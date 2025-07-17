package coordinate;

import java.util.List;
import java.util.Map;

public class FigureFactory implements FigureCreator {

    private Map<Integer, Class<? extends Figure>> figureMap = Map.of(
            Line.LINE_POINT_SIZE, Line.class,
            Triangle.TRIANGLE_POINT_SIZE, Triangle.class,
            Rectangle.RECTANGLE_POINT_SIZE, Rectangle.class
    );

    private FigureFactory() {}

    private static class Holder {
        private static final FigureFactory INSTANCE = new FigureFactory();
    }

    public static Figure getInstance(List<Point> points) {
        return Holder.INSTANCE.create(points);
    }

    @Override
    public Figure create(List<Point> points) {
        Class<? extends Figure> figureClass = figureMap.get(points.size());
        try {
            return figureClass.getConstructor(List.class).newInstance(points);
        } catch (Exception e) {
            throw new IllegalArgumentException("도형 생성 중 오류가 발생했습니다.", e);
        }
    }
}
