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


import com.bydan.erp.seguridad.util.UpdateDetalleConstantesFunciones;
import com.bydan.erp.seguridad.util.UpdateDetalleParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.UpdateDetalleParameterGeneral;

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
final public class UpdateDetalleConstantesFunciones extends UpdateDetalleConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="UpdateDetalle";
	public static final String SPATHOPCION="Seguridad";	
	public static final String SPATHMODULO="seguridad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="UpdateDetalle"+UpdateDetalleConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="UpdateDetalleHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="UpdateDetalleHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=UpdateDetalleConstantesFunciones.SCHEMA+"_"+UpdateDetalleConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/UpdateDetalleHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=UpdateDetalleConstantesFunciones.SCHEMA+"_"+UpdateDetalleConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=UpdateDetalleConstantesFunciones.SCHEMA+"_"+UpdateDetalleConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/UpdateDetalleHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=UpdateDetalleConstantesFunciones.SCHEMA+"_"+UpdateDetalleConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+UpdateDetalleConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/UpdateDetalleHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+UpdateDetalleConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+UpdateDetalleConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/UpdateDetalleHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+UpdateDetalleConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=UpdateDetalleConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+UpdateDetalleConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=UpdateDetalleConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+UpdateDetalleConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Update Detalles";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Update Detalle";
	public static final String SCLASSWEBTITULO_LOWER="Update Detalle";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="UpdateDetalle";
	public static final String OBJECTNAME="updatedetalle";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SEGURIDAD;	
	public static final String TABLENAME="update_detalle";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select updatedetalle from "+UpdateDetalleConstantesFunciones.SPERSISTENCENAME+" updatedetalle";
	public static String QUERYSELECTNATIVE="select "+UpdateDetalleConstantesFunciones.SCHEMA+"."+UpdateDetalleConstantesFunciones.TABLENAME+".id,"+UpdateDetalleConstantesFunciones.SCHEMA+"."+UpdateDetalleConstantesFunciones.TABLENAME+".version_row,"+UpdateDetalleConstantesFunciones.SCHEMA+"."+UpdateDetalleConstantesFunciones.TABLENAME+".id_update,"+UpdateDetalleConstantesFunciones.SCHEMA+"."+UpdateDetalleConstantesFunciones.TABLENAME+".id_anio,"+UpdateDetalleConstantesFunciones.SCHEMA+"."+UpdateDetalleConstantesFunciones.TABLENAME+".id_mes,"+UpdateDetalleConstantesFunciones.SCHEMA+"."+UpdateDetalleConstantesFunciones.TABLENAME+".codigo,"+UpdateDetalleConstantesFunciones.SCHEMA+"."+UpdateDetalleConstantesFunciones.TABLENAME+".codigo_proceso,"+UpdateDetalleConstantesFunciones.SCHEMA+"."+UpdateDetalleConstantesFunciones.TABLENAME+".query_resumen,"+UpdateDetalleConstantesFunciones.SCHEMA+"."+UpdateDetalleConstantesFunciones.TABLENAME+".numero_intento,"+UpdateDetalleConstantesFunciones.SCHEMA+"."+UpdateDetalleConstantesFunciones.TABLENAME+".fecha_archivo,"+UpdateDetalleConstantesFunciones.SCHEMA+"."+UpdateDetalleConstantesFunciones.TABLENAME+".fecha,"+UpdateDetalleConstantesFunciones.SCHEMA+"."+UpdateDetalleConstantesFunciones.TABLENAME+".orden,"+UpdateDetalleConstantesFunciones.SCHEMA+"."+UpdateDetalleConstantesFunciones.TABLENAME+".ejecutado,"+UpdateDetalleConstantesFunciones.SCHEMA+"."+UpdateDetalleConstantesFunciones.TABLENAME+".esta_activo,"+UpdateDetalleConstantesFunciones.SCHEMA+"."+UpdateDetalleConstantesFunciones.TABLENAME+".descripcion from "+UpdateDetalleConstantesFunciones.SCHEMA+"."+UpdateDetalleConstantesFunciones.TABLENAME;//+" as "+UpdateDetalleConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected UpdateDetalleConstantesFuncionesAdditional updatedetalleConstantesFuncionesAdditional=null;
	
	public UpdateDetalleConstantesFuncionesAdditional getUpdateDetalleConstantesFuncionesAdditional() {
		return this.updatedetalleConstantesFuncionesAdditional;
	}
	
	public void setUpdateDetalleConstantesFuncionesAdditional(UpdateDetalleConstantesFuncionesAdditional updatedetalleConstantesFuncionesAdditional) {
		try {
			this.updatedetalleConstantesFuncionesAdditional=updatedetalleConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDUPDATE= "id_update";
    public static final String IDANIO= "id_anio";
    public static final String IDMES= "id_mes";
    public static final String CODIGO= "codigo";
    public static final String CODIGOPROCESO= "codigo_proceso";
    public static final String QUERYRESUMEN= "query_resumen";
    public static final String NUMEROINTENTO= "numero_intento";
    public static final String FECHAARCHIVO= "fecha_archivo";
    public static final String FECHA= "fecha";
    public static final String ORDEN= "orden";
    public static final String EJECUTADO= "ejecutado";
    public static final String ESTAACTIVO= "esta_activo";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDUPDATE= "Update";
		public static final String LABEL_IDUPDATE_LOWER= "Update";
    	public static final String LABEL_IDANIO= "Anio";
		public static final String LABEL_IDANIO_LOWER= "Anio";
    	public static final String LABEL_IDMES= "Mes";
		public static final String LABEL_IDMES_LOWER= "Mes";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_CODIGOPROCESO= "Codigo Proceso";
		public static final String LABEL_CODIGOPROCESO_LOWER= "Codigo Proceso";
    	public static final String LABEL_QUERYRESUMEN= "Query Resumen";
		public static final String LABEL_QUERYRESUMEN_LOWER= "Query Resumen";
    	public static final String LABEL_NUMEROINTENTO= "Numero Intento";
		public static final String LABEL_NUMEROINTENTO_LOWER= "Numero Intento";
    	public static final String LABEL_FECHAARCHIVO= "Fecha Archivo";
		public static final String LABEL_FECHAARCHIVO_LOWER= "Fecha Archivo";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_ORDEN= "Orden";
		public static final String LABEL_ORDEN_LOWER= "Orden";
    	public static final String LABEL_EJECUTADO= "Ejecutado";
		public static final String LABEL_EJECUTADO_LOWER= "Ejecutado";
    	public static final String LABEL_ESTAACTIVO= "Esta Activo";
		public static final String LABEL_ESTAACTIVO_LOWER= "Esta Activo";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO_PROCESO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_PROCESO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXQUERY_RESUMEN=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXQUERY_RESUMEN=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getUpdateDetalleLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(UpdateDetalleConstantesFunciones.IDUPDATE)) {sLabelColumna=UpdateDetalleConstantesFunciones.LABEL_IDUPDATE;}
		if(sNombreColumna.equals(UpdateDetalleConstantesFunciones.IDANIO)) {sLabelColumna=UpdateDetalleConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(UpdateDetalleConstantesFunciones.IDMES)) {sLabelColumna=UpdateDetalleConstantesFunciones.LABEL_IDMES;}
		if(sNombreColumna.equals(UpdateDetalleConstantesFunciones.CODIGO)) {sLabelColumna=UpdateDetalleConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(UpdateDetalleConstantesFunciones.CODIGOPROCESO)) {sLabelColumna=UpdateDetalleConstantesFunciones.LABEL_CODIGOPROCESO;}
		if(sNombreColumna.equals(UpdateDetalleConstantesFunciones.QUERYRESUMEN)) {sLabelColumna=UpdateDetalleConstantesFunciones.LABEL_QUERYRESUMEN;}
		if(sNombreColumna.equals(UpdateDetalleConstantesFunciones.NUMEROINTENTO)) {sLabelColumna=UpdateDetalleConstantesFunciones.LABEL_NUMEROINTENTO;}
		if(sNombreColumna.equals(UpdateDetalleConstantesFunciones.FECHAARCHIVO)) {sLabelColumna=UpdateDetalleConstantesFunciones.LABEL_FECHAARCHIVO;}
		if(sNombreColumna.equals(UpdateDetalleConstantesFunciones.FECHA)) {sLabelColumna=UpdateDetalleConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(UpdateDetalleConstantesFunciones.ORDEN)) {sLabelColumna=UpdateDetalleConstantesFunciones.LABEL_ORDEN;}
		if(sNombreColumna.equals(UpdateDetalleConstantesFunciones.EJECUTADO)) {sLabelColumna=UpdateDetalleConstantesFunciones.LABEL_EJECUTADO;}
		if(sNombreColumna.equals(UpdateDetalleConstantesFunciones.ESTAACTIVO)) {sLabelColumna=UpdateDetalleConstantesFunciones.LABEL_ESTAACTIVO;}
		if(sNombreColumna.equals(UpdateDetalleConstantesFunciones.DESCRIPCION)) {sLabelColumna=UpdateDetalleConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getejecutadoDescripcion(UpdateDetalle updatedetalle) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!updatedetalle.getejecutado()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getejecutadoHtmlDescripcion(UpdateDetalle updatedetalle) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(updatedetalle.getId(),updatedetalle.getejecutado());

		return sDescripcion;
	}	
		
	public static String getesta_activoDescripcion(UpdateDetalle updatedetalle) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!updatedetalle.getesta_activo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getesta_activoHtmlDescripcion(UpdateDetalle updatedetalle) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(updatedetalle.getId(),updatedetalle.getesta_activo());

		return sDescripcion;
	}	
			
	
	public static String getUpdateDetalleDescripcion(UpdateDetalle updatedetalle) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(updatedetalle !=null/* && updatedetalle.getId()!=0*/) {
			sDescripcion=updatedetalle.getcodigo();//updatedetalleupdatedetalle.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getUpdateDetalleDescripcionDetallado(UpdateDetalle updatedetalle) {
		String sDescripcion="";
			
		sDescripcion+=UpdateDetalleConstantesFunciones.ID+"=";
		sDescripcion+=updatedetalle.getId().toString()+",";
		sDescripcion+=UpdateDetalleConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=updatedetalle.getVersionRow().toString()+",";
		sDescripcion+=UpdateDetalleConstantesFunciones.IDUPDATE+"=";
		sDescripcion+=updatedetalle.getid_update().toString()+",";
		sDescripcion+=UpdateDetalleConstantesFunciones.IDANIO+"=";
		sDescripcion+=updatedetalle.getid_anio().toString()+",";
		sDescripcion+=UpdateDetalleConstantesFunciones.IDMES+"=";
		sDescripcion+=updatedetalle.getid_mes().toString()+",";
		sDescripcion+=UpdateDetalleConstantesFunciones.CODIGO+"=";
		sDescripcion+=updatedetalle.getcodigo()+",";
		sDescripcion+=UpdateDetalleConstantesFunciones.CODIGOPROCESO+"=";
		sDescripcion+=updatedetalle.getcodigo_proceso()+",";
		sDescripcion+=UpdateDetalleConstantesFunciones.QUERYRESUMEN+"=";
		sDescripcion+=updatedetalle.getquery_resumen()+",";
		sDescripcion+=UpdateDetalleConstantesFunciones.NUMEROINTENTO+"=";
		sDescripcion+=updatedetalle.getnumero_intento().toString()+",";
		sDescripcion+=UpdateDetalleConstantesFunciones.FECHAARCHIVO+"=";
		sDescripcion+=updatedetalle.getfecha_archivo().toString()+",";
		sDescripcion+=UpdateDetalleConstantesFunciones.FECHA+"=";
		sDescripcion+=updatedetalle.getfecha().toString()+",";
		sDescripcion+=UpdateDetalleConstantesFunciones.ORDEN+"=";
		sDescripcion+=updatedetalle.getorden().toString()+",";
		sDescripcion+=UpdateDetalleConstantesFunciones.EJECUTADO+"=";
		sDescripcion+=updatedetalle.getejecutado().toString()+",";
		sDescripcion+=UpdateDetalleConstantesFunciones.ESTAACTIVO+"=";
		sDescripcion+=updatedetalle.getesta_activo().toString()+",";
		sDescripcion+=UpdateDetalleConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=updatedetalle.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setUpdateDetalleDescripcion(UpdateDetalle updatedetalle,String sValor) throws Exception {			
		if(updatedetalle !=null) {
			updatedetalle.setcodigo(sValor);;//updatedetalleupdatedetalle.getcodigo().trim();
		}		
	}
	
		

	public static String getUpdateDescripcion(Update update) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(update!=null/*&&update.getId()>0*/) {
			sDescripcion=UpdateConstantesFunciones.getUpdateDescripcion(update);
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
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdAnio")) {
			sNombreIndice="Tipo=  Por Anio";
		} else if(sNombreIndice.equals("FK_IdMes")) {
			sNombreIndice="Tipo=  Por Mes";
		} else if(sNombreIndice.equals("FK_IdUpdate")) {
			sNombreIndice="Tipo=  Por Update";
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

	public static String getDetalleIndiceFK_IdMes(Long id_mes) {
		String sDetalleIndice=" Parametros->";
		if(id_mes!=null) {sDetalleIndice+=" Codigo Unico De Mes="+id_mes.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdUpdate(Long id_update) {
		String sDetalleIndice=" Parametros->";
		if(id_update!=null) {sDetalleIndice+=" Codigo Unico De Update="+id_update.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosUpdateDetalle(UpdateDetalle updatedetalle,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		updatedetalle.setcodigo(updatedetalle.getcodigo().trim());
		updatedetalle.setcodigo_proceso(updatedetalle.getcodigo_proceso().trim());
		updatedetalle.setquery_resumen(updatedetalle.getquery_resumen().trim());
		updatedetalle.setdescripcion(updatedetalle.getdescripcion().trim());
	}
	
	public static void quitarEspaciosUpdateDetalles(List<UpdateDetalle> updatedetalles,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(UpdateDetalle updatedetalle: updatedetalles) {
			updatedetalle.setcodigo(updatedetalle.getcodigo().trim());
			updatedetalle.setcodigo_proceso(updatedetalle.getcodigo_proceso().trim());
			updatedetalle.setquery_resumen(updatedetalle.getquery_resumen().trim());
			updatedetalle.setdescripcion(updatedetalle.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresUpdateDetalle(UpdateDetalle updatedetalle,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && updatedetalle.getConCambioAuxiliar()) {
			updatedetalle.setIsDeleted(updatedetalle.getIsDeletedAuxiliar());	
			updatedetalle.setIsNew(updatedetalle.getIsNewAuxiliar());	
			updatedetalle.setIsChanged(updatedetalle.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			updatedetalle.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			updatedetalle.setIsDeletedAuxiliar(false);	
			updatedetalle.setIsNewAuxiliar(false);	
			updatedetalle.setIsChangedAuxiliar(false);
			
			updatedetalle.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresUpdateDetalles(List<UpdateDetalle> updatedetalles,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(UpdateDetalle updatedetalle : updatedetalles) {
			if(conAsignarBase && updatedetalle.getConCambioAuxiliar()) {
				updatedetalle.setIsDeleted(updatedetalle.getIsDeletedAuxiliar());	
				updatedetalle.setIsNew(updatedetalle.getIsNewAuxiliar());	
				updatedetalle.setIsChanged(updatedetalle.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				updatedetalle.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				updatedetalle.setIsDeletedAuxiliar(false);	
				updatedetalle.setIsNewAuxiliar(false);	
				updatedetalle.setIsChangedAuxiliar(false);
				
				updatedetalle.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresUpdateDetalle(UpdateDetalle updatedetalle,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
			updatedetalle.setnumero_intento(0);
			updatedetalle.setorden(0);
		}
	}		
	
	public static void InicializarValoresUpdateDetalles(List<UpdateDetalle> updatedetalles,Boolean conEnteros) throws Exception  {
		
		for(UpdateDetalle updatedetalle: updatedetalles) {
		
			if(conEnteros) {
				Short ish_value=0;
				
				updatedetalle.setnumero_intento(0);
				updatedetalle.setorden(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaUpdateDetalle(List<UpdateDetalle> updatedetalles,UpdateDetalle updatedetalleAux) throws Exception  {
		UpdateDetalleConstantesFunciones.InicializarValoresUpdateDetalle(updatedetalleAux,true);
		
		for(UpdateDetalle updatedetalle: updatedetalles) {
			if(updatedetalle.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			updatedetalleAux.setnumero_intento(updatedetalleAux.getnumero_intento()+updatedetalle.getnumero_intento());			
			updatedetalleAux.setorden(updatedetalleAux.getorden()+updatedetalle.getorden());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesUpdateDetalle(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=UpdateDetalleConstantesFunciones.getArrayColumnasGlobalesUpdateDetalle(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesUpdateDetalle(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoUpdateDetalle(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<UpdateDetalle> updatedetalles,UpdateDetalle updatedetalle,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(UpdateDetalle updatedetalleAux: updatedetalles) {
			if(updatedetalleAux!=null && updatedetalle!=null) {
				if((updatedetalleAux.getId()==null && updatedetalle.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(updatedetalleAux.getId()!=null && updatedetalle.getId()!=null){
					if(updatedetalleAux.getId().equals(updatedetalle.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaUpdateDetalle(List<UpdateDetalle> updatedetalles) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(UpdateDetalle updatedetalle: updatedetalles) {			
			if(updatedetalle.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaUpdateDetalle() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,UpdateDetalleConstantesFunciones.LABEL_ID, UpdateDetalleConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UpdateDetalleConstantesFunciones.LABEL_VERSIONROW, UpdateDetalleConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UpdateDetalleConstantesFunciones.LABEL_IDUPDATE, UpdateDetalleConstantesFunciones.IDUPDATE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UpdateDetalleConstantesFunciones.LABEL_IDANIO, UpdateDetalleConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UpdateDetalleConstantesFunciones.LABEL_IDMES, UpdateDetalleConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UpdateDetalleConstantesFunciones.LABEL_CODIGO, UpdateDetalleConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UpdateDetalleConstantesFunciones.LABEL_CODIGOPROCESO, UpdateDetalleConstantesFunciones.CODIGOPROCESO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UpdateDetalleConstantesFunciones.LABEL_QUERYRESUMEN, UpdateDetalleConstantesFunciones.QUERYRESUMEN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UpdateDetalleConstantesFunciones.LABEL_NUMEROINTENTO, UpdateDetalleConstantesFunciones.NUMEROINTENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UpdateDetalleConstantesFunciones.LABEL_FECHAARCHIVO, UpdateDetalleConstantesFunciones.FECHAARCHIVO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UpdateDetalleConstantesFunciones.LABEL_FECHA, UpdateDetalleConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UpdateDetalleConstantesFunciones.LABEL_ORDEN, UpdateDetalleConstantesFunciones.ORDEN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UpdateDetalleConstantesFunciones.LABEL_EJECUTADO, UpdateDetalleConstantesFunciones.EJECUTADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UpdateDetalleConstantesFunciones.LABEL_ESTAACTIVO, UpdateDetalleConstantesFunciones.ESTAACTIVO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UpdateDetalleConstantesFunciones.LABEL_DESCRIPCION, UpdateDetalleConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasUpdateDetalle() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=UpdateDetalleConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UpdateDetalleConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UpdateDetalleConstantesFunciones.IDUPDATE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UpdateDetalleConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UpdateDetalleConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UpdateDetalleConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UpdateDetalleConstantesFunciones.CODIGOPROCESO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UpdateDetalleConstantesFunciones.QUERYRESUMEN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UpdateDetalleConstantesFunciones.NUMEROINTENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UpdateDetalleConstantesFunciones.FECHAARCHIVO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UpdateDetalleConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UpdateDetalleConstantesFunciones.ORDEN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UpdateDetalleConstantesFunciones.EJECUTADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UpdateDetalleConstantesFunciones.ESTAACTIVO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UpdateDetalleConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarUpdateDetalle() throws Exception  {
		return UpdateDetalleConstantesFunciones.getTiposSeleccionarUpdateDetalle(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarUpdateDetalle(Boolean conFk) throws Exception  {
		return UpdateDetalleConstantesFunciones.getTiposSeleccionarUpdateDetalle(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarUpdateDetalle(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(UpdateDetalleConstantesFunciones.LABEL_IDUPDATE);
			reporte.setsDescripcion(UpdateDetalleConstantesFunciones.LABEL_IDUPDATE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(UpdateDetalleConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(UpdateDetalleConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(UpdateDetalleConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(UpdateDetalleConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(UpdateDetalleConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(UpdateDetalleConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(UpdateDetalleConstantesFunciones.LABEL_CODIGOPROCESO);
			reporte.setsDescripcion(UpdateDetalleConstantesFunciones.LABEL_CODIGOPROCESO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(UpdateDetalleConstantesFunciones.LABEL_QUERYRESUMEN);
			reporte.setsDescripcion(UpdateDetalleConstantesFunciones.LABEL_QUERYRESUMEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(UpdateDetalleConstantesFunciones.LABEL_NUMEROINTENTO);
			reporte.setsDescripcion(UpdateDetalleConstantesFunciones.LABEL_NUMEROINTENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(UpdateDetalleConstantesFunciones.LABEL_FECHAARCHIVO);
			reporte.setsDescripcion(UpdateDetalleConstantesFunciones.LABEL_FECHAARCHIVO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(UpdateDetalleConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(UpdateDetalleConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(UpdateDetalleConstantesFunciones.LABEL_ORDEN);
			reporte.setsDescripcion(UpdateDetalleConstantesFunciones.LABEL_ORDEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(UpdateDetalleConstantesFunciones.LABEL_EJECUTADO);
			reporte.setsDescripcion(UpdateDetalleConstantesFunciones.LABEL_EJECUTADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(UpdateDetalleConstantesFunciones.LABEL_ESTAACTIVO);
			reporte.setsDescripcion(UpdateDetalleConstantesFunciones.LABEL_ESTAACTIVO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(UpdateDetalleConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(UpdateDetalleConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesUpdateDetalle(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesUpdateDetalle(UpdateDetalle updatedetalleAux) throws Exception {
		
			updatedetalleAux.setupdate_descripcion(UpdateConstantesFunciones.getUpdateDescripcion(updatedetalleAux.getUpdate()));
			updatedetalleAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(updatedetalleAux.getAnio()));
			updatedetalleAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(updatedetalleAux.getMes()));		
	}
	
	public static void refrescarForeignKeysDescripcionesUpdateDetalle(List<UpdateDetalle> updatedetallesTemp) throws Exception {
		for(UpdateDetalle updatedetalleAux:updatedetallesTemp) {
			
			updatedetalleAux.setupdate_descripcion(UpdateConstantesFunciones.getUpdateDescripcion(updatedetalleAux.getUpdate()));
			updatedetalleAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(updatedetalleAux.getAnio()));
			updatedetalleAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(updatedetalleAux.getMes()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfUpdateDetalle(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Update.class));
				classes.add(new Classe(Anio.class));
				classes.add(new Classe(Mes.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Update.class)) {
						classes.add(new Classe(Update.class));
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

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfUpdateDetalle(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Update.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Update.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Update.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Update.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfUpdateDetalle(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return UpdateDetalleConstantesFunciones.getClassesRelationshipsOfUpdateDetalle(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfUpdateDetalle(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfUpdateDetalle(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return UpdateDetalleConstantesFunciones.getClassesRelationshipsFromStringsOfUpdateDetalle(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfUpdateDetalle(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(UpdateDetalle updatedetalle,List<UpdateDetalle> updatedetalles,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			UpdateDetalle updatedetalleEncontrado=null;
			
			for(UpdateDetalle updatedetalleLocal:updatedetalles) {
				if(updatedetalleLocal.getId().equals(updatedetalle.getId())) {
					updatedetalleEncontrado=updatedetalleLocal;
					
					updatedetalleLocal.setIsChanged(updatedetalle.getIsChanged());
					updatedetalleLocal.setIsNew(updatedetalle.getIsNew());
					updatedetalleLocal.setIsDeleted(updatedetalle.getIsDeleted());
					
					updatedetalleLocal.setGeneralEntityOriginal(updatedetalle.getGeneralEntityOriginal());
					
					updatedetalleLocal.setId(updatedetalle.getId());	
					updatedetalleLocal.setVersionRow(updatedetalle.getVersionRow());	
					updatedetalleLocal.setid_update(updatedetalle.getid_update());	
					updatedetalleLocal.setid_anio(updatedetalle.getid_anio());	
					updatedetalleLocal.setid_mes(updatedetalle.getid_mes());	
					updatedetalleLocal.setcodigo(updatedetalle.getcodigo());	
					updatedetalleLocal.setcodigo_proceso(updatedetalle.getcodigo_proceso());	
					updatedetalleLocal.setquery_resumen(updatedetalle.getquery_resumen());	
					updatedetalleLocal.setnumero_intento(updatedetalle.getnumero_intento());	
					updatedetalleLocal.setfecha_archivo(updatedetalle.getfecha_archivo());	
					updatedetalleLocal.setfecha(updatedetalle.getfecha());	
					updatedetalleLocal.setorden(updatedetalle.getorden());	
					updatedetalleLocal.setejecutado(updatedetalle.getejecutado());	
					updatedetalleLocal.setesta_activo(updatedetalle.getesta_activo());	
					updatedetalleLocal.setdescripcion(updatedetalle.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!updatedetalle.getIsDeleted()) {
				if(!existe) {
					updatedetalles.add(updatedetalle);
				}
			} else {
				if(updatedetalleEncontrado!=null && permiteQuitar)  {
					updatedetalles.remove(updatedetalleEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(UpdateDetalle updatedetalle,List<UpdateDetalle> updatedetalles) throws Exception {
		try	{			
			for(UpdateDetalle updatedetalleLocal:updatedetalles) {
				if(updatedetalleLocal.getId().equals(updatedetalle.getId())) {
					updatedetalleLocal.setIsSelected(updatedetalle.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesUpdateDetalle(List<UpdateDetalle> updatedetallesAux) throws Exception {
		//this.updatedetallesAux=updatedetallesAux;
		
		for(UpdateDetalle updatedetalleAux:updatedetallesAux) {
			if(updatedetalleAux.getIsChanged()) {
				updatedetalleAux.setIsChanged(false);
			}		
			
			if(updatedetalleAux.getIsNew()) {
				updatedetalleAux.setIsNew(false);
			}	
			
			if(updatedetalleAux.getIsDeleted()) {
				updatedetalleAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesUpdateDetalle(UpdateDetalle updatedetalleAux) throws Exception {
		//this.updatedetalleAux=updatedetalleAux;
		
			if(updatedetalleAux.getIsChanged()) {
				updatedetalleAux.setIsChanged(false);
			}		
			
			if(updatedetalleAux.getIsNew()) {
				updatedetalleAux.setIsNew(false);
			}	
			
			if(updatedetalleAux.getIsDeleted()) {
				updatedetalleAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(UpdateDetalle updatedetalleAsignar,UpdateDetalle updatedetalle) throws Exception {
		updatedetalleAsignar.setId(updatedetalle.getId());	
		updatedetalleAsignar.setVersionRow(updatedetalle.getVersionRow());	
		updatedetalleAsignar.setid_update(updatedetalle.getid_update());
		updatedetalleAsignar.setupdate_descripcion(updatedetalle.getupdate_descripcion());	
		updatedetalleAsignar.setid_anio(updatedetalle.getid_anio());
		updatedetalleAsignar.setanio_descripcion(updatedetalle.getanio_descripcion());	
		updatedetalleAsignar.setid_mes(updatedetalle.getid_mes());
		updatedetalleAsignar.setmes_descripcion(updatedetalle.getmes_descripcion());	
		updatedetalleAsignar.setcodigo(updatedetalle.getcodigo());	
		updatedetalleAsignar.setcodigo_proceso(updatedetalle.getcodigo_proceso());	
		updatedetalleAsignar.setquery_resumen(updatedetalle.getquery_resumen());	
		updatedetalleAsignar.setnumero_intento(updatedetalle.getnumero_intento());	
		updatedetalleAsignar.setfecha_archivo(updatedetalle.getfecha_archivo());	
		updatedetalleAsignar.setfecha(updatedetalle.getfecha());	
		updatedetalleAsignar.setorden(updatedetalle.getorden());	
		updatedetalleAsignar.setejecutado(updatedetalle.getejecutado());	
		updatedetalleAsignar.setesta_activo(updatedetalle.getesta_activo());	
		updatedetalleAsignar.setdescripcion(updatedetalle.getdescripcion());	
	}
	
	public static void inicializarUpdateDetalle(UpdateDetalle updatedetalle) throws Exception {
		try {
				updatedetalle.setId(0L);	
					
				updatedetalle.setid_update(-1L);	
				updatedetalle.setid_anio(null);	
				updatedetalle.setid_mes(null);	
				updatedetalle.setcodigo("");	
				updatedetalle.setcodigo_proceso("");	
				updatedetalle.setquery_resumen("");	
				updatedetalle.setnumero_intento(0);	
				updatedetalle.setfecha_archivo(new Date());	
				updatedetalle.setfecha(new Date());	
				updatedetalle.setorden(0);	
				updatedetalle.setejecutado(false);	
				updatedetalle.setesta_activo(false);	
				updatedetalle.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderUpdateDetalle(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(UpdateDetalleConstantesFunciones.LABEL_IDUPDATE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UpdateDetalleConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UpdateDetalleConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UpdateDetalleConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UpdateDetalleConstantesFunciones.LABEL_CODIGOPROCESO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UpdateDetalleConstantesFunciones.LABEL_QUERYRESUMEN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UpdateDetalleConstantesFunciones.LABEL_NUMEROINTENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UpdateDetalleConstantesFunciones.LABEL_FECHAARCHIVO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UpdateDetalleConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UpdateDetalleConstantesFunciones.LABEL_ORDEN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UpdateDetalleConstantesFunciones.LABEL_EJECUTADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UpdateDetalleConstantesFunciones.LABEL_ESTAACTIVO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UpdateDetalleConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataUpdateDetalle(String sTipo,Row row,Workbook workbook,UpdateDetalle updatedetalle,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(updatedetalle.getupdate_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(updatedetalle.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(updatedetalle.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(updatedetalle.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(updatedetalle.getcodigo_proceso());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(updatedetalle.getquery_resumen());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(updatedetalle.getnumero_intento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(updatedetalle.getfecha_archivo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(updatedetalle.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(updatedetalle.getorden());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(updatedetalle.getejecutado()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(updatedetalle.getesta_activo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(updatedetalle.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryUpdateDetalle=Constantes.SFINALQUERY;
	
	public String getsFinalQueryUpdateDetalle() {
		return this.sFinalQueryUpdateDetalle;
	}
	
	public void setsFinalQueryUpdateDetalle(String sFinalQueryUpdateDetalle) {
		this.sFinalQueryUpdateDetalle= sFinalQueryUpdateDetalle;
	}
	
	public Border resaltarSeleccionarUpdateDetalle=null;
	
	public Border setResaltarSeleccionarUpdateDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*UpdateDetalleBeanSwingJInternalFrame updatedetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//updatedetalleBeanSwingJInternalFrame.jTtoolBarUpdateDetalle.setBorder(borderResaltar);
		
		this.resaltarSeleccionarUpdateDetalle= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarUpdateDetalle() {
		return this.resaltarSeleccionarUpdateDetalle;
	}
	
	public void setResaltarSeleccionarUpdateDetalle(Border borderResaltarSeleccionarUpdateDetalle) {
		this.resaltarSeleccionarUpdateDetalle= borderResaltarSeleccionarUpdateDetalle;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridUpdateDetalle=null;
	public Boolean mostraridUpdateDetalle=true;
	public Boolean activaridUpdateDetalle=true;

	public Border resaltarid_updateUpdateDetalle=null;
	public Boolean mostrarid_updateUpdateDetalle=true;
	public Boolean activarid_updateUpdateDetalle=true;
	public Boolean cargarid_updateUpdateDetalle=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_updateUpdateDetalle=false;//ConEventDepend=true

	public Border resaltarid_anioUpdateDetalle=null;
	public Boolean mostrarid_anioUpdateDetalle=true;
	public Boolean activarid_anioUpdateDetalle=true;
	public Boolean cargarid_anioUpdateDetalle=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioUpdateDetalle=false;//ConEventDepend=true

	public Border resaltarid_mesUpdateDetalle=null;
	public Boolean mostrarid_mesUpdateDetalle=true;
	public Boolean activarid_mesUpdateDetalle=true;
	public Boolean cargarid_mesUpdateDetalle=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesUpdateDetalle=false;//ConEventDepend=true

	public Border resaltarcodigoUpdateDetalle=null;
	public Boolean mostrarcodigoUpdateDetalle=true;
	public Boolean activarcodigoUpdateDetalle=true;

	public Border resaltarcodigo_procesoUpdateDetalle=null;
	public Boolean mostrarcodigo_procesoUpdateDetalle=true;
	public Boolean activarcodigo_procesoUpdateDetalle=true;

	public Border resaltarquery_resumenUpdateDetalle=null;
	public Boolean mostrarquery_resumenUpdateDetalle=true;
	public Boolean activarquery_resumenUpdateDetalle=true;

	public Border resaltarnumero_intentoUpdateDetalle=null;
	public Boolean mostrarnumero_intentoUpdateDetalle=true;
	public Boolean activarnumero_intentoUpdateDetalle=true;

	public Border resaltarfecha_archivoUpdateDetalle=null;
	public Boolean mostrarfecha_archivoUpdateDetalle=true;
	public Boolean activarfecha_archivoUpdateDetalle=false;

	public Border resaltarfechaUpdateDetalle=null;
	public Boolean mostrarfechaUpdateDetalle=true;
	public Boolean activarfechaUpdateDetalle=false;

	public Border resaltarordenUpdateDetalle=null;
	public Boolean mostrarordenUpdateDetalle=true;
	public Boolean activarordenUpdateDetalle=true;

	public Border resaltarejecutadoUpdateDetalle=null;
	public Boolean mostrarejecutadoUpdateDetalle=true;
	public Boolean activarejecutadoUpdateDetalle=true;

	public Border resaltaresta_activoUpdateDetalle=null;
	public Boolean mostraresta_activoUpdateDetalle=true;
	public Boolean activaresta_activoUpdateDetalle=true;

	public Border resaltardescripcionUpdateDetalle=null;
	public Boolean mostrardescripcionUpdateDetalle=true;
	public Boolean activardescripcionUpdateDetalle=true;

	
	

	public Border setResaltaridUpdateDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*UpdateDetalleBeanSwingJInternalFrame updatedetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//updatedetalleBeanSwingJInternalFrame.jTtoolBarUpdateDetalle.setBorder(borderResaltar);
		
		this.resaltaridUpdateDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridUpdateDetalle() {
		return this.resaltaridUpdateDetalle;
	}

	public void setResaltaridUpdateDetalle(Border borderResaltar) {
		this.resaltaridUpdateDetalle= borderResaltar;
	}

	public Boolean getMostraridUpdateDetalle() {
		return this.mostraridUpdateDetalle;
	}

	public void setMostraridUpdateDetalle(Boolean mostraridUpdateDetalle) {
		this.mostraridUpdateDetalle= mostraridUpdateDetalle;
	}

	public Boolean getActivaridUpdateDetalle() {
		return this.activaridUpdateDetalle;
	}

	public void setActivaridUpdateDetalle(Boolean activaridUpdateDetalle) {
		this.activaridUpdateDetalle= activaridUpdateDetalle;
	}

	public Border setResaltarid_updateUpdateDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*UpdateDetalleBeanSwingJInternalFrame updatedetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//updatedetalleBeanSwingJInternalFrame.jTtoolBarUpdateDetalle.setBorder(borderResaltar);
		
		this.resaltarid_updateUpdateDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_updateUpdateDetalle() {
		return this.resaltarid_updateUpdateDetalle;
	}

	public void setResaltarid_updateUpdateDetalle(Border borderResaltar) {
		this.resaltarid_updateUpdateDetalle= borderResaltar;
	}

	public Boolean getMostrarid_updateUpdateDetalle() {
		return this.mostrarid_updateUpdateDetalle;
	}

	public void setMostrarid_updateUpdateDetalle(Boolean mostrarid_updateUpdateDetalle) {
		this.mostrarid_updateUpdateDetalle= mostrarid_updateUpdateDetalle;
	}

	public Boolean getActivarid_updateUpdateDetalle() {
		return this.activarid_updateUpdateDetalle;
	}

	public void setActivarid_updateUpdateDetalle(Boolean activarid_updateUpdateDetalle) {
		this.activarid_updateUpdateDetalle= activarid_updateUpdateDetalle;
	}

	public Boolean getCargarid_updateUpdateDetalle() {
		return this.cargarid_updateUpdateDetalle;
	}

	public void setCargarid_updateUpdateDetalle(Boolean cargarid_updateUpdateDetalle) {
		this.cargarid_updateUpdateDetalle= cargarid_updateUpdateDetalle;
	}

	public Border setResaltarid_anioUpdateDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*UpdateDetalleBeanSwingJInternalFrame updatedetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//updatedetalleBeanSwingJInternalFrame.jTtoolBarUpdateDetalle.setBorder(borderResaltar);
		
		this.resaltarid_anioUpdateDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioUpdateDetalle() {
		return this.resaltarid_anioUpdateDetalle;
	}

	public void setResaltarid_anioUpdateDetalle(Border borderResaltar) {
		this.resaltarid_anioUpdateDetalle= borderResaltar;
	}

	public Boolean getMostrarid_anioUpdateDetalle() {
		return this.mostrarid_anioUpdateDetalle;
	}

	public void setMostrarid_anioUpdateDetalle(Boolean mostrarid_anioUpdateDetalle) {
		this.mostrarid_anioUpdateDetalle= mostrarid_anioUpdateDetalle;
	}

	public Boolean getActivarid_anioUpdateDetalle() {
		return this.activarid_anioUpdateDetalle;
	}

	public void setActivarid_anioUpdateDetalle(Boolean activarid_anioUpdateDetalle) {
		this.activarid_anioUpdateDetalle= activarid_anioUpdateDetalle;
	}

	public Boolean getCargarid_anioUpdateDetalle() {
		return this.cargarid_anioUpdateDetalle;
	}

	public void setCargarid_anioUpdateDetalle(Boolean cargarid_anioUpdateDetalle) {
		this.cargarid_anioUpdateDetalle= cargarid_anioUpdateDetalle;
	}

	public Border setResaltarid_mesUpdateDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*UpdateDetalleBeanSwingJInternalFrame updatedetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//updatedetalleBeanSwingJInternalFrame.jTtoolBarUpdateDetalle.setBorder(borderResaltar);
		
		this.resaltarid_mesUpdateDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesUpdateDetalle() {
		return this.resaltarid_mesUpdateDetalle;
	}

	public void setResaltarid_mesUpdateDetalle(Border borderResaltar) {
		this.resaltarid_mesUpdateDetalle= borderResaltar;
	}

	public Boolean getMostrarid_mesUpdateDetalle() {
		return this.mostrarid_mesUpdateDetalle;
	}

	public void setMostrarid_mesUpdateDetalle(Boolean mostrarid_mesUpdateDetalle) {
		this.mostrarid_mesUpdateDetalle= mostrarid_mesUpdateDetalle;
	}

	public Boolean getActivarid_mesUpdateDetalle() {
		return this.activarid_mesUpdateDetalle;
	}

	public void setActivarid_mesUpdateDetalle(Boolean activarid_mesUpdateDetalle) {
		this.activarid_mesUpdateDetalle= activarid_mesUpdateDetalle;
	}

	public Boolean getCargarid_mesUpdateDetalle() {
		return this.cargarid_mesUpdateDetalle;
	}

	public void setCargarid_mesUpdateDetalle(Boolean cargarid_mesUpdateDetalle) {
		this.cargarid_mesUpdateDetalle= cargarid_mesUpdateDetalle;
	}

	public Border setResaltarcodigoUpdateDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*UpdateDetalleBeanSwingJInternalFrame updatedetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//updatedetalleBeanSwingJInternalFrame.jTtoolBarUpdateDetalle.setBorder(borderResaltar);
		
		this.resaltarcodigoUpdateDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoUpdateDetalle() {
		return this.resaltarcodigoUpdateDetalle;
	}

	public void setResaltarcodigoUpdateDetalle(Border borderResaltar) {
		this.resaltarcodigoUpdateDetalle= borderResaltar;
	}

	public Boolean getMostrarcodigoUpdateDetalle() {
		return this.mostrarcodigoUpdateDetalle;
	}

	public void setMostrarcodigoUpdateDetalle(Boolean mostrarcodigoUpdateDetalle) {
		this.mostrarcodigoUpdateDetalle= mostrarcodigoUpdateDetalle;
	}

	public Boolean getActivarcodigoUpdateDetalle() {
		return this.activarcodigoUpdateDetalle;
	}

	public void setActivarcodigoUpdateDetalle(Boolean activarcodigoUpdateDetalle) {
		this.activarcodigoUpdateDetalle= activarcodigoUpdateDetalle;
	}

	public Border setResaltarcodigo_procesoUpdateDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*UpdateDetalleBeanSwingJInternalFrame updatedetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//updatedetalleBeanSwingJInternalFrame.jTtoolBarUpdateDetalle.setBorder(borderResaltar);
		
		this.resaltarcodigo_procesoUpdateDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_procesoUpdateDetalle() {
		return this.resaltarcodigo_procesoUpdateDetalle;
	}

	public void setResaltarcodigo_procesoUpdateDetalle(Border borderResaltar) {
		this.resaltarcodigo_procesoUpdateDetalle= borderResaltar;
	}

	public Boolean getMostrarcodigo_procesoUpdateDetalle() {
		return this.mostrarcodigo_procesoUpdateDetalle;
	}

	public void setMostrarcodigo_procesoUpdateDetalle(Boolean mostrarcodigo_procesoUpdateDetalle) {
		this.mostrarcodigo_procesoUpdateDetalle= mostrarcodigo_procesoUpdateDetalle;
	}

	public Boolean getActivarcodigo_procesoUpdateDetalle() {
		return this.activarcodigo_procesoUpdateDetalle;
	}

	public void setActivarcodigo_procesoUpdateDetalle(Boolean activarcodigo_procesoUpdateDetalle) {
		this.activarcodigo_procesoUpdateDetalle= activarcodigo_procesoUpdateDetalle;
	}

	public Border setResaltarquery_resumenUpdateDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*UpdateDetalleBeanSwingJInternalFrame updatedetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//updatedetalleBeanSwingJInternalFrame.jTtoolBarUpdateDetalle.setBorder(borderResaltar);
		
		this.resaltarquery_resumenUpdateDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarquery_resumenUpdateDetalle() {
		return this.resaltarquery_resumenUpdateDetalle;
	}

	public void setResaltarquery_resumenUpdateDetalle(Border borderResaltar) {
		this.resaltarquery_resumenUpdateDetalle= borderResaltar;
	}

	public Boolean getMostrarquery_resumenUpdateDetalle() {
		return this.mostrarquery_resumenUpdateDetalle;
	}

	public void setMostrarquery_resumenUpdateDetalle(Boolean mostrarquery_resumenUpdateDetalle) {
		this.mostrarquery_resumenUpdateDetalle= mostrarquery_resumenUpdateDetalle;
	}

	public Boolean getActivarquery_resumenUpdateDetalle() {
		return this.activarquery_resumenUpdateDetalle;
	}

	public void setActivarquery_resumenUpdateDetalle(Boolean activarquery_resumenUpdateDetalle) {
		this.activarquery_resumenUpdateDetalle= activarquery_resumenUpdateDetalle;
	}

	public Border setResaltarnumero_intentoUpdateDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*UpdateDetalleBeanSwingJInternalFrame updatedetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//updatedetalleBeanSwingJInternalFrame.jTtoolBarUpdateDetalle.setBorder(borderResaltar);
		
		this.resaltarnumero_intentoUpdateDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_intentoUpdateDetalle() {
		return this.resaltarnumero_intentoUpdateDetalle;
	}

	public void setResaltarnumero_intentoUpdateDetalle(Border borderResaltar) {
		this.resaltarnumero_intentoUpdateDetalle= borderResaltar;
	}

	public Boolean getMostrarnumero_intentoUpdateDetalle() {
		return this.mostrarnumero_intentoUpdateDetalle;
	}

	public void setMostrarnumero_intentoUpdateDetalle(Boolean mostrarnumero_intentoUpdateDetalle) {
		this.mostrarnumero_intentoUpdateDetalle= mostrarnumero_intentoUpdateDetalle;
	}

	public Boolean getActivarnumero_intentoUpdateDetalle() {
		return this.activarnumero_intentoUpdateDetalle;
	}

	public void setActivarnumero_intentoUpdateDetalle(Boolean activarnumero_intentoUpdateDetalle) {
		this.activarnumero_intentoUpdateDetalle= activarnumero_intentoUpdateDetalle;
	}

	public Border setResaltarfecha_archivoUpdateDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*UpdateDetalleBeanSwingJInternalFrame updatedetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//updatedetalleBeanSwingJInternalFrame.jTtoolBarUpdateDetalle.setBorder(borderResaltar);
		
		this.resaltarfecha_archivoUpdateDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_archivoUpdateDetalle() {
		return this.resaltarfecha_archivoUpdateDetalle;
	}

	public void setResaltarfecha_archivoUpdateDetalle(Border borderResaltar) {
		this.resaltarfecha_archivoUpdateDetalle= borderResaltar;
	}

	public Boolean getMostrarfecha_archivoUpdateDetalle() {
		return this.mostrarfecha_archivoUpdateDetalle;
	}

	public void setMostrarfecha_archivoUpdateDetalle(Boolean mostrarfecha_archivoUpdateDetalle) {
		this.mostrarfecha_archivoUpdateDetalle= mostrarfecha_archivoUpdateDetalle;
	}

	public Boolean getActivarfecha_archivoUpdateDetalle() {
		return this.activarfecha_archivoUpdateDetalle;
	}

	public void setActivarfecha_archivoUpdateDetalle(Boolean activarfecha_archivoUpdateDetalle) {
		this.activarfecha_archivoUpdateDetalle= activarfecha_archivoUpdateDetalle;
	}

	public Border setResaltarfechaUpdateDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*UpdateDetalleBeanSwingJInternalFrame updatedetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//updatedetalleBeanSwingJInternalFrame.jTtoolBarUpdateDetalle.setBorder(borderResaltar);
		
		this.resaltarfechaUpdateDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaUpdateDetalle() {
		return this.resaltarfechaUpdateDetalle;
	}

	public void setResaltarfechaUpdateDetalle(Border borderResaltar) {
		this.resaltarfechaUpdateDetalle= borderResaltar;
	}

	public Boolean getMostrarfechaUpdateDetalle() {
		return this.mostrarfechaUpdateDetalle;
	}

	public void setMostrarfechaUpdateDetalle(Boolean mostrarfechaUpdateDetalle) {
		this.mostrarfechaUpdateDetalle= mostrarfechaUpdateDetalle;
	}

	public Boolean getActivarfechaUpdateDetalle() {
		return this.activarfechaUpdateDetalle;
	}

	public void setActivarfechaUpdateDetalle(Boolean activarfechaUpdateDetalle) {
		this.activarfechaUpdateDetalle= activarfechaUpdateDetalle;
	}

	public Border setResaltarordenUpdateDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*UpdateDetalleBeanSwingJInternalFrame updatedetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//updatedetalleBeanSwingJInternalFrame.jTtoolBarUpdateDetalle.setBorder(borderResaltar);
		
		this.resaltarordenUpdateDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarordenUpdateDetalle() {
		return this.resaltarordenUpdateDetalle;
	}

	public void setResaltarordenUpdateDetalle(Border borderResaltar) {
		this.resaltarordenUpdateDetalle= borderResaltar;
	}

	public Boolean getMostrarordenUpdateDetalle() {
		return this.mostrarordenUpdateDetalle;
	}

	public void setMostrarordenUpdateDetalle(Boolean mostrarordenUpdateDetalle) {
		this.mostrarordenUpdateDetalle= mostrarordenUpdateDetalle;
	}

	public Boolean getActivarordenUpdateDetalle() {
		return this.activarordenUpdateDetalle;
	}

	public void setActivarordenUpdateDetalle(Boolean activarordenUpdateDetalle) {
		this.activarordenUpdateDetalle= activarordenUpdateDetalle;
	}

	public Border setResaltarejecutadoUpdateDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*UpdateDetalleBeanSwingJInternalFrame updatedetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//updatedetalleBeanSwingJInternalFrame.jTtoolBarUpdateDetalle.setBorder(borderResaltar);
		
		this.resaltarejecutadoUpdateDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarejecutadoUpdateDetalle() {
		return this.resaltarejecutadoUpdateDetalle;
	}

	public void setResaltarejecutadoUpdateDetalle(Border borderResaltar) {
		this.resaltarejecutadoUpdateDetalle= borderResaltar;
	}

	public Boolean getMostrarejecutadoUpdateDetalle() {
		return this.mostrarejecutadoUpdateDetalle;
	}

	public void setMostrarejecutadoUpdateDetalle(Boolean mostrarejecutadoUpdateDetalle) {
		this.mostrarejecutadoUpdateDetalle= mostrarejecutadoUpdateDetalle;
	}

	public Boolean getActivarejecutadoUpdateDetalle() {
		return this.activarejecutadoUpdateDetalle;
	}

	public void setActivarejecutadoUpdateDetalle(Boolean activarejecutadoUpdateDetalle) {
		this.activarejecutadoUpdateDetalle= activarejecutadoUpdateDetalle;
	}

	public Border setResaltaresta_activoUpdateDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*UpdateDetalleBeanSwingJInternalFrame updatedetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//updatedetalleBeanSwingJInternalFrame.jTtoolBarUpdateDetalle.setBorder(borderResaltar);
		
		this.resaltaresta_activoUpdateDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaresta_activoUpdateDetalle() {
		return this.resaltaresta_activoUpdateDetalle;
	}

	public void setResaltaresta_activoUpdateDetalle(Border borderResaltar) {
		this.resaltaresta_activoUpdateDetalle= borderResaltar;
	}

	public Boolean getMostraresta_activoUpdateDetalle() {
		return this.mostraresta_activoUpdateDetalle;
	}

	public void setMostraresta_activoUpdateDetalle(Boolean mostraresta_activoUpdateDetalle) {
		this.mostraresta_activoUpdateDetalle= mostraresta_activoUpdateDetalle;
	}

	public Boolean getActivaresta_activoUpdateDetalle() {
		return this.activaresta_activoUpdateDetalle;
	}

	public void setActivaresta_activoUpdateDetalle(Boolean activaresta_activoUpdateDetalle) {
		this.activaresta_activoUpdateDetalle= activaresta_activoUpdateDetalle;
	}

	public Border setResaltardescripcionUpdateDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*UpdateDetalleBeanSwingJInternalFrame updatedetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//updatedetalleBeanSwingJInternalFrame.jTtoolBarUpdateDetalle.setBorder(borderResaltar);
		
		this.resaltardescripcionUpdateDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionUpdateDetalle() {
		return this.resaltardescripcionUpdateDetalle;
	}

	public void setResaltardescripcionUpdateDetalle(Border borderResaltar) {
		this.resaltardescripcionUpdateDetalle= borderResaltar;
	}

	public Boolean getMostrardescripcionUpdateDetalle() {
		return this.mostrardescripcionUpdateDetalle;
	}

	public void setMostrardescripcionUpdateDetalle(Boolean mostrardescripcionUpdateDetalle) {
		this.mostrardescripcionUpdateDetalle= mostrardescripcionUpdateDetalle;
	}

	public Boolean getActivardescripcionUpdateDetalle() {
		return this.activardescripcionUpdateDetalle;
	}

	public void setActivardescripcionUpdateDetalle(Boolean activardescripcionUpdateDetalle) {
		this.activardescripcionUpdateDetalle= activardescripcionUpdateDetalle;
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
		
		
		this.setMostraridUpdateDetalle(esInicial);
		this.setMostrarid_updateUpdateDetalle(esInicial);
		this.setMostrarid_anioUpdateDetalle(esInicial);
		this.setMostrarid_mesUpdateDetalle(esInicial);
		this.setMostrarcodigoUpdateDetalle(esInicial);
		this.setMostrarcodigo_procesoUpdateDetalle(esInicial);
		this.setMostrarquery_resumenUpdateDetalle(esInicial);
		this.setMostrarnumero_intentoUpdateDetalle(esInicial);
		this.setMostrarfecha_archivoUpdateDetalle(esInicial);
		this.setMostrarfechaUpdateDetalle(esInicial);
		this.setMostrarordenUpdateDetalle(esInicial);
		this.setMostrarejecutadoUpdateDetalle(esInicial);
		this.setMostraresta_activoUpdateDetalle(esInicial);
		this.setMostrardescripcionUpdateDetalle(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(UpdateDetalleConstantesFunciones.ID)) {
				this.setMostraridUpdateDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(UpdateDetalleConstantesFunciones.IDUPDATE)) {
				this.setMostrarid_updateUpdateDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(UpdateDetalleConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioUpdateDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(UpdateDetalleConstantesFunciones.IDMES)) {
				this.setMostrarid_mesUpdateDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(UpdateDetalleConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoUpdateDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(UpdateDetalleConstantesFunciones.CODIGOPROCESO)) {
				this.setMostrarcodigo_procesoUpdateDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(UpdateDetalleConstantesFunciones.QUERYRESUMEN)) {
				this.setMostrarquery_resumenUpdateDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(UpdateDetalleConstantesFunciones.NUMEROINTENTO)) {
				this.setMostrarnumero_intentoUpdateDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(UpdateDetalleConstantesFunciones.FECHAARCHIVO)) {
				this.setMostrarfecha_archivoUpdateDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(UpdateDetalleConstantesFunciones.FECHA)) {
				this.setMostrarfechaUpdateDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(UpdateDetalleConstantesFunciones.ORDEN)) {
				this.setMostrarordenUpdateDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(UpdateDetalleConstantesFunciones.EJECUTADO)) {
				this.setMostrarejecutadoUpdateDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(UpdateDetalleConstantesFunciones.ESTAACTIVO)) {
				this.setMostraresta_activoUpdateDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(UpdateDetalleConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionUpdateDetalle(esAsigna);
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
		
		
		this.setActivaridUpdateDetalle(esInicial);
		this.setActivarid_updateUpdateDetalle(esInicial);
		this.setActivarid_anioUpdateDetalle(esInicial);
		this.setActivarid_mesUpdateDetalle(esInicial);
		this.setActivarcodigoUpdateDetalle(esInicial);
		this.setActivarcodigo_procesoUpdateDetalle(esInicial);
		this.setActivarquery_resumenUpdateDetalle(esInicial);
		this.setActivarnumero_intentoUpdateDetalle(esInicial);
		this.setActivarfecha_archivoUpdateDetalle(esInicial);
		this.setActivarfechaUpdateDetalle(esInicial);
		this.setActivarordenUpdateDetalle(esInicial);
		this.setActivarejecutadoUpdateDetalle(esInicial);
		this.setActivaresta_activoUpdateDetalle(esInicial);
		this.setActivardescripcionUpdateDetalle(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(UpdateDetalleConstantesFunciones.ID)) {
				this.setActivaridUpdateDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(UpdateDetalleConstantesFunciones.IDUPDATE)) {
				this.setActivarid_updateUpdateDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(UpdateDetalleConstantesFunciones.IDANIO)) {
				this.setActivarid_anioUpdateDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(UpdateDetalleConstantesFunciones.IDMES)) {
				this.setActivarid_mesUpdateDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(UpdateDetalleConstantesFunciones.CODIGO)) {
				this.setActivarcodigoUpdateDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(UpdateDetalleConstantesFunciones.CODIGOPROCESO)) {
				this.setActivarcodigo_procesoUpdateDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(UpdateDetalleConstantesFunciones.QUERYRESUMEN)) {
				this.setActivarquery_resumenUpdateDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(UpdateDetalleConstantesFunciones.NUMEROINTENTO)) {
				this.setActivarnumero_intentoUpdateDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(UpdateDetalleConstantesFunciones.FECHAARCHIVO)) {
				this.setActivarfecha_archivoUpdateDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(UpdateDetalleConstantesFunciones.FECHA)) {
				this.setActivarfechaUpdateDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(UpdateDetalleConstantesFunciones.ORDEN)) {
				this.setActivarordenUpdateDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(UpdateDetalleConstantesFunciones.EJECUTADO)) {
				this.setActivarejecutadoUpdateDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(UpdateDetalleConstantesFunciones.ESTAACTIVO)) {
				this.setActivaresta_activoUpdateDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(UpdateDetalleConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionUpdateDetalle(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,UpdateDetalleBeanSwingJInternalFrame updatedetalleBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridUpdateDetalle(esInicial);
		this.setResaltarid_updateUpdateDetalle(esInicial);
		this.setResaltarid_anioUpdateDetalle(esInicial);
		this.setResaltarid_mesUpdateDetalle(esInicial);
		this.setResaltarcodigoUpdateDetalle(esInicial);
		this.setResaltarcodigo_procesoUpdateDetalle(esInicial);
		this.setResaltarquery_resumenUpdateDetalle(esInicial);
		this.setResaltarnumero_intentoUpdateDetalle(esInicial);
		this.setResaltarfecha_archivoUpdateDetalle(esInicial);
		this.setResaltarfechaUpdateDetalle(esInicial);
		this.setResaltarordenUpdateDetalle(esInicial);
		this.setResaltarejecutadoUpdateDetalle(esInicial);
		this.setResaltaresta_activoUpdateDetalle(esInicial);
		this.setResaltardescripcionUpdateDetalle(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(UpdateDetalleConstantesFunciones.ID)) {
				this.setResaltaridUpdateDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(UpdateDetalleConstantesFunciones.IDUPDATE)) {
				this.setResaltarid_updateUpdateDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(UpdateDetalleConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioUpdateDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(UpdateDetalleConstantesFunciones.IDMES)) {
				this.setResaltarid_mesUpdateDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(UpdateDetalleConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoUpdateDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(UpdateDetalleConstantesFunciones.CODIGOPROCESO)) {
				this.setResaltarcodigo_procesoUpdateDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(UpdateDetalleConstantesFunciones.QUERYRESUMEN)) {
				this.setResaltarquery_resumenUpdateDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(UpdateDetalleConstantesFunciones.NUMEROINTENTO)) {
				this.setResaltarnumero_intentoUpdateDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(UpdateDetalleConstantesFunciones.FECHAARCHIVO)) {
				this.setResaltarfecha_archivoUpdateDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(UpdateDetalleConstantesFunciones.FECHA)) {
				this.setResaltarfechaUpdateDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(UpdateDetalleConstantesFunciones.ORDEN)) {
				this.setResaltarordenUpdateDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(UpdateDetalleConstantesFunciones.EJECUTADO)) {
				this.setResaltarejecutadoUpdateDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(UpdateDetalleConstantesFunciones.ESTAACTIVO)) {
				this.setResaltaresta_activoUpdateDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(UpdateDetalleConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionUpdateDetalle(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,UpdateDetalleBeanSwingJInternalFrame updatedetalleBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdAnioUpdateDetalle=true;

	public Boolean getMostrarFK_IdAnioUpdateDetalle() {
		return this.mostrarFK_IdAnioUpdateDetalle;
	}

	public void setMostrarFK_IdAnioUpdateDetalle(Boolean visibilidadResaltar) {
		this.mostrarFK_IdAnioUpdateDetalle= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdMesUpdateDetalle=true;

	public Boolean getMostrarFK_IdMesUpdateDetalle() {
		return this.mostrarFK_IdMesUpdateDetalle;
	}

	public void setMostrarFK_IdMesUpdateDetalle(Boolean visibilidadResaltar) {
		this.mostrarFK_IdMesUpdateDetalle= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUpdateUpdateDetalle=true;

	public Boolean getMostrarFK_IdUpdateUpdateDetalle() {
		return this.mostrarFK_IdUpdateUpdateDetalle;
	}

	public void setMostrarFK_IdUpdateUpdateDetalle(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUpdateUpdateDetalle= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdAnioUpdateDetalle=true;

	public Boolean getActivarFK_IdAnioUpdateDetalle() {
		return this.activarFK_IdAnioUpdateDetalle;
	}

	public void setActivarFK_IdAnioUpdateDetalle(Boolean habilitarResaltar) {
		this.activarFK_IdAnioUpdateDetalle= habilitarResaltar;
	}

	public Boolean activarFK_IdMesUpdateDetalle=true;

	public Boolean getActivarFK_IdMesUpdateDetalle() {
		return this.activarFK_IdMesUpdateDetalle;
	}

	public void setActivarFK_IdMesUpdateDetalle(Boolean habilitarResaltar) {
		this.activarFK_IdMesUpdateDetalle= habilitarResaltar;
	}

	public Boolean activarFK_IdUpdateUpdateDetalle=true;

	public Boolean getActivarFK_IdUpdateUpdateDetalle() {
		return this.activarFK_IdUpdateUpdateDetalle;
	}

	public void setActivarFK_IdUpdateUpdateDetalle(Boolean habilitarResaltar) {
		this.activarFK_IdUpdateUpdateDetalle= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdAnioUpdateDetalle=null;

	public Border getResaltarFK_IdAnioUpdateDetalle() {
		return this.resaltarFK_IdAnioUpdateDetalle;
	}

	public void setResaltarFK_IdAnioUpdateDetalle(Border borderResaltar) {
		this.resaltarFK_IdAnioUpdateDetalle= borderResaltar;
	}

	public void setResaltarFK_IdAnioUpdateDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*UpdateDetalleBeanSwingJInternalFrame updatedetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdAnioUpdateDetalle= borderResaltar;
	}

	public Border resaltarFK_IdMesUpdateDetalle=null;

	public Border getResaltarFK_IdMesUpdateDetalle() {
		return this.resaltarFK_IdMesUpdateDetalle;
	}

	public void setResaltarFK_IdMesUpdateDetalle(Border borderResaltar) {
		this.resaltarFK_IdMesUpdateDetalle= borderResaltar;
	}

	public void setResaltarFK_IdMesUpdateDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*UpdateDetalleBeanSwingJInternalFrame updatedetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdMesUpdateDetalle= borderResaltar;
	}

	public Border resaltarFK_IdUpdateUpdateDetalle=null;

	public Border getResaltarFK_IdUpdateUpdateDetalle() {
		return this.resaltarFK_IdUpdateUpdateDetalle;
	}

	public void setResaltarFK_IdUpdateUpdateDetalle(Border borderResaltar) {
		this.resaltarFK_IdUpdateUpdateDetalle= borderResaltar;
	}

	public void setResaltarFK_IdUpdateUpdateDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*UpdateDetalleBeanSwingJInternalFrame updatedetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUpdateUpdateDetalle= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}