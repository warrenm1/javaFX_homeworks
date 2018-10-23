final Group  ticks = new Group();

        for (int i = 0; i < 12; i++) {

        Line tick = new Line(0, -TICK_START_OFFSET, 0, -TICK_END_OFFSET);

        tick.getStyleClass().add("tick");

        tick.setLayoutX(clockRadius);

        tick.setLayoutY(clockRadius);

        tick.getTransforms().add(new Rotate(i * (360 / 12)));

        ticks.getChildren().add(tick);

        }

        return ticks;