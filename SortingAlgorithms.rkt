%-------------------------------------------
%Sorting Algorithms 
%-------------------------------------------


%-------------------------------------------
%support predicates rv/2, rl/3, is_sorted/1

%int r (range of of numbers 0 to R-1)
%int v (random number with in the range r)
%produces a random variable within the range 0 to R-1
%-------------------------------------------
rv(R,V):-
	random(Y), 
	V is floor(Y * R).

%-------------------------------------------
%list L (provides a list of one element of a random number)
%-------------------------------------------
rl(1,R,L):-                  %base case
	rv(R,X),
	L = [X].

%-------------------------------------------
%int N (number of desired elements in list L)
%-------------------------------------------
rl(N,R,L):-                  %non recursive way to create list of random numbers 
	length(L,N),
	maplist(rv(R),L).

%-------------------------------------------
%list L 
%takes in a list of numbers and determines if they are in order from least to greatest
%-------------------------------------------
is_sorted([]).              %one item
is_sorted(L):-              %if length of elements is 1
	length(L,LL),
	LL=:=1,
	length(L,1).
is_sorted(L):-              %if length of elements is greater than 1
	length(L,LL),
	LL > 1,
	L=[L1,L2|LT],
	L1=<L2,
	is_sorted([L2|LT]).    %recursive call on tail of L
%-------------------------------------------

%-------------------------------------------
%selection sort predicates: swap/4, min_index/3, selection_sort/2

%list L 
%int a 
%int b
%list m
%takes in a list, swaps the elements in a and b positions
%-------------------------------------------
swap(L,A,B,M):-
	nth0(A,L,AV),
	nth0(B,L,BV),
	nth0(A,L,_,T1),
	nth0(A,T2,BV,T1),
	nth0(B,T2,_,T3),
	nth0(B,M,AV,T3).

%-------------------------------------------
%list L
%int s (starting index)
%int MI (minimum indeex position)
%-------------------------------------------
min_index(L,S,MI):-
	append(L1,L2,L),
	length(L1,S),
	min_list(L2,MV),
	nth0(L2I,L2,MV),
	MI is L2I + S.
%-------------------------------------------
%top level function
%-------------------------------------------
min_index(L,S,MI):-
	length(L,LL),
	SP1 is S+1,
	min_index(L,S,SP1,LL,MI).

%-------------------------------------------
%int cm (current minimum)
%int c (current index)
%int e (ending index)
%-------------------------------------------
min_index(L,CM,C,E,MI):-
	nth0(CM,L,CMV),
	nth0(C,L,CV),
	CMV =< CV,
	CP1 is C+1,
	min_index(L,CM,CP1,E,MI).

%-------------------------------------------
min_index(L,CM,C,E,MI):-
	nth0(CM,L,CMV),
	nth0(C,L,CV),
	CMV > CV,
	CP1 is C+1,
	min_index(L,C,CP1,E,MI).

%-------------------------------------------
min_index(_,CM,E,E,CM).

%-------------------------------------------
selection_sort([X],[X]).

%-------------------------------------------
%top level
%list L (unsorted list)
%list M (sorted list)
%sorts list
%-------------------------------------------
selection_sort(L, M):-
	length(L,LL),
	LL > 1,
	LLMI is LL-1,
	selection_sort(L,0,LLMI,M).

%-------------------------------------------
%int s (starting index)
%int E (ending index)
%-------------------------------------------
selection_sort(L,S,E,M):-
	S < E, 
	min_index(L,S,MI),
	swap(L,S,MI,L1),
	SP1 is S+1,
	selection_sort(L1,SP1,E,M).

%-------------------------------------------
selection_sort(L,E,E,L).

%-------------------------------------------
sort_test(A,N,R,X):-
	rl(N,R,L),
	writeln(L),
	call(A,L,X),
	is_sorted(X),
	writeln(X).
%-------------------------------------------


%Merge Sort Predicates: split/3, merge/3, merge_sort/2
%-------------------------------------------
split([],[],[]).

split([X],[X],[]).

split([X,Y|T],[X|Xs], [Y|Ys]):-
	split(T, Xs, Ys).

merge([],L,L).

merge(L,[],L).

merge([L1|T1], [L2|T2], [L1|M]):-
	L1 = [L1H|T1],
	L2 = [L2H|T2],
	L1H =< L2H,
	merge(T1,L2,T),
	M = [L1H|T].
merge([L1|T1], [L2|T2], [L1|M]):-
	L1 = [L1H|T1],
	L2 = [L2H|T2],
	L1H > L2H,
	merge(T1,L2H,T),
	M = [L2H|T].

merge_sort([],[]).

merge_sort([X],[X]).

merge_sort(L,M):-
	split(L,L1,L2),
	merge_sort(L1,L1S),
	merge_sort(L2,L2S),
	merge(L1S,L2S,M).
	
	


