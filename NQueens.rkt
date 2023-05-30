#lang racket
;------------------------------------------------------------------------------
;no conlfict
;top level function
;int v (row value)
;list p
;checks if there is any conflicts with a new row value and any entries in list p
(define (nc v p)
  (nc-h v p 1))
;-----------------------------------------
;no conflict helper
;int v (row value), int d (distance
;list p
;confirms n conflicts between v and all elements of p
(define (nc-h v p d)
  (cond
   ((empty? p) #t) ;base case
   (else (and (nc-1 v (car p) d)
              (nc-h v (cdr p) (+ d 1))))))
;-----------------------------------------
;no confilct 1
;int a(row value), int b(row value), int d(distance)
;checks column distance between row values a and b by their distance d
(define (nc-1 a b d)
  (and (not (= a b)) ;row conflict
       (not (= d (abs (- a b)))))) ;diagonal conflict

;------------------------------------------------------------------------------
;solve
;top level function
;int n(how many columns/rows
;calls helper function with set parameters
(define (solve n)
  (solve-h n 1 '(0) '(0 1) '()))

;-----------------------------------------
;solve helper
;int n (number of columns/rows)
;int c (current column index
;list qp (partial solution of queen positions)
;list nr (next row list that shows the next row to try)
;list sv (a solution vector, list of lists)
(define (solve-h n c qp nr sv)
  (cond
    ((and (= (car nr) n)
     (empty? qp)) sv)
    ((and (= (car nr) n)
          (not (empty? qp))) (solve-h n (- c 1) (cdr qp) (cdr nr) sv))
    ((nc (car nr) qp) (solve-h n (+ c 1) (cons (car nr) qp) (cons 0 (cons (+ 1 (car nr)) (cdr nr))) sv))
    ((= c n) (solve-h n (- c 1) (cdr qp) (cdr nr) (cons qp sv)))
    (else
     (solve-h n c qp (cons (+ 1 (car nr)) (cdr nr)) sv))))

;-----------------------------------------
(define sv (write (solve 8)))
    
    