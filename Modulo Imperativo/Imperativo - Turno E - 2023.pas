Program TurnoE2023Imperativo;
{En un hospital se leen datos de consultas hasta que se lea el día número 0.
a) De cada consulta se lee:
• Matrícula del médico.
• DNI del paciente.
• Día de la consulta.
• Código de diagnóstico (1 a 15).
Crear una estructura eficiente para la búsqueda por matrícula del médico, donde cada matrícula está acompañada de todas las consultas al médico.

b) Usando la estructura del inciso a), hacer un módulo que reciba la misma estructura y una matrícula, el módulo debe retornar la 
información ordenada de cuántas veces fue diagnosticado cada código.

c) En base a la estructura de b), hacer un modulo que retorne la misma estructura pero ordenada de mayor a menor.
}

Const
	DF=15;	//Dimensión física del vector contador de b).
Type
	code=1..DF;		//Subrango declarado para los códigos de diagnóstico.
	dia=0..31;			//Si bien el día 0 no existe, necesito incluirlo en el subrango para evitar un error. Este subrango es opcional.
	
	consulta=record			//Este es el tipo de record que guardará los datos ingresados por teclado.
		dia:dia;
		DNI,matricula:integer;
		code:code;
	end;
	
	consultareducida=record  //Este es el tipo de record que guardará en la lista de cada nodo del árbol los datos. NOTA: es útil para evitar repetir la matrícula innecesariamente.
		dia:dia;
		DNI:integer;
		code:code;
	end;
	
	lista=^nodoL;
	nodoL=record
		dato:consultareducida;	//Uso el record achicado en la lista, pues en la línea 43 guardo la matrícula como valor identificador de nodo de árbol.
		sig:lista;
	end;
	
	
	arbol=^nodoA;
	nodoA=record
		matricula:integer;	//Guardo la matrícula por separado para no repetirla.
		HI,HD:arbol;
		L:lista;			//Lista de consultas a la matrícula dada.
	end;

	vCode=array [code] of integer;	//Vector contador de aparición de códigos de diagnóstico.


////////////////////////////////Inciso A

Procedure LeerConsulta (var c:consulta); //Leer Consulta (? se explica solo.
begin
	write ('Ingrese el día de la consulta: ');readln(c.dia);
	if (c.dia<>0) then begin									//Si ingresa el día 0, no me interesa el resto de datos. Pues es condicion de corte.
		write ('Ingrese el DNI del paciente: ');readln(c.DNI);
		write ('Ingrese el codigo de diagnostico: ');readln(c.code);
		write ('Ingrese la matricula del medico: ');readln(c.matricula)
	end;
end;

Procedure AgregarAdelante (var L:lista; c:consulta); //Agregar adelante de toda la vida.
var
	aux:lista;
begin
	new(aux);
	aux^.dato.dia:=c.dia;  //Dado que utilizamos dos record diferentes por lo explicado más arriba, seleccionamos los campos que nos interesan para la lista
	aux^.dato.code:=c.code;
	aux^.dato.DNI:=c.DNI;
	aux^.sig:=L;			//Enlazo el auxiliar creado a mi puntero inicial.
	L:=aux					//Asigno la dirección del auxiliar a mi puntero inicial.
end;

Procedure AgregarAcumulando (var a:arbol; c:consulta);	//Módulo de crear hoja que almacena datos sin repetición de dato utilizado como criterio para ordenar.
begin
	if (a=nil) then begin //Arbol vacio encontrado, lo cargamos.
		new(a);
		a^.l:=nil;		//Inicializo la lista del nodo del árbol en nil. De no hacerlo al recorrerla no encontraría el final y daría error 216.
		AgregarAdelante(a^.l,c);
		a^.matricula:=c.matricula;		//No olvidarse de tomar la matrícula a parte para no repetirla en la lista, es el valor que identifica a cada nodo.
		a^.HI:=nil;
		a^.HD:=nil
	end
	else if (a^.matricula=c.matricula) then //Encontre el nodo donde debo acumular los datos.
		AgregarAdelante(a^.l,c)
	else if (a^.matricula>c.matricula) then //Encontre una matricula mayor que la que recibí. Me voy a buscar a la izquierda.
		AgregarAcumulando(a^.HI,c)
	else
		AgregarAcumulando(a^.HD,c) //Encontre una matricula menor. Me voy a la derecha.
end;


Procedure IncisoA (var a:arbol);
var
	c:consulta;
begin
	LeerConsulta(c);
	if (c.dia<>0) then begin	//Leo consultas mientras el día registrado no sea 0.
		AgregarAcumulando(a,c);
		LeerConsulta(c)
	end;
end;

////////////////////////////////Inciso B

Procedure InicializarVector (var v:vCode); 
//Conceptualmente estamos utilizando un vector contador a pesar de que no lo digan. DEBE inicializarse.
//Más adelante se explicará por qué es crucial este procedure.
var
	i:integer;
begin
	for i:=1 to DF do
		v[i]:=0;
end;


Procedure BuscarMatricula (a:arbol ; var L:lista; mat:integer);
begin
	if (a<>nil) then
		if (a^.matricula=mat) then //Si el nodo revisado tiene la matrícula que quiero, me lo llevo.
			L:=a^.L
		else if (a^.matricula>mat) then	//Si la matricula encontrada en el nodo es más grande que la que quiero, me voy a la izquierda.
			BuscarMatricula(a^.HI,L,mat)
		else
			BuscarMatricula(a^.HD,L,mat)	//Si es más chica, me voy a la derecha.
end;

Procedure RecorrerCargando (var  v:vCode; L:lista);	//Recorro la lista (si no es nil)
//En este procedure se hace claro por qué es importante inicializar el vector, en la línea 135
//se suma a la cantidad encontrada 1, si no estuviera inicializado en 0, se sumaría todo a "basura".
//Dicho error sería muy grave y puede arruinarles medio examen. Atención a los vectores contadores.
begin
	while (l<>nil) do begin
		v[L^.dato.code]:=v[L^.dato.code]+1;		//Uso como índice del vector el codigo de cada registro en la lista, y a esa posición le sumo 1.
		L:=L^.sig		//Paso al siguiente nodo de la lista.
	end;
end;

Procedure IncisoB (a: arbol; mat:integer; var v:vCode);
	var
		L:lista; //Variable necesaria para poder tomar del árbol la lista de la matrícula correcta.
begin
	L:=nil;  				//Inicializo lista. De no encontrar la matricula en el arbol, no se recorre, evitando un error.
	InicializarVector(v);
	BuscarMatricula(a,L,mat);
	if (L<>nil) then			//Pregunto si encontré la lista de la matrícula buscada.
		RecorrerCargando(v,L);
end;
	
////////////////////////////////Inciso C

Procedure IncisoC (var v:vCode); //Ordenar por Seleccion. 
var
	i,j,p:integer;                 // Ipij jp pj "salvo" p <- truquito que uso yo para memorizar OrdXSeleccion.
	AUX:integer;
begin
	for i:=1 to DF-1 do begin	//i
		p:=i;						//pi
		for j:=i+1 to DF do			//j
			if (v[j]>v[p]) then 
				p:=j; 			//jp pj (el comparador es ">" si es de mayor a menor y "<" si es de menor a mayor.
			
		AUX:=v[p];						//"salvo" p con el AUX e intercambio.
		v[p]:=v[i];
		v[i]:=AUX
	end;
end;

var
	a:arbol;
	v:vCode;
	mat:integer;
begin
	a:=nil;
	IncisoA(a); //Crear el arbol pedido.
	write ('Ingrese una matricula de la que retornar los datos ordenados por código de diagnóstico.'); readln(mat);
	if (a<>nil) then begin
		IncisoB(a,mat,v);  //Aclaración: el enunciado pedía que el modulo reciba las tres cosas: estructura de a), matricula y retornar la info ordenada (vector). 
							//Por lo tanto, la matrícula a buscar debe leerse en prog. principal.
		
		IncisoC (v);			//Ordenar el vector de mayor a menor.
	end;
end.		//Cualquier cosita soy matusfp en el grupo de Taller 2023. Si tienen dudas pregunten nomás :D
