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
package com.bydan.erp.tesoreria.util.report;

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


import com.bydan.erp.tesoreria.util.report.PosicionesBancariasConstantesFunciones;
import com.bydan.erp.tesoreria.util.report.PosicionesBancariasParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.report.PosicionesBancariasParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.tesoreria.business.dataaccess.*;
//import com.bydan.erp.tesoreria.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class PosicionesBancariasConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="PosicionesBancarias";
	public static final String SPATHOPCION="Tesoreria";	
	public static final String SPATHMODULO="tesoreria/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="PosicionesBancarias"+PosicionesBancariasConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="PosicionesBancariasHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="PosicionesBancariasHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=PosicionesBancariasConstantesFunciones.SCHEMA+"_"+PosicionesBancariasConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/PosicionesBancariasHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=PosicionesBancariasConstantesFunciones.SCHEMA+"_"+PosicionesBancariasConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=PosicionesBancariasConstantesFunciones.SCHEMA+"_"+PosicionesBancariasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/PosicionesBancariasHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=PosicionesBancariasConstantesFunciones.SCHEMA+"_"+PosicionesBancariasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PosicionesBancariasConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PosicionesBancariasHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PosicionesBancariasConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PosicionesBancariasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PosicionesBancariasHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PosicionesBancariasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=PosicionesBancariasConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+PosicionesBancariasConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=PosicionesBancariasConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+PosicionesBancariasConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Posiciones Bancariases";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Posiciones Bancarias";
	public static final String SCLASSWEBTITULO_LOWER="Posiciones Bancarias";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="PosicionesBancarias";
	public static final String OBJECTNAME="posicionesbancarias";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_TESORERIA;	
	public static final String TABLENAME="posiciones_bancarias";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select posicionesbancarias from "+PosicionesBancariasConstantesFunciones.SPERSISTENCENAME+" posicionesbancarias";
	public static String QUERYSELECTNATIVE="select "+PosicionesBancariasConstantesFunciones.SCHEMA+"."+PosicionesBancariasConstantesFunciones.TABLENAME+".id,"+PosicionesBancariasConstantesFunciones.SCHEMA+"."+PosicionesBancariasConstantesFunciones.TABLENAME+".version_row,"+PosicionesBancariasConstantesFunciones.SCHEMA+"."+PosicionesBancariasConstantesFunciones.TABLENAME+".id_empresa,"+PosicionesBancariasConstantesFunciones.SCHEMA+"."+PosicionesBancariasConstantesFunciones.TABLENAME+".id_ejercicio,"+PosicionesBancariasConstantesFunciones.SCHEMA+"."+PosicionesBancariasConstantesFunciones.TABLENAME+".id_tipo_movimiento,"+PosicionesBancariasConstantesFunciones.SCHEMA+"."+PosicionesBancariasConstantesFunciones.TABLENAME+".fecha_desde,"+PosicionesBancariasConstantesFunciones.SCHEMA+"."+PosicionesBancariasConstantesFunciones.TABLENAME+".fecha_hasta,"+PosicionesBancariasConstantesFunciones.SCHEMA+"."+PosicionesBancariasConstantesFunciones.TABLENAME+".orden_desde,"+PosicionesBancariasConstantesFunciones.SCHEMA+"."+PosicionesBancariasConstantesFunciones.TABLENAME+".orden_hasta,"+PosicionesBancariasConstantesFunciones.SCHEMA+"."+PosicionesBancariasConstantesFunciones.TABLENAME+".tipo_documento,"+PosicionesBancariasConstantesFunciones.SCHEMA+"."+PosicionesBancariasConstantesFunciones.TABLENAME+".detalle,"+PosicionesBancariasConstantesFunciones.SCHEMA+"."+PosicionesBancariasConstantesFunciones.TABLENAME+".codigo_cuenta,"+PosicionesBancariasConstantesFunciones.SCHEMA+"."+PosicionesBancariasConstantesFunciones.TABLENAME+".nombre_cuenta,"+PosicionesBancariasConstantesFunciones.SCHEMA+"."+PosicionesBancariasConstantesFunciones.TABLENAME+".numero_mayor,"+PosicionesBancariasConstantesFunciones.SCHEMA+"."+PosicionesBancariasConstantesFunciones.TABLENAME+".debito_local,"+PosicionesBancariasConstantesFunciones.SCHEMA+"."+PosicionesBancariasConstantesFunciones.TABLENAME+".credito_local,"+PosicionesBancariasConstantesFunciones.SCHEMA+"."+PosicionesBancariasConstantesFunciones.TABLENAME+".tipo_movimiento,"+PosicionesBancariasConstantesFunciones.SCHEMA+"."+PosicionesBancariasConstantesFunciones.TABLENAME+".fecha_emision,"+PosicionesBancariasConstantesFunciones.SCHEMA+"."+PosicionesBancariasConstantesFunciones.TABLENAME+".fecha,"+PosicionesBancariasConstantesFunciones.SCHEMA+"."+PosicionesBancariasConstantesFunciones.TABLENAME+".beneficiario from "+PosicionesBancariasConstantesFunciones.SCHEMA+"."+PosicionesBancariasConstantesFunciones.TABLENAME;//+" as "+PosicionesBancariasConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDTIPOMOVIMIENTO= "id_tipo_movimiento";
    public static final String FECHADESDE= "fecha_desde";
    public static final String FECHAHASTA= "fecha_hasta";
    public static final String ORDENDESDE= "orden_desde";
    public static final String ORDENHASTA= "orden_hasta";
    public static final String TIPODOCUMENTO= "tipo_documento";
    public static final String DETALLE= "detalle";
    public static final String CODIGOCUENTA= "codigo_cuenta";
    public static final String NOMBRECUENTA= "nombre_cuenta";
    public static final String NUMEROMAYOR= "numero_mayor";
    public static final String DEBITOLOCAL= "debito_local";
    public static final String CREDITOLOCAL= "credito_local";
    public static final String TIPOMOVIMIENTO= "tipo_movimiento";
    public static final String FECHAEMISION= "fecha_emision";
    public static final String FECHA= "fecha";
    public static final String BENEFICIARIO= "beneficiario";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_IDTIPOMOVIMIENTO= "Tipo Movimiento Base";
		public static final String LABEL_IDTIPOMOVIMIENTO_LOWER= "Tipo Movimiento";
    	public static final String LABEL_FECHADESDE= "Fecha Desde";
		public static final String LABEL_FECHADESDE_LOWER= "Fecha Desde";
    	public static final String LABEL_FECHAHASTA= "Fecha Hasta";
		public static final String LABEL_FECHAHASTA_LOWER= "Fecha Hasta";
    	public static final String LABEL_ORDENDESDE= "Orden Desde";
		public static final String LABEL_ORDENDESDE_LOWER= "Orden Desde";
    	public static final String LABEL_ORDENHASTA= "Orden Hasta";
		public static final String LABEL_ORDENHASTA_LOWER= "Orden Hasta";
    	public static final String LABEL_TIPODOCUMENTO= "Tipo Documento";
		public static final String LABEL_TIPODOCUMENTO_LOWER= "Tipo Documento";
    	public static final String LABEL_DETALLE= "Detalle";
		public static final String LABEL_DETALLE_LOWER= "Detalle";
    	public static final String LABEL_CODIGOCUENTA= "Codigo Cuenta";
		public static final String LABEL_CODIGOCUENTA_LOWER= "Codigo Cuenta";
    	public static final String LABEL_NOMBRECUENTA= "Nombre Cuenta";
		public static final String LABEL_NOMBRECUENTA_LOWER= "Nombre Cuenta";
    	public static final String LABEL_NUMEROMAYOR= "Numero Mayor";
		public static final String LABEL_NUMEROMAYOR_LOWER= "Numero Mayor";
    	public static final String LABEL_DEBITOLOCAL= "Debito Local";
		public static final String LABEL_DEBITOLOCAL_LOWER= "Debito Local";
    	public static final String LABEL_CREDITOLOCAL= "Credito Local";
		public static final String LABEL_CREDITOLOCAL_LOWER= "Credito Local";
    	public static final String LABEL_TIPOMOVIMIENTO= "Tipo Movimiento";
		public static final String LABEL_TIPOMOVIMIENTO_LOWER= "Tipo Movimiento";
    	public static final String LABEL_FECHAEMISION= "Fecha Emision";
		public static final String LABEL_FECHAEMISION_LOWER= "Fecha Emision";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_BENEFICIARIO= "Beneficiario";
		public static final String LABEL_BENEFICIARIO_LOWER= "Beneficiario";
	
		
		
		
		
		
		
		
		
		
	public static final String SREGEXTIPO_DOCUMENTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXTIPO_DOCUMENTO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDETALLE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDETALLE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO_CUENTA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_CUENTA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_CUENTA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_CUENTA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_MAYOR=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_MAYOR=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXTIPO_MOVIMIENTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXTIPO_MOVIMIENTO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXBENEFICIARIO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXBENEFICIARIO=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getPosicionesBancariasLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(PosicionesBancariasConstantesFunciones.IDEMPRESA)) {sLabelColumna=PosicionesBancariasConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(PosicionesBancariasConstantesFunciones.IDEJERCICIO)) {sLabelColumna=PosicionesBancariasConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(PosicionesBancariasConstantesFunciones.IDTIPOMOVIMIENTO)) {sLabelColumna=PosicionesBancariasConstantesFunciones.LABEL_IDTIPOMOVIMIENTO;}
		if(sNombreColumna.equals(PosicionesBancariasConstantesFunciones.FECHADESDE)) {sLabelColumna=PosicionesBancariasConstantesFunciones.LABEL_FECHADESDE;}
		if(sNombreColumna.equals(PosicionesBancariasConstantesFunciones.FECHAHASTA)) {sLabelColumna=PosicionesBancariasConstantesFunciones.LABEL_FECHAHASTA;}
		if(sNombreColumna.equals(PosicionesBancariasConstantesFunciones.ORDENDESDE)) {sLabelColumna=PosicionesBancariasConstantesFunciones.LABEL_ORDENDESDE;}
		if(sNombreColumna.equals(PosicionesBancariasConstantesFunciones.ORDENHASTA)) {sLabelColumna=PosicionesBancariasConstantesFunciones.LABEL_ORDENHASTA;}
		if(sNombreColumna.equals(PosicionesBancariasConstantesFunciones.TIPODOCUMENTO)) {sLabelColumna=PosicionesBancariasConstantesFunciones.LABEL_TIPODOCUMENTO;}
		if(sNombreColumna.equals(PosicionesBancariasConstantesFunciones.DETALLE)) {sLabelColumna=PosicionesBancariasConstantesFunciones.LABEL_DETALLE;}
		if(sNombreColumna.equals(PosicionesBancariasConstantesFunciones.CODIGOCUENTA)) {sLabelColumna=PosicionesBancariasConstantesFunciones.LABEL_CODIGOCUENTA;}
		if(sNombreColumna.equals(PosicionesBancariasConstantesFunciones.NOMBRECUENTA)) {sLabelColumna=PosicionesBancariasConstantesFunciones.LABEL_NOMBRECUENTA;}
		if(sNombreColumna.equals(PosicionesBancariasConstantesFunciones.NUMEROMAYOR)) {sLabelColumna=PosicionesBancariasConstantesFunciones.LABEL_NUMEROMAYOR;}
		if(sNombreColumna.equals(PosicionesBancariasConstantesFunciones.DEBITOLOCAL)) {sLabelColumna=PosicionesBancariasConstantesFunciones.LABEL_DEBITOLOCAL;}
		if(sNombreColumna.equals(PosicionesBancariasConstantesFunciones.CREDITOLOCAL)) {sLabelColumna=PosicionesBancariasConstantesFunciones.LABEL_CREDITOLOCAL;}
		if(sNombreColumna.equals(PosicionesBancariasConstantesFunciones.TIPOMOVIMIENTO)) {sLabelColumna=PosicionesBancariasConstantesFunciones.LABEL_TIPOMOVIMIENTO;}
		if(sNombreColumna.equals(PosicionesBancariasConstantesFunciones.FECHAEMISION)) {sLabelColumna=PosicionesBancariasConstantesFunciones.LABEL_FECHAEMISION;}
		if(sNombreColumna.equals(PosicionesBancariasConstantesFunciones.FECHA)) {sLabelColumna=PosicionesBancariasConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(PosicionesBancariasConstantesFunciones.BENEFICIARIO)) {sLabelColumna=PosicionesBancariasConstantesFunciones.LABEL_BENEFICIARIO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getPosicionesBancariasDescripcion(PosicionesBancarias posicionesbancarias) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(posicionesbancarias !=null/* && posicionesbancarias.getId()!=0*/) {
			if(posicionesbancarias.getId()!=null) {
				sDescripcion=posicionesbancarias.getId().toString();
			}//posicionesbancariasposicionesbancarias.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getPosicionesBancariasDescripcionDetallado(PosicionesBancarias posicionesbancarias) {
		String sDescripcion="";
			
		sDescripcion+=PosicionesBancariasConstantesFunciones.ID+"=";
		sDescripcion+=posicionesbancarias.getId().toString()+",";
		sDescripcion+=PosicionesBancariasConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=posicionesbancarias.getVersionRow().toString()+",";
		sDescripcion+=PosicionesBancariasConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=posicionesbancarias.getid_empresa().toString()+",";
		sDescripcion+=PosicionesBancariasConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=posicionesbancarias.getid_ejercicio().toString()+",";
		sDescripcion+=PosicionesBancariasConstantesFunciones.IDTIPOMOVIMIENTO+"=";
		sDescripcion+=posicionesbancarias.getid_tipo_movimiento().toString()+",";
		sDescripcion+=PosicionesBancariasConstantesFunciones.FECHADESDE+"=";
		sDescripcion+=posicionesbancarias.getfecha_desde().toString()+",";
		sDescripcion+=PosicionesBancariasConstantesFunciones.FECHAHASTA+"=";
		sDescripcion+=posicionesbancarias.getfecha_hasta().toString()+",";
		sDescripcion+=PosicionesBancariasConstantesFunciones.ORDENDESDE+"=";
		sDescripcion+=posicionesbancarias.getorden_desde().toString()+",";
		sDescripcion+=PosicionesBancariasConstantesFunciones.ORDENHASTA+"=";
		sDescripcion+=posicionesbancarias.getorden_hasta().toString()+",";
		sDescripcion+=PosicionesBancariasConstantesFunciones.TIPODOCUMENTO+"=";
		sDescripcion+=posicionesbancarias.gettipo_documento()+",";
		sDescripcion+=PosicionesBancariasConstantesFunciones.DETALLE+"=";
		sDescripcion+=posicionesbancarias.getdetalle()+",";
		sDescripcion+=PosicionesBancariasConstantesFunciones.CODIGOCUENTA+"=";
		sDescripcion+=posicionesbancarias.getcodigo_cuenta()+",";
		sDescripcion+=PosicionesBancariasConstantesFunciones.NOMBRECUENTA+"=";
		sDescripcion+=posicionesbancarias.getnombre_cuenta()+",";
		sDescripcion+=PosicionesBancariasConstantesFunciones.NUMEROMAYOR+"=";
		sDescripcion+=posicionesbancarias.getnumero_mayor()+",";
		sDescripcion+=PosicionesBancariasConstantesFunciones.DEBITOLOCAL+"=";
		sDescripcion+=posicionesbancarias.getdebito_local().toString()+",";
		sDescripcion+=PosicionesBancariasConstantesFunciones.CREDITOLOCAL+"=";
		sDescripcion+=posicionesbancarias.getcredito_local().toString()+",";
		sDescripcion+=PosicionesBancariasConstantesFunciones.TIPOMOVIMIENTO+"=";
		sDescripcion+=posicionesbancarias.gettipo_movimiento()+",";
		sDescripcion+=PosicionesBancariasConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=posicionesbancarias.getfecha_emision().toString()+",";
		sDescripcion+=PosicionesBancariasConstantesFunciones.FECHA+"=";
		sDescripcion+=posicionesbancarias.getfecha().toString()+",";
		sDescripcion+=PosicionesBancariasConstantesFunciones.BENEFICIARIO+"=";
		sDescripcion+=posicionesbancarias.getbeneficiario()+",";
			
		return sDescripcion;
	}
	
	public static void setPosicionesBancariasDescripcion(PosicionesBancarias posicionesbancarias,String sValor) throws Exception {			
		if(posicionesbancarias !=null) {
			//posicionesbancariasposicionesbancarias.getId().toString();
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
		} else if(sNombreIndice.equals("BusquedaPosicionesBancarias")) {
			sNombreIndice="Tipo=  Por Ejercicio Por Tipo Movimiento Base Por Fecha Desde Por Fecha Hasta Por Orden Desde Por Orden Hasta";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdTipoMovimiento")) {
			sNombreIndice="Tipo=  Por Tipo Movimiento Base";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPosicionesBancarias(Long id_ejercicio,Long id_tipo_movimiento,Date fecha_desde,Date fecha_hasta,Long orden_desde,Long orden_hasta) {
		String sDetalleIndice=" Parametros->";
		if(id_ejercicio!=null) {sDetalleIndice+=" Codigo Unico De Ejercicio="+id_ejercicio.toString();}
		if(id_tipo_movimiento!=null) {sDetalleIndice+=" Codigo Unico De Tipo Movimiento Base="+id_tipo_movimiento.toString();}
		if(fecha_desde!=null) {sDetalleIndice+=" Fecha Desde="+fecha_desde.toString();}
		if(fecha_hasta!=null) {sDetalleIndice+=" Fecha Hasta="+fecha_hasta.toString();}
		if(orden_desde!=null) {sDetalleIndice+=" Orden Desde="+orden_desde.toString();}
		if(orden_hasta!=null) {sDetalleIndice+=" Orden Hasta="+orden_hasta.toString();} 

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

	public static String getDetalleIndiceFK_IdTipoMovimiento(Long id_tipo_movimiento) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_movimiento!=null) {sDetalleIndice+=" Codigo Unico De Tipo Movimiento Base="+id_tipo_movimiento.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosPosicionesBancarias(PosicionesBancarias posicionesbancarias,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		posicionesbancarias.settipo_documento(posicionesbancarias.gettipo_documento().trim());
		posicionesbancarias.setdetalle(posicionesbancarias.getdetalle().trim());
		posicionesbancarias.setcodigo_cuenta(posicionesbancarias.getcodigo_cuenta().trim());
		posicionesbancarias.setnombre_cuenta(posicionesbancarias.getnombre_cuenta().trim());
		posicionesbancarias.setnumero_mayor(posicionesbancarias.getnumero_mayor().trim());
		posicionesbancarias.settipo_movimiento(posicionesbancarias.gettipo_movimiento().trim());
		posicionesbancarias.setbeneficiario(posicionesbancarias.getbeneficiario().trim());
	}
	
	public static void quitarEspaciosPosicionesBancariass(List<PosicionesBancarias> posicionesbancariass,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(PosicionesBancarias posicionesbancarias: posicionesbancariass) {
			posicionesbancarias.settipo_documento(posicionesbancarias.gettipo_documento().trim());
			posicionesbancarias.setdetalle(posicionesbancarias.getdetalle().trim());
			posicionesbancarias.setcodigo_cuenta(posicionesbancarias.getcodigo_cuenta().trim());
			posicionesbancarias.setnombre_cuenta(posicionesbancarias.getnombre_cuenta().trim());
			posicionesbancarias.setnumero_mayor(posicionesbancarias.getnumero_mayor().trim());
			posicionesbancarias.settipo_movimiento(posicionesbancarias.gettipo_movimiento().trim());
			posicionesbancarias.setbeneficiario(posicionesbancarias.getbeneficiario().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPosicionesBancarias(PosicionesBancarias posicionesbancarias,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && posicionesbancarias.getConCambioAuxiliar()) {
			posicionesbancarias.setIsDeleted(posicionesbancarias.getIsDeletedAuxiliar());	
			posicionesbancarias.setIsNew(posicionesbancarias.getIsNewAuxiliar());	
			posicionesbancarias.setIsChanged(posicionesbancarias.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			posicionesbancarias.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			posicionesbancarias.setIsDeletedAuxiliar(false);	
			posicionesbancarias.setIsNewAuxiliar(false);	
			posicionesbancarias.setIsChangedAuxiliar(false);
			
			posicionesbancarias.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPosicionesBancariass(List<PosicionesBancarias> posicionesbancariass,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(PosicionesBancarias posicionesbancarias : posicionesbancariass) {
			if(conAsignarBase && posicionesbancarias.getConCambioAuxiliar()) {
				posicionesbancarias.setIsDeleted(posicionesbancarias.getIsDeletedAuxiliar());	
				posicionesbancarias.setIsNew(posicionesbancarias.getIsNewAuxiliar());	
				posicionesbancarias.setIsChanged(posicionesbancarias.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				posicionesbancarias.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				posicionesbancarias.setIsDeletedAuxiliar(false);	
				posicionesbancarias.setIsNewAuxiliar(false);	
				posicionesbancarias.setIsChangedAuxiliar(false);
				
				posicionesbancarias.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresPosicionesBancarias(PosicionesBancarias posicionesbancarias,Boolean conEnteros) throws Exception  {
		posicionesbancarias.setdebito_local(0.0);
		posicionesbancarias.setcredito_local(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresPosicionesBancariass(List<PosicionesBancarias> posicionesbancariass,Boolean conEnteros) throws Exception  {
		
		for(PosicionesBancarias posicionesbancarias: posicionesbancariass) {
			posicionesbancarias.setdebito_local(0.0);
			posicionesbancarias.setcredito_local(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaPosicionesBancarias(List<PosicionesBancarias> posicionesbancariass,PosicionesBancarias posicionesbancariasAux) throws Exception  {
		PosicionesBancariasConstantesFunciones.InicializarValoresPosicionesBancarias(posicionesbancariasAux,true);
		
		for(PosicionesBancarias posicionesbancarias: posicionesbancariass) {
			if(posicionesbancarias.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			posicionesbancariasAux.setdebito_local(posicionesbancariasAux.getdebito_local()+posicionesbancarias.getdebito_local());			
			posicionesbancariasAux.setcredito_local(posicionesbancariasAux.getcredito_local()+posicionesbancarias.getcredito_local());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesPosicionesBancarias(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=PosicionesBancariasConstantesFunciones.getArrayColumnasGlobalesPosicionesBancarias(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesPosicionesBancarias(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PosicionesBancariasConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PosicionesBancariasConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PosicionesBancariasConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PosicionesBancariasConstantesFunciones.IDEJERCICIO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoPosicionesBancarias(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<PosicionesBancarias> posicionesbancariass,PosicionesBancarias posicionesbancarias,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(PosicionesBancarias posicionesbancariasAux: posicionesbancariass) {
			if(posicionesbancariasAux!=null && posicionesbancarias!=null) {
				if((posicionesbancariasAux.getId()==null && posicionesbancarias.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(posicionesbancariasAux.getId()!=null && posicionesbancarias.getId()!=null){
					if(posicionesbancariasAux.getId().equals(posicionesbancarias.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaPosicionesBancarias(List<PosicionesBancarias> posicionesbancariass) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double debito_localTotal=0.0;
		Double credito_localTotal=0.0;
	
		for(PosicionesBancarias posicionesbancarias: posicionesbancariass) {			
			if(posicionesbancarias.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			debito_localTotal+=posicionesbancarias.getdebito_local();
			credito_localTotal+=posicionesbancarias.getcredito_local();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PosicionesBancariasConstantesFunciones.DEBITOLOCAL);
		datoGeneral.setsDescripcion(PosicionesBancariasConstantesFunciones.LABEL_DEBITOLOCAL);
		datoGeneral.setdValorDouble(debito_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PosicionesBancariasConstantesFunciones.CREDITOLOCAL);
		datoGeneral.setsDescripcion(PosicionesBancariasConstantesFunciones.LABEL_CREDITOLOCAL);
		datoGeneral.setdValorDouble(credito_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaPosicionesBancarias() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,PosicionesBancariasConstantesFunciones.LABEL_ID, PosicionesBancariasConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PosicionesBancariasConstantesFunciones.LABEL_VERSIONROW, PosicionesBancariasConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PosicionesBancariasConstantesFunciones.LABEL_TIPODOCUMENTO, PosicionesBancariasConstantesFunciones.TIPODOCUMENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PosicionesBancariasConstantesFunciones.LABEL_DETALLE, PosicionesBancariasConstantesFunciones.DETALLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PosicionesBancariasConstantesFunciones.LABEL_CODIGOCUENTA, PosicionesBancariasConstantesFunciones.CODIGOCUENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PosicionesBancariasConstantesFunciones.LABEL_NOMBRECUENTA, PosicionesBancariasConstantesFunciones.NOMBRECUENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PosicionesBancariasConstantesFunciones.LABEL_NUMEROMAYOR, PosicionesBancariasConstantesFunciones.NUMEROMAYOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PosicionesBancariasConstantesFunciones.LABEL_DEBITOLOCAL, PosicionesBancariasConstantesFunciones.DEBITOLOCAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PosicionesBancariasConstantesFunciones.LABEL_CREDITOLOCAL, PosicionesBancariasConstantesFunciones.CREDITOLOCAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PosicionesBancariasConstantesFunciones.LABEL_TIPOMOVIMIENTO, PosicionesBancariasConstantesFunciones.TIPOMOVIMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PosicionesBancariasConstantesFunciones.LABEL_FECHAEMISION, PosicionesBancariasConstantesFunciones.FECHAEMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PosicionesBancariasConstantesFunciones.LABEL_FECHA, PosicionesBancariasConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PosicionesBancariasConstantesFunciones.LABEL_BENEFICIARIO, PosicionesBancariasConstantesFunciones.BENEFICIARIO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasPosicionesBancarias() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=PosicionesBancariasConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PosicionesBancariasConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PosicionesBancariasConstantesFunciones.TIPODOCUMENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PosicionesBancariasConstantesFunciones.DETALLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PosicionesBancariasConstantesFunciones.CODIGOCUENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PosicionesBancariasConstantesFunciones.NOMBRECUENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PosicionesBancariasConstantesFunciones.NUMEROMAYOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PosicionesBancariasConstantesFunciones.DEBITOLOCAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PosicionesBancariasConstantesFunciones.CREDITOLOCAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PosicionesBancariasConstantesFunciones.TIPOMOVIMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PosicionesBancariasConstantesFunciones.FECHAEMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PosicionesBancariasConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PosicionesBancariasConstantesFunciones.BENEFICIARIO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPosicionesBancarias() throws Exception  {
		return PosicionesBancariasConstantesFunciones.getTiposSeleccionarPosicionesBancarias(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPosicionesBancarias(Boolean conFk) throws Exception  {
		return PosicionesBancariasConstantesFunciones.getTiposSeleccionarPosicionesBancarias(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPosicionesBancarias(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PosicionesBancariasConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(PosicionesBancariasConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PosicionesBancariasConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(PosicionesBancariasConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PosicionesBancariasConstantesFunciones.LABEL_IDTIPOMOVIMIENTO);
			reporte.setsDescripcion(PosicionesBancariasConstantesFunciones.LABEL_IDTIPOMOVIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PosicionesBancariasConstantesFunciones.LABEL_FECHADESDE);
			reporte.setsDescripcion(PosicionesBancariasConstantesFunciones.LABEL_FECHADESDE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PosicionesBancariasConstantesFunciones.LABEL_FECHAHASTA);
			reporte.setsDescripcion(PosicionesBancariasConstantesFunciones.LABEL_FECHAHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PosicionesBancariasConstantesFunciones.LABEL_ORDENDESDE);
			reporte.setsDescripcion(PosicionesBancariasConstantesFunciones.LABEL_ORDENDESDE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PosicionesBancariasConstantesFunciones.LABEL_ORDENHASTA);
			reporte.setsDescripcion(PosicionesBancariasConstantesFunciones.LABEL_ORDENHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PosicionesBancariasConstantesFunciones.LABEL_TIPODOCUMENTO);
			reporte.setsDescripcion(PosicionesBancariasConstantesFunciones.LABEL_TIPODOCUMENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PosicionesBancariasConstantesFunciones.LABEL_DETALLE);
			reporte.setsDescripcion(PosicionesBancariasConstantesFunciones.LABEL_DETALLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PosicionesBancariasConstantesFunciones.LABEL_CODIGOCUENTA);
			reporte.setsDescripcion(PosicionesBancariasConstantesFunciones.LABEL_CODIGOCUENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PosicionesBancariasConstantesFunciones.LABEL_NOMBRECUENTA);
			reporte.setsDescripcion(PosicionesBancariasConstantesFunciones.LABEL_NOMBRECUENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PosicionesBancariasConstantesFunciones.LABEL_NUMEROMAYOR);
			reporte.setsDescripcion(PosicionesBancariasConstantesFunciones.LABEL_NUMEROMAYOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PosicionesBancariasConstantesFunciones.LABEL_DEBITOLOCAL);
			reporte.setsDescripcion(PosicionesBancariasConstantesFunciones.LABEL_DEBITOLOCAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PosicionesBancariasConstantesFunciones.LABEL_CREDITOLOCAL);
			reporte.setsDescripcion(PosicionesBancariasConstantesFunciones.LABEL_CREDITOLOCAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PosicionesBancariasConstantesFunciones.LABEL_TIPOMOVIMIENTO);
			reporte.setsDescripcion(PosicionesBancariasConstantesFunciones.LABEL_TIPOMOVIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PosicionesBancariasConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(PosicionesBancariasConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PosicionesBancariasConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(PosicionesBancariasConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PosicionesBancariasConstantesFunciones.LABEL_BENEFICIARIO);
			reporte.setsDescripcion(PosicionesBancariasConstantesFunciones.LABEL_BENEFICIARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesPosicionesBancarias(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesPosicionesBancarias(PosicionesBancarias posicionesbancariasAux) throws Exception {
		
			posicionesbancariasAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(posicionesbancariasAux.getEmpresa()));
			posicionesbancariasAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(posicionesbancariasAux.getEjercicio()));
			posicionesbancariasAux.settipomovimiento_descripcion(TipoMovimientoConstantesFunciones.getTipoMovimientoDescripcion(posicionesbancariasAux.getTipoMovimiento()));		
	}
	
	public static void refrescarForeignKeysDescripcionesPosicionesBancarias(List<PosicionesBancarias> posicionesbancariassTemp) throws Exception {
		for(PosicionesBancarias posicionesbancariasAux:posicionesbancariassTemp) {
			
			posicionesbancariasAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(posicionesbancariasAux.getEmpresa()));
			posicionesbancariasAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(posicionesbancariasAux.getEjercicio()));
			posicionesbancariasAux.settipomovimiento_descripcion(TipoMovimientoConstantesFunciones.getTipoMovimientoDescripcion(posicionesbancariasAux.getTipoMovimiento()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfPosicionesBancarias(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(TipoMovimiento.class));
				
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfPosicionesBancarias(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(TipoMovimiento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoMovimiento.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfPosicionesBancarias(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return PosicionesBancariasConstantesFunciones.getClassesRelationshipsOfPosicionesBancarias(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPosicionesBancarias(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPosicionesBancarias(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return PosicionesBancariasConstantesFunciones.getClassesRelationshipsFromStringsOfPosicionesBancarias(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPosicionesBancarias(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(PosicionesBancarias posicionesbancarias,List<PosicionesBancarias> posicionesbancariass,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(PosicionesBancarias posicionesbancarias,List<PosicionesBancarias> posicionesbancariass) throws Exception {
		try	{			
			for(PosicionesBancarias posicionesbancariasLocal:posicionesbancariass) {
				if(posicionesbancariasLocal.getId().equals(posicionesbancarias.getId())) {
					posicionesbancariasLocal.setIsSelected(posicionesbancarias.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesPosicionesBancarias(List<PosicionesBancarias> posicionesbancariassAux) throws Exception {
		//this.posicionesbancariassAux=posicionesbancariassAux;
		
		for(PosicionesBancarias posicionesbancariasAux:posicionesbancariassAux) {
			if(posicionesbancariasAux.getIsChanged()) {
				posicionesbancariasAux.setIsChanged(false);
			}		
			
			if(posicionesbancariasAux.getIsNew()) {
				posicionesbancariasAux.setIsNew(false);
			}	
			
			if(posicionesbancariasAux.getIsDeleted()) {
				posicionesbancariasAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesPosicionesBancarias(PosicionesBancarias posicionesbancariasAux) throws Exception {
		//this.posicionesbancariasAux=posicionesbancariasAux;
		
			if(posicionesbancariasAux.getIsChanged()) {
				posicionesbancariasAux.setIsChanged(false);
			}		
			
			if(posicionesbancariasAux.getIsNew()) {
				posicionesbancariasAux.setIsNew(false);
			}	
			
			if(posicionesbancariasAux.getIsDeleted()) {
				posicionesbancariasAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(PosicionesBancarias posicionesbancariasAsignar,PosicionesBancarias posicionesbancarias) throws Exception {
		posicionesbancariasAsignar.setId(posicionesbancarias.getId());	
		posicionesbancariasAsignar.setVersionRow(posicionesbancarias.getVersionRow());	
		posicionesbancariasAsignar.settipo_documento(posicionesbancarias.gettipo_documento());	
		posicionesbancariasAsignar.setdetalle(posicionesbancarias.getdetalle());	
		posicionesbancariasAsignar.setcodigo_cuenta(posicionesbancarias.getcodigo_cuenta());	
		posicionesbancariasAsignar.setnombre_cuenta(posicionesbancarias.getnombre_cuenta());	
		posicionesbancariasAsignar.setnumero_mayor(posicionesbancarias.getnumero_mayor());	
		posicionesbancariasAsignar.setdebito_local(posicionesbancarias.getdebito_local());	
		posicionesbancariasAsignar.setcredito_local(posicionesbancarias.getcredito_local());	
		posicionesbancariasAsignar.settipo_movimiento(posicionesbancarias.gettipo_movimiento());	
		posicionesbancariasAsignar.setfecha_emision(posicionesbancarias.getfecha_emision());	
		posicionesbancariasAsignar.setfecha(posicionesbancarias.getfecha());	
		posicionesbancariasAsignar.setbeneficiario(posicionesbancarias.getbeneficiario());	
	}
	
	public static void inicializarPosicionesBancarias(PosicionesBancarias posicionesbancarias) throws Exception {
		try {
				posicionesbancarias.setId(0L);	
					
				posicionesbancarias.settipo_documento("");	
				posicionesbancarias.setdetalle("");	
				posicionesbancarias.setcodigo_cuenta("");	
				posicionesbancarias.setnombre_cuenta("");	
				posicionesbancarias.setnumero_mayor("");	
				posicionesbancarias.setdebito_local(0.0);	
				posicionesbancarias.setcredito_local(0.0);	
				posicionesbancarias.settipo_movimiento("");	
				posicionesbancarias.setfecha_emision(new Date());	
				posicionesbancarias.setfecha(new Date());	
				posicionesbancarias.setbeneficiario("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderPosicionesBancarias(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(PosicionesBancariasConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PosicionesBancariasConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PosicionesBancariasConstantesFunciones.LABEL_IDTIPOMOVIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PosicionesBancariasConstantesFunciones.LABEL_FECHADESDE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PosicionesBancariasConstantesFunciones.LABEL_FECHAHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PosicionesBancariasConstantesFunciones.LABEL_ORDENDESDE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PosicionesBancariasConstantesFunciones.LABEL_ORDENHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PosicionesBancariasConstantesFunciones.LABEL_TIPODOCUMENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PosicionesBancariasConstantesFunciones.LABEL_DETALLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PosicionesBancariasConstantesFunciones.LABEL_CODIGOCUENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PosicionesBancariasConstantesFunciones.LABEL_NOMBRECUENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PosicionesBancariasConstantesFunciones.LABEL_NUMEROMAYOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PosicionesBancariasConstantesFunciones.LABEL_DEBITOLOCAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PosicionesBancariasConstantesFunciones.LABEL_CREDITOLOCAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PosicionesBancariasConstantesFunciones.LABEL_TIPOMOVIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PosicionesBancariasConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PosicionesBancariasConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PosicionesBancariasConstantesFunciones.LABEL_BENEFICIARIO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataPosicionesBancarias(String sTipo,Row row,Workbook workbook,PosicionesBancarias posicionesbancarias,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(posicionesbancarias.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(posicionesbancarias.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(posicionesbancarias.gettipomovimiento_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(posicionesbancarias.getfecha_desde());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(posicionesbancarias.getfecha_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(posicionesbancarias.getorden_desde());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(posicionesbancarias.getorden_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(posicionesbancarias.gettipo_documento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(posicionesbancarias.getdetalle());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(posicionesbancarias.getcodigo_cuenta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(posicionesbancarias.getnombre_cuenta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(posicionesbancarias.getnumero_mayor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(posicionesbancarias.getdebito_local());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(posicionesbancarias.getcredito_local());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(posicionesbancarias.gettipo_movimiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(posicionesbancarias.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(posicionesbancarias.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(posicionesbancarias.getbeneficiario());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryPosicionesBancarias="";
	
	public String getsFinalQueryPosicionesBancarias() {
		return this.sFinalQueryPosicionesBancarias;
	}
	
	public void setsFinalQueryPosicionesBancarias(String sFinalQueryPosicionesBancarias) {
		this.sFinalQueryPosicionesBancarias= sFinalQueryPosicionesBancarias;
	}
	
	public Border resaltarSeleccionarPosicionesBancarias=null;
	
	public Border setResaltarSeleccionarPosicionesBancarias(ParametroGeneralUsuario parametroGeneralUsuario/*PosicionesBancariasBeanSwingJInternalFrame posicionesbancariasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//posicionesbancariasBeanSwingJInternalFrame.jTtoolBarPosicionesBancarias.setBorder(borderResaltar);
		
		this.resaltarSeleccionarPosicionesBancarias= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarPosicionesBancarias() {
		return this.resaltarSeleccionarPosicionesBancarias;
	}
	
	public void setResaltarSeleccionarPosicionesBancarias(Border borderResaltarSeleccionarPosicionesBancarias) {
		this.resaltarSeleccionarPosicionesBancarias= borderResaltarSeleccionarPosicionesBancarias;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridPosicionesBancarias=null;
	public Boolean mostraridPosicionesBancarias=true;
	public Boolean activaridPosicionesBancarias=true;

	public Border resaltarid_empresaPosicionesBancarias=null;
	public Boolean mostrarid_empresaPosicionesBancarias=true;
	public Boolean activarid_empresaPosicionesBancarias=true;
	public Boolean cargarid_empresaPosicionesBancarias=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaPosicionesBancarias=false;//ConEventDepend=true

	public Border resaltarid_ejercicioPosicionesBancarias=null;
	public Boolean mostrarid_ejercicioPosicionesBancarias=true;
	public Boolean activarid_ejercicioPosicionesBancarias=true;
	public Boolean cargarid_ejercicioPosicionesBancarias=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioPosicionesBancarias=false;//ConEventDepend=true

	public Border resaltarid_tipo_movimientoPosicionesBancarias=null;
	public Boolean mostrarid_tipo_movimientoPosicionesBancarias=true;
	public Boolean activarid_tipo_movimientoPosicionesBancarias=true;
	public Boolean cargarid_tipo_movimientoPosicionesBancarias=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_movimientoPosicionesBancarias=false;//ConEventDepend=true

	public Border resaltarfecha_desdePosicionesBancarias=null;
	public Boolean mostrarfecha_desdePosicionesBancarias=true;
	public Boolean activarfecha_desdePosicionesBancarias=true;

	public Border resaltarfecha_hastaPosicionesBancarias=null;
	public Boolean mostrarfecha_hastaPosicionesBancarias=true;
	public Boolean activarfecha_hastaPosicionesBancarias=true;

	public Border resaltarorden_desdePosicionesBancarias=null;
	public Boolean mostrarorden_desdePosicionesBancarias=true;
	public Boolean activarorden_desdePosicionesBancarias=true;

	public Border resaltarorden_hastaPosicionesBancarias=null;
	public Boolean mostrarorden_hastaPosicionesBancarias=true;
	public Boolean activarorden_hastaPosicionesBancarias=true;

	public Border resaltartipo_documentoPosicionesBancarias=null;
	public Boolean mostrartipo_documentoPosicionesBancarias=true;
	public Boolean activartipo_documentoPosicionesBancarias=true;

	public Border resaltardetallePosicionesBancarias=null;
	public Boolean mostrardetallePosicionesBancarias=true;
	public Boolean activardetallePosicionesBancarias=true;

	public Border resaltarcodigo_cuentaPosicionesBancarias=null;
	public Boolean mostrarcodigo_cuentaPosicionesBancarias=true;
	public Boolean activarcodigo_cuentaPosicionesBancarias=true;

	public Border resaltarnombre_cuentaPosicionesBancarias=null;
	public Boolean mostrarnombre_cuentaPosicionesBancarias=true;
	public Boolean activarnombre_cuentaPosicionesBancarias=true;

	public Border resaltarnumero_mayorPosicionesBancarias=null;
	public Boolean mostrarnumero_mayorPosicionesBancarias=true;
	public Boolean activarnumero_mayorPosicionesBancarias=true;

	public Border resaltardebito_localPosicionesBancarias=null;
	public Boolean mostrardebito_localPosicionesBancarias=true;
	public Boolean activardebito_localPosicionesBancarias=true;

	public Border resaltarcredito_localPosicionesBancarias=null;
	public Boolean mostrarcredito_localPosicionesBancarias=true;
	public Boolean activarcredito_localPosicionesBancarias=true;

	public Border resaltartipo_movimientoPosicionesBancarias=null;
	public Boolean mostrartipo_movimientoPosicionesBancarias=true;
	public Boolean activartipo_movimientoPosicionesBancarias=true;

	public Border resaltarfecha_emisionPosicionesBancarias=null;
	public Boolean mostrarfecha_emisionPosicionesBancarias=true;
	public Boolean activarfecha_emisionPosicionesBancarias=true;

	public Border resaltarfechaPosicionesBancarias=null;
	public Boolean mostrarfechaPosicionesBancarias=true;
	public Boolean activarfechaPosicionesBancarias=true;

	public Border resaltarbeneficiarioPosicionesBancarias=null;
	public Boolean mostrarbeneficiarioPosicionesBancarias=true;
	public Boolean activarbeneficiarioPosicionesBancarias=true;

	
	

	public Border setResaltaridPosicionesBancarias(ParametroGeneralUsuario parametroGeneralUsuario/*PosicionesBancariasBeanSwingJInternalFrame posicionesbancariasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//posicionesbancariasBeanSwingJInternalFrame.jTtoolBarPosicionesBancarias.setBorder(borderResaltar);
		
		this.resaltaridPosicionesBancarias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridPosicionesBancarias() {
		return this.resaltaridPosicionesBancarias;
	}

	public void setResaltaridPosicionesBancarias(Border borderResaltar) {
		this.resaltaridPosicionesBancarias= borderResaltar;
	}

	public Boolean getMostraridPosicionesBancarias() {
		return this.mostraridPosicionesBancarias;
	}

	public void setMostraridPosicionesBancarias(Boolean mostraridPosicionesBancarias) {
		this.mostraridPosicionesBancarias= mostraridPosicionesBancarias;
	}

	public Boolean getActivaridPosicionesBancarias() {
		return this.activaridPosicionesBancarias;
	}

	public void setActivaridPosicionesBancarias(Boolean activaridPosicionesBancarias) {
		this.activaridPosicionesBancarias= activaridPosicionesBancarias;
	}

	public Border setResaltarid_empresaPosicionesBancarias(ParametroGeneralUsuario parametroGeneralUsuario/*PosicionesBancariasBeanSwingJInternalFrame posicionesbancariasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//posicionesbancariasBeanSwingJInternalFrame.jTtoolBarPosicionesBancarias.setBorder(borderResaltar);
		
		this.resaltarid_empresaPosicionesBancarias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaPosicionesBancarias() {
		return this.resaltarid_empresaPosicionesBancarias;
	}

	public void setResaltarid_empresaPosicionesBancarias(Border borderResaltar) {
		this.resaltarid_empresaPosicionesBancarias= borderResaltar;
	}

	public Boolean getMostrarid_empresaPosicionesBancarias() {
		return this.mostrarid_empresaPosicionesBancarias;
	}

	public void setMostrarid_empresaPosicionesBancarias(Boolean mostrarid_empresaPosicionesBancarias) {
		this.mostrarid_empresaPosicionesBancarias= mostrarid_empresaPosicionesBancarias;
	}

	public Boolean getActivarid_empresaPosicionesBancarias() {
		return this.activarid_empresaPosicionesBancarias;
	}

	public void setActivarid_empresaPosicionesBancarias(Boolean activarid_empresaPosicionesBancarias) {
		this.activarid_empresaPosicionesBancarias= activarid_empresaPosicionesBancarias;
	}

	public Boolean getCargarid_empresaPosicionesBancarias() {
		return this.cargarid_empresaPosicionesBancarias;
	}

	public void setCargarid_empresaPosicionesBancarias(Boolean cargarid_empresaPosicionesBancarias) {
		this.cargarid_empresaPosicionesBancarias= cargarid_empresaPosicionesBancarias;
	}

	public Border setResaltarid_ejercicioPosicionesBancarias(ParametroGeneralUsuario parametroGeneralUsuario/*PosicionesBancariasBeanSwingJInternalFrame posicionesbancariasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//posicionesbancariasBeanSwingJInternalFrame.jTtoolBarPosicionesBancarias.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioPosicionesBancarias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioPosicionesBancarias() {
		return this.resaltarid_ejercicioPosicionesBancarias;
	}

	public void setResaltarid_ejercicioPosicionesBancarias(Border borderResaltar) {
		this.resaltarid_ejercicioPosicionesBancarias= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioPosicionesBancarias() {
		return this.mostrarid_ejercicioPosicionesBancarias;
	}

	public void setMostrarid_ejercicioPosicionesBancarias(Boolean mostrarid_ejercicioPosicionesBancarias) {
		this.mostrarid_ejercicioPosicionesBancarias= mostrarid_ejercicioPosicionesBancarias;
	}

	public Boolean getActivarid_ejercicioPosicionesBancarias() {
		return this.activarid_ejercicioPosicionesBancarias;
	}

	public void setActivarid_ejercicioPosicionesBancarias(Boolean activarid_ejercicioPosicionesBancarias) {
		this.activarid_ejercicioPosicionesBancarias= activarid_ejercicioPosicionesBancarias;
	}

	public Boolean getCargarid_ejercicioPosicionesBancarias() {
		return this.cargarid_ejercicioPosicionesBancarias;
	}

	public void setCargarid_ejercicioPosicionesBancarias(Boolean cargarid_ejercicioPosicionesBancarias) {
		this.cargarid_ejercicioPosicionesBancarias= cargarid_ejercicioPosicionesBancarias;
	}

	public Border setResaltarid_tipo_movimientoPosicionesBancarias(ParametroGeneralUsuario parametroGeneralUsuario/*PosicionesBancariasBeanSwingJInternalFrame posicionesbancariasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//posicionesbancariasBeanSwingJInternalFrame.jTtoolBarPosicionesBancarias.setBorder(borderResaltar);
		
		this.resaltarid_tipo_movimientoPosicionesBancarias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_movimientoPosicionesBancarias() {
		return this.resaltarid_tipo_movimientoPosicionesBancarias;
	}

	public void setResaltarid_tipo_movimientoPosicionesBancarias(Border borderResaltar) {
		this.resaltarid_tipo_movimientoPosicionesBancarias= borderResaltar;
	}

	public Boolean getMostrarid_tipo_movimientoPosicionesBancarias() {
		return this.mostrarid_tipo_movimientoPosicionesBancarias;
	}

	public void setMostrarid_tipo_movimientoPosicionesBancarias(Boolean mostrarid_tipo_movimientoPosicionesBancarias) {
		this.mostrarid_tipo_movimientoPosicionesBancarias= mostrarid_tipo_movimientoPosicionesBancarias;
	}

	public Boolean getActivarid_tipo_movimientoPosicionesBancarias() {
		return this.activarid_tipo_movimientoPosicionesBancarias;
	}

	public void setActivarid_tipo_movimientoPosicionesBancarias(Boolean activarid_tipo_movimientoPosicionesBancarias) {
		this.activarid_tipo_movimientoPosicionesBancarias= activarid_tipo_movimientoPosicionesBancarias;
	}

	public Boolean getCargarid_tipo_movimientoPosicionesBancarias() {
		return this.cargarid_tipo_movimientoPosicionesBancarias;
	}

	public void setCargarid_tipo_movimientoPosicionesBancarias(Boolean cargarid_tipo_movimientoPosicionesBancarias) {
		this.cargarid_tipo_movimientoPosicionesBancarias= cargarid_tipo_movimientoPosicionesBancarias;
	}

	public Border setResaltarfecha_desdePosicionesBancarias(ParametroGeneralUsuario parametroGeneralUsuario/*PosicionesBancariasBeanSwingJInternalFrame posicionesbancariasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//posicionesbancariasBeanSwingJInternalFrame.jTtoolBarPosicionesBancarias.setBorder(borderResaltar);
		
		this.resaltarfecha_desdePosicionesBancarias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_desdePosicionesBancarias() {
		return this.resaltarfecha_desdePosicionesBancarias;
	}

	public void setResaltarfecha_desdePosicionesBancarias(Border borderResaltar) {
		this.resaltarfecha_desdePosicionesBancarias= borderResaltar;
	}

	public Boolean getMostrarfecha_desdePosicionesBancarias() {
		return this.mostrarfecha_desdePosicionesBancarias;
	}

	public void setMostrarfecha_desdePosicionesBancarias(Boolean mostrarfecha_desdePosicionesBancarias) {
		this.mostrarfecha_desdePosicionesBancarias= mostrarfecha_desdePosicionesBancarias;
	}

	public Boolean getActivarfecha_desdePosicionesBancarias() {
		return this.activarfecha_desdePosicionesBancarias;
	}

	public void setActivarfecha_desdePosicionesBancarias(Boolean activarfecha_desdePosicionesBancarias) {
		this.activarfecha_desdePosicionesBancarias= activarfecha_desdePosicionesBancarias;
	}

	public Border setResaltarfecha_hastaPosicionesBancarias(ParametroGeneralUsuario parametroGeneralUsuario/*PosicionesBancariasBeanSwingJInternalFrame posicionesbancariasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//posicionesbancariasBeanSwingJInternalFrame.jTtoolBarPosicionesBancarias.setBorder(borderResaltar);
		
		this.resaltarfecha_hastaPosicionesBancarias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_hastaPosicionesBancarias() {
		return this.resaltarfecha_hastaPosicionesBancarias;
	}

	public void setResaltarfecha_hastaPosicionesBancarias(Border borderResaltar) {
		this.resaltarfecha_hastaPosicionesBancarias= borderResaltar;
	}

	public Boolean getMostrarfecha_hastaPosicionesBancarias() {
		return this.mostrarfecha_hastaPosicionesBancarias;
	}

	public void setMostrarfecha_hastaPosicionesBancarias(Boolean mostrarfecha_hastaPosicionesBancarias) {
		this.mostrarfecha_hastaPosicionesBancarias= mostrarfecha_hastaPosicionesBancarias;
	}

	public Boolean getActivarfecha_hastaPosicionesBancarias() {
		return this.activarfecha_hastaPosicionesBancarias;
	}

	public void setActivarfecha_hastaPosicionesBancarias(Boolean activarfecha_hastaPosicionesBancarias) {
		this.activarfecha_hastaPosicionesBancarias= activarfecha_hastaPosicionesBancarias;
	}

	public Border setResaltarorden_desdePosicionesBancarias(ParametroGeneralUsuario parametroGeneralUsuario/*PosicionesBancariasBeanSwingJInternalFrame posicionesbancariasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//posicionesbancariasBeanSwingJInternalFrame.jTtoolBarPosicionesBancarias.setBorder(borderResaltar);
		
		this.resaltarorden_desdePosicionesBancarias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarorden_desdePosicionesBancarias() {
		return this.resaltarorden_desdePosicionesBancarias;
	}

	public void setResaltarorden_desdePosicionesBancarias(Border borderResaltar) {
		this.resaltarorden_desdePosicionesBancarias= borderResaltar;
	}

	public Boolean getMostrarorden_desdePosicionesBancarias() {
		return this.mostrarorden_desdePosicionesBancarias;
	}

	public void setMostrarorden_desdePosicionesBancarias(Boolean mostrarorden_desdePosicionesBancarias) {
		this.mostrarorden_desdePosicionesBancarias= mostrarorden_desdePosicionesBancarias;
	}

	public Boolean getActivarorden_desdePosicionesBancarias() {
		return this.activarorden_desdePosicionesBancarias;
	}

	public void setActivarorden_desdePosicionesBancarias(Boolean activarorden_desdePosicionesBancarias) {
		this.activarorden_desdePosicionesBancarias= activarorden_desdePosicionesBancarias;
	}

	public Border setResaltarorden_hastaPosicionesBancarias(ParametroGeneralUsuario parametroGeneralUsuario/*PosicionesBancariasBeanSwingJInternalFrame posicionesbancariasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//posicionesbancariasBeanSwingJInternalFrame.jTtoolBarPosicionesBancarias.setBorder(borderResaltar);
		
		this.resaltarorden_hastaPosicionesBancarias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarorden_hastaPosicionesBancarias() {
		return this.resaltarorden_hastaPosicionesBancarias;
	}

	public void setResaltarorden_hastaPosicionesBancarias(Border borderResaltar) {
		this.resaltarorden_hastaPosicionesBancarias= borderResaltar;
	}

	public Boolean getMostrarorden_hastaPosicionesBancarias() {
		return this.mostrarorden_hastaPosicionesBancarias;
	}

	public void setMostrarorden_hastaPosicionesBancarias(Boolean mostrarorden_hastaPosicionesBancarias) {
		this.mostrarorden_hastaPosicionesBancarias= mostrarorden_hastaPosicionesBancarias;
	}

	public Boolean getActivarorden_hastaPosicionesBancarias() {
		return this.activarorden_hastaPosicionesBancarias;
	}

	public void setActivarorden_hastaPosicionesBancarias(Boolean activarorden_hastaPosicionesBancarias) {
		this.activarorden_hastaPosicionesBancarias= activarorden_hastaPosicionesBancarias;
	}

	public Border setResaltartipo_documentoPosicionesBancarias(ParametroGeneralUsuario parametroGeneralUsuario/*PosicionesBancariasBeanSwingJInternalFrame posicionesbancariasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//posicionesbancariasBeanSwingJInternalFrame.jTtoolBarPosicionesBancarias.setBorder(borderResaltar);
		
		this.resaltartipo_documentoPosicionesBancarias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartipo_documentoPosicionesBancarias() {
		return this.resaltartipo_documentoPosicionesBancarias;
	}

	public void setResaltartipo_documentoPosicionesBancarias(Border borderResaltar) {
		this.resaltartipo_documentoPosicionesBancarias= borderResaltar;
	}

	public Boolean getMostrartipo_documentoPosicionesBancarias() {
		return this.mostrartipo_documentoPosicionesBancarias;
	}

	public void setMostrartipo_documentoPosicionesBancarias(Boolean mostrartipo_documentoPosicionesBancarias) {
		this.mostrartipo_documentoPosicionesBancarias= mostrartipo_documentoPosicionesBancarias;
	}

	public Boolean getActivartipo_documentoPosicionesBancarias() {
		return this.activartipo_documentoPosicionesBancarias;
	}

	public void setActivartipo_documentoPosicionesBancarias(Boolean activartipo_documentoPosicionesBancarias) {
		this.activartipo_documentoPosicionesBancarias= activartipo_documentoPosicionesBancarias;
	}

	public Border setResaltardetallePosicionesBancarias(ParametroGeneralUsuario parametroGeneralUsuario/*PosicionesBancariasBeanSwingJInternalFrame posicionesbancariasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//posicionesbancariasBeanSwingJInternalFrame.jTtoolBarPosicionesBancarias.setBorder(borderResaltar);
		
		this.resaltardetallePosicionesBancarias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardetallePosicionesBancarias() {
		return this.resaltardetallePosicionesBancarias;
	}

	public void setResaltardetallePosicionesBancarias(Border borderResaltar) {
		this.resaltardetallePosicionesBancarias= borderResaltar;
	}

	public Boolean getMostrardetallePosicionesBancarias() {
		return this.mostrardetallePosicionesBancarias;
	}

	public void setMostrardetallePosicionesBancarias(Boolean mostrardetallePosicionesBancarias) {
		this.mostrardetallePosicionesBancarias= mostrardetallePosicionesBancarias;
	}

	public Boolean getActivardetallePosicionesBancarias() {
		return this.activardetallePosicionesBancarias;
	}

	public void setActivardetallePosicionesBancarias(Boolean activardetallePosicionesBancarias) {
		this.activardetallePosicionesBancarias= activardetallePosicionesBancarias;
	}

	public Border setResaltarcodigo_cuentaPosicionesBancarias(ParametroGeneralUsuario parametroGeneralUsuario/*PosicionesBancariasBeanSwingJInternalFrame posicionesbancariasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//posicionesbancariasBeanSwingJInternalFrame.jTtoolBarPosicionesBancarias.setBorder(borderResaltar);
		
		this.resaltarcodigo_cuentaPosicionesBancarias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_cuentaPosicionesBancarias() {
		return this.resaltarcodigo_cuentaPosicionesBancarias;
	}

	public void setResaltarcodigo_cuentaPosicionesBancarias(Border borderResaltar) {
		this.resaltarcodigo_cuentaPosicionesBancarias= borderResaltar;
	}

	public Boolean getMostrarcodigo_cuentaPosicionesBancarias() {
		return this.mostrarcodigo_cuentaPosicionesBancarias;
	}

	public void setMostrarcodigo_cuentaPosicionesBancarias(Boolean mostrarcodigo_cuentaPosicionesBancarias) {
		this.mostrarcodigo_cuentaPosicionesBancarias= mostrarcodigo_cuentaPosicionesBancarias;
	}

	public Boolean getActivarcodigo_cuentaPosicionesBancarias() {
		return this.activarcodigo_cuentaPosicionesBancarias;
	}

	public void setActivarcodigo_cuentaPosicionesBancarias(Boolean activarcodigo_cuentaPosicionesBancarias) {
		this.activarcodigo_cuentaPosicionesBancarias= activarcodigo_cuentaPosicionesBancarias;
	}

	public Border setResaltarnombre_cuentaPosicionesBancarias(ParametroGeneralUsuario parametroGeneralUsuario/*PosicionesBancariasBeanSwingJInternalFrame posicionesbancariasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//posicionesbancariasBeanSwingJInternalFrame.jTtoolBarPosicionesBancarias.setBorder(borderResaltar);
		
		this.resaltarnombre_cuentaPosicionesBancarias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_cuentaPosicionesBancarias() {
		return this.resaltarnombre_cuentaPosicionesBancarias;
	}

	public void setResaltarnombre_cuentaPosicionesBancarias(Border borderResaltar) {
		this.resaltarnombre_cuentaPosicionesBancarias= borderResaltar;
	}

	public Boolean getMostrarnombre_cuentaPosicionesBancarias() {
		return this.mostrarnombre_cuentaPosicionesBancarias;
	}

	public void setMostrarnombre_cuentaPosicionesBancarias(Boolean mostrarnombre_cuentaPosicionesBancarias) {
		this.mostrarnombre_cuentaPosicionesBancarias= mostrarnombre_cuentaPosicionesBancarias;
	}

	public Boolean getActivarnombre_cuentaPosicionesBancarias() {
		return this.activarnombre_cuentaPosicionesBancarias;
	}

	public void setActivarnombre_cuentaPosicionesBancarias(Boolean activarnombre_cuentaPosicionesBancarias) {
		this.activarnombre_cuentaPosicionesBancarias= activarnombre_cuentaPosicionesBancarias;
	}

	public Border setResaltarnumero_mayorPosicionesBancarias(ParametroGeneralUsuario parametroGeneralUsuario/*PosicionesBancariasBeanSwingJInternalFrame posicionesbancariasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//posicionesbancariasBeanSwingJInternalFrame.jTtoolBarPosicionesBancarias.setBorder(borderResaltar);
		
		this.resaltarnumero_mayorPosicionesBancarias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_mayorPosicionesBancarias() {
		return this.resaltarnumero_mayorPosicionesBancarias;
	}

	public void setResaltarnumero_mayorPosicionesBancarias(Border borderResaltar) {
		this.resaltarnumero_mayorPosicionesBancarias= borderResaltar;
	}

	public Boolean getMostrarnumero_mayorPosicionesBancarias() {
		return this.mostrarnumero_mayorPosicionesBancarias;
	}

	public void setMostrarnumero_mayorPosicionesBancarias(Boolean mostrarnumero_mayorPosicionesBancarias) {
		this.mostrarnumero_mayorPosicionesBancarias= mostrarnumero_mayorPosicionesBancarias;
	}

	public Boolean getActivarnumero_mayorPosicionesBancarias() {
		return this.activarnumero_mayorPosicionesBancarias;
	}

	public void setActivarnumero_mayorPosicionesBancarias(Boolean activarnumero_mayorPosicionesBancarias) {
		this.activarnumero_mayorPosicionesBancarias= activarnumero_mayorPosicionesBancarias;
	}

	public Border setResaltardebito_localPosicionesBancarias(ParametroGeneralUsuario parametroGeneralUsuario/*PosicionesBancariasBeanSwingJInternalFrame posicionesbancariasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//posicionesbancariasBeanSwingJInternalFrame.jTtoolBarPosicionesBancarias.setBorder(borderResaltar);
		
		this.resaltardebito_localPosicionesBancarias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardebito_localPosicionesBancarias() {
		return this.resaltardebito_localPosicionesBancarias;
	}

	public void setResaltardebito_localPosicionesBancarias(Border borderResaltar) {
		this.resaltardebito_localPosicionesBancarias= borderResaltar;
	}

	public Boolean getMostrardebito_localPosicionesBancarias() {
		return this.mostrardebito_localPosicionesBancarias;
	}

	public void setMostrardebito_localPosicionesBancarias(Boolean mostrardebito_localPosicionesBancarias) {
		this.mostrardebito_localPosicionesBancarias= mostrardebito_localPosicionesBancarias;
	}

	public Boolean getActivardebito_localPosicionesBancarias() {
		return this.activardebito_localPosicionesBancarias;
	}

	public void setActivardebito_localPosicionesBancarias(Boolean activardebito_localPosicionesBancarias) {
		this.activardebito_localPosicionesBancarias= activardebito_localPosicionesBancarias;
	}

	public Border setResaltarcredito_localPosicionesBancarias(ParametroGeneralUsuario parametroGeneralUsuario/*PosicionesBancariasBeanSwingJInternalFrame posicionesbancariasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//posicionesbancariasBeanSwingJInternalFrame.jTtoolBarPosicionesBancarias.setBorder(borderResaltar);
		
		this.resaltarcredito_localPosicionesBancarias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcredito_localPosicionesBancarias() {
		return this.resaltarcredito_localPosicionesBancarias;
	}

	public void setResaltarcredito_localPosicionesBancarias(Border borderResaltar) {
		this.resaltarcredito_localPosicionesBancarias= borderResaltar;
	}

	public Boolean getMostrarcredito_localPosicionesBancarias() {
		return this.mostrarcredito_localPosicionesBancarias;
	}

	public void setMostrarcredito_localPosicionesBancarias(Boolean mostrarcredito_localPosicionesBancarias) {
		this.mostrarcredito_localPosicionesBancarias= mostrarcredito_localPosicionesBancarias;
	}

	public Boolean getActivarcredito_localPosicionesBancarias() {
		return this.activarcredito_localPosicionesBancarias;
	}

	public void setActivarcredito_localPosicionesBancarias(Boolean activarcredito_localPosicionesBancarias) {
		this.activarcredito_localPosicionesBancarias= activarcredito_localPosicionesBancarias;
	}

	public Border setResaltartipo_movimientoPosicionesBancarias(ParametroGeneralUsuario parametroGeneralUsuario/*PosicionesBancariasBeanSwingJInternalFrame posicionesbancariasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//posicionesbancariasBeanSwingJInternalFrame.jTtoolBarPosicionesBancarias.setBorder(borderResaltar);
		
		this.resaltartipo_movimientoPosicionesBancarias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartipo_movimientoPosicionesBancarias() {
		return this.resaltartipo_movimientoPosicionesBancarias;
	}

	public void setResaltartipo_movimientoPosicionesBancarias(Border borderResaltar) {
		this.resaltartipo_movimientoPosicionesBancarias= borderResaltar;
	}

	public Boolean getMostrartipo_movimientoPosicionesBancarias() {
		return this.mostrartipo_movimientoPosicionesBancarias;
	}

	public void setMostrartipo_movimientoPosicionesBancarias(Boolean mostrartipo_movimientoPosicionesBancarias) {
		this.mostrartipo_movimientoPosicionesBancarias= mostrartipo_movimientoPosicionesBancarias;
	}

	public Boolean getActivartipo_movimientoPosicionesBancarias() {
		return this.activartipo_movimientoPosicionesBancarias;
	}

	public void setActivartipo_movimientoPosicionesBancarias(Boolean activartipo_movimientoPosicionesBancarias) {
		this.activartipo_movimientoPosicionesBancarias= activartipo_movimientoPosicionesBancarias;
	}

	public Border setResaltarfecha_emisionPosicionesBancarias(ParametroGeneralUsuario parametroGeneralUsuario/*PosicionesBancariasBeanSwingJInternalFrame posicionesbancariasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//posicionesbancariasBeanSwingJInternalFrame.jTtoolBarPosicionesBancarias.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionPosicionesBancarias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionPosicionesBancarias() {
		return this.resaltarfecha_emisionPosicionesBancarias;
	}

	public void setResaltarfecha_emisionPosicionesBancarias(Border borderResaltar) {
		this.resaltarfecha_emisionPosicionesBancarias= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionPosicionesBancarias() {
		return this.mostrarfecha_emisionPosicionesBancarias;
	}

	public void setMostrarfecha_emisionPosicionesBancarias(Boolean mostrarfecha_emisionPosicionesBancarias) {
		this.mostrarfecha_emisionPosicionesBancarias= mostrarfecha_emisionPosicionesBancarias;
	}

	public Boolean getActivarfecha_emisionPosicionesBancarias() {
		return this.activarfecha_emisionPosicionesBancarias;
	}

	public void setActivarfecha_emisionPosicionesBancarias(Boolean activarfecha_emisionPosicionesBancarias) {
		this.activarfecha_emisionPosicionesBancarias= activarfecha_emisionPosicionesBancarias;
	}

	public Border setResaltarfechaPosicionesBancarias(ParametroGeneralUsuario parametroGeneralUsuario/*PosicionesBancariasBeanSwingJInternalFrame posicionesbancariasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//posicionesbancariasBeanSwingJInternalFrame.jTtoolBarPosicionesBancarias.setBorder(borderResaltar);
		
		this.resaltarfechaPosicionesBancarias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaPosicionesBancarias() {
		return this.resaltarfechaPosicionesBancarias;
	}

	public void setResaltarfechaPosicionesBancarias(Border borderResaltar) {
		this.resaltarfechaPosicionesBancarias= borderResaltar;
	}

	public Boolean getMostrarfechaPosicionesBancarias() {
		return this.mostrarfechaPosicionesBancarias;
	}

	public void setMostrarfechaPosicionesBancarias(Boolean mostrarfechaPosicionesBancarias) {
		this.mostrarfechaPosicionesBancarias= mostrarfechaPosicionesBancarias;
	}

	public Boolean getActivarfechaPosicionesBancarias() {
		return this.activarfechaPosicionesBancarias;
	}

	public void setActivarfechaPosicionesBancarias(Boolean activarfechaPosicionesBancarias) {
		this.activarfechaPosicionesBancarias= activarfechaPosicionesBancarias;
	}

	public Border setResaltarbeneficiarioPosicionesBancarias(ParametroGeneralUsuario parametroGeneralUsuario/*PosicionesBancariasBeanSwingJInternalFrame posicionesbancariasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//posicionesbancariasBeanSwingJInternalFrame.jTtoolBarPosicionesBancarias.setBorder(borderResaltar);
		
		this.resaltarbeneficiarioPosicionesBancarias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarbeneficiarioPosicionesBancarias() {
		return this.resaltarbeneficiarioPosicionesBancarias;
	}

	public void setResaltarbeneficiarioPosicionesBancarias(Border borderResaltar) {
		this.resaltarbeneficiarioPosicionesBancarias= borderResaltar;
	}

	public Boolean getMostrarbeneficiarioPosicionesBancarias() {
		return this.mostrarbeneficiarioPosicionesBancarias;
	}

	public void setMostrarbeneficiarioPosicionesBancarias(Boolean mostrarbeneficiarioPosicionesBancarias) {
		this.mostrarbeneficiarioPosicionesBancarias= mostrarbeneficiarioPosicionesBancarias;
	}

	public Boolean getActivarbeneficiarioPosicionesBancarias() {
		return this.activarbeneficiarioPosicionesBancarias;
	}

	public void setActivarbeneficiarioPosicionesBancarias(Boolean activarbeneficiarioPosicionesBancarias) {
		this.activarbeneficiarioPosicionesBancarias= activarbeneficiarioPosicionesBancarias;
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
		
		
		this.setMostraridPosicionesBancarias(esInicial);
		this.setMostrarid_empresaPosicionesBancarias(esInicial);
		this.setMostrarid_ejercicioPosicionesBancarias(esInicial);
		this.setMostrarid_tipo_movimientoPosicionesBancarias(esInicial);
		this.setMostrarfecha_desdePosicionesBancarias(esInicial);
		this.setMostrarfecha_hastaPosicionesBancarias(esInicial);
		this.setMostrarorden_desdePosicionesBancarias(esInicial);
		this.setMostrarorden_hastaPosicionesBancarias(esInicial);
		this.setMostrartipo_documentoPosicionesBancarias(esInicial);
		this.setMostrardetallePosicionesBancarias(esInicial);
		this.setMostrarcodigo_cuentaPosicionesBancarias(esInicial);
		this.setMostrarnombre_cuentaPosicionesBancarias(esInicial);
		this.setMostrarnumero_mayorPosicionesBancarias(esInicial);
		this.setMostrardebito_localPosicionesBancarias(esInicial);
		this.setMostrarcredito_localPosicionesBancarias(esInicial);
		this.setMostrartipo_movimientoPosicionesBancarias(esInicial);
		this.setMostrarfecha_emisionPosicionesBancarias(esInicial);
		this.setMostrarfechaPosicionesBancarias(esInicial);
		this.setMostrarbeneficiarioPosicionesBancarias(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PosicionesBancariasConstantesFunciones.ID)) {
				this.setMostraridPosicionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(PosicionesBancariasConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaPosicionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(PosicionesBancariasConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioPosicionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(PosicionesBancariasConstantesFunciones.IDTIPOMOVIMIENTO)) {
				this.setMostrarid_tipo_movimientoPosicionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(PosicionesBancariasConstantesFunciones.FECHADESDE)) {
				this.setMostrarfecha_desdePosicionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(PosicionesBancariasConstantesFunciones.FECHAHASTA)) {
				this.setMostrarfecha_hastaPosicionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(PosicionesBancariasConstantesFunciones.ORDENDESDE)) {
				this.setMostrarorden_desdePosicionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(PosicionesBancariasConstantesFunciones.ORDENHASTA)) {
				this.setMostrarorden_hastaPosicionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(PosicionesBancariasConstantesFunciones.TIPODOCUMENTO)) {
				this.setMostrartipo_documentoPosicionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(PosicionesBancariasConstantesFunciones.DETALLE)) {
				this.setMostrardetallePosicionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(PosicionesBancariasConstantesFunciones.CODIGOCUENTA)) {
				this.setMostrarcodigo_cuentaPosicionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(PosicionesBancariasConstantesFunciones.NOMBRECUENTA)) {
				this.setMostrarnombre_cuentaPosicionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(PosicionesBancariasConstantesFunciones.NUMEROMAYOR)) {
				this.setMostrarnumero_mayorPosicionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(PosicionesBancariasConstantesFunciones.DEBITOLOCAL)) {
				this.setMostrardebito_localPosicionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(PosicionesBancariasConstantesFunciones.CREDITOLOCAL)) {
				this.setMostrarcredito_localPosicionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(PosicionesBancariasConstantesFunciones.TIPOMOVIMIENTO)) {
				this.setMostrartipo_movimientoPosicionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(PosicionesBancariasConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionPosicionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(PosicionesBancariasConstantesFunciones.FECHA)) {
				this.setMostrarfechaPosicionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(PosicionesBancariasConstantesFunciones.BENEFICIARIO)) {
				this.setMostrarbeneficiarioPosicionesBancarias(esAsigna);
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
		
		
		this.setActivaridPosicionesBancarias(esInicial);
		this.setActivarid_empresaPosicionesBancarias(esInicial);
		this.setActivarid_ejercicioPosicionesBancarias(esInicial);
		this.setActivarid_tipo_movimientoPosicionesBancarias(esInicial);
		this.setActivarfecha_desdePosicionesBancarias(esInicial);
		this.setActivarfecha_hastaPosicionesBancarias(esInicial);
		this.setActivarorden_desdePosicionesBancarias(esInicial);
		this.setActivarorden_hastaPosicionesBancarias(esInicial);
		this.setActivartipo_documentoPosicionesBancarias(esInicial);
		this.setActivardetallePosicionesBancarias(esInicial);
		this.setActivarcodigo_cuentaPosicionesBancarias(esInicial);
		this.setActivarnombre_cuentaPosicionesBancarias(esInicial);
		this.setActivarnumero_mayorPosicionesBancarias(esInicial);
		this.setActivardebito_localPosicionesBancarias(esInicial);
		this.setActivarcredito_localPosicionesBancarias(esInicial);
		this.setActivartipo_movimientoPosicionesBancarias(esInicial);
		this.setActivarfecha_emisionPosicionesBancarias(esInicial);
		this.setActivarfechaPosicionesBancarias(esInicial);
		this.setActivarbeneficiarioPosicionesBancarias(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PosicionesBancariasConstantesFunciones.ID)) {
				this.setActivaridPosicionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(PosicionesBancariasConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaPosicionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(PosicionesBancariasConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioPosicionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(PosicionesBancariasConstantesFunciones.IDTIPOMOVIMIENTO)) {
				this.setActivarid_tipo_movimientoPosicionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(PosicionesBancariasConstantesFunciones.FECHADESDE)) {
				this.setActivarfecha_desdePosicionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(PosicionesBancariasConstantesFunciones.FECHAHASTA)) {
				this.setActivarfecha_hastaPosicionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(PosicionesBancariasConstantesFunciones.ORDENDESDE)) {
				this.setActivarorden_desdePosicionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(PosicionesBancariasConstantesFunciones.ORDENHASTA)) {
				this.setActivarorden_hastaPosicionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(PosicionesBancariasConstantesFunciones.TIPODOCUMENTO)) {
				this.setActivartipo_documentoPosicionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(PosicionesBancariasConstantesFunciones.DETALLE)) {
				this.setActivardetallePosicionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(PosicionesBancariasConstantesFunciones.CODIGOCUENTA)) {
				this.setActivarcodigo_cuentaPosicionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(PosicionesBancariasConstantesFunciones.NOMBRECUENTA)) {
				this.setActivarnombre_cuentaPosicionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(PosicionesBancariasConstantesFunciones.NUMEROMAYOR)) {
				this.setActivarnumero_mayorPosicionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(PosicionesBancariasConstantesFunciones.DEBITOLOCAL)) {
				this.setActivardebito_localPosicionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(PosicionesBancariasConstantesFunciones.CREDITOLOCAL)) {
				this.setActivarcredito_localPosicionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(PosicionesBancariasConstantesFunciones.TIPOMOVIMIENTO)) {
				this.setActivartipo_movimientoPosicionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(PosicionesBancariasConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionPosicionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(PosicionesBancariasConstantesFunciones.FECHA)) {
				this.setActivarfechaPosicionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(PosicionesBancariasConstantesFunciones.BENEFICIARIO)) {
				this.setActivarbeneficiarioPosicionesBancarias(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,PosicionesBancariasBeanSwingJInternalFrame posicionesbancariasBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridPosicionesBancarias(esInicial);
		this.setResaltarid_empresaPosicionesBancarias(esInicial);
		this.setResaltarid_ejercicioPosicionesBancarias(esInicial);
		this.setResaltarid_tipo_movimientoPosicionesBancarias(esInicial);
		this.setResaltarfecha_desdePosicionesBancarias(esInicial);
		this.setResaltarfecha_hastaPosicionesBancarias(esInicial);
		this.setResaltarorden_desdePosicionesBancarias(esInicial);
		this.setResaltarorden_hastaPosicionesBancarias(esInicial);
		this.setResaltartipo_documentoPosicionesBancarias(esInicial);
		this.setResaltardetallePosicionesBancarias(esInicial);
		this.setResaltarcodigo_cuentaPosicionesBancarias(esInicial);
		this.setResaltarnombre_cuentaPosicionesBancarias(esInicial);
		this.setResaltarnumero_mayorPosicionesBancarias(esInicial);
		this.setResaltardebito_localPosicionesBancarias(esInicial);
		this.setResaltarcredito_localPosicionesBancarias(esInicial);
		this.setResaltartipo_movimientoPosicionesBancarias(esInicial);
		this.setResaltarfecha_emisionPosicionesBancarias(esInicial);
		this.setResaltarfechaPosicionesBancarias(esInicial);
		this.setResaltarbeneficiarioPosicionesBancarias(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PosicionesBancariasConstantesFunciones.ID)) {
				this.setResaltaridPosicionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(PosicionesBancariasConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaPosicionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(PosicionesBancariasConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioPosicionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(PosicionesBancariasConstantesFunciones.IDTIPOMOVIMIENTO)) {
				this.setResaltarid_tipo_movimientoPosicionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(PosicionesBancariasConstantesFunciones.FECHADESDE)) {
				this.setResaltarfecha_desdePosicionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(PosicionesBancariasConstantesFunciones.FECHAHASTA)) {
				this.setResaltarfecha_hastaPosicionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(PosicionesBancariasConstantesFunciones.ORDENDESDE)) {
				this.setResaltarorden_desdePosicionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(PosicionesBancariasConstantesFunciones.ORDENHASTA)) {
				this.setResaltarorden_hastaPosicionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(PosicionesBancariasConstantesFunciones.TIPODOCUMENTO)) {
				this.setResaltartipo_documentoPosicionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(PosicionesBancariasConstantesFunciones.DETALLE)) {
				this.setResaltardetallePosicionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(PosicionesBancariasConstantesFunciones.CODIGOCUENTA)) {
				this.setResaltarcodigo_cuentaPosicionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(PosicionesBancariasConstantesFunciones.NOMBRECUENTA)) {
				this.setResaltarnombre_cuentaPosicionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(PosicionesBancariasConstantesFunciones.NUMEROMAYOR)) {
				this.setResaltarnumero_mayorPosicionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(PosicionesBancariasConstantesFunciones.DEBITOLOCAL)) {
				this.setResaltardebito_localPosicionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(PosicionesBancariasConstantesFunciones.CREDITOLOCAL)) {
				this.setResaltarcredito_localPosicionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(PosicionesBancariasConstantesFunciones.TIPOMOVIMIENTO)) {
				this.setResaltartipo_movimientoPosicionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(PosicionesBancariasConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionPosicionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(PosicionesBancariasConstantesFunciones.FECHA)) {
				this.setResaltarfechaPosicionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(PosicionesBancariasConstantesFunciones.BENEFICIARIO)) {
				this.setResaltarbeneficiarioPosicionesBancarias(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,PosicionesBancariasBeanSwingJInternalFrame posicionesbancariasBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPosicionesBancariasPosicionesBancarias=true;

	public Boolean getMostrarBusquedaPosicionesBancariasPosicionesBancarias() {
		return this.mostrarBusquedaPosicionesBancariasPosicionesBancarias;
	}

	public void setMostrarBusquedaPosicionesBancariasPosicionesBancarias(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPosicionesBancariasPosicionesBancarias= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPosicionesBancariasPosicionesBancarias=true;

	public Boolean getActivarBusquedaPosicionesBancariasPosicionesBancarias() {
		return this.activarBusquedaPosicionesBancariasPosicionesBancarias;
	}

	public void setActivarBusquedaPosicionesBancariasPosicionesBancarias(Boolean habilitarResaltar) {
		this.activarBusquedaPosicionesBancariasPosicionesBancarias= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPosicionesBancariasPosicionesBancarias=null;

	public Border getResaltarBusquedaPosicionesBancariasPosicionesBancarias() {
		return this.resaltarBusquedaPosicionesBancariasPosicionesBancarias;
	}

	public void setResaltarBusquedaPosicionesBancariasPosicionesBancarias(Border borderResaltar) {
		this.resaltarBusquedaPosicionesBancariasPosicionesBancarias= borderResaltar;
	}

	public void setResaltarBusquedaPosicionesBancariasPosicionesBancarias(ParametroGeneralUsuario parametroGeneralUsuario/*PosicionesBancariasBeanSwingJInternalFrame posicionesbancariasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPosicionesBancariasPosicionesBancarias= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}