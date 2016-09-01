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


import com.bydan.erp.seguridad.util.OpcionConstantesFunciones;
import com.bydan.erp.seguridad.util.OpcionParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.OpcionParameterGeneral;

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
final public class OpcionConstantesFunciones extends OpcionConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Opcion";
	public static final String SPATHOPCION="Seguridad";	
	public static final String SPATHMODULO="seguridad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Opcion"+OpcionConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="OpcionHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="OpcionHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=OpcionConstantesFunciones.SCHEMA+"_"+OpcionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/OpcionHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=OpcionConstantesFunciones.SCHEMA+"_"+OpcionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=OpcionConstantesFunciones.SCHEMA+"_"+OpcionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/OpcionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=OpcionConstantesFunciones.SCHEMA+"_"+OpcionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+OpcionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/OpcionHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+OpcionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+OpcionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/OpcionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+OpcionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=OpcionConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+OpcionConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=OpcionConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+OpcionConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Opciones";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Opcion";
	public static final String SCLASSWEBTITULO_LOWER="Opcion";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Opcion";
	public static final String OBJECTNAME="opcion";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SEGURIDAD;	
	public static final String TABLENAME="opcion";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select opcion from "+OpcionConstantesFunciones.SPERSISTENCENAME+" opcion";
	public static String QUERYSELECTNATIVE="select "+OpcionConstantesFunciones.SCHEMA+"."+OpcionConstantesFunciones.TABLENAME+".id,"+OpcionConstantesFunciones.SCHEMA+"."+OpcionConstantesFunciones.TABLENAME+".version_row,"+OpcionConstantesFunciones.SCHEMA+"."+OpcionConstantesFunciones.TABLENAME+".id_sistema,"+OpcionConstantesFunciones.SCHEMA+"."+OpcionConstantesFunciones.TABLENAME+".id_modulo,"+OpcionConstantesFunciones.SCHEMA+"."+OpcionConstantesFunciones.TABLENAME+".id_grupo_opcion,"+OpcionConstantesFunciones.SCHEMA+"."+OpcionConstantesFunciones.TABLENAME+".id_opcion,"+OpcionConstantesFunciones.SCHEMA+"."+OpcionConstantesFunciones.TABLENAME+".codigo,"+OpcionConstantesFunciones.SCHEMA+"."+OpcionConstantesFunciones.TABLENAME+".nombre,"+OpcionConstantesFunciones.SCHEMA+"."+OpcionConstantesFunciones.TABLENAME+".id_tipo_tecla_mascara,"+OpcionConstantesFunciones.SCHEMA+"."+OpcionConstantesFunciones.TABLENAME+".tecla,"+OpcionConstantesFunciones.SCHEMA+"."+OpcionConstantesFunciones.TABLENAME+".posicion,"+OpcionConstantesFunciones.SCHEMA+"."+OpcionConstantesFunciones.TABLENAME+".icon_name,"+OpcionConstantesFunciones.SCHEMA+"."+OpcionConstantesFunciones.TABLENAME+".nombre_clase,"+OpcionConstantesFunciones.SCHEMA+"."+OpcionConstantesFunciones.TABLENAME+".sub_modulo,"+OpcionConstantesFunciones.SCHEMA+"."+OpcionConstantesFunciones.TABLENAME+".paquete,"+OpcionConstantesFunciones.SCHEMA+"."+OpcionConstantesFunciones.TABLENAME+".paquete_original,"+OpcionConstantesFunciones.SCHEMA+"."+OpcionConstantesFunciones.TABLENAME+".path_auxiliar,"+OpcionConstantesFunciones.SCHEMA+"."+OpcionConstantesFunciones.TABLENAME+".es_para_menu,"+OpcionConstantesFunciones.SCHEMA+"."+OpcionConstantesFunciones.TABLENAME+".con_mostrar_acciones_campo,"+OpcionConstantesFunciones.SCHEMA+"."+OpcionConstantesFunciones.TABLENAME+".es_guardar_relaciones,"+OpcionConstantesFunciones.SCHEMA+"."+OpcionConstantesFunciones.TABLENAME+".estado from "+OpcionConstantesFunciones.SCHEMA+"."+OpcionConstantesFunciones.TABLENAME;//+" as "+OpcionConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=true;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected OpcionConstantesFuncionesAdditional opcionConstantesFuncionesAdditional=null;
	
	public OpcionConstantesFuncionesAdditional getOpcionConstantesFuncionesAdditional() {
		return this.opcionConstantesFuncionesAdditional;
	}
	
	public void setOpcionConstantesFuncionesAdditional(OpcionConstantesFuncionesAdditional opcionConstantesFuncionesAdditional) {
		try {
			this.opcionConstantesFuncionesAdditional=opcionConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDSISTEMA= "id_sistema";
    public static final String IDMODULO= "id_modulo";
    public static final String IDGRUPOOPCION= "id_grupo_opcion";
    public static final String IDOPCION= "id_opcion";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String IDTIPOTECLAMASCARA= "id_tipo_tecla_mascara";
    public static final String TECLA= "tecla";
    public static final String POSICION= "posicion";
    public static final String ICONNAME= "icon_name";
    public static final String NOMBRECLASE= "nombre_clase";
    public static final String SUBMODULO= "sub_modulo";
    public static final String PAQUETE= "paquete";
    public static final String PAQUETEORIGINAL= "paquete_original";
    public static final String PATHAUXILIAR= "path_auxiliar";
    public static final String ESPARAMENU= "es_para_menu";
    public static final String CONMOSTRARACCIONESCAMPO= "con_mostrar_acciones_campo";
    public static final String ESGUARDARRELACIONES= "es_guardar_relaciones";
    public static final String ESTADO= "estado";
	//TITULO CAMPO
    	public static final String LABEL_ID= "A";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "A";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDSISTEMA= "Sistema";
		public static final String LABEL_IDSISTEMA_LOWER= "Sistema";
    	public static final String LABEL_IDMODULO= "Modulo";
		public static final String LABEL_IDMODULO_LOWER= "Modulo";
    	public static final String LABEL_IDGRUPOOPCION= "Grupo Opcion";
		public static final String LABEL_IDGRUPOOPCION_LOWER= "Grupo Opcion";
    	public static final String LABEL_IDOPCION= "Opcion";
		public static final String LABEL_IDOPCION_LOWER= "Opcion";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_IDTIPOTECLAMASCARA= "Tecla Mascara";
		public static final String LABEL_IDTIPOTECLAMASCARA_LOWER= "Tipo Tecla Mascara";
    	public static final String LABEL_TECLA= "Tecla";
		public static final String LABEL_TECLA_LOWER= "Tecla";
    	public static final String LABEL_POSICION= "Posicion";
		public static final String LABEL_POSICION_LOWER= "Posicion";
    	public static final String LABEL_ICONNAME= "Path Del Icono";
		public static final String LABEL_ICONNAME_LOWER= "Icon Name";
    	public static final String LABEL_NOMBRECLASE= "Nombre De Clase";
		public static final String LABEL_NOMBRECLASE_LOWER= "Nombre Clase";
    	public static final String LABEL_SUBMODULO= "SubModulo";
		public static final String LABEL_SUBMODULO_LOWER= "Sub Modulo";
    	public static final String LABEL_PAQUETE= "Paquete";
		public static final String LABEL_PAQUETE_LOWER= "Paquete";
    	public static final String LABEL_PAQUETEORIGINAL= "Paquete Original";
		public static final String LABEL_PAQUETEORIGINAL_LOWER= "Paquete Original";
    	public static final String LABEL_PATHAUXILIAR= "Path Auxiliar";
		public static final String LABEL_PATHAUXILIAR_LOWER= "Path Auxiliar";
    	public static final String LABEL_ESPARAMENU= "Es Para Menu";
		public static final String LABEL_ESPARAMENU_LOWER= "Es Para Menu";
    	public static final String LABEL_CONMOSTRARACCIONESCAMPO= "Mostrar Acciones Campo";
		public static final String LABEL_CONMOSTRARACCIONESCAMPO_LOWER= "Con Mostrar Acciones Campo";
    	public static final String LABEL_ESGUARDARRELACIONES= "Guardar Relaciones";
		public static final String LABEL_ESGUARDARRELACIONES_LOWER= "Es Guardar Relaciones";
    	public static final String LABEL_ESTADO= "Estado";
		public static final String LABEL_ESTADO_LOWER= "Estado";
	
		
		
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXTECLA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXTECLA=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXICON_NAME=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXICON_NAME=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_CLASE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_CLASE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXSUB_MODULO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSUB_MODULO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXPAQUETE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXPAQUETE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXPAQUETE_ORIGINAL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXPAQUETE_ORIGINAL=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXPATH_AUXILIAR=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXPATH_AUXILIAR=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
	
	public static String getOpcionLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(OpcionConstantesFunciones.IDSISTEMA)) {sLabelColumna=OpcionConstantesFunciones.LABEL_IDSISTEMA;}
		if(sNombreColumna.equals(OpcionConstantesFunciones.IDMODULO)) {sLabelColumna=OpcionConstantesFunciones.LABEL_IDMODULO;}
		if(sNombreColumna.equals(OpcionConstantesFunciones.IDGRUPOOPCION)) {sLabelColumna=OpcionConstantesFunciones.LABEL_IDGRUPOOPCION;}
		if(sNombreColumna.equals(OpcionConstantesFunciones.IDOPCION)) {sLabelColumna=OpcionConstantesFunciones.LABEL_IDOPCION;}
		if(sNombreColumna.equals(OpcionConstantesFunciones.CODIGO)) {sLabelColumna=OpcionConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(OpcionConstantesFunciones.NOMBRE)) {sLabelColumna=OpcionConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(OpcionConstantesFunciones.IDTIPOTECLAMASCARA)) {sLabelColumna=OpcionConstantesFunciones.LABEL_IDTIPOTECLAMASCARA;}
		if(sNombreColumna.equals(OpcionConstantesFunciones.TECLA)) {sLabelColumna=OpcionConstantesFunciones.LABEL_TECLA;}
		if(sNombreColumna.equals(OpcionConstantesFunciones.POSICION)) {sLabelColumna=OpcionConstantesFunciones.LABEL_POSICION;}
		if(sNombreColumna.equals(OpcionConstantesFunciones.ICONNAME)) {sLabelColumna=OpcionConstantesFunciones.LABEL_ICONNAME;}
		if(sNombreColumna.equals(OpcionConstantesFunciones.NOMBRECLASE)) {sLabelColumna=OpcionConstantesFunciones.LABEL_NOMBRECLASE;}
		if(sNombreColumna.equals(OpcionConstantesFunciones.SUBMODULO)) {sLabelColumna=OpcionConstantesFunciones.LABEL_SUBMODULO;}
		if(sNombreColumna.equals(OpcionConstantesFunciones.PAQUETE)) {sLabelColumna=OpcionConstantesFunciones.LABEL_PAQUETE;}
		if(sNombreColumna.equals(OpcionConstantesFunciones.PAQUETEORIGINAL)) {sLabelColumna=OpcionConstantesFunciones.LABEL_PAQUETEORIGINAL;}
		if(sNombreColumna.equals(OpcionConstantesFunciones.PATHAUXILIAR)) {sLabelColumna=OpcionConstantesFunciones.LABEL_PATHAUXILIAR;}
		if(sNombreColumna.equals(OpcionConstantesFunciones.ESPARAMENU)) {sLabelColumna=OpcionConstantesFunciones.LABEL_ESPARAMENU;}
		if(sNombreColumna.equals(OpcionConstantesFunciones.CONMOSTRARACCIONESCAMPO)) {sLabelColumna=OpcionConstantesFunciones.LABEL_CONMOSTRARACCIONESCAMPO;}
		if(sNombreColumna.equals(OpcionConstantesFunciones.ESGUARDARRELACIONES)) {sLabelColumna=OpcionConstantesFunciones.LABEL_ESGUARDARRELACIONES;}
		if(sNombreColumna.equals(OpcionConstantesFunciones.ESTADO)) {sLabelColumna=OpcionConstantesFunciones.LABEL_ESTADO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getes_para_menuDescripcion(Opcion opcion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!opcion.getes_para_menu()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_para_menuHtmlDescripcion(Opcion opcion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(opcion.getId(),opcion.getes_para_menu());

		return sDescripcion;
	}	
		
	public static String getcon_mostrar_acciones_campoDescripcion(Opcion opcion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!opcion.getcon_mostrar_acciones_campo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_mostrar_acciones_campoHtmlDescripcion(Opcion opcion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(opcion.getId(),opcion.getcon_mostrar_acciones_campo());

		return sDescripcion;
	}	
		
	public static String getes_guardar_relacionesDescripcion(Opcion opcion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!opcion.getes_guardar_relaciones()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_guardar_relacionesHtmlDescripcion(Opcion opcion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(opcion.getId(),opcion.getes_guardar_relaciones());

		return sDescripcion;
	}	
		
	public static String getestadoDescripcion(Opcion opcion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!opcion.getestado()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getestadoHtmlDescripcion(Opcion opcion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(opcion.getId(),opcion.getestado());

		return sDescripcion;
	}	
	
	public static String getOpcionDescripcion(Opcion opcion) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(opcion !=null/* && opcion.getId()!=0*/) {
			sDescripcion=opcion.getcodigo();//opcionopcion.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getOpcionDescripcionDetallado(Opcion opcion) {
		String sDescripcion="";
			
		sDescripcion+=OpcionConstantesFunciones.ID+"=";
		sDescripcion+=opcion.getId().toString()+",";
		sDescripcion+=OpcionConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=opcion.getVersionRow().toString()+",";
		sDescripcion+=OpcionConstantesFunciones.IDSISTEMA+"=";
		sDescripcion+=opcion.getid_sistema().toString()+",";
		sDescripcion+=OpcionConstantesFunciones.IDMODULO+"=";
		sDescripcion+=opcion.getid_modulo().toString()+",";
		sDescripcion+=OpcionConstantesFunciones.IDGRUPOOPCION+"=";
		sDescripcion+=opcion.getid_grupo_opcion().toString()+",";
		sDescripcion+=OpcionConstantesFunciones.IDOPCION+"=";
		sDescripcion+=opcion.getid_opcion().toString()+",";
		sDescripcion+=OpcionConstantesFunciones.CODIGO+"=";
		sDescripcion+=opcion.getcodigo()+",";
		sDescripcion+=OpcionConstantesFunciones.NOMBRE+"=";
		sDescripcion+=opcion.getnombre()+",";
		sDescripcion+=OpcionConstantesFunciones.IDTIPOTECLAMASCARA+"=";
		sDescripcion+=opcion.getid_tipo_tecla_mascara().toString()+",";
		sDescripcion+=OpcionConstantesFunciones.TECLA+"=";
		sDescripcion+=opcion.gettecla()+",";
		sDescripcion+=OpcionConstantesFunciones.POSICION+"=";
		sDescripcion+=opcion.getposicion().toString()+",";
		sDescripcion+=OpcionConstantesFunciones.ICONNAME+"=";
		sDescripcion+=opcion.geticon_name()+",";
		sDescripcion+=OpcionConstantesFunciones.NOMBRECLASE+"=";
		sDescripcion+=opcion.getnombre_clase()+",";
		sDescripcion+=OpcionConstantesFunciones.SUBMODULO+"=";
		sDescripcion+=opcion.getsub_modulo()+",";
		sDescripcion+=OpcionConstantesFunciones.PAQUETE+"=";
		sDescripcion+=opcion.getpaquete()+",";
		sDescripcion+=OpcionConstantesFunciones.PAQUETEORIGINAL+"=";
		sDescripcion+=opcion.getpaquete_original()+",";
		sDescripcion+=OpcionConstantesFunciones.PATHAUXILIAR+"=";
		sDescripcion+=opcion.getpath_auxiliar()+",";
		sDescripcion+=OpcionConstantesFunciones.ESPARAMENU+"=";
		sDescripcion+=opcion.getes_para_menu().toString()+",";
		sDescripcion+=OpcionConstantesFunciones.CONMOSTRARACCIONESCAMPO+"=";
		sDescripcion+=opcion.getcon_mostrar_acciones_campo().toString()+",";
		sDescripcion+=OpcionConstantesFunciones.ESGUARDARRELACIONES+"=";
		sDescripcion+=opcion.getes_guardar_relaciones().toString()+",";
		sDescripcion+=OpcionConstantesFunciones.ESTADO+"=";
		sDescripcion+=opcion.getestado().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setOpcionDescripcion(Opcion opcion,String sValor) throws Exception {			
		if(opcion !=null) {
			opcion.setcodigo(sValor);;//opcionopcion.getcodigo().trim();
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

	public static String getTipoTeclaMascaraDescripcion(TipoTeclaMascara tipoteclamascara) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoteclamascara!=null/*&&tipoteclamascara.getId()>0*/) {
			sDescripcion=TipoTeclaMascaraConstantesFunciones.getTipoTeclaMascaraDescripcion(tipoteclamascara);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorIdModuloPorIdOpcion")) {
			sNombreIndice="Tipo=  Por Sistema Por Modulo Por Opcion";
		} else if(sNombreIndice.equals("BusquedaPorIdModuloPorNombre")) {
			sNombreIndice="Tipo=  Por Sistema Por Modulo Por Nombre";
		} else if(sNombreIndice.equals("BusquedaPorIdSistemaPorModulo")) {
			sNombreIndice="Tipo=  Por Sistema Por Modulo";
		} else if(sNombreIndice.equals("FK_IdGrupoOpcion")) {
			sNombreIndice="Tipo=  Por Grupo Opcion";
		} else if(sNombreIndice.equals("FK_IdModulo")) {
			sNombreIndice="Tipo=  Por Modulo";
		} else if(sNombreIndice.equals("FK_IdOpcion")) {
			sNombreIndice="Tipo=  Por Opcion";
		} else if(sNombreIndice.equals("FK_IdSistema")) {
			sNombreIndice="Tipo=  Por Sistema";
		} else if(sNombreIndice.equals("FK_IdTipoTeclaMascara")) {
			sNombreIndice="Tipo=  Por Tecla Mascara";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorIdModuloPorIdOpcion(Long id_sistema,Long id_modulo,Long id_opcion) {
		String sDetalleIndice=" Parametros->";
		if(id_sistema!=null) {sDetalleIndice+=" Codigo Unico De Sistema="+id_sistema.toString();}
		if(id_modulo!=null) {sDetalleIndice+=" Codigo Unico De Modulo="+id_modulo.toString();}
		if(id_opcion!=null) {sDetalleIndice+=" Codigo Unico De Opcion="+id_opcion.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorIdModuloPorNombre(Long id_sistema,Long id_modulo,String nombre) {
		String sDetalleIndice=" Parametros->";
		if(id_sistema!=null) {sDetalleIndice+=" Codigo Unico De Sistema="+id_sistema.toString();}
		if(id_modulo!=null) {sDetalleIndice+=" Codigo Unico De Modulo="+id_modulo.toString();}
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorIdSistemaPorModulo(Long id_sistema,Long id_modulo) {
		String sDetalleIndice=" Parametros->";
		if(id_sistema!=null) {sDetalleIndice+=" Codigo Unico De Sistema="+id_sistema.toString();}
		if(id_modulo!=null) {sDetalleIndice+=" Codigo Unico De Modulo="+id_modulo.toString();} 

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

	public static String getDetalleIndiceFK_IdSistema(Long id_sistema) {
		String sDetalleIndice=" Parametros->";
		if(id_sistema!=null) {sDetalleIndice+=" Codigo Unico De Sistema="+id_sistema.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoTeclaMascara(Long id_tipo_tecla_mascara) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_tecla_mascara!=null) {sDetalleIndice+=" Codigo Unico De Tecla Mascara="+id_tipo_tecla_mascara.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosOpcion(Opcion opcion,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		opcion.setcodigo(opcion.getcodigo().trim());
		opcion.setnombre(opcion.getnombre().trim());
		opcion.settecla(opcion.gettecla().trim());
		opcion.seticon_name(opcion.geticon_name().trim());
		opcion.setnombre_clase(opcion.getnombre_clase().trim());
		opcion.setsub_modulo(opcion.getsub_modulo().trim());
		opcion.setpaquete(opcion.getpaquete().trim());
		opcion.setpaquete_original(opcion.getpaquete_original().trim());
		opcion.setpath_auxiliar(opcion.getpath_auxiliar().trim());
	}
	
	public static void quitarEspaciosOpcions(List<Opcion> opcions,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Opcion opcion: opcions) {
			opcion.setcodigo(opcion.getcodigo().trim());
			opcion.setnombre(opcion.getnombre().trim());
			opcion.settecla(opcion.gettecla().trim());
			opcion.seticon_name(opcion.geticon_name().trim());
			opcion.setnombre_clase(opcion.getnombre_clase().trim());
			opcion.setsub_modulo(opcion.getsub_modulo().trim());
			opcion.setpaquete(opcion.getpaquete().trim());
			opcion.setpaquete_original(opcion.getpaquete_original().trim());
			opcion.setpath_auxiliar(opcion.getpath_auxiliar().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresOpcion(Opcion opcion,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && opcion.getConCambioAuxiliar()) {
			opcion.setIsDeleted(opcion.getIsDeletedAuxiliar());	
			opcion.setIsNew(opcion.getIsNewAuxiliar());	
			opcion.setIsChanged(opcion.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			opcion.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			opcion.setIsDeletedAuxiliar(false);	
			opcion.setIsNewAuxiliar(false);	
			opcion.setIsChangedAuxiliar(false);
			
			opcion.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresOpcions(List<Opcion> opcions,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Opcion opcion : opcions) {
			if(conAsignarBase && opcion.getConCambioAuxiliar()) {
				opcion.setIsDeleted(opcion.getIsDeletedAuxiliar());	
				opcion.setIsNew(opcion.getIsNewAuxiliar());	
				opcion.setIsChanged(opcion.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				opcion.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				opcion.setIsDeletedAuxiliar(false);	
				opcion.setIsNewAuxiliar(false);	
				opcion.setIsChangedAuxiliar(false);
				
				opcion.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresOpcion(Opcion opcion,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
			opcion.setposicion(ish_value);
		}
	}		
	
	public static void InicializarValoresOpcions(List<Opcion> opcions,Boolean conEnteros) throws Exception  {
		
		for(Opcion opcion: opcions) {
		
			if(conEnteros) {
				Short ish_value=0;
				
				opcion.setposicion(ish_value);
			}
		}				
	}
	
	public static void TotalizarValoresFilaOpcion(List<Opcion> opcions,Opcion opcionAux) throws Exception  {
		OpcionConstantesFunciones.InicializarValoresOpcion(opcionAux,true);
		
		for(Opcion opcion: opcions) {
			if(opcion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			opcionAux.setposicion((short)(opcionAux.getposicion()+opcion.getposicion()));			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesOpcion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=OpcionConstantesFunciones.getArrayColumnasGlobalesOpcion(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesOpcion(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoOpcion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Opcion> opcions,Opcion opcion,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Opcion opcionAux: opcions) {
			if(opcionAux!=null && opcion!=null) {
				if((opcionAux.getId()==null && opcion.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(opcionAux.getId()!=null && opcion.getId()!=null){
					if(opcionAux.getId().equals(opcion.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaOpcion(List<Opcion> opcions) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Opcion opcion: opcions) {			
			if(opcion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaOpcion() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,OpcionConstantesFunciones.LABEL_ID, OpcionConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OpcionConstantesFunciones.LABEL_VERSIONROW, OpcionConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OpcionConstantesFunciones.LABEL_IDSISTEMA, OpcionConstantesFunciones.IDSISTEMA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OpcionConstantesFunciones.LABEL_IDMODULO, OpcionConstantesFunciones.IDMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OpcionConstantesFunciones.LABEL_IDGRUPOOPCION, OpcionConstantesFunciones.IDGRUPOOPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OpcionConstantesFunciones.LABEL_IDOPCION, OpcionConstantesFunciones.IDOPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OpcionConstantesFunciones.LABEL_CODIGO, OpcionConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OpcionConstantesFunciones.LABEL_NOMBRE, OpcionConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OpcionConstantesFunciones.LABEL_IDTIPOTECLAMASCARA, OpcionConstantesFunciones.IDTIPOTECLAMASCARA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OpcionConstantesFunciones.LABEL_TECLA, OpcionConstantesFunciones.TECLA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OpcionConstantesFunciones.LABEL_POSICION, OpcionConstantesFunciones.POSICION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OpcionConstantesFunciones.LABEL_ICONNAME, OpcionConstantesFunciones.ICONNAME,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OpcionConstantesFunciones.LABEL_NOMBRECLASE, OpcionConstantesFunciones.NOMBRECLASE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OpcionConstantesFunciones.LABEL_SUBMODULO, OpcionConstantesFunciones.SUBMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OpcionConstantesFunciones.LABEL_PAQUETE, OpcionConstantesFunciones.PAQUETE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OpcionConstantesFunciones.LABEL_PAQUETEORIGINAL, OpcionConstantesFunciones.PAQUETEORIGINAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OpcionConstantesFunciones.LABEL_PATHAUXILIAR, OpcionConstantesFunciones.PATHAUXILIAR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OpcionConstantesFunciones.LABEL_ESPARAMENU, OpcionConstantesFunciones.ESPARAMENU,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OpcionConstantesFunciones.LABEL_CONMOSTRARACCIONESCAMPO, OpcionConstantesFunciones.CONMOSTRARACCIONESCAMPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OpcionConstantesFunciones.LABEL_ESGUARDARRELACIONES, OpcionConstantesFunciones.ESGUARDARRELACIONES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OpcionConstantesFunciones.LABEL_ESTADO, OpcionConstantesFunciones.ESTADO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasOpcion() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=OpcionConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OpcionConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OpcionConstantesFunciones.IDSISTEMA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OpcionConstantesFunciones.IDMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OpcionConstantesFunciones.IDGRUPOOPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OpcionConstantesFunciones.IDOPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OpcionConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OpcionConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OpcionConstantesFunciones.IDTIPOTECLAMASCARA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OpcionConstantesFunciones.TECLA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OpcionConstantesFunciones.POSICION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OpcionConstantesFunciones.ICONNAME;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OpcionConstantesFunciones.NOMBRECLASE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OpcionConstantesFunciones.SUBMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OpcionConstantesFunciones.PAQUETE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OpcionConstantesFunciones.PAQUETEORIGINAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OpcionConstantesFunciones.PATHAUXILIAR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OpcionConstantesFunciones.ESPARAMENU;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OpcionConstantesFunciones.CONMOSTRARACCIONESCAMPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OpcionConstantesFunciones.ESGUARDARRELACIONES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OpcionConstantesFunciones.ESTADO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarOpcion() throws Exception  {
		return OpcionConstantesFunciones.getTiposSeleccionarOpcion(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarOpcion(Boolean conFk) throws Exception  {
		return OpcionConstantesFunciones.getTiposSeleccionarOpcion(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarOpcion(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(OpcionConstantesFunciones.LABEL_IDSISTEMA);
			reporte.setsDescripcion(OpcionConstantesFunciones.LABEL_IDSISTEMA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(OpcionConstantesFunciones.LABEL_IDMODULO);
			reporte.setsDescripcion(OpcionConstantesFunciones.LABEL_IDMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(OpcionConstantesFunciones.LABEL_IDGRUPOOPCION);
			reporte.setsDescripcion(OpcionConstantesFunciones.LABEL_IDGRUPOOPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(OpcionConstantesFunciones.LABEL_IDOPCION);
			reporte.setsDescripcion(OpcionConstantesFunciones.LABEL_IDOPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(OpcionConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(OpcionConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(OpcionConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(OpcionConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(OpcionConstantesFunciones.LABEL_IDTIPOTECLAMASCARA);
			reporte.setsDescripcion(OpcionConstantesFunciones.LABEL_IDTIPOTECLAMASCARA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(OpcionConstantesFunciones.LABEL_TECLA);
			reporte.setsDescripcion(OpcionConstantesFunciones.LABEL_TECLA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(OpcionConstantesFunciones.LABEL_POSICION);
			reporte.setsDescripcion(OpcionConstantesFunciones.LABEL_POSICION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(OpcionConstantesFunciones.LABEL_ICONNAME);
			reporte.setsDescripcion(OpcionConstantesFunciones.LABEL_ICONNAME);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(OpcionConstantesFunciones.LABEL_NOMBRECLASE);
			reporte.setsDescripcion(OpcionConstantesFunciones.LABEL_NOMBRECLASE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(OpcionConstantesFunciones.LABEL_SUBMODULO);
			reporte.setsDescripcion(OpcionConstantesFunciones.LABEL_SUBMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(OpcionConstantesFunciones.LABEL_PAQUETE);
			reporte.setsDescripcion(OpcionConstantesFunciones.LABEL_PAQUETE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(OpcionConstantesFunciones.LABEL_PAQUETEORIGINAL);
			reporte.setsDescripcion(OpcionConstantesFunciones.LABEL_PAQUETEORIGINAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(OpcionConstantesFunciones.LABEL_PATHAUXILIAR);
			reporte.setsDescripcion(OpcionConstantesFunciones.LABEL_PATHAUXILIAR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(OpcionConstantesFunciones.LABEL_ESPARAMENU);
			reporte.setsDescripcion(OpcionConstantesFunciones.LABEL_ESPARAMENU);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(OpcionConstantesFunciones.LABEL_CONMOSTRARACCIONESCAMPO);
			reporte.setsDescripcion(OpcionConstantesFunciones.LABEL_CONMOSTRARACCIONESCAMPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(OpcionConstantesFunciones.LABEL_ESGUARDARRELACIONES);
			reporte.setsDescripcion(OpcionConstantesFunciones.LABEL_ESGUARDARRELACIONES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(OpcionConstantesFunciones.LABEL_ESTADO);
			reporte.setsDescripcion(OpcionConstantesFunciones.LABEL_ESTADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesOpcion(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesOpcion(Opcion opcionAux) throws Exception {
		
			opcionAux.setsistema_descripcion(SistemaConstantesFunciones.getSistemaDescripcion(opcionAux.getSistema()));
			opcionAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(opcionAux.getModulo()));
			opcionAux.setgrupoopcion_descripcion(GrupoOpcionConstantesFunciones.getGrupoOpcionDescripcion(opcionAux.getGrupoOpcion()));
			opcionAux.setopcion_descripcion(OpcionConstantesFunciones.getOpcionDescripcion(opcionAux.getOpcion()));
			opcionAux.settipoteclamascara_descripcion(TipoTeclaMascaraConstantesFunciones.getTipoTeclaMascaraDescripcion(opcionAux.getTipoTeclaMascara()));		
	}
	
	public static void refrescarForeignKeysDescripcionesOpcion(List<Opcion> opcionsTemp) throws Exception {
		for(Opcion opcionAux:opcionsTemp) {
			
			opcionAux.setsistema_descripcion(SistemaConstantesFunciones.getSistemaDescripcion(opcionAux.getSistema()));
			opcionAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(opcionAux.getModulo()));
			opcionAux.setgrupoopcion_descripcion(GrupoOpcionConstantesFunciones.getGrupoOpcionDescripcion(opcionAux.getGrupoOpcion()));
			opcionAux.setopcion_descripcion(OpcionConstantesFunciones.getOpcionDescripcion(opcionAux.getOpcion()));
			opcionAux.settipoteclamascara_descripcion(TipoTeclaMascaraConstantesFunciones.getTipoTeclaMascaraDescripcion(opcionAux.getTipoTeclaMascara()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfOpcion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Sistema.class));
				classes.add(new Classe(Modulo.class));
				classes.add(new Classe(GrupoOpcion.class));
				classes.add(new Classe(Opcion.class));
				classes.add(new Classe(TipoTeclaMascara.class));
				
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
					if(clas.clas.equals(Opcion.class)) {
						classes.add(new Classe(Opcion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoTeclaMascara.class)) {
						classes.add(new Classe(TipoTeclaMascara.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfOpcion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Opcion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Opcion.class)); continue;
					}

					if(TipoTeclaMascara.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoTeclaMascara.class)); continue;
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

					if(Opcion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Opcion.class)); continue;
					}

					if(TipoTeclaMascara.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoTeclaMascara.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfOpcion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return OpcionConstantesFunciones.getClassesRelationshipsOfOpcion(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfOpcion(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(UsuarioOpcion.class));
				classes.add(new Classe(Opcion.class));
				classes.add(new Classe(Accion.class));
				classes.add(new Classe(PerfilOpcion.class));
				classes.add(new Classe(Campo.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(UsuarioOpcion.class)) {
						classes.add(new Classe(UsuarioOpcion.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Opcion.class)) {
						classes.add(new Classe(Opcion.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Accion.class)) {
						classes.add(new Classe(Accion.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(PerfilOpcion.class)) {
						classes.add(new Classe(PerfilOpcion.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Campo.class)) {
						classes.add(new Classe(Campo.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfOpcion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return OpcionConstantesFunciones.getClassesRelationshipsFromStringsOfOpcion(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfOpcion(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(UsuarioOpcion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(UsuarioOpcion.class)); continue;
					}

					if(Opcion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Opcion.class)); continue;
					}

					if(Accion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Accion.class)); continue;
					}

					if(PerfilOpcion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PerfilOpcion.class)); continue;
					}

					if(Campo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Campo.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(UsuarioOpcion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(UsuarioOpcion.class)); continue;
					}

					if(Opcion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Opcion.class)); continue;
					}

					if(Accion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Accion.class)); continue;
					}

					if(PerfilOpcion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PerfilOpcion.class)); continue;
					}

					if(Campo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Campo.class)); continue;
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
	public static void actualizarLista(Opcion opcion,List<Opcion> opcions,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Opcion opcionEncontrado=null;
			
			for(Opcion opcionLocal:opcions) {
				if(opcionLocal.getId().equals(opcion.getId())) {
					opcionEncontrado=opcionLocal;
					
					opcionLocal.setIsChanged(opcion.getIsChanged());
					opcionLocal.setIsNew(opcion.getIsNew());
					opcionLocal.setIsDeleted(opcion.getIsDeleted());
					
					opcionLocal.setGeneralEntityOriginal(opcion.getGeneralEntityOriginal());
					
					opcionLocal.setId(opcion.getId());	
					opcionLocal.setVersionRow(opcion.getVersionRow());	
					opcionLocal.setid_sistema(opcion.getid_sistema());	
					opcionLocal.setid_modulo(opcion.getid_modulo());	
					opcionLocal.setid_grupo_opcion(opcion.getid_grupo_opcion());	
					opcionLocal.setid_opcion(opcion.getid_opcion());	
					opcionLocal.setcodigo(opcion.getcodigo());	
					opcionLocal.setnombre(opcion.getnombre());	
					opcionLocal.setid_tipo_tecla_mascara(opcion.getid_tipo_tecla_mascara());	
					opcionLocal.settecla(opcion.gettecla());	
					opcionLocal.setposicion(opcion.getposicion());	
					opcionLocal.seticon_name(opcion.geticon_name());	
					opcionLocal.setnombre_clase(opcion.getnombre_clase());	
					opcionLocal.setsub_modulo(opcion.getsub_modulo());	
					opcionLocal.setpaquete(opcion.getpaquete());	
					opcionLocal.setpaquete_original(opcion.getpaquete_original());	
					opcionLocal.setpath_auxiliar(opcion.getpath_auxiliar());	
					opcionLocal.setes_para_menu(opcion.getes_para_menu());	
					opcionLocal.setcon_mostrar_acciones_campo(opcion.getcon_mostrar_acciones_campo());	
					opcionLocal.setes_guardar_relaciones(opcion.getes_guardar_relaciones());	
					opcionLocal.setestado(opcion.getestado());	
					
					
					opcionLocal.setUsuarioOpcions(opcion.getUsuarioOpcions());
					opcionLocal.setOpcions(opcion.getOpcions());
					opcionLocal.setAccions(opcion.getAccions());
					opcionLocal.setPerfilOpcions(opcion.getPerfilOpcions());
					opcionLocal.setCampos(opcion.getCampos());
					
					existe=true;
					break;
				}
			}
			
			if(!opcion.getIsDeleted()) {
				if(!existe) {
					opcions.add(opcion);
				}
			} else {
				if(opcionEncontrado!=null && permiteQuitar)  {
					opcions.remove(opcionEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Opcion opcion,List<Opcion> opcions) throws Exception {
		try	{			
			for(Opcion opcionLocal:opcions) {
				if(opcionLocal.getId().equals(opcion.getId())) {
					opcionLocal.setIsSelected(opcion.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesOpcion(List<Opcion> opcionsAux) throws Exception {
		//this.opcionsAux=opcionsAux;
		
		for(Opcion opcionAux:opcionsAux) {
			if(opcionAux.getIsChanged()) {
				opcionAux.setIsChanged(false);
			}		
			
			if(opcionAux.getIsNew()) {
				opcionAux.setIsNew(false);
			}	
			
			if(opcionAux.getIsDeleted()) {
				opcionAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesOpcion(Opcion opcionAux) throws Exception {
		//this.opcionAux=opcionAux;
		
			if(opcionAux.getIsChanged()) {
				opcionAux.setIsChanged(false);
			}		
			
			if(opcionAux.getIsNew()) {
				opcionAux.setIsNew(false);
			}	
			
			if(opcionAux.getIsDeleted()) {
				opcionAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Opcion opcionAsignar,Opcion opcion) throws Exception {
		opcionAsignar.setId(opcion.getId());	
		opcionAsignar.setVersionRow(opcion.getVersionRow());	
		opcionAsignar.setid_sistema(opcion.getid_sistema());
		opcionAsignar.setsistema_descripcion(opcion.getsistema_descripcion());	
		opcionAsignar.setid_modulo(opcion.getid_modulo());
		opcionAsignar.setmodulo_descripcion(opcion.getmodulo_descripcion());	
		opcionAsignar.setid_grupo_opcion(opcion.getid_grupo_opcion());
		opcionAsignar.setgrupoopcion_descripcion(opcion.getgrupoopcion_descripcion());	
		opcionAsignar.setid_opcion(opcion.getid_opcion());
		opcionAsignar.setopcion_descripcion(opcion.getopcion_descripcion());	
		opcionAsignar.setcodigo(opcion.getcodigo());	
		opcionAsignar.setnombre(opcion.getnombre());	
		opcionAsignar.setid_tipo_tecla_mascara(opcion.getid_tipo_tecla_mascara());
		opcionAsignar.settipoteclamascara_descripcion(opcion.gettipoteclamascara_descripcion());	
		opcionAsignar.settecla(opcion.gettecla());	
		opcionAsignar.setposicion(opcion.getposicion());	
		opcionAsignar.seticon_name(opcion.geticon_name());	
		opcionAsignar.setnombre_clase(opcion.getnombre_clase());	
		opcionAsignar.setsub_modulo(opcion.getsub_modulo());	
		opcionAsignar.setpaquete(opcion.getpaquete());	
		opcionAsignar.setpaquete_original(opcion.getpaquete_original());	
		opcionAsignar.setpath_auxiliar(opcion.getpath_auxiliar());	
		opcionAsignar.setes_para_menu(opcion.getes_para_menu());	
		opcionAsignar.setcon_mostrar_acciones_campo(opcion.getcon_mostrar_acciones_campo());	
		opcionAsignar.setes_guardar_relaciones(opcion.getes_guardar_relaciones());	
		opcionAsignar.setestado(opcion.getestado());	
	}
	
	public static void inicializarOpcion(Opcion opcion) throws Exception {
		try {
				opcion.setId(0L);	
					
				opcion.setid_sistema(-1L);	
				opcion.setid_modulo(-1L);	
				opcion.setid_grupo_opcion(null);	
				opcion.setid_opcion(null);	
				opcion.setcodigo("");	
				opcion.setnombre("");	
				opcion.setid_tipo_tecla_mascara(-1L);	
				opcion.settecla("");	
				opcion.setposicion(Short.parseShort("0"));	
				opcion.seticon_name("");	
				opcion.setnombre_clase("");	
				opcion.setsub_modulo("");	
				opcion.setpaquete("");	
				opcion.setpaquete_original("");	
				opcion.setpath_auxiliar("");	
				opcion.setes_para_menu(false);	
				opcion.setcon_mostrar_acciones_campo(false);	
				opcion.setes_guardar_relaciones(false);	
				opcion.setestado(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderOpcion(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(OpcionConstantesFunciones.LABEL_IDSISTEMA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OpcionConstantesFunciones.LABEL_IDMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OpcionConstantesFunciones.LABEL_IDGRUPOOPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OpcionConstantesFunciones.LABEL_IDOPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OpcionConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OpcionConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OpcionConstantesFunciones.LABEL_IDTIPOTECLAMASCARA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OpcionConstantesFunciones.LABEL_TECLA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OpcionConstantesFunciones.LABEL_POSICION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OpcionConstantesFunciones.LABEL_ICONNAME);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OpcionConstantesFunciones.LABEL_NOMBRECLASE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OpcionConstantesFunciones.LABEL_SUBMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OpcionConstantesFunciones.LABEL_PAQUETE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OpcionConstantesFunciones.LABEL_PAQUETEORIGINAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OpcionConstantesFunciones.LABEL_PATHAUXILIAR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OpcionConstantesFunciones.LABEL_ESPARAMENU);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OpcionConstantesFunciones.LABEL_CONMOSTRARACCIONESCAMPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OpcionConstantesFunciones.LABEL_ESGUARDARRELACIONES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OpcionConstantesFunciones.LABEL_ESTADO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataOpcion(String sTipo,Row row,Workbook workbook,Opcion opcion,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(opcion.getsistema_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(opcion.getmodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(opcion.getgrupoopcion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(opcion.getopcion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(opcion.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(opcion.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(opcion.gettipoteclamascara_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(opcion.gettecla());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(opcion.getposicion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(opcion.geticon_name());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(opcion.getnombre_clase());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(opcion.getsub_modulo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(opcion.getpaquete());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(opcion.getpaquete_original());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(opcion.getpath_auxiliar());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(opcion.getes_para_menu()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(opcion.getcon_mostrar_acciones_campo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(opcion.getes_guardar_relaciones()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(opcion.getestado()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryOpcion=Constantes.SFINALQUERY;
	
	public String getsFinalQueryOpcion() {
		return this.sFinalQueryOpcion;
	}
	
	public void setsFinalQueryOpcion(String sFinalQueryOpcion) {
		this.sFinalQueryOpcion= sFinalQueryOpcion;
	}
	
	public Border resaltarSeleccionarOpcion=null;
	
	public Border setResaltarSeleccionarOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*OpcionBeanSwingJInternalFrame opcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//opcionBeanSwingJInternalFrame.jTtoolBarOpcion.setBorder(borderResaltar);
		
		this.resaltarSeleccionarOpcion= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarOpcion() {
		return this.resaltarSeleccionarOpcion;
	}
	
	public void setResaltarSeleccionarOpcion(Border borderResaltarSeleccionarOpcion) {
		this.resaltarSeleccionarOpcion= borderResaltarSeleccionarOpcion;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridOpcion=null;
	public Boolean mostraridOpcion=true;
	public Boolean activaridOpcion=true;

	public Border resaltarid_sistemaOpcion=null;
	public Boolean mostrarid_sistemaOpcion=true;
	public Boolean activarid_sistemaOpcion=true;
	public Boolean cargarid_sistemaOpcion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sistemaOpcion=false;//ConEventDepend=true

	public Border resaltarid_moduloOpcion=null;
	public Boolean mostrarid_moduloOpcion=true;
	public Boolean activarid_moduloOpcion=true;
	public Boolean cargarid_moduloOpcion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_moduloOpcion=true;//ConEventDepend=true

	public Border resaltarid_grupo_opcionOpcion=null;
	public Boolean mostrarid_grupo_opcionOpcion=true;
	public Boolean activarid_grupo_opcionOpcion=true;
	public Boolean cargarid_grupo_opcionOpcion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_grupo_opcionOpcion=true;//ConEventDepend=true

	public Border resaltarid_opcionOpcion=null;
	public Boolean mostrarid_opcionOpcion=true;
	public Boolean activarid_opcionOpcion=true;
	public Boolean cargarid_opcionOpcion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_opcionOpcion=false;//ConEventDepend=true

	public Border resaltarcodigoOpcion=null;
	public Boolean mostrarcodigoOpcion=true;
	public Boolean activarcodigoOpcion=true;

	public Border resaltarnombreOpcion=null;
	public Boolean mostrarnombreOpcion=true;
	public Boolean activarnombreOpcion=true;

	public Border resaltarid_tipo_tecla_mascaraOpcion=null;
	public Boolean mostrarid_tipo_tecla_mascaraOpcion=true;
	public Boolean activarid_tipo_tecla_mascaraOpcion=true;
	public Boolean cargarid_tipo_tecla_mascaraOpcion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_tecla_mascaraOpcion=false;//ConEventDepend=true

	public Border resaltarteclaOpcion=null;
	public Boolean mostrarteclaOpcion=true;
	public Boolean activarteclaOpcion=true;

	public Border resaltarposicionOpcion=null;
	public Boolean mostrarposicionOpcion=true;
	public Boolean activarposicionOpcion=true;

	public Border resaltaricon_nameOpcion=null;
	public Boolean mostraricon_nameOpcion=true;
	public Boolean activaricon_nameOpcion=true;

	public Border resaltarnombre_claseOpcion=null;
	public Boolean mostrarnombre_claseOpcion=true;
	public Boolean activarnombre_claseOpcion=true;

	public Border resaltarsub_moduloOpcion=null;
	public Boolean mostrarsub_moduloOpcion=true;
	public Boolean activarsub_moduloOpcion=true;

	public Border resaltarpaqueteOpcion=null;
	public Boolean mostrarpaqueteOpcion=true;
	public Boolean activarpaqueteOpcion=true;

	public Border resaltarpaquete_originalOpcion=null;
	public Boolean mostrarpaquete_originalOpcion=true;
	public Boolean activarpaquete_originalOpcion=true;

	public Border resaltarpath_auxiliarOpcion=null;
	public Boolean mostrarpath_auxiliarOpcion=true;
	public Boolean activarpath_auxiliarOpcion=true;

	public Border resaltares_para_menuOpcion=null;
	public Boolean mostrares_para_menuOpcion=true;
	public Boolean activares_para_menuOpcion=true;

	public Border resaltarcon_mostrar_acciones_campoOpcion=null;
	public Boolean mostrarcon_mostrar_acciones_campoOpcion=true;
	public Boolean activarcon_mostrar_acciones_campoOpcion=true;

	public Border resaltares_guardar_relacionesOpcion=null;
	public Boolean mostrares_guardar_relacionesOpcion=true;
	public Boolean activares_guardar_relacionesOpcion=true;

	public Border resaltarestadoOpcion=null;
	public Boolean mostrarestadoOpcion=true;
	public Boolean activarestadoOpcion=true;

	
	

	public Border setResaltaridOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*OpcionBeanSwingJInternalFrame opcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//opcionBeanSwingJInternalFrame.jTtoolBarOpcion.setBorder(borderResaltar);
		
		this.resaltaridOpcion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridOpcion() {
		return this.resaltaridOpcion;
	}

	public void setResaltaridOpcion(Border borderResaltar) {
		this.resaltaridOpcion= borderResaltar;
	}

	public Boolean getMostraridOpcion() {
		return this.mostraridOpcion;
	}

	public void setMostraridOpcion(Boolean mostraridOpcion) {
		this.mostraridOpcion= mostraridOpcion;
	}

	public Boolean getActivaridOpcion() {
		return this.activaridOpcion;
	}

	public void setActivaridOpcion(Boolean activaridOpcion) {
		this.activaridOpcion= activaridOpcion;
	}

	public Border setResaltarid_sistemaOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*OpcionBeanSwingJInternalFrame opcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//opcionBeanSwingJInternalFrame.jTtoolBarOpcion.setBorder(borderResaltar);
		
		this.resaltarid_sistemaOpcion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sistemaOpcion() {
		return this.resaltarid_sistemaOpcion;
	}

	public void setResaltarid_sistemaOpcion(Border borderResaltar) {
		this.resaltarid_sistemaOpcion= borderResaltar;
	}

	public Boolean getMostrarid_sistemaOpcion() {
		return this.mostrarid_sistemaOpcion;
	}

	public void setMostrarid_sistemaOpcion(Boolean mostrarid_sistemaOpcion) {
		this.mostrarid_sistemaOpcion= mostrarid_sistemaOpcion;
	}

	public Boolean getActivarid_sistemaOpcion() {
		return this.activarid_sistemaOpcion;
	}

	public void setActivarid_sistemaOpcion(Boolean activarid_sistemaOpcion) {
		this.activarid_sistemaOpcion= activarid_sistemaOpcion;
	}

	public Boolean getCargarid_sistemaOpcion() {
		return this.cargarid_sistemaOpcion;
	}

	public void setCargarid_sistemaOpcion(Boolean cargarid_sistemaOpcion) {
		this.cargarid_sistemaOpcion= cargarid_sistemaOpcion;
	}

	public Border setResaltarid_moduloOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*OpcionBeanSwingJInternalFrame opcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//opcionBeanSwingJInternalFrame.jTtoolBarOpcion.setBorder(borderResaltar);
		
		this.resaltarid_moduloOpcion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_moduloOpcion() {
		return this.resaltarid_moduloOpcion;
	}

	public void setResaltarid_moduloOpcion(Border borderResaltar) {
		this.resaltarid_moduloOpcion= borderResaltar;
	}

	public Boolean getMostrarid_moduloOpcion() {
		return this.mostrarid_moduloOpcion;
	}

	public void setMostrarid_moduloOpcion(Boolean mostrarid_moduloOpcion) {
		this.mostrarid_moduloOpcion= mostrarid_moduloOpcion;
	}

	public Boolean getActivarid_moduloOpcion() {
		return this.activarid_moduloOpcion;
	}

	public void setActivarid_moduloOpcion(Boolean activarid_moduloOpcion) {
		this.activarid_moduloOpcion= activarid_moduloOpcion;
	}

	public Boolean getCargarid_moduloOpcion() {
		return this.cargarid_moduloOpcion;
	}

	public void setCargarid_moduloOpcion(Boolean cargarid_moduloOpcion) {
		this.cargarid_moduloOpcion= cargarid_moduloOpcion;
	}

	public Border setResaltarid_grupo_opcionOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*OpcionBeanSwingJInternalFrame opcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//opcionBeanSwingJInternalFrame.jTtoolBarOpcion.setBorder(borderResaltar);
		
		this.resaltarid_grupo_opcionOpcion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_grupo_opcionOpcion() {
		return this.resaltarid_grupo_opcionOpcion;
	}

	public void setResaltarid_grupo_opcionOpcion(Border borderResaltar) {
		this.resaltarid_grupo_opcionOpcion= borderResaltar;
	}

	public Boolean getMostrarid_grupo_opcionOpcion() {
		return this.mostrarid_grupo_opcionOpcion;
	}

	public void setMostrarid_grupo_opcionOpcion(Boolean mostrarid_grupo_opcionOpcion) {
		this.mostrarid_grupo_opcionOpcion= mostrarid_grupo_opcionOpcion;
	}

	public Boolean getActivarid_grupo_opcionOpcion() {
		return this.activarid_grupo_opcionOpcion;
	}

	public void setActivarid_grupo_opcionOpcion(Boolean activarid_grupo_opcionOpcion) {
		this.activarid_grupo_opcionOpcion= activarid_grupo_opcionOpcion;
	}

	public Boolean getCargarid_grupo_opcionOpcion() {
		return this.cargarid_grupo_opcionOpcion;
	}

	public void setCargarid_grupo_opcionOpcion(Boolean cargarid_grupo_opcionOpcion) {
		this.cargarid_grupo_opcionOpcion= cargarid_grupo_opcionOpcion;
	}

	public Border setResaltarid_opcionOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*OpcionBeanSwingJInternalFrame opcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//opcionBeanSwingJInternalFrame.jTtoolBarOpcion.setBorder(borderResaltar);
		
		this.resaltarid_opcionOpcion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_opcionOpcion() {
		return this.resaltarid_opcionOpcion;
	}

	public void setResaltarid_opcionOpcion(Border borderResaltar) {
		this.resaltarid_opcionOpcion= borderResaltar;
	}

	public Boolean getMostrarid_opcionOpcion() {
		return this.mostrarid_opcionOpcion;
	}

	public void setMostrarid_opcionOpcion(Boolean mostrarid_opcionOpcion) {
		this.mostrarid_opcionOpcion= mostrarid_opcionOpcion;
	}

	public Boolean getActivarid_opcionOpcion() {
		return this.activarid_opcionOpcion;
	}

	public void setActivarid_opcionOpcion(Boolean activarid_opcionOpcion) {
		this.activarid_opcionOpcion= activarid_opcionOpcion;
	}

	public Boolean getCargarid_opcionOpcion() {
		return this.cargarid_opcionOpcion;
	}

	public void setCargarid_opcionOpcion(Boolean cargarid_opcionOpcion) {
		this.cargarid_opcionOpcion= cargarid_opcionOpcion;
	}

	public Border setResaltarcodigoOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*OpcionBeanSwingJInternalFrame opcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//opcionBeanSwingJInternalFrame.jTtoolBarOpcion.setBorder(borderResaltar);
		
		this.resaltarcodigoOpcion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoOpcion() {
		return this.resaltarcodigoOpcion;
	}

	public void setResaltarcodigoOpcion(Border borderResaltar) {
		this.resaltarcodigoOpcion= borderResaltar;
	}

	public Boolean getMostrarcodigoOpcion() {
		return this.mostrarcodigoOpcion;
	}

	public void setMostrarcodigoOpcion(Boolean mostrarcodigoOpcion) {
		this.mostrarcodigoOpcion= mostrarcodigoOpcion;
	}

	public Boolean getActivarcodigoOpcion() {
		return this.activarcodigoOpcion;
	}

	public void setActivarcodigoOpcion(Boolean activarcodigoOpcion) {
		this.activarcodigoOpcion= activarcodigoOpcion;
	}

	public Border setResaltarnombreOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*OpcionBeanSwingJInternalFrame opcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//opcionBeanSwingJInternalFrame.jTtoolBarOpcion.setBorder(borderResaltar);
		
		this.resaltarnombreOpcion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreOpcion() {
		return this.resaltarnombreOpcion;
	}

	public void setResaltarnombreOpcion(Border borderResaltar) {
		this.resaltarnombreOpcion= borderResaltar;
	}

	public Boolean getMostrarnombreOpcion() {
		return this.mostrarnombreOpcion;
	}

	public void setMostrarnombreOpcion(Boolean mostrarnombreOpcion) {
		this.mostrarnombreOpcion= mostrarnombreOpcion;
	}

	public Boolean getActivarnombreOpcion() {
		return this.activarnombreOpcion;
	}

	public void setActivarnombreOpcion(Boolean activarnombreOpcion) {
		this.activarnombreOpcion= activarnombreOpcion;
	}

	public Border setResaltarid_tipo_tecla_mascaraOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*OpcionBeanSwingJInternalFrame opcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//opcionBeanSwingJInternalFrame.jTtoolBarOpcion.setBorder(borderResaltar);
		
		this.resaltarid_tipo_tecla_mascaraOpcion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_tecla_mascaraOpcion() {
		return this.resaltarid_tipo_tecla_mascaraOpcion;
	}

	public void setResaltarid_tipo_tecla_mascaraOpcion(Border borderResaltar) {
		this.resaltarid_tipo_tecla_mascaraOpcion= borderResaltar;
	}

	public Boolean getMostrarid_tipo_tecla_mascaraOpcion() {
		return this.mostrarid_tipo_tecla_mascaraOpcion;
	}

	public void setMostrarid_tipo_tecla_mascaraOpcion(Boolean mostrarid_tipo_tecla_mascaraOpcion) {
		this.mostrarid_tipo_tecla_mascaraOpcion= mostrarid_tipo_tecla_mascaraOpcion;
	}

	public Boolean getActivarid_tipo_tecla_mascaraOpcion() {
		return this.activarid_tipo_tecla_mascaraOpcion;
	}

	public void setActivarid_tipo_tecla_mascaraOpcion(Boolean activarid_tipo_tecla_mascaraOpcion) {
		this.activarid_tipo_tecla_mascaraOpcion= activarid_tipo_tecla_mascaraOpcion;
	}

	public Boolean getCargarid_tipo_tecla_mascaraOpcion() {
		return this.cargarid_tipo_tecla_mascaraOpcion;
	}

	public void setCargarid_tipo_tecla_mascaraOpcion(Boolean cargarid_tipo_tecla_mascaraOpcion) {
		this.cargarid_tipo_tecla_mascaraOpcion= cargarid_tipo_tecla_mascaraOpcion;
	}

	public Border setResaltarteclaOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*OpcionBeanSwingJInternalFrame opcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//opcionBeanSwingJInternalFrame.jTtoolBarOpcion.setBorder(borderResaltar);
		
		this.resaltarteclaOpcion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarteclaOpcion() {
		return this.resaltarteclaOpcion;
	}

	public void setResaltarteclaOpcion(Border borderResaltar) {
		this.resaltarteclaOpcion= borderResaltar;
	}

	public Boolean getMostrarteclaOpcion() {
		return this.mostrarteclaOpcion;
	}

	public void setMostrarteclaOpcion(Boolean mostrarteclaOpcion) {
		this.mostrarteclaOpcion= mostrarteclaOpcion;
	}

	public Boolean getActivarteclaOpcion() {
		return this.activarteclaOpcion;
	}

	public void setActivarteclaOpcion(Boolean activarteclaOpcion) {
		this.activarteclaOpcion= activarteclaOpcion;
	}

	public Border setResaltarposicionOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*OpcionBeanSwingJInternalFrame opcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//opcionBeanSwingJInternalFrame.jTtoolBarOpcion.setBorder(borderResaltar);
		
		this.resaltarposicionOpcion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarposicionOpcion() {
		return this.resaltarposicionOpcion;
	}

	public void setResaltarposicionOpcion(Border borderResaltar) {
		this.resaltarposicionOpcion= borderResaltar;
	}

	public Boolean getMostrarposicionOpcion() {
		return this.mostrarposicionOpcion;
	}

	public void setMostrarposicionOpcion(Boolean mostrarposicionOpcion) {
		this.mostrarposicionOpcion= mostrarposicionOpcion;
	}

	public Boolean getActivarposicionOpcion() {
		return this.activarposicionOpcion;
	}

	public void setActivarposicionOpcion(Boolean activarposicionOpcion) {
		this.activarposicionOpcion= activarposicionOpcion;
	}

	public Border setResaltaricon_nameOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*OpcionBeanSwingJInternalFrame opcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//opcionBeanSwingJInternalFrame.jTtoolBarOpcion.setBorder(borderResaltar);
		
		this.resaltaricon_nameOpcion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaricon_nameOpcion() {
		return this.resaltaricon_nameOpcion;
	}

	public void setResaltaricon_nameOpcion(Border borderResaltar) {
		this.resaltaricon_nameOpcion= borderResaltar;
	}

	public Boolean getMostraricon_nameOpcion() {
		return this.mostraricon_nameOpcion;
	}

	public void setMostraricon_nameOpcion(Boolean mostraricon_nameOpcion) {
		this.mostraricon_nameOpcion= mostraricon_nameOpcion;
	}

	public Boolean getActivaricon_nameOpcion() {
		return this.activaricon_nameOpcion;
	}

	public void setActivaricon_nameOpcion(Boolean activaricon_nameOpcion) {
		this.activaricon_nameOpcion= activaricon_nameOpcion;
	}

	public Border setResaltarnombre_claseOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*OpcionBeanSwingJInternalFrame opcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//opcionBeanSwingJInternalFrame.jTtoolBarOpcion.setBorder(borderResaltar);
		
		this.resaltarnombre_claseOpcion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_claseOpcion() {
		return this.resaltarnombre_claseOpcion;
	}

	public void setResaltarnombre_claseOpcion(Border borderResaltar) {
		this.resaltarnombre_claseOpcion= borderResaltar;
	}

	public Boolean getMostrarnombre_claseOpcion() {
		return this.mostrarnombre_claseOpcion;
	}

	public void setMostrarnombre_claseOpcion(Boolean mostrarnombre_claseOpcion) {
		this.mostrarnombre_claseOpcion= mostrarnombre_claseOpcion;
	}

	public Boolean getActivarnombre_claseOpcion() {
		return this.activarnombre_claseOpcion;
	}

	public void setActivarnombre_claseOpcion(Boolean activarnombre_claseOpcion) {
		this.activarnombre_claseOpcion= activarnombre_claseOpcion;
	}

	public Border setResaltarsub_moduloOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*OpcionBeanSwingJInternalFrame opcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//opcionBeanSwingJInternalFrame.jTtoolBarOpcion.setBorder(borderResaltar);
		
		this.resaltarsub_moduloOpcion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsub_moduloOpcion() {
		return this.resaltarsub_moduloOpcion;
	}

	public void setResaltarsub_moduloOpcion(Border borderResaltar) {
		this.resaltarsub_moduloOpcion= borderResaltar;
	}

	public Boolean getMostrarsub_moduloOpcion() {
		return this.mostrarsub_moduloOpcion;
	}

	public void setMostrarsub_moduloOpcion(Boolean mostrarsub_moduloOpcion) {
		this.mostrarsub_moduloOpcion= mostrarsub_moduloOpcion;
	}

	public Boolean getActivarsub_moduloOpcion() {
		return this.activarsub_moduloOpcion;
	}

	public void setActivarsub_moduloOpcion(Boolean activarsub_moduloOpcion) {
		this.activarsub_moduloOpcion= activarsub_moduloOpcion;
	}

	public Border setResaltarpaqueteOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*OpcionBeanSwingJInternalFrame opcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//opcionBeanSwingJInternalFrame.jTtoolBarOpcion.setBorder(borderResaltar);
		
		this.resaltarpaqueteOpcion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarpaqueteOpcion() {
		return this.resaltarpaqueteOpcion;
	}

	public void setResaltarpaqueteOpcion(Border borderResaltar) {
		this.resaltarpaqueteOpcion= borderResaltar;
	}

	public Boolean getMostrarpaqueteOpcion() {
		return this.mostrarpaqueteOpcion;
	}

	public void setMostrarpaqueteOpcion(Boolean mostrarpaqueteOpcion) {
		this.mostrarpaqueteOpcion= mostrarpaqueteOpcion;
	}

	public Boolean getActivarpaqueteOpcion() {
		return this.activarpaqueteOpcion;
	}

	public void setActivarpaqueteOpcion(Boolean activarpaqueteOpcion) {
		this.activarpaqueteOpcion= activarpaqueteOpcion;
	}

	public Border setResaltarpaquete_originalOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*OpcionBeanSwingJInternalFrame opcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//opcionBeanSwingJInternalFrame.jTtoolBarOpcion.setBorder(borderResaltar);
		
		this.resaltarpaquete_originalOpcion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarpaquete_originalOpcion() {
		return this.resaltarpaquete_originalOpcion;
	}

	public void setResaltarpaquete_originalOpcion(Border borderResaltar) {
		this.resaltarpaquete_originalOpcion= borderResaltar;
	}

	public Boolean getMostrarpaquete_originalOpcion() {
		return this.mostrarpaquete_originalOpcion;
	}

	public void setMostrarpaquete_originalOpcion(Boolean mostrarpaquete_originalOpcion) {
		this.mostrarpaquete_originalOpcion= mostrarpaquete_originalOpcion;
	}

	public Boolean getActivarpaquete_originalOpcion() {
		return this.activarpaquete_originalOpcion;
	}

	public void setActivarpaquete_originalOpcion(Boolean activarpaquete_originalOpcion) {
		this.activarpaquete_originalOpcion= activarpaquete_originalOpcion;
	}

	public Border setResaltarpath_auxiliarOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*OpcionBeanSwingJInternalFrame opcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//opcionBeanSwingJInternalFrame.jTtoolBarOpcion.setBorder(borderResaltar);
		
		this.resaltarpath_auxiliarOpcion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarpath_auxiliarOpcion() {
		return this.resaltarpath_auxiliarOpcion;
	}

	public void setResaltarpath_auxiliarOpcion(Border borderResaltar) {
		this.resaltarpath_auxiliarOpcion= borderResaltar;
	}

	public Boolean getMostrarpath_auxiliarOpcion() {
		return this.mostrarpath_auxiliarOpcion;
	}

	public void setMostrarpath_auxiliarOpcion(Boolean mostrarpath_auxiliarOpcion) {
		this.mostrarpath_auxiliarOpcion= mostrarpath_auxiliarOpcion;
	}

	public Boolean getActivarpath_auxiliarOpcion() {
		return this.activarpath_auxiliarOpcion;
	}

	public void setActivarpath_auxiliarOpcion(Boolean activarpath_auxiliarOpcion) {
		this.activarpath_auxiliarOpcion= activarpath_auxiliarOpcion;
	}

	public Border setResaltares_para_menuOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*OpcionBeanSwingJInternalFrame opcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//opcionBeanSwingJInternalFrame.jTtoolBarOpcion.setBorder(borderResaltar);
		
		this.resaltares_para_menuOpcion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_para_menuOpcion() {
		return this.resaltares_para_menuOpcion;
	}

	public void setResaltares_para_menuOpcion(Border borderResaltar) {
		this.resaltares_para_menuOpcion= borderResaltar;
	}

	public Boolean getMostrares_para_menuOpcion() {
		return this.mostrares_para_menuOpcion;
	}

	public void setMostrares_para_menuOpcion(Boolean mostrares_para_menuOpcion) {
		this.mostrares_para_menuOpcion= mostrares_para_menuOpcion;
	}

	public Boolean getActivares_para_menuOpcion() {
		return this.activares_para_menuOpcion;
	}

	public void setActivares_para_menuOpcion(Boolean activares_para_menuOpcion) {
		this.activares_para_menuOpcion= activares_para_menuOpcion;
	}

	public Border setResaltarcon_mostrar_acciones_campoOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*OpcionBeanSwingJInternalFrame opcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//opcionBeanSwingJInternalFrame.jTtoolBarOpcion.setBorder(borderResaltar);
		
		this.resaltarcon_mostrar_acciones_campoOpcion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_mostrar_acciones_campoOpcion() {
		return this.resaltarcon_mostrar_acciones_campoOpcion;
	}

	public void setResaltarcon_mostrar_acciones_campoOpcion(Border borderResaltar) {
		this.resaltarcon_mostrar_acciones_campoOpcion= borderResaltar;
	}

	public Boolean getMostrarcon_mostrar_acciones_campoOpcion() {
		return this.mostrarcon_mostrar_acciones_campoOpcion;
	}

	public void setMostrarcon_mostrar_acciones_campoOpcion(Boolean mostrarcon_mostrar_acciones_campoOpcion) {
		this.mostrarcon_mostrar_acciones_campoOpcion= mostrarcon_mostrar_acciones_campoOpcion;
	}

	public Boolean getActivarcon_mostrar_acciones_campoOpcion() {
		return this.activarcon_mostrar_acciones_campoOpcion;
	}

	public void setActivarcon_mostrar_acciones_campoOpcion(Boolean activarcon_mostrar_acciones_campoOpcion) {
		this.activarcon_mostrar_acciones_campoOpcion= activarcon_mostrar_acciones_campoOpcion;
	}

	public Border setResaltares_guardar_relacionesOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*OpcionBeanSwingJInternalFrame opcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//opcionBeanSwingJInternalFrame.jTtoolBarOpcion.setBorder(borderResaltar);
		
		this.resaltares_guardar_relacionesOpcion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_guardar_relacionesOpcion() {
		return this.resaltares_guardar_relacionesOpcion;
	}

	public void setResaltares_guardar_relacionesOpcion(Border borderResaltar) {
		this.resaltares_guardar_relacionesOpcion= borderResaltar;
	}

	public Boolean getMostrares_guardar_relacionesOpcion() {
		return this.mostrares_guardar_relacionesOpcion;
	}

	public void setMostrares_guardar_relacionesOpcion(Boolean mostrares_guardar_relacionesOpcion) {
		this.mostrares_guardar_relacionesOpcion= mostrares_guardar_relacionesOpcion;
	}

	public Boolean getActivares_guardar_relacionesOpcion() {
		return this.activares_guardar_relacionesOpcion;
	}

	public void setActivares_guardar_relacionesOpcion(Boolean activares_guardar_relacionesOpcion) {
		this.activares_guardar_relacionesOpcion= activares_guardar_relacionesOpcion;
	}

	public Border setResaltarestadoOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*OpcionBeanSwingJInternalFrame opcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//opcionBeanSwingJInternalFrame.jTtoolBarOpcion.setBorder(borderResaltar);
		
		this.resaltarestadoOpcion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarestadoOpcion() {
		return this.resaltarestadoOpcion;
	}

	public void setResaltarestadoOpcion(Border borderResaltar) {
		this.resaltarestadoOpcion= borderResaltar;
	}

	public Boolean getMostrarestadoOpcion() {
		return this.mostrarestadoOpcion;
	}

	public void setMostrarestadoOpcion(Boolean mostrarestadoOpcion) {
		this.mostrarestadoOpcion= mostrarestadoOpcion;
	}

	public Boolean getActivarestadoOpcion() {
		return this.activarestadoOpcion;
	}

	public void setActivarestadoOpcion(Boolean activarestadoOpcion) {
		this.activarestadoOpcion= activarestadoOpcion;
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
		
		
		this.setMostraridOpcion(esInicial);
		this.setMostrarid_sistemaOpcion(esInicial);
		this.setMostrarid_moduloOpcion(esInicial);
		this.setMostrarid_grupo_opcionOpcion(esInicial);
		this.setMostrarid_opcionOpcion(esInicial);
		this.setMostrarcodigoOpcion(esInicial);
		this.setMostrarnombreOpcion(esInicial);
		this.setMostrarid_tipo_tecla_mascaraOpcion(esInicial);
		this.setMostrarteclaOpcion(esInicial);
		this.setMostrarposicionOpcion(esInicial);
		this.setMostraricon_nameOpcion(esInicial);
		this.setMostrarnombre_claseOpcion(esInicial);
		this.setMostrarsub_moduloOpcion(esInicial);
		this.setMostrarpaqueteOpcion(esInicial);
		this.setMostrarpaquete_originalOpcion(esInicial);
		this.setMostrarpath_auxiliarOpcion(esInicial);
		this.setMostrares_para_menuOpcion(esInicial);
		this.setMostrarcon_mostrar_acciones_campoOpcion(esInicial);
		this.setMostrares_guardar_relacionesOpcion(esInicial);
		this.setMostrarestadoOpcion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(OpcionConstantesFunciones.ID)) {
				this.setMostraridOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(OpcionConstantesFunciones.IDSISTEMA)) {
				this.setMostrarid_sistemaOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(OpcionConstantesFunciones.IDMODULO)) {
				this.setMostrarid_moduloOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(OpcionConstantesFunciones.IDGRUPOOPCION)) {
				this.setMostrarid_grupo_opcionOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(OpcionConstantesFunciones.IDOPCION)) {
				this.setMostrarid_opcionOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(OpcionConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(OpcionConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(OpcionConstantesFunciones.IDTIPOTECLAMASCARA)) {
				this.setMostrarid_tipo_tecla_mascaraOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(OpcionConstantesFunciones.TECLA)) {
				this.setMostrarteclaOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(OpcionConstantesFunciones.POSICION)) {
				this.setMostrarposicionOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(OpcionConstantesFunciones.ICONNAME)) {
				this.setMostraricon_nameOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(OpcionConstantesFunciones.NOMBRECLASE)) {
				this.setMostrarnombre_claseOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(OpcionConstantesFunciones.SUBMODULO)) {
				this.setMostrarsub_moduloOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(OpcionConstantesFunciones.PAQUETE)) {
				this.setMostrarpaqueteOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(OpcionConstantesFunciones.PAQUETEORIGINAL)) {
				this.setMostrarpaquete_originalOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(OpcionConstantesFunciones.PATHAUXILIAR)) {
				this.setMostrarpath_auxiliarOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(OpcionConstantesFunciones.ESPARAMENU)) {
				this.setMostrares_para_menuOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(OpcionConstantesFunciones.CONMOSTRARACCIONESCAMPO)) {
				this.setMostrarcon_mostrar_acciones_campoOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(OpcionConstantesFunciones.ESGUARDARRELACIONES)) {
				this.setMostrares_guardar_relacionesOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(OpcionConstantesFunciones.ESTADO)) {
				this.setMostrarestadoOpcion(esAsigna);
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
		
		
		this.setActivaridOpcion(esInicial);
		this.setActivarid_sistemaOpcion(esInicial);
		this.setActivarid_moduloOpcion(esInicial);
		this.setActivarid_grupo_opcionOpcion(esInicial);
		this.setActivarid_opcionOpcion(esInicial);
		this.setActivarcodigoOpcion(esInicial);
		this.setActivarnombreOpcion(esInicial);
		this.setActivarid_tipo_tecla_mascaraOpcion(esInicial);
		this.setActivarteclaOpcion(esInicial);
		this.setActivarposicionOpcion(esInicial);
		this.setActivaricon_nameOpcion(esInicial);
		this.setActivarnombre_claseOpcion(esInicial);
		this.setActivarsub_moduloOpcion(esInicial);
		this.setActivarpaqueteOpcion(esInicial);
		this.setActivarpaquete_originalOpcion(esInicial);
		this.setActivarpath_auxiliarOpcion(esInicial);
		this.setActivares_para_menuOpcion(esInicial);
		this.setActivarcon_mostrar_acciones_campoOpcion(esInicial);
		this.setActivares_guardar_relacionesOpcion(esInicial);
		this.setActivarestadoOpcion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(OpcionConstantesFunciones.ID)) {
				this.setActivaridOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(OpcionConstantesFunciones.IDSISTEMA)) {
				this.setActivarid_sistemaOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(OpcionConstantesFunciones.IDMODULO)) {
				this.setActivarid_moduloOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(OpcionConstantesFunciones.IDGRUPOOPCION)) {
				this.setActivarid_grupo_opcionOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(OpcionConstantesFunciones.IDOPCION)) {
				this.setActivarid_opcionOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(OpcionConstantesFunciones.CODIGO)) {
				this.setActivarcodigoOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(OpcionConstantesFunciones.NOMBRE)) {
				this.setActivarnombreOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(OpcionConstantesFunciones.IDTIPOTECLAMASCARA)) {
				this.setActivarid_tipo_tecla_mascaraOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(OpcionConstantesFunciones.TECLA)) {
				this.setActivarteclaOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(OpcionConstantesFunciones.POSICION)) {
				this.setActivarposicionOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(OpcionConstantesFunciones.ICONNAME)) {
				this.setActivaricon_nameOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(OpcionConstantesFunciones.NOMBRECLASE)) {
				this.setActivarnombre_claseOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(OpcionConstantesFunciones.SUBMODULO)) {
				this.setActivarsub_moduloOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(OpcionConstantesFunciones.PAQUETE)) {
				this.setActivarpaqueteOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(OpcionConstantesFunciones.PAQUETEORIGINAL)) {
				this.setActivarpaquete_originalOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(OpcionConstantesFunciones.PATHAUXILIAR)) {
				this.setActivarpath_auxiliarOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(OpcionConstantesFunciones.ESPARAMENU)) {
				this.setActivares_para_menuOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(OpcionConstantesFunciones.CONMOSTRARACCIONESCAMPO)) {
				this.setActivarcon_mostrar_acciones_campoOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(OpcionConstantesFunciones.ESGUARDARRELACIONES)) {
				this.setActivares_guardar_relacionesOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(OpcionConstantesFunciones.ESTADO)) {
				this.setActivarestadoOpcion(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,OpcionBeanSwingJInternalFrame opcionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridOpcion(esInicial);
		this.setResaltarid_sistemaOpcion(esInicial);
		this.setResaltarid_moduloOpcion(esInicial);
		this.setResaltarid_grupo_opcionOpcion(esInicial);
		this.setResaltarid_opcionOpcion(esInicial);
		this.setResaltarcodigoOpcion(esInicial);
		this.setResaltarnombreOpcion(esInicial);
		this.setResaltarid_tipo_tecla_mascaraOpcion(esInicial);
		this.setResaltarteclaOpcion(esInicial);
		this.setResaltarposicionOpcion(esInicial);
		this.setResaltaricon_nameOpcion(esInicial);
		this.setResaltarnombre_claseOpcion(esInicial);
		this.setResaltarsub_moduloOpcion(esInicial);
		this.setResaltarpaqueteOpcion(esInicial);
		this.setResaltarpaquete_originalOpcion(esInicial);
		this.setResaltarpath_auxiliarOpcion(esInicial);
		this.setResaltares_para_menuOpcion(esInicial);
		this.setResaltarcon_mostrar_acciones_campoOpcion(esInicial);
		this.setResaltares_guardar_relacionesOpcion(esInicial);
		this.setResaltarestadoOpcion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(OpcionConstantesFunciones.ID)) {
				this.setResaltaridOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(OpcionConstantesFunciones.IDSISTEMA)) {
				this.setResaltarid_sistemaOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(OpcionConstantesFunciones.IDMODULO)) {
				this.setResaltarid_moduloOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(OpcionConstantesFunciones.IDGRUPOOPCION)) {
				this.setResaltarid_grupo_opcionOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(OpcionConstantesFunciones.IDOPCION)) {
				this.setResaltarid_opcionOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(OpcionConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(OpcionConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(OpcionConstantesFunciones.IDTIPOTECLAMASCARA)) {
				this.setResaltarid_tipo_tecla_mascaraOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(OpcionConstantesFunciones.TECLA)) {
				this.setResaltarteclaOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(OpcionConstantesFunciones.POSICION)) {
				this.setResaltarposicionOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(OpcionConstantesFunciones.ICONNAME)) {
				this.setResaltaricon_nameOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(OpcionConstantesFunciones.NOMBRECLASE)) {
				this.setResaltarnombre_claseOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(OpcionConstantesFunciones.SUBMODULO)) {
				this.setResaltarsub_moduloOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(OpcionConstantesFunciones.PAQUETE)) {
				this.setResaltarpaqueteOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(OpcionConstantesFunciones.PAQUETEORIGINAL)) {
				this.setResaltarpaquete_originalOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(OpcionConstantesFunciones.PATHAUXILIAR)) {
				this.setResaltarpath_auxiliarOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(OpcionConstantesFunciones.ESPARAMENU)) {
				this.setResaltares_para_menuOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(OpcionConstantesFunciones.CONMOSTRARACCIONESCAMPO)) {
				this.setResaltarcon_mostrar_acciones_campoOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(OpcionConstantesFunciones.ESGUARDARRELACIONES)) {
				this.setResaltares_guardar_relacionesOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(OpcionConstantesFunciones.ESTADO)) {
				this.setResaltarestadoOpcion(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarUsuarioOpcionOpcion=null;

	public Border getResaltarUsuarioOpcionOpcion() {
		return this.resaltarUsuarioOpcionOpcion;
	}

	public void setResaltarUsuarioOpcionOpcion(Border borderResaltarUsuarioOpcion) {
		if(borderResaltarUsuarioOpcion!=null) {
			this.resaltarUsuarioOpcionOpcion= borderResaltarUsuarioOpcion;
		}
	}

	public Border setResaltarUsuarioOpcionOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*OpcionBeanSwingJInternalFrame opcionBeanSwingJInternalFrame*/) {
		Border borderResaltarUsuarioOpcion=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//opcionBeanSwingJInternalFrame.jTtoolBarOpcion.setBorder(borderResaltarUsuarioOpcion);
			
		this.resaltarUsuarioOpcionOpcion= borderResaltarUsuarioOpcion;

		 return borderResaltarUsuarioOpcion;
	}



	public Boolean mostrarUsuarioOpcionOpcion=true;

	public Boolean getMostrarUsuarioOpcionOpcion() {
		return this.mostrarUsuarioOpcionOpcion;
	}

	public void setMostrarUsuarioOpcionOpcion(Boolean visibilidadResaltarUsuarioOpcion) {
		this.mostrarUsuarioOpcionOpcion= visibilidadResaltarUsuarioOpcion;
	}



	public Boolean activarUsuarioOpcionOpcion=true;

	public Boolean gethabilitarResaltarUsuarioOpcionOpcion() {
		return this.activarUsuarioOpcionOpcion;
	}

	public void setActivarUsuarioOpcionOpcion(Boolean habilitarResaltarUsuarioOpcion) {
		this.activarUsuarioOpcionOpcion= habilitarResaltarUsuarioOpcion;
	}


	public Border resaltarOpcionOpcion=null;

	public Border getResaltarOpcionOpcion() {
		return this.resaltarOpcionOpcion;
	}

	public void setResaltarOpcionOpcion(Border borderResaltarOpcion) {
		if(borderResaltarOpcion!=null) {
			this.resaltarOpcionOpcion= borderResaltarOpcion;
		}
	}

	public Border setResaltarOpcionOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*OpcionBeanSwingJInternalFrame opcionBeanSwingJInternalFrame*/) {
		Border borderResaltarOpcion=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//opcionBeanSwingJInternalFrame.jTtoolBarOpcion.setBorder(borderResaltarOpcion);
			
		this.resaltarOpcionOpcion= borderResaltarOpcion;

		 return borderResaltarOpcion;
	}



	public Boolean mostrarOpcionOpcion=true;

	public Boolean getMostrarOpcionOpcion() {
		return this.mostrarOpcionOpcion;
	}

	public void setMostrarOpcionOpcion(Boolean visibilidadResaltarOpcion) {
		this.mostrarOpcionOpcion= visibilidadResaltarOpcion;
	}



	public Boolean activarOpcionOpcion=true;

	public Boolean gethabilitarResaltarOpcionOpcion() {
		return this.activarOpcionOpcion;
	}

	public void setActivarOpcionOpcion(Boolean habilitarResaltarOpcion) {
		this.activarOpcionOpcion= habilitarResaltarOpcion;
	}


	public Border resaltarAccionOpcion=null;

	public Border getResaltarAccionOpcion() {
		return this.resaltarAccionOpcion;
	}

	public void setResaltarAccionOpcion(Border borderResaltarAccion) {
		if(borderResaltarAccion!=null) {
			this.resaltarAccionOpcion= borderResaltarAccion;
		}
	}

	public Border setResaltarAccionOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*OpcionBeanSwingJInternalFrame opcionBeanSwingJInternalFrame*/) {
		Border borderResaltarAccion=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//opcionBeanSwingJInternalFrame.jTtoolBarOpcion.setBorder(borderResaltarAccion);
			
		this.resaltarAccionOpcion= borderResaltarAccion;

		 return borderResaltarAccion;
	}



	public Boolean mostrarAccionOpcion=true;

	public Boolean getMostrarAccionOpcion() {
		return this.mostrarAccionOpcion;
	}

	public void setMostrarAccionOpcion(Boolean visibilidadResaltarAccion) {
		this.mostrarAccionOpcion= visibilidadResaltarAccion;
	}



	public Boolean activarAccionOpcion=true;

	public Boolean gethabilitarResaltarAccionOpcion() {
		return this.activarAccionOpcion;
	}

	public void setActivarAccionOpcion(Boolean habilitarResaltarAccion) {
		this.activarAccionOpcion= habilitarResaltarAccion;
	}


	public Border resaltarPerfilOpcionOpcion=null;

	public Border getResaltarPerfilOpcionOpcion() {
		return this.resaltarPerfilOpcionOpcion;
	}

	public void setResaltarPerfilOpcionOpcion(Border borderResaltarPerfilOpcion) {
		if(borderResaltarPerfilOpcion!=null) {
			this.resaltarPerfilOpcionOpcion= borderResaltarPerfilOpcion;
		}
	}

	public Border setResaltarPerfilOpcionOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*OpcionBeanSwingJInternalFrame opcionBeanSwingJInternalFrame*/) {
		Border borderResaltarPerfilOpcion=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//opcionBeanSwingJInternalFrame.jTtoolBarOpcion.setBorder(borderResaltarPerfilOpcion);
			
		this.resaltarPerfilOpcionOpcion= borderResaltarPerfilOpcion;

		 return borderResaltarPerfilOpcion;
	}



	public Boolean mostrarPerfilOpcionOpcion=true;

	public Boolean getMostrarPerfilOpcionOpcion() {
		return this.mostrarPerfilOpcionOpcion;
	}

	public void setMostrarPerfilOpcionOpcion(Boolean visibilidadResaltarPerfilOpcion) {
		this.mostrarPerfilOpcionOpcion= visibilidadResaltarPerfilOpcion;
	}



	public Boolean activarPerfilOpcionOpcion=true;

	public Boolean gethabilitarResaltarPerfilOpcionOpcion() {
		return this.activarPerfilOpcionOpcion;
	}

	public void setActivarPerfilOpcionOpcion(Boolean habilitarResaltarPerfilOpcion) {
		this.activarPerfilOpcionOpcion= habilitarResaltarPerfilOpcion;
	}


	public Border resaltarCampoOpcion=null;

	public Border getResaltarCampoOpcion() {
		return this.resaltarCampoOpcion;
	}

	public void setResaltarCampoOpcion(Border borderResaltarCampo) {
		if(borderResaltarCampo!=null) {
			this.resaltarCampoOpcion= borderResaltarCampo;
		}
	}

	public Border setResaltarCampoOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*OpcionBeanSwingJInternalFrame opcionBeanSwingJInternalFrame*/) {
		Border borderResaltarCampo=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//opcionBeanSwingJInternalFrame.jTtoolBarOpcion.setBorder(borderResaltarCampo);
			
		this.resaltarCampoOpcion= borderResaltarCampo;

		 return borderResaltarCampo;
	}



	public Boolean mostrarCampoOpcion=true;

	public Boolean getMostrarCampoOpcion() {
		return this.mostrarCampoOpcion;
	}

	public void setMostrarCampoOpcion(Boolean visibilidadResaltarCampo) {
		this.mostrarCampoOpcion= visibilidadResaltarCampo;
	}



	public Boolean activarCampoOpcion=true;

	public Boolean gethabilitarResaltarCampoOpcion() {
		return this.activarCampoOpcion;
	}

	public void setActivarCampoOpcion(Boolean habilitarResaltarCampo) {
		this.activarCampoOpcion= habilitarResaltarCampo;
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

		this.setMostrarUsuarioOpcionOpcion(esInicial);
		this.setMostrarOpcionOpcion(esInicial);
		this.setMostrarAccionOpcion(esInicial);
		this.setMostrarPerfilOpcionOpcion(esInicial);
		this.setMostrarCampoOpcion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(UsuarioOpcion.class)) {
				this.setMostrarUsuarioOpcionOpcion(esAsigna);
				continue;
			}

			if(clase.clas.equals(Opcion.class)) {
				this.setMostrarOpcionOpcion(esAsigna);
				continue;
			}

			if(clase.clas.equals(Accion.class)) {
				this.setMostrarAccionOpcion(esAsigna);
				continue;
			}

			if(clase.clas.equals(PerfilOpcion.class)) {
				this.setMostrarPerfilOpcionOpcion(esAsigna);
				continue;
			}

			if(clase.clas.equals(Campo.class)) {
				this.setMostrarCampoOpcion(esAsigna);
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

		this.setActivarUsuarioOpcionOpcion(esInicial);
		this.setActivarOpcionOpcion(esInicial);
		this.setActivarAccionOpcion(esInicial);
		this.setActivarPerfilOpcionOpcion(esInicial);
		this.setActivarCampoOpcion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(UsuarioOpcion.class)) {
				this.setActivarUsuarioOpcionOpcion(esAsigna);
				continue;
			}

			if(clase.clas.equals(Opcion.class)) {
				this.setActivarOpcionOpcion(esAsigna);
				continue;
			}

			if(clase.clas.equals(Accion.class)) {
				this.setActivarAccionOpcion(esAsigna);
				continue;
			}

			if(clase.clas.equals(PerfilOpcion.class)) {
				this.setActivarPerfilOpcionOpcion(esAsigna);
				continue;
			}

			if(clase.clas.equals(Campo.class)) {
				this.setActivarCampoOpcion(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,OpcionBeanSwingJInternalFrame opcionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarUsuarioOpcionOpcion(esInicial);
		this.setResaltarOpcionOpcion(esInicial);
		this.setResaltarAccionOpcion(esInicial);
		this.setResaltarPerfilOpcionOpcion(esInicial);
		this.setResaltarCampoOpcion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(UsuarioOpcion.class)) {
				this.setResaltarUsuarioOpcionOpcion(esAsigna);
				continue;
			}

			if(clase.clas.equals(Opcion.class)) {
				this.setResaltarOpcionOpcion(esAsigna);
				continue;
			}

			if(clase.clas.equals(Accion.class)) {
				this.setResaltarAccionOpcion(esAsigna);
				continue;
			}

			if(clase.clas.equals(PerfilOpcion.class)) {
				this.setResaltarPerfilOpcionOpcion(esAsigna);
				continue;
			}

			if(clase.clas.equals(Campo.class)) {
				this.setResaltarCampoOpcion(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorIdModuloPorIdOpcionOpcion=true;

	public Boolean getMostrarBusquedaPorIdModuloPorIdOpcionOpcion() {
		return this.mostrarBusquedaPorIdModuloPorIdOpcionOpcion;
	}

	public void setMostrarBusquedaPorIdModuloPorIdOpcionOpcion(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorIdModuloPorIdOpcionOpcion= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorIdModuloPorNombreOpcion=true;

	public Boolean getMostrarBusquedaPorIdModuloPorNombreOpcion() {
		return this.mostrarBusquedaPorIdModuloPorNombreOpcion;
	}

	public void setMostrarBusquedaPorIdModuloPorNombreOpcion(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorIdModuloPorNombreOpcion= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorIdSistemaPorModuloOpcion=true;

	public Boolean getMostrarBusquedaPorIdSistemaPorModuloOpcion() {
		return this.mostrarBusquedaPorIdSistemaPorModuloOpcion;
	}

	public void setMostrarBusquedaPorIdSistemaPorModuloOpcion(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorIdSistemaPorModuloOpcion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSistemaOpcion=true;

	public Boolean getMostrarFK_IdSistemaOpcion() {
		return this.mostrarFK_IdSistemaOpcion;
	}

	public void setMostrarFK_IdSistemaOpcion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSistemaOpcion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoTeclaMascaraOpcion=true;

	public Boolean getMostrarFK_IdTipoTeclaMascaraOpcion() {
		return this.mostrarFK_IdTipoTeclaMascaraOpcion;
	}

	public void setMostrarFK_IdTipoTeclaMascaraOpcion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoTeclaMascaraOpcion= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorIdModuloPorIdOpcionOpcion=true;

	public Boolean getActivarBusquedaPorIdModuloPorIdOpcionOpcion() {
		return this.activarBusquedaPorIdModuloPorIdOpcionOpcion;
	}

	public void setActivarBusquedaPorIdModuloPorIdOpcionOpcion(Boolean habilitarResaltar) {
		this.activarBusquedaPorIdModuloPorIdOpcionOpcion= habilitarResaltar;
	}

	public Boolean activarBusquedaPorIdModuloPorNombreOpcion=true;

	public Boolean getActivarBusquedaPorIdModuloPorNombreOpcion() {
		return this.activarBusquedaPorIdModuloPorNombreOpcion;
	}

	public void setActivarBusquedaPorIdModuloPorNombreOpcion(Boolean habilitarResaltar) {
		this.activarBusquedaPorIdModuloPorNombreOpcion= habilitarResaltar;
	}

	public Boolean activarBusquedaPorIdSistemaPorModuloOpcion=true;

	public Boolean getActivarBusquedaPorIdSistemaPorModuloOpcion() {
		return this.activarBusquedaPorIdSistemaPorModuloOpcion;
	}

	public void setActivarBusquedaPorIdSistemaPorModuloOpcion(Boolean habilitarResaltar) {
		this.activarBusquedaPorIdSistemaPorModuloOpcion= habilitarResaltar;
	}

	public Boolean activarFK_IdSistemaOpcion=true;

	public Boolean getActivarFK_IdSistemaOpcion() {
		return this.activarFK_IdSistemaOpcion;
	}

	public void setActivarFK_IdSistemaOpcion(Boolean habilitarResaltar) {
		this.activarFK_IdSistemaOpcion= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoTeclaMascaraOpcion=true;

	public Boolean getActivarFK_IdTipoTeclaMascaraOpcion() {
		return this.activarFK_IdTipoTeclaMascaraOpcion;
	}

	public void setActivarFK_IdTipoTeclaMascaraOpcion(Boolean habilitarResaltar) {
		this.activarFK_IdTipoTeclaMascaraOpcion= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorIdModuloPorIdOpcionOpcion=null;

	public Border getResaltarBusquedaPorIdModuloPorIdOpcionOpcion() {
		return this.resaltarBusquedaPorIdModuloPorIdOpcionOpcion;
	}

	public void setResaltarBusquedaPorIdModuloPorIdOpcionOpcion(Border borderResaltar) {
		this.resaltarBusquedaPorIdModuloPorIdOpcionOpcion= borderResaltar;
	}

	public void setResaltarBusquedaPorIdModuloPorIdOpcionOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*OpcionBeanSwingJInternalFrame opcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorIdModuloPorIdOpcionOpcion= borderResaltar;
	}

	public Border resaltarBusquedaPorIdModuloPorNombreOpcion=null;

	public Border getResaltarBusquedaPorIdModuloPorNombreOpcion() {
		return this.resaltarBusquedaPorIdModuloPorNombreOpcion;
	}

	public void setResaltarBusquedaPorIdModuloPorNombreOpcion(Border borderResaltar) {
		this.resaltarBusquedaPorIdModuloPorNombreOpcion= borderResaltar;
	}

	public void setResaltarBusquedaPorIdModuloPorNombreOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*OpcionBeanSwingJInternalFrame opcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorIdModuloPorNombreOpcion= borderResaltar;
	}

	public Border resaltarBusquedaPorIdSistemaPorModuloOpcion=null;

	public Border getResaltarBusquedaPorIdSistemaPorModuloOpcion() {
		return this.resaltarBusquedaPorIdSistemaPorModuloOpcion;
	}

	public void setResaltarBusquedaPorIdSistemaPorModuloOpcion(Border borderResaltar) {
		this.resaltarBusquedaPorIdSistemaPorModuloOpcion= borderResaltar;
	}

	public void setResaltarBusquedaPorIdSistemaPorModuloOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*OpcionBeanSwingJInternalFrame opcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorIdSistemaPorModuloOpcion= borderResaltar;
	}

	public Border resaltarFK_IdSistemaOpcion=null;

	public Border getResaltarFK_IdSistemaOpcion() {
		return this.resaltarFK_IdSistemaOpcion;
	}

	public void setResaltarFK_IdSistemaOpcion(Border borderResaltar) {
		this.resaltarFK_IdSistemaOpcion= borderResaltar;
	}

	public void setResaltarFK_IdSistemaOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*OpcionBeanSwingJInternalFrame opcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSistemaOpcion= borderResaltar;
	}

	public Border resaltarFK_IdTipoTeclaMascaraOpcion=null;

	public Border getResaltarFK_IdTipoTeclaMascaraOpcion() {
		return this.resaltarFK_IdTipoTeclaMascaraOpcion;
	}

	public void setResaltarFK_IdTipoTeclaMascaraOpcion(Border borderResaltar) {
		this.resaltarFK_IdTipoTeclaMascaraOpcion= borderResaltar;
	}

	public void setResaltarFK_IdTipoTeclaMascaraOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*OpcionBeanSwingJInternalFrame opcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoTeclaMascaraOpcion= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}