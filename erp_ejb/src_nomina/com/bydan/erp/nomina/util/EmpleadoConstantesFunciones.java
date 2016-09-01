/*
*AVISO LEGAL
© Copyright
*Este programa esta protegido por la ley de derechos de autor.
*La reproduccion o distribucion ilicita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y seran objeto de todas las sanciones legales que correspondan.

*Su contenido no puede copiarse para fines comerciales o de otras,
*ni puede mostrarse, incluso en una version modificada, en otros sitios Web.
Solo esta permitido colocar hipervinculos al sitio web.
*/
package com.bydan.erp.nomina.util;

import org.apache.log4j.Logger;
import java.sql.Time;
import java.sql.Timestamp;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.swing.border.Border;
import java.io.InputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Date;
//import java.util.ArrayList;

import com.bydan.framework.erp.business.entity.GeneralEntity;
import com.bydan.framework.erp.business.entity.GeneralEntityReturnGeneral;
import com.bydan.framework.erp.business.entity.GeneralEntityParameterGeneral;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.OrderBy;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.entity.Reporte;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;


import com.bydan.erp.nomina.util.EmpleadoConstantesFunciones;
import com.bydan.erp.nomina.util.EmpleadoParameterReturnGeneral;
//import com.bydan.erp.nomina.util.EmpleadoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class EmpleadoConstantesFunciones extends EmpleadoConstantesFuncionesAdditional {		
	
	
	
	public static String S_TIPOREPORTE_EXTRA="";
	
	//USADO MAS EN RELACIONADO PARA MANTENIMIENTO MAESTRO-DETALLE
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOS=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOS;
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOS=Constantes.ISWING_TAMANIOMINIMO_TABLADATOS;
	
	//PARA TABLA RELACIONES(DESCRIPCION HEIGHTPE_REL_TAB)
	public static Integer ALTO_TABPANE_RELACIONES=Constantes.ISWING_ALTO_TABPANE + Funciones2.getValorProporcion(Constantes.ISWING_ALTO_TABPANE,0);
	
	//PARA TABLA RELACIONADO(DESCRIPTION HEIGHTPE_REL)
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL,0);		
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL,0);	
	
	//PARA CAMBIAR TODO--> SE CAMBIA EN TABLA RELACIONES Y TABLAS RELACIONADOS
	/*
	PARA MANEJAR EL TAB RELACIONES CON TABLA DE DATOS SE DEBE MODIFICAR Y VERIFICAR LOS VALORES CONTANTES:	
		final public static Integer ISWING_TAMANIOMAXIMO_TABLADATOSREL=240;//230;350;		
		final public static Integer ISWING_TAMANIOMINIMO_TABLADATOSREL=240;//230;260
		
		final public static Integer ISWING_ALTO_TABPANE=375;//375;400;260;
	CASO CONTRARIO, ESTOS VALORES SERIAN PARA CADA CASO (NO CONSTANTES)
	
	NOTA:
	* LA ALINEACION HORIZONTAL,FALTA
	*/
	
	
	public static final String SFINALQUERY=Constantes.SFINALQUERY;	
	public static final String SNOMBREOPCION="Empleado";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Empleado"+EmpleadoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EmpleadoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EmpleadoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EmpleadoConstantesFunciones.SCHEMA+"_"+EmpleadoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EmpleadoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EmpleadoConstantesFunciones.SCHEMA+"_"+EmpleadoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EmpleadoConstantesFunciones.SCHEMA+"_"+EmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EmpleadoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EmpleadoConstantesFunciones.SCHEMA+"_"+EmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EmpleadoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EmpleadoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EmpleadoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EmpleadoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EmpleadoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EmpleadoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Empleados";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Empleado";
	public static final String SCLASSWEBTITULO_LOWER="Empleado";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Empleado";
	public static final String OBJECTNAME="empleado";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="empleado";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select empleado from "+EmpleadoConstantesFunciones.SPERSISTENCENAME+" empleado";
	public static String QUERYSELECTNATIVE="select "+EmpleadoConstantesFunciones.SCHEMA+"."+EmpleadoConstantesFunciones.TABLENAME+".id,"+EmpleadoConstantesFunciones.SCHEMA+"."+EmpleadoConstantesFunciones.TABLENAME+".version_row,"+EmpleadoConstantesFunciones.SCHEMA+"."+EmpleadoConstantesFunciones.TABLENAME+".id_empresa,"+EmpleadoConstantesFunciones.SCHEMA+"."+EmpleadoConstantesFunciones.TABLENAME+".id_sucursal,"+EmpleadoConstantesFunciones.SCHEMA+"."+EmpleadoConstantesFunciones.TABLENAME+".id_pais,"+EmpleadoConstantesFunciones.SCHEMA+"."+EmpleadoConstantesFunciones.TABLENAME+".id_provincia,"+EmpleadoConstantesFunciones.SCHEMA+"."+EmpleadoConstantesFunciones.TABLENAME+".id_ciudad,"+EmpleadoConstantesFunciones.SCHEMA+"."+EmpleadoConstantesFunciones.TABLENAME+".id_centro_costo,"+EmpleadoConstantesFunciones.SCHEMA+"."+EmpleadoConstantesFunciones.TABLENAME+".id_religion,"+EmpleadoConstantesFunciones.SCHEMA+"."+EmpleadoConstantesFunciones.TABLENAME+".id_estado_civil,"+EmpleadoConstantesFunciones.SCHEMA+"."+EmpleadoConstantesFunciones.TABLENAME+".id_tipo_genero,"+EmpleadoConstantesFunciones.SCHEMA+"."+EmpleadoConstantesFunciones.TABLENAME+".id_tipo_empleado,"+EmpleadoConstantesFunciones.SCHEMA+"."+EmpleadoConstantesFunciones.TABLENAME+".id_tipo_instruccion,"+EmpleadoConstantesFunciones.SCHEMA+"."+EmpleadoConstantesFunciones.TABLENAME+".id_cargo,"+EmpleadoConstantesFunciones.SCHEMA+"."+EmpleadoConstantesFunciones.TABLENAME+".id_estructura,"+EmpleadoConstantesFunciones.SCHEMA+"."+EmpleadoConstantesFunciones.TABLENAME+".id_estructura_seccion,"+EmpleadoConstantesFunciones.SCHEMA+"."+EmpleadoConstantesFunciones.TABLENAME+".id_estado_empleado,"+EmpleadoConstantesFunciones.SCHEMA+"."+EmpleadoConstantesFunciones.TABLENAME+".id_tipo_contrato,"+EmpleadoConstantesFunciones.SCHEMA+"."+EmpleadoConstantesFunciones.TABLENAME+".codigo,"+EmpleadoConstantesFunciones.SCHEMA+"."+EmpleadoConstantesFunciones.TABLENAME+".nombre,"+EmpleadoConstantesFunciones.SCHEMA+"."+EmpleadoConstantesFunciones.TABLENAME+".apellido,"+EmpleadoConstantesFunciones.SCHEMA+"."+EmpleadoConstantesFunciones.TABLENAME+".nombre_completo,"+EmpleadoConstantesFunciones.SCHEMA+"."+EmpleadoConstantesFunciones.TABLENAME+".mail,"+EmpleadoConstantesFunciones.SCHEMA+"."+EmpleadoConstantesFunciones.TABLENAME+".direccion,"+EmpleadoConstantesFunciones.SCHEMA+"."+EmpleadoConstantesFunciones.TABLENAME+".sueldo,"+EmpleadoConstantesFunciones.SCHEMA+"."+EmpleadoConstantesFunciones.TABLENAME+".telefono,"+EmpleadoConstantesFunciones.SCHEMA+"."+EmpleadoConstantesFunciones.TABLENAME+".id_tipo_cuenta_banco_global,"+EmpleadoConstantesFunciones.SCHEMA+"."+EmpleadoConstantesFunciones.TABLENAME+".numero_cuenta,"+EmpleadoConstantesFunciones.SCHEMA+"."+EmpleadoConstantesFunciones.TABLENAME+".tiene_casa,"+EmpleadoConstantesFunciones.SCHEMA+"."+EmpleadoConstantesFunciones.TABLENAME+".tiene_vehiculo from "+EmpleadoConstantesFunciones.SCHEMA+"."+EmpleadoConstantesFunciones.TABLENAME;//+" as "+EmpleadoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected EmpleadoConstantesFuncionesAdditional empleadoConstantesFuncionesAdditional=null;
	
	public EmpleadoConstantesFuncionesAdditional getEmpleadoConstantesFuncionesAdditional() {
		return this.empleadoConstantesFuncionesAdditional;
	}
	
	public void setEmpleadoConstantesFuncionesAdditional(EmpleadoConstantesFuncionesAdditional empleadoConstantesFuncionesAdditional) {
		try {
			this.empleadoConstantesFuncionesAdditional=empleadoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDPAIS= "id_pais";
    public static final String IDPROVINCIA= "id_provincia";
    public static final String IDCIUDAD= "id_ciudad";
    public static final String IDCENTROCOSTO= "id_centro_costo";
    public static final String IDRELIGION= "id_religion";
    public static final String IDESTADOCIVIL= "id_estado_civil";
    public static final String IDTIPOGENERO= "id_tipo_genero";
    public static final String IDTIPOEMPLEADO= "id_tipo_empleado";
    public static final String IDTIPOINSTRUCCION= "id_tipo_instruccion";
    public static final String IDCARGO= "id_cargo";
    public static final String IDESTRUCTURA= "id_estructura";
    public static final String IDESTRUCTURASECCION= "id_estructura_seccion";
    public static final String IDESTADOEMPLEADO= "id_estado_empleado";
    public static final String IDTIPOCONTRATO= "id_tipo_contrato";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String APELLIDO= "apellido";
    public static final String NOMBRECOMPLETO= "nombre_completo";
    public static final String MAIL= "mail";
    public static final String DIRECCION= "direccion";
    public static final String SUELDO= "sueldo";
    public static final String TELEFONO= "telefono";
    public static final String IDTIPOCUENTABANCOGLOBAL= "id_tipo_cuenta_banco_global";
    public static final String NUMEROCUENTA= "numero_cuenta";
    public static final String TIENECASA= "tiene_casa";
    public static final String TIENEVEHICULO= "tiene_vehiculo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDPAIS= "Pais";
		public static final String LABEL_IDPAIS_LOWER= "Pais";
    	public static final String LABEL_IDPROVINCIA= "Provincia";
		public static final String LABEL_IDPROVINCIA_LOWER= "Provincia";
    	public static final String LABEL_IDCIUDAD= "Ciudad";
		public static final String LABEL_IDCIUDAD_LOWER= "Ciudad";
    	public static final String LABEL_IDCENTROCOSTO= "Centro Costo";
		public static final String LABEL_IDCENTROCOSTO_LOWER= "Centro Costo";
    	public static final String LABEL_IDRELIGION= "Religion";
		public static final String LABEL_IDRELIGION_LOWER= "Religion";
    	public static final String LABEL_IDESTADOCIVIL= "Estado Civil";
		public static final String LABEL_IDESTADOCIVIL_LOWER= "Estado Civil";
    	public static final String LABEL_IDTIPOGENERO= "Tipo Genero";
		public static final String LABEL_IDTIPOGENERO_LOWER= "Tipo Genero";
    	public static final String LABEL_IDTIPOEMPLEADO= "Tipo Empleado";
		public static final String LABEL_IDTIPOEMPLEADO_LOWER= "Tipo Empleado";
    	public static final String LABEL_IDTIPOINSTRUCCION= "Tipo Instruccion";
		public static final String LABEL_IDTIPOINSTRUCCION_LOWER= "Tipo Instruccion";
    	public static final String LABEL_IDCARGO= "Cargo";
		public static final String LABEL_IDCARGO_LOWER= "Cargo";
    	public static final String LABEL_IDESTRUCTURA= "Estructura";
		public static final String LABEL_IDESTRUCTURA_LOWER= "Estructura";
    	public static final String LABEL_IDESTRUCTURASECCION= "Estructura Seccion";
		public static final String LABEL_IDESTRUCTURASECCION_LOWER= "Estructura Seccion";
    	public static final String LABEL_IDESTADOEMPLEADO= "Estado Empleado";
		public static final String LABEL_IDESTADOEMPLEADO_LOWER= "Estado Empleado";
    	public static final String LABEL_IDTIPOCONTRATO= "Idtipo Contrato";
		public static final String LABEL_IDTIPOCONTRATO_LOWER= "Tipo Contrato";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_APELLIDO= "Apellido";
		public static final String LABEL_APELLIDO_LOWER= "Apellido";
    	public static final String LABEL_NOMBRECOMPLETO= "Nombre Completo";
		public static final String LABEL_NOMBRECOMPLETO_LOWER= "Nombre Completo";
    	public static final String LABEL_MAIL= "Mail";
		public static final String LABEL_MAIL_LOWER= "Mail";
    	public static final String LABEL_DIRECCION= "Direccion";
		public static final String LABEL_DIRECCION_LOWER= "Direccion";
    	public static final String LABEL_SUELDO= "Sueldo";
		public static final String LABEL_SUELDO_LOWER= "Sueldo";
    	public static final String LABEL_TELEFONO= "Telefono";
		public static final String LABEL_TELEFONO_LOWER= "Telefono";
    	public static final String LABEL_IDTIPOCUENTABANCOGLOBAL= "Tipo Cuenta Banco Global";
		public static final String LABEL_IDTIPOCUENTABANCOGLOBAL_LOWER= "Tipo Cuenta Banco Global";
    	public static final String LABEL_NUMEROCUENTA= "Numero Cuenta";
		public static final String LABEL_NUMEROCUENTA_LOWER= "Numero Cuenta";
    	public static final String LABEL_TIENECASA= "Tiene Casa";
		public static final String LABEL_TIENECASA_LOWER= "Tiene Casa";
    	public static final String LABEL_TIENEVEHICULO= "Tiene Vehiculo";
		public static final String LABEL_TIENEVEHICULO_LOWER= "Tiene Vehiculo";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXAPELLIDO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXAPELLIDO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_COMPLETO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_COMPLETO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXMAIL=ConstantesValidacion.SREGEXCADENA_MAIL;
	public static final String SMENSAJEREGEXMAIL=ConstantesValidacion.SVALIDACIONCADENA_MAIL;	
	public static final String SREGEXDIRECCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDIRECCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXTELEFONO=ConstantesValidacion.SREGEXCADENA_TELEFONO;
	public static final String SMENSAJEREGEXTELEFONO=ConstantesValidacion.SVALIDACIONCADENA_TELEFONO;	
		
	public static final String SREGEXNUMERO_CUENTA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_CUENTA=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	
	public static String getEmpleadoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EmpleadoConstantesFunciones.IDEMPRESA)) {sLabelColumna=EmpleadoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(EmpleadoConstantesFunciones.IDSUCURSAL)) {sLabelColumna=EmpleadoConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(EmpleadoConstantesFunciones.IDPAIS)) {sLabelColumna=EmpleadoConstantesFunciones.LABEL_IDPAIS;}
		if(sNombreColumna.equals(EmpleadoConstantesFunciones.IDPROVINCIA)) {sLabelColumna=EmpleadoConstantesFunciones.LABEL_IDPROVINCIA;}
		if(sNombreColumna.equals(EmpleadoConstantesFunciones.IDCIUDAD)) {sLabelColumna=EmpleadoConstantesFunciones.LABEL_IDCIUDAD;}
		if(sNombreColumna.equals(EmpleadoConstantesFunciones.IDCENTROCOSTO)) {sLabelColumna=EmpleadoConstantesFunciones.LABEL_IDCENTROCOSTO;}
		if(sNombreColumna.equals(EmpleadoConstantesFunciones.IDRELIGION)) {sLabelColumna=EmpleadoConstantesFunciones.LABEL_IDRELIGION;}
		if(sNombreColumna.equals(EmpleadoConstantesFunciones.IDESTADOCIVIL)) {sLabelColumna=EmpleadoConstantesFunciones.LABEL_IDESTADOCIVIL;}
		if(sNombreColumna.equals(EmpleadoConstantesFunciones.IDTIPOGENERO)) {sLabelColumna=EmpleadoConstantesFunciones.LABEL_IDTIPOGENERO;}
		if(sNombreColumna.equals(EmpleadoConstantesFunciones.IDTIPOEMPLEADO)) {sLabelColumna=EmpleadoConstantesFunciones.LABEL_IDTIPOEMPLEADO;}
		if(sNombreColumna.equals(EmpleadoConstantesFunciones.IDTIPOINSTRUCCION)) {sLabelColumna=EmpleadoConstantesFunciones.LABEL_IDTIPOINSTRUCCION;}
		if(sNombreColumna.equals(EmpleadoConstantesFunciones.IDCARGO)) {sLabelColumna=EmpleadoConstantesFunciones.LABEL_IDCARGO;}
		if(sNombreColumna.equals(EmpleadoConstantesFunciones.IDESTRUCTURA)) {sLabelColumna=EmpleadoConstantesFunciones.LABEL_IDESTRUCTURA;}
		if(sNombreColumna.equals(EmpleadoConstantesFunciones.IDESTRUCTURASECCION)) {sLabelColumna=EmpleadoConstantesFunciones.LABEL_IDESTRUCTURASECCION;}
		if(sNombreColumna.equals(EmpleadoConstantesFunciones.IDESTADOEMPLEADO)) {sLabelColumna=EmpleadoConstantesFunciones.LABEL_IDESTADOEMPLEADO;}
		if(sNombreColumna.equals(EmpleadoConstantesFunciones.IDTIPOCONTRATO)) {sLabelColumna=EmpleadoConstantesFunciones.LABEL_IDTIPOCONTRATO;}
		if(sNombreColumna.equals(EmpleadoConstantesFunciones.CODIGO)) {sLabelColumna=EmpleadoConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(EmpleadoConstantesFunciones.NOMBRE)) {sLabelColumna=EmpleadoConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(EmpleadoConstantesFunciones.APELLIDO)) {sLabelColumna=EmpleadoConstantesFunciones.LABEL_APELLIDO;}
		if(sNombreColumna.equals(EmpleadoConstantesFunciones.NOMBRECOMPLETO)) {sLabelColumna=EmpleadoConstantesFunciones.LABEL_NOMBRECOMPLETO;}
		if(sNombreColumna.equals(EmpleadoConstantesFunciones.MAIL)) {sLabelColumna=EmpleadoConstantesFunciones.LABEL_MAIL;}
		if(sNombreColumna.equals(EmpleadoConstantesFunciones.DIRECCION)) {sLabelColumna=EmpleadoConstantesFunciones.LABEL_DIRECCION;}
		if(sNombreColumna.equals(EmpleadoConstantesFunciones.SUELDO)) {sLabelColumna=EmpleadoConstantesFunciones.LABEL_SUELDO;}
		if(sNombreColumna.equals(EmpleadoConstantesFunciones.TELEFONO)) {sLabelColumna=EmpleadoConstantesFunciones.LABEL_TELEFONO;}
		if(sNombreColumna.equals(EmpleadoConstantesFunciones.IDTIPOCUENTABANCOGLOBAL)) {sLabelColumna=EmpleadoConstantesFunciones.LABEL_IDTIPOCUENTABANCOGLOBAL;}
		if(sNombreColumna.equals(EmpleadoConstantesFunciones.NUMEROCUENTA)) {sLabelColumna=EmpleadoConstantesFunciones.LABEL_NUMEROCUENTA;}
		if(sNombreColumna.equals(EmpleadoConstantesFunciones.TIENECASA)) {sLabelColumna=EmpleadoConstantesFunciones.LABEL_TIENECASA;}
		if(sNombreColumna.equals(EmpleadoConstantesFunciones.TIENEVEHICULO)) {sLabelColumna=EmpleadoConstantesFunciones.LABEL_TIENEVEHICULO;}
		
		if(sLabelColumna.equals("")) {
			sLabelColumna=sNombreColumna;	
		}
		return sLabelColumna;
	}
	
	
	
	public static String getNombreEjb_JBoss81(String sAplicacion,String sModule,String sClaseEjb,String sInterfaceEjb) throws Exception {
		String sDescripcion="";

		sDescripcion="ejb:"+sAplicacion+"/"+sModule+"/"+sClaseEjb+"!" + sInterfaceEjb;
		
		return sDescripcion;
	}
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
	public static String gettiene_casaDescripcion(Empleado empleado) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!empleado.gettiene_casa()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String gettiene_casaHtmlDescripcion(Empleado empleado) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(empleado.getId(),empleado.gettiene_casa());

		return sDescripcion;
	}	
		
	public static String gettiene_vehiculoDescripcion(Empleado empleado) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!empleado.gettiene_vehiculo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String gettiene_vehiculoHtmlDescripcion(Empleado empleado) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(empleado.getId(),empleado.gettiene_vehiculo());

		return sDescripcion;
	}	
	
	public static String getEmpleadoDescripcion(Empleado empleado) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(empleado !=null/* && empleado.getId()!=0*/) {
			sDescripcion=empleado.getnombre_completo();//empleadoempleado.getnombre_completo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getEmpleadoDescripcionDetallado(Empleado empleado) {
		String sDescripcion="";
			
		sDescripcion+=EmpleadoConstantesFunciones.ID+"=";
		sDescripcion+=empleado.getId().toString()+",";
		sDescripcion+=EmpleadoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=empleado.getVersionRow().toString()+",";
		sDescripcion+=EmpleadoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=empleado.getid_empresa().toString()+",";
		sDescripcion+=EmpleadoConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=empleado.getid_sucursal().toString()+",";
		sDescripcion+=EmpleadoConstantesFunciones.IDPAIS+"=";
		sDescripcion+=empleado.getid_pais().toString()+",";
		sDescripcion+=EmpleadoConstantesFunciones.IDPROVINCIA+"=";
		sDescripcion+=empleado.getid_provincia().toString()+",";
		sDescripcion+=EmpleadoConstantesFunciones.IDCIUDAD+"=";
		sDescripcion+=empleado.getid_ciudad().toString()+",";
		sDescripcion+=EmpleadoConstantesFunciones.IDCENTROCOSTO+"=";
		sDescripcion+=empleado.getid_centro_costo().toString()+",";
		sDescripcion+=EmpleadoConstantesFunciones.IDRELIGION+"=";
		sDescripcion+=empleado.getid_religion().toString()+",";
		sDescripcion+=EmpleadoConstantesFunciones.IDESTADOCIVIL+"=";
		sDescripcion+=empleado.getid_estado_civil().toString()+",";
		sDescripcion+=EmpleadoConstantesFunciones.IDTIPOGENERO+"=";
		sDescripcion+=empleado.getid_tipo_genero().toString()+",";
		sDescripcion+=EmpleadoConstantesFunciones.IDTIPOEMPLEADO+"=";
		sDescripcion+=empleado.getid_tipo_empleado().toString()+",";
		sDescripcion+=EmpleadoConstantesFunciones.IDTIPOINSTRUCCION+"=";
		sDescripcion+=empleado.getid_tipo_instruccion().toString()+",";
		sDescripcion+=EmpleadoConstantesFunciones.IDCARGO+"=";
		sDescripcion+=empleado.getid_cargo().toString()+",";
		sDescripcion+=EmpleadoConstantesFunciones.IDESTRUCTURA+"=";
		sDescripcion+=empleado.getid_estructura().toString()+",";
		sDescripcion+=EmpleadoConstantesFunciones.IDESTRUCTURASECCION+"=";
		sDescripcion+=empleado.getid_estructura_seccion().toString()+",";
		sDescripcion+=EmpleadoConstantesFunciones.IDESTADOEMPLEADO+"=";
		sDescripcion+=empleado.getid_estado_empleado().toString()+",";
		sDescripcion+=EmpleadoConstantesFunciones.IDTIPOCONTRATO+"=";
		sDescripcion+=empleado.getid_tipo_contrato().toString()+",";
		sDescripcion+=EmpleadoConstantesFunciones.CODIGO+"=";
		sDescripcion+=empleado.getcodigo()+",";
		sDescripcion+=EmpleadoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=empleado.getnombre()+",";
		sDescripcion+=EmpleadoConstantesFunciones.APELLIDO+"=";
		sDescripcion+=empleado.getapellido()+",";
		sDescripcion+=EmpleadoConstantesFunciones.NOMBRECOMPLETO+"=";
		sDescripcion+=empleado.getnombre_completo()+",";
		sDescripcion+=EmpleadoConstantesFunciones.MAIL+"=";
		sDescripcion+=empleado.getmail()+",";
		sDescripcion+=EmpleadoConstantesFunciones.DIRECCION+"=";
		sDescripcion+=empleado.getdireccion()+",";
		sDescripcion+=EmpleadoConstantesFunciones.SUELDO+"=";
		sDescripcion+=empleado.getsueldo().toString()+",";
		sDescripcion+=EmpleadoConstantesFunciones.TELEFONO+"=";
		sDescripcion+=empleado.gettelefono()+",";
		sDescripcion+=EmpleadoConstantesFunciones.IDTIPOCUENTABANCOGLOBAL+"=";
		sDescripcion+=empleado.getid_tipo_cuenta_banco_global().toString()+",";
		sDescripcion+=EmpleadoConstantesFunciones.NUMEROCUENTA+"=";
		sDescripcion+=empleado.getnumero_cuenta()+",";
		sDescripcion+=EmpleadoConstantesFunciones.TIENECASA+"=";
		sDescripcion+=empleado.gettiene_casa().toString()+",";
		sDescripcion+=EmpleadoConstantesFunciones.TIENEVEHICULO+"=";
		sDescripcion+=empleado.gettiene_vehiculo().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setEmpleadoDescripcion(Empleado empleado,String sValor) throws Exception {			
		if(empleado !=null) {
			empleado.setnombre_completo(sValor);;//empleadoempleado.getnombre_completo().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getSucursalDescripcion(Sucursal sucursal) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(sucursal!=null/*&&sucursal.getId()>0*/) {
			sDescripcion=SucursalConstantesFunciones.getSucursalDescripcion(sucursal);
		}

		return sDescripcion;
	}

	public static String getPaisDescripcion(Pais pais) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(pais!=null/*&&pais.getId()>0*/) {
			sDescripcion=PaisConstantesFunciones.getPaisDescripcion(pais);
		}

		return sDescripcion;
	}

	public static String getProvinciaDescripcion(Provincia provincia) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(provincia!=null/*&&provincia.getId()>0*/) {
			sDescripcion=ProvinciaConstantesFunciones.getProvinciaDescripcion(provincia);
		}

		return sDescripcion;
	}

	public static String getCiudadDescripcion(Ciudad ciudad) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(ciudad!=null/*&&ciudad.getId()>0*/) {
			sDescripcion=CiudadConstantesFunciones.getCiudadDescripcion(ciudad);
		}

		return sDescripcion;
	}

	public static String getCentroCostoDescripcion(CentroCosto centrocosto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(centrocosto!=null/*&&centrocosto.getId()>0*/) {
			sDescripcion=CentroCostoConstantesFunciones.getCentroCostoDescripcion(centrocosto);
		}

		return sDescripcion;
	}

	public static String getReligionDescripcion(Religion religion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(religion!=null/*&&religion.getId()>0*/) {
			sDescripcion=ReligionConstantesFunciones.getReligionDescripcion(religion);
		}

		return sDescripcion;
	}

	public static String getEstadoCivilDescripcion(EstadoCivil estadocivil) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estadocivil!=null/*&&estadocivil.getId()>0*/) {
			sDescripcion=EstadoCivilConstantesFunciones.getEstadoCivilDescripcion(estadocivil);
		}

		return sDescripcion;
	}

	public static String getTipoGeneroDescripcion(TipoGenero tipogenero) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipogenero!=null/*&&tipogenero.getId()>0*/) {
			sDescripcion=TipoGeneroConstantesFunciones.getTipoGeneroDescripcion(tipogenero);
		}

		return sDescripcion;
	}

	public static String getTipoEmpleadoDescripcion(TipoEmpleado tipoempleado) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoempleado!=null/*&&tipoempleado.getId()>0*/) {
			sDescripcion=TipoEmpleadoConstantesFunciones.getTipoEmpleadoDescripcion(tipoempleado);
		}

		return sDescripcion;
	}

	public static String getTipoInstruccionDescripcion(TipoInstruccion tipoinstruccion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoinstruccion!=null/*&&tipoinstruccion.getId()>0*/) {
			sDescripcion=TipoInstruccionConstantesFunciones.getTipoInstruccionDescripcion(tipoinstruccion);
		}

		return sDescripcion;
	}

	public static String getCargoDescripcion(Cargo cargo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cargo!=null/*&&cargo.getId()>0*/) {
			sDescripcion=CargoConstantesFunciones.getCargoDescripcion(cargo);
		}

		return sDescripcion;
	}

	public static String getEstructuraDescripcion(Estructura estructura) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estructura!=null/*&&estructura.getId()>0*/) {
			sDescripcion=EstructuraConstantesFunciones.getEstructuraDescripcion(estructura);
		}

		return sDescripcion;
	}

	public static String getEstructuraSeccionDescripcion(Estructura estructura) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estructura!=null/*&&estructura.getId()>0*/) {
			sDescripcion=EstructuraConstantesFunciones.getEstructuraDescripcion(estructura);
		}

		return sDescripcion;
	}

	public static String getEstadoEmpleadoDescripcion(EstadoEmpleado estadoempleado) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estadoempleado!=null/*&&estadoempleado.getId()>0*/) {
			sDescripcion=EstadoEmpleadoConstantesFunciones.getEstadoEmpleadoDescripcion(estadoempleado);
		}

		return sDescripcion;
	}

	public static String getTipoContratoDescripcion(TipoContrato tipocontrato) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipocontrato!=null/*&&tipocontrato.getId()>0*/) {
			sDescripcion=TipoContratoConstantesFunciones.getTipoContratoDescripcion(tipocontrato);
		}

		return sDescripcion;
	}

	public static String getTipoCuentaBancoGlobalDescripcion(TipoCuentaBancoGlobal tipocuentabancoglobal) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipocuentabancoglobal!=null/*&&tipocuentabancoglobal.getId()>0*/) {
			sDescripcion=TipoCuentaBancoGlobalConstantesFunciones.getTipoCuentaBancoGlobalDescripcion(tipocuentabancoglobal);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdCargo")) {
			sNombreIndice="Tipo=  Por Cargo";
		} else if(sNombreIndice.equals("FK_IdCentroCosto")) {
			sNombreIndice="Tipo=  Por Centro Costo";
		} else if(sNombreIndice.equals("FK_IdCiudad")) {
			sNombreIndice="Tipo=  Por Ciudad";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEstadoCivil")) {
			sNombreIndice="Tipo=  Por Estado Civil";
		} else if(sNombreIndice.equals("FK_IdEstadoEmpleado")) {
			sNombreIndice="Tipo=  Por Estado Empleado";
		} else if(sNombreIndice.equals("FK_IdEstructura")) {
			sNombreIndice="Tipo=  Por Estructura";
		} else if(sNombreIndice.equals("FK_IdEstructuraSeccion")) {
			sNombreIndice="Tipo=  Por Estructura Seccion";
		} else if(sNombreIndice.equals("FK_IdPais")) {
			sNombreIndice="Tipo=  Por Pais";
		} else if(sNombreIndice.equals("FK_IdProvincia")) {
			sNombreIndice="Tipo=  Por Provincia";
		} else if(sNombreIndice.equals("FK_IdReligion")) {
			sNombreIndice="Tipo=  Por Religion";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoContrato")) {
			sNombreIndice="Tipo=  Por Idtipo Contrato";
		} else if(sNombreIndice.equals("FK_IdTipoCuentaBancoGlobal")) {
			sNombreIndice="Tipo=  Por Tipo Cuenta Banco Global";
		} else if(sNombreIndice.equals("FK_IdTipoEmpleado")) {
			sNombreIndice="Tipo=  Por Tipo Empleado";
		} else if(sNombreIndice.equals("FK_IdTipoGenero")) {
			sNombreIndice="Tipo=  Por Tipo Genero";
		} else if(sNombreIndice.equals("FK_IdTipoInstruccion")) {
			sNombreIndice="Tipo=  Por Tipo Instruccion";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdCargo(Long id_cargo) {
		String sDetalleIndice=" Parametros->";
		if(id_cargo!=null) {sDetalleIndice+=" Codigo Unico De Cargo="+id_cargo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCentroCosto(Long id_centro_costo) {
		String sDetalleIndice=" Parametros->";
		if(id_centro_costo!=null) {sDetalleIndice+=" Codigo Unico De Centro Costo="+id_centro_costo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCiudad(Long id_ciudad) {
		String sDetalleIndice=" Parametros->";
		if(id_ciudad!=null) {sDetalleIndice+=" Codigo Unico De Ciudad="+id_ciudad.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEstadoCivil(Long id_estado_civil) {
		String sDetalleIndice=" Parametros->";
		if(id_estado_civil!=null) {sDetalleIndice+=" Codigo Unico De Estado Civil="+id_estado_civil.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEstadoEmpleado(Long id_estado_empleado) {
		String sDetalleIndice=" Parametros->";
		if(id_estado_empleado!=null) {sDetalleIndice+=" Codigo Unico De Estado Empleado="+id_estado_empleado.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEstructura(Long id_estructura) {
		String sDetalleIndice=" Parametros->";
		if(id_estructura!=null) {sDetalleIndice+=" Codigo Unico De Estructura="+id_estructura.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEstructuraSeccion(Long id_estructura_seccion) {
		String sDetalleIndice=" Parametros->";
		if(id_estructura_seccion!=null) {sDetalleIndice+=" Codigo Unico De Estructura Seccion="+id_estructura_seccion.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPais(Long id_pais) {
		String sDetalleIndice=" Parametros->";
		if(id_pais!=null) {sDetalleIndice+=" Codigo Unico De Pais="+id_pais.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdProvincia(Long id_provincia) {
		String sDetalleIndice=" Parametros->";
		if(id_provincia!=null) {sDetalleIndice+=" Codigo Unico De Provincia="+id_provincia.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdReligion(Long id_religion) {
		String sDetalleIndice=" Parametros->";
		if(id_religion!=null) {sDetalleIndice+=" Codigo Unico De Religion="+id_religion.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoContrato(Long id_tipo_contrato) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_contrato!=null) {sDetalleIndice+=" Codigo Unico De Idtipo Contrato="+id_tipo_contrato.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoCuentaBancoGlobal(Long id_tipo_cuenta_banco_global) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_cuenta_banco_global!=null) {sDetalleIndice+=" Codigo Unico De Tipo Cuenta Banco Global="+id_tipo_cuenta_banco_global.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoEmpleado(Long id_tipo_empleado) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_empleado!=null) {sDetalleIndice+=" Codigo Unico De Tipo Empleado="+id_tipo_empleado.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoGenero(Long id_tipo_genero) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_genero!=null) {sDetalleIndice+=" Codigo Unico De Tipo Genero="+id_tipo_genero.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoInstruccion(Long id_tipo_instruccion) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_instruccion!=null) {sDetalleIndice+=" Codigo Unico De Tipo Instruccion="+id_tipo_instruccion.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosEmpleado(Empleado empleado,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		empleado.setcodigo(empleado.getcodigo().trim());
		empleado.setnombre(empleado.getnombre().trim());
		empleado.setapellido(empleado.getapellido().trim());
		empleado.setnombre_completo(empleado.getnombre_completo().trim());
		empleado.setmail(empleado.getmail().trim());
		empleado.setdireccion(empleado.getdireccion().trim());
		empleado.settelefono(empleado.gettelefono().trim());
		empleado.setnumero_cuenta(empleado.getnumero_cuenta().trim());
	}
	
	public static void quitarEspaciosEmpleados(List<Empleado> empleados,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Empleado empleado: empleados) {
			empleado.setcodigo(empleado.getcodigo().trim());
			empleado.setnombre(empleado.getnombre().trim());
			empleado.setapellido(empleado.getapellido().trim());
			empleado.setnombre_completo(empleado.getnombre_completo().trim());
			empleado.setmail(empleado.getmail().trim());
			empleado.setdireccion(empleado.getdireccion().trim());
			empleado.settelefono(empleado.gettelefono().trim());
			empleado.setnumero_cuenta(empleado.getnumero_cuenta().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEmpleado(Empleado empleado,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && empleado.getConCambioAuxiliar()) {
			empleado.setIsDeleted(empleado.getIsDeletedAuxiliar());	
			empleado.setIsNew(empleado.getIsNewAuxiliar());	
			empleado.setIsChanged(empleado.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			empleado.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			empleado.setIsDeletedAuxiliar(false);	
			empleado.setIsNewAuxiliar(false);	
			empleado.setIsChangedAuxiliar(false);
			
			empleado.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEmpleados(List<Empleado> empleados,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Empleado empleado : empleados) {
			if(conAsignarBase && empleado.getConCambioAuxiliar()) {
				empleado.setIsDeleted(empleado.getIsDeletedAuxiliar());	
				empleado.setIsNew(empleado.getIsNewAuxiliar());	
				empleado.setIsChanged(empleado.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				empleado.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				empleado.setIsDeletedAuxiliar(false);	
				empleado.setIsNewAuxiliar(false);	
				empleado.setIsChangedAuxiliar(false);
				
				empleado.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEmpleado(Empleado empleado,Boolean conEnteros) throws Exception  {
		empleado.setsueldo(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresEmpleados(List<Empleado> empleados,Boolean conEnteros) throws Exception  {
		
		for(Empleado empleado: empleados) {
			empleado.setsueldo(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaEmpleado(List<Empleado> empleados,Empleado empleadoAux) throws Exception  {
		EmpleadoConstantesFunciones.InicializarValoresEmpleado(empleadoAux,true);
		
		for(Empleado empleado: empleados) {
			if(empleado.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			empleadoAux.setsueldo(empleadoAux.getsueldo()+empleado.getsueldo());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEmpleado(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EmpleadoConstantesFunciones.getArrayColumnasGlobalesEmpleado(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEmpleado(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(EmpleadoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(EmpleadoConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(EmpleadoConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(EmpleadoConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEmpleado(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Empleado> empleados,Empleado empleado,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Empleado empleadoAux: empleados) {
			if(empleadoAux!=null && empleado!=null) {
				if((empleadoAux.getId()==null && empleado.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(empleadoAux.getId()!=null && empleado.getId()!=null){
					if(empleadoAux.getId().equals(empleado.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEmpleado(List<Empleado> empleados) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double sueldoTotal=0.0;
	
		for(Empleado empleado: empleados) {			
			if(empleado.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			sueldoTotal+=empleado.getsueldo();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(EmpleadoConstantesFunciones.SUELDO);
		datoGeneral.setsDescripcion(EmpleadoConstantesFunciones.LABEL_SUELDO);
		datoGeneral.setdValorDouble(sueldoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEmpleado() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EmpleadoConstantesFunciones.LABEL_ID, EmpleadoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoConstantesFunciones.LABEL_VERSIONROW, EmpleadoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoConstantesFunciones.LABEL_IDEMPRESA, EmpleadoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoConstantesFunciones.LABEL_IDSUCURSAL, EmpleadoConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoConstantesFunciones.LABEL_IDPAIS, EmpleadoConstantesFunciones.IDPAIS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoConstantesFunciones.LABEL_IDPROVINCIA, EmpleadoConstantesFunciones.IDPROVINCIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoConstantesFunciones.LABEL_IDCIUDAD, EmpleadoConstantesFunciones.IDCIUDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoConstantesFunciones.LABEL_IDCENTROCOSTO, EmpleadoConstantesFunciones.IDCENTROCOSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoConstantesFunciones.LABEL_IDRELIGION, EmpleadoConstantesFunciones.IDRELIGION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoConstantesFunciones.LABEL_IDESTADOCIVIL, EmpleadoConstantesFunciones.IDESTADOCIVIL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoConstantesFunciones.LABEL_IDTIPOGENERO, EmpleadoConstantesFunciones.IDTIPOGENERO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoConstantesFunciones.LABEL_IDTIPOEMPLEADO, EmpleadoConstantesFunciones.IDTIPOEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoConstantesFunciones.LABEL_IDTIPOINSTRUCCION, EmpleadoConstantesFunciones.IDTIPOINSTRUCCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoConstantesFunciones.LABEL_IDCARGO, EmpleadoConstantesFunciones.IDCARGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoConstantesFunciones.LABEL_IDESTRUCTURA, EmpleadoConstantesFunciones.IDESTRUCTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoConstantesFunciones.LABEL_IDESTRUCTURASECCION, EmpleadoConstantesFunciones.IDESTRUCTURASECCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoConstantesFunciones.LABEL_IDESTADOEMPLEADO, EmpleadoConstantesFunciones.IDESTADOEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoConstantesFunciones.LABEL_IDTIPOCONTRATO, EmpleadoConstantesFunciones.IDTIPOCONTRATO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoConstantesFunciones.LABEL_CODIGO, EmpleadoConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoConstantesFunciones.LABEL_NOMBRE, EmpleadoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoConstantesFunciones.LABEL_APELLIDO, EmpleadoConstantesFunciones.APELLIDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoConstantesFunciones.LABEL_NOMBRECOMPLETO, EmpleadoConstantesFunciones.NOMBRECOMPLETO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoConstantesFunciones.LABEL_MAIL, EmpleadoConstantesFunciones.MAIL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoConstantesFunciones.LABEL_DIRECCION, EmpleadoConstantesFunciones.DIRECCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoConstantesFunciones.LABEL_SUELDO, EmpleadoConstantesFunciones.SUELDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoConstantesFunciones.LABEL_TELEFONO, EmpleadoConstantesFunciones.TELEFONO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoConstantesFunciones.LABEL_IDTIPOCUENTABANCOGLOBAL, EmpleadoConstantesFunciones.IDTIPOCUENTABANCOGLOBAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoConstantesFunciones.LABEL_NUMEROCUENTA, EmpleadoConstantesFunciones.NUMEROCUENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoConstantesFunciones.LABEL_TIENECASA, EmpleadoConstantesFunciones.TIENECASA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoConstantesFunciones.LABEL_TIENEVEHICULO, EmpleadoConstantesFunciones.TIENEVEHICULO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEmpleado() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EmpleadoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoConstantesFunciones.IDPAIS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoConstantesFunciones.IDPROVINCIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoConstantesFunciones.IDCIUDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoConstantesFunciones.IDCENTROCOSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoConstantesFunciones.IDRELIGION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoConstantesFunciones.IDESTADOCIVIL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoConstantesFunciones.IDTIPOGENERO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoConstantesFunciones.IDTIPOEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoConstantesFunciones.IDTIPOINSTRUCCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoConstantesFunciones.IDCARGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoConstantesFunciones.IDESTRUCTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoConstantesFunciones.IDESTRUCTURASECCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoConstantesFunciones.IDESTADOEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoConstantesFunciones.IDTIPOCONTRATO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoConstantesFunciones.APELLIDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoConstantesFunciones.NOMBRECOMPLETO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoConstantesFunciones.MAIL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoConstantesFunciones.DIRECCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoConstantesFunciones.SUELDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoConstantesFunciones.TELEFONO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoConstantesFunciones.IDTIPOCUENTABANCOGLOBAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoConstantesFunciones.NUMEROCUENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoConstantesFunciones.TIENECASA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoConstantesFunciones.TIENEVEHICULO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEmpleado() throws Exception  {
		return EmpleadoConstantesFunciones.getTiposSeleccionarEmpleado(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEmpleado(Boolean conFk) throws Exception  {
		return EmpleadoConstantesFunciones.getTiposSeleccionarEmpleado(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEmpleado(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(EmpleadoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(EmpleadoConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoConstantesFunciones.LABEL_IDPAIS);
			reporte.setsDescripcion(EmpleadoConstantesFunciones.LABEL_IDPAIS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoConstantesFunciones.LABEL_IDPROVINCIA);
			reporte.setsDescripcion(EmpleadoConstantesFunciones.LABEL_IDPROVINCIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoConstantesFunciones.LABEL_IDCIUDAD);
			reporte.setsDescripcion(EmpleadoConstantesFunciones.LABEL_IDCIUDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoConstantesFunciones.LABEL_IDCENTROCOSTO);
			reporte.setsDescripcion(EmpleadoConstantesFunciones.LABEL_IDCENTROCOSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoConstantesFunciones.LABEL_IDRELIGION);
			reporte.setsDescripcion(EmpleadoConstantesFunciones.LABEL_IDRELIGION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoConstantesFunciones.LABEL_IDESTADOCIVIL);
			reporte.setsDescripcion(EmpleadoConstantesFunciones.LABEL_IDESTADOCIVIL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoConstantesFunciones.LABEL_IDTIPOGENERO);
			reporte.setsDescripcion(EmpleadoConstantesFunciones.LABEL_IDTIPOGENERO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoConstantesFunciones.LABEL_IDTIPOEMPLEADO);
			reporte.setsDescripcion(EmpleadoConstantesFunciones.LABEL_IDTIPOEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoConstantesFunciones.LABEL_IDTIPOINSTRUCCION);
			reporte.setsDescripcion(EmpleadoConstantesFunciones.LABEL_IDTIPOINSTRUCCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoConstantesFunciones.LABEL_IDCARGO);
			reporte.setsDescripcion(EmpleadoConstantesFunciones.LABEL_IDCARGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoConstantesFunciones.LABEL_IDESTRUCTURA);
			reporte.setsDescripcion(EmpleadoConstantesFunciones.LABEL_IDESTRUCTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoConstantesFunciones.LABEL_IDESTRUCTURASECCION);
			reporte.setsDescripcion(EmpleadoConstantesFunciones.LABEL_IDESTRUCTURASECCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoConstantesFunciones.LABEL_IDESTADOEMPLEADO);
			reporte.setsDescripcion(EmpleadoConstantesFunciones.LABEL_IDESTADOEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoConstantesFunciones.LABEL_IDTIPOCONTRATO);
			reporte.setsDescripcion(EmpleadoConstantesFunciones.LABEL_IDTIPOCONTRATO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(EmpleadoConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(EmpleadoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoConstantesFunciones.LABEL_APELLIDO);
			reporte.setsDescripcion(EmpleadoConstantesFunciones.LABEL_APELLIDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoConstantesFunciones.LABEL_NOMBRECOMPLETO);
			reporte.setsDescripcion(EmpleadoConstantesFunciones.LABEL_NOMBRECOMPLETO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoConstantesFunciones.LABEL_MAIL);
			reporte.setsDescripcion(EmpleadoConstantesFunciones.LABEL_MAIL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoConstantesFunciones.LABEL_DIRECCION);
			reporte.setsDescripcion(EmpleadoConstantesFunciones.LABEL_DIRECCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoConstantesFunciones.LABEL_SUELDO);
			reporte.setsDescripcion(EmpleadoConstantesFunciones.LABEL_SUELDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoConstantesFunciones.LABEL_TELEFONO);
			reporte.setsDescripcion(EmpleadoConstantesFunciones.LABEL_TELEFONO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoConstantesFunciones.LABEL_IDTIPOCUENTABANCOGLOBAL);
			reporte.setsDescripcion(EmpleadoConstantesFunciones.LABEL_IDTIPOCUENTABANCOGLOBAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoConstantesFunciones.LABEL_NUMEROCUENTA);
			reporte.setsDescripcion(EmpleadoConstantesFunciones.LABEL_NUMEROCUENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoConstantesFunciones.LABEL_TIENECASA);
			reporte.setsDescripcion(EmpleadoConstantesFunciones.LABEL_TIENECASA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoConstantesFunciones.LABEL_TIENEVEHICULO);
			reporte.setsDescripcion(EmpleadoConstantesFunciones.LABEL_TIENEVEHICULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEmpleado(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEmpleado(Empleado empleadoAux) throws Exception {
		
			empleadoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(empleadoAux.getEmpresa()));
			empleadoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(empleadoAux.getSucursal()));
			empleadoAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(empleadoAux.getPais()));
			empleadoAux.setprovincia_descripcion(ProvinciaConstantesFunciones.getProvinciaDescripcion(empleadoAux.getProvincia()));
			empleadoAux.setciudad_descripcion(CiudadConstantesFunciones.getCiudadDescripcion(empleadoAux.getCiudad()));
			empleadoAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(empleadoAux.getCentroCosto()));
			empleadoAux.setreligion_descripcion(ReligionConstantesFunciones.getReligionDescripcion(empleadoAux.getReligion()));
			empleadoAux.setestadocivil_descripcion(EstadoCivilConstantesFunciones.getEstadoCivilDescripcion(empleadoAux.getEstadoCivil()));
			empleadoAux.settipogenero_descripcion(TipoGeneroConstantesFunciones.getTipoGeneroDescripcion(empleadoAux.getTipoGenero()));
			empleadoAux.settipoempleado_descripcion(TipoEmpleadoConstantesFunciones.getTipoEmpleadoDescripcion(empleadoAux.getTipoEmpleado()));
			empleadoAux.settipoinstruccion_descripcion(TipoInstruccionConstantesFunciones.getTipoInstruccionDescripcion(empleadoAux.getTipoInstruccion()));
			empleadoAux.setcargo_descripcion(CargoConstantesFunciones.getCargoDescripcion(empleadoAux.getCargo()));
			empleadoAux.setestructura_descripcion(EstructuraConstantesFunciones.getEstructuraDescripcion(empleadoAux.getEstructura()));
			empleadoAux.setestructuraseccion_descripcion(EstructuraConstantesFunciones.getEstructuraDescripcion(empleadoAux.getEstructuraSeccion()));
			empleadoAux.setestadoempleado_descripcion(EstadoEmpleadoConstantesFunciones.getEstadoEmpleadoDescripcion(empleadoAux.getEstadoEmpleado()));
			empleadoAux.settipocontrato_descripcion(TipoContratoConstantesFunciones.getTipoContratoDescripcion(empleadoAux.getTipoContrato()));
			empleadoAux.settipocuentabancoglobal_descripcion(TipoCuentaBancoGlobalConstantesFunciones.getTipoCuentaBancoGlobalDescripcion(empleadoAux.getTipoCuentaBancoGlobal()));		
	}
	
	public static void refrescarForeignKeysDescripcionesEmpleado(List<Empleado> empleadosTemp) throws Exception {
		for(Empleado empleadoAux:empleadosTemp) {
			
			empleadoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(empleadoAux.getEmpresa()));
			empleadoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(empleadoAux.getSucursal()));
			empleadoAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(empleadoAux.getPais()));
			empleadoAux.setprovincia_descripcion(ProvinciaConstantesFunciones.getProvinciaDescripcion(empleadoAux.getProvincia()));
			empleadoAux.setciudad_descripcion(CiudadConstantesFunciones.getCiudadDescripcion(empleadoAux.getCiudad()));
			empleadoAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(empleadoAux.getCentroCosto()));
			empleadoAux.setreligion_descripcion(ReligionConstantesFunciones.getReligionDescripcion(empleadoAux.getReligion()));
			empleadoAux.setestadocivil_descripcion(EstadoCivilConstantesFunciones.getEstadoCivilDescripcion(empleadoAux.getEstadoCivil()));
			empleadoAux.settipogenero_descripcion(TipoGeneroConstantesFunciones.getTipoGeneroDescripcion(empleadoAux.getTipoGenero()));
			empleadoAux.settipoempleado_descripcion(TipoEmpleadoConstantesFunciones.getTipoEmpleadoDescripcion(empleadoAux.getTipoEmpleado()));
			empleadoAux.settipoinstruccion_descripcion(TipoInstruccionConstantesFunciones.getTipoInstruccionDescripcion(empleadoAux.getTipoInstruccion()));
			empleadoAux.setcargo_descripcion(CargoConstantesFunciones.getCargoDescripcion(empleadoAux.getCargo()));
			empleadoAux.setestructura_descripcion(EstructuraConstantesFunciones.getEstructuraDescripcion(empleadoAux.getEstructura()));
			empleadoAux.setestructuraseccion_descripcion(EstructuraConstantesFunciones.getEstructuraDescripcion(empleadoAux.getEstructuraSeccion()));
			empleadoAux.setestadoempleado_descripcion(EstadoEmpleadoConstantesFunciones.getEstadoEmpleadoDescripcion(empleadoAux.getEstadoEmpleado()));
			empleadoAux.settipocontrato_descripcion(TipoContratoConstantesFunciones.getTipoContratoDescripcion(empleadoAux.getTipoContrato()));
			empleadoAux.settipocuentabancoglobal_descripcion(TipoCuentaBancoGlobalConstantesFunciones.getTipoCuentaBancoGlobalDescripcion(empleadoAux.getTipoCuentaBancoGlobal()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Pais.class));
				classes.add(new Classe(Provincia.class));
				classes.add(new Classe(Ciudad.class));
				classes.add(new Classe(CentroCosto.class));
				classes.add(new Classe(Religion.class));
				classes.add(new Classe(EstadoCivil.class));
				classes.add(new Classe(TipoGenero.class));
				classes.add(new Classe(TipoEmpleado.class));
				classes.add(new Classe(TipoInstruccion.class));
				classes.add(new Classe(Cargo.class));
				classes.add(new Classe(Estructura.class));
				classes.add(new Classe(Estructura.class));
				classes.add(new Classe(EstadoEmpleado.class));
				classes.add(new Classe(TipoContrato.class));
				classes.add(new Classe(TipoCuentaBancoGlobal.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Sucursal.class)) {
						classes.add(new Classe(Sucursal.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Pais.class)) {
						classes.add(new Classe(Pais.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Provincia.class)) {
						classes.add(new Classe(Provincia.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Ciudad.class)) {
						classes.add(new Classe(Ciudad.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CentroCosto.class)) {
						classes.add(new Classe(CentroCosto.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Religion.class)) {
						classes.add(new Classe(Religion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EstadoCivil.class)) {
						classes.add(new Classe(EstadoCivil.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoGenero.class)) {
						classes.add(new Classe(TipoGenero.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoEmpleado.class)) {
						classes.add(new Classe(TipoEmpleado.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoInstruccion.class)) {
						classes.add(new Classe(TipoInstruccion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Cargo.class)) {
						classes.add(new Classe(Cargo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Estructura.class)) {
						classes.add(new Classe(Estructura.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Estructura.class)) {
						classes.add(new Classe(Estructura.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EstadoEmpleado.class)) {
						classes.add(new Classe(EstadoEmpleado.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoContrato.class)) {
						classes.add(new Classe(TipoContrato.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoCuentaBancoGlobal.class)) {
						classes.add(new Classe(TipoCuentaBancoGlobal.class));
					}
				}

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEmpleado(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
					}

					if(Provincia.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Provincia.class)); continue;
					}

					if(Ciudad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ciudad.class)); continue;
					}

					if(CentroCosto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroCosto.class)); continue;
					}

					if(Religion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Religion.class)); continue;
					}

					if(EstadoCivil.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoCivil.class)); continue;
					}

					if(TipoGenero.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoGenero.class)); continue;
					}

					if(TipoEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoEmpleado.class)); continue;
					}

					if(TipoInstruccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoInstruccion.class)); continue;
					}

					if(Cargo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cargo.class)); continue;
					}

					if(Estructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Estructura.class)); continue;
					}

					if(Estructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Estructura.class)); continue;
					}

					if(EstadoEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoEmpleado.class)); continue;
					}

					if(TipoContrato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoContrato.class)); continue;
					}

					if(TipoCuentaBancoGlobal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCuentaBancoGlobal.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
					}

					if(Provincia.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Provincia.class)); continue;
					}

					if(Ciudad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ciudad.class)); continue;
					}

					if(CentroCosto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroCosto.class)); continue;
					}

					if(Religion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Religion.class)); continue;
					}

					if(EstadoCivil.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoCivil.class)); continue;
					}

					if(TipoGenero.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoGenero.class)); continue;
					}

					if(TipoEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoEmpleado.class)); continue;
					}

					if(TipoInstruccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoInstruccion.class)); continue;
					}

					if(Cargo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cargo.class)); continue;
					}

					if(Estructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Estructura.class)); continue;
					}

					if(Estructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Estructura.class)); continue;
					}

					if(EstadoEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoEmpleado.class)); continue;
					}

					if(TipoContrato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoContrato.class)); continue;
					}

					if(TipoCuentaBancoGlobal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCuentaBancoGlobal.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EmpleadoConstantesFunciones.getClassesRelationshipsOfEmpleado(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(CargaFamiliar_NM.class));
				classes.add(new Classe(Curso.class));
				classes.add(new Classe(Prestamo.class));
				classes.add(new Classe(EmpleadoIdioma.class));
				classes.add(new Classe(HistorialPagoMesNomi.class));
				classes.add(new Classe(EmpleadoImpuestoRenta.class));
				classes.add(new Classe(DatoGeneralEmpleado.class));
				classes.add(new Classe(Area.class));
				classes.add(new Classe(GastoEmpleado.class));
				classes.add(new Classe(EmpleadoHobby.class));
				classes.add(new Classe(EmpleadoEMail.class));
				classes.add(new Classe(RasgoPersonal.class));
				classes.add(new Classe(Referencia.class));
				classes.add(new Classe(Telefono_NM.class));
				classes.add(new Classe(Novedad.class));
				classes.add(new Classe(EmpleadoHerra.class));
				classes.add(new Classe(EmpleadoEnfer.class));
				classes.add(new Classe(Visa.class));
				classes.add(new Classe(Seguro.class));
				classes.add(new Classe(AsistenciaMensual.class));
				classes.add(new Classe(EmpleadoDisca.class));
				classes.add(new Classe(ProfesionEmplea.class));
				classes.add(new Classe(RubroEmpleado.class));
				classes.add(new Classe(EmpleadoConstante.class));
				classes.add(new Classe(TallaVestido.class));
				classes.add(new Classe(NovedadNomi.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(CargaFamiliar_NM.class)) {
						classes.add(new Classe(CargaFamiliar_NM.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Curso.class)) {
						classes.add(new Classe(Curso.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Prestamo.class)) {
						classes.add(new Classe(Prestamo.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EmpleadoIdioma.class)) {
						classes.add(new Classe(EmpleadoIdioma.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(HistorialPagoMesNomi.class)) {
						classes.add(new Classe(HistorialPagoMesNomi.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EmpleadoImpuestoRenta.class)) {
						classes.add(new Classe(EmpleadoImpuestoRenta.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(DatoGeneralEmpleado.class)) {
						classes.add(new Classe(DatoGeneralEmpleado.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Area.class)) {
						classes.add(new Classe(Area.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(GastoEmpleado.class)) {
						classes.add(new Classe(GastoEmpleado.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EmpleadoHobby.class)) {
						classes.add(new Classe(EmpleadoHobby.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EmpleadoEMail.class)) {
						classes.add(new Classe(EmpleadoEMail.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(RasgoPersonal.class)) {
						classes.add(new Classe(RasgoPersonal.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Referencia.class)) {
						classes.add(new Classe(Referencia.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Telefono_NM.class)) {
						classes.add(new Classe(Telefono_NM.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Novedad.class)) {
						classes.add(new Classe(Novedad.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EmpleadoHerra.class)) {
						classes.add(new Classe(EmpleadoHerra.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EmpleadoEnfer.class)) {
						classes.add(new Classe(EmpleadoEnfer.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Visa.class)) {
						classes.add(new Classe(Visa.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Seguro.class)) {
						classes.add(new Classe(Seguro.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(AsistenciaMensual.class)) {
						classes.add(new Classe(AsistenciaMensual.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EmpleadoDisca.class)) {
						classes.add(new Classe(EmpleadoDisca.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ProfesionEmplea.class)) {
						classes.add(new Classe(ProfesionEmplea.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(RubroEmpleado.class)) {
						classes.add(new Classe(RubroEmpleado.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EmpleadoConstante.class)) {
						classes.add(new Classe(EmpleadoConstante.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TallaVestido.class)) {
						classes.add(new Classe(TallaVestido.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(NovedadNomi.class)) {
						classes.add(new Classe(NovedadNomi.class)); break;
					}
				}

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEmpleado(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EmpleadoConstantesFunciones.getClassesRelationshipsFromStringsOfEmpleado(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEmpleado(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(CargaFamiliar_NM.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CargaFamiliar_NM.class)); continue;
					}

					if(Curso.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Curso.class)); continue;
					}

					if(Prestamo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Prestamo.class)); continue;
					}

					if(EmpleadoIdioma.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EmpleadoIdioma.class)); continue;
					}

					if(HistorialPagoMesNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(HistorialPagoMesNomi.class)); continue;
					}

					if(EmpleadoImpuestoRenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EmpleadoImpuestoRenta.class)); continue;
					}

					if(DatoGeneralEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DatoGeneralEmpleado.class)); continue;
					}

					if(Area.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Area.class)); continue;
					}

					if(GastoEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(GastoEmpleado.class)); continue;
					}

					if(EmpleadoHobby.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EmpleadoHobby.class)); continue;
					}

					if(EmpleadoEMail.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EmpleadoEMail.class)); continue;
					}

					if(RasgoPersonal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(RasgoPersonal.class)); continue;
					}

					if(Referencia.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Referencia.class)); continue;
					}

					if(Telefono_NM.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Telefono_NM.class)); continue;
					}

					if(Novedad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Novedad.class)); continue;
					}

					if(EmpleadoHerra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EmpleadoHerra.class)); continue;
					}

					if(EmpleadoEnfer.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EmpleadoEnfer.class)); continue;
					}

					if(Visa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Visa.class)); continue;
					}

					if(Seguro.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Seguro.class)); continue;
					}

					if(AsistenciaMensual.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AsistenciaMensual.class)); continue;
					}

					if(EmpleadoDisca.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EmpleadoDisca.class)); continue;
					}

					if(ProfesionEmplea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProfesionEmplea.class)); continue;
					}

					if(RubroEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(RubroEmpleado.class)); continue;
					}

					if(EmpleadoConstante.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EmpleadoConstante.class)); continue;
					}

					if(TallaVestido.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TallaVestido.class)); continue;
					}

					if(NovedadNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NovedadNomi.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(CargaFamiliar_NM.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CargaFamiliar_NM.class)); continue;
					}

					if(Curso.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Curso.class)); continue;
					}

					if(Prestamo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Prestamo.class)); continue;
					}

					if(EmpleadoIdioma.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EmpleadoIdioma.class)); continue;
					}

					if(HistorialPagoMesNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(HistorialPagoMesNomi.class)); continue;
					}

					if(EmpleadoImpuestoRenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EmpleadoImpuestoRenta.class)); continue;
					}

					if(DatoGeneralEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DatoGeneralEmpleado.class)); continue;
					}

					if(Area.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Area.class)); continue;
					}

					if(GastoEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(GastoEmpleado.class)); continue;
					}

					if(EmpleadoHobby.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EmpleadoHobby.class)); continue;
					}

					if(EmpleadoEMail.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EmpleadoEMail.class)); continue;
					}

					if(RasgoPersonal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(RasgoPersonal.class)); continue;
					}

					if(Referencia.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Referencia.class)); continue;
					}

					if(Telefono_NM.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Telefono_NM.class)); continue;
					}

					if(Novedad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Novedad.class)); continue;
					}

					if(EmpleadoHerra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EmpleadoHerra.class)); continue;
					}

					if(EmpleadoEnfer.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EmpleadoEnfer.class)); continue;
					}

					if(Visa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Visa.class)); continue;
					}

					if(Seguro.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Seguro.class)); continue;
					}

					if(AsistenciaMensual.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AsistenciaMensual.class)); continue;
					}

					if(EmpleadoDisca.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EmpleadoDisca.class)); continue;
					}

					if(ProfesionEmplea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProfesionEmplea.class)); continue;
					}

					if(RubroEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(RubroEmpleado.class)); continue;
					}

					if(EmpleadoConstante.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EmpleadoConstante.class)); continue;
					}

					if(TallaVestido.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TallaVestido.class)); continue;
					}

					if(NovedadNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NovedadNomi.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}		
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(Empleado empleado,List<Empleado> empleados,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Empleado empleadoEncontrado=null;
			
			for(Empleado empleadoLocal:empleados) {
				if(empleadoLocal.getId().equals(empleado.getId())) {
					empleadoEncontrado=empleadoLocal;
					
					empleadoLocal.setIsChanged(empleado.getIsChanged());
					empleadoLocal.setIsNew(empleado.getIsNew());
					empleadoLocal.setIsDeleted(empleado.getIsDeleted());
					
					empleadoLocal.setGeneralEntityOriginal(empleado.getGeneralEntityOriginal());
					
					empleadoLocal.setId(empleado.getId());	
					empleadoLocal.setVersionRow(empleado.getVersionRow());	
					empleadoLocal.setid_empresa(empleado.getid_empresa());	
					empleadoLocal.setid_sucursal(empleado.getid_sucursal());	
					empleadoLocal.setid_pais(empleado.getid_pais());	
					empleadoLocal.setid_provincia(empleado.getid_provincia());	
					empleadoLocal.setid_ciudad(empleado.getid_ciudad());	
					empleadoLocal.setid_centro_costo(empleado.getid_centro_costo());	
					empleadoLocal.setid_religion(empleado.getid_religion());	
					empleadoLocal.setid_estado_civil(empleado.getid_estado_civil());	
					empleadoLocal.setid_tipo_genero(empleado.getid_tipo_genero());	
					empleadoLocal.setid_tipo_empleado(empleado.getid_tipo_empleado());	
					empleadoLocal.setid_tipo_instruccion(empleado.getid_tipo_instruccion());	
					empleadoLocal.setid_cargo(empleado.getid_cargo());	
					empleadoLocal.setid_estructura(empleado.getid_estructura());	
					empleadoLocal.setid_estructura_seccion(empleado.getid_estructura_seccion());	
					empleadoLocal.setid_estado_empleado(empleado.getid_estado_empleado());	
					empleadoLocal.setid_tipo_contrato(empleado.getid_tipo_contrato());	
					empleadoLocal.setcodigo(empleado.getcodigo());	
					empleadoLocal.setnombre(empleado.getnombre());	
					empleadoLocal.setapellido(empleado.getapellido());	
					empleadoLocal.setnombre_completo(empleado.getnombre_completo());	
					empleadoLocal.setmail(empleado.getmail());	
					empleadoLocal.setdireccion(empleado.getdireccion());	
					empleadoLocal.setsueldo(empleado.getsueldo());	
					empleadoLocal.settelefono(empleado.gettelefono());	
					empleadoLocal.setid_tipo_cuenta_banco_global(empleado.getid_tipo_cuenta_banco_global());	
					empleadoLocal.setnumero_cuenta(empleado.getnumero_cuenta());	
					empleadoLocal.settiene_casa(empleado.gettiene_casa());	
					empleadoLocal.settiene_vehiculo(empleado.gettiene_vehiculo());	
					
					
					empleadoLocal.setCargaFamiliar_NMs(empleado.getCargaFamiliar_NMs());
					empleadoLocal.setCursos(empleado.getCursos());
					empleadoLocal.setPrestamos(empleado.getPrestamos());
					empleadoLocal.setEmpleadoIdiomas(empleado.getEmpleadoIdiomas());
					empleadoLocal.setHistorialPagoMesNomis(empleado.getHistorialPagoMesNomis());
					empleadoLocal.setEmpleadoImpuestoRentas(empleado.getEmpleadoImpuestoRentas());
					empleadoLocal.setDatoGeneralEmpleado(empleado.getDatoGeneralEmpleado());
					empleadoLocal.setAreas(empleado.getAreas());
					empleadoLocal.setGastoEmpleados(empleado.getGastoEmpleados());
					empleadoLocal.setEmpleadoHobbys(empleado.getEmpleadoHobbys());
					empleadoLocal.setEmpleadoEMails(empleado.getEmpleadoEMails());
					empleadoLocal.setRasgoPersonals(empleado.getRasgoPersonals());
					empleadoLocal.setReferencias(empleado.getReferencias());
					empleadoLocal.setTelefono_NMs(empleado.getTelefono_NMs());
					empleadoLocal.setNovedads(empleado.getNovedads());
					empleadoLocal.setEmpleadoHerras(empleado.getEmpleadoHerras());
					empleadoLocal.setEmpleadoEnfers(empleado.getEmpleadoEnfers());
					empleadoLocal.setVisas(empleado.getVisas());
					empleadoLocal.setSeguros(empleado.getSeguros());
					empleadoLocal.setAsistenciaMensuals(empleado.getAsistenciaMensuals());
					empleadoLocal.setEmpleadoDiscas(empleado.getEmpleadoDiscas());
					empleadoLocal.setProfesionEmpleas(empleado.getProfesionEmpleas());
					empleadoLocal.setRubroEmpleados(empleado.getRubroEmpleados());
					empleadoLocal.setEmpleadoConstantes(empleado.getEmpleadoConstantes());
					empleadoLocal.setTallaVestidos(empleado.getTallaVestidos());
					empleadoLocal.setNovedadNomis(empleado.getNovedadNomis());
					
					existe=true;
					break;
				}
			}
			
			if(!empleado.getIsDeleted()) {
				if(!existe) {
					empleados.add(empleado);
				}
			} else {
				if(empleadoEncontrado!=null && permiteQuitar)  {
					empleados.remove(empleadoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Empleado empleado,List<Empleado> empleados) throws Exception {
		try	{			
			for(Empleado empleadoLocal:empleados) {
				if(empleadoLocal.getId().equals(empleado.getId())) {
					empleadoLocal.setIsSelected(empleado.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEmpleado(List<Empleado> empleadosAux) throws Exception {
		//this.empleadosAux=empleadosAux;
		
		for(Empleado empleadoAux:empleadosAux) {
			if(empleadoAux.getIsChanged()) {
				empleadoAux.setIsChanged(false);
			}		
			
			if(empleadoAux.getIsNew()) {
				empleadoAux.setIsNew(false);
			}	
			
			if(empleadoAux.getIsDeleted()) {
				empleadoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEmpleado(Empleado empleadoAux) throws Exception {
		//this.empleadoAux=empleadoAux;
		
			if(empleadoAux.getIsChanged()) {
				empleadoAux.setIsChanged(false);
			}		
			
			if(empleadoAux.getIsNew()) {
				empleadoAux.setIsNew(false);
			}	
			
			if(empleadoAux.getIsDeleted()) {
				empleadoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Empleado empleadoAsignar,Empleado empleado) throws Exception {
		empleadoAsignar.setId(empleado.getId());	
		empleadoAsignar.setVersionRow(empleado.getVersionRow());	
		empleadoAsignar.setid_empresa(empleado.getid_empresa());
		empleadoAsignar.setempresa_descripcion(empleado.getempresa_descripcion());	
		empleadoAsignar.setid_sucursal(empleado.getid_sucursal());
		empleadoAsignar.setsucursal_descripcion(empleado.getsucursal_descripcion());	
		empleadoAsignar.setid_pais(empleado.getid_pais());
		empleadoAsignar.setpais_descripcion(empleado.getpais_descripcion());	
		empleadoAsignar.setid_provincia(empleado.getid_provincia());
		empleadoAsignar.setprovincia_descripcion(empleado.getprovincia_descripcion());	
		empleadoAsignar.setid_ciudad(empleado.getid_ciudad());
		empleadoAsignar.setciudad_descripcion(empleado.getciudad_descripcion());	
		empleadoAsignar.setid_centro_costo(empleado.getid_centro_costo());
		empleadoAsignar.setcentrocosto_descripcion(empleado.getcentrocosto_descripcion());	
		empleadoAsignar.setid_religion(empleado.getid_religion());
		empleadoAsignar.setreligion_descripcion(empleado.getreligion_descripcion());	
		empleadoAsignar.setid_estado_civil(empleado.getid_estado_civil());
		empleadoAsignar.setestadocivil_descripcion(empleado.getestadocivil_descripcion());	
		empleadoAsignar.setid_tipo_genero(empleado.getid_tipo_genero());
		empleadoAsignar.settipogenero_descripcion(empleado.gettipogenero_descripcion());	
		empleadoAsignar.setid_tipo_empleado(empleado.getid_tipo_empleado());
		empleadoAsignar.settipoempleado_descripcion(empleado.gettipoempleado_descripcion());	
		empleadoAsignar.setid_tipo_instruccion(empleado.getid_tipo_instruccion());
		empleadoAsignar.settipoinstruccion_descripcion(empleado.gettipoinstruccion_descripcion());	
		empleadoAsignar.setid_cargo(empleado.getid_cargo());
		empleadoAsignar.setcargo_descripcion(empleado.getcargo_descripcion());	
		empleadoAsignar.setid_estructura(empleado.getid_estructura());
		empleadoAsignar.setestructura_descripcion(empleado.getestructura_descripcion());	
		empleadoAsignar.setid_estructura_seccion(empleado.getid_estructura_seccion());
		empleadoAsignar.setestructuraseccion_descripcion(empleado.getestructuraseccion_descripcion());	
		empleadoAsignar.setid_estado_empleado(empleado.getid_estado_empleado());
		empleadoAsignar.setestadoempleado_descripcion(empleado.getestadoempleado_descripcion());	
		empleadoAsignar.setid_tipo_contrato(empleado.getid_tipo_contrato());
		empleadoAsignar.settipocontrato_descripcion(empleado.gettipocontrato_descripcion());	
		empleadoAsignar.setcodigo(empleado.getcodigo());	
		empleadoAsignar.setnombre(empleado.getnombre());	
		empleadoAsignar.setapellido(empleado.getapellido());	
		empleadoAsignar.setnombre_completo(empleado.getnombre_completo());	
		empleadoAsignar.setmail(empleado.getmail());	
		empleadoAsignar.setdireccion(empleado.getdireccion());	
		empleadoAsignar.setsueldo(empleado.getsueldo());	
		empleadoAsignar.settelefono(empleado.gettelefono());	
		empleadoAsignar.setid_tipo_cuenta_banco_global(empleado.getid_tipo_cuenta_banco_global());
		empleadoAsignar.settipocuentabancoglobal_descripcion(empleado.gettipocuentabancoglobal_descripcion());	
		empleadoAsignar.setnumero_cuenta(empleado.getnumero_cuenta());	
		empleadoAsignar.settiene_casa(empleado.gettiene_casa());	
		empleadoAsignar.settiene_vehiculo(empleado.gettiene_vehiculo());	
	}
	
	public static void inicializarEmpleado(Empleado empleado) throws Exception {
		try {
				empleado.setId(0L);	
					
				empleado.setid_empresa(-1L);	
				empleado.setid_sucursal(-1L);	
				empleado.setid_pais(-1L);	
				empleado.setid_provincia(-1L);	
				empleado.setid_ciudad(-1L);	
				empleado.setid_centro_costo(null);	
				empleado.setid_religion(-1L);	
				empleado.setid_estado_civil(-1L);	
				empleado.setid_tipo_genero(-1L);	
				empleado.setid_tipo_empleado(-1L);	
				empleado.setid_tipo_instruccion(-1L);	
				empleado.setid_cargo(-1L);	
				empleado.setid_estructura(-1L);	
				empleado.setid_estructura_seccion(-1L);	
				empleado.setid_estado_empleado(-1L);	
				empleado.setid_tipo_contrato(-1L);	
				empleado.setcodigo("");	
				empleado.setnombre("");	
				empleado.setapellido("");	
				empleado.setnombre_completo("");	
				empleado.setmail("");	
				empleado.setdireccion("");	
				empleado.setsueldo(0.0);	
				empleado.settelefono("");	
				empleado.setid_tipo_cuenta_banco_global(-1L);	
				empleado.setnumero_cuenta("");	
				empleado.settiene_casa(false);	
				empleado.settiene_vehiculo(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEmpleado(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoConstantesFunciones.LABEL_IDPAIS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoConstantesFunciones.LABEL_IDPROVINCIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoConstantesFunciones.LABEL_IDCIUDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoConstantesFunciones.LABEL_IDCENTROCOSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoConstantesFunciones.LABEL_IDRELIGION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoConstantesFunciones.LABEL_IDESTADOCIVIL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoConstantesFunciones.LABEL_IDTIPOGENERO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoConstantesFunciones.LABEL_IDTIPOEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoConstantesFunciones.LABEL_IDTIPOINSTRUCCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoConstantesFunciones.LABEL_IDCARGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoConstantesFunciones.LABEL_IDESTRUCTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoConstantesFunciones.LABEL_IDESTRUCTURASECCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoConstantesFunciones.LABEL_IDESTADOEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoConstantesFunciones.LABEL_IDTIPOCONTRATO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoConstantesFunciones.LABEL_APELLIDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoConstantesFunciones.LABEL_NOMBRECOMPLETO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoConstantesFunciones.LABEL_MAIL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoConstantesFunciones.LABEL_DIRECCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoConstantesFunciones.LABEL_SUELDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoConstantesFunciones.LABEL_TELEFONO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoConstantesFunciones.LABEL_IDTIPOCUENTABANCOGLOBAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoConstantesFunciones.LABEL_NUMEROCUENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoConstantesFunciones.LABEL_TIENECASA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoConstantesFunciones.LABEL_TIENEVEHICULO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEmpleado(String sTipo,Row row,Workbook workbook,Empleado empleado,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(empleado.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleado.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleado.getpais_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleado.getprovincia_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleado.getciudad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleado.getcentrocosto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleado.getreligion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleado.getestadocivil_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleado.gettipogenero_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleado.gettipoempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleado.gettipoinstruccion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleado.getcargo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleado.getestructura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleado.getestructuraseccion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleado.getestadoempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleado.gettipocontrato_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleado.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleado.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleado.getapellido());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleado.getnombre_completo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleado.getmail());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleado.getdireccion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleado.getsueldo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleado.gettelefono());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleado.gettipocuentabancoglobal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleado.getnumero_cuenta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(empleado.gettiene_casa()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(empleado.gettiene_vehiculo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEmpleado=Constantes.SFINALQUERY;
	
	public String getsFinalQueryEmpleado() {
		return this.sFinalQueryEmpleado;
	}
	
	public void setsFinalQueryEmpleado(String sFinalQueryEmpleado) {
		this.sFinalQueryEmpleado= sFinalQueryEmpleado;
	}
	
	public Border resaltarSeleccionarEmpleado=null;
	
	public Border setResaltarSeleccionarEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoBeanSwingJInternalFrame empleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//empleadoBeanSwingJInternalFrame.jTtoolBarEmpleado.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEmpleado= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEmpleado() {
		return this.resaltarSeleccionarEmpleado;
	}
	
	public void setResaltarSeleccionarEmpleado(Border borderResaltarSeleccionarEmpleado) {
		this.resaltarSeleccionarEmpleado= borderResaltarSeleccionarEmpleado;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEmpleado=null;
	public Boolean mostraridEmpleado=true;
	public Boolean activaridEmpleado=true;

	public Border resaltarid_empresaEmpleado=null;
	public Boolean mostrarid_empresaEmpleado=true;
	public Boolean activarid_empresaEmpleado=true;
	public Boolean cargarid_empresaEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaEmpleado=false;//ConEventDepend=true

	public Border resaltarid_sucursalEmpleado=null;
	public Boolean mostrarid_sucursalEmpleado=true;
	public Boolean activarid_sucursalEmpleado=true;
	public Boolean cargarid_sucursalEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalEmpleado=false;//ConEventDepend=true

	public Border resaltarid_paisEmpleado=null;
	public Boolean mostrarid_paisEmpleado=true;
	public Boolean activarid_paisEmpleado=true;
	public Boolean cargarid_paisEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_paisEmpleado=false;//ConEventDepend=true

	public Border resaltarid_provinciaEmpleado=null;
	public Boolean mostrarid_provinciaEmpleado=true;
	public Boolean activarid_provinciaEmpleado=true;
	public Boolean cargarid_provinciaEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_provinciaEmpleado=false;//ConEventDepend=true

	public Border resaltarid_ciudadEmpleado=null;
	public Boolean mostrarid_ciudadEmpleado=true;
	public Boolean activarid_ciudadEmpleado=true;
	public Boolean cargarid_ciudadEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ciudadEmpleado=true;//ConEventDepend=true

	public Border resaltarid_centro_costoEmpleado=null;
	public Boolean mostrarid_centro_costoEmpleado=true;
	public Boolean activarid_centro_costoEmpleado=true;
	public Boolean cargarid_centro_costoEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_centro_costoEmpleado=false;//ConEventDepend=true

	public Border resaltarid_religionEmpleado=null;
	public Boolean mostrarid_religionEmpleado=true;
	public Boolean activarid_religionEmpleado=true;
	public Boolean cargarid_religionEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_religionEmpleado=false;//ConEventDepend=true

	public Border resaltarid_estado_civilEmpleado=null;
	public Boolean mostrarid_estado_civilEmpleado=true;
	public Boolean activarid_estado_civilEmpleado=true;
	public Boolean cargarid_estado_civilEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_civilEmpleado=false;//ConEventDepend=true

	public Border resaltarid_tipo_generoEmpleado=null;
	public Boolean mostrarid_tipo_generoEmpleado=true;
	public Boolean activarid_tipo_generoEmpleado=true;
	public Boolean cargarid_tipo_generoEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_generoEmpleado=false;//ConEventDepend=true

	public Border resaltarid_tipo_empleadoEmpleado=null;
	public Boolean mostrarid_tipo_empleadoEmpleado=true;
	public Boolean activarid_tipo_empleadoEmpleado=true;
	public Boolean cargarid_tipo_empleadoEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_empleadoEmpleado=false;//ConEventDepend=true

	public Border resaltarid_tipo_instruccionEmpleado=null;
	public Boolean mostrarid_tipo_instruccionEmpleado=true;
	public Boolean activarid_tipo_instruccionEmpleado=true;
	public Boolean cargarid_tipo_instruccionEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_instruccionEmpleado=false;//ConEventDepend=true

	public Border resaltarid_cargoEmpleado=null;
	public Boolean mostrarid_cargoEmpleado=true;
	public Boolean activarid_cargoEmpleado=true;
	public Boolean cargarid_cargoEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cargoEmpleado=false;//ConEventDepend=true

	public Border resaltarid_estructuraEmpleado=null;
	public Boolean mostrarid_estructuraEmpleado=true;
	public Boolean activarid_estructuraEmpleado=true;
	public Boolean cargarid_estructuraEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estructuraEmpleado=false;//ConEventDepend=true

	public Border resaltarid_estructura_seccionEmpleado=null;
	public Boolean mostrarid_estructura_seccionEmpleado=true;
	public Boolean activarid_estructura_seccionEmpleado=true;
	public Boolean cargarid_estructura_seccionEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estructura_seccionEmpleado=false;//ConEventDepend=true

	public Border resaltarid_estado_empleadoEmpleado=null;
	public Boolean mostrarid_estado_empleadoEmpleado=true;
	public Boolean activarid_estado_empleadoEmpleado=true;
	public Boolean cargarid_estado_empleadoEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_empleadoEmpleado=false;//ConEventDepend=true

	public Border resaltarid_tipo_contratoEmpleado=null;
	public Boolean mostrarid_tipo_contratoEmpleado=true;
	public Boolean activarid_tipo_contratoEmpleado=true;
	public Boolean cargarid_tipo_contratoEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_contratoEmpleado=false;//ConEventDepend=true

	public Border resaltarcodigoEmpleado=null;
	public Boolean mostrarcodigoEmpleado=true;
	public Boolean activarcodigoEmpleado=true;

	public Border resaltarnombreEmpleado=null;
	public Boolean mostrarnombreEmpleado=true;
	public Boolean activarnombreEmpleado=true;

	public Border resaltarapellidoEmpleado=null;
	public Boolean mostrarapellidoEmpleado=true;
	public Boolean activarapellidoEmpleado=true;

	public Border resaltarnombre_completoEmpleado=null;
	public Boolean mostrarnombre_completoEmpleado=true;
	public Boolean activarnombre_completoEmpleado=true;

	public Border resaltarmailEmpleado=null;
	public Boolean mostrarmailEmpleado=true;
	public Boolean activarmailEmpleado=true;

	public Border resaltardireccionEmpleado=null;
	public Boolean mostrardireccionEmpleado=true;
	public Boolean activardireccionEmpleado=true;

	public Border resaltarsueldoEmpleado=null;
	public Boolean mostrarsueldoEmpleado=true;
	public Boolean activarsueldoEmpleado=true;

	public Border resaltartelefonoEmpleado=null;
	public Boolean mostrartelefonoEmpleado=true;
	public Boolean activartelefonoEmpleado=true;

	public Border resaltarid_tipo_cuenta_banco_globalEmpleado=null;
	public Boolean mostrarid_tipo_cuenta_banco_globalEmpleado=true;
	public Boolean activarid_tipo_cuenta_banco_globalEmpleado=true;
	public Boolean cargarid_tipo_cuenta_banco_globalEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_cuenta_banco_globalEmpleado=false;//ConEventDepend=true

	public Border resaltarnumero_cuentaEmpleado=null;
	public Boolean mostrarnumero_cuentaEmpleado=true;
	public Boolean activarnumero_cuentaEmpleado=true;

	public Border resaltartiene_casaEmpleado=null;
	public Boolean mostrartiene_casaEmpleado=true;
	public Boolean activartiene_casaEmpleado=true;

	public Border resaltartiene_vehiculoEmpleado=null;
	public Boolean mostrartiene_vehiculoEmpleado=true;
	public Boolean activartiene_vehiculoEmpleado=true;

	
	

	public Border setResaltaridEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoBeanSwingJInternalFrame empleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoBeanSwingJInternalFrame.jTtoolBarEmpleado.setBorder(borderResaltar);
		
		this.resaltaridEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEmpleado() {
		return this.resaltaridEmpleado;
	}

	public void setResaltaridEmpleado(Border borderResaltar) {
		this.resaltaridEmpleado= borderResaltar;
	}

	public Boolean getMostraridEmpleado() {
		return this.mostraridEmpleado;
	}

	public void setMostraridEmpleado(Boolean mostraridEmpleado) {
		this.mostraridEmpleado= mostraridEmpleado;
	}

	public Boolean getActivaridEmpleado() {
		return this.activaridEmpleado;
	}

	public void setActivaridEmpleado(Boolean activaridEmpleado) {
		this.activaridEmpleado= activaridEmpleado;
	}

	public Border setResaltarid_empresaEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoBeanSwingJInternalFrame empleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoBeanSwingJInternalFrame.jTtoolBarEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_empresaEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaEmpleado() {
		return this.resaltarid_empresaEmpleado;
	}

	public void setResaltarid_empresaEmpleado(Border borderResaltar) {
		this.resaltarid_empresaEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_empresaEmpleado() {
		return this.mostrarid_empresaEmpleado;
	}

	public void setMostrarid_empresaEmpleado(Boolean mostrarid_empresaEmpleado) {
		this.mostrarid_empresaEmpleado= mostrarid_empresaEmpleado;
	}

	public Boolean getActivarid_empresaEmpleado() {
		return this.activarid_empresaEmpleado;
	}

	public void setActivarid_empresaEmpleado(Boolean activarid_empresaEmpleado) {
		this.activarid_empresaEmpleado= activarid_empresaEmpleado;
	}

	public Boolean getCargarid_empresaEmpleado() {
		return this.cargarid_empresaEmpleado;
	}

	public void setCargarid_empresaEmpleado(Boolean cargarid_empresaEmpleado) {
		this.cargarid_empresaEmpleado= cargarid_empresaEmpleado;
	}

	public Border setResaltarid_sucursalEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoBeanSwingJInternalFrame empleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoBeanSwingJInternalFrame.jTtoolBarEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_sucursalEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalEmpleado() {
		return this.resaltarid_sucursalEmpleado;
	}

	public void setResaltarid_sucursalEmpleado(Border borderResaltar) {
		this.resaltarid_sucursalEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_sucursalEmpleado() {
		return this.mostrarid_sucursalEmpleado;
	}

	public void setMostrarid_sucursalEmpleado(Boolean mostrarid_sucursalEmpleado) {
		this.mostrarid_sucursalEmpleado= mostrarid_sucursalEmpleado;
	}

	public Boolean getActivarid_sucursalEmpleado() {
		return this.activarid_sucursalEmpleado;
	}

	public void setActivarid_sucursalEmpleado(Boolean activarid_sucursalEmpleado) {
		this.activarid_sucursalEmpleado= activarid_sucursalEmpleado;
	}

	public Boolean getCargarid_sucursalEmpleado() {
		return this.cargarid_sucursalEmpleado;
	}

	public void setCargarid_sucursalEmpleado(Boolean cargarid_sucursalEmpleado) {
		this.cargarid_sucursalEmpleado= cargarid_sucursalEmpleado;
	}

	public Border setResaltarid_paisEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoBeanSwingJInternalFrame empleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoBeanSwingJInternalFrame.jTtoolBarEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_paisEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_paisEmpleado() {
		return this.resaltarid_paisEmpleado;
	}

	public void setResaltarid_paisEmpleado(Border borderResaltar) {
		this.resaltarid_paisEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_paisEmpleado() {
		return this.mostrarid_paisEmpleado;
	}

	public void setMostrarid_paisEmpleado(Boolean mostrarid_paisEmpleado) {
		this.mostrarid_paisEmpleado= mostrarid_paisEmpleado;
	}

	public Boolean getActivarid_paisEmpleado() {
		return this.activarid_paisEmpleado;
	}

	public void setActivarid_paisEmpleado(Boolean activarid_paisEmpleado) {
		this.activarid_paisEmpleado= activarid_paisEmpleado;
	}

	public Boolean getCargarid_paisEmpleado() {
		return this.cargarid_paisEmpleado;
	}

	public void setCargarid_paisEmpleado(Boolean cargarid_paisEmpleado) {
		this.cargarid_paisEmpleado= cargarid_paisEmpleado;
	}

	public Border setResaltarid_provinciaEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoBeanSwingJInternalFrame empleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoBeanSwingJInternalFrame.jTtoolBarEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_provinciaEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_provinciaEmpleado() {
		return this.resaltarid_provinciaEmpleado;
	}

	public void setResaltarid_provinciaEmpleado(Border borderResaltar) {
		this.resaltarid_provinciaEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_provinciaEmpleado() {
		return this.mostrarid_provinciaEmpleado;
	}

	public void setMostrarid_provinciaEmpleado(Boolean mostrarid_provinciaEmpleado) {
		this.mostrarid_provinciaEmpleado= mostrarid_provinciaEmpleado;
	}

	public Boolean getActivarid_provinciaEmpleado() {
		return this.activarid_provinciaEmpleado;
	}

	public void setActivarid_provinciaEmpleado(Boolean activarid_provinciaEmpleado) {
		this.activarid_provinciaEmpleado= activarid_provinciaEmpleado;
	}

	public Boolean getCargarid_provinciaEmpleado() {
		return this.cargarid_provinciaEmpleado;
	}

	public void setCargarid_provinciaEmpleado(Boolean cargarid_provinciaEmpleado) {
		this.cargarid_provinciaEmpleado= cargarid_provinciaEmpleado;
	}

	public Border setResaltarid_ciudadEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoBeanSwingJInternalFrame empleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoBeanSwingJInternalFrame.jTtoolBarEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_ciudadEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ciudadEmpleado() {
		return this.resaltarid_ciudadEmpleado;
	}

	public void setResaltarid_ciudadEmpleado(Border borderResaltar) {
		this.resaltarid_ciudadEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_ciudadEmpleado() {
		return this.mostrarid_ciudadEmpleado;
	}

	public void setMostrarid_ciudadEmpleado(Boolean mostrarid_ciudadEmpleado) {
		this.mostrarid_ciudadEmpleado= mostrarid_ciudadEmpleado;
	}

	public Boolean getActivarid_ciudadEmpleado() {
		return this.activarid_ciudadEmpleado;
	}

	public void setActivarid_ciudadEmpleado(Boolean activarid_ciudadEmpleado) {
		this.activarid_ciudadEmpleado= activarid_ciudadEmpleado;
	}

	public Boolean getCargarid_ciudadEmpleado() {
		return this.cargarid_ciudadEmpleado;
	}

	public void setCargarid_ciudadEmpleado(Boolean cargarid_ciudadEmpleado) {
		this.cargarid_ciudadEmpleado= cargarid_ciudadEmpleado;
	}

	public Border setResaltarid_centro_costoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoBeanSwingJInternalFrame empleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoBeanSwingJInternalFrame.jTtoolBarEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_centro_costoEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_centro_costoEmpleado() {
		return this.resaltarid_centro_costoEmpleado;
	}

	public void setResaltarid_centro_costoEmpleado(Border borderResaltar) {
		this.resaltarid_centro_costoEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_centro_costoEmpleado() {
		return this.mostrarid_centro_costoEmpleado;
	}

	public void setMostrarid_centro_costoEmpleado(Boolean mostrarid_centro_costoEmpleado) {
		this.mostrarid_centro_costoEmpleado= mostrarid_centro_costoEmpleado;
	}

	public Boolean getActivarid_centro_costoEmpleado() {
		return this.activarid_centro_costoEmpleado;
	}

	public void setActivarid_centro_costoEmpleado(Boolean activarid_centro_costoEmpleado) {
		this.activarid_centro_costoEmpleado= activarid_centro_costoEmpleado;
	}

	public Boolean getCargarid_centro_costoEmpleado() {
		return this.cargarid_centro_costoEmpleado;
	}

	public void setCargarid_centro_costoEmpleado(Boolean cargarid_centro_costoEmpleado) {
		this.cargarid_centro_costoEmpleado= cargarid_centro_costoEmpleado;
	}

	public Border setResaltarid_religionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoBeanSwingJInternalFrame empleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoBeanSwingJInternalFrame.jTtoolBarEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_religionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_religionEmpleado() {
		return this.resaltarid_religionEmpleado;
	}

	public void setResaltarid_religionEmpleado(Border borderResaltar) {
		this.resaltarid_religionEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_religionEmpleado() {
		return this.mostrarid_religionEmpleado;
	}

	public void setMostrarid_religionEmpleado(Boolean mostrarid_religionEmpleado) {
		this.mostrarid_religionEmpleado= mostrarid_religionEmpleado;
	}

	public Boolean getActivarid_religionEmpleado() {
		return this.activarid_religionEmpleado;
	}

	public void setActivarid_religionEmpleado(Boolean activarid_religionEmpleado) {
		this.activarid_religionEmpleado= activarid_religionEmpleado;
	}

	public Boolean getCargarid_religionEmpleado() {
		return this.cargarid_religionEmpleado;
	}

	public void setCargarid_religionEmpleado(Boolean cargarid_religionEmpleado) {
		this.cargarid_religionEmpleado= cargarid_religionEmpleado;
	}

	public Border setResaltarid_estado_civilEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoBeanSwingJInternalFrame empleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoBeanSwingJInternalFrame.jTtoolBarEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_estado_civilEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_civilEmpleado() {
		return this.resaltarid_estado_civilEmpleado;
	}

	public void setResaltarid_estado_civilEmpleado(Border borderResaltar) {
		this.resaltarid_estado_civilEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_estado_civilEmpleado() {
		return this.mostrarid_estado_civilEmpleado;
	}

	public void setMostrarid_estado_civilEmpleado(Boolean mostrarid_estado_civilEmpleado) {
		this.mostrarid_estado_civilEmpleado= mostrarid_estado_civilEmpleado;
	}

	public Boolean getActivarid_estado_civilEmpleado() {
		return this.activarid_estado_civilEmpleado;
	}

	public void setActivarid_estado_civilEmpleado(Boolean activarid_estado_civilEmpleado) {
		this.activarid_estado_civilEmpleado= activarid_estado_civilEmpleado;
	}

	public Boolean getCargarid_estado_civilEmpleado() {
		return this.cargarid_estado_civilEmpleado;
	}

	public void setCargarid_estado_civilEmpleado(Boolean cargarid_estado_civilEmpleado) {
		this.cargarid_estado_civilEmpleado= cargarid_estado_civilEmpleado;
	}

	public Border setResaltarid_tipo_generoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoBeanSwingJInternalFrame empleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoBeanSwingJInternalFrame.jTtoolBarEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_tipo_generoEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_generoEmpleado() {
		return this.resaltarid_tipo_generoEmpleado;
	}

	public void setResaltarid_tipo_generoEmpleado(Border borderResaltar) {
		this.resaltarid_tipo_generoEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_tipo_generoEmpleado() {
		return this.mostrarid_tipo_generoEmpleado;
	}

	public void setMostrarid_tipo_generoEmpleado(Boolean mostrarid_tipo_generoEmpleado) {
		this.mostrarid_tipo_generoEmpleado= mostrarid_tipo_generoEmpleado;
	}

	public Boolean getActivarid_tipo_generoEmpleado() {
		return this.activarid_tipo_generoEmpleado;
	}

	public void setActivarid_tipo_generoEmpleado(Boolean activarid_tipo_generoEmpleado) {
		this.activarid_tipo_generoEmpleado= activarid_tipo_generoEmpleado;
	}

	public Boolean getCargarid_tipo_generoEmpleado() {
		return this.cargarid_tipo_generoEmpleado;
	}

	public void setCargarid_tipo_generoEmpleado(Boolean cargarid_tipo_generoEmpleado) {
		this.cargarid_tipo_generoEmpleado= cargarid_tipo_generoEmpleado;
	}

	public Border setResaltarid_tipo_empleadoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoBeanSwingJInternalFrame empleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoBeanSwingJInternalFrame.jTtoolBarEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_tipo_empleadoEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_empleadoEmpleado() {
		return this.resaltarid_tipo_empleadoEmpleado;
	}

	public void setResaltarid_tipo_empleadoEmpleado(Border borderResaltar) {
		this.resaltarid_tipo_empleadoEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_tipo_empleadoEmpleado() {
		return this.mostrarid_tipo_empleadoEmpleado;
	}

	public void setMostrarid_tipo_empleadoEmpleado(Boolean mostrarid_tipo_empleadoEmpleado) {
		this.mostrarid_tipo_empleadoEmpleado= mostrarid_tipo_empleadoEmpleado;
	}

	public Boolean getActivarid_tipo_empleadoEmpleado() {
		return this.activarid_tipo_empleadoEmpleado;
	}

	public void setActivarid_tipo_empleadoEmpleado(Boolean activarid_tipo_empleadoEmpleado) {
		this.activarid_tipo_empleadoEmpleado= activarid_tipo_empleadoEmpleado;
	}

	public Boolean getCargarid_tipo_empleadoEmpleado() {
		return this.cargarid_tipo_empleadoEmpleado;
	}

	public void setCargarid_tipo_empleadoEmpleado(Boolean cargarid_tipo_empleadoEmpleado) {
		this.cargarid_tipo_empleadoEmpleado= cargarid_tipo_empleadoEmpleado;
	}

	public Border setResaltarid_tipo_instruccionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoBeanSwingJInternalFrame empleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoBeanSwingJInternalFrame.jTtoolBarEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_tipo_instruccionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_instruccionEmpleado() {
		return this.resaltarid_tipo_instruccionEmpleado;
	}

	public void setResaltarid_tipo_instruccionEmpleado(Border borderResaltar) {
		this.resaltarid_tipo_instruccionEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_tipo_instruccionEmpleado() {
		return this.mostrarid_tipo_instruccionEmpleado;
	}

	public void setMostrarid_tipo_instruccionEmpleado(Boolean mostrarid_tipo_instruccionEmpleado) {
		this.mostrarid_tipo_instruccionEmpleado= mostrarid_tipo_instruccionEmpleado;
	}

	public Boolean getActivarid_tipo_instruccionEmpleado() {
		return this.activarid_tipo_instruccionEmpleado;
	}

	public void setActivarid_tipo_instruccionEmpleado(Boolean activarid_tipo_instruccionEmpleado) {
		this.activarid_tipo_instruccionEmpleado= activarid_tipo_instruccionEmpleado;
	}

	public Boolean getCargarid_tipo_instruccionEmpleado() {
		return this.cargarid_tipo_instruccionEmpleado;
	}

	public void setCargarid_tipo_instruccionEmpleado(Boolean cargarid_tipo_instruccionEmpleado) {
		this.cargarid_tipo_instruccionEmpleado= cargarid_tipo_instruccionEmpleado;
	}

	public Border setResaltarid_cargoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoBeanSwingJInternalFrame empleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoBeanSwingJInternalFrame.jTtoolBarEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_cargoEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cargoEmpleado() {
		return this.resaltarid_cargoEmpleado;
	}

	public void setResaltarid_cargoEmpleado(Border borderResaltar) {
		this.resaltarid_cargoEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_cargoEmpleado() {
		return this.mostrarid_cargoEmpleado;
	}

	public void setMostrarid_cargoEmpleado(Boolean mostrarid_cargoEmpleado) {
		this.mostrarid_cargoEmpleado= mostrarid_cargoEmpleado;
	}

	public Boolean getActivarid_cargoEmpleado() {
		return this.activarid_cargoEmpleado;
	}

	public void setActivarid_cargoEmpleado(Boolean activarid_cargoEmpleado) {
		this.activarid_cargoEmpleado= activarid_cargoEmpleado;
	}

	public Boolean getCargarid_cargoEmpleado() {
		return this.cargarid_cargoEmpleado;
	}

	public void setCargarid_cargoEmpleado(Boolean cargarid_cargoEmpleado) {
		this.cargarid_cargoEmpleado= cargarid_cargoEmpleado;
	}

	public Border setResaltarid_estructuraEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoBeanSwingJInternalFrame empleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoBeanSwingJInternalFrame.jTtoolBarEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_estructuraEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estructuraEmpleado() {
		return this.resaltarid_estructuraEmpleado;
	}

	public void setResaltarid_estructuraEmpleado(Border borderResaltar) {
		this.resaltarid_estructuraEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_estructuraEmpleado() {
		return this.mostrarid_estructuraEmpleado;
	}

	public void setMostrarid_estructuraEmpleado(Boolean mostrarid_estructuraEmpleado) {
		this.mostrarid_estructuraEmpleado= mostrarid_estructuraEmpleado;
	}

	public Boolean getActivarid_estructuraEmpleado() {
		return this.activarid_estructuraEmpleado;
	}

	public void setActivarid_estructuraEmpleado(Boolean activarid_estructuraEmpleado) {
		this.activarid_estructuraEmpleado= activarid_estructuraEmpleado;
	}

	public Boolean getCargarid_estructuraEmpleado() {
		return this.cargarid_estructuraEmpleado;
	}

	public void setCargarid_estructuraEmpleado(Boolean cargarid_estructuraEmpleado) {
		this.cargarid_estructuraEmpleado= cargarid_estructuraEmpleado;
	}

	public Border setResaltarid_estructura_seccionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoBeanSwingJInternalFrame empleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoBeanSwingJInternalFrame.jTtoolBarEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_estructura_seccionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estructura_seccionEmpleado() {
		return this.resaltarid_estructura_seccionEmpleado;
	}

	public void setResaltarid_estructura_seccionEmpleado(Border borderResaltar) {
		this.resaltarid_estructura_seccionEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_estructura_seccionEmpleado() {
		return this.mostrarid_estructura_seccionEmpleado;
	}

	public void setMostrarid_estructura_seccionEmpleado(Boolean mostrarid_estructura_seccionEmpleado) {
		this.mostrarid_estructura_seccionEmpleado= mostrarid_estructura_seccionEmpleado;
	}

	public Boolean getActivarid_estructura_seccionEmpleado() {
		return this.activarid_estructura_seccionEmpleado;
	}

	public void setActivarid_estructura_seccionEmpleado(Boolean activarid_estructura_seccionEmpleado) {
		this.activarid_estructura_seccionEmpleado= activarid_estructura_seccionEmpleado;
	}

	public Boolean getCargarid_estructura_seccionEmpleado() {
		return this.cargarid_estructura_seccionEmpleado;
	}

	public void setCargarid_estructura_seccionEmpleado(Boolean cargarid_estructura_seccionEmpleado) {
		this.cargarid_estructura_seccionEmpleado= cargarid_estructura_seccionEmpleado;
	}

	public Border setResaltarid_estado_empleadoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoBeanSwingJInternalFrame empleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoBeanSwingJInternalFrame.jTtoolBarEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_estado_empleadoEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_empleadoEmpleado() {
		return this.resaltarid_estado_empleadoEmpleado;
	}

	public void setResaltarid_estado_empleadoEmpleado(Border borderResaltar) {
		this.resaltarid_estado_empleadoEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_estado_empleadoEmpleado() {
		return this.mostrarid_estado_empleadoEmpleado;
	}

	public void setMostrarid_estado_empleadoEmpleado(Boolean mostrarid_estado_empleadoEmpleado) {
		this.mostrarid_estado_empleadoEmpleado= mostrarid_estado_empleadoEmpleado;
	}

	public Boolean getActivarid_estado_empleadoEmpleado() {
		return this.activarid_estado_empleadoEmpleado;
	}

	public void setActivarid_estado_empleadoEmpleado(Boolean activarid_estado_empleadoEmpleado) {
		this.activarid_estado_empleadoEmpleado= activarid_estado_empleadoEmpleado;
	}

	public Boolean getCargarid_estado_empleadoEmpleado() {
		return this.cargarid_estado_empleadoEmpleado;
	}

	public void setCargarid_estado_empleadoEmpleado(Boolean cargarid_estado_empleadoEmpleado) {
		this.cargarid_estado_empleadoEmpleado= cargarid_estado_empleadoEmpleado;
	}

	public Border setResaltarid_tipo_contratoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoBeanSwingJInternalFrame empleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoBeanSwingJInternalFrame.jTtoolBarEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_tipo_contratoEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_contratoEmpleado() {
		return this.resaltarid_tipo_contratoEmpleado;
	}

	public void setResaltarid_tipo_contratoEmpleado(Border borderResaltar) {
		this.resaltarid_tipo_contratoEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_tipo_contratoEmpleado() {
		return this.mostrarid_tipo_contratoEmpleado;
	}

	public void setMostrarid_tipo_contratoEmpleado(Boolean mostrarid_tipo_contratoEmpleado) {
		this.mostrarid_tipo_contratoEmpleado= mostrarid_tipo_contratoEmpleado;
	}

	public Boolean getActivarid_tipo_contratoEmpleado() {
		return this.activarid_tipo_contratoEmpleado;
	}

	public void setActivarid_tipo_contratoEmpleado(Boolean activarid_tipo_contratoEmpleado) {
		this.activarid_tipo_contratoEmpleado= activarid_tipo_contratoEmpleado;
	}

	public Boolean getCargarid_tipo_contratoEmpleado() {
		return this.cargarid_tipo_contratoEmpleado;
	}

	public void setCargarid_tipo_contratoEmpleado(Boolean cargarid_tipo_contratoEmpleado) {
		this.cargarid_tipo_contratoEmpleado= cargarid_tipo_contratoEmpleado;
	}

	public Border setResaltarcodigoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoBeanSwingJInternalFrame empleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoBeanSwingJInternalFrame.jTtoolBarEmpleado.setBorder(borderResaltar);
		
		this.resaltarcodigoEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoEmpleado() {
		return this.resaltarcodigoEmpleado;
	}

	public void setResaltarcodigoEmpleado(Border borderResaltar) {
		this.resaltarcodigoEmpleado= borderResaltar;
	}

	public Boolean getMostrarcodigoEmpleado() {
		return this.mostrarcodigoEmpleado;
	}

	public void setMostrarcodigoEmpleado(Boolean mostrarcodigoEmpleado) {
		this.mostrarcodigoEmpleado= mostrarcodigoEmpleado;
	}

	public Boolean getActivarcodigoEmpleado() {
		return this.activarcodigoEmpleado;
	}

	public void setActivarcodigoEmpleado(Boolean activarcodigoEmpleado) {
		this.activarcodigoEmpleado= activarcodigoEmpleado;
	}

	public Border setResaltarnombreEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoBeanSwingJInternalFrame empleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoBeanSwingJInternalFrame.jTtoolBarEmpleado.setBorder(borderResaltar);
		
		this.resaltarnombreEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreEmpleado() {
		return this.resaltarnombreEmpleado;
	}

	public void setResaltarnombreEmpleado(Border borderResaltar) {
		this.resaltarnombreEmpleado= borderResaltar;
	}

	public Boolean getMostrarnombreEmpleado() {
		return this.mostrarnombreEmpleado;
	}

	public void setMostrarnombreEmpleado(Boolean mostrarnombreEmpleado) {
		this.mostrarnombreEmpleado= mostrarnombreEmpleado;
	}

	public Boolean getActivarnombreEmpleado() {
		return this.activarnombreEmpleado;
	}

	public void setActivarnombreEmpleado(Boolean activarnombreEmpleado) {
		this.activarnombreEmpleado= activarnombreEmpleado;
	}

	public Border setResaltarapellidoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoBeanSwingJInternalFrame empleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoBeanSwingJInternalFrame.jTtoolBarEmpleado.setBorder(borderResaltar);
		
		this.resaltarapellidoEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarapellidoEmpleado() {
		return this.resaltarapellidoEmpleado;
	}

	public void setResaltarapellidoEmpleado(Border borderResaltar) {
		this.resaltarapellidoEmpleado= borderResaltar;
	}

	public Boolean getMostrarapellidoEmpleado() {
		return this.mostrarapellidoEmpleado;
	}

	public void setMostrarapellidoEmpleado(Boolean mostrarapellidoEmpleado) {
		this.mostrarapellidoEmpleado= mostrarapellidoEmpleado;
	}

	public Boolean getActivarapellidoEmpleado() {
		return this.activarapellidoEmpleado;
	}

	public void setActivarapellidoEmpleado(Boolean activarapellidoEmpleado) {
		this.activarapellidoEmpleado= activarapellidoEmpleado;
	}

	public Border setResaltarnombre_completoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoBeanSwingJInternalFrame empleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoBeanSwingJInternalFrame.jTtoolBarEmpleado.setBorder(borderResaltar);
		
		this.resaltarnombre_completoEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_completoEmpleado() {
		return this.resaltarnombre_completoEmpleado;
	}

	public void setResaltarnombre_completoEmpleado(Border borderResaltar) {
		this.resaltarnombre_completoEmpleado= borderResaltar;
	}

	public Boolean getMostrarnombre_completoEmpleado() {
		return this.mostrarnombre_completoEmpleado;
	}

	public void setMostrarnombre_completoEmpleado(Boolean mostrarnombre_completoEmpleado) {
		this.mostrarnombre_completoEmpleado= mostrarnombre_completoEmpleado;
	}

	public Boolean getActivarnombre_completoEmpleado() {
		return this.activarnombre_completoEmpleado;
	}

	public void setActivarnombre_completoEmpleado(Boolean activarnombre_completoEmpleado) {
		this.activarnombre_completoEmpleado= activarnombre_completoEmpleado;
	}

	public Border setResaltarmailEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoBeanSwingJInternalFrame empleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoBeanSwingJInternalFrame.jTtoolBarEmpleado.setBorder(borderResaltar);
		
		this.resaltarmailEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmailEmpleado() {
		return this.resaltarmailEmpleado;
	}

	public void setResaltarmailEmpleado(Border borderResaltar) {
		this.resaltarmailEmpleado= borderResaltar;
	}

	public Boolean getMostrarmailEmpleado() {
		return this.mostrarmailEmpleado;
	}

	public void setMostrarmailEmpleado(Boolean mostrarmailEmpleado) {
		this.mostrarmailEmpleado= mostrarmailEmpleado;
	}

	public Boolean getActivarmailEmpleado() {
		return this.activarmailEmpleado;
	}

	public void setActivarmailEmpleado(Boolean activarmailEmpleado) {
		this.activarmailEmpleado= activarmailEmpleado;
	}

	public Border setResaltardireccionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoBeanSwingJInternalFrame empleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoBeanSwingJInternalFrame.jTtoolBarEmpleado.setBorder(borderResaltar);
		
		this.resaltardireccionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardireccionEmpleado() {
		return this.resaltardireccionEmpleado;
	}

	public void setResaltardireccionEmpleado(Border borderResaltar) {
		this.resaltardireccionEmpleado= borderResaltar;
	}

	public Boolean getMostrardireccionEmpleado() {
		return this.mostrardireccionEmpleado;
	}

	public void setMostrardireccionEmpleado(Boolean mostrardireccionEmpleado) {
		this.mostrardireccionEmpleado= mostrardireccionEmpleado;
	}

	public Boolean getActivardireccionEmpleado() {
		return this.activardireccionEmpleado;
	}

	public void setActivardireccionEmpleado(Boolean activardireccionEmpleado) {
		this.activardireccionEmpleado= activardireccionEmpleado;
	}

	public Border setResaltarsueldoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoBeanSwingJInternalFrame empleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoBeanSwingJInternalFrame.jTtoolBarEmpleado.setBorder(borderResaltar);
		
		this.resaltarsueldoEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsueldoEmpleado() {
		return this.resaltarsueldoEmpleado;
	}

	public void setResaltarsueldoEmpleado(Border borderResaltar) {
		this.resaltarsueldoEmpleado= borderResaltar;
	}

	public Boolean getMostrarsueldoEmpleado() {
		return this.mostrarsueldoEmpleado;
	}

	public void setMostrarsueldoEmpleado(Boolean mostrarsueldoEmpleado) {
		this.mostrarsueldoEmpleado= mostrarsueldoEmpleado;
	}

	public Boolean getActivarsueldoEmpleado() {
		return this.activarsueldoEmpleado;
	}

	public void setActivarsueldoEmpleado(Boolean activarsueldoEmpleado) {
		this.activarsueldoEmpleado= activarsueldoEmpleado;
	}

	public Border setResaltartelefonoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoBeanSwingJInternalFrame empleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoBeanSwingJInternalFrame.jTtoolBarEmpleado.setBorder(borderResaltar);
		
		this.resaltartelefonoEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartelefonoEmpleado() {
		return this.resaltartelefonoEmpleado;
	}

	public void setResaltartelefonoEmpleado(Border borderResaltar) {
		this.resaltartelefonoEmpleado= borderResaltar;
	}

	public Boolean getMostrartelefonoEmpleado() {
		return this.mostrartelefonoEmpleado;
	}

	public void setMostrartelefonoEmpleado(Boolean mostrartelefonoEmpleado) {
		this.mostrartelefonoEmpleado= mostrartelefonoEmpleado;
	}

	public Boolean getActivartelefonoEmpleado() {
		return this.activartelefonoEmpleado;
	}

	public void setActivartelefonoEmpleado(Boolean activartelefonoEmpleado) {
		this.activartelefonoEmpleado= activartelefonoEmpleado;
	}

	public Border setResaltarid_tipo_cuenta_banco_globalEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoBeanSwingJInternalFrame empleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoBeanSwingJInternalFrame.jTtoolBarEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_tipo_cuenta_banco_globalEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_cuenta_banco_globalEmpleado() {
		return this.resaltarid_tipo_cuenta_banco_globalEmpleado;
	}

	public void setResaltarid_tipo_cuenta_banco_globalEmpleado(Border borderResaltar) {
		this.resaltarid_tipo_cuenta_banco_globalEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_tipo_cuenta_banco_globalEmpleado() {
		return this.mostrarid_tipo_cuenta_banco_globalEmpleado;
	}

	public void setMostrarid_tipo_cuenta_banco_globalEmpleado(Boolean mostrarid_tipo_cuenta_banco_globalEmpleado) {
		this.mostrarid_tipo_cuenta_banco_globalEmpleado= mostrarid_tipo_cuenta_banco_globalEmpleado;
	}

	public Boolean getActivarid_tipo_cuenta_banco_globalEmpleado() {
		return this.activarid_tipo_cuenta_banco_globalEmpleado;
	}

	public void setActivarid_tipo_cuenta_banco_globalEmpleado(Boolean activarid_tipo_cuenta_banco_globalEmpleado) {
		this.activarid_tipo_cuenta_banco_globalEmpleado= activarid_tipo_cuenta_banco_globalEmpleado;
	}

	public Boolean getCargarid_tipo_cuenta_banco_globalEmpleado() {
		return this.cargarid_tipo_cuenta_banco_globalEmpleado;
	}

	public void setCargarid_tipo_cuenta_banco_globalEmpleado(Boolean cargarid_tipo_cuenta_banco_globalEmpleado) {
		this.cargarid_tipo_cuenta_banco_globalEmpleado= cargarid_tipo_cuenta_banco_globalEmpleado;
	}

	public Border setResaltarnumero_cuentaEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoBeanSwingJInternalFrame empleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoBeanSwingJInternalFrame.jTtoolBarEmpleado.setBorder(borderResaltar);
		
		this.resaltarnumero_cuentaEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_cuentaEmpleado() {
		return this.resaltarnumero_cuentaEmpleado;
	}

	public void setResaltarnumero_cuentaEmpleado(Border borderResaltar) {
		this.resaltarnumero_cuentaEmpleado= borderResaltar;
	}

	public Boolean getMostrarnumero_cuentaEmpleado() {
		return this.mostrarnumero_cuentaEmpleado;
	}

	public void setMostrarnumero_cuentaEmpleado(Boolean mostrarnumero_cuentaEmpleado) {
		this.mostrarnumero_cuentaEmpleado= mostrarnumero_cuentaEmpleado;
	}

	public Boolean getActivarnumero_cuentaEmpleado() {
		return this.activarnumero_cuentaEmpleado;
	}

	public void setActivarnumero_cuentaEmpleado(Boolean activarnumero_cuentaEmpleado) {
		this.activarnumero_cuentaEmpleado= activarnumero_cuentaEmpleado;
	}

	public Border setResaltartiene_casaEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoBeanSwingJInternalFrame empleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoBeanSwingJInternalFrame.jTtoolBarEmpleado.setBorder(borderResaltar);
		
		this.resaltartiene_casaEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartiene_casaEmpleado() {
		return this.resaltartiene_casaEmpleado;
	}

	public void setResaltartiene_casaEmpleado(Border borderResaltar) {
		this.resaltartiene_casaEmpleado= borderResaltar;
	}

	public Boolean getMostrartiene_casaEmpleado() {
		return this.mostrartiene_casaEmpleado;
	}

	public void setMostrartiene_casaEmpleado(Boolean mostrartiene_casaEmpleado) {
		this.mostrartiene_casaEmpleado= mostrartiene_casaEmpleado;
	}

	public Boolean getActivartiene_casaEmpleado() {
		return this.activartiene_casaEmpleado;
	}

	public void setActivartiene_casaEmpleado(Boolean activartiene_casaEmpleado) {
		this.activartiene_casaEmpleado= activartiene_casaEmpleado;
	}

	public Border setResaltartiene_vehiculoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoBeanSwingJInternalFrame empleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoBeanSwingJInternalFrame.jTtoolBarEmpleado.setBorder(borderResaltar);
		
		this.resaltartiene_vehiculoEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartiene_vehiculoEmpleado() {
		return this.resaltartiene_vehiculoEmpleado;
	}

	public void setResaltartiene_vehiculoEmpleado(Border borderResaltar) {
		this.resaltartiene_vehiculoEmpleado= borderResaltar;
	}

	public Boolean getMostrartiene_vehiculoEmpleado() {
		return this.mostrartiene_vehiculoEmpleado;
	}

	public void setMostrartiene_vehiculoEmpleado(Boolean mostrartiene_vehiculoEmpleado) {
		this.mostrartiene_vehiculoEmpleado= mostrartiene_vehiculoEmpleado;
	}

	public Boolean getActivartiene_vehiculoEmpleado() {
		return this.activartiene_vehiculoEmpleado;
	}

	public void setActivartiene_vehiculoEmpleado(Boolean activartiene_vehiculoEmpleado) {
		this.activartiene_vehiculoEmpleado= activartiene_vehiculoEmpleado;
	}
	
	public void setMostrarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}
		
		
		this.setMostraridEmpleado(esInicial);
		this.setMostrarid_empresaEmpleado(esInicial);
		this.setMostrarid_sucursalEmpleado(esInicial);
		this.setMostrarid_paisEmpleado(esInicial);
		this.setMostrarid_provinciaEmpleado(esInicial);
		this.setMostrarid_ciudadEmpleado(esInicial);
		this.setMostrarid_centro_costoEmpleado(esInicial);
		this.setMostrarid_religionEmpleado(esInicial);
		this.setMostrarid_estado_civilEmpleado(esInicial);
		this.setMostrarid_tipo_generoEmpleado(esInicial);
		this.setMostrarid_tipo_empleadoEmpleado(esInicial);
		this.setMostrarid_tipo_instruccionEmpleado(esInicial);
		this.setMostrarid_cargoEmpleado(esInicial);
		this.setMostrarid_estructuraEmpleado(esInicial);
		this.setMostrarid_estructura_seccionEmpleado(esInicial);
		this.setMostrarid_estado_empleadoEmpleado(esInicial);
		this.setMostrarid_tipo_contratoEmpleado(esInicial);
		this.setMostrarcodigoEmpleado(esInicial);
		this.setMostrarnombreEmpleado(esInicial);
		this.setMostrarapellidoEmpleado(esInicial);
		this.setMostrarnombre_completoEmpleado(esInicial);
		this.setMostrarmailEmpleado(esInicial);
		this.setMostrardireccionEmpleado(esInicial);
		this.setMostrarsueldoEmpleado(esInicial);
		this.setMostrartelefonoEmpleado(esInicial);
		this.setMostrarid_tipo_cuenta_banco_globalEmpleado(esInicial);
		this.setMostrarnumero_cuentaEmpleado(esInicial);
		this.setMostrartiene_casaEmpleado(esInicial);
		this.setMostrartiene_vehiculoEmpleado(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EmpleadoConstantesFunciones.ID)) {
				this.setMostraridEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.IDPAIS)) {
				this.setMostrarid_paisEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.IDPROVINCIA)) {
				this.setMostrarid_provinciaEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.IDCIUDAD)) {
				this.setMostrarid_ciudadEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.IDCENTROCOSTO)) {
				this.setMostrarid_centro_costoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.IDRELIGION)) {
				this.setMostrarid_religionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.IDESTADOCIVIL)) {
				this.setMostrarid_estado_civilEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.IDTIPOGENERO)) {
				this.setMostrarid_tipo_generoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.IDTIPOEMPLEADO)) {
				this.setMostrarid_tipo_empleadoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.IDTIPOINSTRUCCION)) {
				this.setMostrarid_tipo_instruccionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.IDCARGO)) {
				this.setMostrarid_cargoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.IDESTRUCTURA)) {
				this.setMostrarid_estructuraEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.IDESTRUCTURASECCION)) {
				this.setMostrarid_estructura_seccionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.IDESTADOEMPLEADO)) {
				this.setMostrarid_estado_empleadoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.IDTIPOCONTRATO)) {
				this.setMostrarid_tipo_contratoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.APELLIDO)) {
				this.setMostrarapellidoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.NOMBRECOMPLETO)) {
				this.setMostrarnombre_completoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.MAIL)) {
				this.setMostrarmailEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.DIRECCION)) {
				this.setMostrardireccionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.SUELDO)) {
				this.setMostrarsueldoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.TELEFONO)) {
				this.setMostrartelefonoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.IDTIPOCUENTABANCOGLOBAL)) {
				this.setMostrarid_tipo_cuenta_banco_globalEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.NUMEROCUENTA)) {
				this.setMostrarnumero_cuentaEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.TIENECASA)) {
				this.setMostrartiene_casaEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.TIENEVEHICULO)) {
				this.setMostrartiene_vehiculoEmpleado(esAsigna);
				continue;
			}
		}
	}
	
	public void setActivarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}
		
		
		this.setActivaridEmpleado(esInicial);
		this.setActivarid_empresaEmpleado(esInicial);
		this.setActivarid_sucursalEmpleado(esInicial);
		this.setActivarid_paisEmpleado(esInicial);
		this.setActivarid_provinciaEmpleado(esInicial);
		this.setActivarid_ciudadEmpleado(esInicial);
		this.setActivarid_centro_costoEmpleado(esInicial);
		this.setActivarid_religionEmpleado(esInicial);
		this.setActivarid_estado_civilEmpleado(esInicial);
		this.setActivarid_tipo_generoEmpleado(esInicial);
		this.setActivarid_tipo_empleadoEmpleado(esInicial);
		this.setActivarid_tipo_instruccionEmpleado(esInicial);
		this.setActivarid_cargoEmpleado(esInicial);
		this.setActivarid_estructuraEmpleado(esInicial);
		this.setActivarid_estructura_seccionEmpleado(esInicial);
		this.setActivarid_estado_empleadoEmpleado(esInicial);
		this.setActivarid_tipo_contratoEmpleado(esInicial);
		this.setActivarcodigoEmpleado(esInicial);
		this.setActivarnombreEmpleado(esInicial);
		this.setActivarapellidoEmpleado(esInicial);
		this.setActivarnombre_completoEmpleado(esInicial);
		this.setActivarmailEmpleado(esInicial);
		this.setActivardireccionEmpleado(esInicial);
		this.setActivarsueldoEmpleado(esInicial);
		this.setActivartelefonoEmpleado(esInicial);
		this.setActivarid_tipo_cuenta_banco_globalEmpleado(esInicial);
		this.setActivarnumero_cuentaEmpleado(esInicial);
		this.setActivartiene_casaEmpleado(esInicial);
		this.setActivartiene_vehiculoEmpleado(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EmpleadoConstantesFunciones.ID)) {
				this.setActivaridEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.IDPAIS)) {
				this.setActivarid_paisEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.IDPROVINCIA)) {
				this.setActivarid_provinciaEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.IDCIUDAD)) {
				this.setActivarid_ciudadEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.IDCENTROCOSTO)) {
				this.setActivarid_centro_costoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.IDRELIGION)) {
				this.setActivarid_religionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.IDESTADOCIVIL)) {
				this.setActivarid_estado_civilEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.IDTIPOGENERO)) {
				this.setActivarid_tipo_generoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.IDTIPOEMPLEADO)) {
				this.setActivarid_tipo_empleadoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.IDTIPOINSTRUCCION)) {
				this.setActivarid_tipo_instruccionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.IDCARGO)) {
				this.setActivarid_cargoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.IDESTRUCTURA)) {
				this.setActivarid_estructuraEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.IDESTRUCTURASECCION)) {
				this.setActivarid_estructura_seccionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.IDESTADOEMPLEADO)) {
				this.setActivarid_estado_empleadoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.IDTIPOCONTRATO)) {
				this.setActivarid_tipo_contratoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.CODIGO)) {
				this.setActivarcodigoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.APELLIDO)) {
				this.setActivarapellidoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.NOMBRECOMPLETO)) {
				this.setActivarnombre_completoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.MAIL)) {
				this.setActivarmailEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.DIRECCION)) {
				this.setActivardireccionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.SUELDO)) {
				this.setActivarsueldoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.TELEFONO)) {
				this.setActivartelefonoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.IDTIPOCUENTABANCOGLOBAL)) {
				this.setActivarid_tipo_cuenta_banco_globalEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.NUMEROCUENTA)) {
				this.setActivarnumero_cuentaEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.TIENECASA)) {
				this.setActivartiene_casaEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.TIENEVEHICULO)) {
				this.setActivartiene_vehiculoEmpleado(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EmpleadoBeanSwingJInternalFrame empleadoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEmpleado(esInicial);
		this.setResaltarid_empresaEmpleado(esInicial);
		this.setResaltarid_sucursalEmpleado(esInicial);
		this.setResaltarid_paisEmpleado(esInicial);
		this.setResaltarid_provinciaEmpleado(esInicial);
		this.setResaltarid_ciudadEmpleado(esInicial);
		this.setResaltarid_centro_costoEmpleado(esInicial);
		this.setResaltarid_religionEmpleado(esInicial);
		this.setResaltarid_estado_civilEmpleado(esInicial);
		this.setResaltarid_tipo_generoEmpleado(esInicial);
		this.setResaltarid_tipo_empleadoEmpleado(esInicial);
		this.setResaltarid_tipo_instruccionEmpleado(esInicial);
		this.setResaltarid_cargoEmpleado(esInicial);
		this.setResaltarid_estructuraEmpleado(esInicial);
		this.setResaltarid_estructura_seccionEmpleado(esInicial);
		this.setResaltarid_estado_empleadoEmpleado(esInicial);
		this.setResaltarid_tipo_contratoEmpleado(esInicial);
		this.setResaltarcodigoEmpleado(esInicial);
		this.setResaltarnombreEmpleado(esInicial);
		this.setResaltarapellidoEmpleado(esInicial);
		this.setResaltarnombre_completoEmpleado(esInicial);
		this.setResaltarmailEmpleado(esInicial);
		this.setResaltardireccionEmpleado(esInicial);
		this.setResaltarsueldoEmpleado(esInicial);
		this.setResaltartelefonoEmpleado(esInicial);
		this.setResaltarid_tipo_cuenta_banco_globalEmpleado(esInicial);
		this.setResaltarnumero_cuentaEmpleado(esInicial);
		this.setResaltartiene_casaEmpleado(esInicial);
		this.setResaltartiene_vehiculoEmpleado(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EmpleadoConstantesFunciones.ID)) {
				this.setResaltaridEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.IDPAIS)) {
				this.setResaltarid_paisEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.IDPROVINCIA)) {
				this.setResaltarid_provinciaEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.IDCIUDAD)) {
				this.setResaltarid_ciudadEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.IDCENTROCOSTO)) {
				this.setResaltarid_centro_costoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.IDRELIGION)) {
				this.setResaltarid_religionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.IDESTADOCIVIL)) {
				this.setResaltarid_estado_civilEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.IDTIPOGENERO)) {
				this.setResaltarid_tipo_generoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.IDTIPOEMPLEADO)) {
				this.setResaltarid_tipo_empleadoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.IDTIPOINSTRUCCION)) {
				this.setResaltarid_tipo_instruccionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.IDCARGO)) {
				this.setResaltarid_cargoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.IDESTRUCTURA)) {
				this.setResaltarid_estructuraEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.IDESTRUCTURASECCION)) {
				this.setResaltarid_estructura_seccionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.IDESTADOEMPLEADO)) {
				this.setResaltarid_estado_empleadoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.IDTIPOCONTRATO)) {
				this.setResaltarid_tipo_contratoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.APELLIDO)) {
				this.setResaltarapellidoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.NOMBRECOMPLETO)) {
				this.setResaltarnombre_completoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.MAIL)) {
				this.setResaltarmailEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.DIRECCION)) {
				this.setResaltardireccionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.SUELDO)) {
				this.setResaltarsueldoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.TELEFONO)) {
				this.setResaltartelefonoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.IDTIPOCUENTABANCOGLOBAL)) {
				this.setResaltarid_tipo_cuenta_banco_globalEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.NUMEROCUENTA)) {
				this.setResaltarnumero_cuentaEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.TIENECASA)) {
				this.setResaltartiene_casaEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstantesFunciones.TIENEVEHICULO)) {
				this.setResaltartiene_vehiculoEmpleado(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarCargaFamiliar_NMEmpleado=null;

	public Border getResaltarCargaFamiliar_NMEmpleado() {
		return this.resaltarCargaFamiliar_NMEmpleado;
	}

	public void setResaltarCargaFamiliar_NMEmpleado(Border borderResaltarCargaFamiliar_NM) {
		if(borderResaltarCargaFamiliar_NM!=null) {
			this.resaltarCargaFamiliar_NMEmpleado= borderResaltarCargaFamiliar_NM;
		}
	}

	public Border setResaltarCargaFamiliar_NMEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoBeanSwingJInternalFrame empleadoBeanSwingJInternalFrame*/) {
		Border borderResaltarCargaFamiliar_NM=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//empleadoBeanSwingJInternalFrame.jTtoolBarEmpleado.setBorder(borderResaltarCargaFamiliar_NM);
			
		this.resaltarCargaFamiliar_NMEmpleado= borderResaltarCargaFamiliar_NM;

		 return borderResaltarCargaFamiliar_NM;
	}



	public Boolean mostrarCargaFamiliar_NMEmpleado=true;

	public Boolean getMostrarCargaFamiliar_NMEmpleado() {
		return this.mostrarCargaFamiliar_NMEmpleado;
	}

	public void setMostrarCargaFamiliar_NMEmpleado(Boolean visibilidadResaltarCargaFamiliar_NM) {
		this.mostrarCargaFamiliar_NMEmpleado= visibilidadResaltarCargaFamiliar_NM;
	}



	public Boolean activarCargaFamiliar_NMEmpleado=true;

	public Boolean gethabilitarResaltarCargaFamiliar_NMEmpleado() {
		return this.activarCargaFamiliar_NMEmpleado;
	}

	public void setActivarCargaFamiliar_NMEmpleado(Boolean habilitarResaltarCargaFamiliar_NM) {
		this.activarCargaFamiliar_NMEmpleado= habilitarResaltarCargaFamiliar_NM;
	}


	public Border resaltarCursoEmpleado=null;

	public Border getResaltarCursoEmpleado() {
		return this.resaltarCursoEmpleado;
	}

	public void setResaltarCursoEmpleado(Border borderResaltarCurso) {
		if(borderResaltarCurso!=null) {
			this.resaltarCursoEmpleado= borderResaltarCurso;
		}
	}

	public Border setResaltarCursoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoBeanSwingJInternalFrame empleadoBeanSwingJInternalFrame*/) {
		Border borderResaltarCurso=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//empleadoBeanSwingJInternalFrame.jTtoolBarEmpleado.setBorder(borderResaltarCurso);
			
		this.resaltarCursoEmpleado= borderResaltarCurso;

		 return borderResaltarCurso;
	}



	public Boolean mostrarCursoEmpleado=true;

	public Boolean getMostrarCursoEmpleado() {
		return this.mostrarCursoEmpleado;
	}

	public void setMostrarCursoEmpleado(Boolean visibilidadResaltarCurso) {
		this.mostrarCursoEmpleado= visibilidadResaltarCurso;
	}



	public Boolean activarCursoEmpleado=true;

	public Boolean gethabilitarResaltarCursoEmpleado() {
		return this.activarCursoEmpleado;
	}

	public void setActivarCursoEmpleado(Boolean habilitarResaltarCurso) {
		this.activarCursoEmpleado= habilitarResaltarCurso;
	}


	public Border resaltarPrestamoEmpleado=null;

	public Border getResaltarPrestamoEmpleado() {
		return this.resaltarPrestamoEmpleado;
	}

	public void setResaltarPrestamoEmpleado(Border borderResaltarPrestamo) {
		if(borderResaltarPrestamo!=null) {
			this.resaltarPrestamoEmpleado= borderResaltarPrestamo;
		}
	}

	public Border setResaltarPrestamoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoBeanSwingJInternalFrame empleadoBeanSwingJInternalFrame*/) {
		Border borderResaltarPrestamo=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//empleadoBeanSwingJInternalFrame.jTtoolBarEmpleado.setBorder(borderResaltarPrestamo);
			
		this.resaltarPrestamoEmpleado= borderResaltarPrestamo;

		 return borderResaltarPrestamo;
	}



	public Boolean mostrarPrestamoEmpleado=true;

	public Boolean getMostrarPrestamoEmpleado() {
		return this.mostrarPrestamoEmpleado;
	}

	public void setMostrarPrestamoEmpleado(Boolean visibilidadResaltarPrestamo) {
		this.mostrarPrestamoEmpleado= visibilidadResaltarPrestamo;
	}



	public Boolean activarPrestamoEmpleado=true;

	public Boolean gethabilitarResaltarPrestamoEmpleado() {
		return this.activarPrestamoEmpleado;
	}

	public void setActivarPrestamoEmpleado(Boolean habilitarResaltarPrestamo) {
		this.activarPrestamoEmpleado= habilitarResaltarPrestamo;
	}


	public Border resaltarEmpleadoIdiomaEmpleado=null;

	public Border getResaltarEmpleadoIdiomaEmpleado() {
		return this.resaltarEmpleadoIdiomaEmpleado;
	}

	public void setResaltarEmpleadoIdiomaEmpleado(Border borderResaltarEmpleadoIdioma) {
		if(borderResaltarEmpleadoIdioma!=null) {
			this.resaltarEmpleadoIdiomaEmpleado= borderResaltarEmpleadoIdioma;
		}
	}

	public Border setResaltarEmpleadoIdiomaEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoBeanSwingJInternalFrame empleadoBeanSwingJInternalFrame*/) {
		Border borderResaltarEmpleadoIdioma=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//empleadoBeanSwingJInternalFrame.jTtoolBarEmpleado.setBorder(borderResaltarEmpleadoIdioma);
			
		this.resaltarEmpleadoIdiomaEmpleado= borderResaltarEmpleadoIdioma;

		 return borderResaltarEmpleadoIdioma;
	}



	public Boolean mostrarEmpleadoIdiomaEmpleado=true;

	public Boolean getMostrarEmpleadoIdiomaEmpleado() {
		return this.mostrarEmpleadoIdiomaEmpleado;
	}

	public void setMostrarEmpleadoIdiomaEmpleado(Boolean visibilidadResaltarEmpleadoIdioma) {
		this.mostrarEmpleadoIdiomaEmpleado= visibilidadResaltarEmpleadoIdioma;
	}



	public Boolean activarEmpleadoIdiomaEmpleado=true;

	public Boolean gethabilitarResaltarEmpleadoIdiomaEmpleado() {
		return this.activarEmpleadoIdiomaEmpleado;
	}

	public void setActivarEmpleadoIdiomaEmpleado(Boolean habilitarResaltarEmpleadoIdioma) {
		this.activarEmpleadoIdiomaEmpleado= habilitarResaltarEmpleadoIdioma;
	}


	public Border resaltarHistorialPagoMesNomiEmpleado=null;

	public Border getResaltarHistorialPagoMesNomiEmpleado() {
		return this.resaltarHistorialPagoMesNomiEmpleado;
	}

	public void setResaltarHistorialPagoMesNomiEmpleado(Border borderResaltarHistorialPagoMesNomi) {
		if(borderResaltarHistorialPagoMesNomi!=null) {
			this.resaltarHistorialPagoMesNomiEmpleado= borderResaltarHistorialPagoMesNomi;
		}
	}

	public Border setResaltarHistorialPagoMesNomiEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoBeanSwingJInternalFrame empleadoBeanSwingJInternalFrame*/) {
		Border borderResaltarHistorialPagoMesNomi=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//empleadoBeanSwingJInternalFrame.jTtoolBarEmpleado.setBorder(borderResaltarHistorialPagoMesNomi);
			
		this.resaltarHistorialPagoMesNomiEmpleado= borderResaltarHistorialPagoMesNomi;

		 return borderResaltarHistorialPagoMesNomi;
	}



	public Boolean mostrarHistorialPagoMesNomiEmpleado=true;

	public Boolean getMostrarHistorialPagoMesNomiEmpleado() {
		return this.mostrarHistorialPagoMesNomiEmpleado;
	}

	public void setMostrarHistorialPagoMesNomiEmpleado(Boolean visibilidadResaltarHistorialPagoMesNomi) {
		this.mostrarHistorialPagoMesNomiEmpleado= visibilidadResaltarHistorialPagoMesNomi;
	}



	public Boolean activarHistorialPagoMesNomiEmpleado=true;

	public Boolean gethabilitarResaltarHistorialPagoMesNomiEmpleado() {
		return this.activarHistorialPagoMesNomiEmpleado;
	}

	public void setActivarHistorialPagoMesNomiEmpleado(Boolean habilitarResaltarHistorialPagoMesNomi) {
		this.activarHistorialPagoMesNomiEmpleado= habilitarResaltarHistorialPagoMesNomi;
	}


	public Border resaltarEmpleadoImpuestoRentaEmpleado=null;

	public Border getResaltarEmpleadoImpuestoRentaEmpleado() {
		return this.resaltarEmpleadoImpuestoRentaEmpleado;
	}

	public void setResaltarEmpleadoImpuestoRentaEmpleado(Border borderResaltarEmpleadoImpuestoRenta) {
		if(borderResaltarEmpleadoImpuestoRenta!=null) {
			this.resaltarEmpleadoImpuestoRentaEmpleado= borderResaltarEmpleadoImpuestoRenta;
		}
	}

	public Border setResaltarEmpleadoImpuestoRentaEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoBeanSwingJInternalFrame empleadoBeanSwingJInternalFrame*/) {
		Border borderResaltarEmpleadoImpuestoRenta=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//empleadoBeanSwingJInternalFrame.jTtoolBarEmpleado.setBorder(borderResaltarEmpleadoImpuestoRenta);
			
		this.resaltarEmpleadoImpuestoRentaEmpleado= borderResaltarEmpleadoImpuestoRenta;

		 return borderResaltarEmpleadoImpuestoRenta;
	}



	public Boolean mostrarEmpleadoImpuestoRentaEmpleado=true;

	public Boolean getMostrarEmpleadoImpuestoRentaEmpleado() {
		return this.mostrarEmpleadoImpuestoRentaEmpleado;
	}

	public void setMostrarEmpleadoImpuestoRentaEmpleado(Boolean visibilidadResaltarEmpleadoImpuestoRenta) {
		this.mostrarEmpleadoImpuestoRentaEmpleado= visibilidadResaltarEmpleadoImpuestoRenta;
	}



	public Boolean activarEmpleadoImpuestoRentaEmpleado=true;

	public Boolean gethabilitarResaltarEmpleadoImpuestoRentaEmpleado() {
		return this.activarEmpleadoImpuestoRentaEmpleado;
	}

	public void setActivarEmpleadoImpuestoRentaEmpleado(Boolean habilitarResaltarEmpleadoImpuestoRenta) {
		this.activarEmpleadoImpuestoRentaEmpleado= habilitarResaltarEmpleadoImpuestoRenta;
	}


	public Border resaltarDatoGeneralEmpleadoEmpleado=null;

	public Border getResaltarDatoGeneralEmpleadoEmpleado() {
		return this.resaltarDatoGeneralEmpleadoEmpleado;
	}

	public void setResaltarDatoGeneralEmpleadoEmpleado(Border borderResaltarDatoGeneralEmpleado) {
		if(borderResaltarDatoGeneralEmpleado!=null) {
			this.resaltarDatoGeneralEmpleadoEmpleado= borderResaltarDatoGeneralEmpleado;
		}
	}

	public Border setResaltarDatoGeneralEmpleadoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoBeanSwingJInternalFrame empleadoBeanSwingJInternalFrame*/) {
		Border borderResaltarDatoGeneralEmpleado=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//empleadoBeanSwingJInternalFrame.jTtoolBarEmpleado.setBorder(borderResaltarDatoGeneralEmpleado);
			
		this.resaltarDatoGeneralEmpleadoEmpleado= borderResaltarDatoGeneralEmpleado;

		 return borderResaltarDatoGeneralEmpleado;
	}



	public Boolean mostrarDatoGeneralEmpleadoEmpleado=true;

	public Boolean getMostrarDatoGeneralEmpleadoEmpleado() {
		return this.mostrarDatoGeneralEmpleadoEmpleado;
	}

	public void setMostrarDatoGeneralEmpleadoEmpleado(Boolean visibilidadResaltarDatoGeneralEmpleado) {
		this.mostrarDatoGeneralEmpleadoEmpleado= visibilidadResaltarDatoGeneralEmpleado;
	}



	public Boolean activarDatoGeneralEmpleadoEmpleado=true;

	public Boolean gethabilitarResaltarDatoGeneralEmpleadoEmpleado() {
		return this.activarDatoGeneralEmpleadoEmpleado;
	}

	public void setActivarDatoGeneralEmpleadoEmpleado(Boolean habilitarResaltarDatoGeneralEmpleado) {
		this.activarDatoGeneralEmpleadoEmpleado= habilitarResaltarDatoGeneralEmpleado;
	}


	public Border resaltarAreaEmpleado=null;

	public Border getResaltarAreaEmpleado() {
		return this.resaltarAreaEmpleado;
	}

	public void setResaltarAreaEmpleado(Border borderResaltarArea) {
		if(borderResaltarArea!=null) {
			this.resaltarAreaEmpleado= borderResaltarArea;
		}
	}

	public Border setResaltarAreaEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoBeanSwingJInternalFrame empleadoBeanSwingJInternalFrame*/) {
		Border borderResaltarArea=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//empleadoBeanSwingJInternalFrame.jTtoolBarEmpleado.setBorder(borderResaltarArea);
			
		this.resaltarAreaEmpleado= borderResaltarArea;

		 return borderResaltarArea;
	}



	public Boolean mostrarAreaEmpleado=true;

	public Boolean getMostrarAreaEmpleado() {
		return this.mostrarAreaEmpleado;
	}

	public void setMostrarAreaEmpleado(Boolean visibilidadResaltarArea) {
		this.mostrarAreaEmpleado= visibilidadResaltarArea;
	}



	public Boolean activarAreaEmpleado=true;

	public Boolean gethabilitarResaltarAreaEmpleado() {
		return this.activarAreaEmpleado;
	}

	public void setActivarAreaEmpleado(Boolean habilitarResaltarArea) {
		this.activarAreaEmpleado= habilitarResaltarArea;
	}


	public Border resaltarGastoEmpleadoEmpleado=null;

	public Border getResaltarGastoEmpleadoEmpleado() {
		return this.resaltarGastoEmpleadoEmpleado;
	}

	public void setResaltarGastoEmpleadoEmpleado(Border borderResaltarGastoEmpleado) {
		if(borderResaltarGastoEmpleado!=null) {
			this.resaltarGastoEmpleadoEmpleado= borderResaltarGastoEmpleado;
		}
	}

	public Border setResaltarGastoEmpleadoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoBeanSwingJInternalFrame empleadoBeanSwingJInternalFrame*/) {
		Border borderResaltarGastoEmpleado=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//empleadoBeanSwingJInternalFrame.jTtoolBarEmpleado.setBorder(borderResaltarGastoEmpleado);
			
		this.resaltarGastoEmpleadoEmpleado= borderResaltarGastoEmpleado;

		 return borderResaltarGastoEmpleado;
	}



	public Boolean mostrarGastoEmpleadoEmpleado=true;

	public Boolean getMostrarGastoEmpleadoEmpleado() {
		return this.mostrarGastoEmpleadoEmpleado;
	}

	public void setMostrarGastoEmpleadoEmpleado(Boolean visibilidadResaltarGastoEmpleado) {
		this.mostrarGastoEmpleadoEmpleado= visibilidadResaltarGastoEmpleado;
	}



	public Boolean activarGastoEmpleadoEmpleado=true;

	public Boolean gethabilitarResaltarGastoEmpleadoEmpleado() {
		return this.activarGastoEmpleadoEmpleado;
	}

	public void setActivarGastoEmpleadoEmpleado(Boolean habilitarResaltarGastoEmpleado) {
		this.activarGastoEmpleadoEmpleado= habilitarResaltarGastoEmpleado;
	}


	public Border resaltarEmpleadoHobbyEmpleado=null;

	public Border getResaltarEmpleadoHobbyEmpleado() {
		return this.resaltarEmpleadoHobbyEmpleado;
	}

	public void setResaltarEmpleadoHobbyEmpleado(Border borderResaltarEmpleadoHobby) {
		if(borderResaltarEmpleadoHobby!=null) {
			this.resaltarEmpleadoHobbyEmpleado= borderResaltarEmpleadoHobby;
		}
	}

	public Border setResaltarEmpleadoHobbyEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoBeanSwingJInternalFrame empleadoBeanSwingJInternalFrame*/) {
		Border borderResaltarEmpleadoHobby=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//empleadoBeanSwingJInternalFrame.jTtoolBarEmpleado.setBorder(borderResaltarEmpleadoHobby);
			
		this.resaltarEmpleadoHobbyEmpleado= borderResaltarEmpleadoHobby;

		 return borderResaltarEmpleadoHobby;
	}



	public Boolean mostrarEmpleadoHobbyEmpleado=true;

	public Boolean getMostrarEmpleadoHobbyEmpleado() {
		return this.mostrarEmpleadoHobbyEmpleado;
	}

	public void setMostrarEmpleadoHobbyEmpleado(Boolean visibilidadResaltarEmpleadoHobby) {
		this.mostrarEmpleadoHobbyEmpleado= visibilidadResaltarEmpleadoHobby;
	}



	public Boolean activarEmpleadoHobbyEmpleado=true;

	public Boolean gethabilitarResaltarEmpleadoHobbyEmpleado() {
		return this.activarEmpleadoHobbyEmpleado;
	}

	public void setActivarEmpleadoHobbyEmpleado(Boolean habilitarResaltarEmpleadoHobby) {
		this.activarEmpleadoHobbyEmpleado= habilitarResaltarEmpleadoHobby;
	}


	public Border resaltarEmpleadoEMailEmpleado=null;

	public Border getResaltarEmpleadoEMailEmpleado() {
		return this.resaltarEmpleadoEMailEmpleado;
	}

	public void setResaltarEmpleadoEMailEmpleado(Border borderResaltarEmpleadoEMail) {
		if(borderResaltarEmpleadoEMail!=null) {
			this.resaltarEmpleadoEMailEmpleado= borderResaltarEmpleadoEMail;
		}
	}

	public Border setResaltarEmpleadoEMailEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoBeanSwingJInternalFrame empleadoBeanSwingJInternalFrame*/) {
		Border borderResaltarEmpleadoEMail=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//empleadoBeanSwingJInternalFrame.jTtoolBarEmpleado.setBorder(borderResaltarEmpleadoEMail);
			
		this.resaltarEmpleadoEMailEmpleado= borderResaltarEmpleadoEMail;

		 return borderResaltarEmpleadoEMail;
	}



	public Boolean mostrarEmpleadoEMailEmpleado=true;

	public Boolean getMostrarEmpleadoEMailEmpleado() {
		return this.mostrarEmpleadoEMailEmpleado;
	}

	public void setMostrarEmpleadoEMailEmpleado(Boolean visibilidadResaltarEmpleadoEMail) {
		this.mostrarEmpleadoEMailEmpleado= visibilidadResaltarEmpleadoEMail;
	}



	public Boolean activarEmpleadoEMailEmpleado=true;

	public Boolean gethabilitarResaltarEmpleadoEMailEmpleado() {
		return this.activarEmpleadoEMailEmpleado;
	}

	public void setActivarEmpleadoEMailEmpleado(Boolean habilitarResaltarEmpleadoEMail) {
		this.activarEmpleadoEMailEmpleado= habilitarResaltarEmpleadoEMail;
	}


	public Border resaltarRasgoPersonalEmpleado=null;

	public Border getResaltarRasgoPersonalEmpleado() {
		return this.resaltarRasgoPersonalEmpleado;
	}

	public void setResaltarRasgoPersonalEmpleado(Border borderResaltarRasgoPersonal) {
		if(borderResaltarRasgoPersonal!=null) {
			this.resaltarRasgoPersonalEmpleado= borderResaltarRasgoPersonal;
		}
	}

	public Border setResaltarRasgoPersonalEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoBeanSwingJInternalFrame empleadoBeanSwingJInternalFrame*/) {
		Border borderResaltarRasgoPersonal=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//empleadoBeanSwingJInternalFrame.jTtoolBarEmpleado.setBorder(borderResaltarRasgoPersonal);
			
		this.resaltarRasgoPersonalEmpleado= borderResaltarRasgoPersonal;

		 return borderResaltarRasgoPersonal;
	}



	public Boolean mostrarRasgoPersonalEmpleado=true;

	public Boolean getMostrarRasgoPersonalEmpleado() {
		return this.mostrarRasgoPersonalEmpleado;
	}

	public void setMostrarRasgoPersonalEmpleado(Boolean visibilidadResaltarRasgoPersonal) {
		this.mostrarRasgoPersonalEmpleado= visibilidadResaltarRasgoPersonal;
	}



	public Boolean activarRasgoPersonalEmpleado=true;

	public Boolean gethabilitarResaltarRasgoPersonalEmpleado() {
		return this.activarRasgoPersonalEmpleado;
	}

	public void setActivarRasgoPersonalEmpleado(Boolean habilitarResaltarRasgoPersonal) {
		this.activarRasgoPersonalEmpleado= habilitarResaltarRasgoPersonal;
	}


	public Border resaltarReferenciaEmpleado=null;

	public Border getResaltarReferenciaEmpleado() {
		return this.resaltarReferenciaEmpleado;
	}

	public void setResaltarReferenciaEmpleado(Border borderResaltarReferencia) {
		if(borderResaltarReferencia!=null) {
			this.resaltarReferenciaEmpleado= borderResaltarReferencia;
		}
	}

	public Border setResaltarReferenciaEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoBeanSwingJInternalFrame empleadoBeanSwingJInternalFrame*/) {
		Border borderResaltarReferencia=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//empleadoBeanSwingJInternalFrame.jTtoolBarEmpleado.setBorder(borderResaltarReferencia);
			
		this.resaltarReferenciaEmpleado= borderResaltarReferencia;

		 return borderResaltarReferencia;
	}



	public Boolean mostrarReferenciaEmpleado=true;

	public Boolean getMostrarReferenciaEmpleado() {
		return this.mostrarReferenciaEmpleado;
	}

	public void setMostrarReferenciaEmpleado(Boolean visibilidadResaltarReferencia) {
		this.mostrarReferenciaEmpleado= visibilidadResaltarReferencia;
	}



	public Boolean activarReferenciaEmpleado=true;

	public Boolean gethabilitarResaltarReferenciaEmpleado() {
		return this.activarReferenciaEmpleado;
	}

	public void setActivarReferenciaEmpleado(Boolean habilitarResaltarReferencia) {
		this.activarReferenciaEmpleado= habilitarResaltarReferencia;
	}


	public Border resaltarTelefono_NMEmpleado=null;

	public Border getResaltarTelefono_NMEmpleado() {
		return this.resaltarTelefono_NMEmpleado;
	}

	public void setResaltarTelefono_NMEmpleado(Border borderResaltarTelefono_NM) {
		if(borderResaltarTelefono_NM!=null) {
			this.resaltarTelefono_NMEmpleado= borderResaltarTelefono_NM;
		}
	}

	public Border setResaltarTelefono_NMEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoBeanSwingJInternalFrame empleadoBeanSwingJInternalFrame*/) {
		Border borderResaltarTelefono_NM=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//empleadoBeanSwingJInternalFrame.jTtoolBarEmpleado.setBorder(borderResaltarTelefono_NM);
			
		this.resaltarTelefono_NMEmpleado= borderResaltarTelefono_NM;

		 return borderResaltarTelefono_NM;
	}



	public Boolean mostrarTelefono_NMEmpleado=true;

	public Boolean getMostrarTelefono_NMEmpleado() {
		return this.mostrarTelefono_NMEmpleado;
	}

	public void setMostrarTelefono_NMEmpleado(Boolean visibilidadResaltarTelefono_NM) {
		this.mostrarTelefono_NMEmpleado= visibilidadResaltarTelefono_NM;
	}



	public Boolean activarTelefono_NMEmpleado=true;

	public Boolean gethabilitarResaltarTelefono_NMEmpleado() {
		return this.activarTelefono_NMEmpleado;
	}

	public void setActivarTelefono_NMEmpleado(Boolean habilitarResaltarTelefono_NM) {
		this.activarTelefono_NMEmpleado= habilitarResaltarTelefono_NM;
	}


	public Border resaltarNovedadEmpleado=null;

	public Border getResaltarNovedadEmpleado() {
		return this.resaltarNovedadEmpleado;
	}

	public void setResaltarNovedadEmpleado(Border borderResaltarNovedad) {
		if(borderResaltarNovedad!=null) {
			this.resaltarNovedadEmpleado= borderResaltarNovedad;
		}
	}

	public Border setResaltarNovedadEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoBeanSwingJInternalFrame empleadoBeanSwingJInternalFrame*/) {
		Border borderResaltarNovedad=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//empleadoBeanSwingJInternalFrame.jTtoolBarEmpleado.setBorder(borderResaltarNovedad);
			
		this.resaltarNovedadEmpleado= borderResaltarNovedad;

		 return borderResaltarNovedad;
	}



	public Boolean mostrarNovedadEmpleado=true;

	public Boolean getMostrarNovedadEmpleado() {
		return this.mostrarNovedadEmpleado;
	}

	public void setMostrarNovedadEmpleado(Boolean visibilidadResaltarNovedad) {
		this.mostrarNovedadEmpleado= visibilidadResaltarNovedad;
	}



	public Boolean activarNovedadEmpleado=true;

	public Boolean gethabilitarResaltarNovedadEmpleado() {
		return this.activarNovedadEmpleado;
	}

	public void setActivarNovedadEmpleado(Boolean habilitarResaltarNovedad) {
		this.activarNovedadEmpleado= habilitarResaltarNovedad;
	}


	public Border resaltarEmpleadoHerraEmpleado=null;

	public Border getResaltarEmpleadoHerraEmpleado() {
		return this.resaltarEmpleadoHerraEmpleado;
	}

	public void setResaltarEmpleadoHerraEmpleado(Border borderResaltarEmpleadoHerra) {
		if(borderResaltarEmpleadoHerra!=null) {
			this.resaltarEmpleadoHerraEmpleado= borderResaltarEmpleadoHerra;
		}
	}

	public Border setResaltarEmpleadoHerraEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoBeanSwingJInternalFrame empleadoBeanSwingJInternalFrame*/) {
		Border borderResaltarEmpleadoHerra=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//empleadoBeanSwingJInternalFrame.jTtoolBarEmpleado.setBorder(borderResaltarEmpleadoHerra);
			
		this.resaltarEmpleadoHerraEmpleado= borderResaltarEmpleadoHerra;

		 return borderResaltarEmpleadoHerra;
	}



	public Boolean mostrarEmpleadoHerraEmpleado=true;

	public Boolean getMostrarEmpleadoHerraEmpleado() {
		return this.mostrarEmpleadoHerraEmpleado;
	}

	public void setMostrarEmpleadoHerraEmpleado(Boolean visibilidadResaltarEmpleadoHerra) {
		this.mostrarEmpleadoHerraEmpleado= visibilidadResaltarEmpleadoHerra;
	}



	public Boolean activarEmpleadoHerraEmpleado=true;

	public Boolean gethabilitarResaltarEmpleadoHerraEmpleado() {
		return this.activarEmpleadoHerraEmpleado;
	}

	public void setActivarEmpleadoHerraEmpleado(Boolean habilitarResaltarEmpleadoHerra) {
		this.activarEmpleadoHerraEmpleado= habilitarResaltarEmpleadoHerra;
	}


	public Border resaltarEmpleadoEnferEmpleado=null;

	public Border getResaltarEmpleadoEnferEmpleado() {
		return this.resaltarEmpleadoEnferEmpleado;
	}

	public void setResaltarEmpleadoEnferEmpleado(Border borderResaltarEmpleadoEnfer) {
		if(borderResaltarEmpleadoEnfer!=null) {
			this.resaltarEmpleadoEnferEmpleado= borderResaltarEmpleadoEnfer;
		}
	}

	public Border setResaltarEmpleadoEnferEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoBeanSwingJInternalFrame empleadoBeanSwingJInternalFrame*/) {
		Border borderResaltarEmpleadoEnfer=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//empleadoBeanSwingJInternalFrame.jTtoolBarEmpleado.setBorder(borderResaltarEmpleadoEnfer);
			
		this.resaltarEmpleadoEnferEmpleado= borderResaltarEmpleadoEnfer;

		 return borderResaltarEmpleadoEnfer;
	}



	public Boolean mostrarEmpleadoEnferEmpleado=true;

	public Boolean getMostrarEmpleadoEnferEmpleado() {
		return this.mostrarEmpleadoEnferEmpleado;
	}

	public void setMostrarEmpleadoEnferEmpleado(Boolean visibilidadResaltarEmpleadoEnfer) {
		this.mostrarEmpleadoEnferEmpleado= visibilidadResaltarEmpleadoEnfer;
	}



	public Boolean activarEmpleadoEnferEmpleado=true;

	public Boolean gethabilitarResaltarEmpleadoEnferEmpleado() {
		return this.activarEmpleadoEnferEmpleado;
	}

	public void setActivarEmpleadoEnferEmpleado(Boolean habilitarResaltarEmpleadoEnfer) {
		this.activarEmpleadoEnferEmpleado= habilitarResaltarEmpleadoEnfer;
	}


	public Border resaltarVisaEmpleado=null;

	public Border getResaltarVisaEmpleado() {
		return this.resaltarVisaEmpleado;
	}

	public void setResaltarVisaEmpleado(Border borderResaltarVisa) {
		if(borderResaltarVisa!=null) {
			this.resaltarVisaEmpleado= borderResaltarVisa;
		}
	}

	public Border setResaltarVisaEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoBeanSwingJInternalFrame empleadoBeanSwingJInternalFrame*/) {
		Border borderResaltarVisa=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//empleadoBeanSwingJInternalFrame.jTtoolBarEmpleado.setBorder(borderResaltarVisa);
			
		this.resaltarVisaEmpleado= borderResaltarVisa;

		 return borderResaltarVisa;
	}



	public Boolean mostrarVisaEmpleado=true;

	public Boolean getMostrarVisaEmpleado() {
		return this.mostrarVisaEmpleado;
	}

	public void setMostrarVisaEmpleado(Boolean visibilidadResaltarVisa) {
		this.mostrarVisaEmpleado= visibilidadResaltarVisa;
	}



	public Boolean activarVisaEmpleado=true;

	public Boolean gethabilitarResaltarVisaEmpleado() {
		return this.activarVisaEmpleado;
	}

	public void setActivarVisaEmpleado(Boolean habilitarResaltarVisa) {
		this.activarVisaEmpleado= habilitarResaltarVisa;
	}


	public Border resaltarSeguroEmpleado=null;

	public Border getResaltarSeguroEmpleado() {
		return this.resaltarSeguroEmpleado;
	}

	public void setResaltarSeguroEmpleado(Border borderResaltarSeguro) {
		if(borderResaltarSeguro!=null) {
			this.resaltarSeguroEmpleado= borderResaltarSeguro;
		}
	}

	public Border setResaltarSeguroEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoBeanSwingJInternalFrame empleadoBeanSwingJInternalFrame*/) {
		Border borderResaltarSeguro=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//empleadoBeanSwingJInternalFrame.jTtoolBarEmpleado.setBorder(borderResaltarSeguro);
			
		this.resaltarSeguroEmpleado= borderResaltarSeguro;

		 return borderResaltarSeguro;
	}



	public Boolean mostrarSeguroEmpleado=true;

	public Boolean getMostrarSeguroEmpleado() {
		return this.mostrarSeguroEmpleado;
	}

	public void setMostrarSeguroEmpleado(Boolean visibilidadResaltarSeguro) {
		this.mostrarSeguroEmpleado= visibilidadResaltarSeguro;
	}



	public Boolean activarSeguroEmpleado=true;

	public Boolean gethabilitarResaltarSeguroEmpleado() {
		return this.activarSeguroEmpleado;
	}

	public void setActivarSeguroEmpleado(Boolean habilitarResaltarSeguro) {
		this.activarSeguroEmpleado= habilitarResaltarSeguro;
	}


	public Border resaltarAsistenciaMensualEmpleado=null;

	public Border getResaltarAsistenciaMensualEmpleado() {
		return this.resaltarAsistenciaMensualEmpleado;
	}

	public void setResaltarAsistenciaMensualEmpleado(Border borderResaltarAsistenciaMensual) {
		if(borderResaltarAsistenciaMensual!=null) {
			this.resaltarAsistenciaMensualEmpleado= borderResaltarAsistenciaMensual;
		}
	}

	public Border setResaltarAsistenciaMensualEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoBeanSwingJInternalFrame empleadoBeanSwingJInternalFrame*/) {
		Border borderResaltarAsistenciaMensual=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//empleadoBeanSwingJInternalFrame.jTtoolBarEmpleado.setBorder(borderResaltarAsistenciaMensual);
			
		this.resaltarAsistenciaMensualEmpleado= borderResaltarAsistenciaMensual;

		 return borderResaltarAsistenciaMensual;
	}



	public Boolean mostrarAsistenciaMensualEmpleado=true;

	public Boolean getMostrarAsistenciaMensualEmpleado() {
		return this.mostrarAsistenciaMensualEmpleado;
	}

	public void setMostrarAsistenciaMensualEmpleado(Boolean visibilidadResaltarAsistenciaMensual) {
		this.mostrarAsistenciaMensualEmpleado= visibilidadResaltarAsistenciaMensual;
	}



	public Boolean activarAsistenciaMensualEmpleado=true;

	public Boolean gethabilitarResaltarAsistenciaMensualEmpleado() {
		return this.activarAsistenciaMensualEmpleado;
	}

	public void setActivarAsistenciaMensualEmpleado(Boolean habilitarResaltarAsistenciaMensual) {
		this.activarAsistenciaMensualEmpleado= habilitarResaltarAsistenciaMensual;
	}


	public Border resaltarEmpleadoDiscaEmpleado=null;

	public Border getResaltarEmpleadoDiscaEmpleado() {
		return this.resaltarEmpleadoDiscaEmpleado;
	}

	public void setResaltarEmpleadoDiscaEmpleado(Border borderResaltarEmpleadoDisca) {
		if(borderResaltarEmpleadoDisca!=null) {
			this.resaltarEmpleadoDiscaEmpleado= borderResaltarEmpleadoDisca;
		}
	}

	public Border setResaltarEmpleadoDiscaEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoBeanSwingJInternalFrame empleadoBeanSwingJInternalFrame*/) {
		Border borderResaltarEmpleadoDisca=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//empleadoBeanSwingJInternalFrame.jTtoolBarEmpleado.setBorder(borderResaltarEmpleadoDisca);
			
		this.resaltarEmpleadoDiscaEmpleado= borderResaltarEmpleadoDisca;

		 return borderResaltarEmpleadoDisca;
	}



	public Boolean mostrarEmpleadoDiscaEmpleado=true;

	public Boolean getMostrarEmpleadoDiscaEmpleado() {
		return this.mostrarEmpleadoDiscaEmpleado;
	}

	public void setMostrarEmpleadoDiscaEmpleado(Boolean visibilidadResaltarEmpleadoDisca) {
		this.mostrarEmpleadoDiscaEmpleado= visibilidadResaltarEmpleadoDisca;
	}



	public Boolean activarEmpleadoDiscaEmpleado=true;

	public Boolean gethabilitarResaltarEmpleadoDiscaEmpleado() {
		return this.activarEmpleadoDiscaEmpleado;
	}

	public void setActivarEmpleadoDiscaEmpleado(Boolean habilitarResaltarEmpleadoDisca) {
		this.activarEmpleadoDiscaEmpleado= habilitarResaltarEmpleadoDisca;
	}


	public Border resaltarProfesionEmpleaEmpleado=null;

	public Border getResaltarProfesionEmpleaEmpleado() {
		return this.resaltarProfesionEmpleaEmpleado;
	}

	public void setResaltarProfesionEmpleaEmpleado(Border borderResaltarProfesionEmplea) {
		if(borderResaltarProfesionEmplea!=null) {
			this.resaltarProfesionEmpleaEmpleado= borderResaltarProfesionEmplea;
		}
	}

	public Border setResaltarProfesionEmpleaEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoBeanSwingJInternalFrame empleadoBeanSwingJInternalFrame*/) {
		Border borderResaltarProfesionEmplea=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//empleadoBeanSwingJInternalFrame.jTtoolBarEmpleado.setBorder(borderResaltarProfesionEmplea);
			
		this.resaltarProfesionEmpleaEmpleado= borderResaltarProfesionEmplea;

		 return borderResaltarProfesionEmplea;
	}



	public Boolean mostrarProfesionEmpleaEmpleado=true;

	public Boolean getMostrarProfesionEmpleaEmpleado() {
		return this.mostrarProfesionEmpleaEmpleado;
	}

	public void setMostrarProfesionEmpleaEmpleado(Boolean visibilidadResaltarProfesionEmplea) {
		this.mostrarProfesionEmpleaEmpleado= visibilidadResaltarProfesionEmplea;
	}



	public Boolean activarProfesionEmpleaEmpleado=true;

	public Boolean gethabilitarResaltarProfesionEmpleaEmpleado() {
		return this.activarProfesionEmpleaEmpleado;
	}

	public void setActivarProfesionEmpleaEmpleado(Boolean habilitarResaltarProfesionEmplea) {
		this.activarProfesionEmpleaEmpleado= habilitarResaltarProfesionEmplea;
	}


	public Border resaltarRubroEmpleadoEmpleado=null;

	public Border getResaltarRubroEmpleadoEmpleado() {
		return this.resaltarRubroEmpleadoEmpleado;
	}

	public void setResaltarRubroEmpleadoEmpleado(Border borderResaltarRubroEmpleado) {
		if(borderResaltarRubroEmpleado!=null) {
			this.resaltarRubroEmpleadoEmpleado= borderResaltarRubroEmpleado;
		}
	}

	public Border setResaltarRubroEmpleadoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoBeanSwingJInternalFrame empleadoBeanSwingJInternalFrame*/) {
		Border borderResaltarRubroEmpleado=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//empleadoBeanSwingJInternalFrame.jTtoolBarEmpleado.setBorder(borderResaltarRubroEmpleado);
			
		this.resaltarRubroEmpleadoEmpleado= borderResaltarRubroEmpleado;

		 return borderResaltarRubroEmpleado;
	}



	public Boolean mostrarRubroEmpleadoEmpleado=true;

	public Boolean getMostrarRubroEmpleadoEmpleado() {
		return this.mostrarRubroEmpleadoEmpleado;
	}

	public void setMostrarRubroEmpleadoEmpleado(Boolean visibilidadResaltarRubroEmpleado) {
		this.mostrarRubroEmpleadoEmpleado= visibilidadResaltarRubroEmpleado;
	}



	public Boolean activarRubroEmpleadoEmpleado=true;

	public Boolean gethabilitarResaltarRubroEmpleadoEmpleado() {
		return this.activarRubroEmpleadoEmpleado;
	}

	public void setActivarRubroEmpleadoEmpleado(Boolean habilitarResaltarRubroEmpleado) {
		this.activarRubroEmpleadoEmpleado= habilitarResaltarRubroEmpleado;
	}


	public Border resaltarEmpleadoConstanteEmpleado=null;

	public Border getResaltarEmpleadoConstanteEmpleado() {
		return this.resaltarEmpleadoConstanteEmpleado;
	}

	public void setResaltarEmpleadoConstanteEmpleado(Border borderResaltarEmpleadoConstante) {
		if(borderResaltarEmpleadoConstante!=null) {
			this.resaltarEmpleadoConstanteEmpleado= borderResaltarEmpleadoConstante;
		}
	}

	public Border setResaltarEmpleadoConstanteEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoBeanSwingJInternalFrame empleadoBeanSwingJInternalFrame*/) {
		Border borderResaltarEmpleadoConstante=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//empleadoBeanSwingJInternalFrame.jTtoolBarEmpleado.setBorder(borderResaltarEmpleadoConstante);
			
		this.resaltarEmpleadoConstanteEmpleado= borderResaltarEmpleadoConstante;

		 return borderResaltarEmpleadoConstante;
	}



	public Boolean mostrarEmpleadoConstanteEmpleado=true;

	public Boolean getMostrarEmpleadoConstanteEmpleado() {
		return this.mostrarEmpleadoConstanteEmpleado;
	}

	public void setMostrarEmpleadoConstanteEmpleado(Boolean visibilidadResaltarEmpleadoConstante) {
		this.mostrarEmpleadoConstanteEmpleado= visibilidadResaltarEmpleadoConstante;
	}



	public Boolean activarEmpleadoConstanteEmpleado=true;

	public Boolean gethabilitarResaltarEmpleadoConstanteEmpleado() {
		return this.activarEmpleadoConstanteEmpleado;
	}

	public void setActivarEmpleadoConstanteEmpleado(Boolean habilitarResaltarEmpleadoConstante) {
		this.activarEmpleadoConstanteEmpleado= habilitarResaltarEmpleadoConstante;
	}


	public Border resaltarTallaVestidoEmpleado=null;

	public Border getResaltarTallaVestidoEmpleado() {
		return this.resaltarTallaVestidoEmpleado;
	}

	public void setResaltarTallaVestidoEmpleado(Border borderResaltarTallaVestido) {
		if(borderResaltarTallaVestido!=null) {
			this.resaltarTallaVestidoEmpleado= borderResaltarTallaVestido;
		}
	}

	public Border setResaltarTallaVestidoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoBeanSwingJInternalFrame empleadoBeanSwingJInternalFrame*/) {
		Border borderResaltarTallaVestido=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//empleadoBeanSwingJInternalFrame.jTtoolBarEmpleado.setBorder(borderResaltarTallaVestido);
			
		this.resaltarTallaVestidoEmpleado= borderResaltarTallaVestido;

		 return borderResaltarTallaVestido;
	}



	public Boolean mostrarTallaVestidoEmpleado=true;

	public Boolean getMostrarTallaVestidoEmpleado() {
		return this.mostrarTallaVestidoEmpleado;
	}

	public void setMostrarTallaVestidoEmpleado(Boolean visibilidadResaltarTallaVestido) {
		this.mostrarTallaVestidoEmpleado= visibilidadResaltarTallaVestido;
	}



	public Boolean activarTallaVestidoEmpleado=true;

	public Boolean gethabilitarResaltarTallaVestidoEmpleado() {
		return this.activarTallaVestidoEmpleado;
	}

	public void setActivarTallaVestidoEmpleado(Boolean habilitarResaltarTallaVestido) {
		this.activarTallaVestidoEmpleado= habilitarResaltarTallaVestido;
	}


	public Border resaltarNovedadNomiEmpleado=null;

	public Border getResaltarNovedadNomiEmpleado() {
		return this.resaltarNovedadNomiEmpleado;
	}

	public void setResaltarNovedadNomiEmpleado(Border borderResaltarNovedadNomi) {
		if(borderResaltarNovedadNomi!=null) {
			this.resaltarNovedadNomiEmpleado= borderResaltarNovedadNomi;
		}
	}

	public Border setResaltarNovedadNomiEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoBeanSwingJInternalFrame empleadoBeanSwingJInternalFrame*/) {
		Border borderResaltarNovedadNomi=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//empleadoBeanSwingJInternalFrame.jTtoolBarEmpleado.setBorder(borderResaltarNovedadNomi);
			
		this.resaltarNovedadNomiEmpleado= borderResaltarNovedadNomi;

		 return borderResaltarNovedadNomi;
	}



	public Boolean mostrarNovedadNomiEmpleado=true;

	public Boolean getMostrarNovedadNomiEmpleado() {
		return this.mostrarNovedadNomiEmpleado;
	}

	public void setMostrarNovedadNomiEmpleado(Boolean visibilidadResaltarNovedadNomi) {
		this.mostrarNovedadNomiEmpleado= visibilidadResaltarNovedadNomi;
	}



	public Boolean activarNovedadNomiEmpleado=true;

	public Boolean gethabilitarResaltarNovedadNomiEmpleado() {
		return this.activarNovedadNomiEmpleado;
	}

	public void setActivarNovedadNomiEmpleado(Boolean habilitarResaltarNovedadNomi) {
		this.activarNovedadNomiEmpleado= habilitarResaltarNovedadNomi;
	}
		
		
	public void setMostrarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}

		this.setMostrarCargaFamiliar_NMEmpleado(esInicial);
		this.setMostrarCursoEmpleado(esInicial);
		this.setMostrarPrestamoEmpleado(esInicial);
		this.setMostrarEmpleadoIdiomaEmpleado(esInicial);
		this.setMostrarHistorialPagoMesNomiEmpleado(esInicial);
		this.setMostrarEmpleadoImpuestoRentaEmpleado(esInicial);
		this.setMostrarDatoGeneralEmpleadoEmpleado(esInicial);
		this.setMostrarAreaEmpleado(esInicial);
		this.setMostrarGastoEmpleadoEmpleado(esInicial);
		this.setMostrarEmpleadoHobbyEmpleado(esInicial);
		this.setMostrarEmpleadoEMailEmpleado(esInicial);
		this.setMostrarRasgoPersonalEmpleado(esInicial);
		this.setMostrarReferenciaEmpleado(esInicial);
		this.setMostrarTelefono_NMEmpleado(esInicial);
		this.setMostrarNovedadEmpleado(esInicial);
		this.setMostrarEmpleadoHerraEmpleado(esInicial);
		this.setMostrarEmpleadoEnferEmpleado(esInicial);
		this.setMostrarVisaEmpleado(esInicial);
		this.setMostrarSeguroEmpleado(esInicial);
		this.setMostrarAsistenciaMensualEmpleado(esInicial);
		this.setMostrarEmpleadoDiscaEmpleado(esInicial);
		this.setMostrarProfesionEmpleaEmpleado(esInicial);
		this.setMostrarRubroEmpleadoEmpleado(esInicial);
		this.setMostrarEmpleadoConstanteEmpleado(esInicial);
		this.setMostrarTallaVestidoEmpleado(esInicial);
		this.setMostrarNovedadNomiEmpleado(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(CargaFamiliar_NM.class)) {
				this.setMostrarCargaFamiliar_NMEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(Curso.class)) {
				this.setMostrarCursoEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(Prestamo.class)) {
				this.setMostrarPrestamoEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(EmpleadoIdioma.class)) {
				this.setMostrarEmpleadoIdiomaEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(HistorialPagoMesNomi.class)) {
				this.setMostrarHistorialPagoMesNomiEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(EmpleadoImpuestoRenta.class)) {
				this.setMostrarEmpleadoImpuestoRentaEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(DatoGeneralEmpleado.class)) {
				this.setMostrarDatoGeneralEmpleadoEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(Area.class)) {
				this.setMostrarAreaEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(GastoEmpleado.class)) {
				this.setMostrarGastoEmpleadoEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(EmpleadoHobby.class)) {
				this.setMostrarEmpleadoHobbyEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(EmpleadoEMail.class)) {
				this.setMostrarEmpleadoEMailEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(RasgoPersonal.class)) {
				this.setMostrarRasgoPersonalEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(Referencia.class)) {
				this.setMostrarReferenciaEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(Telefono_NM.class)) {
				this.setMostrarTelefono_NMEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(Novedad.class)) {
				this.setMostrarNovedadEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(EmpleadoHerra.class)) {
				this.setMostrarEmpleadoHerraEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(EmpleadoEnfer.class)) {
				this.setMostrarEmpleadoEnferEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(Visa.class)) {
				this.setMostrarVisaEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(Seguro.class)) {
				this.setMostrarSeguroEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(AsistenciaMensual.class)) {
				this.setMostrarAsistenciaMensualEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(EmpleadoDisca.class)) {
				this.setMostrarEmpleadoDiscaEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(ProfesionEmplea.class)) {
				this.setMostrarProfesionEmpleaEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(RubroEmpleado.class)) {
				this.setMostrarRubroEmpleadoEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(EmpleadoConstante.class)) {
				this.setMostrarEmpleadoConstanteEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(TallaVestido.class)) {
				this.setMostrarTallaVestidoEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(NovedadNomi.class)) {
				this.setMostrarNovedadNomiEmpleado(esAsigna);
				continue;
			}
		}		
	}
	
	public void setActivarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}

		this.setActivarCargaFamiliar_NMEmpleado(esInicial);
		this.setActivarCursoEmpleado(esInicial);
		this.setActivarPrestamoEmpleado(esInicial);
		this.setActivarEmpleadoIdiomaEmpleado(esInicial);
		this.setActivarHistorialPagoMesNomiEmpleado(esInicial);
		this.setActivarEmpleadoImpuestoRentaEmpleado(esInicial);
		this.setActivarDatoGeneralEmpleadoEmpleado(esInicial);
		this.setActivarAreaEmpleado(esInicial);
		this.setActivarGastoEmpleadoEmpleado(esInicial);
		this.setActivarEmpleadoHobbyEmpleado(esInicial);
		this.setActivarEmpleadoEMailEmpleado(esInicial);
		this.setActivarRasgoPersonalEmpleado(esInicial);
		this.setActivarReferenciaEmpleado(esInicial);
		this.setActivarTelefono_NMEmpleado(esInicial);
		this.setActivarNovedadEmpleado(esInicial);
		this.setActivarEmpleadoHerraEmpleado(esInicial);
		this.setActivarEmpleadoEnferEmpleado(esInicial);
		this.setActivarVisaEmpleado(esInicial);
		this.setActivarSeguroEmpleado(esInicial);
		this.setActivarAsistenciaMensualEmpleado(esInicial);
		this.setActivarEmpleadoDiscaEmpleado(esInicial);
		this.setActivarProfesionEmpleaEmpleado(esInicial);
		this.setActivarRubroEmpleadoEmpleado(esInicial);
		this.setActivarEmpleadoConstanteEmpleado(esInicial);
		this.setActivarTallaVestidoEmpleado(esInicial);
		this.setActivarNovedadNomiEmpleado(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(CargaFamiliar_NM.class)) {
				this.setActivarCargaFamiliar_NMEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(Curso.class)) {
				this.setActivarCursoEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(Prestamo.class)) {
				this.setActivarPrestamoEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(EmpleadoIdioma.class)) {
				this.setActivarEmpleadoIdiomaEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(HistorialPagoMesNomi.class)) {
				this.setActivarHistorialPagoMesNomiEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(EmpleadoImpuestoRenta.class)) {
				this.setActivarEmpleadoImpuestoRentaEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(DatoGeneralEmpleado.class)) {
				this.setActivarDatoGeneralEmpleadoEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(Area.class)) {
				this.setActivarAreaEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(GastoEmpleado.class)) {
				this.setActivarGastoEmpleadoEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(EmpleadoHobby.class)) {
				this.setActivarEmpleadoHobbyEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(EmpleadoEMail.class)) {
				this.setActivarEmpleadoEMailEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(RasgoPersonal.class)) {
				this.setActivarRasgoPersonalEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(Referencia.class)) {
				this.setActivarReferenciaEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(Telefono_NM.class)) {
				this.setActivarTelefono_NMEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(Novedad.class)) {
				this.setActivarNovedadEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(EmpleadoHerra.class)) {
				this.setActivarEmpleadoHerraEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(EmpleadoEnfer.class)) {
				this.setActivarEmpleadoEnferEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(Visa.class)) {
				this.setActivarVisaEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(Seguro.class)) {
				this.setActivarSeguroEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(AsistenciaMensual.class)) {
				this.setActivarAsistenciaMensualEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(EmpleadoDisca.class)) {
				this.setActivarEmpleadoDiscaEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(ProfesionEmplea.class)) {
				this.setActivarProfesionEmpleaEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(RubroEmpleado.class)) {
				this.setActivarRubroEmpleadoEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(EmpleadoConstante.class)) {
				this.setActivarEmpleadoConstanteEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(TallaVestido.class)) {
				this.setActivarTallaVestidoEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(NovedadNomi.class)) {
				this.setActivarNovedadNomiEmpleado(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EmpleadoBeanSwingJInternalFrame empleadoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarCargaFamiliar_NMEmpleado(esInicial);
		this.setResaltarCursoEmpleado(esInicial);
		this.setResaltarPrestamoEmpleado(esInicial);
		this.setResaltarEmpleadoIdiomaEmpleado(esInicial);
		this.setResaltarHistorialPagoMesNomiEmpleado(esInicial);
		this.setResaltarEmpleadoImpuestoRentaEmpleado(esInicial);
		this.setResaltarDatoGeneralEmpleadoEmpleado(esInicial);
		this.setResaltarAreaEmpleado(esInicial);
		this.setResaltarGastoEmpleadoEmpleado(esInicial);
		this.setResaltarEmpleadoHobbyEmpleado(esInicial);
		this.setResaltarEmpleadoEMailEmpleado(esInicial);
		this.setResaltarRasgoPersonalEmpleado(esInicial);
		this.setResaltarReferenciaEmpleado(esInicial);
		this.setResaltarTelefono_NMEmpleado(esInicial);
		this.setResaltarNovedadEmpleado(esInicial);
		this.setResaltarEmpleadoHerraEmpleado(esInicial);
		this.setResaltarEmpleadoEnferEmpleado(esInicial);
		this.setResaltarVisaEmpleado(esInicial);
		this.setResaltarSeguroEmpleado(esInicial);
		this.setResaltarAsistenciaMensualEmpleado(esInicial);
		this.setResaltarEmpleadoDiscaEmpleado(esInicial);
		this.setResaltarProfesionEmpleaEmpleado(esInicial);
		this.setResaltarRubroEmpleadoEmpleado(esInicial);
		this.setResaltarEmpleadoConstanteEmpleado(esInicial);
		this.setResaltarTallaVestidoEmpleado(esInicial);
		this.setResaltarNovedadNomiEmpleado(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(CargaFamiliar_NM.class)) {
				this.setResaltarCargaFamiliar_NMEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(Curso.class)) {
				this.setResaltarCursoEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(Prestamo.class)) {
				this.setResaltarPrestamoEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(EmpleadoIdioma.class)) {
				this.setResaltarEmpleadoIdiomaEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(HistorialPagoMesNomi.class)) {
				this.setResaltarHistorialPagoMesNomiEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(EmpleadoImpuestoRenta.class)) {
				this.setResaltarEmpleadoImpuestoRentaEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(DatoGeneralEmpleado.class)) {
				this.setResaltarDatoGeneralEmpleadoEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(Area.class)) {
				this.setResaltarAreaEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(GastoEmpleado.class)) {
				this.setResaltarGastoEmpleadoEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(EmpleadoHobby.class)) {
				this.setResaltarEmpleadoHobbyEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(EmpleadoEMail.class)) {
				this.setResaltarEmpleadoEMailEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(RasgoPersonal.class)) {
				this.setResaltarRasgoPersonalEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(Referencia.class)) {
				this.setResaltarReferenciaEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(Telefono_NM.class)) {
				this.setResaltarTelefono_NMEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(Novedad.class)) {
				this.setResaltarNovedadEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(EmpleadoHerra.class)) {
				this.setResaltarEmpleadoHerraEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(EmpleadoEnfer.class)) {
				this.setResaltarEmpleadoEnferEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(Visa.class)) {
				this.setResaltarVisaEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(Seguro.class)) {
				this.setResaltarSeguroEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(AsistenciaMensual.class)) {
				this.setResaltarAsistenciaMensualEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(EmpleadoDisca.class)) {
				this.setResaltarEmpleadoDiscaEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(ProfesionEmplea.class)) {
				this.setResaltarProfesionEmpleaEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(RubroEmpleado.class)) {
				this.setResaltarRubroEmpleadoEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(EmpleadoConstante.class)) {
				this.setResaltarEmpleadoConstanteEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(TallaVestido.class)) {
				this.setResaltarTallaVestidoEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(NovedadNomi.class)) {
				this.setResaltarNovedadNomiEmpleado(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdCargoEmpleado=true;

	public Boolean getMostrarFK_IdCargoEmpleado() {
		return this.mostrarFK_IdCargoEmpleado;
	}

	public void setMostrarFK_IdCargoEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCargoEmpleado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCentroCostoEmpleado=true;

	public Boolean getMostrarFK_IdCentroCostoEmpleado() {
		return this.mostrarFK_IdCentroCostoEmpleado;
	}

	public void setMostrarFK_IdCentroCostoEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCentroCostoEmpleado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCiudadEmpleado=true;

	public Boolean getMostrarFK_IdCiudadEmpleado() {
		return this.mostrarFK_IdCiudadEmpleado;
	}

	public void setMostrarFK_IdCiudadEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCiudadEmpleado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaEmpleado=true;

	public Boolean getMostrarFK_IdEmpresaEmpleado() {
		return this.mostrarFK_IdEmpresaEmpleado;
	}

	public void setMostrarFK_IdEmpresaEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaEmpleado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstadoCivilEmpleado=true;

	public Boolean getMostrarFK_IdEstadoCivilEmpleado() {
		return this.mostrarFK_IdEstadoCivilEmpleado;
	}

	public void setMostrarFK_IdEstadoCivilEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstadoCivilEmpleado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstadoEmpleadoEmpleado=true;

	public Boolean getMostrarFK_IdEstadoEmpleadoEmpleado() {
		return this.mostrarFK_IdEstadoEmpleadoEmpleado;
	}

	public void setMostrarFK_IdEstadoEmpleadoEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstadoEmpleadoEmpleado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstructuraEmpleado=true;

	public Boolean getMostrarFK_IdEstructuraEmpleado() {
		return this.mostrarFK_IdEstructuraEmpleado;
	}

	public void setMostrarFK_IdEstructuraEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstructuraEmpleado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstructuraSeccionEmpleado=true;

	public Boolean getMostrarFK_IdEstructuraSeccionEmpleado() {
		return this.mostrarFK_IdEstructuraSeccionEmpleado;
	}

	public void setMostrarFK_IdEstructuraSeccionEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstructuraSeccionEmpleado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPaisEmpleado=true;

	public Boolean getMostrarFK_IdPaisEmpleado() {
		return this.mostrarFK_IdPaisEmpleado;
	}

	public void setMostrarFK_IdPaisEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPaisEmpleado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdProvinciaEmpleado=true;

	public Boolean getMostrarFK_IdProvinciaEmpleado() {
		return this.mostrarFK_IdProvinciaEmpleado;
	}

	public void setMostrarFK_IdProvinciaEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdProvinciaEmpleado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdReligionEmpleado=true;

	public Boolean getMostrarFK_IdReligionEmpleado() {
		return this.mostrarFK_IdReligionEmpleado;
	}

	public void setMostrarFK_IdReligionEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdReligionEmpleado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalEmpleado=true;

	public Boolean getMostrarFK_IdSucursalEmpleado() {
		return this.mostrarFK_IdSucursalEmpleado;
	}

	public void setMostrarFK_IdSucursalEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalEmpleado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoContratoEmpleado=true;

	public Boolean getMostrarFK_IdTipoContratoEmpleado() {
		return this.mostrarFK_IdTipoContratoEmpleado;
	}

	public void setMostrarFK_IdTipoContratoEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoContratoEmpleado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoCuentaBancoGlobalEmpleado=true;

	public Boolean getMostrarFK_IdTipoCuentaBancoGlobalEmpleado() {
		return this.mostrarFK_IdTipoCuentaBancoGlobalEmpleado;
	}

	public void setMostrarFK_IdTipoCuentaBancoGlobalEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoCuentaBancoGlobalEmpleado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoEmpleadoEmpleado=true;

	public Boolean getMostrarFK_IdTipoEmpleadoEmpleado() {
		return this.mostrarFK_IdTipoEmpleadoEmpleado;
	}

	public void setMostrarFK_IdTipoEmpleadoEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoEmpleadoEmpleado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoGeneroEmpleado=true;

	public Boolean getMostrarFK_IdTipoGeneroEmpleado() {
		return this.mostrarFK_IdTipoGeneroEmpleado;
	}

	public void setMostrarFK_IdTipoGeneroEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoGeneroEmpleado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoInstruccionEmpleado=true;

	public Boolean getMostrarFK_IdTipoInstruccionEmpleado() {
		return this.mostrarFK_IdTipoInstruccionEmpleado;
	}

	public void setMostrarFK_IdTipoInstruccionEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoInstruccionEmpleado= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdCargoEmpleado=true;

	public Boolean getActivarFK_IdCargoEmpleado() {
		return this.activarFK_IdCargoEmpleado;
	}

	public void setActivarFK_IdCargoEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdCargoEmpleado= habilitarResaltar;
	}

	public Boolean activarFK_IdCentroCostoEmpleado=true;

	public Boolean getActivarFK_IdCentroCostoEmpleado() {
		return this.activarFK_IdCentroCostoEmpleado;
	}

	public void setActivarFK_IdCentroCostoEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdCentroCostoEmpleado= habilitarResaltar;
	}

	public Boolean activarFK_IdCiudadEmpleado=true;

	public Boolean getActivarFK_IdCiudadEmpleado() {
		return this.activarFK_IdCiudadEmpleado;
	}

	public void setActivarFK_IdCiudadEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdCiudadEmpleado= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaEmpleado=true;

	public Boolean getActivarFK_IdEmpresaEmpleado() {
		return this.activarFK_IdEmpresaEmpleado;
	}

	public void setActivarFK_IdEmpresaEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaEmpleado= habilitarResaltar;
	}

	public Boolean activarFK_IdEstadoCivilEmpleado=true;

	public Boolean getActivarFK_IdEstadoCivilEmpleado() {
		return this.activarFK_IdEstadoCivilEmpleado;
	}

	public void setActivarFK_IdEstadoCivilEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdEstadoCivilEmpleado= habilitarResaltar;
	}

	public Boolean activarFK_IdEstadoEmpleadoEmpleado=true;

	public Boolean getActivarFK_IdEstadoEmpleadoEmpleado() {
		return this.activarFK_IdEstadoEmpleadoEmpleado;
	}

	public void setActivarFK_IdEstadoEmpleadoEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdEstadoEmpleadoEmpleado= habilitarResaltar;
	}

	public Boolean activarFK_IdEstructuraEmpleado=true;

	public Boolean getActivarFK_IdEstructuraEmpleado() {
		return this.activarFK_IdEstructuraEmpleado;
	}

	public void setActivarFK_IdEstructuraEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdEstructuraEmpleado= habilitarResaltar;
	}

	public Boolean activarFK_IdEstructuraSeccionEmpleado=true;

	public Boolean getActivarFK_IdEstructuraSeccionEmpleado() {
		return this.activarFK_IdEstructuraSeccionEmpleado;
	}

	public void setActivarFK_IdEstructuraSeccionEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdEstructuraSeccionEmpleado= habilitarResaltar;
	}

	public Boolean activarFK_IdPaisEmpleado=true;

	public Boolean getActivarFK_IdPaisEmpleado() {
		return this.activarFK_IdPaisEmpleado;
	}

	public void setActivarFK_IdPaisEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdPaisEmpleado= habilitarResaltar;
	}

	public Boolean activarFK_IdProvinciaEmpleado=true;

	public Boolean getActivarFK_IdProvinciaEmpleado() {
		return this.activarFK_IdProvinciaEmpleado;
	}

	public void setActivarFK_IdProvinciaEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdProvinciaEmpleado= habilitarResaltar;
	}

	public Boolean activarFK_IdReligionEmpleado=true;

	public Boolean getActivarFK_IdReligionEmpleado() {
		return this.activarFK_IdReligionEmpleado;
	}

	public void setActivarFK_IdReligionEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdReligionEmpleado= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalEmpleado=true;

	public Boolean getActivarFK_IdSucursalEmpleado() {
		return this.activarFK_IdSucursalEmpleado;
	}

	public void setActivarFK_IdSucursalEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalEmpleado= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoContratoEmpleado=true;

	public Boolean getActivarFK_IdTipoContratoEmpleado() {
		return this.activarFK_IdTipoContratoEmpleado;
	}

	public void setActivarFK_IdTipoContratoEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdTipoContratoEmpleado= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoCuentaBancoGlobalEmpleado=true;

	public Boolean getActivarFK_IdTipoCuentaBancoGlobalEmpleado() {
		return this.activarFK_IdTipoCuentaBancoGlobalEmpleado;
	}

	public void setActivarFK_IdTipoCuentaBancoGlobalEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdTipoCuentaBancoGlobalEmpleado= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoEmpleadoEmpleado=true;

	public Boolean getActivarFK_IdTipoEmpleadoEmpleado() {
		return this.activarFK_IdTipoEmpleadoEmpleado;
	}

	public void setActivarFK_IdTipoEmpleadoEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdTipoEmpleadoEmpleado= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoGeneroEmpleado=true;

	public Boolean getActivarFK_IdTipoGeneroEmpleado() {
		return this.activarFK_IdTipoGeneroEmpleado;
	}

	public void setActivarFK_IdTipoGeneroEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdTipoGeneroEmpleado= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoInstruccionEmpleado=true;

	public Boolean getActivarFK_IdTipoInstruccionEmpleado() {
		return this.activarFK_IdTipoInstruccionEmpleado;
	}

	public void setActivarFK_IdTipoInstruccionEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdTipoInstruccionEmpleado= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdCargoEmpleado=null;

	public Border getResaltarFK_IdCargoEmpleado() {
		return this.resaltarFK_IdCargoEmpleado;
	}

	public void setResaltarFK_IdCargoEmpleado(Border borderResaltar) {
		this.resaltarFK_IdCargoEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdCargoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoBeanSwingJInternalFrame empleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCargoEmpleado= borderResaltar;
	}

	public Border resaltarFK_IdCentroCostoEmpleado=null;

	public Border getResaltarFK_IdCentroCostoEmpleado() {
		return this.resaltarFK_IdCentroCostoEmpleado;
	}

	public void setResaltarFK_IdCentroCostoEmpleado(Border borderResaltar) {
		this.resaltarFK_IdCentroCostoEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdCentroCostoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoBeanSwingJInternalFrame empleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCentroCostoEmpleado= borderResaltar;
	}

	public Border resaltarFK_IdCiudadEmpleado=null;

	public Border getResaltarFK_IdCiudadEmpleado() {
		return this.resaltarFK_IdCiudadEmpleado;
	}

	public void setResaltarFK_IdCiudadEmpleado(Border borderResaltar) {
		this.resaltarFK_IdCiudadEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdCiudadEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoBeanSwingJInternalFrame empleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCiudadEmpleado= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaEmpleado=null;

	public Border getResaltarFK_IdEmpresaEmpleado() {
		return this.resaltarFK_IdEmpresaEmpleado;
	}

	public void setResaltarFK_IdEmpresaEmpleado(Border borderResaltar) {
		this.resaltarFK_IdEmpresaEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoBeanSwingJInternalFrame empleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaEmpleado= borderResaltar;
	}

	public Border resaltarFK_IdEstadoCivilEmpleado=null;

	public Border getResaltarFK_IdEstadoCivilEmpleado() {
		return this.resaltarFK_IdEstadoCivilEmpleado;
	}

	public void setResaltarFK_IdEstadoCivilEmpleado(Border borderResaltar) {
		this.resaltarFK_IdEstadoCivilEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdEstadoCivilEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoBeanSwingJInternalFrame empleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstadoCivilEmpleado= borderResaltar;
	}

	public Border resaltarFK_IdEstadoEmpleadoEmpleado=null;

	public Border getResaltarFK_IdEstadoEmpleadoEmpleado() {
		return this.resaltarFK_IdEstadoEmpleadoEmpleado;
	}

	public void setResaltarFK_IdEstadoEmpleadoEmpleado(Border borderResaltar) {
		this.resaltarFK_IdEstadoEmpleadoEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdEstadoEmpleadoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoBeanSwingJInternalFrame empleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstadoEmpleadoEmpleado= borderResaltar;
	}

	public Border resaltarFK_IdEstructuraEmpleado=null;

	public Border getResaltarFK_IdEstructuraEmpleado() {
		return this.resaltarFK_IdEstructuraEmpleado;
	}

	public void setResaltarFK_IdEstructuraEmpleado(Border borderResaltar) {
		this.resaltarFK_IdEstructuraEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdEstructuraEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoBeanSwingJInternalFrame empleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstructuraEmpleado= borderResaltar;
	}

	public Border resaltarFK_IdEstructuraSeccionEmpleado=null;

	public Border getResaltarFK_IdEstructuraSeccionEmpleado() {
		return this.resaltarFK_IdEstructuraSeccionEmpleado;
	}

	public void setResaltarFK_IdEstructuraSeccionEmpleado(Border borderResaltar) {
		this.resaltarFK_IdEstructuraSeccionEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdEstructuraSeccionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoBeanSwingJInternalFrame empleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstructuraSeccionEmpleado= borderResaltar;
	}

	public Border resaltarFK_IdPaisEmpleado=null;

	public Border getResaltarFK_IdPaisEmpleado() {
		return this.resaltarFK_IdPaisEmpleado;
	}

	public void setResaltarFK_IdPaisEmpleado(Border borderResaltar) {
		this.resaltarFK_IdPaisEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdPaisEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoBeanSwingJInternalFrame empleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPaisEmpleado= borderResaltar;
	}

	public Border resaltarFK_IdProvinciaEmpleado=null;

	public Border getResaltarFK_IdProvinciaEmpleado() {
		return this.resaltarFK_IdProvinciaEmpleado;
	}

	public void setResaltarFK_IdProvinciaEmpleado(Border borderResaltar) {
		this.resaltarFK_IdProvinciaEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdProvinciaEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoBeanSwingJInternalFrame empleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdProvinciaEmpleado= borderResaltar;
	}

	public Border resaltarFK_IdReligionEmpleado=null;

	public Border getResaltarFK_IdReligionEmpleado() {
		return this.resaltarFK_IdReligionEmpleado;
	}

	public void setResaltarFK_IdReligionEmpleado(Border borderResaltar) {
		this.resaltarFK_IdReligionEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdReligionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoBeanSwingJInternalFrame empleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdReligionEmpleado= borderResaltar;
	}

	public Border resaltarFK_IdSucursalEmpleado=null;

	public Border getResaltarFK_IdSucursalEmpleado() {
		return this.resaltarFK_IdSucursalEmpleado;
	}

	public void setResaltarFK_IdSucursalEmpleado(Border borderResaltar) {
		this.resaltarFK_IdSucursalEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdSucursalEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoBeanSwingJInternalFrame empleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalEmpleado= borderResaltar;
	}

	public Border resaltarFK_IdTipoContratoEmpleado=null;

	public Border getResaltarFK_IdTipoContratoEmpleado() {
		return this.resaltarFK_IdTipoContratoEmpleado;
	}

	public void setResaltarFK_IdTipoContratoEmpleado(Border borderResaltar) {
		this.resaltarFK_IdTipoContratoEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdTipoContratoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoBeanSwingJInternalFrame empleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoContratoEmpleado= borderResaltar;
	}

	public Border resaltarFK_IdTipoCuentaBancoGlobalEmpleado=null;

	public Border getResaltarFK_IdTipoCuentaBancoGlobalEmpleado() {
		return this.resaltarFK_IdTipoCuentaBancoGlobalEmpleado;
	}

	public void setResaltarFK_IdTipoCuentaBancoGlobalEmpleado(Border borderResaltar) {
		this.resaltarFK_IdTipoCuentaBancoGlobalEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdTipoCuentaBancoGlobalEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoBeanSwingJInternalFrame empleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoCuentaBancoGlobalEmpleado= borderResaltar;
	}

	public Border resaltarFK_IdTipoEmpleadoEmpleado=null;

	public Border getResaltarFK_IdTipoEmpleadoEmpleado() {
		return this.resaltarFK_IdTipoEmpleadoEmpleado;
	}

	public void setResaltarFK_IdTipoEmpleadoEmpleado(Border borderResaltar) {
		this.resaltarFK_IdTipoEmpleadoEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdTipoEmpleadoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoBeanSwingJInternalFrame empleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoEmpleadoEmpleado= borderResaltar;
	}

	public Border resaltarFK_IdTipoGeneroEmpleado=null;

	public Border getResaltarFK_IdTipoGeneroEmpleado() {
		return this.resaltarFK_IdTipoGeneroEmpleado;
	}

	public void setResaltarFK_IdTipoGeneroEmpleado(Border borderResaltar) {
		this.resaltarFK_IdTipoGeneroEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdTipoGeneroEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoBeanSwingJInternalFrame empleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoGeneroEmpleado= borderResaltar;
	}

	public Border resaltarFK_IdTipoInstruccionEmpleado=null;

	public Border getResaltarFK_IdTipoInstruccionEmpleado() {
		return this.resaltarFK_IdTipoInstruccionEmpleado;
	}

	public void setResaltarFK_IdTipoInstruccionEmpleado(Border borderResaltar) {
		this.resaltarFK_IdTipoInstruccionEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdTipoInstruccionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoBeanSwingJInternalFrame empleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoInstruccionEmpleado= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}