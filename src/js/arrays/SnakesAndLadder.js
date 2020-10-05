/**
 *
 *  On an N x N board, the numbers from 1 to N*N are written boustrophedonically starting from the bottom
 *  left of the board, and alternating direction each row.
 *
 * You start on square 1 of the board (which is always in the last row and first column). Each move,
 * starting from square x, consists of the following:
 *
 * You choose a destination square S with number x+1, x+2, x+3, x+4, x+5, or x+6, provided this number is <= N*N.
 * (This choice simulates the result of a standard 6-sided die roll: ie., there are always at most 6 destinations,
 * regardless of the size of the board.)
 *
 * If S has a snake or ladder, you move to the destination of that snake or ladder.  Otherwise, you move to S.
 * A board square on row r and column c has a "snake or ladder" if board[r][c] != -1.  The destination of
 * that snake or ladder is board[r][c].
 *
 * Note that you only take a snake or ladder at most once per move: if the destination to a snake or ladder is the
 * start of another snake or ladder, you do not continue moving.  (For example, if the board is `[[4,-1],[-1,3]]`,
 * and on the first move your destination square is `2`, then you finish your first move at `3`, because you do not
 * continue moving to `4`.)
 *
 * Return the least number of moves required to reach square N*N.  If it is not possible, return -1.

 * Source: https://leetcode.com/problems/snakes-and-ladders/
 *
 * Tag: #Google
 *
 */


function snakesAndLadders(board) {
  const size = board.length;

  /* Given a square num s, return board coordinates (r, c) as r*N + c */
  const get = (curr) => {
    let quo = (curr - 1) / size,
        rem = (curr - 1) % size,
        row = size - 1 - quo,
        col = row % 2 !== size % 2 ? rem : size - 1 - rem;
    return row * size + col;
  }

  const distance = { 1: 0 };
  const queue = [0];

  while(queue.length > 0) {
    let source = queue.pop();

    if (source === (size * size)) return distance[source];

    for (let curr = source + 1; curr <= Math.min(source+6, size * size); ++curr) {
      let rc = get(curr);
      let row = parseInt(rc / size),
          col = parseInt(rc % size);

      let dest = board[row][col] === -1 ? curr : board[row][col];

      if (!distance.hasOwnProperty(dest)) {
        distance[dest] = distance[source] + 1;
        queue.push(dest);
      }
    }
  }

  return -1;
}


console.log(snakesAndLadders([[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,35,-1,-1,13,-1],[-1,-1,-1,-1,-1,-1],[-1,15,-1,-1,-1,-1]]));
