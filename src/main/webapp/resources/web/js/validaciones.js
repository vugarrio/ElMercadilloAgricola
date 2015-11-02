/* 
	function ValidaFormulario() {
			var error = 0;
			var mensaje = "Debe cumplimentar correctamente los siguentes datos:\n\n";
			
			if (!esVacio(document.miform.titulo.value)) {
				error = 1;
				mensaje = mensaje + "  - TITULO (Obligatorio)\n"
			}
			
			if (!esVacio(document.miform.FechaCargoRecibos.value)) {
				error = 1;
				mensaje = mensaje + "  - FECHA DE CARGO (Obligatorio)\n"
			} else if (!fechaCorrecta(document.miform.FechaCargoRecibos.value)) {
					error = 1;
					mensaje = mensaje + "  - FECHA DE CARGO correcta (dd/mm/yyyy)\n"
				}
			
			if (document.miform.Tipo_Formulario.options[document.miform.Tipo_Formulario.selectedIndex].value == '') {
				error = 1;
				mensaje = mensaje + "  - Seleccionar REMESA (Obligatorio) \n"
			} 
			
			if (error == 1) {
				alert (mensaje);
				return false;
			} else return true
			
		}
		
		Mirar: http://www.webintenta.com/validacion-con-expresiones-regulares-y-javascript.html
*/     

/* Devuelve si existe una varaible dada. Ej.: if (isset('variable_name')) alert ('si')  */
/*function isset(variable_name) {
	try {
     if (eval(variable_name)) return true;
     if (eval(variable_name) != null)
       if (typeof(eval(variable_name)) != 'undefined')
         return true;
   } catch(e) { }
   return false;
   
}*/

function IsDigit(e)
{	
	/* IsDigit(event)  */
	/* Comnpatilble con FireFox */
	var keyCode;
		
	if (window.event) {
		e = window.event;
		keyCode = e.keyCode;
	} else {
		// a key, such as delete, was pressed; let it pass through
		if (e.keyCode == e.which) keyCode = null;
		// else if not a char we don't know what this is; let it pass through
		else if (e.charCode != e.which) keyCode = void 0;
		// else a char - set it
		else keyCode = e.which;
	}
	
	return (((keyCode >= 48) && (keyCode <= 57)) ||  (keyCode == 37))
}


function IsDigitPrecioCorrecto(e, obj)
{
	/* IsDigitPrecioCorrecto(event, this)  */
	/* Comnpatilble con FireFox */
	var keyCode;
		
	if (window.event) {
		e = window.event;
		keyCode = e.keyCode;
	} else {
		// a key, such as delete, was pressed; let it pass through
		if (e.keyCode == e.which) keyCode = null;
		// else if not a char we don't know what this is; let it pass through
		else if (e.charCode != e.which) keyCode = void 0;
		// else a char - set it
		else keyCode = e.which;
	}	
		
	if (obj.value.length == 0){
		//primera pulsacion.  no controlar comas
		return (((keyCode >= 48) && (keyCode <= 57)) ||  (keyCode == 37) ||  (keyCode == 44))
	}else{
		var i;
		var longitud = obj.value.length;
		var caracter;
		var devolver = 0;
		for(i=0;i<longitud;i++){
			caracter = obj.value.charAt(i)
			if ((i == 0) && (caracter == '.')){
				//el primer caracter escrito es una coma, incorrecto
				//alert('El primer digito no puede ser una coma')
				devolver = 1;
			}
			if ((caracter == '.') && (keyCode == 44)){
				//alert('Solo puede introducir una coma')
				devolver = 1;
			}
			
			if ((caracter == ',') && (i<longitud) && (keyCode == 44)){
				//alert('Solo puede contener una coma.')
				devolver = 2;
			}
			
		}
		if (devolver == 0){
			// no hay mas de una coma, correcto
			return (((keyCode >= 48) && (keyCode <= 57)) ||  (keyCode == 37) ||  (keyCode == 44))
		} else if (devolver == 1){
			// error
			obj.value = ''
			return false;
		} else {
                        return false;
                }
	}
}

function IsDigit_coma(e, obj)
{
	/* IsDigit_coma(event, this)  */
	/* Comnpatilble con FireFox */
	var keyCode;
		
	if (window.event) {
		e = window.event;
		keyCode = e.keyCode;
	} else {
		// a key, such as delete, was pressed; let it pass through
		if (e.keyCode == e.which) keyCode = null;
		// else if not a char we don't know what this is; let it pass through
		else if (e.charCode != e.which) keyCode = void 0;
		// else a char - set it
		else keyCode = e.which;
	}
	
	if (obj.value.length == 0){
		//primera pulsacion.  no controlar comas
		return (((keyCode >= 48) && (keyCode <= 57)) ||  (keyCode == 37) ||  (keyCode == 44))
	}else{
		var i;
		var longitud = obj.value.length;
		var caracter;
		var devolver = 0;
		for(i=0;i<longitud;i++){
			caracter = obj.value.charAt(i)
			if ((i == 0) && (caracter == '.')){
				//el primer caracter escrito es una coma, incorrecto
				//alert('El primer digito no puede ser una coma')
				devolver = 1;
			}
			if ((caracter == '.') && (keyCode == 44)){
				//alert('Solo puede introducir una coma')
				devolver = 1;
			}
			
			if ((caracter == ',') && (i<longitud) && (keyCode == 44)){
				alert('Solo puede contener una coma.')
				devolver = 1;
			}
			
		}
		if (devolver == 0){
			// no hay mas de una coma, correcto
			return (((keyCode >= 48) && (keyCode <= 57)) ||  (keyCode == 37) ||  (keyCode == 44))
		}else{
			// error
			obj.value = ''
			return false;
		}
	}
}

function IsDigit_punto(e, obj)
{
	/* IsDigit_punto(event, this)  */
	/* Comnpatilble con FireFox */
	var keyCode;
		
	if (window.event) {
		e = window.event;
		keyCode = e.keyCode;
	} else {
		// a key, such as delete, was pressed; let it pass through
		if (e.keyCode == e.which) keyCode = null;
		// else if not a char we don't know what this is; let it pass through
		else if (e.charCode != e.which) keyCode = void 0;
		// else a char - set it
		else keyCode = e.which;
	}
	
	if (obj.value.length == 0){
		//primera pulsacion.  no controlar comas
		return (((keyCode >= 48) && (keyCode <= 57)) ||  (keyCode == 37) ||  (keyCode == 46))
	}else{
		var i;
		var longitud = obj.value.length;
		var caracter;
		var devolver = 0;
		for(i=0;i<longitud;i++){
			caracter = obj.value.charAt(i)
			if ((i == 0) && (caracter == '.')){
				//el primer caracter escrito es una coma, incorrecto
				//alert('El primer digito no puede ser un punto')
				devolver = 1;
			}
			if ((caracter == ',') && (keyCode == 46)){
				//alert('Solo puede introducir un punto')
				devolver = 1;
			}
		}
		if (devolver == 0){
			// no hay mas de una coma, correcto
			return (((keyCode >= 48) && (keyCode <= 57)) ||  (keyCode == 37) ||  (keyCode == 46))
		}else{
			// error
			obj.value = ''
			return false;
		}
	}
}

//Devulve el valor pulsado en un dato de tipo radio
function getCheckedValue(radioObj) {
	if(!radioObj)
			return "";
	var radioLength = radioObj.length;
	if(!isset(radioLength)) {
		if(radioObj.checked)
			return radioObj.value;
		else
			return "";
	}
	for(var i = 0; i < radioLength; i++) {
		if(radioObj[i].checked) {
			return radioObj[i].value;
		}
	}
	return "";
}

//Selecciona un dato de tipo radio pasandole el valor del radio
function setCheckedValue(radioObj, ele) {
	var radioLength = radioObj.length;
	if(!isset(radioLength)) {	
		radioObj.checked = 1;		
	}
	for(var i = 0; i < radioLength; i++) {
		if(radioObj[i].value == ele) {
			radioObj[i].checked = 1
		}
	}
}



/* VALIDA SI ES NUMERICO

LLAMADA:
<cfinput type="Text" name="numtitulos" message="DEBE INTRODUCIR N� TITULOS." validate="integer" required="Yes" size="3" maxlength="3" onchange="return isNumero(this)">  

*/
	function esNumerico (object_value)
    {
	   
	    if (object_value.length == 0)
	        return true;
	
		var start_format = " .+-0123456789";
		var number_format = " .0123456789";
		var check_char;
		var decimal = false;
		var trailing_blank = false;
		var digits = false;
	
	    //The first character can be + - .  blank or a digit.
		check_char = start_format.indexOf(object_value.charAt(0))
	    //Was it a decimal?
		if (check_char == 1)
		    decimal = true;
		else if (check_char < 1)
			return false;
	        
		//Remaining characters can be only . or a digit, but only one decimal.
		for (var i = 1; i < object_value.length; i++)
		{
			check_char = number_format.indexOf(object_value.charAt(i))
			if (check_char < 0)
				return false;
			else if (check_char == 1)
			{
				if (decimal)		// Second decimal.
					return false;
				else
					decimal = true;
			}
			else if (check_char == 0)
			{
				if (decimal || digits)	
					trailing_blank = true;
	        // ignore leading blanks
	
			}
		        else if (trailing_blank)
				return false;
			else
				digits = true;
		}	
	    //All tests passed, so...
	    return true;
		
    }
	
	
	
	
	function esEntero(valor){
	  cad = valor.toString();
	  for (var i=0; i<cad.length; i++) {
		var caracter = cad.charAt(i);
		if (caracter<"0" || caracter>"9")
		  return false;
	  }
	  return true;
	}
	
	function IsDecimal(expression)
	{
		return (String(expression).search(/^\d+(\,\d+)?$/) != -1); //Con coma
	}
	
	
	// Validar la Cuenta Corriente de un Banco 
	function obtenerDigito(valor){
	  valores = new Array(1, 2, 4, 8, 5, 10, 9, 7, 3, 6);
	  control = 0;
	  for (i=0; i<=9; i++)
		control += parseInt(valor.charAt(i)) * valores[i];
	  control = 11 - (control % 11);
	  if (control == 11) control = 0;
	  else if (control == 10) control = 1;
	  return control;
	}
    function validarCCC(banco, sucursal, dc, cuenta) {
	 
	  if (banco == ""  || sucursal == "" ||
		  dc == "" || cuenta == "")
		return false;
	  else {
		if (banco.length != 4 || sucursal.length != 4 ||
			dc.length != 2 || cuenta.length != 10)
		  return false;
		else {
		  if (!esEntero(banco) || !esEntero(sucursal) ||
			  !esEntero(dc) || !esEntero(cuenta))
			return false;
		  else {
		  	if (!(obtenerDigito("00" + banco + sucursal) ==
				  parseInt(dc.charAt(0))) || 
				!(obtenerDigito(cuenta) ==  parseInt(dc.charAt(1))))
			  return false;
			else
			 return true;
		  }
		}
	  }
	}
	

// Si es vacio devuelve FALSE
function esVacio(contenido)  {
	 return (!contenido || /^\s*$/.test(contenido));
	  
     /*if ((contenido.length==0) {
	      return true;
	   } else {
		   for (var i=0; i<contenido.length; ++i) {
		   	  if (contenido.charAt(i)!=' ' )
		         {
				   return false;
		         } 
		   }
	   }
	   return true; */
}

/* Si es un texto formado por letras o numeros sin espacos*/
function esTextoAlfaNumercio(contenido)  {
 if (contenido.length==0) {
	  return true;
   } else {
	   for (var i=0; i<contenido.length; ++i) {
		  codigo = contenido.charAt(i).charCodeAt();
		  //alert("Letra: " + contenido.charAt(i) + "   Codigo: " + codigo);
		  if (((codigo >=65) && (codigo <=90)) || ((codigo >=97) && (codigo <=122)) || ((codigo >=48) && (codigo <=57))) { 
		  }	else {
			return false;
		  }
	   }
   }
   return true; 
} 



function validarPassword(valor){
	var exr = /^([a-zA-Z0-9@*#]{3,16})$/;
	return exr.test(valor);

}



///Valida el C:Posta: EL CP debe tener 5 numeros.
function validarCP(valor){
	var exr = /^([1-9]{2}|[0-9][1-9]|[1-9][0-9])[0-9]{3}$/;
	return exr.test(valor);

}


function validaTelefonoFijoEspana(valor){
	if (valor.substring(0,1)=='9' && validaTelefono(valor)){
		return true;												 
	} else return false;
}

function validaTelefonoMovilEspana(valor){
	if ( (valor.substring(0,1)=='6' || valor.substring(0,1)=='7' ) && validaTelefono(valor)){
		return true;												 
	} else return false;
}


// Comprueba que el telefono tiene mas de 9 digitos, no tiene letras y empieza por 9 o 6.
function validaTelefono (valor)  {
	var exr = /([9|6|7])+[0-9]{8}/ 
	//var exr = /^[0-9]{2,3}-? ?[0-9]{6,7}$/
	return exr.test(valor);	
   }
   
function validaTelefonoGeneral  (valor)  {
	var existe_var = "+967";
	var esta = false;
	if (valor.length >= 9) {
		for (var i = 0; i < valor.length; i++) {
			pos = existe_var.indexOf(valor.charAt(i));
			if (pos >= 0) {
				esta = true;
			}
		}
	}	
	return esta;
	//var exr = /([9|6|7])+[0-9]{8}/ 
	//var exr = /^[0-9]{2,3}-? ?[0-9]{6,7}$/
	//return exr.test(valor);	
   }

function validaEmail(valor) {
	var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/; 
	
	return emailReg.test( valor );
	
	
}




// Valida el NIF incluyendo la letra que le corresponde. Se puede introducir el numero con puntos o sin puntos.
function  validarNIF(dato) {
  if (dato == "")
  {
    //alert("Escriba el valor para el campo \"DNI\" .");
    //obj.focus();
    return (false);
  }
  
  var tamanio = dato.length;
  var letra = dato.charAt(tamanio-1).toLowerCase();
  var penultima = dato.charAt(tamanio-2);
    
   
  var digitos = "0123456789.";
  var letras =   "trwagmyfpdxbnjzsqvhlcke"
  var chequeo ;
  var correcto = true;
  //alert (letra)
  if ( letras.indexOf(letra,0)< 0) {
  	//alert("Debe de poner una Letra");
    //obj.focus();
    return (false);
  
  } 
  
  if ( penultima == '-' ) {
  	chequeo = dato.substring(0,tamanio-2) 
  } else chequeo = dato.substring(0,tamanio-1) 
  
  
  var num =""
  for (i = 0;  i < chequeo.length;  i++)
  {
    ch = chequeo.charAt(i);
	if (ch!=".") 
	  	num=num+chequeo.charAt(i);
	for (j = 0;  j < digitos.length;  j++)
	  if (ch == digitos.charAt(j))
        break;
    if (j == digitos.length)
    {
      //alert("Escriba �nicamente d�gitos del 0 al 9 en el campo \"DNI\".");
      //obj.focus();
      return (false);
    }
   }
   	//alert(num)
	var miletra;
	var ASC;
	ASC = num % 23;
	//alert ("asc:"+ASC)
	if ( ASC == 0) { miletra="T"; };
	if ( ASC == 1) { miletra="R"; };
	if ( ASC == 2) { miletra="W"; };
	if ( ASC == 3) { miletra="A"; };
	if ( ASC == 4) { miletra="G"; };
	if ( ASC == 5) { miletra="M"; };
	if ( ASC == 6) { miletra="Y"; };
	if ( ASC == 7) { miletra="F"; };
	if ( ASC == 8) { miletra="P"; };
	if ( ASC == 9) { miletra="D"; };
	if ( ASC == 10) { miletra="X"; };
	if ( ASC == 11) { miletra="B"; };
	if ( ASC == 12) { miletra="N"; };
	if ( ASC == 13) { miletra="J"; };
	if ( ASC == 14) { miletra="Z"; };
	if ( ASC == 15) { miletra="S"; };
	if ( ASC == 16) { miletra="Q"; };
	if ( ASC == 17) { miletra="V"; };
	if ( ASC == 18) { miletra="H"; };
	if ( ASC == 19) { miletra="L"; };
	if ( ASC == 20) { miletra="C"; };
	if ( ASC == 21) { miletra="K"; };
	if ( ASC == 22) { miletra="E"; };
	if ( ASC == 23) { miletra="T"; };
	
	if (miletra.toLowerCase()==letra) {
		 //alert ("Letras Iguales");
		 return true;
	} else {
		//alert ("Letras NO Iguales")
		return false;
	}
}

// Funcion que valida que el valor del objeto que se le pase sea un cif sino devolvera 1.correcto 0.incorrecto
//Necesita incluir la funci&oacute;n de trim y de nif en el mismo fichero

function  validarCIF(dato) 
{
var valor = dato;
var longitud=valor.length;
if (longitud==9)
{
dig4=valor.substr(2,1)
dig6=valor.substr(4,1)
dig8=valor.substr(6,1)
dig3=valor.substr(1,1)
dig5=valor.substr(3,1)
dig7=valor.substr(5,1)
dig9=valor.substr(7,1)
dig10=valor.substr(8,1)

dig4 = dig4 - 0
dig6 = dig6 - 0
dig8 = dig8 - 0
dig3 = dig3 - 0
dig5 = dig5 - 0
dig7 = dig7 - 0
dig9 = dig9 - 0
if (isFinite(dig10))
    {dig10 = dig10 - 0}

   
   S1 = dig4 + dig6 + dig8   
   S2 = 0
   Resultador = dig3 * 2
	
	if (Resultador < 10)
        {S2 = S2 + Resultador}
	else
	{
		 Resultador=Resultador.toString()
        r1=Resultador.substr(0,1) 
        r2=Resultador.substr(1,1) 
        r1=r1-0
        r2=r2-0
        S2 = S2 + ( r1 + r2)
	}


   Resultador = dig5 * 2
	
	if (Resultador < 10)
        {S2 = S2 + Resultador}
	else
	{
		 Resultador=Resultador.toString()
        r1=Resultador.substr(0,1) 
        r2=Resultador.substr(1,1) 
        r1=r1-0
        r2=r2-0
        S2 = S2 + ( r1 + r2)
	}


   Resultador = dig7 * 2
	
	if (Resultador < 10)
        {S2 = S2 + Resultador}
	else
	{
		 Resultador=Resultador.toString()
        r1=Resultador.substr(0,1) 
        r2=Resultador.substr(1,1) 
        r1=r1-0
        r2=r2-0
        S2 = S2 + ( r1 + r2)
	}

   Resultador = dig9 * 2
	
	if (Resultador < 10)
        {S2 = S2 + Resultador}
	else
	{
 		 Resultador=Resultador.toString()
        r1=Resultador.substr(0,1) 
        r2=Resultador.substr(1,1) 
        r1=r1-0
        r2=r2-0
        S2 = S2 + ( r1 + r2)
	}

   S = S1 + S2
      
   if (S<10)
	   	{   D = 10 - S
		}
	else if (S<20)
            	{   D = 20 - S
	    		}
	else if (S<30)
            	{   D = 30 - S
				}
	else if (S<40)
   
            	{   D = 40 - S
		}
	else if (S<50)
               	{   D = 50 - S
		}
	else if (S<60)
   
            	{   D = 60 - S
		}
	else if (S<70)
   
            	{   D = 70 - S
		}
	else if (S<80)
               	{   D = 80 - S
		}
	else if (S<90)
      	{   D = 90 - S
		}
	else
		{	
      	   D = 100 - S
		}

      if (D > 9)
		{
		          D=D.toString()
                 d1 = D.substr(1,1)
                 D = d1
                 D = D - 0
		}

var da=''
if (D==0)
   {
     da = 'J'
	}
if (D==1)
   {
     da = 'A'
	}
if (D==2)
   {
     da = 'B'
	}
if (D==3)
   {
     da = 'C'
	}
if (D==4)
   {
     da = 'D'
	}
if (D==5)
   {
     da = 'E'
	}
if (D==6)
   {
     da = 'F'
	}
if (D==7)
   {
     da = 'G'
	}
if (D==8)
   {
     da = 'H'
	}
if (D==9)
   {
     da = 'I'
	}

	
   if (isFinite(dig10))
   {
	  if (D == dig10)
	  {
                return true; 
	  }
	}
	else
	{dig10=dig10.toString()
	 dig10=dig10.toUpperCase()
	 if (da==dig10) 
	   {
                return true; 
	  }
    }
	    
}	
return false;
}


// Valida el NIE (T. de Residencia).
function  validarNIE(dato) {
  if (dato == "")
  {
    //alert("Escriba el valor para el campo \"DNI\" .");
    //obj.focus();
    return (false);
  }

    var dni = dato.toUpperCase();
	var pre = dni.substr(0, 1);
	var prev = '0';
	if (pre == 'X')
	   prev = '0';
	else if (pre == 'Y')
	   prev = '1';
	else if (pre == 'Z')
	   prev = '2';
	else return false;
	numero = prev + dni.substr(1,dni.length-1);
	return validarNIF(numero);

}

 // Comprueba si la longitud de TextArea es correcta
 // LLamada: <textarea name="OBSER_DG" cols="24" rows="3" onKeyUp="LongitudTextoArea(this, 250)"></textarea>
 function LongitudTextoArea(elemento, longitud) {
	 var longitud_maxima = longitud;
	 var longitud_texto = elemento.value.length;
	 if (longitud_texto > longitud_maxima) {
	  elemento.value = elemento.value.substring(0,longitud_maxima);
	  alert ("EL TEXTO TIENE QUE SER UN MAXIMO DE "+longitud_maxima+" CARACTERES.");
	  return false
	 } else {
	  return true;
	 }
	 
}

// Valida el sexo. Si se introdujo V de Varon o H de hembra
function validaSexo(s) {
	//alert(s.value.toLowerCase());
	if (s.value == "")
		{
			return true
			//Si esta vacio, el valor introducido en valido porque es un dato opcional.
		}	
	
	
		if( (s.value.toLowerCase() != 'v') && (s.value.toLowerCase() != 'h'))
		{
			alert("Debe introducir un valor correcto. (V / H)");
			s.focus()
			return false;
		}
}


function compruebaSinCarExtranios (object_value) {
	var carateres_extranios = "%&$!\"\'/\\"
	
	for (var i = 0; i < object_value.length; i++)
	{
	check_char = carateres_extranios.indexOf(object_value.charAt(i))
	if (check_char >= 0 )
		return false;
	}	
	return true	
}

//Valida si un texto es una hora con formato hh:mm  .
function EsHoraMinuto(cadena) {  
	var  n1 = cadena.indexOf(":",0);
	if (n1 < 0) {
		return false;
	}
	
	var hora =  cadena.substring(0, n1)
	var minuto = cadena.substring(n1+1, cadena.length)
	if (!esEntero(hora) || !esEntero(minuto) || hora < 0 || hora > 23 || minuto < 0 || minuto > 59 ) {
		return false
	} else return true
}
	
