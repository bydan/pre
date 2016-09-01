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


import com.bydan.erp.seguridad.util.ParametroGeneralUsuarioConstantesFunciones;
import com.bydan.erp.seguridad.util.ParametroGeneralUsuarioParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.ParametroGeneralUsuarioParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.seguridad.business.entity.*;



import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.seguridad.business.dataaccess.*;
//import com.bydan.erp.seguridad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ParametroGeneralUsuarioConstantesFunciones extends ParametroGeneralUsuarioConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ParametroGeneralUsuario";
	public static final String SPATHOPCION="Seguridad";	
	public static final String SPATHMODULO="seguridad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ParametroGeneralUsuario"+ParametroGeneralUsuarioConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ParametroGeneralUsuarioHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ParametroGeneralUsuarioHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"_"+ParametroGeneralUsuarioConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ParametroGeneralUsuarioHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"_"+ParametroGeneralUsuarioConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"_"+ParametroGeneralUsuarioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ParametroGeneralUsuarioHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"_"+ParametroGeneralUsuarioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroGeneralUsuarioConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ParametroGeneralUsuarioHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroGeneralUsuarioConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroGeneralUsuarioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ParametroGeneralUsuarioHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroGeneralUsuarioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ParametroGeneralUsuarioConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ParametroGeneralUsuarioConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ParametroGeneralUsuarioConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ParametroGeneralUsuarioConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Parametro Generales";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Parametro General";
	public static final String SCLASSWEBTITULO_LOWER="Parametro General Usuario";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ParametroGeneralUsuario";
	public static final String OBJECTNAME="parametrogeneralusuario";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SEGURIDAD;	
	public static final String TABLENAME="parametro_general_usuario";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select parametrogeneralusuario from "+ParametroGeneralUsuarioConstantesFunciones.SPERSISTENCENAME+" parametrogeneralusuario";
	public static String QUERYSELECTNATIVE="select "+ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"."+ParametroGeneralUsuarioConstantesFunciones.TABLENAME+".id,"+ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"."+ParametroGeneralUsuarioConstantesFunciones.TABLENAME+".version_row,"+ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"."+ParametroGeneralUsuarioConstantesFunciones.TABLENAME+".id_empresa,"+ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"."+ParametroGeneralUsuarioConstantesFunciones.TABLENAME+".id_sucursal,"+ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"."+ParametroGeneralUsuarioConstantesFunciones.TABLENAME+".id_ejercicio,"+ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"."+ParametroGeneralUsuarioConstantesFunciones.TABLENAME+".id_periodo,"+ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"."+ParametroGeneralUsuarioConstantesFunciones.TABLENAME+".id_moneda,"+ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"."+ParametroGeneralUsuarioConstantesFunciones.TABLENAME+".fecha_sistema,"+ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"."+ParametroGeneralUsuarioConstantesFunciones.TABLENAME+".id_anio,"+ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"."+ParametroGeneralUsuarioConstantesFunciones.TABLENAME+".id_mes,"+ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"."+ParametroGeneralUsuarioConstantesFunciones.TABLENAME+".dia,"+ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"."+ParametroGeneralUsuarioConstantesFunciones.TABLENAME+".id_tipo_visual,"+ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"."+ParametroGeneralUsuarioConstantesFunciones.TABLENAME+".id_tipo_fondo,"+ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"."+ParametroGeneralUsuarioConstantesFunciones.TABLENAME+".id_tipo_fondo_borde,"+ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"."+ParametroGeneralUsuarioConstantesFunciones.TABLENAME+".id_tipo_fondo_control,"+ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"."+ParametroGeneralUsuarioConstantesFunciones.TABLENAME+".id_tipo_fuente,"+ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"."+ParametroGeneralUsuarioConstantesFunciones.TABLENAME+".id_tipo_tamanio_control_normal,"+ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"."+ParametroGeneralUsuarioConstantesFunciones.TABLENAME+".id_tipo_tamanio_control_relacion,"+ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"."+ParametroGeneralUsuarioConstantesFunciones.TABLENAME+".con_tamanio_control_manual,"+ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"."+ParametroGeneralUsuarioConstantesFunciones.TABLENAME+".con_tamanio_control_todo_relacion,"+ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"."+ParametroGeneralUsuarioConstantesFunciones.TABLENAME+".con_guardar_relaciones,"+ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"."+ParametroGeneralUsuarioConstantesFunciones.TABLENAME+".con_mensaje_confirmacion,"+ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"."+ParametroGeneralUsuarioConstantesFunciones.TABLENAME+".con_botones_tool_bar,"+ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"."+ParametroGeneralUsuarioConstantesFunciones.TABLENAME+".con_mostrar_acciones_campo_general,"+ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"."+ParametroGeneralUsuarioConstantesFunciones.TABLENAME+".con_mostrar_acciones_campo_relaciones,"+ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"."+ParametroGeneralUsuarioConstantesFunciones.TABLENAME+".id_tipo_exportar,"+ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"."+ParametroGeneralUsuarioConstantesFunciones.TABLENAME+".id_tipo_delimiter,"+ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"."+ParametroGeneralUsuarioConstantesFunciones.TABLENAME+".con_exportar_cabecera,"+ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"."+ParametroGeneralUsuarioConstantesFunciones.TABLENAME+".con_exportar_campo_version,"+ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"."+ParametroGeneralUsuarioConstantesFunciones.TABLENAME+".path_exportar,"+ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"."+ParametroGeneralUsuarioConstantesFunciones.TABLENAME+".con_precargar_ventanas,"+ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"."+ParametroGeneralUsuarioConstantesFunciones.TABLENAME+".con_precargar_por_usuario,"+ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"."+ParametroGeneralUsuarioConstantesFunciones.TABLENAME+".con_cargar_por_parte from "+ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"."+ParametroGeneralUsuarioConstantesFunciones.TABLENAME;//+" as "+ParametroGeneralUsuarioConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ParametroGeneralUsuarioConstantesFuncionesAdditional parametrogeneralusuarioConstantesFuncionesAdditional=null;
	
	public ParametroGeneralUsuarioConstantesFuncionesAdditional getParametroGeneralUsuarioConstantesFuncionesAdditional() {
		return this.parametrogeneralusuarioConstantesFuncionesAdditional;
	}
	
	public void setParametroGeneralUsuarioConstantesFuncionesAdditional(ParametroGeneralUsuarioConstantesFuncionesAdditional parametrogeneralusuarioConstantesFuncionesAdditional) {
		try {
			this.parametrogeneralusuarioConstantesFuncionesAdditional=parametrogeneralusuarioConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDPERIODO= "id_periodo";
    public static final String IDMONEDA= "id_moneda";
    public static final String FECHASISTEMA= "fecha_sistema";
    public static final String IDANIO= "id_anio";
    public static final String IDMES= "id_mes";
    public static final String DIA= "dia";
    public static final String IDTIPOVISUAL= "id_tipo_visual";
    public static final String IDTIPOFONDO= "id_tipo_fondo";
    public static final String IDTIPOFONDOBORDE= "id_tipo_fondo_borde";
    public static final String IDTIPOFONDOCONTROL= "id_tipo_fondo_control";
    public static final String IDTIPOFUENTE= "id_tipo_fuente";
    public static final String IDTIPOTAMANIOCONTROLNORMAL= "id_tipo_tamanio_control_normal";
    public static final String IDTIPOTAMANIOCONTROLRELACION= "id_tipo_tamanio_control_relacion";
    public static final String CONTAMANIOCONTROLMANUAL= "con_tamanio_control_manual";
    public static final String CONTAMANIOCONTROLTODORELACION= "con_tamanio_control_todo_relacion";
    public static final String CONGUARDARRELACIONES= "con_guardar_relaciones";
    public static final String CONMENSAJECONFIRMACION= "con_mensaje_confirmacion";
    public static final String CONBOTONESTOOLBAR= "con_botones_tool_bar";
    public static final String CONMOSTRARACCIONESCAMPOGENERAL= "con_mostrar_acciones_campo_general";
    public static final String CONMOSTRARACCIONESCAMPORELACIONES= "con_mostrar_acciones_campo_relaciones";
    public static final String IDTIPOEXPORTAR= "id_tipo_exportar";
    public static final String IDTIPODELIMITER= "id_tipo_delimiter";
    public static final String CONEXPORTARCABECERA= "con_exportar_cabecera";
    public static final String CONEXPORTARCAMPOVERSION= "con_exportar_campo_version";
    public static final String PATHEXPORTAR= "path_exportar";
    public static final String CONPRECARGARVENTANAS= "con_precargar_ventanas";
    public static final String CONPRECARGARPORUSUARIO= "con_precargar_por_usuario";
    public static final String CONCARGARPORPARTE= "con_cargar_por_parte";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "";
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
    	public static final String LABEL_IDMONEDA= "Moneda";
		public static final String LABEL_IDMONEDA_LOWER= "Moneda";
    	public static final String LABEL_FECHASISTEMA= "F Sistema";
		public static final String LABEL_FECHASISTEMA_LOWER= "Fecha Sistema";
    	public static final String LABEL_IDANIO= "Anio";
		public static final String LABEL_IDANIO_LOWER= "Anio";
    	public static final String LABEL_IDMES= "Mes";
		public static final String LABEL_IDMES_LOWER= "Mes";
    	public static final String LABEL_DIA= "Dia";
		public static final String LABEL_DIA_LOWER= "Dia";
    	public static final String LABEL_IDTIPOVISUAL= "Tipo Visual";
		public static final String LABEL_IDTIPOVISUAL_LOWER= "Tipo Visual";
    	public static final String LABEL_IDTIPOFONDO= "Tipo Fondo";
		public static final String LABEL_IDTIPOFONDO_LOWER= "Tipo Fondo";
    	public static final String LABEL_IDTIPOFONDOBORDE= "Tipo Fondo Borde";
		public static final String LABEL_IDTIPOFONDOBORDE_LOWER= "Tipo Fondo Borde";
    	public static final String LABEL_IDTIPOFONDOCONTROL= "Tipo Fondo Control";
		public static final String LABEL_IDTIPOFONDOCONTROL_LOWER= "Tipo Fondo Control";
    	public static final String LABEL_IDTIPOFUENTE= "Tipo Fuente";
		public static final String LABEL_IDTIPOFUENTE_LOWER= "Tipo Fuente";
    	public static final String LABEL_IDTIPOTAMANIOCONTROLNORMAL= "Tam. Control Normal";
		public static final String LABEL_IDTIPOTAMANIOCONTROLNORMAL_LOWER= "Tipo Tamanio Control Normal";
    	public static final String LABEL_IDTIPOTAMANIOCONTROLRELACION= "Tam. Control Relacion";
		public static final String LABEL_IDTIPOTAMANIOCONTROLRELACION_LOWER= "Tipo Tamanio Control Relacion";
    	public static final String LABEL_CONTAMANIOCONTROLMANUAL= "Tam. Control Manual";
		public static final String LABEL_CONTAMANIOCONTROLMANUAL_LOWER= "con Tamanio Control Manual";
    	public static final String LABEL_CONTAMANIOCONTROLTODORELACION= "Tam.Todo Relacion";
		public static final String LABEL_CONTAMANIOCONTROLTODORELACION_LOWER= "con Tamanio Control Todo Relacion";
    	public static final String LABEL_CONGUARDARRELACIONES= "Guardar Relaciones";
		public static final String LABEL_CONGUARDARRELACIONES_LOWER= "Con Guardar Relaciones";
    	public static final String LABEL_CONMENSAJECONFIRMACION= "Mensaje Confirmacion";
		public static final String LABEL_CONMENSAJECONFIRMACION_LOWER= "Con Mensaje Confirmacion";
    	public static final String LABEL_CONBOTONESTOOLBAR= "Botones Tool Bar";
		public static final String LABEL_CONBOTONESTOOLBAR_LOWER= "Con Botones Tool Bar";
    	public static final String LABEL_CONMOSTRARACCIONESCAMPOGENERAL= "Mostrar Acciones Campo General";
		public static final String LABEL_CONMOSTRARACCIONESCAMPOGENERAL_LOWER= "Con Mostrar Acciones Campo General";
    	public static final String LABEL_CONMOSTRARACCIONESCAMPORELACIONES= "Mostrar Acciones Campo Relaciones";
		public static final String LABEL_CONMOSTRARACCIONESCAMPORELACIONES_LOWER= "Con Mostrar Acciones Campo Relaciones";
    	public static final String LABEL_IDTIPOEXPORTAR= "T. Exportar";
		public static final String LABEL_IDTIPOEXPORTAR_LOWER= "Tipo Exportar";
    	public static final String LABEL_IDTIPODELIMITER= "T. Delimiter";
		public static final String LABEL_IDTIPODELIMITER_LOWER= "Tipo Delimiter";
    	public static final String LABEL_CONEXPORTARCABECERA= "Exportar Cabecera";
		public static final String LABEL_CONEXPORTARCABECERA_LOWER= "Con Exportar Cabecera";
    	public static final String LABEL_CONEXPORTARCAMPOVERSION= "Exportar Campo Version";
		public static final String LABEL_CONEXPORTARCAMPOVERSION_LOWER= "Con Exportar Campo Version";
    	public static final String LABEL_PATHEXPORTAR= "Path Exportar";
		public static final String LABEL_PATHEXPORTAR_LOWER= "Path Exportar";
    	public static final String LABEL_CONPRECARGARVENTANAS= "Precargar Ventanas";
		public static final String LABEL_CONPRECARGARVENTANAS_LOWER= "Con Precargar Ventanas";
    	public static final String LABEL_CONPRECARGARPORUSUARIO= "Precargar Por Usuario";
		public static final String LABEL_CONPRECARGARPORUSUARIO_LOWER= "Con Precargar Por Usuario";
    	public static final String LABEL_CONCARGARPORPARTE= "Con Cargar Por Parte";
		public static final String LABEL_CONCARGARPORPARTE_LOWER= "Con Cargar Por Parte";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXPATH_EXPORTAR=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXPATH_EXPORTAR=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
	
	public static String getParametroGeneralUsuarioLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ParametroGeneralUsuarioConstantesFunciones.IDEMPRESA)) {sLabelColumna=ParametroGeneralUsuarioConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ParametroGeneralUsuarioConstantesFunciones.IDSUCURSAL)) {sLabelColumna=ParametroGeneralUsuarioConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(ParametroGeneralUsuarioConstantesFunciones.IDEJERCICIO)) {sLabelColumna=ParametroGeneralUsuarioConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(ParametroGeneralUsuarioConstantesFunciones.IDPERIODO)) {sLabelColumna=ParametroGeneralUsuarioConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(ParametroGeneralUsuarioConstantesFunciones.IDMONEDA)) {sLabelColumna=ParametroGeneralUsuarioConstantesFunciones.LABEL_IDMONEDA;}
		if(sNombreColumna.equals(ParametroGeneralUsuarioConstantesFunciones.FECHASISTEMA)) {sLabelColumna=ParametroGeneralUsuarioConstantesFunciones.LABEL_FECHASISTEMA;}
		if(sNombreColumna.equals(ParametroGeneralUsuarioConstantesFunciones.IDANIO)) {sLabelColumna=ParametroGeneralUsuarioConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(ParametroGeneralUsuarioConstantesFunciones.IDMES)) {sLabelColumna=ParametroGeneralUsuarioConstantesFunciones.LABEL_IDMES;}
		if(sNombreColumna.equals(ParametroGeneralUsuarioConstantesFunciones.DIA)) {sLabelColumna=ParametroGeneralUsuarioConstantesFunciones.LABEL_DIA;}
		if(sNombreColumna.equals(ParametroGeneralUsuarioConstantesFunciones.IDTIPOVISUAL)) {sLabelColumna=ParametroGeneralUsuarioConstantesFunciones.LABEL_IDTIPOVISUAL;}
		if(sNombreColumna.equals(ParametroGeneralUsuarioConstantesFunciones.IDTIPOFONDO)) {sLabelColumna=ParametroGeneralUsuarioConstantesFunciones.LABEL_IDTIPOFONDO;}
		if(sNombreColumna.equals(ParametroGeneralUsuarioConstantesFunciones.IDTIPOFONDOBORDE)) {sLabelColumna=ParametroGeneralUsuarioConstantesFunciones.LABEL_IDTIPOFONDOBORDE;}
		if(sNombreColumna.equals(ParametroGeneralUsuarioConstantesFunciones.IDTIPOFONDOCONTROL)) {sLabelColumna=ParametroGeneralUsuarioConstantesFunciones.LABEL_IDTIPOFONDOCONTROL;}
		if(sNombreColumna.equals(ParametroGeneralUsuarioConstantesFunciones.IDTIPOFUENTE)) {sLabelColumna=ParametroGeneralUsuarioConstantesFunciones.LABEL_IDTIPOFUENTE;}
		if(sNombreColumna.equals(ParametroGeneralUsuarioConstantesFunciones.IDTIPOTAMANIOCONTROLNORMAL)) {sLabelColumna=ParametroGeneralUsuarioConstantesFunciones.LABEL_IDTIPOTAMANIOCONTROLNORMAL;}
		if(sNombreColumna.equals(ParametroGeneralUsuarioConstantesFunciones.IDTIPOTAMANIOCONTROLRELACION)) {sLabelColumna=ParametroGeneralUsuarioConstantesFunciones.LABEL_IDTIPOTAMANIOCONTROLRELACION;}
		if(sNombreColumna.equals(ParametroGeneralUsuarioConstantesFunciones.CONTAMANIOCONTROLMANUAL)) {sLabelColumna=ParametroGeneralUsuarioConstantesFunciones.LABEL_CONTAMANIOCONTROLMANUAL;}
		if(sNombreColumna.equals(ParametroGeneralUsuarioConstantesFunciones.CONTAMANIOCONTROLTODORELACION)) {sLabelColumna=ParametroGeneralUsuarioConstantesFunciones.LABEL_CONTAMANIOCONTROLTODORELACION;}
		if(sNombreColumna.equals(ParametroGeneralUsuarioConstantesFunciones.CONGUARDARRELACIONES)) {sLabelColumna=ParametroGeneralUsuarioConstantesFunciones.LABEL_CONGUARDARRELACIONES;}
		if(sNombreColumna.equals(ParametroGeneralUsuarioConstantesFunciones.CONMENSAJECONFIRMACION)) {sLabelColumna=ParametroGeneralUsuarioConstantesFunciones.LABEL_CONMENSAJECONFIRMACION;}
		if(sNombreColumna.equals(ParametroGeneralUsuarioConstantesFunciones.CONBOTONESTOOLBAR)) {sLabelColumna=ParametroGeneralUsuarioConstantesFunciones.LABEL_CONBOTONESTOOLBAR;}
		if(sNombreColumna.equals(ParametroGeneralUsuarioConstantesFunciones.CONMOSTRARACCIONESCAMPOGENERAL)) {sLabelColumna=ParametroGeneralUsuarioConstantesFunciones.LABEL_CONMOSTRARACCIONESCAMPOGENERAL;}
		if(sNombreColumna.equals(ParametroGeneralUsuarioConstantesFunciones.CONMOSTRARACCIONESCAMPORELACIONES)) {sLabelColumna=ParametroGeneralUsuarioConstantesFunciones.LABEL_CONMOSTRARACCIONESCAMPORELACIONES;}
		if(sNombreColumna.equals(ParametroGeneralUsuarioConstantesFunciones.IDTIPOEXPORTAR)) {sLabelColumna=ParametroGeneralUsuarioConstantesFunciones.LABEL_IDTIPOEXPORTAR;}
		if(sNombreColumna.equals(ParametroGeneralUsuarioConstantesFunciones.IDTIPODELIMITER)) {sLabelColumna=ParametroGeneralUsuarioConstantesFunciones.LABEL_IDTIPODELIMITER;}
		if(sNombreColumna.equals(ParametroGeneralUsuarioConstantesFunciones.CONEXPORTARCABECERA)) {sLabelColumna=ParametroGeneralUsuarioConstantesFunciones.LABEL_CONEXPORTARCABECERA;}
		if(sNombreColumna.equals(ParametroGeneralUsuarioConstantesFunciones.CONEXPORTARCAMPOVERSION)) {sLabelColumna=ParametroGeneralUsuarioConstantesFunciones.LABEL_CONEXPORTARCAMPOVERSION;}
		if(sNombreColumna.equals(ParametroGeneralUsuarioConstantesFunciones.PATHEXPORTAR)) {sLabelColumna=ParametroGeneralUsuarioConstantesFunciones.LABEL_PATHEXPORTAR;}
		if(sNombreColumna.equals(ParametroGeneralUsuarioConstantesFunciones.CONPRECARGARVENTANAS)) {sLabelColumna=ParametroGeneralUsuarioConstantesFunciones.LABEL_CONPRECARGARVENTANAS;}
		if(sNombreColumna.equals(ParametroGeneralUsuarioConstantesFunciones.CONPRECARGARPORUSUARIO)) {sLabelColumna=ParametroGeneralUsuarioConstantesFunciones.LABEL_CONPRECARGARPORUSUARIO;}
		if(sNombreColumna.equals(ParametroGeneralUsuarioConstantesFunciones.CONCARGARPORPARTE)) {sLabelColumna=ParametroGeneralUsuarioConstantesFunciones.LABEL_CONCARGARPORPARTE;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getcon_tamanio_control_manualDescripcion(ParametroGeneralUsuario parametrogeneralusuario) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametrogeneralusuario.getcon_tamanio_control_manual()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_tamanio_control_manualHtmlDescripcion(ParametroGeneralUsuario parametrogeneralusuario) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametrogeneralusuario.getId(),parametrogeneralusuario.getcon_tamanio_control_manual());

		return sDescripcion;
	}	
		
	public static String getcon_tamanio_control_todo_relacionDescripcion(ParametroGeneralUsuario parametrogeneralusuario) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametrogeneralusuario.getcon_tamanio_control_todo_relacion()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_tamanio_control_todo_relacionHtmlDescripcion(ParametroGeneralUsuario parametrogeneralusuario) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametrogeneralusuario.getId(),parametrogeneralusuario.getcon_tamanio_control_todo_relacion());

		return sDescripcion;
	}	
		
	public static String getcon_guardar_relacionesDescripcion(ParametroGeneralUsuario parametrogeneralusuario) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametrogeneralusuario.getcon_guardar_relaciones()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_guardar_relacionesHtmlDescripcion(ParametroGeneralUsuario parametrogeneralusuario) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametrogeneralusuario.getId(),parametrogeneralusuario.getcon_guardar_relaciones());

		return sDescripcion;
	}	
		
	public static String getcon_mensaje_confirmacionDescripcion(ParametroGeneralUsuario parametrogeneralusuario) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametrogeneralusuario.getcon_mensaje_confirmacion()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_mensaje_confirmacionHtmlDescripcion(ParametroGeneralUsuario parametrogeneralusuario) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametrogeneralusuario.getId(),parametrogeneralusuario.getcon_mensaje_confirmacion());

		return sDescripcion;
	}	
		
	public static String getcon_botones_tool_barDescripcion(ParametroGeneralUsuario parametrogeneralusuario) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametrogeneralusuario.getcon_botones_tool_bar()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_botones_tool_barHtmlDescripcion(ParametroGeneralUsuario parametrogeneralusuario) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametrogeneralusuario.getId(),parametrogeneralusuario.getcon_botones_tool_bar());

		return sDescripcion;
	}	
		
	public static String getcon_mostrar_acciones_campo_generalDescripcion(ParametroGeneralUsuario parametrogeneralusuario) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametrogeneralusuario.getcon_mostrar_acciones_campo_general()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_mostrar_acciones_campo_generalHtmlDescripcion(ParametroGeneralUsuario parametrogeneralusuario) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametrogeneralusuario.getId(),parametrogeneralusuario.getcon_mostrar_acciones_campo_general());

		return sDescripcion;
	}	
		
	public static String getcon_mostrar_acciones_campo_relacionesDescripcion(ParametroGeneralUsuario parametrogeneralusuario) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametrogeneralusuario.getcon_mostrar_acciones_campo_relaciones()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_mostrar_acciones_campo_relacionesHtmlDescripcion(ParametroGeneralUsuario parametrogeneralusuario) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametrogeneralusuario.getId(),parametrogeneralusuario.getcon_mostrar_acciones_campo_relaciones());

		return sDescripcion;
	}	
			
			
		
	public static String getcon_exportar_cabeceraDescripcion(ParametroGeneralUsuario parametrogeneralusuario) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametrogeneralusuario.getcon_exportar_cabecera()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_exportar_cabeceraHtmlDescripcion(ParametroGeneralUsuario parametrogeneralusuario) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametrogeneralusuario.getId(),parametrogeneralusuario.getcon_exportar_cabecera());

		return sDescripcion;
	}	
		
	public static String getcon_exportar_campo_versionDescripcion(ParametroGeneralUsuario parametrogeneralusuario) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametrogeneralusuario.getcon_exportar_campo_version()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_exportar_campo_versionHtmlDescripcion(ParametroGeneralUsuario parametrogeneralusuario) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametrogeneralusuario.getId(),parametrogeneralusuario.getcon_exportar_campo_version());

		return sDescripcion;
	}	
			
		
	public static String getcon_precargar_ventanasDescripcion(ParametroGeneralUsuario parametrogeneralusuario) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametrogeneralusuario.getcon_precargar_ventanas()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_precargar_ventanasHtmlDescripcion(ParametroGeneralUsuario parametrogeneralusuario) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametrogeneralusuario.getId(),parametrogeneralusuario.getcon_precargar_ventanas());

		return sDescripcion;
	}	
		
	public static String getcon_precargar_por_usuarioDescripcion(ParametroGeneralUsuario parametrogeneralusuario) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametrogeneralusuario.getcon_precargar_por_usuario()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_precargar_por_usuarioHtmlDescripcion(ParametroGeneralUsuario parametrogeneralusuario) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametrogeneralusuario.getId(),parametrogeneralusuario.getcon_precargar_por_usuario());

		return sDescripcion;
	}	
		
	public static String getcon_cargar_por_parteDescripcion(ParametroGeneralUsuario parametrogeneralusuario) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametrogeneralusuario.getcon_cargar_por_parte()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_cargar_por_parteHtmlDescripcion(ParametroGeneralUsuario parametrogeneralusuario) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametrogeneralusuario.getId(),parametrogeneralusuario.getcon_cargar_por_parte());

		return sDescripcion;
	}	
	
	public static String getParametroGeneralUsuarioDescripcion(ParametroGeneralUsuario parametrogeneralusuario) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(parametrogeneralusuario !=null/* && parametrogeneralusuario.getId()!=0*/) {
			if(parametrogeneralusuario.getId()!=null) {
				sDescripcion=parametrogeneralusuario.getId().toString();
			}//parametrogeneralusuarioparametrogeneralusuario.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getParametroGeneralUsuarioDescripcionDetallado(ParametroGeneralUsuario parametrogeneralusuario) {
		String sDescripcion="";
			
		sDescripcion+=ParametroGeneralUsuarioConstantesFunciones.ID+"=";
		sDescripcion+=parametrogeneralusuario.getId().toString()+",";
		sDescripcion+=ParametroGeneralUsuarioConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=parametrogeneralusuario.getVersionRow().toString()+",";
		sDescripcion+=ParametroGeneralUsuarioConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=parametrogeneralusuario.getid_empresa().toString()+",";
		sDescripcion+=ParametroGeneralUsuarioConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=parametrogeneralusuario.getid_sucursal().toString()+",";
		sDescripcion+=ParametroGeneralUsuarioConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=parametrogeneralusuario.getid_ejercicio().toString()+",";
		sDescripcion+=ParametroGeneralUsuarioConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=parametrogeneralusuario.getid_periodo().toString()+",";
		sDescripcion+=ParametroGeneralUsuarioConstantesFunciones.IDMONEDA+"=";
		sDescripcion+=parametrogeneralusuario.getid_moneda().toString()+",";
		sDescripcion+=ParametroGeneralUsuarioConstantesFunciones.FECHASISTEMA+"=";
		sDescripcion+=parametrogeneralusuario.getfecha_sistema().toString()+",";
		sDescripcion+=ParametroGeneralUsuarioConstantesFunciones.IDANIO+"=";
		sDescripcion+=parametrogeneralusuario.getid_anio().toString()+",";
		sDescripcion+=ParametroGeneralUsuarioConstantesFunciones.IDMES+"=";
		sDescripcion+=parametrogeneralusuario.getid_mes().toString()+",";
		sDescripcion+=ParametroGeneralUsuarioConstantesFunciones.DIA+"=";
		sDescripcion+=parametrogeneralusuario.getdia().toString()+",";
		sDescripcion+=ParametroGeneralUsuarioConstantesFunciones.IDTIPOVISUAL+"=";
		sDescripcion+=parametrogeneralusuario.getid_tipo_visual().toString()+",";
		sDescripcion+=ParametroGeneralUsuarioConstantesFunciones.IDTIPOFONDO+"=";
		sDescripcion+=parametrogeneralusuario.getid_tipo_fondo().toString()+",";
		sDescripcion+=ParametroGeneralUsuarioConstantesFunciones.IDTIPOFONDOBORDE+"=";
		sDescripcion+=parametrogeneralusuario.getid_tipo_fondo_borde().toString()+",";
		sDescripcion+=ParametroGeneralUsuarioConstantesFunciones.IDTIPOFONDOCONTROL+"=";
		sDescripcion+=parametrogeneralusuario.getid_tipo_fondo_control().toString()+",";
		sDescripcion+=ParametroGeneralUsuarioConstantesFunciones.IDTIPOFUENTE+"=";
		sDescripcion+=parametrogeneralusuario.getid_tipo_fuente().toString()+",";
		sDescripcion+=ParametroGeneralUsuarioConstantesFunciones.IDTIPOTAMANIOCONTROLNORMAL+"=";
		sDescripcion+=parametrogeneralusuario.getid_tipo_tamanio_control_normal().toString()+",";
		sDescripcion+=ParametroGeneralUsuarioConstantesFunciones.IDTIPOTAMANIOCONTROLRELACION+"=";
		sDescripcion+=parametrogeneralusuario.getid_tipo_tamanio_control_relacion().toString()+",";
		sDescripcion+=ParametroGeneralUsuarioConstantesFunciones.CONTAMANIOCONTROLMANUAL+"=";
		sDescripcion+=parametrogeneralusuario.getcon_tamanio_control_manual().toString()+",";
		sDescripcion+=ParametroGeneralUsuarioConstantesFunciones.CONTAMANIOCONTROLTODORELACION+"=";
		sDescripcion+=parametrogeneralusuario.getcon_tamanio_control_todo_relacion().toString()+",";
		sDescripcion+=ParametroGeneralUsuarioConstantesFunciones.CONGUARDARRELACIONES+"=";
		sDescripcion+=parametrogeneralusuario.getcon_guardar_relaciones().toString()+",";
		sDescripcion+=ParametroGeneralUsuarioConstantesFunciones.CONMENSAJECONFIRMACION+"=";
		sDescripcion+=parametrogeneralusuario.getcon_mensaje_confirmacion().toString()+",";
		sDescripcion+=ParametroGeneralUsuarioConstantesFunciones.CONBOTONESTOOLBAR+"=";
		sDescripcion+=parametrogeneralusuario.getcon_botones_tool_bar().toString()+",";
		sDescripcion+=ParametroGeneralUsuarioConstantesFunciones.CONMOSTRARACCIONESCAMPOGENERAL+"=";
		sDescripcion+=parametrogeneralusuario.getcon_mostrar_acciones_campo_general().toString()+",";
		sDescripcion+=ParametroGeneralUsuarioConstantesFunciones.CONMOSTRARACCIONESCAMPORELACIONES+"=";
		sDescripcion+=parametrogeneralusuario.getcon_mostrar_acciones_campo_relaciones().toString()+",";
		sDescripcion+=ParametroGeneralUsuarioConstantesFunciones.IDTIPOEXPORTAR+"=";
		sDescripcion+=parametrogeneralusuario.getid_tipo_exportar().toString()+",";
		sDescripcion+=ParametroGeneralUsuarioConstantesFunciones.IDTIPODELIMITER+"=";
		sDescripcion+=parametrogeneralusuario.getid_tipo_delimiter().toString()+",";
		sDescripcion+=ParametroGeneralUsuarioConstantesFunciones.CONEXPORTARCABECERA+"=";
		sDescripcion+=parametrogeneralusuario.getcon_exportar_cabecera().toString()+",";
		sDescripcion+=ParametroGeneralUsuarioConstantesFunciones.CONEXPORTARCAMPOVERSION+"=";
		sDescripcion+=parametrogeneralusuario.getcon_exportar_campo_version().toString()+",";
		sDescripcion+=ParametroGeneralUsuarioConstantesFunciones.PATHEXPORTAR+"=";
		sDescripcion+=parametrogeneralusuario.getpath_exportar()+",";
		sDescripcion+=ParametroGeneralUsuarioConstantesFunciones.CONPRECARGARVENTANAS+"=";
		sDescripcion+=parametrogeneralusuario.getcon_precargar_ventanas().toString()+",";
		sDescripcion+=ParametroGeneralUsuarioConstantesFunciones.CONPRECARGARPORUSUARIO+"=";
		sDescripcion+=parametrogeneralusuario.getcon_precargar_por_usuario().toString()+",";
		sDescripcion+=ParametroGeneralUsuarioConstantesFunciones.CONCARGARPORPARTE+"=";
		sDescripcion+=parametrogeneralusuario.getcon_cargar_por_parte().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setParametroGeneralUsuarioDescripcion(ParametroGeneralUsuario parametrogeneralusuario,String sValor) throws Exception {			
		if(parametrogeneralusuario !=null) {
			//parametrogeneralusuarioparametrogeneralusuario.getId().toString();
		}		
	}
	
		

	public static String getUsuarioDescripcion(Usuario usuario) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(usuario!=null/*&&usuario.getId()>0*/) {
			sDescripcion=UsuarioConstantesFunciones.getUsuarioDescripcion(usuario);
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

	public static String getMonedaDescripcion(Moneda moneda) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(moneda!=null/*&&moneda.getId()>0*/) {
			sDescripcion=MonedaConstantesFunciones.getMonedaDescripcion(moneda);
		}

		return sDescripcion;
	}

	public static String getAnioDescripcion(Anio anio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(anio!=null/*&&anio.getId()>0*/) {
			sDescripcion=AnioConstantesFunciones.getAnioDescripcion(anio);
		}

		return sDescripcion;
	}

	public static String getMesDescripcion(Mes mes) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(mes!=null/*&&mes.getId()>0*/) {
			sDescripcion=MesConstantesFunciones.getMesDescripcion(mes);
		}

		return sDescripcion;
	}

	public static String getTipoVisualDescripcion(TipoVisual tipovisual) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipovisual!=null/*&&tipovisual.getId()>0*/) {
			sDescripcion=TipoVisualConstantesFunciones.getTipoVisualDescripcion(tipovisual);
		}

		return sDescripcion;
	}

	public static String getTipoFondoDescripcion(TipoFondo tipofondo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipofondo!=null/*&&tipofondo.getId()>0*/) {
			sDescripcion=TipoFondoConstantesFunciones.getTipoFondoDescripcion(tipofondo);
		}

		return sDescripcion;
	}

	public static String getTipoFondoBordeDescripcion(TipoFondo tipofondo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipofondo!=null/*&&tipofondo.getId()>0*/) {
			sDescripcion=TipoFondoConstantesFunciones.getTipoFondoDescripcion(tipofondo);
		}

		return sDescripcion;
	}

	public static String getTipoFondoControlDescripcion(TipoFondoControl tipofondocontrol) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipofondocontrol!=null/*&&tipofondocontrol.getId()>0*/) {
			sDescripcion=TipoFondoControlConstantesFunciones.getTipoFondoControlDescripcion(tipofondocontrol);
		}

		return sDescripcion;
	}

	public static String getTipoFuenteDescripcion(TipoFuente tipofuente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipofuente!=null/*&&tipofuente.getId()>0*/) {
			sDescripcion=TipoFuenteConstantesFunciones.getTipoFuenteDescripcion(tipofuente);
		}

		return sDescripcion;
	}

	public static String getTipoTamanioControlNormalDescripcion(TipoTamanioControl tipotamaniocontrol) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipotamaniocontrol!=null/*&&tipotamaniocontrol.getId()>0*/) {
			sDescripcion=TipoTamanioControlConstantesFunciones.getTipoTamanioControlDescripcion(tipotamaniocontrol);
		}

		return sDescripcion;
	}

	public static String getTipoTamanioControlRelacionDescripcion(TipoTamanioControl tipotamaniocontrol) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipotamaniocontrol!=null/*&&tipotamaniocontrol.getId()>0*/) {
			sDescripcion=TipoTamanioControlConstantesFunciones.getTipoTamanioControlDescripcion(tipotamaniocontrol);
		}

		return sDescripcion;
	}

	public static String getTipoExportarDescripcion(TipoExportar tipoexportar) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoexportar!=null/*&&tipoexportar.getId()>0*/) {
			sDescripcion=TipoExportarConstantesFunciones.getTipoExportarDescripcion(tipoexportar);
		}

		return sDescripcion;
	}

	public static String getTipoDelimiterDescripcion(TipoDelimiter tipodelimiter) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipodelimiter!=null/*&&tipodelimiter.getId()>0*/) {
			sDescripcion=TipoDelimiterConstantesFunciones.getTipoDelimiterDescripcion(tipodelimiter);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdAnio")) {
			sNombreIndice="Tipo=  Por Anio";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdMes")) {
			sNombreIndice="Tipo=  Por Mes";
		} else if(sNombreIndice.equals("FK_IdMoneda")) {
			sNombreIndice="Tipo=  Por Moneda";
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoDelimiter")) {
			sNombreIndice="Tipo=  Por T. Delimiter";
		} else if(sNombreIndice.equals("FK_IdTipoExportar")) {
			sNombreIndice="Tipo=  Por T. Exportar";
		} else if(sNombreIndice.equals("FK_IdTipoFondo")) {
			sNombreIndice="Tipo=  Por Tipo Fondo";
		} else if(sNombreIndice.equals("FK_IdTipoFondoBorde")) {
			sNombreIndice="Tipo=  Por Tipo Fondo Borde";
		} else if(sNombreIndice.equals("FK_IdTipoFondoControl")) {
			sNombreIndice="Tipo=  Por Tipo Fondo Control";
		} else if(sNombreIndice.equals("FK_IdTipoFuente")) {
			sNombreIndice="Tipo=  Por Tipo Fuente";
		} else if(sNombreIndice.equals("FK_IdTipoTamanioControlNormal")) {
			sNombreIndice="Tipo=  Por Tam. Control Normal";
		} else if(sNombreIndice.equals("FK_IdTipoTamanioControlRelacion")) {
			sNombreIndice="Tipo=  Por Tam. Control Relacion";
		} else if(sNombreIndice.equals("FK_IdTipoVisual")) {
			sNombreIndice="Tipo=  Por Tipo Visual";
		} else if(sNombreIndice.equals("FK_IdUsuario")) {
			sNombreIndice="Tipo=  Por Id";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdAnio(Long id_anio) {
		String sDetalleIndice=" Parametros->";
		if(id_anio!=null) {sDetalleIndice+=" Codigo Unico De Anio="+id_anio.toString();} 

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

	public static String getDetalleIndiceFK_IdMes(Long id_mes) {
		String sDetalleIndice=" Parametros->";
		if(id_mes!=null) {sDetalleIndice+=" Codigo Unico De Mes="+id_mes.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdMoneda(Long id_moneda) {
		String sDetalleIndice=" Parametros->";
		if(id_moneda!=null) {sDetalleIndice+=" Codigo Unico De Moneda="+id_moneda.toString();} 

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

	public static String getDetalleIndiceFK_IdTipoDelimiter(Long id_tipo_delimiter) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_delimiter!=null) {sDetalleIndice+=" Codigo Unico De T. Delimiter="+id_tipo_delimiter.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoExportar(Long id_tipo_exportar) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_exportar!=null) {sDetalleIndice+=" Codigo Unico De T. Exportar="+id_tipo_exportar.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoFondo(Long id_tipo_fondo) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_fondo!=null) {sDetalleIndice+=" Codigo Unico De Tipo Fondo="+id_tipo_fondo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoFondoBorde(Long id_tipo_fondo_borde) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_fondo_borde!=null) {sDetalleIndice+=" Codigo Unico De Tipo Fondo Borde="+id_tipo_fondo_borde.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoFondoControl(Long id_tipo_fondo_control) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_fondo_control!=null) {sDetalleIndice+=" Codigo Unico De Tipo Fondo Control="+id_tipo_fondo_control.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoFuente(Long id_tipo_fuente) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_fuente!=null) {sDetalleIndice+=" Codigo Unico De Tipo Fuente="+id_tipo_fuente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoTamanioControlNormal(Long id_tipo_tamanio_control_normal) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_tamanio_control_normal!=null) {sDetalleIndice+=" Codigo Unico De Tam. Control Normal="+id_tipo_tamanio_control_normal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoTamanioControlRelacion(Long id_tipo_tamanio_control_relacion) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_tamanio_control_relacion!=null) {sDetalleIndice+=" Codigo Unico De Tam. Control Relacion="+id_tipo_tamanio_control_relacion.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoVisual(Long id_tipo_visual) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_visual!=null) {sDetalleIndice+=" Codigo Unico De Tipo Visual="+id_tipo_visual.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdUsuario(Long id_usuario) {
		String sDetalleIndice=" Parametros->";
		if(id_usuario!=null) {sDetalleIndice+=" Codigo Unico De Id="+id_usuario.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosParametroGeneralUsuario(ParametroGeneralUsuario parametrogeneralusuario,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		parametrogeneralusuario.setpath_exportar(parametrogeneralusuario.getpath_exportar().trim());
	}
	
	public static void quitarEspaciosParametroGeneralUsuarios(List<ParametroGeneralUsuario> parametrogeneralusuarios,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ParametroGeneralUsuario parametrogeneralusuario: parametrogeneralusuarios) {
			parametrogeneralusuario.setpath_exportar(parametrogeneralusuario.getpath_exportar().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresParametroGeneralUsuario(ParametroGeneralUsuario parametrogeneralusuario,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && parametrogeneralusuario.getConCambioAuxiliar()) {
			parametrogeneralusuario.setIsDeleted(parametrogeneralusuario.getIsDeletedAuxiliar());	
			parametrogeneralusuario.setIsNew(parametrogeneralusuario.getIsNewAuxiliar());	
			parametrogeneralusuario.setIsChanged(parametrogeneralusuario.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			parametrogeneralusuario.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			parametrogeneralusuario.setIsDeletedAuxiliar(false);	
			parametrogeneralusuario.setIsNewAuxiliar(false);	
			parametrogeneralusuario.setIsChangedAuxiliar(false);
			
			parametrogeneralusuario.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresParametroGeneralUsuarios(List<ParametroGeneralUsuario> parametrogeneralusuarios,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ParametroGeneralUsuario parametrogeneralusuario : parametrogeneralusuarios) {
			if(conAsignarBase && parametrogeneralusuario.getConCambioAuxiliar()) {
				parametrogeneralusuario.setIsDeleted(parametrogeneralusuario.getIsDeletedAuxiliar());	
				parametrogeneralusuario.setIsNew(parametrogeneralusuario.getIsNewAuxiliar());	
				parametrogeneralusuario.setIsChanged(parametrogeneralusuario.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				parametrogeneralusuario.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				parametrogeneralusuario.setIsDeletedAuxiliar(false);	
				parametrogeneralusuario.setIsNewAuxiliar(false);	
				parametrogeneralusuario.setIsChangedAuxiliar(false);
				
				parametrogeneralusuario.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresParametroGeneralUsuario(ParametroGeneralUsuario parametrogeneralusuario,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
			parametrogeneralusuario.setdia(0);
		}
	}		
	
	public static void InicializarValoresParametroGeneralUsuarios(List<ParametroGeneralUsuario> parametrogeneralusuarios,Boolean conEnteros) throws Exception  {
		
		for(ParametroGeneralUsuario parametrogeneralusuario: parametrogeneralusuarios) {
		
			if(conEnteros) {
				Short ish_value=0;
				
				parametrogeneralusuario.setdia(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaParametroGeneralUsuario(List<ParametroGeneralUsuario> parametrogeneralusuarios,ParametroGeneralUsuario parametrogeneralusuarioAux) throws Exception  {
		ParametroGeneralUsuarioConstantesFunciones.InicializarValoresParametroGeneralUsuario(parametrogeneralusuarioAux,true);
		
		for(ParametroGeneralUsuario parametrogeneralusuario: parametrogeneralusuarios) {
			if(parametrogeneralusuario.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			parametrogeneralusuarioAux.setdia(parametrogeneralusuarioAux.getdia()+parametrogeneralusuario.getdia());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesParametroGeneralUsuario(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ParametroGeneralUsuarioConstantesFunciones.getArrayColumnasGlobalesParametroGeneralUsuario(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesParametroGeneralUsuario(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoParametroGeneralUsuario(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ParametroGeneralUsuario> parametrogeneralusuarios,ParametroGeneralUsuario parametrogeneralusuario,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ParametroGeneralUsuario parametrogeneralusuarioAux: parametrogeneralusuarios) {
			if(parametrogeneralusuarioAux!=null && parametrogeneralusuario!=null) {
				if((parametrogeneralusuarioAux.getId()==null && parametrogeneralusuario.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(parametrogeneralusuarioAux.getId()!=null && parametrogeneralusuario.getId()!=null){
					if(parametrogeneralusuarioAux.getId().equals(parametrogeneralusuario.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaParametroGeneralUsuario(List<ParametroGeneralUsuario> parametrogeneralusuarios) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ParametroGeneralUsuario parametrogeneralusuario: parametrogeneralusuarios) {			
			if(parametrogeneralusuario.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaParametroGeneralUsuario() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ParametroGeneralUsuarioConstantesFunciones.LABEL_ID, ParametroGeneralUsuarioConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGeneralUsuarioConstantesFunciones.LABEL_VERSIONROW, ParametroGeneralUsuarioConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGeneralUsuarioConstantesFunciones.LABEL_IDEMPRESA, ParametroGeneralUsuarioConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGeneralUsuarioConstantesFunciones.LABEL_IDSUCURSAL, ParametroGeneralUsuarioConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGeneralUsuarioConstantesFunciones.LABEL_IDEJERCICIO, ParametroGeneralUsuarioConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGeneralUsuarioConstantesFunciones.LABEL_IDPERIODO, ParametroGeneralUsuarioConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGeneralUsuarioConstantesFunciones.LABEL_IDMONEDA, ParametroGeneralUsuarioConstantesFunciones.IDMONEDA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGeneralUsuarioConstantesFunciones.LABEL_FECHASISTEMA, ParametroGeneralUsuarioConstantesFunciones.FECHASISTEMA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGeneralUsuarioConstantesFunciones.LABEL_IDANIO, ParametroGeneralUsuarioConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGeneralUsuarioConstantesFunciones.LABEL_IDMES, ParametroGeneralUsuarioConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGeneralUsuarioConstantesFunciones.LABEL_DIA, ParametroGeneralUsuarioConstantesFunciones.DIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGeneralUsuarioConstantesFunciones.LABEL_IDTIPOVISUAL, ParametroGeneralUsuarioConstantesFunciones.IDTIPOVISUAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGeneralUsuarioConstantesFunciones.LABEL_IDTIPOFONDO, ParametroGeneralUsuarioConstantesFunciones.IDTIPOFONDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGeneralUsuarioConstantesFunciones.LABEL_IDTIPOFONDOBORDE, ParametroGeneralUsuarioConstantesFunciones.IDTIPOFONDOBORDE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGeneralUsuarioConstantesFunciones.LABEL_IDTIPOFONDOCONTROL, ParametroGeneralUsuarioConstantesFunciones.IDTIPOFONDOCONTROL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGeneralUsuarioConstantesFunciones.LABEL_IDTIPOFUENTE, ParametroGeneralUsuarioConstantesFunciones.IDTIPOFUENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGeneralUsuarioConstantesFunciones.LABEL_IDTIPOTAMANIOCONTROLNORMAL, ParametroGeneralUsuarioConstantesFunciones.IDTIPOTAMANIOCONTROLNORMAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGeneralUsuarioConstantesFunciones.LABEL_IDTIPOTAMANIOCONTROLRELACION, ParametroGeneralUsuarioConstantesFunciones.IDTIPOTAMANIOCONTROLRELACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGeneralUsuarioConstantesFunciones.LABEL_CONTAMANIOCONTROLMANUAL, ParametroGeneralUsuarioConstantesFunciones.CONTAMANIOCONTROLMANUAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGeneralUsuarioConstantesFunciones.LABEL_CONTAMANIOCONTROLTODORELACION, ParametroGeneralUsuarioConstantesFunciones.CONTAMANIOCONTROLTODORELACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGeneralUsuarioConstantesFunciones.LABEL_CONGUARDARRELACIONES, ParametroGeneralUsuarioConstantesFunciones.CONGUARDARRELACIONES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGeneralUsuarioConstantesFunciones.LABEL_CONMENSAJECONFIRMACION, ParametroGeneralUsuarioConstantesFunciones.CONMENSAJECONFIRMACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGeneralUsuarioConstantesFunciones.LABEL_CONBOTONESTOOLBAR, ParametroGeneralUsuarioConstantesFunciones.CONBOTONESTOOLBAR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGeneralUsuarioConstantesFunciones.LABEL_CONMOSTRARACCIONESCAMPOGENERAL, ParametroGeneralUsuarioConstantesFunciones.CONMOSTRARACCIONESCAMPOGENERAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGeneralUsuarioConstantesFunciones.LABEL_CONMOSTRARACCIONESCAMPORELACIONES, ParametroGeneralUsuarioConstantesFunciones.CONMOSTRARACCIONESCAMPORELACIONES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGeneralUsuarioConstantesFunciones.LABEL_IDTIPOEXPORTAR, ParametroGeneralUsuarioConstantesFunciones.IDTIPOEXPORTAR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGeneralUsuarioConstantesFunciones.LABEL_IDTIPODELIMITER, ParametroGeneralUsuarioConstantesFunciones.IDTIPODELIMITER,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGeneralUsuarioConstantesFunciones.LABEL_CONEXPORTARCABECERA, ParametroGeneralUsuarioConstantesFunciones.CONEXPORTARCABECERA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGeneralUsuarioConstantesFunciones.LABEL_CONEXPORTARCAMPOVERSION, ParametroGeneralUsuarioConstantesFunciones.CONEXPORTARCAMPOVERSION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGeneralUsuarioConstantesFunciones.LABEL_PATHEXPORTAR, ParametroGeneralUsuarioConstantesFunciones.PATHEXPORTAR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGeneralUsuarioConstantesFunciones.LABEL_CONPRECARGARVENTANAS, ParametroGeneralUsuarioConstantesFunciones.CONPRECARGARVENTANAS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGeneralUsuarioConstantesFunciones.LABEL_CONPRECARGARPORUSUARIO, ParametroGeneralUsuarioConstantesFunciones.CONPRECARGARPORUSUARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGeneralUsuarioConstantesFunciones.LABEL_CONCARGARPORPARTE, ParametroGeneralUsuarioConstantesFunciones.CONCARGARPORPARTE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasParametroGeneralUsuario() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ParametroGeneralUsuarioConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGeneralUsuarioConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGeneralUsuarioConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGeneralUsuarioConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGeneralUsuarioConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGeneralUsuarioConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGeneralUsuarioConstantesFunciones.IDMONEDA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGeneralUsuarioConstantesFunciones.FECHASISTEMA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGeneralUsuarioConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGeneralUsuarioConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGeneralUsuarioConstantesFunciones.DIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGeneralUsuarioConstantesFunciones.IDTIPOVISUAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGeneralUsuarioConstantesFunciones.IDTIPOFONDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGeneralUsuarioConstantesFunciones.IDTIPOFONDOBORDE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGeneralUsuarioConstantesFunciones.IDTIPOFONDOCONTROL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGeneralUsuarioConstantesFunciones.IDTIPOFUENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGeneralUsuarioConstantesFunciones.IDTIPOTAMANIOCONTROLNORMAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGeneralUsuarioConstantesFunciones.IDTIPOTAMANIOCONTROLRELACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGeneralUsuarioConstantesFunciones.CONTAMANIOCONTROLMANUAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGeneralUsuarioConstantesFunciones.CONTAMANIOCONTROLTODORELACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGeneralUsuarioConstantesFunciones.CONGUARDARRELACIONES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGeneralUsuarioConstantesFunciones.CONMENSAJECONFIRMACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGeneralUsuarioConstantesFunciones.CONBOTONESTOOLBAR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGeneralUsuarioConstantesFunciones.CONMOSTRARACCIONESCAMPOGENERAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGeneralUsuarioConstantesFunciones.CONMOSTRARACCIONESCAMPORELACIONES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGeneralUsuarioConstantesFunciones.IDTIPOEXPORTAR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGeneralUsuarioConstantesFunciones.IDTIPODELIMITER;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGeneralUsuarioConstantesFunciones.CONEXPORTARCABECERA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGeneralUsuarioConstantesFunciones.CONEXPORTARCAMPOVERSION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGeneralUsuarioConstantesFunciones.PATHEXPORTAR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGeneralUsuarioConstantesFunciones.CONPRECARGARVENTANAS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGeneralUsuarioConstantesFunciones.CONPRECARGARPORUSUARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGeneralUsuarioConstantesFunciones.CONCARGARPORPARTE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroGeneralUsuario() throws Exception  {
		return ParametroGeneralUsuarioConstantesFunciones.getTiposSeleccionarParametroGeneralUsuario(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroGeneralUsuario(Boolean conFk) throws Exception  {
		return ParametroGeneralUsuarioConstantesFunciones.getTiposSeleccionarParametroGeneralUsuario(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroGeneralUsuario(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGeneralUsuarioConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ParametroGeneralUsuarioConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGeneralUsuarioConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(ParametroGeneralUsuarioConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGeneralUsuarioConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(ParametroGeneralUsuarioConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGeneralUsuarioConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(ParametroGeneralUsuarioConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGeneralUsuarioConstantesFunciones.LABEL_IDMONEDA);
			reporte.setsDescripcion(ParametroGeneralUsuarioConstantesFunciones.LABEL_IDMONEDA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGeneralUsuarioConstantesFunciones.LABEL_FECHASISTEMA);
			reporte.setsDescripcion(ParametroGeneralUsuarioConstantesFunciones.LABEL_FECHASISTEMA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGeneralUsuarioConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(ParametroGeneralUsuarioConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGeneralUsuarioConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(ParametroGeneralUsuarioConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGeneralUsuarioConstantesFunciones.LABEL_DIA);
			reporte.setsDescripcion(ParametroGeneralUsuarioConstantesFunciones.LABEL_DIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGeneralUsuarioConstantesFunciones.LABEL_IDTIPOVISUAL);
			reporte.setsDescripcion(ParametroGeneralUsuarioConstantesFunciones.LABEL_IDTIPOVISUAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGeneralUsuarioConstantesFunciones.LABEL_IDTIPOFONDO);
			reporte.setsDescripcion(ParametroGeneralUsuarioConstantesFunciones.LABEL_IDTIPOFONDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGeneralUsuarioConstantesFunciones.LABEL_IDTIPOFONDOBORDE);
			reporte.setsDescripcion(ParametroGeneralUsuarioConstantesFunciones.LABEL_IDTIPOFONDOBORDE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGeneralUsuarioConstantesFunciones.LABEL_IDTIPOFONDOCONTROL);
			reporte.setsDescripcion(ParametroGeneralUsuarioConstantesFunciones.LABEL_IDTIPOFONDOCONTROL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGeneralUsuarioConstantesFunciones.LABEL_IDTIPOFUENTE);
			reporte.setsDescripcion(ParametroGeneralUsuarioConstantesFunciones.LABEL_IDTIPOFUENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGeneralUsuarioConstantesFunciones.LABEL_IDTIPOTAMANIOCONTROLNORMAL);
			reporte.setsDescripcion(ParametroGeneralUsuarioConstantesFunciones.LABEL_IDTIPOTAMANIOCONTROLNORMAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGeneralUsuarioConstantesFunciones.LABEL_IDTIPOTAMANIOCONTROLRELACION);
			reporte.setsDescripcion(ParametroGeneralUsuarioConstantesFunciones.LABEL_IDTIPOTAMANIOCONTROLRELACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGeneralUsuarioConstantesFunciones.LABEL_CONTAMANIOCONTROLMANUAL);
			reporte.setsDescripcion(ParametroGeneralUsuarioConstantesFunciones.LABEL_CONTAMANIOCONTROLMANUAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGeneralUsuarioConstantesFunciones.LABEL_CONTAMANIOCONTROLTODORELACION);
			reporte.setsDescripcion(ParametroGeneralUsuarioConstantesFunciones.LABEL_CONTAMANIOCONTROLTODORELACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGeneralUsuarioConstantesFunciones.LABEL_CONGUARDARRELACIONES);
			reporte.setsDescripcion(ParametroGeneralUsuarioConstantesFunciones.LABEL_CONGUARDARRELACIONES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGeneralUsuarioConstantesFunciones.LABEL_CONMENSAJECONFIRMACION);
			reporte.setsDescripcion(ParametroGeneralUsuarioConstantesFunciones.LABEL_CONMENSAJECONFIRMACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGeneralUsuarioConstantesFunciones.LABEL_CONBOTONESTOOLBAR);
			reporte.setsDescripcion(ParametroGeneralUsuarioConstantesFunciones.LABEL_CONBOTONESTOOLBAR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGeneralUsuarioConstantesFunciones.LABEL_CONMOSTRARACCIONESCAMPOGENERAL);
			reporte.setsDescripcion(ParametroGeneralUsuarioConstantesFunciones.LABEL_CONMOSTRARACCIONESCAMPOGENERAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGeneralUsuarioConstantesFunciones.LABEL_CONMOSTRARACCIONESCAMPORELACIONES);
			reporte.setsDescripcion(ParametroGeneralUsuarioConstantesFunciones.LABEL_CONMOSTRARACCIONESCAMPORELACIONES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGeneralUsuarioConstantesFunciones.LABEL_IDTIPOEXPORTAR);
			reporte.setsDescripcion(ParametroGeneralUsuarioConstantesFunciones.LABEL_IDTIPOEXPORTAR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGeneralUsuarioConstantesFunciones.LABEL_IDTIPODELIMITER);
			reporte.setsDescripcion(ParametroGeneralUsuarioConstantesFunciones.LABEL_IDTIPODELIMITER);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGeneralUsuarioConstantesFunciones.LABEL_CONEXPORTARCABECERA);
			reporte.setsDescripcion(ParametroGeneralUsuarioConstantesFunciones.LABEL_CONEXPORTARCABECERA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGeneralUsuarioConstantesFunciones.LABEL_CONEXPORTARCAMPOVERSION);
			reporte.setsDescripcion(ParametroGeneralUsuarioConstantesFunciones.LABEL_CONEXPORTARCAMPOVERSION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGeneralUsuarioConstantesFunciones.LABEL_PATHEXPORTAR);
			reporte.setsDescripcion(ParametroGeneralUsuarioConstantesFunciones.LABEL_PATHEXPORTAR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGeneralUsuarioConstantesFunciones.LABEL_CONPRECARGARVENTANAS);
			reporte.setsDescripcion(ParametroGeneralUsuarioConstantesFunciones.LABEL_CONPRECARGARVENTANAS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGeneralUsuarioConstantesFunciones.LABEL_CONPRECARGARPORUSUARIO);
			reporte.setsDescripcion(ParametroGeneralUsuarioConstantesFunciones.LABEL_CONPRECARGARPORUSUARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGeneralUsuarioConstantesFunciones.LABEL_CONCARGARPORPARTE);
			reporte.setsDescripcion(ParametroGeneralUsuarioConstantesFunciones.LABEL_CONCARGARPORPARTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesParametroGeneralUsuario(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesParametroGeneralUsuario(ParametroGeneralUsuario parametrogeneralusuarioAux) throws Exception {
		
			parametrogeneralusuarioAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(parametrogeneralusuarioAux.getUsuario()));
			parametrogeneralusuarioAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(parametrogeneralusuarioAux.getEmpresa()));
			parametrogeneralusuarioAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(parametrogeneralusuarioAux.getSucursal()));
			parametrogeneralusuarioAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(parametrogeneralusuarioAux.getEjercicio()));
			parametrogeneralusuarioAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(parametrogeneralusuarioAux.getPeriodo()));
			parametrogeneralusuarioAux.setmoneda_descripcion(MonedaConstantesFunciones.getMonedaDescripcion(parametrogeneralusuarioAux.getMoneda()));
			parametrogeneralusuarioAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(parametrogeneralusuarioAux.getAnio()));
			parametrogeneralusuarioAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(parametrogeneralusuarioAux.getMes()));
			parametrogeneralusuarioAux.settipovisual_descripcion(TipoVisualConstantesFunciones.getTipoVisualDescripcion(parametrogeneralusuarioAux.getTipoVisual()));
			parametrogeneralusuarioAux.settipofondo_descripcion(TipoFondoConstantesFunciones.getTipoFondoDescripcion(parametrogeneralusuarioAux.getTipoFondo()));
			parametrogeneralusuarioAux.settipofondoborde_descripcion(TipoFondoConstantesFunciones.getTipoFondoDescripcion(parametrogeneralusuarioAux.getTipoFondoBorde()));
			parametrogeneralusuarioAux.settipofondocontrol_descripcion(TipoFondoControlConstantesFunciones.getTipoFondoControlDescripcion(parametrogeneralusuarioAux.getTipoFondoControl()));
			parametrogeneralusuarioAux.settipofuente_descripcion(TipoFuenteConstantesFunciones.getTipoFuenteDescripcion(parametrogeneralusuarioAux.getTipoFuente()));
			parametrogeneralusuarioAux.settipotamaniocontrolnormal_descripcion(TipoTamanioControlConstantesFunciones.getTipoTamanioControlDescripcion(parametrogeneralusuarioAux.getTipoTamanioControlNormal()));
			parametrogeneralusuarioAux.settipotamaniocontrolrelacion_descripcion(TipoTamanioControlConstantesFunciones.getTipoTamanioControlDescripcion(parametrogeneralusuarioAux.getTipoTamanioControlRelacion()));
			parametrogeneralusuarioAux.settipoexportar_descripcion(TipoExportarConstantesFunciones.getTipoExportarDescripcion(parametrogeneralusuarioAux.getTipoExportar()));
			parametrogeneralusuarioAux.settipodelimiter_descripcion(TipoDelimiterConstantesFunciones.getTipoDelimiterDescripcion(parametrogeneralusuarioAux.getTipoDelimiter()));		
	}
	
	public static void refrescarForeignKeysDescripcionesParametroGeneralUsuario(List<ParametroGeneralUsuario> parametrogeneralusuariosTemp) throws Exception {
		for(ParametroGeneralUsuario parametrogeneralusuarioAux:parametrogeneralusuariosTemp) {
			
			parametrogeneralusuarioAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(parametrogeneralusuarioAux.getUsuario()));
			parametrogeneralusuarioAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(parametrogeneralusuarioAux.getEmpresa()));
			parametrogeneralusuarioAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(parametrogeneralusuarioAux.getSucursal()));
			parametrogeneralusuarioAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(parametrogeneralusuarioAux.getEjercicio()));
			parametrogeneralusuarioAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(parametrogeneralusuarioAux.getPeriodo()));
			parametrogeneralusuarioAux.setmoneda_descripcion(MonedaConstantesFunciones.getMonedaDescripcion(parametrogeneralusuarioAux.getMoneda()));
			parametrogeneralusuarioAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(parametrogeneralusuarioAux.getAnio()));
			parametrogeneralusuarioAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(parametrogeneralusuarioAux.getMes()));
			parametrogeneralusuarioAux.settipovisual_descripcion(TipoVisualConstantesFunciones.getTipoVisualDescripcion(parametrogeneralusuarioAux.getTipoVisual()));
			parametrogeneralusuarioAux.settipofondo_descripcion(TipoFondoConstantesFunciones.getTipoFondoDescripcion(parametrogeneralusuarioAux.getTipoFondo()));
			parametrogeneralusuarioAux.settipofondoborde_descripcion(TipoFondoConstantesFunciones.getTipoFondoDescripcion(parametrogeneralusuarioAux.getTipoFondoBorde()));
			parametrogeneralusuarioAux.settipofondocontrol_descripcion(TipoFondoControlConstantesFunciones.getTipoFondoControlDescripcion(parametrogeneralusuarioAux.getTipoFondoControl()));
			parametrogeneralusuarioAux.settipofuente_descripcion(TipoFuenteConstantesFunciones.getTipoFuenteDescripcion(parametrogeneralusuarioAux.getTipoFuente()));
			parametrogeneralusuarioAux.settipotamaniocontrolnormal_descripcion(TipoTamanioControlConstantesFunciones.getTipoTamanioControlDescripcion(parametrogeneralusuarioAux.getTipoTamanioControlNormal()));
			parametrogeneralusuarioAux.settipotamaniocontrolrelacion_descripcion(TipoTamanioControlConstantesFunciones.getTipoTamanioControlDescripcion(parametrogeneralusuarioAux.getTipoTamanioControlRelacion()));
			parametrogeneralusuarioAux.settipoexportar_descripcion(TipoExportarConstantesFunciones.getTipoExportarDescripcion(parametrogeneralusuarioAux.getTipoExportar()));
			parametrogeneralusuarioAux.settipodelimiter_descripcion(TipoDelimiterConstantesFunciones.getTipoDelimiterDescripcion(parametrogeneralusuarioAux.getTipoDelimiter()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfParametroGeneralUsuario(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Usuario.class));
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(Moneda.class));
				classes.add(new Classe(Anio.class));
				classes.add(new Classe(Mes.class));
				classes.add(new Classe(TipoVisual.class));
				classes.add(new Classe(TipoFondo.class));
				classes.add(new Classe(TipoFondo.class));
				classes.add(new Classe(TipoFondoControl.class));
				classes.add(new Classe(TipoFuente.class));
				classes.add(new Classe(TipoTamanioControl.class));
				classes.add(new Classe(TipoTamanioControl.class));
				classes.add(new Classe(TipoExportar.class));
				classes.add(new Classe(TipoDelimiter.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Usuario.class)) {
						classes.add(new Classe(Usuario.class));
					}
				}

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
					if(clas.clas.equals(Moneda.class)) {
						classes.add(new Classe(Moneda.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Anio.class)) {
						classes.add(new Classe(Anio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Mes.class)) {
						classes.add(new Classe(Mes.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoVisual.class)) {
						classes.add(new Classe(TipoVisual.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoFondo.class)) {
						classes.add(new Classe(TipoFondo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoFondo.class)) {
						classes.add(new Classe(TipoFondo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoFondoControl.class)) {
						classes.add(new Classe(TipoFondoControl.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoFuente.class)) {
						classes.add(new Classe(TipoFuente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoTamanioControl.class)) {
						classes.add(new Classe(TipoTamanioControl.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoTamanioControl.class)) {
						classes.add(new Classe(TipoTamanioControl.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoExportar.class)) {
						classes.add(new Classe(TipoExportar.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoDelimiter.class)) {
						classes.add(new Classe(TipoDelimiter.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfParametroGeneralUsuario(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
					}

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

					if(Moneda.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Moneda.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
					}

					if(TipoVisual.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoVisual.class)); continue;
					}

					if(TipoFondo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoFondo.class)); continue;
					}

					if(TipoFondo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoFondo.class)); continue;
					}

					if(TipoFondoControl.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoFondoControl.class)); continue;
					}

					if(TipoFuente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoFuente.class)); continue;
					}

					if(TipoTamanioControl.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoTamanioControl.class)); continue;
					}

					if(TipoTamanioControl.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoTamanioControl.class)); continue;
					}

					if(TipoExportar.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoExportar.class)); continue;
					}

					if(TipoDelimiter.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDelimiter.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
					}

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

					if(Moneda.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Moneda.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
					}

					if(TipoVisual.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoVisual.class)); continue;
					}

					if(TipoFondo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoFondo.class)); continue;
					}

					if(TipoFondo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoFondo.class)); continue;
					}

					if(TipoFondoControl.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoFondoControl.class)); continue;
					}

					if(TipoFuente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoFuente.class)); continue;
					}

					if(TipoTamanioControl.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoTamanioControl.class)); continue;
					}

					if(TipoTamanioControl.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoTamanioControl.class)); continue;
					}

					if(TipoExportar.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoExportar.class)); continue;
					}

					if(TipoDelimiter.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDelimiter.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroGeneralUsuario(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ParametroGeneralUsuarioConstantesFunciones.getClassesRelationshipsOfParametroGeneralUsuario(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroGeneralUsuario(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfParametroGeneralUsuario(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ParametroGeneralUsuarioConstantesFunciones.getClassesRelationshipsFromStringsOfParametroGeneralUsuario(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfParametroGeneralUsuario(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(ParametroGeneralUsuario parametrogeneralusuario,List<ParametroGeneralUsuario> parametrogeneralusuarios,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ParametroGeneralUsuario parametrogeneralusuarioEncontrado=null;
			
			for(ParametroGeneralUsuario parametrogeneralusuarioLocal:parametrogeneralusuarios) {
				if(parametrogeneralusuarioLocal.getId().equals(parametrogeneralusuario.getId())) {
					parametrogeneralusuarioEncontrado=parametrogeneralusuarioLocal;
					
					parametrogeneralusuarioLocal.setIsChanged(parametrogeneralusuario.getIsChanged());
					parametrogeneralusuarioLocal.setIsNew(parametrogeneralusuario.getIsNew());
					parametrogeneralusuarioLocal.setIsDeleted(parametrogeneralusuario.getIsDeleted());
					
					parametrogeneralusuarioLocal.setGeneralEntityOriginal(parametrogeneralusuario.getGeneralEntityOriginal());
					
					parametrogeneralusuarioLocal.setId(parametrogeneralusuario.getId());	
					parametrogeneralusuarioLocal.setVersionRow(parametrogeneralusuario.getVersionRow());	
					parametrogeneralusuarioLocal.setid_empresa(parametrogeneralusuario.getid_empresa());	
					parametrogeneralusuarioLocal.setid_sucursal(parametrogeneralusuario.getid_sucursal());	
					parametrogeneralusuarioLocal.setid_ejercicio(parametrogeneralusuario.getid_ejercicio());	
					parametrogeneralusuarioLocal.setid_periodo(parametrogeneralusuario.getid_periodo());	
					parametrogeneralusuarioLocal.setid_moneda(parametrogeneralusuario.getid_moneda());	
					parametrogeneralusuarioLocal.setfecha_sistema(parametrogeneralusuario.getfecha_sistema());	
					parametrogeneralusuarioLocal.setid_anio(parametrogeneralusuario.getid_anio());	
					parametrogeneralusuarioLocal.setid_mes(parametrogeneralusuario.getid_mes());	
					parametrogeneralusuarioLocal.setdia(parametrogeneralusuario.getdia());	
					parametrogeneralusuarioLocal.setid_tipo_visual(parametrogeneralusuario.getid_tipo_visual());	
					parametrogeneralusuarioLocal.setid_tipo_fondo(parametrogeneralusuario.getid_tipo_fondo());	
					parametrogeneralusuarioLocal.setid_tipo_fondo_borde(parametrogeneralusuario.getid_tipo_fondo_borde());	
					parametrogeneralusuarioLocal.setid_tipo_fondo_control(parametrogeneralusuario.getid_tipo_fondo_control());	
					parametrogeneralusuarioLocal.setid_tipo_fuente(parametrogeneralusuario.getid_tipo_fuente());	
					parametrogeneralusuarioLocal.setid_tipo_tamanio_control_normal(parametrogeneralusuario.getid_tipo_tamanio_control_normal());	
					parametrogeneralusuarioLocal.setid_tipo_tamanio_control_relacion(parametrogeneralusuario.getid_tipo_tamanio_control_relacion());	
					parametrogeneralusuarioLocal.setcon_tamanio_control_manual(parametrogeneralusuario.getcon_tamanio_control_manual());	
					parametrogeneralusuarioLocal.setcon_tamanio_control_todo_relacion(parametrogeneralusuario.getcon_tamanio_control_todo_relacion());	
					parametrogeneralusuarioLocal.setcon_guardar_relaciones(parametrogeneralusuario.getcon_guardar_relaciones());	
					parametrogeneralusuarioLocal.setcon_mensaje_confirmacion(parametrogeneralusuario.getcon_mensaje_confirmacion());	
					parametrogeneralusuarioLocal.setcon_botones_tool_bar(parametrogeneralusuario.getcon_botones_tool_bar());	
					parametrogeneralusuarioLocal.setcon_mostrar_acciones_campo_general(parametrogeneralusuario.getcon_mostrar_acciones_campo_general());	
					parametrogeneralusuarioLocal.setcon_mostrar_acciones_campo_relaciones(parametrogeneralusuario.getcon_mostrar_acciones_campo_relaciones());	
					parametrogeneralusuarioLocal.setid_tipo_exportar(parametrogeneralusuario.getid_tipo_exportar());	
					parametrogeneralusuarioLocal.setid_tipo_delimiter(parametrogeneralusuario.getid_tipo_delimiter());	
					parametrogeneralusuarioLocal.setcon_exportar_cabecera(parametrogeneralusuario.getcon_exportar_cabecera());	
					parametrogeneralusuarioLocal.setcon_exportar_campo_version(parametrogeneralusuario.getcon_exportar_campo_version());	
					parametrogeneralusuarioLocal.setpath_exportar(parametrogeneralusuario.getpath_exportar());	
					parametrogeneralusuarioLocal.setcon_precargar_ventanas(parametrogeneralusuario.getcon_precargar_ventanas());	
					parametrogeneralusuarioLocal.setcon_precargar_por_usuario(parametrogeneralusuario.getcon_precargar_por_usuario());	
					parametrogeneralusuarioLocal.setcon_cargar_por_parte(parametrogeneralusuario.getcon_cargar_por_parte());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!parametrogeneralusuario.getIsDeleted()) {
				if(!existe) {
					parametrogeneralusuarios.add(parametrogeneralusuario);
				}
			} else {
				if(parametrogeneralusuarioEncontrado!=null && permiteQuitar)  {
					parametrogeneralusuarios.remove(parametrogeneralusuarioEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ParametroGeneralUsuario parametrogeneralusuario,List<ParametroGeneralUsuario> parametrogeneralusuarios) throws Exception {
		try	{			
			for(ParametroGeneralUsuario parametrogeneralusuarioLocal:parametrogeneralusuarios) {
				if(parametrogeneralusuarioLocal.getId().equals(parametrogeneralusuario.getId())) {
					parametrogeneralusuarioLocal.setIsSelected(parametrogeneralusuario.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesParametroGeneralUsuario(List<ParametroGeneralUsuario> parametrogeneralusuariosAux) throws Exception {
		//this.parametrogeneralusuariosAux=parametrogeneralusuariosAux;
		
		for(ParametroGeneralUsuario parametrogeneralusuarioAux:parametrogeneralusuariosAux) {
			if(parametrogeneralusuarioAux.getIsChanged()) {
				parametrogeneralusuarioAux.setIsChanged(false);
			}		
			
			if(parametrogeneralusuarioAux.getIsNew()) {
				parametrogeneralusuarioAux.setIsNew(false);
			}	
			
			if(parametrogeneralusuarioAux.getIsDeleted()) {
				parametrogeneralusuarioAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesParametroGeneralUsuario(ParametroGeneralUsuario parametrogeneralusuarioAux) throws Exception {
		//this.parametrogeneralusuarioAux=parametrogeneralusuarioAux;
		
			if(parametrogeneralusuarioAux.getIsChanged()) {
				parametrogeneralusuarioAux.setIsChanged(false);
			}		
			
			if(parametrogeneralusuarioAux.getIsNew()) {
				parametrogeneralusuarioAux.setIsNew(false);
			}	
			
			if(parametrogeneralusuarioAux.getIsDeleted()) {
				parametrogeneralusuarioAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ParametroGeneralUsuario parametrogeneralusuarioAsignar,ParametroGeneralUsuario parametrogeneralusuario) throws Exception {
		parametrogeneralusuarioAsignar.setId(parametrogeneralusuario.getId());	
		parametrogeneralusuarioAsignar.setVersionRow(parametrogeneralusuario.getVersionRow());	
		parametrogeneralusuarioAsignar.setid_empresa(parametrogeneralusuario.getid_empresa());
		parametrogeneralusuarioAsignar.setempresa_descripcion(parametrogeneralusuario.getempresa_descripcion());	
		parametrogeneralusuarioAsignar.setid_sucursal(parametrogeneralusuario.getid_sucursal());
		parametrogeneralusuarioAsignar.setsucursal_descripcion(parametrogeneralusuario.getsucursal_descripcion());	
		parametrogeneralusuarioAsignar.setid_ejercicio(parametrogeneralusuario.getid_ejercicio());
		parametrogeneralusuarioAsignar.setejercicio_descripcion(parametrogeneralusuario.getejercicio_descripcion());	
		parametrogeneralusuarioAsignar.setid_periodo(parametrogeneralusuario.getid_periodo());
		parametrogeneralusuarioAsignar.setperiodo_descripcion(parametrogeneralusuario.getperiodo_descripcion());	
		parametrogeneralusuarioAsignar.setid_moneda(parametrogeneralusuario.getid_moneda());
		parametrogeneralusuarioAsignar.setmoneda_descripcion(parametrogeneralusuario.getmoneda_descripcion());	
		parametrogeneralusuarioAsignar.setfecha_sistema(parametrogeneralusuario.getfecha_sistema());	
		parametrogeneralusuarioAsignar.setid_anio(parametrogeneralusuario.getid_anio());
		parametrogeneralusuarioAsignar.setanio_descripcion(parametrogeneralusuario.getanio_descripcion());	
		parametrogeneralusuarioAsignar.setid_mes(parametrogeneralusuario.getid_mes());
		parametrogeneralusuarioAsignar.setmes_descripcion(parametrogeneralusuario.getmes_descripcion());	
		parametrogeneralusuarioAsignar.setdia(parametrogeneralusuario.getdia());	
		parametrogeneralusuarioAsignar.setid_tipo_visual(parametrogeneralusuario.getid_tipo_visual());
		parametrogeneralusuarioAsignar.settipovisual_descripcion(parametrogeneralusuario.gettipovisual_descripcion());	
		parametrogeneralusuarioAsignar.setid_tipo_fondo(parametrogeneralusuario.getid_tipo_fondo());
		parametrogeneralusuarioAsignar.settipofondo_descripcion(parametrogeneralusuario.gettipofondo_descripcion());	
		parametrogeneralusuarioAsignar.setid_tipo_fondo_borde(parametrogeneralusuario.getid_tipo_fondo_borde());
		parametrogeneralusuarioAsignar.settipofondoborde_descripcion(parametrogeneralusuario.gettipofondoborde_descripcion());	
		parametrogeneralusuarioAsignar.setid_tipo_fondo_control(parametrogeneralusuario.getid_tipo_fondo_control());
		parametrogeneralusuarioAsignar.settipofondocontrol_descripcion(parametrogeneralusuario.gettipofondocontrol_descripcion());	
		parametrogeneralusuarioAsignar.setid_tipo_fuente(parametrogeneralusuario.getid_tipo_fuente());
		parametrogeneralusuarioAsignar.settipofuente_descripcion(parametrogeneralusuario.gettipofuente_descripcion());	
		parametrogeneralusuarioAsignar.setid_tipo_tamanio_control_normal(parametrogeneralusuario.getid_tipo_tamanio_control_normal());
		parametrogeneralusuarioAsignar.settipotamaniocontrolnormal_descripcion(parametrogeneralusuario.gettipotamaniocontrolnormal_descripcion());	
		parametrogeneralusuarioAsignar.setid_tipo_tamanio_control_relacion(parametrogeneralusuario.getid_tipo_tamanio_control_relacion());
		parametrogeneralusuarioAsignar.settipotamaniocontrolrelacion_descripcion(parametrogeneralusuario.gettipotamaniocontrolrelacion_descripcion());	
		parametrogeneralusuarioAsignar.setcon_tamanio_control_manual(parametrogeneralusuario.getcon_tamanio_control_manual());	
		parametrogeneralusuarioAsignar.setcon_tamanio_control_todo_relacion(parametrogeneralusuario.getcon_tamanio_control_todo_relacion());	
		parametrogeneralusuarioAsignar.setcon_guardar_relaciones(parametrogeneralusuario.getcon_guardar_relaciones());	
		parametrogeneralusuarioAsignar.setcon_mensaje_confirmacion(parametrogeneralusuario.getcon_mensaje_confirmacion());	
		parametrogeneralusuarioAsignar.setcon_botones_tool_bar(parametrogeneralusuario.getcon_botones_tool_bar());	
		parametrogeneralusuarioAsignar.setcon_mostrar_acciones_campo_general(parametrogeneralusuario.getcon_mostrar_acciones_campo_general());	
		parametrogeneralusuarioAsignar.setcon_mostrar_acciones_campo_relaciones(parametrogeneralusuario.getcon_mostrar_acciones_campo_relaciones());	
		parametrogeneralusuarioAsignar.setid_tipo_exportar(parametrogeneralusuario.getid_tipo_exportar());
		parametrogeneralusuarioAsignar.settipoexportar_descripcion(parametrogeneralusuario.gettipoexportar_descripcion());	
		parametrogeneralusuarioAsignar.setid_tipo_delimiter(parametrogeneralusuario.getid_tipo_delimiter());
		parametrogeneralusuarioAsignar.settipodelimiter_descripcion(parametrogeneralusuario.gettipodelimiter_descripcion());	
		parametrogeneralusuarioAsignar.setcon_exportar_cabecera(parametrogeneralusuario.getcon_exportar_cabecera());	
		parametrogeneralusuarioAsignar.setcon_exportar_campo_version(parametrogeneralusuario.getcon_exportar_campo_version());	
		parametrogeneralusuarioAsignar.setpath_exportar(parametrogeneralusuario.getpath_exportar());	
		parametrogeneralusuarioAsignar.setcon_precargar_ventanas(parametrogeneralusuario.getcon_precargar_ventanas());	
		parametrogeneralusuarioAsignar.setcon_precargar_por_usuario(parametrogeneralusuario.getcon_precargar_por_usuario());	
		parametrogeneralusuarioAsignar.setcon_cargar_por_parte(parametrogeneralusuario.getcon_cargar_por_parte());	
	}
	
	public static void inicializarParametroGeneralUsuario(ParametroGeneralUsuario parametrogeneralusuario) throws Exception {
		try {
				parametrogeneralusuario.setId(-1L);	
					
				parametrogeneralusuario.setid_empresa(-1L);	
				parametrogeneralusuario.setid_sucursal(-1L);	
				parametrogeneralusuario.setid_ejercicio(-1L);	
				parametrogeneralusuario.setid_periodo(-1L);	
				parametrogeneralusuario.setid_moneda(-1L);	
				parametrogeneralusuario.setfecha_sistema(new Date());	
				parametrogeneralusuario.setid_anio(null);	
				parametrogeneralusuario.setid_mes(null);	
				parametrogeneralusuario.setdia(0);	
				parametrogeneralusuario.setid_tipo_visual(-1L);	
				parametrogeneralusuario.setid_tipo_fondo(-1L);	
				parametrogeneralusuario.setid_tipo_fondo_borde(-1L);	
				parametrogeneralusuario.setid_tipo_fondo_control(-1L);	
				parametrogeneralusuario.setid_tipo_fuente(-1L);	
				parametrogeneralusuario.setid_tipo_tamanio_control_normal(-1L);	
				parametrogeneralusuario.setid_tipo_tamanio_control_relacion(-1L);	
				parametrogeneralusuario.setcon_tamanio_control_manual(false);	
				parametrogeneralusuario.setcon_tamanio_control_todo_relacion(false);	
				parametrogeneralusuario.setcon_guardar_relaciones(false);	
				parametrogeneralusuario.setcon_mensaje_confirmacion(false);	
				parametrogeneralusuario.setcon_botones_tool_bar(false);	
				parametrogeneralusuario.setcon_mostrar_acciones_campo_general(false);	
				parametrogeneralusuario.setcon_mostrar_acciones_campo_relaciones(false);	
				parametrogeneralusuario.setid_tipo_exportar(-1L);	
				parametrogeneralusuario.setid_tipo_delimiter(-1L);	
				parametrogeneralusuario.setcon_exportar_cabecera(false);	
				parametrogeneralusuario.setcon_exportar_campo_version(false);	
				parametrogeneralusuario.setpath_exportar("");	
				parametrogeneralusuario.setcon_precargar_ventanas(false);	
				parametrogeneralusuario.setcon_precargar_por_usuario(false);	
				parametrogeneralusuario.setcon_cargar_por_parte(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderParametroGeneralUsuario(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGeneralUsuarioConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGeneralUsuarioConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGeneralUsuarioConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGeneralUsuarioConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGeneralUsuarioConstantesFunciones.LABEL_IDMONEDA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGeneralUsuarioConstantesFunciones.LABEL_FECHASISTEMA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGeneralUsuarioConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGeneralUsuarioConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGeneralUsuarioConstantesFunciones.LABEL_DIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGeneralUsuarioConstantesFunciones.LABEL_IDTIPOVISUAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGeneralUsuarioConstantesFunciones.LABEL_IDTIPOFONDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGeneralUsuarioConstantesFunciones.LABEL_IDTIPOFONDOBORDE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGeneralUsuarioConstantesFunciones.LABEL_IDTIPOFONDOCONTROL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGeneralUsuarioConstantesFunciones.LABEL_IDTIPOFUENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGeneralUsuarioConstantesFunciones.LABEL_IDTIPOTAMANIOCONTROLNORMAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGeneralUsuarioConstantesFunciones.LABEL_IDTIPOTAMANIOCONTROLRELACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGeneralUsuarioConstantesFunciones.LABEL_CONTAMANIOCONTROLMANUAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGeneralUsuarioConstantesFunciones.LABEL_CONTAMANIOCONTROLTODORELACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGeneralUsuarioConstantesFunciones.LABEL_CONGUARDARRELACIONES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGeneralUsuarioConstantesFunciones.LABEL_CONMENSAJECONFIRMACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGeneralUsuarioConstantesFunciones.LABEL_CONBOTONESTOOLBAR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGeneralUsuarioConstantesFunciones.LABEL_CONMOSTRARACCIONESCAMPOGENERAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGeneralUsuarioConstantesFunciones.LABEL_CONMOSTRARACCIONESCAMPORELACIONES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGeneralUsuarioConstantesFunciones.LABEL_IDTIPOEXPORTAR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGeneralUsuarioConstantesFunciones.LABEL_IDTIPODELIMITER);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGeneralUsuarioConstantesFunciones.LABEL_CONEXPORTARCABECERA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGeneralUsuarioConstantesFunciones.LABEL_CONEXPORTARCAMPOVERSION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGeneralUsuarioConstantesFunciones.LABEL_PATHEXPORTAR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGeneralUsuarioConstantesFunciones.LABEL_CONPRECARGARVENTANAS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGeneralUsuarioConstantesFunciones.LABEL_CONPRECARGARPORUSUARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGeneralUsuarioConstantesFunciones.LABEL_CONCARGARPORPARTE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataParametroGeneralUsuario(String sTipo,Row row,Workbook workbook,ParametroGeneralUsuario parametrogeneralusuario,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrogeneralusuario.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrogeneralusuario.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrogeneralusuario.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrogeneralusuario.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrogeneralusuario.getmoneda_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrogeneralusuario.getfecha_sistema());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrogeneralusuario.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrogeneralusuario.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrogeneralusuario.getdia());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrogeneralusuario.gettipovisual_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrogeneralusuario.gettipofondo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrogeneralusuario.gettipofondoborde_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrogeneralusuario.gettipofondocontrol_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrogeneralusuario.gettipofuente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrogeneralusuario.gettipotamaniocontrolnormal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrogeneralusuario.gettipotamaniocontrolrelacion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametrogeneralusuario.getcon_tamanio_control_manual()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametrogeneralusuario.getcon_tamanio_control_todo_relacion()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametrogeneralusuario.getcon_guardar_relaciones()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametrogeneralusuario.getcon_mensaje_confirmacion()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametrogeneralusuario.getcon_botones_tool_bar()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametrogeneralusuario.getcon_mostrar_acciones_campo_general()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametrogeneralusuario.getcon_mostrar_acciones_campo_relaciones()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrogeneralusuario.gettipoexportar_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrogeneralusuario.gettipodelimiter_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametrogeneralusuario.getcon_exportar_cabecera()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametrogeneralusuario.getcon_exportar_campo_version()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrogeneralusuario.getpath_exportar());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametrogeneralusuario.getcon_precargar_ventanas()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametrogeneralusuario.getcon_precargar_por_usuario()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametrogeneralusuario.getcon_cargar_por_parte()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryParametroGeneralUsuario=Constantes.SFINALQUERY;
	
	public String getsFinalQueryParametroGeneralUsuario() {
		return this.sFinalQueryParametroGeneralUsuario;
	}
	
	public void setsFinalQueryParametroGeneralUsuario(String sFinalQueryParametroGeneralUsuario) {
		this.sFinalQueryParametroGeneralUsuario= sFinalQueryParametroGeneralUsuario;
	}
	
	public Border resaltarSeleccionarParametroGeneralUsuario=null;
	
	public Border setResaltarSeleccionarParametroGeneralUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGeneralUsuarioBeanSwingJInternalFrame parametrogeneralusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//parametrogeneralusuarioBeanSwingJInternalFrame.jTtoolBarParametroGeneralUsuario.setBorder(borderResaltar);
		
		this.resaltarSeleccionarParametroGeneralUsuario= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarParametroGeneralUsuario() {
		return this.resaltarSeleccionarParametroGeneralUsuario;
	}
	
	public void setResaltarSeleccionarParametroGeneralUsuario(Border borderResaltarSeleccionarParametroGeneralUsuario) {
		this.resaltarSeleccionarParametroGeneralUsuario= borderResaltarSeleccionarParametroGeneralUsuario;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltarid_usuarioParametroGeneralUsuario=null;
	public Boolean mostrarid_usuarioParametroGeneralUsuario=true;
	public Boolean activarid_usuarioParametroGeneralUsuario=true;
	public Boolean cargarid_usuarioParametroGeneralUsuario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_usuarioParametroGeneralUsuario=false;//ConEventDepend=true

	public Border resaltarid_empresaParametroGeneralUsuario=null;
	public Boolean mostrarid_empresaParametroGeneralUsuario=true;
	public Boolean activarid_empresaParametroGeneralUsuario=true;
	public Boolean cargarid_empresaParametroGeneralUsuario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaParametroGeneralUsuario=false;//ConEventDepend=true

	public Border resaltarid_sucursalParametroGeneralUsuario=null;
	public Boolean mostrarid_sucursalParametroGeneralUsuario=true;
	public Boolean activarid_sucursalParametroGeneralUsuario=true;
	public Boolean cargarid_sucursalParametroGeneralUsuario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalParametroGeneralUsuario=true;//ConEventDepend=true

	public Border resaltarid_ejercicioParametroGeneralUsuario=null;
	public Boolean mostrarid_ejercicioParametroGeneralUsuario=true;
	public Boolean activarid_ejercicioParametroGeneralUsuario=true;
	public Boolean cargarid_ejercicioParametroGeneralUsuario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioParametroGeneralUsuario=true;//ConEventDepend=true

	public Border resaltarid_periodoParametroGeneralUsuario=null;
	public Boolean mostrarid_periodoParametroGeneralUsuario=true;
	public Boolean activarid_periodoParametroGeneralUsuario=true;
	public Boolean cargarid_periodoParametroGeneralUsuario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoParametroGeneralUsuario=true;//ConEventDepend=true

	public Border resaltarid_monedaParametroGeneralUsuario=null;
	public Boolean mostrarid_monedaParametroGeneralUsuario=true;
	public Boolean activarid_monedaParametroGeneralUsuario=true;
	public Boolean cargarid_monedaParametroGeneralUsuario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_monedaParametroGeneralUsuario=false;//ConEventDepend=true

	public Border resaltarfecha_sistemaParametroGeneralUsuario=null;
	public Boolean mostrarfecha_sistemaParametroGeneralUsuario=true;
	public Boolean activarfecha_sistemaParametroGeneralUsuario=true;

	public Border resaltarid_anioParametroGeneralUsuario=null;
	public Boolean mostrarid_anioParametroGeneralUsuario=true;
	public Boolean activarid_anioParametroGeneralUsuario=false;
	public Boolean cargarid_anioParametroGeneralUsuario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioParametroGeneralUsuario=false;//ConEventDepend=true

	public Border resaltarid_mesParametroGeneralUsuario=null;
	public Boolean mostrarid_mesParametroGeneralUsuario=true;
	public Boolean activarid_mesParametroGeneralUsuario=false;
	public Boolean cargarid_mesParametroGeneralUsuario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesParametroGeneralUsuario=false;//ConEventDepend=true

	public Border resaltardiaParametroGeneralUsuario=null;
	public Boolean mostrardiaParametroGeneralUsuario=true;
	public Boolean activardiaParametroGeneralUsuario=true;

	public Border resaltarid_tipo_visualParametroGeneralUsuario=null;
	public Boolean mostrarid_tipo_visualParametroGeneralUsuario=true;
	public Boolean activarid_tipo_visualParametroGeneralUsuario=true;
	public Boolean cargarid_tipo_visualParametroGeneralUsuario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_visualParametroGeneralUsuario=false;//ConEventDepend=true

	public Border resaltarid_tipo_fondoParametroGeneralUsuario=null;
	public Boolean mostrarid_tipo_fondoParametroGeneralUsuario=true;
	public Boolean activarid_tipo_fondoParametroGeneralUsuario=true;
	public Boolean cargarid_tipo_fondoParametroGeneralUsuario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_fondoParametroGeneralUsuario=false;//ConEventDepend=true

	public Border resaltarid_tipo_fondo_bordeParametroGeneralUsuario=null;
	public Boolean mostrarid_tipo_fondo_bordeParametroGeneralUsuario=true;
	public Boolean activarid_tipo_fondo_bordeParametroGeneralUsuario=true;
	public Boolean cargarid_tipo_fondo_bordeParametroGeneralUsuario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_fondo_bordeParametroGeneralUsuario=false;//ConEventDepend=true

	public Border resaltarid_tipo_fondo_controlParametroGeneralUsuario=null;
	public Boolean mostrarid_tipo_fondo_controlParametroGeneralUsuario=true;
	public Boolean activarid_tipo_fondo_controlParametroGeneralUsuario=true;
	public Boolean cargarid_tipo_fondo_controlParametroGeneralUsuario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_fondo_controlParametroGeneralUsuario=false;//ConEventDepend=true

	public Border resaltarid_tipo_fuenteParametroGeneralUsuario=null;
	public Boolean mostrarid_tipo_fuenteParametroGeneralUsuario=true;
	public Boolean activarid_tipo_fuenteParametroGeneralUsuario=true;
	public Boolean cargarid_tipo_fuenteParametroGeneralUsuario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_fuenteParametroGeneralUsuario=false;//ConEventDepend=true

	public Border resaltarid_tipo_tamanio_control_normalParametroGeneralUsuario=null;
	public Boolean mostrarid_tipo_tamanio_control_normalParametroGeneralUsuario=true;
	public Boolean activarid_tipo_tamanio_control_normalParametroGeneralUsuario=true;
	public Boolean cargarid_tipo_tamanio_control_normalParametroGeneralUsuario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_tamanio_control_normalParametroGeneralUsuario=false;//ConEventDepend=true

	public Border resaltarid_tipo_tamanio_control_relacionParametroGeneralUsuario=null;
	public Boolean mostrarid_tipo_tamanio_control_relacionParametroGeneralUsuario=true;
	public Boolean activarid_tipo_tamanio_control_relacionParametroGeneralUsuario=true;
	public Boolean cargarid_tipo_tamanio_control_relacionParametroGeneralUsuario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_tamanio_control_relacionParametroGeneralUsuario=false;//ConEventDepend=true

	public Border resaltarcon_tamanio_control_manualParametroGeneralUsuario=null;
	public Boolean mostrarcon_tamanio_control_manualParametroGeneralUsuario=true;
	public Boolean activarcon_tamanio_control_manualParametroGeneralUsuario=true;

	public Border resaltarcon_tamanio_control_todo_relacionParametroGeneralUsuario=null;
	public Boolean mostrarcon_tamanio_control_todo_relacionParametroGeneralUsuario=true;
	public Boolean activarcon_tamanio_control_todo_relacionParametroGeneralUsuario=true;

	public Border resaltarcon_guardar_relacionesParametroGeneralUsuario=null;
	public Boolean mostrarcon_guardar_relacionesParametroGeneralUsuario=true;
	public Boolean activarcon_guardar_relacionesParametroGeneralUsuario=true;

	public Border resaltarcon_mensaje_confirmacionParametroGeneralUsuario=null;
	public Boolean mostrarcon_mensaje_confirmacionParametroGeneralUsuario=true;
	public Boolean activarcon_mensaje_confirmacionParametroGeneralUsuario=true;

	public Border resaltarcon_botones_tool_barParametroGeneralUsuario=null;
	public Boolean mostrarcon_botones_tool_barParametroGeneralUsuario=true;
	public Boolean activarcon_botones_tool_barParametroGeneralUsuario=true;

	public Border resaltarcon_mostrar_acciones_campo_generalParametroGeneralUsuario=null;
	public Boolean mostrarcon_mostrar_acciones_campo_generalParametroGeneralUsuario=true;
	public Boolean activarcon_mostrar_acciones_campo_generalParametroGeneralUsuario=true;

	public Border resaltarcon_mostrar_acciones_campo_relacionesParametroGeneralUsuario=null;
	public Boolean mostrarcon_mostrar_acciones_campo_relacionesParametroGeneralUsuario=true;
	public Boolean activarcon_mostrar_acciones_campo_relacionesParametroGeneralUsuario=true;

	public Border resaltarid_tipo_exportarParametroGeneralUsuario=null;
	public Boolean mostrarid_tipo_exportarParametroGeneralUsuario=true;
	public Boolean activarid_tipo_exportarParametroGeneralUsuario=true;
	public Boolean cargarid_tipo_exportarParametroGeneralUsuario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_exportarParametroGeneralUsuario=false;//ConEventDepend=true

	public Border resaltarid_tipo_delimiterParametroGeneralUsuario=null;
	public Boolean mostrarid_tipo_delimiterParametroGeneralUsuario=true;
	public Boolean activarid_tipo_delimiterParametroGeneralUsuario=true;
	public Boolean cargarid_tipo_delimiterParametroGeneralUsuario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_delimiterParametroGeneralUsuario=false;//ConEventDepend=true

	public Border resaltarcon_exportar_cabeceraParametroGeneralUsuario=null;
	public Boolean mostrarcon_exportar_cabeceraParametroGeneralUsuario=true;
	public Boolean activarcon_exportar_cabeceraParametroGeneralUsuario=true;

	public Border resaltarcon_exportar_campo_versionParametroGeneralUsuario=null;
	public Boolean mostrarcon_exportar_campo_versionParametroGeneralUsuario=true;
	public Boolean activarcon_exportar_campo_versionParametroGeneralUsuario=true;

	public Border resaltarpath_exportarParametroGeneralUsuario=null;
	public Boolean mostrarpath_exportarParametroGeneralUsuario=true;
	public Boolean activarpath_exportarParametroGeneralUsuario=true;

	public Border resaltarcon_precargar_ventanasParametroGeneralUsuario=null;
	public Boolean mostrarcon_precargar_ventanasParametroGeneralUsuario=true;
	public Boolean activarcon_precargar_ventanasParametroGeneralUsuario=true;

	public Border resaltarcon_precargar_por_usuarioParametroGeneralUsuario=null;
	public Boolean mostrarcon_precargar_por_usuarioParametroGeneralUsuario=true;
	public Boolean activarcon_precargar_por_usuarioParametroGeneralUsuario=true;

	public Border resaltarcon_cargar_por_parteParametroGeneralUsuario=null;
	public Boolean mostrarcon_cargar_por_parteParametroGeneralUsuario=true;
	public Boolean activarcon_cargar_por_parteParametroGeneralUsuario=true;

	
	

	public Border setResaltarid_usuarioParametroGeneralUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGeneralUsuarioBeanSwingJInternalFrame parametrogeneralusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrogeneralusuarioBeanSwingJInternalFrame.jTtoolBarParametroGeneralUsuario.setBorder(borderResaltar);
		
		this.resaltarid_usuarioParametroGeneralUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_usuarioParametroGeneralUsuario() {
		return this.resaltarid_usuarioParametroGeneralUsuario;
	}

	public void setResaltarid_usuarioParametroGeneralUsuario(Border borderResaltar) {
		this.resaltarid_usuarioParametroGeneralUsuario= borderResaltar;
	}

	public Boolean getMostrarid_usuarioParametroGeneralUsuario() {
		return this.mostrarid_usuarioParametroGeneralUsuario;
	}

	public void setMostrarid_usuarioParametroGeneralUsuario(Boolean mostrarid_usuarioParametroGeneralUsuario) {
		this.mostrarid_usuarioParametroGeneralUsuario= mostrarid_usuarioParametroGeneralUsuario;
	}

	public Boolean getActivarid_usuarioParametroGeneralUsuario() {
		return this.activarid_usuarioParametroGeneralUsuario;
	}

	public void setActivarid_usuarioParametroGeneralUsuario(Boolean activarid_usuarioParametroGeneralUsuario) {
		this.activarid_usuarioParametroGeneralUsuario= activarid_usuarioParametroGeneralUsuario;
	}

	public Boolean getCargarid_usuarioParametroGeneralUsuario() {
		return this.cargarid_usuarioParametroGeneralUsuario;
	}

	public void setCargarid_usuarioParametroGeneralUsuario(Boolean cargarid_usuarioParametroGeneralUsuario) {
		this.cargarid_usuarioParametroGeneralUsuario= cargarid_usuarioParametroGeneralUsuario;
	}

	public Border setResaltarid_empresaParametroGeneralUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGeneralUsuarioBeanSwingJInternalFrame parametrogeneralusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrogeneralusuarioBeanSwingJInternalFrame.jTtoolBarParametroGeneralUsuario.setBorder(borderResaltar);
		
		this.resaltarid_empresaParametroGeneralUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaParametroGeneralUsuario() {
		return this.resaltarid_empresaParametroGeneralUsuario;
	}

	public void setResaltarid_empresaParametroGeneralUsuario(Border borderResaltar) {
		this.resaltarid_empresaParametroGeneralUsuario= borderResaltar;
	}

	public Boolean getMostrarid_empresaParametroGeneralUsuario() {
		return this.mostrarid_empresaParametroGeneralUsuario;
	}

	public void setMostrarid_empresaParametroGeneralUsuario(Boolean mostrarid_empresaParametroGeneralUsuario) {
		this.mostrarid_empresaParametroGeneralUsuario= mostrarid_empresaParametroGeneralUsuario;
	}

	public Boolean getActivarid_empresaParametroGeneralUsuario() {
		return this.activarid_empresaParametroGeneralUsuario;
	}

	public void setActivarid_empresaParametroGeneralUsuario(Boolean activarid_empresaParametroGeneralUsuario) {
		this.activarid_empresaParametroGeneralUsuario= activarid_empresaParametroGeneralUsuario;
	}

	public Boolean getCargarid_empresaParametroGeneralUsuario() {
		return this.cargarid_empresaParametroGeneralUsuario;
	}

	public void setCargarid_empresaParametroGeneralUsuario(Boolean cargarid_empresaParametroGeneralUsuario) {
		this.cargarid_empresaParametroGeneralUsuario= cargarid_empresaParametroGeneralUsuario;
	}

	public Border setResaltarid_sucursalParametroGeneralUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGeneralUsuarioBeanSwingJInternalFrame parametrogeneralusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrogeneralusuarioBeanSwingJInternalFrame.jTtoolBarParametroGeneralUsuario.setBorder(borderResaltar);
		
		this.resaltarid_sucursalParametroGeneralUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalParametroGeneralUsuario() {
		return this.resaltarid_sucursalParametroGeneralUsuario;
	}

	public void setResaltarid_sucursalParametroGeneralUsuario(Border borderResaltar) {
		this.resaltarid_sucursalParametroGeneralUsuario= borderResaltar;
	}

	public Boolean getMostrarid_sucursalParametroGeneralUsuario() {
		return this.mostrarid_sucursalParametroGeneralUsuario;
	}

	public void setMostrarid_sucursalParametroGeneralUsuario(Boolean mostrarid_sucursalParametroGeneralUsuario) {
		this.mostrarid_sucursalParametroGeneralUsuario= mostrarid_sucursalParametroGeneralUsuario;
	}

	public Boolean getActivarid_sucursalParametroGeneralUsuario() {
		return this.activarid_sucursalParametroGeneralUsuario;
	}

	public void setActivarid_sucursalParametroGeneralUsuario(Boolean activarid_sucursalParametroGeneralUsuario) {
		this.activarid_sucursalParametroGeneralUsuario= activarid_sucursalParametroGeneralUsuario;
	}

	public Boolean getCargarid_sucursalParametroGeneralUsuario() {
		return this.cargarid_sucursalParametroGeneralUsuario;
	}

	public void setCargarid_sucursalParametroGeneralUsuario(Boolean cargarid_sucursalParametroGeneralUsuario) {
		this.cargarid_sucursalParametroGeneralUsuario= cargarid_sucursalParametroGeneralUsuario;
	}

	public Border setResaltarid_ejercicioParametroGeneralUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGeneralUsuarioBeanSwingJInternalFrame parametrogeneralusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrogeneralusuarioBeanSwingJInternalFrame.jTtoolBarParametroGeneralUsuario.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioParametroGeneralUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioParametroGeneralUsuario() {
		return this.resaltarid_ejercicioParametroGeneralUsuario;
	}

	public void setResaltarid_ejercicioParametroGeneralUsuario(Border borderResaltar) {
		this.resaltarid_ejercicioParametroGeneralUsuario= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioParametroGeneralUsuario() {
		return this.mostrarid_ejercicioParametroGeneralUsuario;
	}

	public void setMostrarid_ejercicioParametroGeneralUsuario(Boolean mostrarid_ejercicioParametroGeneralUsuario) {
		this.mostrarid_ejercicioParametroGeneralUsuario= mostrarid_ejercicioParametroGeneralUsuario;
	}

	public Boolean getActivarid_ejercicioParametroGeneralUsuario() {
		return this.activarid_ejercicioParametroGeneralUsuario;
	}

	public void setActivarid_ejercicioParametroGeneralUsuario(Boolean activarid_ejercicioParametroGeneralUsuario) {
		this.activarid_ejercicioParametroGeneralUsuario= activarid_ejercicioParametroGeneralUsuario;
	}

	public Boolean getCargarid_ejercicioParametroGeneralUsuario() {
		return this.cargarid_ejercicioParametroGeneralUsuario;
	}

	public void setCargarid_ejercicioParametroGeneralUsuario(Boolean cargarid_ejercicioParametroGeneralUsuario) {
		this.cargarid_ejercicioParametroGeneralUsuario= cargarid_ejercicioParametroGeneralUsuario;
	}

	public Border setResaltarid_periodoParametroGeneralUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGeneralUsuarioBeanSwingJInternalFrame parametrogeneralusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrogeneralusuarioBeanSwingJInternalFrame.jTtoolBarParametroGeneralUsuario.setBorder(borderResaltar);
		
		this.resaltarid_periodoParametroGeneralUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoParametroGeneralUsuario() {
		return this.resaltarid_periodoParametroGeneralUsuario;
	}

	public void setResaltarid_periodoParametroGeneralUsuario(Border borderResaltar) {
		this.resaltarid_periodoParametroGeneralUsuario= borderResaltar;
	}

	public Boolean getMostrarid_periodoParametroGeneralUsuario() {
		return this.mostrarid_periodoParametroGeneralUsuario;
	}

	public void setMostrarid_periodoParametroGeneralUsuario(Boolean mostrarid_periodoParametroGeneralUsuario) {
		this.mostrarid_periodoParametroGeneralUsuario= mostrarid_periodoParametroGeneralUsuario;
	}

	public Boolean getActivarid_periodoParametroGeneralUsuario() {
		return this.activarid_periodoParametroGeneralUsuario;
	}

	public void setActivarid_periodoParametroGeneralUsuario(Boolean activarid_periodoParametroGeneralUsuario) {
		this.activarid_periodoParametroGeneralUsuario= activarid_periodoParametroGeneralUsuario;
	}

	public Boolean getCargarid_periodoParametroGeneralUsuario() {
		return this.cargarid_periodoParametroGeneralUsuario;
	}

	public void setCargarid_periodoParametroGeneralUsuario(Boolean cargarid_periodoParametroGeneralUsuario) {
		this.cargarid_periodoParametroGeneralUsuario= cargarid_periodoParametroGeneralUsuario;
	}

	public Border setResaltarid_monedaParametroGeneralUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGeneralUsuarioBeanSwingJInternalFrame parametrogeneralusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrogeneralusuarioBeanSwingJInternalFrame.jTtoolBarParametroGeneralUsuario.setBorder(borderResaltar);
		
		this.resaltarid_monedaParametroGeneralUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_monedaParametroGeneralUsuario() {
		return this.resaltarid_monedaParametroGeneralUsuario;
	}

	public void setResaltarid_monedaParametroGeneralUsuario(Border borderResaltar) {
		this.resaltarid_monedaParametroGeneralUsuario= borderResaltar;
	}

	public Boolean getMostrarid_monedaParametroGeneralUsuario() {
		return this.mostrarid_monedaParametroGeneralUsuario;
	}

	public void setMostrarid_monedaParametroGeneralUsuario(Boolean mostrarid_monedaParametroGeneralUsuario) {
		this.mostrarid_monedaParametroGeneralUsuario= mostrarid_monedaParametroGeneralUsuario;
	}

	public Boolean getActivarid_monedaParametroGeneralUsuario() {
		return this.activarid_monedaParametroGeneralUsuario;
	}

	public void setActivarid_monedaParametroGeneralUsuario(Boolean activarid_monedaParametroGeneralUsuario) {
		this.activarid_monedaParametroGeneralUsuario= activarid_monedaParametroGeneralUsuario;
	}

	public Boolean getCargarid_monedaParametroGeneralUsuario() {
		return this.cargarid_monedaParametroGeneralUsuario;
	}

	public void setCargarid_monedaParametroGeneralUsuario(Boolean cargarid_monedaParametroGeneralUsuario) {
		this.cargarid_monedaParametroGeneralUsuario= cargarid_monedaParametroGeneralUsuario;
	}

	public Border setResaltarfecha_sistemaParametroGeneralUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGeneralUsuarioBeanSwingJInternalFrame parametrogeneralusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrogeneralusuarioBeanSwingJInternalFrame.jTtoolBarParametroGeneralUsuario.setBorder(borderResaltar);
		
		this.resaltarfecha_sistemaParametroGeneralUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_sistemaParametroGeneralUsuario() {
		return this.resaltarfecha_sistemaParametroGeneralUsuario;
	}

	public void setResaltarfecha_sistemaParametroGeneralUsuario(Border borderResaltar) {
		this.resaltarfecha_sistemaParametroGeneralUsuario= borderResaltar;
	}

	public Boolean getMostrarfecha_sistemaParametroGeneralUsuario() {
		return this.mostrarfecha_sistemaParametroGeneralUsuario;
	}

	public void setMostrarfecha_sistemaParametroGeneralUsuario(Boolean mostrarfecha_sistemaParametroGeneralUsuario) {
		this.mostrarfecha_sistemaParametroGeneralUsuario= mostrarfecha_sistemaParametroGeneralUsuario;
	}

	public Boolean getActivarfecha_sistemaParametroGeneralUsuario() {
		return this.activarfecha_sistemaParametroGeneralUsuario;
	}

	public void setActivarfecha_sistemaParametroGeneralUsuario(Boolean activarfecha_sistemaParametroGeneralUsuario) {
		this.activarfecha_sistemaParametroGeneralUsuario= activarfecha_sistemaParametroGeneralUsuario;
	}

	public Border setResaltarid_anioParametroGeneralUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGeneralUsuarioBeanSwingJInternalFrame parametrogeneralusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrogeneralusuarioBeanSwingJInternalFrame.jTtoolBarParametroGeneralUsuario.setBorder(borderResaltar);
		
		this.resaltarid_anioParametroGeneralUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioParametroGeneralUsuario() {
		return this.resaltarid_anioParametroGeneralUsuario;
	}

	public void setResaltarid_anioParametroGeneralUsuario(Border borderResaltar) {
		this.resaltarid_anioParametroGeneralUsuario= borderResaltar;
	}

	public Boolean getMostrarid_anioParametroGeneralUsuario() {
		return this.mostrarid_anioParametroGeneralUsuario;
	}

	public void setMostrarid_anioParametroGeneralUsuario(Boolean mostrarid_anioParametroGeneralUsuario) {
		this.mostrarid_anioParametroGeneralUsuario= mostrarid_anioParametroGeneralUsuario;
	}

	public Boolean getActivarid_anioParametroGeneralUsuario() {
		return this.activarid_anioParametroGeneralUsuario;
	}

	public void setActivarid_anioParametroGeneralUsuario(Boolean activarid_anioParametroGeneralUsuario) {
		this.activarid_anioParametroGeneralUsuario= activarid_anioParametroGeneralUsuario;
	}

	public Boolean getCargarid_anioParametroGeneralUsuario() {
		return this.cargarid_anioParametroGeneralUsuario;
	}

	public void setCargarid_anioParametroGeneralUsuario(Boolean cargarid_anioParametroGeneralUsuario) {
		this.cargarid_anioParametroGeneralUsuario= cargarid_anioParametroGeneralUsuario;
	}

	public Border setResaltarid_mesParametroGeneralUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGeneralUsuarioBeanSwingJInternalFrame parametrogeneralusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrogeneralusuarioBeanSwingJInternalFrame.jTtoolBarParametroGeneralUsuario.setBorder(borderResaltar);
		
		this.resaltarid_mesParametroGeneralUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesParametroGeneralUsuario() {
		return this.resaltarid_mesParametroGeneralUsuario;
	}

	public void setResaltarid_mesParametroGeneralUsuario(Border borderResaltar) {
		this.resaltarid_mesParametroGeneralUsuario= borderResaltar;
	}

	public Boolean getMostrarid_mesParametroGeneralUsuario() {
		return this.mostrarid_mesParametroGeneralUsuario;
	}

	public void setMostrarid_mesParametroGeneralUsuario(Boolean mostrarid_mesParametroGeneralUsuario) {
		this.mostrarid_mesParametroGeneralUsuario= mostrarid_mesParametroGeneralUsuario;
	}

	public Boolean getActivarid_mesParametroGeneralUsuario() {
		return this.activarid_mesParametroGeneralUsuario;
	}

	public void setActivarid_mesParametroGeneralUsuario(Boolean activarid_mesParametroGeneralUsuario) {
		this.activarid_mesParametroGeneralUsuario= activarid_mesParametroGeneralUsuario;
	}

	public Boolean getCargarid_mesParametroGeneralUsuario() {
		return this.cargarid_mesParametroGeneralUsuario;
	}

	public void setCargarid_mesParametroGeneralUsuario(Boolean cargarid_mesParametroGeneralUsuario) {
		this.cargarid_mesParametroGeneralUsuario= cargarid_mesParametroGeneralUsuario;
	}

	public Border setResaltardiaParametroGeneralUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGeneralUsuarioBeanSwingJInternalFrame parametrogeneralusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrogeneralusuarioBeanSwingJInternalFrame.jTtoolBarParametroGeneralUsuario.setBorder(borderResaltar);
		
		this.resaltardiaParametroGeneralUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardiaParametroGeneralUsuario() {
		return this.resaltardiaParametroGeneralUsuario;
	}

	public void setResaltardiaParametroGeneralUsuario(Border borderResaltar) {
		this.resaltardiaParametroGeneralUsuario= borderResaltar;
	}

	public Boolean getMostrardiaParametroGeneralUsuario() {
		return this.mostrardiaParametroGeneralUsuario;
	}

	public void setMostrardiaParametroGeneralUsuario(Boolean mostrardiaParametroGeneralUsuario) {
		this.mostrardiaParametroGeneralUsuario= mostrardiaParametroGeneralUsuario;
	}

	public Boolean getActivardiaParametroGeneralUsuario() {
		return this.activardiaParametroGeneralUsuario;
	}

	public void setActivardiaParametroGeneralUsuario(Boolean activardiaParametroGeneralUsuario) {
		this.activardiaParametroGeneralUsuario= activardiaParametroGeneralUsuario;
	}

	public Border setResaltarid_tipo_visualParametroGeneralUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGeneralUsuarioBeanSwingJInternalFrame parametrogeneralusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrogeneralusuarioBeanSwingJInternalFrame.jTtoolBarParametroGeneralUsuario.setBorder(borderResaltar);
		
		this.resaltarid_tipo_visualParametroGeneralUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_visualParametroGeneralUsuario() {
		return this.resaltarid_tipo_visualParametroGeneralUsuario;
	}

	public void setResaltarid_tipo_visualParametroGeneralUsuario(Border borderResaltar) {
		this.resaltarid_tipo_visualParametroGeneralUsuario= borderResaltar;
	}

	public Boolean getMostrarid_tipo_visualParametroGeneralUsuario() {
		return this.mostrarid_tipo_visualParametroGeneralUsuario;
	}

	public void setMostrarid_tipo_visualParametroGeneralUsuario(Boolean mostrarid_tipo_visualParametroGeneralUsuario) {
		this.mostrarid_tipo_visualParametroGeneralUsuario= mostrarid_tipo_visualParametroGeneralUsuario;
	}

	public Boolean getActivarid_tipo_visualParametroGeneralUsuario() {
		return this.activarid_tipo_visualParametroGeneralUsuario;
	}

	public void setActivarid_tipo_visualParametroGeneralUsuario(Boolean activarid_tipo_visualParametroGeneralUsuario) {
		this.activarid_tipo_visualParametroGeneralUsuario= activarid_tipo_visualParametroGeneralUsuario;
	}

	public Boolean getCargarid_tipo_visualParametroGeneralUsuario() {
		return this.cargarid_tipo_visualParametroGeneralUsuario;
	}

	public void setCargarid_tipo_visualParametroGeneralUsuario(Boolean cargarid_tipo_visualParametroGeneralUsuario) {
		this.cargarid_tipo_visualParametroGeneralUsuario= cargarid_tipo_visualParametroGeneralUsuario;
	}

	public Border setResaltarid_tipo_fondoParametroGeneralUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGeneralUsuarioBeanSwingJInternalFrame parametrogeneralusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrogeneralusuarioBeanSwingJInternalFrame.jTtoolBarParametroGeneralUsuario.setBorder(borderResaltar);
		
		this.resaltarid_tipo_fondoParametroGeneralUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_fondoParametroGeneralUsuario() {
		return this.resaltarid_tipo_fondoParametroGeneralUsuario;
	}

	public void setResaltarid_tipo_fondoParametroGeneralUsuario(Border borderResaltar) {
		this.resaltarid_tipo_fondoParametroGeneralUsuario= borderResaltar;
	}

	public Boolean getMostrarid_tipo_fondoParametroGeneralUsuario() {
		return this.mostrarid_tipo_fondoParametroGeneralUsuario;
	}

	public void setMostrarid_tipo_fondoParametroGeneralUsuario(Boolean mostrarid_tipo_fondoParametroGeneralUsuario) {
		this.mostrarid_tipo_fondoParametroGeneralUsuario= mostrarid_tipo_fondoParametroGeneralUsuario;
	}

	public Boolean getActivarid_tipo_fondoParametroGeneralUsuario() {
		return this.activarid_tipo_fondoParametroGeneralUsuario;
	}

	public void setActivarid_tipo_fondoParametroGeneralUsuario(Boolean activarid_tipo_fondoParametroGeneralUsuario) {
		this.activarid_tipo_fondoParametroGeneralUsuario= activarid_tipo_fondoParametroGeneralUsuario;
	}

	public Boolean getCargarid_tipo_fondoParametroGeneralUsuario() {
		return this.cargarid_tipo_fondoParametroGeneralUsuario;
	}

	public void setCargarid_tipo_fondoParametroGeneralUsuario(Boolean cargarid_tipo_fondoParametroGeneralUsuario) {
		this.cargarid_tipo_fondoParametroGeneralUsuario= cargarid_tipo_fondoParametroGeneralUsuario;
	}

	public Border setResaltarid_tipo_fondo_bordeParametroGeneralUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGeneralUsuarioBeanSwingJInternalFrame parametrogeneralusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrogeneralusuarioBeanSwingJInternalFrame.jTtoolBarParametroGeneralUsuario.setBorder(borderResaltar);
		
		this.resaltarid_tipo_fondo_bordeParametroGeneralUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_fondo_bordeParametroGeneralUsuario() {
		return this.resaltarid_tipo_fondo_bordeParametroGeneralUsuario;
	}

	public void setResaltarid_tipo_fondo_bordeParametroGeneralUsuario(Border borderResaltar) {
		this.resaltarid_tipo_fondo_bordeParametroGeneralUsuario= borderResaltar;
	}

	public Boolean getMostrarid_tipo_fondo_bordeParametroGeneralUsuario() {
		return this.mostrarid_tipo_fondo_bordeParametroGeneralUsuario;
	}

	public void setMostrarid_tipo_fondo_bordeParametroGeneralUsuario(Boolean mostrarid_tipo_fondo_bordeParametroGeneralUsuario) {
		this.mostrarid_tipo_fondo_bordeParametroGeneralUsuario= mostrarid_tipo_fondo_bordeParametroGeneralUsuario;
	}

	public Boolean getActivarid_tipo_fondo_bordeParametroGeneralUsuario() {
		return this.activarid_tipo_fondo_bordeParametroGeneralUsuario;
	}

	public void setActivarid_tipo_fondo_bordeParametroGeneralUsuario(Boolean activarid_tipo_fondo_bordeParametroGeneralUsuario) {
		this.activarid_tipo_fondo_bordeParametroGeneralUsuario= activarid_tipo_fondo_bordeParametroGeneralUsuario;
	}

	public Boolean getCargarid_tipo_fondo_bordeParametroGeneralUsuario() {
		return this.cargarid_tipo_fondo_bordeParametroGeneralUsuario;
	}

	public void setCargarid_tipo_fondo_bordeParametroGeneralUsuario(Boolean cargarid_tipo_fondo_bordeParametroGeneralUsuario) {
		this.cargarid_tipo_fondo_bordeParametroGeneralUsuario= cargarid_tipo_fondo_bordeParametroGeneralUsuario;
	}

	public Border setResaltarid_tipo_fondo_controlParametroGeneralUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGeneralUsuarioBeanSwingJInternalFrame parametrogeneralusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrogeneralusuarioBeanSwingJInternalFrame.jTtoolBarParametroGeneralUsuario.setBorder(borderResaltar);
		
		this.resaltarid_tipo_fondo_controlParametroGeneralUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_fondo_controlParametroGeneralUsuario() {
		return this.resaltarid_tipo_fondo_controlParametroGeneralUsuario;
	}

	public void setResaltarid_tipo_fondo_controlParametroGeneralUsuario(Border borderResaltar) {
		this.resaltarid_tipo_fondo_controlParametroGeneralUsuario= borderResaltar;
	}

	public Boolean getMostrarid_tipo_fondo_controlParametroGeneralUsuario() {
		return this.mostrarid_tipo_fondo_controlParametroGeneralUsuario;
	}

	public void setMostrarid_tipo_fondo_controlParametroGeneralUsuario(Boolean mostrarid_tipo_fondo_controlParametroGeneralUsuario) {
		this.mostrarid_tipo_fondo_controlParametroGeneralUsuario= mostrarid_tipo_fondo_controlParametroGeneralUsuario;
	}

	public Boolean getActivarid_tipo_fondo_controlParametroGeneralUsuario() {
		return this.activarid_tipo_fondo_controlParametroGeneralUsuario;
	}

	public void setActivarid_tipo_fondo_controlParametroGeneralUsuario(Boolean activarid_tipo_fondo_controlParametroGeneralUsuario) {
		this.activarid_tipo_fondo_controlParametroGeneralUsuario= activarid_tipo_fondo_controlParametroGeneralUsuario;
	}

	public Boolean getCargarid_tipo_fondo_controlParametroGeneralUsuario() {
		return this.cargarid_tipo_fondo_controlParametroGeneralUsuario;
	}

	public void setCargarid_tipo_fondo_controlParametroGeneralUsuario(Boolean cargarid_tipo_fondo_controlParametroGeneralUsuario) {
		this.cargarid_tipo_fondo_controlParametroGeneralUsuario= cargarid_tipo_fondo_controlParametroGeneralUsuario;
	}

	public Border setResaltarid_tipo_fuenteParametroGeneralUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGeneralUsuarioBeanSwingJInternalFrame parametrogeneralusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrogeneralusuarioBeanSwingJInternalFrame.jTtoolBarParametroGeneralUsuario.setBorder(borderResaltar);
		
		this.resaltarid_tipo_fuenteParametroGeneralUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_fuenteParametroGeneralUsuario() {
		return this.resaltarid_tipo_fuenteParametroGeneralUsuario;
	}

	public void setResaltarid_tipo_fuenteParametroGeneralUsuario(Border borderResaltar) {
		this.resaltarid_tipo_fuenteParametroGeneralUsuario= borderResaltar;
	}

	public Boolean getMostrarid_tipo_fuenteParametroGeneralUsuario() {
		return this.mostrarid_tipo_fuenteParametroGeneralUsuario;
	}

	public void setMostrarid_tipo_fuenteParametroGeneralUsuario(Boolean mostrarid_tipo_fuenteParametroGeneralUsuario) {
		this.mostrarid_tipo_fuenteParametroGeneralUsuario= mostrarid_tipo_fuenteParametroGeneralUsuario;
	}

	public Boolean getActivarid_tipo_fuenteParametroGeneralUsuario() {
		return this.activarid_tipo_fuenteParametroGeneralUsuario;
	}

	public void setActivarid_tipo_fuenteParametroGeneralUsuario(Boolean activarid_tipo_fuenteParametroGeneralUsuario) {
		this.activarid_tipo_fuenteParametroGeneralUsuario= activarid_tipo_fuenteParametroGeneralUsuario;
	}

	public Boolean getCargarid_tipo_fuenteParametroGeneralUsuario() {
		return this.cargarid_tipo_fuenteParametroGeneralUsuario;
	}

	public void setCargarid_tipo_fuenteParametroGeneralUsuario(Boolean cargarid_tipo_fuenteParametroGeneralUsuario) {
		this.cargarid_tipo_fuenteParametroGeneralUsuario= cargarid_tipo_fuenteParametroGeneralUsuario;
	}

	public Border setResaltarid_tipo_tamanio_control_normalParametroGeneralUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGeneralUsuarioBeanSwingJInternalFrame parametrogeneralusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrogeneralusuarioBeanSwingJInternalFrame.jTtoolBarParametroGeneralUsuario.setBorder(borderResaltar);
		
		this.resaltarid_tipo_tamanio_control_normalParametroGeneralUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_tamanio_control_normalParametroGeneralUsuario() {
		return this.resaltarid_tipo_tamanio_control_normalParametroGeneralUsuario;
	}

	public void setResaltarid_tipo_tamanio_control_normalParametroGeneralUsuario(Border borderResaltar) {
		this.resaltarid_tipo_tamanio_control_normalParametroGeneralUsuario= borderResaltar;
	}

	public Boolean getMostrarid_tipo_tamanio_control_normalParametroGeneralUsuario() {
		return this.mostrarid_tipo_tamanio_control_normalParametroGeneralUsuario;
	}

	public void setMostrarid_tipo_tamanio_control_normalParametroGeneralUsuario(Boolean mostrarid_tipo_tamanio_control_normalParametroGeneralUsuario) {
		this.mostrarid_tipo_tamanio_control_normalParametroGeneralUsuario= mostrarid_tipo_tamanio_control_normalParametroGeneralUsuario;
	}

	public Boolean getActivarid_tipo_tamanio_control_normalParametroGeneralUsuario() {
		return this.activarid_tipo_tamanio_control_normalParametroGeneralUsuario;
	}

	public void setActivarid_tipo_tamanio_control_normalParametroGeneralUsuario(Boolean activarid_tipo_tamanio_control_normalParametroGeneralUsuario) {
		this.activarid_tipo_tamanio_control_normalParametroGeneralUsuario= activarid_tipo_tamanio_control_normalParametroGeneralUsuario;
	}

	public Boolean getCargarid_tipo_tamanio_control_normalParametroGeneralUsuario() {
		return this.cargarid_tipo_tamanio_control_normalParametroGeneralUsuario;
	}

	public void setCargarid_tipo_tamanio_control_normalParametroGeneralUsuario(Boolean cargarid_tipo_tamanio_control_normalParametroGeneralUsuario) {
		this.cargarid_tipo_tamanio_control_normalParametroGeneralUsuario= cargarid_tipo_tamanio_control_normalParametroGeneralUsuario;
	}

	public Border setResaltarid_tipo_tamanio_control_relacionParametroGeneralUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGeneralUsuarioBeanSwingJInternalFrame parametrogeneralusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrogeneralusuarioBeanSwingJInternalFrame.jTtoolBarParametroGeneralUsuario.setBorder(borderResaltar);
		
		this.resaltarid_tipo_tamanio_control_relacionParametroGeneralUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_tamanio_control_relacionParametroGeneralUsuario() {
		return this.resaltarid_tipo_tamanio_control_relacionParametroGeneralUsuario;
	}

	public void setResaltarid_tipo_tamanio_control_relacionParametroGeneralUsuario(Border borderResaltar) {
		this.resaltarid_tipo_tamanio_control_relacionParametroGeneralUsuario= borderResaltar;
	}

	public Boolean getMostrarid_tipo_tamanio_control_relacionParametroGeneralUsuario() {
		return this.mostrarid_tipo_tamanio_control_relacionParametroGeneralUsuario;
	}

	public void setMostrarid_tipo_tamanio_control_relacionParametroGeneralUsuario(Boolean mostrarid_tipo_tamanio_control_relacionParametroGeneralUsuario) {
		this.mostrarid_tipo_tamanio_control_relacionParametroGeneralUsuario= mostrarid_tipo_tamanio_control_relacionParametroGeneralUsuario;
	}

	public Boolean getActivarid_tipo_tamanio_control_relacionParametroGeneralUsuario() {
		return this.activarid_tipo_tamanio_control_relacionParametroGeneralUsuario;
	}

	public void setActivarid_tipo_tamanio_control_relacionParametroGeneralUsuario(Boolean activarid_tipo_tamanio_control_relacionParametroGeneralUsuario) {
		this.activarid_tipo_tamanio_control_relacionParametroGeneralUsuario= activarid_tipo_tamanio_control_relacionParametroGeneralUsuario;
	}

	public Boolean getCargarid_tipo_tamanio_control_relacionParametroGeneralUsuario() {
		return this.cargarid_tipo_tamanio_control_relacionParametroGeneralUsuario;
	}

	public void setCargarid_tipo_tamanio_control_relacionParametroGeneralUsuario(Boolean cargarid_tipo_tamanio_control_relacionParametroGeneralUsuario) {
		this.cargarid_tipo_tamanio_control_relacionParametroGeneralUsuario= cargarid_tipo_tamanio_control_relacionParametroGeneralUsuario;
	}

	public Border setResaltarcon_tamanio_control_manualParametroGeneralUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGeneralUsuarioBeanSwingJInternalFrame parametrogeneralusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrogeneralusuarioBeanSwingJInternalFrame.jTtoolBarParametroGeneralUsuario.setBorder(borderResaltar);
		
		this.resaltarcon_tamanio_control_manualParametroGeneralUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_tamanio_control_manualParametroGeneralUsuario() {
		return this.resaltarcon_tamanio_control_manualParametroGeneralUsuario;
	}

	public void setResaltarcon_tamanio_control_manualParametroGeneralUsuario(Border borderResaltar) {
		this.resaltarcon_tamanio_control_manualParametroGeneralUsuario= borderResaltar;
	}

	public Boolean getMostrarcon_tamanio_control_manualParametroGeneralUsuario() {
		return this.mostrarcon_tamanio_control_manualParametroGeneralUsuario;
	}

	public void setMostrarcon_tamanio_control_manualParametroGeneralUsuario(Boolean mostrarcon_tamanio_control_manualParametroGeneralUsuario) {
		this.mostrarcon_tamanio_control_manualParametroGeneralUsuario= mostrarcon_tamanio_control_manualParametroGeneralUsuario;
	}

	public Boolean getActivarcon_tamanio_control_manualParametroGeneralUsuario() {
		return this.activarcon_tamanio_control_manualParametroGeneralUsuario;
	}

	public void setActivarcon_tamanio_control_manualParametroGeneralUsuario(Boolean activarcon_tamanio_control_manualParametroGeneralUsuario) {
		this.activarcon_tamanio_control_manualParametroGeneralUsuario= activarcon_tamanio_control_manualParametroGeneralUsuario;
	}

	public Border setResaltarcon_tamanio_control_todo_relacionParametroGeneralUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGeneralUsuarioBeanSwingJInternalFrame parametrogeneralusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrogeneralusuarioBeanSwingJInternalFrame.jTtoolBarParametroGeneralUsuario.setBorder(borderResaltar);
		
		this.resaltarcon_tamanio_control_todo_relacionParametroGeneralUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_tamanio_control_todo_relacionParametroGeneralUsuario() {
		return this.resaltarcon_tamanio_control_todo_relacionParametroGeneralUsuario;
	}

	public void setResaltarcon_tamanio_control_todo_relacionParametroGeneralUsuario(Border borderResaltar) {
		this.resaltarcon_tamanio_control_todo_relacionParametroGeneralUsuario= borderResaltar;
	}

	public Boolean getMostrarcon_tamanio_control_todo_relacionParametroGeneralUsuario() {
		return this.mostrarcon_tamanio_control_todo_relacionParametroGeneralUsuario;
	}

	public void setMostrarcon_tamanio_control_todo_relacionParametroGeneralUsuario(Boolean mostrarcon_tamanio_control_todo_relacionParametroGeneralUsuario) {
		this.mostrarcon_tamanio_control_todo_relacionParametroGeneralUsuario= mostrarcon_tamanio_control_todo_relacionParametroGeneralUsuario;
	}

	public Boolean getActivarcon_tamanio_control_todo_relacionParametroGeneralUsuario() {
		return this.activarcon_tamanio_control_todo_relacionParametroGeneralUsuario;
	}

	public void setActivarcon_tamanio_control_todo_relacionParametroGeneralUsuario(Boolean activarcon_tamanio_control_todo_relacionParametroGeneralUsuario) {
		this.activarcon_tamanio_control_todo_relacionParametroGeneralUsuario= activarcon_tamanio_control_todo_relacionParametroGeneralUsuario;
	}

	public Border setResaltarcon_guardar_relacionesParametroGeneralUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGeneralUsuarioBeanSwingJInternalFrame parametrogeneralusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrogeneralusuarioBeanSwingJInternalFrame.jTtoolBarParametroGeneralUsuario.setBorder(borderResaltar);
		
		this.resaltarcon_guardar_relacionesParametroGeneralUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_guardar_relacionesParametroGeneralUsuario() {
		return this.resaltarcon_guardar_relacionesParametroGeneralUsuario;
	}

	public void setResaltarcon_guardar_relacionesParametroGeneralUsuario(Border borderResaltar) {
		this.resaltarcon_guardar_relacionesParametroGeneralUsuario= borderResaltar;
	}

	public Boolean getMostrarcon_guardar_relacionesParametroGeneralUsuario() {
		return this.mostrarcon_guardar_relacionesParametroGeneralUsuario;
	}

	public void setMostrarcon_guardar_relacionesParametroGeneralUsuario(Boolean mostrarcon_guardar_relacionesParametroGeneralUsuario) {
		this.mostrarcon_guardar_relacionesParametroGeneralUsuario= mostrarcon_guardar_relacionesParametroGeneralUsuario;
	}

	public Boolean getActivarcon_guardar_relacionesParametroGeneralUsuario() {
		return this.activarcon_guardar_relacionesParametroGeneralUsuario;
	}

	public void setActivarcon_guardar_relacionesParametroGeneralUsuario(Boolean activarcon_guardar_relacionesParametroGeneralUsuario) {
		this.activarcon_guardar_relacionesParametroGeneralUsuario= activarcon_guardar_relacionesParametroGeneralUsuario;
	}

	public Border setResaltarcon_mensaje_confirmacionParametroGeneralUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGeneralUsuarioBeanSwingJInternalFrame parametrogeneralusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrogeneralusuarioBeanSwingJInternalFrame.jTtoolBarParametroGeneralUsuario.setBorder(borderResaltar);
		
		this.resaltarcon_mensaje_confirmacionParametroGeneralUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_mensaje_confirmacionParametroGeneralUsuario() {
		return this.resaltarcon_mensaje_confirmacionParametroGeneralUsuario;
	}

	public void setResaltarcon_mensaje_confirmacionParametroGeneralUsuario(Border borderResaltar) {
		this.resaltarcon_mensaje_confirmacionParametroGeneralUsuario= borderResaltar;
	}

	public Boolean getMostrarcon_mensaje_confirmacionParametroGeneralUsuario() {
		return this.mostrarcon_mensaje_confirmacionParametroGeneralUsuario;
	}

	public void setMostrarcon_mensaje_confirmacionParametroGeneralUsuario(Boolean mostrarcon_mensaje_confirmacionParametroGeneralUsuario) {
		this.mostrarcon_mensaje_confirmacionParametroGeneralUsuario= mostrarcon_mensaje_confirmacionParametroGeneralUsuario;
	}

	public Boolean getActivarcon_mensaje_confirmacionParametroGeneralUsuario() {
		return this.activarcon_mensaje_confirmacionParametroGeneralUsuario;
	}

	public void setActivarcon_mensaje_confirmacionParametroGeneralUsuario(Boolean activarcon_mensaje_confirmacionParametroGeneralUsuario) {
		this.activarcon_mensaje_confirmacionParametroGeneralUsuario= activarcon_mensaje_confirmacionParametroGeneralUsuario;
	}

	public Border setResaltarcon_botones_tool_barParametroGeneralUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGeneralUsuarioBeanSwingJInternalFrame parametrogeneralusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrogeneralusuarioBeanSwingJInternalFrame.jTtoolBarParametroGeneralUsuario.setBorder(borderResaltar);
		
		this.resaltarcon_botones_tool_barParametroGeneralUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_botones_tool_barParametroGeneralUsuario() {
		return this.resaltarcon_botones_tool_barParametroGeneralUsuario;
	}

	public void setResaltarcon_botones_tool_barParametroGeneralUsuario(Border borderResaltar) {
		this.resaltarcon_botones_tool_barParametroGeneralUsuario= borderResaltar;
	}

	public Boolean getMostrarcon_botones_tool_barParametroGeneralUsuario() {
		return this.mostrarcon_botones_tool_barParametroGeneralUsuario;
	}

	public void setMostrarcon_botones_tool_barParametroGeneralUsuario(Boolean mostrarcon_botones_tool_barParametroGeneralUsuario) {
		this.mostrarcon_botones_tool_barParametroGeneralUsuario= mostrarcon_botones_tool_barParametroGeneralUsuario;
	}

	public Boolean getActivarcon_botones_tool_barParametroGeneralUsuario() {
		return this.activarcon_botones_tool_barParametroGeneralUsuario;
	}

	public void setActivarcon_botones_tool_barParametroGeneralUsuario(Boolean activarcon_botones_tool_barParametroGeneralUsuario) {
		this.activarcon_botones_tool_barParametroGeneralUsuario= activarcon_botones_tool_barParametroGeneralUsuario;
	}

	public Border setResaltarcon_mostrar_acciones_campo_generalParametroGeneralUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGeneralUsuarioBeanSwingJInternalFrame parametrogeneralusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrogeneralusuarioBeanSwingJInternalFrame.jTtoolBarParametroGeneralUsuario.setBorder(borderResaltar);
		
		this.resaltarcon_mostrar_acciones_campo_generalParametroGeneralUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_mostrar_acciones_campo_generalParametroGeneralUsuario() {
		return this.resaltarcon_mostrar_acciones_campo_generalParametroGeneralUsuario;
	}

	public void setResaltarcon_mostrar_acciones_campo_generalParametroGeneralUsuario(Border borderResaltar) {
		this.resaltarcon_mostrar_acciones_campo_generalParametroGeneralUsuario= borderResaltar;
	}

	public Boolean getMostrarcon_mostrar_acciones_campo_generalParametroGeneralUsuario() {
		return this.mostrarcon_mostrar_acciones_campo_generalParametroGeneralUsuario;
	}

	public void setMostrarcon_mostrar_acciones_campo_generalParametroGeneralUsuario(Boolean mostrarcon_mostrar_acciones_campo_generalParametroGeneralUsuario) {
		this.mostrarcon_mostrar_acciones_campo_generalParametroGeneralUsuario= mostrarcon_mostrar_acciones_campo_generalParametroGeneralUsuario;
	}

	public Boolean getActivarcon_mostrar_acciones_campo_generalParametroGeneralUsuario() {
		return this.activarcon_mostrar_acciones_campo_generalParametroGeneralUsuario;
	}

	public void setActivarcon_mostrar_acciones_campo_generalParametroGeneralUsuario(Boolean activarcon_mostrar_acciones_campo_generalParametroGeneralUsuario) {
		this.activarcon_mostrar_acciones_campo_generalParametroGeneralUsuario= activarcon_mostrar_acciones_campo_generalParametroGeneralUsuario;
	}

	public Border setResaltarcon_mostrar_acciones_campo_relacionesParametroGeneralUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGeneralUsuarioBeanSwingJInternalFrame parametrogeneralusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrogeneralusuarioBeanSwingJInternalFrame.jTtoolBarParametroGeneralUsuario.setBorder(borderResaltar);
		
		this.resaltarcon_mostrar_acciones_campo_relacionesParametroGeneralUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_mostrar_acciones_campo_relacionesParametroGeneralUsuario() {
		return this.resaltarcon_mostrar_acciones_campo_relacionesParametroGeneralUsuario;
	}

	public void setResaltarcon_mostrar_acciones_campo_relacionesParametroGeneralUsuario(Border borderResaltar) {
		this.resaltarcon_mostrar_acciones_campo_relacionesParametroGeneralUsuario= borderResaltar;
	}

	public Boolean getMostrarcon_mostrar_acciones_campo_relacionesParametroGeneralUsuario() {
		return this.mostrarcon_mostrar_acciones_campo_relacionesParametroGeneralUsuario;
	}

	public void setMostrarcon_mostrar_acciones_campo_relacionesParametroGeneralUsuario(Boolean mostrarcon_mostrar_acciones_campo_relacionesParametroGeneralUsuario) {
		this.mostrarcon_mostrar_acciones_campo_relacionesParametroGeneralUsuario= mostrarcon_mostrar_acciones_campo_relacionesParametroGeneralUsuario;
	}

	public Boolean getActivarcon_mostrar_acciones_campo_relacionesParametroGeneralUsuario() {
		return this.activarcon_mostrar_acciones_campo_relacionesParametroGeneralUsuario;
	}

	public void setActivarcon_mostrar_acciones_campo_relacionesParametroGeneralUsuario(Boolean activarcon_mostrar_acciones_campo_relacionesParametroGeneralUsuario) {
		this.activarcon_mostrar_acciones_campo_relacionesParametroGeneralUsuario= activarcon_mostrar_acciones_campo_relacionesParametroGeneralUsuario;
	}

	public Border setResaltarid_tipo_exportarParametroGeneralUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGeneralUsuarioBeanSwingJInternalFrame parametrogeneralusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrogeneralusuarioBeanSwingJInternalFrame.jTtoolBarParametroGeneralUsuario.setBorder(borderResaltar);
		
		this.resaltarid_tipo_exportarParametroGeneralUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_exportarParametroGeneralUsuario() {
		return this.resaltarid_tipo_exportarParametroGeneralUsuario;
	}

	public void setResaltarid_tipo_exportarParametroGeneralUsuario(Border borderResaltar) {
		this.resaltarid_tipo_exportarParametroGeneralUsuario= borderResaltar;
	}

	public Boolean getMostrarid_tipo_exportarParametroGeneralUsuario() {
		return this.mostrarid_tipo_exportarParametroGeneralUsuario;
	}

	public void setMostrarid_tipo_exportarParametroGeneralUsuario(Boolean mostrarid_tipo_exportarParametroGeneralUsuario) {
		this.mostrarid_tipo_exportarParametroGeneralUsuario= mostrarid_tipo_exportarParametroGeneralUsuario;
	}

	public Boolean getActivarid_tipo_exportarParametroGeneralUsuario() {
		return this.activarid_tipo_exportarParametroGeneralUsuario;
	}

	public void setActivarid_tipo_exportarParametroGeneralUsuario(Boolean activarid_tipo_exportarParametroGeneralUsuario) {
		this.activarid_tipo_exportarParametroGeneralUsuario= activarid_tipo_exportarParametroGeneralUsuario;
	}

	public Boolean getCargarid_tipo_exportarParametroGeneralUsuario() {
		return this.cargarid_tipo_exportarParametroGeneralUsuario;
	}

	public void setCargarid_tipo_exportarParametroGeneralUsuario(Boolean cargarid_tipo_exportarParametroGeneralUsuario) {
		this.cargarid_tipo_exportarParametroGeneralUsuario= cargarid_tipo_exportarParametroGeneralUsuario;
	}

	public Border setResaltarid_tipo_delimiterParametroGeneralUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGeneralUsuarioBeanSwingJInternalFrame parametrogeneralusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrogeneralusuarioBeanSwingJInternalFrame.jTtoolBarParametroGeneralUsuario.setBorder(borderResaltar);
		
		this.resaltarid_tipo_delimiterParametroGeneralUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_delimiterParametroGeneralUsuario() {
		return this.resaltarid_tipo_delimiterParametroGeneralUsuario;
	}

	public void setResaltarid_tipo_delimiterParametroGeneralUsuario(Border borderResaltar) {
		this.resaltarid_tipo_delimiterParametroGeneralUsuario= borderResaltar;
	}

	public Boolean getMostrarid_tipo_delimiterParametroGeneralUsuario() {
		return this.mostrarid_tipo_delimiterParametroGeneralUsuario;
	}

	public void setMostrarid_tipo_delimiterParametroGeneralUsuario(Boolean mostrarid_tipo_delimiterParametroGeneralUsuario) {
		this.mostrarid_tipo_delimiterParametroGeneralUsuario= mostrarid_tipo_delimiterParametroGeneralUsuario;
	}

	public Boolean getActivarid_tipo_delimiterParametroGeneralUsuario() {
		return this.activarid_tipo_delimiterParametroGeneralUsuario;
	}

	public void setActivarid_tipo_delimiterParametroGeneralUsuario(Boolean activarid_tipo_delimiterParametroGeneralUsuario) {
		this.activarid_tipo_delimiterParametroGeneralUsuario= activarid_tipo_delimiterParametroGeneralUsuario;
	}

	public Boolean getCargarid_tipo_delimiterParametroGeneralUsuario() {
		return this.cargarid_tipo_delimiterParametroGeneralUsuario;
	}

	public void setCargarid_tipo_delimiterParametroGeneralUsuario(Boolean cargarid_tipo_delimiterParametroGeneralUsuario) {
		this.cargarid_tipo_delimiterParametroGeneralUsuario= cargarid_tipo_delimiterParametroGeneralUsuario;
	}

	public Border setResaltarcon_exportar_cabeceraParametroGeneralUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGeneralUsuarioBeanSwingJInternalFrame parametrogeneralusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrogeneralusuarioBeanSwingJInternalFrame.jTtoolBarParametroGeneralUsuario.setBorder(borderResaltar);
		
		this.resaltarcon_exportar_cabeceraParametroGeneralUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_exportar_cabeceraParametroGeneralUsuario() {
		return this.resaltarcon_exportar_cabeceraParametroGeneralUsuario;
	}

	public void setResaltarcon_exportar_cabeceraParametroGeneralUsuario(Border borderResaltar) {
		this.resaltarcon_exportar_cabeceraParametroGeneralUsuario= borderResaltar;
	}

	public Boolean getMostrarcon_exportar_cabeceraParametroGeneralUsuario() {
		return this.mostrarcon_exportar_cabeceraParametroGeneralUsuario;
	}

	public void setMostrarcon_exportar_cabeceraParametroGeneralUsuario(Boolean mostrarcon_exportar_cabeceraParametroGeneralUsuario) {
		this.mostrarcon_exportar_cabeceraParametroGeneralUsuario= mostrarcon_exportar_cabeceraParametroGeneralUsuario;
	}

	public Boolean getActivarcon_exportar_cabeceraParametroGeneralUsuario() {
		return this.activarcon_exportar_cabeceraParametroGeneralUsuario;
	}

	public void setActivarcon_exportar_cabeceraParametroGeneralUsuario(Boolean activarcon_exportar_cabeceraParametroGeneralUsuario) {
		this.activarcon_exportar_cabeceraParametroGeneralUsuario= activarcon_exportar_cabeceraParametroGeneralUsuario;
	}

	public Border setResaltarcon_exportar_campo_versionParametroGeneralUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGeneralUsuarioBeanSwingJInternalFrame parametrogeneralusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrogeneralusuarioBeanSwingJInternalFrame.jTtoolBarParametroGeneralUsuario.setBorder(borderResaltar);
		
		this.resaltarcon_exportar_campo_versionParametroGeneralUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_exportar_campo_versionParametroGeneralUsuario() {
		return this.resaltarcon_exportar_campo_versionParametroGeneralUsuario;
	}

	public void setResaltarcon_exportar_campo_versionParametroGeneralUsuario(Border borderResaltar) {
		this.resaltarcon_exportar_campo_versionParametroGeneralUsuario= borderResaltar;
	}

	public Boolean getMostrarcon_exportar_campo_versionParametroGeneralUsuario() {
		return this.mostrarcon_exportar_campo_versionParametroGeneralUsuario;
	}

	public void setMostrarcon_exportar_campo_versionParametroGeneralUsuario(Boolean mostrarcon_exportar_campo_versionParametroGeneralUsuario) {
		this.mostrarcon_exportar_campo_versionParametroGeneralUsuario= mostrarcon_exportar_campo_versionParametroGeneralUsuario;
	}

	public Boolean getActivarcon_exportar_campo_versionParametroGeneralUsuario() {
		return this.activarcon_exportar_campo_versionParametroGeneralUsuario;
	}

	public void setActivarcon_exportar_campo_versionParametroGeneralUsuario(Boolean activarcon_exportar_campo_versionParametroGeneralUsuario) {
		this.activarcon_exportar_campo_versionParametroGeneralUsuario= activarcon_exportar_campo_versionParametroGeneralUsuario;
	}

	public Border setResaltarpath_exportarParametroGeneralUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGeneralUsuarioBeanSwingJInternalFrame parametrogeneralusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrogeneralusuarioBeanSwingJInternalFrame.jTtoolBarParametroGeneralUsuario.setBorder(borderResaltar);
		
		this.resaltarpath_exportarParametroGeneralUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarpath_exportarParametroGeneralUsuario() {
		return this.resaltarpath_exportarParametroGeneralUsuario;
	}

	public void setResaltarpath_exportarParametroGeneralUsuario(Border borderResaltar) {
		this.resaltarpath_exportarParametroGeneralUsuario= borderResaltar;
	}

	public Boolean getMostrarpath_exportarParametroGeneralUsuario() {
		return this.mostrarpath_exportarParametroGeneralUsuario;
	}

	public void setMostrarpath_exportarParametroGeneralUsuario(Boolean mostrarpath_exportarParametroGeneralUsuario) {
		this.mostrarpath_exportarParametroGeneralUsuario= mostrarpath_exportarParametroGeneralUsuario;
	}

	public Boolean getActivarpath_exportarParametroGeneralUsuario() {
		return this.activarpath_exportarParametroGeneralUsuario;
	}

	public void setActivarpath_exportarParametroGeneralUsuario(Boolean activarpath_exportarParametroGeneralUsuario) {
		this.activarpath_exportarParametroGeneralUsuario= activarpath_exportarParametroGeneralUsuario;
	}

	public Border setResaltarcon_precargar_ventanasParametroGeneralUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGeneralUsuarioBeanSwingJInternalFrame parametrogeneralusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrogeneralusuarioBeanSwingJInternalFrame.jTtoolBarParametroGeneralUsuario.setBorder(borderResaltar);
		
		this.resaltarcon_precargar_ventanasParametroGeneralUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_precargar_ventanasParametroGeneralUsuario() {
		return this.resaltarcon_precargar_ventanasParametroGeneralUsuario;
	}

	public void setResaltarcon_precargar_ventanasParametroGeneralUsuario(Border borderResaltar) {
		this.resaltarcon_precargar_ventanasParametroGeneralUsuario= borderResaltar;
	}

	public Boolean getMostrarcon_precargar_ventanasParametroGeneralUsuario() {
		return this.mostrarcon_precargar_ventanasParametroGeneralUsuario;
	}

	public void setMostrarcon_precargar_ventanasParametroGeneralUsuario(Boolean mostrarcon_precargar_ventanasParametroGeneralUsuario) {
		this.mostrarcon_precargar_ventanasParametroGeneralUsuario= mostrarcon_precargar_ventanasParametroGeneralUsuario;
	}

	public Boolean getActivarcon_precargar_ventanasParametroGeneralUsuario() {
		return this.activarcon_precargar_ventanasParametroGeneralUsuario;
	}

	public void setActivarcon_precargar_ventanasParametroGeneralUsuario(Boolean activarcon_precargar_ventanasParametroGeneralUsuario) {
		this.activarcon_precargar_ventanasParametroGeneralUsuario= activarcon_precargar_ventanasParametroGeneralUsuario;
	}

	public Border setResaltarcon_precargar_por_usuarioParametroGeneralUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGeneralUsuarioBeanSwingJInternalFrame parametrogeneralusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrogeneralusuarioBeanSwingJInternalFrame.jTtoolBarParametroGeneralUsuario.setBorder(borderResaltar);
		
		this.resaltarcon_precargar_por_usuarioParametroGeneralUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_precargar_por_usuarioParametroGeneralUsuario() {
		return this.resaltarcon_precargar_por_usuarioParametroGeneralUsuario;
	}

	public void setResaltarcon_precargar_por_usuarioParametroGeneralUsuario(Border borderResaltar) {
		this.resaltarcon_precargar_por_usuarioParametroGeneralUsuario= borderResaltar;
	}

	public Boolean getMostrarcon_precargar_por_usuarioParametroGeneralUsuario() {
		return this.mostrarcon_precargar_por_usuarioParametroGeneralUsuario;
	}

	public void setMostrarcon_precargar_por_usuarioParametroGeneralUsuario(Boolean mostrarcon_precargar_por_usuarioParametroGeneralUsuario) {
		this.mostrarcon_precargar_por_usuarioParametroGeneralUsuario= mostrarcon_precargar_por_usuarioParametroGeneralUsuario;
	}

	public Boolean getActivarcon_precargar_por_usuarioParametroGeneralUsuario() {
		return this.activarcon_precargar_por_usuarioParametroGeneralUsuario;
	}

	public void setActivarcon_precargar_por_usuarioParametroGeneralUsuario(Boolean activarcon_precargar_por_usuarioParametroGeneralUsuario) {
		this.activarcon_precargar_por_usuarioParametroGeneralUsuario= activarcon_precargar_por_usuarioParametroGeneralUsuario;
	}

	public Border setResaltarcon_cargar_por_parteParametroGeneralUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGeneralUsuarioBeanSwingJInternalFrame parametrogeneralusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrogeneralusuarioBeanSwingJInternalFrame.jTtoolBarParametroGeneralUsuario.setBorder(borderResaltar);
		
		this.resaltarcon_cargar_por_parteParametroGeneralUsuario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_cargar_por_parteParametroGeneralUsuario() {
		return this.resaltarcon_cargar_por_parteParametroGeneralUsuario;
	}

	public void setResaltarcon_cargar_por_parteParametroGeneralUsuario(Border borderResaltar) {
		this.resaltarcon_cargar_por_parteParametroGeneralUsuario= borderResaltar;
	}

	public Boolean getMostrarcon_cargar_por_parteParametroGeneralUsuario() {
		return this.mostrarcon_cargar_por_parteParametroGeneralUsuario;
	}

	public void setMostrarcon_cargar_por_parteParametroGeneralUsuario(Boolean mostrarcon_cargar_por_parteParametroGeneralUsuario) {
		this.mostrarcon_cargar_por_parteParametroGeneralUsuario= mostrarcon_cargar_por_parteParametroGeneralUsuario;
	}

	public Boolean getActivarcon_cargar_por_parteParametroGeneralUsuario() {
		return this.activarcon_cargar_por_parteParametroGeneralUsuario;
	}

	public void setActivarcon_cargar_por_parteParametroGeneralUsuario(Boolean activarcon_cargar_por_parteParametroGeneralUsuario) {
		this.activarcon_cargar_por_parteParametroGeneralUsuario= activarcon_cargar_por_parteParametroGeneralUsuario;
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
		
		
		this.setMostrarid_usuarioParametroGeneralUsuario(esInicial);
		this.setMostrarid_empresaParametroGeneralUsuario(esInicial);
		this.setMostrarid_sucursalParametroGeneralUsuario(esInicial);
		this.setMostrarid_ejercicioParametroGeneralUsuario(esInicial);
		this.setMostrarid_periodoParametroGeneralUsuario(esInicial);
		this.setMostrarid_monedaParametroGeneralUsuario(esInicial);
		this.setMostrarfecha_sistemaParametroGeneralUsuario(esInicial);
		this.setMostrarid_anioParametroGeneralUsuario(esInicial);
		this.setMostrarid_mesParametroGeneralUsuario(esInicial);
		this.setMostrardiaParametroGeneralUsuario(esInicial);
		this.setMostrarid_tipo_visualParametroGeneralUsuario(esInicial);
		this.setMostrarid_tipo_fondoParametroGeneralUsuario(esInicial);
		this.setMostrarid_tipo_fondo_bordeParametroGeneralUsuario(esInicial);
		this.setMostrarid_tipo_fondo_controlParametroGeneralUsuario(esInicial);
		this.setMostrarid_tipo_fuenteParametroGeneralUsuario(esInicial);
		this.setMostrarid_tipo_tamanio_control_normalParametroGeneralUsuario(esInicial);
		this.setMostrarid_tipo_tamanio_control_relacionParametroGeneralUsuario(esInicial);
		this.setMostrarcon_tamanio_control_manualParametroGeneralUsuario(esInicial);
		this.setMostrarcon_tamanio_control_todo_relacionParametroGeneralUsuario(esInicial);
		this.setMostrarcon_guardar_relacionesParametroGeneralUsuario(esInicial);
		this.setMostrarcon_mensaje_confirmacionParametroGeneralUsuario(esInicial);
		this.setMostrarcon_botones_tool_barParametroGeneralUsuario(esInicial);
		this.setMostrarcon_mostrar_acciones_campo_generalParametroGeneralUsuario(esInicial);
		this.setMostrarcon_mostrar_acciones_campo_relacionesParametroGeneralUsuario(esInicial);
		this.setMostrarid_tipo_exportarParametroGeneralUsuario(esInicial);
		this.setMostrarid_tipo_delimiterParametroGeneralUsuario(esInicial);
		this.setMostrarcon_exportar_cabeceraParametroGeneralUsuario(esInicial);
		this.setMostrarcon_exportar_campo_versionParametroGeneralUsuario(esInicial);
		this.setMostrarpath_exportarParametroGeneralUsuario(esInicial);
		this.setMostrarcon_precargar_ventanasParametroGeneralUsuario(esInicial);
		this.setMostrarcon_precargar_por_usuarioParametroGeneralUsuario(esInicial);
		this.setMostrarcon_cargar_por_parteParametroGeneralUsuario(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.ID)) {
				this.setMostrarid_usuarioParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.IDMONEDA)) {
				this.setMostrarid_monedaParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.FECHASISTEMA)) {
				this.setMostrarfecha_sistemaParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.IDMES)) {
				this.setMostrarid_mesParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.DIA)) {
				this.setMostrardiaParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.IDTIPOVISUAL)) {
				this.setMostrarid_tipo_visualParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.IDTIPOFONDO)) {
				this.setMostrarid_tipo_fondoParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.IDTIPOFONDOBORDE)) {
				this.setMostrarid_tipo_fondo_bordeParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.IDTIPOFONDOCONTROL)) {
				this.setMostrarid_tipo_fondo_controlParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.IDTIPOFUENTE)) {
				this.setMostrarid_tipo_fuenteParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.IDTIPOTAMANIOCONTROLNORMAL)) {
				this.setMostrarid_tipo_tamanio_control_normalParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.IDTIPOTAMANIOCONTROLRELACION)) {
				this.setMostrarid_tipo_tamanio_control_relacionParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.CONTAMANIOCONTROLMANUAL)) {
				this.setMostrarcon_tamanio_control_manualParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.CONTAMANIOCONTROLTODORELACION)) {
				this.setMostrarcon_tamanio_control_todo_relacionParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.CONGUARDARRELACIONES)) {
				this.setMostrarcon_guardar_relacionesParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.CONMENSAJECONFIRMACION)) {
				this.setMostrarcon_mensaje_confirmacionParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.CONBOTONESTOOLBAR)) {
				this.setMostrarcon_botones_tool_barParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.CONMOSTRARACCIONESCAMPOGENERAL)) {
				this.setMostrarcon_mostrar_acciones_campo_generalParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.CONMOSTRARACCIONESCAMPORELACIONES)) {
				this.setMostrarcon_mostrar_acciones_campo_relacionesParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.IDTIPOEXPORTAR)) {
				this.setMostrarid_tipo_exportarParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.IDTIPODELIMITER)) {
				this.setMostrarid_tipo_delimiterParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.CONEXPORTARCABECERA)) {
				this.setMostrarcon_exportar_cabeceraParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.CONEXPORTARCAMPOVERSION)) {
				this.setMostrarcon_exportar_campo_versionParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.PATHEXPORTAR)) {
				this.setMostrarpath_exportarParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.CONPRECARGARVENTANAS)) {
				this.setMostrarcon_precargar_ventanasParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.CONPRECARGARPORUSUARIO)) {
				this.setMostrarcon_precargar_por_usuarioParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.CONCARGARPORPARTE)) {
				this.setMostrarcon_cargar_por_parteParametroGeneralUsuario(esAsigna);
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
		
		
		this.setActivarid_usuarioParametroGeneralUsuario(esInicial);
		this.setActivarid_empresaParametroGeneralUsuario(esInicial);
		this.setActivarid_sucursalParametroGeneralUsuario(esInicial);
		this.setActivarid_ejercicioParametroGeneralUsuario(esInicial);
		this.setActivarid_periodoParametroGeneralUsuario(esInicial);
		this.setActivarid_monedaParametroGeneralUsuario(esInicial);
		this.setActivarfecha_sistemaParametroGeneralUsuario(esInicial);
		this.setActivarid_anioParametroGeneralUsuario(esInicial);
		this.setActivarid_mesParametroGeneralUsuario(esInicial);
		this.setActivardiaParametroGeneralUsuario(esInicial);
		this.setActivarid_tipo_visualParametroGeneralUsuario(esInicial);
		this.setActivarid_tipo_fondoParametroGeneralUsuario(esInicial);
		this.setActivarid_tipo_fondo_bordeParametroGeneralUsuario(esInicial);
		this.setActivarid_tipo_fondo_controlParametroGeneralUsuario(esInicial);
		this.setActivarid_tipo_fuenteParametroGeneralUsuario(esInicial);
		this.setActivarid_tipo_tamanio_control_normalParametroGeneralUsuario(esInicial);
		this.setActivarid_tipo_tamanio_control_relacionParametroGeneralUsuario(esInicial);
		this.setActivarcon_tamanio_control_manualParametroGeneralUsuario(esInicial);
		this.setActivarcon_tamanio_control_todo_relacionParametroGeneralUsuario(esInicial);
		this.setActivarcon_guardar_relacionesParametroGeneralUsuario(esInicial);
		this.setActivarcon_mensaje_confirmacionParametroGeneralUsuario(esInicial);
		this.setActivarcon_botones_tool_barParametroGeneralUsuario(esInicial);
		this.setActivarcon_mostrar_acciones_campo_generalParametroGeneralUsuario(esInicial);
		this.setActivarcon_mostrar_acciones_campo_relacionesParametroGeneralUsuario(esInicial);
		this.setActivarid_tipo_exportarParametroGeneralUsuario(esInicial);
		this.setActivarid_tipo_delimiterParametroGeneralUsuario(esInicial);
		this.setActivarcon_exportar_cabeceraParametroGeneralUsuario(esInicial);
		this.setActivarcon_exportar_campo_versionParametroGeneralUsuario(esInicial);
		this.setActivarpath_exportarParametroGeneralUsuario(esInicial);
		this.setActivarcon_precargar_ventanasParametroGeneralUsuario(esInicial);
		this.setActivarcon_precargar_por_usuarioParametroGeneralUsuario(esInicial);
		this.setActivarcon_cargar_por_parteParametroGeneralUsuario(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.ID)) {
				this.setActivarid_usuarioParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.IDMONEDA)) {
				this.setActivarid_monedaParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.FECHASISTEMA)) {
				this.setActivarfecha_sistemaParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.IDANIO)) {
				this.setActivarid_anioParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.IDMES)) {
				this.setActivarid_mesParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.DIA)) {
				this.setActivardiaParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.IDTIPOVISUAL)) {
				this.setActivarid_tipo_visualParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.IDTIPOFONDO)) {
				this.setActivarid_tipo_fondoParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.IDTIPOFONDOBORDE)) {
				this.setActivarid_tipo_fondo_bordeParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.IDTIPOFONDOCONTROL)) {
				this.setActivarid_tipo_fondo_controlParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.IDTIPOFUENTE)) {
				this.setActivarid_tipo_fuenteParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.IDTIPOTAMANIOCONTROLNORMAL)) {
				this.setActivarid_tipo_tamanio_control_normalParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.IDTIPOTAMANIOCONTROLRELACION)) {
				this.setActivarid_tipo_tamanio_control_relacionParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.CONTAMANIOCONTROLMANUAL)) {
				this.setActivarcon_tamanio_control_manualParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.CONTAMANIOCONTROLTODORELACION)) {
				this.setActivarcon_tamanio_control_todo_relacionParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.CONGUARDARRELACIONES)) {
				this.setActivarcon_guardar_relacionesParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.CONMENSAJECONFIRMACION)) {
				this.setActivarcon_mensaje_confirmacionParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.CONBOTONESTOOLBAR)) {
				this.setActivarcon_botones_tool_barParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.CONMOSTRARACCIONESCAMPOGENERAL)) {
				this.setActivarcon_mostrar_acciones_campo_generalParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.CONMOSTRARACCIONESCAMPORELACIONES)) {
				this.setActivarcon_mostrar_acciones_campo_relacionesParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.IDTIPOEXPORTAR)) {
				this.setActivarid_tipo_exportarParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.IDTIPODELIMITER)) {
				this.setActivarid_tipo_delimiterParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.CONEXPORTARCABECERA)) {
				this.setActivarcon_exportar_cabeceraParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.CONEXPORTARCAMPOVERSION)) {
				this.setActivarcon_exportar_campo_versionParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.PATHEXPORTAR)) {
				this.setActivarpath_exportarParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.CONPRECARGARVENTANAS)) {
				this.setActivarcon_precargar_ventanasParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.CONPRECARGARPORUSUARIO)) {
				this.setActivarcon_precargar_por_usuarioParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.CONCARGARPORPARTE)) {
				this.setActivarcon_cargar_por_parteParametroGeneralUsuario(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ParametroGeneralUsuarioBeanSwingJInternalFrame parametrogeneralusuarioBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltarid_usuarioParametroGeneralUsuario(esInicial);
		this.setResaltarid_empresaParametroGeneralUsuario(esInicial);
		this.setResaltarid_sucursalParametroGeneralUsuario(esInicial);
		this.setResaltarid_ejercicioParametroGeneralUsuario(esInicial);
		this.setResaltarid_periodoParametroGeneralUsuario(esInicial);
		this.setResaltarid_monedaParametroGeneralUsuario(esInicial);
		this.setResaltarfecha_sistemaParametroGeneralUsuario(esInicial);
		this.setResaltarid_anioParametroGeneralUsuario(esInicial);
		this.setResaltarid_mesParametroGeneralUsuario(esInicial);
		this.setResaltardiaParametroGeneralUsuario(esInicial);
		this.setResaltarid_tipo_visualParametroGeneralUsuario(esInicial);
		this.setResaltarid_tipo_fondoParametroGeneralUsuario(esInicial);
		this.setResaltarid_tipo_fondo_bordeParametroGeneralUsuario(esInicial);
		this.setResaltarid_tipo_fondo_controlParametroGeneralUsuario(esInicial);
		this.setResaltarid_tipo_fuenteParametroGeneralUsuario(esInicial);
		this.setResaltarid_tipo_tamanio_control_normalParametroGeneralUsuario(esInicial);
		this.setResaltarid_tipo_tamanio_control_relacionParametroGeneralUsuario(esInicial);
		this.setResaltarcon_tamanio_control_manualParametroGeneralUsuario(esInicial);
		this.setResaltarcon_tamanio_control_todo_relacionParametroGeneralUsuario(esInicial);
		this.setResaltarcon_guardar_relacionesParametroGeneralUsuario(esInicial);
		this.setResaltarcon_mensaje_confirmacionParametroGeneralUsuario(esInicial);
		this.setResaltarcon_botones_tool_barParametroGeneralUsuario(esInicial);
		this.setResaltarcon_mostrar_acciones_campo_generalParametroGeneralUsuario(esInicial);
		this.setResaltarcon_mostrar_acciones_campo_relacionesParametroGeneralUsuario(esInicial);
		this.setResaltarid_tipo_exportarParametroGeneralUsuario(esInicial);
		this.setResaltarid_tipo_delimiterParametroGeneralUsuario(esInicial);
		this.setResaltarcon_exportar_cabeceraParametroGeneralUsuario(esInicial);
		this.setResaltarcon_exportar_campo_versionParametroGeneralUsuario(esInicial);
		this.setResaltarpath_exportarParametroGeneralUsuario(esInicial);
		this.setResaltarcon_precargar_ventanasParametroGeneralUsuario(esInicial);
		this.setResaltarcon_precargar_por_usuarioParametroGeneralUsuario(esInicial);
		this.setResaltarcon_cargar_por_parteParametroGeneralUsuario(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.ID)) {
				this.setResaltarid_usuarioParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.IDMONEDA)) {
				this.setResaltarid_monedaParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.FECHASISTEMA)) {
				this.setResaltarfecha_sistemaParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.IDMES)) {
				this.setResaltarid_mesParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.DIA)) {
				this.setResaltardiaParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.IDTIPOVISUAL)) {
				this.setResaltarid_tipo_visualParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.IDTIPOFONDO)) {
				this.setResaltarid_tipo_fondoParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.IDTIPOFONDOBORDE)) {
				this.setResaltarid_tipo_fondo_bordeParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.IDTIPOFONDOCONTROL)) {
				this.setResaltarid_tipo_fondo_controlParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.IDTIPOFUENTE)) {
				this.setResaltarid_tipo_fuenteParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.IDTIPOTAMANIOCONTROLNORMAL)) {
				this.setResaltarid_tipo_tamanio_control_normalParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.IDTIPOTAMANIOCONTROLRELACION)) {
				this.setResaltarid_tipo_tamanio_control_relacionParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.CONTAMANIOCONTROLMANUAL)) {
				this.setResaltarcon_tamanio_control_manualParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.CONTAMANIOCONTROLTODORELACION)) {
				this.setResaltarcon_tamanio_control_todo_relacionParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.CONGUARDARRELACIONES)) {
				this.setResaltarcon_guardar_relacionesParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.CONMENSAJECONFIRMACION)) {
				this.setResaltarcon_mensaje_confirmacionParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.CONBOTONESTOOLBAR)) {
				this.setResaltarcon_botones_tool_barParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.CONMOSTRARACCIONESCAMPOGENERAL)) {
				this.setResaltarcon_mostrar_acciones_campo_generalParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.CONMOSTRARACCIONESCAMPORELACIONES)) {
				this.setResaltarcon_mostrar_acciones_campo_relacionesParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.IDTIPOEXPORTAR)) {
				this.setResaltarid_tipo_exportarParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.IDTIPODELIMITER)) {
				this.setResaltarid_tipo_delimiterParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.CONEXPORTARCABECERA)) {
				this.setResaltarcon_exportar_cabeceraParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.CONEXPORTARCAMPOVERSION)) {
				this.setResaltarcon_exportar_campo_versionParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.PATHEXPORTAR)) {
				this.setResaltarpath_exportarParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.CONPRECARGARVENTANAS)) {
				this.setResaltarcon_precargar_ventanasParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.CONPRECARGARPORUSUARIO)) {
				this.setResaltarcon_precargar_por_usuarioParametroGeneralUsuario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralUsuarioConstantesFunciones.CONCARGARPORPARTE)) {
				this.setResaltarcon_cargar_por_parteParametroGeneralUsuario(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ParametroGeneralUsuarioBeanSwingJInternalFrame parametrogeneralusuarioBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpresaParametroGeneralUsuario=true;

	public Boolean getMostrarFK_IdEmpresaParametroGeneralUsuario() {
		return this.mostrarFK_IdEmpresaParametroGeneralUsuario;
	}

	public void setMostrarFK_IdEmpresaParametroGeneralUsuario(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaParametroGeneralUsuario= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdMonedaParametroGeneralUsuario=true;

	public Boolean getMostrarFK_IdMonedaParametroGeneralUsuario() {
		return this.mostrarFK_IdMonedaParametroGeneralUsuario;
	}

	public void setMostrarFK_IdMonedaParametroGeneralUsuario(Boolean visibilidadResaltar) {
		this.mostrarFK_IdMonedaParametroGeneralUsuario= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoDelimiterParametroGeneralUsuario=true;

	public Boolean getMostrarFK_IdTipoDelimiterParametroGeneralUsuario() {
		return this.mostrarFK_IdTipoDelimiterParametroGeneralUsuario;
	}

	public void setMostrarFK_IdTipoDelimiterParametroGeneralUsuario(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoDelimiterParametroGeneralUsuario= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoExportarParametroGeneralUsuario=true;

	public Boolean getMostrarFK_IdTipoExportarParametroGeneralUsuario() {
		return this.mostrarFK_IdTipoExportarParametroGeneralUsuario;
	}

	public void setMostrarFK_IdTipoExportarParametroGeneralUsuario(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoExportarParametroGeneralUsuario= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoFondoParametroGeneralUsuario=true;

	public Boolean getMostrarFK_IdTipoFondoParametroGeneralUsuario() {
		return this.mostrarFK_IdTipoFondoParametroGeneralUsuario;
	}

	public void setMostrarFK_IdTipoFondoParametroGeneralUsuario(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoFondoParametroGeneralUsuario= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoFondoBordeParametroGeneralUsuario=true;

	public Boolean getMostrarFK_IdTipoFondoBordeParametroGeneralUsuario() {
		return this.mostrarFK_IdTipoFondoBordeParametroGeneralUsuario;
	}

	public void setMostrarFK_IdTipoFondoBordeParametroGeneralUsuario(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoFondoBordeParametroGeneralUsuario= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoFondoControlParametroGeneralUsuario=true;

	public Boolean getMostrarFK_IdTipoFondoControlParametroGeneralUsuario() {
		return this.mostrarFK_IdTipoFondoControlParametroGeneralUsuario;
	}

	public void setMostrarFK_IdTipoFondoControlParametroGeneralUsuario(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoFondoControlParametroGeneralUsuario= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoFuenteParametroGeneralUsuario=true;

	public Boolean getMostrarFK_IdTipoFuenteParametroGeneralUsuario() {
		return this.mostrarFK_IdTipoFuenteParametroGeneralUsuario;
	}

	public void setMostrarFK_IdTipoFuenteParametroGeneralUsuario(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoFuenteParametroGeneralUsuario= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoTamanioControlNormalParametroGeneralUsuario=true;

	public Boolean getMostrarFK_IdTipoTamanioControlNormalParametroGeneralUsuario() {
		return this.mostrarFK_IdTipoTamanioControlNormalParametroGeneralUsuario;
	}

	public void setMostrarFK_IdTipoTamanioControlNormalParametroGeneralUsuario(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoTamanioControlNormalParametroGeneralUsuario= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoTamanioControlRelacionParametroGeneralUsuario=true;

	public Boolean getMostrarFK_IdTipoTamanioControlRelacionParametroGeneralUsuario() {
		return this.mostrarFK_IdTipoTamanioControlRelacionParametroGeneralUsuario;
	}

	public void setMostrarFK_IdTipoTamanioControlRelacionParametroGeneralUsuario(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoTamanioControlRelacionParametroGeneralUsuario= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUsuarioParametroGeneralUsuario=true;

	public Boolean getMostrarFK_IdUsuarioParametroGeneralUsuario() {
		return this.mostrarFK_IdUsuarioParametroGeneralUsuario;
	}

	public void setMostrarFK_IdUsuarioParametroGeneralUsuario(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUsuarioParametroGeneralUsuario= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaParametroGeneralUsuario=true;

	public Boolean getActivarFK_IdEmpresaParametroGeneralUsuario() {
		return this.activarFK_IdEmpresaParametroGeneralUsuario;
	}

	public void setActivarFK_IdEmpresaParametroGeneralUsuario(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaParametroGeneralUsuario= habilitarResaltar;
	}

	public Boolean activarFK_IdMonedaParametroGeneralUsuario=true;

	public Boolean getActivarFK_IdMonedaParametroGeneralUsuario() {
		return this.activarFK_IdMonedaParametroGeneralUsuario;
	}

	public void setActivarFK_IdMonedaParametroGeneralUsuario(Boolean habilitarResaltar) {
		this.activarFK_IdMonedaParametroGeneralUsuario= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoDelimiterParametroGeneralUsuario=true;

	public Boolean getActivarFK_IdTipoDelimiterParametroGeneralUsuario() {
		return this.activarFK_IdTipoDelimiterParametroGeneralUsuario;
	}

	public void setActivarFK_IdTipoDelimiterParametroGeneralUsuario(Boolean habilitarResaltar) {
		this.activarFK_IdTipoDelimiterParametroGeneralUsuario= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoExportarParametroGeneralUsuario=true;

	public Boolean getActivarFK_IdTipoExportarParametroGeneralUsuario() {
		return this.activarFK_IdTipoExportarParametroGeneralUsuario;
	}

	public void setActivarFK_IdTipoExportarParametroGeneralUsuario(Boolean habilitarResaltar) {
		this.activarFK_IdTipoExportarParametroGeneralUsuario= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoFondoParametroGeneralUsuario=true;

	public Boolean getActivarFK_IdTipoFondoParametroGeneralUsuario() {
		return this.activarFK_IdTipoFondoParametroGeneralUsuario;
	}

	public void setActivarFK_IdTipoFondoParametroGeneralUsuario(Boolean habilitarResaltar) {
		this.activarFK_IdTipoFondoParametroGeneralUsuario= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoFondoBordeParametroGeneralUsuario=true;

	public Boolean getActivarFK_IdTipoFondoBordeParametroGeneralUsuario() {
		return this.activarFK_IdTipoFondoBordeParametroGeneralUsuario;
	}

	public void setActivarFK_IdTipoFondoBordeParametroGeneralUsuario(Boolean habilitarResaltar) {
		this.activarFK_IdTipoFondoBordeParametroGeneralUsuario= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoFondoControlParametroGeneralUsuario=true;

	public Boolean getActivarFK_IdTipoFondoControlParametroGeneralUsuario() {
		return this.activarFK_IdTipoFondoControlParametroGeneralUsuario;
	}

	public void setActivarFK_IdTipoFondoControlParametroGeneralUsuario(Boolean habilitarResaltar) {
		this.activarFK_IdTipoFondoControlParametroGeneralUsuario= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoFuenteParametroGeneralUsuario=true;

	public Boolean getActivarFK_IdTipoFuenteParametroGeneralUsuario() {
		return this.activarFK_IdTipoFuenteParametroGeneralUsuario;
	}

	public void setActivarFK_IdTipoFuenteParametroGeneralUsuario(Boolean habilitarResaltar) {
		this.activarFK_IdTipoFuenteParametroGeneralUsuario= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoTamanioControlNormalParametroGeneralUsuario=true;

	public Boolean getActivarFK_IdTipoTamanioControlNormalParametroGeneralUsuario() {
		return this.activarFK_IdTipoTamanioControlNormalParametroGeneralUsuario;
	}

	public void setActivarFK_IdTipoTamanioControlNormalParametroGeneralUsuario(Boolean habilitarResaltar) {
		this.activarFK_IdTipoTamanioControlNormalParametroGeneralUsuario= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoTamanioControlRelacionParametroGeneralUsuario=true;

	public Boolean getActivarFK_IdTipoTamanioControlRelacionParametroGeneralUsuario() {
		return this.activarFK_IdTipoTamanioControlRelacionParametroGeneralUsuario;
	}

	public void setActivarFK_IdTipoTamanioControlRelacionParametroGeneralUsuario(Boolean habilitarResaltar) {
		this.activarFK_IdTipoTamanioControlRelacionParametroGeneralUsuario= habilitarResaltar;
	}

	public Boolean activarFK_IdUsuarioParametroGeneralUsuario=true;

	public Boolean getActivarFK_IdUsuarioParametroGeneralUsuario() {
		return this.activarFK_IdUsuarioParametroGeneralUsuario;
	}

	public void setActivarFK_IdUsuarioParametroGeneralUsuario(Boolean habilitarResaltar) {
		this.activarFK_IdUsuarioParametroGeneralUsuario= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaParametroGeneralUsuario=null;

	public Border getResaltarFK_IdEmpresaParametroGeneralUsuario() {
		return this.resaltarFK_IdEmpresaParametroGeneralUsuario;
	}

	public void setResaltarFK_IdEmpresaParametroGeneralUsuario(Border borderResaltar) {
		this.resaltarFK_IdEmpresaParametroGeneralUsuario= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaParametroGeneralUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGeneralUsuarioBeanSwingJInternalFrame parametrogeneralusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaParametroGeneralUsuario= borderResaltar;
	}

	public Border resaltarFK_IdMonedaParametroGeneralUsuario=null;

	public Border getResaltarFK_IdMonedaParametroGeneralUsuario() {
		return this.resaltarFK_IdMonedaParametroGeneralUsuario;
	}

	public void setResaltarFK_IdMonedaParametroGeneralUsuario(Border borderResaltar) {
		this.resaltarFK_IdMonedaParametroGeneralUsuario= borderResaltar;
	}

	public void setResaltarFK_IdMonedaParametroGeneralUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGeneralUsuarioBeanSwingJInternalFrame parametrogeneralusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdMonedaParametroGeneralUsuario= borderResaltar;
	}

	public Border resaltarFK_IdTipoDelimiterParametroGeneralUsuario=null;

	public Border getResaltarFK_IdTipoDelimiterParametroGeneralUsuario() {
		return this.resaltarFK_IdTipoDelimiterParametroGeneralUsuario;
	}

	public void setResaltarFK_IdTipoDelimiterParametroGeneralUsuario(Border borderResaltar) {
		this.resaltarFK_IdTipoDelimiterParametroGeneralUsuario= borderResaltar;
	}

	public void setResaltarFK_IdTipoDelimiterParametroGeneralUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGeneralUsuarioBeanSwingJInternalFrame parametrogeneralusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoDelimiterParametroGeneralUsuario= borderResaltar;
	}

	public Border resaltarFK_IdTipoExportarParametroGeneralUsuario=null;

	public Border getResaltarFK_IdTipoExportarParametroGeneralUsuario() {
		return this.resaltarFK_IdTipoExportarParametroGeneralUsuario;
	}

	public void setResaltarFK_IdTipoExportarParametroGeneralUsuario(Border borderResaltar) {
		this.resaltarFK_IdTipoExportarParametroGeneralUsuario= borderResaltar;
	}

	public void setResaltarFK_IdTipoExportarParametroGeneralUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGeneralUsuarioBeanSwingJInternalFrame parametrogeneralusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoExportarParametroGeneralUsuario= borderResaltar;
	}

	public Border resaltarFK_IdTipoFondoParametroGeneralUsuario=null;

	public Border getResaltarFK_IdTipoFondoParametroGeneralUsuario() {
		return this.resaltarFK_IdTipoFondoParametroGeneralUsuario;
	}

	public void setResaltarFK_IdTipoFondoParametroGeneralUsuario(Border borderResaltar) {
		this.resaltarFK_IdTipoFondoParametroGeneralUsuario= borderResaltar;
	}

	public void setResaltarFK_IdTipoFondoParametroGeneralUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGeneralUsuarioBeanSwingJInternalFrame parametrogeneralusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoFondoParametroGeneralUsuario= borderResaltar;
	}

	public Border resaltarFK_IdTipoFondoBordeParametroGeneralUsuario=null;

	public Border getResaltarFK_IdTipoFondoBordeParametroGeneralUsuario() {
		return this.resaltarFK_IdTipoFondoBordeParametroGeneralUsuario;
	}

	public void setResaltarFK_IdTipoFondoBordeParametroGeneralUsuario(Border borderResaltar) {
		this.resaltarFK_IdTipoFondoBordeParametroGeneralUsuario= borderResaltar;
	}

	public void setResaltarFK_IdTipoFondoBordeParametroGeneralUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGeneralUsuarioBeanSwingJInternalFrame parametrogeneralusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoFondoBordeParametroGeneralUsuario= borderResaltar;
	}

	public Border resaltarFK_IdTipoFondoControlParametroGeneralUsuario=null;

	public Border getResaltarFK_IdTipoFondoControlParametroGeneralUsuario() {
		return this.resaltarFK_IdTipoFondoControlParametroGeneralUsuario;
	}

	public void setResaltarFK_IdTipoFondoControlParametroGeneralUsuario(Border borderResaltar) {
		this.resaltarFK_IdTipoFondoControlParametroGeneralUsuario= borderResaltar;
	}

	public void setResaltarFK_IdTipoFondoControlParametroGeneralUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGeneralUsuarioBeanSwingJInternalFrame parametrogeneralusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoFondoControlParametroGeneralUsuario= borderResaltar;
	}

	public Border resaltarFK_IdTipoFuenteParametroGeneralUsuario=null;

	public Border getResaltarFK_IdTipoFuenteParametroGeneralUsuario() {
		return this.resaltarFK_IdTipoFuenteParametroGeneralUsuario;
	}

	public void setResaltarFK_IdTipoFuenteParametroGeneralUsuario(Border borderResaltar) {
		this.resaltarFK_IdTipoFuenteParametroGeneralUsuario= borderResaltar;
	}

	public void setResaltarFK_IdTipoFuenteParametroGeneralUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGeneralUsuarioBeanSwingJInternalFrame parametrogeneralusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoFuenteParametroGeneralUsuario= borderResaltar;
	}

	public Border resaltarFK_IdTipoTamanioControlNormalParametroGeneralUsuario=null;

	public Border getResaltarFK_IdTipoTamanioControlNormalParametroGeneralUsuario() {
		return this.resaltarFK_IdTipoTamanioControlNormalParametroGeneralUsuario;
	}

	public void setResaltarFK_IdTipoTamanioControlNormalParametroGeneralUsuario(Border borderResaltar) {
		this.resaltarFK_IdTipoTamanioControlNormalParametroGeneralUsuario= borderResaltar;
	}

	public void setResaltarFK_IdTipoTamanioControlNormalParametroGeneralUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGeneralUsuarioBeanSwingJInternalFrame parametrogeneralusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoTamanioControlNormalParametroGeneralUsuario= borderResaltar;
	}

	public Border resaltarFK_IdTipoTamanioControlRelacionParametroGeneralUsuario=null;

	public Border getResaltarFK_IdTipoTamanioControlRelacionParametroGeneralUsuario() {
		return this.resaltarFK_IdTipoTamanioControlRelacionParametroGeneralUsuario;
	}

	public void setResaltarFK_IdTipoTamanioControlRelacionParametroGeneralUsuario(Border borderResaltar) {
		this.resaltarFK_IdTipoTamanioControlRelacionParametroGeneralUsuario= borderResaltar;
	}

	public void setResaltarFK_IdTipoTamanioControlRelacionParametroGeneralUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGeneralUsuarioBeanSwingJInternalFrame parametrogeneralusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoTamanioControlRelacionParametroGeneralUsuario= borderResaltar;
	}

	public Border resaltarFK_IdUsuarioParametroGeneralUsuario=null;

	public Border getResaltarFK_IdUsuarioParametroGeneralUsuario() {
		return this.resaltarFK_IdUsuarioParametroGeneralUsuario;
	}

	public void setResaltarFK_IdUsuarioParametroGeneralUsuario(Border borderResaltar) {
		this.resaltarFK_IdUsuarioParametroGeneralUsuario= borderResaltar;
	}

	public void setResaltarFK_IdUsuarioParametroGeneralUsuario(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGeneralUsuarioBeanSwingJInternalFrame parametrogeneralusuarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUsuarioParametroGeneralUsuario= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}