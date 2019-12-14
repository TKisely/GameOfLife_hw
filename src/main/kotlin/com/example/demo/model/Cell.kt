package com.example.demo.model

data class Cell(val x:Int, val y:Int, var isAlive:Boolean)

fun Cell.CountNeighbours(board: Board):Int{
    var n=0
    var actNCell:Cell

    //center part, surrounded by cells from every side
    if(this.x!=1&&
            this.x!=board.xCellsNum&&
            this.y!=1&&
            this.y!=board.yCellsNum){

        //Find cell above
        if (
                (board.cells.find { cell -> (cell.x==this.x && cell.y==this.y-1) }?.isAlive)!!
        ){n++}
        //Find cell below
        if (
                (board.cells.find { cell -> (cell.x==this.x && cell.y==this.y+1) }?.isAlive)!!
        ){n++}
        //Find cell right
        if (
                (board.cells.find { cell -> (cell.x==this.x+1 && cell.y==this.y) }?.isAlive)!!
        ){n++}
        //Find cell left
        if (
                (board.cells.find { cell -> (cell.x==this.x-1 && cell.y==this.y) }?.isAlive)!!
        ){n++}

        //Find cell right above
        if (
                (board.cells.find { cell -> (cell.x==this.x+1 && cell.y==this.y-1) }?.isAlive)!!
        ){n++}
        //Find cell left above
        if (
                (board.cells.find { cell -> (cell.x==this.x-1 && cell.y==this.y-1) }?.isAlive)!!
        ){n++}
        //Find cell right below
        if (
                (board.cells.find { cell -> (cell.x==this.x+1 && cell.y==this.y+1) }?.isAlive)!!
        ){n++}
        //Find cell left below
        if (
                (board.cells.find { cell -> (cell.x==this.x-1 && cell.y==this.y+1) }?.isAlive)!!
        ){n++}

        return n
    }

    //left center
    else if (this.x==1&&
            this.y!=1&&
            this.y!=board.yCellsNum){
        //Find cell above
        if (
                (board.cells.find { cell -> (cell.x==this.x && cell.y==this.y-1) }?.isAlive)!!
        ){n++}
        //Find cell right
        if (
                (board.cells.find { cell -> (cell.x==this.x+1 && cell.y==this.y) }?.isAlive)!!
        ){n++}
        //Find cell below
        if (
                (board.cells.find { cell -> (cell.x==this.x && cell.y==this.y+1) }?.isAlive)!!
        ){n++}
        //Find cell right above
        if (
                (board.cells.find { cell -> (cell.x==this.x+1 && cell.y==this.y-1) }?.isAlive)!!
        ){n++}
        //Find cell right below
        if (
                (board.cells.find { cell -> (cell.x==this.x+1 && cell.y==this.y+1) }?.isAlive)!!
        ){n++}

        //Find right center neighbours same row
        if (
                (board.cells.find { cell -> (cell.x==board.xCellsNum&& cell.y==this.y) }?.isAlive)!!
        ){n++}
        //Find right center neighbours one row above
        if (
                (board.cells.find { cell -> (cell.x==board.xCellsNum&& cell.y==this.y-1) }?.isAlive)!!
        ){n++}
        //Find right center neighbours one row below
        if (
                (board.cells.find { cell -> (cell.x==board.xCellsNum&& cell.y==this.y+1) }?.isAlive)!!
        ){n++}

        return n

    }
    //top center
    else if (this.y==1&&
            this.x!=board.xCellsNum&&
            this.x!=1){
        //Find cell below
        if (
                (board.cells.find { cell -> (cell.x==this.x && cell.y==this.y+1) }?.isAlive)!!
        ){n++}
        //Find cell right
        if (
                (board.cells.find { cell -> (cell.x==this.x+1 && cell.y==this.y) }?.isAlive)!!
        ){n++}
        //Find cell left
        if (
                (board.cells.find { cell -> (cell.x==this.x-1 && cell.y==this.y) }?.isAlive)!!
        ){n++}
        //Find cell left below
        if (
                (board.cells.find { cell -> (cell.x==this.x-1 && cell.y==this.y+1) }?.isAlive)!!
        ){n++}
        //Find cell right below
        if (
                (board.cells.find { cell -> (cell.x==this.x+1 && cell.y==this.y+1) }?.isAlive)!!
        ){n++}
        //Find bottom center same column
        if (
                (board.cells.find { cell -> (cell.x==this.x && cell.y==board.yCellsNum) }?.isAlive)!!
        ){n++}
        //Find bottom center one column left
        if (
                (board.cells.find { cell -> (cell.x==this.x-1 && cell.y==board.yCellsNum) }?.isAlive)!!
        ){n++}
        //Find bottom center one column right
        if (
                (board.cells.find { cell -> (cell.x==this.x+1 && cell.y==board.yCellsNum) }?.isAlive)!!
        ){n++}

        return n
    }
    //right center
    else if (this.x==board.xCellsNum&&
            this.y!=1&&
            this.y!=board.yCellsNum){
        //Find cell above
        if (
                (board.cells.find { cell -> (cell.x==this.x && cell.y==this.y-1) }?.isAlive)!!
        ){n++}
        //Find cell below
        if (
                (board.cells.find { cell -> (cell.x==this.x && cell.y==this.y+1) }?.isAlive)!!
        ){n++}
        //Find cell left
        if (
                (board.cells.find { cell -> (cell.x==this.x-1 && cell.y==this.y) }?.isAlive)!!
        ){n++}
        //Find cell left below
        if (
                (board.cells.find { cell -> (cell.x==this.x-1 && cell.y==this.y+1) }?.isAlive)!!
        ){n++}
        //Find cell left above
        if (
                (board.cells.find { cell -> (cell.x==this.x-1 && cell.y==this.y-1) }?.isAlive)!!
        ){n++}
        //Find left center same row
        if (
                (board.cells.find { cell -> (cell.x==1 && cell.y==this.y) }?.isAlive)!!
        ){n++}
        //Find left center one row above
        if (
                (board.cells.find { cell -> (cell.x==1 && cell.y==this.y-1) }?.isAlive)!!
        ){n++}
        //Find left center one row below
        if (
                (board.cells.find { cell -> (cell.x==1 && cell.y==this.y+1) }?.isAlive)!!
        ){n++}

        return n
    }
    //bottom center
    else if (this.y==board.yCellsNum&&this.x!=1&&this.x!=board.xCellsNum) {
        //Find cell above
        if (
                (board.cells.find { cell -> (cell.x==this.x && cell.y==this.y-1) }?.isAlive)!!
        ){n++}
        //Find cell right
        if (
                (board.cells.find { cell -> (cell.x==this.x+1 && cell.y==this.y) }?.isAlive)!!
        ){n++}
        //Find cell left
        if (
                (board.cells.find { cell -> (cell.x==this.x-1 && cell.y==this.y) }?.isAlive)!!
        ){n++}
        //Find cell left above
        if (
                (board.cells.find { cell -> (cell.x==this.x-1 && cell.y==this.y-1) }?.isAlive)!!
        ){n++}
        //Find cell right above
        if (
                (board.cells.find { cell -> (cell.x==this.x+1 && cell.y==this.y-1) }?.isAlive)!!
        ){n++}
        //Find top center same column
        if (
                (board.cells.find { cell -> (cell.x==this.x && cell.y==1) }?.isAlive)!!
        ){n++}
        //Find top center one column left
        if (
                (board.cells.find { cell -> (cell.x==this.x-1 && cell.y==1) }?.isAlive)!!
        ){n++}
        //Find top center one column right
        if (
                (board.cells.find { cell -> (cell.x==this.x+1 && cell.y==1) }?.isAlive)!!
        ){n++}

        return n
    }
    //top left corner
    else if (this.x==1&&this.y==1){
        //Find cell below
        if (
                (board.cells.find { cell -> (cell.x==this.x && cell.y==this.y+1) }?.isAlive)!!
        ){n++}
        //Find cell right
        if (
                (board.cells.find { cell -> (cell.x==this.x+1 && cell.y==this.y) }?.isAlive)!!
        ){n++}
        //Find cell right below
        if (
                (board.cells.find { cell -> (cell.x==this.x+1 && cell.y==this.y+1) }?.isAlive)!!
        ){n++}

        //Find top right corner - same row, last column
        if (
                (board.cells.find { cell -> (cell.x==board.xCellsNum && cell.y==1) }?.isAlive)!!
        ){n++}
        //Find bottom left corner - last row, same column
        if (
                (board.cells.find { cell -> (cell.x==1 && cell.y==board.yCellsNum) }?.isAlive)!!
        ){n++}
        //Find bottom right corner - last row, last column
        if (
                (board.cells.find { cell -> (cell.x==board.xCellsNum && cell.y==board.yCellsNum) }?.isAlive)!!
        ){n++}
        //Find left down inf - one row down, last column
        if (
                (board.cells.find { cell -> (cell.x==board.xCellsNum && cell.y==this.y+1) }?.isAlive)!!
        ){n++}
        //Find right up inf - last row, one column right
        if (
                (board.cells.find { cell -> (cell.x==this.x+1 && cell.y==board.yCellsNum) }?.isAlive)!!
        ){n++}

        return n
    }

    //top right corner
    else if (this.x==board.xCellsNum&&this.y==1){
        //Find cell left
        if (
                (board.cells.find { cell -> (cell.x==this.x-1 && cell.y==this.y) }?.isAlive)!!
        ){n++}
        //Find cell below
        if (
                (board.cells.find { cell -> (cell.x==this.x && cell.y==this.y+1) }?.isAlive)!!
        ){n++}
        //Find cell left below
        if (
                (board.cells.find { cell -> (cell.x==this.x-1 && cell.y==this.y+1) }?.isAlive)!!
        ){n++}

        //Find top left corner
        if (
                (board.cells.find { cell -> (cell.x==1 && cell.y==this.y) }?.isAlive)!!
        ){n++}
        //Find bottom right corner
        if (
                (board.cells.find { cell -> (cell.x==this.x && cell.y==board.yCellsNum) }?.isAlive)!!
        ){n++}
        //Find bottom left corner
        if (
                (board.cells.find { cell -> (cell.x==1 && cell.y==board.yCellsNum) }?.isAlive)!!
        ){n++}
        //Find one row below && first column
        if (
                (board.cells.find { cell -> (cell.x==1 && cell.y==this.y+1) }?.isAlive)!!
        ){n++}
        //Find one column left && last row
        if (
                (board.cells.find { cell -> (cell.x==this.x-1 && cell.y==board.yCellsNum) }?.isAlive)!!
        ){n++}

        return n
    }
    //bottom right corner
    else if(this.x==board.xCellsNum&&this.y==board.yCellsNum){
        //Find cell left
        if (
                (board.cells.find { cell -> (cell.x==this.x-1 && cell.y==this.y) }?.isAlive)!!
        ){n++}
        //Find cell above
        if (
                (board.cells.find { cell -> (cell.x==this.x && cell.y==this.y-1) }?.isAlive)!!
        ){n++}
        //Find cell left above
        if (
                (board.cells.find { cell -> (cell.x==this.x-1 && cell.y==this.y-1) }?.isAlive)!!
        ){n++}

        //Find top left corner
        if (
                (board.cells.find { cell -> (cell.x==1 && cell.y==1) }?.isAlive)!!
        ){n++}
        //Find top right corner
        if (
                (board.cells.find { cell -> (cell.x==board.xCellsNum && cell.y==1) }?.isAlive)!!
        ){n++}
        //Find bottom left corner
        if (
                (board.cells.find { cell -> (cell.x==1 && cell.y==board.yCellsNum) }?.isAlive)!!
        ){n++}
        //Find one row above && first column
        if (
                (board.cells.find { cell -> (cell.x==1 && cell.y==this.y-1) }?.isAlive)!!
        ){n++}
        //Find one column left && first row
        if (
                (board.cells.find { cell -> (cell.x==this.x-1 && cell.y==1) }?.isAlive)!!
        ){n++}

        return n
    }
    //bottom left corner
    else if(this.x==1&&this.y==board.yCellsNum){
        //Find cell right
        if (
                (board.cells.find { cell -> (cell.x==this.x+1 && cell.y==this.y) }?.isAlive)!!
        ){n++}
        //Find cell above
        if (
                (board.cells.find { cell -> (cell.x==this.x && cell.y==this.y-1) }?.isAlive)!!
        ){n++}
        //Find cell right above
        if (
                (board.cells.find { cell -> (cell.x==this.x+1 && cell.y==this.y-1) }?.isAlive)!!
        ){n++}

        //Find top left corner
        if (
                (board.cells.find { cell -> (cell.x==1 && cell.y==1) }?.isAlive)!!
        ){n++}
        //Find top right corner
        if (
                (board.cells.find { cell -> (cell.x==board.xCellsNum && cell.y==1) }?.isAlive)!!
        ){n++}
        //Find bottom right corner
        if (
                (board.cells.find { cell -> (cell.x==board.xCellsNum && cell.y==board.yCellsNum) }?.isAlive)!!
        ){n++}
        //Find last column && one row above
        if (
                (board.cells.find { cell -> (cell.x==board.xCellsNum && cell.y==this.y-1) }?.isAlive)!!
        ){n++}
        //Find one column right && first row
        if (
                (board.cells.find { cell -> (cell.x==this.x+1 && cell.y==1) }?.isAlive)!!
        ){n++}

        return n
    }

    //Not known option
    else{
        return -1

    }
}

fun Cell.convertPixelToCellposition(pixel:Int, cellSize:Int):Int{
    return (pixel/cellSize).toInt()
}