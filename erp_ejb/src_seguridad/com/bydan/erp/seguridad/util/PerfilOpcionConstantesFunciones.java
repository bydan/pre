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
package com.bydan.erp.seguridad.util;

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


import com.bydan.erp.seguridad.util.PerfilOpcionConstantesFunciones;
import com.bydan.erp.seguridad.util.PerfilOpcionParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.PerfilOpcionParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.seguridad.business.entity.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.seguridad.business.dataaccess.*;
//import com.bydan.erp.seguridad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class PerfilOpcionConstantesFunciones extends PerfilOpcionConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="PerfilOpcion";
	public static final String SPATHOPCION="Seguridad";	
	public static final String SPATHMODULO="seguridad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="PerfilOpcion"+PerfilOpcionConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="PerfilOpcionHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="PerfilOpcionHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=PerfilOpcionConstantesFunciones.SCHEMA+"_"+PerfilOpcionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/PerfilOpcionHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=PerfilOpcionConstantesFunciones.SCHEMA+"_"+PerfilOpcionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=PerfilOpcionConstantesFunciones.SCHEMA+"_"+PerfilOpcionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/PerfilOpcionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=PerfilOpcionConstantesFunciones.SCHEMA+"_"+PerfilOpcionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PerfilOpcionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PerfilOpcionHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PerfilOpcionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PerfilOpcionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PerfilOpcionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PerfilOpcionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=PerfilOpcionConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+PerfilOpcionConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=PerfilOpcionConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+PerfilOpcionConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Perfil Opciones";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Perfil Opcion";
	public static final String SCLASSWEBTITULO_LOWER="Perfil Opcion";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="PerfilOpcion";
	public static final String OBJECTNAME="perfilopcion";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SEGURIDAD;	
	public static final String TABLENAME="perfil_opcion";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select perfilopcion from "+PerfilOpcionConstantesFunciones.SPERSISTENCENAME+" perfilopcion";
	public static String QUERYSELECTNATIVE="select "+PerfilOpcionConstantesFunciones.SCHEMA+"."+PerfilOpcionConstantesFunciones.TABLENAME+".id,"+PerfilOpcionConstantesFunciones.SCHEMA+"."+PerfilOpcionConstantesFunciones.TABLENAME+".version_row,"+PerfilOpcionConstantesFunciones.SCHEMA+"."+PerfilOpcionConstantesFunciones.TABLENAME+".id_sistema,"+PerfilOpcionConstantesFunciones.SCHEMA+"."+PerfilOpcionConstantesFunciones.TABLENAME+".id_modulo,"+PerfilOpcionConstantesFunciones.SCHEMA+"."+PerfilOpcionConstantesFunciones.TABLENAME+".id_grupo_opcion,"+PerfilOpcionConstantesFunciones.SCHEMA+"."+PerfilOpcionConstantesFunciones.TABLENAME+".id_perfil,"+PerfilOpcionConstantesFunciones.SCHEMA+"."+PerfilOpcionConstantesFunciones.TABLENAME+".id_opcion,"+PerfilOpcionConstantesFunciones.SCHEMA+"."+PerfilOpcionConstantesFunciones.TABLENAME+".todo,"+PerfilOpcionConstantesFunciones.SCHEMA+"."+PerfilOpcionConstantesFunciones.TABLENAME+".ingreso,"+PerfilOpcionConstantesFunciones.SCHEMA+"."+PerfilOpcionConstantesFunciones.TABLENAME+".modificacion,"+PerfilOpcionConstantesFunciones.SCHEMA+"."+PerfilOpcionConstantesFunciones.TABLENAME+".eliminacion,"+PerfilOpcionConstantesFunciones.SCHEMA+"."+PerfilOpcionConstantesFunciones.TABLENAME+".guardar_cambios,"+PerfilOpcionConstantesFunciones.SCHEMA+"."+PerfilOpcionConstantesFunciones.TABLENAME+".consulta,"+PerfilOpcionConstantesFunciones.SCHEMA+"."+PerfilOpcionConstantesFunciones.TABLENAME+".busqueda,"+PerfilOpcionConstantesFunciones.SCHEMA+"."+PerfilOpcionConstantesFunciones.TABLENAME+".reporte,"+PerfilOpcionConstantesFunciones.SCHEMA+"."+PerfilOpcionConstantesFunciones.TABLENAME+".orden,"+PerfilOpcionConstantesFunciones.SCHEMA+"."+PerfilOpcionConstantesFunciones.TABLENAME+".paginacion_medio,"+PerfilOpcionConstantesFunciones.SCHEMA+"."+PerfilOpcionConstantesFunciones.TABLENAME+".paginacion_alto,"+PerfilOpcionConstantesFunciones.SCHEMA+"."+PerfilOpcionConstantesFunciones.TABLENAME+".paginacion_todo,"+PerfilOpcionConstantesFunciones.SCHEMA+"."+PerfilOpcionConstantesFunciones.TABLENAME+".duplicar,"+PerfilOpcionConstantesFunciones.SCHEMA+"."+PerfilOpcionConstantesFunciones.TABLENAME+".copiar,"+PerfilOpcionConstantesFunciones.SCHEMA+"."+PerfilOpcionConstantesFunciones.TABLENAME+".con_precargar,"+PerfilOpcionConstantesFunciones.SCHEMA+"."+PerfilOpcionConstantesFunciones.TABLENAME+".estado from "+PerfilOpcionConstantesFunciones.SCHEMA+"."+PerfilOpcionConstantesFunciones.TABLENAME;//+" as "+PerfilOpcionConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=true;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected PerfilOpcionConstantesFuncionesAdditional perfilopcionConstantesFuncionesAdditional=null;
	
	public PerfilOpcionConstantesFuncionesAdditional getPerfilOpcionConstantesFuncionesAdditional() {
		return this.perfilopcionConstantesFuncionesAdditional;
	}
	
	public void setPerfilOpcionConstantesFuncionesAdditional(PerfilOpcionConstantesFuncionesAdditional perfilopcionConstantesFuncionesAdditional) {
		try {
			this.perfilopcionConstantesFuncionesAdditional=perfilopcionConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDSISTEMA= "id_sistema";
    public static final String IDMODULO= "id_modulo";
    public static final String IDGRUPOOPCION= "id_grupo_opcion";
    public static final String IDPERFIL= "id_perfil";
    public static final String IDOPCION= "id_opcion";
    public static final String TODO= "todo";
    public static final String INGRESO= "ingreso";
    public static final String MODIFICACION= "modificacion";
    public static final String ELIMINACION= "eliminacion";
    public static final String GUARDARCAMBIOS= "guardar_cambios";
    public static final String CONSULTA= "consulta";
    public static final String BUSQUEDA= "busqueda";
    public static final String REPORTE= "reporte";
    public static final String ORDEN= "orden";
    public static final String PAGINACIONMEDIO= "paginacion_medio";
    public static final String PAGINACIONALTO= "paginacion_alto";
    public static final String PAGINACIONTODO= "paginacion_todo";
    public static final String DUPLICAR= "duplicar";
    public static final String COPIAR= "copiar";
    public static final String CONPRECARGAR= "con_precargar";
    public static final String ESTADO= "estado";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "A";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDSISTEMA= "Sistema";
		public static final String LABEL_IDSISTEMA_LOWER= "Sistema";
    	public static final String LABEL_IDMODULO= "Modulo";
		public static final String LABEL_IDMODULO_LOWER= "Modulo";
    	public static final String LABEL_IDGRUPOOPCION= "Grupo Opcion";
		public static final String LABEL_IDGRUPOOPCION_LOWER= "Grupo Opcion";
    	public static final String LABEL_IDPERFIL= "Perfil";
		public static final String LABEL_IDPERFIL_LOWER= "Perfil";
    	public static final String LABEL_IDOPCION= "Opcion";
		public static final String LABEL_IDOPCION_LOWER= "Opcion";
    	public static final String LABEL_TODO= "Todo";
		public static final String LABEL_TODO_LOWER= "Todo";
    	public static final String LABEL_INGRESO= "Ingreso";
		public static final String LABEL_INGRESO_LOWER= "Ingreso";
    	public static final String LABEL_MODIFICACION= "Modificacion";
		public static final String LABEL_MODIFICACION_LOWER= "Modificacion";
    	public static final String LABEL_ELIMINACION= "Eliminacion";
		public static final String LABEL_ELIMINACION_LOWER= "Eliminacion";
    	public static final String LABEL_GUARDARCAMBIOS= "Guardar Cambios";
		public static final String LABEL_GUARDARCAMBIOS_LOWER= "Guardar Cambios";
    	public static final String LABEL_CONSULTA= "Consulta";
		public static final String LABEL_CONSULTA_LOWER= "Consulta";
    	public static final String LABEL_BUSQUEDA= "Busqueda";
		public static final String LABEL_BUSQUEDA_LOWER= "Busqueda";
    	public static final String LABEL_REPORTE= "Reporte";
		public static final String LABEL_REPORTE_LOWER= "Reporte";
    	public static final String LABEL_ORDEN= "Orden";
		public static final String LABEL_ORDEN_LOWER= "Orden";
    	public static final String LABEL_PAGINACIONMEDIO= "Paginacion Medio";
		public static final String LABEL_PAGINACIONMEDIO_LOWER= "Paginacion Medio";
    	public static final String LABEL_PAGINACIONALTO= "Paginacion Alto";
		public static final String LABEL_PAGINACIONALTO_LOWER= "Paginacion Alto";
    	public static final String LABEL_PAGINACIONTODO= "Paginacion Todo";
		public static final String LABEL_PAGINACIONTODO_LOWER= "Paginacion Todo";
    	public static final String LABEL_DUPLICAR= "Duplicar";
		public static final String LABEL_DUPLICAR_LOWER= "Duplicar";
    	public static final String LABEL_COPIAR= "Copiar";
		public static final String LABEL_COPIAR_LOWER= "Copiar";
    	public static final String LABEL_CONPRECARGAR= "Precargar";
		public static final String LABEL_CONPRECARGAR_LOWER= "Con Precargar";
    	public static final String LABEL_ESTADO= "Estado";
		public static final String LABEL_ESTADO_LOWER= "Estado";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	public static String getPerfilOpcionLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(PerfilOpcionConstantesFunciones.IDSISTEMA)) {sLabelColumna=PerfilOpcionConstantesFunciones.LABEL_IDSISTEMA;}
		if(sNombreColumna.equals(PerfilOpcionConstantesFunciones.IDMODULO)) {sLabelColumna=PerfilOpcionConstantesFunciones.LABEL_IDMODULO;}
		if(sNombreColumna.equals(PerfilOpcionConstantesFunciones.IDGRUPOOPCION)) {sLabelColumna=PerfilOpcionConstantesFunciones.LABEL_IDGRUPOOPCION;}
		if(sNombreColumna.equals(PerfilOpcionConstantesFunciones.IDPERFIL)) {sLabelColumna=PerfilOpcionConstantesFunciones.LABEL_IDPERFIL;}
		if(sNombreColumna.equals(PerfilOpcionConstantesFunciones.IDOPCION)) {sLabelColumna=PerfilOpcionConstantesFunciones.LABEL_IDOPCION;}
		if(sNombreColumna.equals(PerfilOpcionConstantesFunciones.TODO)) {sLabelColumna=PerfilOpcionConstantesFunciones.LABEL_TODO;}
		if(sNombreColumna.equals(PerfilOpcionConstantesFunciones.INGRESO)) {sLabelColumna=PerfilOpcionConstantesFunciones.LABEL_INGRESO;}
		if(sNombreColumna.equals(PerfilOpcionConstantesFunciones.MODIFICACION)) {sLabelColumna=PerfilOpcionConstantesFunciones.LABEL_MODIFICACION;}
		if(sNombreColumna.equals(PerfilOpcionConstantesFunciones.ELIMINACION)) {sLabelColumna=PerfilOpcionConstantesFunciones.LABEL_ELIMINACION;}
		if(sNombreColumna.equals(PerfilOpcionConstantesFunciones.GUARDARCAMBIOS)) {sLabelColumna=PerfilOpcionConstantesFunciones.LABEL_GUARDARCAMBIOS;}
		if(sNombreColumna.equals(PerfilOpcionConstantesFunciones.CONSULTA)) {sLabelColumna=PerfilOpcionConstantesFunciones.LABEL_CONSULTA;}
		if(sNombreColumna.equals(PerfilOpcionConstantesFunciones.BUSQUEDA)) {sLabelColumna=PerfilOpcionConstantesFunciones.LABEL_BUSQUEDA;}
		if(sNombreColumna.equals(PerfilOpcionConstantesFunciones.REPORTE)) {sLabelColumna=PerfilOpcionConstantesFunciones.LABEL_REPORTE;}
		if(sNombreColumna.equals(PerfilOpcionConstantesFunciones.ORDEN)) {sLabelColumna=PerfilOpcionConstantesFunciones.LABEL_ORDEN;}
		if(sNombreColumna.equals(PerfilOpcionConstantesFunciones.PAGINACIONMEDIO)) {sLabelColumna=PerfilOpcionConstantesFunciones.LABEL_PAGINACIONMEDIO;}
		if(sNombreColumna.equals(PerfilOpcionConstantesFunciones.PAGINACIONALTO)) {sLabelColumna=PerfilOpcionConstantesFunciones.LABEL_PAGINACIONALTO;}
		if(sNombreColumna.equals(PerfilOpcionConstantesFunciones.PAGINACIONTODO)) {sLabelColumna=PerfilOpcionConstantesFunciones.LABEL_PAGINACIONTODO;}
		if(sNombreColumna.equals(PerfilOpcionConstantesFunciones.DUPLICAR)) {sLabelColumna=PerfilOpcionConstantesFunciones.LABEL_DUPLICAR;}
		if(sNombreColumna.equals(PerfilOpcionConstantesFunciones.COPIAR)) {sLabelColumna=PerfilOpcionConstantesFunciones.LABEL_COPIAR;}
		if(sNombreColumna.equals(PerfilOpcionConstantesFunciones.CONPRECARGAR)) {sLabelColumna=PerfilOpcionConstantesFunciones.LABEL_CONPRECARGAR;}
		if(sNombreColumna.equals(PerfilOpcionConstantesFunciones.ESTADO)) {sLabelColumna=PerfilOpcionConstantesFunciones.LABEL_ESTADO;}
		
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
	
	
	
			
			
			
			
			
			
			
		
	public static String gettodoDescripcion(PerfilOpcion perfilopcion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!perfilopcion.gettodo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String gettodoHtmlDescripcion(PerfilOpcion perfilopcion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(perfilopcion.getId(),perfilopcion.gettodo());

		return sDescripcion;
	}	
		
	public static String getingresoDescripcion(PerfilOpcion perfilopcion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!perfilopcion.getingreso()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getingresoHtmlDescripcion(PerfilOpcion perfilopcion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(perfilopcion.getId(),perfilopcion.getingreso());

		return sDescripcion;
	}	
		
	public static String getmodificacionDescripcion(PerfilOpcion perfilopcion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!perfilopcion.getmodificacion()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getmodificacionHtmlDescripcion(PerfilOpcion perfilopcion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(perfilopcion.getId(),perfilopcion.getmodificacion());

		return sDescripcion;
	}	
		
	public static String geteliminacionDescripcion(PerfilOpcion perfilopcion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!perfilopcion.geteliminacion()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String geteliminacionHtmlDescripcion(PerfilOpcion perfilopcion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(perfilopcion.getId(),perfilopcion.geteliminacion());

		return sDescripcion;
	}	
		
	public static String getguardar_cambiosDescripcion(PerfilOpcion perfilopcion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!perfilopcion.getguardar_cambios()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getguardar_cambiosHtmlDescripcion(PerfilOpcion perfilopcion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(perfilopcion.getId(),perfilopcion.getguardar_cambios());

		return sDescripcion;
	}	
		
	public static String getconsultaDescripcion(PerfilOpcion perfilopcion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!perfilopcion.getconsulta()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getconsultaHtmlDescripcion(PerfilOpcion perfilopcion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(perfilopcion.getId(),perfilopcion.getconsulta());

		return sDescripcion;
	}	
		
	public static String getbusquedaDescripcion(PerfilOpcion perfilopcion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!perfilopcion.getbusqueda()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getbusquedaHtmlDescripcion(PerfilOpcion perfilopcion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(perfilopcion.getId(),perfilopcion.getbusqueda());

		return sDescripcion;
	}	
		
	public static String getreporteDescripcion(PerfilOpcion perfilopcion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!perfilopcion.getreporte()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getreporteHtmlDescripcion(PerfilOpcion perfilopcion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(perfilopcion.getId(),perfilopcion.getreporte());

		return sDescripcion;
	}	
		
	public static String getordenDescripcion(PerfilOpcion perfilopcion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!perfilopcion.getorden()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getordenHtmlDescripcion(PerfilOpcion perfilopcion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(perfilopcion.getId(),perfilopcion.getorden());

		return sDescripcion;
	}	
		
	public static String getpaginacion_medioDescripcion(PerfilOpcion perfilopcion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!perfilopcion.getpaginacion_medio()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getpaginacion_medioHtmlDescripcion(PerfilOpcion perfilopcion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(perfilopcion.getId(),perfilopcion.getpaginacion_medio());

		return sDescripcion;
	}	
		
	public static String getpaginacion_altoDescripcion(PerfilOpcion perfilopcion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!perfilopcion.getpaginacion_alto()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getpaginacion_altoHtmlDescripcion(PerfilOpcion perfilopcion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(perfilopcion.getId(),perfilopcion.getpaginacion_alto());

		return sDescripcion;
	}	
		
	public static String getpaginacion_todoDescripcion(PerfilOpcion perfilopcion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!perfilopcion.getpaginacion_todo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getpaginacion_todoHtmlDescripcion(PerfilOpcion perfilopcion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(perfilopcion.getId(),perfilopcion.getpaginacion_todo());

		return sDescripcion;
	}	
		
	public static String getduplicarDescripcion(PerfilOpcion perfilopcion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!perfilopcion.getduplicar()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getduplicarHtmlDescripcion(PerfilOpcion perfilopcion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(perfilopcion.getId(),perfilopcion.getduplicar());

		return sDescripcion;
	}	
		
	public static String getcopiarDescripcion(PerfilOpcion perfilopcion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!perfilopcion.getcopiar()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcopiarHtmlDescripcion(PerfilOpcion perfilopcion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(perfilopcion.getId(),perfilopcion.getcopiar());

		return sDescripcion;
	}	
		
	public static String getcon_precargarDescripcion(PerfilOpcion perfilopcion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!perfilopcion.getcon_precargar()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_precargarHtmlDescripcion(PerfilOpcion perfilopcion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(perfilopcion.getId(),perfilopcion.getcon_precargar());

		return sDescripcion;
	}	
		
	public static String getestadoDescripcion(PerfilOpcion perfilopcion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!perfilopcion.getestado()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getestadoHtmlDescripcion(PerfilOpcion perfilopcion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(perfilopcion.getId(),perfilopcion.getestado());

		return sDescripcion;
	}	
	
	public static String getPerfilOpcionDescripcion(PerfilOpcion perfilopcion) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(perfilopcion !=null/* && perfilopcion.getId()!=0*/) {
			if(perfilopcion.getId()!=null) {
				sDescripcion=perfilopcion.getId().toString();
			}//perfilopcionperfilopcion.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getPerfilOpcionDescripcionDetallado(PerfilOpcion perfilopcion) {
		String sDescripcion="";
			
		sDescripcion+=PerfilOpcionConstantesFunciones.ID+"=";
		sDescripcion+=perfilopcion.getId().toString()+",";
		sDescripcion+=PerfilOpcionConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=perfilopcion.getVersionRow().toString()+",";
		sDescripcion+=PerfilOpcionConstantesFunciones.IDSISTEMA+"=";
		sDescripcion+=perfilopcion.getid_sistema().toString()+",";
		sDescripcion+=PerfilOpcionConstantesFunciones.IDMODULO+"=";
		sDescripcion+=perfilopcion.getid_modulo().toString()+",";
		sDescripcion+=PerfilOpcionConstantesFunciones.IDGRUPOOPCION+"=";
		sDescripcion+=perfilopcion.getid_grupo_opcion().toString()+",";
		sDescripcion+=PerfilOpcionConstantesFunciones.IDPERFIL+"=";
		sDescripcion+=perfilopcion.getid_perfil().toString()+",";
		sDescripcion+=PerfilOpcionConstantesFunciones.IDOPCION+"=";
		sDescripcion+=perfilopcion.getid_opcion().toString()+",";
		sDescripcion+=PerfilOpcionConstantesFunciones.TODO+"=";
		sDescripcion+=perfilopcion.gettodo().toString()+",";
		sDescripcion+=PerfilOpcionConstantesFunciones.INGRESO+"=";
		sDescripcion+=perfilopcion.getingreso().toString()+",";
		sDescripcion+=PerfilOpcionConstantesFunciones.MODIFICACION+"=";
		sDescripcion+=perfilopcion.getmodificacion().toString()+",";
		sDescripcion+=PerfilOpcionConstantesFunciones.ELIMINACION+"=";
		sDescripcion+=perfilopcion.geteliminacion().toString()+",";
		sDescripcion+=PerfilOpcionConstantesFunciones.GUARDARCAMBIOS+"=";
		sDescripcion+=perfilopcion.getguardar_cambios().toString()+",";
		sDescripcion+=PerfilOpcionConstantesFunciones.CONSULTA+"=";
		sDescripcion+=perfilopcion.getconsulta().toString()+",";
		sDescripcion+=PerfilOpcionConstantesFunciones.BUSQUEDA+"=";
		sDescripcion+=perfilopcion.getbusqueda().toString()+",";
		sDescripcion+=PerfilOpcionConstantesFunciones.REPORTE+"=";
		sDescripcion+=perfilopcion.getreporte().toString()+",";
		sDescripcion+=PerfilOpcionConstantesFunciones.ORDEN+"=";
		sDescripcion+=perfilopcion.getorden().toString()+",";
		sDescripcion+=PerfilOpcionConstantesFunciones.PAGINACIONMEDIO+"=";
		sDescripcion+=perfilopcion.getpaginacion_medio().toString()+",";
		sDescripcion+=PerfilOpcionConstantesFunciones.PAGINACIONALTO+"=";
		sDescripcion+=perfilopcion.getpaginacion_alto().toString()+",";
		sDescripcion+=PerfilOpcionConstantesFunciones.PAGINACIONTODO+"=";
		sDescripcion+=perfilopcion.getpaginacion_todo().toString()+",";
		sDescripcion+=PerfilOpcionConstantesFunciones.DUPLICAR+"=";
		sDescripcion+=perfilopcion.getduplicar().toString()+",";
		sDescripcion+=PerfilOpcionConstantesFunciones.COPIAR+"=";
		sDescripcion+=perfilopcion.getcopiar().toString()+",";
		sDescripcion+=PerfilOpcionConstantesFunciones.CONPRECARGAR+"=";
		sDescripcion+=perfilopcion.getcon_precargar().toString()+",";
		sDescripcion+=PerfilOpcionConstantesFunciones.ESTADO+"=";
		sDescripcion+=perfilopcion.getestado().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setPerfilOpcionDescripcion(PerfilOpcion perfilopcion,String sValor) throws Exception {			
		if(perfilopcion !=null) {
			//perfilopcionperfilopcion.getId().toString();
		}		
	}
	
		

	public static String getSistemaDescripcion(Sistema sistema) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(sistema!=null/*&&sistema.getId()>0*/) {
			sDescripcion=SistemaConstantesFunciones.getSistemaDescripcion(sistema);
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

	public static String getGrupoOpcionDescripcion(GrupoOpcion grupoopcion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(grupoopcion!=null/*&&grupoopcion.getId()>0*/) {
			sDescripcion=GrupoOpcionConstantesFunciones.getGrupoOpcionDescripcion(grupoopcion);
		}

		return sDescripcion;
	}

	public static String getPerfilDescripcion(Perfil perfil) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(perfil!=null/*&&perfil.getId()>0*/) {
			sDescripcion=PerfilConstantesFunciones.getPerfilDescripcion(perfil);
		}

		return sDescripcion;
	}

	public static String getOpcionDescripcion(Opcion opcion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(opcion!=null/*&&opcion.getId()>0*/) {
			sDescripcion=OpcionConstantesFunciones.getOpcionDescripcion(opcion);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorIdPerfilPorIdOpcion")) {
			sNombreIndice="Tipo=  Por Sistema Por Modulo Por Grupo Opcion Por Perfil Por Opcion";
		} else if(sNombreIndice.equals("BusquedaPorIdSisPorIdModPorIdPer")) {
			sNombreIndice="Tipo=  Por Sistema Por Modulo Por Grupo Opcion Por Perfil";
		} else if(sNombreIndice.equals("FK_IdGrupoOpcion")) {
			sNombreIndice="Tipo=  Por Grupo Opcion";
		} else if(sNombreIndice.equals("FK_IdModulo")) {
			sNombreIndice="Tipo=  Por Modulo";
		} else if(sNombreIndice.equals("FK_IdOpcion")) {
			sNombreIndice="Tipo=  Por Opcion";
		} else if(sNombreIndice.equals("FK_IdPerfil")) {
			sNombreIndice="Tipo=  Por Perfil";
		} else if(sNombreIndice.equals("FK_IdSistema")) {
			sNombreIndice="Tipo=  Por Sistema";
		} else if(sNombreIndice.equals("PorIdPerfilPorIdOpcion")) {
			sNombreIndice="Tipo=  Por Perfil Por Opcion";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorIdPerfilPorIdOpcion(Long id_sistema,Long id_modulo,Long id_grupo_opcion,Long id_perfil,Long id_opcion) {
		String sDetalleIndice=" Parametros->";
		if(id_sistema!=null) {sDetalleIndice+=" Codigo Unico De Sistema="+id_sistema.toString();}
		if(id_modulo!=null) {sDetalleIndice+=" Codigo Unico De Modulo="+id_modulo.toString();}
		if(id_grupo_opcion!=null) {sDetalleIndice+=" Codigo Unico De Grupo Opcion="+id_grupo_opcion.toString();}
		if(id_perfil!=null) {sDetalleIndice+=" Codigo Unico De Perfil="+id_perfil.toString();}
		if(id_opcion!=null) {sDetalleIndice+=" Codigo Unico De Opcion="+id_opcion.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorIdSisPorIdModPorIdPer(Long id_sistema,Long id_modulo,Long id_grupo_opcion,Long id_perfil) {
		String sDetalleIndice=" Parametros->";
		if(id_sistema!=null) {sDetalleIndice+=" Codigo Unico De Sistema="+id_sistema.toString();}
		if(id_modulo!=null) {sDetalleIndice+=" Codigo Unico De Modulo="+id_modulo.toString();}
		if(id_grupo_opcion!=null) {sDetalleIndice+=" Codigo Unico De Grupo Opcion="+id_grupo_opcion.toString();}
		if(id_perfil!=null) {sDetalleIndice+=" Codigo Unico De Perfil="+id_perfil.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdGrupoOpcion(Long id_grupo_opcion) {
		String sDetalleIndice=" Parametros->";
		if(id_grupo_opcion!=null) {sDetalleIndice+=" Codigo Unico De Grupo Opcion="+id_grupo_opcion.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdModulo(Long id_modulo) {
		String sDetalleIndice=" Parametros->";
		if(id_modulo!=null) {sDetalleIndice+=" Codigo Unico De Modulo="+id_modulo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdOpcion(Long id_opcion) {
		String sDetalleIndice=" Parametros->";
		if(id_opcion!=null) {sDetalleIndice+=" Codigo Unico De Opcion="+id_opcion.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPerfil(Long id_perfil) {
		String sDetalleIndice=" Parametros->";
		if(id_perfil!=null) {sDetalleIndice+=" Codigo Unico De Perfil="+id_perfil.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSistema(Long id_sistema) {
		String sDetalleIndice=" Parametros->";
		if(id_sistema!=null) {sDetalleIndice+=" Codigo Unico De Sistema="+id_sistema.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndicePorIdPerfilPorIdOpcion(Long id_perfil,Long id_opcion) {
		String sDetalleIndice=" Parametros->";
		if(id_perfil!=null) {sDetalleIndice+=" Codigo Unico De Perfil="+id_perfil.toString();}
		if(id_opcion!=null) {sDetalleIndice+=" Codigo Unico De Opcion="+id_opcion.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosPerfilOpcion(PerfilOpcion perfilopcion,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosPerfilOpcions(List<PerfilOpcion> perfilopcions,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(PerfilOpcion perfilopcion: perfilopcions) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPerfilOpcion(PerfilOpcion perfilopcion,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && perfilopcion.getConCambioAuxiliar()) {
			perfilopcion.setIsDeleted(perfilopcion.getIsDeletedAuxiliar());	
			perfilopcion.setIsNew(perfilopcion.getIsNewAuxiliar());	
			perfilopcion.setIsChanged(perfilopcion.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			perfilopcion.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			perfilopcion.setIsDeletedAuxiliar(false);	
			perfilopcion.setIsNewAuxiliar(false);	
			perfilopcion.setIsChangedAuxiliar(false);
			
			perfilopcion.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPerfilOpcions(List<PerfilOpcion> perfilopcions,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(PerfilOpcion perfilopcion : perfilopcions) {
			if(conAsignarBase && perfilopcion.getConCambioAuxiliar()) {
				perfilopcion.setIsDeleted(perfilopcion.getIsDeletedAuxiliar());	
				perfilopcion.setIsNew(perfilopcion.getIsNewAuxiliar());	
				perfilopcion.setIsChanged(perfilopcion.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				perfilopcion.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				perfilopcion.setIsDeletedAuxiliar(false);	
				perfilopcion.setIsNewAuxiliar(false);	
				perfilopcion.setIsChangedAuxiliar(false);
				
				perfilopcion.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresPerfilOpcion(PerfilOpcion perfilopcion,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresPerfilOpcions(List<PerfilOpcion> perfilopcions,Boolean conEnteros) throws Exception  {
		
		for(PerfilOpcion perfilopcion: perfilopcions) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaPerfilOpcion(List<PerfilOpcion> perfilopcions,PerfilOpcion perfilopcionAux) throws Exception  {
		PerfilOpcionConstantesFunciones.InicializarValoresPerfilOpcion(perfilopcionAux,true);
		
		for(PerfilOpcion perfilopcion: perfilopcions) {
			if(perfilopcion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesPerfilOpcion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=PerfilOpcionConstantesFunciones.getArrayColumnasGlobalesPerfilOpcion(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesPerfilOpcion(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoPerfilOpcion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<PerfilOpcion> perfilopcions,PerfilOpcion perfilopcion,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(PerfilOpcion perfilopcionAux: perfilopcions) {
			if(perfilopcionAux!=null && perfilopcion!=null) {
				if((perfilopcionAux.getId()==null && perfilopcion.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(perfilopcionAux.getId()!=null && perfilopcion.getId()!=null){
					if(perfilopcionAux.getId().equals(perfilopcion.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaPerfilOpcion(List<PerfilOpcion> perfilopcions) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(PerfilOpcion perfilopcion: perfilopcions) {			
			if(perfilopcion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaPerfilOpcion() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,PerfilOpcionConstantesFunciones.LABEL_ID, PerfilOpcionConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PerfilOpcionConstantesFunciones.LABEL_VERSIONROW, PerfilOpcionConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PerfilOpcionConstantesFunciones.LABEL_IDSISTEMA, PerfilOpcionConstantesFunciones.IDSISTEMA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PerfilOpcionConstantesFunciones.LABEL_IDMODULO, PerfilOpcionConstantesFunciones.IDMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PerfilOpcionConstantesFunciones.LABEL_IDGRUPOOPCION, PerfilOpcionConstantesFunciones.IDGRUPOOPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PerfilOpcionConstantesFunciones.LABEL_IDPERFIL, PerfilOpcionConstantesFunciones.IDPERFIL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PerfilOpcionConstantesFunciones.LABEL_IDOPCION, PerfilOpcionConstantesFunciones.IDOPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PerfilOpcionConstantesFunciones.LABEL_TODO, PerfilOpcionConstantesFunciones.TODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PerfilOpcionConstantesFunciones.LABEL_INGRESO, PerfilOpcionConstantesFunciones.INGRESO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PerfilOpcionConstantesFunciones.LABEL_MODIFICACION, PerfilOpcionConstantesFunciones.MODIFICACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PerfilOpcionConstantesFunciones.LABEL_ELIMINACION, PerfilOpcionConstantesFunciones.ELIMINACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PerfilOpcionConstantesFunciones.LABEL_GUARDARCAMBIOS, PerfilOpcionConstantesFunciones.GUARDARCAMBIOS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PerfilOpcionConstantesFunciones.LABEL_CONSULTA, PerfilOpcionConstantesFunciones.CONSULTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PerfilOpcionConstantesFunciones.LABEL_BUSQUEDA, PerfilOpcionConstantesFunciones.BUSQUEDA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PerfilOpcionConstantesFunciones.LABEL_REPORTE, PerfilOpcionConstantesFunciones.REPORTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PerfilOpcionConstantesFunciones.LABEL_ORDEN, PerfilOpcionConstantesFunciones.ORDEN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PerfilOpcionConstantesFunciones.LABEL_PAGINACIONMEDIO, PerfilOpcionConstantesFunciones.PAGINACIONMEDIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PerfilOpcionConstantesFunciones.LABEL_PAGINACIONALTO, PerfilOpcionConstantesFunciones.PAGINACIONALTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PerfilOpcionConstantesFunciones.LABEL_PAGINACIONTODO, PerfilOpcionConstantesFunciones.PAGINACIONTODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PerfilOpcionConstantesFunciones.LABEL_DUPLICAR, PerfilOpcionConstantesFunciones.DUPLICAR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PerfilOpcionConstantesFunciones.LABEL_COPIAR, PerfilOpcionConstantesFunciones.COPIAR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PerfilOpcionConstantesFunciones.LABEL_CONPRECARGAR, PerfilOpcionConstantesFunciones.CONPRECARGAR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PerfilOpcionConstantesFunciones.LABEL_ESTADO, PerfilOpcionConstantesFunciones.ESTADO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasPerfilOpcion() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=PerfilOpcionConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PerfilOpcionConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PerfilOpcionConstantesFunciones.IDSISTEMA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PerfilOpcionConstantesFunciones.IDMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PerfilOpcionConstantesFunciones.IDGRUPOOPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PerfilOpcionConstantesFunciones.IDPERFIL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PerfilOpcionConstantesFunciones.IDOPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PerfilOpcionConstantesFunciones.TODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PerfilOpcionConstantesFunciones.INGRESO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PerfilOpcionConstantesFunciones.MODIFICACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PerfilOpcionConstantesFunciones.ELIMINACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PerfilOpcionConstantesFunciones.GUARDARCAMBIOS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PerfilOpcionConstantesFunciones.CONSULTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PerfilOpcionConstantesFunciones.BUSQUEDA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PerfilOpcionConstantesFunciones.REPORTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PerfilOpcionConstantesFunciones.ORDEN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PerfilOpcionConstantesFunciones.PAGINACIONMEDIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PerfilOpcionConstantesFunciones.PAGINACIONALTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PerfilOpcionConstantesFunciones.PAGINACIONTODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PerfilOpcionConstantesFunciones.DUPLICAR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PerfilOpcionConstantesFunciones.COPIAR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PerfilOpcionConstantesFunciones.CONPRECARGAR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PerfilOpcionConstantesFunciones.ESTADO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPerfilOpcion() throws Exception  {
		return PerfilOpcionConstantesFunciones.getTiposSeleccionarPerfilOpcion(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPerfilOpcion(Boolean conFk) throws Exception  {
		return PerfilOpcionConstantesFunciones.getTiposSeleccionarPerfilOpcion(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPerfilOpcion(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PerfilOpcionConstantesFunciones.LABEL_IDSISTEMA);
			reporte.setsDescripcion(PerfilOpcionConstantesFunciones.LABEL_IDSISTEMA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PerfilOpcionConstantesFunciones.LABEL_IDMODULO);
			reporte.setsDescripcion(PerfilOpcionConstantesFunciones.LABEL_IDMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PerfilOpcionConstantesFunciones.LABEL_IDGRUPOOPCION);
			reporte.setsDescripcion(PerfilOpcionConstantesFunciones.LABEL_IDGRUPOOPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PerfilOpcionConstantesFunciones.LABEL_IDPERFIL);
			reporte.setsDescripcion(PerfilOpcionConstantesFunciones.LABEL_IDPERFIL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PerfilOpcionConstantesFunciones.LABEL_IDOPCION);
			reporte.setsDescripcion(PerfilOpcionConstantesFunciones.LABEL_IDOPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PerfilOpcionConstantesFunciones.LABEL_TODO);
			reporte.setsDescripcion(PerfilOpcionConstantesFunciones.LABEL_TODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PerfilOpcionConstantesFunciones.LABEL_INGRESO);
			reporte.setsDescripcion(PerfilOpcionConstantesFunciones.LABEL_INGRESO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PerfilOpcionConstantesFunciones.LABEL_MODIFICACION);
			reporte.setsDescripcion(PerfilOpcionConstantesFunciones.LABEL_MODIFICACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PerfilOpcionConstantesFunciones.LABEL_ELIMINACION);
			reporte.setsDescripcion(PerfilOpcionConstantesFunciones.LABEL_ELIMINACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PerfilOpcionConstantesFunciones.LABEL_GUARDARCAMBIOS);
			reporte.setsDescripcion(PerfilOpcionConstantesFunciones.LABEL_GUARDARCAMBIOS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PerfilOpcionConstantesFunciones.LABEL_CONSULTA);
			reporte.setsDescripcion(PerfilOpcionConstantesFunciones.LABEL_CONSULTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PerfilOpcionConstantesFunciones.LABEL_BUSQUEDA);
			reporte.setsDescripcion(PerfilOpcionConstantesFunciones.LABEL_BUSQUEDA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PerfilOpcionConstantesFunciones.LABEL_REPORTE);
			reporte.setsDescripcion(PerfilOpcionConstantesFunciones.LABEL_REPORTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PerfilOpcionConstantesFunciones.LABEL_ORDEN);
			reporte.setsDescripcion(PerfilOpcionConstantesFunciones.LABEL_ORDEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PerfilOpcionConstantesFunciones.LABEL_PAGINACIONMEDIO);
			reporte.setsDescripcion(PerfilOpcionConstantesFunciones.LABEL_PAGINACIONMEDIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PerfilOpcionConstantesFunciones.LABEL_PAGINACIONALTO);
			reporte.setsDescripcion(PerfilOpcionConstantesFunciones.LABEL_PAGINACIONALTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PerfilOpcionConstantesFunciones.LABEL_PAGINACIONTODO);
			reporte.setsDescripcion(PerfilOpcionConstantesFunciones.LABEL_PAGINACIONTODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PerfilOpcionConstantesFunciones.LABEL_DUPLICAR);
			reporte.setsDescripcion(PerfilOpcionConstantesFunciones.LABEL_DUPLICAR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PerfilOpcionConstantesFunciones.LABEL_COPIAR);
			reporte.setsDescripcion(PerfilOpcionConstantesFunciones.LABEL_COPIAR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PerfilOpcionConstantesFunciones.LABEL_CONPRECARGAR);
			reporte.setsDescripcion(PerfilOpcionConstantesFunciones.LABEL_CONPRECARGAR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PerfilOpcionConstantesFunciones.LABEL_ESTADO);
			reporte.setsDescripcion(PerfilOpcionConstantesFunciones.LABEL_ESTADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesPerfilOpcion(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesPerfilOpcion(PerfilOpcion perfilopcionAux) throws Exception {
		
			perfilopcionAux.setsistema_descripcion(SistemaConstantesFunciones.getSistemaDescripcion(perfilopcionAux.getSistema()));
			perfilopcionAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(perfilopcionAux.getModulo()));
			perfilopcionAux.setgrupoopcion_descripcion(GrupoOpcionConstantesFunciones.getGrupoOpcionDescripcion(perfilopcionAux.getGrupoOpcion()));
			perfilopcionAux.setperfil_descripcion(PerfilConstantesFunciones.getPerfilDescripcion(perfilopcionAux.getPerfil()));
			perfilopcionAux.setopcion_descripcion(OpcionConstantesFunciones.getOpcionDescripcion(perfilopcionAux.getOpcion()));		
	}
	
	public static void refrescarForeignKeysDescripcionesPerfilOpcion(List<PerfilOpcion> perfilopcionsTemp) throws Exception {
		for(PerfilOpcion perfilopcionAux:perfilopcionsTemp) {
			
			perfilopcionAux.setsistema_descripcion(SistemaConstantesFunciones.getSistemaDescripcion(perfilopcionAux.getSistema()));
			perfilopcionAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(perfilopcionAux.getModulo()));
			perfilopcionAux.setgrupoopcion_descripcion(GrupoOpcionConstantesFunciones.getGrupoOpcionDescripcion(perfilopcionAux.getGrupoOpcion()));
			perfilopcionAux.setperfil_descripcion(PerfilConstantesFunciones.getPerfilDescripcion(perfilopcionAux.getPerfil()));
			perfilopcionAux.setopcion_descripcion(OpcionConstantesFunciones.getOpcionDescripcion(perfilopcionAux.getOpcion()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfPerfilOpcion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Sistema.class));
				classes.add(new Classe(Modulo.class));
				classes.add(new Classe(GrupoOpcion.class));
				classes.add(new Classe(Perfil.class));
				classes.add(new Classe(Opcion.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Sistema.class)) {
						classes.add(new Classe(Sistema.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Modulo.class)) {
						classes.add(new Classe(Modulo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(GrupoOpcion.class)) {
						classes.add(new Classe(GrupoOpcion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Perfil.class)) {
						classes.add(new Classe(Perfil.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Opcion.class)) {
						classes.add(new Classe(Opcion.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfPerfilOpcion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Sistema.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sistema.class)); continue;
					}

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}

					if(GrupoOpcion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(GrupoOpcion.class)); continue;
					}

					if(Perfil.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Perfil.class)); continue;
					}

					if(Opcion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Opcion.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Sistema.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sistema.class)); continue;
					}

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}

					if(GrupoOpcion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(GrupoOpcion.class)); continue;
					}

					if(Perfil.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Perfil.class)); continue;
					}

					if(Opcion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Opcion.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfPerfilOpcion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return PerfilOpcionConstantesFunciones.getClassesRelationshipsOfPerfilOpcion(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPerfilOpcion(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPerfilOpcion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return PerfilOpcionConstantesFunciones.getClassesRelationshipsFromStringsOfPerfilOpcion(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPerfilOpcion(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(PerfilOpcion perfilopcion,List<PerfilOpcion> perfilopcions,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			PerfilOpcion perfilopcionEncontrado=null;
			
			for(PerfilOpcion perfilopcionLocal:perfilopcions) {
				if(perfilopcionLocal.getId().equals(perfilopcion.getId())) {
					perfilopcionEncontrado=perfilopcionLocal;
					
					perfilopcionLocal.setIsChanged(perfilopcion.getIsChanged());
					perfilopcionLocal.setIsNew(perfilopcion.getIsNew());
					perfilopcionLocal.setIsDeleted(perfilopcion.getIsDeleted());
					
					perfilopcionLocal.setGeneralEntityOriginal(perfilopcion.getGeneralEntityOriginal());
					
					perfilopcionLocal.setId(perfilopcion.getId());	
					perfilopcionLocal.setVersionRow(perfilopcion.getVersionRow());	
					perfilopcionLocal.setid_sistema(perfilopcion.getid_sistema());	
					perfilopcionLocal.setid_modulo(perfilopcion.getid_modulo());	
					perfilopcionLocal.setid_grupo_opcion(perfilopcion.getid_grupo_opcion());	
					perfilopcionLocal.setid_perfil(perfilopcion.getid_perfil());	
					perfilopcionLocal.setid_opcion(perfilopcion.getid_opcion());	
					perfilopcionLocal.settodo(perfilopcion.gettodo());	
					perfilopcionLocal.setingreso(perfilopcion.getingreso());	
					perfilopcionLocal.setmodificacion(perfilopcion.getmodificacion());	
					perfilopcionLocal.seteliminacion(perfilopcion.geteliminacion());	
					perfilopcionLocal.setguardar_cambios(perfilopcion.getguardar_cambios());	
					perfilopcionLocal.setconsulta(perfilopcion.getconsulta());	
					perfilopcionLocal.setbusqueda(perfilopcion.getbusqueda());	
					perfilopcionLocal.setreporte(perfilopcion.getreporte());	
					perfilopcionLocal.setorden(perfilopcion.getorden());	
					perfilopcionLocal.setpaginacion_medio(perfilopcion.getpaginacion_medio());	
					perfilopcionLocal.setpaginacion_alto(perfilopcion.getpaginacion_alto());	
					perfilopcionLocal.setpaginacion_todo(perfilopcion.getpaginacion_todo());	
					perfilopcionLocal.setduplicar(perfilopcion.getduplicar());	
					perfilopcionLocal.setcopiar(perfilopcion.getcopiar());	
					perfilopcionLocal.setcon_precargar(perfilopcion.getcon_precargar());	
					perfilopcionLocal.setestado(perfilopcion.getestado());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!perfilopcion.getIsDeleted()) {
				if(!existe) {
					perfilopcions.add(perfilopcion);
				}
			} else {
				if(perfilopcionEncontrado!=null && permiteQuitar)  {
					perfilopcions.remove(perfilopcionEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(PerfilOpcion perfilopcion,List<PerfilOpcion> perfilopcions) throws Exception {
		try	{			
			for(PerfilOpcion perfilopcionLocal:perfilopcions) {
				if(perfilopcionLocal.getId().equals(perfilopcion.getId())) {
					perfilopcionLocal.setIsSelected(perfilopcion.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesPerfilOpcion(List<PerfilOpcion> perfilopcionsAux) throws Exception {
		//this.perfilopcionsAux=perfilopcionsAux;
		
		for(PerfilOpcion perfilopcionAux:perfilopcionsAux) {
			if(perfilopcionAux.getIsChanged()) {
				perfilopcionAux.setIsChanged(false);
			}		
			
			if(perfilopcionAux.getIsNew()) {
				perfilopcionAux.setIsNew(false);
			}	
			
			if(perfilopcionAux.getIsDeleted()) {
				perfilopcionAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesPerfilOpcion(PerfilOpcion perfilopcionAux) throws Exception {
		//this.perfilopcionAux=perfilopcionAux;
		
			if(perfilopcionAux.getIsChanged()) {
				perfilopcionAux.setIsChanged(false);
			}		
			
			if(perfilopcionAux.getIsNew()) {
				perfilopcionAux.setIsNew(false);
			}	
			
			if(perfilopcionAux.getIsDeleted()) {
				perfilopcionAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(PerfilOpcion perfilopcionAsignar,PerfilOpcion perfilopcion) throws Exception {
		perfilopcionAsignar.setId(perfilopcion.getId());	
		perfilopcionAsignar.setVersionRow(perfilopcion.getVersionRow());	
		perfilopcionAsignar.setid_sistema(perfilopcion.getid_sistema());
		perfilopcionAsignar.setsistema_descripcion(perfilopcion.getsistema_descripcion());	
		perfilopcionAsignar.setid_modulo(perfilopcion.getid_modulo());
		perfilopcionAsignar.setmodulo_descripcion(perfilopcion.getmodulo_descripcion());	
		perfilopcionAsignar.setid_grupo_opcion(perfilopcion.getid_grupo_opcion());
		perfilopcionAsignar.setgrupoopcion_descripcion(perfilopcion.getgrupoopcion_descripcion());	
		perfilopcionAsignar.setid_perfil(perfilopcion.getid_perfil());
		perfilopcionAsignar.setperfil_descripcion(perfilopcion.getperfil_descripcion());	
		perfilopcionAsignar.setid_opcion(perfilopcion.getid_opcion());
		perfilopcionAsignar.setopcion_descripcion(perfilopcion.getopcion_descripcion());	
		perfilopcionAsignar.settodo(perfilopcion.gettodo());	
		perfilopcionAsignar.setingreso(perfilopcion.getingreso());	
		perfilopcionAsignar.setmodificacion(perfilopcion.getmodificacion());	
		perfilopcionAsignar.seteliminacion(perfilopcion.geteliminacion());	
		perfilopcionAsignar.setguardar_cambios(perfilopcion.getguardar_cambios());	
		perfilopcionAsignar.setconsulta(perfilopcion.getconsulta());	
		perfilopcionAsignar.setbusqueda(perfilopcion.getbusqueda());	
		perfilopcionAsignar.setreporte(perfilopcion.getreporte());	
		perfilopcionAsignar.setorden(perfilopcion.getorden());	
		perfilopcionAsignar.setpaginacion_medio(perfilopcion.getpaginacion_medio());	
		perfilopcionAsignar.setpaginacion_alto(perfilopcion.getpaginacion_alto());	
		perfilopcionAsignar.setpaginacion_todo(perfilopcion.getpaginacion_todo());	
		perfilopcionAsignar.setduplicar(perfilopcion.getduplicar());	
		perfilopcionAsignar.setcopiar(perfilopcion.getcopiar());	
		perfilopcionAsignar.setcon_precargar(perfilopcion.getcon_precargar());	
		perfilopcionAsignar.setestado(perfilopcion.getestado());	
	}
	
	public static void inicializarPerfilOpcion(PerfilOpcion perfilopcion) throws Exception {
		try {
				perfilopcion.setId(0L);	
					
				perfilopcion.setid_sistema(-1L);	
				perfilopcion.setid_modulo(-1L);	
				perfilopcion.setid_grupo_opcion(null);	
				perfilopcion.setid_perfil(-1L);	
				perfilopcion.setid_opcion(-1L);	
				perfilopcion.settodo(false);	
				perfilopcion.setingreso(false);	
				perfilopcion.setmodificacion(false);	
				perfilopcion.seteliminacion(false);	
				perfilopcion.setguardar_cambios(false);	
				perfilopcion.setconsulta(false);	
				perfilopcion.setbusqueda(false);	
				perfilopcion.setreporte(false);	
				perfilopcion.setorden(false);	
				perfilopcion.setpaginacion_medio(false);	
				perfilopcion.setpaginacion_alto(false);	
				perfilopcion.setpaginacion_todo(false);	
				perfilopcion.setduplicar(false);	
				perfilopcion.setcopiar(false);	
				perfilopcion.setcon_precargar(false);	
				perfilopcion.setestado(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderPerfilOpcion(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(PerfilOpcionConstantesFunciones.LABEL_IDSISTEMA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PerfilOpcionConstantesFunciones.LABEL_IDMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PerfilOpcionConstantesFunciones.LABEL_IDGRUPOOPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PerfilOpcionConstantesFunciones.LABEL_IDPERFIL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PerfilOpcionConstantesFunciones.LABEL_IDOPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PerfilOpcionConstantesFunciones.LABEL_TODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PerfilOpcionConstantesFunciones.LABEL_INGRESO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PerfilOpcionConstantesFunciones.LABEL_MODIFICACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PerfilOpcionConstantesFunciones.LABEL_ELIMINACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PerfilOpcionConstantesFunciones.LABEL_GUARDARCAMBIOS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PerfilOpcionConstantesFunciones.LABEL_CONSULTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PerfilOpcionConstantesFunciones.LABEL_BUSQUEDA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PerfilOpcionConstantesFunciones.LABEL_REPORTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PerfilOpcionConstantesFunciones.LABEL_ORDEN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PerfilOpcionConstantesFunciones.LABEL_PAGINACIONMEDIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PerfilOpcionConstantesFunciones.LABEL_PAGINACIONALTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PerfilOpcionConstantesFunciones.LABEL_PAGINACIONTODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PerfilOpcionConstantesFunciones.LABEL_DUPLICAR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PerfilOpcionConstantesFunciones.LABEL_COPIAR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PerfilOpcionConstantesFunciones.LABEL_CONPRECARGAR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PerfilOpcionConstantesFunciones.LABEL_ESTADO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataPerfilOpcion(String sTipo,Row row,Workbook workbook,PerfilOpcion perfilopcion,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(perfilopcion.getsistema_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(perfilopcion.getmodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(perfilopcion.getgrupoopcion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(perfilopcion.getperfil_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(perfilopcion.getopcion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(perfilopcion.gettodo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(perfilopcion.getingreso()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(perfilopcion.getmodificacion()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(perfilopcion.geteliminacion()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(perfilopcion.getguardar_cambios()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(perfilopcion.getconsulta()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(perfilopcion.getbusqueda()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(perfilopcion.getreporte()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(perfilopcion.getorden()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(perfilopcion.getpaginacion_medio()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(perfilopcion.getpaginacion_alto()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(perfilopcion.getpaginacion_todo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(perfilopcion.getduplicar()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(perfilopcion.getcopiar()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(perfilopcion.getcon_precargar()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(perfilopcion.getestado()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryPerfilOpcion=Constantes.SFINALQUERY;
	
	public String getsFinalQueryPerfilOpcion() {
		return this.sFinalQueryPerfilOpcion;
	}
	
	public void setsFinalQueryPerfilOpcion(String sFinalQueryPerfilOpcion) {
		this.sFinalQueryPerfilOpcion= sFinalQueryPerfilOpcion;
	}
	
	public Border resaltarSeleccionarPerfilOpcion=null;
	
	public Border setResaltarSeleccionarPerfilOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*PerfilOpcionBeanSwingJInternalFrame perfilopcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//perfilopcionBeanSwingJInternalFrame.jTtoolBarPerfilOpcion.setBorder(borderResaltar);
		
		this.resaltarSeleccionarPerfilOpcion= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarPerfilOpcion() {
		return this.resaltarSeleccionarPerfilOpcion;
	}
	
	public void setResaltarSeleccionarPerfilOpcion(Border borderResaltarSeleccionarPerfilOpcion) {
		this.resaltarSeleccionarPerfilOpcion= borderResaltarSeleccionarPerfilOpcion;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridPerfilOpcion=null;
	public Boolean mostraridPerfilOpcion=true;
	public Boolean activaridPerfilOpcion=true;

	public Border resaltarid_sistemaPerfilOpcion=null;
	public Boolean mostrarid_sistemaPerfilOpcion=true;
	public Boolean activarid_sistemaPerfilOpcion=true;
	public Boolean cargarid_sistemaPerfilOpcion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sistemaPerfilOpcion=false;//ConEventDepend=true

	public Border resaltarid_moduloPerfilOpcion=null;
	public Boolean mostrarid_moduloPerfilOpcion=true;
	public Boolean activarid_moduloPerfilOpcion=true;
	public Boolean cargarid_moduloPerfilOpcion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_moduloPerfilOpcion=true;//ConEventDepend=true

	public Border resaltarid_grupo_opcionPerfilOpcion=null;
	public Boolean mostrarid_grupo_opcionPerfilOpcion=true;
	public Boolean activarid_grupo_opcionPerfilOpcion=true;
	public Boolean cargarid_grupo_opcionPerfilOpcion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_grupo_opcionPerfilOpcion=true;//ConEventDepend=true

	public Border resaltarid_perfilPerfilOpcion=null;
	public Boolean mostrarid_perfilPerfilOpcion=true;
	public Boolean activarid_perfilPerfilOpcion=true;
	public Boolean cargarid_perfilPerfilOpcion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_perfilPerfilOpcion=true;//ConEventDepend=true

	public Border resaltarid_opcionPerfilOpcion=null;
	public Boolean mostrarid_opcionPerfilOpcion=true;
	public Boolean activarid_opcionPerfilOpcion=true;
	public Boolean cargarid_opcionPerfilOpcion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_opcionPerfilOpcion=true;//ConEventDepend=true

	public Border resaltartodoPerfilOpcion=null;
	public Boolean mostrartodoPerfilOpcion=true;
	public Boolean activartodoPerfilOpcion=true;

	public Border resaltaringresoPerfilOpcion=null;
	public Boolean mostraringresoPerfilOpcion=true;
	public Boolean activaringresoPerfilOpcion=true;

	public Border resaltarmodificacionPerfilOpcion=null;
	public Boolean mostrarmodificacionPerfilOpcion=true;
	public Boolean activarmodificacionPerfilOpcion=true;

	public Border resaltareliminacionPerfilOpcion=null;
	public Boolean mostrareliminacionPerfilOpcion=true;
	public Boolean activareliminacionPerfilOpcion=true;

	public Border resaltarguardar_cambiosPerfilOpcion=null;
	public Boolean mostrarguardar_cambiosPerfilOpcion=true;
	public Boolean activarguardar_cambiosPerfilOpcion=true;

	public Border resaltarconsultaPerfilOpcion=null;
	public Boolean mostrarconsultaPerfilOpcion=true;
	public Boolean activarconsultaPerfilOpcion=true;

	public Border resaltarbusquedaPerfilOpcion=null;
	public Boolean mostrarbusquedaPerfilOpcion=true;
	public Boolean activarbusquedaPerfilOpcion=true;

	public Border resaltarreportePerfilOpcion=null;
	public Boolean mostrarreportePerfilOpcion=true;
	public Boolean activarreportePerfilOpcion=true;

	public Border resaltarordenPerfilOpcion=null;
	public Boolean mostrarordenPerfilOpcion=true;
	public Boolean activarordenPerfilOpcion=true;

	public Border resaltarpaginacion_medioPerfilOpcion=null;
	public Boolean mostrarpaginacion_medioPerfilOpcion=true;
	public Boolean activarpaginacion_medioPerfilOpcion=true;

	public Border resaltarpaginacion_altoPerfilOpcion=null;
	public Boolean mostrarpaginacion_altoPerfilOpcion=true;
	public Boolean activarpaginacion_altoPerfilOpcion=true;

	public Border resaltarpaginacion_todoPerfilOpcion=null;
	public Boolean mostrarpaginacion_todoPerfilOpcion=true;
	public Boolean activarpaginacion_todoPerfilOpcion=true;

	public Border resaltarduplicarPerfilOpcion=null;
	public Boolean mostrarduplicarPerfilOpcion=true;
	public Boolean activarduplicarPerfilOpcion=true;

	public Border resaltarcopiarPerfilOpcion=null;
	public Boolean mostrarcopiarPerfilOpcion=true;
	public Boolean activarcopiarPerfilOpcion=true;

	public Border resaltarcon_precargarPerfilOpcion=null;
	public Boolean mostrarcon_precargarPerfilOpcion=true;
	public Boolean activarcon_precargarPerfilOpcion=true;

	public Border resaltarestadoPerfilOpcion=null;
	public Boolean mostrarestadoPerfilOpcion=true;
	public Boolean activarestadoPerfilOpcion=true;

	
	

	public Border setResaltaridPerfilOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*PerfilOpcionBeanSwingJInternalFrame perfilopcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//perfilopcionBeanSwingJInternalFrame.jTtoolBarPerfilOpcion.setBorder(borderResaltar);
		
		this.resaltaridPerfilOpcion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridPerfilOpcion() {
		return this.resaltaridPerfilOpcion;
	}

	public void setResaltaridPerfilOpcion(Border borderResaltar) {
		this.resaltaridPerfilOpcion= borderResaltar;
	}

	public Boolean getMostraridPerfilOpcion() {
		return this.mostraridPerfilOpcion;
	}

	public void setMostraridPerfilOpcion(Boolean mostraridPerfilOpcion) {
		this.mostraridPerfilOpcion= mostraridPerfilOpcion;
	}

	public Boolean getActivaridPerfilOpcion() {
		return this.activaridPerfilOpcion;
	}

	public void setActivaridPerfilOpcion(Boolean activaridPerfilOpcion) {
		this.activaridPerfilOpcion= activaridPerfilOpcion;
	}

	public Border setResaltarid_sistemaPerfilOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*PerfilOpcionBeanSwingJInternalFrame perfilopcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//perfilopcionBeanSwingJInternalFrame.jTtoolBarPerfilOpcion.setBorder(borderResaltar);
		
		this.resaltarid_sistemaPerfilOpcion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sistemaPerfilOpcion() {
		return this.resaltarid_sistemaPerfilOpcion;
	}

	public void setResaltarid_sistemaPerfilOpcion(Border borderResaltar) {
		this.resaltarid_sistemaPerfilOpcion= borderResaltar;
	}

	public Boolean getMostrarid_sistemaPerfilOpcion() {
		return this.mostrarid_sistemaPerfilOpcion;
	}

	public void setMostrarid_sistemaPerfilOpcion(Boolean mostrarid_sistemaPerfilOpcion) {
		this.mostrarid_sistemaPerfilOpcion= mostrarid_sistemaPerfilOpcion;
	}

	public Boolean getActivarid_sistemaPerfilOpcion() {
		return this.activarid_sistemaPerfilOpcion;
	}

	public void setActivarid_sistemaPerfilOpcion(Boolean activarid_sistemaPerfilOpcion) {
		this.activarid_sistemaPerfilOpcion= activarid_sistemaPerfilOpcion;
	}

	public Boolean getCargarid_sistemaPerfilOpcion() {
		return this.cargarid_sistemaPerfilOpcion;
	}

	public void setCargarid_sistemaPerfilOpcion(Boolean cargarid_sistemaPerfilOpcion) {
		this.cargarid_sistemaPerfilOpcion= cargarid_sistemaPerfilOpcion;
	}

	public Border setResaltarid_moduloPerfilOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*PerfilOpcionBeanSwingJInternalFrame perfilopcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//perfilopcionBeanSwingJInternalFrame.jTtoolBarPerfilOpcion.setBorder(borderResaltar);
		
		this.resaltarid_moduloPerfilOpcion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_moduloPerfilOpcion() {
		return this.resaltarid_moduloPerfilOpcion;
	}

	public void setResaltarid_moduloPerfilOpcion(Border borderResaltar) {
		this.resaltarid_moduloPerfilOpcion= borderResaltar;
	}

	public Boolean getMostrarid_moduloPerfilOpcion() {
		return this.mostrarid_moduloPerfilOpcion;
	}

	public void setMostrarid_moduloPerfilOpcion(Boolean mostrarid_moduloPerfilOpcion) {
		this.mostrarid_moduloPerfilOpcion= mostrarid_moduloPerfilOpcion;
	}

	public Boolean getActivarid_moduloPerfilOpcion() {
		return this.activarid_moduloPerfilOpcion;
	}

	public void setActivarid_moduloPerfilOpcion(Boolean activarid_moduloPerfilOpcion) {
		this.activarid_moduloPerfilOpcion= activarid_moduloPerfilOpcion;
	}

	public Boolean getCargarid_moduloPerfilOpcion() {
		return this.cargarid_moduloPerfilOpcion;
	}

	public void setCargarid_moduloPerfilOpcion(Boolean cargarid_moduloPerfilOpcion) {
		this.cargarid_moduloPerfilOpcion= cargarid_moduloPerfilOpcion;
	}

	public Border setResaltarid_grupo_opcionPerfilOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*PerfilOpcionBeanSwingJInternalFrame perfilopcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//perfilopcionBeanSwingJInternalFrame.jTtoolBarPerfilOpcion.setBorder(borderResaltar);
		
		this.resaltarid_grupo_opcionPerfilOpcion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_grupo_opcionPerfilOpcion() {
		return this.resaltarid_grupo_opcionPerfilOpcion;
	}

	public void setResaltarid_grupo_opcionPerfilOpcion(Border borderResaltar) {
		this.resaltarid_grupo_opcionPerfilOpcion= borderResaltar;
	}

	public Boolean getMostrarid_grupo_opcionPerfilOpcion() {
		return this.mostrarid_grupo_opcionPerfilOpcion;
	}

	public void setMostrarid_grupo_opcionPerfilOpcion(Boolean mostrarid_grupo_opcionPerfilOpcion) {
		this.mostrarid_grupo_opcionPerfilOpcion= mostrarid_grupo_opcionPerfilOpcion;
	}

	public Boolean getActivarid_grupo_opcionPerfilOpcion() {
		return this.activarid_grupo_opcionPerfilOpcion;
	}

	public void setActivarid_grupo_opcionPerfilOpcion(Boolean activarid_grupo_opcionPerfilOpcion) {
		this.activarid_grupo_opcionPerfilOpcion= activarid_grupo_opcionPerfilOpcion;
	}

	public Boolean getCargarid_grupo_opcionPerfilOpcion() {
		return this.cargarid_grupo_opcionPerfilOpcion;
	}

	public void setCargarid_grupo_opcionPerfilOpcion(Boolean cargarid_grupo_opcionPerfilOpcion) {
		this.cargarid_grupo_opcionPerfilOpcion= cargarid_grupo_opcionPerfilOpcion;
	}

	public Border setResaltarid_perfilPerfilOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*PerfilOpcionBeanSwingJInternalFrame perfilopcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//perfilopcionBeanSwingJInternalFrame.jTtoolBarPerfilOpcion.setBorder(borderResaltar);
		
		this.resaltarid_perfilPerfilOpcion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_perfilPerfilOpcion() {
		return this.resaltarid_perfilPerfilOpcion;
	}

	public void setResaltarid_perfilPerfilOpcion(Border borderResaltar) {
		this.resaltarid_perfilPerfilOpcion= borderResaltar;
	}

	public Boolean getMostrarid_perfilPerfilOpcion() {
		return this.mostrarid_perfilPerfilOpcion;
	}

	public void setMostrarid_perfilPerfilOpcion(Boolean mostrarid_perfilPerfilOpcion) {
		this.mostrarid_perfilPerfilOpcion= mostrarid_perfilPerfilOpcion;
	}

	public Boolean getActivarid_perfilPerfilOpcion() {
		return this.activarid_perfilPerfilOpcion;
	}

	public void setActivarid_perfilPerfilOpcion(Boolean activarid_perfilPerfilOpcion) {
		this.activarid_perfilPerfilOpcion= activarid_perfilPerfilOpcion;
	}

	public Boolean getCargarid_perfilPerfilOpcion() {
		return this.cargarid_perfilPerfilOpcion;
	}

	public void setCargarid_perfilPerfilOpcion(Boolean cargarid_perfilPerfilOpcion) {
		this.cargarid_perfilPerfilOpcion= cargarid_perfilPerfilOpcion;
	}

	public Border setResaltarid_opcionPerfilOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*PerfilOpcionBeanSwingJInternalFrame perfilopcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//perfilopcionBeanSwingJInternalFrame.jTtoolBarPerfilOpcion.setBorder(borderResaltar);
		
		this.resaltarid_opcionPerfilOpcion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_opcionPerfilOpcion() {
		return this.resaltarid_opcionPerfilOpcion;
	}

	public void setResaltarid_opcionPerfilOpcion(Border borderResaltar) {
		this.resaltarid_opcionPerfilOpcion= borderResaltar;
	}

	public Boolean getMostrarid_opcionPerfilOpcion() {
		return this.mostrarid_opcionPerfilOpcion;
	}

	public void setMostrarid_opcionPerfilOpcion(Boolean mostrarid_opcionPerfilOpcion) {
		this.mostrarid_opcionPerfilOpcion= mostrarid_opcionPerfilOpcion;
	}

	public Boolean getActivarid_opcionPerfilOpcion() {
		return this.activarid_opcionPerfilOpcion;
	}

	public void setActivarid_opcionPerfilOpcion(Boolean activarid_opcionPerfilOpcion) {
		this.activarid_opcionPerfilOpcion= activarid_opcionPerfilOpcion;
	}

	public Boolean getCargarid_opcionPerfilOpcion() {
		return this.cargarid_opcionPerfilOpcion;
	}

	public void setCargarid_opcionPerfilOpcion(Boolean cargarid_opcionPerfilOpcion) {
		this.cargarid_opcionPerfilOpcion= cargarid_opcionPerfilOpcion;
	}

	public Border setResaltartodoPerfilOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*PerfilOpcionBeanSwingJInternalFrame perfilopcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//perfilopcionBeanSwingJInternalFrame.jTtoolBarPerfilOpcion.setBorder(borderResaltar);
		
		this.resaltartodoPerfilOpcion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartodoPerfilOpcion() {
		return this.resaltartodoPerfilOpcion;
	}

	public void setResaltartodoPerfilOpcion(Border borderResaltar) {
		this.resaltartodoPerfilOpcion= borderResaltar;
	}

	public Boolean getMostrartodoPerfilOpcion() {
		return this.mostrartodoPerfilOpcion;
	}

	public void setMostrartodoPerfilOpcion(Boolean mostrartodoPerfilOpcion) {
		this.mostrartodoPerfilOpcion= mostrartodoPerfilOpcion;
	}

	public Boolean getActivartodoPerfilOpcion() {
		return this.activartodoPerfilOpcion;
	}

	public void setActivartodoPerfilOpcion(Boolean activartodoPerfilOpcion) {
		this.activartodoPerfilOpcion= activartodoPerfilOpcion;
	}

	public Border setResaltaringresoPerfilOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*PerfilOpcionBeanSwingJInternalFrame perfilopcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//perfilopcionBeanSwingJInternalFrame.jTtoolBarPerfilOpcion.setBorder(borderResaltar);
		
		this.resaltaringresoPerfilOpcion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaringresoPerfilOpcion() {
		return this.resaltaringresoPerfilOpcion;
	}

	public void setResaltaringresoPerfilOpcion(Border borderResaltar) {
		this.resaltaringresoPerfilOpcion= borderResaltar;
	}

	public Boolean getMostraringresoPerfilOpcion() {
		return this.mostraringresoPerfilOpcion;
	}

	public void setMostraringresoPerfilOpcion(Boolean mostraringresoPerfilOpcion) {
		this.mostraringresoPerfilOpcion= mostraringresoPerfilOpcion;
	}

	public Boolean getActivaringresoPerfilOpcion() {
		return this.activaringresoPerfilOpcion;
	}

	public void setActivaringresoPerfilOpcion(Boolean activaringresoPerfilOpcion) {
		this.activaringresoPerfilOpcion= activaringresoPerfilOpcion;
	}

	public Border setResaltarmodificacionPerfilOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*PerfilOpcionBeanSwingJInternalFrame perfilopcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//perfilopcionBeanSwingJInternalFrame.jTtoolBarPerfilOpcion.setBorder(borderResaltar);
		
		this.resaltarmodificacionPerfilOpcion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmodificacionPerfilOpcion() {
		return this.resaltarmodificacionPerfilOpcion;
	}

	public void setResaltarmodificacionPerfilOpcion(Border borderResaltar) {
		this.resaltarmodificacionPerfilOpcion= borderResaltar;
	}

	public Boolean getMostrarmodificacionPerfilOpcion() {
		return this.mostrarmodificacionPerfilOpcion;
	}

	public void setMostrarmodificacionPerfilOpcion(Boolean mostrarmodificacionPerfilOpcion) {
		this.mostrarmodificacionPerfilOpcion= mostrarmodificacionPerfilOpcion;
	}

	public Boolean getActivarmodificacionPerfilOpcion() {
		return this.activarmodificacionPerfilOpcion;
	}

	public void setActivarmodificacionPerfilOpcion(Boolean activarmodificacionPerfilOpcion) {
		this.activarmodificacionPerfilOpcion= activarmodificacionPerfilOpcion;
	}

	public Border setResaltareliminacionPerfilOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*PerfilOpcionBeanSwingJInternalFrame perfilopcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//perfilopcionBeanSwingJInternalFrame.jTtoolBarPerfilOpcion.setBorder(borderResaltar);
		
		this.resaltareliminacionPerfilOpcion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltareliminacionPerfilOpcion() {
		return this.resaltareliminacionPerfilOpcion;
	}

	public void setResaltareliminacionPerfilOpcion(Border borderResaltar) {
		this.resaltareliminacionPerfilOpcion= borderResaltar;
	}

	public Boolean getMostrareliminacionPerfilOpcion() {
		return this.mostrareliminacionPerfilOpcion;
	}

	public void setMostrareliminacionPerfilOpcion(Boolean mostrareliminacionPerfilOpcion) {
		this.mostrareliminacionPerfilOpcion= mostrareliminacionPerfilOpcion;
	}

	public Boolean getActivareliminacionPerfilOpcion() {
		return this.activareliminacionPerfilOpcion;
	}

	public void setActivareliminacionPerfilOpcion(Boolean activareliminacionPerfilOpcion) {
		this.activareliminacionPerfilOpcion= activareliminacionPerfilOpcion;
	}

	public Border setResaltarguardar_cambiosPerfilOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*PerfilOpcionBeanSwingJInternalFrame perfilopcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//perfilopcionBeanSwingJInternalFrame.jTtoolBarPerfilOpcion.setBorder(borderResaltar);
		
		this.resaltarguardar_cambiosPerfilOpcion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarguardar_cambiosPerfilOpcion() {
		return this.resaltarguardar_cambiosPerfilOpcion;
	}

	public void setResaltarguardar_cambiosPerfilOpcion(Border borderResaltar) {
		this.resaltarguardar_cambiosPerfilOpcion= borderResaltar;
	}

	public Boolean getMostrarguardar_cambiosPerfilOpcion() {
		return this.mostrarguardar_cambiosPerfilOpcion;
	}

	public void setMostrarguardar_cambiosPerfilOpcion(Boolean mostrarguardar_cambiosPerfilOpcion) {
		this.mostrarguardar_cambiosPerfilOpcion= mostrarguardar_cambiosPerfilOpcion;
	}

	public Boolean getActivarguardar_cambiosPerfilOpcion() {
		return this.activarguardar_cambiosPerfilOpcion;
	}

	public void setActivarguardar_cambiosPerfilOpcion(Boolean activarguardar_cambiosPerfilOpcion) {
		this.activarguardar_cambiosPerfilOpcion= activarguardar_cambiosPerfilOpcion;
	}

	public Border setResaltarconsultaPerfilOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*PerfilOpcionBeanSwingJInternalFrame perfilopcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//perfilopcionBeanSwingJInternalFrame.jTtoolBarPerfilOpcion.setBorder(borderResaltar);
		
		this.resaltarconsultaPerfilOpcion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarconsultaPerfilOpcion() {
		return this.resaltarconsultaPerfilOpcion;
	}

	public void setResaltarconsultaPerfilOpcion(Border borderResaltar) {
		this.resaltarconsultaPerfilOpcion= borderResaltar;
	}

	public Boolean getMostrarconsultaPerfilOpcion() {
		return this.mostrarconsultaPerfilOpcion;
	}

	public void setMostrarconsultaPerfilOpcion(Boolean mostrarconsultaPerfilOpcion) {
		this.mostrarconsultaPerfilOpcion= mostrarconsultaPerfilOpcion;
	}

	public Boolean getActivarconsultaPerfilOpcion() {
		return this.activarconsultaPerfilOpcion;
	}

	public void setActivarconsultaPerfilOpcion(Boolean activarconsultaPerfilOpcion) {
		this.activarconsultaPerfilOpcion= activarconsultaPerfilOpcion;
	}

	public Border setResaltarbusquedaPerfilOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*PerfilOpcionBeanSwingJInternalFrame perfilopcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//perfilopcionBeanSwingJInternalFrame.jTtoolBarPerfilOpcion.setBorder(borderResaltar);
		
		this.resaltarbusquedaPerfilOpcion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarbusquedaPerfilOpcion() {
		return this.resaltarbusquedaPerfilOpcion;
	}

	public void setResaltarbusquedaPerfilOpcion(Border borderResaltar) {
		this.resaltarbusquedaPerfilOpcion= borderResaltar;
	}

	public Boolean getMostrarbusquedaPerfilOpcion() {
		return this.mostrarbusquedaPerfilOpcion;
	}

	public void setMostrarbusquedaPerfilOpcion(Boolean mostrarbusquedaPerfilOpcion) {
		this.mostrarbusquedaPerfilOpcion= mostrarbusquedaPerfilOpcion;
	}

	public Boolean getActivarbusquedaPerfilOpcion() {
		return this.activarbusquedaPerfilOpcion;
	}

	public void setActivarbusquedaPerfilOpcion(Boolean activarbusquedaPerfilOpcion) {
		this.activarbusquedaPerfilOpcion= activarbusquedaPerfilOpcion;
	}

	public Border setResaltarreportePerfilOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*PerfilOpcionBeanSwingJInternalFrame perfilopcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//perfilopcionBeanSwingJInternalFrame.jTtoolBarPerfilOpcion.setBorder(borderResaltar);
		
		this.resaltarreportePerfilOpcion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarreportePerfilOpcion() {
		return this.resaltarreportePerfilOpcion;
	}

	public void setResaltarreportePerfilOpcion(Border borderResaltar) {
		this.resaltarreportePerfilOpcion= borderResaltar;
	}

	public Boolean getMostrarreportePerfilOpcion() {
		return this.mostrarreportePerfilOpcion;
	}

	public void setMostrarreportePerfilOpcion(Boolean mostrarreportePerfilOpcion) {
		this.mostrarreportePerfilOpcion= mostrarreportePerfilOpcion;
	}

	public Boolean getActivarreportePerfilOpcion() {
		return this.activarreportePerfilOpcion;
	}

	public void setActivarreportePerfilOpcion(Boolean activarreportePerfilOpcion) {
		this.activarreportePerfilOpcion= activarreportePerfilOpcion;
	}

	public Border setResaltarordenPerfilOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*PerfilOpcionBeanSwingJInternalFrame perfilopcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//perfilopcionBeanSwingJInternalFrame.jTtoolBarPerfilOpcion.setBorder(borderResaltar);
		
		this.resaltarordenPerfilOpcion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarordenPerfilOpcion() {
		return this.resaltarordenPerfilOpcion;
	}

	public void setResaltarordenPerfilOpcion(Border borderResaltar) {
		this.resaltarordenPerfilOpcion= borderResaltar;
	}

	public Boolean getMostrarordenPerfilOpcion() {
		return this.mostrarordenPerfilOpcion;
	}

	public void setMostrarordenPerfilOpcion(Boolean mostrarordenPerfilOpcion) {
		this.mostrarordenPerfilOpcion= mostrarordenPerfilOpcion;
	}

	public Boolean getActivarordenPerfilOpcion() {
		return this.activarordenPerfilOpcion;
	}

	public void setActivarordenPerfilOpcion(Boolean activarordenPerfilOpcion) {
		this.activarordenPerfilOpcion= activarordenPerfilOpcion;
	}

	public Border setResaltarpaginacion_medioPerfilOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*PerfilOpcionBeanSwingJInternalFrame perfilopcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//perfilopcionBeanSwingJInternalFrame.jTtoolBarPerfilOpcion.setBorder(borderResaltar);
		
		this.resaltarpaginacion_medioPerfilOpcion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarpaginacion_medioPerfilOpcion() {
		return this.resaltarpaginacion_medioPerfilOpcion;
	}

	public void setResaltarpaginacion_medioPerfilOpcion(Border borderResaltar) {
		this.resaltarpaginacion_medioPerfilOpcion= borderResaltar;
	}

	public Boolean getMostrarpaginacion_medioPerfilOpcion() {
		return this.mostrarpaginacion_medioPerfilOpcion;
	}

	public void setMostrarpaginacion_medioPerfilOpcion(Boolean mostrarpaginacion_medioPerfilOpcion) {
		this.mostrarpaginacion_medioPerfilOpcion= mostrarpaginacion_medioPerfilOpcion;
	}

	public Boolean getActivarpaginacion_medioPerfilOpcion() {
		return this.activarpaginacion_medioPerfilOpcion;
	}

	public void setActivarpaginacion_medioPerfilOpcion(Boolean activarpaginacion_medioPerfilOpcion) {
		this.activarpaginacion_medioPerfilOpcion= activarpaginacion_medioPerfilOpcion;
	}

	public Border setResaltarpaginacion_altoPerfilOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*PerfilOpcionBeanSwingJInternalFrame perfilopcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//perfilopcionBeanSwingJInternalFrame.jTtoolBarPerfilOpcion.setBorder(borderResaltar);
		
		this.resaltarpaginacion_altoPerfilOpcion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarpaginacion_altoPerfilOpcion() {
		return this.resaltarpaginacion_altoPerfilOpcion;
	}

	public void setResaltarpaginacion_altoPerfilOpcion(Border borderResaltar) {
		this.resaltarpaginacion_altoPerfilOpcion= borderResaltar;
	}

	public Boolean getMostrarpaginacion_altoPerfilOpcion() {
		return this.mostrarpaginacion_altoPerfilOpcion;
	}

	public void setMostrarpaginacion_altoPerfilOpcion(Boolean mostrarpaginacion_altoPerfilOpcion) {
		this.mostrarpaginacion_altoPerfilOpcion= mostrarpaginacion_altoPerfilOpcion;
	}

	public Boolean getActivarpaginacion_altoPerfilOpcion() {
		return this.activarpaginacion_altoPerfilOpcion;
	}

	public void setActivarpaginacion_altoPerfilOpcion(Boolean activarpaginacion_altoPerfilOpcion) {
		this.activarpaginacion_altoPerfilOpcion= activarpaginacion_altoPerfilOpcion;
	}

	public Border setResaltarpaginacion_todoPerfilOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*PerfilOpcionBeanSwingJInternalFrame perfilopcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//perfilopcionBeanSwingJInternalFrame.jTtoolBarPerfilOpcion.setBorder(borderResaltar);
		
		this.resaltarpaginacion_todoPerfilOpcion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarpaginacion_todoPerfilOpcion() {
		return this.resaltarpaginacion_todoPerfilOpcion;
	}

	public void setResaltarpaginacion_todoPerfilOpcion(Border borderResaltar) {
		this.resaltarpaginacion_todoPerfilOpcion= borderResaltar;
	}

	public Boolean getMostrarpaginacion_todoPerfilOpcion() {
		return this.mostrarpaginacion_todoPerfilOpcion;
	}

	public void setMostrarpaginacion_todoPerfilOpcion(Boolean mostrarpaginacion_todoPerfilOpcion) {
		this.mostrarpaginacion_todoPerfilOpcion= mostrarpaginacion_todoPerfilOpcion;
	}

	public Boolean getActivarpaginacion_todoPerfilOpcion() {
		return this.activarpaginacion_todoPerfilOpcion;
	}

	public void setActivarpaginacion_todoPerfilOpcion(Boolean activarpaginacion_todoPerfilOpcion) {
		this.activarpaginacion_todoPerfilOpcion= activarpaginacion_todoPerfilOpcion;
	}

	public Border setResaltarduplicarPerfilOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*PerfilOpcionBeanSwingJInternalFrame perfilopcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//perfilopcionBeanSwingJInternalFrame.jTtoolBarPerfilOpcion.setBorder(borderResaltar);
		
		this.resaltarduplicarPerfilOpcion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarduplicarPerfilOpcion() {
		return this.resaltarduplicarPerfilOpcion;
	}

	public void setResaltarduplicarPerfilOpcion(Border borderResaltar) {
		this.resaltarduplicarPerfilOpcion= borderResaltar;
	}

	public Boolean getMostrarduplicarPerfilOpcion() {
		return this.mostrarduplicarPerfilOpcion;
	}

	public void setMostrarduplicarPerfilOpcion(Boolean mostrarduplicarPerfilOpcion) {
		this.mostrarduplicarPerfilOpcion= mostrarduplicarPerfilOpcion;
	}

	public Boolean getActivarduplicarPerfilOpcion() {
		return this.activarduplicarPerfilOpcion;
	}

	public void setActivarduplicarPerfilOpcion(Boolean activarduplicarPerfilOpcion) {
		this.activarduplicarPerfilOpcion= activarduplicarPerfilOpcion;
	}

	public Border setResaltarcopiarPerfilOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*PerfilOpcionBeanSwingJInternalFrame perfilopcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//perfilopcionBeanSwingJInternalFrame.jTtoolBarPerfilOpcion.setBorder(borderResaltar);
		
		this.resaltarcopiarPerfilOpcion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcopiarPerfilOpcion() {
		return this.resaltarcopiarPerfilOpcion;
	}

	public void setResaltarcopiarPerfilOpcion(Border borderResaltar) {
		this.resaltarcopiarPerfilOpcion= borderResaltar;
	}

	public Boolean getMostrarcopiarPerfilOpcion() {
		return this.mostrarcopiarPerfilOpcion;
	}

	public void setMostrarcopiarPerfilOpcion(Boolean mostrarcopiarPerfilOpcion) {
		this.mostrarcopiarPerfilOpcion= mostrarcopiarPerfilOpcion;
	}

	public Boolean getActivarcopiarPerfilOpcion() {
		return this.activarcopiarPerfilOpcion;
	}

	public void setActivarcopiarPerfilOpcion(Boolean activarcopiarPerfilOpcion) {
		this.activarcopiarPerfilOpcion= activarcopiarPerfilOpcion;
	}

	public Border setResaltarcon_precargarPerfilOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*PerfilOpcionBeanSwingJInternalFrame perfilopcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//perfilopcionBeanSwingJInternalFrame.jTtoolBarPerfilOpcion.setBorder(borderResaltar);
		
		this.resaltarcon_precargarPerfilOpcion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_precargarPerfilOpcion() {
		return this.resaltarcon_precargarPerfilOpcion;
	}

	public void setResaltarcon_precargarPerfilOpcion(Border borderResaltar) {
		this.resaltarcon_precargarPerfilOpcion= borderResaltar;
	}

	public Boolean getMostrarcon_precargarPerfilOpcion() {
		return this.mostrarcon_precargarPerfilOpcion;
	}

	public void setMostrarcon_precargarPerfilOpcion(Boolean mostrarcon_precargarPerfilOpcion) {
		this.mostrarcon_precargarPerfilOpcion= mostrarcon_precargarPerfilOpcion;
	}

	public Boolean getActivarcon_precargarPerfilOpcion() {
		return this.activarcon_precargarPerfilOpcion;
	}

	public void setActivarcon_precargarPerfilOpcion(Boolean activarcon_precargarPerfilOpcion) {
		this.activarcon_precargarPerfilOpcion= activarcon_precargarPerfilOpcion;
	}

	public Border setResaltarestadoPerfilOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*PerfilOpcionBeanSwingJInternalFrame perfilopcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//perfilopcionBeanSwingJInternalFrame.jTtoolBarPerfilOpcion.setBorder(borderResaltar);
		
		this.resaltarestadoPerfilOpcion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarestadoPerfilOpcion() {
		return this.resaltarestadoPerfilOpcion;
	}

	public void setResaltarestadoPerfilOpcion(Border borderResaltar) {
		this.resaltarestadoPerfilOpcion= borderResaltar;
	}

	public Boolean getMostrarestadoPerfilOpcion() {
		return this.mostrarestadoPerfilOpcion;
	}

	public void setMostrarestadoPerfilOpcion(Boolean mostrarestadoPerfilOpcion) {
		this.mostrarestadoPerfilOpcion= mostrarestadoPerfilOpcion;
	}

	public Boolean getActivarestadoPerfilOpcion() {
		return this.activarestadoPerfilOpcion;
	}

	public void setActivarestadoPerfilOpcion(Boolean activarestadoPerfilOpcion) {
		this.activarestadoPerfilOpcion= activarestadoPerfilOpcion;
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
		
		
		this.setMostraridPerfilOpcion(esInicial);
		this.setMostrarid_sistemaPerfilOpcion(esInicial);
		this.setMostrarid_moduloPerfilOpcion(esInicial);
		this.setMostrarid_grupo_opcionPerfilOpcion(esInicial);
		this.setMostrarid_perfilPerfilOpcion(esInicial);
		this.setMostrarid_opcionPerfilOpcion(esInicial);
		this.setMostrartodoPerfilOpcion(esInicial);
		this.setMostraringresoPerfilOpcion(esInicial);
		this.setMostrarmodificacionPerfilOpcion(esInicial);
		this.setMostrareliminacionPerfilOpcion(esInicial);
		this.setMostrarguardar_cambiosPerfilOpcion(esInicial);
		this.setMostrarconsultaPerfilOpcion(esInicial);
		this.setMostrarbusquedaPerfilOpcion(esInicial);
		this.setMostrarreportePerfilOpcion(esInicial);
		this.setMostrarordenPerfilOpcion(esInicial);
		this.setMostrarpaginacion_medioPerfilOpcion(esInicial);
		this.setMostrarpaginacion_altoPerfilOpcion(esInicial);
		this.setMostrarpaginacion_todoPerfilOpcion(esInicial);
		this.setMostrarduplicarPerfilOpcion(esInicial);
		this.setMostrarcopiarPerfilOpcion(esInicial);
		this.setMostrarcon_precargarPerfilOpcion(esInicial);
		this.setMostrarestadoPerfilOpcion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PerfilOpcionConstantesFunciones.ID)) {
				this.setMostraridPerfilOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilOpcionConstantesFunciones.IDSISTEMA)) {
				this.setMostrarid_sistemaPerfilOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilOpcionConstantesFunciones.IDMODULO)) {
				this.setMostrarid_moduloPerfilOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilOpcionConstantesFunciones.IDGRUPOOPCION)) {
				this.setMostrarid_grupo_opcionPerfilOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilOpcionConstantesFunciones.IDPERFIL)) {
				this.setMostrarid_perfilPerfilOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilOpcionConstantesFunciones.IDOPCION)) {
				this.setMostrarid_opcionPerfilOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilOpcionConstantesFunciones.TODO)) {
				this.setMostrartodoPerfilOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilOpcionConstantesFunciones.INGRESO)) {
				this.setMostraringresoPerfilOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilOpcionConstantesFunciones.MODIFICACION)) {
				this.setMostrarmodificacionPerfilOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilOpcionConstantesFunciones.ELIMINACION)) {
				this.setMostrareliminacionPerfilOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilOpcionConstantesFunciones.GUARDARCAMBIOS)) {
				this.setMostrarguardar_cambiosPerfilOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilOpcionConstantesFunciones.CONSULTA)) {
				this.setMostrarconsultaPerfilOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilOpcionConstantesFunciones.BUSQUEDA)) {
				this.setMostrarbusquedaPerfilOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilOpcionConstantesFunciones.REPORTE)) {
				this.setMostrarreportePerfilOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilOpcionConstantesFunciones.ORDEN)) {
				this.setMostrarordenPerfilOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilOpcionConstantesFunciones.PAGINACIONMEDIO)) {
				this.setMostrarpaginacion_medioPerfilOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilOpcionConstantesFunciones.PAGINACIONALTO)) {
				this.setMostrarpaginacion_altoPerfilOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilOpcionConstantesFunciones.PAGINACIONTODO)) {
				this.setMostrarpaginacion_todoPerfilOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilOpcionConstantesFunciones.DUPLICAR)) {
				this.setMostrarduplicarPerfilOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilOpcionConstantesFunciones.COPIAR)) {
				this.setMostrarcopiarPerfilOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilOpcionConstantesFunciones.CONPRECARGAR)) {
				this.setMostrarcon_precargarPerfilOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilOpcionConstantesFunciones.ESTADO)) {
				this.setMostrarestadoPerfilOpcion(esAsigna);
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
		
		
		this.setActivaridPerfilOpcion(esInicial);
		this.setActivarid_sistemaPerfilOpcion(esInicial);
		this.setActivarid_moduloPerfilOpcion(esInicial);
		this.setActivarid_grupo_opcionPerfilOpcion(esInicial);
		this.setActivarid_perfilPerfilOpcion(esInicial);
		this.setActivarid_opcionPerfilOpcion(esInicial);
		this.setActivartodoPerfilOpcion(esInicial);
		this.setActivaringresoPerfilOpcion(esInicial);
		this.setActivarmodificacionPerfilOpcion(esInicial);
		this.setActivareliminacionPerfilOpcion(esInicial);
		this.setActivarguardar_cambiosPerfilOpcion(esInicial);
		this.setActivarconsultaPerfilOpcion(esInicial);
		this.setActivarbusquedaPerfilOpcion(esInicial);
		this.setActivarreportePerfilOpcion(esInicial);
		this.setActivarordenPerfilOpcion(esInicial);
		this.setActivarpaginacion_medioPerfilOpcion(esInicial);
		this.setActivarpaginacion_altoPerfilOpcion(esInicial);
		this.setActivarpaginacion_todoPerfilOpcion(esInicial);
		this.setActivarduplicarPerfilOpcion(esInicial);
		this.setActivarcopiarPerfilOpcion(esInicial);
		this.setActivarcon_precargarPerfilOpcion(esInicial);
		this.setActivarestadoPerfilOpcion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PerfilOpcionConstantesFunciones.ID)) {
				this.setActivaridPerfilOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilOpcionConstantesFunciones.IDSISTEMA)) {
				this.setActivarid_sistemaPerfilOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilOpcionConstantesFunciones.IDMODULO)) {
				this.setActivarid_moduloPerfilOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilOpcionConstantesFunciones.IDGRUPOOPCION)) {
				this.setActivarid_grupo_opcionPerfilOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilOpcionConstantesFunciones.IDPERFIL)) {
				this.setActivarid_perfilPerfilOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilOpcionConstantesFunciones.IDOPCION)) {
				this.setActivarid_opcionPerfilOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilOpcionConstantesFunciones.TODO)) {
				this.setActivartodoPerfilOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilOpcionConstantesFunciones.INGRESO)) {
				this.setActivaringresoPerfilOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilOpcionConstantesFunciones.MODIFICACION)) {
				this.setActivarmodificacionPerfilOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilOpcionConstantesFunciones.ELIMINACION)) {
				this.setActivareliminacionPerfilOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilOpcionConstantesFunciones.GUARDARCAMBIOS)) {
				this.setActivarguardar_cambiosPerfilOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilOpcionConstantesFunciones.CONSULTA)) {
				this.setActivarconsultaPerfilOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilOpcionConstantesFunciones.BUSQUEDA)) {
				this.setActivarbusquedaPerfilOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilOpcionConstantesFunciones.REPORTE)) {
				this.setActivarreportePerfilOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilOpcionConstantesFunciones.ORDEN)) {
				this.setActivarordenPerfilOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilOpcionConstantesFunciones.PAGINACIONMEDIO)) {
				this.setActivarpaginacion_medioPerfilOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilOpcionConstantesFunciones.PAGINACIONALTO)) {
				this.setActivarpaginacion_altoPerfilOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilOpcionConstantesFunciones.PAGINACIONTODO)) {
				this.setActivarpaginacion_todoPerfilOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilOpcionConstantesFunciones.DUPLICAR)) {
				this.setActivarduplicarPerfilOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilOpcionConstantesFunciones.COPIAR)) {
				this.setActivarcopiarPerfilOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilOpcionConstantesFunciones.CONPRECARGAR)) {
				this.setActivarcon_precargarPerfilOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilOpcionConstantesFunciones.ESTADO)) {
				this.setActivarestadoPerfilOpcion(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,PerfilOpcionBeanSwingJInternalFrame perfilopcionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridPerfilOpcion(esInicial);
		this.setResaltarid_sistemaPerfilOpcion(esInicial);
		this.setResaltarid_moduloPerfilOpcion(esInicial);
		this.setResaltarid_grupo_opcionPerfilOpcion(esInicial);
		this.setResaltarid_perfilPerfilOpcion(esInicial);
		this.setResaltarid_opcionPerfilOpcion(esInicial);
		this.setResaltartodoPerfilOpcion(esInicial);
		this.setResaltaringresoPerfilOpcion(esInicial);
		this.setResaltarmodificacionPerfilOpcion(esInicial);
		this.setResaltareliminacionPerfilOpcion(esInicial);
		this.setResaltarguardar_cambiosPerfilOpcion(esInicial);
		this.setResaltarconsultaPerfilOpcion(esInicial);
		this.setResaltarbusquedaPerfilOpcion(esInicial);
		this.setResaltarreportePerfilOpcion(esInicial);
		this.setResaltarordenPerfilOpcion(esInicial);
		this.setResaltarpaginacion_medioPerfilOpcion(esInicial);
		this.setResaltarpaginacion_altoPerfilOpcion(esInicial);
		this.setResaltarpaginacion_todoPerfilOpcion(esInicial);
		this.setResaltarduplicarPerfilOpcion(esInicial);
		this.setResaltarcopiarPerfilOpcion(esInicial);
		this.setResaltarcon_precargarPerfilOpcion(esInicial);
		this.setResaltarestadoPerfilOpcion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PerfilOpcionConstantesFunciones.ID)) {
				this.setResaltaridPerfilOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilOpcionConstantesFunciones.IDSISTEMA)) {
				this.setResaltarid_sistemaPerfilOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilOpcionConstantesFunciones.IDMODULO)) {
				this.setResaltarid_moduloPerfilOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilOpcionConstantesFunciones.IDGRUPOOPCION)) {
				this.setResaltarid_grupo_opcionPerfilOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilOpcionConstantesFunciones.IDPERFIL)) {
				this.setResaltarid_perfilPerfilOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilOpcionConstantesFunciones.IDOPCION)) {
				this.setResaltarid_opcionPerfilOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilOpcionConstantesFunciones.TODO)) {
				this.setResaltartodoPerfilOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilOpcionConstantesFunciones.INGRESO)) {
				this.setResaltaringresoPerfilOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilOpcionConstantesFunciones.MODIFICACION)) {
				this.setResaltarmodificacionPerfilOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilOpcionConstantesFunciones.ELIMINACION)) {
				this.setResaltareliminacionPerfilOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilOpcionConstantesFunciones.GUARDARCAMBIOS)) {
				this.setResaltarguardar_cambiosPerfilOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilOpcionConstantesFunciones.CONSULTA)) {
				this.setResaltarconsultaPerfilOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilOpcionConstantesFunciones.BUSQUEDA)) {
				this.setResaltarbusquedaPerfilOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilOpcionConstantesFunciones.REPORTE)) {
				this.setResaltarreportePerfilOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilOpcionConstantesFunciones.ORDEN)) {
				this.setResaltarordenPerfilOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilOpcionConstantesFunciones.PAGINACIONMEDIO)) {
				this.setResaltarpaginacion_medioPerfilOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilOpcionConstantesFunciones.PAGINACIONALTO)) {
				this.setResaltarpaginacion_altoPerfilOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilOpcionConstantesFunciones.PAGINACIONTODO)) {
				this.setResaltarpaginacion_todoPerfilOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilOpcionConstantesFunciones.DUPLICAR)) {
				this.setResaltarduplicarPerfilOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilOpcionConstantesFunciones.COPIAR)) {
				this.setResaltarcopiarPerfilOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilOpcionConstantesFunciones.CONPRECARGAR)) {
				this.setResaltarcon_precargarPerfilOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilOpcionConstantesFunciones.ESTADO)) {
				this.setResaltarestadoPerfilOpcion(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,PerfilOpcionBeanSwingJInternalFrame perfilopcionBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPorIdPerfilPorIdOpcionPerfilOpcion=true;

	public Boolean getMostrarBusquedaPorIdPerfilPorIdOpcionPerfilOpcion() {
		return this.mostrarBusquedaPorIdPerfilPorIdOpcionPerfilOpcion;
	}

	public void setMostrarBusquedaPorIdPerfilPorIdOpcionPerfilOpcion(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorIdPerfilPorIdOpcionPerfilOpcion= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorIdSisPorIdModPorIdPerPerfilOpcion=true;

	public Boolean getMostrarBusquedaPorIdSisPorIdModPorIdPerPerfilOpcion() {
		return this.mostrarBusquedaPorIdSisPorIdModPorIdPerPerfilOpcion;
	}

	public void setMostrarBusquedaPorIdSisPorIdModPorIdPerPerfilOpcion(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorIdSisPorIdModPorIdPerPerfilOpcion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdGrupoOpcionPerfilOpcion=true;

	public Boolean getMostrarFK_IdGrupoOpcionPerfilOpcion() {
		return this.mostrarFK_IdGrupoOpcionPerfilOpcion;
	}

	public void setMostrarFK_IdGrupoOpcionPerfilOpcion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdGrupoOpcionPerfilOpcion= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorIdPerfilPorIdOpcionPerfilOpcion=true;

	public Boolean getActivarBusquedaPorIdPerfilPorIdOpcionPerfilOpcion() {
		return this.activarBusquedaPorIdPerfilPorIdOpcionPerfilOpcion;
	}

	public void setActivarBusquedaPorIdPerfilPorIdOpcionPerfilOpcion(Boolean habilitarResaltar) {
		this.activarBusquedaPorIdPerfilPorIdOpcionPerfilOpcion= habilitarResaltar;
	}

	public Boolean activarBusquedaPorIdSisPorIdModPorIdPerPerfilOpcion=true;

	public Boolean getActivarBusquedaPorIdSisPorIdModPorIdPerPerfilOpcion() {
		return this.activarBusquedaPorIdSisPorIdModPorIdPerPerfilOpcion;
	}

	public void setActivarBusquedaPorIdSisPorIdModPorIdPerPerfilOpcion(Boolean habilitarResaltar) {
		this.activarBusquedaPorIdSisPorIdModPorIdPerPerfilOpcion= habilitarResaltar;
	}

	public Boolean activarFK_IdGrupoOpcionPerfilOpcion=true;

	public Boolean getActivarFK_IdGrupoOpcionPerfilOpcion() {
		return this.activarFK_IdGrupoOpcionPerfilOpcion;
	}

	public void setActivarFK_IdGrupoOpcionPerfilOpcion(Boolean habilitarResaltar) {
		this.activarFK_IdGrupoOpcionPerfilOpcion= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorIdPerfilPorIdOpcionPerfilOpcion=null;

	public Border getResaltarBusquedaPorIdPerfilPorIdOpcionPerfilOpcion() {
		return this.resaltarBusquedaPorIdPerfilPorIdOpcionPerfilOpcion;
	}

	public void setResaltarBusquedaPorIdPerfilPorIdOpcionPerfilOpcion(Border borderResaltar) {
		this.resaltarBusquedaPorIdPerfilPorIdOpcionPerfilOpcion= borderResaltar;
	}

	public void setResaltarBusquedaPorIdPerfilPorIdOpcionPerfilOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*PerfilOpcionBeanSwingJInternalFrame perfilopcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorIdPerfilPorIdOpcionPerfilOpcion= borderResaltar;
	}

	public Border resaltarBusquedaPorIdSisPorIdModPorIdPerPerfilOpcion=null;

	public Border getResaltarBusquedaPorIdSisPorIdModPorIdPerPerfilOpcion() {
		return this.resaltarBusquedaPorIdSisPorIdModPorIdPerPerfilOpcion;
	}

	public void setResaltarBusquedaPorIdSisPorIdModPorIdPerPerfilOpcion(Border borderResaltar) {
		this.resaltarBusquedaPorIdSisPorIdModPorIdPerPerfilOpcion= borderResaltar;
	}

	public void setResaltarBusquedaPorIdSisPorIdModPorIdPerPerfilOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*PerfilOpcionBeanSwingJInternalFrame perfilopcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorIdSisPorIdModPorIdPerPerfilOpcion= borderResaltar;
	}

	public Border resaltarFK_IdGrupoOpcionPerfilOpcion=null;

	public Border getResaltarFK_IdGrupoOpcionPerfilOpcion() {
		return this.resaltarFK_IdGrupoOpcionPerfilOpcion;
	}

	public void setResaltarFK_IdGrupoOpcionPerfilOpcion(Border borderResaltar) {
		this.resaltarFK_IdGrupoOpcionPerfilOpcion= borderResaltar;
	}

	public void setResaltarFK_IdGrupoOpcionPerfilOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*PerfilOpcionBeanSwingJInternalFrame perfilopcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdGrupoOpcionPerfilOpcion= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}