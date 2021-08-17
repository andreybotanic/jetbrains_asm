; Sample NASM File
section .text

example_constant equ 45

%define single_line_macro(x)   (x+5)

%macro multi_line_macro 1
    mov    %1, ebx
%endmacro

%macro retz 0
        jnz %%skip
        ret
    %%skip:
%endmacro

global function
func:
       multi_line_macro eax
       mov     eax, single_line_macro(5)
       xor     ax, ax
       mov     ss, ax ; Set segments
       mov     ds, ax
       mov     rax, es:rdx
       fadd    S(0) ; FPU instruction
       pxor    xmm0, xmm0 ; MMX instruction
       cvtsi2ss xmm0, rax
       mov     eax, dword [ebp + 4*eax - 12h]
       mov     eax, 'str'
       mov     eax, partition.sizeof
       repz ret

section .bss

; Format of fdisk partition entry.
struc partition
    .bootid  resb 1 ; bootable or not
    .head    resb 1 ; starting head, sector, cylinder
    .sect    resb 1 ;
    .cyl     resb 1 ;
    .type    resb 1 ; partition type
    .endhead resb 1 ; ending head, sector, cylinder
    .endsect resb 1 ;
    .endcyl  resb 1 ;
    .lba     resd 1 ; starting lba
    .sectors resd 1 ; size in sectors
    .sizeof
endstruc

%macro silly 2
    %2: db %1
%endmacro

section .data
silly "example string 1" exampleString1
exampleString2:db "example string 2", 10, 13
floatval:      dd 3.14159
byteval1:      db 0xFF
byteval2:      db 0A1h
binaryval1:    db 0b0101


jmp partition.head

       END
