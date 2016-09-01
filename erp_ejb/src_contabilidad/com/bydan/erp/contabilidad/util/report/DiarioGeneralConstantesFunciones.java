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


import com.bydan.erp.contabilidad.util.report.DiarioGeneralConstantesFunciones;
import com.bydan.erp.contabilidad.util.report.DiarioGeneralParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.report.DiarioGeneralParameterGeneral;

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
final public class DiarioGeneralConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="DiarioGeneral";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="DiarioGeneral"+DiarioGeneralConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="DiarioGeneralHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="DiarioGeneralHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=DiarioGeneralConstantesFunciones.SCHEMA+"_"+DiarioGeneralConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/DiarioGeneralHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=DiarioGeneralConstantesFunciones.SCHEMA+"_"+DiarioGeneralConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=DiarioGeneralConstantesFunciones.SCHEMA+"_"+DiarioGeneralConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/DiarioGeneralHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=DiarioGeneralConstantesFunciones.SCHEMA+"_"+DiarioGeneralConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DiarioGeneralConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DiarioGeneralHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DiarioGeneralConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DiarioGeneralConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DiarioGeneralHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DiarioGeneralConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=DiarioGeneralConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+DiarioGeneralConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=DiarioGeneralConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+DiarioGeneralConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Diario Generales";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Diario General";
	public static final String SCLASSWEBTITULO_LOWER="Diario General";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="DiarioGeneral";
	public static final String OBJECTNAME="diariogeneral";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="diario_general";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select diariogeneral from "+DiarioGeneralConstantesFunciones.SPERSISTENCENAME+" diariogeneral";
	public static String QUERYSELECTNATIVE="select "+DiarioGeneralConstantesFunciones.SCHEMA+"."+DiarioGeneralConstantesFunciones.TABLENAME+".id,"+DiarioGeneralConstantesFunciones.SCHEMA+"."+DiarioGeneralConstantesFunciones.TABLENAME+".version_row,"+DiarioGeneralConstantesFunciones.SCHEMA+"."+DiarioGeneralConstantesFunciones.TABLENAME+".id_empresa,"+DiarioGeneralConstantesFunciones.SCHEMA+"."+DiarioGeneralConstantesFunciones.TABLENAME+".id_sucursal,"+DiarioGeneralConstantesFunciones.SCHEMA+"."+DiarioGeneralConstantesFunciones.TABLENAME+".id_ejercicio,"+DiarioGeneralConstantesFunciones.SCHEMA+"."+DiarioGeneralConstantesFunciones.TABLENAME+".id_periodo,"+DiarioGeneralConstantesFunciones.SCHEMA+"."+DiarioGeneralConstantesFunciones.TABLENAME+".id_modulo,"+DiarioGeneralConstantesFunciones.SCHEMA+"."+DiarioGeneralConstantesFunciones.TABLENAME+".id_tipo_movimiento,"+DiarioGeneralConstantesFunciones.SCHEMA+"."+DiarioGeneralConstantesFunciones.TABLENAME+".id_tipo_documento,"+DiarioGeneralConstantesFunciones.SCHEMA+"."+DiarioGeneralConstantesFunciones.TABLENAME+".fecha_inicio,"+DiarioGeneralConstantesFunciones.SCHEMA+"."+DiarioGeneralConstantesFunciones.TABLENAME+".fecha_fin,"+DiarioGeneralConstantesFunciones.SCHEMA+"."+DiarioGeneralConstantesFunciones.TABLENAME+".id_asiento_contable,"+DiarioGeneralConstantesFunciones.SCHEMA+"."+DiarioGeneralConstantesFunciones.TABLENAME+".tipo_movimiento,"+DiarioGeneralConstantesFunciones.SCHEMA+"."+DiarioGeneralConstantesFunciones.TABLENAME+".numero_mayor,"+DiarioGeneralConstantesFunciones.SCHEMA+"."+DiarioGeneralConstantesFunciones.TABLENAME+".codigo,"+DiarioGeneralConstantesFunciones.SCHEMA+"."+DiarioGeneralConstantesFunciones.TABLENAME+".nombre,"+DiarioGeneralConstantesFunciones.SCHEMA+"."+DiarioGeneralConstantesFunciones.TABLENAME+".codigo_asiento,"+DiarioGeneralConstantesFunciones.SCHEMA+"."+DiarioGeneralConstantesFunciones.TABLENAME+".debito_local,"+DiarioGeneralConstantesFunciones.SCHEMA+"."+DiarioGeneralConstantesFunciones.TABLENAME+".credito_local,"+DiarioGeneralConstantesFunciones.SCHEMA+"."+DiarioGeneralConstantesFunciones.TABLENAME+".debito_extran,"+DiarioGeneralConstantesFunciones.SCHEMA+"."+DiarioGeneralConstantesFunciones.TABLENAME+".credito_extran,"+DiarioGeneralConstantesFunciones.SCHEMA+"."+DiarioGeneralConstantesFunciones.TABLENAME+".fecha,"+DiarioGeneralConstantesFunciones.SCHEMA+"."+DiarioGeneralConstantesFunciones.TABLENAME+".detalle,"+DiarioGeneralConstantesFunciones.SCHEMA+"."+DiarioGeneralConstantesFunciones.TABLENAME+".nombre_estado from "+DiarioGeneralConstantesFunciones.SCHEMA+"."+DiarioGeneralConstantesFunciones.TABLENAME;//+" as "+DiarioGeneralConstantesFunciones.TABLENAME;
	
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
    public static final String IDPERIODO= "id_periodo";
    public static final String IDMODULO= "id_modulo";
    public static final String IDTIPOMOVIMIENTO= "id_tipo_movimiento";
    public static final String IDTIPODOCUMENTO= "id_tipo_documento";
    public static final String FECHAINICIO= "fecha_inicio";
    public static final String FECHAFIN= "fecha_fin";
    public static final String IDASIENTOCONTABLE= "id_asiento_contable";
    public static final String TIPOMOVIMIENTO= "tipo_movimiento";
    public static final String NUMEROMAYOR= "numero_mayor";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String CODIGOASIENTO= "codigo_asiento";
    public static final String DEBITOLOCAL= "debito_local";
    public static final String CREDITOLOCAL= "credito_local";
    public static final String DEBITOEXTRAN= "debito_extran";
    public static final String CREDITOEXTRAN= "credito_extran";
    public static final String FECHA= "fecha";
    public static final String DETALLE= "detalle";
    public static final String NOMBREESTADO= "nombre_estado";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_IDPERIODO= "Periodo";
		public static final String LABEL_IDPERIODO_LOWER= "Periodo";
    	public static final String LABEL_IDMODULO= "Modulo";
		public static final String LABEL_IDMODULO_LOWER= "Modulo";
    	public static final String LABEL_IDTIPOMOVIMIENTO= "Tipo Movimiento Base";
		public static final String LABEL_IDTIPOMOVIMIENTO_LOWER= "Tipo Movimiento";
    	public static final String LABEL_IDTIPODOCUMENTO= "Tipo Documento";
		public static final String LABEL_IDTIPODOCUMENTO_LOWER= "Tipo Documento";
    	public static final String LABEL_FECHAINICIO= "Fecha Inicio";
		public static final String LABEL_FECHAINICIO_LOWER= "Fecha Inicio";
    	public static final String LABEL_FECHAFIN= "Fecha Fin";
		public static final String LABEL_FECHAFIN_LOWER= "Fecha Fin";
    	public static final String LABEL_IDASIENTOCONTABLE= "Asiento Contable";
		public static final String LABEL_IDASIENTOCONTABLE_LOWER= "Asiento Contable";
    	public static final String LABEL_TIPOMOVIMIENTO= "Tipo Movimiento";
		public static final String LABEL_TIPOMOVIMIENTO_LOWER= "Tipo Movimiento";
    	public static final String LABEL_NUMEROMAYOR= "Numero Mayor";
		public static final String LABEL_NUMEROMAYOR_LOWER= "Numero Mayor";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_CODIGOASIENTO= "Codigo Asiento";
		public static final String LABEL_CODIGOASIENTO_LOWER= "Codigo Asiento";
    	public static final String LABEL_DEBITOLOCAL= "Debito";
		public static final String LABEL_DEBITOLOCAL_LOWER= "Debito Local";
    	public static final String LABEL_CREDITOLOCAL= "Credito";
		public static final String LABEL_CREDITOLOCAL_LOWER= "Credito Local";
    	public static final String LABEL_DEBITOEXTRAN= "Debito Extranjero";
		public static final String LABEL_DEBITOEXTRAN_LOWER= "Debito Extran";
    	public static final String LABEL_CREDITOEXTRAN= "Credito Extranjero";
		public static final String LABEL_CREDITOEXTRAN_LOWER= "Credito Extran";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_DETALLE= "Detalle";
		public static final String LABEL_DETALLE_LOWER= "Detalle";
    	public static final String LABEL_NOMBREESTADO= "Nombre Estado";
		public static final String LABEL_NOMBREESTADO_LOWER= "Nombre Estado";
	
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXTIPO_MOVIMIENTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXTIPO_MOVIMIENTO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_MAYOR=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_MAYOR=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO_ASIENTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_ASIENTO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
	public static final String SREGEXDETALLE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDETALLE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_ESTADO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_ESTADO=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getDiarioGeneralLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(DiarioGeneralConstantesFunciones.IDEMPRESA)) {sLabelColumna=DiarioGeneralConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(DiarioGeneralConstantesFunciones.IDSUCURSAL)) {sLabelColumna=DiarioGeneralConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(DiarioGeneralConstantesFunciones.IDEJERCICIO)) {sLabelColumna=DiarioGeneralConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(DiarioGeneralConstantesFunciones.IDPERIODO)) {sLabelColumna=DiarioGeneralConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(DiarioGeneralConstantesFunciones.IDMODULO)) {sLabelColumna=DiarioGeneralConstantesFunciones.LABEL_IDMODULO;}
		if(sNombreColumna.equals(DiarioGeneralConstantesFunciones.IDTIPOMOVIMIENTO)) {sLabelColumna=DiarioGeneralConstantesFunciones.LABEL_IDTIPOMOVIMIENTO;}
		if(sNombreColumna.equals(DiarioGeneralConstantesFunciones.IDTIPODOCUMENTO)) {sLabelColumna=DiarioGeneralConstantesFunciones.LABEL_IDTIPODOCUMENTO;}
		if(sNombreColumna.equals(DiarioGeneralConstantesFunciones.FECHAINICIO)) {sLabelColumna=DiarioGeneralConstantesFunciones.LABEL_FECHAINICIO;}
		if(sNombreColumna.equals(DiarioGeneralConstantesFunciones.FECHAFIN)) {sLabelColumna=DiarioGeneralConstantesFunciones.LABEL_FECHAFIN;}
		if(sNombreColumna.equals(DiarioGeneralConstantesFunciones.IDASIENTOCONTABLE)) {sLabelColumna=DiarioGeneralConstantesFunciones.LABEL_IDASIENTOCONTABLE;}
		if(sNombreColumna.equals(DiarioGeneralConstantesFunciones.TIPOMOVIMIENTO)) {sLabelColumna=DiarioGeneralConstantesFunciones.LABEL_TIPOMOVIMIENTO;}
		if(sNombreColumna.equals(DiarioGeneralConstantesFunciones.NUMEROMAYOR)) {sLabelColumna=DiarioGeneralConstantesFunciones.LABEL_NUMEROMAYOR;}
		if(sNombreColumna.equals(DiarioGeneralConstantesFunciones.CODIGO)) {sLabelColumna=DiarioGeneralConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(DiarioGeneralConstantesFunciones.NOMBRE)) {sLabelColumna=DiarioGeneralConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(DiarioGeneralConstantesFunciones.CODIGOASIENTO)) {sLabelColumna=DiarioGeneralConstantesFunciones.LABEL_CODIGOASIENTO;}
		if(sNombreColumna.equals(DiarioGeneralConstantesFunciones.DEBITOLOCAL)) {sLabelColumna=DiarioGeneralConstantesFunciones.LABEL_DEBITOLOCAL;}
		if(sNombreColumna.equals(DiarioGeneralConstantesFunciones.CREDITOLOCAL)) {sLabelColumna=DiarioGeneralConstantesFunciones.LABEL_CREDITOLOCAL;}
		if(sNombreColumna.equals(DiarioGeneralConstantesFunciones.DEBITOEXTRAN)) {sLabelColumna=DiarioGeneralConstantesFunciones.LABEL_DEBITOEXTRAN;}
		if(sNombreColumna.equals(DiarioGeneralConstantesFunciones.CREDITOEXTRAN)) {sLabelColumna=DiarioGeneralConstantesFunciones.LABEL_CREDITOEXTRAN;}
		if(sNombreColumna.equals(DiarioGeneralConstantesFunciones.FECHA)) {sLabelColumna=DiarioGeneralConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(DiarioGeneralConstantesFunciones.DETALLE)) {sLabelColumna=DiarioGeneralConstantesFunciones.LABEL_DETALLE;}
		if(sNombreColumna.equals(DiarioGeneralConstantesFunciones.NOMBREESTADO)) {sLabelColumna=DiarioGeneralConstantesFunciones.LABEL_NOMBREESTADO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getDiarioGeneralDescripcion(DiarioGeneral diariogeneral) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(diariogeneral !=null/* && diariogeneral.getId()!=0*/) {
			sDescripcion=diariogeneral.getcodigo();//diariogeneraldiariogeneral.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getDiarioGeneralDescripcionDetallado(DiarioGeneral diariogeneral) {
		String sDescripcion="";
			
		sDescripcion+=DiarioGeneralConstantesFunciones.ID+"=";
		sDescripcion+=diariogeneral.getId().toString()+",";
		sDescripcion+=DiarioGeneralConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=diariogeneral.getVersionRow().toString()+",";
		sDescripcion+=DiarioGeneralConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=diariogeneral.getid_empresa().toString()+",";
		sDescripcion+=DiarioGeneralConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=diariogeneral.getid_sucursal().toString()+",";
		sDescripcion+=DiarioGeneralConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=diariogeneral.getid_ejercicio().toString()+",";
		sDescripcion+=DiarioGeneralConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=diariogeneral.getid_periodo().toString()+",";
		sDescripcion+=DiarioGeneralConstantesFunciones.IDMODULO+"=";
		sDescripcion+=diariogeneral.getid_modulo().toString()+",";
		sDescripcion+=DiarioGeneralConstantesFunciones.IDTIPOMOVIMIENTO+"=";
		sDescripcion+=diariogeneral.getid_tipo_movimiento().toString()+",";
		sDescripcion+=DiarioGeneralConstantesFunciones.IDTIPODOCUMENTO+"=";
		sDescripcion+=diariogeneral.getid_tipo_documento().toString()+",";
		sDescripcion+=DiarioGeneralConstantesFunciones.FECHAINICIO+"=";
		sDescripcion+=diariogeneral.getfecha_inicio().toString()+",";
		sDescripcion+=DiarioGeneralConstantesFunciones.FECHAFIN+"=";
		sDescripcion+=diariogeneral.getfecha_fin().toString()+",";
		sDescripcion+=DiarioGeneralConstantesFunciones.IDASIENTOCONTABLE+"=";
		sDescripcion+=diariogeneral.getid_asiento_contable().toString()+",";
		sDescripcion+=DiarioGeneralConstantesFunciones.TIPOMOVIMIENTO+"=";
		sDescripcion+=diariogeneral.gettipo_movimiento()+",";
		sDescripcion+=DiarioGeneralConstantesFunciones.NUMEROMAYOR+"=";
		sDescripcion+=diariogeneral.getnumero_mayor()+",";
		sDescripcion+=DiarioGeneralConstantesFunciones.CODIGO+"=";
		sDescripcion+=diariogeneral.getcodigo()+",";
		sDescripcion+=DiarioGeneralConstantesFunciones.NOMBRE+"=";
		sDescripcion+=diariogeneral.getnombre()+",";
		sDescripcion+=DiarioGeneralConstantesFunciones.CODIGOASIENTO+"=";
		sDescripcion+=diariogeneral.getcodigo_asiento()+",";
		sDescripcion+=DiarioGeneralConstantesFunciones.DEBITOLOCAL+"=";
		sDescripcion+=diariogeneral.getdebito_local().toString()+",";
		sDescripcion+=DiarioGeneralConstantesFunciones.CREDITOLOCAL+"=";
		sDescripcion+=diariogeneral.getcredito_local().toString()+",";
		sDescripcion+=DiarioGeneralConstantesFunciones.DEBITOEXTRAN+"=";
		sDescripcion+=diariogeneral.getdebito_extran().toString()+",";
		sDescripcion+=DiarioGeneralConstantesFunciones.CREDITOEXTRAN+"=";
		sDescripcion+=diariogeneral.getcredito_extran().toString()+",";
		sDescripcion+=DiarioGeneralConstantesFunciones.FECHA+"=";
		sDescripcion+=diariogeneral.getfecha().toString()+",";
		sDescripcion+=DiarioGeneralConstantesFunciones.DETALLE+"=";
		sDescripcion+=diariogeneral.getdetalle()+",";
		sDescripcion+=DiarioGeneralConstantesFunciones.NOMBREESTADO+"=";
		sDescripcion+=diariogeneral.getnombre_estado()+",";
			
		return sDescripcion;
	}
	
	public static void setDiarioGeneralDescripcion(DiarioGeneral diariogeneral,String sValor) throws Exception {			
		if(diariogeneral !=null) {
			diariogeneral.setcodigo(sValor);;//diariogeneraldiariogeneral.getcodigo().trim();
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

	public static String getPeriodoDescripcion(Periodo periodo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(periodo!=null/*&&periodo.getId()>0*/) {
			sDescripcion=PeriodoConstantesFunciones.getPeriodoDescripcion(periodo);
		}

		return sDescripcion;
	}

	public static String getModuloDescripcion(Modulo modulo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(modulo!=null/*&&modulo.getId()>0*/) {
			sDescripcion=ModuloConstantesFunciones.getModuloDescripcion(modulo);
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

	public static String getTipoDocumentoDescripcion(TipoDocumento tipodocumento) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipodocumento!=null/*&&tipodocumento.getId()>0*/) {
			sDescripcion=TipoDocumentoConstantesFunciones.getTipoDocumentoDescripcion(tipodocumento);
		}

		return sDescripcion;
	}

	public static String getAsientoContableDescripcion(AsientoContable asientocontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(asientocontable!=null/*&&asientocontable.getId()>0*/) {
			sDescripcion=AsientoContableConstantesFunciones.getAsientoContableDescripcion(asientocontable);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaReporte")) {
			sNombreIndice="Tipo=  Por Ejercicio Por Periodo Por Modulo Por Tipo Movimiento Base Por Tipo Documento Por Fecha Inicio Por Fecha Fin";
		} else if(sNombreIndice.equals("FK_IdAsientoContable")) {
			sNombreIndice="Tipo=  Por Asiento Contable";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdModulo")) {
			sNombreIndice="Tipo=  Por Modulo";
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoDocumento")) {
			sNombreIndice="Tipo=  Por Tipo Documento";
		} else if(sNombreIndice.equals("FK_IdTipoMovimiento")) {
			sNombreIndice="Tipo=  Por Tipo Movimiento Base";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaReporte(Long id_ejercicio,Long id_periodo,Long id_modulo,Long id_tipo_movimiento,Long id_tipo_documento,Date fecha_inicio,Date fecha_fin) {
		String sDetalleIndice=" Parametros->";
		if(id_ejercicio!=null) {sDetalleIndice+=" Codigo Unico De Ejercicio="+id_ejercicio.toString();}
		if(id_periodo!=null) {sDetalleIndice+=" Codigo Unico De Periodo="+id_periodo.toString();}
		if(id_modulo!=null) {sDetalleIndice+=" Codigo Unico De Modulo="+id_modulo.toString();}
		if(id_tipo_movimiento!=null) {sDetalleIndice+=" Codigo Unico De Tipo Movimiento Base="+id_tipo_movimiento.toString();}
		if(id_tipo_documento!=null) {sDetalleIndice+=" Codigo Unico De Tipo Documento="+id_tipo_documento.toString();}
		if(fecha_inicio!=null) {sDetalleIndice+=" Fecha Inicio="+fecha_inicio.toString();}
		if(fecha_fin!=null) {sDetalleIndice+=" Fecha Fin="+fecha_fin.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdAsientoContable(Long id_asiento_contable) {
		String sDetalleIndice=" Parametros->";
		if(id_asiento_contable!=null) {sDetalleIndice+=" Codigo Unico De Asiento Contable="+id_asiento_contable.toString();} 

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

	public static String getDetalleIndiceFK_IdModulo(Long id_modulo) {
		String sDetalleIndice=" Parametros->";
		if(id_modulo!=null) {sDetalleIndice+=" Codigo Unico De Modulo="+id_modulo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPeriodo(Long id_periodo) {
		String sDetalleIndice=" Parametros->";
		if(id_periodo!=null) {sDetalleIndice+=" Codigo Unico De Periodo="+id_periodo.toString();} 

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
		if(id_tipo_movimiento!=null) {sDetalleIndice+=" Codigo Unico De Tipo Movimiento Base="+id_tipo_movimiento.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosDiarioGeneral(DiarioGeneral diariogeneral,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		diariogeneral.settipo_movimiento(diariogeneral.gettipo_movimiento().trim());
		diariogeneral.setnumero_mayor(diariogeneral.getnumero_mayor().trim());
		diariogeneral.setcodigo(diariogeneral.getcodigo().trim());
		diariogeneral.setnombre(diariogeneral.getnombre().trim());
		diariogeneral.setcodigo_asiento(diariogeneral.getcodigo_asiento().trim());
		diariogeneral.setdetalle(diariogeneral.getdetalle().trim());
		diariogeneral.setnombre_estado(diariogeneral.getnombre_estado().trim());
	}
	
	public static void quitarEspaciosDiarioGenerals(List<DiarioGeneral> diariogenerals,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DiarioGeneral diariogeneral: diariogenerals) {
			diariogeneral.settipo_movimiento(diariogeneral.gettipo_movimiento().trim());
			diariogeneral.setnumero_mayor(diariogeneral.getnumero_mayor().trim());
			diariogeneral.setcodigo(diariogeneral.getcodigo().trim());
			diariogeneral.setnombre(diariogeneral.getnombre().trim());
			diariogeneral.setcodigo_asiento(diariogeneral.getcodigo_asiento().trim());
			diariogeneral.setdetalle(diariogeneral.getdetalle().trim());
			diariogeneral.setnombre_estado(diariogeneral.getnombre_estado().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDiarioGeneral(DiarioGeneral diariogeneral,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && diariogeneral.getConCambioAuxiliar()) {
			diariogeneral.setIsDeleted(diariogeneral.getIsDeletedAuxiliar());	
			diariogeneral.setIsNew(diariogeneral.getIsNewAuxiliar());	
			diariogeneral.setIsChanged(diariogeneral.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			diariogeneral.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			diariogeneral.setIsDeletedAuxiliar(false);	
			diariogeneral.setIsNewAuxiliar(false);	
			diariogeneral.setIsChangedAuxiliar(false);
			
			diariogeneral.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDiarioGenerals(List<DiarioGeneral> diariogenerals,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(DiarioGeneral diariogeneral : diariogenerals) {
			if(conAsignarBase && diariogeneral.getConCambioAuxiliar()) {
				diariogeneral.setIsDeleted(diariogeneral.getIsDeletedAuxiliar());	
				diariogeneral.setIsNew(diariogeneral.getIsNewAuxiliar());	
				diariogeneral.setIsChanged(diariogeneral.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				diariogeneral.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				diariogeneral.setIsDeletedAuxiliar(false);	
				diariogeneral.setIsNewAuxiliar(false);	
				diariogeneral.setIsChangedAuxiliar(false);
				
				diariogeneral.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresDiarioGeneral(DiarioGeneral diariogeneral,Boolean conEnteros) throws Exception  {
		diariogeneral.setdebito_local(0.0);
		diariogeneral.setcredito_local(0.0);
		diariogeneral.setdebito_extran(0.0);
		diariogeneral.setcredito_extran(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresDiarioGenerals(List<DiarioGeneral> diariogenerals,Boolean conEnteros) throws Exception  {
		
		for(DiarioGeneral diariogeneral: diariogenerals) {
			diariogeneral.setdebito_local(0.0);
			diariogeneral.setcredito_local(0.0);
			diariogeneral.setdebito_extran(0.0);
			diariogeneral.setcredito_extran(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaDiarioGeneral(List<DiarioGeneral> diariogenerals,DiarioGeneral diariogeneralAux) throws Exception  {
		DiarioGeneralConstantesFunciones.InicializarValoresDiarioGeneral(diariogeneralAux,true);
		
		for(DiarioGeneral diariogeneral: diariogenerals) {
			if(diariogeneral.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			diariogeneralAux.setdebito_local(diariogeneralAux.getdebito_local()+diariogeneral.getdebito_local());			
			diariogeneralAux.setcredito_local(diariogeneralAux.getcredito_local()+diariogeneral.getcredito_local());			
			diariogeneralAux.setdebito_extran(diariogeneralAux.getdebito_extran()+diariogeneral.getdebito_extran());			
			diariogeneralAux.setcredito_extran(diariogeneralAux.getcredito_extran()+diariogeneral.getcredito_extran());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDiarioGeneral(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=DiarioGeneralConstantesFunciones.getArrayColumnasGlobalesDiarioGeneral(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesDiarioGeneral(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DiarioGeneralConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DiarioGeneralConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DiarioGeneralConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DiarioGeneralConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DiarioGeneralConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DiarioGeneralConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DiarioGeneralConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DiarioGeneralConstantesFunciones.IDPERIODO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DiarioGeneralConstantesFunciones.IDMODULO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DiarioGeneralConstantesFunciones.IDMODULO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoDiarioGeneral(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DiarioGeneral> diariogenerals,DiarioGeneral diariogeneral,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DiarioGeneral diariogeneralAux: diariogenerals) {
			if(diariogeneralAux!=null && diariogeneral!=null) {
				if((diariogeneralAux.getId()==null && diariogeneral.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(diariogeneralAux.getId()!=null && diariogeneral.getId()!=null){
					if(diariogeneralAux.getId().equals(diariogeneral.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDiarioGeneral(List<DiarioGeneral> diariogenerals) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double debito_localTotal=0.0;
		Double credito_localTotal=0.0;
		Double debito_extranTotal=0.0;
		Double credito_extranTotal=0.0;
	
		for(DiarioGeneral diariogeneral: diariogenerals) {			
			if(diariogeneral.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			debito_localTotal+=diariogeneral.getdebito_local();
			credito_localTotal+=diariogeneral.getcredito_local();
			debito_extranTotal+=diariogeneral.getdebito_extran();
			credito_extranTotal+=diariogeneral.getcredito_extran();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DiarioGeneralConstantesFunciones.DEBITOLOCAL);
		datoGeneral.setsDescripcion(DiarioGeneralConstantesFunciones.LABEL_DEBITOLOCAL);
		datoGeneral.setdValorDouble(debito_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DiarioGeneralConstantesFunciones.CREDITOLOCAL);
		datoGeneral.setsDescripcion(DiarioGeneralConstantesFunciones.LABEL_CREDITOLOCAL);
		datoGeneral.setdValorDouble(credito_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DiarioGeneralConstantesFunciones.DEBITOEXTRAN);
		datoGeneral.setsDescripcion(DiarioGeneralConstantesFunciones.LABEL_DEBITOEXTRAN);
		datoGeneral.setdValorDouble(debito_extranTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DiarioGeneralConstantesFunciones.CREDITOEXTRAN);
		datoGeneral.setsDescripcion(DiarioGeneralConstantesFunciones.LABEL_CREDITOEXTRAN);
		datoGeneral.setdValorDouble(credito_extranTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaDiarioGeneral() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,DiarioGeneralConstantesFunciones.LABEL_ID, DiarioGeneralConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DiarioGeneralConstantesFunciones.LABEL_VERSIONROW, DiarioGeneralConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DiarioGeneralConstantesFunciones.LABEL_IDASIENTOCONTABLE, DiarioGeneralConstantesFunciones.IDASIENTOCONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DiarioGeneralConstantesFunciones.LABEL_TIPOMOVIMIENTO, DiarioGeneralConstantesFunciones.TIPOMOVIMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DiarioGeneralConstantesFunciones.LABEL_NUMEROMAYOR, DiarioGeneralConstantesFunciones.NUMEROMAYOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DiarioGeneralConstantesFunciones.LABEL_CODIGO, DiarioGeneralConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DiarioGeneralConstantesFunciones.LABEL_NOMBRE, DiarioGeneralConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DiarioGeneralConstantesFunciones.LABEL_CODIGOASIENTO, DiarioGeneralConstantesFunciones.CODIGOASIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DiarioGeneralConstantesFunciones.LABEL_DEBITOLOCAL, DiarioGeneralConstantesFunciones.DEBITOLOCAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DiarioGeneralConstantesFunciones.LABEL_CREDITOLOCAL, DiarioGeneralConstantesFunciones.CREDITOLOCAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DiarioGeneralConstantesFunciones.LABEL_DEBITOEXTRAN, DiarioGeneralConstantesFunciones.DEBITOEXTRAN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DiarioGeneralConstantesFunciones.LABEL_CREDITOEXTRAN, DiarioGeneralConstantesFunciones.CREDITOEXTRAN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DiarioGeneralConstantesFunciones.LABEL_FECHA, DiarioGeneralConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DiarioGeneralConstantesFunciones.LABEL_DETALLE, DiarioGeneralConstantesFunciones.DETALLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DiarioGeneralConstantesFunciones.LABEL_NOMBREESTADO, DiarioGeneralConstantesFunciones.NOMBREESTADO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasDiarioGeneral() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=DiarioGeneralConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DiarioGeneralConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DiarioGeneralConstantesFunciones.IDASIENTOCONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DiarioGeneralConstantesFunciones.TIPOMOVIMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DiarioGeneralConstantesFunciones.NUMEROMAYOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DiarioGeneralConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DiarioGeneralConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DiarioGeneralConstantesFunciones.CODIGOASIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DiarioGeneralConstantesFunciones.DEBITOLOCAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DiarioGeneralConstantesFunciones.CREDITOLOCAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DiarioGeneralConstantesFunciones.DEBITOEXTRAN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DiarioGeneralConstantesFunciones.CREDITOEXTRAN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DiarioGeneralConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DiarioGeneralConstantesFunciones.DETALLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DiarioGeneralConstantesFunciones.NOMBREESTADO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDiarioGeneral() throws Exception  {
		return DiarioGeneralConstantesFunciones.getTiposSeleccionarDiarioGeneral(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDiarioGeneral(Boolean conFk) throws Exception  {
		return DiarioGeneralConstantesFunciones.getTiposSeleccionarDiarioGeneral(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDiarioGeneral(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DiarioGeneralConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(DiarioGeneralConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DiarioGeneralConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(DiarioGeneralConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DiarioGeneralConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(DiarioGeneralConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DiarioGeneralConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(DiarioGeneralConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DiarioGeneralConstantesFunciones.LABEL_IDMODULO);
			reporte.setsDescripcion(DiarioGeneralConstantesFunciones.LABEL_IDMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DiarioGeneralConstantesFunciones.LABEL_IDTIPOMOVIMIENTO);
			reporte.setsDescripcion(DiarioGeneralConstantesFunciones.LABEL_IDTIPOMOVIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DiarioGeneralConstantesFunciones.LABEL_IDTIPODOCUMENTO);
			reporte.setsDescripcion(DiarioGeneralConstantesFunciones.LABEL_IDTIPODOCUMENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DiarioGeneralConstantesFunciones.LABEL_FECHAINICIO);
			reporte.setsDescripcion(DiarioGeneralConstantesFunciones.LABEL_FECHAINICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DiarioGeneralConstantesFunciones.LABEL_FECHAFIN);
			reporte.setsDescripcion(DiarioGeneralConstantesFunciones.LABEL_FECHAFIN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DiarioGeneralConstantesFunciones.LABEL_IDASIENTOCONTABLE);
			reporte.setsDescripcion(DiarioGeneralConstantesFunciones.LABEL_IDASIENTOCONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DiarioGeneralConstantesFunciones.LABEL_TIPOMOVIMIENTO);
			reporte.setsDescripcion(DiarioGeneralConstantesFunciones.LABEL_TIPOMOVIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DiarioGeneralConstantesFunciones.LABEL_NUMEROMAYOR);
			reporte.setsDescripcion(DiarioGeneralConstantesFunciones.LABEL_NUMEROMAYOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DiarioGeneralConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(DiarioGeneralConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DiarioGeneralConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(DiarioGeneralConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DiarioGeneralConstantesFunciones.LABEL_CODIGOASIENTO);
			reporte.setsDescripcion(DiarioGeneralConstantesFunciones.LABEL_CODIGOASIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DiarioGeneralConstantesFunciones.LABEL_DEBITOLOCAL);
			reporte.setsDescripcion(DiarioGeneralConstantesFunciones.LABEL_DEBITOLOCAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DiarioGeneralConstantesFunciones.LABEL_CREDITOLOCAL);
			reporte.setsDescripcion(DiarioGeneralConstantesFunciones.LABEL_CREDITOLOCAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DiarioGeneralConstantesFunciones.LABEL_DEBITOEXTRAN);
			reporte.setsDescripcion(DiarioGeneralConstantesFunciones.LABEL_DEBITOEXTRAN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DiarioGeneralConstantesFunciones.LABEL_CREDITOEXTRAN);
			reporte.setsDescripcion(DiarioGeneralConstantesFunciones.LABEL_CREDITOEXTRAN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DiarioGeneralConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(DiarioGeneralConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DiarioGeneralConstantesFunciones.LABEL_DETALLE);
			reporte.setsDescripcion(DiarioGeneralConstantesFunciones.LABEL_DETALLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DiarioGeneralConstantesFunciones.LABEL_NOMBREESTADO);
			reporte.setsDescripcion(DiarioGeneralConstantesFunciones.LABEL_NOMBREESTADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesDiarioGeneral(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesDiarioGeneral(DiarioGeneral diariogeneralAux) throws Exception {
		
			diariogeneralAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(diariogeneralAux.getEmpresa()));
			diariogeneralAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(diariogeneralAux.getSucursal()));
			diariogeneralAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(diariogeneralAux.getEjercicio()));
			diariogeneralAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(diariogeneralAux.getPeriodo()));
			diariogeneralAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(diariogeneralAux.getModulo()));
			diariogeneralAux.settipomovimiento_descripcion(TipoMovimientoConstantesFunciones.getTipoMovimientoDescripcion(diariogeneralAux.getTipoMovimiento()));
			diariogeneralAux.settipodocumento_descripcion(TipoDocumentoConstantesFunciones.getTipoDocumentoDescripcion(diariogeneralAux.getTipoDocumento()));
			diariogeneralAux.setasientocontable_descripcion(AsientoContableConstantesFunciones.getAsientoContableDescripcion(diariogeneralAux.getAsientoContable()));		
	}
	
	public static void refrescarForeignKeysDescripcionesDiarioGeneral(List<DiarioGeneral> diariogeneralsTemp) throws Exception {
		for(DiarioGeneral diariogeneralAux:diariogeneralsTemp) {
			
			diariogeneralAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(diariogeneralAux.getEmpresa()));
			diariogeneralAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(diariogeneralAux.getSucursal()));
			diariogeneralAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(diariogeneralAux.getEjercicio()));
			diariogeneralAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(diariogeneralAux.getPeriodo()));
			diariogeneralAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(diariogeneralAux.getModulo()));
			diariogeneralAux.settipomovimiento_descripcion(TipoMovimientoConstantesFunciones.getTipoMovimientoDescripcion(diariogeneralAux.getTipoMovimiento()));
			diariogeneralAux.settipodocumento_descripcion(TipoDocumentoConstantesFunciones.getTipoDocumentoDescripcion(diariogeneralAux.getTipoDocumento()));
			diariogeneralAux.setasientocontable_descripcion(AsientoContableConstantesFunciones.getAsientoContableDescripcion(diariogeneralAux.getAsientoContable()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfDiarioGeneral(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(Modulo.class));
				classes.add(new Classe(TipoMovimiento.class));
				classes.add(new Classe(TipoDocumento.class));
				classes.add(new Classe(AsientoContable.class));
				
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
					if(clas.clas.equals(Periodo.class)) {
						classes.add(new Classe(Periodo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Modulo.class)) {
						classes.add(new Classe(Modulo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoMovimiento.class)) {
						classes.add(new Classe(TipoMovimiento.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoDocumento.class)) {
						classes.add(new Classe(TipoDocumento.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(AsientoContable.class)) {
						classes.add(new Classe(AsientoContable.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfDiarioGeneral(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}

					if(TipoMovimiento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoMovimiento.class)); continue;
					}

					if(TipoDocumento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDocumento.class)); continue;
					}

					if(AsientoContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AsientoContable.class)); continue;
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

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}

					if(TipoMovimiento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoMovimiento.class)); continue;
					}

					if(TipoDocumento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDocumento.class)); continue;
					}

					if(AsientoContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AsientoContable.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfDiarioGeneral(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return DiarioGeneralConstantesFunciones.getClassesRelationshipsOfDiarioGeneral(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDiarioGeneral(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDiarioGeneral(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return DiarioGeneralConstantesFunciones.getClassesRelationshipsFromStringsOfDiarioGeneral(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDiarioGeneral(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(DiarioGeneral diariogeneral,List<DiarioGeneral> diariogenerals,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(DiarioGeneral diariogeneral,List<DiarioGeneral> diariogenerals) throws Exception {
		try	{			
			for(DiarioGeneral diariogeneralLocal:diariogenerals) {
				if(diariogeneralLocal.getId().equals(diariogeneral.getId())) {
					diariogeneralLocal.setIsSelected(diariogeneral.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesDiarioGeneral(List<DiarioGeneral> diariogeneralsAux) throws Exception {
		//this.diariogeneralsAux=diariogeneralsAux;
		
		for(DiarioGeneral diariogeneralAux:diariogeneralsAux) {
			if(diariogeneralAux.getIsChanged()) {
				diariogeneralAux.setIsChanged(false);
			}		
			
			if(diariogeneralAux.getIsNew()) {
				diariogeneralAux.setIsNew(false);
			}	
			
			if(diariogeneralAux.getIsDeleted()) {
				diariogeneralAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesDiarioGeneral(DiarioGeneral diariogeneralAux) throws Exception {
		//this.diariogeneralAux=diariogeneralAux;
		
			if(diariogeneralAux.getIsChanged()) {
				diariogeneralAux.setIsChanged(false);
			}		
			
			if(diariogeneralAux.getIsNew()) {
				diariogeneralAux.setIsNew(false);
			}	
			
			if(diariogeneralAux.getIsDeleted()) {
				diariogeneralAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(DiarioGeneral diariogeneralAsignar,DiarioGeneral diariogeneral) throws Exception {
		diariogeneralAsignar.setId(diariogeneral.getId());	
		diariogeneralAsignar.setVersionRow(diariogeneral.getVersionRow());	
		diariogeneralAsignar.setid_asiento_contable(diariogeneral.getid_asiento_contable());
		diariogeneralAsignar.setasientocontable_descripcion(diariogeneral.getasientocontable_descripcion());	
		diariogeneralAsignar.settipo_movimiento(diariogeneral.gettipo_movimiento());	
		diariogeneralAsignar.setnumero_mayor(diariogeneral.getnumero_mayor());	
		diariogeneralAsignar.setcodigo(diariogeneral.getcodigo());	
		diariogeneralAsignar.setnombre(diariogeneral.getnombre());	
		diariogeneralAsignar.setcodigo_asiento(diariogeneral.getcodigo_asiento());	
		diariogeneralAsignar.setdebito_local(diariogeneral.getdebito_local());	
		diariogeneralAsignar.setcredito_local(diariogeneral.getcredito_local());	
		diariogeneralAsignar.setdebito_extran(diariogeneral.getdebito_extran());	
		diariogeneralAsignar.setcredito_extran(diariogeneral.getcredito_extran());	
		diariogeneralAsignar.setfecha(diariogeneral.getfecha());	
		diariogeneralAsignar.setdetalle(diariogeneral.getdetalle());	
		diariogeneralAsignar.setnombre_estado(diariogeneral.getnombre_estado());	
	}
	
	public static void inicializarDiarioGeneral(DiarioGeneral diariogeneral) throws Exception {
		try {
				diariogeneral.setId(0L);	
					
				diariogeneral.setid_asiento_contable(-1L);	
				diariogeneral.settipo_movimiento("");	
				diariogeneral.setnumero_mayor("");	
				diariogeneral.setcodigo("");	
				diariogeneral.setnombre("");	
				diariogeneral.setcodigo_asiento("");	
				diariogeneral.setdebito_local(0.0);	
				diariogeneral.setcredito_local(0.0);	
				diariogeneral.setdebito_extran(0.0);	
				diariogeneral.setcredito_extran(0.0);	
				diariogeneral.setfecha(new Date());	
				diariogeneral.setdetalle("");	
				diariogeneral.setnombre_estado("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderDiarioGeneral(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(DiarioGeneralConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DiarioGeneralConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DiarioGeneralConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DiarioGeneralConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DiarioGeneralConstantesFunciones.LABEL_IDMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DiarioGeneralConstantesFunciones.LABEL_IDTIPOMOVIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DiarioGeneralConstantesFunciones.LABEL_IDTIPODOCUMENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DiarioGeneralConstantesFunciones.LABEL_FECHAINICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DiarioGeneralConstantesFunciones.LABEL_FECHAFIN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DiarioGeneralConstantesFunciones.LABEL_IDASIENTOCONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DiarioGeneralConstantesFunciones.LABEL_TIPOMOVIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DiarioGeneralConstantesFunciones.LABEL_NUMEROMAYOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DiarioGeneralConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DiarioGeneralConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DiarioGeneralConstantesFunciones.LABEL_CODIGOASIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DiarioGeneralConstantesFunciones.LABEL_DEBITOLOCAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DiarioGeneralConstantesFunciones.LABEL_CREDITOLOCAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DiarioGeneralConstantesFunciones.LABEL_DEBITOEXTRAN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DiarioGeneralConstantesFunciones.LABEL_CREDITOEXTRAN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DiarioGeneralConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DiarioGeneralConstantesFunciones.LABEL_DETALLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DiarioGeneralConstantesFunciones.LABEL_NOMBREESTADO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataDiarioGeneral(String sTipo,Row row,Workbook workbook,DiarioGeneral diariogeneral,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(diariogeneral.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(diariogeneral.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(diariogeneral.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(diariogeneral.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(diariogeneral.getmodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(diariogeneral.gettipomovimiento_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(diariogeneral.gettipodocumento_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(diariogeneral.getfecha_inicio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(diariogeneral.getfecha_fin());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(diariogeneral.getasientocontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(diariogeneral.gettipo_movimiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(diariogeneral.getnumero_mayor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(diariogeneral.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(diariogeneral.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(diariogeneral.getcodigo_asiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(diariogeneral.getdebito_local());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(diariogeneral.getcredito_local());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(diariogeneral.getdebito_extran());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(diariogeneral.getcredito_extran());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(diariogeneral.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(diariogeneral.getdetalle());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(diariogeneral.getnombre_estado());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryDiarioGeneral="";
	
	public String getsFinalQueryDiarioGeneral() {
		return this.sFinalQueryDiarioGeneral;
	}
	
	public void setsFinalQueryDiarioGeneral(String sFinalQueryDiarioGeneral) {
		this.sFinalQueryDiarioGeneral= sFinalQueryDiarioGeneral;
	}
	
	public Border resaltarSeleccionarDiarioGeneral=null;
	
	public Border setResaltarSeleccionarDiarioGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*DiarioGeneralBeanSwingJInternalFrame diariogeneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//diariogeneralBeanSwingJInternalFrame.jTtoolBarDiarioGeneral.setBorder(borderResaltar);
		
		this.resaltarSeleccionarDiarioGeneral= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarDiarioGeneral() {
		return this.resaltarSeleccionarDiarioGeneral;
	}
	
	public void setResaltarSeleccionarDiarioGeneral(Border borderResaltarSeleccionarDiarioGeneral) {
		this.resaltarSeleccionarDiarioGeneral= borderResaltarSeleccionarDiarioGeneral;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridDiarioGeneral=null;
	public Boolean mostraridDiarioGeneral=true;
	public Boolean activaridDiarioGeneral=true;

	public Border resaltarid_empresaDiarioGeneral=null;
	public Boolean mostrarid_empresaDiarioGeneral=true;
	public Boolean activarid_empresaDiarioGeneral=true;
	public Boolean cargarid_empresaDiarioGeneral=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaDiarioGeneral=false;//ConEventDepend=true

	public Border resaltarid_sucursalDiarioGeneral=null;
	public Boolean mostrarid_sucursalDiarioGeneral=true;
	public Boolean activarid_sucursalDiarioGeneral=true;
	public Boolean cargarid_sucursalDiarioGeneral=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalDiarioGeneral=false;//ConEventDepend=true

	public Border resaltarid_ejercicioDiarioGeneral=null;
	public Boolean mostrarid_ejercicioDiarioGeneral=true;
	public Boolean activarid_ejercicioDiarioGeneral=true;
	public Boolean cargarid_ejercicioDiarioGeneral=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioDiarioGeneral=false;//ConEventDepend=true

	public Border resaltarid_periodoDiarioGeneral=null;
	public Boolean mostrarid_periodoDiarioGeneral=true;
	public Boolean activarid_periodoDiarioGeneral=true;
	public Boolean cargarid_periodoDiarioGeneral=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoDiarioGeneral=true;//ConEventDepend=true

	public Border resaltarid_moduloDiarioGeneral=null;
	public Boolean mostrarid_moduloDiarioGeneral=true;
	public Boolean activarid_moduloDiarioGeneral=true;
	public Boolean cargarid_moduloDiarioGeneral=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_moduloDiarioGeneral=false;//ConEventDepend=true

	public Border resaltarid_tipo_movimientoDiarioGeneral=null;
	public Boolean mostrarid_tipo_movimientoDiarioGeneral=true;
	public Boolean activarid_tipo_movimientoDiarioGeneral=true;
	public Boolean cargarid_tipo_movimientoDiarioGeneral=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_movimientoDiarioGeneral=false;//ConEventDepend=true

	public Border resaltarid_tipo_documentoDiarioGeneral=null;
	public Boolean mostrarid_tipo_documentoDiarioGeneral=true;
	public Boolean activarid_tipo_documentoDiarioGeneral=true;
	public Boolean cargarid_tipo_documentoDiarioGeneral=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_documentoDiarioGeneral=true;//ConEventDepend=true

	public Border resaltarfecha_inicioDiarioGeneral=null;
	public Boolean mostrarfecha_inicioDiarioGeneral=true;
	public Boolean activarfecha_inicioDiarioGeneral=true;

	public Border resaltarfecha_finDiarioGeneral=null;
	public Boolean mostrarfecha_finDiarioGeneral=true;
	public Boolean activarfecha_finDiarioGeneral=true;

	public Border resaltarid_asiento_contableDiarioGeneral=null;
	public Boolean mostrarid_asiento_contableDiarioGeneral=true;
	public Boolean activarid_asiento_contableDiarioGeneral=false;
	public Boolean cargarid_asiento_contableDiarioGeneral=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_asiento_contableDiarioGeneral=false;//ConEventDepend=true

	public Border resaltartipo_movimientoDiarioGeneral=null;
	public Boolean mostrartipo_movimientoDiarioGeneral=true;
	public Boolean activartipo_movimientoDiarioGeneral=true;

	public Border resaltarnumero_mayorDiarioGeneral=null;
	public Boolean mostrarnumero_mayorDiarioGeneral=true;
	public Boolean activarnumero_mayorDiarioGeneral=true;

	public Border resaltarcodigoDiarioGeneral=null;
	public Boolean mostrarcodigoDiarioGeneral=true;
	public Boolean activarcodigoDiarioGeneral=true;

	public Border resaltarnombreDiarioGeneral=null;
	public Boolean mostrarnombreDiarioGeneral=true;
	public Boolean activarnombreDiarioGeneral=true;

	public Border resaltarcodigo_asientoDiarioGeneral=null;
	public Boolean mostrarcodigo_asientoDiarioGeneral=true;
	public Boolean activarcodigo_asientoDiarioGeneral=true;

	public Border resaltardebito_localDiarioGeneral=null;
	public Boolean mostrardebito_localDiarioGeneral=true;
	public Boolean activardebito_localDiarioGeneral=true;

	public Border resaltarcredito_localDiarioGeneral=null;
	public Boolean mostrarcredito_localDiarioGeneral=true;
	public Boolean activarcredito_localDiarioGeneral=true;

	public Border resaltardebito_extranDiarioGeneral=null;
	public Boolean mostrardebito_extranDiarioGeneral=true;
	public Boolean activardebito_extranDiarioGeneral=true;

	public Border resaltarcredito_extranDiarioGeneral=null;
	public Boolean mostrarcredito_extranDiarioGeneral=true;
	public Boolean activarcredito_extranDiarioGeneral=true;

	public Border resaltarfechaDiarioGeneral=null;
	public Boolean mostrarfechaDiarioGeneral=true;
	public Boolean activarfechaDiarioGeneral=true;

	public Border resaltardetalleDiarioGeneral=null;
	public Boolean mostrardetalleDiarioGeneral=true;
	public Boolean activardetalleDiarioGeneral=true;

	public Border resaltarnombre_estadoDiarioGeneral=null;
	public Boolean mostrarnombre_estadoDiarioGeneral=true;
	public Boolean activarnombre_estadoDiarioGeneral=true;

	
	

	public Border setResaltaridDiarioGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*DiarioGeneralBeanSwingJInternalFrame diariogeneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//diariogeneralBeanSwingJInternalFrame.jTtoolBarDiarioGeneral.setBorder(borderResaltar);
		
		this.resaltaridDiarioGeneral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridDiarioGeneral() {
		return this.resaltaridDiarioGeneral;
	}

	public void setResaltaridDiarioGeneral(Border borderResaltar) {
		this.resaltaridDiarioGeneral= borderResaltar;
	}

	public Boolean getMostraridDiarioGeneral() {
		return this.mostraridDiarioGeneral;
	}

	public void setMostraridDiarioGeneral(Boolean mostraridDiarioGeneral) {
		this.mostraridDiarioGeneral= mostraridDiarioGeneral;
	}

	public Boolean getActivaridDiarioGeneral() {
		return this.activaridDiarioGeneral;
	}

	public void setActivaridDiarioGeneral(Boolean activaridDiarioGeneral) {
		this.activaridDiarioGeneral= activaridDiarioGeneral;
	}

	public Border setResaltarid_empresaDiarioGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*DiarioGeneralBeanSwingJInternalFrame diariogeneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//diariogeneralBeanSwingJInternalFrame.jTtoolBarDiarioGeneral.setBorder(borderResaltar);
		
		this.resaltarid_empresaDiarioGeneral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaDiarioGeneral() {
		return this.resaltarid_empresaDiarioGeneral;
	}

	public void setResaltarid_empresaDiarioGeneral(Border borderResaltar) {
		this.resaltarid_empresaDiarioGeneral= borderResaltar;
	}

	public Boolean getMostrarid_empresaDiarioGeneral() {
		return this.mostrarid_empresaDiarioGeneral;
	}

	public void setMostrarid_empresaDiarioGeneral(Boolean mostrarid_empresaDiarioGeneral) {
		this.mostrarid_empresaDiarioGeneral= mostrarid_empresaDiarioGeneral;
	}

	public Boolean getActivarid_empresaDiarioGeneral() {
		return this.activarid_empresaDiarioGeneral;
	}

	public void setActivarid_empresaDiarioGeneral(Boolean activarid_empresaDiarioGeneral) {
		this.activarid_empresaDiarioGeneral= activarid_empresaDiarioGeneral;
	}

	public Boolean getCargarid_empresaDiarioGeneral() {
		return this.cargarid_empresaDiarioGeneral;
	}

	public void setCargarid_empresaDiarioGeneral(Boolean cargarid_empresaDiarioGeneral) {
		this.cargarid_empresaDiarioGeneral= cargarid_empresaDiarioGeneral;
	}

	public Border setResaltarid_sucursalDiarioGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*DiarioGeneralBeanSwingJInternalFrame diariogeneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//diariogeneralBeanSwingJInternalFrame.jTtoolBarDiarioGeneral.setBorder(borderResaltar);
		
		this.resaltarid_sucursalDiarioGeneral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalDiarioGeneral() {
		return this.resaltarid_sucursalDiarioGeneral;
	}

	public void setResaltarid_sucursalDiarioGeneral(Border borderResaltar) {
		this.resaltarid_sucursalDiarioGeneral= borderResaltar;
	}

	public Boolean getMostrarid_sucursalDiarioGeneral() {
		return this.mostrarid_sucursalDiarioGeneral;
	}

	public void setMostrarid_sucursalDiarioGeneral(Boolean mostrarid_sucursalDiarioGeneral) {
		this.mostrarid_sucursalDiarioGeneral= mostrarid_sucursalDiarioGeneral;
	}

	public Boolean getActivarid_sucursalDiarioGeneral() {
		return this.activarid_sucursalDiarioGeneral;
	}

	public void setActivarid_sucursalDiarioGeneral(Boolean activarid_sucursalDiarioGeneral) {
		this.activarid_sucursalDiarioGeneral= activarid_sucursalDiarioGeneral;
	}

	public Boolean getCargarid_sucursalDiarioGeneral() {
		return this.cargarid_sucursalDiarioGeneral;
	}

	public void setCargarid_sucursalDiarioGeneral(Boolean cargarid_sucursalDiarioGeneral) {
		this.cargarid_sucursalDiarioGeneral= cargarid_sucursalDiarioGeneral;
	}

	public Border setResaltarid_ejercicioDiarioGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*DiarioGeneralBeanSwingJInternalFrame diariogeneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//diariogeneralBeanSwingJInternalFrame.jTtoolBarDiarioGeneral.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioDiarioGeneral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioDiarioGeneral() {
		return this.resaltarid_ejercicioDiarioGeneral;
	}

	public void setResaltarid_ejercicioDiarioGeneral(Border borderResaltar) {
		this.resaltarid_ejercicioDiarioGeneral= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioDiarioGeneral() {
		return this.mostrarid_ejercicioDiarioGeneral;
	}

	public void setMostrarid_ejercicioDiarioGeneral(Boolean mostrarid_ejercicioDiarioGeneral) {
		this.mostrarid_ejercicioDiarioGeneral= mostrarid_ejercicioDiarioGeneral;
	}

	public Boolean getActivarid_ejercicioDiarioGeneral() {
		return this.activarid_ejercicioDiarioGeneral;
	}

	public void setActivarid_ejercicioDiarioGeneral(Boolean activarid_ejercicioDiarioGeneral) {
		this.activarid_ejercicioDiarioGeneral= activarid_ejercicioDiarioGeneral;
	}

	public Boolean getCargarid_ejercicioDiarioGeneral() {
		return this.cargarid_ejercicioDiarioGeneral;
	}

	public void setCargarid_ejercicioDiarioGeneral(Boolean cargarid_ejercicioDiarioGeneral) {
		this.cargarid_ejercicioDiarioGeneral= cargarid_ejercicioDiarioGeneral;
	}

	public Border setResaltarid_periodoDiarioGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*DiarioGeneralBeanSwingJInternalFrame diariogeneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//diariogeneralBeanSwingJInternalFrame.jTtoolBarDiarioGeneral.setBorder(borderResaltar);
		
		this.resaltarid_periodoDiarioGeneral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoDiarioGeneral() {
		return this.resaltarid_periodoDiarioGeneral;
	}

	public void setResaltarid_periodoDiarioGeneral(Border borderResaltar) {
		this.resaltarid_periodoDiarioGeneral= borderResaltar;
	}

	public Boolean getMostrarid_periodoDiarioGeneral() {
		return this.mostrarid_periodoDiarioGeneral;
	}

	public void setMostrarid_periodoDiarioGeneral(Boolean mostrarid_periodoDiarioGeneral) {
		this.mostrarid_periodoDiarioGeneral= mostrarid_periodoDiarioGeneral;
	}

	public Boolean getActivarid_periodoDiarioGeneral() {
		return this.activarid_periodoDiarioGeneral;
	}

	public void setActivarid_periodoDiarioGeneral(Boolean activarid_periodoDiarioGeneral) {
		this.activarid_periodoDiarioGeneral= activarid_periodoDiarioGeneral;
	}

	public Boolean getCargarid_periodoDiarioGeneral() {
		return this.cargarid_periodoDiarioGeneral;
	}

	public void setCargarid_periodoDiarioGeneral(Boolean cargarid_periodoDiarioGeneral) {
		this.cargarid_periodoDiarioGeneral= cargarid_periodoDiarioGeneral;
	}

	public Border setResaltarid_moduloDiarioGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*DiarioGeneralBeanSwingJInternalFrame diariogeneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//diariogeneralBeanSwingJInternalFrame.jTtoolBarDiarioGeneral.setBorder(borderResaltar);
		
		this.resaltarid_moduloDiarioGeneral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_moduloDiarioGeneral() {
		return this.resaltarid_moduloDiarioGeneral;
	}

	public void setResaltarid_moduloDiarioGeneral(Border borderResaltar) {
		this.resaltarid_moduloDiarioGeneral= borderResaltar;
	}

	public Boolean getMostrarid_moduloDiarioGeneral() {
		return this.mostrarid_moduloDiarioGeneral;
	}

	public void setMostrarid_moduloDiarioGeneral(Boolean mostrarid_moduloDiarioGeneral) {
		this.mostrarid_moduloDiarioGeneral= mostrarid_moduloDiarioGeneral;
	}

	public Boolean getActivarid_moduloDiarioGeneral() {
		return this.activarid_moduloDiarioGeneral;
	}

	public void setActivarid_moduloDiarioGeneral(Boolean activarid_moduloDiarioGeneral) {
		this.activarid_moduloDiarioGeneral= activarid_moduloDiarioGeneral;
	}

	public Boolean getCargarid_moduloDiarioGeneral() {
		return this.cargarid_moduloDiarioGeneral;
	}

	public void setCargarid_moduloDiarioGeneral(Boolean cargarid_moduloDiarioGeneral) {
		this.cargarid_moduloDiarioGeneral= cargarid_moduloDiarioGeneral;
	}

	public Border setResaltarid_tipo_movimientoDiarioGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*DiarioGeneralBeanSwingJInternalFrame diariogeneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//diariogeneralBeanSwingJInternalFrame.jTtoolBarDiarioGeneral.setBorder(borderResaltar);
		
		this.resaltarid_tipo_movimientoDiarioGeneral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_movimientoDiarioGeneral() {
		return this.resaltarid_tipo_movimientoDiarioGeneral;
	}

	public void setResaltarid_tipo_movimientoDiarioGeneral(Border borderResaltar) {
		this.resaltarid_tipo_movimientoDiarioGeneral= borderResaltar;
	}

	public Boolean getMostrarid_tipo_movimientoDiarioGeneral() {
		return this.mostrarid_tipo_movimientoDiarioGeneral;
	}

	public void setMostrarid_tipo_movimientoDiarioGeneral(Boolean mostrarid_tipo_movimientoDiarioGeneral) {
		this.mostrarid_tipo_movimientoDiarioGeneral= mostrarid_tipo_movimientoDiarioGeneral;
	}

	public Boolean getActivarid_tipo_movimientoDiarioGeneral() {
		return this.activarid_tipo_movimientoDiarioGeneral;
	}

	public void setActivarid_tipo_movimientoDiarioGeneral(Boolean activarid_tipo_movimientoDiarioGeneral) {
		this.activarid_tipo_movimientoDiarioGeneral= activarid_tipo_movimientoDiarioGeneral;
	}

	public Boolean getCargarid_tipo_movimientoDiarioGeneral() {
		return this.cargarid_tipo_movimientoDiarioGeneral;
	}

	public void setCargarid_tipo_movimientoDiarioGeneral(Boolean cargarid_tipo_movimientoDiarioGeneral) {
		this.cargarid_tipo_movimientoDiarioGeneral= cargarid_tipo_movimientoDiarioGeneral;
	}

	public Border setResaltarid_tipo_documentoDiarioGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*DiarioGeneralBeanSwingJInternalFrame diariogeneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//diariogeneralBeanSwingJInternalFrame.jTtoolBarDiarioGeneral.setBorder(borderResaltar);
		
		this.resaltarid_tipo_documentoDiarioGeneral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_documentoDiarioGeneral() {
		return this.resaltarid_tipo_documentoDiarioGeneral;
	}

	public void setResaltarid_tipo_documentoDiarioGeneral(Border borderResaltar) {
		this.resaltarid_tipo_documentoDiarioGeneral= borderResaltar;
	}

	public Boolean getMostrarid_tipo_documentoDiarioGeneral() {
		return this.mostrarid_tipo_documentoDiarioGeneral;
	}

	public void setMostrarid_tipo_documentoDiarioGeneral(Boolean mostrarid_tipo_documentoDiarioGeneral) {
		this.mostrarid_tipo_documentoDiarioGeneral= mostrarid_tipo_documentoDiarioGeneral;
	}

	public Boolean getActivarid_tipo_documentoDiarioGeneral() {
		return this.activarid_tipo_documentoDiarioGeneral;
	}

	public void setActivarid_tipo_documentoDiarioGeneral(Boolean activarid_tipo_documentoDiarioGeneral) {
		this.activarid_tipo_documentoDiarioGeneral= activarid_tipo_documentoDiarioGeneral;
	}

	public Boolean getCargarid_tipo_documentoDiarioGeneral() {
		return this.cargarid_tipo_documentoDiarioGeneral;
	}

	public void setCargarid_tipo_documentoDiarioGeneral(Boolean cargarid_tipo_documentoDiarioGeneral) {
		this.cargarid_tipo_documentoDiarioGeneral= cargarid_tipo_documentoDiarioGeneral;
	}

	public Border setResaltarfecha_inicioDiarioGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*DiarioGeneralBeanSwingJInternalFrame diariogeneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//diariogeneralBeanSwingJInternalFrame.jTtoolBarDiarioGeneral.setBorder(borderResaltar);
		
		this.resaltarfecha_inicioDiarioGeneral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_inicioDiarioGeneral() {
		return this.resaltarfecha_inicioDiarioGeneral;
	}

	public void setResaltarfecha_inicioDiarioGeneral(Border borderResaltar) {
		this.resaltarfecha_inicioDiarioGeneral= borderResaltar;
	}

	public Boolean getMostrarfecha_inicioDiarioGeneral() {
		return this.mostrarfecha_inicioDiarioGeneral;
	}

	public void setMostrarfecha_inicioDiarioGeneral(Boolean mostrarfecha_inicioDiarioGeneral) {
		this.mostrarfecha_inicioDiarioGeneral= mostrarfecha_inicioDiarioGeneral;
	}

	public Boolean getActivarfecha_inicioDiarioGeneral() {
		return this.activarfecha_inicioDiarioGeneral;
	}

	public void setActivarfecha_inicioDiarioGeneral(Boolean activarfecha_inicioDiarioGeneral) {
		this.activarfecha_inicioDiarioGeneral= activarfecha_inicioDiarioGeneral;
	}

	public Border setResaltarfecha_finDiarioGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*DiarioGeneralBeanSwingJInternalFrame diariogeneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//diariogeneralBeanSwingJInternalFrame.jTtoolBarDiarioGeneral.setBorder(borderResaltar);
		
		this.resaltarfecha_finDiarioGeneral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_finDiarioGeneral() {
		return this.resaltarfecha_finDiarioGeneral;
	}

	public void setResaltarfecha_finDiarioGeneral(Border borderResaltar) {
		this.resaltarfecha_finDiarioGeneral= borderResaltar;
	}

	public Boolean getMostrarfecha_finDiarioGeneral() {
		return this.mostrarfecha_finDiarioGeneral;
	}

	public void setMostrarfecha_finDiarioGeneral(Boolean mostrarfecha_finDiarioGeneral) {
		this.mostrarfecha_finDiarioGeneral= mostrarfecha_finDiarioGeneral;
	}

	public Boolean getActivarfecha_finDiarioGeneral() {
		return this.activarfecha_finDiarioGeneral;
	}

	public void setActivarfecha_finDiarioGeneral(Boolean activarfecha_finDiarioGeneral) {
		this.activarfecha_finDiarioGeneral= activarfecha_finDiarioGeneral;
	}

	public Border setResaltarid_asiento_contableDiarioGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*DiarioGeneralBeanSwingJInternalFrame diariogeneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//diariogeneralBeanSwingJInternalFrame.jTtoolBarDiarioGeneral.setBorder(borderResaltar);
		
		this.resaltarid_asiento_contableDiarioGeneral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_asiento_contableDiarioGeneral() {
		return this.resaltarid_asiento_contableDiarioGeneral;
	}

	public void setResaltarid_asiento_contableDiarioGeneral(Border borderResaltar) {
		this.resaltarid_asiento_contableDiarioGeneral= borderResaltar;
	}

	public Boolean getMostrarid_asiento_contableDiarioGeneral() {
		return this.mostrarid_asiento_contableDiarioGeneral;
	}

	public void setMostrarid_asiento_contableDiarioGeneral(Boolean mostrarid_asiento_contableDiarioGeneral) {
		this.mostrarid_asiento_contableDiarioGeneral= mostrarid_asiento_contableDiarioGeneral;
	}

	public Boolean getActivarid_asiento_contableDiarioGeneral() {
		return this.activarid_asiento_contableDiarioGeneral;
	}

	public void setActivarid_asiento_contableDiarioGeneral(Boolean activarid_asiento_contableDiarioGeneral) {
		this.activarid_asiento_contableDiarioGeneral= activarid_asiento_contableDiarioGeneral;
	}

	public Boolean getCargarid_asiento_contableDiarioGeneral() {
		return this.cargarid_asiento_contableDiarioGeneral;
	}

	public void setCargarid_asiento_contableDiarioGeneral(Boolean cargarid_asiento_contableDiarioGeneral) {
		this.cargarid_asiento_contableDiarioGeneral= cargarid_asiento_contableDiarioGeneral;
	}

	public Border setResaltartipo_movimientoDiarioGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*DiarioGeneralBeanSwingJInternalFrame diariogeneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//diariogeneralBeanSwingJInternalFrame.jTtoolBarDiarioGeneral.setBorder(borderResaltar);
		
		this.resaltartipo_movimientoDiarioGeneral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartipo_movimientoDiarioGeneral() {
		return this.resaltartipo_movimientoDiarioGeneral;
	}

	public void setResaltartipo_movimientoDiarioGeneral(Border borderResaltar) {
		this.resaltartipo_movimientoDiarioGeneral= borderResaltar;
	}

	public Boolean getMostrartipo_movimientoDiarioGeneral() {
		return this.mostrartipo_movimientoDiarioGeneral;
	}

	public void setMostrartipo_movimientoDiarioGeneral(Boolean mostrartipo_movimientoDiarioGeneral) {
		this.mostrartipo_movimientoDiarioGeneral= mostrartipo_movimientoDiarioGeneral;
	}

	public Boolean getActivartipo_movimientoDiarioGeneral() {
		return this.activartipo_movimientoDiarioGeneral;
	}

	public void setActivartipo_movimientoDiarioGeneral(Boolean activartipo_movimientoDiarioGeneral) {
		this.activartipo_movimientoDiarioGeneral= activartipo_movimientoDiarioGeneral;
	}

	public Border setResaltarnumero_mayorDiarioGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*DiarioGeneralBeanSwingJInternalFrame diariogeneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//diariogeneralBeanSwingJInternalFrame.jTtoolBarDiarioGeneral.setBorder(borderResaltar);
		
		this.resaltarnumero_mayorDiarioGeneral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_mayorDiarioGeneral() {
		return this.resaltarnumero_mayorDiarioGeneral;
	}

	public void setResaltarnumero_mayorDiarioGeneral(Border borderResaltar) {
		this.resaltarnumero_mayorDiarioGeneral= borderResaltar;
	}

	public Boolean getMostrarnumero_mayorDiarioGeneral() {
		return this.mostrarnumero_mayorDiarioGeneral;
	}

	public void setMostrarnumero_mayorDiarioGeneral(Boolean mostrarnumero_mayorDiarioGeneral) {
		this.mostrarnumero_mayorDiarioGeneral= mostrarnumero_mayorDiarioGeneral;
	}

	public Boolean getActivarnumero_mayorDiarioGeneral() {
		return this.activarnumero_mayorDiarioGeneral;
	}

	public void setActivarnumero_mayorDiarioGeneral(Boolean activarnumero_mayorDiarioGeneral) {
		this.activarnumero_mayorDiarioGeneral= activarnumero_mayorDiarioGeneral;
	}

	public Border setResaltarcodigoDiarioGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*DiarioGeneralBeanSwingJInternalFrame diariogeneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//diariogeneralBeanSwingJInternalFrame.jTtoolBarDiarioGeneral.setBorder(borderResaltar);
		
		this.resaltarcodigoDiarioGeneral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoDiarioGeneral() {
		return this.resaltarcodigoDiarioGeneral;
	}

	public void setResaltarcodigoDiarioGeneral(Border borderResaltar) {
		this.resaltarcodigoDiarioGeneral= borderResaltar;
	}

	public Boolean getMostrarcodigoDiarioGeneral() {
		return this.mostrarcodigoDiarioGeneral;
	}

	public void setMostrarcodigoDiarioGeneral(Boolean mostrarcodigoDiarioGeneral) {
		this.mostrarcodigoDiarioGeneral= mostrarcodigoDiarioGeneral;
	}

	public Boolean getActivarcodigoDiarioGeneral() {
		return this.activarcodigoDiarioGeneral;
	}

	public void setActivarcodigoDiarioGeneral(Boolean activarcodigoDiarioGeneral) {
		this.activarcodigoDiarioGeneral= activarcodigoDiarioGeneral;
	}

	public Border setResaltarnombreDiarioGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*DiarioGeneralBeanSwingJInternalFrame diariogeneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//diariogeneralBeanSwingJInternalFrame.jTtoolBarDiarioGeneral.setBorder(borderResaltar);
		
		this.resaltarnombreDiarioGeneral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreDiarioGeneral() {
		return this.resaltarnombreDiarioGeneral;
	}

	public void setResaltarnombreDiarioGeneral(Border borderResaltar) {
		this.resaltarnombreDiarioGeneral= borderResaltar;
	}

	public Boolean getMostrarnombreDiarioGeneral() {
		return this.mostrarnombreDiarioGeneral;
	}

	public void setMostrarnombreDiarioGeneral(Boolean mostrarnombreDiarioGeneral) {
		this.mostrarnombreDiarioGeneral= mostrarnombreDiarioGeneral;
	}

	public Boolean getActivarnombreDiarioGeneral() {
		return this.activarnombreDiarioGeneral;
	}

	public void setActivarnombreDiarioGeneral(Boolean activarnombreDiarioGeneral) {
		this.activarnombreDiarioGeneral= activarnombreDiarioGeneral;
	}

	public Border setResaltarcodigo_asientoDiarioGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*DiarioGeneralBeanSwingJInternalFrame diariogeneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//diariogeneralBeanSwingJInternalFrame.jTtoolBarDiarioGeneral.setBorder(borderResaltar);
		
		this.resaltarcodigo_asientoDiarioGeneral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_asientoDiarioGeneral() {
		return this.resaltarcodigo_asientoDiarioGeneral;
	}

	public void setResaltarcodigo_asientoDiarioGeneral(Border borderResaltar) {
		this.resaltarcodigo_asientoDiarioGeneral= borderResaltar;
	}

	public Boolean getMostrarcodigo_asientoDiarioGeneral() {
		return this.mostrarcodigo_asientoDiarioGeneral;
	}

	public void setMostrarcodigo_asientoDiarioGeneral(Boolean mostrarcodigo_asientoDiarioGeneral) {
		this.mostrarcodigo_asientoDiarioGeneral= mostrarcodigo_asientoDiarioGeneral;
	}

	public Boolean getActivarcodigo_asientoDiarioGeneral() {
		return this.activarcodigo_asientoDiarioGeneral;
	}

	public void setActivarcodigo_asientoDiarioGeneral(Boolean activarcodigo_asientoDiarioGeneral) {
		this.activarcodigo_asientoDiarioGeneral= activarcodigo_asientoDiarioGeneral;
	}

	public Border setResaltardebito_localDiarioGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*DiarioGeneralBeanSwingJInternalFrame diariogeneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//diariogeneralBeanSwingJInternalFrame.jTtoolBarDiarioGeneral.setBorder(borderResaltar);
		
		this.resaltardebito_localDiarioGeneral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardebito_localDiarioGeneral() {
		return this.resaltardebito_localDiarioGeneral;
	}

	public void setResaltardebito_localDiarioGeneral(Border borderResaltar) {
		this.resaltardebito_localDiarioGeneral= borderResaltar;
	}

	public Boolean getMostrardebito_localDiarioGeneral() {
		return this.mostrardebito_localDiarioGeneral;
	}

	public void setMostrardebito_localDiarioGeneral(Boolean mostrardebito_localDiarioGeneral) {
		this.mostrardebito_localDiarioGeneral= mostrardebito_localDiarioGeneral;
	}

	public Boolean getActivardebito_localDiarioGeneral() {
		return this.activardebito_localDiarioGeneral;
	}

	public void setActivardebito_localDiarioGeneral(Boolean activardebito_localDiarioGeneral) {
		this.activardebito_localDiarioGeneral= activardebito_localDiarioGeneral;
	}

	public Border setResaltarcredito_localDiarioGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*DiarioGeneralBeanSwingJInternalFrame diariogeneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//diariogeneralBeanSwingJInternalFrame.jTtoolBarDiarioGeneral.setBorder(borderResaltar);
		
		this.resaltarcredito_localDiarioGeneral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcredito_localDiarioGeneral() {
		return this.resaltarcredito_localDiarioGeneral;
	}

	public void setResaltarcredito_localDiarioGeneral(Border borderResaltar) {
		this.resaltarcredito_localDiarioGeneral= borderResaltar;
	}

	public Boolean getMostrarcredito_localDiarioGeneral() {
		return this.mostrarcredito_localDiarioGeneral;
	}

	public void setMostrarcredito_localDiarioGeneral(Boolean mostrarcredito_localDiarioGeneral) {
		this.mostrarcredito_localDiarioGeneral= mostrarcredito_localDiarioGeneral;
	}

	public Boolean getActivarcredito_localDiarioGeneral() {
		return this.activarcredito_localDiarioGeneral;
	}

	public void setActivarcredito_localDiarioGeneral(Boolean activarcredito_localDiarioGeneral) {
		this.activarcredito_localDiarioGeneral= activarcredito_localDiarioGeneral;
	}

	public Border setResaltardebito_extranDiarioGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*DiarioGeneralBeanSwingJInternalFrame diariogeneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//diariogeneralBeanSwingJInternalFrame.jTtoolBarDiarioGeneral.setBorder(borderResaltar);
		
		this.resaltardebito_extranDiarioGeneral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardebito_extranDiarioGeneral() {
		return this.resaltardebito_extranDiarioGeneral;
	}

	public void setResaltardebito_extranDiarioGeneral(Border borderResaltar) {
		this.resaltardebito_extranDiarioGeneral= borderResaltar;
	}

	public Boolean getMostrardebito_extranDiarioGeneral() {
		return this.mostrardebito_extranDiarioGeneral;
	}

	public void setMostrardebito_extranDiarioGeneral(Boolean mostrardebito_extranDiarioGeneral) {
		this.mostrardebito_extranDiarioGeneral= mostrardebito_extranDiarioGeneral;
	}

	public Boolean getActivardebito_extranDiarioGeneral() {
		return this.activardebito_extranDiarioGeneral;
	}

	public void setActivardebito_extranDiarioGeneral(Boolean activardebito_extranDiarioGeneral) {
		this.activardebito_extranDiarioGeneral= activardebito_extranDiarioGeneral;
	}

	public Border setResaltarcredito_extranDiarioGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*DiarioGeneralBeanSwingJInternalFrame diariogeneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//diariogeneralBeanSwingJInternalFrame.jTtoolBarDiarioGeneral.setBorder(borderResaltar);
		
		this.resaltarcredito_extranDiarioGeneral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcredito_extranDiarioGeneral() {
		return this.resaltarcredito_extranDiarioGeneral;
	}

	public void setResaltarcredito_extranDiarioGeneral(Border borderResaltar) {
		this.resaltarcredito_extranDiarioGeneral= borderResaltar;
	}

	public Boolean getMostrarcredito_extranDiarioGeneral() {
		return this.mostrarcredito_extranDiarioGeneral;
	}

	public void setMostrarcredito_extranDiarioGeneral(Boolean mostrarcredito_extranDiarioGeneral) {
		this.mostrarcredito_extranDiarioGeneral= mostrarcredito_extranDiarioGeneral;
	}

	public Boolean getActivarcredito_extranDiarioGeneral() {
		return this.activarcredito_extranDiarioGeneral;
	}

	public void setActivarcredito_extranDiarioGeneral(Boolean activarcredito_extranDiarioGeneral) {
		this.activarcredito_extranDiarioGeneral= activarcredito_extranDiarioGeneral;
	}

	public Border setResaltarfechaDiarioGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*DiarioGeneralBeanSwingJInternalFrame diariogeneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//diariogeneralBeanSwingJInternalFrame.jTtoolBarDiarioGeneral.setBorder(borderResaltar);
		
		this.resaltarfechaDiarioGeneral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaDiarioGeneral() {
		return this.resaltarfechaDiarioGeneral;
	}

	public void setResaltarfechaDiarioGeneral(Border borderResaltar) {
		this.resaltarfechaDiarioGeneral= borderResaltar;
	}

	public Boolean getMostrarfechaDiarioGeneral() {
		return this.mostrarfechaDiarioGeneral;
	}

	public void setMostrarfechaDiarioGeneral(Boolean mostrarfechaDiarioGeneral) {
		this.mostrarfechaDiarioGeneral= mostrarfechaDiarioGeneral;
	}

	public Boolean getActivarfechaDiarioGeneral() {
		return this.activarfechaDiarioGeneral;
	}

	public void setActivarfechaDiarioGeneral(Boolean activarfechaDiarioGeneral) {
		this.activarfechaDiarioGeneral= activarfechaDiarioGeneral;
	}

	public Border setResaltardetalleDiarioGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*DiarioGeneralBeanSwingJInternalFrame diariogeneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//diariogeneralBeanSwingJInternalFrame.jTtoolBarDiarioGeneral.setBorder(borderResaltar);
		
		this.resaltardetalleDiarioGeneral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardetalleDiarioGeneral() {
		return this.resaltardetalleDiarioGeneral;
	}

	public void setResaltardetalleDiarioGeneral(Border borderResaltar) {
		this.resaltardetalleDiarioGeneral= borderResaltar;
	}

	public Boolean getMostrardetalleDiarioGeneral() {
		return this.mostrardetalleDiarioGeneral;
	}

	public void setMostrardetalleDiarioGeneral(Boolean mostrardetalleDiarioGeneral) {
		this.mostrardetalleDiarioGeneral= mostrardetalleDiarioGeneral;
	}

	public Boolean getActivardetalleDiarioGeneral() {
		return this.activardetalleDiarioGeneral;
	}

	public void setActivardetalleDiarioGeneral(Boolean activardetalleDiarioGeneral) {
		this.activardetalleDiarioGeneral= activardetalleDiarioGeneral;
	}

	public Border setResaltarnombre_estadoDiarioGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*DiarioGeneralBeanSwingJInternalFrame diariogeneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//diariogeneralBeanSwingJInternalFrame.jTtoolBarDiarioGeneral.setBorder(borderResaltar);
		
		this.resaltarnombre_estadoDiarioGeneral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_estadoDiarioGeneral() {
		return this.resaltarnombre_estadoDiarioGeneral;
	}

	public void setResaltarnombre_estadoDiarioGeneral(Border borderResaltar) {
		this.resaltarnombre_estadoDiarioGeneral= borderResaltar;
	}

	public Boolean getMostrarnombre_estadoDiarioGeneral() {
		return this.mostrarnombre_estadoDiarioGeneral;
	}

	public void setMostrarnombre_estadoDiarioGeneral(Boolean mostrarnombre_estadoDiarioGeneral) {
		this.mostrarnombre_estadoDiarioGeneral= mostrarnombre_estadoDiarioGeneral;
	}

	public Boolean getActivarnombre_estadoDiarioGeneral() {
		return this.activarnombre_estadoDiarioGeneral;
	}

	public void setActivarnombre_estadoDiarioGeneral(Boolean activarnombre_estadoDiarioGeneral) {
		this.activarnombre_estadoDiarioGeneral= activarnombre_estadoDiarioGeneral;
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
		
		
		this.setMostraridDiarioGeneral(esInicial);
		this.setMostrarid_empresaDiarioGeneral(esInicial);
		this.setMostrarid_sucursalDiarioGeneral(esInicial);
		this.setMostrarid_ejercicioDiarioGeneral(esInicial);
		this.setMostrarid_periodoDiarioGeneral(esInicial);
		this.setMostrarid_moduloDiarioGeneral(esInicial);
		this.setMostrarid_tipo_movimientoDiarioGeneral(esInicial);
		this.setMostrarid_tipo_documentoDiarioGeneral(esInicial);
		this.setMostrarfecha_inicioDiarioGeneral(esInicial);
		this.setMostrarfecha_finDiarioGeneral(esInicial);
		this.setMostrarid_asiento_contableDiarioGeneral(esInicial);
		this.setMostrartipo_movimientoDiarioGeneral(esInicial);
		this.setMostrarnumero_mayorDiarioGeneral(esInicial);
		this.setMostrarcodigoDiarioGeneral(esInicial);
		this.setMostrarnombreDiarioGeneral(esInicial);
		this.setMostrarcodigo_asientoDiarioGeneral(esInicial);
		this.setMostrardebito_localDiarioGeneral(esInicial);
		this.setMostrarcredito_localDiarioGeneral(esInicial);
		this.setMostrardebito_extranDiarioGeneral(esInicial);
		this.setMostrarcredito_extranDiarioGeneral(esInicial);
		this.setMostrarfechaDiarioGeneral(esInicial);
		this.setMostrardetalleDiarioGeneral(esInicial);
		this.setMostrarnombre_estadoDiarioGeneral(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DiarioGeneralConstantesFunciones.ID)) {
				this.setMostraridDiarioGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiarioGeneralConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaDiarioGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiarioGeneralConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalDiarioGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiarioGeneralConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioDiarioGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiarioGeneralConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoDiarioGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiarioGeneralConstantesFunciones.IDMODULO)) {
				this.setMostrarid_moduloDiarioGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiarioGeneralConstantesFunciones.IDTIPOMOVIMIENTO)) {
				this.setMostrarid_tipo_movimientoDiarioGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiarioGeneralConstantesFunciones.IDTIPODOCUMENTO)) {
				this.setMostrarid_tipo_documentoDiarioGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiarioGeneralConstantesFunciones.FECHAINICIO)) {
				this.setMostrarfecha_inicioDiarioGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiarioGeneralConstantesFunciones.FECHAFIN)) {
				this.setMostrarfecha_finDiarioGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiarioGeneralConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setMostrarid_asiento_contableDiarioGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiarioGeneralConstantesFunciones.TIPOMOVIMIENTO)) {
				this.setMostrartipo_movimientoDiarioGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiarioGeneralConstantesFunciones.NUMEROMAYOR)) {
				this.setMostrarnumero_mayorDiarioGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiarioGeneralConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoDiarioGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiarioGeneralConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreDiarioGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiarioGeneralConstantesFunciones.CODIGOASIENTO)) {
				this.setMostrarcodigo_asientoDiarioGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiarioGeneralConstantesFunciones.DEBITOLOCAL)) {
				this.setMostrardebito_localDiarioGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiarioGeneralConstantesFunciones.CREDITOLOCAL)) {
				this.setMostrarcredito_localDiarioGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiarioGeneralConstantesFunciones.DEBITOEXTRAN)) {
				this.setMostrardebito_extranDiarioGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiarioGeneralConstantesFunciones.CREDITOEXTRAN)) {
				this.setMostrarcredito_extranDiarioGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiarioGeneralConstantesFunciones.FECHA)) {
				this.setMostrarfechaDiarioGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiarioGeneralConstantesFunciones.DETALLE)) {
				this.setMostrardetalleDiarioGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiarioGeneralConstantesFunciones.NOMBREESTADO)) {
				this.setMostrarnombre_estadoDiarioGeneral(esAsigna);
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
		
		
		this.setActivaridDiarioGeneral(esInicial);
		this.setActivarid_empresaDiarioGeneral(esInicial);
		this.setActivarid_sucursalDiarioGeneral(esInicial);
		this.setActivarid_ejercicioDiarioGeneral(esInicial);
		this.setActivarid_periodoDiarioGeneral(esInicial);
		this.setActivarid_moduloDiarioGeneral(esInicial);
		this.setActivarid_tipo_movimientoDiarioGeneral(esInicial);
		this.setActivarid_tipo_documentoDiarioGeneral(esInicial);
		this.setActivarfecha_inicioDiarioGeneral(esInicial);
		this.setActivarfecha_finDiarioGeneral(esInicial);
		this.setActivarid_asiento_contableDiarioGeneral(esInicial);
		this.setActivartipo_movimientoDiarioGeneral(esInicial);
		this.setActivarnumero_mayorDiarioGeneral(esInicial);
		this.setActivarcodigoDiarioGeneral(esInicial);
		this.setActivarnombreDiarioGeneral(esInicial);
		this.setActivarcodigo_asientoDiarioGeneral(esInicial);
		this.setActivardebito_localDiarioGeneral(esInicial);
		this.setActivarcredito_localDiarioGeneral(esInicial);
		this.setActivardebito_extranDiarioGeneral(esInicial);
		this.setActivarcredito_extranDiarioGeneral(esInicial);
		this.setActivarfechaDiarioGeneral(esInicial);
		this.setActivardetalleDiarioGeneral(esInicial);
		this.setActivarnombre_estadoDiarioGeneral(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DiarioGeneralConstantesFunciones.ID)) {
				this.setActivaridDiarioGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiarioGeneralConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaDiarioGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiarioGeneralConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalDiarioGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiarioGeneralConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioDiarioGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiarioGeneralConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoDiarioGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiarioGeneralConstantesFunciones.IDMODULO)) {
				this.setActivarid_moduloDiarioGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiarioGeneralConstantesFunciones.IDTIPOMOVIMIENTO)) {
				this.setActivarid_tipo_movimientoDiarioGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiarioGeneralConstantesFunciones.IDTIPODOCUMENTO)) {
				this.setActivarid_tipo_documentoDiarioGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiarioGeneralConstantesFunciones.FECHAINICIO)) {
				this.setActivarfecha_inicioDiarioGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiarioGeneralConstantesFunciones.FECHAFIN)) {
				this.setActivarfecha_finDiarioGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiarioGeneralConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setActivarid_asiento_contableDiarioGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiarioGeneralConstantesFunciones.TIPOMOVIMIENTO)) {
				this.setActivartipo_movimientoDiarioGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiarioGeneralConstantesFunciones.NUMEROMAYOR)) {
				this.setActivarnumero_mayorDiarioGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiarioGeneralConstantesFunciones.CODIGO)) {
				this.setActivarcodigoDiarioGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiarioGeneralConstantesFunciones.NOMBRE)) {
				this.setActivarnombreDiarioGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiarioGeneralConstantesFunciones.CODIGOASIENTO)) {
				this.setActivarcodigo_asientoDiarioGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiarioGeneralConstantesFunciones.DEBITOLOCAL)) {
				this.setActivardebito_localDiarioGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiarioGeneralConstantesFunciones.CREDITOLOCAL)) {
				this.setActivarcredito_localDiarioGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiarioGeneralConstantesFunciones.DEBITOEXTRAN)) {
				this.setActivardebito_extranDiarioGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiarioGeneralConstantesFunciones.CREDITOEXTRAN)) {
				this.setActivarcredito_extranDiarioGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiarioGeneralConstantesFunciones.FECHA)) {
				this.setActivarfechaDiarioGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiarioGeneralConstantesFunciones.DETALLE)) {
				this.setActivardetalleDiarioGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiarioGeneralConstantesFunciones.NOMBREESTADO)) {
				this.setActivarnombre_estadoDiarioGeneral(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,DiarioGeneralBeanSwingJInternalFrame diariogeneralBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridDiarioGeneral(esInicial);
		this.setResaltarid_empresaDiarioGeneral(esInicial);
		this.setResaltarid_sucursalDiarioGeneral(esInicial);
		this.setResaltarid_ejercicioDiarioGeneral(esInicial);
		this.setResaltarid_periodoDiarioGeneral(esInicial);
		this.setResaltarid_moduloDiarioGeneral(esInicial);
		this.setResaltarid_tipo_movimientoDiarioGeneral(esInicial);
		this.setResaltarid_tipo_documentoDiarioGeneral(esInicial);
		this.setResaltarfecha_inicioDiarioGeneral(esInicial);
		this.setResaltarfecha_finDiarioGeneral(esInicial);
		this.setResaltarid_asiento_contableDiarioGeneral(esInicial);
		this.setResaltartipo_movimientoDiarioGeneral(esInicial);
		this.setResaltarnumero_mayorDiarioGeneral(esInicial);
		this.setResaltarcodigoDiarioGeneral(esInicial);
		this.setResaltarnombreDiarioGeneral(esInicial);
		this.setResaltarcodigo_asientoDiarioGeneral(esInicial);
		this.setResaltardebito_localDiarioGeneral(esInicial);
		this.setResaltarcredito_localDiarioGeneral(esInicial);
		this.setResaltardebito_extranDiarioGeneral(esInicial);
		this.setResaltarcredito_extranDiarioGeneral(esInicial);
		this.setResaltarfechaDiarioGeneral(esInicial);
		this.setResaltardetalleDiarioGeneral(esInicial);
		this.setResaltarnombre_estadoDiarioGeneral(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DiarioGeneralConstantesFunciones.ID)) {
				this.setResaltaridDiarioGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiarioGeneralConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaDiarioGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiarioGeneralConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalDiarioGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiarioGeneralConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioDiarioGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiarioGeneralConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoDiarioGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiarioGeneralConstantesFunciones.IDMODULO)) {
				this.setResaltarid_moduloDiarioGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiarioGeneralConstantesFunciones.IDTIPOMOVIMIENTO)) {
				this.setResaltarid_tipo_movimientoDiarioGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiarioGeneralConstantesFunciones.IDTIPODOCUMENTO)) {
				this.setResaltarid_tipo_documentoDiarioGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiarioGeneralConstantesFunciones.FECHAINICIO)) {
				this.setResaltarfecha_inicioDiarioGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiarioGeneralConstantesFunciones.FECHAFIN)) {
				this.setResaltarfecha_finDiarioGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiarioGeneralConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setResaltarid_asiento_contableDiarioGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiarioGeneralConstantesFunciones.TIPOMOVIMIENTO)) {
				this.setResaltartipo_movimientoDiarioGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiarioGeneralConstantesFunciones.NUMEROMAYOR)) {
				this.setResaltarnumero_mayorDiarioGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiarioGeneralConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoDiarioGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiarioGeneralConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreDiarioGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiarioGeneralConstantesFunciones.CODIGOASIENTO)) {
				this.setResaltarcodigo_asientoDiarioGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiarioGeneralConstantesFunciones.DEBITOLOCAL)) {
				this.setResaltardebito_localDiarioGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiarioGeneralConstantesFunciones.CREDITOLOCAL)) {
				this.setResaltarcredito_localDiarioGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiarioGeneralConstantesFunciones.DEBITOEXTRAN)) {
				this.setResaltardebito_extranDiarioGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiarioGeneralConstantesFunciones.CREDITOEXTRAN)) {
				this.setResaltarcredito_extranDiarioGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiarioGeneralConstantesFunciones.FECHA)) {
				this.setResaltarfechaDiarioGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiarioGeneralConstantesFunciones.DETALLE)) {
				this.setResaltardetalleDiarioGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiarioGeneralConstantesFunciones.NOMBREESTADO)) {
				this.setResaltarnombre_estadoDiarioGeneral(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,DiarioGeneralBeanSwingJInternalFrame diariogeneralBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaReporteDiarioGeneral=true;

	public Boolean getMostrarBusquedaReporteDiarioGeneral() {
		return this.mostrarBusquedaReporteDiarioGeneral;
	}

	public void setMostrarBusquedaReporteDiarioGeneral(Boolean visibilidadResaltar) {
		this.mostrarBusquedaReporteDiarioGeneral= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaReporteDiarioGeneral=true;

	public Boolean getActivarBusquedaReporteDiarioGeneral() {
		return this.activarBusquedaReporteDiarioGeneral;
	}

	public void setActivarBusquedaReporteDiarioGeneral(Boolean habilitarResaltar) {
		this.activarBusquedaReporteDiarioGeneral= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaReporteDiarioGeneral=null;

	public Border getResaltarBusquedaReporteDiarioGeneral() {
		return this.resaltarBusquedaReporteDiarioGeneral;
	}

	public void setResaltarBusquedaReporteDiarioGeneral(Border borderResaltar) {
		this.resaltarBusquedaReporteDiarioGeneral= borderResaltar;
	}

	public void setResaltarBusquedaReporteDiarioGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*DiarioGeneralBeanSwingJInternalFrame diariogeneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaReporteDiarioGeneral= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}