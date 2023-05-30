#lang racket

(provide bst)
(provide nl-to-all)
(provide insert)
(provide delete)
(provide insert-from-list)
(provide traverse)
(provide random-list)
(provide find)
(provide nl-to-vl)
(provide delete-from-list)

;----------------------------------
; Struct definitions
;----------------------------------
(struct node(value count left right) #:mutable #:transparent)
(struct bst (root) #:mutable #:transparent)
;_________________________________________________________________________________________________________

;----------------------------------
; Traverse
; t: bst
; value: list of nodes
; Helper function (traverse-node n) n: node
;----------------------------------
(define (traverse t)
  (traverse-node (bst-root t))) ;recursive call

;----------------------------------
; Traverse Node
; n: node
; Description: uses only node reference to travel through out the whole tree
;----------------------------------
(define (traverse-node n)
  (cond
    ((empty? n) null)
    (else (append (traverse-node (node-left n)) (list n) (traverse-node (node-right n))))))
;_________________________________________________________________________________________________________

;----------------------------------
; nl-to-vl
; x: list of nodes obtained from traverse function
; Value; returns a list of values
;----------------------------------
(define (nl-to-vl x)
  (cond
    ((empty? x) '()) ;if tree is empty
    ((empty? (cdr x)) (list (node-value (car x)))) ;if there is only the root
    (else (cons (node-value (car x)) (nl-to-vl (cdr x)))))) ; for the rest of the cases
;_________________________________________________________________________________________________________

;----------------------------------
; Find
; t: bst
; v: integer
; Description: top level function, creates list of nodes in bst t from root to insertion point for value v
;----------------------------------
(define (find t v)
  (cond
    ((empty? (bst-root t)) null)
    (else (find-node (bst-root t) v)))) ;calls helper function

;----------------------------------
; Find-node
; n: node
; v: integer
; Helper function that handles non special cases
;----------------------------------
(define (find-node n v) 
  (cond
    ((empty? n) '())
    ((= v (node-value n)) (list n)) ;if v = the value of the node
    ((and (< v (node-value n)) ;if v is less than value of node & the nodes left child is empty
          (empty? (node-left n))) (list n))
    ((and (< v (node-value n)) ;if v is less than value of node & the nodes left child is not empty
          (not (empty? (node-left n))))
     (append (find-node (node-left n) v) (list n)))
    ((and (> v (node-value n)) ;if v is greater than value of node & the node's right child is empty
          (empty? (node-right n))) (list n))
    ((and (> v (node-value n)) ;if v is greater than value of node & the node's right child is not empty
          (not (empty? (node-right n))))
     (append (find-node (node-right n) v) (list n)))))
;_________________________________________________________________________________________________________

;----------------------------------
; Random value
; r: integer to scale the number
; Description: generates an integer value on the range 0 through r-1
;----------------------------------
(define (random-value r)
  (inexact->exact (floor (*(random r)))))

;----------------------------------
; Random list
; n: number of items in the list
; r: integer to scale the number
; Description: generates a list of n random numbers
;----------------------------------
(define (random-list n r)
  (cond
    ((= n 1) (list (random-value r)))
    (else (cons (random-value r) (random-list (- n 1) r)))))
;_________________________________________________________________________________________________________

;----------------------------------
; Insert
; t: bst
; v: integer
; Description: adds a new value to existing bst
(define (insert t v)
  (cond
    ((empty? (bst-root t)) ;if empty, sets the root to the value to be inserted
     (set-bst-root! t(node v 1 null null)))
     (else (insert-node v (find t v))))) ;calls helper function if not empty

;----------------------------------
; Insert node
; v: integer
; path: list of nodes to insertion point
; Description: handles everything where it does not involve the root changing
;----------------------------------
(define (insert-node v path)
  (cond
    ((= v (node-value (car path))) ;if v = node value of car path
     (set-node-count!(car path) (+ 1 (node-count (car path)))))
    ((< v (node-value (car path))) ;if v < node value car path
     (set-node-left! (car path) (node v 1 null null)))
    ((> v (node-value (car path))) ;if v > node value car path
     (set-node-right! (car path) (node v 1 null null)))))

;----------------------------------
; Insert from list
; t: empty bst
; y: list of random numbers
; Description: automatically inserts list of of numbers into an empty bst
;----------------------------------
(define (insert-from-list t y)
  (map (lambda (x) (insert t x) (displayln (nl-to-vl (traverse t)))) y) (void))
;_________________________________________________________________________________________________________

;----------------------------------
; Child count
; n: node
; Description: calculates the number of child nodes n has (0,1,2)
;----------------------------------
(define (child-count n)
  (cond
    ((and (empty? (node-left n))
         (empty? (node-right n))) 0) ;no children
    ((and (not (empty? (node-left n)))
         (not (empty? (node-right n)))) 2) ;2 children
    (else 1))) ;1 child

;----------------------------------
; Get child node values
; n: node
; Description: creates a list of the values of the child nodes of n, if child is null, "X" is used
;----------------------------------
(define (get-child-node-values n)
  (cond
    ((and (empty? (node-left n))
          (empty? (node-right n))) ;both are empty
     (list 'X'X))
    ((and (empty? (node-left n)) ;left is empty, right is not empty
          (not(empty? (node-right n))))
     (list 'X (node-value (node-right n)))) ;left is not empty, right is empty
    ((and(not(empty? (node-left n)))
         (empty? (node-right n)))
     (list (node-value (node-left n)) 'X))
    (else(list (node-value(node-left n))(node-value(node-right n)))))) ;neither are empty
;_________________________________________________________________________________________________________

;----------------------------------
; Delete
; t: bst
; v: integer to be deleted
; Top level function
; Description: calls find to get the path from root to node n
;----------------------------------
(define (delete t v)
  (let ((path (find t v)))
    (cond
      ((empty? t)) ;tree is empty
      ((empty? (bst-root t))) ;root is empty
      ((not(= v (node-value (car path))))) ;v doesnt = the node value of car path
      ((> (node-count (car path)) 1) ;node to be deleted has a count greater than one
       (set-node-count! (- 1 (node-count (car path)))))
      ((equal? (car path)(bst-root t))
       (cond
         ((and (empty? (node-left (car path)))
              (empty? (node-right (car path)))) ;node to be deleted doesnt have children
          (set-bst-root! t null))
         ((and (empty? (node-left (car path)))
               (not (empty? (node-right (car path))))) ;node to be deleted has a right child
          (set-bst-root! t (node-right (car path))))
         ((and (not (empty? (node-left (car path))))
               (empty? (node-right (car path)))) ;node to be deleted has a left childd
          (set-bst-root! t (node-left (car path))))
         (else (delete-node path))))
      (else (delete-node path)))))

;----------------------------------
; Delete node
; path: list of nodes to deletion point
; Description: based on how many children the node that is to be delted has, it procedes to correct deletion function
;----------------------------------
(define (delete-node path)
  (let ((n (car path)))
    (cond
      (( = 0 (child-count n))(delete-node-0 path))
      (( = 1 (child-count n))(delete-node-1 path))
      (else (delete-node-2 path)))))

;----------------------------------
; Delete node 0
; path: list of nodes to deletion point
; Description: if the node has no children, provides deletion method
;----------------------------------
(define (delete-node-0 path)
  (cond
    ((empty? (cdr path)) null);0.1
    ((equal? (node-left (cadr path)) (car path))
     (set-node-left! (cadr path) null));0.2
    (else (set-node-right! (cadr path) null)))) ;0.3

;----------------------------------
; Delete node 1
; path: list of nodes to deletion point
; Description: if the node has 1 child node
;----------------------------------
(define (delete-node-1 path)
  (let ((n (car path))(p(cadr path)))
  (cond
     ((and (empty? (cdr path))
           (not (empty? (node-left n)))) (node-left n));1.1
     ((and (empty? (cdr path))
           (not (empty? (node-right n))))
      (node-right n));1.2
     ((and (equal? (node-left p) n)
           (not (empty? (node-left n))))
      (set-node-left! p (node-left n)));1.3
     ((and (equal? (node-left p) n)
           (not (empty? (node-right n))))
      (set-node-left! p (node-right n)));1.4
     ((and (equal? (node-right p) n)
           (not (empty? (node-left n))))
      (set-node-right! p (node-left n)));1.5
     ((and (equal? (node-right p) n)
           (not (empty? (node-right n))))
      (set-node-right! p (node-right n)))))) ;1.6

;----------------------------------
; Delete node 2
; path: list from node to deletion point
; Description: if node has two children
;----------------------------------
(define (delete-node-2 path)
 (let ((ioppath (get-iop-path (car path))))
  (cond
    ((and (equal? (node-left (cadr ioppath)) (car ioppath))
          (empty? (node-right (car ioppath))))
     (set-node-value! (car path)(node-value (car ioppath)))
     (set-node-count! (car path)(node-count (car ioppath)))
     (set-node-left! (cadr ioppath)(node-left (car ioppath))));2.1
    ((and (equal? (node-right (cadr ioppath)) (car ioppath))
          (empty? (node-right (car ioppath)))
     (set-node-value! (car path)(node-value (car ioppath)))
     (set-node-count! (car path)(node-count (car ioppath)))
     (set-node-right! (cadr ioppath)(node-left (car ioppath)))))))) ;2.2

;----------------------------------
; Delete from list
; t: bst
; y: list of numbers to be deleted from tree
; Description: deletes all nodes from the bst
;----------------------------------
(define (delete-from-list t y)
(map (lambda (x) (delete t x) (displayln (nl-to-vl (traverse t)))) y) (void))
;_________________________________________________________________________________________________________

;----------------------------------
; Get node fields
; n: node
; Description: creates a list of all field values for node n
;----------------------------------
(define (get-node-fields n)
 (cond
 ((empty? n) "X")
 (else (append (list (node-value n) (node-count n)) (get-child-node-values n)))))

;----------------------------------
; nl to all
; x: list of nodes
; Description: converts a list of nodes into a more detailed list of (value, count, left, right)
;----------------------------------
(define (nl-to-all x)
(cond
 ((empty? x) (list 'X))
 (else (append (list (get-node-fields (car x))) (nl-to-all (cdr x))))))
;_________________________________________________________________________________________________________

;----------------------------------
; Get IOP path right
; path: list of nodes who have right child
; Description: calls itself recursively to add the right child of the most recent node to the head of the list
;              until it reaches a node with no head
;----------------------------------
(define (get-iop-path-right path)
  (cond
    ((empty? (node-right path)) (list path))
    (else (append (get-iop-path-right (node-right path))(list path)))))

;----------------------------------
; Get IOP path
; n: node from which we need to find its IOP
; Description: adds the first two nodes to the path, calls helper function
;----------------------------------
(define (get-iop-path n)
  (cond
    ((empty? (node-right (node-left n))) (list (node-left n) n))
    (else (append (get-iop-path-right (node-left n))(list n)))))
;_________________________________________________________________________________________________________
