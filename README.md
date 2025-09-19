# CodeSmells


1° Magic number:

O valor 0.9 é um "número mágico". Ele representa um desconto de 10%, mas esse significado não está explícito no código, ou seja, precisa ser esclarecido o contexto para que ele venha a aparecer.

Troquei o valor solto para uma constante com o nome autoexplicativo:
"private static final double FATOR_DESCONTO_PROMOCIONAL = 0.9;"
