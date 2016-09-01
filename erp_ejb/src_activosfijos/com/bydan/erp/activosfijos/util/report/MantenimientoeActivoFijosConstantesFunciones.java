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
package com.bydan.erp.activosfijos.util.report;

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


import com.bydan.erp.activosfijos.util.report.MantenimientoeActivoFijosConstantesFunciones;
import com.bydan.erp.activosfijos.util.report.MantenimientoeActivoFijosParameterReturnGeneral;
//import com.bydan.erp.activosfijos.util.report.MantenimientoeActivoFijosParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.activosfijos.business.dataaccess.*;
//import com.bydan.erp.activosfijos.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class MantenimientoeActivoFijosConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="MantenimientoeActivoFijos";
	public static final String SPATHOPCION="ActivosFijos";	
	public static final String SPATHMODULO="activosfijos/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="MantenimientoeActivoFijos"+MantenimientoeActivoFijosConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="MantenimientoeActivoFijosHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="MantenimientoeActivoFijosHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=MantenimientoeActivoFijosConstantesFunciones.SCHEMA+"_"+MantenimientoeActivoFijosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/MantenimientoeActivoFijosHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=MantenimientoeActivoFijosConstantesFunciones.SCHEMA+"_"+MantenimientoeActivoFijosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=MantenimientoeActivoFijosConstantesFunciones.SCHEMA+"_"+MantenimientoeActivoFijosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/MantenimientoeActivoFijosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=MantenimientoeActivoFijosConstantesFunciones.SCHEMA+"_"+MantenimientoeActivoFijosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+MantenimientoeActivoFijosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/MantenimientoeActivoFijosHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+MantenimientoeActivoFijosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+MantenimientoeActivoFijosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/MantenimientoeActivoFijosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+MantenimientoeActivoFijosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=MantenimientoeActivoFijosConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+MantenimientoeActivoFijosConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=MantenimientoeActivoFijosConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+MantenimientoeActivoFijosConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Mantenimientoe Activo Fijoses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Mantenimientoe Activo Fijos";
	public static final String SCLASSWEBTITULO_LOWER="Mantenimientoe Activo Fijos";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="MantenimientoeActivoFijos";
	public static final String OBJECTNAME="mantenimientoeactivofijos";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_ACTIVOSFIJOS;	
	public static final String TABLENAME="mantenimientoe_activo_fijos";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select mantenimientoeactivofijos from "+MantenimientoeActivoFijosConstantesFunciones.SPERSISTENCENAME+" mantenimientoeactivofijos";
	public static String QUERYSELECTNATIVE="select "+MantenimientoeActivoFijosConstantesFunciones.SCHEMA+"."+MantenimientoeActivoFijosConstantesFunciones.TABLENAME+".id,"+MantenimientoeActivoFijosConstantesFunciones.SCHEMA+"."+MantenimientoeActivoFijosConstantesFunciones.TABLENAME+".version_row,"+MantenimientoeActivoFijosConstantesFunciones.SCHEMA+"."+MantenimientoeActivoFijosConstantesFunciones.TABLENAME+".id_empresa,"+MantenimientoeActivoFijosConstantesFunciones.SCHEMA+"."+MantenimientoeActivoFijosConstantesFunciones.TABLENAME+".numero_documento,"+MantenimientoeActivoFijosConstantesFunciones.SCHEMA+"."+MantenimientoeActivoFijosConstantesFunciones.TABLENAME+".causa,"+MantenimientoeActivoFijosConstantesFunciones.SCHEMA+"."+MantenimientoeActivoFijosConstantesFunciones.TABLENAME+".referencia,"+MantenimientoeActivoFijosConstantesFunciones.SCHEMA+"."+MantenimientoeActivoFijosConstantesFunciones.TABLENAME+".taller,"+MantenimientoeActivoFijosConstantesFunciones.SCHEMA+"."+MantenimientoeActivoFijosConstantesFunciones.TABLENAME+".fecha_inicio,"+MantenimientoeActivoFijosConstantesFunciones.SCHEMA+"."+MantenimientoeActivoFijosConstantesFunciones.TABLENAME+".fecha_entrega,"+MantenimientoeActivoFijosConstantesFunciones.SCHEMA+"."+MantenimientoeActivoFijosConstantesFunciones.TABLENAME+".costo,"+MantenimientoeActivoFijosConstantesFunciones.SCHEMA+"."+MantenimientoeActivoFijosConstantesFunciones.TABLENAME+".responsable,"+MantenimientoeActivoFijosConstantesFunciones.SCHEMA+"."+MantenimientoeActivoFijosConstantesFunciones.TABLENAME+".observacion,"+MantenimientoeActivoFijosConstantesFunciones.SCHEMA+"."+MantenimientoeActivoFijosConstantesFunciones.TABLENAME+".tipo_movimiento,"+MantenimientoeActivoFijosConstantesFunciones.SCHEMA+"."+MantenimientoeActivoFijosConstantesFunciones.TABLENAME+".clave,"+MantenimientoeActivoFijosConstantesFunciones.SCHEMA+"."+MantenimientoeActivoFijosConstantesFunciones.TABLENAME+".nombre,"+MantenimientoeActivoFijosConstantesFunciones.SCHEMA+"."+MantenimientoeActivoFijosConstantesFunciones.TABLENAME+".codigo_detalle_grupo,"+MantenimientoeActivoFijosConstantesFunciones.SCHEMA+"."+MantenimientoeActivoFijosConstantesFunciones.TABLENAME+".nombre_detalle_grupo from "+MantenimientoeActivoFijosConstantesFunciones.SCHEMA+"."+MantenimientoeActivoFijosConstantesFunciones.TABLENAME;//+" as "+MantenimientoeActivoFijosConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String NUMERODOCUMENTO= "numero_documento";
    public static final String CAUSA= "causa";
    public static final String REFERENCIA= "referencia";
    public static final String TALLER= "taller";
    public static final String FECHAINICIO= "fecha_inicio";
    public static final String FECHAENTREGA= "fecha_entrega";
    public static final String COSTO= "costo";
    public static final String RESPONSABLE= "responsable";
    public static final String OBSERVACION= "observacion";
    public static final String TIPOMOVIMIENTO= "tipo_movimiento";
    public static final String CLAVE= "clave";
    public static final String NOMBRE= "nombre";
    public static final String CODIGODETALLEGRUPO= "codigo_detalle_grupo";
    public static final String NOMBREDETALLEGRUPO= "nombre_detalle_grupo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_NUMERODOCUMENTO= "Numero Documento";
		public static final String LABEL_NUMERODOCUMENTO_LOWER= "Numero Documento";
    	public static final String LABEL_CAUSA= "Causa";
		public static final String LABEL_CAUSA_LOWER= "Causa";
    	public static final String LABEL_REFERENCIA= "Referencia";
		public static final String LABEL_REFERENCIA_LOWER= "Referencia";
    	public static final String LABEL_TALLER= "Taller";
		public static final String LABEL_TALLER_LOWER= "Taller";
    	public static final String LABEL_FECHAINICIO= "Fecha Inicio";
		public static final String LABEL_FECHAINICIO_LOWER= "Fecha Inicio";
    	public static final String LABEL_FECHAENTREGA= "Fecha Entrega";
		public static final String LABEL_FECHAENTREGA_LOWER= "Fecha Entrega";
    	public static final String LABEL_COSTO= "Costo";
		public static final String LABEL_COSTO_LOWER= "Costo";
    	public static final String LABEL_RESPONSABLE= "Responsable";
		public static final String LABEL_RESPONSABLE_LOWER= "Responsable";
    	public static final String LABEL_OBSERVACION= "Observacion";
		public static final String LABEL_OBSERVACION_LOWER= "Observacion";
    	public static final String LABEL_TIPOMOVIMIENTO= "Tipo Movimiento";
		public static final String LABEL_TIPOMOVIMIENTO_LOWER= "Tipo Movimiento";
    	public static final String LABEL_CLAVE= "Clave";
		public static final String LABEL_CLAVE_LOWER= "Clave";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_CODIGODETALLEGRUPO= "Codigo Detalle Grupo";
		public static final String LABEL_CODIGODETALLEGRUPO_LOWER= "Codigo Detalle Grupo";
    	public static final String LABEL_NOMBREDETALLEGRUPO= "Nombre Detalle Grupo";
		public static final String LABEL_NOMBREDETALLEGRUPO_LOWER= "Nombre Detalle Grupo";
	
		
		
		
	public static final String SREGEXNUMERO_DOCUMENTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_DOCUMENTO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCAUSA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCAUSA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXREFERENCIA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXREFERENCIA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXTALLER=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXTALLER=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
	public static final String SREGEXRESPONSABLE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXRESPONSABLE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXOBSERVACION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXOBSERVACION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXTIPO_MOVIMIENTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXTIPO_MOVIMIENTO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCLAVE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCLAVE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO_DETALLE_GRUPO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_DETALLE_GRUPO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_DETALLE_GRUPO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_DETALLE_GRUPO=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getMantenimientoeActivoFijosLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(MantenimientoeActivoFijosConstantesFunciones.IDEMPRESA)) {sLabelColumna=MantenimientoeActivoFijosConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(MantenimientoeActivoFijosConstantesFunciones.NUMERODOCUMENTO)) {sLabelColumna=MantenimientoeActivoFijosConstantesFunciones.LABEL_NUMERODOCUMENTO;}
		if(sNombreColumna.equals(MantenimientoeActivoFijosConstantesFunciones.CAUSA)) {sLabelColumna=MantenimientoeActivoFijosConstantesFunciones.LABEL_CAUSA;}
		if(sNombreColumna.equals(MantenimientoeActivoFijosConstantesFunciones.REFERENCIA)) {sLabelColumna=MantenimientoeActivoFijosConstantesFunciones.LABEL_REFERENCIA;}
		if(sNombreColumna.equals(MantenimientoeActivoFijosConstantesFunciones.TALLER)) {sLabelColumna=MantenimientoeActivoFijosConstantesFunciones.LABEL_TALLER;}
		if(sNombreColumna.equals(MantenimientoeActivoFijosConstantesFunciones.FECHAINICIO)) {sLabelColumna=MantenimientoeActivoFijosConstantesFunciones.LABEL_FECHAINICIO;}
		if(sNombreColumna.equals(MantenimientoeActivoFijosConstantesFunciones.FECHAENTREGA)) {sLabelColumna=MantenimientoeActivoFijosConstantesFunciones.LABEL_FECHAENTREGA;}
		if(sNombreColumna.equals(MantenimientoeActivoFijosConstantesFunciones.COSTO)) {sLabelColumna=MantenimientoeActivoFijosConstantesFunciones.LABEL_COSTO;}
		if(sNombreColumna.equals(MantenimientoeActivoFijosConstantesFunciones.RESPONSABLE)) {sLabelColumna=MantenimientoeActivoFijosConstantesFunciones.LABEL_RESPONSABLE;}
		if(sNombreColumna.equals(MantenimientoeActivoFijosConstantesFunciones.OBSERVACION)) {sLabelColumna=MantenimientoeActivoFijosConstantesFunciones.LABEL_OBSERVACION;}
		if(sNombreColumna.equals(MantenimientoeActivoFijosConstantesFunciones.TIPOMOVIMIENTO)) {sLabelColumna=MantenimientoeActivoFijosConstantesFunciones.LABEL_TIPOMOVIMIENTO;}
		if(sNombreColumna.equals(MantenimientoeActivoFijosConstantesFunciones.CLAVE)) {sLabelColumna=MantenimientoeActivoFijosConstantesFunciones.LABEL_CLAVE;}
		if(sNombreColumna.equals(MantenimientoeActivoFijosConstantesFunciones.NOMBRE)) {sLabelColumna=MantenimientoeActivoFijosConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(MantenimientoeActivoFijosConstantesFunciones.CODIGODETALLEGRUPO)) {sLabelColumna=MantenimientoeActivoFijosConstantesFunciones.LABEL_CODIGODETALLEGRUPO;}
		if(sNombreColumna.equals(MantenimientoeActivoFijosConstantesFunciones.NOMBREDETALLEGRUPO)) {sLabelColumna=MantenimientoeActivoFijosConstantesFunciones.LABEL_NOMBREDETALLEGRUPO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getMantenimientoeActivoFijosDescripcion(MantenimientoeActivoFijos mantenimientoeactivofijos) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(mantenimientoeactivofijos !=null/* && mantenimientoeactivofijos.getId()!=0*/) {
			sDescripcion=mantenimientoeactivofijos.getnombre();//mantenimientoeactivofijosmantenimientoeactivofijos.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getMantenimientoeActivoFijosDescripcionDetallado(MantenimientoeActivoFijos mantenimientoeactivofijos) {
		String sDescripcion="";
			
		sDescripcion+=MantenimientoeActivoFijosConstantesFunciones.ID+"=";
		sDescripcion+=mantenimientoeactivofijos.getId().toString()+",";
		sDescripcion+=MantenimientoeActivoFijosConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=mantenimientoeactivofijos.getVersionRow().toString()+",";
		sDescripcion+=MantenimientoeActivoFijosConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=mantenimientoeactivofijos.getid_empresa().toString()+",";
		sDescripcion+=MantenimientoeActivoFijosConstantesFunciones.NUMERODOCUMENTO+"=";
		sDescripcion+=mantenimientoeactivofijos.getnumero_documento()+",";
		sDescripcion+=MantenimientoeActivoFijosConstantesFunciones.CAUSA+"=";
		sDescripcion+=mantenimientoeactivofijos.getcausa()+",";
		sDescripcion+=MantenimientoeActivoFijosConstantesFunciones.REFERENCIA+"=";
		sDescripcion+=mantenimientoeactivofijos.getreferencia()+",";
		sDescripcion+=MantenimientoeActivoFijosConstantesFunciones.TALLER+"=";
		sDescripcion+=mantenimientoeactivofijos.gettaller()+",";
		sDescripcion+=MantenimientoeActivoFijosConstantesFunciones.FECHAINICIO+"=";
		sDescripcion+=mantenimientoeactivofijos.getfecha_inicio().toString()+",";
		sDescripcion+=MantenimientoeActivoFijosConstantesFunciones.FECHAENTREGA+"=";
		sDescripcion+=mantenimientoeactivofijos.getfecha_entrega().toString()+",";
		sDescripcion+=MantenimientoeActivoFijosConstantesFunciones.COSTO+"=";
		sDescripcion+=mantenimientoeactivofijos.getcosto().toString()+",";
		sDescripcion+=MantenimientoeActivoFijosConstantesFunciones.RESPONSABLE+"=";
		sDescripcion+=mantenimientoeactivofijos.getresponsable()+",";
		sDescripcion+=MantenimientoeActivoFijosConstantesFunciones.OBSERVACION+"=";
		sDescripcion+=mantenimientoeactivofijos.getobservacion()+",";
		sDescripcion+=MantenimientoeActivoFijosConstantesFunciones.TIPOMOVIMIENTO+"=";
		sDescripcion+=mantenimientoeactivofijos.gettipo_movimiento()+",";
		sDescripcion+=MantenimientoeActivoFijosConstantesFunciones.CLAVE+"=";
		sDescripcion+=mantenimientoeactivofijos.getclave()+",";
		sDescripcion+=MantenimientoeActivoFijosConstantesFunciones.NOMBRE+"=";
		sDescripcion+=mantenimientoeactivofijos.getnombre()+",";
		sDescripcion+=MantenimientoeActivoFijosConstantesFunciones.CODIGODETALLEGRUPO+"=";
		sDescripcion+=mantenimientoeactivofijos.getcodigo_detalle_grupo()+",";
		sDescripcion+=MantenimientoeActivoFijosConstantesFunciones.NOMBREDETALLEGRUPO+"=";
		sDescripcion+=mantenimientoeactivofijos.getnombre_detalle_grupo()+",";
			
		return sDescripcion;
	}
	
	public static void setMantenimientoeActivoFijosDescripcion(MantenimientoeActivoFijos mantenimientoeactivofijos,String sValor) throws Exception {			
		if(mantenimientoeactivofijos !=null) {
			mantenimientoeactivofijos.setnombre(sValor);;//mantenimientoeactivofijosmantenimientoeactivofijos.getnombre().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaMantenimientoeActivoFijos")) {
			sNombreIndice="Tipo=  Por ";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaMantenimientoeActivoFijos(Long id) {
		String sDetalleIndice=" Parametros->";
		if(id!=null) {sDetalleIndice+=" ="+id.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosMantenimientoeActivoFijos(MantenimientoeActivoFijos mantenimientoeactivofijos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		mantenimientoeactivofijos.setnumero_documento(mantenimientoeactivofijos.getnumero_documento().trim());
		mantenimientoeactivofijos.setcausa(mantenimientoeactivofijos.getcausa().trim());
		mantenimientoeactivofijos.setreferencia(mantenimientoeactivofijos.getreferencia().trim());
		mantenimientoeactivofijos.settaller(mantenimientoeactivofijos.gettaller().trim());
		mantenimientoeactivofijos.setresponsable(mantenimientoeactivofijos.getresponsable().trim());
		mantenimientoeactivofijos.setobservacion(mantenimientoeactivofijos.getobservacion().trim());
		mantenimientoeactivofijos.settipo_movimiento(mantenimientoeactivofijos.gettipo_movimiento().trim());
		mantenimientoeactivofijos.setclave(mantenimientoeactivofijos.getclave().trim());
		mantenimientoeactivofijos.setnombre(mantenimientoeactivofijos.getnombre().trim());
		mantenimientoeactivofijos.setcodigo_detalle_grupo(mantenimientoeactivofijos.getcodigo_detalle_grupo().trim());
		mantenimientoeactivofijos.setnombre_detalle_grupo(mantenimientoeactivofijos.getnombre_detalle_grupo().trim());
	}
	
	public static void quitarEspaciosMantenimientoeActivoFijoss(List<MantenimientoeActivoFijos> mantenimientoeactivofijoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(MantenimientoeActivoFijos mantenimientoeactivofijos: mantenimientoeactivofijoss) {
			mantenimientoeactivofijos.setnumero_documento(mantenimientoeactivofijos.getnumero_documento().trim());
			mantenimientoeactivofijos.setcausa(mantenimientoeactivofijos.getcausa().trim());
			mantenimientoeactivofijos.setreferencia(mantenimientoeactivofijos.getreferencia().trim());
			mantenimientoeactivofijos.settaller(mantenimientoeactivofijos.gettaller().trim());
			mantenimientoeactivofijos.setresponsable(mantenimientoeactivofijos.getresponsable().trim());
			mantenimientoeactivofijos.setobservacion(mantenimientoeactivofijos.getobservacion().trim());
			mantenimientoeactivofijos.settipo_movimiento(mantenimientoeactivofijos.gettipo_movimiento().trim());
			mantenimientoeactivofijos.setclave(mantenimientoeactivofijos.getclave().trim());
			mantenimientoeactivofijos.setnombre(mantenimientoeactivofijos.getnombre().trim());
			mantenimientoeactivofijos.setcodigo_detalle_grupo(mantenimientoeactivofijos.getcodigo_detalle_grupo().trim());
			mantenimientoeactivofijos.setnombre_detalle_grupo(mantenimientoeactivofijos.getnombre_detalle_grupo().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresMantenimientoeActivoFijos(MantenimientoeActivoFijos mantenimientoeactivofijos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && mantenimientoeactivofijos.getConCambioAuxiliar()) {
			mantenimientoeactivofijos.setIsDeleted(mantenimientoeactivofijos.getIsDeletedAuxiliar());	
			mantenimientoeactivofijos.setIsNew(mantenimientoeactivofijos.getIsNewAuxiliar());	
			mantenimientoeactivofijos.setIsChanged(mantenimientoeactivofijos.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			mantenimientoeactivofijos.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			mantenimientoeactivofijos.setIsDeletedAuxiliar(false);	
			mantenimientoeactivofijos.setIsNewAuxiliar(false);	
			mantenimientoeactivofijos.setIsChangedAuxiliar(false);
			
			mantenimientoeactivofijos.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresMantenimientoeActivoFijoss(List<MantenimientoeActivoFijos> mantenimientoeactivofijoss,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(MantenimientoeActivoFijos mantenimientoeactivofijos : mantenimientoeactivofijoss) {
			if(conAsignarBase && mantenimientoeactivofijos.getConCambioAuxiliar()) {
				mantenimientoeactivofijos.setIsDeleted(mantenimientoeactivofijos.getIsDeletedAuxiliar());	
				mantenimientoeactivofijos.setIsNew(mantenimientoeactivofijos.getIsNewAuxiliar());	
				mantenimientoeactivofijos.setIsChanged(mantenimientoeactivofijos.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				mantenimientoeactivofijos.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				mantenimientoeactivofijos.setIsDeletedAuxiliar(false);	
				mantenimientoeactivofijos.setIsNewAuxiliar(false);	
				mantenimientoeactivofijos.setIsChangedAuxiliar(false);
				
				mantenimientoeactivofijos.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresMantenimientoeActivoFijos(MantenimientoeActivoFijos mantenimientoeactivofijos,Boolean conEnteros) throws Exception  {
		mantenimientoeactivofijos.setcosto(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresMantenimientoeActivoFijoss(List<MantenimientoeActivoFijos> mantenimientoeactivofijoss,Boolean conEnteros) throws Exception  {
		
		for(MantenimientoeActivoFijos mantenimientoeactivofijos: mantenimientoeactivofijoss) {
			mantenimientoeactivofijos.setcosto(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaMantenimientoeActivoFijos(List<MantenimientoeActivoFijos> mantenimientoeactivofijoss,MantenimientoeActivoFijos mantenimientoeactivofijosAux) throws Exception  {
		MantenimientoeActivoFijosConstantesFunciones.InicializarValoresMantenimientoeActivoFijos(mantenimientoeactivofijosAux,true);
		
		for(MantenimientoeActivoFijos mantenimientoeactivofijos: mantenimientoeactivofijoss) {
			if(mantenimientoeactivofijos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			mantenimientoeactivofijosAux.setcosto(mantenimientoeactivofijosAux.getcosto()+mantenimientoeactivofijos.getcosto());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesMantenimientoeActivoFijos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=MantenimientoeActivoFijosConstantesFunciones.getArrayColumnasGlobalesMantenimientoeActivoFijos(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesMantenimientoeActivoFijos(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(MantenimientoeActivoFijosConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(MantenimientoeActivoFijosConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoMantenimientoeActivoFijos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<MantenimientoeActivoFijos> mantenimientoeactivofijoss,MantenimientoeActivoFijos mantenimientoeactivofijos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(MantenimientoeActivoFijos mantenimientoeactivofijosAux: mantenimientoeactivofijoss) {
			if(mantenimientoeactivofijosAux!=null && mantenimientoeactivofijos!=null) {
				if((mantenimientoeactivofijosAux.getId()==null && mantenimientoeactivofijos.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(mantenimientoeactivofijosAux.getId()!=null && mantenimientoeactivofijos.getId()!=null){
					if(mantenimientoeactivofijosAux.getId().equals(mantenimientoeactivofijos.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaMantenimientoeActivoFijos(List<MantenimientoeActivoFijos> mantenimientoeactivofijoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double costoTotal=0.0;
	
		for(MantenimientoeActivoFijos mantenimientoeactivofijos: mantenimientoeactivofijoss) {			
			if(mantenimientoeactivofijos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			costoTotal+=mantenimientoeactivofijos.getcosto();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(MantenimientoeActivoFijosConstantesFunciones.COSTO);
		datoGeneral.setsDescripcion(MantenimientoeActivoFijosConstantesFunciones.LABEL_COSTO);
		datoGeneral.setdValorDouble(costoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaMantenimientoeActivoFijos() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,MantenimientoeActivoFijosConstantesFunciones.LABEL_ID, MantenimientoeActivoFijosConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MantenimientoeActivoFijosConstantesFunciones.LABEL_VERSIONROW, MantenimientoeActivoFijosConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MantenimientoeActivoFijosConstantesFunciones.LABEL_NUMERODOCUMENTO, MantenimientoeActivoFijosConstantesFunciones.NUMERODOCUMENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MantenimientoeActivoFijosConstantesFunciones.LABEL_CAUSA, MantenimientoeActivoFijosConstantesFunciones.CAUSA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MantenimientoeActivoFijosConstantesFunciones.LABEL_REFERENCIA, MantenimientoeActivoFijosConstantesFunciones.REFERENCIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MantenimientoeActivoFijosConstantesFunciones.LABEL_TALLER, MantenimientoeActivoFijosConstantesFunciones.TALLER,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MantenimientoeActivoFijosConstantesFunciones.LABEL_FECHAINICIO, MantenimientoeActivoFijosConstantesFunciones.FECHAINICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MantenimientoeActivoFijosConstantesFunciones.LABEL_FECHAENTREGA, MantenimientoeActivoFijosConstantesFunciones.FECHAENTREGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MantenimientoeActivoFijosConstantesFunciones.LABEL_COSTO, MantenimientoeActivoFijosConstantesFunciones.COSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MantenimientoeActivoFijosConstantesFunciones.LABEL_RESPONSABLE, MantenimientoeActivoFijosConstantesFunciones.RESPONSABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MantenimientoeActivoFijosConstantesFunciones.LABEL_OBSERVACION, MantenimientoeActivoFijosConstantesFunciones.OBSERVACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MantenimientoeActivoFijosConstantesFunciones.LABEL_TIPOMOVIMIENTO, MantenimientoeActivoFijosConstantesFunciones.TIPOMOVIMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MantenimientoeActivoFijosConstantesFunciones.LABEL_CLAVE, MantenimientoeActivoFijosConstantesFunciones.CLAVE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MantenimientoeActivoFijosConstantesFunciones.LABEL_NOMBRE, MantenimientoeActivoFijosConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MantenimientoeActivoFijosConstantesFunciones.LABEL_CODIGODETALLEGRUPO, MantenimientoeActivoFijosConstantesFunciones.CODIGODETALLEGRUPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MantenimientoeActivoFijosConstantesFunciones.LABEL_NOMBREDETALLEGRUPO, MantenimientoeActivoFijosConstantesFunciones.NOMBREDETALLEGRUPO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasMantenimientoeActivoFijos() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=MantenimientoeActivoFijosConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MantenimientoeActivoFijosConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MantenimientoeActivoFijosConstantesFunciones.NUMERODOCUMENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MantenimientoeActivoFijosConstantesFunciones.CAUSA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MantenimientoeActivoFijosConstantesFunciones.REFERENCIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MantenimientoeActivoFijosConstantesFunciones.TALLER;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MantenimientoeActivoFijosConstantesFunciones.FECHAINICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MantenimientoeActivoFijosConstantesFunciones.FECHAENTREGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MantenimientoeActivoFijosConstantesFunciones.COSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MantenimientoeActivoFijosConstantesFunciones.RESPONSABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MantenimientoeActivoFijosConstantesFunciones.OBSERVACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MantenimientoeActivoFijosConstantesFunciones.TIPOMOVIMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MantenimientoeActivoFijosConstantesFunciones.CLAVE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MantenimientoeActivoFijosConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MantenimientoeActivoFijosConstantesFunciones.CODIGODETALLEGRUPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MantenimientoeActivoFijosConstantesFunciones.NOMBREDETALLEGRUPO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarMantenimientoeActivoFijos() throws Exception  {
		return MantenimientoeActivoFijosConstantesFunciones.getTiposSeleccionarMantenimientoeActivoFijos(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarMantenimientoeActivoFijos(Boolean conFk) throws Exception  {
		return MantenimientoeActivoFijosConstantesFunciones.getTiposSeleccionarMantenimientoeActivoFijos(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarMantenimientoeActivoFijos(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(MantenimientoeActivoFijosConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(MantenimientoeActivoFijosConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MantenimientoeActivoFijosConstantesFunciones.LABEL_NUMERODOCUMENTO);
			reporte.setsDescripcion(MantenimientoeActivoFijosConstantesFunciones.LABEL_NUMERODOCUMENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MantenimientoeActivoFijosConstantesFunciones.LABEL_CAUSA);
			reporte.setsDescripcion(MantenimientoeActivoFijosConstantesFunciones.LABEL_CAUSA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MantenimientoeActivoFijosConstantesFunciones.LABEL_REFERENCIA);
			reporte.setsDescripcion(MantenimientoeActivoFijosConstantesFunciones.LABEL_REFERENCIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MantenimientoeActivoFijosConstantesFunciones.LABEL_TALLER);
			reporte.setsDescripcion(MantenimientoeActivoFijosConstantesFunciones.LABEL_TALLER);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MantenimientoeActivoFijosConstantesFunciones.LABEL_FECHAINICIO);
			reporte.setsDescripcion(MantenimientoeActivoFijosConstantesFunciones.LABEL_FECHAINICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MantenimientoeActivoFijosConstantesFunciones.LABEL_FECHAENTREGA);
			reporte.setsDescripcion(MantenimientoeActivoFijosConstantesFunciones.LABEL_FECHAENTREGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MantenimientoeActivoFijosConstantesFunciones.LABEL_COSTO);
			reporte.setsDescripcion(MantenimientoeActivoFijosConstantesFunciones.LABEL_COSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MantenimientoeActivoFijosConstantesFunciones.LABEL_RESPONSABLE);
			reporte.setsDescripcion(MantenimientoeActivoFijosConstantesFunciones.LABEL_RESPONSABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MantenimientoeActivoFijosConstantesFunciones.LABEL_OBSERVACION);
			reporte.setsDescripcion(MantenimientoeActivoFijosConstantesFunciones.LABEL_OBSERVACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MantenimientoeActivoFijosConstantesFunciones.LABEL_TIPOMOVIMIENTO);
			reporte.setsDescripcion(MantenimientoeActivoFijosConstantesFunciones.LABEL_TIPOMOVIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MantenimientoeActivoFijosConstantesFunciones.LABEL_CLAVE);
			reporte.setsDescripcion(MantenimientoeActivoFijosConstantesFunciones.LABEL_CLAVE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MantenimientoeActivoFijosConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(MantenimientoeActivoFijosConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MantenimientoeActivoFijosConstantesFunciones.LABEL_CODIGODETALLEGRUPO);
			reporte.setsDescripcion(MantenimientoeActivoFijosConstantesFunciones.LABEL_CODIGODETALLEGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MantenimientoeActivoFijosConstantesFunciones.LABEL_NOMBREDETALLEGRUPO);
			reporte.setsDescripcion(MantenimientoeActivoFijosConstantesFunciones.LABEL_NOMBREDETALLEGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesMantenimientoeActivoFijos(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesMantenimientoeActivoFijos(MantenimientoeActivoFijos mantenimientoeactivofijosAux) throws Exception {
		
			mantenimientoeactivofijosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(mantenimientoeactivofijosAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesMantenimientoeActivoFijos(List<MantenimientoeActivoFijos> mantenimientoeactivofijossTemp) throws Exception {
		for(MantenimientoeActivoFijos mantenimientoeactivofijosAux:mantenimientoeactivofijossTemp) {
			
			mantenimientoeactivofijosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(mantenimientoeactivofijosAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfMantenimientoeActivoFijos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfMantenimientoeActivoFijos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfMantenimientoeActivoFijos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return MantenimientoeActivoFijosConstantesFunciones.getClassesRelationshipsOfMantenimientoeActivoFijos(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfMantenimientoeActivoFijos(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfMantenimientoeActivoFijos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return MantenimientoeActivoFijosConstantesFunciones.getClassesRelationshipsFromStringsOfMantenimientoeActivoFijos(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfMantenimientoeActivoFijos(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(MantenimientoeActivoFijos mantenimientoeactivofijos,List<MantenimientoeActivoFijos> mantenimientoeactivofijoss,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(MantenimientoeActivoFijos mantenimientoeactivofijos,List<MantenimientoeActivoFijos> mantenimientoeactivofijoss) throws Exception {
		try	{			
			for(MantenimientoeActivoFijos mantenimientoeactivofijosLocal:mantenimientoeactivofijoss) {
				if(mantenimientoeactivofijosLocal.getId().equals(mantenimientoeactivofijos.getId())) {
					mantenimientoeactivofijosLocal.setIsSelected(mantenimientoeactivofijos.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesMantenimientoeActivoFijos(List<MantenimientoeActivoFijos> mantenimientoeactivofijossAux) throws Exception {
		//this.mantenimientoeactivofijossAux=mantenimientoeactivofijossAux;
		
		for(MantenimientoeActivoFijos mantenimientoeactivofijosAux:mantenimientoeactivofijossAux) {
			if(mantenimientoeactivofijosAux.getIsChanged()) {
				mantenimientoeactivofijosAux.setIsChanged(false);
			}		
			
			if(mantenimientoeactivofijosAux.getIsNew()) {
				mantenimientoeactivofijosAux.setIsNew(false);
			}	
			
			if(mantenimientoeactivofijosAux.getIsDeleted()) {
				mantenimientoeactivofijosAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesMantenimientoeActivoFijos(MantenimientoeActivoFijos mantenimientoeactivofijosAux) throws Exception {
		//this.mantenimientoeactivofijosAux=mantenimientoeactivofijosAux;
		
			if(mantenimientoeactivofijosAux.getIsChanged()) {
				mantenimientoeactivofijosAux.setIsChanged(false);
			}		
			
			if(mantenimientoeactivofijosAux.getIsNew()) {
				mantenimientoeactivofijosAux.setIsNew(false);
			}	
			
			if(mantenimientoeactivofijosAux.getIsDeleted()) {
				mantenimientoeactivofijosAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(MantenimientoeActivoFijos mantenimientoeactivofijosAsignar,MantenimientoeActivoFijos mantenimientoeactivofijos) throws Exception {
		mantenimientoeactivofijosAsignar.setId(mantenimientoeactivofijos.getId());	
		mantenimientoeactivofijosAsignar.setVersionRow(mantenimientoeactivofijos.getVersionRow());	
		mantenimientoeactivofijosAsignar.setnumero_documento(mantenimientoeactivofijos.getnumero_documento());	
		mantenimientoeactivofijosAsignar.setcausa(mantenimientoeactivofijos.getcausa());	
		mantenimientoeactivofijosAsignar.setreferencia(mantenimientoeactivofijos.getreferencia());	
		mantenimientoeactivofijosAsignar.settaller(mantenimientoeactivofijos.gettaller());	
		mantenimientoeactivofijosAsignar.setfecha_inicio(mantenimientoeactivofijos.getfecha_inicio());	
		mantenimientoeactivofijosAsignar.setfecha_entrega(mantenimientoeactivofijos.getfecha_entrega());	
		mantenimientoeactivofijosAsignar.setcosto(mantenimientoeactivofijos.getcosto());	
		mantenimientoeactivofijosAsignar.setresponsable(mantenimientoeactivofijos.getresponsable());	
		mantenimientoeactivofijosAsignar.setobservacion(mantenimientoeactivofijos.getobservacion());	
		mantenimientoeactivofijosAsignar.settipo_movimiento(mantenimientoeactivofijos.gettipo_movimiento());	
		mantenimientoeactivofijosAsignar.setclave(mantenimientoeactivofijos.getclave());	
		mantenimientoeactivofijosAsignar.setnombre(mantenimientoeactivofijos.getnombre());	
		mantenimientoeactivofijosAsignar.setcodigo_detalle_grupo(mantenimientoeactivofijos.getcodigo_detalle_grupo());	
		mantenimientoeactivofijosAsignar.setnombre_detalle_grupo(mantenimientoeactivofijos.getnombre_detalle_grupo());	
	}
	
	public static void inicializarMantenimientoeActivoFijos(MantenimientoeActivoFijos mantenimientoeactivofijos) throws Exception {
		try {
				mantenimientoeactivofijos.setId(0L);	
					
				mantenimientoeactivofijos.setnumero_documento("");	
				mantenimientoeactivofijos.setcausa("");	
				mantenimientoeactivofijos.setreferencia("");	
				mantenimientoeactivofijos.settaller("");	
				mantenimientoeactivofijos.setfecha_inicio(new Date());	
				mantenimientoeactivofijos.setfecha_entrega(new Date());	
				mantenimientoeactivofijos.setcosto(0.0);	
				mantenimientoeactivofijos.setresponsable("");	
				mantenimientoeactivofijos.setobservacion("");	
				mantenimientoeactivofijos.settipo_movimiento("");	
				mantenimientoeactivofijos.setclave("");	
				mantenimientoeactivofijos.setnombre("");	
				mantenimientoeactivofijos.setcodigo_detalle_grupo("");	
				mantenimientoeactivofijos.setnombre_detalle_grupo("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderMantenimientoeActivoFijos(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(MantenimientoeActivoFijosConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MantenimientoeActivoFijosConstantesFunciones.LABEL_NUMERODOCUMENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MantenimientoeActivoFijosConstantesFunciones.LABEL_CAUSA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MantenimientoeActivoFijosConstantesFunciones.LABEL_REFERENCIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MantenimientoeActivoFijosConstantesFunciones.LABEL_TALLER);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MantenimientoeActivoFijosConstantesFunciones.LABEL_FECHAINICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MantenimientoeActivoFijosConstantesFunciones.LABEL_FECHAENTREGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MantenimientoeActivoFijosConstantesFunciones.LABEL_COSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MantenimientoeActivoFijosConstantesFunciones.LABEL_RESPONSABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MantenimientoeActivoFijosConstantesFunciones.LABEL_OBSERVACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MantenimientoeActivoFijosConstantesFunciones.LABEL_TIPOMOVIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MantenimientoeActivoFijosConstantesFunciones.LABEL_CLAVE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MantenimientoeActivoFijosConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MantenimientoeActivoFijosConstantesFunciones.LABEL_CODIGODETALLEGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MantenimientoeActivoFijosConstantesFunciones.LABEL_NOMBREDETALLEGRUPO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataMantenimientoeActivoFijos(String sTipo,Row row,Workbook workbook,MantenimientoeActivoFijos mantenimientoeactivofijos,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(mantenimientoeactivofijos.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(mantenimientoeactivofijos.getnumero_documento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(mantenimientoeactivofijos.getcausa());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(mantenimientoeactivofijos.getreferencia());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(mantenimientoeactivofijos.gettaller());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(mantenimientoeactivofijos.getfecha_inicio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(mantenimientoeactivofijos.getfecha_entrega());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(mantenimientoeactivofijos.getcosto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(mantenimientoeactivofijos.getresponsable());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(mantenimientoeactivofijos.getobservacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(mantenimientoeactivofijos.gettipo_movimiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(mantenimientoeactivofijos.getclave());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(mantenimientoeactivofijos.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(mantenimientoeactivofijos.getcodigo_detalle_grupo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(mantenimientoeactivofijos.getnombre_detalle_grupo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryMantenimientoeActivoFijos="";
	
	public String getsFinalQueryMantenimientoeActivoFijos() {
		return this.sFinalQueryMantenimientoeActivoFijos;
	}
	
	public void setsFinalQueryMantenimientoeActivoFijos(String sFinalQueryMantenimientoeActivoFijos) {
		this.sFinalQueryMantenimientoeActivoFijos= sFinalQueryMantenimientoeActivoFijos;
	}
	
	public Border resaltarSeleccionarMantenimientoeActivoFijos=null;
	
	public Border setResaltarSeleccionarMantenimientoeActivoFijos(ParametroGeneralUsuario parametroGeneralUsuario/*MantenimientoeActivoFijosBeanSwingJInternalFrame mantenimientoeactivofijosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//mantenimientoeactivofijosBeanSwingJInternalFrame.jTtoolBarMantenimientoeActivoFijos.setBorder(borderResaltar);
		
		this.resaltarSeleccionarMantenimientoeActivoFijos= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarMantenimientoeActivoFijos() {
		return this.resaltarSeleccionarMantenimientoeActivoFijos;
	}
	
	public void setResaltarSeleccionarMantenimientoeActivoFijos(Border borderResaltarSeleccionarMantenimientoeActivoFijos) {
		this.resaltarSeleccionarMantenimientoeActivoFijos= borderResaltarSeleccionarMantenimientoeActivoFijos;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridMantenimientoeActivoFijos=null;
	public Boolean mostraridMantenimientoeActivoFijos=true;
	public Boolean activaridMantenimientoeActivoFijos=true;

	public Border resaltarid_empresaMantenimientoeActivoFijos=null;
	public Boolean mostrarid_empresaMantenimientoeActivoFijos=true;
	public Boolean activarid_empresaMantenimientoeActivoFijos=true;
	public Boolean cargarid_empresaMantenimientoeActivoFijos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaMantenimientoeActivoFijos=false;//ConEventDepend=true

	public Border resaltarnumero_documentoMantenimientoeActivoFijos=null;
	public Boolean mostrarnumero_documentoMantenimientoeActivoFijos=true;
	public Boolean activarnumero_documentoMantenimientoeActivoFijos=true;

	public Border resaltarcausaMantenimientoeActivoFijos=null;
	public Boolean mostrarcausaMantenimientoeActivoFijos=true;
	public Boolean activarcausaMantenimientoeActivoFijos=true;

	public Border resaltarreferenciaMantenimientoeActivoFijos=null;
	public Boolean mostrarreferenciaMantenimientoeActivoFijos=true;
	public Boolean activarreferenciaMantenimientoeActivoFijos=true;

	public Border resaltartallerMantenimientoeActivoFijos=null;
	public Boolean mostrartallerMantenimientoeActivoFijos=true;
	public Boolean activartallerMantenimientoeActivoFijos=true;

	public Border resaltarfecha_inicioMantenimientoeActivoFijos=null;
	public Boolean mostrarfecha_inicioMantenimientoeActivoFijos=true;
	public Boolean activarfecha_inicioMantenimientoeActivoFijos=true;

	public Border resaltarfecha_entregaMantenimientoeActivoFijos=null;
	public Boolean mostrarfecha_entregaMantenimientoeActivoFijos=true;
	public Boolean activarfecha_entregaMantenimientoeActivoFijos=true;

	public Border resaltarcostoMantenimientoeActivoFijos=null;
	public Boolean mostrarcostoMantenimientoeActivoFijos=true;
	public Boolean activarcostoMantenimientoeActivoFijos=true;

	public Border resaltarresponsableMantenimientoeActivoFijos=null;
	public Boolean mostrarresponsableMantenimientoeActivoFijos=true;
	public Boolean activarresponsableMantenimientoeActivoFijos=true;

	public Border resaltarobservacionMantenimientoeActivoFijos=null;
	public Boolean mostrarobservacionMantenimientoeActivoFijos=true;
	public Boolean activarobservacionMantenimientoeActivoFijos=true;

	public Border resaltartipo_movimientoMantenimientoeActivoFijos=null;
	public Boolean mostrartipo_movimientoMantenimientoeActivoFijos=true;
	public Boolean activartipo_movimientoMantenimientoeActivoFijos=true;

	public Border resaltarclaveMantenimientoeActivoFijos=null;
	public Boolean mostrarclaveMantenimientoeActivoFijos=true;
	public Boolean activarclaveMantenimientoeActivoFijos=true;

	public Border resaltarnombreMantenimientoeActivoFijos=null;
	public Boolean mostrarnombreMantenimientoeActivoFijos=true;
	public Boolean activarnombreMantenimientoeActivoFijos=true;

	public Border resaltarcodigo_detalle_grupoMantenimientoeActivoFijos=null;
	public Boolean mostrarcodigo_detalle_grupoMantenimientoeActivoFijos=true;
	public Boolean activarcodigo_detalle_grupoMantenimientoeActivoFijos=true;

	public Border resaltarnombre_detalle_grupoMantenimientoeActivoFijos=null;
	public Boolean mostrarnombre_detalle_grupoMantenimientoeActivoFijos=true;
	public Boolean activarnombre_detalle_grupoMantenimientoeActivoFijos=true;

	
	

	public Border setResaltaridMantenimientoeActivoFijos(ParametroGeneralUsuario parametroGeneralUsuario/*MantenimientoeActivoFijosBeanSwingJInternalFrame mantenimientoeactivofijosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//mantenimientoeactivofijosBeanSwingJInternalFrame.jTtoolBarMantenimientoeActivoFijos.setBorder(borderResaltar);
		
		this.resaltaridMantenimientoeActivoFijos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridMantenimientoeActivoFijos() {
		return this.resaltaridMantenimientoeActivoFijos;
	}

	public void setResaltaridMantenimientoeActivoFijos(Border borderResaltar) {
		this.resaltaridMantenimientoeActivoFijos= borderResaltar;
	}

	public Boolean getMostraridMantenimientoeActivoFijos() {
		return this.mostraridMantenimientoeActivoFijos;
	}

	public void setMostraridMantenimientoeActivoFijos(Boolean mostraridMantenimientoeActivoFijos) {
		this.mostraridMantenimientoeActivoFijos= mostraridMantenimientoeActivoFijos;
	}

	public Boolean getActivaridMantenimientoeActivoFijos() {
		return this.activaridMantenimientoeActivoFijos;
	}

	public void setActivaridMantenimientoeActivoFijos(Boolean activaridMantenimientoeActivoFijos) {
		this.activaridMantenimientoeActivoFijos= activaridMantenimientoeActivoFijos;
	}

	public Border setResaltarid_empresaMantenimientoeActivoFijos(ParametroGeneralUsuario parametroGeneralUsuario/*MantenimientoeActivoFijosBeanSwingJInternalFrame mantenimientoeactivofijosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//mantenimientoeactivofijosBeanSwingJInternalFrame.jTtoolBarMantenimientoeActivoFijos.setBorder(borderResaltar);
		
		this.resaltarid_empresaMantenimientoeActivoFijos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaMantenimientoeActivoFijos() {
		return this.resaltarid_empresaMantenimientoeActivoFijos;
	}

	public void setResaltarid_empresaMantenimientoeActivoFijos(Border borderResaltar) {
		this.resaltarid_empresaMantenimientoeActivoFijos= borderResaltar;
	}

	public Boolean getMostrarid_empresaMantenimientoeActivoFijos() {
		return this.mostrarid_empresaMantenimientoeActivoFijos;
	}

	public void setMostrarid_empresaMantenimientoeActivoFijos(Boolean mostrarid_empresaMantenimientoeActivoFijos) {
		this.mostrarid_empresaMantenimientoeActivoFijos= mostrarid_empresaMantenimientoeActivoFijos;
	}

	public Boolean getActivarid_empresaMantenimientoeActivoFijos() {
		return this.activarid_empresaMantenimientoeActivoFijos;
	}

	public void setActivarid_empresaMantenimientoeActivoFijos(Boolean activarid_empresaMantenimientoeActivoFijos) {
		this.activarid_empresaMantenimientoeActivoFijos= activarid_empresaMantenimientoeActivoFijos;
	}

	public Boolean getCargarid_empresaMantenimientoeActivoFijos() {
		return this.cargarid_empresaMantenimientoeActivoFijos;
	}

	public void setCargarid_empresaMantenimientoeActivoFijos(Boolean cargarid_empresaMantenimientoeActivoFijos) {
		this.cargarid_empresaMantenimientoeActivoFijos= cargarid_empresaMantenimientoeActivoFijos;
	}

	public Border setResaltarnumero_documentoMantenimientoeActivoFijos(ParametroGeneralUsuario parametroGeneralUsuario/*MantenimientoeActivoFijosBeanSwingJInternalFrame mantenimientoeactivofijosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//mantenimientoeactivofijosBeanSwingJInternalFrame.jTtoolBarMantenimientoeActivoFijos.setBorder(borderResaltar);
		
		this.resaltarnumero_documentoMantenimientoeActivoFijos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_documentoMantenimientoeActivoFijos() {
		return this.resaltarnumero_documentoMantenimientoeActivoFijos;
	}

	public void setResaltarnumero_documentoMantenimientoeActivoFijos(Border borderResaltar) {
		this.resaltarnumero_documentoMantenimientoeActivoFijos= borderResaltar;
	}

	public Boolean getMostrarnumero_documentoMantenimientoeActivoFijos() {
		return this.mostrarnumero_documentoMantenimientoeActivoFijos;
	}

	public void setMostrarnumero_documentoMantenimientoeActivoFijos(Boolean mostrarnumero_documentoMantenimientoeActivoFijos) {
		this.mostrarnumero_documentoMantenimientoeActivoFijos= mostrarnumero_documentoMantenimientoeActivoFijos;
	}

	public Boolean getActivarnumero_documentoMantenimientoeActivoFijos() {
		return this.activarnumero_documentoMantenimientoeActivoFijos;
	}

	public void setActivarnumero_documentoMantenimientoeActivoFijos(Boolean activarnumero_documentoMantenimientoeActivoFijos) {
		this.activarnumero_documentoMantenimientoeActivoFijos= activarnumero_documentoMantenimientoeActivoFijos;
	}

	public Border setResaltarcausaMantenimientoeActivoFijos(ParametroGeneralUsuario parametroGeneralUsuario/*MantenimientoeActivoFijosBeanSwingJInternalFrame mantenimientoeactivofijosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//mantenimientoeactivofijosBeanSwingJInternalFrame.jTtoolBarMantenimientoeActivoFijos.setBorder(borderResaltar);
		
		this.resaltarcausaMantenimientoeActivoFijos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcausaMantenimientoeActivoFijos() {
		return this.resaltarcausaMantenimientoeActivoFijos;
	}

	public void setResaltarcausaMantenimientoeActivoFijos(Border borderResaltar) {
		this.resaltarcausaMantenimientoeActivoFijos= borderResaltar;
	}

	public Boolean getMostrarcausaMantenimientoeActivoFijos() {
		return this.mostrarcausaMantenimientoeActivoFijos;
	}

	public void setMostrarcausaMantenimientoeActivoFijos(Boolean mostrarcausaMantenimientoeActivoFijos) {
		this.mostrarcausaMantenimientoeActivoFijos= mostrarcausaMantenimientoeActivoFijos;
	}

	public Boolean getActivarcausaMantenimientoeActivoFijos() {
		return this.activarcausaMantenimientoeActivoFijos;
	}

	public void setActivarcausaMantenimientoeActivoFijos(Boolean activarcausaMantenimientoeActivoFijos) {
		this.activarcausaMantenimientoeActivoFijos= activarcausaMantenimientoeActivoFijos;
	}

	public Border setResaltarreferenciaMantenimientoeActivoFijos(ParametroGeneralUsuario parametroGeneralUsuario/*MantenimientoeActivoFijosBeanSwingJInternalFrame mantenimientoeactivofijosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//mantenimientoeactivofijosBeanSwingJInternalFrame.jTtoolBarMantenimientoeActivoFijos.setBorder(borderResaltar);
		
		this.resaltarreferenciaMantenimientoeActivoFijos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarreferenciaMantenimientoeActivoFijos() {
		return this.resaltarreferenciaMantenimientoeActivoFijos;
	}

	public void setResaltarreferenciaMantenimientoeActivoFijos(Border borderResaltar) {
		this.resaltarreferenciaMantenimientoeActivoFijos= borderResaltar;
	}

	public Boolean getMostrarreferenciaMantenimientoeActivoFijos() {
		return this.mostrarreferenciaMantenimientoeActivoFijos;
	}

	public void setMostrarreferenciaMantenimientoeActivoFijos(Boolean mostrarreferenciaMantenimientoeActivoFijos) {
		this.mostrarreferenciaMantenimientoeActivoFijos= mostrarreferenciaMantenimientoeActivoFijos;
	}

	public Boolean getActivarreferenciaMantenimientoeActivoFijos() {
		return this.activarreferenciaMantenimientoeActivoFijos;
	}

	public void setActivarreferenciaMantenimientoeActivoFijos(Boolean activarreferenciaMantenimientoeActivoFijos) {
		this.activarreferenciaMantenimientoeActivoFijos= activarreferenciaMantenimientoeActivoFijos;
	}

	public Border setResaltartallerMantenimientoeActivoFijos(ParametroGeneralUsuario parametroGeneralUsuario/*MantenimientoeActivoFijosBeanSwingJInternalFrame mantenimientoeactivofijosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//mantenimientoeactivofijosBeanSwingJInternalFrame.jTtoolBarMantenimientoeActivoFijos.setBorder(borderResaltar);
		
		this.resaltartallerMantenimientoeActivoFijos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartallerMantenimientoeActivoFijos() {
		return this.resaltartallerMantenimientoeActivoFijos;
	}

	public void setResaltartallerMantenimientoeActivoFijos(Border borderResaltar) {
		this.resaltartallerMantenimientoeActivoFijos= borderResaltar;
	}

	public Boolean getMostrartallerMantenimientoeActivoFijos() {
		return this.mostrartallerMantenimientoeActivoFijos;
	}

	public void setMostrartallerMantenimientoeActivoFijos(Boolean mostrartallerMantenimientoeActivoFijos) {
		this.mostrartallerMantenimientoeActivoFijos= mostrartallerMantenimientoeActivoFijos;
	}

	public Boolean getActivartallerMantenimientoeActivoFijos() {
		return this.activartallerMantenimientoeActivoFijos;
	}

	public void setActivartallerMantenimientoeActivoFijos(Boolean activartallerMantenimientoeActivoFijos) {
		this.activartallerMantenimientoeActivoFijos= activartallerMantenimientoeActivoFijos;
	}

	public Border setResaltarfecha_inicioMantenimientoeActivoFijos(ParametroGeneralUsuario parametroGeneralUsuario/*MantenimientoeActivoFijosBeanSwingJInternalFrame mantenimientoeactivofijosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//mantenimientoeactivofijosBeanSwingJInternalFrame.jTtoolBarMantenimientoeActivoFijos.setBorder(borderResaltar);
		
		this.resaltarfecha_inicioMantenimientoeActivoFijos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_inicioMantenimientoeActivoFijos() {
		return this.resaltarfecha_inicioMantenimientoeActivoFijos;
	}

	public void setResaltarfecha_inicioMantenimientoeActivoFijos(Border borderResaltar) {
		this.resaltarfecha_inicioMantenimientoeActivoFijos= borderResaltar;
	}

	public Boolean getMostrarfecha_inicioMantenimientoeActivoFijos() {
		return this.mostrarfecha_inicioMantenimientoeActivoFijos;
	}

	public void setMostrarfecha_inicioMantenimientoeActivoFijos(Boolean mostrarfecha_inicioMantenimientoeActivoFijos) {
		this.mostrarfecha_inicioMantenimientoeActivoFijos= mostrarfecha_inicioMantenimientoeActivoFijos;
	}

	public Boolean getActivarfecha_inicioMantenimientoeActivoFijos() {
		return this.activarfecha_inicioMantenimientoeActivoFijos;
	}

	public void setActivarfecha_inicioMantenimientoeActivoFijos(Boolean activarfecha_inicioMantenimientoeActivoFijos) {
		this.activarfecha_inicioMantenimientoeActivoFijos= activarfecha_inicioMantenimientoeActivoFijos;
	}

	public Border setResaltarfecha_entregaMantenimientoeActivoFijos(ParametroGeneralUsuario parametroGeneralUsuario/*MantenimientoeActivoFijosBeanSwingJInternalFrame mantenimientoeactivofijosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//mantenimientoeactivofijosBeanSwingJInternalFrame.jTtoolBarMantenimientoeActivoFijos.setBorder(borderResaltar);
		
		this.resaltarfecha_entregaMantenimientoeActivoFijos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_entregaMantenimientoeActivoFijos() {
		return this.resaltarfecha_entregaMantenimientoeActivoFijos;
	}

	public void setResaltarfecha_entregaMantenimientoeActivoFijos(Border borderResaltar) {
		this.resaltarfecha_entregaMantenimientoeActivoFijos= borderResaltar;
	}

	public Boolean getMostrarfecha_entregaMantenimientoeActivoFijos() {
		return this.mostrarfecha_entregaMantenimientoeActivoFijos;
	}

	public void setMostrarfecha_entregaMantenimientoeActivoFijos(Boolean mostrarfecha_entregaMantenimientoeActivoFijos) {
		this.mostrarfecha_entregaMantenimientoeActivoFijos= mostrarfecha_entregaMantenimientoeActivoFijos;
	}

	public Boolean getActivarfecha_entregaMantenimientoeActivoFijos() {
		return this.activarfecha_entregaMantenimientoeActivoFijos;
	}

	public void setActivarfecha_entregaMantenimientoeActivoFijos(Boolean activarfecha_entregaMantenimientoeActivoFijos) {
		this.activarfecha_entregaMantenimientoeActivoFijos= activarfecha_entregaMantenimientoeActivoFijos;
	}

	public Border setResaltarcostoMantenimientoeActivoFijos(ParametroGeneralUsuario parametroGeneralUsuario/*MantenimientoeActivoFijosBeanSwingJInternalFrame mantenimientoeactivofijosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//mantenimientoeactivofijosBeanSwingJInternalFrame.jTtoolBarMantenimientoeActivoFijos.setBorder(borderResaltar);
		
		this.resaltarcostoMantenimientoeActivoFijos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcostoMantenimientoeActivoFijos() {
		return this.resaltarcostoMantenimientoeActivoFijos;
	}

	public void setResaltarcostoMantenimientoeActivoFijos(Border borderResaltar) {
		this.resaltarcostoMantenimientoeActivoFijos= borderResaltar;
	}

	public Boolean getMostrarcostoMantenimientoeActivoFijos() {
		return this.mostrarcostoMantenimientoeActivoFijos;
	}

	public void setMostrarcostoMantenimientoeActivoFijos(Boolean mostrarcostoMantenimientoeActivoFijos) {
		this.mostrarcostoMantenimientoeActivoFijos= mostrarcostoMantenimientoeActivoFijos;
	}

	public Boolean getActivarcostoMantenimientoeActivoFijos() {
		return this.activarcostoMantenimientoeActivoFijos;
	}

	public void setActivarcostoMantenimientoeActivoFijos(Boolean activarcostoMantenimientoeActivoFijos) {
		this.activarcostoMantenimientoeActivoFijos= activarcostoMantenimientoeActivoFijos;
	}

	public Border setResaltarresponsableMantenimientoeActivoFijos(ParametroGeneralUsuario parametroGeneralUsuario/*MantenimientoeActivoFijosBeanSwingJInternalFrame mantenimientoeactivofijosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//mantenimientoeactivofijosBeanSwingJInternalFrame.jTtoolBarMantenimientoeActivoFijos.setBorder(borderResaltar);
		
		this.resaltarresponsableMantenimientoeActivoFijos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarresponsableMantenimientoeActivoFijos() {
		return this.resaltarresponsableMantenimientoeActivoFijos;
	}

	public void setResaltarresponsableMantenimientoeActivoFijos(Border borderResaltar) {
		this.resaltarresponsableMantenimientoeActivoFijos= borderResaltar;
	}

	public Boolean getMostrarresponsableMantenimientoeActivoFijos() {
		return this.mostrarresponsableMantenimientoeActivoFijos;
	}

	public void setMostrarresponsableMantenimientoeActivoFijos(Boolean mostrarresponsableMantenimientoeActivoFijos) {
		this.mostrarresponsableMantenimientoeActivoFijos= mostrarresponsableMantenimientoeActivoFijos;
	}

	public Boolean getActivarresponsableMantenimientoeActivoFijos() {
		return this.activarresponsableMantenimientoeActivoFijos;
	}

	public void setActivarresponsableMantenimientoeActivoFijos(Boolean activarresponsableMantenimientoeActivoFijos) {
		this.activarresponsableMantenimientoeActivoFijos= activarresponsableMantenimientoeActivoFijos;
	}

	public Border setResaltarobservacionMantenimientoeActivoFijos(ParametroGeneralUsuario parametroGeneralUsuario/*MantenimientoeActivoFijosBeanSwingJInternalFrame mantenimientoeactivofijosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//mantenimientoeactivofijosBeanSwingJInternalFrame.jTtoolBarMantenimientoeActivoFijos.setBorder(borderResaltar);
		
		this.resaltarobservacionMantenimientoeActivoFijos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarobservacionMantenimientoeActivoFijos() {
		return this.resaltarobservacionMantenimientoeActivoFijos;
	}

	public void setResaltarobservacionMantenimientoeActivoFijos(Border borderResaltar) {
		this.resaltarobservacionMantenimientoeActivoFijos= borderResaltar;
	}

	public Boolean getMostrarobservacionMantenimientoeActivoFijos() {
		return this.mostrarobservacionMantenimientoeActivoFijos;
	}

	public void setMostrarobservacionMantenimientoeActivoFijos(Boolean mostrarobservacionMantenimientoeActivoFijos) {
		this.mostrarobservacionMantenimientoeActivoFijos= mostrarobservacionMantenimientoeActivoFijos;
	}

	public Boolean getActivarobservacionMantenimientoeActivoFijos() {
		return this.activarobservacionMantenimientoeActivoFijos;
	}

	public void setActivarobservacionMantenimientoeActivoFijos(Boolean activarobservacionMantenimientoeActivoFijos) {
		this.activarobservacionMantenimientoeActivoFijos= activarobservacionMantenimientoeActivoFijos;
	}

	public Border setResaltartipo_movimientoMantenimientoeActivoFijos(ParametroGeneralUsuario parametroGeneralUsuario/*MantenimientoeActivoFijosBeanSwingJInternalFrame mantenimientoeactivofijosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//mantenimientoeactivofijosBeanSwingJInternalFrame.jTtoolBarMantenimientoeActivoFijos.setBorder(borderResaltar);
		
		this.resaltartipo_movimientoMantenimientoeActivoFijos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartipo_movimientoMantenimientoeActivoFijos() {
		return this.resaltartipo_movimientoMantenimientoeActivoFijos;
	}

	public void setResaltartipo_movimientoMantenimientoeActivoFijos(Border borderResaltar) {
		this.resaltartipo_movimientoMantenimientoeActivoFijos= borderResaltar;
	}

	public Boolean getMostrartipo_movimientoMantenimientoeActivoFijos() {
		return this.mostrartipo_movimientoMantenimientoeActivoFijos;
	}

	public void setMostrartipo_movimientoMantenimientoeActivoFijos(Boolean mostrartipo_movimientoMantenimientoeActivoFijos) {
		this.mostrartipo_movimientoMantenimientoeActivoFijos= mostrartipo_movimientoMantenimientoeActivoFijos;
	}

	public Boolean getActivartipo_movimientoMantenimientoeActivoFijos() {
		return this.activartipo_movimientoMantenimientoeActivoFijos;
	}

	public void setActivartipo_movimientoMantenimientoeActivoFijos(Boolean activartipo_movimientoMantenimientoeActivoFijos) {
		this.activartipo_movimientoMantenimientoeActivoFijos= activartipo_movimientoMantenimientoeActivoFijos;
	}

	public Border setResaltarclaveMantenimientoeActivoFijos(ParametroGeneralUsuario parametroGeneralUsuario/*MantenimientoeActivoFijosBeanSwingJInternalFrame mantenimientoeactivofijosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//mantenimientoeactivofijosBeanSwingJInternalFrame.jTtoolBarMantenimientoeActivoFijos.setBorder(borderResaltar);
		
		this.resaltarclaveMantenimientoeActivoFijos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarclaveMantenimientoeActivoFijos() {
		return this.resaltarclaveMantenimientoeActivoFijos;
	}

	public void setResaltarclaveMantenimientoeActivoFijos(Border borderResaltar) {
		this.resaltarclaveMantenimientoeActivoFijos= borderResaltar;
	}

	public Boolean getMostrarclaveMantenimientoeActivoFijos() {
		return this.mostrarclaveMantenimientoeActivoFijos;
	}

	public void setMostrarclaveMantenimientoeActivoFijos(Boolean mostrarclaveMantenimientoeActivoFijos) {
		this.mostrarclaveMantenimientoeActivoFijos= mostrarclaveMantenimientoeActivoFijos;
	}

	public Boolean getActivarclaveMantenimientoeActivoFijos() {
		return this.activarclaveMantenimientoeActivoFijos;
	}

	public void setActivarclaveMantenimientoeActivoFijos(Boolean activarclaveMantenimientoeActivoFijos) {
		this.activarclaveMantenimientoeActivoFijos= activarclaveMantenimientoeActivoFijos;
	}

	public Border setResaltarnombreMantenimientoeActivoFijos(ParametroGeneralUsuario parametroGeneralUsuario/*MantenimientoeActivoFijosBeanSwingJInternalFrame mantenimientoeactivofijosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//mantenimientoeactivofijosBeanSwingJInternalFrame.jTtoolBarMantenimientoeActivoFijos.setBorder(borderResaltar);
		
		this.resaltarnombreMantenimientoeActivoFijos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreMantenimientoeActivoFijos() {
		return this.resaltarnombreMantenimientoeActivoFijos;
	}

	public void setResaltarnombreMantenimientoeActivoFijos(Border borderResaltar) {
		this.resaltarnombreMantenimientoeActivoFijos= borderResaltar;
	}

	public Boolean getMostrarnombreMantenimientoeActivoFijos() {
		return this.mostrarnombreMantenimientoeActivoFijos;
	}

	public void setMostrarnombreMantenimientoeActivoFijos(Boolean mostrarnombreMantenimientoeActivoFijos) {
		this.mostrarnombreMantenimientoeActivoFijos= mostrarnombreMantenimientoeActivoFijos;
	}

	public Boolean getActivarnombreMantenimientoeActivoFijos() {
		return this.activarnombreMantenimientoeActivoFijos;
	}

	public void setActivarnombreMantenimientoeActivoFijos(Boolean activarnombreMantenimientoeActivoFijos) {
		this.activarnombreMantenimientoeActivoFijos= activarnombreMantenimientoeActivoFijos;
	}

	public Border setResaltarcodigo_detalle_grupoMantenimientoeActivoFijos(ParametroGeneralUsuario parametroGeneralUsuario/*MantenimientoeActivoFijosBeanSwingJInternalFrame mantenimientoeactivofijosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//mantenimientoeactivofijosBeanSwingJInternalFrame.jTtoolBarMantenimientoeActivoFijos.setBorder(borderResaltar);
		
		this.resaltarcodigo_detalle_grupoMantenimientoeActivoFijos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_detalle_grupoMantenimientoeActivoFijos() {
		return this.resaltarcodigo_detalle_grupoMantenimientoeActivoFijos;
	}

	public void setResaltarcodigo_detalle_grupoMantenimientoeActivoFijos(Border borderResaltar) {
		this.resaltarcodigo_detalle_grupoMantenimientoeActivoFijos= borderResaltar;
	}

	public Boolean getMostrarcodigo_detalle_grupoMantenimientoeActivoFijos() {
		return this.mostrarcodigo_detalle_grupoMantenimientoeActivoFijos;
	}

	public void setMostrarcodigo_detalle_grupoMantenimientoeActivoFijos(Boolean mostrarcodigo_detalle_grupoMantenimientoeActivoFijos) {
		this.mostrarcodigo_detalle_grupoMantenimientoeActivoFijos= mostrarcodigo_detalle_grupoMantenimientoeActivoFijos;
	}

	public Boolean getActivarcodigo_detalle_grupoMantenimientoeActivoFijos() {
		return this.activarcodigo_detalle_grupoMantenimientoeActivoFijos;
	}

	public void setActivarcodigo_detalle_grupoMantenimientoeActivoFijos(Boolean activarcodigo_detalle_grupoMantenimientoeActivoFijos) {
		this.activarcodigo_detalle_grupoMantenimientoeActivoFijos= activarcodigo_detalle_grupoMantenimientoeActivoFijos;
	}

	public Border setResaltarnombre_detalle_grupoMantenimientoeActivoFijos(ParametroGeneralUsuario parametroGeneralUsuario/*MantenimientoeActivoFijosBeanSwingJInternalFrame mantenimientoeactivofijosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//mantenimientoeactivofijosBeanSwingJInternalFrame.jTtoolBarMantenimientoeActivoFijos.setBorder(borderResaltar);
		
		this.resaltarnombre_detalle_grupoMantenimientoeActivoFijos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_detalle_grupoMantenimientoeActivoFijos() {
		return this.resaltarnombre_detalle_grupoMantenimientoeActivoFijos;
	}

	public void setResaltarnombre_detalle_grupoMantenimientoeActivoFijos(Border borderResaltar) {
		this.resaltarnombre_detalle_grupoMantenimientoeActivoFijos= borderResaltar;
	}

	public Boolean getMostrarnombre_detalle_grupoMantenimientoeActivoFijos() {
		return this.mostrarnombre_detalle_grupoMantenimientoeActivoFijos;
	}

	public void setMostrarnombre_detalle_grupoMantenimientoeActivoFijos(Boolean mostrarnombre_detalle_grupoMantenimientoeActivoFijos) {
		this.mostrarnombre_detalle_grupoMantenimientoeActivoFijos= mostrarnombre_detalle_grupoMantenimientoeActivoFijos;
	}

	public Boolean getActivarnombre_detalle_grupoMantenimientoeActivoFijos() {
		return this.activarnombre_detalle_grupoMantenimientoeActivoFijos;
	}

	public void setActivarnombre_detalle_grupoMantenimientoeActivoFijos(Boolean activarnombre_detalle_grupoMantenimientoeActivoFijos) {
		this.activarnombre_detalle_grupoMantenimientoeActivoFijos= activarnombre_detalle_grupoMantenimientoeActivoFijos;
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
		
		
		this.setMostraridMantenimientoeActivoFijos(esInicial);
		this.setMostrarid_empresaMantenimientoeActivoFijos(esInicial);
		this.setMostrarnumero_documentoMantenimientoeActivoFijos(esInicial);
		this.setMostrarcausaMantenimientoeActivoFijos(esInicial);
		this.setMostrarreferenciaMantenimientoeActivoFijos(esInicial);
		this.setMostrartallerMantenimientoeActivoFijos(esInicial);
		this.setMostrarfecha_inicioMantenimientoeActivoFijos(esInicial);
		this.setMostrarfecha_entregaMantenimientoeActivoFijos(esInicial);
		this.setMostrarcostoMantenimientoeActivoFijos(esInicial);
		this.setMostrarresponsableMantenimientoeActivoFijos(esInicial);
		this.setMostrarobservacionMantenimientoeActivoFijos(esInicial);
		this.setMostrartipo_movimientoMantenimientoeActivoFijos(esInicial);
		this.setMostrarclaveMantenimientoeActivoFijos(esInicial);
		this.setMostrarnombreMantenimientoeActivoFijos(esInicial);
		this.setMostrarcodigo_detalle_grupoMantenimientoeActivoFijos(esInicial);
		this.setMostrarnombre_detalle_grupoMantenimientoeActivoFijos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(MantenimientoeActivoFijosConstantesFunciones.ID)) {
				this.setMostraridMantenimientoeActivoFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoeActivoFijosConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaMantenimientoeActivoFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoeActivoFijosConstantesFunciones.NUMERODOCUMENTO)) {
				this.setMostrarnumero_documentoMantenimientoeActivoFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoeActivoFijosConstantesFunciones.CAUSA)) {
				this.setMostrarcausaMantenimientoeActivoFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoeActivoFijosConstantesFunciones.REFERENCIA)) {
				this.setMostrarreferenciaMantenimientoeActivoFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoeActivoFijosConstantesFunciones.TALLER)) {
				this.setMostrartallerMantenimientoeActivoFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoeActivoFijosConstantesFunciones.FECHAINICIO)) {
				this.setMostrarfecha_inicioMantenimientoeActivoFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoeActivoFijosConstantesFunciones.FECHAENTREGA)) {
				this.setMostrarfecha_entregaMantenimientoeActivoFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoeActivoFijosConstantesFunciones.COSTO)) {
				this.setMostrarcostoMantenimientoeActivoFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoeActivoFijosConstantesFunciones.RESPONSABLE)) {
				this.setMostrarresponsableMantenimientoeActivoFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoeActivoFijosConstantesFunciones.OBSERVACION)) {
				this.setMostrarobservacionMantenimientoeActivoFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoeActivoFijosConstantesFunciones.TIPOMOVIMIENTO)) {
				this.setMostrartipo_movimientoMantenimientoeActivoFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoeActivoFijosConstantesFunciones.CLAVE)) {
				this.setMostrarclaveMantenimientoeActivoFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoeActivoFijosConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreMantenimientoeActivoFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoeActivoFijosConstantesFunciones.CODIGODETALLEGRUPO)) {
				this.setMostrarcodigo_detalle_grupoMantenimientoeActivoFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoeActivoFijosConstantesFunciones.NOMBREDETALLEGRUPO)) {
				this.setMostrarnombre_detalle_grupoMantenimientoeActivoFijos(esAsigna);
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
		
		
		this.setActivaridMantenimientoeActivoFijos(esInicial);
		this.setActivarid_empresaMantenimientoeActivoFijos(esInicial);
		this.setActivarnumero_documentoMantenimientoeActivoFijos(esInicial);
		this.setActivarcausaMantenimientoeActivoFijos(esInicial);
		this.setActivarreferenciaMantenimientoeActivoFijos(esInicial);
		this.setActivartallerMantenimientoeActivoFijos(esInicial);
		this.setActivarfecha_inicioMantenimientoeActivoFijos(esInicial);
		this.setActivarfecha_entregaMantenimientoeActivoFijos(esInicial);
		this.setActivarcostoMantenimientoeActivoFijos(esInicial);
		this.setActivarresponsableMantenimientoeActivoFijos(esInicial);
		this.setActivarobservacionMantenimientoeActivoFijos(esInicial);
		this.setActivartipo_movimientoMantenimientoeActivoFijos(esInicial);
		this.setActivarclaveMantenimientoeActivoFijos(esInicial);
		this.setActivarnombreMantenimientoeActivoFijos(esInicial);
		this.setActivarcodigo_detalle_grupoMantenimientoeActivoFijos(esInicial);
		this.setActivarnombre_detalle_grupoMantenimientoeActivoFijos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(MantenimientoeActivoFijosConstantesFunciones.ID)) {
				this.setActivaridMantenimientoeActivoFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoeActivoFijosConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaMantenimientoeActivoFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoeActivoFijosConstantesFunciones.NUMERODOCUMENTO)) {
				this.setActivarnumero_documentoMantenimientoeActivoFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoeActivoFijosConstantesFunciones.CAUSA)) {
				this.setActivarcausaMantenimientoeActivoFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoeActivoFijosConstantesFunciones.REFERENCIA)) {
				this.setActivarreferenciaMantenimientoeActivoFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoeActivoFijosConstantesFunciones.TALLER)) {
				this.setActivartallerMantenimientoeActivoFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoeActivoFijosConstantesFunciones.FECHAINICIO)) {
				this.setActivarfecha_inicioMantenimientoeActivoFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoeActivoFijosConstantesFunciones.FECHAENTREGA)) {
				this.setActivarfecha_entregaMantenimientoeActivoFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoeActivoFijosConstantesFunciones.COSTO)) {
				this.setActivarcostoMantenimientoeActivoFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoeActivoFijosConstantesFunciones.RESPONSABLE)) {
				this.setActivarresponsableMantenimientoeActivoFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoeActivoFijosConstantesFunciones.OBSERVACION)) {
				this.setActivarobservacionMantenimientoeActivoFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoeActivoFijosConstantesFunciones.TIPOMOVIMIENTO)) {
				this.setActivartipo_movimientoMantenimientoeActivoFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoeActivoFijosConstantesFunciones.CLAVE)) {
				this.setActivarclaveMantenimientoeActivoFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoeActivoFijosConstantesFunciones.NOMBRE)) {
				this.setActivarnombreMantenimientoeActivoFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoeActivoFijosConstantesFunciones.CODIGODETALLEGRUPO)) {
				this.setActivarcodigo_detalle_grupoMantenimientoeActivoFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoeActivoFijosConstantesFunciones.NOMBREDETALLEGRUPO)) {
				this.setActivarnombre_detalle_grupoMantenimientoeActivoFijos(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,MantenimientoeActivoFijosBeanSwingJInternalFrame mantenimientoeactivofijosBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridMantenimientoeActivoFijos(esInicial);
		this.setResaltarid_empresaMantenimientoeActivoFijos(esInicial);
		this.setResaltarnumero_documentoMantenimientoeActivoFijos(esInicial);
		this.setResaltarcausaMantenimientoeActivoFijos(esInicial);
		this.setResaltarreferenciaMantenimientoeActivoFijos(esInicial);
		this.setResaltartallerMantenimientoeActivoFijos(esInicial);
		this.setResaltarfecha_inicioMantenimientoeActivoFijos(esInicial);
		this.setResaltarfecha_entregaMantenimientoeActivoFijos(esInicial);
		this.setResaltarcostoMantenimientoeActivoFijos(esInicial);
		this.setResaltarresponsableMantenimientoeActivoFijos(esInicial);
		this.setResaltarobservacionMantenimientoeActivoFijos(esInicial);
		this.setResaltartipo_movimientoMantenimientoeActivoFijos(esInicial);
		this.setResaltarclaveMantenimientoeActivoFijos(esInicial);
		this.setResaltarnombreMantenimientoeActivoFijos(esInicial);
		this.setResaltarcodigo_detalle_grupoMantenimientoeActivoFijos(esInicial);
		this.setResaltarnombre_detalle_grupoMantenimientoeActivoFijos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(MantenimientoeActivoFijosConstantesFunciones.ID)) {
				this.setResaltaridMantenimientoeActivoFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoeActivoFijosConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaMantenimientoeActivoFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoeActivoFijosConstantesFunciones.NUMERODOCUMENTO)) {
				this.setResaltarnumero_documentoMantenimientoeActivoFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoeActivoFijosConstantesFunciones.CAUSA)) {
				this.setResaltarcausaMantenimientoeActivoFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoeActivoFijosConstantesFunciones.REFERENCIA)) {
				this.setResaltarreferenciaMantenimientoeActivoFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoeActivoFijosConstantesFunciones.TALLER)) {
				this.setResaltartallerMantenimientoeActivoFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoeActivoFijosConstantesFunciones.FECHAINICIO)) {
				this.setResaltarfecha_inicioMantenimientoeActivoFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoeActivoFijosConstantesFunciones.FECHAENTREGA)) {
				this.setResaltarfecha_entregaMantenimientoeActivoFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoeActivoFijosConstantesFunciones.COSTO)) {
				this.setResaltarcostoMantenimientoeActivoFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoeActivoFijosConstantesFunciones.RESPONSABLE)) {
				this.setResaltarresponsableMantenimientoeActivoFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoeActivoFijosConstantesFunciones.OBSERVACION)) {
				this.setResaltarobservacionMantenimientoeActivoFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoeActivoFijosConstantesFunciones.TIPOMOVIMIENTO)) {
				this.setResaltartipo_movimientoMantenimientoeActivoFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoeActivoFijosConstantesFunciones.CLAVE)) {
				this.setResaltarclaveMantenimientoeActivoFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoeActivoFijosConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreMantenimientoeActivoFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoeActivoFijosConstantesFunciones.CODIGODETALLEGRUPO)) {
				this.setResaltarcodigo_detalle_grupoMantenimientoeActivoFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoeActivoFijosConstantesFunciones.NOMBREDETALLEGRUPO)) {
				this.setResaltarnombre_detalle_grupoMantenimientoeActivoFijos(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,MantenimientoeActivoFijosBeanSwingJInternalFrame mantenimientoeactivofijosBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaMantenimientoeActivoFijosMantenimientoeActivoFijos=true;

	public Boolean getMostrarBusquedaMantenimientoeActivoFijosMantenimientoeActivoFijos() {
		return this.mostrarBusquedaMantenimientoeActivoFijosMantenimientoeActivoFijos;
	}

	public void setMostrarBusquedaMantenimientoeActivoFijosMantenimientoeActivoFijos(Boolean visibilidadResaltar) {
		this.mostrarBusquedaMantenimientoeActivoFijosMantenimientoeActivoFijos= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaMantenimientoeActivoFijosMantenimientoeActivoFijos=true;

	public Boolean getActivarBusquedaMantenimientoeActivoFijosMantenimientoeActivoFijos() {
		return this.activarBusquedaMantenimientoeActivoFijosMantenimientoeActivoFijos;
	}

	public void setActivarBusquedaMantenimientoeActivoFijosMantenimientoeActivoFijos(Boolean habilitarResaltar) {
		this.activarBusquedaMantenimientoeActivoFijosMantenimientoeActivoFijos= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaMantenimientoeActivoFijosMantenimientoeActivoFijos=null;

	public Border getResaltarBusquedaMantenimientoeActivoFijosMantenimientoeActivoFijos() {
		return this.resaltarBusquedaMantenimientoeActivoFijosMantenimientoeActivoFijos;
	}

	public void setResaltarBusquedaMantenimientoeActivoFijosMantenimientoeActivoFijos(Border borderResaltar) {
		this.resaltarBusquedaMantenimientoeActivoFijosMantenimientoeActivoFijos= borderResaltar;
	}

	public void setResaltarBusquedaMantenimientoeActivoFijosMantenimientoeActivoFijos(ParametroGeneralUsuario parametroGeneralUsuario/*MantenimientoeActivoFijosBeanSwingJInternalFrame mantenimientoeactivofijosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaMantenimientoeActivoFijosMantenimientoeActivoFijos= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}