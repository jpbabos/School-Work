#lang racket
(require "BST.rkt")
;-----------------------------------
; Test case functions
;-----------------------------------
(define bst-1 (bst null))
; --- delete cases that change root
; --- delete case 0.1
(displayln "") (displayln "delete case 0.1")
(set! bst-1 (bst null))
(insert-from-list bst-1 '(50))
(nl-to-all (traverse bst-1)) ; ((50 1 X X) X) (50 is root)
(delete bst-1 50)
(nl-to-all (traverse bst-1)) ; (X) (root is null)
; --- delete case 1.1
(displayln "") (displayln "delete case 1.1")
(set! bst-1 (bst null))
(insert-from-list bst-1 '(50 25))
(nl-to-all (traverse bst-1)) ; ((25 1 X X) (50 1 25 X) X) (50 is root)
(delete bst-1 50)
(nl-to-all (traverse bst-1)) ; ((25 1 X X) X) (25 is root)
; --- delete case 1.2
(displayln "") (displayln "delete case 1.2")
(set! bst-1 (bst null))
(insert-from-list bst-1 '(50 75))
(nl-to-all (traverse bst-1)) ; ((25 1 X X) (50 1 25 X) X) (50 is root)
(delete bst-1 50)
(nl-to-all (traverse bst-1)) ; ((25 1 X X) X) (25 is root)
; --- delete cases that don't change root
; --- delete case 0.2
(displayln "") (displayln "delete case 0.2")
(set! bst-1 (bst null))
(insert-from-list bst-1 '(50 25))
(nl-to-all (traverse bst-1)) ; ((25 1 X X) (50 1 25 X) X) (50 is root)
(delete bst-1 25)
(nl-to-all (traverse bst-1)) ; ((25 1 X X) X) (25 is root)
; --- delete case 0.3
(displayln "") (displayln "delete case 0.3")
(set! bst-1 (bst null))
(insert-from-list bst-1 '(50 75))
(nl-to-all (traverse bst-1)) ; ((25 1 X X) (50 1 25 X) X) (50 is root)
(delete bst-1 75)
(nl-to-all (traverse bst-1)) ; ((25 1 X X) X) (25 is root)
; --- delete case 1.3
(displayln "") (displayln "delete case 1.3")
(set! bst-1 (bst null))
(insert-from-list bst-1 '(50 25 12))
(nl-to-all (traverse bst-1)) ; ((25 1 X X) (50 1 25 X) X) (50 is root)
(delete bst-1 25)
(nl-to-all (traverse bst-1)) ; ((25 1 X X) X) (25 is root)
; --- delete case 1.4
(displayln "") (displayln "delete case 1.4")
(set! bst-1 (bst null))
(insert-from-list bst-1 '(50 25 35))
(nl-to-all (traverse bst-1)) ; ((25 1 X X) (50 1 25 X) X) (50 is root)
(delete bst-1 25)
(nl-to-all (traverse bst-1)) ; ((25 1 X X) X) (25 is root)
; --- delete case 1.5
(displayln "") (displayln "delete case 1.5")
(set! bst-1 (bst null))
(insert-from-list bst-1 '(50 75 60))
(nl-to-all (traverse bst-1)) ; ((25 1 X X) (50 1 25 X) X) (50 is root)
(delete bst-1 75)
(nl-to-all (traverse bst-1)) ; ((25 1 X X) X) (25 is root)
; --- delete case 1.6
(displayln "") (displayln "delete case 1.6")
(set! bst-1 (bst null))
(insert-from-list bst-1 '(50 75 85))
(nl-to-all (traverse bst-1)) ; ((25 1 X X) (50 1 25 X) X) (50 is root)
(delete bst-1 75)
(nl-to-all (traverse bst-1)) ; ((25 1 X X) X) (25 is root)
; --- delete case 2.1 #1
(displayln "") (displayln "delete case 2.1 #1")
(set! bst-1 (bst null))
(insert-from-list bst-1 '(50 25 75 12 30))
(nl-to-all (traverse bst-1)) ; ((25 1 X X) (50 1 25 X) X) (50 is root)
(delete bst-1 25)
(nl-to-all (traverse bst-1)) ; ((25 1 X X) X) (25 is root)
; --- delete case 2.1 #2
(displayln "") (displayln "delete case 2.1 #2")
(set! bst-1 (bst null))
(insert-from-list bst-1 '(50 25 75 12 30 10))
(nl-to-all (traverse bst-1)) ; ((25 1 X X) (50 1 25 X) X) (50 is root)
(delete bst-1 25)
(nl-to-all (traverse bst-1)) ; ((25 1 X X) X) (25 is root)
; --- delete case 2.2
(displayln "") (displayln "delete case 2.2")
(set! bst-1 (bst null))
(insert-from-list bst-1 '(50 25 75 12 30 10 13 14))
(nl-to-all (traverse bst-1)) ; ((25 1 X X) (50 1 25 X) X) (50 is root)
(delete bst-1 25)
(nl-to-all (traverse bst-1))

(define bst-2 (bst null)) ; initially empty bst
(define list-2 (random-list 10 1000)) ; list of 10 random numbers
(displayln list-2)
(insert-from-list bst-2 list-2) ; insert numbers from list into bst
(nl-to-vl (traverse bst-2)) ; snapshot of tree
(delete-from-list bst-2 list-2) ; delete numbers from list from bst
(nl-to-vl (traverse bst-2))