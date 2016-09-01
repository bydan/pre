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
package com.bydan.erp.contabilidad.util.report;

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


import com.bydan.erp.contabilidad.util.report.ComprobantesAnuladosConstantesFunciones;
import com.bydan.erp.contabilidad.util.report.ComprobantesAnuladosParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.report.ComprobantesAnuladosParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ComprobantesAnuladosConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="ComprobantesAnulados";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ComprobantesAnulados"+ComprobantesAnuladosConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ComprobantesAnuladosHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ComprobantesAnuladosHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ComprobantesAnuladosConstantesFunciones.SCHEMA+"_"+ComprobantesAnuladosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ComprobantesAnuladosHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ComprobantesAnuladosConstantesFunciones.SCHEMA+"_"+ComprobantesAnuladosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ComprobantesAnuladosConstantesFunciones.SCHEMA+"_"+ComprobantesAnuladosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ComprobantesAnuladosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ComprobantesAnuladosConstantesFunciones.SCHEMA+"_"+ComprobantesAnuladosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ComprobantesAnuladosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ComprobantesAnuladosHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ComprobantesAnuladosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ComprobantesAnuladosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ComprobantesAnuladosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ComprobantesAnuladosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ComprobantesAnuladosConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ComprobantesAnuladosConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ComprobantesAnuladosConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ComprobantesAnuladosConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Comprobantes Anuladoses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Comprobantes Anulados";
	public static final String SCLASSWEBTITULO_LOWER="Comprobantes Anulados";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ComprobantesAnulados";
	public static final String OBJECTNAME="comprobantesanulados";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="comprobantes_anulados";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select comprobantesanulados from "+ComprobantesAnuladosConstantesFunciones.SPERSISTENCENAME+" comprobantesanulados";
	public static String QUERYSELECTNATIVE="select "+ComprobantesAnuladosConstantesFunciones.SCHEMA+"."+ComprobantesAnuladosConstantesFunciones.TABLENAME+".id,"+ComprobantesAnuladosConstantesFunciones.SCHEMA+"."+ComprobantesAnuladosConstantesFunciones.TABLENAME+".version_row,"+ComprobantesAnuladosConstantesFunciones.SCHEMA+"."+ComprobantesAnuladosConstantesFunciones.TABLENAME+".id_empresa,"+ComprobantesAnuladosConstantesFunciones.SCHEMA+"."+ComprobantesAnuladosConstantesFunciones.TABLENAME+".id_sucursal,"+ComprobantesAnuladosConstantesFunciones.SCHEMA+"."+ComprobantesAnuladosConstantesFunciones.TABLENAME+".id_ejercicio,"+ComprobantesAnuladosConstantesFunciones.SCHEMA+"."+ComprobantesAnuladosConstantesFunciones.TABLENAME+".id_tipo_documento,"+ComprobantesAnuladosConstantesFunciones.SCHEMA+"."+ComprobantesAnuladosConstantesFunciones.TABLENAME+".id_tipo_movimiento,"+ComprobantesAnuladosConstantesFunciones.SCHEMA+"."+ComprobantesAnuladosConstantesFunciones.TABLENAME+".numero_mayor,"+ComprobantesAnuladosConstantesFunciones.SCHEMA+"."+ComprobantesAnuladosConstantesFunciones.TABLENAME+".fecha_emision_desde,"+ComprobantesAnuladosConstantesFunciones.SCHEMA+"."+ComprobantesAnuladosConstantesFunciones.TABLENAME+".fecha_emision_hasta,"+ComprobantesAnuladosConstantesFunciones.SCHEMA+"."+ComprobantesAnuladosConstantesFunciones.TABLENAME+".user_name_usuario,"+ComprobantesAnuladosConstantesFunciones.SCHEMA+"."+ComprobantesAnuladosConstantesFunciones.TABLENAME+".nombre_modulo,"+ComprobantesAnuladosConstantesFunciones.SCHEMA+"."+ComprobantesAnuladosConstantesFunciones.TABLENAME+".codigo,"+ComprobantesAnuladosConstantesFunciones.SCHEMA+"."+ComprobantesAnuladosConstantesFunciones.TABLENAME+".beneficiario,"+ComprobantesAnuladosConstantesFunciones.SCHEMA+"."+ComprobantesAnuladosConstantesFunciones.TABLENAME+".detalle,"+ComprobantesAnuladosConstantesFunciones.SCHEMA+"."+ComprobantesAnuladosConstantesFunciones.TABLENAME+".fecha_emision,"+ComprobantesAnuladosConstantesFunciones.SCHEMA+"."+ComprobantesAnuladosConstantesFunciones.TABLENAME+".codigo_tipo_movimiento,"+ComprobantesAnuladosConstantesFunciones.SCHEMA+"."+ComprobantesAnuladosConstantesFunciones.TABLENAME+".numero_mayor_dato,"+ComprobantesAnuladosConstantesFunciones.SCHEMA+"."+ComprobantesAnuladosConstantesFunciones.TABLENAME+".nombre_cuenta_contable,"+ComprobantesAnuladosConstantesFunciones.SCHEMA+"."+ComprobantesAnuladosConstantesFunciones.TABLENAME+".debito_local,"+ComprobantesAnuladosConstantesFunciones.SCHEMA+"."+ComprobantesAnuladosConstantesFunciones.TABLENAME+".credito_local,"+ComprobantesAnuladosConstantesFunciones.SCHEMA+"."+ComprobantesAnuladosConstantesFunciones.TABLENAME+".codigo_cuenta_contable from "+ComprobantesAnuladosConstantesFunciones.SCHEMA+"."+ComprobantesAnuladosConstantesFunciones.TABLENAME;//+" as "+ComprobantesAnuladosConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDTIPODOCUMENTO= "id_tipo_documento";
    public static final String IDTIPOMOVIMIENTO= "id_tipo_movimiento";
    public static final String NUMEROMAYOR= "numero_mayor";
    public static final String FECHAEMISIONDESDE= "fecha_emision_desde";
    public static final String FECHAEMISIONHASTA= "fecha_emision_hasta";
    public static final String USERNAMEUSUARIO= "user_name_usuario";
    public static final String NOMBREMODULO= "nombre_modulo";
    public static final String CODIGO= "codigo";
    public static final String BENEFICIARIO= "beneficiario";
    public static final String DETALLE= "detalle";
    public static final String FECHAEMISION= "fecha_emision";
    public static final String CODIGOTIPOMOVIMIENTO= "codigo_tipo_movimiento";
    public static final String NUMEROMAYORDATO= "numero_mayor_dato";
    public static final String NOMBRECUENTACONTABLE= "nombre_cuenta_contable";
    public static final String DEBITOLOCAL= "debito_local";
    public static final String CREDITOLOCAL= "credito_local";
    public static final String CODIGOCUENTACONTABLE= "codigo_cuenta_contable";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_IDTIPODOCUMENTO= "Tipo Documento";
		public static final String LABEL_IDTIPODOCUMENTO_LOWER= "Tipo Documento";
    	public static final String LABEL_IDTIPOMOVIMIENTO= "Tipo Movimiento";
		public static final String LABEL_IDTIPOMOVIMIENTO_LOWER= "Tipo Movimiento";
    	public static final String LABEL_NUMEROMAYOR= "Numero Mayor";
		public static final String LABEL_NUMEROMAYOR_LOWER= "Numero Mayor";
    	public static final String LABEL_FECHAEMISIONDESDE= "Fecha Emision Desde";
		public static final String LABEL_FECHAEMISIONDESDE_LOWER= "Fecha Emision Desde";
    	public static final String LABEL_FECHAEMISIONHASTA= "Fecha Emision Hasta";
		public static final String LABEL_FECHAEMISIONHASTA_LOWER= "Fecha Emision Hasta";
    	public static final String LABEL_USERNAMEUSUARIO= "User Name Usuario";
		public static final String LABEL_USERNAMEUSUARIO_LOWER= "User Name Usuario";
    	public static final String LABEL_NOMBREMODULO= "Nombre Modulo";
		public static final String LABEL_NOMBREMODULO_LOWER= "Nombre Modulo";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_BENEFICIARIO= "Beneficiario";
		public static final String LABEL_BENEFICIARIO_LOWER= "Beneficiario";
    	public static final String LABEL_DETALLE= "Detalle";
		public static final String LABEL_DETALLE_LOWER= "Detalle";
    	public static final String LABEL_FECHAEMISION= "Fecha Emision";
		public static final String LABEL_FECHAEMISION_LOWER= "Fecha Emision";
    	public static final String LABEL_CODIGOTIPOMOVIMIENTO= "Codigo Tipo Movimiento";
		public static final String LABEL_CODIGOTIPOMOVIMIENTO_LOWER= "Codigo Tipo Movimiento";
    	public static final String LABEL_NUMEROMAYORDATO= "Numero Mayor Dato";
		public static final String LABEL_NUMEROMAYORDATO_LOWER= "Numero Mayor Dato";
    	public static final String LABEL_NOMBRECUENTACONTABLE= "Nombre Cuenta Contable";
		public static final String LABEL_NOMBRECUENTACONTABLE_LOWER= "Nombre Cuenta Contable";
    	public static final String LABEL_DEBITOLOCAL= "Debito Local";
		public static final String LABEL_DEBITOLOCAL_LOWER= "Debito Local";
    	public static final String LABEL_CREDITOLOCAL= "Credito Local";
		public static final String LABEL_CREDITOLOCAL_LOWER= "Credito Local";
    	public static final String LABEL_CODIGOCUENTACONTABLE= "Codigo Cuenta Contable";
		public static final String LABEL_CODIGOCUENTACONTABLE_LOWER= "Codigo Cuenta Contable";
	
		
		
		
		
		
		
		
	public static final String SREGEXNUMERO_MAYOR=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_MAYOR=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXUSER_NAME_USUARIO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXUSER_NAME_USUARIO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_MODULO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_MODULO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXBENEFICIARIO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXBENEFICIARIO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDETALLE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDETALLE=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXCODIGO_TIPO_MOVIMIENTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_TIPO_MOVIMIENTO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_MAYOR_DATO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_MAYOR_DATO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_CUENTA_CONTABLE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_CUENTA_CONTABLE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXCODIGO_CUENTA_CONTABLE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_CUENTA_CONTABLE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getComprobantesAnuladosLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ComprobantesAnuladosConstantesFunciones.IDEMPRESA)) {sLabelColumna=ComprobantesAnuladosConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ComprobantesAnuladosConstantesFunciones.IDSUCURSAL)) {sLabelColumna=ComprobantesAnuladosConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(ComprobantesAnuladosConstantesFunciones.IDEJERCICIO)) {sLabelColumna=ComprobantesAnuladosConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(ComprobantesAnuladosConstantesFunciones.IDTIPODOCUMENTO)) {sLabelColumna=ComprobantesAnuladosConstantesFunciones.LABEL_IDTIPODOCUMENTO;}
		if(sNombreColumna.equals(ComprobantesAnuladosConstantesFunciones.IDTIPOMOVIMIENTO)) {sLabelColumna=ComprobantesAnuladosConstantesFunciones.LABEL_IDTIPOMOVIMIENTO;}
		if(sNombreColumna.equals(ComprobantesAnuladosConstantesFunciones.NUMEROMAYOR)) {sLabelColumna=ComprobantesAnuladosConstantesFunciones.LABEL_NUMEROMAYOR;}
		if(sNombreColumna.equals(ComprobantesAnuladosConstantesFunciones.FECHAEMISIONDESDE)) {sLabelColumna=ComprobantesAnuladosConstantesFunciones.LABEL_FECHAEMISIONDESDE;}
		if(sNombreColumna.equals(ComprobantesAnuladosConstantesFunciones.FECHAEMISIONHASTA)) {sLabelColumna=ComprobantesAnuladosConstantesFunciones.LABEL_FECHAEMISIONHASTA;}
		if(sNombreColumna.equals(ComprobantesAnuladosConstantesFunciones.USERNAMEUSUARIO)) {sLabelColumna=ComprobantesAnuladosConstantesFunciones.LABEL_USERNAMEUSUARIO;}
		if(sNombreColumna.equals(ComprobantesAnuladosConstantesFunciones.NOMBREMODULO)) {sLabelColumna=ComprobantesAnuladosConstantesFunciones.LABEL_NOMBREMODULO;}
		if(sNombreColumna.equals(ComprobantesAnuladosConstantesFunciones.CODIGO)) {sLabelColumna=ComprobantesAnuladosConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(ComprobantesAnuladosConstantesFunciones.BENEFICIARIO)) {sLabelColumna=ComprobantesAnuladosConstantesFunciones.LABEL_BENEFICIARIO;}
		if(sNombreColumna.equals(ComprobantesAnuladosConstantesFunciones.DETALLE)) {sLabelColumna=ComprobantesAnuladosConstantesFunciones.LABEL_DETALLE;}
		if(sNombreColumna.equals(ComprobantesAnuladosConstantesFunciones.FECHAEMISION)) {sLabelColumna=ComprobantesAnuladosConstantesFunciones.LABEL_FECHAEMISION;}
		if(sNombreColumna.equals(ComprobantesAnuladosConstantesFunciones.CODIGOTIPOMOVIMIENTO)) {sLabelColumna=ComprobantesAnuladosConstantesFunciones.LABEL_CODIGOTIPOMOVIMIENTO;}
		if(sNombreColumna.equals(ComprobantesAnuladosConstantesFunciones.NUMEROMAYORDATO)) {sLabelColumna=ComprobantesAnuladosConstantesFunciones.LABEL_NUMEROMAYORDATO;}
		if(sNombreColumna.equals(ComprobantesAnuladosConstantesFunciones.NOMBRECUENTACONTABLE)) {sLabelColumna=ComprobantesAnuladosConstantesFunciones.LABEL_NOMBRECUENTACONTABLE;}
		if(sNombreColumna.equals(ComprobantesAnuladosConstantesFunciones.DEBITOLOCAL)) {sLabelColumna=ComprobantesAnuladosConstantesFunciones.LABEL_DEBITOLOCAL;}
		if(sNombreColumna.equals(ComprobantesAnuladosConstantesFunciones.CREDITOLOCAL)) {sLabelColumna=ComprobantesAnuladosConstantesFunciones.LABEL_CREDITOLOCAL;}
		if(sNombreColumna.equals(ComprobantesAnuladosConstantesFunciones.CODIGOCUENTACONTABLE)) {sLabelColumna=ComprobantesAnuladosConstantesFunciones.LABEL_CODIGOCUENTACONTABLE;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getComprobantesAnuladosDescripcion(ComprobantesAnulados comprobantesanulados) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(comprobantesanulados !=null/* && comprobantesanulados.getId()!=0*/) {
			sDescripcion=comprobantesanulados.getcodigo();//comprobantesanuladoscomprobantesanulados.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getComprobantesAnuladosDescripcionDetallado(ComprobantesAnulados comprobantesanulados) {
		String sDescripcion="";
			
		sDescripcion+=ComprobantesAnuladosConstantesFunciones.ID+"=";
		sDescripcion+=comprobantesanulados.getId().toString()+",";
		sDescripcion+=ComprobantesAnuladosConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=comprobantesanulados.getVersionRow().toString()+",";
		sDescripcion+=ComprobantesAnuladosConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=comprobantesanulados.getid_empresa().toString()+",";
		sDescripcion+=ComprobantesAnuladosConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=comprobantesanulados.getid_sucursal().toString()+",";
		sDescripcion+=ComprobantesAnuladosConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=comprobantesanulados.getid_ejercicio().toString()+",";
		sDescripcion+=ComprobantesAnuladosConstantesFunciones.IDTIPODOCUMENTO+"=";
		sDescripcion+=comprobantesanulados.getid_tipo_documento().toString()+",";
		sDescripcion+=ComprobantesAnuladosConstantesFunciones.IDTIPOMOVIMIENTO+"=";
		sDescripcion+=comprobantesanulados.getid_tipo_movimiento().toString()+",";
		sDescripcion+=ComprobantesAnuladosConstantesFunciones.NUMEROMAYOR+"=";
		sDescripcion+=comprobantesanulados.getnumero_mayor()+",";
		sDescripcion+=ComprobantesAnuladosConstantesFunciones.FECHAEMISIONDESDE+"=";
		sDescripcion+=comprobantesanulados.getfecha_emision_desde().toString()+",";
		sDescripcion+=ComprobantesAnuladosConstantesFunciones.FECHAEMISIONHASTA+"=";
		sDescripcion+=comprobantesanulados.getfecha_emision_hasta().toString()+",";
		sDescripcion+=ComprobantesAnuladosConstantesFunciones.USERNAMEUSUARIO+"=";
		sDescripcion+=comprobantesanulados.getuser_name_usuario()+",";
		sDescripcion+=ComprobantesAnuladosConstantesFunciones.NOMBREMODULO+"=";
		sDescripcion+=comprobantesanulados.getnombre_modulo()+",";
		sDescripcion+=ComprobantesAnuladosConstantesFunciones.CODIGO+"=";
		sDescripcion+=comprobantesanulados.getcodigo()+",";
		sDescripcion+=ComprobantesAnuladosConstantesFunciones.BENEFICIARIO+"=";
		sDescripcion+=comprobantesanulados.getbeneficiario()+",";
		sDescripcion+=ComprobantesAnuladosConstantesFunciones.DETALLE+"=";
		sDescripcion+=comprobantesanulados.getdetalle()+",";
		sDescripcion+=ComprobantesAnuladosConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=comprobantesanulados.getfecha_emision().toString()+",";
		sDescripcion+=ComprobantesAnuladosConstantesFunciones.CODIGOTIPOMOVIMIENTO+"=";
		sDescripcion+=comprobantesanulados.getcodigo_tipo_movimiento()+",";
		sDescripcion+=ComprobantesAnuladosConstantesFunciones.NUMEROMAYORDATO+"=";
		sDescripcion+=comprobantesanulados.getnumero_mayor_dato()+",";
		sDescripcion+=ComprobantesAnuladosConstantesFunciones.NOMBRECUENTACONTABLE+"=";
		sDescripcion+=comprobantesanulados.getnombre_cuenta_contable()+",";
		sDescripcion+=ComprobantesAnuladosConstantesFunciones.DEBITOLOCAL+"=";
		sDescripcion+=comprobantesanulados.getdebito_local().toString()+",";
		sDescripcion+=ComprobantesAnuladosConstantesFunciones.CREDITOLOCAL+"=";
		sDescripcion+=comprobantesanulados.getcredito_local().toString()+",";
		sDescripcion+=ComprobantesAnuladosConstantesFunciones.CODIGOCUENTACONTABLE+"=";
		sDescripcion+=comprobantesanulados.getcodigo_cuenta_contable()+",";
			
		return sDescripcion;
	}
	
	public static void setComprobantesAnuladosDescripcion(ComprobantesAnulados comprobantesanulados,String sValor) throws Exception {			
		if(comprobantesanulados !=null) {
			comprobantesanulados.setcodigo(sValor);;//comprobantesanuladoscomprobantesanulados.getcodigo().trim();
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

	public static String getEjercicioDescripcion(Ejercicio ejercicio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(ejercicio!=null/*&&ejercicio.getId()>0*/) {
			sDescripcion=EjercicioConstantesFunciones.getEjercicioDescripcion(ejercicio);
		}

		return sDescripcion;
	}

	public static String getTipoDocumentoDescripcion(TipoDocumento tipodocumento) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipodocumento!=null/*&&tipodocumento.getId()>0*/) {
			sDescripcion=TipoDocumentoConstantesFunciones.getTipoDocumentoDescripcion(tipodocumento);
		}

		return sDescripcion;
	}

	public static String getTipoMovimientoDescripcion(TipoMovimiento tipomovimiento) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipomovimiento!=null/*&&tipomovimiento.getId()>0*/) {
			sDescripcion=TipoMovimientoConstantesFunciones.getTipoMovimientoDescripcion(tipomovimiento);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaComprobantesAnulados")) {
			sNombreIndice="Tipo=  Por Ejercicio Por Tipo Documento Por Tipo Movimiento Por Numero Mayor Por Fecha Emision Desde Por Fecha Emision Hasta";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoDocumento")) {
			sNombreIndice="Tipo=  Por Tipo Documento";
		} else if(sNombreIndice.equals("FK_IdTipoMovimiento")) {
			sNombreIndice="Tipo=  Por Tipo Movimiento";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaComprobantesAnulados(Long id_ejercicio,Long id_tipo_documento,Long id_tipo_movimiento,String numero_mayor,Date fecha_emision_desde,Date fecha_emision_hasta) {
		String sDetalleIndice=" Parametros->";
		if(id_ejercicio!=null) {sDetalleIndice+=" Codigo Unico De Ejercicio="+id_ejercicio.toString();}
		if(id_tipo_documento!=null) {sDetalleIndice+=" Codigo Unico De Tipo Documento="+id_tipo_documento.toString();}
		if(id_tipo_movimiento!=null) {sDetalleIndice+=" Codigo Unico De Tipo Movimiento="+id_tipo_movimiento.toString();}
		if(numero_mayor!=null) {sDetalleIndice+=" Numero Mayor="+numero_mayor;}
		if(fecha_emision_desde!=null) {sDetalleIndice+=" Fecha Emision Desde="+fecha_emision_desde.toString();}
		if(fecha_emision_hasta!=null) {sDetalleIndice+=" Fecha Emision Hasta="+fecha_emision_hasta.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEjercicio(Long id_ejercicio) {
		String sDetalleIndice=" Parametros->";
		if(id_ejercicio!=null) {sDetalleIndice+=" Codigo Unico De Ejercicio="+id_ejercicio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoDocumento(Long id_tipo_documento) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_documento!=null) {sDetalleIndice+=" Codigo Unico De Tipo Documento="+id_tipo_documento.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoMovimiento(Long id_tipo_movimiento) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_movimiento!=null) {sDetalleIndice+=" Codigo Unico De Tipo Movimiento="+id_tipo_movimiento.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosComprobantesAnulados(ComprobantesAnulados comprobantesanulados,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		comprobantesanulados.setuser_name_usuario(comprobantesanulados.getuser_name_usuario().trim());
		comprobantesanulados.setnombre_modulo(comprobantesanulados.getnombre_modulo().trim());
		comprobantesanulados.setcodigo(comprobantesanulados.getcodigo().trim());
		comprobantesanulados.setbeneficiario(comprobantesanulados.getbeneficiario().trim());
		comprobantesanulados.setdetalle(comprobantesanulados.getdetalle().trim());
		comprobantesanulados.setcodigo_tipo_movimiento(comprobantesanulados.getcodigo_tipo_movimiento().trim());
		comprobantesanulados.setnumero_mayor_dato(comprobantesanulados.getnumero_mayor_dato().trim());
		comprobantesanulados.setnombre_cuenta_contable(comprobantesanulados.getnombre_cuenta_contable().trim());
		comprobantesanulados.setcodigo_cuenta_contable(comprobantesanulados.getcodigo_cuenta_contable().trim());
	}
	
	public static void quitarEspaciosComprobantesAnuladoss(List<ComprobantesAnulados> comprobantesanuladoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ComprobantesAnulados comprobantesanulados: comprobantesanuladoss) {
			comprobantesanulados.setuser_name_usuario(comprobantesanulados.getuser_name_usuario().trim());
			comprobantesanulados.setnombre_modulo(comprobantesanulados.getnombre_modulo().trim());
			comprobantesanulados.setcodigo(comprobantesanulados.getcodigo().trim());
			comprobantesanulados.setbeneficiario(comprobantesanulados.getbeneficiario().trim());
			comprobantesanulados.setdetalle(comprobantesanulados.getdetalle().trim());
			comprobantesanulados.setcodigo_tipo_movimiento(comprobantesanulados.getcodigo_tipo_movimiento().trim());
			comprobantesanulados.setnumero_mayor_dato(comprobantesanulados.getnumero_mayor_dato().trim());
			comprobantesanulados.setnombre_cuenta_contable(comprobantesanulados.getnombre_cuenta_contable().trim());
			comprobantesanulados.setcodigo_cuenta_contable(comprobantesanulados.getcodigo_cuenta_contable().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresComprobantesAnulados(ComprobantesAnulados comprobantesanulados,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && comprobantesanulados.getConCambioAuxiliar()) {
			comprobantesanulados.setIsDeleted(comprobantesanulados.getIsDeletedAuxiliar());	
			comprobantesanulados.setIsNew(comprobantesanulados.getIsNewAuxiliar());	
			comprobantesanulados.setIsChanged(comprobantesanulados.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			comprobantesanulados.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			comprobantesanulados.setIsDeletedAuxiliar(false);	
			comprobantesanulados.setIsNewAuxiliar(false);	
			comprobantesanulados.setIsChangedAuxiliar(false);
			
			comprobantesanulados.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresComprobantesAnuladoss(List<ComprobantesAnulados> comprobantesanuladoss,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ComprobantesAnulados comprobantesanulados : comprobantesanuladoss) {
			if(conAsignarBase && comprobantesanulados.getConCambioAuxiliar()) {
				comprobantesanulados.setIsDeleted(comprobantesanulados.getIsDeletedAuxiliar());	
				comprobantesanulados.setIsNew(comprobantesanulados.getIsNewAuxiliar());	
				comprobantesanulados.setIsChanged(comprobantesanulados.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				comprobantesanulados.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				comprobantesanulados.setIsDeletedAuxiliar(false);	
				comprobantesanulados.setIsNewAuxiliar(false);	
				comprobantesanulados.setIsChangedAuxiliar(false);
				
				comprobantesanulados.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresComprobantesAnulados(ComprobantesAnulados comprobantesanulados,Boolean conEnteros) throws Exception  {
		comprobantesanulados.setdebito_local(0.0);
		comprobantesanulados.setcredito_local(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresComprobantesAnuladoss(List<ComprobantesAnulados> comprobantesanuladoss,Boolean conEnteros) throws Exception  {
		
		for(ComprobantesAnulados comprobantesanulados: comprobantesanuladoss) {
			comprobantesanulados.setdebito_local(0.0);
			comprobantesanulados.setcredito_local(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaComprobantesAnulados(List<ComprobantesAnulados> comprobantesanuladoss,ComprobantesAnulados comprobantesanuladosAux) throws Exception  {
		ComprobantesAnuladosConstantesFunciones.InicializarValoresComprobantesAnulados(comprobantesanuladosAux,true);
		
		for(ComprobantesAnulados comprobantesanulados: comprobantesanuladoss) {
			if(comprobantesanulados.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			comprobantesanuladosAux.setdebito_local(comprobantesanuladosAux.getdebito_local()+comprobantesanulados.getdebito_local());			
			comprobantesanuladosAux.setcredito_local(comprobantesanuladosAux.getcredito_local()+comprobantesanulados.getcredito_local());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesComprobantesAnulados(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ComprobantesAnuladosConstantesFunciones.getArrayColumnasGlobalesComprobantesAnulados(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesComprobantesAnulados(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ComprobantesAnuladosConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ComprobantesAnuladosConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ComprobantesAnuladosConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ComprobantesAnuladosConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ComprobantesAnuladosConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ComprobantesAnuladosConstantesFunciones.IDEJERCICIO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoComprobantesAnulados(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ComprobantesAnulados> comprobantesanuladoss,ComprobantesAnulados comprobantesanulados,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ComprobantesAnulados comprobantesanuladosAux: comprobantesanuladoss) {
			if(comprobantesanuladosAux!=null && comprobantesanulados!=null) {
				if((comprobantesanuladosAux.getId()==null && comprobantesanulados.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(comprobantesanuladosAux.getId()!=null && comprobantesanulados.getId()!=null){
					if(comprobantesanuladosAux.getId().equals(comprobantesanulados.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaComprobantesAnulados(List<ComprobantesAnulados> comprobantesanuladoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double debito_localTotal=0.0;
		Double credito_localTotal=0.0;
	
		for(ComprobantesAnulados comprobantesanulados: comprobantesanuladoss) {			
			if(comprobantesanulados.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			debito_localTotal+=comprobantesanulados.getdebito_local();
			credito_localTotal+=comprobantesanulados.getcredito_local();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComprobantesAnuladosConstantesFunciones.DEBITOLOCAL);
		datoGeneral.setsDescripcion(ComprobantesAnuladosConstantesFunciones.LABEL_DEBITOLOCAL);
		datoGeneral.setdValorDouble(debito_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComprobantesAnuladosConstantesFunciones.CREDITOLOCAL);
		datoGeneral.setsDescripcion(ComprobantesAnuladosConstantesFunciones.LABEL_CREDITOLOCAL);
		datoGeneral.setdValorDouble(credito_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaComprobantesAnulados() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ComprobantesAnuladosConstantesFunciones.LABEL_ID, ComprobantesAnuladosConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobantesAnuladosConstantesFunciones.LABEL_VERSIONROW, ComprobantesAnuladosConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobantesAnuladosConstantesFunciones.LABEL_USERNAMEUSUARIO, ComprobantesAnuladosConstantesFunciones.USERNAMEUSUARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobantesAnuladosConstantesFunciones.LABEL_NOMBREMODULO, ComprobantesAnuladosConstantesFunciones.NOMBREMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobantesAnuladosConstantesFunciones.LABEL_CODIGO, ComprobantesAnuladosConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobantesAnuladosConstantesFunciones.LABEL_BENEFICIARIO, ComprobantesAnuladosConstantesFunciones.BENEFICIARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobantesAnuladosConstantesFunciones.LABEL_DETALLE, ComprobantesAnuladosConstantesFunciones.DETALLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobantesAnuladosConstantesFunciones.LABEL_FECHAEMISION, ComprobantesAnuladosConstantesFunciones.FECHAEMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobantesAnuladosConstantesFunciones.LABEL_CODIGOTIPOMOVIMIENTO, ComprobantesAnuladosConstantesFunciones.CODIGOTIPOMOVIMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobantesAnuladosConstantesFunciones.LABEL_NUMEROMAYORDATO, ComprobantesAnuladosConstantesFunciones.NUMEROMAYORDATO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobantesAnuladosConstantesFunciones.LABEL_NOMBRECUENTACONTABLE, ComprobantesAnuladosConstantesFunciones.NOMBRECUENTACONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobantesAnuladosConstantesFunciones.LABEL_DEBITOLOCAL, ComprobantesAnuladosConstantesFunciones.DEBITOLOCAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobantesAnuladosConstantesFunciones.LABEL_CREDITOLOCAL, ComprobantesAnuladosConstantesFunciones.CREDITOLOCAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobantesAnuladosConstantesFunciones.LABEL_CODIGOCUENTACONTABLE, ComprobantesAnuladosConstantesFunciones.CODIGOCUENTACONTABLE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasComprobantesAnulados() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ComprobantesAnuladosConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobantesAnuladosConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobantesAnuladosConstantesFunciones.USERNAMEUSUARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobantesAnuladosConstantesFunciones.NOMBREMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobantesAnuladosConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobantesAnuladosConstantesFunciones.BENEFICIARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobantesAnuladosConstantesFunciones.DETALLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobantesAnuladosConstantesFunciones.FECHAEMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobantesAnuladosConstantesFunciones.CODIGOTIPOMOVIMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobantesAnuladosConstantesFunciones.NUMEROMAYORDATO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobantesAnuladosConstantesFunciones.NOMBRECUENTACONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobantesAnuladosConstantesFunciones.DEBITOLOCAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobantesAnuladosConstantesFunciones.CREDITOLOCAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobantesAnuladosConstantesFunciones.CODIGOCUENTACONTABLE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarComprobantesAnulados() throws Exception  {
		return ComprobantesAnuladosConstantesFunciones.getTiposSeleccionarComprobantesAnulados(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarComprobantesAnulados(Boolean conFk) throws Exception  {
		return ComprobantesAnuladosConstantesFunciones.getTiposSeleccionarComprobantesAnulados(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarComprobantesAnulados(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobantesAnuladosConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ComprobantesAnuladosConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobantesAnuladosConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(ComprobantesAnuladosConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobantesAnuladosConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(ComprobantesAnuladosConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobantesAnuladosConstantesFunciones.LABEL_IDTIPODOCUMENTO);
			reporte.setsDescripcion(ComprobantesAnuladosConstantesFunciones.LABEL_IDTIPODOCUMENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobantesAnuladosConstantesFunciones.LABEL_IDTIPOMOVIMIENTO);
			reporte.setsDescripcion(ComprobantesAnuladosConstantesFunciones.LABEL_IDTIPOMOVIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobantesAnuladosConstantesFunciones.LABEL_NUMEROMAYOR);
			reporte.setsDescripcion(ComprobantesAnuladosConstantesFunciones.LABEL_NUMEROMAYOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobantesAnuladosConstantesFunciones.LABEL_FECHAEMISIONDESDE);
			reporte.setsDescripcion(ComprobantesAnuladosConstantesFunciones.LABEL_FECHAEMISIONDESDE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobantesAnuladosConstantesFunciones.LABEL_FECHAEMISIONHASTA);
			reporte.setsDescripcion(ComprobantesAnuladosConstantesFunciones.LABEL_FECHAEMISIONHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobantesAnuladosConstantesFunciones.LABEL_USERNAMEUSUARIO);
			reporte.setsDescripcion(ComprobantesAnuladosConstantesFunciones.LABEL_USERNAMEUSUARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobantesAnuladosConstantesFunciones.LABEL_NOMBREMODULO);
			reporte.setsDescripcion(ComprobantesAnuladosConstantesFunciones.LABEL_NOMBREMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobantesAnuladosConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(ComprobantesAnuladosConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobantesAnuladosConstantesFunciones.LABEL_BENEFICIARIO);
			reporte.setsDescripcion(ComprobantesAnuladosConstantesFunciones.LABEL_BENEFICIARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobantesAnuladosConstantesFunciones.LABEL_DETALLE);
			reporte.setsDescripcion(ComprobantesAnuladosConstantesFunciones.LABEL_DETALLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobantesAnuladosConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(ComprobantesAnuladosConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobantesAnuladosConstantesFunciones.LABEL_CODIGOTIPOMOVIMIENTO);
			reporte.setsDescripcion(ComprobantesAnuladosConstantesFunciones.LABEL_CODIGOTIPOMOVIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobantesAnuladosConstantesFunciones.LABEL_NUMEROMAYORDATO);
			reporte.setsDescripcion(ComprobantesAnuladosConstantesFunciones.LABEL_NUMEROMAYORDATO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobantesAnuladosConstantesFunciones.LABEL_NOMBRECUENTACONTABLE);
			reporte.setsDescripcion(ComprobantesAnuladosConstantesFunciones.LABEL_NOMBRECUENTACONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobantesAnuladosConstantesFunciones.LABEL_DEBITOLOCAL);
			reporte.setsDescripcion(ComprobantesAnuladosConstantesFunciones.LABEL_DEBITOLOCAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobantesAnuladosConstantesFunciones.LABEL_CREDITOLOCAL);
			reporte.setsDescripcion(ComprobantesAnuladosConstantesFunciones.LABEL_CREDITOLOCAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobantesAnuladosConstantesFunciones.LABEL_CODIGOCUENTACONTABLE);
			reporte.setsDescripcion(ComprobantesAnuladosConstantesFunciones.LABEL_CODIGOCUENTACONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesComprobantesAnulados(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesComprobantesAnulados(ComprobantesAnulados comprobantesanuladosAux) throws Exception {
		
			comprobantesanuladosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(comprobantesanuladosAux.getEmpresa()));
			comprobantesanuladosAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(comprobantesanuladosAux.getSucursal()));
			comprobantesanuladosAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(comprobantesanuladosAux.getEjercicio()));
			comprobantesanuladosAux.settipodocumento_descripcion(TipoDocumentoConstantesFunciones.getTipoDocumentoDescripcion(comprobantesanuladosAux.getTipoDocumento()));
			comprobantesanuladosAux.settipomovimiento_descripcion(TipoMovimientoConstantesFunciones.getTipoMovimientoDescripcion(comprobantesanuladosAux.getTipoMovimiento()));		
	}
	
	public static void refrescarForeignKeysDescripcionesComprobantesAnulados(List<ComprobantesAnulados> comprobantesanuladossTemp) throws Exception {
		for(ComprobantesAnulados comprobantesanuladosAux:comprobantesanuladossTemp) {
			
			comprobantesanuladosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(comprobantesanuladosAux.getEmpresa()));
			comprobantesanuladosAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(comprobantesanuladosAux.getSucursal()));
			comprobantesanuladosAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(comprobantesanuladosAux.getEjercicio()));
			comprobantesanuladosAux.settipodocumento_descripcion(TipoDocumentoConstantesFunciones.getTipoDocumentoDescripcion(comprobantesanuladosAux.getTipoDocumento()));
			comprobantesanuladosAux.settipomovimiento_descripcion(TipoMovimientoConstantesFunciones.getTipoMovimientoDescripcion(comprobantesanuladosAux.getTipoMovimiento()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfComprobantesAnulados(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(TipoDocumento.class));
				classes.add(new Classe(TipoMovimiento.class));
				
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
					if(clas.clas.equals(Ejercicio.class)) {
						classes.add(new Classe(Ejercicio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoDocumento.class)) {
						classes.add(new Classe(TipoDocumento.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoMovimiento.class)) {
						classes.add(new Classe(TipoMovimiento.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfComprobantesAnulados(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(TipoDocumento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDocumento.class)); continue;
					}

					if(TipoMovimiento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoMovimiento.class)); continue;
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

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(TipoDocumento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDocumento.class)); continue;
					}

					if(TipoMovimiento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoMovimiento.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfComprobantesAnulados(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ComprobantesAnuladosConstantesFunciones.getClassesRelationshipsOfComprobantesAnulados(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfComprobantesAnulados(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfComprobantesAnulados(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ComprobantesAnuladosConstantesFunciones.getClassesRelationshipsFromStringsOfComprobantesAnulados(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfComprobantesAnulados(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ComprobantesAnulados comprobantesanulados,List<ComprobantesAnulados> comprobantesanuladoss,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(ComprobantesAnulados comprobantesanulados,List<ComprobantesAnulados> comprobantesanuladoss) throws Exception {
		try	{			
			for(ComprobantesAnulados comprobantesanuladosLocal:comprobantesanuladoss) {
				if(comprobantesanuladosLocal.getId().equals(comprobantesanulados.getId())) {
					comprobantesanuladosLocal.setIsSelected(comprobantesanulados.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesComprobantesAnulados(List<ComprobantesAnulados> comprobantesanuladossAux) throws Exception {
		//this.comprobantesanuladossAux=comprobantesanuladossAux;
		
		for(ComprobantesAnulados comprobantesanuladosAux:comprobantesanuladossAux) {
			if(comprobantesanuladosAux.getIsChanged()) {
				comprobantesanuladosAux.setIsChanged(false);
			}		
			
			if(comprobantesanuladosAux.getIsNew()) {
				comprobantesanuladosAux.setIsNew(false);
			}	
			
			if(comprobantesanuladosAux.getIsDeleted()) {
				comprobantesanuladosAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesComprobantesAnulados(ComprobantesAnulados comprobantesanuladosAux) throws Exception {
		//this.comprobantesanuladosAux=comprobantesanuladosAux;
		
			if(comprobantesanuladosAux.getIsChanged()) {
				comprobantesanuladosAux.setIsChanged(false);
			}		
			
			if(comprobantesanuladosAux.getIsNew()) {
				comprobantesanuladosAux.setIsNew(false);
			}	
			
			if(comprobantesanuladosAux.getIsDeleted()) {
				comprobantesanuladosAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ComprobantesAnulados comprobantesanuladosAsignar,ComprobantesAnulados comprobantesanulados) throws Exception {
		comprobantesanuladosAsignar.setId(comprobantesanulados.getId());	
		comprobantesanuladosAsignar.setVersionRow(comprobantesanulados.getVersionRow());	
		comprobantesanuladosAsignar.setuser_name_usuario(comprobantesanulados.getuser_name_usuario());	
		comprobantesanuladosAsignar.setnombre_modulo(comprobantesanulados.getnombre_modulo());	
		comprobantesanuladosAsignar.setcodigo(comprobantesanulados.getcodigo());	
		comprobantesanuladosAsignar.setbeneficiario(comprobantesanulados.getbeneficiario());	
		comprobantesanuladosAsignar.setdetalle(comprobantesanulados.getdetalle());	
		comprobantesanuladosAsignar.setfecha_emision(comprobantesanulados.getfecha_emision());	
		comprobantesanuladosAsignar.setcodigo_tipo_movimiento(comprobantesanulados.getcodigo_tipo_movimiento());	
		comprobantesanuladosAsignar.setnumero_mayor_dato(comprobantesanulados.getnumero_mayor_dato());	
		comprobantesanuladosAsignar.setnombre_cuenta_contable(comprobantesanulados.getnombre_cuenta_contable());	
		comprobantesanuladosAsignar.setdebito_local(comprobantesanulados.getdebito_local());	
		comprobantesanuladosAsignar.setcredito_local(comprobantesanulados.getcredito_local());	
		comprobantesanuladosAsignar.setcodigo_cuenta_contable(comprobantesanulados.getcodigo_cuenta_contable());	
	}
	
	public static void inicializarComprobantesAnulados(ComprobantesAnulados comprobantesanulados) throws Exception {
		try {
				comprobantesanulados.setId(0L);	
					
				comprobantesanulados.setuser_name_usuario("");	
				comprobantesanulados.setnombre_modulo("");	
				comprobantesanulados.setcodigo("");	
				comprobantesanulados.setbeneficiario("");	
				comprobantesanulados.setdetalle("");	
				comprobantesanulados.setfecha_emision(new Date());	
				comprobantesanulados.setcodigo_tipo_movimiento("");	
				comprobantesanulados.setnumero_mayor_dato("");	
				comprobantesanulados.setnombre_cuenta_contable("");	
				comprobantesanulados.setdebito_local(0.0);	
				comprobantesanulados.setcredito_local(0.0);	
				comprobantesanulados.setcodigo_cuenta_contable("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderComprobantesAnulados(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobantesAnuladosConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobantesAnuladosConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobantesAnuladosConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobantesAnuladosConstantesFunciones.LABEL_IDTIPODOCUMENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobantesAnuladosConstantesFunciones.LABEL_IDTIPOMOVIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobantesAnuladosConstantesFunciones.LABEL_NUMEROMAYOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobantesAnuladosConstantesFunciones.LABEL_FECHAEMISIONDESDE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobantesAnuladosConstantesFunciones.LABEL_FECHAEMISIONHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobantesAnuladosConstantesFunciones.LABEL_USERNAMEUSUARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobantesAnuladosConstantesFunciones.LABEL_NOMBREMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobantesAnuladosConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobantesAnuladosConstantesFunciones.LABEL_BENEFICIARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobantesAnuladosConstantesFunciones.LABEL_DETALLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobantesAnuladosConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobantesAnuladosConstantesFunciones.LABEL_CODIGOTIPOMOVIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobantesAnuladosConstantesFunciones.LABEL_NUMEROMAYORDATO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobantesAnuladosConstantesFunciones.LABEL_NOMBRECUENTACONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobantesAnuladosConstantesFunciones.LABEL_DEBITOLOCAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobantesAnuladosConstantesFunciones.LABEL_CREDITOLOCAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobantesAnuladosConstantesFunciones.LABEL_CODIGOCUENTACONTABLE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataComprobantesAnulados(String sTipo,Row row,Workbook workbook,ComprobantesAnulados comprobantesanulados,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantesanulados.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantesanulados.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantesanulados.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantesanulados.gettipodocumento_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantesanulados.gettipomovimiento_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantesanulados.getnumero_mayor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantesanulados.getfecha_emision_desde());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantesanulados.getfecha_emision_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantesanulados.getuser_name_usuario());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantesanulados.getnombre_modulo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantesanulados.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantesanulados.getbeneficiario());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantesanulados.getdetalle());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantesanulados.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantesanulados.getcodigo_tipo_movimiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantesanulados.getnumero_mayor_dato());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantesanulados.getnombre_cuenta_contable());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantesanulados.getdebito_local());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantesanulados.getcredito_local());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantesanulados.getcodigo_cuenta_contable());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryComprobantesAnulados="";
	
	public String getsFinalQueryComprobantesAnulados() {
		return this.sFinalQueryComprobantesAnulados;
	}
	
	public void setsFinalQueryComprobantesAnulados(String sFinalQueryComprobantesAnulados) {
		this.sFinalQueryComprobantesAnulados= sFinalQueryComprobantesAnulados;
	}
	
	public Border resaltarSeleccionarComprobantesAnulados=null;
	
	public Border setResaltarSeleccionarComprobantesAnulados(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobantesAnuladosBeanSwingJInternalFrame comprobantesanuladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//comprobantesanuladosBeanSwingJInternalFrame.jTtoolBarComprobantesAnulados.setBorder(borderResaltar);
		
		this.resaltarSeleccionarComprobantesAnulados= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarComprobantesAnulados() {
		return this.resaltarSeleccionarComprobantesAnulados;
	}
	
	public void setResaltarSeleccionarComprobantesAnulados(Border borderResaltarSeleccionarComprobantesAnulados) {
		this.resaltarSeleccionarComprobantesAnulados= borderResaltarSeleccionarComprobantesAnulados;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridComprobantesAnulados=null;
	public Boolean mostraridComprobantesAnulados=true;
	public Boolean activaridComprobantesAnulados=true;

	public Border resaltarid_empresaComprobantesAnulados=null;
	public Boolean mostrarid_empresaComprobantesAnulados=true;
	public Boolean activarid_empresaComprobantesAnulados=true;
	public Boolean cargarid_empresaComprobantesAnulados=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaComprobantesAnulados=false;//ConEventDepend=true

	public Border resaltarid_sucursalComprobantesAnulados=null;
	public Boolean mostrarid_sucursalComprobantesAnulados=true;
	public Boolean activarid_sucursalComprobantesAnulados=true;
	public Boolean cargarid_sucursalComprobantesAnulados=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalComprobantesAnulados=false;//ConEventDepend=true

	public Border resaltarid_ejercicioComprobantesAnulados=null;
	public Boolean mostrarid_ejercicioComprobantesAnulados=true;
	public Boolean activarid_ejercicioComprobantesAnulados=true;
	public Boolean cargarid_ejercicioComprobantesAnulados=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioComprobantesAnulados=false;//ConEventDepend=true

	public Border resaltarid_tipo_documentoComprobantesAnulados=null;
	public Boolean mostrarid_tipo_documentoComprobantesAnulados=true;
	public Boolean activarid_tipo_documentoComprobantesAnulados=true;
	public Boolean cargarid_tipo_documentoComprobantesAnulados=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_documentoComprobantesAnulados=false;//ConEventDepend=true

	public Border resaltarid_tipo_movimientoComprobantesAnulados=null;
	public Boolean mostrarid_tipo_movimientoComprobantesAnulados=true;
	public Boolean activarid_tipo_movimientoComprobantesAnulados=true;
	public Boolean cargarid_tipo_movimientoComprobantesAnulados=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_movimientoComprobantesAnulados=false;//ConEventDepend=true

	public Border resaltarnumero_mayorComprobantesAnulados=null;
	public Boolean mostrarnumero_mayorComprobantesAnulados=true;
	public Boolean activarnumero_mayorComprobantesAnulados=true;

	public Border resaltarfecha_emision_desdeComprobantesAnulados=null;
	public Boolean mostrarfecha_emision_desdeComprobantesAnulados=true;
	public Boolean activarfecha_emision_desdeComprobantesAnulados=true;

	public Border resaltarfecha_emision_hastaComprobantesAnulados=null;
	public Boolean mostrarfecha_emision_hastaComprobantesAnulados=true;
	public Boolean activarfecha_emision_hastaComprobantesAnulados=true;

	public Border resaltaruser_name_usuarioComprobantesAnulados=null;
	public Boolean mostraruser_name_usuarioComprobantesAnulados=true;
	public Boolean activaruser_name_usuarioComprobantesAnulados=true;

	public Border resaltarnombre_moduloComprobantesAnulados=null;
	public Boolean mostrarnombre_moduloComprobantesAnulados=true;
	public Boolean activarnombre_moduloComprobantesAnulados=true;

	public Border resaltarcodigoComprobantesAnulados=null;
	public Boolean mostrarcodigoComprobantesAnulados=true;
	public Boolean activarcodigoComprobantesAnulados=true;

	public Border resaltarbeneficiarioComprobantesAnulados=null;
	public Boolean mostrarbeneficiarioComprobantesAnulados=true;
	public Boolean activarbeneficiarioComprobantesAnulados=true;

	public Border resaltardetalleComprobantesAnulados=null;
	public Boolean mostrardetalleComprobantesAnulados=true;
	public Boolean activardetalleComprobantesAnulados=true;

	public Border resaltarfecha_emisionComprobantesAnulados=null;
	public Boolean mostrarfecha_emisionComprobantesAnulados=true;
	public Boolean activarfecha_emisionComprobantesAnulados=true;

	public Border resaltarcodigo_tipo_movimientoComprobantesAnulados=null;
	public Boolean mostrarcodigo_tipo_movimientoComprobantesAnulados=true;
	public Boolean activarcodigo_tipo_movimientoComprobantesAnulados=true;

	public Border resaltarnumero_mayor_datoComprobantesAnulados=null;
	public Boolean mostrarnumero_mayor_datoComprobantesAnulados=true;
	public Boolean activarnumero_mayor_datoComprobantesAnulados=true;

	public Border resaltarnombre_cuenta_contableComprobantesAnulados=null;
	public Boolean mostrarnombre_cuenta_contableComprobantesAnulados=true;
	public Boolean activarnombre_cuenta_contableComprobantesAnulados=true;

	public Border resaltardebito_localComprobantesAnulados=null;
	public Boolean mostrardebito_localComprobantesAnulados=true;
	public Boolean activardebito_localComprobantesAnulados=true;

	public Border resaltarcredito_localComprobantesAnulados=null;
	public Boolean mostrarcredito_localComprobantesAnulados=true;
	public Boolean activarcredito_localComprobantesAnulados=true;

	public Border resaltarcodigo_cuenta_contableComprobantesAnulados=null;
	public Boolean mostrarcodigo_cuenta_contableComprobantesAnulados=true;
	public Boolean activarcodigo_cuenta_contableComprobantesAnulados=true;

	
	

	public Border setResaltaridComprobantesAnulados(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobantesAnuladosBeanSwingJInternalFrame comprobantesanuladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantesanuladosBeanSwingJInternalFrame.jTtoolBarComprobantesAnulados.setBorder(borderResaltar);
		
		this.resaltaridComprobantesAnulados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridComprobantesAnulados() {
		return this.resaltaridComprobantesAnulados;
	}

	public void setResaltaridComprobantesAnulados(Border borderResaltar) {
		this.resaltaridComprobantesAnulados= borderResaltar;
	}

	public Boolean getMostraridComprobantesAnulados() {
		return this.mostraridComprobantesAnulados;
	}

	public void setMostraridComprobantesAnulados(Boolean mostraridComprobantesAnulados) {
		this.mostraridComprobantesAnulados= mostraridComprobantesAnulados;
	}

	public Boolean getActivaridComprobantesAnulados() {
		return this.activaridComprobantesAnulados;
	}

	public void setActivaridComprobantesAnulados(Boolean activaridComprobantesAnulados) {
		this.activaridComprobantesAnulados= activaridComprobantesAnulados;
	}

	public Border setResaltarid_empresaComprobantesAnulados(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobantesAnuladosBeanSwingJInternalFrame comprobantesanuladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantesanuladosBeanSwingJInternalFrame.jTtoolBarComprobantesAnulados.setBorder(borderResaltar);
		
		this.resaltarid_empresaComprobantesAnulados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaComprobantesAnulados() {
		return this.resaltarid_empresaComprobantesAnulados;
	}

	public void setResaltarid_empresaComprobantesAnulados(Border borderResaltar) {
		this.resaltarid_empresaComprobantesAnulados= borderResaltar;
	}

	public Boolean getMostrarid_empresaComprobantesAnulados() {
		return this.mostrarid_empresaComprobantesAnulados;
	}

	public void setMostrarid_empresaComprobantesAnulados(Boolean mostrarid_empresaComprobantesAnulados) {
		this.mostrarid_empresaComprobantesAnulados= mostrarid_empresaComprobantesAnulados;
	}

	public Boolean getActivarid_empresaComprobantesAnulados() {
		return this.activarid_empresaComprobantesAnulados;
	}

	public void setActivarid_empresaComprobantesAnulados(Boolean activarid_empresaComprobantesAnulados) {
		this.activarid_empresaComprobantesAnulados= activarid_empresaComprobantesAnulados;
	}

	public Boolean getCargarid_empresaComprobantesAnulados() {
		return this.cargarid_empresaComprobantesAnulados;
	}

	public void setCargarid_empresaComprobantesAnulados(Boolean cargarid_empresaComprobantesAnulados) {
		this.cargarid_empresaComprobantesAnulados= cargarid_empresaComprobantesAnulados;
	}

	public Border setResaltarid_sucursalComprobantesAnulados(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobantesAnuladosBeanSwingJInternalFrame comprobantesanuladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantesanuladosBeanSwingJInternalFrame.jTtoolBarComprobantesAnulados.setBorder(borderResaltar);
		
		this.resaltarid_sucursalComprobantesAnulados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalComprobantesAnulados() {
		return this.resaltarid_sucursalComprobantesAnulados;
	}

	public void setResaltarid_sucursalComprobantesAnulados(Border borderResaltar) {
		this.resaltarid_sucursalComprobantesAnulados= borderResaltar;
	}

	public Boolean getMostrarid_sucursalComprobantesAnulados() {
		return this.mostrarid_sucursalComprobantesAnulados;
	}

	public void setMostrarid_sucursalComprobantesAnulados(Boolean mostrarid_sucursalComprobantesAnulados) {
		this.mostrarid_sucursalComprobantesAnulados= mostrarid_sucursalComprobantesAnulados;
	}

	public Boolean getActivarid_sucursalComprobantesAnulados() {
		return this.activarid_sucursalComprobantesAnulados;
	}

	public void setActivarid_sucursalComprobantesAnulados(Boolean activarid_sucursalComprobantesAnulados) {
		this.activarid_sucursalComprobantesAnulados= activarid_sucursalComprobantesAnulados;
	}

	public Boolean getCargarid_sucursalComprobantesAnulados() {
		return this.cargarid_sucursalComprobantesAnulados;
	}

	public void setCargarid_sucursalComprobantesAnulados(Boolean cargarid_sucursalComprobantesAnulados) {
		this.cargarid_sucursalComprobantesAnulados= cargarid_sucursalComprobantesAnulados;
	}

	public Border setResaltarid_ejercicioComprobantesAnulados(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobantesAnuladosBeanSwingJInternalFrame comprobantesanuladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantesanuladosBeanSwingJInternalFrame.jTtoolBarComprobantesAnulados.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioComprobantesAnulados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioComprobantesAnulados() {
		return this.resaltarid_ejercicioComprobantesAnulados;
	}

	public void setResaltarid_ejercicioComprobantesAnulados(Border borderResaltar) {
		this.resaltarid_ejercicioComprobantesAnulados= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioComprobantesAnulados() {
		return this.mostrarid_ejercicioComprobantesAnulados;
	}

	public void setMostrarid_ejercicioComprobantesAnulados(Boolean mostrarid_ejercicioComprobantesAnulados) {
		this.mostrarid_ejercicioComprobantesAnulados= mostrarid_ejercicioComprobantesAnulados;
	}

	public Boolean getActivarid_ejercicioComprobantesAnulados() {
		return this.activarid_ejercicioComprobantesAnulados;
	}

	public void setActivarid_ejercicioComprobantesAnulados(Boolean activarid_ejercicioComprobantesAnulados) {
		this.activarid_ejercicioComprobantesAnulados= activarid_ejercicioComprobantesAnulados;
	}

	public Boolean getCargarid_ejercicioComprobantesAnulados() {
		return this.cargarid_ejercicioComprobantesAnulados;
	}

	public void setCargarid_ejercicioComprobantesAnulados(Boolean cargarid_ejercicioComprobantesAnulados) {
		this.cargarid_ejercicioComprobantesAnulados= cargarid_ejercicioComprobantesAnulados;
	}

	public Border setResaltarid_tipo_documentoComprobantesAnulados(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobantesAnuladosBeanSwingJInternalFrame comprobantesanuladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantesanuladosBeanSwingJInternalFrame.jTtoolBarComprobantesAnulados.setBorder(borderResaltar);
		
		this.resaltarid_tipo_documentoComprobantesAnulados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_documentoComprobantesAnulados() {
		return this.resaltarid_tipo_documentoComprobantesAnulados;
	}

	public void setResaltarid_tipo_documentoComprobantesAnulados(Border borderResaltar) {
		this.resaltarid_tipo_documentoComprobantesAnulados= borderResaltar;
	}

	public Boolean getMostrarid_tipo_documentoComprobantesAnulados() {
		return this.mostrarid_tipo_documentoComprobantesAnulados;
	}

	public void setMostrarid_tipo_documentoComprobantesAnulados(Boolean mostrarid_tipo_documentoComprobantesAnulados) {
		this.mostrarid_tipo_documentoComprobantesAnulados= mostrarid_tipo_documentoComprobantesAnulados;
	}

	public Boolean getActivarid_tipo_documentoComprobantesAnulados() {
		return this.activarid_tipo_documentoComprobantesAnulados;
	}

	public void setActivarid_tipo_documentoComprobantesAnulados(Boolean activarid_tipo_documentoComprobantesAnulados) {
		this.activarid_tipo_documentoComprobantesAnulados= activarid_tipo_documentoComprobantesAnulados;
	}

	public Boolean getCargarid_tipo_documentoComprobantesAnulados() {
		return this.cargarid_tipo_documentoComprobantesAnulados;
	}

	public void setCargarid_tipo_documentoComprobantesAnulados(Boolean cargarid_tipo_documentoComprobantesAnulados) {
		this.cargarid_tipo_documentoComprobantesAnulados= cargarid_tipo_documentoComprobantesAnulados;
	}

	public Border setResaltarid_tipo_movimientoComprobantesAnulados(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobantesAnuladosBeanSwingJInternalFrame comprobantesanuladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantesanuladosBeanSwingJInternalFrame.jTtoolBarComprobantesAnulados.setBorder(borderResaltar);
		
		this.resaltarid_tipo_movimientoComprobantesAnulados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_movimientoComprobantesAnulados() {
		return this.resaltarid_tipo_movimientoComprobantesAnulados;
	}

	public void setResaltarid_tipo_movimientoComprobantesAnulados(Border borderResaltar) {
		this.resaltarid_tipo_movimientoComprobantesAnulados= borderResaltar;
	}

	public Boolean getMostrarid_tipo_movimientoComprobantesAnulados() {
		return this.mostrarid_tipo_movimientoComprobantesAnulados;
	}

	public void setMostrarid_tipo_movimientoComprobantesAnulados(Boolean mostrarid_tipo_movimientoComprobantesAnulados) {
		this.mostrarid_tipo_movimientoComprobantesAnulados= mostrarid_tipo_movimientoComprobantesAnulados;
	}

	public Boolean getActivarid_tipo_movimientoComprobantesAnulados() {
		return this.activarid_tipo_movimientoComprobantesAnulados;
	}

	public void setActivarid_tipo_movimientoComprobantesAnulados(Boolean activarid_tipo_movimientoComprobantesAnulados) {
		this.activarid_tipo_movimientoComprobantesAnulados= activarid_tipo_movimientoComprobantesAnulados;
	}

	public Boolean getCargarid_tipo_movimientoComprobantesAnulados() {
		return this.cargarid_tipo_movimientoComprobantesAnulados;
	}

	public void setCargarid_tipo_movimientoComprobantesAnulados(Boolean cargarid_tipo_movimientoComprobantesAnulados) {
		this.cargarid_tipo_movimientoComprobantesAnulados= cargarid_tipo_movimientoComprobantesAnulados;
	}

	public Border setResaltarnumero_mayorComprobantesAnulados(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobantesAnuladosBeanSwingJInternalFrame comprobantesanuladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantesanuladosBeanSwingJInternalFrame.jTtoolBarComprobantesAnulados.setBorder(borderResaltar);
		
		this.resaltarnumero_mayorComprobantesAnulados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_mayorComprobantesAnulados() {
		return this.resaltarnumero_mayorComprobantesAnulados;
	}

	public void setResaltarnumero_mayorComprobantesAnulados(Border borderResaltar) {
		this.resaltarnumero_mayorComprobantesAnulados= borderResaltar;
	}

	public Boolean getMostrarnumero_mayorComprobantesAnulados() {
		return this.mostrarnumero_mayorComprobantesAnulados;
	}

	public void setMostrarnumero_mayorComprobantesAnulados(Boolean mostrarnumero_mayorComprobantesAnulados) {
		this.mostrarnumero_mayorComprobantesAnulados= mostrarnumero_mayorComprobantesAnulados;
	}

	public Boolean getActivarnumero_mayorComprobantesAnulados() {
		return this.activarnumero_mayorComprobantesAnulados;
	}

	public void setActivarnumero_mayorComprobantesAnulados(Boolean activarnumero_mayorComprobantesAnulados) {
		this.activarnumero_mayorComprobantesAnulados= activarnumero_mayorComprobantesAnulados;
	}

	public Border setResaltarfecha_emision_desdeComprobantesAnulados(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobantesAnuladosBeanSwingJInternalFrame comprobantesanuladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantesanuladosBeanSwingJInternalFrame.jTtoolBarComprobantesAnulados.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_desdeComprobantesAnulados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_desdeComprobantesAnulados() {
		return this.resaltarfecha_emision_desdeComprobantesAnulados;
	}

	public void setResaltarfecha_emision_desdeComprobantesAnulados(Border borderResaltar) {
		this.resaltarfecha_emision_desdeComprobantesAnulados= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_desdeComprobantesAnulados() {
		return this.mostrarfecha_emision_desdeComprobantesAnulados;
	}

	public void setMostrarfecha_emision_desdeComprobantesAnulados(Boolean mostrarfecha_emision_desdeComprobantesAnulados) {
		this.mostrarfecha_emision_desdeComprobantesAnulados= mostrarfecha_emision_desdeComprobantesAnulados;
	}

	public Boolean getActivarfecha_emision_desdeComprobantesAnulados() {
		return this.activarfecha_emision_desdeComprobantesAnulados;
	}

	public void setActivarfecha_emision_desdeComprobantesAnulados(Boolean activarfecha_emision_desdeComprobantesAnulados) {
		this.activarfecha_emision_desdeComprobantesAnulados= activarfecha_emision_desdeComprobantesAnulados;
	}

	public Border setResaltarfecha_emision_hastaComprobantesAnulados(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobantesAnuladosBeanSwingJInternalFrame comprobantesanuladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantesanuladosBeanSwingJInternalFrame.jTtoolBarComprobantesAnulados.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_hastaComprobantesAnulados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_hastaComprobantesAnulados() {
		return this.resaltarfecha_emision_hastaComprobantesAnulados;
	}

	public void setResaltarfecha_emision_hastaComprobantesAnulados(Border borderResaltar) {
		this.resaltarfecha_emision_hastaComprobantesAnulados= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_hastaComprobantesAnulados() {
		return this.mostrarfecha_emision_hastaComprobantesAnulados;
	}

	public void setMostrarfecha_emision_hastaComprobantesAnulados(Boolean mostrarfecha_emision_hastaComprobantesAnulados) {
		this.mostrarfecha_emision_hastaComprobantesAnulados= mostrarfecha_emision_hastaComprobantesAnulados;
	}

	public Boolean getActivarfecha_emision_hastaComprobantesAnulados() {
		return this.activarfecha_emision_hastaComprobantesAnulados;
	}

	public void setActivarfecha_emision_hastaComprobantesAnulados(Boolean activarfecha_emision_hastaComprobantesAnulados) {
		this.activarfecha_emision_hastaComprobantesAnulados= activarfecha_emision_hastaComprobantesAnulados;
	}

	public Border setResaltaruser_name_usuarioComprobantesAnulados(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobantesAnuladosBeanSwingJInternalFrame comprobantesanuladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantesanuladosBeanSwingJInternalFrame.jTtoolBarComprobantesAnulados.setBorder(borderResaltar);
		
		this.resaltaruser_name_usuarioComprobantesAnulados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaruser_name_usuarioComprobantesAnulados() {
		return this.resaltaruser_name_usuarioComprobantesAnulados;
	}

	public void setResaltaruser_name_usuarioComprobantesAnulados(Border borderResaltar) {
		this.resaltaruser_name_usuarioComprobantesAnulados= borderResaltar;
	}

	public Boolean getMostraruser_name_usuarioComprobantesAnulados() {
		return this.mostraruser_name_usuarioComprobantesAnulados;
	}

	public void setMostraruser_name_usuarioComprobantesAnulados(Boolean mostraruser_name_usuarioComprobantesAnulados) {
		this.mostraruser_name_usuarioComprobantesAnulados= mostraruser_name_usuarioComprobantesAnulados;
	}

	public Boolean getActivaruser_name_usuarioComprobantesAnulados() {
		return this.activaruser_name_usuarioComprobantesAnulados;
	}

	public void setActivaruser_name_usuarioComprobantesAnulados(Boolean activaruser_name_usuarioComprobantesAnulados) {
		this.activaruser_name_usuarioComprobantesAnulados= activaruser_name_usuarioComprobantesAnulados;
	}

	public Border setResaltarnombre_moduloComprobantesAnulados(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobantesAnuladosBeanSwingJInternalFrame comprobantesanuladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantesanuladosBeanSwingJInternalFrame.jTtoolBarComprobantesAnulados.setBorder(borderResaltar);
		
		this.resaltarnombre_moduloComprobantesAnulados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_moduloComprobantesAnulados() {
		return this.resaltarnombre_moduloComprobantesAnulados;
	}

	public void setResaltarnombre_moduloComprobantesAnulados(Border borderResaltar) {
		this.resaltarnombre_moduloComprobantesAnulados= borderResaltar;
	}

	public Boolean getMostrarnombre_moduloComprobantesAnulados() {
		return this.mostrarnombre_moduloComprobantesAnulados;
	}

	public void setMostrarnombre_moduloComprobantesAnulados(Boolean mostrarnombre_moduloComprobantesAnulados) {
		this.mostrarnombre_moduloComprobantesAnulados= mostrarnombre_moduloComprobantesAnulados;
	}

	public Boolean getActivarnombre_moduloComprobantesAnulados() {
		return this.activarnombre_moduloComprobantesAnulados;
	}

	public void setActivarnombre_moduloComprobantesAnulados(Boolean activarnombre_moduloComprobantesAnulados) {
		this.activarnombre_moduloComprobantesAnulados= activarnombre_moduloComprobantesAnulados;
	}

	public Border setResaltarcodigoComprobantesAnulados(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobantesAnuladosBeanSwingJInternalFrame comprobantesanuladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantesanuladosBeanSwingJInternalFrame.jTtoolBarComprobantesAnulados.setBorder(borderResaltar);
		
		this.resaltarcodigoComprobantesAnulados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoComprobantesAnulados() {
		return this.resaltarcodigoComprobantesAnulados;
	}

	public void setResaltarcodigoComprobantesAnulados(Border borderResaltar) {
		this.resaltarcodigoComprobantesAnulados= borderResaltar;
	}

	public Boolean getMostrarcodigoComprobantesAnulados() {
		return this.mostrarcodigoComprobantesAnulados;
	}

	public void setMostrarcodigoComprobantesAnulados(Boolean mostrarcodigoComprobantesAnulados) {
		this.mostrarcodigoComprobantesAnulados= mostrarcodigoComprobantesAnulados;
	}

	public Boolean getActivarcodigoComprobantesAnulados() {
		return this.activarcodigoComprobantesAnulados;
	}

	public void setActivarcodigoComprobantesAnulados(Boolean activarcodigoComprobantesAnulados) {
		this.activarcodigoComprobantesAnulados= activarcodigoComprobantesAnulados;
	}

	public Border setResaltarbeneficiarioComprobantesAnulados(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobantesAnuladosBeanSwingJInternalFrame comprobantesanuladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantesanuladosBeanSwingJInternalFrame.jTtoolBarComprobantesAnulados.setBorder(borderResaltar);
		
		this.resaltarbeneficiarioComprobantesAnulados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarbeneficiarioComprobantesAnulados() {
		return this.resaltarbeneficiarioComprobantesAnulados;
	}

	public void setResaltarbeneficiarioComprobantesAnulados(Border borderResaltar) {
		this.resaltarbeneficiarioComprobantesAnulados= borderResaltar;
	}

	public Boolean getMostrarbeneficiarioComprobantesAnulados() {
		return this.mostrarbeneficiarioComprobantesAnulados;
	}

	public void setMostrarbeneficiarioComprobantesAnulados(Boolean mostrarbeneficiarioComprobantesAnulados) {
		this.mostrarbeneficiarioComprobantesAnulados= mostrarbeneficiarioComprobantesAnulados;
	}

	public Boolean getActivarbeneficiarioComprobantesAnulados() {
		return this.activarbeneficiarioComprobantesAnulados;
	}

	public void setActivarbeneficiarioComprobantesAnulados(Boolean activarbeneficiarioComprobantesAnulados) {
		this.activarbeneficiarioComprobantesAnulados= activarbeneficiarioComprobantesAnulados;
	}

	public Border setResaltardetalleComprobantesAnulados(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobantesAnuladosBeanSwingJInternalFrame comprobantesanuladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantesanuladosBeanSwingJInternalFrame.jTtoolBarComprobantesAnulados.setBorder(borderResaltar);
		
		this.resaltardetalleComprobantesAnulados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardetalleComprobantesAnulados() {
		return this.resaltardetalleComprobantesAnulados;
	}

	public void setResaltardetalleComprobantesAnulados(Border borderResaltar) {
		this.resaltardetalleComprobantesAnulados= borderResaltar;
	}

	public Boolean getMostrardetalleComprobantesAnulados() {
		return this.mostrardetalleComprobantesAnulados;
	}

	public void setMostrardetalleComprobantesAnulados(Boolean mostrardetalleComprobantesAnulados) {
		this.mostrardetalleComprobantesAnulados= mostrardetalleComprobantesAnulados;
	}

	public Boolean getActivardetalleComprobantesAnulados() {
		return this.activardetalleComprobantesAnulados;
	}

	public void setActivardetalleComprobantesAnulados(Boolean activardetalleComprobantesAnulados) {
		this.activardetalleComprobantesAnulados= activardetalleComprobantesAnulados;
	}

	public Border setResaltarfecha_emisionComprobantesAnulados(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobantesAnuladosBeanSwingJInternalFrame comprobantesanuladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantesanuladosBeanSwingJInternalFrame.jTtoolBarComprobantesAnulados.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionComprobantesAnulados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionComprobantesAnulados() {
		return this.resaltarfecha_emisionComprobantesAnulados;
	}

	public void setResaltarfecha_emisionComprobantesAnulados(Border borderResaltar) {
		this.resaltarfecha_emisionComprobantesAnulados= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionComprobantesAnulados() {
		return this.mostrarfecha_emisionComprobantesAnulados;
	}

	public void setMostrarfecha_emisionComprobantesAnulados(Boolean mostrarfecha_emisionComprobantesAnulados) {
		this.mostrarfecha_emisionComprobantesAnulados= mostrarfecha_emisionComprobantesAnulados;
	}

	public Boolean getActivarfecha_emisionComprobantesAnulados() {
		return this.activarfecha_emisionComprobantesAnulados;
	}

	public void setActivarfecha_emisionComprobantesAnulados(Boolean activarfecha_emisionComprobantesAnulados) {
		this.activarfecha_emisionComprobantesAnulados= activarfecha_emisionComprobantesAnulados;
	}

	public Border setResaltarcodigo_tipo_movimientoComprobantesAnulados(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobantesAnuladosBeanSwingJInternalFrame comprobantesanuladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantesanuladosBeanSwingJInternalFrame.jTtoolBarComprobantesAnulados.setBorder(borderResaltar);
		
		this.resaltarcodigo_tipo_movimientoComprobantesAnulados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_tipo_movimientoComprobantesAnulados() {
		return this.resaltarcodigo_tipo_movimientoComprobantesAnulados;
	}

	public void setResaltarcodigo_tipo_movimientoComprobantesAnulados(Border borderResaltar) {
		this.resaltarcodigo_tipo_movimientoComprobantesAnulados= borderResaltar;
	}

	public Boolean getMostrarcodigo_tipo_movimientoComprobantesAnulados() {
		return this.mostrarcodigo_tipo_movimientoComprobantesAnulados;
	}

	public void setMostrarcodigo_tipo_movimientoComprobantesAnulados(Boolean mostrarcodigo_tipo_movimientoComprobantesAnulados) {
		this.mostrarcodigo_tipo_movimientoComprobantesAnulados= mostrarcodigo_tipo_movimientoComprobantesAnulados;
	}

	public Boolean getActivarcodigo_tipo_movimientoComprobantesAnulados() {
		return this.activarcodigo_tipo_movimientoComprobantesAnulados;
	}

	public void setActivarcodigo_tipo_movimientoComprobantesAnulados(Boolean activarcodigo_tipo_movimientoComprobantesAnulados) {
		this.activarcodigo_tipo_movimientoComprobantesAnulados= activarcodigo_tipo_movimientoComprobantesAnulados;
	}

	public Border setResaltarnumero_mayor_datoComprobantesAnulados(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobantesAnuladosBeanSwingJInternalFrame comprobantesanuladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantesanuladosBeanSwingJInternalFrame.jTtoolBarComprobantesAnulados.setBorder(borderResaltar);
		
		this.resaltarnumero_mayor_datoComprobantesAnulados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_mayor_datoComprobantesAnulados() {
		return this.resaltarnumero_mayor_datoComprobantesAnulados;
	}

	public void setResaltarnumero_mayor_datoComprobantesAnulados(Border borderResaltar) {
		this.resaltarnumero_mayor_datoComprobantesAnulados= borderResaltar;
	}

	public Boolean getMostrarnumero_mayor_datoComprobantesAnulados() {
		return this.mostrarnumero_mayor_datoComprobantesAnulados;
	}

	public void setMostrarnumero_mayor_datoComprobantesAnulados(Boolean mostrarnumero_mayor_datoComprobantesAnulados) {
		this.mostrarnumero_mayor_datoComprobantesAnulados= mostrarnumero_mayor_datoComprobantesAnulados;
	}

	public Boolean getActivarnumero_mayor_datoComprobantesAnulados() {
		return this.activarnumero_mayor_datoComprobantesAnulados;
	}

	public void setActivarnumero_mayor_datoComprobantesAnulados(Boolean activarnumero_mayor_datoComprobantesAnulados) {
		this.activarnumero_mayor_datoComprobantesAnulados= activarnumero_mayor_datoComprobantesAnulados;
	}

	public Border setResaltarnombre_cuenta_contableComprobantesAnulados(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobantesAnuladosBeanSwingJInternalFrame comprobantesanuladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantesanuladosBeanSwingJInternalFrame.jTtoolBarComprobantesAnulados.setBorder(borderResaltar);
		
		this.resaltarnombre_cuenta_contableComprobantesAnulados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_cuenta_contableComprobantesAnulados() {
		return this.resaltarnombre_cuenta_contableComprobantesAnulados;
	}

	public void setResaltarnombre_cuenta_contableComprobantesAnulados(Border borderResaltar) {
		this.resaltarnombre_cuenta_contableComprobantesAnulados= borderResaltar;
	}

	public Boolean getMostrarnombre_cuenta_contableComprobantesAnulados() {
		return this.mostrarnombre_cuenta_contableComprobantesAnulados;
	}

	public void setMostrarnombre_cuenta_contableComprobantesAnulados(Boolean mostrarnombre_cuenta_contableComprobantesAnulados) {
		this.mostrarnombre_cuenta_contableComprobantesAnulados= mostrarnombre_cuenta_contableComprobantesAnulados;
	}

	public Boolean getActivarnombre_cuenta_contableComprobantesAnulados() {
		return this.activarnombre_cuenta_contableComprobantesAnulados;
	}

	public void setActivarnombre_cuenta_contableComprobantesAnulados(Boolean activarnombre_cuenta_contableComprobantesAnulados) {
		this.activarnombre_cuenta_contableComprobantesAnulados= activarnombre_cuenta_contableComprobantesAnulados;
	}

	public Border setResaltardebito_localComprobantesAnulados(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobantesAnuladosBeanSwingJInternalFrame comprobantesanuladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantesanuladosBeanSwingJInternalFrame.jTtoolBarComprobantesAnulados.setBorder(borderResaltar);
		
		this.resaltardebito_localComprobantesAnulados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardebito_localComprobantesAnulados() {
		return this.resaltardebito_localComprobantesAnulados;
	}

	public void setResaltardebito_localComprobantesAnulados(Border borderResaltar) {
		this.resaltardebito_localComprobantesAnulados= borderResaltar;
	}

	public Boolean getMostrardebito_localComprobantesAnulados() {
		return this.mostrardebito_localComprobantesAnulados;
	}

	public void setMostrardebito_localComprobantesAnulados(Boolean mostrardebito_localComprobantesAnulados) {
		this.mostrardebito_localComprobantesAnulados= mostrardebito_localComprobantesAnulados;
	}

	public Boolean getActivardebito_localComprobantesAnulados() {
		return this.activardebito_localComprobantesAnulados;
	}

	public void setActivardebito_localComprobantesAnulados(Boolean activardebito_localComprobantesAnulados) {
		this.activardebito_localComprobantesAnulados= activardebito_localComprobantesAnulados;
	}

	public Border setResaltarcredito_localComprobantesAnulados(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobantesAnuladosBeanSwingJInternalFrame comprobantesanuladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantesanuladosBeanSwingJInternalFrame.jTtoolBarComprobantesAnulados.setBorder(borderResaltar);
		
		this.resaltarcredito_localComprobantesAnulados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcredito_localComprobantesAnulados() {
		return this.resaltarcredito_localComprobantesAnulados;
	}

	public void setResaltarcredito_localComprobantesAnulados(Border borderResaltar) {
		this.resaltarcredito_localComprobantesAnulados= borderResaltar;
	}

	public Boolean getMostrarcredito_localComprobantesAnulados() {
		return this.mostrarcredito_localComprobantesAnulados;
	}

	public void setMostrarcredito_localComprobantesAnulados(Boolean mostrarcredito_localComprobantesAnulados) {
		this.mostrarcredito_localComprobantesAnulados= mostrarcredito_localComprobantesAnulados;
	}

	public Boolean getActivarcredito_localComprobantesAnulados() {
		return this.activarcredito_localComprobantesAnulados;
	}

	public void setActivarcredito_localComprobantesAnulados(Boolean activarcredito_localComprobantesAnulados) {
		this.activarcredito_localComprobantesAnulados= activarcredito_localComprobantesAnulados;
	}

	public Border setResaltarcodigo_cuenta_contableComprobantesAnulados(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobantesAnuladosBeanSwingJInternalFrame comprobantesanuladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantesanuladosBeanSwingJInternalFrame.jTtoolBarComprobantesAnulados.setBorder(borderResaltar);
		
		this.resaltarcodigo_cuenta_contableComprobantesAnulados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_cuenta_contableComprobantesAnulados() {
		return this.resaltarcodigo_cuenta_contableComprobantesAnulados;
	}

	public void setResaltarcodigo_cuenta_contableComprobantesAnulados(Border borderResaltar) {
		this.resaltarcodigo_cuenta_contableComprobantesAnulados= borderResaltar;
	}

	public Boolean getMostrarcodigo_cuenta_contableComprobantesAnulados() {
		return this.mostrarcodigo_cuenta_contableComprobantesAnulados;
	}

	public void setMostrarcodigo_cuenta_contableComprobantesAnulados(Boolean mostrarcodigo_cuenta_contableComprobantesAnulados) {
		this.mostrarcodigo_cuenta_contableComprobantesAnulados= mostrarcodigo_cuenta_contableComprobantesAnulados;
	}

	public Boolean getActivarcodigo_cuenta_contableComprobantesAnulados() {
		return this.activarcodigo_cuenta_contableComprobantesAnulados;
	}

	public void setActivarcodigo_cuenta_contableComprobantesAnulados(Boolean activarcodigo_cuenta_contableComprobantesAnulados) {
		this.activarcodigo_cuenta_contableComprobantesAnulados= activarcodigo_cuenta_contableComprobantesAnulados;
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
		
		
		this.setMostraridComprobantesAnulados(esInicial);
		this.setMostrarid_empresaComprobantesAnulados(esInicial);
		this.setMostrarid_sucursalComprobantesAnulados(esInicial);
		this.setMostrarid_ejercicioComprobantesAnulados(esInicial);
		this.setMostrarid_tipo_documentoComprobantesAnulados(esInicial);
		this.setMostrarid_tipo_movimientoComprobantesAnulados(esInicial);
		this.setMostrarnumero_mayorComprobantesAnulados(esInicial);
		this.setMostrarfecha_emision_desdeComprobantesAnulados(esInicial);
		this.setMostrarfecha_emision_hastaComprobantesAnulados(esInicial);
		this.setMostraruser_name_usuarioComprobantesAnulados(esInicial);
		this.setMostrarnombre_moduloComprobantesAnulados(esInicial);
		this.setMostrarcodigoComprobantesAnulados(esInicial);
		this.setMostrarbeneficiarioComprobantesAnulados(esInicial);
		this.setMostrardetalleComprobantesAnulados(esInicial);
		this.setMostrarfecha_emisionComprobantesAnulados(esInicial);
		this.setMostrarcodigo_tipo_movimientoComprobantesAnulados(esInicial);
		this.setMostrarnumero_mayor_datoComprobantesAnulados(esInicial);
		this.setMostrarnombre_cuenta_contableComprobantesAnulados(esInicial);
		this.setMostrardebito_localComprobantesAnulados(esInicial);
		this.setMostrarcredito_localComprobantesAnulados(esInicial);
		this.setMostrarcodigo_cuenta_contableComprobantesAnulados(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.ID)) {
				this.setMostraridComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.IDTIPODOCUMENTO)) {
				this.setMostrarid_tipo_documentoComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.IDTIPOMOVIMIENTO)) {
				this.setMostrarid_tipo_movimientoComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.NUMEROMAYOR)) {
				this.setMostrarnumero_mayorComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setMostrarfecha_emision_desdeComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setMostrarfecha_emision_hastaComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.USERNAMEUSUARIO)) {
				this.setMostraruser_name_usuarioComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.NOMBREMODULO)) {
				this.setMostrarnombre_moduloComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.BENEFICIARIO)) {
				this.setMostrarbeneficiarioComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.DETALLE)) {
				this.setMostrardetalleComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.CODIGOTIPOMOVIMIENTO)) {
				this.setMostrarcodigo_tipo_movimientoComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.NUMEROMAYORDATO)) {
				this.setMostrarnumero_mayor_datoComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.NOMBRECUENTACONTABLE)) {
				this.setMostrarnombre_cuenta_contableComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.DEBITOLOCAL)) {
				this.setMostrardebito_localComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.CREDITOLOCAL)) {
				this.setMostrarcredito_localComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.CODIGOCUENTACONTABLE)) {
				this.setMostrarcodigo_cuenta_contableComprobantesAnulados(esAsigna);
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
		
		
		this.setActivaridComprobantesAnulados(esInicial);
		this.setActivarid_empresaComprobantesAnulados(esInicial);
		this.setActivarid_sucursalComprobantesAnulados(esInicial);
		this.setActivarid_ejercicioComprobantesAnulados(esInicial);
		this.setActivarid_tipo_documentoComprobantesAnulados(esInicial);
		this.setActivarid_tipo_movimientoComprobantesAnulados(esInicial);
		this.setActivarnumero_mayorComprobantesAnulados(esInicial);
		this.setActivarfecha_emision_desdeComprobantesAnulados(esInicial);
		this.setActivarfecha_emision_hastaComprobantesAnulados(esInicial);
		this.setActivaruser_name_usuarioComprobantesAnulados(esInicial);
		this.setActivarnombre_moduloComprobantesAnulados(esInicial);
		this.setActivarcodigoComprobantesAnulados(esInicial);
		this.setActivarbeneficiarioComprobantesAnulados(esInicial);
		this.setActivardetalleComprobantesAnulados(esInicial);
		this.setActivarfecha_emisionComprobantesAnulados(esInicial);
		this.setActivarcodigo_tipo_movimientoComprobantesAnulados(esInicial);
		this.setActivarnumero_mayor_datoComprobantesAnulados(esInicial);
		this.setActivarnombre_cuenta_contableComprobantesAnulados(esInicial);
		this.setActivardebito_localComprobantesAnulados(esInicial);
		this.setActivarcredito_localComprobantesAnulados(esInicial);
		this.setActivarcodigo_cuenta_contableComprobantesAnulados(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.ID)) {
				this.setActivaridComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.IDTIPODOCUMENTO)) {
				this.setActivarid_tipo_documentoComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.IDTIPOMOVIMIENTO)) {
				this.setActivarid_tipo_movimientoComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.NUMEROMAYOR)) {
				this.setActivarnumero_mayorComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setActivarfecha_emision_desdeComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setActivarfecha_emision_hastaComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.USERNAMEUSUARIO)) {
				this.setActivaruser_name_usuarioComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.NOMBREMODULO)) {
				this.setActivarnombre_moduloComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.CODIGO)) {
				this.setActivarcodigoComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.BENEFICIARIO)) {
				this.setActivarbeneficiarioComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.DETALLE)) {
				this.setActivardetalleComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.CODIGOTIPOMOVIMIENTO)) {
				this.setActivarcodigo_tipo_movimientoComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.NUMEROMAYORDATO)) {
				this.setActivarnumero_mayor_datoComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.NOMBRECUENTACONTABLE)) {
				this.setActivarnombre_cuenta_contableComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.DEBITOLOCAL)) {
				this.setActivardebito_localComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.CREDITOLOCAL)) {
				this.setActivarcredito_localComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.CODIGOCUENTACONTABLE)) {
				this.setActivarcodigo_cuenta_contableComprobantesAnulados(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ComprobantesAnuladosBeanSwingJInternalFrame comprobantesanuladosBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridComprobantesAnulados(esInicial);
		this.setResaltarid_empresaComprobantesAnulados(esInicial);
		this.setResaltarid_sucursalComprobantesAnulados(esInicial);
		this.setResaltarid_ejercicioComprobantesAnulados(esInicial);
		this.setResaltarid_tipo_documentoComprobantesAnulados(esInicial);
		this.setResaltarid_tipo_movimientoComprobantesAnulados(esInicial);
		this.setResaltarnumero_mayorComprobantesAnulados(esInicial);
		this.setResaltarfecha_emision_desdeComprobantesAnulados(esInicial);
		this.setResaltarfecha_emision_hastaComprobantesAnulados(esInicial);
		this.setResaltaruser_name_usuarioComprobantesAnulados(esInicial);
		this.setResaltarnombre_moduloComprobantesAnulados(esInicial);
		this.setResaltarcodigoComprobantesAnulados(esInicial);
		this.setResaltarbeneficiarioComprobantesAnulados(esInicial);
		this.setResaltardetalleComprobantesAnulados(esInicial);
		this.setResaltarfecha_emisionComprobantesAnulados(esInicial);
		this.setResaltarcodigo_tipo_movimientoComprobantesAnulados(esInicial);
		this.setResaltarnumero_mayor_datoComprobantesAnulados(esInicial);
		this.setResaltarnombre_cuenta_contableComprobantesAnulados(esInicial);
		this.setResaltardebito_localComprobantesAnulados(esInicial);
		this.setResaltarcredito_localComprobantesAnulados(esInicial);
		this.setResaltarcodigo_cuenta_contableComprobantesAnulados(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.ID)) {
				this.setResaltaridComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.IDTIPODOCUMENTO)) {
				this.setResaltarid_tipo_documentoComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.IDTIPOMOVIMIENTO)) {
				this.setResaltarid_tipo_movimientoComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.NUMEROMAYOR)) {
				this.setResaltarnumero_mayorComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setResaltarfecha_emision_desdeComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setResaltarfecha_emision_hastaComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.USERNAMEUSUARIO)) {
				this.setResaltaruser_name_usuarioComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.NOMBREMODULO)) {
				this.setResaltarnombre_moduloComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.BENEFICIARIO)) {
				this.setResaltarbeneficiarioComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.DETALLE)) {
				this.setResaltardetalleComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.CODIGOTIPOMOVIMIENTO)) {
				this.setResaltarcodigo_tipo_movimientoComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.NUMEROMAYORDATO)) {
				this.setResaltarnumero_mayor_datoComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.NOMBRECUENTACONTABLE)) {
				this.setResaltarnombre_cuenta_contableComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.DEBITOLOCAL)) {
				this.setResaltardebito_localComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.CREDITOLOCAL)) {
				this.setResaltarcredito_localComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.CODIGOCUENTACONTABLE)) {
				this.setResaltarcodigo_cuenta_contableComprobantesAnulados(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ComprobantesAnuladosBeanSwingJInternalFrame comprobantesanuladosBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaComprobantesAnuladosComprobantesAnulados=true;

	public Boolean getMostrarBusquedaComprobantesAnuladosComprobantesAnulados() {
		return this.mostrarBusquedaComprobantesAnuladosComprobantesAnulados;
	}

	public void setMostrarBusquedaComprobantesAnuladosComprobantesAnulados(Boolean visibilidadResaltar) {
		this.mostrarBusquedaComprobantesAnuladosComprobantesAnulados= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaComprobantesAnuladosComprobantesAnulados=true;

	public Boolean getActivarBusquedaComprobantesAnuladosComprobantesAnulados() {
		return this.activarBusquedaComprobantesAnuladosComprobantesAnulados;
	}

	public void setActivarBusquedaComprobantesAnuladosComprobantesAnulados(Boolean habilitarResaltar) {
		this.activarBusquedaComprobantesAnuladosComprobantesAnulados= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaComprobantesAnuladosComprobantesAnulados=null;

	public Border getResaltarBusquedaComprobantesAnuladosComprobantesAnulados() {
		return this.resaltarBusquedaComprobantesAnuladosComprobantesAnulados;
	}

	public void setResaltarBusquedaComprobantesAnuladosComprobantesAnulados(Border borderResaltar) {
		this.resaltarBusquedaComprobantesAnuladosComprobantesAnulados= borderResaltar;
	}

	public void setResaltarBusquedaComprobantesAnuladosComprobantesAnulados(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobantesAnuladosBeanSwingJInternalFrame comprobantesanuladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaComprobantesAnuladosComprobantesAnulados= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}