var1:   db 33
var2:   dw (55)               ; Integer expression
var3:   dd 42
        dq 42
      ; db (44,55)            ; Invalid - error
        db ('AA')             ; Integer expression - outputs single byte
        db 1, 2, 0x10, 'a', 'abc'
var11:  db 0
mov eax, 0x01
xor ax, ax
.label:
add cx, 10 ; comment
; comment too
;comment too1
 ; sdfdss
inc al
dec bl
jmp .label
mov al, ' '
mov ax, '0x'
