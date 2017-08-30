/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.mikecroft.demo.WorkDistributor;

/**
 *
 * @author Mike Croft
 */
public class Work {

    int counter = 0;

    public void doWork(WorkRequest req) {
        switch (req) {
            case BUSYWORK:
                break;
            case TARTAN_PAINT:
                mixTartanPaint();
                break;
            case LONG_STAND:
                fetchLongStand();
            default:
                lookBusy();
                break;

        }

    }

    private void mixTartanPaint() {
        lookBusy();
    }

    private void lookBusy() {
        // Scroll all the way to the right on Excel or something
        for (int i = 0; i < Short.MAX_VALUE; i++) {
            if (i % 2 == 0) {
                counter++;
            }
        }
    }

    private void fetchLongStand() {
        lookBusy();
    }

}
