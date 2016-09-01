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
package com.bydan.erp.nomina.util.report;

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


import com.bydan.erp.nomina.util.report.CreditosPendientesConstantesFunciones;
import com.bydan.erp.nomina.util.report.CreditosPendientesParameterReturnGeneral;
//import com.bydan.erp.nomina.util.report.CreditosPendientesParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.nomina.business.entity.report.*;



import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.nomina.util.*;
import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class CreditosPendientesConstantesFunciones{		
	
	
	
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
	
	
	public static final String SFINALQUERY="";	
	public static final String SNOMBREOPCION="CreditosPendientes";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="CreditosPendientes"+CreditosPendientesConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="CreditosPendientesHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="CreditosPendientesHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=CreditosPendientesConstantesFunciones.SCHEMA+"_"+CreditosPendientesConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/CreditosPendientesHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=CreditosPendientesConstantesFunciones.SCHEMA+"_"+CreditosPendientesConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=CreditosPendientesConstantesFunciones.SCHEMA+"_"+CreditosPendientesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/CreditosPendientesHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=CreditosPendientesConstantesFunciones.SCHEMA+"_"+CreditosPendientesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CreditosPendientesConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CreditosPendientesHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CreditosPendientesConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CreditosPendientesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CreditosPendientesHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CreditosPendientesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=CreditosPendientesConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+CreditosPendientesConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=CreditosPendientesConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+CreditosPendientesConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Creditos Pendienteses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Creditos Pendientes";
	public static final String SCLASSWEBTITULO_LOWER="Creditos Pendientes";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="CreditosPendientes";
	public static final String OBJECTNAME="creditospendientes";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="creditos_pendientes";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select creditospendientes from "+CreditosPendientesConstantesFunciones.SPERSISTENCENAME+" creditospendientes";
	public static String QUERYSELECTNATIVE="select "+CreditosPendientesConstantesFunciones.SCHEMA+"."+CreditosPendientesConstantesFunciones.TABLENAME+".id,"+CreditosPendientesConstantesFunciones.SCHEMA+"."+CreditosPendientesConstantesFunciones.TABLENAME+".version_row,"+CreditosPendientesConstantesFunciones.SCHEMA+"."+CreditosPendientesConstantesFunciones.TABLENAME+".id_cargo,"+CreditosPendientesConstantesFunciones.SCHEMA+"."+CreditosPendientesConstantesFunciones.TABLENAME+".id_estructura,"+CreditosPendientesConstantesFunciones.SCHEMA+"."+CreditosPendientesConstantesFunciones.TABLENAME+".id_empresa,"+CreditosPendientesConstantesFunciones.SCHEMA+"."+CreditosPendientesConstantesFunciones.TABLENAME+".id_empleado,"+CreditosPendientesConstantesFunciones.SCHEMA+"."+CreditosPendientesConstantesFunciones.TABLENAME+".fecha_vencimiento_desde,"+CreditosPendientesConstantesFunciones.SCHEMA+"."+CreditosPendientesConstantesFunciones.TABLENAME+".fecha_vencimiento_hasta,"+CreditosPendientesConstantesFunciones.SCHEMA+"."+CreditosPendientesConstantesFunciones.TABLENAME+".codigo,"+CreditosPendientesConstantesFunciones.SCHEMA+"."+CreditosPendientesConstantesFunciones.TABLENAME+".nombre_completo,"+CreditosPendientesConstantesFunciones.SCHEMA+"."+CreditosPendientesConstantesFunciones.TABLENAME+".codigo_tipo_prestamo,"+CreditosPendientesConstantesFunciones.SCHEMA+"."+CreditosPendientesConstantesFunciones.TABLENAME+".codigo_prestamo,"+CreditosPendientesConstantesFunciones.SCHEMA+"."+CreditosPendientesConstantesFunciones.TABLENAME+".numero,"+CreditosPendientesConstantesFunciones.SCHEMA+"."+CreditosPendientesConstantesFunciones.TABLENAME+".monto_capital,"+CreditosPendientesConstantesFunciones.SCHEMA+"."+CreditosPendientesConstantesFunciones.TABLENAME+".monto_interes,"+CreditosPendientesConstantesFunciones.SCHEMA+"."+CreditosPendientesConstantesFunciones.TABLENAME+".valor,"+CreditosPendientesConstantesFunciones.SCHEMA+"."+CreditosPendientesConstantesFunciones.TABLENAME+".saldo from "+CreditosPendientesConstantesFunciones.SCHEMA+"."+CreditosPendientesConstantesFunciones.TABLENAME;//+" as "+CreditosPendientesConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDCARGO= "id_cargo";
    public static final String IDESTRUCTURA= "id_estructura";
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String FECHAVENCIMIENTODESDE= "fecha_vencimiento_desde";
    public static final String FECHAVENCIMIENTOHASTA= "fecha_vencimiento_hasta";
    public static final String CODIGO= "codigo";
    public static final String NOMBRECOMPLETO= "nombre_completo";
    public static final String CODIGOTIPOPRESTAMO= "codigo_tipo_prestamo";
    public static final String CODIGOPRESTAMO= "codigo_prestamo";
    public static final String NUMERO= "numero";
    public static final String MONTOCAPITAL= "monto_capital";
    public static final String MONTOINTERES= "monto_interes";
    public static final String VALOR= "valor";
    public static final String SALDO= "saldo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDCARGO= "Cargo";
		public static final String LABEL_IDCARGO_LOWER= "Cargo";
    	public static final String LABEL_IDESTRUCTURA= "Estructura";
		public static final String LABEL_IDESTRUCTURA_LOWER= "Estructura";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDEMPLEADO= "Empleado";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
    	public static final String LABEL_FECHAVENCIMIENTODESDE= "Fecha Vencimiento Desde";
		public static final String LABEL_FECHAVENCIMIENTODESDE_LOWER= "Fecha Vencimiento Desde";
    	public static final String LABEL_FECHAVENCIMIENTOHASTA= "Fecha Vencimiento Hasta";
		public static final String LABEL_FECHAVENCIMIENTOHASTA_LOWER= "Fecha Vencimiento Hasta";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRECOMPLETO= "Nombre Completo";
		public static final String LABEL_NOMBRECOMPLETO_LOWER= "Nombre Completo";
    	public static final String LABEL_CODIGOTIPOPRESTAMO= "Codigo Tipo Prestamo";
		public static final String LABEL_CODIGOTIPOPRESTAMO_LOWER= "Codigo Tipo Prestamo";
    	public static final String LABEL_CODIGOPRESTAMO= "Codigo Prestamo";
		public static final String LABEL_CODIGOPRESTAMO_LOWER= "Codigo Prestamo";
    	public static final String LABEL_NUMERO= "Numero";
		public static final String LABEL_NUMERO_LOWER= "Numero";
    	public static final String LABEL_MONTOCAPITAL= "Monto Capital";
		public static final String LABEL_MONTOCAPITAL_LOWER= "Monto Capital";
    	public static final String LABEL_MONTOINTERES= "Monto Interes";
		public static final String LABEL_MONTOINTERES_LOWER= "Monto Interes";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
    	public static final String LABEL_SALDO= "Saldo";
		public static final String LABEL_SALDO_LOWER= "Saldo";
	
		
		
		
		
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_COMPLETO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_COMPLETO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO_TIPO_PRESTAMO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_TIPO_PRESTAMO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO_PRESTAMO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_PRESTAMO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
	
	public static String getCreditosPendientesLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(CreditosPendientesConstantesFunciones.IDCARGO)) {sLabelColumna=CreditosPendientesConstantesFunciones.LABEL_IDCARGO;}
		if(sNombreColumna.equals(CreditosPendientesConstantesFunciones.IDESTRUCTURA)) {sLabelColumna=CreditosPendientesConstantesFunciones.LABEL_IDESTRUCTURA;}
		if(sNombreColumna.equals(CreditosPendientesConstantesFunciones.IDEMPRESA)) {sLabelColumna=CreditosPendientesConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(CreditosPendientesConstantesFunciones.IDEMPLEADO)) {sLabelColumna=CreditosPendientesConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(CreditosPendientesConstantesFunciones.FECHAVENCIMIENTODESDE)) {sLabelColumna=CreditosPendientesConstantesFunciones.LABEL_FECHAVENCIMIENTODESDE;}
		if(sNombreColumna.equals(CreditosPendientesConstantesFunciones.FECHAVENCIMIENTOHASTA)) {sLabelColumna=CreditosPendientesConstantesFunciones.LABEL_FECHAVENCIMIENTOHASTA;}
		if(sNombreColumna.equals(CreditosPendientesConstantesFunciones.CODIGO)) {sLabelColumna=CreditosPendientesConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(CreditosPendientesConstantesFunciones.NOMBRECOMPLETO)) {sLabelColumna=CreditosPendientesConstantesFunciones.LABEL_NOMBRECOMPLETO;}
		if(sNombreColumna.equals(CreditosPendientesConstantesFunciones.CODIGOTIPOPRESTAMO)) {sLabelColumna=CreditosPendientesConstantesFunciones.LABEL_CODIGOTIPOPRESTAMO;}
		if(sNombreColumna.equals(CreditosPendientesConstantesFunciones.CODIGOPRESTAMO)) {sLabelColumna=CreditosPendientesConstantesFunciones.LABEL_CODIGOPRESTAMO;}
		if(sNombreColumna.equals(CreditosPendientesConstantesFunciones.NUMERO)) {sLabelColumna=CreditosPendientesConstantesFunciones.LABEL_NUMERO;}
		if(sNombreColumna.equals(CreditosPendientesConstantesFunciones.MONTOCAPITAL)) {sLabelColumna=CreditosPendientesConstantesFunciones.LABEL_MONTOCAPITAL;}
		if(sNombreColumna.equals(CreditosPendientesConstantesFunciones.MONTOINTERES)) {sLabelColumna=CreditosPendientesConstantesFunciones.LABEL_MONTOINTERES;}
		if(sNombreColumna.equals(CreditosPendientesConstantesFunciones.VALOR)) {sLabelColumna=CreditosPendientesConstantesFunciones.LABEL_VALOR;}
		if(sNombreColumna.equals(CreditosPendientesConstantesFunciones.SALDO)) {sLabelColumna=CreditosPendientesConstantesFunciones.LABEL_SALDO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getCreditosPendientesDescripcion(CreditosPendientes creditospendientes) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(creditospendientes !=null/* && creditospendientes.getId()!=0*/) {
			sDescripcion=creditospendientes.getcodigo();//creditospendientescreditospendientes.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getCreditosPendientesDescripcionDetallado(CreditosPendientes creditospendientes) {
		String sDescripcion="";
			
		sDescripcion+=CreditosPendientesConstantesFunciones.ID+"=";
		sDescripcion+=creditospendientes.getId().toString()+",";
		sDescripcion+=CreditosPendientesConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=creditospendientes.getVersionRow().toString()+",";
		sDescripcion+=CreditosPendientesConstantesFunciones.IDCARGO+"=";
		sDescripcion+=creditospendientes.getid_cargo().toString()+",";
		sDescripcion+=CreditosPendientesConstantesFunciones.IDESTRUCTURA+"=";
		sDescripcion+=creditospendientes.getid_estructura().toString()+",";
		sDescripcion+=CreditosPendientesConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=creditospendientes.getid_empresa().toString()+",";
		sDescripcion+=CreditosPendientesConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=creditospendientes.getid_empleado().toString()+",";
		sDescripcion+=CreditosPendientesConstantesFunciones.FECHAVENCIMIENTODESDE+"=";
		sDescripcion+=creditospendientes.getfecha_vencimiento_desde().toString()+",";
		sDescripcion+=CreditosPendientesConstantesFunciones.FECHAVENCIMIENTOHASTA+"=";
		sDescripcion+=creditospendientes.getfecha_vencimiento_hasta().toString()+",";
		sDescripcion+=CreditosPendientesConstantesFunciones.CODIGO+"=";
		sDescripcion+=creditospendientes.getcodigo()+",";
		sDescripcion+=CreditosPendientesConstantesFunciones.NOMBRECOMPLETO+"=";
		sDescripcion+=creditospendientes.getnombre_completo()+",";
		sDescripcion+=CreditosPendientesConstantesFunciones.CODIGOTIPOPRESTAMO+"=";
		sDescripcion+=creditospendientes.getcodigo_tipo_prestamo()+",";
		sDescripcion+=CreditosPendientesConstantesFunciones.CODIGOPRESTAMO+"=";
		sDescripcion+=creditospendientes.getcodigo_prestamo()+",";
		sDescripcion+=CreditosPendientesConstantesFunciones.NUMERO+"=";
		sDescripcion+=creditospendientes.getnumero().toString()+",";
		sDescripcion+=CreditosPendientesConstantesFunciones.MONTOCAPITAL+"=";
		sDescripcion+=creditospendientes.getmonto_capital().toString()+",";
		sDescripcion+=CreditosPendientesConstantesFunciones.MONTOINTERES+"=";
		sDescripcion+=creditospendientes.getmonto_interes().toString()+",";
		sDescripcion+=CreditosPendientesConstantesFunciones.VALOR+"=";
		sDescripcion+=creditospendientes.getvalor().toString()+",";
		sDescripcion+=CreditosPendientesConstantesFunciones.SALDO+"=";
		sDescripcion+=creditospendientes.getsaldo().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setCreditosPendientesDescripcion(CreditosPendientes creditospendientes,String sValor) throws Exception {			
		if(creditospendientes !=null) {
			creditospendientes.setcodigo(sValor);;//creditospendientescreditospendientes.getcodigo().trim();
		}		
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

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getEmpleadoDescripcion(Empleado empleado) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empleado!=null/*&&empleado.getId()>0*/) {
			sDescripcion=EmpleadoConstantesFunciones.getEmpleadoDescripcion(empleado);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaCreditosPendientes")) {
			sNombreIndice="Tipo=  Por Cargo Por Estructura Por Empleado Por Fecha Vencimiento Desde Por Fecha Vencimiento Hasta";
		} else if(sNombreIndice.equals("FK_IdCargo")) {
			sNombreIndice="Tipo=  Por Cargo";
		} else if(sNombreIndice.equals("FK_IdEmpleado")) {
			sNombreIndice="Tipo=  Por Empleado";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEstructura")) {
			sNombreIndice="Tipo=  Por Estructura";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaCreditosPendientes(Long id_cargo,Long id_estructura,Long id_empleado,Date fecha_vencimiento_desde,Date fecha_vencimiento_hasta) {
		String sDetalleIndice=" Parametros->";
		if(id_cargo!=null) {sDetalleIndice+=" Codigo Unico De Cargo="+id_cargo.toString();}
		if(id_estructura!=null) {sDetalleIndice+=" Codigo Unico De Estructura="+id_estructura.toString();}
		if(id_empleado!=null) {sDetalleIndice+=" Codigo Unico De Empleado="+id_empleado.toString();}
		if(fecha_vencimiento_desde!=null) {sDetalleIndice+=" Fecha Vencimiento Desde="+fecha_vencimiento_desde.toString();}
		if(fecha_vencimiento_hasta!=null) {sDetalleIndice+=" Fecha Vencimiento Hasta="+fecha_vencimiento_hasta.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCargo(Long id_cargo) {
		String sDetalleIndice=" Parametros->";
		if(id_cargo!=null) {sDetalleIndice+=" Codigo Unico De Cargo="+id_cargo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpleado(Long id_empleado) {
		String sDetalleIndice=" Parametros->";
		if(id_empleado!=null) {sDetalleIndice+=" Codigo Unico De Empleado="+id_empleado.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEstructura(Long id_estructura) {
		String sDetalleIndice=" Parametros->";
		if(id_estructura!=null) {sDetalleIndice+=" Codigo Unico De Estructura="+id_estructura.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosCreditosPendientes(CreditosPendientes creditospendientes,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		creditospendientes.setcodigo(creditospendientes.getcodigo().trim());
		creditospendientes.setnombre_completo(creditospendientes.getnombre_completo().trim());
		creditospendientes.setcodigo_tipo_prestamo(creditospendientes.getcodigo_tipo_prestamo().trim());
		creditospendientes.setcodigo_prestamo(creditospendientes.getcodigo_prestamo().trim());
	}
	
	public static void quitarEspaciosCreditosPendientess(List<CreditosPendientes> creditospendientess,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(CreditosPendientes creditospendientes: creditospendientess) {
			creditospendientes.setcodigo(creditospendientes.getcodigo().trim());
			creditospendientes.setnombre_completo(creditospendientes.getnombre_completo().trim());
			creditospendientes.setcodigo_tipo_prestamo(creditospendientes.getcodigo_tipo_prestamo().trim());
			creditospendientes.setcodigo_prestamo(creditospendientes.getcodigo_prestamo().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCreditosPendientes(CreditosPendientes creditospendientes,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && creditospendientes.getConCambioAuxiliar()) {
			creditospendientes.setIsDeleted(creditospendientes.getIsDeletedAuxiliar());	
			creditospendientes.setIsNew(creditospendientes.getIsNewAuxiliar());	
			creditospendientes.setIsChanged(creditospendientes.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			creditospendientes.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			creditospendientes.setIsDeletedAuxiliar(false);	
			creditospendientes.setIsNewAuxiliar(false);	
			creditospendientes.setIsChangedAuxiliar(false);
			
			creditospendientes.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCreditosPendientess(List<CreditosPendientes> creditospendientess,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(CreditosPendientes creditospendientes : creditospendientess) {
			if(conAsignarBase && creditospendientes.getConCambioAuxiliar()) {
				creditospendientes.setIsDeleted(creditospendientes.getIsDeletedAuxiliar());	
				creditospendientes.setIsNew(creditospendientes.getIsNewAuxiliar());	
				creditospendientes.setIsChanged(creditospendientes.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				creditospendientes.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				creditospendientes.setIsDeletedAuxiliar(false);	
				creditospendientes.setIsNewAuxiliar(false);	
				creditospendientes.setIsChangedAuxiliar(false);
				
				creditospendientes.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresCreditosPendientes(CreditosPendientes creditospendientes,Boolean conEnteros) throws Exception  {
		creditospendientes.setmonto_capital(0.0);
		creditospendientes.setmonto_interes(0.0);
		creditospendientes.setvalor(0.0);
		creditospendientes.setsaldo(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			creditospendientes.setnumero(0);
		}
	}		
	
	public static void InicializarValoresCreditosPendientess(List<CreditosPendientes> creditospendientess,Boolean conEnteros) throws Exception  {
		
		for(CreditosPendientes creditospendientes: creditospendientess) {
			creditospendientes.setmonto_capital(0.0);
			creditospendientes.setmonto_interes(0.0);
			creditospendientes.setvalor(0.0);
			creditospendientes.setsaldo(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				creditospendientes.setnumero(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaCreditosPendientes(List<CreditosPendientes> creditospendientess,CreditosPendientes creditospendientesAux) throws Exception  {
		CreditosPendientesConstantesFunciones.InicializarValoresCreditosPendientes(creditospendientesAux,true);
		
		for(CreditosPendientes creditospendientes: creditospendientess) {
			if(creditospendientes.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			creditospendientesAux.setnumero(creditospendientesAux.getnumero()+creditospendientes.getnumero());			
			creditospendientesAux.setmonto_capital(creditospendientesAux.getmonto_capital()+creditospendientes.getmonto_capital());			
			creditospendientesAux.setmonto_interes(creditospendientesAux.getmonto_interes()+creditospendientes.getmonto_interes());			
			creditospendientesAux.setvalor(creditospendientesAux.getvalor()+creditospendientes.getvalor());			
			creditospendientesAux.setsaldo(creditospendientesAux.getsaldo()+creditospendientes.getsaldo());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCreditosPendientes(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=CreditosPendientesConstantesFunciones.getArrayColumnasGlobalesCreditosPendientes(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesCreditosPendientes(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CreditosPendientesConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CreditosPendientesConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoCreditosPendientes(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<CreditosPendientes> creditospendientess,CreditosPendientes creditospendientes,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(CreditosPendientes creditospendientesAux: creditospendientess) {
			if(creditospendientesAux!=null && creditospendientes!=null) {
				if((creditospendientesAux.getId()==null && creditospendientes.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(creditospendientesAux.getId()!=null && creditospendientes.getId()!=null){
					if(creditospendientesAux.getId().equals(creditospendientes.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCreditosPendientes(List<CreditosPendientes> creditospendientess) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double monto_capitalTotal=0.0;
		Double monto_interesTotal=0.0;
		Double valorTotal=0.0;
		Double saldoTotal=0.0;
	
		for(CreditosPendientes creditospendientes: creditospendientess) {			
			if(creditospendientes.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			monto_capitalTotal+=creditospendientes.getmonto_capital();
			monto_interesTotal+=creditospendientes.getmonto_interes();
			valorTotal+=creditospendientes.getvalor();
			saldoTotal+=creditospendientes.getsaldo();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CreditosPendientesConstantesFunciones.MONTOCAPITAL);
		datoGeneral.setsDescripcion(CreditosPendientesConstantesFunciones.LABEL_MONTOCAPITAL);
		datoGeneral.setdValorDouble(monto_capitalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CreditosPendientesConstantesFunciones.MONTOINTERES);
		datoGeneral.setsDescripcion(CreditosPendientesConstantesFunciones.LABEL_MONTOINTERES);
		datoGeneral.setdValorDouble(monto_interesTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CreditosPendientesConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(CreditosPendientesConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CreditosPendientesConstantesFunciones.SALDO);
		datoGeneral.setsDescripcion(CreditosPendientesConstantesFunciones.LABEL_SALDO);
		datoGeneral.setdValorDouble(saldoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaCreditosPendientes() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,CreditosPendientesConstantesFunciones.LABEL_ID, CreditosPendientesConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CreditosPendientesConstantesFunciones.LABEL_VERSIONROW, CreditosPendientesConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CreditosPendientesConstantesFunciones.LABEL_CODIGO, CreditosPendientesConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CreditosPendientesConstantesFunciones.LABEL_NOMBRECOMPLETO, CreditosPendientesConstantesFunciones.NOMBRECOMPLETO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CreditosPendientesConstantesFunciones.LABEL_CODIGOTIPOPRESTAMO, CreditosPendientesConstantesFunciones.CODIGOTIPOPRESTAMO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CreditosPendientesConstantesFunciones.LABEL_CODIGOPRESTAMO, CreditosPendientesConstantesFunciones.CODIGOPRESTAMO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CreditosPendientesConstantesFunciones.LABEL_NUMERO, CreditosPendientesConstantesFunciones.NUMERO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CreditosPendientesConstantesFunciones.LABEL_MONTOCAPITAL, CreditosPendientesConstantesFunciones.MONTOCAPITAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CreditosPendientesConstantesFunciones.LABEL_MONTOINTERES, CreditosPendientesConstantesFunciones.MONTOINTERES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CreditosPendientesConstantesFunciones.LABEL_VALOR, CreditosPendientesConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CreditosPendientesConstantesFunciones.LABEL_SALDO, CreditosPendientesConstantesFunciones.SALDO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasCreditosPendientes() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=CreditosPendientesConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CreditosPendientesConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CreditosPendientesConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CreditosPendientesConstantesFunciones.NOMBRECOMPLETO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CreditosPendientesConstantesFunciones.CODIGOTIPOPRESTAMO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CreditosPendientesConstantesFunciones.CODIGOPRESTAMO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CreditosPendientesConstantesFunciones.NUMERO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CreditosPendientesConstantesFunciones.MONTOCAPITAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CreditosPendientesConstantesFunciones.MONTOINTERES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CreditosPendientesConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CreditosPendientesConstantesFunciones.SALDO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCreditosPendientes() throws Exception  {
		return CreditosPendientesConstantesFunciones.getTiposSeleccionarCreditosPendientes(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCreditosPendientes(Boolean conFk) throws Exception  {
		return CreditosPendientesConstantesFunciones.getTiposSeleccionarCreditosPendientes(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCreditosPendientes(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CreditosPendientesConstantesFunciones.LABEL_IDCARGO);
			reporte.setsDescripcion(CreditosPendientesConstantesFunciones.LABEL_IDCARGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CreditosPendientesConstantesFunciones.LABEL_IDESTRUCTURA);
			reporte.setsDescripcion(CreditosPendientesConstantesFunciones.LABEL_IDESTRUCTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CreditosPendientesConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(CreditosPendientesConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CreditosPendientesConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(CreditosPendientesConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CreditosPendientesConstantesFunciones.LABEL_FECHAVENCIMIENTODESDE);
			reporte.setsDescripcion(CreditosPendientesConstantesFunciones.LABEL_FECHAVENCIMIENTODESDE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CreditosPendientesConstantesFunciones.LABEL_FECHAVENCIMIENTOHASTA);
			reporte.setsDescripcion(CreditosPendientesConstantesFunciones.LABEL_FECHAVENCIMIENTOHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CreditosPendientesConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(CreditosPendientesConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CreditosPendientesConstantesFunciones.LABEL_NOMBRECOMPLETO);
			reporte.setsDescripcion(CreditosPendientesConstantesFunciones.LABEL_NOMBRECOMPLETO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CreditosPendientesConstantesFunciones.LABEL_CODIGOTIPOPRESTAMO);
			reporte.setsDescripcion(CreditosPendientesConstantesFunciones.LABEL_CODIGOTIPOPRESTAMO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CreditosPendientesConstantesFunciones.LABEL_CODIGOPRESTAMO);
			reporte.setsDescripcion(CreditosPendientesConstantesFunciones.LABEL_CODIGOPRESTAMO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CreditosPendientesConstantesFunciones.LABEL_NUMERO);
			reporte.setsDescripcion(CreditosPendientesConstantesFunciones.LABEL_NUMERO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CreditosPendientesConstantesFunciones.LABEL_MONTOCAPITAL);
			reporte.setsDescripcion(CreditosPendientesConstantesFunciones.LABEL_MONTOCAPITAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CreditosPendientesConstantesFunciones.LABEL_MONTOINTERES);
			reporte.setsDescripcion(CreditosPendientesConstantesFunciones.LABEL_MONTOINTERES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CreditosPendientesConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(CreditosPendientesConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CreditosPendientesConstantesFunciones.LABEL_SALDO);
			reporte.setsDescripcion(CreditosPendientesConstantesFunciones.LABEL_SALDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesCreditosPendientes(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesCreditosPendientes(CreditosPendientes creditospendientesAux) throws Exception {
		
			creditospendientesAux.setcargo_descripcion(CargoConstantesFunciones.getCargoDescripcion(creditospendientesAux.getCargo()));
			creditospendientesAux.setestructura_descripcion(EstructuraConstantesFunciones.getEstructuraDescripcion(creditospendientesAux.getEstructura()));
			creditospendientesAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(creditospendientesAux.getEmpresa()));
			creditospendientesAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(creditospendientesAux.getEmpleado()));		
	}
	
	public static void refrescarForeignKeysDescripcionesCreditosPendientes(List<CreditosPendientes> creditospendientessTemp) throws Exception {
		for(CreditosPendientes creditospendientesAux:creditospendientessTemp) {
			
			creditospendientesAux.setcargo_descripcion(CargoConstantesFunciones.getCargoDescripcion(creditospendientesAux.getCargo()));
			creditospendientesAux.setestructura_descripcion(EstructuraConstantesFunciones.getEstructuraDescripcion(creditospendientesAux.getEstructura()));
			creditospendientesAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(creditospendientesAux.getEmpresa()));
			creditospendientesAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(creditospendientesAux.getEmpleado()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfCreditosPendientes(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Cargo.class));
				classes.add(new Classe(Estructura.class));
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Empleado.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
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
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Empleado.class)) {
						classes.add(new Classe(Empleado.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfCreditosPendientes(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Cargo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cargo.class)); continue;
					}

					if(Estructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Estructura.class)); continue;
					}

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Cargo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cargo.class)); continue;
					}

					if(Estructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Estructura.class)); continue;
					}

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfCreditosPendientes(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return CreditosPendientesConstantesFunciones.getClassesRelationshipsOfCreditosPendientes(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCreditosPendientes(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCreditosPendientes(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return CreditosPendientesConstantesFunciones.getClassesRelationshipsFromStringsOfCreditosPendientes(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCreditosPendientes(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {
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
	public static void actualizarLista(CreditosPendientes creditospendientes,List<CreditosPendientes> creditospendientess,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(CreditosPendientes creditospendientes,List<CreditosPendientes> creditospendientess) throws Exception {
		try	{			
			for(CreditosPendientes creditospendientesLocal:creditospendientess) {
				if(creditospendientesLocal.getId().equals(creditospendientes.getId())) {
					creditospendientesLocal.setIsSelected(creditospendientes.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesCreditosPendientes(List<CreditosPendientes> creditospendientessAux) throws Exception {
		//this.creditospendientessAux=creditospendientessAux;
		
		for(CreditosPendientes creditospendientesAux:creditospendientessAux) {
			if(creditospendientesAux.getIsChanged()) {
				creditospendientesAux.setIsChanged(false);
			}		
			
			if(creditospendientesAux.getIsNew()) {
				creditospendientesAux.setIsNew(false);
			}	
			
			if(creditospendientesAux.getIsDeleted()) {
				creditospendientesAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesCreditosPendientes(CreditosPendientes creditospendientesAux) throws Exception {
		//this.creditospendientesAux=creditospendientesAux;
		
			if(creditospendientesAux.getIsChanged()) {
				creditospendientesAux.setIsChanged(false);
			}		
			
			if(creditospendientesAux.getIsNew()) {
				creditospendientesAux.setIsNew(false);
			}	
			
			if(creditospendientesAux.getIsDeleted()) {
				creditospendientesAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(CreditosPendientes creditospendientesAsignar,CreditosPendientes creditospendientes) throws Exception {
		creditospendientesAsignar.setId(creditospendientes.getId());	
		creditospendientesAsignar.setVersionRow(creditospendientes.getVersionRow());	
		creditospendientesAsignar.setcodigo(creditospendientes.getcodigo());	
		creditospendientesAsignar.setnombre_completo(creditospendientes.getnombre_completo());	
		creditospendientesAsignar.setcodigo_tipo_prestamo(creditospendientes.getcodigo_tipo_prestamo());	
		creditospendientesAsignar.setcodigo_prestamo(creditospendientes.getcodigo_prestamo());	
		creditospendientesAsignar.setnumero(creditospendientes.getnumero());	
		creditospendientesAsignar.setmonto_capital(creditospendientes.getmonto_capital());	
		creditospendientesAsignar.setmonto_interes(creditospendientes.getmonto_interes());	
		creditospendientesAsignar.setvalor(creditospendientes.getvalor());	
		creditospendientesAsignar.setsaldo(creditospendientes.getsaldo());	
	}
	
	public static void inicializarCreditosPendientes(CreditosPendientes creditospendientes) throws Exception {
		try {
				creditospendientes.setId(0L);	
					
				creditospendientes.setcodigo("");	
				creditospendientes.setnombre_completo("");	
				creditospendientes.setcodigo_tipo_prestamo("");	
				creditospendientes.setcodigo_prestamo("");	
				creditospendientes.setnumero(0);	
				creditospendientes.setmonto_capital(0.0);	
				creditospendientes.setmonto_interes(0.0);	
				creditospendientes.setvalor(0.0);	
				creditospendientes.setsaldo(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderCreditosPendientes(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(CreditosPendientesConstantesFunciones.LABEL_IDCARGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CreditosPendientesConstantesFunciones.LABEL_IDESTRUCTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CreditosPendientesConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CreditosPendientesConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CreditosPendientesConstantesFunciones.LABEL_FECHAVENCIMIENTODESDE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CreditosPendientesConstantesFunciones.LABEL_FECHAVENCIMIENTOHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CreditosPendientesConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CreditosPendientesConstantesFunciones.LABEL_NOMBRECOMPLETO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CreditosPendientesConstantesFunciones.LABEL_CODIGOTIPOPRESTAMO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CreditosPendientesConstantesFunciones.LABEL_CODIGOPRESTAMO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CreditosPendientesConstantesFunciones.LABEL_NUMERO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CreditosPendientesConstantesFunciones.LABEL_MONTOCAPITAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CreditosPendientesConstantesFunciones.LABEL_MONTOINTERES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CreditosPendientesConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CreditosPendientesConstantesFunciones.LABEL_SALDO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataCreditosPendientes(String sTipo,Row row,Workbook workbook,CreditosPendientes creditospendientes,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(creditospendientes.getcargo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(creditospendientes.getestructura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(creditospendientes.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(creditospendientes.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(creditospendientes.getfecha_vencimiento_desde());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(creditospendientes.getfecha_vencimiento_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(creditospendientes.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(creditospendientes.getnombre_completo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(creditospendientes.getcodigo_tipo_prestamo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(creditospendientes.getcodigo_prestamo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(creditospendientes.getnumero());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(creditospendientes.getmonto_capital());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(creditospendientes.getmonto_interes());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(creditospendientes.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(creditospendientes.getsaldo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryCreditosPendientes="";
	
	public String getsFinalQueryCreditosPendientes() {
		return this.sFinalQueryCreditosPendientes;
	}
	
	public void setsFinalQueryCreditosPendientes(String sFinalQueryCreditosPendientes) {
		this.sFinalQueryCreditosPendientes= sFinalQueryCreditosPendientes;
	}
	
	public Border resaltarSeleccionarCreditosPendientes=null;
	
	public Border setResaltarSeleccionarCreditosPendientes(ParametroGeneralUsuario parametroGeneralUsuario/*CreditosPendientesBeanSwingJInternalFrame creditospendientesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//creditospendientesBeanSwingJInternalFrame.jTtoolBarCreditosPendientes.setBorder(borderResaltar);
		
		this.resaltarSeleccionarCreditosPendientes= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarCreditosPendientes() {
		return this.resaltarSeleccionarCreditosPendientes;
	}
	
	public void setResaltarSeleccionarCreditosPendientes(Border borderResaltarSeleccionarCreditosPendientes) {
		this.resaltarSeleccionarCreditosPendientes= borderResaltarSeleccionarCreditosPendientes;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridCreditosPendientes=null;
	public Boolean mostraridCreditosPendientes=true;
	public Boolean activaridCreditosPendientes=true;

	public Border resaltarid_cargoCreditosPendientes=null;
	public Boolean mostrarid_cargoCreditosPendientes=true;
	public Boolean activarid_cargoCreditosPendientes=true;
	public Boolean cargarid_cargoCreditosPendientes=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cargoCreditosPendientes=false;//ConEventDepend=true

	public Border resaltarid_estructuraCreditosPendientes=null;
	public Boolean mostrarid_estructuraCreditosPendientes=true;
	public Boolean activarid_estructuraCreditosPendientes=true;
	public Boolean cargarid_estructuraCreditosPendientes=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estructuraCreditosPendientes=false;//ConEventDepend=true

	public Border resaltarid_empresaCreditosPendientes=null;
	public Boolean mostrarid_empresaCreditosPendientes=true;
	public Boolean activarid_empresaCreditosPendientes=true;
	public Boolean cargarid_empresaCreditosPendientes=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaCreditosPendientes=false;//ConEventDepend=true

	public Border resaltarid_empleadoCreditosPendientes=null;
	public Boolean mostrarid_empleadoCreditosPendientes=true;
	public Boolean activarid_empleadoCreditosPendientes=true;
	public Boolean cargarid_empleadoCreditosPendientes=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoCreditosPendientes=false;//ConEventDepend=true

	public Border resaltarfecha_vencimiento_desdeCreditosPendientes=null;
	public Boolean mostrarfecha_vencimiento_desdeCreditosPendientes=true;
	public Boolean activarfecha_vencimiento_desdeCreditosPendientes=true;

	public Border resaltarfecha_vencimiento_hastaCreditosPendientes=null;
	public Boolean mostrarfecha_vencimiento_hastaCreditosPendientes=true;
	public Boolean activarfecha_vencimiento_hastaCreditosPendientes=true;

	public Border resaltarcodigoCreditosPendientes=null;
	public Boolean mostrarcodigoCreditosPendientes=true;
	public Boolean activarcodigoCreditosPendientes=true;

	public Border resaltarnombre_completoCreditosPendientes=null;
	public Boolean mostrarnombre_completoCreditosPendientes=true;
	public Boolean activarnombre_completoCreditosPendientes=true;

	public Border resaltarcodigo_tipo_prestamoCreditosPendientes=null;
	public Boolean mostrarcodigo_tipo_prestamoCreditosPendientes=true;
	public Boolean activarcodigo_tipo_prestamoCreditosPendientes=true;

	public Border resaltarcodigo_prestamoCreditosPendientes=null;
	public Boolean mostrarcodigo_prestamoCreditosPendientes=true;
	public Boolean activarcodigo_prestamoCreditosPendientes=true;

	public Border resaltarnumeroCreditosPendientes=null;
	public Boolean mostrarnumeroCreditosPendientes=true;
	public Boolean activarnumeroCreditosPendientes=true;

	public Border resaltarmonto_capitalCreditosPendientes=null;
	public Boolean mostrarmonto_capitalCreditosPendientes=true;
	public Boolean activarmonto_capitalCreditosPendientes=true;

	public Border resaltarmonto_interesCreditosPendientes=null;
	public Boolean mostrarmonto_interesCreditosPendientes=true;
	public Boolean activarmonto_interesCreditosPendientes=true;

	public Border resaltarvalorCreditosPendientes=null;
	public Boolean mostrarvalorCreditosPendientes=true;
	public Boolean activarvalorCreditosPendientes=true;

	public Border resaltarsaldoCreditosPendientes=null;
	public Boolean mostrarsaldoCreditosPendientes=true;
	public Boolean activarsaldoCreditosPendientes=true;

	
	

	public Border setResaltaridCreditosPendientes(ParametroGeneralUsuario parametroGeneralUsuario/*CreditosPendientesBeanSwingJInternalFrame creditospendientesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//creditospendientesBeanSwingJInternalFrame.jTtoolBarCreditosPendientes.setBorder(borderResaltar);
		
		this.resaltaridCreditosPendientes= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridCreditosPendientes() {
		return this.resaltaridCreditosPendientes;
	}

	public void setResaltaridCreditosPendientes(Border borderResaltar) {
		this.resaltaridCreditosPendientes= borderResaltar;
	}

	public Boolean getMostraridCreditosPendientes() {
		return this.mostraridCreditosPendientes;
	}

	public void setMostraridCreditosPendientes(Boolean mostraridCreditosPendientes) {
		this.mostraridCreditosPendientes= mostraridCreditosPendientes;
	}

	public Boolean getActivaridCreditosPendientes() {
		return this.activaridCreditosPendientes;
	}

	public void setActivaridCreditosPendientes(Boolean activaridCreditosPendientes) {
		this.activaridCreditosPendientes= activaridCreditosPendientes;
	}

	public Border setResaltarid_cargoCreditosPendientes(ParametroGeneralUsuario parametroGeneralUsuario/*CreditosPendientesBeanSwingJInternalFrame creditospendientesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//creditospendientesBeanSwingJInternalFrame.jTtoolBarCreditosPendientes.setBorder(borderResaltar);
		
		this.resaltarid_cargoCreditosPendientes= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cargoCreditosPendientes() {
		return this.resaltarid_cargoCreditosPendientes;
	}

	public void setResaltarid_cargoCreditosPendientes(Border borderResaltar) {
		this.resaltarid_cargoCreditosPendientes= borderResaltar;
	}

	public Boolean getMostrarid_cargoCreditosPendientes() {
		return this.mostrarid_cargoCreditosPendientes;
	}

	public void setMostrarid_cargoCreditosPendientes(Boolean mostrarid_cargoCreditosPendientes) {
		this.mostrarid_cargoCreditosPendientes= mostrarid_cargoCreditosPendientes;
	}

	public Boolean getActivarid_cargoCreditosPendientes() {
		return this.activarid_cargoCreditosPendientes;
	}

	public void setActivarid_cargoCreditosPendientes(Boolean activarid_cargoCreditosPendientes) {
		this.activarid_cargoCreditosPendientes= activarid_cargoCreditosPendientes;
	}

	public Boolean getCargarid_cargoCreditosPendientes() {
		return this.cargarid_cargoCreditosPendientes;
	}

	public void setCargarid_cargoCreditosPendientes(Boolean cargarid_cargoCreditosPendientes) {
		this.cargarid_cargoCreditosPendientes= cargarid_cargoCreditosPendientes;
	}

	public Border setResaltarid_estructuraCreditosPendientes(ParametroGeneralUsuario parametroGeneralUsuario/*CreditosPendientesBeanSwingJInternalFrame creditospendientesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//creditospendientesBeanSwingJInternalFrame.jTtoolBarCreditosPendientes.setBorder(borderResaltar);
		
		this.resaltarid_estructuraCreditosPendientes= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estructuraCreditosPendientes() {
		return this.resaltarid_estructuraCreditosPendientes;
	}

	public void setResaltarid_estructuraCreditosPendientes(Border borderResaltar) {
		this.resaltarid_estructuraCreditosPendientes= borderResaltar;
	}

	public Boolean getMostrarid_estructuraCreditosPendientes() {
		return this.mostrarid_estructuraCreditosPendientes;
	}

	public void setMostrarid_estructuraCreditosPendientes(Boolean mostrarid_estructuraCreditosPendientes) {
		this.mostrarid_estructuraCreditosPendientes= mostrarid_estructuraCreditosPendientes;
	}

	public Boolean getActivarid_estructuraCreditosPendientes() {
		return this.activarid_estructuraCreditosPendientes;
	}

	public void setActivarid_estructuraCreditosPendientes(Boolean activarid_estructuraCreditosPendientes) {
		this.activarid_estructuraCreditosPendientes= activarid_estructuraCreditosPendientes;
	}

	public Boolean getCargarid_estructuraCreditosPendientes() {
		return this.cargarid_estructuraCreditosPendientes;
	}

	public void setCargarid_estructuraCreditosPendientes(Boolean cargarid_estructuraCreditosPendientes) {
		this.cargarid_estructuraCreditosPendientes= cargarid_estructuraCreditosPendientes;
	}

	public Border setResaltarid_empresaCreditosPendientes(ParametroGeneralUsuario parametroGeneralUsuario/*CreditosPendientesBeanSwingJInternalFrame creditospendientesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//creditospendientesBeanSwingJInternalFrame.jTtoolBarCreditosPendientes.setBorder(borderResaltar);
		
		this.resaltarid_empresaCreditosPendientes= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaCreditosPendientes() {
		return this.resaltarid_empresaCreditosPendientes;
	}

	public void setResaltarid_empresaCreditosPendientes(Border borderResaltar) {
		this.resaltarid_empresaCreditosPendientes= borderResaltar;
	}

	public Boolean getMostrarid_empresaCreditosPendientes() {
		return this.mostrarid_empresaCreditosPendientes;
	}

	public void setMostrarid_empresaCreditosPendientes(Boolean mostrarid_empresaCreditosPendientes) {
		this.mostrarid_empresaCreditosPendientes= mostrarid_empresaCreditosPendientes;
	}

	public Boolean getActivarid_empresaCreditosPendientes() {
		return this.activarid_empresaCreditosPendientes;
	}

	public void setActivarid_empresaCreditosPendientes(Boolean activarid_empresaCreditosPendientes) {
		this.activarid_empresaCreditosPendientes= activarid_empresaCreditosPendientes;
	}

	public Boolean getCargarid_empresaCreditosPendientes() {
		return this.cargarid_empresaCreditosPendientes;
	}

	public void setCargarid_empresaCreditosPendientes(Boolean cargarid_empresaCreditosPendientes) {
		this.cargarid_empresaCreditosPendientes= cargarid_empresaCreditosPendientes;
	}

	public Border setResaltarid_empleadoCreditosPendientes(ParametroGeneralUsuario parametroGeneralUsuario/*CreditosPendientesBeanSwingJInternalFrame creditospendientesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//creditospendientesBeanSwingJInternalFrame.jTtoolBarCreditosPendientes.setBorder(borderResaltar);
		
		this.resaltarid_empleadoCreditosPendientes= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoCreditosPendientes() {
		return this.resaltarid_empleadoCreditosPendientes;
	}

	public void setResaltarid_empleadoCreditosPendientes(Border borderResaltar) {
		this.resaltarid_empleadoCreditosPendientes= borderResaltar;
	}

	public Boolean getMostrarid_empleadoCreditosPendientes() {
		return this.mostrarid_empleadoCreditosPendientes;
	}

	public void setMostrarid_empleadoCreditosPendientes(Boolean mostrarid_empleadoCreditosPendientes) {
		this.mostrarid_empleadoCreditosPendientes= mostrarid_empleadoCreditosPendientes;
	}

	public Boolean getActivarid_empleadoCreditosPendientes() {
		return this.activarid_empleadoCreditosPendientes;
	}

	public void setActivarid_empleadoCreditosPendientes(Boolean activarid_empleadoCreditosPendientes) {
		this.activarid_empleadoCreditosPendientes= activarid_empleadoCreditosPendientes;
	}

	public Boolean getCargarid_empleadoCreditosPendientes() {
		return this.cargarid_empleadoCreditosPendientes;
	}

	public void setCargarid_empleadoCreditosPendientes(Boolean cargarid_empleadoCreditosPendientes) {
		this.cargarid_empleadoCreditosPendientes= cargarid_empleadoCreditosPendientes;
	}

	public Border setResaltarfecha_vencimiento_desdeCreditosPendientes(ParametroGeneralUsuario parametroGeneralUsuario/*CreditosPendientesBeanSwingJInternalFrame creditospendientesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//creditospendientesBeanSwingJInternalFrame.jTtoolBarCreditosPendientes.setBorder(borderResaltar);
		
		this.resaltarfecha_vencimiento_desdeCreditosPendientes= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_vencimiento_desdeCreditosPendientes() {
		return this.resaltarfecha_vencimiento_desdeCreditosPendientes;
	}

	public void setResaltarfecha_vencimiento_desdeCreditosPendientes(Border borderResaltar) {
		this.resaltarfecha_vencimiento_desdeCreditosPendientes= borderResaltar;
	}

	public Boolean getMostrarfecha_vencimiento_desdeCreditosPendientes() {
		return this.mostrarfecha_vencimiento_desdeCreditosPendientes;
	}

	public void setMostrarfecha_vencimiento_desdeCreditosPendientes(Boolean mostrarfecha_vencimiento_desdeCreditosPendientes) {
		this.mostrarfecha_vencimiento_desdeCreditosPendientes= mostrarfecha_vencimiento_desdeCreditosPendientes;
	}

	public Boolean getActivarfecha_vencimiento_desdeCreditosPendientes() {
		return this.activarfecha_vencimiento_desdeCreditosPendientes;
	}

	public void setActivarfecha_vencimiento_desdeCreditosPendientes(Boolean activarfecha_vencimiento_desdeCreditosPendientes) {
		this.activarfecha_vencimiento_desdeCreditosPendientes= activarfecha_vencimiento_desdeCreditosPendientes;
	}

	public Border setResaltarfecha_vencimiento_hastaCreditosPendientes(ParametroGeneralUsuario parametroGeneralUsuario/*CreditosPendientesBeanSwingJInternalFrame creditospendientesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//creditospendientesBeanSwingJInternalFrame.jTtoolBarCreditosPendientes.setBorder(borderResaltar);
		
		this.resaltarfecha_vencimiento_hastaCreditosPendientes= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_vencimiento_hastaCreditosPendientes() {
		return this.resaltarfecha_vencimiento_hastaCreditosPendientes;
	}

	public void setResaltarfecha_vencimiento_hastaCreditosPendientes(Border borderResaltar) {
		this.resaltarfecha_vencimiento_hastaCreditosPendientes= borderResaltar;
	}

	public Boolean getMostrarfecha_vencimiento_hastaCreditosPendientes() {
		return this.mostrarfecha_vencimiento_hastaCreditosPendientes;
	}

	public void setMostrarfecha_vencimiento_hastaCreditosPendientes(Boolean mostrarfecha_vencimiento_hastaCreditosPendientes) {
		this.mostrarfecha_vencimiento_hastaCreditosPendientes= mostrarfecha_vencimiento_hastaCreditosPendientes;
	}

	public Boolean getActivarfecha_vencimiento_hastaCreditosPendientes() {
		return this.activarfecha_vencimiento_hastaCreditosPendientes;
	}

	public void setActivarfecha_vencimiento_hastaCreditosPendientes(Boolean activarfecha_vencimiento_hastaCreditosPendientes) {
		this.activarfecha_vencimiento_hastaCreditosPendientes= activarfecha_vencimiento_hastaCreditosPendientes;
	}

	public Border setResaltarcodigoCreditosPendientes(ParametroGeneralUsuario parametroGeneralUsuario/*CreditosPendientesBeanSwingJInternalFrame creditospendientesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//creditospendientesBeanSwingJInternalFrame.jTtoolBarCreditosPendientes.setBorder(borderResaltar);
		
		this.resaltarcodigoCreditosPendientes= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoCreditosPendientes() {
		return this.resaltarcodigoCreditosPendientes;
	}

	public void setResaltarcodigoCreditosPendientes(Border borderResaltar) {
		this.resaltarcodigoCreditosPendientes= borderResaltar;
	}

	public Boolean getMostrarcodigoCreditosPendientes() {
		return this.mostrarcodigoCreditosPendientes;
	}

	public void setMostrarcodigoCreditosPendientes(Boolean mostrarcodigoCreditosPendientes) {
		this.mostrarcodigoCreditosPendientes= mostrarcodigoCreditosPendientes;
	}

	public Boolean getActivarcodigoCreditosPendientes() {
		return this.activarcodigoCreditosPendientes;
	}

	public void setActivarcodigoCreditosPendientes(Boolean activarcodigoCreditosPendientes) {
		this.activarcodigoCreditosPendientes= activarcodigoCreditosPendientes;
	}

	public Border setResaltarnombre_completoCreditosPendientes(ParametroGeneralUsuario parametroGeneralUsuario/*CreditosPendientesBeanSwingJInternalFrame creditospendientesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//creditospendientesBeanSwingJInternalFrame.jTtoolBarCreditosPendientes.setBorder(borderResaltar);
		
		this.resaltarnombre_completoCreditosPendientes= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_completoCreditosPendientes() {
		return this.resaltarnombre_completoCreditosPendientes;
	}

	public void setResaltarnombre_completoCreditosPendientes(Border borderResaltar) {
		this.resaltarnombre_completoCreditosPendientes= borderResaltar;
	}

	public Boolean getMostrarnombre_completoCreditosPendientes() {
		return this.mostrarnombre_completoCreditosPendientes;
	}

	public void setMostrarnombre_completoCreditosPendientes(Boolean mostrarnombre_completoCreditosPendientes) {
		this.mostrarnombre_completoCreditosPendientes= mostrarnombre_completoCreditosPendientes;
	}

	public Boolean getActivarnombre_completoCreditosPendientes() {
		return this.activarnombre_completoCreditosPendientes;
	}

	public void setActivarnombre_completoCreditosPendientes(Boolean activarnombre_completoCreditosPendientes) {
		this.activarnombre_completoCreditosPendientes= activarnombre_completoCreditosPendientes;
	}

	public Border setResaltarcodigo_tipo_prestamoCreditosPendientes(ParametroGeneralUsuario parametroGeneralUsuario/*CreditosPendientesBeanSwingJInternalFrame creditospendientesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//creditospendientesBeanSwingJInternalFrame.jTtoolBarCreditosPendientes.setBorder(borderResaltar);
		
		this.resaltarcodigo_tipo_prestamoCreditosPendientes= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_tipo_prestamoCreditosPendientes() {
		return this.resaltarcodigo_tipo_prestamoCreditosPendientes;
	}

	public void setResaltarcodigo_tipo_prestamoCreditosPendientes(Border borderResaltar) {
		this.resaltarcodigo_tipo_prestamoCreditosPendientes= borderResaltar;
	}

	public Boolean getMostrarcodigo_tipo_prestamoCreditosPendientes() {
		return this.mostrarcodigo_tipo_prestamoCreditosPendientes;
	}

	public void setMostrarcodigo_tipo_prestamoCreditosPendientes(Boolean mostrarcodigo_tipo_prestamoCreditosPendientes) {
		this.mostrarcodigo_tipo_prestamoCreditosPendientes= mostrarcodigo_tipo_prestamoCreditosPendientes;
	}

	public Boolean getActivarcodigo_tipo_prestamoCreditosPendientes() {
		return this.activarcodigo_tipo_prestamoCreditosPendientes;
	}

	public void setActivarcodigo_tipo_prestamoCreditosPendientes(Boolean activarcodigo_tipo_prestamoCreditosPendientes) {
		this.activarcodigo_tipo_prestamoCreditosPendientes= activarcodigo_tipo_prestamoCreditosPendientes;
	}

	public Border setResaltarcodigo_prestamoCreditosPendientes(ParametroGeneralUsuario parametroGeneralUsuario/*CreditosPendientesBeanSwingJInternalFrame creditospendientesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//creditospendientesBeanSwingJInternalFrame.jTtoolBarCreditosPendientes.setBorder(borderResaltar);
		
		this.resaltarcodigo_prestamoCreditosPendientes= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_prestamoCreditosPendientes() {
		return this.resaltarcodigo_prestamoCreditosPendientes;
	}

	public void setResaltarcodigo_prestamoCreditosPendientes(Border borderResaltar) {
		this.resaltarcodigo_prestamoCreditosPendientes= borderResaltar;
	}

	public Boolean getMostrarcodigo_prestamoCreditosPendientes() {
		return this.mostrarcodigo_prestamoCreditosPendientes;
	}

	public void setMostrarcodigo_prestamoCreditosPendientes(Boolean mostrarcodigo_prestamoCreditosPendientes) {
		this.mostrarcodigo_prestamoCreditosPendientes= mostrarcodigo_prestamoCreditosPendientes;
	}

	public Boolean getActivarcodigo_prestamoCreditosPendientes() {
		return this.activarcodigo_prestamoCreditosPendientes;
	}

	public void setActivarcodigo_prestamoCreditosPendientes(Boolean activarcodigo_prestamoCreditosPendientes) {
		this.activarcodigo_prestamoCreditosPendientes= activarcodigo_prestamoCreditosPendientes;
	}

	public Border setResaltarnumeroCreditosPendientes(ParametroGeneralUsuario parametroGeneralUsuario/*CreditosPendientesBeanSwingJInternalFrame creditospendientesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//creditospendientesBeanSwingJInternalFrame.jTtoolBarCreditosPendientes.setBorder(borderResaltar);
		
		this.resaltarnumeroCreditosPendientes= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumeroCreditosPendientes() {
		return this.resaltarnumeroCreditosPendientes;
	}

	public void setResaltarnumeroCreditosPendientes(Border borderResaltar) {
		this.resaltarnumeroCreditosPendientes= borderResaltar;
	}

	public Boolean getMostrarnumeroCreditosPendientes() {
		return this.mostrarnumeroCreditosPendientes;
	}

	public void setMostrarnumeroCreditosPendientes(Boolean mostrarnumeroCreditosPendientes) {
		this.mostrarnumeroCreditosPendientes= mostrarnumeroCreditosPendientes;
	}

	public Boolean getActivarnumeroCreditosPendientes() {
		return this.activarnumeroCreditosPendientes;
	}

	public void setActivarnumeroCreditosPendientes(Boolean activarnumeroCreditosPendientes) {
		this.activarnumeroCreditosPendientes= activarnumeroCreditosPendientes;
	}

	public Border setResaltarmonto_capitalCreditosPendientes(ParametroGeneralUsuario parametroGeneralUsuario/*CreditosPendientesBeanSwingJInternalFrame creditospendientesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//creditospendientesBeanSwingJInternalFrame.jTtoolBarCreditosPendientes.setBorder(borderResaltar);
		
		this.resaltarmonto_capitalCreditosPendientes= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmonto_capitalCreditosPendientes() {
		return this.resaltarmonto_capitalCreditosPendientes;
	}

	public void setResaltarmonto_capitalCreditosPendientes(Border borderResaltar) {
		this.resaltarmonto_capitalCreditosPendientes= borderResaltar;
	}

	public Boolean getMostrarmonto_capitalCreditosPendientes() {
		return this.mostrarmonto_capitalCreditosPendientes;
	}

	public void setMostrarmonto_capitalCreditosPendientes(Boolean mostrarmonto_capitalCreditosPendientes) {
		this.mostrarmonto_capitalCreditosPendientes= mostrarmonto_capitalCreditosPendientes;
	}

	public Boolean getActivarmonto_capitalCreditosPendientes() {
		return this.activarmonto_capitalCreditosPendientes;
	}

	public void setActivarmonto_capitalCreditosPendientes(Boolean activarmonto_capitalCreditosPendientes) {
		this.activarmonto_capitalCreditosPendientes= activarmonto_capitalCreditosPendientes;
	}

	public Border setResaltarmonto_interesCreditosPendientes(ParametroGeneralUsuario parametroGeneralUsuario/*CreditosPendientesBeanSwingJInternalFrame creditospendientesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//creditospendientesBeanSwingJInternalFrame.jTtoolBarCreditosPendientes.setBorder(borderResaltar);
		
		this.resaltarmonto_interesCreditosPendientes= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmonto_interesCreditosPendientes() {
		return this.resaltarmonto_interesCreditosPendientes;
	}

	public void setResaltarmonto_interesCreditosPendientes(Border borderResaltar) {
		this.resaltarmonto_interesCreditosPendientes= borderResaltar;
	}

	public Boolean getMostrarmonto_interesCreditosPendientes() {
		return this.mostrarmonto_interesCreditosPendientes;
	}

	public void setMostrarmonto_interesCreditosPendientes(Boolean mostrarmonto_interesCreditosPendientes) {
		this.mostrarmonto_interesCreditosPendientes= mostrarmonto_interesCreditosPendientes;
	}

	public Boolean getActivarmonto_interesCreditosPendientes() {
		return this.activarmonto_interesCreditosPendientes;
	}

	public void setActivarmonto_interesCreditosPendientes(Boolean activarmonto_interesCreditosPendientes) {
		this.activarmonto_interesCreditosPendientes= activarmonto_interesCreditosPendientes;
	}

	public Border setResaltarvalorCreditosPendientes(ParametroGeneralUsuario parametroGeneralUsuario/*CreditosPendientesBeanSwingJInternalFrame creditospendientesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//creditospendientesBeanSwingJInternalFrame.jTtoolBarCreditosPendientes.setBorder(borderResaltar);
		
		this.resaltarvalorCreditosPendientes= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorCreditosPendientes() {
		return this.resaltarvalorCreditosPendientes;
	}

	public void setResaltarvalorCreditosPendientes(Border borderResaltar) {
		this.resaltarvalorCreditosPendientes= borderResaltar;
	}

	public Boolean getMostrarvalorCreditosPendientes() {
		return this.mostrarvalorCreditosPendientes;
	}

	public void setMostrarvalorCreditosPendientes(Boolean mostrarvalorCreditosPendientes) {
		this.mostrarvalorCreditosPendientes= mostrarvalorCreditosPendientes;
	}

	public Boolean getActivarvalorCreditosPendientes() {
		return this.activarvalorCreditosPendientes;
	}

	public void setActivarvalorCreditosPendientes(Boolean activarvalorCreditosPendientes) {
		this.activarvalorCreditosPendientes= activarvalorCreditosPendientes;
	}

	public Border setResaltarsaldoCreditosPendientes(ParametroGeneralUsuario parametroGeneralUsuario/*CreditosPendientesBeanSwingJInternalFrame creditospendientesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//creditospendientesBeanSwingJInternalFrame.jTtoolBarCreditosPendientes.setBorder(borderResaltar);
		
		this.resaltarsaldoCreditosPendientes= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsaldoCreditosPendientes() {
		return this.resaltarsaldoCreditosPendientes;
	}

	public void setResaltarsaldoCreditosPendientes(Border borderResaltar) {
		this.resaltarsaldoCreditosPendientes= borderResaltar;
	}

	public Boolean getMostrarsaldoCreditosPendientes() {
		return this.mostrarsaldoCreditosPendientes;
	}

	public void setMostrarsaldoCreditosPendientes(Boolean mostrarsaldoCreditosPendientes) {
		this.mostrarsaldoCreditosPendientes= mostrarsaldoCreditosPendientes;
	}

	public Boolean getActivarsaldoCreditosPendientes() {
		return this.activarsaldoCreditosPendientes;
	}

	public void setActivarsaldoCreditosPendientes(Boolean activarsaldoCreditosPendientes) {
		this.activarsaldoCreditosPendientes= activarsaldoCreditosPendientes;
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
		
		
		this.setMostraridCreditosPendientes(esInicial);
		this.setMostrarid_cargoCreditosPendientes(esInicial);
		this.setMostrarid_estructuraCreditosPendientes(esInicial);
		this.setMostrarid_empresaCreditosPendientes(esInicial);
		this.setMostrarid_empleadoCreditosPendientes(esInicial);
		this.setMostrarfecha_vencimiento_desdeCreditosPendientes(esInicial);
		this.setMostrarfecha_vencimiento_hastaCreditosPendientes(esInicial);
		this.setMostrarcodigoCreditosPendientes(esInicial);
		this.setMostrarnombre_completoCreditosPendientes(esInicial);
		this.setMostrarcodigo_tipo_prestamoCreditosPendientes(esInicial);
		this.setMostrarcodigo_prestamoCreditosPendientes(esInicial);
		this.setMostrarnumeroCreditosPendientes(esInicial);
		this.setMostrarmonto_capitalCreditosPendientes(esInicial);
		this.setMostrarmonto_interesCreditosPendientes(esInicial);
		this.setMostrarvalorCreditosPendientes(esInicial);
		this.setMostrarsaldoCreditosPendientes(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CreditosPendientesConstantesFunciones.ID)) {
				this.setMostraridCreditosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosPendientesConstantesFunciones.IDCARGO)) {
				this.setMostrarid_cargoCreditosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosPendientesConstantesFunciones.IDESTRUCTURA)) {
				this.setMostrarid_estructuraCreditosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosPendientesConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaCreditosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosPendientesConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoCreditosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosPendientesConstantesFunciones.FECHAVENCIMIENTODESDE)) {
				this.setMostrarfecha_vencimiento_desdeCreditosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosPendientesConstantesFunciones.FECHAVENCIMIENTOHASTA)) {
				this.setMostrarfecha_vencimiento_hastaCreditosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosPendientesConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoCreditosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosPendientesConstantesFunciones.NOMBRECOMPLETO)) {
				this.setMostrarnombre_completoCreditosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosPendientesConstantesFunciones.CODIGOTIPOPRESTAMO)) {
				this.setMostrarcodigo_tipo_prestamoCreditosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosPendientesConstantesFunciones.CODIGOPRESTAMO)) {
				this.setMostrarcodigo_prestamoCreditosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosPendientesConstantesFunciones.NUMERO)) {
				this.setMostrarnumeroCreditosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosPendientesConstantesFunciones.MONTOCAPITAL)) {
				this.setMostrarmonto_capitalCreditosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosPendientesConstantesFunciones.MONTOINTERES)) {
				this.setMostrarmonto_interesCreditosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosPendientesConstantesFunciones.VALOR)) {
				this.setMostrarvalorCreditosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosPendientesConstantesFunciones.SALDO)) {
				this.setMostrarsaldoCreditosPendientes(esAsigna);
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
		
		
		this.setActivaridCreditosPendientes(esInicial);
		this.setActivarid_cargoCreditosPendientes(esInicial);
		this.setActivarid_estructuraCreditosPendientes(esInicial);
		this.setActivarid_empresaCreditosPendientes(esInicial);
		this.setActivarid_empleadoCreditosPendientes(esInicial);
		this.setActivarfecha_vencimiento_desdeCreditosPendientes(esInicial);
		this.setActivarfecha_vencimiento_hastaCreditosPendientes(esInicial);
		this.setActivarcodigoCreditosPendientes(esInicial);
		this.setActivarnombre_completoCreditosPendientes(esInicial);
		this.setActivarcodigo_tipo_prestamoCreditosPendientes(esInicial);
		this.setActivarcodigo_prestamoCreditosPendientes(esInicial);
		this.setActivarnumeroCreditosPendientes(esInicial);
		this.setActivarmonto_capitalCreditosPendientes(esInicial);
		this.setActivarmonto_interesCreditosPendientes(esInicial);
		this.setActivarvalorCreditosPendientes(esInicial);
		this.setActivarsaldoCreditosPendientes(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CreditosPendientesConstantesFunciones.ID)) {
				this.setActivaridCreditosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosPendientesConstantesFunciones.IDCARGO)) {
				this.setActivarid_cargoCreditosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosPendientesConstantesFunciones.IDESTRUCTURA)) {
				this.setActivarid_estructuraCreditosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosPendientesConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaCreditosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosPendientesConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoCreditosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosPendientesConstantesFunciones.FECHAVENCIMIENTODESDE)) {
				this.setActivarfecha_vencimiento_desdeCreditosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosPendientesConstantesFunciones.FECHAVENCIMIENTOHASTA)) {
				this.setActivarfecha_vencimiento_hastaCreditosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosPendientesConstantesFunciones.CODIGO)) {
				this.setActivarcodigoCreditosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosPendientesConstantesFunciones.NOMBRECOMPLETO)) {
				this.setActivarnombre_completoCreditosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosPendientesConstantesFunciones.CODIGOTIPOPRESTAMO)) {
				this.setActivarcodigo_tipo_prestamoCreditosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosPendientesConstantesFunciones.CODIGOPRESTAMO)) {
				this.setActivarcodigo_prestamoCreditosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosPendientesConstantesFunciones.NUMERO)) {
				this.setActivarnumeroCreditosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosPendientesConstantesFunciones.MONTOCAPITAL)) {
				this.setActivarmonto_capitalCreditosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosPendientesConstantesFunciones.MONTOINTERES)) {
				this.setActivarmonto_interesCreditosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosPendientesConstantesFunciones.VALOR)) {
				this.setActivarvalorCreditosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosPendientesConstantesFunciones.SALDO)) {
				this.setActivarsaldoCreditosPendientes(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,CreditosPendientesBeanSwingJInternalFrame creditospendientesBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridCreditosPendientes(esInicial);
		this.setResaltarid_cargoCreditosPendientes(esInicial);
		this.setResaltarid_estructuraCreditosPendientes(esInicial);
		this.setResaltarid_empresaCreditosPendientes(esInicial);
		this.setResaltarid_empleadoCreditosPendientes(esInicial);
		this.setResaltarfecha_vencimiento_desdeCreditosPendientes(esInicial);
		this.setResaltarfecha_vencimiento_hastaCreditosPendientes(esInicial);
		this.setResaltarcodigoCreditosPendientes(esInicial);
		this.setResaltarnombre_completoCreditosPendientes(esInicial);
		this.setResaltarcodigo_tipo_prestamoCreditosPendientes(esInicial);
		this.setResaltarcodigo_prestamoCreditosPendientes(esInicial);
		this.setResaltarnumeroCreditosPendientes(esInicial);
		this.setResaltarmonto_capitalCreditosPendientes(esInicial);
		this.setResaltarmonto_interesCreditosPendientes(esInicial);
		this.setResaltarvalorCreditosPendientes(esInicial);
		this.setResaltarsaldoCreditosPendientes(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CreditosPendientesConstantesFunciones.ID)) {
				this.setResaltaridCreditosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosPendientesConstantesFunciones.IDCARGO)) {
				this.setResaltarid_cargoCreditosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosPendientesConstantesFunciones.IDESTRUCTURA)) {
				this.setResaltarid_estructuraCreditosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosPendientesConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaCreditosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosPendientesConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoCreditosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosPendientesConstantesFunciones.FECHAVENCIMIENTODESDE)) {
				this.setResaltarfecha_vencimiento_desdeCreditosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosPendientesConstantesFunciones.FECHAVENCIMIENTOHASTA)) {
				this.setResaltarfecha_vencimiento_hastaCreditosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosPendientesConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoCreditosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosPendientesConstantesFunciones.NOMBRECOMPLETO)) {
				this.setResaltarnombre_completoCreditosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosPendientesConstantesFunciones.CODIGOTIPOPRESTAMO)) {
				this.setResaltarcodigo_tipo_prestamoCreditosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosPendientesConstantesFunciones.CODIGOPRESTAMO)) {
				this.setResaltarcodigo_prestamoCreditosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosPendientesConstantesFunciones.NUMERO)) {
				this.setResaltarnumeroCreditosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosPendientesConstantesFunciones.MONTOCAPITAL)) {
				this.setResaltarmonto_capitalCreditosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosPendientesConstantesFunciones.MONTOINTERES)) {
				this.setResaltarmonto_interesCreditosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosPendientesConstantesFunciones.VALOR)) {
				this.setResaltarvalorCreditosPendientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosPendientesConstantesFunciones.SALDO)) {
				this.setResaltarsaldoCreditosPendientes(esAsigna);
				continue;
			}
		}
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


		for(Classe clase:clases) {
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


		for(Classe clase:clases) {
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,CreditosPendientesBeanSwingJInternalFrame creditospendientesBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}


		for(Classe clase:clases) {
		}		
	}
	
	


	public Boolean mostrarBusquedaCreditosPendientesCreditosPendientes=true;

	public Boolean getMostrarBusquedaCreditosPendientesCreditosPendientes() {
		return this.mostrarBusquedaCreditosPendientesCreditosPendientes;
	}

	public void setMostrarBusquedaCreditosPendientesCreditosPendientes(Boolean visibilidadResaltar) {
		this.mostrarBusquedaCreditosPendientesCreditosPendientes= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaCreditosPendientesCreditosPendientes=true;

	public Boolean getActivarBusquedaCreditosPendientesCreditosPendientes() {
		return this.activarBusquedaCreditosPendientesCreditosPendientes;
	}

	public void setActivarBusquedaCreditosPendientesCreditosPendientes(Boolean habilitarResaltar) {
		this.activarBusquedaCreditosPendientesCreditosPendientes= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaCreditosPendientesCreditosPendientes=null;

	public Border getResaltarBusquedaCreditosPendientesCreditosPendientes() {
		return this.resaltarBusquedaCreditosPendientesCreditosPendientes;
	}

	public void setResaltarBusquedaCreditosPendientesCreditosPendientes(Border borderResaltar) {
		this.resaltarBusquedaCreditosPendientesCreditosPendientes= borderResaltar;
	}

	public void setResaltarBusquedaCreditosPendientesCreditosPendientes(ParametroGeneralUsuario parametroGeneralUsuario/*CreditosPendientesBeanSwingJInternalFrame creditospendientesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaCreditosPendientesCreditosPendientes= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}