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
package com.bydan.erp.activosfijos.util;

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


import com.bydan.erp.activosfijos.util.MantenimientoActivoFijoConstantesFunciones;
import com.bydan.erp.activosfijos.util.MantenimientoActivoFijoParameterReturnGeneral;
//import com.bydan.erp.activosfijos.util.MantenimientoActivoFijoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.activosfijos.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.activosfijos.business.dataaccess.*;
//import com.bydan.erp.activosfijos.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class MantenimientoActivoFijoConstantesFunciones extends MantenimientoActivoFijoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="MantenimientoActivoFijo";
	public static final String SPATHOPCION="ActivosFijos";	
	public static final String SPATHMODULO="activosfijos/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="MantenimientoActivoFijo"+MantenimientoActivoFijoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="MantenimientoActivoFijoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="MantenimientoActivoFijoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=MantenimientoActivoFijoConstantesFunciones.SCHEMA+"_"+MantenimientoActivoFijoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/MantenimientoActivoFijoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=MantenimientoActivoFijoConstantesFunciones.SCHEMA+"_"+MantenimientoActivoFijoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=MantenimientoActivoFijoConstantesFunciones.SCHEMA+"_"+MantenimientoActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/MantenimientoActivoFijoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=MantenimientoActivoFijoConstantesFunciones.SCHEMA+"_"+MantenimientoActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+MantenimientoActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/MantenimientoActivoFijoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+MantenimientoActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+MantenimientoActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/MantenimientoActivoFijoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+MantenimientoActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=MantenimientoActivoFijoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+MantenimientoActivoFijoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=MantenimientoActivoFijoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+MantenimientoActivoFijoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Mantenimiento Activo Fijos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Mantenimiento Activo Fijo";
	public static final String SCLASSWEBTITULO_LOWER="Mantenimiento Activo Fijo";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="MantenimientoActivoFijo";
	public static final String OBJECTNAME="mantenimientoactivofijo";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_ACTIVOSFIJOS;	
	public static final String TABLENAME="mantenimiento_activo_fijo";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select mantenimientoactivofijo from "+MantenimientoActivoFijoConstantesFunciones.SPERSISTENCENAME+" mantenimientoactivofijo";
	public static String QUERYSELECTNATIVE="select "+MantenimientoActivoFijoConstantesFunciones.SCHEMA+"."+MantenimientoActivoFijoConstantesFunciones.TABLENAME+".id,"+MantenimientoActivoFijoConstantesFunciones.SCHEMA+"."+MantenimientoActivoFijoConstantesFunciones.TABLENAME+".version_row,"+MantenimientoActivoFijoConstantesFunciones.SCHEMA+"."+MantenimientoActivoFijoConstantesFunciones.TABLENAME+".id_empresa,"+MantenimientoActivoFijoConstantesFunciones.SCHEMA+"."+MantenimientoActivoFijoConstantesFunciones.TABLENAME+".id_sucursal,"+MantenimientoActivoFijoConstantesFunciones.SCHEMA+"."+MantenimientoActivoFijoConstantesFunciones.TABLENAME+".id_detalle_activo_fijo,"+MantenimientoActivoFijoConstantesFunciones.SCHEMA+"."+MantenimientoActivoFijoConstantesFunciones.TABLENAME+".id_tipo_movimiento,"+MantenimientoActivoFijoConstantesFunciones.SCHEMA+"."+MantenimientoActivoFijoConstantesFunciones.TABLENAME+".numero_documento,"+MantenimientoActivoFijoConstantesFunciones.SCHEMA+"."+MantenimientoActivoFijoConstantesFunciones.TABLENAME+".causa,"+MantenimientoActivoFijoConstantesFunciones.SCHEMA+"."+MantenimientoActivoFijoConstantesFunciones.TABLENAME+".referencia,"+MantenimientoActivoFijoConstantesFunciones.SCHEMA+"."+MantenimientoActivoFijoConstantesFunciones.TABLENAME+".taller,"+MantenimientoActivoFijoConstantesFunciones.SCHEMA+"."+MantenimientoActivoFijoConstantesFunciones.TABLENAME+".telefono,"+MantenimientoActivoFijoConstantesFunciones.SCHEMA+"."+MantenimientoActivoFijoConstantesFunciones.TABLENAME+".fecha_inicio,"+MantenimientoActivoFijoConstantesFunciones.SCHEMA+"."+MantenimientoActivoFijoConstantesFunciones.TABLENAME+".fecha_entrega,"+MantenimientoActivoFijoConstantesFunciones.SCHEMA+"."+MantenimientoActivoFijoConstantesFunciones.TABLENAME+".costo,"+MantenimientoActivoFijoConstantesFunciones.SCHEMA+"."+MantenimientoActivoFijoConstantesFunciones.TABLENAME+".responsable,"+MantenimientoActivoFijoConstantesFunciones.SCHEMA+"."+MantenimientoActivoFijoConstantesFunciones.TABLENAME+".observacion from "+MantenimientoActivoFijoConstantesFunciones.SCHEMA+"."+MantenimientoActivoFijoConstantesFunciones.TABLENAME;//+" as "+MantenimientoActivoFijoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected MantenimientoActivoFijoConstantesFuncionesAdditional mantenimientoactivofijoConstantesFuncionesAdditional=null;
	
	public MantenimientoActivoFijoConstantesFuncionesAdditional getMantenimientoActivoFijoConstantesFuncionesAdditional() {
		return this.mantenimientoactivofijoConstantesFuncionesAdditional;
	}
	
	public void setMantenimientoActivoFijoConstantesFuncionesAdditional(MantenimientoActivoFijoConstantesFuncionesAdditional mantenimientoactivofijoConstantesFuncionesAdditional) {
		try {
			this.mantenimientoactivofijoConstantesFuncionesAdditional=mantenimientoactivofijoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDDETALLEACTIVOFIJO= "id_detalle_activo_fijo";
    public static final String IDTIPOMOVIMIENTO= "id_tipo_movimiento";
    public static final String NUMERODOCUMENTO= "numero_documento";
    public static final String CAUSA= "causa";
    public static final String REFERENCIA= "referencia";
    public static final String TALLER= "taller";
    public static final String TELEFONO= "telefono";
    public static final String FECHAINICIO= "fecha_inicio";
    public static final String FECHAENTREGA= "fecha_entrega";
    public static final String COSTO= "costo";
    public static final String RESPONSABLE= "responsable";
    public static final String OBSERVACION= "observacion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDDETALLEACTIVOFIJO= "Detalle Activo Fijo";
		public static final String LABEL_IDDETALLEACTIVOFIJO_LOWER= "Detalle Activo Fijo";
    	public static final String LABEL_IDTIPOMOVIMIENTO= "Tipo Movimiento";
		public static final String LABEL_IDTIPOMOVIMIENTO_LOWER= "Tipo Movimiento";
    	public static final String LABEL_NUMERODOCUMENTO= "Numero Documento";
		public static final String LABEL_NUMERODOCUMENTO_LOWER= "Numero Documento";
    	public static final String LABEL_CAUSA= "Causa";
		public static final String LABEL_CAUSA_LOWER= "Causa";
    	public static final String LABEL_REFERENCIA= "Referencia";
		public static final String LABEL_REFERENCIA_LOWER= "Referencia";
    	public static final String LABEL_TALLER= "Taller";
		public static final String LABEL_TALLER_LOWER= "Taller";
    	public static final String LABEL_TELEFONO= "Telefono";
		public static final String LABEL_TELEFONO_LOWER= "Telefono";
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
	
		
		
		
		
		
		
	public static final String SREGEXNUMERO_DOCUMENTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_DOCUMENTO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCAUSA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCAUSA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXREFERENCIA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXREFERENCIA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXTALLER=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXTALLER=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXTELEFONO=ConstantesValidacion.SREGEXCADENA_TELEFONO;
	public static final String SMENSAJEREGEXTELEFONO=ConstantesValidacion.SVALIDACIONCADENA_TELEFONO;	
		
		
		
	public static final String SREGEXRESPONSABLE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXRESPONSABLE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXOBSERVACION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXOBSERVACION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getMantenimientoActivoFijoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(MantenimientoActivoFijoConstantesFunciones.IDEMPRESA)) {sLabelColumna=MantenimientoActivoFijoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(MantenimientoActivoFijoConstantesFunciones.IDSUCURSAL)) {sLabelColumna=MantenimientoActivoFijoConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(MantenimientoActivoFijoConstantesFunciones.IDDETALLEACTIVOFIJO)) {sLabelColumna=MantenimientoActivoFijoConstantesFunciones.LABEL_IDDETALLEACTIVOFIJO;}
		if(sNombreColumna.equals(MantenimientoActivoFijoConstantesFunciones.IDTIPOMOVIMIENTO)) {sLabelColumna=MantenimientoActivoFijoConstantesFunciones.LABEL_IDTIPOMOVIMIENTO;}
		if(sNombreColumna.equals(MantenimientoActivoFijoConstantesFunciones.NUMERODOCUMENTO)) {sLabelColumna=MantenimientoActivoFijoConstantesFunciones.LABEL_NUMERODOCUMENTO;}
		if(sNombreColumna.equals(MantenimientoActivoFijoConstantesFunciones.CAUSA)) {sLabelColumna=MantenimientoActivoFijoConstantesFunciones.LABEL_CAUSA;}
		if(sNombreColumna.equals(MantenimientoActivoFijoConstantesFunciones.REFERENCIA)) {sLabelColumna=MantenimientoActivoFijoConstantesFunciones.LABEL_REFERENCIA;}
		if(sNombreColumna.equals(MantenimientoActivoFijoConstantesFunciones.TALLER)) {sLabelColumna=MantenimientoActivoFijoConstantesFunciones.LABEL_TALLER;}
		if(sNombreColumna.equals(MantenimientoActivoFijoConstantesFunciones.TELEFONO)) {sLabelColumna=MantenimientoActivoFijoConstantesFunciones.LABEL_TELEFONO;}
		if(sNombreColumna.equals(MantenimientoActivoFijoConstantesFunciones.FECHAINICIO)) {sLabelColumna=MantenimientoActivoFijoConstantesFunciones.LABEL_FECHAINICIO;}
		if(sNombreColumna.equals(MantenimientoActivoFijoConstantesFunciones.FECHAENTREGA)) {sLabelColumna=MantenimientoActivoFijoConstantesFunciones.LABEL_FECHAENTREGA;}
		if(sNombreColumna.equals(MantenimientoActivoFijoConstantesFunciones.COSTO)) {sLabelColumna=MantenimientoActivoFijoConstantesFunciones.LABEL_COSTO;}
		if(sNombreColumna.equals(MantenimientoActivoFijoConstantesFunciones.RESPONSABLE)) {sLabelColumna=MantenimientoActivoFijoConstantesFunciones.LABEL_RESPONSABLE;}
		if(sNombreColumna.equals(MantenimientoActivoFijoConstantesFunciones.OBSERVACION)) {sLabelColumna=MantenimientoActivoFijoConstantesFunciones.LABEL_OBSERVACION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getMantenimientoActivoFijoDescripcion(MantenimientoActivoFijo mantenimientoactivofijo) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(mantenimientoactivofijo !=null/* && mantenimientoactivofijo.getId()!=0*/) {
			if(mantenimientoactivofijo.getId()!=null) {
				sDescripcion=mantenimientoactivofijo.getId().toString();
			}//mantenimientoactivofijomantenimientoactivofijo.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getMantenimientoActivoFijoDescripcionDetallado(MantenimientoActivoFijo mantenimientoactivofijo) {
		String sDescripcion="";
			
		sDescripcion+=MantenimientoActivoFijoConstantesFunciones.ID+"=";
		sDescripcion+=mantenimientoactivofijo.getId().toString()+",";
		sDescripcion+=MantenimientoActivoFijoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=mantenimientoactivofijo.getVersionRow().toString()+",";
		sDescripcion+=MantenimientoActivoFijoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=mantenimientoactivofijo.getid_empresa().toString()+",";
		sDescripcion+=MantenimientoActivoFijoConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=mantenimientoactivofijo.getid_sucursal().toString()+",";
		sDescripcion+=MantenimientoActivoFijoConstantesFunciones.IDDETALLEACTIVOFIJO+"=";
		sDescripcion+=mantenimientoactivofijo.getid_detalle_activo_fijo().toString()+",";
		sDescripcion+=MantenimientoActivoFijoConstantesFunciones.IDTIPOMOVIMIENTO+"=";
		sDescripcion+=mantenimientoactivofijo.getid_tipo_movimiento().toString()+",";
		sDescripcion+=MantenimientoActivoFijoConstantesFunciones.NUMERODOCUMENTO+"=";
		sDescripcion+=mantenimientoactivofijo.getnumero_documento()+",";
		sDescripcion+=MantenimientoActivoFijoConstantesFunciones.CAUSA+"=";
		sDescripcion+=mantenimientoactivofijo.getcausa()+",";
		sDescripcion+=MantenimientoActivoFijoConstantesFunciones.REFERENCIA+"=";
		sDescripcion+=mantenimientoactivofijo.getreferencia()+",";
		sDescripcion+=MantenimientoActivoFijoConstantesFunciones.TALLER+"=";
		sDescripcion+=mantenimientoactivofijo.gettaller()+",";
		sDescripcion+=MantenimientoActivoFijoConstantesFunciones.TELEFONO+"=";
		sDescripcion+=mantenimientoactivofijo.gettelefono()+",";
		sDescripcion+=MantenimientoActivoFijoConstantesFunciones.FECHAINICIO+"=";
		sDescripcion+=mantenimientoactivofijo.getfecha_inicio().toString()+",";
		sDescripcion+=MantenimientoActivoFijoConstantesFunciones.FECHAENTREGA+"=";
		sDescripcion+=mantenimientoactivofijo.getfecha_entrega().toString()+",";
		sDescripcion+=MantenimientoActivoFijoConstantesFunciones.COSTO+"=";
		sDescripcion+=mantenimientoactivofijo.getcosto().toString()+",";
		sDescripcion+=MantenimientoActivoFijoConstantesFunciones.RESPONSABLE+"=";
		sDescripcion+=mantenimientoactivofijo.getresponsable()+",";
		sDescripcion+=MantenimientoActivoFijoConstantesFunciones.OBSERVACION+"=";
		sDescripcion+=mantenimientoactivofijo.getobservacion()+",";
			
		return sDescripcion;
	}
	
	public static void setMantenimientoActivoFijoDescripcion(MantenimientoActivoFijo mantenimientoactivofijo,String sValor) throws Exception {			
		if(mantenimientoactivofijo !=null) {
			//mantenimientoactivofijomantenimientoactivofijo.getId().toString();
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

	public static String getDetalleActivoFijoDescripcion(DetalleActivoFijo detalleactivofijo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(detalleactivofijo!=null/*&&detalleactivofijo.getId()>0*/) {
			sDescripcion=DetalleActivoFijoConstantesFunciones.getDetalleActivoFijoDescripcion(detalleactivofijo);
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
		} else if(sNombreIndice.equals("FK_IdDetalleActivoFijo")) {
			sNombreIndice="Tipo=  Por Detalle Activo Fijo";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoMovimiento")) {
			sNombreIndice="Tipo=  Por Tipo Movimiento";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdDetalleActivoFijo(Long id_detalle_activo_fijo) {
		String sDetalleIndice=" Parametros->";
		if(id_detalle_activo_fijo!=null) {sDetalleIndice+=" Codigo Unico De Detalle Activo Fijo="+id_detalle_activo_fijo.toString();} 

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

	public static String getDetalleIndiceFK_IdTipoMovimiento(Long id_tipo_movimiento) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_movimiento!=null) {sDetalleIndice+=" Codigo Unico De Tipo Movimiento="+id_tipo_movimiento.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosMantenimientoActivoFijo(MantenimientoActivoFijo mantenimientoactivofijo,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		mantenimientoactivofijo.setnumero_documento(mantenimientoactivofijo.getnumero_documento().trim());
		mantenimientoactivofijo.setcausa(mantenimientoactivofijo.getcausa().trim());
		mantenimientoactivofijo.setreferencia(mantenimientoactivofijo.getreferencia().trim());
		mantenimientoactivofijo.settaller(mantenimientoactivofijo.gettaller().trim());
		mantenimientoactivofijo.settelefono(mantenimientoactivofijo.gettelefono().trim());
		mantenimientoactivofijo.setresponsable(mantenimientoactivofijo.getresponsable().trim());
		mantenimientoactivofijo.setobservacion(mantenimientoactivofijo.getobservacion().trim());
	}
	
	public static void quitarEspaciosMantenimientoActivoFijos(List<MantenimientoActivoFijo> mantenimientoactivofijos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(MantenimientoActivoFijo mantenimientoactivofijo: mantenimientoactivofijos) {
			mantenimientoactivofijo.setnumero_documento(mantenimientoactivofijo.getnumero_documento().trim());
			mantenimientoactivofijo.setcausa(mantenimientoactivofijo.getcausa().trim());
			mantenimientoactivofijo.setreferencia(mantenimientoactivofijo.getreferencia().trim());
			mantenimientoactivofijo.settaller(mantenimientoactivofijo.gettaller().trim());
			mantenimientoactivofijo.settelefono(mantenimientoactivofijo.gettelefono().trim());
			mantenimientoactivofijo.setresponsable(mantenimientoactivofijo.getresponsable().trim());
			mantenimientoactivofijo.setobservacion(mantenimientoactivofijo.getobservacion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresMantenimientoActivoFijo(MantenimientoActivoFijo mantenimientoactivofijo,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && mantenimientoactivofijo.getConCambioAuxiliar()) {
			mantenimientoactivofijo.setIsDeleted(mantenimientoactivofijo.getIsDeletedAuxiliar());	
			mantenimientoactivofijo.setIsNew(mantenimientoactivofijo.getIsNewAuxiliar());	
			mantenimientoactivofijo.setIsChanged(mantenimientoactivofijo.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			mantenimientoactivofijo.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			mantenimientoactivofijo.setIsDeletedAuxiliar(false);	
			mantenimientoactivofijo.setIsNewAuxiliar(false);	
			mantenimientoactivofijo.setIsChangedAuxiliar(false);
			
			mantenimientoactivofijo.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresMantenimientoActivoFijos(List<MantenimientoActivoFijo> mantenimientoactivofijos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(MantenimientoActivoFijo mantenimientoactivofijo : mantenimientoactivofijos) {
			if(conAsignarBase && mantenimientoactivofijo.getConCambioAuxiliar()) {
				mantenimientoactivofijo.setIsDeleted(mantenimientoactivofijo.getIsDeletedAuxiliar());	
				mantenimientoactivofijo.setIsNew(mantenimientoactivofijo.getIsNewAuxiliar());	
				mantenimientoactivofijo.setIsChanged(mantenimientoactivofijo.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				mantenimientoactivofijo.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				mantenimientoactivofijo.setIsDeletedAuxiliar(false);	
				mantenimientoactivofijo.setIsNewAuxiliar(false);	
				mantenimientoactivofijo.setIsChangedAuxiliar(false);
				
				mantenimientoactivofijo.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresMantenimientoActivoFijo(MantenimientoActivoFijo mantenimientoactivofijo,Boolean conEnteros) throws Exception  {
		mantenimientoactivofijo.setcosto(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresMantenimientoActivoFijos(List<MantenimientoActivoFijo> mantenimientoactivofijos,Boolean conEnteros) throws Exception  {
		
		for(MantenimientoActivoFijo mantenimientoactivofijo: mantenimientoactivofijos) {
			mantenimientoactivofijo.setcosto(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaMantenimientoActivoFijo(List<MantenimientoActivoFijo> mantenimientoactivofijos,MantenimientoActivoFijo mantenimientoactivofijoAux) throws Exception  {
		MantenimientoActivoFijoConstantesFunciones.InicializarValoresMantenimientoActivoFijo(mantenimientoactivofijoAux,true);
		
		for(MantenimientoActivoFijo mantenimientoactivofijo: mantenimientoactivofijos) {
			if(mantenimientoactivofijo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			mantenimientoactivofijoAux.setcosto(mantenimientoactivofijoAux.getcosto()+mantenimientoactivofijo.getcosto());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesMantenimientoActivoFijo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=MantenimientoActivoFijoConstantesFunciones.getArrayColumnasGlobalesMantenimientoActivoFijo(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesMantenimientoActivoFijo(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(MantenimientoActivoFijoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(MantenimientoActivoFijoConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(MantenimientoActivoFijoConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(MantenimientoActivoFijoConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoMantenimientoActivoFijo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<MantenimientoActivoFijo> mantenimientoactivofijos,MantenimientoActivoFijo mantenimientoactivofijo,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(MantenimientoActivoFijo mantenimientoactivofijoAux: mantenimientoactivofijos) {
			if(mantenimientoactivofijoAux!=null && mantenimientoactivofijo!=null) {
				if((mantenimientoactivofijoAux.getId()==null && mantenimientoactivofijo.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(mantenimientoactivofijoAux.getId()!=null && mantenimientoactivofijo.getId()!=null){
					if(mantenimientoactivofijoAux.getId().equals(mantenimientoactivofijo.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaMantenimientoActivoFijo(List<MantenimientoActivoFijo> mantenimientoactivofijos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double costoTotal=0.0;
	
		for(MantenimientoActivoFijo mantenimientoactivofijo: mantenimientoactivofijos) {			
			if(mantenimientoactivofijo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			costoTotal+=mantenimientoactivofijo.getcosto();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(MantenimientoActivoFijoConstantesFunciones.COSTO);
		datoGeneral.setsDescripcion(MantenimientoActivoFijoConstantesFunciones.LABEL_COSTO);
		datoGeneral.setdValorDouble(costoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaMantenimientoActivoFijo() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,MantenimientoActivoFijoConstantesFunciones.LABEL_ID, MantenimientoActivoFijoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MantenimientoActivoFijoConstantesFunciones.LABEL_VERSIONROW, MantenimientoActivoFijoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MantenimientoActivoFijoConstantesFunciones.LABEL_IDEMPRESA, MantenimientoActivoFijoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MantenimientoActivoFijoConstantesFunciones.LABEL_IDSUCURSAL, MantenimientoActivoFijoConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MantenimientoActivoFijoConstantesFunciones.LABEL_IDDETALLEACTIVOFIJO, MantenimientoActivoFijoConstantesFunciones.IDDETALLEACTIVOFIJO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MantenimientoActivoFijoConstantesFunciones.LABEL_IDTIPOMOVIMIENTO, MantenimientoActivoFijoConstantesFunciones.IDTIPOMOVIMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MantenimientoActivoFijoConstantesFunciones.LABEL_NUMERODOCUMENTO, MantenimientoActivoFijoConstantesFunciones.NUMERODOCUMENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MantenimientoActivoFijoConstantesFunciones.LABEL_CAUSA, MantenimientoActivoFijoConstantesFunciones.CAUSA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MantenimientoActivoFijoConstantesFunciones.LABEL_REFERENCIA, MantenimientoActivoFijoConstantesFunciones.REFERENCIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MantenimientoActivoFijoConstantesFunciones.LABEL_TALLER, MantenimientoActivoFijoConstantesFunciones.TALLER,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MantenimientoActivoFijoConstantesFunciones.LABEL_TELEFONO, MantenimientoActivoFijoConstantesFunciones.TELEFONO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MantenimientoActivoFijoConstantesFunciones.LABEL_FECHAINICIO, MantenimientoActivoFijoConstantesFunciones.FECHAINICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MantenimientoActivoFijoConstantesFunciones.LABEL_FECHAENTREGA, MantenimientoActivoFijoConstantesFunciones.FECHAENTREGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MantenimientoActivoFijoConstantesFunciones.LABEL_COSTO, MantenimientoActivoFijoConstantesFunciones.COSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MantenimientoActivoFijoConstantesFunciones.LABEL_RESPONSABLE, MantenimientoActivoFijoConstantesFunciones.RESPONSABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MantenimientoActivoFijoConstantesFunciones.LABEL_OBSERVACION, MantenimientoActivoFijoConstantesFunciones.OBSERVACION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasMantenimientoActivoFijo() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=MantenimientoActivoFijoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MantenimientoActivoFijoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MantenimientoActivoFijoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MantenimientoActivoFijoConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MantenimientoActivoFijoConstantesFunciones.IDDETALLEACTIVOFIJO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MantenimientoActivoFijoConstantesFunciones.IDTIPOMOVIMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MantenimientoActivoFijoConstantesFunciones.NUMERODOCUMENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MantenimientoActivoFijoConstantesFunciones.CAUSA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MantenimientoActivoFijoConstantesFunciones.REFERENCIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MantenimientoActivoFijoConstantesFunciones.TALLER;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MantenimientoActivoFijoConstantesFunciones.TELEFONO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MantenimientoActivoFijoConstantesFunciones.FECHAINICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MantenimientoActivoFijoConstantesFunciones.FECHAENTREGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MantenimientoActivoFijoConstantesFunciones.COSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MantenimientoActivoFijoConstantesFunciones.RESPONSABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MantenimientoActivoFijoConstantesFunciones.OBSERVACION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarMantenimientoActivoFijo() throws Exception  {
		return MantenimientoActivoFijoConstantesFunciones.getTiposSeleccionarMantenimientoActivoFijo(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarMantenimientoActivoFijo(Boolean conFk) throws Exception  {
		return MantenimientoActivoFijoConstantesFunciones.getTiposSeleccionarMantenimientoActivoFijo(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarMantenimientoActivoFijo(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(MantenimientoActivoFijoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(MantenimientoActivoFijoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(MantenimientoActivoFijoConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(MantenimientoActivoFijoConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(MantenimientoActivoFijoConstantesFunciones.LABEL_IDDETALLEACTIVOFIJO);
			reporte.setsDescripcion(MantenimientoActivoFijoConstantesFunciones.LABEL_IDDETALLEACTIVOFIJO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(MantenimientoActivoFijoConstantesFunciones.LABEL_IDTIPOMOVIMIENTO);
			reporte.setsDescripcion(MantenimientoActivoFijoConstantesFunciones.LABEL_IDTIPOMOVIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MantenimientoActivoFijoConstantesFunciones.LABEL_NUMERODOCUMENTO);
			reporte.setsDescripcion(MantenimientoActivoFijoConstantesFunciones.LABEL_NUMERODOCUMENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MantenimientoActivoFijoConstantesFunciones.LABEL_CAUSA);
			reporte.setsDescripcion(MantenimientoActivoFijoConstantesFunciones.LABEL_CAUSA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MantenimientoActivoFijoConstantesFunciones.LABEL_REFERENCIA);
			reporte.setsDescripcion(MantenimientoActivoFijoConstantesFunciones.LABEL_REFERENCIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MantenimientoActivoFijoConstantesFunciones.LABEL_TALLER);
			reporte.setsDescripcion(MantenimientoActivoFijoConstantesFunciones.LABEL_TALLER);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MantenimientoActivoFijoConstantesFunciones.LABEL_TELEFONO);
			reporte.setsDescripcion(MantenimientoActivoFijoConstantesFunciones.LABEL_TELEFONO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MantenimientoActivoFijoConstantesFunciones.LABEL_FECHAINICIO);
			reporte.setsDescripcion(MantenimientoActivoFijoConstantesFunciones.LABEL_FECHAINICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MantenimientoActivoFijoConstantesFunciones.LABEL_FECHAENTREGA);
			reporte.setsDescripcion(MantenimientoActivoFijoConstantesFunciones.LABEL_FECHAENTREGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MantenimientoActivoFijoConstantesFunciones.LABEL_COSTO);
			reporte.setsDescripcion(MantenimientoActivoFijoConstantesFunciones.LABEL_COSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MantenimientoActivoFijoConstantesFunciones.LABEL_RESPONSABLE);
			reporte.setsDescripcion(MantenimientoActivoFijoConstantesFunciones.LABEL_RESPONSABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MantenimientoActivoFijoConstantesFunciones.LABEL_OBSERVACION);
			reporte.setsDescripcion(MantenimientoActivoFijoConstantesFunciones.LABEL_OBSERVACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesMantenimientoActivoFijo(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesMantenimientoActivoFijo(MantenimientoActivoFijo mantenimientoactivofijoAux) throws Exception {
		
			mantenimientoactivofijoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(mantenimientoactivofijoAux.getEmpresa()));
			mantenimientoactivofijoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(mantenimientoactivofijoAux.getSucursal()));
			mantenimientoactivofijoAux.setdetalleactivofijo_descripcion(DetalleActivoFijoConstantesFunciones.getDetalleActivoFijoDescripcion(mantenimientoactivofijoAux.getDetalleActivoFijo()));
			mantenimientoactivofijoAux.settipomovimiento_descripcion(TipoMovimientoConstantesFunciones.getTipoMovimientoDescripcion(mantenimientoactivofijoAux.getTipoMovimiento()));		
	}
	
	public static void refrescarForeignKeysDescripcionesMantenimientoActivoFijo(List<MantenimientoActivoFijo> mantenimientoactivofijosTemp) throws Exception {
		for(MantenimientoActivoFijo mantenimientoactivofijoAux:mantenimientoactivofijosTemp) {
			
			mantenimientoactivofijoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(mantenimientoactivofijoAux.getEmpresa()));
			mantenimientoactivofijoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(mantenimientoactivofijoAux.getSucursal()));
			mantenimientoactivofijoAux.setdetalleactivofijo_descripcion(DetalleActivoFijoConstantesFunciones.getDetalleActivoFijoDescripcion(mantenimientoactivofijoAux.getDetalleActivoFijo()));
			mantenimientoactivofijoAux.settipomovimiento_descripcion(TipoMovimientoConstantesFunciones.getTipoMovimientoDescripcion(mantenimientoactivofijoAux.getTipoMovimiento()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfMantenimientoActivoFijo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(DetalleActivoFijo.class));
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
					if(clas.clas.equals(DetalleActivoFijo.class)) {
						classes.add(new Classe(DetalleActivoFijo.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfMantenimientoActivoFijo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(DetalleActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleActivoFijo.class)); continue;
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

					if(DetalleActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleActivoFijo.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfMantenimientoActivoFijo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return MantenimientoActivoFijoConstantesFunciones.getClassesRelationshipsOfMantenimientoActivoFijo(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfMantenimientoActivoFijo(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfMantenimientoActivoFijo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return MantenimientoActivoFijoConstantesFunciones.getClassesRelationshipsFromStringsOfMantenimientoActivoFijo(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfMantenimientoActivoFijo(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(MantenimientoActivoFijo mantenimientoactivofijo,List<MantenimientoActivoFijo> mantenimientoactivofijos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			MantenimientoActivoFijo mantenimientoactivofijoEncontrado=null;
			
			for(MantenimientoActivoFijo mantenimientoactivofijoLocal:mantenimientoactivofijos) {
				if(mantenimientoactivofijoLocal.getId().equals(mantenimientoactivofijo.getId())) {
					mantenimientoactivofijoEncontrado=mantenimientoactivofijoLocal;
					
					mantenimientoactivofijoLocal.setIsChanged(mantenimientoactivofijo.getIsChanged());
					mantenimientoactivofijoLocal.setIsNew(mantenimientoactivofijo.getIsNew());
					mantenimientoactivofijoLocal.setIsDeleted(mantenimientoactivofijo.getIsDeleted());
					
					mantenimientoactivofijoLocal.setGeneralEntityOriginal(mantenimientoactivofijo.getGeneralEntityOriginal());
					
					mantenimientoactivofijoLocal.setId(mantenimientoactivofijo.getId());	
					mantenimientoactivofijoLocal.setVersionRow(mantenimientoactivofijo.getVersionRow());	
					mantenimientoactivofijoLocal.setid_empresa(mantenimientoactivofijo.getid_empresa());	
					mantenimientoactivofijoLocal.setid_sucursal(mantenimientoactivofijo.getid_sucursal());	
					mantenimientoactivofijoLocal.setid_detalle_activo_fijo(mantenimientoactivofijo.getid_detalle_activo_fijo());	
					mantenimientoactivofijoLocal.setid_tipo_movimiento(mantenimientoactivofijo.getid_tipo_movimiento());	
					mantenimientoactivofijoLocal.setnumero_documento(mantenimientoactivofijo.getnumero_documento());	
					mantenimientoactivofijoLocal.setcausa(mantenimientoactivofijo.getcausa());	
					mantenimientoactivofijoLocal.setreferencia(mantenimientoactivofijo.getreferencia());	
					mantenimientoactivofijoLocal.settaller(mantenimientoactivofijo.gettaller());	
					mantenimientoactivofijoLocal.settelefono(mantenimientoactivofijo.gettelefono());	
					mantenimientoactivofijoLocal.setfecha_inicio(mantenimientoactivofijo.getfecha_inicio());	
					mantenimientoactivofijoLocal.setfecha_entrega(mantenimientoactivofijo.getfecha_entrega());	
					mantenimientoactivofijoLocal.setcosto(mantenimientoactivofijo.getcosto());	
					mantenimientoactivofijoLocal.setresponsable(mantenimientoactivofijo.getresponsable());	
					mantenimientoactivofijoLocal.setobservacion(mantenimientoactivofijo.getobservacion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!mantenimientoactivofijo.getIsDeleted()) {
				if(!existe) {
					mantenimientoactivofijos.add(mantenimientoactivofijo);
				}
			} else {
				if(mantenimientoactivofijoEncontrado!=null && permiteQuitar)  {
					mantenimientoactivofijos.remove(mantenimientoactivofijoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(MantenimientoActivoFijo mantenimientoactivofijo,List<MantenimientoActivoFijo> mantenimientoactivofijos) throws Exception {
		try	{			
			for(MantenimientoActivoFijo mantenimientoactivofijoLocal:mantenimientoactivofijos) {
				if(mantenimientoactivofijoLocal.getId().equals(mantenimientoactivofijo.getId())) {
					mantenimientoactivofijoLocal.setIsSelected(mantenimientoactivofijo.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesMantenimientoActivoFijo(List<MantenimientoActivoFijo> mantenimientoactivofijosAux) throws Exception {
		//this.mantenimientoactivofijosAux=mantenimientoactivofijosAux;
		
		for(MantenimientoActivoFijo mantenimientoactivofijoAux:mantenimientoactivofijosAux) {
			if(mantenimientoactivofijoAux.getIsChanged()) {
				mantenimientoactivofijoAux.setIsChanged(false);
			}		
			
			if(mantenimientoactivofijoAux.getIsNew()) {
				mantenimientoactivofijoAux.setIsNew(false);
			}	
			
			if(mantenimientoactivofijoAux.getIsDeleted()) {
				mantenimientoactivofijoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesMantenimientoActivoFijo(MantenimientoActivoFijo mantenimientoactivofijoAux) throws Exception {
		//this.mantenimientoactivofijoAux=mantenimientoactivofijoAux;
		
			if(mantenimientoactivofijoAux.getIsChanged()) {
				mantenimientoactivofijoAux.setIsChanged(false);
			}		
			
			if(mantenimientoactivofijoAux.getIsNew()) {
				mantenimientoactivofijoAux.setIsNew(false);
			}	
			
			if(mantenimientoactivofijoAux.getIsDeleted()) {
				mantenimientoactivofijoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(MantenimientoActivoFijo mantenimientoactivofijoAsignar,MantenimientoActivoFijo mantenimientoactivofijo) throws Exception {
		mantenimientoactivofijoAsignar.setId(mantenimientoactivofijo.getId());	
		mantenimientoactivofijoAsignar.setVersionRow(mantenimientoactivofijo.getVersionRow());	
		mantenimientoactivofijoAsignar.setid_empresa(mantenimientoactivofijo.getid_empresa());
		mantenimientoactivofijoAsignar.setempresa_descripcion(mantenimientoactivofijo.getempresa_descripcion());	
		mantenimientoactivofijoAsignar.setid_sucursal(mantenimientoactivofijo.getid_sucursal());
		mantenimientoactivofijoAsignar.setsucursal_descripcion(mantenimientoactivofijo.getsucursal_descripcion());	
		mantenimientoactivofijoAsignar.setid_detalle_activo_fijo(mantenimientoactivofijo.getid_detalle_activo_fijo());
		mantenimientoactivofijoAsignar.setdetalleactivofijo_descripcion(mantenimientoactivofijo.getdetalleactivofijo_descripcion());	
		mantenimientoactivofijoAsignar.setid_tipo_movimiento(mantenimientoactivofijo.getid_tipo_movimiento());
		mantenimientoactivofijoAsignar.settipomovimiento_descripcion(mantenimientoactivofijo.gettipomovimiento_descripcion());	
		mantenimientoactivofijoAsignar.setnumero_documento(mantenimientoactivofijo.getnumero_documento());	
		mantenimientoactivofijoAsignar.setcausa(mantenimientoactivofijo.getcausa());	
		mantenimientoactivofijoAsignar.setreferencia(mantenimientoactivofijo.getreferencia());	
		mantenimientoactivofijoAsignar.settaller(mantenimientoactivofijo.gettaller());	
		mantenimientoactivofijoAsignar.settelefono(mantenimientoactivofijo.gettelefono());	
		mantenimientoactivofijoAsignar.setfecha_inicio(mantenimientoactivofijo.getfecha_inicio());	
		mantenimientoactivofijoAsignar.setfecha_entrega(mantenimientoactivofijo.getfecha_entrega());	
		mantenimientoactivofijoAsignar.setcosto(mantenimientoactivofijo.getcosto());	
		mantenimientoactivofijoAsignar.setresponsable(mantenimientoactivofijo.getresponsable());	
		mantenimientoactivofijoAsignar.setobservacion(mantenimientoactivofijo.getobservacion());	
	}
	
	public static void inicializarMantenimientoActivoFijo(MantenimientoActivoFijo mantenimientoactivofijo) throws Exception {
		try {
				mantenimientoactivofijo.setId(0L);	
					
				mantenimientoactivofijo.setid_empresa(-1L);	
				mantenimientoactivofijo.setid_sucursal(-1L);	
				mantenimientoactivofijo.setid_detalle_activo_fijo(-1L);	
				mantenimientoactivofijo.setid_tipo_movimiento(-1L);	
				mantenimientoactivofijo.setnumero_documento("");	
				mantenimientoactivofijo.setcausa("");	
				mantenimientoactivofijo.setreferencia("");	
				mantenimientoactivofijo.settaller("");	
				mantenimientoactivofijo.settelefono("");	
				mantenimientoactivofijo.setfecha_inicio(new Date());	
				mantenimientoactivofijo.setfecha_entrega(new Date());	
				mantenimientoactivofijo.setcosto(0.0);	
				mantenimientoactivofijo.setresponsable("");	
				mantenimientoactivofijo.setobservacion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderMantenimientoActivoFijo(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(MantenimientoActivoFijoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MantenimientoActivoFijoConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MantenimientoActivoFijoConstantesFunciones.LABEL_IDDETALLEACTIVOFIJO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MantenimientoActivoFijoConstantesFunciones.LABEL_IDTIPOMOVIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MantenimientoActivoFijoConstantesFunciones.LABEL_NUMERODOCUMENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MantenimientoActivoFijoConstantesFunciones.LABEL_CAUSA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MantenimientoActivoFijoConstantesFunciones.LABEL_REFERENCIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MantenimientoActivoFijoConstantesFunciones.LABEL_TALLER);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MantenimientoActivoFijoConstantesFunciones.LABEL_TELEFONO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MantenimientoActivoFijoConstantesFunciones.LABEL_FECHAINICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MantenimientoActivoFijoConstantesFunciones.LABEL_FECHAENTREGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MantenimientoActivoFijoConstantesFunciones.LABEL_COSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MantenimientoActivoFijoConstantesFunciones.LABEL_RESPONSABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MantenimientoActivoFijoConstantesFunciones.LABEL_OBSERVACION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataMantenimientoActivoFijo(String sTipo,Row row,Workbook workbook,MantenimientoActivoFijo mantenimientoactivofijo,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(mantenimientoactivofijo.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(mantenimientoactivofijo.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(mantenimientoactivofijo.getdetalleactivofijo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(mantenimientoactivofijo.gettipomovimiento_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(mantenimientoactivofijo.getnumero_documento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(mantenimientoactivofijo.getcausa());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(mantenimientoactivofijo.getreferencia());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(mantenimientoactivofijo.gettaller());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(mantenimientoactivofijo.gettelefono());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(mantenimientoactivofijo.getfecha_inicio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(mantenimientoactivofijo.getfecha_entrega());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(mantenimientoactivofijo.getcosto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(mantenimientoactivofijo.getresponsable());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(mantenimientoactivofijo.getobservacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryMantenimientoActivoFijo=Constantes.SFINALQUERY;
	
	public String getsFinalQueryMantenimientoActivoFijo() {
		return this.sFinalQueryMantenimientoActivoFijo;
	}
	
	public void setsFinalQueryMantenimientoActivoFijo(String sFinalQueryMantenimientoActivoFijo) {
		this.sFinalQueryMantenimientoActivoFijo= sFinalQueryMantenimientoActivoFijo;
	}
	
	public Border resaltarSeleccionarMantenimientoActivoFijo=null;
	
	public Border setResaltarSeleccionarMantenimientoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*MantenimientoActivoFijoBeanSwingJInternalFrame mantenimientoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//mantenimientoactivofijoBeanSwingJInternalFrame.jTtoolBarMantenimientoActivoFijo.setBorder(borderResaltar);
		
		this.resaltarSeleccionarMantenimientoActivoFijo= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarMantenimientoActivoFijo() {
		return this.resaltarSeleccionarMantenimientoActivoFijo;
	}
	
	public void setResaltarSeleccionarMantenimientoActivoFijo(Border borderResaltarSeleccionarMantenimientoActivoFijo) {
		this.resaltarSeleccionarMantenimientoActivoFijo= borderResaltarSeleccionarMantenimientoActivoFijo;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridMantenimientoActivoFijo=null;
	public Boolean mostraridMantenimientoActivoFijo=true;
	public Boolean activaridMantenimientoActivoFijo=true;

	public Border resaltarid_empresaMantenimientoActivoFijo=null;
	public Boolean mostrarid_empresaMantenimientoActivoFijo=true;
	public Boolean activarid_empresaMantenimientoActivoFijo=true;
	public Boolean cargarid_empresaMantenimientoActivoFijo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaMantenimientoActivoFijo=false;//ConEventDepend=true

	public Border resaltarid_sucursalMantenimientoActivoFijo=null;
	public Boolean mostrarid_sucursalMantenimientoActivoFijo=true;
	public Boolean activarid_sucursalMantenimientoActivoFijo=true;
	public Boolean cargarid_sucursalMantenimientoActivoFijo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalMantenimientoActivoFijo=false;//ConEventDepend=true

	public Border resaltarid_detalle_activo_fijoMantenimientoActivoFijo=null;
	public Boolean mostrarid_detalle_activo_fijoMantenimientoActivoFijo=true;
	public Boolean activarid_detalle_activo_fijoMantenimientoActivoFijo=true;
	public Boolean cargarid_detalle_activo_fijoMantenimientoActivoFijo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_detalle_activo_fijoMantenimientoActivoFijo=false;//ConEventDepend=true

	public Border resaltarid_tipo_movimientoMantenimientoActivoFijo=null;
	public Boolean mostrarid_tipo_movimientoMantenimientoActivoFijo=true;
	public Boolean activarid_tipo_movimientoMantenimientoActivoFijo=true;
	public Boolean cargarid_tipo_movimientoMantenimientoActivoFijo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_movimientoMantenimientoActivoFijo=false;//ConEventDepend=true

	public Border resaltarnumero_documentoMantenimientoActivoFijo=null;
	public Boolean mostrarnumero_documentoMantenimientoActivoFijo=true;
	public Boolean activarnumero_documentoMantenimientoActivoFijo=true;

	public Border resaltarcausaMantenimientoActivoFijo=null;
	public Boolean mostrarcausaMantenimientoActivoFijo=true;
	public Boolean activarcausaMantenimientoActivoFijo=true;

	public Border resaltarreferenciaMantenimientoActivoFijo=null;
	public Boolean mostrarreferenciaMantenimientoActivoFijo=true;
	public Boolean activarreferenciaMantenimientoActivoFijo=true;

	public Border resaltartallerMantenimientoActivoFijo=null;
	public Boolean mostrartallerMantenimientoActivoFijo=true;
	public Boolean activartallerMantenimientoActivoFijo=true;

	public Border resaltartelefonoMantenimientoActivoFijo=null;
	public Boolean mostrartelefonoMantenimientoActivoFijo=true;
	public Boolean activartelefonoMantenimientoActivoFijo=true;

	public Border resaltarfecha_inicioMantenimientoActivoFijo=null;
	public Boolean mostrarfecha_inicioMantenimientoActivoFijo=true;
	public Boolean activarfecha_inicioMantenimientoActivoFijo=false;

	public Border resaltarfecha_entregaMantenimientoActivoFijo=null;
	public Boolean mostrarfecha_entregaMantenimientoActivoFijo=true;
	public Boolean activarfecha_entregaMantenimientoActivoFijo=false;

	public Border resaltarcostoMantenimientoActivoFijo=null;
	public Boolean mostrarcostoMantenimientoActivoFijo=true;
	public Boolean activarcostoMantenimientoActivoFijo=true;

	public Border resaltarresponsableMantenimientoActivoFijo=null;
	public Boolean mostrarresponsableMantenimientoActivoFijo=true;
	public Boolean activarresponsableMantenimientoActivoFijo=true;

	public Border resaltarobservacionMantenimientoActivoFijo=null;
	public Boolean mostrarobservacionMantenimientoActivoFijo=true;
	public Boolean activarobservacionMantenimientoActivoFijo=true;

	
	

	public Border setResaltaridMantenimientoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*MantenimientoActivoFijoBeanSwingJInternalFrame mantenimientoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//mantenimientoactivofijoBeanSwingJInternalFrame.jTtoolBarMantenimientoActivoFijo.setBorder(borderResaltar);
		
		this.resaltaridMantenimientoActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridMantenimientoActivoFijo() {
		return this.resaltaridMantenimientoActivoFijo;
	}

	public void setResaltaridMantenimientoActivoFijo(Border borderResaltar) {
		this.resaltaridMantenimientoActivoFijo= borderResaltar;
	}

	public Boolean getMostraridMantenimientoActivoFijo() {
		return this.mostraridMantenimientoActivoFijo;
	}

	public void setMostraridMantenimientoActivoFijo(Boolean mostraridMantenimientoActivoFijo) {
		this.mostraridMantenimientoActivoFijo= mostraridMantenimientoActivoFijo;
	}

	public Boolean getActivaridMantenimientoActivoFijo() {
		return this.activaridMantenimientoActivoFijo;
	}

	public void setActivaridMantenimientoActivoFijo(Boolean activaridMantenimientoActivoFijo) {
		this.activaridMantenimientoActivoFijo= activaridMantenimientoActivoFijo;
	}

	public Border setResaltarid_empresaMantenimientoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*MantenimientoActivoFijoBeanSwingJInternalFrame mantenimientoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//mantenimientoactivofijoBeanSwingJInternalFrame.jTtoolBarMantenimientoActivoFijo.setBorder(borderResaltar);
		
		this.resaltarid_empresaMantenimientoActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaMantenimientoActivoFijo() {
		return this.resaltarid_empresaMantenimientoActivoFijo;
	}

	public void setResaltarid_empresaMantenimientoActivoFijo(Border borderResaltar) {
		this.resaltarid_empresaMantenimientoActivoFijo= borderResaltar;
	}

	public Boolean getMostrarid_empresaMantenimientoActivoFijo() {
		return this.mostrarid_empresaMantenimientoActivoFijo;
	}

	public void setMostrarid_empresaMantenimientoActivoFijo(Boolean mostrarid_empresaMantenimientoActivoFijo) {
		this.mostrarid_empresaMantenimientoActivoFijo= mostrarid_empresaMantenimientoActivoFijo;
	}

	public Boolean getActivarid_empresaMantenimientoActivoFijo() {
		return this.activarid_empresaMantenimientoActivoFijo;
	}

	public void setActivarid_empresaMantenimientoActivoFijo(Boolean activarid_empresaMantenimientoActivoFijo) {
		this.activarid_empresaMantenimientoActivoFijo= activarid_empresaMantenimientoActivoFijo;
	}

	public Boolean getCargarid_empresaMantenimientoActivoFijo() {
		return this.cargarid_empresaMantenimientoActivoFijo;
	}

	public void setCargarid_empresaMantenimientoActivoFijo(Boolean cargarid_empresaMantenimientoActivoFijo) {
		this.cargarid_empresaMantenimientoActivoFijo= cargarid_empresaMantenimientoActivoFijo;
	}

	public Border setResaltarid_sucursalMantenimientoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*MantenimientoActivoFijoBeanSwingJInternalFrame mantenimientoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//mantenimientoactivofijoBeanSwingJInternalFrame.jTtoolBarMantenimientoActivoFijo.setBorder(borderResaltar);
		
		this.resaltarid_sucursalMantenimientoActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalMantenimientoActivoFijo() {
		return this.resaltarid_sucursalMantenimientoActivoFijo;
	}

	public void setResaltarid_sucursalMantenimientoActivoFijo(Border borderResaltar) {
		this.resaltarid_sucursalMantenimientoActivoFijo= borderResaltar;
	}

	public Boolean getMostrarid_sucursalMantenimientoActivoFijo() {
		return this.mostrarid_sucursalMantenimientoActivoFijo;
	}

	public void setMostrarid_sucursalMantenimientoActivoFijo(Boolean mostrarid_sucursalMantenimientoActivoFijo) {
		this.mostrarid_sucursalMantenimientoActivoFijo= mostrarid_sucursalMantenimientoActivoFijo;
	}

	public Boolean getActivarid_sucursalMantenimientoActivoFijo() {
		return this.activarid_sucursalMantenimientoActivoFijo;
	}

	public void setActivarid_sucursalMantenimientoActivoFijo(Boolean activarid_sucursalMantenimientoActivoFijo) {
		this.activarid_sucursalMantenimientoActivoFijo= activarid_sucursalMantenimientoActivoFijo;
	}

	public Boolean getCargarid_sucursalMantenimientoActivoFijo() {
		return this.cargarid_sucursalMantenimientoActivoFijo;
	}

	public void setCargarid_sucursalMantenimientoActivoFijo(Boolean cargarid_sucursalMantenimientoActivoFijo) {
		this.cargarid_sucursalMantenimientoActivoFijo= cargarid_sucursalMantenimientoActivoFijo;
	}

	public Border setResaltarid_detalle_activo_fijoMantenimientoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*MantenimientoActivoFijoBeanSwingJInternalFrame mantenimientoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//mantenimientoactivofijoBeanSwingJInternalFrame.jTtoolBarMantenimientoActivoFijo.setBorder(borderResaltar);
		
		this.resaltarid_detalle_activo_fijoMantenimientoActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_detalle_activo_fijoMantenimientoActivoFijo() {
		return this.resaltarid_detalle_activo_fijoMantenimientoActivoFijo;
	}

	public void setResaltarid_detalle_activo_fijoMantenimientoActivoFijo(Border borderResaltar) {
		this.resaltarid_detalle_activo_fijoMantenimientoActivoFijo= borderResaltar;
	}

	public Boolean getMostrarid_detalle_activo_fijoMantenimientoActivoFijo() {
		return this.mostrarid_detalle_activo_fijoMantenimientoActivoFijo;
	}

	public void setMostrarid_detalle_activo_fijoMantenimientoActivoFijo(Boolean mostrarid_detalle_activo_fijoMantenimientoActivoFijo) {
		this.mostrarid_detalle_activo_fijoMantenimientoActivoFijo= mostrarid_detalle_activo_fijoMantenimientoActivoFijo;
	}

	public Boolean getActivarid_detalle_activo_fijoMantenimientoActivoFijo() {
		return this.activarid_detalle_activo_fijoMantenimientoActivoFijo;
	}

	public void setActivarid_detalle_activo_fijoMantenimientoActivoFijo(Boolean activarid_detalle_activo_fijoMantenimientoActivoFijo) {
		this.activarid_detalle_activo_fijoMantenimientoActivoFijo= activarid_detalle_activo_fijoMantenimientoActivoFijo;
	}

	public Boolean getCargarid_detalle_activo_fijoMantenimientoActivoFijo() {
		return this.cargarid_detalle_activo_fijoMantenimientoActivoFijo;
	}

	public void setCargarid_detalle_activo_fijoMantenimientoActivoFijo(Boolean cargarid_detalle_activo_fijoMantenimientoActivoFijo) {
		this.cargarid_detalle_activo_fijoMantenimientoActivoFijo= cargarid_detalle_activo_fijoMantenimientoActivoFijo;
	}

	public Border setResaltarid_tipo_movimientoMantenimientoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*MantenimientoActivoFijoBeanSwingJInternalFrame mantenimientoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//mantenimientoactivofijoBeanSwingJInternalFrame.jTtoolBarMantenimientoActivoFijo.setBorder(borderResaltar);
		
		this.resaltarid_tipo_movimientoMantenimientoActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_movimientoMantenimientoActivoFijo() {
		return this.resaltarid_tipo_movimientoMantenimientoActivoFijo;
	}

	public void setResaltarid_tipo_movimientoMantenimientoActivoFijo(Border borderResaltar) {
		this.resaltarid_tipo_movimientoMantenimientoActivoFijo= borderResaltar;
	}

	public Boolean getMostrarid_tipo_movimientoMantenimientoActivoFijo() {
		return this.mostrarid_tipo_movimientoMantenimientoActivoFijo;
	}

	public void setMostrarid_tipo_movimientoMantenimientoActivoFijo(Boolean mostrarid_tipo_movimientoMantenimientoActivoFijo) {
		this.mostrarid_tipo_movimientoMantenimientoActivoFijo= mostrarid_tipo_movimientoMantenimientoActivoFijo;
	}

	public Boolean getActivarid_tipo_movimientoMantenimientoActivoFijo() {
		return this.activarid_tipo_movimientoMantenimientoActivoFijo;
	}

	public void setActivarid_tipo_movimientoMantenimientoActivoFijo(Boolean activarid_tipo_movimientoMantenimientoActivoFijo) {
		this.activarid_tipo_movimientoMantenimientoActivoFijo= activarid_tipo_movimientoMantenimientoActivoFijo;
	}

	public Boolean getCargarid_tipo_movimientoMantenimientoActivoFijo() {
		return this.cargarid_tipo_movimientoMantenimientoActivoFijo;
	}

	public void setCargarid_tipo_movimientoMantenimientoActivoFijo(Boolean cargarid_tipo_movimientoMantenimientoActivoFijo) {
		this.cargarid_tipo_movimientoMantenimientoActivoFijo= cargarid_tipo_movimientoMantenimientoActivoFijo;
	}

	public Border setResaltarnumero_documentoMantenimientoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*MantenimientoActivoFijoBeanSwingJInternalFrame mantenimientoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//mantenimientoactivofijoBeanSwingJInternalFrame.jTtoolBarMantenimientoActivoFijo.setBorder(borderResaltar);
		
		this.resaltarnumero_documentoMantenimientoActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_documentoMantenimientoActivoFijo() {
		return this.resaltarnumero_documentoMantenimientoActivoFijo;
	}

	public void setResaltarnumero_documentoMantenimientoActivoFijo(Border borderResaltar) {
		this.resaltarnumero_documentoMantenimientoActivoFijo= borderResaltar;
	}

	public Boolean getMostrarnumero_documentoMantenimientoActivoFijo() {
		return this.mostrarnumero_documentoMantenimientoActivoFijo;
	}

	public void setMostrarnumero_documentoMantenimientoActivoFijo(Boolean mostrarnumero_documentoMantenimientoActivoFijo) {
		this.mostrarnumero_documentoMantenimientoActivoFijo= mostrarnumero_documentoMantenimientoActivoFijo;
	}

	public Boolean getActivarnumero_documentoMantenimientoActivoFijo() {
		return this.activarnumero_documentoMantenimientoActivoFijo;
	}

	public void setActivarnumero_documentoMantenimientoActivoFijo(Boolean activarnumero_documentoMantenimientoActivoFijo) {
		this.activarnumero_documentoMantenimientoActivoFijo= activarnumero_documentoMantenimientoActivoFijo;
	}

	public Border setResaltarcausaMantenimientoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*MantenimientoActivoFijoBeanSwingJInternalFrame mantenimientoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//mantenimientoactivofijoBeanSwingJInternalFrame.jTtoolBarMantenimientoActivoFijo.setBorder(borderResaltar);
		
		this.resaltarcausaMantenimientoActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcausaMantenimientoActivoFijo() {
		return this.resaltarcausaMantenimientoActivoFijo;
	}

	public void setResaltarcausaMantenimientoActivoFijo(Border borderResaltar) {
		this.resaltarcausaMantenimientoActivoFijo= borderResaltar;
	}

	public Boolean getMostrarcausaMantenimientoActivoFijo() {
		return this.mostrarcausaMantenimientoActivoFijo;
	}

	public void setMostrarcausaMantenimientoActivoFijo(Boolean mostrarcausaMantenimientoActivoFijo) {
		this.mostrarcausaMantenimientoActivoFijo= mostrarcausaMantenimientoActivoFijo;
	}

	public Boolean getActivarcausaMantenimientoActivoFijo() {
		return this.activarcausaMantenimientoActivoFijo;
	}

	public void setActivarcausaMantenimientoActivoFijo(Boolean activarcausaMantenimientoActivoFijo) {
		this.activarcausaMantenimientoActivoFijo= activarcausaMantenimientoActivoFijo;
	}

	public Border setResaltarreferenciaMantenimientoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*MantenimientoActivoFijoBeanSwingJInternalFrame mantenimientoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//mantenimientoactivofijoBeanSwingJInternalFrame.jTtoolBarMantenimientoActivoFijo.setBorder(borderResaltar);
		
		this.resaltarreferenciaMantenimientoActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarreferenciaMantenimientoActivoFijo() {
		return this.resaltarreferenciaMantenimientoActivoFijo;
	}

	public void setResaltarreferenciaMantenimientoActivoFijo(Border borderResaltar) {
		this.resaltarreferenciaMantenimientoActivoFijo= borderResaltar;
	}

	public Boolean getMostrarreferenciaMantenimientoActivoFijo() {
		return this.mostrarreferenciaMantenimientoActivoFijo;
	}

	public void setMostrarreferenciaMantenimientoActivoFijo(Boolean mostrarreferenciaMantenimientoActivoFijo) {
		this.mostrarreferenciaMantenimientoActivoFijo= mostrarreferenciaMantenimientoActivoFijo;
	}

	public Boolean getActivarreferenciaMantenimientoActivoFijo() {
		return this.activarreferenciaMantenimientoActivoFijo;
	}

	public void setActivarreferenciaMantenimientoActivoFijo(Boolean activarreferenciaMantenimientoActivoFijo) {
		this.activarreferenciaMantenimientoActivoFijo= activarreferenciaMantenimientoActivoFijo;
	}

	public Border setResaltartallerMantenimientoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*MantenimientoActivoFijoBeanSwingJInternalFrame mantenimientoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//mantenimientoactivofijoBeanSwingJInternalFrame.jTtoolBarMantenimientoActivoFijo.setBorder(borderResaltar);
		
		this.resaltartallerMantenimientoActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartallerMantenimientoActivoFijo() {
		return this.resaltartallerMantenimientoActivoFijo;
	}

	public void setResaltartallerMantenimientoActivoFijo(Border borderResaltar) {
		this.resaltartallerMantenimientoActivoFijo= borderResaltar;
	}

	public Boolean getMostrartallerMantenimientoActivoFijo() {
		return this.mostrartallerMantenimientoActivoFijo;
	}

	public void setMostrartallerMantenimientoActivoFijo(Boolean mostrartallerMantenimientoActivoFijo) {
		this.mostrartallerMantenimientoActivoFijo= mostrartallerMantenimientoActivoFijo;
	}

	public Boolean getActivartallerMantenimientoActivoFijo() {
		return this.activartallerMantenimientoActivoFijo;
	}

	public void setActivartallerMantenimientoActivoFijo(Boolean activartallerMantenimientoActivoFijo) {
		this.activartallerMantenimientoActivoFijo= activartallerMantenimientoActivoFijo;
	}

	public Border setResaltartelefonoMantenimientoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*MantenimientoActivoFijoBeanSwingJInternalFrame mantenimientoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//mantenimientoactivofijoBeanSwingJInternalFrame.jTtoolBarMantenimientoActivoFijo.setBorder(borderResaltar);
		
		this.resaltartelefonoMantenimientoActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartelefonoMantenimientoActivoFijo() {
		return this.resaltartelefonoMantenimientoActivoFijo;
	}

	public void setResaltartelefonoMantenimientoActivoFijo(Border borderResaltar) {
		this.resaltartelefonoMantenimientoActivoFijo= borderResaltar;
	}

	public Boolean getMostrartelefonoMantenimientoActivoFijo() {
		return this.mostrartelefonoMantenimientoActivoFijo;
	}

	public void setMostrartelefonoMantenimientoActivoFijo(Boolean mostrartelefonoMantenimientoActivoFijo) {
		this.mostrartelefonoMantenimientoActivoFijo= mostrartelefonoMantenimientoActivoFijo;
	}

	public Boolean getActivartelefonoMantenimientoActivoFijo() {
		return this.activartelefonoMantenimientoActivoFijo;
	}

	public void setActivartelefonoMantenimientoActivoFijo(Boolean activartelefonoMantenimientoActivoFijo) {
		this.activartelefonoMantenimientoActivoFijo= activartelefonoMantenimientoActivoFijo;
	}

	public Border setResaltarfecha_inicioMantenimientoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*MantenimientoActivoFijoBeanSwingJInternalFrame mantenimientoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//mantenimientoactivofijoBeanSwingJInternalFrame.jTtoolBarMantenimientoActivoFijo.setBorder(borderResaltar);
		
		this.resaltarfecha_inicioMantenimientoActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_inicioMantenimientoActivoFijo() {
		return this.resaltarfecha_inicioMantenimientoActivoFijo;
	}

	public void setResaltarfecha_inicioMantenimientoActivoFijo(Border borderResaltar) {
		this.resaltarfecha_inicioMantenimientoActivoFijo= borderResaltar;
	}

	public Boolean getMostrarfecha_inicioMantenimientoActivoFijo() {
		return this.mostrarfecha_inicioMantenimientoActivoFijo;
	}

	public void setMostrarfecha_inicioMantenimientoActivoFijo(Boolean mostrarfecha_inicioMantenimientoActivoFijo) {
		this.mostrarfecha_inicioMantenimientoActivoFijo= mostrarfecha_inicioMantenimientoActivoFijo;
	}

	public Boolean getActivarfecha_inicioMantenimientoActivoFijo() {
		return this.activarfecha_inicioMantenimientoActivoFijo;
	}

	public void setActivarfecha_inicioMantenimientoActivoFijo(Boolean activarfecha_inicioMantenimientoActivoFijo) {
		this.activarfecha_inicioMantenimientoActivoFijo= activarfecha_inicioMantenimientoActivoFijo;
	}

	public Border setResaltarfecha_entregaMantenimientoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*MantenimientoActivoFijoBeanSwingJInternalFrame mantenimientoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//mantenimientoactivofijoBeanSwingJInternalFrame.jTtoolBarMantenimientoActivoFijo.setBorder(borderResaltar);
		
		this.resaltarfecha_entregaMantenimientoActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_entregaMantenimientoActivoFijo() {
		return this.resaltarfecha_entregaMantenimientoActivoFijo;
	}

	public void setResaltarfecha_entregaMantenimientoActivoFijo(Border borderResaltar) {
		this.resaltarfecha_entregaMantenimientoActivoFijo= borderResaltar;
	}

	public Boolean getMostrarfecha_entregaMantenimientoActivoFijo() {
		return this.mostrarfecha_entregaMantenimientoActivoFijo;
	}

	public void setMostrarfecha_entregaMantenimientoActivoFijo(Boolean mostrarfecha_entregaMantenimientoActivoFijo) {
		this.mostrarfecha_entregaMantenimientoActivoFijo= mostrarfecha_entregaMantenimientoActivoFijo;
	}

	public Boolean getActivarfecha_entregaMantenimientoActivoFijo() {
		return this.activarfecha_entregaMantenimientoActivoFijo;
	}

	public void setActivarfecha_entregaMantenimientoActivoFijo(Boolean activarfecha_entregaMantenimientoActivoFijo) {
		this.activarfecha_entregaMantenimientoActivoFijo= activarfecha_entregaMantenimientoActivoFijo;
	}

	public Border setResaltarcostoMantenimientoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*MantenimientoActivoFijoBeanSwingJInternalFrame mantenimientoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//mantenimientoactivofijoBeanSwingJInternalFrame.jTtoolBarMantenimientoActivoFijo.setBorder(borderResaltar);
		
		this.resaltarcostoMantenimientoActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcostoMantenimientoActivoFijo() {
		return this.resaltarcostoMantenimientoActivoFijo;
	}

	public void setResaltarcostoMantenimientoActivoFijo(Border borderResaltar) {
		this.resaltarcostoMantenimientoActivoFijo= borderResaltar;
	}

	public Boolean getMostrarcostoMantenimientoActivoFijo() {
		return this.mostrarcostoMantenimientoActivoFijo;
	}

	public void setMostrarcostoMantenimientoActivoFijo(Boolean mostrarcostoMantenimientoActivoFijo) {
		this.mostrarcostoMantenimientoActivoFijo= mostrarcostoMantenimientoActivoFijo;
	}

	public Boolean getActivarcostoMantenimientoActivoFijo() {
		return this.activarcostoMantenimientoActivoFijo;
	}

	public void setActivarcostoMantenimientoActivoFijo(Boolean activarcostoMantenimientoActivoFijo) {
		this.activarcostoMantenimientoActivoFijo= activarcostoMantenimientoActivoFijo;
	}

	public Border setResaltarresponsableMantenimientoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*MantenimientoActivoFijoBeanSwingJInternalFrame mantenimientoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//mantenimientoactivofijoBeanSwingJInternalFrame.jTtoolBarMantenimientoActivoFijo.setBorder(borderResaltar);
		
		this.resaltarresponsableMantenimientoActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarresponsableMantenimientoActivoFijo() {
		return this.resaltarresponsableMantenimientoActivoFijo;
	}

	public void setResaltarresponsableMantenimientoActivoFijo(Border borderResaltar) {
		this.resaltarresponsableMantenimientoActivoFijo= borderResaltar;
	}

	public Boolean getMostrarresponsableMantenimientoActivoFijo() {
		return this.mostrarresponsableMantenimientoActivoFijo;
	}

	public void setMostrarresponsableMantenimientoActivoFijo(Boolean mostrarresponsableMantenimientoActivoFijo) {
		this.mostrarresponsableMantenimientoActivoFijo= mostrarresponsableMantenimientoActivoFijo;
	}

	public Boolean getActivarresponsableMantenimientoActivoFijo() {
		return this.activarresponsableMantenimientoActivoFijo;
	}

	public void setActivarresponsableMantenimientoActivoFijo(Boolean activarresponsableMantenimientoActivoFijo) {
		this.activarresponsableMantenimientoActivoFijo= activarresponsableMantenimientoActivoFijo;
	}

	public Border setResaltarobservacionMantenimientoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*MantenimientoActivoFijoBeanSwingJInternalFrame mantenimientoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//mantenimientoactivofijoBeanSwingJInternalFrame.jTtoolBarMantenimientoActivoFijo.setBorder(borderResaltar);
		
		this.resaltarobservacionMantenimientoActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarobservacionMantenimientoActivoFijo() {
		return this.resaltarobservacionMantenimientoActivoFijo;
	}

	public void setResaltarobservacionMantenimientoActivoFijo(Border borderResaltar) {
		this.resaltarobservacionMantenimientoActivoFijo= borderResaltar;
	}

	public Boolean getMostrarobservacionMantenimientoActivoFijo() {
		return this.mostrarobservacionMantenimientoActivoFijo;
	}

	public void setMostrarobservacionMantenimientoActivoFijo(Boolean mostrarobservacionMantenimientoActivoFijo) {
		this.mostrarobservacionMantenimientoActivoFijo= mostrarobservacionMantenimientoActivoFijo;
	}

	public Boolean getActivarobservacionMantenimientoActivoFijo() {
		return this.activarobservacionMantenimientoActivoFijo;
	}

	public void setActivarobservacionMantenimientoActivoFijo(Boolean activarobservacionMantenimientoActivoFijo) {
		this.activarobservacionMantenimientoActivoFijo= activarobservacionMantenimientoActivoFijo;
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
		
		
		this.setMostraridMantenimientoActivoFijo(esInicial);
		this.setMostrarid_empresaMantenimientoActivoFijo(esInicial);
		this.setMostrarid_sucursalMantenimientoActivoFijo(esInicial);
		this.setMostrarid_detalle_activo_fijoMantenimientoActivoFijo(esInicial);
		this.setMostrarid_tipo_movimientoMantenimientoActivoFijo(esInicial);
		this.setMostrarnumero_documentoMantenimientoActivoFijo(esInicial);
		this.setMostrarcausaMantenimientoActivoFijo(esInicial);
		this.setMostrarreferenciaMantenimientoActivoFijo(esInicial);
		this.setMostrartallerMantenimientoActivoFijo(esInicial);
		this.setMostrartelefonoMantenimientoActivoFijo(esInicial);
		this.setMostrarfecha_inicioMantenimientoActivoFijo(esInicial);
		this.setMostrarfecha_entregaMantenimientoActivoFijo(esInicial);
		this.setMostrarcostoMantenimientoActivoFijo(esInicial);
		this.setMostrarresponsableMantenimientoActivoFijo(esInicial);
		this.setMostrarobservacionMantenimientoActivoFijo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(MantenimientoActivoFijoConstantesFunciones.ID)) {
				this.setMostraridMantenimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoActivoFijoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaMantenimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoActivoFijoConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalMantenimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoActivoFijoConstantesFunciones.IDDETALLEACTIVOFIJO)) {
				this.setMostrarid_detalle_activo_fijoMantenimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoActivoFijoConstantesFunciones.IDTIPOMOVIMIENTO)) {
				this.setMostrarid_tipo_movimientoMantenimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoActivoFijoConstantesFunciones.NUMERODOCUMENTO)) {
				this.setMostrarnumero_documentoMantenimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoActivoFijoConstantesFunciones.CAUSA)) {
				this.setMostrarcausaMantenimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoActivoFijoConstantesFunciones.REFERENCIA)) {
				this.setMostrarreferenciaMantenimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoActivoFijoConstantesFunciones.TALLER)) {
				this.setMostrartallerMantenimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoActivoFijoConstantesFunciones.TELEFONO)) {
				this.setMostrartelefonoMantenimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoActivoFijoConstantesFunciones.FECHAINICIO)) {
				this.setMostrarfecha_inicioMantenimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoActivoFijoConstantesFunciones.FECHAENTREGA)) {
				this.setMostrarfecha_entregaMantenimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoActivoFijoConstantesFunciones.COSTO)) {
				this.setMostrarcostoMantenimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoActivoFijoConstantesFunciones.RESPONSABLE)) {
				this.setMostrarresponsableMantenimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoActivoFijoConstantesFunciones.OBSERVACION)) {
				this.setMostrarobservacionMantenimientoActivoFijo(esAsigna);
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
		
		
		this.setActivaridMantenimientoActivoFijo(esInicial);
		this.setActivarid_empresaMantenimientoActivoFijo(esInicial);
		this.setActivarid_sucursalMantenimientoActivoFijo(esInicial);
		this.setActivarid_detalle_activo_fijoMantenimientoActivoFijo(esInicial);
		this.setActivarid_tipo_movimientoMantenimientoActivoFijo(esInicial);
		this.setActivarnumero_documentoMantenimientoActivoFijo(esInicial);
		this.setActivarcausaMantenimientoActivoFijo(esInicial);
		this.setActivarreferenciaMantenimientoActivoFijo(esInicial);
		this.setActivartallerMantenimientoActivoFijo(esInicial);
		this.setActivartelefonoMantenimientoActivoFijo(esInicial);
		this.setActivarfecha_inicioMantenimientoActivoFijo(esInicial);
		this.setActivarfecha_entregaMantenimientoActivoFijo(esInicial);
		this.setActivarcostoMantenimientoActivoFijo(esInicial);
		this.setActivarresponsableMantenimientoActivoFijo(esInicial);
		this.setActivarobservacionMantenimientoActivoFijo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(MantenimientoActivoFijoConstantesFunciones.ID)) {
				this.setActivaridMantenimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoActivoFijoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaMantenimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoActivoFijoConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalMantenimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoActivoFijoConstantesFunciones.IDDETALLEACTIVOFIJO)) {
				this.setActivarid_detalle_activo_fijoMantenimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoActivoFijoConstantesFunciones.IDTIPOMOVIMIENTO)) {
				this.setActivarid_tipo_movimientoMantenimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoActivoFijoConstantesFunciones.NUMERODOCUMENTO)) {
				this.setActivarnumero_documentoMantenimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoActivoFijoConstantesFunciones.CAUSA)) {
				this.setActivarcausaMantenimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoActivoFijoConstantesFunciones.REFERENCIA)) {
				this.setActivarreferenciaMantenimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoActivoFijoConstantesFunciones.TALLER)) {
				this.setActivartallerMantenimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoActivoFijoConstantesFunciones.TELEFONO)) {
				this.setActivartelefonoMantenimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoActivoFijoConstantesFunciones.FECHAINICIO)) {
				this.setActivarfecha_inicioMantenimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoActivoFijoConstantesFunciones.FECHAENTREGA)) {
				this.setActivarfecha_entregaMantenimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoActivoFijoConstantesFunciones.COSTO)) {
				this.setActivarcostoMantenimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoActivoFijoConstantesFunciones.RESPONSABLE)) {
				this.setActivarresponsableMantenimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoActivoFijoConstantesFunciones.OBSERVACION)) {
				this.setActivarobservacionMantenimientoActivoFijo(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,MantenimientoActivoFijoBeanSwingJInternalFrame mantenimientoactivofijoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridMantenimientoActivoFijo(esInicial);
		this.setResaltarid_empresaMantenimientoActivoFijo(esInicial);
		this.setResaltarid_sucursalMantenimientoActivoFijo(esInicial);
		this.setResaltarid_detalle_activo_fijoMantenimientoActivoFijo(esInicial);
		this.setResaltarid_tipo_movimientoMantenimientoActivoFijo(esInicial);
		this.setResaltarnumero_documentoMantenimientoActivoFijo(esInicial);
		this.setResaltarcausaMantenimientoActivoFijo(esInicial);
		this.setResaltarreferenciaMantenimientoActivoFijo(esInicial);
		this.setResaltartallerMantenimientoActivoFijo(esInicial);
		this.setResaltartelefonoMantenimientoActivoFijo(esInicial);
		this.setResaltarfecha_inicioMantenimientoActivoFijo(esInicial);
		this.setResaltarfecha_entregaMantenimientoActivoFijo(esInicial);
		this.setResaltarcostoMantenimientoActivoFijo(esInicial);
		this.setResaltarresponsableMantenimientoActivoFijo(esInicial);
		this.setResaltarobservacionMantenimientoActivoFijo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(MantenimientoActivoFijoConstantesFunciones.ID)) {
				this.setResaltaridMantenimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoActivoFijoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaMantenimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoActivoFijoConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalMantenimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoActivoFijoConstantesFunciones.IDDETALLEACTIVOFIJO)) {
				this.setResaltarid_detalle_activo_fijoMantenimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoActivoFijoConstantesFunciones.IDTIPOMOVIMIENTO)) {
				this.setResaltarid_tipo_movimientoMantenimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoActivoFijoConstantesFunciones.NUMERODOCUMENTO)) {
				this.setResaltarnumero_documentoMantenimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoActivoFijoConstantesFunciones.CAUSA)) {
				this.setResaltarcausaMantenimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoActivoFijoConstantesFunciones.REFERENCIA)) {
				this.setResaltarreferenciaMantenimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoActivoFijoConstantesFunciones.TALLER)) {
				this.setResaltartallerMantenimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoActivoFijoConstantesFunciones.TELEFONO)) {
				this.setResaltartelefonoMantenimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoActivoFijoConstantesFunciones.FECHAINICIO)) {
				this.setResaltarfecha_inicioMantenimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoActivoFijoConstantesFunciones.FECHAENTREGA)) {
				this.setResaltarfecha_entregaMantenimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoActivoFijoConstantesFunciones.COSTO)) {
				this.setResaltarcostoMantenimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoActivoFijoConstantesFunciones.RESPONSABLE)) {
				this.setResaltarresponsableMantenimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MantenimientoActivoFijoConstantesFunciones.OBSERVACION)) {
				this.setResaltarobservacionMantenimientoActivoFijo(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,MantenimientoActivoFijoBeanSwingJInternalFrame mantenimientoactivofijoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdDetalleActivoFijoMantenimientoActivoFijo=true;

	public Boolean getMostrarFK_IdDetalleActivoFijoMantenimientoActivoFijo() {
		return this.mostrarFK_IdDetalleActivoFijoMantenimientoActivoFijo;
	}

	public void setMostrarFK_IdDetalleActivoFijoMantenimientoActivoFijo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdDetalleActivoFijoMantenimientoActivoFijo= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaMantenimientoActivoFijo=true;

	public Boolean getMostrarFK_IdEmpresaMantenimientoActivoFijo() {
		return this.mostrarFK_IdEmpresaMantenimientoActivoFijo;
	}

	public void setMostrarFK_IdEmpresaMantenimientoActivoFijo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaMantenimientoActivoFijo= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalMantenimientoActivoFijo=true;

	public Boolean getMostrarFK_IdSucursalMantenimientoActivoFijo() {
		return this.mostrarFK_IdSucursalMantenimientoActivoFijo;
	}

	public void setMostrarFK_IdSucursalMantenimientoActivoFijo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalMantenimientoActivoFijo= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoMovimientoMantenimientoActivoFijo=true;

	public Boolean getMostrarFK_IdTipoMovimientoMantenimientoActivoFijo() {
		return this.mostrarFK_IdTipoMovimientoMantenimientoActivoFijo;
	}

	public void setMostrarFK_IdTipoMovimientoMantenimientoActivoFijo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoMovimientoMantenimientoActivoFijo= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdDetalleActivoFijoMantenimientoActivoFijo=true;

	public Boolean getActivarFK_IdDetalleActivoFijoMantenimientoActivoFijo() {
		return this.activarFK_IdDetalleActivoFijoMantenimientoActivoFijo;
	}

	public void setActivarFK_IdDetalleActivoFijoMantenimientoActivoFijo(Boolean habilitarResaltar) {
		this.activarFK_IdDetalleActivoFijoMantenimientoActivoFijo= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaMantenimientoActivoFijo=true;

	public Boolean getActivarFK_IdEmpresaMantenimientoActivoFijo() {
		return this.activarFK_IdEmpresaMantenimientoActivoFijo;
	}

	public void setActivarFK_IdEmpresaMantenimientoActivoFijo(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaMantenimientoActivoFijo= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalMantenimientoActivoFijo=true;

	public Boolean getActivarFK_IdSucursalMantenimientoActivoFijo() {
		return this.activarFK_IdSucursalMantenimientoActivoFijo;
	}

	public void setActivarFK_IdSucursalMantenimientoActivoFijo(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalMantenimientoActivoFijo= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoMovimientoMantenimientoActivoFijo=true;

	public Boolean getActivarFK_IdTipoMovimientoMantenimientoActivoFijo() {
		return this.activarFK_IdTipoMovimientoMantenimientoActivoFijo;
	}

	public void setActivarFK_IdTipoMovimientoMantenimientoActivoFijo(Boolean habilitarResaltar) {
		this.activarFK_IdTipoMovimientoMantenimientoActivoFijo= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdDetalleActivoFijoMantenimientoActivoFijo=null;

	public Border getResaltarFK_IdDetalleActivoFijoMantenimientoActivoFijo() {
		return this.resaltarFK_IdDetalleActivoFijoMantenimientoActivoFijo;
	}

	public void setResaltarFK_IdDetalleActivoFijoMantenimientoActivoFijo(Border borderResaltar) {
		this.resaltarFK_IdDetalleActivoFijoMantenimientoActivoFijo= borderResaltar;
	}

	public void setResaltarFK_IdDetalleActivoFijoMantenimientoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*MantenimientoActivoFijoBeanSwingJInternalFrame mantenimientoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdDetalleActivoFijoMantenimientoActivoFijo= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaMantenimientoActivoFijo=null;

	public Border getResaltarFK_IdEmpresaMantenimientoActivoFijo() {
		return this.resaltarFK_IdEmpresaMantenimientoActivoFijo;
	}

	public void setResaltarFK_IdEmpresaMantenimientoActivoFijo(Border borderResaltar) {
		this.resaltarFK_IdEmpresaMantenimientoActivoFijo= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaMantenimientoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*MantenimientoActivoFijoBeanSwingJInternalFrame mantenimientoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaMantenimientoActivoFijo= borderResaltar;
	}

	public Border resaltarFK_IdSucursalMantenimientoActivoFijo=null;

	public Border getResaltarFK_IdSucursalMantenimientoActivoFijo() {
		return this.resaltarFK_IdSucursalMantenimientoActivoFijo;
	}

	public void setResaltarFK_IdSucursalMantenimientoActivoFijo(Border borderResaltar) {
		this.resaltarFK_IdSucursalMantenimientoActivoFijo= borderResaltar;
	}

	public void setResaltarFK_IdSucursalMantenimientoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*MantenimientoActivoFijoBeanSwingJInternalFrame mantenimientoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalMantenimientoActivoFijo= borderResaltar;
	}

	public Border resaltarFK_IdTipoMovimientoMantenimientoActivoFijo=null;

	public Border getResaltarFK_IdTipoMovimientoMantenimientoActivoFijo() {
		return this.resaltarFK_IdTipoMovimientoMantenimientoActivoFijo;
	}

	public void setResaltarFK_IdTipoMovimientoMantenimientoActivoFijo(Border borderResaltar) {
		this.resaltarFK_IdTipoMovimientoMantenimientoActivoFijo= borderResaltar;
	}

	public void setResaltarFK_IdTipoMovimientoMantenimientoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*MantenimientoActivoFijoBeanSwingJInternalFrame mantenimientoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoMovimientoMantenimientoActivoFijo= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}