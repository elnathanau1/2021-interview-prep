// https://leetcode.com/problems/robot-bounded-in-circle/

class Solution {
    public boolean isRobotBounded(String instructions) {
        Direction dir = Direction.NORTH;
        int x = 0;
        int y = 0;
        for (char c : instructions.toCharArray()) {
            if (c == 'L' || c == 'R') dir = nextDirection(dir, c);
            else {
                switch(dir) {
                    case NORTH: y++; break;
                    case WEST: x--; break;
                    case SOUTH: y--; break;
                    case EAST: x++; break;
                }
            }
        }
            
        return (dir != Direction.NORTH) || (x == 0 && y == 0);
    }
    
    private Direction nextDirection (Direction current, char change) {
        if (change == 'L') {
            switch(current) {
                case NORTH: return Direction.WEST;
                case WEST: return Direction.SOUTH;
                case SOUTH: return Direction.EAST;
                case EAST: return Direction.NORTH;
                default: return null;
            }
        }
        else {
            switch(current) {
                case NORTH: return Direction.EAST;
                case WEST: return Direction.NORTH;
                case SOUTH: return Direction.WEST;
                case EAST: return Direction.SOUTH;
                default: return null;
            }
        }
    }
}


enum Direction {
    NORTH,
    SOUTH,
    EAST,
    WEST
}
