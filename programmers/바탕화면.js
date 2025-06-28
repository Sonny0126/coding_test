function solution(wallpaper) {
  let top = Infinity,
    left = Infinity;
  let bottom = -Infinity,
    right = -Infinity;

  for (let i = 0; i < wallpaper.length; i++) {
    const row = wallpaper[i];
    if (row.includes("#")) {
      const leftFile = row.indexOf("#");
      const rightFile = row.lastIndexOf("#");

      top = Math.min(top, i);
      bottom = Math.max(bottom, i + 1);
      left = Math.min(left, leftFile);
      right = Math.max(right, rightFile + 1);
    }
  }

  return [top, left, bottom, right];
}
