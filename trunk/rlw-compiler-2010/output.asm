.model small
.586
.stack 100h
.data
    CRLF db "  $"
    fperon dd ?
    m16 dw ?
    sumOverError db "Error! Overflow en una suma$"
    zeroDivError db "Error! Intento de division por 0$"
    CONSTANT7 dd 10.6
    CONSTANT19 dd 132
    CONSTANT16 db "Lorem ipsum dolor sit amet, $"
    CONSTANT26 dd 18
    CONSTANT12 dd 15
    CONSTANT28 dd 14
    foo_1 dd ?
    CONSTANT32 db "first loop$"
    bar_2_1 dd ?
    CONSTANT10 dd 156.4E19
    CONSTANT11 dd 0.0
    baz_1 dd ?
    l_1 dd ?
    foo_1_1 dd ?
    CONSTANT4 dd 65
    CONSTANT3 dd 105
    CONSTANT38 db "third loop$"
    CONSTANT25 db "i'm outside the scope$"
    CONSTANT35 db "second loop$"
    CONSTANT15 db "i shouldn't be printed$"
    CONSTANT21 db "this is WRONG$"
    k_1 dd ?
    CONSTANT29 db "This is inside a loop$"
    foo_2_1 dd ?
    j_1 dd ?
    CONSTANT8 dd -10.6
    CONSTANT34 dd 3
    CONSTANT5 dd 2
    CONSTANT18 dd 10
    CONSTANT30 dd 1
    CONSTANT9 dd 0
    CONSTANT6 dd -2
    i_1 dd ?
    CONSTANT24 db "fooooo$"
    CONSTANT37 dd -3
    CONSTANT20 db "consectetur adipiscing elit. Mauris at sagittis velit.$"
    CONSTANT17 dd 9
    bar_1 dd ?
    CONSTANT14 db "i'm inside the scope$"
.code
main:
    mov ax, @data
    mov ds, ax
    mov CRLF, 13
    mov CRLF + 1, 10
    push CONSTANT3
    push CONSTANT4
    pop ebx
    pop eax
    imul ebx; mult entera
    push eax
    push CONSTANT6
    pop ebx
    pop eax
    add eax,ebx ; suma entera
    jo _sumOver
    push eax
    pop eax
    mov foo_1,eax
    mov eax,CONSTANT8
    mov bar_1,eax
    push foo_1
    push CONSTANT9
    pop ebx
    pop eax
    cmp eax,ebx; comp int
    jge _elseLabel_1
    mov eax,CONSTANT10
    mov bar_1,eax
    mov eax,CONSTANT11
    mov baz_1,eax
    jmp _endifLabel_1
_elseLabel_1:
    mov eax,CONSTANT9
    mov fperon,eax; conversion implicit
    fild fperon
    fst fperon
    mov eax,fperon
    mov bar_1,eax
    push foo_1
    push CONSTANT12
    pop ebx
    pop eax
    add eax,ebx ; suma entera
    jo _sumOver
    push eax
    pop eax
    mov foo_1,eax
_endifLabel_1:
    mov eax,bar_1
    mov foo_1_1,eax
    mov dx,OFFSET CONSTANT14
    mov ah,9
    int 21h
    mov dx,OFFSET CRLF
    mov ah,9
    int 21h
    push foo_1_1
    push CONSTANT9
    pop ebx
    pop eax
    mov fperon,ebx; comp float 
    fld fperon
    mov fperon,eax
    fild fperon
    fcompp
    fstsw m16
    fwait
    mov ax,m16
    sahf 
    je _elseLabel_2
    mov dx,OFFSET CONSTANT15
    mov ah,9
    int 21h
    mov dx,OFFSET CRLF
    mov ah,9
    int 21h
    jmp _endifLabel_2
_elseLabel_2:
    mov dx,OFFSET CONSTANT16
    mov ah,9
    int 21h
    mov dx,OFFSET CRLF
    mov ah,9
    int 21h
    push foo_1_1
    push CONSTANT17
    pop ebx
    pop eax
    mov fperon,ebx ; suma float
    fld fperon
    mov fperon,eax
    fild fperon
    fadd
    fstsw m16
    fwait
    mov ax,m16
    sahf 
    jc _sumOver
    fst fperon
    mov eax,fperon
    push eax
    push CONSTANT18
    push bar_1
    push CONSTANT19
    pop ebx
    pop eax
    mov fperon,ebx ; mul float
    fld fperon
    mov fperon,eax
    fild fperon
    fmul
    fst fperon
    mov eax,fperon
    push eax
    pop ebx
    pop eax
    mov fperon,eax; resta float 
    fild fperon
    mov fperon,ebx
    fld fperon
    fsub
    fst fperon
    mov eax,fperon
    push eax
    pop ebx
    pop eax
    mov fperon,ebx; comp float 
    fld fperon
    mov fperon,eax
    fld fperon
    fcompp
    fstsw m16
    fwait
    mov ax,m16
    sahf 
    jge _elseLabel_3
    mov dx,OFFSET CONSTANT20
    mov ah,9
    int 21h
    mov dx,OFFSET CRLF
    mov ah,9
    int 21h
    jmp _endifLabel_3
_elseLabel_3:
    mov dx,OFFSET CONSTANT21
    mov ah,9
    int 21h
    mov dx,OFFSET CRLF
    mov ah,9
    int 21h
_endifLabel_3:
_endifLabel_2:
    mov eax,CONSTANT12
    mov foo_1,eax
    mov dx,OFFSET CONSTANT24
    mov ah,9
    int 21h
    mov dx,OFFSET CRLF
    mov ah,9
    int 21h
    mov dx,OFFSET CONSTANT25
    mov ah,9
    int 21h
    mov dx,OFFSET CRLF
    mov ah,9
    int 21h
    mov eax,CONSTANT26
    mov i_1,eax
_loopCheck_1:
    push i_1
    push foo_1
    pop ebx
    pop eax
    cmp eax,ebx; comp int
    jge _loopEnd_1
    mov dx,OFFSET CONSTANT29
    mov ah,9
    int 21h
    mov dx,OFFSET CRLF
    mov ah,9
    int 21h
    push bar_1
    push i_1
    pop ebx
    pop eax
    mov fperon,ebx ; suma float
    fld fperon
    mov fperon,eax
    fild fperon
    fadd
    fstsw m16
    fwait
    mov ax,m16
    sahf 
    jc _sumOver
    fst fperon
    mov eax,fperon
    push eax
    pop eax
    mov bar_1,eax
    push i_1
    push CONSTANT28
    pop ebx
    pop eax
    add eax,ebx ; suma entera
    jo _sumOver
    push eax
    pop eax
    mov i_1,eax
    jmp _loopCheck_1
_loopEnd_1:
    mov eax,CONSTANT30
    mov j_1,eax
_loopCheck_2:
    push CONSTANT5
    push j_1
    pop ebx
    pop eax
    cmp eax,ebx; comp int
    jb _loopEnd_2
    mov dx,OFFSET CONSTANT32
    mov ah,9
    int 21h
    mov dx,OFFSET CRLF
    mov ah,9
    int 21h
    mov eax,CONSTANT9
    mov k_1,eax
_loopCheck_3:
    push CONSTANT34
    push k_1
    pop ebx
    pop eax
    cmp eax,ebx; comp int
    jbe _loopEnd_3
    mov dx,OFFSET CONSTANT35
    mov ah,9
    int 21h
    mov dx,OFFSET CRLF
    mov ah,9
    int 21h
    mov eax,CONSTANT26
    mov l_1,eax
_loopCheck_4:
    push CONSTANT9
    push l_1
    pop ebx
    pop eax
    cmp eax,ebx; comp int
    je _loopEnd_4
    mov dx,OFFSET CONSTANT38
    mov ah,9
    int 21h
    mov dx,OFFSET CRLF
    mov ah,9
    int 21h
    push l_1
    push CONSTANT37
    pop ebx
    pop eax
    add eax,ebx ; suma entera
    jo _sumOver
    push eax
    pop eax
    mov l_1,eax
    jmp _loopCheck_4
_loopEnd_4:
    push k_1
    push CONSTANT30
    pop ebx
    pop eax
    add eax,ebx ; suma entera
    jo _sumOver
    push eax
    pop eax
    mov k_1,eax
    jmp _loopCheck_3
_loopEnd_3:
    push j_1
    push CONSTANT30
    pop ebx
    pop eax
    add eax,ebx ; suma entera
    jo _sumOver
    push eax
    pop eax
    mov j_1,eax
    jmp _loopCheck_2
_loopEnd_2:
    mov ah,4ch
    mov al,0
    int 21h
_zeroDiv:
    mov dx,OFFSET zeroDivError
    mov ah,9
    int 21h
    mov dx,OFFSET CRLF
    mov ah,9
    int 21h
    mov ah,4ch
    mov al,0
    int 21h
_sumOver:
    mov dx,OFFSET sumOverError
    mov ah,9
    int 21h
    mov dx,OFFSET CRLF
    mov ah,9
    int 21h
    mov ah,4ch
    mov al,0
    int 21h
end main
