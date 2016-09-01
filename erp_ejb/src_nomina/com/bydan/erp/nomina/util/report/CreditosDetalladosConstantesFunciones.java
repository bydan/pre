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


import com.bydan.erp.nomina.util.report.CreditosDetalladosConstantesFunciones;
import com.bydan.erp.nomina.util.report.CreditosDetalladosParameterReturnGeneral;
//import com.bydan.erp.nomina.util.report.CreditosDetalladosParameterGeneral;

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
final public class CreditosDetalladosConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="CreditosDetallados";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="CreditosDetallados"+CreditosDetalladosConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="CreditosDetalladosHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="CreditosDetalladosHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=CreditosDetalladosConstantesFunciones.SCHEMA+"_"+CreditosDetalladosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/CreditosDetalladosHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=CreditosDetalladosConstantesFunciones.SCHEMA+"_"+CreditosDetalladosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=CreditosDetalladosConstantesFunciones.SCHEMA+"_"+CreditosDetalladosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/CreditosDetalladosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=CreditosDetalladosConstantesFunciones.SCHEMA+"_"+CreditosDetalladosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CreditosDetalladosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CreditosDetalladosHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CreditosDetalladosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CreditosDetalladosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CreditosDetalladosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CreditosDetalladosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=CreditosDetalladosConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+CreditosDetalladosConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=CreditosDetalladosConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+CreditosDetalladosConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Creditos Detalladoses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Creditos Detallados";
	public static final String SCLASSWEBTITULO_LOWER="Creditos Detallados";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="CreditosDetallados";
	public static final String OBJECTNAME="creditosdetallados";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="creditos_detallados";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select creditosdetallados from "+CreditosDetalladosConstantesFunciones.SPERSISTENCENAME+" creditosdetallados";
	public static String QUERYSELECTNATIVE="select "+CreditosDetalladosConstantesFunciones.SCHEMA+"."+CreditosDetalladosConstantesFunciones.TABLENAME+".id,"+CreditosDetalladosConstantesFunciones.SCHEMA+"."+CreditosDetalladosConstantesFunciones.TABLENAME+".version_row,"+CreditosDetalladosConstantesFunciones.SCHEMA+"."+CreditosDetalladosConstantesFunciones.TABLENAME+".id_cargo,"+CreditosDetalladosConstantesFunciones.SCHEMA+"."+CreditosDetalladosConstantesFunciones.TABLENAME+".id_estructura,"+CreditosDetalladosConstantesFunciones.SCHEMA+"."+CreditosDetalladosConstantesFunciones.TABLENAME+".id_empresa,"+CreditosDetalladosConstantesFunciones.SCHEMA+"."+CreditosDetalladosConstantesFunciones.TABLENAME+".id_empleado,"+CreditosDetalladosConstantesFunciones.SCHEMA+"."+CreditosDetalladosConstantesFunciones.TABLENAME+".id_tipo_prestamo,"+CreditosDetalladosConstantesFunciones.SCHEMA+"."+CreditosDetalladosConstantesFunciones.TABLENAME+".fecha_vencimiento_desde,"+CreditosDetalladosConstantesFunciones.SCHEMA+"."+CreditosDetalladosConstantesFunciones.TABLENAME+".fecha_vencimiento_hasta,"+CreditosDetalladosConstantesFunciones.SCHEMA+"."+CreditosDetalladosConstantesFunciones.TABLENAME+".codigo,"+CreditosDetalladosConstantesFunciones.SCHEMA+"."+CreditosDetalladosConstantesFunciones.TABLENAME+".nombre_completo,"+CreditosDetalladosConstantesFunciones.SCHEMA+"."+CreditosDetalladosConstantesFunciones.TABLENAME+".codigo_tipo_prestamo,"+CreditosDetalladosConstantesFunciones.SCHEMA+"."+CreditosDetalladosConstantesFunciones.TABLENAME+".codigo_prestamo,"+CreditosDetalladosConstantesFunciones.SCHEMA+"."+CreditosDetalladosConstantesFunciones.TABLENAME+".fecha,"+CreditosDetalladosConstantesFunciones.SCHEMA+"."+CreditosDetalladosConstantesFunciones.TABLENAME+".monto,"+CreditosDetalladosConstantesFunciones.SCHEMA+"."+CreditosDetalladosConstantesFunciones.TABLENAME+".numero_cuotas,"+CreditosDetalladosConstantesFunciones.SCHEMA+"."+CreditosDetalladosConstantesFunciones.TABLENAME+".numero,"+CreditosDetalladosConstantesFunciones.SCHEMA+"."+CreditosDetalladosConstantesFunciones.TABLENAME+".monto_capital,"+CreditosDetalladosConstantesFunciones.SCHEMA+"."+CreditosDetalladosConstantesFunciones.TABLENAME+".monto_interes,"+CreditosDetalladosConstantesFunciones.SCHEMA+"."+CreditosDetalladosConstantesFunciones.TABLENAME+".valor,"+CreditosDetalladosConstantesFunciones.SCHEMA+"."+CreditosDetalladosConstantesFunciones.TABLENAME+".saldo from "+CreditosDetalladosConstantesFunciones.SCHEMA+"."+CreditosDetalladosConstantesFunciones.TABLENAME;//+" as "+CreditosDetalladosConstantesFunciones.TABLENAME;
	
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
    public static final String IDTIPOPRESTAMO= "id_tipo_prestamo";
    public static final String FECHAVENCIMIENTODESDE= "fecha_vencimiento_desde";
    public static final String FECHAVENCIMIENTOHASTA= "fecha_vencimiento_hasta";
    public static final String CODIGO= "codigo";
    public static final String NOMBRECOMPLETO= "nombre_completo";
    public static final String CODIGOTIPOPRESTAMO= "codigo_tipo_prestamo";
    public static final String CODIGOPRESTAMO= "codigo_prestamo";
    public static final String FECHA= "fecha";
    public static final String MONTO= "monto";
    public static final String NUMEROCUOTAS= "numero_cuotas";
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
    	public static final String LABEL_IDTIPOPRESTAMO= "Tipo Prestamo";
		public static final String LABEL_IDTIPOPRESTAMO_LOWER= "Tipo Prestamo";
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
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_MONTO= "Monto";
		public static final String LABEL_MONTO_LOWER= "Monto";
    	public static final String LABEL_NUMEROCUOTAS= "Numero Cuotas";
		public static final String LABEL_NUMEROCUOTAS_LOWER= "Numero Cuotas";
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
		
		
		
		
		
		
		
		
	
	public static String getCreditosDetalladosLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(CreditosDetalladosConstantesFunciones.IDCARGO)) {sLabelColumna=CreditosDetalladosConstantesFunciones.LABEL_IDCARGO;}
		if(sNombreColumna.equals(CreditosDetalladosConstantesFunciones.IDESTRUCTURA)) {sLabelColumna=CreditosDetalladosConstantesFunciones.LABEL_IDESTRUCTURA;}
		if(sNombreColumna.equals(CreditosDetalladosConstantesFunciones.IDEMPRESA)) {sLabelColumna=CreditosDetalladosConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(CreditosDetalladosConstantesFunciones.IDEMPLEADO)) {sLabelColumna=CreditosDetalladosConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(CreditosDetalladosConstantesFunciones.IDTIPOPRESTAMO)) {sLabelColumna=CreditosDetalladosConstantesFunciones.LABEL_IDTIPOPRESTAMO;}
		if(sNombreColumna.equals(CreditosDetalladosConstantesFunciones.FECHAVENCIMIENTODESDE)) {sLabelColumna=CreditosDetalladosConstantesFunciones.LABEL_FECHAVENCIMIENTODESDE;}
		if(sNombreColumna.equals(CreditosDetalladosConstantesFunciones.FECHAVENCIMIENTOHASTA)) {sLabelColumna=CreditosDetalladosConstantesFunciones.LABEL_FECHAVENCIMIENTOHASTA;}
		if(sNombreColumna.equals(CreditosDetalladosConstantesFunciones.CODIGO)) {sLabelColumna=CreditosDetalladosConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(CreditosDetalladosConstantesFunciones.NOMBRECOMPLETO)) {sLabelColumna=CreditosDetalladosConstantesFunciones.LABEL_NOMBRECOMPLETO;}
		if(sNombreColumna.equals(CreditosDetalladosConstantesFunciones.CODIGOTIPOPRESTAMO)) {sLabelColumna=CreditosDetalladosConstantesFunciones.LABEL_CODIGOTIPOPRESTAMO;}
		if(sNombreColumna.equals(CreditosDetalladosConstantesFunciones.CODIGOPRESTAMO)) {sLabelColumna=CreditosDetalladosConstantesFunciones.LABEL_CODIGOPRESTAMO;}
		if(sNombreColumna.equals(CreditosDetalladosConstantesFunciones.FECHA)) {sLabelColumna=CreditosDetalladosConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(CreditosDetalladosConstantesFunciones.MONTO)) {sLabelColumna=CreditosDetalladosConstantesFunciones.LABEL_MONTO;}
		if(sNombreColumna.equals(CreditosDetalladosConstantesFunciones.NUMEROCUOTAS)) {sLabelColumna=CreditosDetalladosConstantesFunciones.LABEL_NUMEROCUOTAS;}
		if(sNombreColumna.equals(CreditosDetalladosConstantesFunciones.NUMERO)) {sLabelColumna=CreditosDetalladosConstantesFunciones.LABEL_NUMERO;}
		if(sNombreColumna.equals(CreditosDetalladosConstantesFunciones.MONTOCAPITAL)) {sLabelColumna=CreditosDetalladosConstantesFunciones.LABEL_MONTOCAPITAL;}
		if(sNombreColumna.equals(CreditosDetalladosConstantesFunciones.MONTOINTERES)) {sLabelColumna=CreditosDetalladosConstantesFunciones.LABEL_MONTOINTERES;}
		if(sNombreColumna.equals(CreditosDetalladosConstantesFunciones.VALOR)) {sLabelColumna=CreditosDetalladosConstantesFunciones.LABEL_VALOR;}
		if(sNombreColumna.equals(CreditosDetalladosConstantesFunciones.SALDO)) {sLabelColumna=CreditosDetalladosConstantesFunciones.LABEL_SALDO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getCreditosDetalladosDescripcion(CreditosDetallados creditosdetallados) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(creditosdetallados !=null/* && creditosdetallados.getId()!=0*/) {
			sDescripcion=creditosdetallados.getcodigo();//creditosdetalladoscreditosdetallados.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getCreditosDetalladosDescripcionDetallado(CreditosDetallados creditosdetallados) {
		String sDescripcion="";
			
		sDescripcion+=CreditosDetalladosConstantesFunciones.ID+"=";
		sDescripcion+=creditosdetallados.getId().toString()+",";
		sDescripcion+=CreditosDetalladosConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=creditosdetallados.getVersionRow().toString()+",";
		sDescripcion+=CreditosDetalladosConstantesFunciones.IDCARGO+"=";
		sDescripcion+=creditosdetallados.getid_cargo().toString()+",";
		sDescripcion+=CreditosDetalladosConstantesFunciones.IDESTRUCTURA+"=";
		sDescripcion+=creditosdetallados.getid_estructura().toString()+",";
		sDescripcion+=CreditosDetalladosConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=creditosdetallados.getid_empresa().toString()+",";
		sDescripcion+=CreditosDetalladosConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=creditosdetallados.getid_empleado().toString()+",";
		sDescripcion+=CreditosDetalladosConstantesFunciones.IDTIPOPRESTAMO+"=";
		sDescripcion+=creditosdetallados.getid_tipo_prestamo().toString()+",";
		sDescripcion+=CreditosDetalladosConstantesFunciones.FECHAVENCIMIENTODESDE+"=";
		sDescripcion+=creditosdetallados.getfecha_vencimiento_desde().toString()+",";
		sDescripcion+=CreditosDetalladosConstantesFunciones.FECHAVENCIMIENTOHASTA+"=";
		sDescripcion+=creditosdetallados.getfecha_vencimiento_hasta().toString()+",";
		sDescripcion+=CreditosDetalladosConstantesFunciones.CODIGO+"=";
		sDescripcion+=creditosdetallados.getcodigo()+",";
		sDescripcion+=CreditosDetalladosConstantesFunciones.NOMBRECOMPLETO+"=";
		sDescripcion+=creditosdetallados.getnombre_completo()+",";
		sDescripcion+=CreditosDetalladosConstantesFunciones.CODIGOTIPOPRESTAMO+"=";
		sDescripcion+=creditosdetallados.getcodigo_tipo_prestamo()+",";
		sDescripcion+=CreditosDetalladosConstantesFunciones.CODIGOPRESTAMO+"=";
		sDescripcion+=creditosdetallados.getcodigo_prestamo()+",";
		sDescripcion+=CreditosDetalladosConstantesFunciones.FECHA+"=";
		sDescripcion+=creditosdetallados.getfecha().toString()+",";
		sDescripcion+=CreditosDetalladosConstantesFunciones.MONTO+"=";
		sDescripcion+=creditosdetallados.getmonto().toString()+",";
		sDescripcion+=CreditosDetalladosConstantesFunciones.NUMEROCUOTAS+"=";
		sDescripcion+=creditosdetallados.getnumero_cuotas().toString()+",";
		sDescripcion+=CreditosDetalladosConstantesFunciones.NUMERO+"=";
		sDescripcion+=creditosdetallados.getnumero().toString()+",";
		sDescripcion+=CreditosDetalladosConstantesFunciones.MONTOCAPITAL+"=";
		sDescripcion+=creditosdetallados.getmonto_capital().toString()+",";
		sDescripcion+=CreditosDetalladosConstantesFunciones.MONTOINTERES+"=";
		sDescripcion+=creditosdetallados.getmonto_interes().toString()+",";
		sDescripcion+=CreditosDetalladosConstantesFunciones.VALOR+"=";
		sDescripcion+=creditosdetallados.getvalor().toString()+",";
		sDescripcion+=CreditosDetalladosConstantesFunciones.SALDO+"=";
		sDescripcion+=creditosdetallados.getsaldo().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setCreditosDetalladosDescripcion(CreditosDetallados creditosdetallados,String sValor) throws Exception {			
		if(creditosdetallados !=null) {
			creditosdetallados.setcodigo(sValor);;//creditosdetalladoscreditosdetallados.getcodigo().trim();
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

	public static String getTipoPrestamoDescripcion(TipoPrestamo tipoprestamo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoprestamo!=null/*&&tipoprestamo.getId()>0*/) {
			sDescripcion=TipoPrestamoConstantesFunciones.getTipoPrestamoDescripcion(tipoprestamo);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaCreditosDetallados")) {
			sNombreIndice="Tipo=  Por Cargo Por Estructura Por Empleado Por Tipo Prestamo Por Fecha Vencimiento Desde Por Fecha Vencimiento Hasta";
		} else if(sNombreIndice.equals("FK_IdCargo")) {
			sNombreIndice="Tipo=  Por Cargo";
		} else if(sNombreIndice.equals("FK_IdEmpleado")) {
			sNombreIndice="Tipo=  Por Empleado";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEstructura")) {
			sNombreIndice="Tipo=  Por Estructura";
		} else if(sNombreIndice.equals("FK_IdTipoPrestamo")) {
			sNombreIndice="Tipo=  Por Tipo Prestamo";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaCreditosDetallados(Long id_cargo,Long id_estructura,Long id_empleado,Long id_tipo_prestamo,Date fecha_vencimiento_desde,Date fecha_vencimiento_hasta) {
		String sDetalleIndice=" Parametros->";
		if(id_cargo!=null) {sDetalleIndice+=" Codigo Unico De Cargo="+id_cargo.toString();}
		if(id_estructura!=null) {sDetalleIndice+=" Codigo Unico De Estructura="+id_estructura.toString();}
		if(id_empleado!=null) {sDetalleIndice+=" Codigo Unico De Empleado="+id_empleado.toString();}
		if(id_tipo_prestamo!=null) {sDetalleIndice+=" Codigo Unico De Tipo Prestamo="+id_tipo_prestamo.toString();}
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

	public static String getDetalleIndiceFK_IdTipoPrestamo(Long id_tipo_prestamo) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_prestamo!=null) {sDetalleIndice+=" Codigo Unico De Tipo Prestamo="+id_tipo_prestamo.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosCreditosDetallados(CreditosDetallados creditosdetallados,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		creditosdetallados.setcodigo(creditosdetallados.getcodigo().trim());
		creditosdetallados.setnombre_completo(creditosdetallados.getnombre_completo().trim());
		creditosdetallados.setcodigo_tipo_prestamo(creditosdetallados.getcodigo_tipo_prestamo().trim());
		creditosdetallados.setcodigo_prestamo(creditosdetallados.getcodigo_prestamo().trim());
	}
	
	public static void quitarEspaciosCreditosDetalladoss(List<CreditosDetallados> creditosdetalladoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(CreditosDetallados creditosdetallados: creditosdetalladoss) {
			creditosdetallados.setcodigo(creditosdetallados.getcodigo().trim());
			creditosdetallados.setnombre_completo(creditosdetallados.getnombre_completo().trim());
			creditosdetallados.setcodigo_tipo_prestamo(creditosdetallados.getcodigo_tipo_prestamo().trim());
			creditosdetallados.setcodigo_prestamo(creditosdetallados.getcodigo_prestamo().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCreditosDetallados(CreditosDetallados creditosdetallados,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && creditosdetallados.getConCambioAuxiliar()) {
			creditosdetallados.setIsDeleted(creditosdetallados.getIsDeletedAuxiliar());	
			creditosdetallados.setIsNew(creditosdetallados.getIsNewAuxiliar());	
			creditosdetallados.setIsChanged(creditosdetallados.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			creditosdetallados.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			creditosdetallados.setIsDeletedAuxiliar(false);	
			creditosdetallados.setIsNewAuxiliar(false);	
			creditosdetallados.setIsChangedAuxiliar(false);
			
			creditosdetallados.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCreditosDetalladoss(List<CreditosDetallados> creditosdetalladoss,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(CreditosDetallados creditosdetallados : creditosdetalladoss) {
			if(conAsignarBase && creditosdetallados.getConCambioAuxiliar()) {
				creditosdetallados.setIsDeleted(creditosdetallados.getIsDeletedAuxiliar());	
				creditosdetallados.setIsNew(creditosdetallados.getIsNewAuxiliar());	
				creditosdetallados.setIsChanged(creditosdetallados.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				creditosdetallados.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				creditosdetallados.setIsDeletedAuxiliar(false);	
				creditosdetallados.setIsNewAuxiliar(false);	
				creditosdetallados.setIsChangedAuxiliar(false);
				
				creditosdetallados.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresCreditosDetallados(CreditosDetallados creditosdetallados,Boolean conEnteros) throws Exception  {
		creditosdetallados.setmonto(0.0);
		creditosdetallados.setmonto_capital(0.0);
		creditosdetallados.setmonto_interes(0.0);
		creditosdetallados.setvalor(0.0);
		creditosdetallados.setsaldo(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			creditosdetallados.setnumero_cuotas(0);
			creditosdetallados.setnumero(0);
		}
	}		
	
	public static void InicializarValoresCreditosDetalladoss(List<CreditosDetallados> creditosdetalladoss,Boolean conEnteros) throws Exception  {
		
		for(CreditosDetallados creditosdetallados: creditosdetalladoss) {
			creditosdetallados.setmonto(0.0);
			creditosdetallados.setmonto_capital(0.0);
			creditosdetallados.setmonto_interes(0.0);
			creditosdetallados.setvalor(0.0);
			creditosdetallados.setsaldo(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				creditosdetallados.setnumero_cuotas(0);
				creditosdetallados.setnumero(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaCreditosDetallados(List<CreditosDetallados> creditosdetalladoss,CreditosDetallados creditosdetalladosAux) throws Exception  {
		CreditosDetalladosConstantesFunciones.InicializarValoresCreditosDetallados(creditosdetalladosAux,true);
		
		for(CreditosDetallados creditosdetallados: creditosdetalladoss) {
			if(creditosdetallados.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			creditosdetalladosAux.setmonto(creditosdetalladosAux.getmonto()+creditosdetallados.getmonto());			
			creditosdetalladosAux.setnumero_cuotas(creditosdetalladosAux.getnumero_cuotas()+creditosdetallados.getnumero_cuotas());			
			creditosdetalladosAux.setnumero(creditosdetalladosAux.getnumero()+creditosdetallados.getnumero());			
			creditosdetalladosAux.setmonto_capital(creditosdetalladosAux.getmonto_capital()+creditosdetallados.getmonto_capital());			
			creditosdetalladosAux.setmonto_interes(creditosdetalladosAux.getmonto_interes()+creditosdetallados.getmonto_interes());			
			creditosdetalladosAux.setvalor(creditosdetalladosAux.getvalor()+creditosdetallados.getvalor());			
			creditosdetalladosAux.setsaldo(creditosdetalladosAux.getsaldo()+creditosdetallados.getsaldo());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCreditosDetallados(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=CreditosDetalladosConstantesFunciones.getArrayColumnasGlobalesCreditosDetallados(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesCreditosDetallados(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CreditosDetalladosConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CreditosDetalladosConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoCreditosDetallados(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<CreditosDetallados> creditosdetalladoss,CreditosDetallados creditosdetallados,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(CreditosDetallados creditosdetalladosAux: creditosdetalladoss) {
			if(creditosdetalladosAux!=null && creditosdetallados!=null) {
				if((creditosdetalladosAux.getId()==null && creditosdetallados.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(creditosdetalladosAux.getId()!=null && creditosdetallados.getId()!=null){
					if(creditosdetalladosAux.getId().equals(creditosdetallados.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCreditosDetallados(List<CreditosDetallados> creditosdetalladoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double montoTotal=0.0;
		Double monto_capitalTotal=0.0;
		Double monto_interesTotal=0.0;
		Double valorTotal=0.0;
		Double saldoTotal=0.0;
	
		for(CreditosDetallados creditosdetallados: creditosdetalladoss) {			
			if(creditosdetallados.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			montoTotal+=creditosdetallados.getmonto();
			monto_capitalTotal+=creditosdetallados.getmonto_capital();
			monto_interesTotal+=creditosdetallados.getmonto_interes();
			valorTotal+=creditosdetallados.getvalor();
			saldoTotal+=creditosdetallados.getsaldo();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CreditosDetalladosConstantesFunciones.MONTO);
		datoGeneral.setsDescripcion(CreditosDetalladosConstantesFunciones.LABEL_MONTO);
		datoGeneral.setdValorDouble(montoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CreditosDetalladosConstantesFunciones.MONTOCAPITAL);
		datoGeneral.setsDescripcion(CreditosDetalladosConstantesFunciones.LABEL_MONTOCAPITAL);
		datoGeneral.setdValorDouble(monto_capitalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CreditosDetalladosConstantesFunciones.MONTOINTERES);
		datoGeneral.setsDescripcion(CreditosDetalladosConstantesFunciones.LABEL_MONTOINTERES);
		datoGeneral.setdValorDouble(monto_interesTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CreditosDetalladosConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(CreditosDetalladosConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CreditosDetalladosConstantesFunciones.SALDO);
		datoGeneral.setsDescripcion(CreditosDetalladosConstantesFunciones.LABEL_SALDO);
		datoGeneral.setdValorDouble(saldoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaCreditosDetallados() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,CreditosDetalladosConstantesFunciones.LABEL_ID, CreditosDetalladosConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CreditosDetalladosConstantesFunciones.LABEL_VERSIONROW, CreditosDetalladosConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CreditosDetalladosConstantesFunciones.LABEL_CODIGO, CreditosDetalladosConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CreditosDetalladosConstantesFunciones.LABEL_NOMBRECOMPLETO, CreditosDetalladosConstantesFunciones.NOMBRECOMPLETO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CreditosDetalladosConstantesFunciones.LABEL_CODIGOTIPOPRESTAMO, CreditosDetalladosConstantesFunciones.CODIGOTIPOPRESTAMO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CreditosDetalladosConstantesFunciones.LABEL_CODIGOPRESTAMO, CreditosDetalladosConstantesFunciones.CODIGOPRESTAMO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CreditosDetalladosConstantesFunciones.LABEL_FECHA, CreditosDetalladosConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CreditosDetalladosConstantesFunciones.LABEL_MONTO, CreditosDetalladosConstantesFunciones.MONTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CreditosDetalladosConstantesFunciones.LABEL_NUMEROCUOTAS, CreditosDetalladosConstantesFunciones.NUMEROCUOTAS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CreditosDetalladosConstantesFunciones.LABEL_NUMERO, CreditosDetalladosConstantesFunciones.NUMERO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CreditosDetalladosConstantesFunciones.LABEL_MONTOCAPITAL, CreditosDetalladosConstantesFunciones.MONTOCAPITAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CreditosDetalladosConstantesFunciones.LABEL_MONTOINTERES, CreditosDetalladosConstantesFunciones.MONTOINTERES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CreditosDetalladosConstantesFunciones.LABEL_VALOR, CreditosDetalladosConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CreditosDetalladosConstantesFunciones.LABEL_SALDO, CreditosDetalladosConstantesFunciones.SALDO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasCreditosDetallados() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=CreditosDetalladosConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CreditosDetalladosConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CreditosDetalladosConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CreditosDetalladosConstantesFunciones.NOMBRECOMPLETO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CreditosDetalladosConstantesFunciones.CODIGOTIPOPRESTAMO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CreditosDetalladosConstantesFunciones.CODIGOPRESTAMO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CreditosDetalladosConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CreditosDetalladosConstantesFunciones.MONTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CreditosDetalladosConstantesFunciones.NUMEROCUOTAS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CreditosDetalladosConstantesFunciones.NUMERO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CreditosDetalladosConstantesFunciones.MONTOCAPITAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CreditosDetalladosConstantesFunciones.MONTOINTERES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CreditosDetalladosConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CreditosDetalladosConstantesFunciones.SALDO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCreditosDetallados() throws Exception  {
		return CreditosDetalladosConstantesFunciones.getTiposSeleccionarCreditosDetallados(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCreditosDetallados(Boolean conFk) throws Exception  {
		return CreditosDetalladosConstantesFunciones.getTiposSeleccionarCreditosDetallados(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCreditosDetallados(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CreditosDetalladosConstantesFunciones.LABEL_IDCARGO);
			reporte.setsDescripcion(CreditosDetalladosConstantesFunciones.LABEL_IDCARGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CreditosDetalladosConstantesFunciones.LABEL_IDESTRUCTURA);
			reporte.setsDescripcion(CreditosDetalladosConstantesFunciones.LABEL_IDESTRUCTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CreditosDetalladosConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(CreditosDetalladosConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CreditosDetalladosConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(CreditosDetalladosConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CreditosDetalladosConstantesFunciones.LABEL_IDTIPOPRESTAMO);
			reporte.setsDescripcion(CreditosDetalladosConstantesFunciones.LABEL_IDTIPOPRESTAMO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CreditosDetalladosConstantesFunciones.LABEL_FECHAVENCIMIENTODESDE);
			reporte.setsDescripcion(CreditosDetalladosConstantesFunciones.LABEL_FECHAVENCIMIENTODESDE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CreditosDetalladosConstantesFunciones.LABEL_FECHAVENCIMIENTOHASTA);
			reporte.setsDescripcion(CreditosDetalladosConstantesFunciones.LABEL_FECHAVENCIMIENTOHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CreditosDetalladosConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(CreditosDetalladosConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CreditosDetalladosConstantesFunciones.LABEL_NOMBRECOMPLETO);
			reporte.setsDescripcion(CreditosDetalladosConstantesFunciones.LABEL_NOMBRECOMPLETO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CreditosDetalladosConstantesFunciones.LABEL_CODIGOTIPOPRESTAMO);
			reporte.setsDescripcion(CreditosDetalladosConstantesFunciones.LABEL_CODIGOTIPOPRESTAMO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CreditosDetalladosConstantesFunciones.LABEL_CODIGOPRESTAMO);
			reporte.setsDescripcion(CreditosDetalladosConstantesFunciones.LABEL_CODIGOPRESTAMO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CreditosDetalladosConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(CreditosDetalladosConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CreditosDetalladosConstantesFunciones.LABEL_MONTO);
			reporte.setsDescripcion(CreditosDetalladosConstantesFunciones.LABEL_MONTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CreditosDetalladosConstantesFunciones.LABEL_NUMEROCUOTAS);
			reporte.setsDescripcion(CreditosDetalladosConstantesFunciones.LABEL_NUMEROCUOTAS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CreditosDetalladosConstantesFunciones.LABEL_NUMERO);
			reporte.setsDescripcion(CreditosDetalladosConstantesFunciones.LABEL_NUMERO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CreditosDetalladosConstantesFunciones.LABEL_MONTOCAPITAL);
			reporte.setsDescripcion(CreditosDetalladosConstantesFunciones.LABEL_MONTOCAPITAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CreditosDetalladosConstantesFunciones.LABEL_MONTOINTERES);
			reporte.setsDescripcion(CreditosDetalladosConstantesFunciones.LABEL_MONTOINTERES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CreditosDetalladosConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(CreditosDetalladosConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CreditosDetalladosConstantesFunciones.LABEL_SALDO);
			reporte.setsDescripcion(CreditosDetalladosConstantesFunciones.LABEL_SALDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesCreditosDetallados(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesCreditosDetallados(CreditosDetallados creditosdetalladosAux) throws Exception {
		
			creditosdetalladosAux.setcargo_descripcion(CargoConstantesFunciones.getCargoDescripcion(creditosdetalladosAux.getCargo()));
			creditosdetalladosAux.setestructura_descripcion(EstructuraConstantesFunciones.getEstructuraDescripcion(creditosdetalladosAux.getEstructura()));
			creditosdetalladosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(creditosdetalladosAux.getEmpresa()));
			creditosdetalladosAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(creditosdetalladosAux.getEmpleado()));
			creditosdetalladosAux.settipoprestamo_descripcion(TipoPrestamoConstantesFunciones.getTipoPrestamoDescripcion(creditosdetalladosAux.getTipoPrestamo()));		
	}
	
	public static void refrescarForeignKeysDescripcionesCreditosDetallados(List<CreditosDetallados> creditosdetalladossTemp) throws Exception {
		for(CreditosDetallados creditosdetalladosAux:creditosdetalladossTemp) {
			
			creditosdetalladosAux.setcargo_descripcion(CargoConstantesFunciones.getCargoDescripcion(creditosdetalladosAux.getCargo()));
			creditosdetalladosAux.setestructura_descripcion(EstructuraConstantesFunciones.getEstructuraDescripcion(creditosdetalladosAux.getEstructura()));
			creditosdetalladosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(creditosdetalladosAux.getEmpresa()));
			creditosdetalladosAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(creditosdetalladosAux.getEmpleado()));
			creditosdetalladosAux.settipoprestamo_descripcion(TipoPrestamoConstantesFunciones.getTipoPrestamoDescripcion(creditosdetalladosAux.getTipoPrestamo()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfCreditosDetallados(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Cargo.class));
				classes.add(new Classe(Estructura.class));
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(TipoPrestamo.class));
				
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

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoPrestamo.class)) {
						classes.add(new Classe(TipoPrestamo.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfCreditosDetallados(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(TipoPrestamo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoPrestamo.class)); continue;
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

					if(TipoPrestamo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoPrestamo.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfCreditosDetallados(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return CreditosDetalladosConstantesFunciones.getClassesRelationshipsOfCreditosDetallados(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCreditosDetallados(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCreditosDetallados(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return CreditosDetalladosConstantesFunciones.getClassesRelationshipsFromStringsOfCreditosDetallados(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCreditosDetallados(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(CreditosDetallados creditosdetallados,List<CreditosDetallados> creditosdetalladoss,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(CreditosDetallados creditosdetallados,List<CreditosDetallados> creditosdetalladoss) throws Exception {
		try	{			
			for(CreditosDetallados creditosdetalladosLocal:creditosdetalladoss) {
				if(creditosdetalladosLocal.getId().equals(creditosdetallados.getId())) {
					creditosdetalladosLocal.setIsSelected(creditosdetallados.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesCreditosDetallados(List<CreditosDetallados> creditosdetalladossAux) throws Exception {
		//this.creditosdetalladossAux=creditosdetalladossAux;
		
		for(CreditosDetallados creditosdetalladosAux:creditosdetalladossAux) {
			if(creditosdetalladosAux.getIsChanged()) {
				creditosdetalladosAux.setIsChanged(false);
			}		
			
			if(creditosdetalladosAux.getIsNew()) {
				creditosdetalladosAux.setIsNew(false);
			}	
			
			if(creditosdetalladosAux.getIsDeleted()) {
				creditosdetalladosAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesCreditosDetallados(CreditosDetallados creditosdetalladosAux) throws Exception {
		//this.creditosdetalladosAux=creditosdetalladosAux;
		
			if(creditosdetalladosAux.getIsChanged()) {
				creditosdetalladosAux.setIsChanged(false);
			}		
			
			if(creditosdetalladosAux.getIsNew()) {
				creditosdetalladosAux.setIsNew(false);
			}	
			
			if(creditosdetalladosAux.getIsDeleted()) {
				creditosdetalladosAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(CreditosDetallados creditosdetalladosAsignar,CreditosDetallados creditosdetallados) throws Exception {
		creditosdetalladosAsignar.setId(creditosdetallados.getId());	
		creditosdetalladosAsignar.setVersionRow(creditosdetallados.getVersionRow());	
		creditosdetalladosAsignar.setcodigo(creditosdetallados.getcodigo());	
		creditosdetalladosAsignar.setnombre_completo(creditosdetallados.getnombre_completo());	
		creditosdetalladosAsignar.setcodigo_tipo_prestamo(creditosdetallados.getcodigo_tipo_prestamo());	
		creditosdetalladosAsignar.setcodigo_prestamo(creditosdetallados.getcodigo_prestamo());	
		creditosdetalladosAsignar.setfecha(creditosdetallados.getfecha());	
		creditosdetalladosAsignar.setmonto(creditosdetallados.getmonto());	
		creditosdetalladosAsignar.setnumero_cuotas(creditosdetallados.getnumero_cuotas());	
		creditosdetalladosAsignar.setnumero(creditosdetallados.getnumero());	
		creditosdetalladosAsignar.setmonto_capital(creditosdetallados.getmonto_capital());	
		creditosdetalladosAsignar.setmonto_interes(creditosdetallados.getmonto_interes());	
		creditosdetalladosAsignar.setvalor(creditosdetallados.getvalor());	
		creditosdetalladosAsignar.setsaldo(creditosdetallados.getsaldo());	
	}
	
	public static void inicializarCreditosDetallados(CreditosDetallados creditosdetallados) throws Exception {
		try {
				creditosdetallados.setId(0L);	
					
				creditosdetallados.setcodigo("");	
				creditosdetallados.setnombre_completo("");	
				creditosdetallados.setcodigo_tipo_prestamo("");	
				creditosdetallados.setcodigo_prestamo("");	
				creditosdetallados.setfecha(new Date());	
				creditosdetallados.setmonto(0.0);	
				creditosdetallados.setnumero_cuotas(0);	
				creditosdetallados.setnumero(0);	
				creditosdetallados.setmonto_capital(0.0);	
				creditosdetallados.setmonto_interes(0.0);	
				creditosdetallados.setvalor(0.0);	
				creditosdetallados.setsaldo(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderCreditosDetallados(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(CreditosDetalladosConstantesFunciones.LABEL_IDCARGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CreditosDetalladosConstantesFunciones.LABEL_IDESTRUCTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CreditosDetalladosConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CreditosDetalladosConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CreditosDetalladosConstantesFunciones.LABEL_IDTIPOPRESTAMO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CreditosDetalladosConstantesFunciones.LABEL_FECHAVENCIMIENTODESDE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CreditosDetalladosConstantesFunciones.LABEL_FECHAVENCIMIENTOHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CreditosDetalladosConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CreditosDetalladosConstantesFunciones.LABEL_NOMBRECOMPLETO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CreditosDetalladosConstantesFunciones.LABEL_CODIGOTIPOPRESTAMO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CreditosDetalladosConstantesFunciones.LABEL_CODIGOPRESTAMO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CreditosDetalladosConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CreditosDetalladosConstantesFunciones.LABEL_MONTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CreditosDetalladosConstantesFunciones.LABEL_NUMEROCUOTAS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CreditosDetalladosConstantesFunciones.LABEL_NUMERO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CreditosDetalladosConstantesFunciones.LABEL_MONTOCAPITAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CreditosDetalladosConstantesFunciones.LABEL_MONTOINTERES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CreditosDetalladosConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CreditosDetalladosConstantesFunciones.LABEL_SALDO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataCreditosDetallados(String sTipo,Row row,Workbook workbook,CreditosDetallados creditosdetallados,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(creditosdetallados.getcargo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(creditosdetallados.getestructura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(creditosdetallados.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(creditosdetallados.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(creditosdetallados.gettipoprestamo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(creditosdetallados.getfecha_vencimiento_desde());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(creditosdetallados.getfecha_vencimiento_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(creditosdetallados.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(creditosdetallados.getnombre_completo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(creditosdetallados.getcodigo_tipo_prestamo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(creditosdetallados.getcodigo_prestamo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(creditosdetallados.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(creditosdetallados.getmonto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(creditosdetallados.getnumero_cuotas());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(creditosdetallados.getnumero());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(creditosdetallados.getmonto_capital());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(creditosdetallados.getmonto_interes());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(creditosdetallados.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(creditosdetallados.getsaldo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryCreditosDetallados="";
	
	public String getsFinalQueryCreditosDetallados() {
		return this.sFinalQueryCreditosDetallados;
	}
	
	public void setsFinalQueryCreditosDetallados(String sFinalQueryCreditosDetallados) {
		this.sFinalQueryCreditosDetallados= sFinalQueryCreditosDetallados;
	}
	
	public Border resaltarSeleccionarCreditosDetallados=null;
	
	public Border setResaltarSeleccionarCreditosDetallados(ParametroGeneralUsuario parametroGeneralUsuario/*CreditosDetalladosBeanSwingJInternalFrame creditosdetalladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//creditosdetalladosBeanSwingJInternalFrame.jTtoolBarCreditosDetallados.setBorder(borderResaltar);
		
		this.resaltarSeleccionarCreditosDetallados= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarCreditosDetallados() {
		return this.resaltarSeleccionarCreditosDetallados;
	}
	
	public void setResaltarSeleccionarCreditosDetallados(Border borderResaltarSeleccionarCreditosDetallados) {
		this.resaltarSeleccionarCreditosDetallados= borderResaltarSeleccionarCreditosDetallados;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridCreditosDetallados=null;
	public Boolean mostraridCreditosDetallados=true;
	public Boolean activaridCreditosDetallados=true;

	public Border resaltarid_cargoCreditosDetallados=null;
	public Boolean mostrarid_cargoCreditosDetallados=true;
	public Boolean activarid_cargoCreditosDetallados=true;
	public Boolean cargarid_cargoCreditosDetallados=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cargoCreditosDetallados=false;//ConEventDepend=true

	public Border resaltarid_estructuraCreditosDetallados=null;
	public Boolean mostrarid_estructuraCreditosDetallados=true;
	public Boolean activarid_estructuraCreditosDetallados=true;
	public Boolean cargarid_estructuraCreditosDetallados=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estructuraCreditosDetallados=false;//ConEventDepend=true

	public Border resaltarid_empresaCreditosDetallados=null;
	public Boolean mostrarid_empresaCreditosDetallados=true;
	public Boolean activarid_empresaCreditosDetallados=true;
	public Boolean cargarid_empresaCreditosDetallados=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaCreditosDetallados=false;//ConEventDepend=true

	public Border resaltarid_empleadoCreditosDetallados=null;
	public Boolean mostrarid_empleadoCreditosDetallados=true;
	public Boolean activarid_empleadoCreditosDetallados=true;
	public Boolean cargarid_empleadoCreditosDetallados=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoCreditosDetallados=false;//ConEventDepend=true

	public Border resaltarid_tipo_prestamoCreditosDetallados=null;
	public Boolean mostrarid_tipo_prestamoCreditosDetallados=true;
	public Boolean activarid_tipo_prestamoCreditosDetallados=true;
	public Boolean cargarid_tipo_prestamoCreditosDetallados=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_prestamoCreditosDetallados=false;//ConEventDepend=true

	public Border resaltarfecha_vencimiento_desdeCreditosDetallados=null;
	public Boolean mostrarfecha_vencimiento_desdeCreditosDetallados=true;
	public Boolean activarfecha_vencimiento_desdeCreditosDetallados=true;

	public Border resaltarfecha_vencimiento_hastaCreditosDetallados=null;
	public Boolean mostrarfecha_vencimiento_hastaCreditosDetallados=true;
	public Boolean activarfecha_vencimiento_hastaCreditosDetallados=true;

	public Border resaltarcodigoCreditosDetallados=null;
	public Boolean mostrarcodigoCreditosDetallados=true;
	public Boolean activarcodigoCreditosDetallados=true;

	public Border resaltarnombre_completoCreditosDetallados=null;
	public Boolean mostrarnombre_completoCreditosDetallados=true;
	public Boolean activarnombre_completoCreditosDetallados=true;

	public Border resaltarcodigo_tipo_prestamoCreditosDetallados=null;
	public Boolean mostrarcodigo_tipo_prestamoCreditosDetallados=true;
	public Boolean activarcodigo_tipo_prestamoCreditosDetallados=true;

	public Border resaltarcodigo_prestamoCreditosDetallados=null;
	public Boolean mostrarcodigo_prestamoCreditosDetallados=true;
	public Boolean activarcodigo_prestamoCreditosDetallados=true;

	public Border resaltarfechaCreditosDetallados=null;
	public Boolean mostrarfechaCreditosDetallados=true;
	public Boolean activarfechaCreditosDetallados=true;

	public Border resaltarmontoCreditosDetallados=null;
	public Boolean mostrarmontoCreditosDetallados=true;
	public Boolean activarmontoCreditosDetallados=true;

	public Border resaltarnumero_cuotasCreditosDetallados=null;
	public Boolean mostrarnumero_cuotasCreditosDetallados=true;
	public Boolean activarnumero_cuotasCreditosDetallados=true;

	public Border resaltarnumeroCreditosDetallados=null;
	public Boolean mostrarnumeroCreditosDetallados=true;
	public Boolean activarnumeroCreditosDetallados=true;

	public Border resaltarmonto_capitalCreditosDetallados=null;
	public Boolean mostrarmonto_capitalCreditosDetallados=true;
	public Boolean activarmonto_capitalCreditosDetallados=true;

	public Border resaltarmonto_interesCreditosDetallados=null;
	public Boolean mostrarmonto_interesCreditosDetallados=true;
	public Boolean activarmonto_interesCreditosDetallados=true;

	public Border resaltarvalorCreditosDetallados=null;
	public Boolean mostrarvalorCreditosDetallados=true;
	public Boolean activarvalorCreditosDetallados=true;

	public Border resaltarsaldoCreditosDetallados=null;
	public Boolean mostrarsaldoCreditosDetallados=true;
	public Boolean activarsaldoCreditosDetallados=true;

	
	

	public Border setResaltaridCreditosDetallados(ParametroGeneralUsuario parametroGeneralUsuario/*CreditosDetalladosBeanSwingJInternalFrame creditosdetalladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//creditosdetalladosBeanSwingJInternalFrame.jTtoolBarCreditosDetallados.setBorder(borderResaltar);
		
		this.resaltaridCreditosDetallados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridCreditosDetallados() {
		return this.resaltaridCreditosDetallados;
	}

	public void setResaltaridCreditosDetallados(Border borderResaltar) {
		this.resaltaridCreditosDetallados= borderResaltar;
	}

	public Boolean getMostraridCreditosDetallados() {
		return this.mostraridCreditosDetallados;
	}

	public void setMostraridCreditosDetallados(Boolean mostraridCreditosDetallados) {
		this.mostraridCreditosDetallados= mostraridCreditosDetallados;
	}

	public Boolean getActivaridCreditosDetallados() {
		return this.activaridCreditosDetallados;
	}

	public void setActivaridCreditosDetallados(Boolean activaridCreditosDetallados) {
		this.activaridCreditosDetallados= activaridCreditosDetallados;
	}

	public Border setResaltarid_cargoCreditosDetallados(ParametroGeneralUsuario parametroGeneralUsuario/*CreditosDetalladosBeanSwingJInternalFrame creditosdetalladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//creditosdetalladosBeanSwingJInternalFrame.jTtoolBarCreditosDetallados.setBorder(borderResaltar);
		
		this.resaltarid_cargoCreditosDetallados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cargoCreditosDetallados() {
		return this.resaltarid_cargoCreditosDetallados;
	}

	public void setResaltarid_cargoCreditosDetallados(Border borderResaltar) {
		this.resaltarid_cargoCreditosDetallados= borderResaltar;
	}

	public Boolean getMostrarid_cargoCreditosDetallados() {
		return this.mostrarid_cargoCreditosDetallados;
	}

	public void setMostrarid_cargoCreditosDetallados(Boolean mostrarid_cargoCreditosDetallados) {
		this.mostrarid_cargoCreditosDetallados= mostrarid_cargoCreditosDetallados;
	}

	public Boolean getActivarid_cargoCreditosDetallados() {
		return this.activarid_cargoCreditosDetallados;
	}

	public void setActivarid_cargoCreditosDetallados(Boolean activarid_cargoCreditosDetallados) {
		this.activarid_cargoCreditosDetallados= activarid_cargoCreditosDetallados;
	}

	public Boolean getCargarid_cargoCreditosDetallados() {
		return this.cargarid_cargoCreditosDetallados;
	}

	public void setCargarid_cargoCreditosDetallados(Boolean cargarid_cargoCreditosDetallados) {
		this.cargarid_cargoCreditosDetallados= cargarid_cargoCreditosDetallados;
	}

	public Border setResaltarid_estructuraCreditosDetallados(ParametroGeneralUsuario parametroGeneralUsuario/*CreditosDetalladosBeanSwingJInternalFrame creditosdetalladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//creditosdetalladosBeanSwingJInternalFrame.jTtoolBarCreditosDetallados.setBorder(borderResaltar);
		
		this.resaltarid_estructuraCreditosDetallados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estructuraCreditosDetallados() {
		return this.resaltarid_estructuraCreditosDetallados;
	}

	public void setResaltarid_estructuraCreditosDetallados(Border borderResaltar) {
		this.resaltarid_estructuraCreditosDetallados= borderResaltar;
	}

	public Boolean getMostrarid_estructuraCreditosDetallados() {
		return this.mostrarid_estructuraCreditosDetallados;
	}

	public void setMostrarid_estructuraCreditosDetallados(Boolean mostrarid_estructuraCreditosDetallados) {
		this.mostrarid_estructuraCreditosDetallados= mostrarid_estructuraCreditosDetallados;
	}

	public Boolean getActivarid_estructuraCreditosDetallados() {
		return this.activarid_estructuraCreditosDetallados;
	}

	public void setActivarid_estructuraCreditosDetallados(Boolean activarid_estructuraCreditosDetallados) {
		this.activarid_estructuraCreditosDetallados= activarid_estructuraCreditosDetallados;
	}

	public Boolean getCargarid_estructuraCreditosDetallados() {
		return this.cargarid_estructuraCreditosDetallados;
	}

	public void setCargarid_estructuraCreditosDetallados(Boolean cargarid_estructuraCreditosDetallados) {
		this.cargarid_estructuraCreditosDetallados= cargarid_estructuraCreditosDetallados;
	}

	public Border setResaltarid_empresaCreditosDetallados(ParametroGeneralUsuario parametroGeneralUsuario/*CreditosDetalladosBeanSwingJInternalFrame creditosdetalladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//creditosdetalladosBeanSwingJInternalFrame.jTtoolBarCreditosDetallados.setBorder(borderResaltar);
		
		this.resaltarid_empresaCreditosDetallados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaCreditosDetallados() {
		return this.resaltarid_empresaCreditosDetallados;
	}

	public void setResaltarid_empresaCreditosDetallados(Border borderResaltar) {
		this.resaltarid_empresaCreditosDetallados= borderResaltar;
	}

	public Boolean getMostrarid_empresaCreditosDetallados() {
		return this.mostrarid_empresaCreditosDetallados;
	}

	public void setMostrarid_empresaCreditosDetallados(Boolean mostrarid_empresaCreditosDetallados) {
		this.mostrarid_empresaCreditosDetallados= mostrarid_empresaCreditosDetallados;
	}

	public Boolean getActivarid_empresaCreditosDetallados() {
		return this.activarid_empresaCreditosDetallados;
	}

	public void setActivarid_empresaCreditosDetallados(Boolean activarid_empresaCreditosDetallados) {
		this.activarid_empresaCreditosDetallados= activarid_empresaCreditosDetallados;
	}

	public Boolean getCargarid_empresaCreditosDetallados() {
		return this.cargarid_empresaCreditosDetallados;
	}

	public void setCargarid_empresaCreditosDetallados(Boolean cargarid_empresaCreditosDetallados) {
		this.cargarid_empresaCreditosDetallados= cargarid_empresaCreditosDetallados;
	}

	public Border setResaltarid_empleadoCreditosDetallados(ParametroGeneralUsuario parametroGeneralUsuario/*CreditosDetalladosBeanSwingJInternalFrame creditosdetalladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//creditosdetalladosBeanSwingJInternalFrame.jTtoolBarCreditosDetallados.setBorder(borderResaltar);
		
		this.resaltarid_empleadoCreditosDetallados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoCreditosDetallados() {
		return this.resaltarid_empleadoCreditosDetallados;
	}

	public void setResaltarid_empleadoCreditosDetallados(Border borderResaltar) {
		this.resaltarid_empleadoCreditosDetallados= borderResaltar;
	}

	public Boolean getMostrarid_empleadoCreditosDetallados() {
		return this.mostrarid_empleadoCreditosDetallados;
	}

	public void setMostrarid_empleadoCreditosDetallados(Boolean mostrarid_empleadoCreditosDetallados) {
		this.mostrarid_empleadoCreditosDetallados= mostrarid_empleadoCreditosDetallados;
	}

	public Boolean getActivarid_empleadoCreditosDetallados() {
		return this.activarid_empleadoCreditosDetallados;
	}

	public void setActivarid_empleadoCreditosDetallados(Boolean activarid_empleadoCreditosDetallados) {
		this.activarid_empleadoCreditosDetallados= activarid_empleadoCreditosDetallados;
	}

	public Boolean getCargarid_empleadoCreditosDetallados() {
		return this.cargarid_empleadoCreditosDetallados;
	}

	public void setCargarid_empleadoCreditosDetallados(Boolean cargarid_empleadoCreditosDetallados) {
		this.cargarid_empleadoCreditosDetallados= cargarid_empleadoCreditosDetallados;
	}

	public Border setResaltarid_tipo_prestamoCreditosDetallados(ParametroGeneralUsuario parametroGeneralUsuario/*CreditosDetalladosBeanSwingJInternalFrame creditosdetalladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//creditosdetalladosBeanSwingJInternalFrame.jTtoolBarCreditosDetallados.setBorder(borderResaltar);
		
		this.resaltarid_tipo_prestamoCreditosDetallados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_prestamoCreditosDetallados() {
		return this.resaltarid_tipo_prestamoCreditosDetallados;
	}

	public void setResaltarid_tipo_prestamoCreditosDetallados(Border borderResaltar) {
		this.resaltarid_tipo_prestamoCreditosDetallados= borderResaltar;
	}

	public Boolean getMostrarid_tipo_prestamoCreditosDetallados() {
		return this.mostrarid_tipo_prestamoCreditosDetallados;
	}

	public void setMostrarid_tipo_prestamoCreditosDetallados(Boolean mostrarid_tipo_prestamoCreditosDetallados) {
		this.mostrarid_tipo_prestamoCreditosDetallados= mostrarid_tipo_prestamoCreditosDetallados;
	}

	public Boolean getActivarid_tipo_prestamoCreditosDetallados() {
		return this.activarid_tipo_prestamoCreditosDetallados;
	}

	public void setActivarid_tipo_prestamoCreditosDetallados(Boolean activarid_tipo_prestamoCreditosDetallados) {
		this.activarid_tipo_prestamoCreditosDetallados= activarid_tipo_prestamoCreditosDetallados;
	}

	public Boolean getCargarid_tipo_prestamoCreditosDetallados() {
		return this.cargarid_tipo_prestamoCreditosDetallados;
	}

	public void setCargarid_tipo_prestamoCreditosDetallados(Boolean cargarid_tipo_prestamoCreditosDetallados) {
		this.cargarid_tipo_prestamoCreditosDetallados= cargarid_tipo_prestamoCreditosDetallados;
	}

	public Border setResaltarfecha_vencimiento_desdeCreditosDetallados(ParametroGeneralUsuario parametroGeneralUsuario/*CreditosDetalladosBeanSwingJInternalFrame creditosdetalladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//creditosdetalladosBeanSwingJInternalFrame.jTtoolBarCreditosDetallados.setBorder(borderResaltar);
		
		this.resaltarfecha_vencimiento_desdeCreditosDetallados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_vencimiento_desdeCreditosDetallados() {
		return this.resaltarfecha_vencimiento_desdeCreditosDetallados;
	}

	public void setResaltarfecha_vencimiento_desdeCreditosDetallados(Border borderResaltar) {
		this.resaltarfecha_vencimiento_desdeCreditosDetallados= borderResaltar;
	}

	public Boolean getMostrarfecha_vencimiento_desdeCreditosDetallados() {
		return this.mostrarfecha_vencimiento_desdeCreditosDetallados;
	}

	public void setMostrarfecha_vencimiento_desdeCreditosDetallados(Boolean mostrarfecha_vencimiento_desdeCreditosDetallados) {
		this.mostrarfecha_vencimiento_desdeCreditosDetallados= mostrarfecha_vencimiento_desdeCreditosDetallados;
	}

	public Boolean getActivarfecha_vencimiento_desdeCreditosDetallados() {
		return this.activarfecha_vencimiento_desdeCreditosDetallados;
	}

	public void setActivarfecha_vencimiento_desdeCreditosDetallados(Boolean activarfecha_vencimiento_desdeCreditosDetallados) {
		this.activarfecha_vencimiento_desdeCreditosDetallados= activarfecha_vencimiento_desdeCreditosDetallados;
	}

	public Border setResaltarfecha_vencimiento_hastaCreditosDetallados(ParametroGeneralUsuario parametroGeneralUsuario/*CreditosDetalladosBeanSwingJInternalFrame creditosdetalladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//creditosdetalladosBeanSwingJInternalFrame.jTtoolBarCreditosDetallados.setBorder(borderResaltar);
		
		this.resaltarfecha_vencimiento_hastaCreditosDetallados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_vencimiento_hastaCreditosDetallados() {
		return this.resaltarfecha_vencimiento_hastaCreditosDetallados;
	}

	public void setResaltarfecha_vencimiento_hastaCreditosDetallados(Border borderResaltar) {
		this.resaltarfecha_vencimiento_hastaCreditosDetallados= borderResaltar;
	}

	public Boolean getMostrarfecha_vencimiento_hastaCreditosDetallados() {
		return this.mostrarfecha_vencimiento_hastaCreditosDetallados;
	}

	public void setMostrarfecha_vencimiento_hastaCreditosDetallados(Boolean mostrarfecha_vencimiento_hastaCreditosDetallados) {
		this.mostrarfecha_vencimiento_hastaCreditosDetallados= mostrarfecha_vencimiento_hastaCreditosDetallados;
	}

	public Boolean getActivarfecha_vencimiento_hastaCreditosDetallados() {
		return this.activarfecha_vencimiento_hastaCreditosDetallados;
	}

	public void setActivarfecha_vencimiento_hastaCreditosDetallados(Boolean activarfecha_vencimiento_hastaCreditosDetallados) {
		this.activarfecha_vencimiento_hastaCreditosDetallados= activarfecha_vencimiento_hastaCreditosDetallados;
	}

	public Border setResaltarcodigoCreditosDetallados(ParametroGeneralUsuario parametroGeneralUsuario/*CreditosDetalladosBeanSwingJInternalFrame creditosdetalladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//creditosdetalladosBeanSwingJInternalFrame.jTtoolBarCreditosDetallados.setBorder(borderResaltar);
		
		this.resaltarcodigoCreditosDetallados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoCreditosDetallados() {
		return this.resaltarcodigoCreditosDetallados;
	}

	public void setResaltarcodigoCreditosDetallados(Border borderResaltar) {
		this.resaltarcodigoCreditosDetallados= borderResaltar;
	}

	public Boolean getMostrarcodigoCreditosDetallados() {
		return this.mostrarcodigoCreditosDetallados;
	}

	public void setMostrarcodigoCreditosDetallados(Boolean mostrarcodigoCreditosDetallados) {
		this.mostrarcodigoCreditosDetallados= mostrarcodigoCreditosDetallados;
	}

	public Boolean getActivarcodigoCreditosDetallados() {
		return this.activarcodigoCreditosDetallados;
	}

	public void setActivarcodigoCreditosDetallados(Boolean activarcodigoCreditosDetallados) {
		this.activarcodigoCreditosDetallados= activarcodigoCreditosDetallados;
	}

	public Border setResaltarnombre_completoCreditosDetallados(ParametroGeneralUsuario parametroGeneralUsuario/*CreditosDetalladosBeanSwingJInternalFrame creditosdetalladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//creditosdetalladosBeanSwingJInternalFrame.jTtoolBarCreditosDetallados.setBorder(borderResaltar);
		
		this.resaltarnombre_completoCreditosDetallados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_completoCreditosDetallados() {
		return this.resaltarnombre_completoCreditosDetallados;
	}

	public void setResaltarnombre_completoCreditosDetallados(Border borderResaltar) {
		this.resaltarnombre_completoCreditosDetallados= borderResaltar;
	}

	public Boolean getMostrarnombre_completoCreditosDetallados() {
		return this.mostrarnombre_completoCreditosDetallados;
	}

	public void setMostrarnombre_completoCreditosDetallados(Boolean mostrarnombre_completoCreditosDetallados) {
		this.mostrarnombre_completoCreditosDetallados= mostrarnombre_completoCreditosDetallados;
	}

	public Boolean getActivarnombre_completoCreditosDetallados() {
		return this.activarnombre_completoCreditosDetallados;
	}

	public void setActivarnombre_completoCreditosDetallados(Boolean activarnombre_completoCreditosDetallados) {
		this.activarnombre_completoCreditosDetallados= activarnombre_completoCreditosDetallados;
	}

	public Border setResaltarcodigo_tipo_prestamoCreditosDetallados(ParametroGeneralUsuario parametroGeneralUsuario/*CreditosDetalladosBeanSwingJInternalFrame creditosdetalladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//creditosdetalladosBeanSwingJInternalFrame.jTtoolBarCreditosDetallados.setBorder(borderResaltar);
		
		this.resaltarcodigo_tipo_prestamoCreditosDetallados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_tipo_prestamoCreditosDetallados() {
		return this.resaltarcodigo_tipo_prestamoCreditosDetallados;
	}

	public void setResaltarcodigo_tipo_prestamoCreditosDetallados(Border borderResaltar) {
		this.resaltarcodigo_tipo_prestamoCreditosDetallados= borderResaltar;
	}

	public Boolean getMostrarcodigo_tipo_prestamoCreditosDetallados() {
		return this.mostrarcodigo_tipo_prestamoCreditosDetallados;
	}

	public void setMostrarcodigo_tipo_prestamoCreditosDetallados(Boolean mostrarcodigo_tipo_prestamoCreditosDetallados) {
		this.mostrarcodigo_tipo_prestamoCreditosDetallados= mostrarcodigo_tipo_prestamoCreditosDetallados;
	}

	public Boolean getActivarcodigo_tipo_prestamoCreditosDetallados() {
		return this.activarcodigo_tipo_prestamoCreditosDetallados;
	}

	public void setActivarcodigo_tipo_prestamoCreditosDetallados(Boolean activarcodigo_tipo_prestamoCreditosDetallados) {
		this.activarcodigo_tipo_prestamoCreditosDetallados= activarcodigo_tipo_prestamoCreditosDetallados;
	}

	public Border setResaltarcodigo_prestamoCreditosDetallados(ParametroGeneralUsuario parametroGeneralUsuario/*CreditosDetalladosBeanSwingJInternalFrame creditosdetalladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//creditosdetalladosBeanSwingJInternalFrame.jTtoolBarCreditosDetallados.setBorder(borderResaltar);
		
		this.resaltarcodigo_prestamoCreditosDetallados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_prestamoCreditosDetallados() {
		return this.resaltarcodigo_prestamoCreditosDetallados;
	}

	public void setResaltarcodigo_prestamoCreditosDetallados(Border borderResaltar) {
		this.resaltarcodigo_prestamoCreditosDetallados= borderResaltar;
	}

	public Boolean getMostrarcodigo_prestamoCreditosDetallados() {
		return this.mostrarcodigo_prestamoCreditosDetallados;
	}

	public void setMostrarcodigo_prestamoCreditosDetallados(Boolean mostrarcodigo_prestamoCreditosDetallados) {
		this.mostrarcodigo_prestamoCreditosDetallados= mostrarcodigo_prestamoCreditosDetallados;
	}

	public Boolean getActivarcodigo_prestamoCreditosDetallados() {
		return this.activarcodigo_prestamoCreditosDetallados;
	}

	public void setActivarcodigo_prestamoCreditosDetallados(Boolean activarcodigo_prestamoCreditosDetallados) {
		this.activarcodigo_prestamoCreditosDetallados= activarcodigo_prestamoCreditosDetallados;
	}

	public Border setResaltarfechaCreditosDetallados(ParametroGeneralUsuario parametroGeneralUsuario/*CreditosDetalladosBeanSwingJInternalFrame creditosdetalladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//creditosdetalladosBeanSwingJInternalFrame.jTtoolBarCreditosDetallados.setBorder(borderResaltar);
		
		this.resaltarfechaCreditosDetallados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaCreditosDetallados() {
		return this.resaltarfechaCreditosDetallados;
	}

	public void setResaltarfechaCreditosDetallados(Border borderResaltar) {
		this.resaltarfechaCreditosDetallados= borderResaltar;
	}

	public Boolean getMostrarfechaCreditosDetallados() {
		return this.mostrarfechaCreditosDetallados;
	}

	public void setMostrarfechaCreditosDetallados(Boolean mostrarfechaCreditosDetallados) {
		this.mostrarfechaCreditosDetallados= mostrarfechaCreditosDetallados;
	}

	public Boolean getActivarfechaCreditosDetallados() {
		return this.activarfechaCreditosDetallados;
	}

	public void setActivarfechaCreditosDetallados(Boolean activarfechaCreditosDetallados) {
		this.activarfechaCreditosDetallados= activarfechaCreditosDetallados;
	}

	public Border setResaltarmontoCreditosDetallados(ParametroGeneralUsuario parametroGeneralUsuario/*CreditosDetalladosBeanSwingJInternalFrame creditosdetalladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//creditosdetalladosBeanSwingJInternalFrame.jTtoolBarCreditosDetallados.setBorder(borderResaltar);
		
		this.resaltarmontoCreditosDetallados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmontoCreditosDetallados() {
		return this.resaltarmontoCreditosDetallados;
	}

	public void setResaltarmontoCreditosDetallados(Border borderResaltar) {
		this.resaltarmontoCreditosDetallados= borderResaltar;
	}

	public Boolean getMostrarmontoCreditosDetallados() {
		return this.mostrarmontoCreditosDetallados;
	}

	public void setMostrarmontoCreditosDetallados(Boolean mostrarmontoCreditosDetallados) {
		this.mostrarmontoCreditosDetallados= mostrarmontoCreditosDetallados;
	}

	public Boolean getActivarmontoCreditosDetallados() {
		return this.activarmontoCreditosDetallados;
	}

	public void setActivarmontoCreditosDetallados(Boolean activarmontoCreditosDetallados) {
		this.activarmontoCreditosDetallados= activarmontoCreditosDetallados;
	}

	public Border setResaltarnumero_cuotasCreditosDetallados(ParametroGeneralUsuario parametroGeneralUsuario/*CreditosDetalladosBeanSwingJInternalFrame creditosdetalladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//creditosdetalladosBeanSwingJInternalFrame.jTtoolBarCreditosDetallados.setBorder(borderResaltar);
		
		this.resaltarnumero_cuotasCreditosDetallados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_cuotasCreditosDetallados() {
		return this.resaltarnumero_cuotasCreditosDetallados;
	}

	public void setResaltarnumero_cuotasCreditosDetallados(Border borderResaltar) {
		this.resaltarnumero_cuotasCreditosDetallados= borderResaltar;
	}

	public Boolean getMostrarnumero_cuotasCreditosDetallados() {
		return this.mostrarnumero_cuotasCreditosDetallados;
	}

	public void setMostrarnumero_cuotasCreditosDetallados(Boolean mostrarnumero_cuotasCreditosDetallados) {
		this.mostrarnumero_cuotasCreditosDetallados= mostrarnumero_cuotasCreditosDetallados;
	}

	public Boolean getActivarnumero_cuotasCreditosDetallados() {
		return this.activarnumero_cuotasCreditosDetallados;
	}

	public void setActivarnumero_cuotasCreditosDetallados(Boolean activarnumero_cuotasCreditosDetallados) {
		this.activarnumero_cuotasCreditosDetallados= activarnumero_cuotasCreditosDetallados;
	}

	public Border setResaltarnumeroCreditosDetallados(ParametroGeneralUsuario parametroGeneralUsuario/*CreditosDetalladosBeanSwingJInternalFrame creditosdetalladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//creditosdetalladosBeanSwingJInternalFrame.jTtoolBarCreditosDetallados.setBorder(borderResaltar);
		
		this.resaltarnumeroCreditosDetallados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumeroCreditosDetallados() {
		return this.resaltarnumeroCreditosDetallados;
	}

	public void setResaltarnumeroCreditosDetallados(Border borderResaltar) {
		this.resaltarnumeroCreditosDetallados= borderResaltar;
	}

	public Boolean getMostrarnumeroCreditosDetallados() {
		return this.mostrarnumeroCreditosDetallados;
	}

	public void setMostrarnumeroCreditosDetallados(Boolean mostrarnumeroCreditosDetallados) {
		this.mostrarnumeroCreditosDetallados= mostrarnumeroCreditosDetallados;
	}

	public Boolean getActivarnumeroCreditosDetallados() {
		return this.activarnumeroCreditosDetallados;
	}

	public void setActivarnumeroCreditosDetallados(Boolean activarnumeroCreditosDetallados) {
		this.activarnumeroCreditosDetallados= activarnumeroCreditosDetallados;
	}

	public Border setResaltarmonto_capitalCreditosDetallados(ParametroGeneralUsuario parametroGeneralUsuario/*CreditosDetalladosBeanSwingJInternalFrame creditosdetalladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//creditosdetalladosBeanSwingJInternalFrame.jTtoolBarCreditosDetallados.setBorder(borderResaltar);
		
		this.resaltarmonto_capitalCreditosDetallados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmonto_capitalCreditosDetallados() {
		return this.resaltarmonto_capitalCreditosDetallados;
	}

	public void setResaltarmonto_capitalCreditosDetallados(Border borderResaltar) {
		this.resaltarmonto_capitalCreditosDetallados= borderResaltar;
	}

	public Boolean getMostrarmonto_capitalCreditosDetallados() {
		return this.mostrarmonto_capitalCreditosDetallados;
	}

	public void setMostrarmonto_capitalCreditosDetallados(Boolean mostrarmonto_capitalCreditosDetallados) {
		this.mostrarmonto_capitalCreditosDetallados= mostrarmonto_capitalCreditosDetallados;
	}

	public Boolean getActivarmonto_capitalCreditosDetallados() {
		return this.activarmonto_capitalCreditosDetallados;
	}

	public void setActivarmonto_capitalCreditosDetallados(Boolean activarmonto_capitalCreditosDetallados) {
		this.activarmonto_capitalCreditosDetallados= activarmonto_capitalCreditosDetallados;
	}

	public Border setResaltarmonto_interesCreditosDetallados(ParametroGeneralUsuario parametroGeneralUsuario/*CreditosDetalladosBeanSwingJInternalFrame creditosdetalladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//creditosdetalladosBeanSwingJInternalFrame.jTtoolBarCreditosDetallados.setBorder(borderResaltar);
		
		this.resaltarmonto_interesCreditosDetallados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmonto_interesCreditosDetallados() {
		return this.resaltarmonto_interesCreditosDetallados;
	}

	public void setResaltarmonto_interesCreditosDetallados(Border borderResaltar) {
		this.resaltarmonto_interesCreditosDetallados= borderResaltar;
	}

	public Boolean getMostrarmonto_interesCreditosDetallados() {
		return this.mostrarmonto_interesCreditosDetallados;
	}

	public void setMostrarmonto_interesCreditosDetallados(Boolean mostrarmonto_interesCreditosDetallados) {
		this.mostrarmonto_interesCreditosDetallados= mostrarmonto_interesCreditosDetallados;
	}

	public Boolean getActivarmonto_interesCreditosDetallados() {
		return this.activarmonto_interesCreditosDetallados;
	}

	public void setActivarmonto_interesCreditosDetallados(Boolean activarmonto_interesCreditosDetallados) {
		this.activarmonto_interesCreditosDetallados= activarmonto_interesCreditosDetallados;
	}

	public Border setResaltarvalorCreditosDetallados(ParametroGeneralUsuario parametroGeneralUsuario/*CreditosDetalladosBeanSwingJInternalFrame creditosdetalladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//creditosdetalladosBeanSwingJInternalFrame.jTtoolBarCreditosDetallados.setBorder(borderResaltar);
		
		this.resaltarvalorCreditosDetallados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorCreditosDetallados() {
		return this.resaltarvalorCreditosDetallados;
	}

	public void setResaltarvalorCreditosDetallados(Border borderResaltar) {
		this.resaltarvalorCreditosDetallados= borderResaltar;
	}

	public Boolean getMostrarvalorCreditosDetallados() {
		return this.mostrarvalorCreditosDetallados;
	}

	public void setMostrarvalorCreditosDetallados(Boolean mostrarvalorCreditosDetallados) {
		this.mostrarvalorCreditosDetallados= mostrarvalorCreditosDetallados;
	}

	public Boolean getActivarvalorCreditosDetallados() {
		return this.activarvalorCreditosDetallados;
	}

	public void setActivarvalorCreditosDetallados(Boolean activarvalorCreditosDetallados) {
		this.activarvalorCreditosDetallados= activarvalorCreditosDetallados;
	}

	public Border setResaltarsaldoCreditosDetallados(ParametroGeneralUsuario parametroGeneralUsuario/*CreditosDetalladosBeanSwingJInternalFrame creditosdetalladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//creditosdetalladosBeanSwingJInternalFrame.jTtoolBarCreditosDetallados.setBorder(borderResaltar);
		
		this.resaltarsaldoCreditosDetallados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsaldoCreditosDetallados() {
		return this.resaltarsaldoCreditosDetallados;
	}

	public void setResaltarsaldoCreditosDetallados(Border borderResaltar) {
		this.resaltarsaldoCreditosDetallados= borderResaltar;
	}

	public Boolean getMostrarsaldoCreditosDetallados() {
		return this.mostrarsaldoCreditosDetallados;
	}

	public void setMostrarsaldoCreditosDetallados(Boolean mostrarsaldoCreditosDetallados) {
		this.mostrarsaldoCreditosDetallados= mostrarsaldoCreditosDetallados;
	}

	public Boolean getActivarsaldoCreditosDetallados() {
		return this.activarsaldoCreditosDetallados;
	}

	public void setActivarsaldoCreditosDetallados(Boolean activarsaldoCreditosDetallados) {
		this.activarsaldoCreditosDetallados= activarsaldoCreditosDetallados;
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
		
		
		this.setMostraridCreditosDetallados(esInicial);
		this.setMostrarid_cargoCreditosDetallados(esInicial);
		this.setMostrarid_estructuraCreditosDetallados(esInicial);
		this.setMostrarid_empresaCreditosDetallados(esInicial);
		this.setMostrarid_empleadoCreditosDetallados(esInicial);
		this.setMostrarid_tipo_prestamoCreditosDetallados(esInicial);
		this.setMostrarfecha_vencimiento_desdeCreditosDetallados(esInicial);
		this.setMostrarfecha_vencimiento_hastaCreditosDetallados(esInicial);
		this.setMostrarcodigoCreditosDetallados(esInicial);
		this.setMostrarnombre_completoCreditosDetallados(esInicial);
		this.setMostrarcodigo_tipo_prestamoCreditosDetallados(esInicial);
		this.setMostrarcodigo_prestamoCreditosDetallados(esInicial);
		this.setMostrarfechaCreditosDetallados(esInicial);
		this.setMostrarmontoCreditosDetallados(esInicial);
		this.setMostrarnumero_cuotasCreditosDetallados(esInicial);
		this.setMostrarnumeroCreditosDetallados(esInicial);
		this.setMostrarmonto_capitalCreditosDetallados(esInicial);
		this.setMostrarmonto_interesCreditosDetallados(esInicial);
		this.setMostrarvalorCreditosDetallados(esInicial);
		this.setMostrarsaldoCreditosDetallados(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CreditosDetalladosConstantesFunciones.ID)) {
				this.setMostraridCreditosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosDetalladosConstantesFunciones.IDCARGO)) {
				this.setMostrarid_cargoCreditosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosDetalladosConstantesFunciones.IDESTRUCTURA)) {
				this.setMostrarid_estructuraCreditosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosDetalladosConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaCreditosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosDetalladosConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoCreditosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosDetalladosConstantesFunciones.IDTIPOPRESTAMO)) {
				this.setMostrarid_tipo_prestamoCreditosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosDetalladosConstantesFunciones.FECHAVENCIMIENTODESDE)) {
				this.setMostrarfecha_vencimiento_desdeCreditosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosDetalladosConstantesFunciones.FECHAVENCIMIENTOHASTA)) {
				this.setMostrarfecha_vencimiento_hastaCreditosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosDetalladosConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoCreditosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosDetalladosConstantesFunciones.NOMBRECOMPLETO)) {
				this.setMostrarnombre_completoCreditosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosDetalladosConstantesFunciones.CODIGOTIPOPRESTAMO)) {
				this.setMostrarcodigo_tipo_prestamoCreditosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosDetalladosConstantesFunciones.CODIGOPRESTAMO)) {
				this.setMostrarcodigo_prestamoCreditosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosDetalladosConstantesFunciones.FECHA)) {
				this.setMostrarfechaCreditosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosDetalladosConstantesFunciones.MONTO)) {
				this.setMostrarmontoCreditosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosDetalladosConstantesFunciones.NUMEROCUOTAS)) {
				this.setMostrarnumero_cuotasCreditosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosDetalladosConstantesFunciones.NUMERO)) {
				this.setMostrarnumeroCreditosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosDetalladosConstantesFunciones.MONTOCAPITAL)) {
				this.setMostrarmonto_capitalCreditosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosDetalladosConstantesFunciones.MONTOINTERES)) {
				this.setMostrarmonto_interesCreditosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosDetalladosConstantesFunciones.VALOR)) {
				this.setMostrarvalorCreditosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosDetalladosConstantesFunciones.SALDO)) {
				this.setMostrarsaldoCreditosDetallados(esAsigna);
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
		
		
		this.setActivaridCreditosDetallados(esInicial);
		this.setActivarid_cargoCreditosDetallados(esInicial);
		this.setActivarid_estructuraCreditosDetallados(esInicial);
		this.setActivarid_empresaCreditosDetallados(esInicial);
		this.setActivarid_empleadoCreditosDetallados(esInicial);
		this.setActivarid_tipo_prestamoCreditosDetallados(esInicial);
		this.setActivarfecha_vencimiento_desdeCreditosDetallados(esInicial);
		this.setActivarfecha_vencimiento_hastaCreditosDetallados(esInicial);
		this.setActivarcodigoCreditosDetallados(esInicial);
		this.setActivarnombre_completoCreditosDetallados(esInicial);
		this.setActivarcodigo_tipo_prestamoCreditosDetallados(esInicial);
		this.setActivarcodigo_prestamoCreditosDetallados(esInicial);
		this.setActivarfechaCreditosDetallados(esInicial);
		this.setActivarmontoCreditosDetallados(esInicial);
		this.setActivarnumero_cuotasCreditosDetallados(esInicial);
		this.setActivarnumeroCreditosDetallados(esInicial);
		this.setActivarmonto_capitalCreditosDetallados(esInicial);
		this.setActivarmonto_interesCreditosDetallados(esInicial);
		this.setActivarvalorCreditosDetallados(esInicial);
		this.setActivarsaldoCreditosDetallados(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CreditosDetalladosConstantesFunciones.ID)) {
				this.setActivaridCreditosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosDetalladosConstantesFunciones.IDCARGO)) {
				this.setActivarid_cargoCreditosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosDetalladosConstantesFunciones.IDESTRUCTURA)) {
				this.setActivarid_estructuraCreditosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosDetalladosConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaCreditosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosDetalladosConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoCreditosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosDetalladosConstantesFunciones.IDTIPOPRESTAMO)) {
				this.setActivarid_tipo_prestamoCreditosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosDetalladosConstantesFunciones.FECHAVENCIMIENTODESDE)) {
				this.setActivarfecha_vencimiento_desdeCreditosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosDetalladosConstantesFunciones.FECHAVENCIMIENTOHASTA)) {
				this.setActivarfecha_vencimiento_hastaCreditosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosDetalladosConstantesFunciones.CODIGO)) {
				this.setActivarcodigoCreditosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosDetalladosConstantesFunciones.NOMBRECOMPLETO)) {
				this.setActivarnombre_completoCreditosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosDetalladosConstantesFunciones.CODIGOTIPOPRESTAMO)) {
				this.setActivarcodigo_tipo_prestamoCreditosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosDetalladosConstantesFunciones.CODIGOPRESTAMO)) {
				this.setActivarcodigo_prestamoCreditosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosDetalladosConstantesFunciones.FECHA)) {
				this.setActivarfechaCreditosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosDetalladosConstantesFunciones.MONTO)) {
				this.setActivarmontoCreditosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosDetalladosConstantesFunciones.NUMEROCUOTAS)) {
				this.setActivarnumero_cuotasCreditosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosDetalladosConstantesFunciones.NUMERO)) {
				this.setActivarnumeroCreditosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosDetalladosConstantesFunciones.MONTOCAPITAL)) {
				this.setActivarmonto_capitalCreditosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosDetalladosConstantesFunciones.MONTOINTERES)) {
				this.setActivarmonto_interesCreditosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosDetalladosConstantesFunciones.VALOR)) {
				this.setActivarvalorCreditosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosDetalladosConstantesFunciones.SALDO)) {
				this.setActivarsaldoCreditosDetallados(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,CreditosDetalladosBeanSwingJInternalFrame creditosdetalladosBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridCreditosDetallados(esInicial);
		this.setResaltarid_cargoCreditosDetallados(esInicial);
		this.setResaltarid_estructuraCreditosDetallados(esInicial);
		this.setResaltarid_empresaCreditosDetallados(esInicial);
		this.setResaltarid_empleadoCreditosDetallados(esInicial);
		this.setResaltarid_tipo_prestamoCreditosDetallados(esInicial);
		this.setResaltarfecha_vencimiento_desdeCreditosDetallados(esInicial);
		this.setResaltarfecha_vencimiento_hastaCreditosDetallados(esInicial);
		this.setResaltarcodigoCreditosDetallados(esInicial);
		this.setResaltarnombre_completoCreditosDetallados(esInicial);
		this.setResaltarcodigo_tipo_prestamoCreditosDetallados(esInicial);
		this.setResaltarcodigo_prestamoCreditosDetallados(esInicial);
		this.setResaltarfechaCreditosDetallados(esInicial);
		this.setResaltarmontoCreditosDetallados(esInicial);
		this.setResaltarnumero_cuotasCreditosDetallados(esInicial);
		this.setResaltarnumeroCreditosDetallados(esInicial);
		this.setResaltarmonto_capitalCreditosDetallados(esInicial);
		this.setResaltarmonto_interesCreditosDetallados(esInicial);
		this.setResaltarvalorCreditosDetallados(esInicial);
		this.setResaltarsaldoCreditosDetallados(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CreditosDetalladosConstantesFunciones.ID)) {
				this.setResaltaridCreditosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosDetalladosConstantesFunciones.IDCARGO)) {
				this.setResaltarid_cargoCreditosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosDetalladosConstantesFunciones.IDESTRUCTURA)) {
				this.setResaltarid_estructuraCreditosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosDetalladosConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaCreditosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosDetalladosConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoCreditosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosDetalladosConstantesFunciones.IDTIPOPRESTAMO)) {
				this.setResaltarid_tipo_prestamoCreditosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosDetalladosConstantesFunciones.FECHAVENCIMIENTODESDE)) {
				this.setResaltarfecha_vencimiento_desdeCreditosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosDetalladosConstantesFunciones.FECHAVENCIMIENTOHASTA)) {
				this.setResaltarfecha_vencimiento_hastaCreditosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosDetalladosConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoCreditosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosDetalladosConstantesFunciones.NOMBRECOMPLETO)) {
				this.setResaltarnombre_completoCreditosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosDetalladosConstantesFunciones.CODIGOTIPOPRESTAMO)) {
				this.setResaltarcodigo_tipo_prestamoCreditosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosDetalladosConstantesFunciones.CODIGOPRESTAMO)) {
				this.setResaltarcodigo_prestamoCreditosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosDetalladosConstantesFunciones.FECHA)) {
				this.setResaltarfechaCreditosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosDetalladosConstantesFunciones.MONTO)) {
				this.setResaltarmontoCreditosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosDetalladosConstantesFunciones.NUMEROCUOTAS)) {
				this.setResaltarnumero_cuotasCreditosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosDetalladosConstantesFunciones.NUMERO)) {
				this.setResaltarnumeroCreditosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosDetalladosConstantesFunciones.MONTOCAPITAL)) {
				this.setResaltarmonto_capitalCreditosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosDetalladosConstantesFunciones.MONTOINTERES)) {
				this.setResaltarmonto_interesCreditosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosDetalladosConstantesFunciones.VALOR)) {
				this.setResaltarvalorCreditosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CreditosDetalladosConstantesFunciones.SALDO)) {
				this.setResaltarsaldoCreditosDetallados(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,CreditosDetalladosBeanSwingJInternalFrame creditosdetalladosBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaCreditosDetalladosCreditosDetallados=true;

	public Boolean getMostrarBusquedaCreditosDetalladosCreditosDetallados() {
		return this.mostrarBusquedaCreditosDetalladosCreditosDetallados;
	}

	public void setMostrarBusquedaCreditosDetalladosCreditosDetallados(Boolean visibilidadResaltar) {
		this.mostrarBusquedaCreditosDetalladosCreditosDetallados= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaCreditosDetalladosCreditosDetallados=true;

	public Boolean getActivarBusquedaCreditosDetalladosCreditosDetallados() {
		return this.activarBusquedaCreditosDetalladosCreditosDetallados;
	}

	public void setActivarBusquedaCreditosDetalladosCreditosDetallados(Boolean habilitarResaltar) {
		this.activarBusquedaCreditosDetalladosCreditosDetallados= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaCreditosDetalladosCreditosDetallados=null;

	public Border getResaltarBusquedaCreditosDetalladosCreditosDetallados() {
		return this.resaltarBusquedaCreditosDetalladosCreditosDetallados;
	}

	public void setResaltarBusquedaCreditosDetalladosCreditosDetallados(Border borderResaltar) {
		this.resaltarBusquedaCreditosDetalladosCreditosDetallados= borderResaltar;
	}

	public void setResaltarBusquedaCreditosDetalladosCreditosDetallados(ParametroGeneralUsuario parametroGeneralUsuario/*CreditosDetalladosBeanSwingJInternalFrame creditosdetalladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaCreditosDetalladosCreditosDetallados= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}