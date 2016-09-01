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


import com.bydan.erp.contabilidad.util.report.MayooresGeneralesConstantesFunciones;
import com.bydan.erp.contabilidad.util.report.MayooresGeneralesParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.report.MayooresGeneralesParameterGeneral;

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
final public class MayooresGeneralesConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="MayooresGenerales";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="MayooresGenerales"+MayooresGeneralesConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="MayooresGeneralesHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="MayooresGeneralesHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=MayooresGeneralesConstantesFunciones.SCHEMA+"_"+MayooresGeneralesConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/MayooresGeneralesHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=MayooresGeneralesConstantesFunciones.SCHEMA+"_"+MayooresGeneralesConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=MayooresGeneralesConstantesFunciones.SCHEMA+"_"+MayooresGeneralesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/MayooresGeneralesHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=MayooresGeneralesConstantesFunciones.SCHEMA+"_"+MayooresGeneralesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+MayooresGeneralesConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/MayooresGeneralesHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+MayooresGeneralesConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+MayooresGeneralesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/MayooresGeneralesHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+MayooresGeneralesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=MayooresGeneralesConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+MayooresGeneralesConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=MayooresGeneralesConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+MayooresGeneralesConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Mayores Generaleses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Mayores Generales";
	public static final String SCLASSWEBTITULO_LOWER="Mayoores Generales";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="MayooresGenerales";
	public static final String OBJECTNAME="mayooresgenerales";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="mayores_generales";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select mayooresgenerales from "+MayooresGeneralesConstantesFunciones.SPERSISTENCENAME+" mayooresgenerales";
	public static String QUERYSELECTNATIVE="select "+MayooresGeneralesConstantesFunciones.SCHEMA+"."+MayooresGeneralesConstantesFunciones.TABLENAME+".id,"+MayooresGeneralesConstantesFunciones.SCHEMA+"."+MayooresGeneralesConstantesFunciones.TABLENAME+".version_row,"+MayooresGeneralesConstantesFunciones.SCHEMA+"."+MayooresGeneralesConstantesFunciones.TABLENAME+".id_empresa,"+MayooresGeneralesConstantesFunciones.SCHEMA+"."+MayooresGeneralesConstantesFunciones.TABLENAME+".id_ejercicio,"+MayooresGeneralesConstantesFunciones.SCHEMA+"."+MayooresGeneralesConstantesFunciones.TABLENAME+".id_cuenta_contable,"+MayooresGeneralesConstantesFunciones.SCHEMA+"."+MayooresGeneralesConstantesFunciones.TABLENAME+".fecha_emision_desde,"+MayooresGeneralesConstantesFunciones.SCHEMA+"."+MayooresGeneralesConstantesFunciones.TABLENAME+".fecha_emision_hasta,"+MayooresGeneralesConstantesFunciones.SCHEMA+"."+MayooresGeneralesConstantesFunciones.TABLENAME+".nombre_sucursal,"+MayooresGeneralesConstantesFunciones.SCHEMA+"."+MayooresGeneralesConstantesFunciones.TABLENAME+".codigo,"+MayooresGeneralesConstantesFunciones.SCHEMA+"."+MayooresGeneralesConstantesFunciones.TABLENAME+".beneficiario,"+MayooresGeneralesConstantesFunciones.SCHEMA+"."+MayooresGeneralesConstantesFunciones.TABLENAME+".detalle,"+MayooresGeneralesConstantesFunciones.SCHEMA+"."+MayooresGeneralesConstantesFunciones.TABLENAME+".fecha_emision,"+MayooresGeneralesConstantesFunciones.SCHEMA+"."+MayooresGeneralesConstantesFunciones.TABLENAME+".codigo_tipo_movimiento,"+MayooresGeneralesConstantesFunciones.SCHEMA+"."+MayooresGeneralesConstantesFunciones.TABLENAME+".numero_mayor,"+MayooresGeneralesConstantesFunciones.SCHEMA+"."+MayooresGeneralesConstantesFunciones.TABLENAME+".nombre_cuenta_contable,"+MayooresGeneralesConstantesFunciones.SCHEMA+"."+MayooresGeneralesConstantesFunciones.TABLENAME+".debito_local,"+MayooresGeneralesConstantesFunciones.SCHEMA+"."+MayooresGeneralesConstantesFunciones.TABLENAME+".credito_local,"+MayooresGeneralesConstantesFunciones.SCHEMA+"."+MayooresGeneralesConstantesFunciones.TABLENAME+".detalle_detalle_asiento_contable,"+MayooresGeneralesConstantesFunciones.SCHEMA+"."+MayooresGeneralesConstantesFunciones.TABLENAME+".codigo_cuenta_contable,"+MayooresGeneralesConstantesFunciones.SCHEMA+"."+MayooresGeneralesConstantesFunciones.TABLENAME+".saldo from "+MayooresGeneralesConstantesFunciones.SCHEMA+"."+MayooresGeneralesConstantesFunciones.TABLENAME;//+" as "+MayooresGeneralesConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDCUENTACONTABLE= "id_cuenta_contable";
    public static final String FECHAEMISIONDESDE= "fecha_emision_desde";
    public static final String FECHAEMISIONHASTA= "fecha_emision_hasta";
    public static final String NOMBRESUCURSAL= "nombre_sucursal";
    public static final String CODIGO= "codigo";
    public static final String BENEFICIARIO= "beneficiario";
    public static final String DETALLE= "detalle";
    public static final String FECHAEMISION= "fecha_emision";
    public static final String CODIGOTIPOMOVIMIENTO= "codigo_tipo_movimiento";
    public static final String NUMEROMAYOR= "numero_mayor";
    public static final String NOMBRECUENTACONTABLE= "nombre_cuenta_contable";
    public static final String DEBITOLOCAL= "debito_local";
    public static final String CREDITOLOCAL= "credito_local";
    public static final String DETALLEDETALLEASIENTOCONTABLE= "detalle_detalle_asiento_contable";
    public static final String CODIGOCUENTACONTABLE= "codigo_cuenta_contable";
    public static final String SALDO= "saldo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_IDCUENTACONTABLE= "Cuenta Contable";
		public static final String LABEL_IDCUENTACONTABLE_LOWER= "Cuenta Contable";
    	public static final String LABEL_FECHAEMISIONDESDE= "Fecha Emision Desde";
		public static final String LABEL_FECHAEMISIONDESDE_LOWER= "Fecha Emision Desde";
    	public static final String LABEL_FECHAEMISIONHASTA= "Fecha Emision Hasta";
		public static final String LABEL_FECHAEMISIONHASTA_LOWER= "Fecha Emision Hasta";
    	public static final String LABEL_NOMBRESUCURSAL= "Nombre Sucursal";
		public static final String LABEL_NOMBRESUCURSAL_LOWER= "Nombre Sucursal";
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
    	public static final String LABEL_NUMEROMAYOR= "Numero Mayor";
		public static final String LABEL_NUMEROMAYOR_LOWER= "Numero Mayor";
    	public static final String LABEL_NOMBRECUENTACONTABLE= "Nombre Cuenta Contable";
		public static final String LABEL_NOMBRECUENTACONTABLE_LOWER= "Nombre Cuenta Contable";
    	public static final String LABEL_DEBITOLOCAL= "Debito Local";
		public static final String LABEL_DEBITOLOCAL_LOWER= "Debito Local";
    	public static final String LABEL_CREDITOLOCAL= "Credito Local";
		public static final String LABEL_CREDITOLOCAL_LOWER= "Credito Local";
    	public static final String LABEL_DETALLEDETALLEASIENTOCONTABLE= "Detalle Detalle Asiento Contable";
		public static final String LABEL_DETALLEDETALLEASIENTOCONTABLE_LOWER= "Detalle Detalle Asiento Contable";
    	public static final String LABEL_CODIGOCUENTACONTABLE= "Codigo Cuenta Contable";
		public static final String LABEL_CODIGOCUENTACONTABLE_LOWER= "Codigo Cuenta Contable";
    	public static final String LABEL_SALDO= "Saldo";
		public static final String LABEL_SALDO_LOWER= "Saldo";
	
		
		
		
		
		
		
		
	public static final String SREGEXNOMBRE_SUCURSAL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_SUCURSAL=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXBENEFICIARIO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXBENEFICIARIO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDETALLE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDETALLE=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXCODIGO_TIPO_MOVIMIENTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_TIPO_MOVIMIENTO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_MAYOR=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_MAYOR=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_CUENTA_CONTABLE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_CUENTA_CONTABLE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXDETALLE_DETALLE_ASIENTO_CONTABLE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDETALLE_DETALLE_ASIENTO_CONTABLE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO_CUENTA_CONTABLE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_CUENTA_CONTABLE=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getMayooresGeneralesLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(MayooresGeneralesConstantesFunciones.IDEMPRESA)) {sLabelColumna=MayooresGeneralesConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(MayooresGeneralesConstantesFunciones.IDEJERCICIO)) {sLabelColumna=MayooresGeneralesConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(MayooresGeneralesConstantesFunciones.IDCUENTACONTABLE)) {sLabelColumna=MayooresGeneralesConstantesFunciones.LABEL_IDCUENTACONTABLE;}
		if(sNombreColumna.equals(MayooresGeneralesConstantesFunciones.FECHAEMISIONDESDE)) {sLabelColumna=MayooresGeneralesConstantesFunciones.LABEL_FECHAEMISIONDESDE;}
		if(sNombreColumna.equals(MayooresGeneralesConstantesFunciones.FECHAEMISIONHASTA)) {sLabelColumna=MayooresGeneralesConstantesFunciones.LABEL_FECHAEMISIONHASTA;}
		if(sNombreColumna.equals(MayooresGeneralesConstantesFunciones.NOMBRESUCURSAL)) {sLabelColumna=MayooresGeneralesConstantesFunciones.LABEL_NOMBRESUCURSAL;}
		if(sNombreColumna.equals(MayooresGeneralesConstantesFunciones.CODIGO)) {sLabelColumna=MayooresGeneralesConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(MayooresGeneralesConstantesFunciones.BENEFICIARIO)) {sLabelColumna=MayooresGeneralesConstantesFunciones.LABEL_BENEFICIARIO;}
		if(sNombreColumna.equals(MayooresGeneralesConstantesFunciones.DETALLE)) {sLabelColumna=MayooresGeneralesConstantesFunciones.LABEL_DETALLE;}
		if(sNombreColumna.equals(MayooresGeneralesConstantesFunciones.FECHAEMISION)) {sLabelColumna=MayooresGeneralesConstantesFunciones.LABEL_FECHAEMISION;}
		if(sNombreColumna.equals(MayooresGeneralesConstantesFunciones.CODIGOTIPOMOVIMIENTO)) {sLabelColumna=MayooresGeneralesConstantesFunciones.LABEL_CODIGOTIPOMOVIMIENTO;}
		if(sNombreColumna.equals(MayooresGeneralesConstantesFunciones.NUMEROMAYOR)) {sLabelColumna=MayooresGeneralesConstantesFunciones.LABEL_NUMEROMAYOR;}
		if(sNombreColumna.equals(MayooresGeneralesConstantesFunciones.NOMBRECUENTACONTABLE)) {sLabelColumna=MayooresGeneralesConstantesFunciones.LABEL_NOMBRECUENTACONTABLE;}
		if(sNombreColumna.equals(MayooresGeneralesConstantesFunciones.DEBITOLOCAL)) {sLabelColumna=MayooresGeneralesConstantesFunciones.LABEL_DEBITOLOCAL;}
		if(sNombreColumna.equals(MayooresGeneralesConstantesFunciones.CREDITOLOCAL)) {sLabelColumna=MayooresGeneralesConstantesFunciones.LABEL_CREDITOLOCAL;}
		if(sNombreColumna.equals(MayooresGeneralesConstantesFunciones.DETALLEDETALLEASIENTOCONTABLE)) {sLabelColumna=MayooresGeneralesConstantesFunciones.LABEL_DETALLEDETALLEASIENTOCONTABLE;}
		if(sNombreColumna.equals(MayooresGeneralesConstantesFunciones.CODIGOCUENTACONTABLE)) {sLabelColumna=MayooresGeneralesConstantesFunciones.LABEL_CODIGOCUENTACONTABLE;}
		if(sNombreColumna.equals(MayooresGeneralesConstantesFunciones.SALDO)) {sLabelColumna=MayooresGeneralesConstantesFunciones.LABEL_SALDO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getMayooresGeneralesDescripcion(MayooresGenerales mayooresgenerales) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(mayooresgenerales !=null/* && mayooresgenerales.getId()!=0*/) {
			sDescripcion=mayooresgenerales.getcodigo();//mayooresgeneralesmayooresgenerales.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getMayooresGeneralesDescripcionDetallado(MayooresGenerales mayooresgenerales) {
		String sDescripcion="";
			
		sDescripcion+=MayooresGeneralesConstantesFunciones.ID+"=";
		sDescripcion+=mayooresgenerales.getId().toString()+",";
		sDescripcion+=MayooresGeneralesConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=mayooresgenerales.getVersionRow().toString()+",";
		sDescripcion+=MayooresGeneralesConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=mayooresgenerales.getid_empresa().toString()+",";
		sDescripcion+=MayooresGeneralesConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=mayooresgenerales.getid_ejercicio().toString()+",";
		sDescripcion+=MayooresGeneralesConstantesFunciones.IDCUENTACONTABLE+"=";
		sDescripcion+=mayooresgenerales.getid_cuenta_contable().toString()+",";
		sDescripcion+=MayooresGeneralesConstantesFunciones.FECHAEMISIONDESDE+"=";
		sDescripcion+=mayooresgenerales.getfecha_emision_desde().toString()+",";
		sDescripcion+=MayooresGeneralesConstantesFunciones.FECHAEMISIONHASTA+"=";
		sDescripcion+=mayooresgenerales.getfecha_emision_hasta().toString()+",";
		sDescripcion+=MayooresGeneralesConstantesFunciones.NOMBRESUCURSAL+"=";
		sDescripcion+=mayooresgenerales.getnombre_sucursal()+",";
		sDescripcion+=MayooresGeneralesConstantesFunciones.CODIGO+"=";
		sDescripcion+=mayooresgenerales.getcodigo()+",";
		sDescripcion+=MayooresGeneralesConstantesFunciones.BENEFICIARIO+"=";
		sDescripcion+=mayooresgenerales.getbeneficiario()+",";
		sDescripcion+=MayooresGeneralesConstantesFunciones.DETALLE+"=";
		sDescripcion+=mayooresgenerales.getdetalle()+",";
		sDescripcion+=MayooresGeneralesConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=mayooresgenerales.getfecha_emision().toString()+",";
		sDescripcion+=MayooresGeneralesConstantesFunciones.CODIGOTIPOMOVIMIENTO+"=";
		sDescripcion+=mayooresgenerales.getcodigo_tipo_movimiento()+",";
		sDescripcion+=MayooresGeneralesConstantesFunciones.NUMEROMAYOR+"=";
		sDescripcion+=mayooresgenerales.getnumero_mayor()+",";
		sDescripcion+=MayooresGeneralesConstantesFunciones.NOMBRECUENTACONTABLE+"=";
		sDescripcion+=mayooresgenerales.getnombre_cuenta_contable()+",";
		sDescripcion+=MayooresGeneralesConstantesFunciones.DEBITOLOCAL+"=";
		sDescripcion+=mayooresgenerales.getdebito_local().toString()+",";
		sDescripcion+=MayooresGeneralesConstantesFunciones.CREDITOLOCAL+"=";
		sDescripcion+=mayooresgenerales.getcredito_local().toString()+",";
		sDescripcion+=MayooresGeneralesConstantesFunciones.DETALLEDETALLEASIENTOCONTABLE+"=";
		sDescripcion+=mayooresgenerales.getdetalle_detalle_asiento_contable()+",";
		sDescripcion+=MayooresGeneralesConstantesFunciones.CODIGOCUENTACONTABLE+"=";
		sDescripcion+=mayooresgenerales.getcodigo_cuenta_contable()+",";
		sDescripcion+=MayooresGeneralesConstantesFunciones.SALDO+"=";
		sDescripcion+=mayooresgenerales.getsaldo().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setMayooresGeneralesDescripcion(MayooresGenerales mayooresgenerales,String sValor) throws Exception {			
		if(mayooresgenerales !=null) {
			mayooresgenerales.setcodigo(sValor);;//mayooresgeneralesmayooresgenerales.getcodigo().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
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

	public static String getCuentaContableDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaMayooresGenerales")) {
			sNombreIndice="Tipo=  Por Ejercicio Por Cuenta Contable Por Fecha Emision Desde Por Fecha Emision Hasta";
		} else if(sNombreIndice.equals("FK_IdCuentaContable")) {
			sNombreIndice="Tipo=  Por Cuenta Contable";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaMayooresGenerales(Long id_ejercicio,Long id_cuenta_contable,Date fecha_emision_desde,Date fecha_emision_hasta) {
		String sDetalleIndice=" Parametros->";
		if(id_ejercicio!=null) {sDetalleIndice+=" Codigo Unico De Ejercicio="+id_ejercicio.toString();}
		if(id_cuenta_contable!=null) {sDetalleIndice+=" Codigo Unico De Cuenta Contable="+id_cuenta_contable.toString();}
		if(fecha_emision_desde!=null) {sDetalleIndice+=" Fecha Emision Desde="+fecha_emision_desde.toString();}
		if(fecha_emision_hasta!=null) {sDetalleIndice+=" Fecha Emision Hasta="+fecha_emision_hasta.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContable(Long id_cuenta_contable) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable!=null) {sDetalleIndice+=" Codigo Unico De Cuenta Contable="+id_cuenta_contable.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosMayooresGenerales(MayooresGenerales mayooresgenerales,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		mayooresgenerales.setnombre_sucursal(mayooresgenerales.getnombre_sucursal().trim());
		mayooresgenerales.setcodigo(mayooresgenerales.getcodigo().trim());
		mayooresgenerales.setbeneficiario(mayooresgenerales.getbeneficiario().trim());
		mayooresgenerales.setdetalle(mayooresgenerales.getdetalle().trim());
		mayooresgenerales.setcodigo_tipo_movimiento(mayooresgenerales.getcodigo_tipo_movimiento().trim());
		mayooresgenerales.setnumero_mayor(mayooresgenerales.getnumero_mayor().trim());
		mayooresgenerales.setnombre_cuenta_contable(mayooresgenerales.getnombre_cuenta_contable().trim());
		mayooresgenerales.setdetalle_detalle_asiento_contable(mayooresgenerales.getdetalle_detalle_asiento_contable().trim());
		mayooresgenerales.setcodigo_cuenta_contable(mayooresgenerales.getcodigo_cuenta_contable().trim());
	}
	
	public static void quitarEspaciosMayooresGeneraless(List<MayooresGenerales> mayooresgeneraless,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(MayooresGenerales mayooresgenerales: mayooresgeneraless) {
			mayooresgenerales.setnombre_sucursal(mayooresgenerales.getnombre_sucursal().trim());
			mayooresgenerales.setcodigo(mayooresgenerales.getcodigo().trim());
			mayooresgenerales.setbeneficiario(mayooresgenerales.getbeneficiario().trim());
			mayooresgenerales.setdetalle(mayooresgenerales.getdetalle().trim());
			mayooresgenerales.setcodigo_tipo_movimiento(mayooresgenerales.getcodigo_tipo_movimiento().trim());
			mayooresgenerales.setnumero_mayor(mayooresgenerales.getnumero_mayor().trim());
			mayooresgenerales.setnombre_cuenta_contable(mayooresgenerales.getnombre_cuenta_contable().trim());
			mayooresgenerales.setdetalle_detalle_asiento_contable(mayooresgenerales.getdetalle_detalle_asiento_contable().trim());
			mayooresgenerales.setcodigo_cuenta_contable(mayooresgenerales.getcodigo_cuenta_contable().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresMayooresGenerales(MayooresGenerales mayooresgenerales,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && mayooresgenerales.getConCambioAuxiliar()) {
			mayooresgenerales.setIsDeleted(mayooresgenerales.getIsDeletedAuxiliar());	
			mayooresgenerales.setIsNew(mayooresgenerales.getIsNewAuxiliar());	
			mayooresgenerales.setIsChanged(mayooresgenerales.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			mayooresgenerales.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			mayooresgenerales.setIsDeletedAuxiliar(false);	
			mayooresgenerales.setIsNewAuxiliar(false);	
			mayooresgenerales.setIsChangedAuxiliar(false);
			
			mayooresgenerales.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresMayooresGeneraless(List<MayooresGenerales> mayooresgeneraless,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(MayooresGenerales mayooresgenerales : mayooresgeneraless) {
			if(conAsignarBase && mayooresgenerales.getConCambioAuxiliar()) {
				mayooresgenerales.setIsDeleted(mayooresgenerales.getIsDeletedAuxiliar());	
				mayooresgenerales.setIsNew(mayooresgenerales.getIsNewAuxiliar());	
				mayooresgenerales.setIsChanged(mayooresgenerales.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				mayooresgenerales.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				mayooresgenerales.setIsDeletedAuxiliar(false);	
				mayooresgenerales.setIsNewAuxiliar(false);	
				mayooresgenerales.setIsChangedAuxiliar(false);
				
				mayooresgenerales.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresMayooresGenerales(MayooresGenerales mayooresgenerales,Boolean conEnteros) throws Exception  {
		mayooresgenerales.setdebito_local(0.0);
		mayooresgenerales.setcredito_local(0.0);
		mayooresgenerales.setsaldo(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresMayooresGeneraless(List<MayooresGenerales> mayooresgeneraless,Boolean conEnteros) throws Exception  {
		
		for(MayooresGenerales mayooresgenerales: mayooresgeneraless) {
			mayooresgenerales.setdebito_local(0.0);
			mayooresgenerales.setcredito_local(0.0);
			mayooresgenerales.setsaldo(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaMayooresGenerales(List<MayooresGenerales> mayooresgeneraless,MayooresGenerales mayooresgeneralesAux) throws Exception  {
		MayooresGeneralesConstantesFunciones.InicializarValoresMayooresGenerales(mayooresgeneralesAux,true);
		
		for(MayooresGenerales mayooresgenerales: mayooresgeneraless) {
			if(mayooresgenerales.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			mayooresgeneralesAux.setdebito_local(mayooresgeneralesAux.getdebito_local()+mayooresgenerales.getdebito_local());			
			mayooresgeneralesAux.setcredito_local(mayooresgeneralesAux.getcredito_local()+mayooresgenerales.getcredito_local());			
			mayooresgeneralesAux.setsaldo(mayooresgeneralesAux.getsaldo()+mayooresgenerales.getsaldo());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesMayooresGenerales(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=MayooresGeneralesConstantesFunciones.getArrayColumnasGlobalesMayooresGenerales(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesMayooresGenerales(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(MayooresGeneralesConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(MayooresGeneralesConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(MayooresGeneralesConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(MayooresGeneralesConstantesFunciones.IDEJERCICIO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoMayooresGenerales(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<MayooresGenerales> mayooresgeneraless,MayooresGenerales mayooresgenerales,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(MayooresGenerales mayooresgeneralesAux: mayooresgeneraless) {
			if(mayooresgeneralesAux!=null && mayooresgenerales!=null) {
				if((mayooresgeneralesAux.getId()==null && mayooresgenerales.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(mayooresgeneralesAux.getId()!=null && mayooresgenerales.getId()!=null){
					if(mayooresgeneralesAux.getId().equals(mayooresgenerales.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaMayooresGenerales(List<MayooresGenerales> mayooresgeneraless) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double debito_localTotal=0.0;
		Double credito_localTotal=0.0;
		Double saldoTotal=0.0;
	
		for(MayooresGenerales mayooresgenerales: mayooresgeneraless) {			
			if(mayooresgenerales.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			debito_localTotal+=mayooresgenerales.getdebito_local();
			credito_localTotal+=mayooresgenerales.getcredito_local();
			saldoTotal+=mayooresgenerales.getsaldo();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(MayooresGeneralesConstantesFunciones.DEBITOLOCAL);
		datoGeneral.setsDescripcion(MayooresGeneralesConstantesFunciones.LABEL_DEBITOLOCAL);
		datoGeneral.setdValorDouble(debito_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(MayooresGeneralesConstantesFunciones.CREDITOLOCAL);
		datoGeneral.setsDescripcion(MayooresGeneralesConstantesFunciones.LABEL_CREDITOLOCAL);
		datoGeneral.setdValorDouble(credito_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(MayooresGeneralesConstantesFunciones.SALDO);
		datoGeneral.setsDescripcion(MayooresGeneralesConstantesFunciones.LABEL_SALDO);
		datoGeneral.setdValorDouble(saldoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaMayooresGenerales() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,MayooresGeneralesConstantesFunciones.LABEL_ID, MayooresGeneralesConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MayooresGeneralesConstantesFunciones.LABEL_VERSIONROW, MayooresGeneralesConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MayooresGeneralesConstantesFunciones.LABEL_NOMBRESUCURSAL, MayooresGeneralesConstantesFunciones.NOMBRESUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MayooresGeneralesConstantesFunciones.LABEL_CODIGO, MayooresGeneralesConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MayooresGeneralesConstantesFunciones.LABEL_BENEFICIARIO, MayooresGeneralesConstantesFunciones.BENEFICIARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MayooresGeneralesConstantesFunciones.LABEL_DETALLE, MayooresGeneralesConstantesFunciones.DETALLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MayooresGeneralesConstantesFunciones.LABEL_FECHAEMISION, MayooresGeneralesConstantesFunciones.FECHAEMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MayooresGeneralesConstantesFunciones.LABEL_CODIGOTIPOMOVIMIENTO, MayooresGeneralesConstantesFunciones.CODIGOTIPOMOVIMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MayooresGeneralesConstantesFunciones.LABEL_NUMEROMAYOR, MayooresGeneralesConstantesFunciones.NUMEROMAYOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MayooresGeneralesConstantesFunciones.LABEL_NOMBRECUENTACONTABLE, MayooresGeneralesConstantesFunciones.NOMBRECUENTACONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MayooresGeneralesConstantesFunciones.LABEL_DEBITOLOCAL, MayooresGeneralesConstantesFunciones.DEBITOLOCAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MayooresGeneralesConstantesFunciones.LABEL_CREDITOLOCAL, MayooresGeneralesConstantesFunciones.CREDITOLOCAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MayooresGeneralesConstantesFunciones.LABEL_DETALLEDETALLEASIENTOCONTABLE, MayooresGeneralesConstantesFunciones.DETALLEDETALLEASIENTOCONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MayooresGeneralesConstantesFunciones.LABEL_CODIGOCUENTACONTABLE, MayooresGeneralesConstantesFunciones.CODIGOCUENTACONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MayooresGeneralesConstantesFunciones.LABEL_SALDO, MayooresGeneralesConstantesFunciones.SALDO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasMayooresGenerales() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=MayooresGeneralesConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MayooresGeneralesConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MayooresGeneralesConstantesFunciones.NOMBRESUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MayooresGeneralesConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MayooresGeneralesConstantesFunciones.BENEFICIARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MayooresGeneralesConstantesFunciones.DETALLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MayooresGeneralesConstantesFunciones.FECHAEMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MayooresGeneralesConstantesFunciones.CODIGOTIPOMOVIMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MayooresGeneralesConstantesFunciones.NUMEROMAYOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MayooresGeneralesConstantesFunciones.NOMBRECUENTACONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MayooresGeneralesConstantesFunciones.DEBITOLOCAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MayooresGeneralesConstantesFunciones.CREDITOLOCAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MayooresGeneralesConstantesFunciones.DETALLEDETALLEASIENTOCONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MayooresGeneralesConstantesFunciones.CODIGOCUENTACONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MayooresGeneralesConstantesFunciones.SALDO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarMayooresGenerales() throws Exception  {
		return MayooresGeneralesConstantesFunciones.getTiposSeleccionarMayooresGenerales(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarMayooresGenerales(Boolean conFk) throws Exception  {
		return MayooresGeneralesConstantesFunciones.getTiposSeleccionarMayooresGenerales(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarMayooresGenerales(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(MayooresGeneralesConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(MayooresGeneralesConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(MayooresGeneralesConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(MayooresGeneralesConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(MayooresGeneralesConstantesFunciones.LABEL_IDCUENTACONTABLE);
			reporte.setsDescripcion(MayooresGeneralesConstantesFunciones.LABEL_IDCUENTACONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MayooresGeneralesConstantesFunciones.LABEL_FECHAEMISIONDESDE);
			reporte.setsDescripcion(MayooresGeneralesConstantesFunciones.LABEL_FECHAEMISIONDESDE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MayooresGeneralesConstantesFunciones.LABEL_FECHAEMISIONHASTA);
			reporte.setsDescripcion(MayooresGeneralesConstantesFunciones.LABEL_FECHAEMISIONHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MayooresGeneralesConstantesFunciones.LABEL_NOMBRESUCURSAL);
			reporte.setsDescripcion(MayooresGeneralesConstantesFunciones.LABEL_NOMBRESUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MayooresGeneralesConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(MayooresGeneralesConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MayooresGeneralesConstantesFunciones.LABEL_BENEFICIARIO);
			reporte.setsDescripcion(MayooresGeneralesConstantesFunciones.LABEL_BENEFICIARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MayooresGeneralesConstantesFunciones.LABEL_DETALLE);
			reporte.setsDescripcion(MayooresGeneralesConstantesFunciones.LABEL_DETALLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MayooresGeneralesConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(MayooresGeneralesConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MayooresGeneralesConstantesFunciones.LABEL_CODIGOTIPOMOVIMIENTO);
			reporte.setsDescripcion(MayooresGeneralesConstantesFunciones.LABEL_CODIGOTIPOMOVIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MayooresGeneralesConstantesFunciones.LABEL_NUMEROMAYOR);
			reporte.setsDescripcion(MayooresGeneralesConstantesFunciones.LABEL_NUMEROMAYOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MayooresGeneralesConstantesFunciones.LABEL_NOMBRECUENTACONTABLE);
			reporte.setsDescripcion(MayooresGeneralesConstantesFunciones.LABEL_NOMBRECUENTACONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MayooresGeneralesConstantesFunciones.LABEL_DEBITOLOCAL);
			reporte.setsDescripcion(MayooresGeneralesConstantesFunciones.LABEL_DEBITOLOCAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MayooresGeneralesConstantesFunciones.LABEL_CREDITOLOCAL);
			reporte.setsDescripcion(MayooresGeneralesConstantesFunciones.LABEL_CREDITOLOCAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MayooresGeneralesConstantesFunciones.LABEL_DETALLEDETALLEASIENTOCONTABLE);
			reporte.setsDescripcion(MayooresGeneralesConstantesFunciones.LABEL_DETALLEDETALLEASIENTOCONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MayooresGeneralesConstantesFunciones.LABEL_CODIGOCUENTACONTABLE);
			reporte.setsDescripcion(MayooresGeneralesConstantesFunciones.LABEL_CODIGOCUENTACONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MayooresGeneralesConstantesFunciones.LABEL_SALDO);
			reporte.setsDescripcion(MayooresGeneralesConstantesFunciones.LABEL_SALDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesMayooresGenerales(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesMayooresGenerales(MayooresGenerales mayooresgeneralesAux) throws Exception {
		
			mayooresgeneralesAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(mayooresgeneralesAux.getEmpresa()));
			mayooresgeneralesAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(mayooresgeneralesAux.getEjercicio()));
			mayooresgeneralesAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(mayooresgeneralesAux.getCuentaContable()));		
	}
	
	public static void refrescarForeignKeysDescripcionesMayooresGenerales(List<MayooresGenerales> mayooresgeneralessTemp) throws Exception {
		for(MayooresGenerales mayooresgeneralesAux:mayooresgeneralessTemp) {
			
			mayooresgeneralesAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(mayooresgeneralesAux.getEmpresa()));
			mayooresgeneralesAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(mayooresgeneralesAux.getEjercicio()));
			mayooresgeneralesAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(mayooresgeneralesAux.getCuentaContable()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfMayooresGenerales(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(CuentaContable.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Ejercicio.class)) {
						classes.add(new Classe(Ejercicio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfMayooresGenerales(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfMayooresGenerales(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return MayooresGeneralesConstantesFunciones.getClassesRelationshipsOfMayooresGenerales(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfMayooresGenerales(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfMayooresGenerales(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return MayooresGeneralesConstantesFunciones.getClassesRelationshipsFromStringsOfMayooresGenerales(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfMayooresGenerales(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(MayooresGenerales mayooresgenerales,List<MayooresGenerales> mayooresgeneraless,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(MayooresGenerales mayooresgenerales,List<MayooresGenerales> mayooresgeneraless) throws Exception {
		try	{			
			for(MayooresGenerales mayooresgeneralesLocal:mayooresgeneraless) {
				if(mayooresgeneralesLocal.getId().equals(mayooresgenerales.getId())) {
					mayooresgeneralesLocal.setIsSelected(mayooresgenerales.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesMayooresGenerales(List<MayooresGenerales> mayooresgeneralessAux) throws Exception {
		//this.mayooresgeneralessAux=mayooresgeneralessAux;
		
		for(MayooresGenerales mayooresgeneralesAux:mayooresgeneralessAux) {
			if(mayooresgeneralesAux.getIsChanged()) {
				mayooresgeneralesAux.setIsChanged(false);
			}		
			
			if(mayooresgeneralesAux.getIsNew()) {
				mayooresgeneralesAux.setIsNew(false);
			}	
			
			if(mayooresgeneralesAux.getIsDeleted()) {
				mayooresgeneralesAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesMayooresGenerales(MayooresGenerales mayooresgeneralesAux) throws Exception {
		//this.mayooresgeneralesAux=mayooresgeneralesAux;
		
			if(mayooresgeneralesAux.getIsChanged()) {
				mayooresgeneralesAux.setIsChanged(false);
			}		
			
			if(mayooresgeneralesAux.getIsNew()) {
				mayooresgeneralesAux.setIsNew(false);
			}	
			
			if(mayooresgeneralesAux.getIsDeleted()) {
				mayooresgeneralesAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(MayooresGenerales mayooresgeneralesAsignar,MayooresGenerales mayooresgenerales) throws Exception {
		mayooresgeneralesAsignar.setId(mayooresgenerales.getId());	
		mayooresgeneralesAsignar.setVersionRow(mayooresgenerales.getVersionRow());	
		mayooresgeneralesAsignar.setnombre_sucursal(mayooresgenerales.getnombre_sucursal());	
		mayooresgeneralesAsignar.setcodigo(mayooresgenerales.getcodigo());	
		mayooresgeneralesAsignar.setbeneficiario(mayooresgenerales.getbeneficiario());	
		mayooresgeneralesAsignar.setdetalle(mayooresgenerales.getdetalle());	
		mayooresgeneralesAsignar.setfecha_emision(mayooresgenerales.getfecha_emision());	
		mayooresgeneralesAsignar.setcodigo_tipo_movimiento(mayooresgenerales.getcodigo_tipo_movimiento());	
		mayooresgeneralesAsignar.setnumero_mayor(mayooresgenerales.getnumero_mayor());	
		mayooresgeneralesAsignar.setnombre_cuenta_contable(mayooresgenerales.getnombre_cuenta_contable());	
		mayooresgeneralesAsignar.setdebito_local(mayooresgenerales.getdebito_local());	
		mayooresgeneralesAsignar.setcredito_local(mayooresgenerales.getcredito_local());	
		mayooresgeneralesAsignar.setdetalle_detalle_asiento_contable(mayooresgenerales.getdetalle_detalle_asiento_contable());	
		mayooresgeneralesAsignar.setcodigo_cuenta_contable(mayooresgenerales.getcodigo_cuenta_contable());	
		mayooresgeneralesAsignar.setsaldo(mayooresgenerales.getsaldo());	
	}
	
	public static void inicializarMayooresGenerales(MayooresGenerales mayooresgenerales) throws Exception {
		try {
				mayooresgenerales.setId(0L);	
					
				mayooresgenerales.setnombre_sucursal("");	
				mayooresgenerales.setcodigo("");	
				mayooresgenerales.setbeneficiario("");	
				mayooresgenerales.setdetalle("");	
				mayooresgenerales.setfecha_emision(new Date());	
				mayooresgenerales.setcodigo_tipo_movimiento("");	
				mayooresgenerales.setnumero_mayor("");	
				mayooresgenerales.setnombre_cuenta_contable("");	
				mayooresgenerales.setdebito_local(0.0);	
				mayooresgenerales.setcredito_local(0.0);	
				mayooresgenerales.setdetalle_detalle_asiento_contable("");	
				mayooresgenerales.setcodigo_cuenta_contable("");	
				mayooresgenerales.setsaldo(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderMayooresGenerales(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(MayooresGeneralesConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MayooresGeneralesConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MayooresGeneralesConstantesFunciones.LABEL_IDCUENTACONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MayooresGeneralesConstantesFunciones.LABEL_FECHAEMISIONDESDE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MayooresGeneralesConstantesFunciones.LABEL_FECHAEMISIONHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MayooresGeneralesConstantesFunciones.LABEL_NOMBRESUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MayooresGeneralesConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MayooresGeneralesConstantesFunciones.LABEL_BENEFICIARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MayooresGeneralesConstantesFunciones.LABEL_DETALLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MayooresGeneralesConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MayooresGeneralesConstantesFunciones.LABEL_CODIGOTIPOMOVIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MayooresGeneralesConstantesFunciones.LABEL_NUMEROMAYOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MayooresGeneralesConstantesFunciones.LABEL_NOMBRECUENTACONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MayooresGeneralesConstantesFunciones.LABEL_DEBITOLOCAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MayooresGeneralesConstantesFunciones.LABEL_CREDITOLOCAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MayooresGeneralesConstantesFunciones.LABEL_DETALLEDETALLEASIENTOCONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MayooresGeneralesConstantesFunciones.LABEL_CODIGOCUENTACONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MayooresGeneralesConstantesFunciones.LABEL_SALDO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataMayooresGenerales(String sTipo,Row row,Workbook workbook,MayooresGenerales mayooresgenerales,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(mayooresgenerales.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(mayooresgenerales.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(mayooresgenerales.getcuentacontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(mayooresgenerales.getfecha_emision_desde());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(mayooresgenerales.getfecha_emision_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(mayooresgenerales.getnombre_sucursal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(mayooresgenerales.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(mayooresgenerales.getbeneficiario());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(mayooresgenerales.getdetalle());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(mayooresgenerales.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(mayooresgenerales.getcodigo_tipo_movimiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(mayooresgenerales.getnumero_mayor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(mayooresgenerales.getnombre_cuenta_contable());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(mayooresgenerales.getdebito_local());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(mayooresgenerales.getcredito_local());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(mayooresgenerales.getdetalle_detalle_asiento_contable());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(mayooresgenerales.getcodigo_cuenta_contable());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(mayooresgenerales.getsaldo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryMayooresGenerales="";
	
	public String getsFinalQueryMayooresGenerales() {
		return this.sFinalQueryMayooresGenerales;
	}
	
	public void setsFinalQueryMayooresGenerales(String sFinalQueryMayooresGenerales) {
		this.sFinalQueryMayooresGenerales= sFinalQueryMayooresGenerales;
	}
	
	public Border resaltarSeleccionarMayooresGenerales=null;
	
	public Border setResaltarSeleccionarMayooresGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*MayooresGeneralesBeanSwingJInternalFrame mayooresgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//mayooresgeneralesBeanSwingJInternalFrame.jTtoolBarMayooresGenerales.setBorder(borderResaltar);
		
		this.resaltarSeleccionarMayooresGenerales= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarMayooresGenerales() {
		return this.resaltarSeleccionarMayooresGenerales;
	}
	
	public void setResaltarSeleccionarMayooresGenerales(Border borderResaltarSeleccionarMayooresGenerales) {
		this.resaltarSeleccionarMayooresGenerales= borderResaltarSeleccionarMayooresGenerales;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridMayooresGenerales=null;
	public Boolean mostraridMayooresGenerales=true;
	public Boolean activaridMayooresGenerales=true;

	public Border resaltarid_empresaMayooresGenerales=null;
	public Boolean mostrarid_empresaMayooresGenerales=true;
	public Boolean activarid_empresaMayooresGenerales=true;
	public Boolean cargarid_empresaMayooresGenerales=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaMayooresGenerales=false;//ConEventDepend=true

	public Border resaltarid_ejercicioMayooresGenerales=null;
	public Boolean mostrarid_ejercicioMayooresGenerales=true;
	public Boolean activarid_ejercicioMayooresGenerales=true;
	public Boolean cargarid_ejercicioMayooresGenerales=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioMayooresGenerales=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contableMayooresGenerales=null;
	public Boolean mostrarid_cuenta_contableMayooresGenerales=true;
	public Boolean activarid_cuenta_contableMayooresGenerales=true;
	public Boolean cargarid_cuenta_contableMayooresGenerales=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contableMayooresGenerales=false;//ConEventDepend=true

	public Border resaltarfecha_emision_desdeMayooresGenerales=null;
	public Boolean mostrarfecha_emision_desdeMayooresGenerales=true;
	public Boolean activarfecha_emision_desdeMayooresGenerales=true;

	public Border resaltarfecha_emision_hastaMayooresGenerales=null;
	public Boolean mostrarfecha_emision_hastaMayooresGenerales=true;
	public Boolean activarfecha_emision_hastaMayooresGenerales=true;

	public Border resaltarnombre_sucursalMayooresGenerales=null;
	public Boolean mostrarnombre_sucursalMayooresGenerales=true;
	public Boolean activarnombre_sucursalMayooresGenerales=true;

	public Border resaltarcodigoMayooresGenerales=null;
	public Boolean mostrarcodigoMayooresGenerales=true;
	public Boolean activarcodigoMayooresGenerales=true;

	public Border resaltarbeneficiarioMayooresGenerales=null;
	public Boolean mostrarbeneficiarioMayooresGenerales=true;
	public Boolean activarbeneficiarioMayooresGenerales=true;

	public Border resaltardetalleMayooresGenerales=null;
	public Boolean mostrardetalleMayooresGenerales=true;
	public Boolean activardetalleMayooresGenerales=true;

	public Border resaltarfecha_emisionMayooresGenerales=null;
	public Boolean mostrarfecha_emisionMayooresGenerales=true;
	public Boolean activarfecha_emisionMayooresGenerales=true;

	public Border resaltarcodigo_tipo_movimientoMayooresGenerales=null;
	public Boolean mostrarcodigo_tipo_movimientoMayooresGenerales=true;
	public Boolean activarcodigo_tipo_movimientoMayooresGenerales=true;

	public Border resaltarnumero_mayorMayooresGenerales=null;
	public Boolean mostrarnumero_mayorMayooresGenerales=true;
	public Boolean activarnumero_mayorMayooresGenerales=true;

	public Border resaltarnombre_cuenta_contableMayooresGenerales=null;
	public Boolean mostrarnombre_cuenta_contableMayooresGenerales=true;
	public Boolean activarnombre_cuenta_contableMayooresGenerales=true;

	public Border resaltardebito_localMayooresGenerales=null;
	public Boolean mostrardebito_localMayooresGenerales=true;
	public Boolean activardebito_localMayooresGenerales=true;

	public Border resaltarcredito_localMayooresGenerales=null;
	public Boolean mostrarcredito_localMayooresGenerales=true;
	public Boolean activarcredito_localMayooresGenerales=true;

	public Border resaltardetalle_detalle_asiento_contableMayooresGenerales=null;
	public Boolean mostrardetalle_detalle_asiento_contableMayooresGenerales=true;
	public Boolean activardetalle_detalle_asiento_contableMayooresGenerales=true;

	public Border resaltarcodigo_cuenta_contableMayooresGenerales=null;
	public Boolean mostrarcodigo_cuenta_contableMayooresGenerales=true;
	public Boolean activarcodigo_cuenta_contableMayooresGenerales=true;

	public Border resaltarsaldoMayooresGenerales=null;
	public Boolean mostrarsaldoMayooresGenerales=true;
	public Boolean activarsaldoMayooresGenerales=true;

	
	

	public Border setResaltaridMayooresGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*MayooresGeneralesBeanSwingJInternalFrame mayooresgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//mayooresgeneralesBeanSwingJInternalFrame.jTtoolBarMayooresGenerales.setBorder(borderResaltar);
		
		this.resaltaridMayooresGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridMayooresGenerales() {
		return this.resaltaridMayooresGenerales;
	}

	public void setResaltaridMayooresGenerales(Border borderResaltar) {
		this.resaltaridMayooresGenerales= borderResaltar;
	}

	public Boolean getMostraridMayooresGenerales() {
		return this.mostraridMayooresGenerales;
	}

	public void setMostraridMayooresGenerales(Boolean mostraridMayooresGenerales) {
		this.mostraridMayooresGenerales= mostraridMayooresGenerales;
	}

	public Boolean getActivaridMayooresGenerales() {
		return this.activaridMayooresGenerales;
	}

	public void setActivaridMayooresGenerales(Boolean activaridMayooresGenerales) {
		this.activaridMayooresGenerales= activaridMayooresGenerales;
	}

	public Border setResaltarid_empresaMayooresGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*MayooresGeneralesBeanSwingJInternalFrame mayooresgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//mayooresgeneralesBeanSwingJInternalFrame.jTtoolBarMayooresGenerales.setBorder(borderResaltar);
		
		this.resaltarid_empresaMayooresGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaMayooresGenerales() {
		return this.resaltarid_empresaMayooresGenerales;
	}

	public void setResaltarid_empresaMayooresGenerales(Border borderResaltar) {
		this.resaltarid_empresaMayooresGenerales= borderResaltar;
	}

	public Boolean getMostrarid_empresaMayooresGenerales() {
		return this.mostrarid_empresaMayooresGenerales;
	}

	public void setMostrarid_empresaMayooresGenerales(Boolean mostrarid_empresaMayooresGenerales) {
		this.mostrarid_empresaMayooresGenerales= mostrarid_empresaMayooresGenerales;
	}

	public Boolean getActivarid_empresaMayooresGenerales() {
		return this.activarid_empresaMayooresGenerales;
	}

	public void setActivarid_empresaMayooresGenerales(Boolean activarid_empresaMayooresGenerales) {
		this.activarid_empresaMayooresGenerales= activarid_empresaMayooresGenerales;
	}

	public Boolean getCargarid_empresaMayooresGenerales() {
		return this.cargarid_empresaMayooresGenerales;
	}

	public void setCargarid_empresaMayooresGenerales(Boolean cargarid_empresaMayooresGenerales) {
		this.cargarid_empresaMayooresGenerales= cargarid_empresaMayooresGenerales;
	}

	public Border setResaltarid_ejercicioMayooresGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*MayooresGeneralesBeanSwingJInternalFrame mayooresgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//mayooresgeneralesBeanSwingJInternalFrame.jTtoolBarMayooresGenerales.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioMayooresGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioMayooresGenerales() {
		return this.resaltarid_ejercicioMayooresGenerales;
	}

	public void setResaltarid_ejercicioMayooresGenerales(Border borderResaltar) {
		this.resaltarid_ejercicioMayooresGenerales= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioMayooresGenerales() {
		return this.mostrarid_ejercicioMayooresGenerales;
	}

	public void setMostrarid_ejercicioMayooresGenerales(Boolean mostrarid_ejercicioMayooresGenerales) {
		this.mostrarid_ejercicioMayooresGenerales= mostrarid_ejercicioMayooresGenerales;
	}

	public Boolean getActivarid_ejercicioMayooresGenerales() {
		return this.activarid_ejercicioMayooresGenerales;
	}

	public void setActivarid_ejercicioMayooresGenerales(Boolean activarid_ejercicioMayooresGenerales) {
		this.activarid_ejercicioMayooresGenerales= activarid_ejercicioMayooresGenerales;
	}

	public Boolean getCargarid_ejercicioMayooresGenerales() {
		return this.cargarid_ejercicioMayooresGenerales;
	}

	public void setCargarid_ejercicioMayooresGenerales(Boolean cargarid_ejercicioMayooresGenerales) {
		this.cargarid_ejercicioMayooresGenerales= cargarid_ejercicioMayooresGenerales;
	}

	public Border setResaltarid_cuenta_contableMayooresGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*MayooresGeneralesBeanSwingJInternalFrame mayooresgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//mayooresgeneralesBeanSwingJInternalFrame.jTtoolBarMayooresGenerales.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contableMayooresGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contableMayooresGenerales() {
		return this.resaltarid_cuenta_contableMayooresGenerales;
	}

	public void setResaltarid_cuenta_contableMayooresGenerales(Border borderResaltar) {
		this.resaltarid_cuenta_contableMayooresGenerales= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contableMayooresGenerales() {
		return this.mostrarid_cuenta_contableMayooresGenerales;
	}

	public void setMostrarid_cuenta_contableMayooresGenerales(Boolean mostrarid_cuenta_contableMayooresGenerales) {
		this.mostrarid_cuenta_contableMayooresGenerales= mostrarid_cuenta_contableMayooresGenerales;
	}

	public Boolean getActivarid_cuenta_contableMayooresGenerales() {
		return this.activarid_cuenta_contableMayooresGenerales;
	}

	public void setActivarid_cuenta_contableMayooresGenerales(Boolean activarid_cuenta_contableMayooresGenerales) {
		this.activarid_cuenta_contableMayooresGenerales= activarid_cuenta_contableMayooresGenerales;
	}

	public Boolean getCargarid_cuenta_contableMayooresGenerales() {
		return this.cargarid_cuenta_contableMayooresGenerales;
	}

	public void setCargarid_cuenta_contableMayooresGenerales(Boolean cargarid_cuenta_contableMayooresGenerales) {
		this.cargarid_cuenta_contableMayooresGenerales= cargarid_cuenta_contableMayooresGenerales;
	}

	public Border setResaltarfecha_emision_desdeMayooresGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*MayooresGeneralesBeanSwingJInternalFrame mayooresgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//mayooresgeneralesBeanSwingJInternalFrame.jTtoolBarMayooresGenerales.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_desdeMayooresGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_desdeMayooresGenerales() {
		return this.resaltarfecha_emision_desdeMayooresGenerales;
	}

	public void setResaltarfecha_emision_desdeMayooresGenerales(Border borderResaltar) {
		this.resaltarfecha_emision_desdeMayooresGenerales= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_desdeMayooresGenerales() {
		return this.mostrarfecha_emision_desdeMayooresGenerales;
	}

	public void setMostrarfecha_emision_desdeMayooresGenerales(Boolean mostrarfecha_emision_desdeMayooresGenerales) {
		this.mostrarfecha_emision_desdeMayooresGenerales= mostrarfecha_emision_desdeMayooresGenerales;
	}

	public Boolean getActivarfecha_emision_desdeMayooresGenerales() {
		return this.activarfecha_emision_desdeMayooresGenerales;
	}

	public void setActivarfecha_emision_desdeMayooresGenerales(Boolean activarfecha_emision_desdeMayooresGenerales) {
		this.activarfecha_emision_desdeMayooresGenerales= activarfecha_emision_desdeMayooresGenerales;
	}

	public Border setResaltarfecha_emision_hastaMayooresGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*MayooresGeneralesBeanSwingJInternalFrame mayooresgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//mayooresgeneralesBeanSwingJInternalFrame.jTtoolBarMayooresGenerales.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_hastaMayooresGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_hastaMayooresGenerales() {
		return this.resaltarfecha_emision_hastaMayooresGenerales;
	}

	public void setResaltarfecha_emision_hastaMayooresGenerales(Border borderResaltar) {
		this.resaltarfecha_emision_hastaMayooresGenerales= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_hastaMayooresGenerales() {
		return this.mostrarfecha_emision_hastaMayooresGenerales;
	}

	public void setMostrarfecha_emision_hastaMayooresGenerales(Boolean mostrarfecha_emision_hastaMayooresGenerales) {
		this.mostrarfecha_emision_hastaMayooresGenerales= mostrarfecha_emision_hastaMayooresGenerales;
	}

	public Boolean getActivarfecha_emision_hastaMayooresGenerales() {
		return this.activarfecha_emision_hastaMayooresGenerales;
	}

	public void setActivarfecha_emision_hastaMayooresGenerales(Boolean activarfecha_emision_hastaMayooresGenerales) {
		this.activarfecha_emision_hastaMayooresGenerales= activarfecha_emision_hastaMayooresGenerales;
	}

	public Border setResaltarnombre_sucursalMayooresGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*MayooresGeneralesBeanSwingJInternalFrame mayooresgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//mayooresgeneralesBeanSwingJInternalFrame.jTtoolBarMayooresGenerales.setBorder(borderResaltar);
		
		this.resaltarnombre_sucursalMayooresGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_sucursalMayooresGenerales() {
		return this.resaltarnombre_sucursalMayooresGenerales;
	}

	public void setResaltarnombre_sucursalMayooresGenerales(Border borderResaltar) {
		this.resaltarnombre_sucursalMayooresGenerales= borderResaltar;
	}

	public Boolean getMostrarnombre_sucursalMayooresGenerales() {
		return this.mostrarnombre_sucursalMayooresGenerales;
	}

	public void setMostrarnombre_sucursalMayooresGenerales(Boolean mostrarnombre_sucursalMayooresGenerales) {
		this.mostrarnombre_sucursalMayooresGenerales= mostrarnombre_sucursalMayooresGenerales;
	}

	public Boolean getActivarnombre_sucursalMayooresGenerales() {
		return this.activarnombre_sucursalMayooresGenerales;
	}

	public void setActivarnombre_sucursalMayooresGenerales(Boolean activarnombre_sucursalMayooresGenerales) {
		this.activarnombre_sucursalMayooresGenerales= activarnombre_sucursalMayooresGenerales;
	}

	public Border setResaltarcodigoMayooresGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*MayooresGeneralesBeanSwingJInternalFrame mayooresgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//mayooresgeneralesBeanSwingJInternalFrame.jTtoolBarMayooresGenerales.setBorder(borderResaltar);
		
		this.resaltarcodigoMayooresGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoMayooresGenerales() {
		return this.resaltarcodigoMayooresGenerales;
	}

	public void setResaltarcodigoMayooresGenerales(Border borderResaltar) {
		this.resaltarcodigoMayooresGenerales= borderResaltar;
	}

	public Boolean getMostrarcodigoMayooresGenerales() {
		return this.mostrarcodigoMayooresGenerales;
	}

	public void setMostrarcodigoMayooresGenerales(Boolean mostrarcodigoMayooresGenerales) {
		this.mostrarcodigoMayooresGenerales= mostrarcodigoMayooresGenerales;
	}

	public Boolean getActivarcodigoMayooresGenerales() {
		return this.activarcodigoMayooresGenerales;
	}

	public void setActivarcodigoMayooresGenerales(Boolean activarcodigoMayooresGenerales) {
		this.activarcodigoMayooresGenerales= activarcodigoMayooresGenerales;
	}

	public Border setResaltarbeneficiarioMayooresGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*MayooresGeneralesBeanSwingJInternalFrame mayooresgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//mayooresgeneralesBeanSwingJInternalFrame.jTtoolBarMayooresGenerales.setBorder(borderResaltar);
		
		this.resaltarbeneficiarioMayooresGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarbeneficiarioMayooresGenerales() {
		return this.resaltarbeneficiarioMayooresGenerales;
	}

	public void setResaltarbeneficiarioMayooresGenerales(Border borderResaltar) {
		this.resaltarbeneficiarioMayooresGenerales= borderResaltar;
	}

	public Boolean getMostrarbeneficiarioMayooresGenerales() {
		return this.mostrarbeneficiarioMayooresGenerales;
	}

	public void setMostrarbeneficiarioMayooresGenerales(Boolean mostrarbeneficiarioMayooresGenerales) {
		this.mostrarbeneficiarioMayooresGenerales= mostrarbeneficiarioMayooresGenerales;
	}

	public Boolean getActivarbeneficiarioMayooresGenerales() {
		return this.activarbeneficiarioMayooresGenerales;
	}

	public void setActivarbeneficiarioMayooresGenerales(Boolean activarbeneficiarioMayooresGenerales) {
		this.activarbeneficiarioMayooresGenerales= activarbeneficiarioMayooresGenerales;
	}

	public Border setResaltardetalleMayooresGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*MayooresGeneralesBeanSwingJInternalFrame mayooresgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//mayooresgeneralesBeanSwingJInternalFrame.jTtoolBarMayooresGenerales.setBorder(borderResaltar);
		
		this.resaltardetalleMayooresGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardetalleMayooresGenerales() {
		return this.resaltardetalleMayooresGenerales;
	}

	public void setResaltardetalleMayooresGenerales(Border borderResaltar) {
		this.resaltardetalleMayooresGenerales= borderResaltar;
	}

	public Boolean getMostrardetalleMayooresGenerales() {
		return this.mostrardetalleMayooresGenerales;
	}

	public void setMostrardetalleMayooresGenerales(Boolean mostrardetalleMayooresGenerales) {
		this.mostrardetalleMayooresGenerales= mostrardetalleMayooresGenerales;
	}

	public Boolean getActivardetalleMayooresGenerales() {
		return this.activardetalleMayooresGenerales;
	}

	public void setActivardetalleMayooresGenerales(Boolean activardetalleMayooresGenerales) {
		this.activardetalleMayooresGenerales= activardetalleMayooresGenerales;
	}

	public Border setResaltarfecha_emisionMayooresGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*MayooresGeneralesBeanSwingJInternalFrame mayooresgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//mayooresgeneralesBeanSwingJInternalFrame.jTtoolBarMayooresGenerales.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionMayooresGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionMayooresGenerales() {
		return this.resaltarfecha_emisionMayooresGenerales;
	}

	public void setResaltarfecha_emisionMayooresGenerales(Border borderResaltar) {
		this.resaltarfecha_emisionMayooresGenerales= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionMayooresGenerales() {
		return this.mostrarfecha_emisionMayooresGenerales;
	}

	public void setMostrarfecha_emisionMayooresGenerales(Boolean mostrarfecha_emisionMayooresGenerales) {
		this.mostrarfecha_emisionMayooresGenerales= mostrarfecha_emisionMayooresGenerales;
	}

	public Boolean getActivarfecha_emisionMayooresGenerales() {
		return this.activarfecha_emisionMayooresGenerales;
	}

	public void setActivarfecha_emisionMayooresGenerales(Boolean activarfecha_emisionMayooresGenerales) {
		this.activarfecha_emisionMayooresGenerales= activarfecha_emisionMayooresGenerales;
	}

	public Border setResaltarcodigo_tipo_movimientoMayooresGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*MayooresGeneralesBeanSwingJInternalFrame mayooresgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//mayooresgeneralesBeanSwingJInternalFrame.jTtoolBarMayooresGenerales.setBorder(borderResaltar);
		
		this.resaltarcodigo_tipo_movimientoMayooresGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_tipo_movimientoMayooresGenerales() {
		return this.resaltarcodigo_tipo_movimientoMayooresGenerales;
	}

	public void setResaltarcodigo_tipo_movimientoMayooresGenerales(Border borderResaltar) {
		this.resaltarcodigo_tipo_movimientoMayooresGenerales= borderResaltar;
	}

	public Boolean getMostrarcodigo_tipo_movimientoMayooresGenerales() {
		return this.mostrarcodigo_tipo_movimientoMayooresGenerales;
	}

	public void setMostrarcodigo_tipo_movimientoMayooresGenerales(Boolean mostrarcodigo_tipo_movimientoMayooresGenerales) {
		this.mostrarcodigo_tipo_movimientoMayooresGenerales= mostrarcodigo_tipo_movimientoMayooresGenerales;
	}

	public Boolean getActivarcodigo_tipo_movimientoMayooresGenerales() {
		return this.activarcodigo_tipo_movimientoMayooresGenerales;
	}

	public void setActivarcodigo_tipo_movimientoMayooresGenerales(Boolean activarcodigo_tipo_movimientoMayooresGenerales) {
		this.activarcodigo_tipo_movimientoMayooresGenerales= activarcodigo_tipo_movimientoMayooresGenerales;
	}

	public Border setResaltarnumero_mayorMayooresGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*MayooresGeneralesBeanSwingJInternalFrame mayooresgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//mayooresgeneralesBeanSwingJInternalFrame.jTtoolBarMayooresGenerales.setBorder(borderResaltar);
		
		this.resaltarnumero_mayorMayooresGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_mayorMayooresGenerales() {
		return this.resaltarnumero_mayorMayooresGenerales;
	}

	public void setResaltarnumero_mayorMayooresGenerales(Border borderResaltar) {
		this.resaltarnumero_mayorMayooresGenerales= borderResaltar;
	}

	public Boolean getMostrarnumero_mayorMayooresGenerales() {
		return this.mostrarnumero_mayorMayooresGenerales;
	}

	public void setMostrarnumero_mayorMayooresGenerales(Boolean mostrarnumero_mayorMayooresGenerales) {
		this.mostrarnumero_mayorMayooresGenerales= mostrarnumero_mayorMayooresGenerales;
	}

	public Boolean getActivarnumero_mayorMayooresGenerales() {
		return this.activarnumero_mayorMayooresGenerales;
	}

	public void setActivarnumero_mayorMayooresGenerales(Boolean activarnumero_mayorMayooresGenerales) {
		this.activarnumero_mayorMayooresGenerales= activarnumero_mayorMayooresGenerales;
	}

	public Border setResaltarnombre_cuenta_contableMayooresGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*MayooresGeneralesBeanSwingJInternalFrame mayooresgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//mayooresgeneralesBeanSwingJInternalFrame.jTtoolBarMayooresGenerales.setBorder(borderResaltar);
		
		this.resaltarnombre_cuenta_contableMayooresGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_cuenta_contableMayooresGenerales() {
		return this.resaltarnombre_cuenta_contableMayooresGenerales;
	}

	public void setResaltarnombre_cuenta_contableMayooresGenerales(Border borderResaltar) {
		this.resaltarnombre_cuenta_contableMayooresGenerales= borderResaltar;
	}

	public Boolean getMostrarnombre_cuenta_contableMayooresGenerales() {
		return this.mostrarnombre_cuenta_contableMayooresGenerales;
	}

	public void setMostrarnombre_cuenta_contableMayooresGenerales(Boolean mostrarnombre_cuenta_contableMayooresGenerales) {
		this.mostrarnombre_cuenta_contableMayooresGenerales= mostrarnombre_cuenta_contableMayooresGenerales;
	}

	public Boolean getActivarnombre_cuenta_contableMayooresGenerales() {
		return this.activarnombre_cuenta_contableMayooresGenerales;
	}

	public void setActivarnombre_cuenta_contableMayooresGenerales(Boolean activarnombre_cuenta_contableMayooresGenerales) {
		this.activarnombre_cuenta_contableMayooresGenerales= activarnombre_cuenta_contableMayooresGenerales;
	}

	public Border setResaltardebito_localMayooresGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*MayooresGeneralesBeanSwingJInternalFrame mayooresgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//mayooresgeneralesBeanSwingJInternalFrame.jTtoolBarMayooresGenerales.setBorder(borderResaltar);
		
		this.resaltardebito_localMayooresGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardebito_localMayooresGenerales() {
		return this.resaltardebito_localMayooresGenerales;
	}

	public void setResaltardebito_localMayooresGenerales(Border borderResaltar) {
		this.resaltardebito_localMayooresGenerales= borderResaltar;
	}

	public Boolean getMostrardebito_localMayooresGenerales() {
		return this.mostrardebito_localMayooresGenerales;
	}

	public void setMostrardebito_localMayooresGenerales(Boolean mostrardebito_localMayooresGenerales) {
		this.mostrardebito_localMayooresGenerales= mostrardebito_localMayooresGenerales;
	}

	public Boolean getActivardebito_localMayooresGenerales() {
		return this.activardebito_localMayooresGenerales;
	}

	public void setActivardebito_localMayooresGenerales(Boolean activardebito_localMayooresGenerales) {
		this.activardebito_localMayooresGenerales= activardebito_localMayooresGenerales;
	}

	public Border setResaltarcredito_localMayooresGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*MayooresGeneralesBeanSwingJInternalFrame mayooresgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//mayooresgeneralesBeanSwingJInternalFrame.jTtoolBarMayooresGenerales.setBorder(borderResaltar);
		
		this.resaltarcredito_localMayooresGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcredito_localMayooresGenerales() {
		return this.resaltarcredito_localMayooresGenerales;
	}

	public void setResaltarcredito_localMayooresGenerales(Border borderResaltar) {
		this.resaltarcredito_localMayooresGenerales= borderResaltar;
	}

	public Boolean getMostrarcredito_localMayooresGenerales() {
		return this.mostrarcredito_localMayooresGenerales;
	}

	public void setMostrarcredito_localMayooresGenerales(Boolean mostrarcredito_localMayooresGenerales) {
		this.mostrarcredito_localMayooresGenerales= mostrarcredito_localMayooresGenerales;
	}

	public Boolean getActivarcredito_localMayooresGenerales() {
		return this.activarcredito_localMayooresGenerales;
	}

	public void setActivarcredito_localMayooresGenerales(Boolean activarcredito_localMayooresGenerales) {
		this.activarcredito_localMayooresGenerales= activarcredito_localMayooresGenerales;
	}

	public Border setResaltardetalle_detalle_asiento_contableMayooresGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*MayooresGeneralesBeanSwingJInternalFrame mayooresgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//mayooresgeneralesBeanSwingJInternalFrame.jTtoolBarMayooresGenerales.setBorder(borderResaltar);
		
		this.resaltardetalle_detalle_asiento_contableMayooresGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardetalle_detalle_asiento_contableMayooresGenerales() {
		return this.resaltardetalle_detalle_asiento_contableMayooresGenerales;
	}

	public void setResaltardetalle_detalle_asiento_contableMayooresGenerales(Border borderResaltar) {
		this.resaltardetalle_detalle_asiento_contableMayooresGenerales= borderResaltar;
	}

	public Boolean getMostrardetalle_detalle_asiento_contableMayooresGenerales() {
		return this.mostrardetalle_detalle_asiento_contableMayooresGenerales;
	}

	public void setMostrardetalle_detalle_asiento_contableMayooresGenerales(Boolean mostrardetalle_detalle_asiento_contableMayooresGenerales) {
		this.mostrardetalle_detalle_asiento_contableMayooresGenerales= mostrardetalle_detalle_asiento_contableMayooresGenerales;
	}

	public Boolean getActivardetalle_detalle_asiento_contableMayooresGenerales() {
		return this.activardetalle_detalle_asiento_contableMayooresGenerales;
	}

	public void setActivardetalle_detalle_asiento_contableMayooresGenerales(Boolean activardetalle_detalle_asiento_contableMayooresGenerales) {
		this.activardetalle_detalle_asiento_contableMayooresGenerales= activardetalle_detalle_asiento_contableMayooresGenerales;
	}

	public Border setResaltarcodigo_cuenta_contableMayooresGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*MayooresGeneralesBeanSwingJInternalFrame mayooresgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//mayooresgeneralesBeanSwingJInternalFrame.jTtoolBarMayooresGenerales.setBorder(borderResaltar);
		
		this.resaltarcodigo_cuenta_contableMayooresGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_cuenta_contableMayooresGenerales() {
		return this.resaltarcodigo_cuenta_contableMayooresGenerales;
	}

	public void setResaltarcodigo_cuenta_contableMayooresGenerales(Border borderResaltar) {
		this.resaltarcodigo_cuenta_contableMayooresGenerales= borderResaltar;
	}

	public Boolean getMostrarcodigo_cuenta_contableMayooresGenerales() {
		return this.mostrarcodigo_cuenta_contableMayooresGenerales;
	}

	public void setMostrarcodigo_cuenta_contableMayooresGenerales(Boolean mostrarcodigo_cuenta_contableMayooresGenerales) {
		this.mostrarcodigo_cuenta_contableMayooresGenerales= mostrarcodigo_cuenta_contableMayooresGenerales;
	}

	public Boolean getActivarcodigo_cuenta_contableMayooresGenerales() {
		return this.activarcodigo_cuenta_contableMayooresGenerales;
	}

	public void setActivarcodigo_cuenta_contableMayooresGenerales(Boolean activarcodigo_cuenta_contableMayooresGenerales) {
		this.activarcodigo_cuenta_contableMayooresGenerales= activarcodigo_cuenta_contableMayooresGenerales;
	}

	public Border setResaltarsaldoMayooresGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*MayooresGeneralesBeanSwingJInternalFrame mayooresgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//mayooresgeneralesBeanSwingJInternalFrame.jTtoolBarMayooresGenerales.setBorder(borderResaltar);
		
		this.resaltarsaldoMayooresGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsaldoMayooresGenerales() {
		return this.resaltarsaldoMayooresGenerales;
	}

	public void setResaltarsaldoMayooresGenerales(Border borderResaltar) {
		this.resaltarsaldoMayooresGenerales= borderResaltar;
	}

	public Boolean getMostrarsaldoMayooresGenerales() {
		return this.mostrarsaldoMayooresGenerales;
	}

	public void setMostrarsaldoMayooresGenerales(Boolean mostrarsaldoMayooresGenerales) {
		this.mostrarsaldoMayooresGenerales= mostrarsaldoMayooresGenerales;
	}

	public Boolean getActivarsaldoMayooresGenerales() {
		return this.activarsaldoMayooresGenerales;
	}

	public void setActivarsaldoMayooresGenerales(Boolean activarsaldoMayooresGenerales) {
		this.activarsaldoMayooresGenerales= activarsaldoMayooresGenerales;
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
		
		
		this.setMostraridMayooresGenerales(esInicial);
		this.setMostrarid_empresaMayooresGenerales(esInicial);
		this.setMostrarid_ejercicioMayooresGenerales(esInicial);
		this.setMostrarid_cuenta_contableMayooresGenerales(esInicial);
		this.setMostrarfecha_emision_desdeMayooresGenerales(esInicial);
		this.setMostrarfecha_emision_hastaMayooresGenerales(esInicial);
		this.setMostrarnombre_sucursalMayooresGenerales(esInicial);
		this.setMostrarcodigoMayooresGenerales(esInicial);
		this.setMostrarbeneficiarioMayooresGenerales(esInicial);
		this.setMostrardetalleMayooresGenerales(esInicial);
		this.setMostrarfecha_emisionMayooresGenerales(esInicial);
		this.setMostrarcodigo_tipo_movimientoMayooresGenerales(esInicial);
		this.setMostrarnumero_mayorMayooresGenerales(esInicial);
		this.setMostrarnombre_cuenta_contableMayooresGenerales(esInicial);
		this.setMostrardebito_localMayooresGenerales(esInicial);
		this.setMostrarcredito_localMayooresGenerales(esInicial);
		this.setMostrardetalle_detalle_asiento_contableMayooresGenerales(esInicial);
		this.setMostrarcodigo_cuenta_contableMayooresGenerales(esInicial);
		this.setMostrarsaldoMayooresGenerales(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(MayooresGeneralesConstantesFunciones.ID)) {
				this.setMostraridMayooresGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(MayooresGeneralesConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaMayooresGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(MayooresGeneralesConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioMayooresGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(MayooresGeneralesConstantesFunciones.IDCUENTACONTABLE)) {
				this.setMostrarid_cuenta_contableMayooresGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(MayooresGeneralesConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setMostrarfecha_emision_desdeMayooresGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(MayooresGeneralesConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setMostrarfecha_emision_hastaMayooresGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(MayooresGeneralesConstantesFunciones.NOMBRESUCURSAL)) {
				this.setMostrarnombre_sucursalMayooresGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(MayooresGeneralesConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoMayooresGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(MayooresGeneralesConstantesFunciones.BENEFICIARIO)) {
				this.setMostrarbeneficiarioMayooresGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(MayooresGeneralesConstantesFunciones.DETALLE)) {
				this.setMostrardetalleMayooresGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(MayooresGeneralesConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionMayooresGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(MayooresGeneralesConstantesFunciones.CODIGOTIPOMOVIMIENTO)) {
				this.setMostrarcodigo_tipo_movimientoMayooresGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(MayooresGeneralesConstantesFunciones.NUMEROMAYOR)) {
				this.setMostrarnumero_mayorMayooresGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(MayooresGeneralesConstantesFunciones.NOMBRECUENTACONTABLE)) {
				this.setMostrarnombre_cuenta_contableMayooresGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(MayooresGeneralesConstantesFunciones.DEBITOLOCAL)) {
				this.setMostrardebito_localMayooresGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(MayooresGeneralesConstantesFunciones.CREDITOLOCAL)) {
				this.setMostrarcredito_localMayooresGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(MayooresGeneralesConstantesFunciones.DETALLEDETALLEASIENTOCONTABLE)) {
				this.setMostrardetalle_detalle_asiento_contableMayooresGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(MayooresGeneralesConstantesFunciones.CODIGOCUENTACONTABLE)) {
				this.setMostrarcodigo_cuenta_contableMayooresGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(MayooresGeneralesConstantesFunciones.SALDO)) {
				this.setMostrarsaldoMayooresGenerales(esAsigna);
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
		
		
		this.setActivaridMayooresGenerales(esInicial);
		this.setActivarid_empresaMayooresGenerales(esInicial);
		this.setActivarid_ejercicioMayooresGenerales(esInicial);
		this.setActivarid_cuenta_contableMayooresGenerales(esInicial);
		this.setActivarfecha_emision_desdeMayooresGenerales(esInicial);
		this.setActivarfecha_emision_hastaMayooresGenerales(esInicial);
		this.setActivarnombre_sucursalMayooresGenerales(esInicial);
		this.setActivarcodigoMayooresGenerales(esInicial);
		this.setActivarbeneficiarioMayooresGenerales(esInicial);
		this.setActivardetalleMayooresGenerales(esInicial);
		this.setActivarfecha_emisionMayooresGenerales(esInicial);
		this.setActivarcodigo_tipo_movimientoMayooresGenerales(esInicial);
		this.setActivarnumero_mayorMayooresGenerales(esInicial);
		this.setActivarnombre_cuenta_contableMayooresGenerales(esInicial);
		this.setActivardebito_localMayooresGenerales(esInicial);
		this.setActivarcredito_localMayooresGenerales(esInicial);
		this.setActivardetalle_detalle_asiento_contableMayooresGenerales(esInicial);
		this.setActivarcodigo_cuenta_contableMayooresGenerales(esInicial);
		this.setActivarsaldoMayooresGenerales(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(MayooresGeneralesConstantesFunciones.ID)) {
				this.setActivaridMayooresGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(MayooresGeneralesConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaMayooresGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(MayooresGeneralesConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioMayooresGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(MayooresGeneralesConstantesFunciones.IDCUENTACONTABLE)) {
				this.setActivarid_cuenta_contableMayooresGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(MayooresGeneralesConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setActivarfecha_emision_desdeMayooresGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(MayooresGeneralesConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setActivarfecha_emision_hastaMayooresGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(MayooresGeneralesConstantesFunciones.NOMBRESUCURSAL)) {
				this.setActivarnombre_sucursalMayooresGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(MayooresGeneralesConstantesFunciones.CODIGO)) {
				this.setActivarcodigoMayooresGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(MayooresGeneralesConstantesFunciones.BENEFICIARIO)) {
				this.setActivarbeneficiarioMayooresGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(MayooresGeneralesConstantesFunciones.DETALLE)) {
				this.setActivardetalleMayooresGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(MayooresGeneralesConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionMayooresGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(MayooresGeneralesConstantesFunciones.CODIGOTIPOMOVIMIENTO)) {
				this.setActivarcodigo_tipo_movimientoMayooresGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(MayooresGeneralesConstantesFunciones.NUMEROMAYOR)) {
				this.setActivarnumero_mayorMayooresGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(MayooresGeneralesConstantesFunciones.NOMBRECUENTACONTABLE)) {
				this.setActivarnombre_cuenta_contableMayooresGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(MayooresGeneralesConstantesFunciones.DEBITOLOCAL)) {
				this.setActivardebito_localMayooresGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(MayooresGeneralesConstantesFunciones.CREDITOLOCAL)) {
				this.setActivarcredito_localMayooresGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(MayooresGeneralesConstantesFunciones.DETALLEDETALLEASIENTOCONTABLE)) {
				this.setActivardetalle_detalle_asiento_contableMayooresGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(MayooresGeneralesConstantesFunciones.CODIGOCUENTACONTABLE)) {
				this.setActivarcodigo_cuenta_contableMayooresGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(MayooresGeneralesConstantesFunciones.SALDO)) {
				this.setActivarsaldoMayooresGenerales(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,MayooresGeneralesBeanSwingJInternalFrame mayooresgeneralesBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridMayooresGenerales(esInicial);
		this.setResaltarid_empresaMayooresGenerales(esInicial);
		this.setResaltarid_ejercicioMayooresGenerales(esInicial);
		this.setResaltarid_cuenta_contableMayooresGenerales(esInicial);
		this.setResaltarfecha_emision_desdeMayooresGenerales(esInicial);
		this.setResaltarfecha_emision_hastaMayooresGenerales(esInicial);
		this.setResaltarnombre_sucursalMayooresGenerales(esInicial);
		this.setResaltarcodigoMayooresGenerales(esInicial);
		this.setResaltarbeneficiarioMayooresGenerales(esInicial);
		this.setResaltardetalleMayooresGenerales(esInicial);
		this.setResaltarfecha_emisionMayooresGenerales(esInicial);
		this.setResaltarcodigo_tipo_movimientoMayooresGenerales(esInicial);
		this.setResaltarnumero_mayorMayooresGenerales(esInicial);
		this.setResaltarnombre_cuenta_contableMayooresGenerales(esInicial);
		this.setResaltardebito_localMayooresGenerales(esInicial);
		this.setResaltarcredito_localMayooresGenerales(esInicial);
		this.setResaltardetalle_detalle_asiento_contableMayooresGenerales(esInicial);
		this.setResaltarcodigo_cuenta_contableMayooresGenerales(esInicial);
		this.setResaltarsaldoMayooresGenerales(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(MayooresGeneralesConstantesFunciones.ID)) {
				this.setResaltaridMayooresGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(MayooresGeneralesConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaMayooresGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(MayooresGeneralesConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioMayooresGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(MayooresGeneralesConstantesFunciones.IDCUENTACONTABLE)) {
				this.setResaltarid_cuenta_contableMayooresGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(MayooresGeneralesConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setResaltarfecha_emision_desdeMayooresGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(MayooresGeneralesConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setResaltarfecha_emision_hastaMayooresGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(MayooresGeneralesConstantesFunciones.NOMBRESUCURSAL)) {
				this.setResaltarnombre_sucursalMayooresGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(MayooresGeneralesConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoMayooresGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(MayooresGeneralesConstantesFunciones.BENEFICIARIO)) {
				this.setResaltarbeneficiarioMayooresGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(MayooresGeneralesConstantesFunciones.DETALLE)) {
				this.setResaltardetalleMayooresGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(MayooresGeneralesConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionMayooresGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(MayooresGeneralesConstantesFunciones.CODIGOTIPOMOVIMIENTO)) {
				this.setResaltarcodigo_tipo_movimientoMayooresGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(MayooresGeneralesConstantesFunciones.NUMEROMAYOR)) {
				this.setResaltarnumero_mayorMayooresGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(MayooresGeneralesConstantesFunciones.NOMBRECUENTACONTABLE)) {
				this.setResaltarnombre_cuenta_contableMayooresGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(MayooresGeneralesConstantesFunciones.DEBITOLOCAL)) {
				this.setResaltardebito_localMayooresGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(MayooresGeneralesConstantesFunciones.CREDITOLOCAL)) {
				this.setResaltarcredito_localMayooresGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(MayooresGeneralesConstantesFunciones.DETALLEDETALLEASIENTOCONTABLE)) {
				this.setResaltardetalle_detalle_asiento_contableMayooresGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(MayooresGeneralesConstantesFunciones.CODIGOCUENTACONTABLE)) {
				this.setResaltarcodigo_cuenta_contableMayooresGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(MayooresGeneralesConstantesFunciones.SALDO)) {
				this.setResaltarsaldoMayooresGenerales(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,MayooresGeneralesBeanSwingJInternalFrame mayooresgeneralesBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaMayooresGeneralesMayooresGenerales=true;

	public Boolean getMostrarBusquedaMayooresGeneralesMayooresGenerales() {
		return this.mostrarBusquedaMayooresGeneralesMayooresGenerales;
	}

	public void setMostrarBusquedaMayooresGeneralesMayooresGenerales(Boolean visibilidadResaltar) {
		this.mostrarBusquedaMayooresGeneralesMayooresGenerales= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaMayooresGeneralesMayooresGenerales=true;

	public Boolean getActivarBusquedaMayooresGeneralesMayooresGenerales() {
		return this.activarBusquedaMayooresGeneralesMayooresGenerales;
	}

	public void setActivarBusquedaMayooresGeneralesMayooresGenerales(Boolean habilitarResaltar) {
		this.activarBusquedaMayooresGeneralesMayooresGenerales= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaMayooresGeneralesMayooresGenerales=null;

	public Border getResaltarBusquedaMayooresGeneralesMayooresGenerales() {
		return this.resaltarBusquedaMayooresGeneralesMayooresGenerales;
	}

	public void setResaltarBusquedaMayooresGeneralesMayooresGenerales(Border borderResaltar) {
		this.resaltarBusquedaMayooresGeneralesMayooresGenerales= borderResaltar;
	}

	public void setResaltarBusquedaMayooresGeneralesMayooresGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*MayooresGeneralesBeanSwingJInternalFrame mayooresgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaMayooresGeneralesMayooresGenerales= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}