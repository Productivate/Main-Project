package com.example.benjamin.graphinput;

import android.content.Context;
import android.graphics.*;
import android.view.MotionEvent;
import android.view.View;

/**
 * Graph input mechanism test
 */

public class GraphView extends View {

    private Point graphPosition = new Point();
    private Point[] rawHandlePositions = new Point[7];
    private final float handleSizeDivider = 40;
    private boolean startup = true;
    private int selectedHandle;
    private boolean handleInMotion = false;

    private final Paint backgroundColor = new Paint();
    private final Paint handleColors = new Paint();
    private final Paint lineColors = new Paint();
    private final Paint textColor = new Paint();

    private RectF background = new RectF();
    private char[] dayLabelsText = {'S', 'M', 'T', 'W', 'T', 'F', 'S'};

    public GraphView(Context context) {

        super(context);

        handleColors.setColor(Color.argb(150, 255, 255, 255));
        lineColors.setColor(Color.argb(150, 255, 255, 255));
        lineColors.setStyle(Paint.Style.FILL_AND_STROKE);
        lineColors.setStrokeWidth(6);

        textColor.setColor(Color.argb(170, 255, 255, 255));
        textColor.setTextAlign(Paint.Align.CENTER);
        textColor.setFakeBoldText(true);

        for(int i = 0; i < 7; i++) {
            rawHandlePositions[i] = new Point();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {

        textColor.setTextSize(canvas.getWidth()*0.9f/handleSizeDivider*2);

        background.set(graphPosition.x, graphPosition.y, (int)(canvas.getWidth()*0.9), (int)(canvas.getWidth()*0.556 + canvas.getWidth()*0.9/handleSizeDivider + textColor.getTextSize()));
        backgroundColor.setShader(new LinearGradient(0, background.top, 0, background.bottom, Color.rgb(255, 187, 69), Color.rgb(255, 166, 13), Shader.TileMode.MIRROR));
        canvas.drawRoundRect(background, background.height()*0.03f, background.height()*0.03f, backgroundColor);

        for(int i = 0; i < 7; i++) {
            if(startup) {
                rawHandlePositions[i].x = (int)(background.left + background.width() / 8 * (i+1));
                rawHandlePositions[i].y = (int)(background.bottom - background.width() / handleSizeDivider * 2 - textColor.getTextSize());
            }
            canvas.drawCircle(rawHandlePositions[i].x, rawHandlePositions[i].y, background.width()/handleSizeDivider, handleColors);
        }

        for(int i = 0; i < 6; i++) {
            canvas.drawLine(rawHandlePositions[i].x, rawHandlePositions[i].y, rawHandlePositions[i+1].x, rawHandlePositions[i+1].y, lineColors);
        }

        for(int i = 0; i < 7; i++) {
            canvas.drawText(dayLabelsText, i, 1, rawHandlePositions[i].x, background.bottom - background.width()/handleSizeDivider, textColor);
        }

        super.onDraw(canvas);
        startup = false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                for(int i = 0; i < 7; i++) {
                    if(distance(event.getX(), event.getY(), rawHandlePositions[i].x, rawHandlePositions[i].y) <= background.width() / handleSizeDivider) {
                        rawHandlePositions[i].y = clipToRange((int)event.getY(), (int)(background.top + background.width()/handleSizeDivider*2), (int)(background.bottom - background.width() / handleSizeDivider * 2 - textColor.getTextSize()));
                        selectedHandle = i;
                        handleInMotion = true;
                        break;
                    }
                }
                return true;
            case MotionEvent.ACTION_MOVE:
                if(handleInMotion) {
                    rawHandlePositions[selectedHandle].y = clipToRange((int)event.getY(), (int)(background.top + background.width()/handleSizeDivider*2), (int)(background.bottom - background.width() / handleSizeDivider * 2 - textColor.getTextSize()));
                }
                break;
            case MotionEvent.ACTION_UP:
                handleInMotion = false;
                break;
            default:
                return false;
        }

        invalidate();
        return true;
    }

    public Point getPosition() { return graphPosition; }
    public void setPosition(Point position) { graphPosition = position; }

    private int clipToRange(int num, int lowerBound, int upperBound) {

        if(num < lowerBound) num = lowerBound;
        else if(num > upperBound) num = upperBound;
        return num;
    }

    private double distance(double x1, double y1, double x2, double y2) { return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)); }

}
