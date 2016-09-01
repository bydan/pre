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


import com.bydan.erp.seguridad.util.UpdateConstantesFunciones;
import com.bydan.erp.seguridad.util.UpdateParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.UpdateParameterGeneral;

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
final public class UpdateConstantesFunciones extends UpdateConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Update";
	public static final String SPATHOPCION="Seguridad";	
	public static final String SPATHMODULO="seguridad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Update"+UpdateConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="UpdateHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="UpdateHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=UpdateConstantesFunciones.SCHEMA+"_"+UpdateConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/UpdateHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=UpdateConstantesFunciones.SCHEMA+"_"+UpdateConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=UpdateConstantesFunciones.SCHEMA+"_"+UpdateConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/UpdateHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=UpdateConstantesFunciones.SCHEMA+"_"+UpdateConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+UpdateConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/UpdateHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+UpdateConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+UpdateConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/UpdateHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+UpdateConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=UpdateConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+UpdateConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=UpdateConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+UpdateConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Updates";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Update";
	public static final String SCLASSWEBTITULO_LOWER="Update";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Update";
	public static final String OBJECTNAME="update";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SEGURIDAD;	
	public static final String TABLENAME="update";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select update from "+UpdateConstantesFunciones.SPERSISTENCENAME+" update";
	public static String QUERYSELECTNATIVE="select "+UpdateConstantesFunciones.SCHEMA+"."+UpdateConstantesFunciones.TABLENAME+".id,"+UpdateConstantesFunciones.SCHEMA+"."+UpdateConstantesFunciones.TABLENAME+".version_row,"+UpdateConstantesFunciones.SCHEMA+"."+UpdateConstantesFunciones.TABLENAME+".id_anio,"+UpdateConstantesFunciones.SCHEMA+"."+UpdateConstantesFunciones.TABLENAME+".id_mes,"+UpdateConstantesFunciones.SCHEMA+"."+UpdateConstantesFunciones.TABLENAME+".codigo,"+UpdateConstantesFunciones.SCHEMA+"."+UpdateConstantesFunciones.TABLENAME+".codigo_proceso,"+UpdateConstantesFunciones.SCHEMA+"."+UpdateConstantesFunciones.TABLENAME+".query_resumen,"+UpdateConstantesFunciones.SCHEMA+"."+UpdateConstantesFunciones.TABLENAME+".numero_intento,"+UpdateConstantesFunciones.SCHEMA+"."+UpdateConstantesFunciones.TABLENAME+".fecha,"+UpdateConstantesFunciones.SCHEMA+"."+UpdateConstantesFunciones.TABLENAME+".fecha_archivo,"+UpdateConstantesFunciones.SCHEMA+"."+UpdateConstantesFunciones.TABLENAME+".orden,"+UpdateConstantesFunciones.SCHEMA+"."+UpdateConstantesFunciones.TABLENAME+".ejecutado,"+UpdateConstantesFunciones.SCHEMA+"."+UpdateConstantesFunciones.TABLENAME+".esta_activo,"+UpdateConstantesFunciones.SCHEMA+"."+UpdateConstantesFunciones.TABLENAME+".descripcion from "+UpdateConstantesFunciones.SCHEMA+"."+UpdateConstantesFunciones.TABLENAME;//+" as "+UpdateConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected UpdateConstantesFuncionesAdditional updateConstantesFuncionesAdditional=null;
	
	public UpdateConstantesFuncionesAdditional getUpdateConstantesFuncionesAdditional() {
		return this.updateConstantesFuncionesAdditional;
	}
	
	public void setUpdateConstantesFuncionesAdditional(UpdateConstantesFuncionesAdditional updateConstantesFuncionesAdditional) {
		try {
			this.updateConstantesFuncionesAdditional=updateConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDANIO= "id_anio";
    public static final String IDMES= "id_mes";
    public static final String CODIGO= "codigo";
    public static final String CODIGOPROCESO= "codigo_proceso";
    public static final String QUERYRESUMEN= "query_resumen";
    public static final String NUMEROINTENTO= "numero_intento";
    public static final String FECHA= "fecha";
    public static final String FECHAARCHIVO= "fecha_archivo";
    public static final String ORDEN= "orden";
    public static final String EJECUTADO= "ejecutado";
    public static final String ESTAACTIVO= "esta_activo";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
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
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_FECHAARCHIVO= "Fecha Archivo";
		public static final String LABEL_FECHAARCHIVO_LOWER= "Fecha Archivo";
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
	
	public static String getUpdateLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(UpdateConstantesFunciones.IDANIO)) {sLabelColumna=UpdateConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(UpdateConstantesFunciones.IDMES)) {sLabelColumna=UpdateConstantesFunciones.LABEL_IDMES;}
		if(sNombreColumna.equals(UpdateConstantesFunciones.CODIGO)) {sLabelColumna=UpdateConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(UpdateConstantesFunciones.CODIGOPROCESO)) {sLabelColumna=UpdateConstantesFunciones.LABEL_CODIGOPROCESO;}
		if(sNombreColumna.equals(UpdateConstantesFunciones.QUERYRESUMEN)) {sLabelColumna=UpdateConstantesFunciones.LABEL_QUERYRESUMEN;}
		if(sNombreColumna.equals(UpdateConstantesFunciones.NUMEROINTENTO)) {sLabelColumna=UpdateConstantesFunciones.LABEL_NUMEROINTENTO;}
		if(sNombreColumna.equals(UpdateConstantesFunciones.FECHA)) {sLabelColumna=UpdateConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(UpdateConstantesFunciones.FECHAARCHIVO)) {sLabelColumna=UpdateConstantesFunciones.LABEL_FECHAARCHIVO;}
		if(sNombreColumna.equals(UpdateConstantesFunciones.ORDEN)) {sLabelColumna=UpdateConstantesFunciones.LABEL_ORDEN;}
		if(sNombreColumna.equals(UpdateConstantesFunciones.EJECUTADO)) {sLabelColumna=UpdateConstantesFunciones.LABEL_EJECUTADO;}
		if(sNombreColumna.equals(UpdateConstantesFunciones.ESTAACTIVO)) {sLabelColumna=UpdateConstantesFunciones.LABEL_ESTAACTIVO;}
		if(sNombreColumna.equals(UpdateConstantesFunciones.DESCRIPCION)) {sLabelColumna=UpdateConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getejecutadoDescripcion(Update update) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!update.getejecutado()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getejecutadoHtmlDescripcion(Update update) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(update.getId(),update.getejecutado());

		return sDescripcion;
	}	
		
	public static String getesta_activoDescripcion(Update update) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!update.getesta_activo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getesta_activoHtmlDescripcion(Update update) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(update.getId(),update.getesta_activo());

		return sDescripcion;
	}	
			
	
	public static String getUpdateDescripcion(Update update) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(update !=null/* && update.getId()!=0*/) {
			sDescripcion=update.getcodigo();//updateupdate.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getUpdateDescripcionDetallado(Update update) {
		String sDescripcion="";
			
		sDescripcion+=UpdateConstantesFunciones.ID+"=";
		sDescripcion+=update.getId().toString()+",";
		sDescripcion+=UpdateConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=update.getVersionRow().toString()+",";
		sDescripcion+=UpdateConstantesFunciones.IDANIO+"=";
		sDescripcion+=update.getid_anio().toString()+",";
		sDescripcion+=UpdateConstantesFunciones.IDMES+"=";
		sDescripcion+=update.getid_mes().toString()+",";
		sDescripcion+=UpdateConstantesFunciones.CODIGO+"=";
		sDescripcion+=update.getcodigo()+",";
		sDescripcion+=UpdateConstantesFunciones.CODIGOPROCESO+"=";
		sDescripcion+=update.getcodigo_proceso()+",";
		sDescripcion+=UpdateConstantesFunciones.QUERYRESUMEN+"=";
		sDescripcion+=update.getquery_resumen()+",";
		sDescripcion+=UpdateConstantesFunciones.NUMEROINTENTO+"=";
		sDescripcion+=update.getnumero_intento().toString()+",";
		sDescripcion+=UpdateConstantesFunciones.FECHA+"=";
		sDescripcion+=update.getfecha().toString()+",";
		sDescripcion+=UpdateConstantesFunciones.FECHAARCHIVO+"=";
		sDescripcion+=update.getfecha_archivo().toString()+",";
		sDescripcion+=UpdateConstantesFunciones.ORDEN+"=";
		sDescripcion+=update.getorden().toString()+",";
		sDescripcion+=UpdateConstantesFunciones.EJECUTADO+"=";
		sDescripcion+=update.getejecutado().toString()+",";
		sDescripcion+=UpdateConstantesFunciones.ESTAACTIVO+"=";
		sDescripcion+=update.getesta_activo().toString()+",";
		sDescripcion+=UpdateConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=update.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setUpdateDescripcion(Update update,String sValor) throws Exception {			
		if(update !=null) {
			update.setcodigo(sValor);;//updateupdate.getcodigo().trim();
		}		
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
	
	
	
	
	
	
	public static void quitarEspaciosUpdate(Update update,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		update.setcodigo(update.getcodigo().trim());
		update.setcodigo_proceso(update.getcodigo_proceso().trim());
		update.setquery_resumen(update.getquery_resumen().trim());
		update.setdescripcion(update.getdescripcion().trim());
	}
	
	public static void quitarEspaciosUpdates(List<Update> updates,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Update update: updates) {
			update.setcodigo(update.getcodigo().trim());
			update.setcodigo_proceso(update.getcodigo_proceso().trim());
			update.setquery_resumen(update.getquery_resumen().trim());
			update.setdescripcion(update.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresUpdate(Update update,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && update.getConCambioAuxiliar()) {
			update.setIsDeleted(update.getIsDeletedAuxiliar());	
			update.setIsNew(update.getIsNewAuxiliar());	
			update.setIsChanged(update.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			update.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			update.setIsDeletedAuxiliar(false);	
			update.setIsNewAuxiliar(false);	
			update.setIsChangedAuxiliar(false);
			
			update.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresUpdates(List<Update> updates,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Update update : updates) {
			if(conAsignarBase && update.getConCambioAuxiliar()) {
				update.setIsDeleted(update.getIsDeletedAuxiliar());	
				update.setIsNew(update.getIsNewAuxiliar());	
				update.setIsChanged(update.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				update.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				update.setIsDeletedAuxiliar(false);	
				update.setIsNewAuxiliar(false);	
				update.setIsChangedAuxiliar(false);
				
				update.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresUpdate(Update update,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
			update.setnumero_intento(0);
			update.setorden(0);
		}
	}		
	
	public static void InicializarValoresUpdates(List<Update> updates,Boolean conEnteros) throws Exception  {
		
		for(Update update: updates) {
		
			if(conEnteros) {
				Short ish_value=0;
				
				update.setnumero_intento(0);
				update.setorden(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaUpdate(List<Update> updates,Update updateAux) throws Exception  {
		UpdateConstantesFunciones.InicializarValoresUpdate(updateAux,true);
		
		for(Update update: updates) {
			if(update.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			updateAux.setnumero_intento(updateAux.getnumero_intento()+update.getnumero_intento());			
			updateAux.setorden(updateAux.getorden()+update.getorden());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesUpdate(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=UpdateConstantesFunciones.getArrayColumnasGlobalesUpdate(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesUpdate(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoUpdate(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Update> updates,Update update,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Update updateAux: updates) {
			if(updateAux!=null && update!=null) {
				if((updateAux.getId()==null && update.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(updateAux.getId()!=null && update.getId()!=null){
					if(updateAux.getId().equals(update.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaUpdate(List<Update> updates) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Update update: updates) {			
			if(update.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaUpdate() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,UpdateConstantesFunciones.LABEL_ID, UpdateConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UpdateConstantesFunciones.LABEL_VERSIONROW, UpdateConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UpdateConstantesFunciones.LABEL_IDANIO, UpdateConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UpdateConstantesFunciones.LABEL_IDMES, UpdateConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UpdateConstantesFunciones.LABEL_CODIGO, UpdateConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UpdateConstantesFunciones.LABEL_CODIGOPROCESO, UpdateConstantesFunciones.CODIGOPROCESO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UpdateConstantesFunciones.LABEL_QUERYRESUMEN, UpdateConstantesFunciones.QUERYRESUMEN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UpdateConstantesFunciones.LABEL_NUMEROINTENTO, UpdateConstantesFunciones.NUMEROINTENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UpdateConstantesFunciones.LABEL_FECHA, UpdateConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UpdateConstantesFunciones.LABEL_FECHAARCHIVO, UpdateConstantesFunciones.FECHAARCHIVO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UpdateConstantesFunciones.LABEL_ORDEN, UpdateConstantesFunciones.ORDEN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UpdateConstantesFunciones.LABEL_EJECUTADO, UpdateConstantesFunciones.EJECUTADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UpdateConstantesFunciones.LABEL_ESTAACTIVO, UpdateConstantesFunciones.ESTAACTIVO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UpdateConstantesFunciones.LABEL_DESCRIPCION, UpdateConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasUpdate() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=UpdateConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UpdateConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UpdateConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UpdateConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UpdateConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UpdateConstantesFunciones.CODIGOPROCESO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UpdateConstantesFunciones.QUERYRESUMEN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UpdateConstantesFunciones.NUMEROINTENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UpdateConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UpdateConstantesFunciones.FECHAARCHIVO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UpdateConstantesFunciones.ORDEN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UpdateConstantesFunciones.EJECUTADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UpdateConstantesFunciones.ESTAACTIVO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UpdateConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarUpdate() throws Exception  {
		return UpdateConstantesFunciones.getTiposSeleccionarUpdate(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarUpdate(Boolean conFk) throws Exception  {
		return UpdateConstantesFunciones.getTiposSeleccionarUpdate(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarUpdate(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(UpdateConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(UpdateConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(UpdateConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(UpdateConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(UpdateConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(UpdateConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(UpdateConstantesFunciones.LABEL_CODIGOPROCESO);
			reporte.setsDescripcion(UpdateConstantesFunciones.LABEL_CODIGOPROCESO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(UpdateConstantesFunciones.LABEL_QUERYRESUMEN);
			reporte.setsDescripcion(UpdateConstantesFunciones.LABEL_QUERYRESUMEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(UpdateConstantesFunciones.LABEL_NUMEROINTENTO);
			reporte.setsDescripcion(UpdateConstantesFunciones.LABEL_NUMEROINTENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(UpdateConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(UpdateConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(UpdateConstantesFunciones.LABEL_FECHAARCHIVO);
			reporte.setsDescripcion(UpdateConstantesFunciones.LABEL_FECHAARCHIVO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(UpdateConstantesFunciones.LABEL_ORDEN);
			reporte.setsDescripcion(UpdateConstantesFunciones.LABEL_ORDEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(UpdateConstantesFunciones.LABEL_EJECUTADO);
			reporte.setsDescripcion(UpdateConstantesFunciones.LABEL_EJECUTADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(UpdateConstantesFunciones.LABEL_ESTAACTIVO);
			reporte.setsDescripcion(UpdateConstantesFunciones.LABEL_ESTAACTIVO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(UpdateConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(UpdateConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesUpdate(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesUpdate(Update updateAux) throws Exception {
		
			updateAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(updateAux.getAnio()));
			updateAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(updateAux.getMes()));		
	}
	
	public static void refrescarForeignKeysDescripcionesUpdate(List<Update> updatesTemp) throws Exception {
		for(Update updateAux:updatesTemp) {
			
			updateAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(updateAux.getAnio()));
			updateAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(updateAux.getMes()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfUpdate(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Anio.class));
				classes.add(new Classe(Mes.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfUpdate(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

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
	
	public static ArrayList<Classe> getClassesRelationshipsOfUpdate(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return UpdateConstantesFunciones.getClassesRelationshipsOfUpdate(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfUpdate(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(UpdateDetalle.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(UpdateDetalle.class)) {
						classes.add(new Classe(UpdateDetalle.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfUpdate(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return UpdateConstantesFunciones.getClassesRelationshipsFromStringsOfUpdate(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfUpdate(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(UpdateDetalle.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(UpdateDetalle.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(UpdateDetalle.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(UpdateDetalle.class)); continue;
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
	public static void actualizarLista(Update update,List<Update> updates,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Update updateEncontrado=null;
			
			for(Update updateLocal:updates) {
				if(updateLocal.getId().equals(update.getId())) {
					updateEncontrado=updateLocal;
					
					updateLocal.setIsChanged(update.getIsChanged());
					updateLocal.setIsNew(update.getIsNew());
					updateLocal.setIsDeleted(update.getIsDeleted());
					
					updateLocal.setGeneralEntityOriginal(update.getGeneralEntityOriginal());
					
					updateLocal.setId(update.getId());	
					updateLocal.setVersionRow(update.getVersionRow());	
					updateLocal.setid_anio(update.getid_anio());	
					updateLocal.setid_mes(update.getid_mes());	
					updateLocal.setcodigo(update.getcodigo());	
					updateLocal.setcodigo_proceso(update.getcodigo_proceso());	
					updateLocal.setquery_resumen(update.getquery_resumen());	
					updateLocal.setnumero_intento(update.getnumero_intento());	
					updateLocal.setfecha(update.getfecha());	
					updateLocal.setfecha_archivo(update.getfecha_archivo());	
					updateLocal.setorden(update.getorden());	
					updateLocal.setejecutado(update.getejecutado());	
					updateLocal.setesta_activo(update.getesta_activo());	
					updateLocal.setdescripcion(update.getdescripcion());	
					
					
					updateLocal.setUpdateDetalles(update.getUpdateDetalles());
					
					existe=true;
					break;
				}
			}
			
			if(!update.getIsDeleted()) {
				if(!existe) {
					updates.add(update);
				}
			} else {
				if(updateEncontrado!=null && permiteQuitar)  {
					updates.remove(updateEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Update update,List<Update> updates) throws Exception {
		try	{			
			for(Update updateLocal:updates) {
				if(updateLocal.getId().equals(update.getId())) {
					updateLocal.setIsSelected(update.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesUpdate(List<Update> updatesAux) throws Exception {
		//this.updatesAux=updatesAux;
		
		for(Update updateAux:updatesAux) {
			if(updateAux.getIsChanged()) {
				updateAux.setIsChanged(false);
			}		
			
			if(updateAux.getIsNew()) {
				updateAux.setIsNew(false);
			}	
			
			if(updateAux.getIsDeleted()) {
				updateAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesUpdate(Update updateAux) throws Exception {
		//this.updateAux=updateAux;
		
			if(updateAux.getIsChanged()) {
				updateAux.setIsChanged(false);
			}		
			
			if(updateAux.getIsNew()) {
				updateAux.setIsNew(false);
			}	
			
			if(updateAux.getIsDeleted()) {
				updateAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Update updateAsignar,Update update) throws Exception {
		updateAsignar.setId(update.getId());	
		updateAsignar.setVersionRow(update.getVersionRow());	
		updateAsignar.setid_anio(update.getid_anio());
		updateAsignar.setanio_descripcion(update.getanio_descripcion());	
		updateAsignar.setid_mes(update.getid_mes());
		updateAsignar.setmes_descripcion(update.getmes_descripcion());	
		updateAsignar.setcodigo(update.getcodigo());	
		updateAsignar.setcodigo_proceso(update.getcodigo_proceso());	
		updateAsignar.setquery_resumen(update.getquery_resumen());	
		updateAsignar.setnumero_intento(update.getnumero_intento());	
		updateAsignar.setfecha(update.getfecha());	
		updateAsignar.setfecha_archivo(update.getfecha_archivo());	
		updateAsignar.setorden(update.getorden());	
		updateAsignar.setejecutado(update.getejecutado());	
		updateAsignar.setesta_activo(update.getesta_activo());	
		updateAsignar.setdescripcion(update.getdescripcion());	
	}
	
	public static void inicializarUpdate(Update update) throws Exception {
		try {
				update.setId(0L);	
					
				update.setid_anio(null);	
				update.setid_mes(null);	
				update.setcodigo("");	
				update.setcodigo_proceso("");	
				update.setquery_resumen("");	
				update.setnumero_intento(0);	
				update.setfecha(new Date());	
				update.setfecha_archivo(new Date());	
				update.setorden(0);	
				update.setejecutado(false);	
				update.setesta_activo(false);	
				update.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderUpdate(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(UpdateConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UpdateConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UpdateConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UpdateConstantesFunciones.LABEL_CODIGOPROCESO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UpdateConstantesFunciones.LABEL_QUERYRESUMEN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UpdateConstantesFunciones.LABEL_NUMEROINTENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UpdateConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UpdateConstantesFunciones.LABEL_FECHAARCHIVO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UpdateConstantesFunciones.LABEL_ORDEN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UpdateConstantesFunciones.LABEL_EJECUTADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UpdateConstantesFunciones.LABEL_ESTAACTIVO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UpdateConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataUpdate(String sTipo,Row row,Workbook workbook,Update update,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(update.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(update.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(update.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(update.getcodigo_proceso());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(update.getquery_resumen());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(update.getnumero_intento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(update.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(update.getfecha_archivo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(update.getorden());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(update.getejecutado()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(update.getesta_activo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(update.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryUpdate=Constantes.SFINALQUERY;
	
	public String getsFinalQueryUpdate() {
		return this.sFinalQueryUpdate;
	}
	
	public void setsFinalQueryUpdate(String sFinalQueryUpdate) {
		this.sFinalQueryUpdate= sFinalQueryUpdate;
	}
	
	public Border resaltarSeleccionarUpdate=null;
	
	public Border setResaltarSeleccionarUpdate(ParametroGeneralUsuario parametroGeneralUsuario/*UpdateBeanSwingJInternalFrame updateBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//updateBeanSwingJInternalFrame.jTtoolBarUpdate.setBorder(borderResaltar);
		
		this.resaltarSeleccionarUpdate= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarUpdate() {
		return this.resaltarSeleccionarUpdate;
	}
	
	public void setResaltarSeleccionarUpdate(Border borderResaltarSeleccionarUpdate) {
		this.resaltarSeleccionarUpdate= borderResaltarSeleccionarUpdate;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridUpdate=null;
	public Boolean mostraridUpdate=true;
	public Boolean activaridUpdate=true;

	public Border resaltarid_anioUpdate=null;
	public Boolean mostrarid_anioUpdate=true;
	public Boolean activarid_anioUpdate=true;
	public Boolean cargarid_anioUpdate=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioUpdate=false;//ConEventDepend=true

	public Border resaltarid_mesUpdate=null;
	public Boolean mostrarid_mesUpdate=true;
	public Boolean activarid_mesUpdate=true;
	public Boolean cargarid_mesUpdate=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesUpdate=false;//ConEventDepend=true

	public Border resaltarcodigoUpdate=null;
	public Boolean mostrarcodigoUpdate=true;
	public Boolean activarcodigoUpdate=true;

	public Border resaltarcodigo_procesoUpdate=null;
	public Boolean mostrarcodigo_procesoUpdate=true;
	public Boolean activarcodigo_procesoUpdate=true;

	public Border resaltarquery_resumenUpdate=null;
	public Boolean mostrarquery_resumenUpdate=true;
	public Boolean activarquery_resumenUpdate=true;

	public Border resaltarnumero_intentoUpdate=null;
	public Boolean mostrarnumero_intentoUpdate=true;
	public Boolean activarnumero_intentoUpdate=true;

	public Border resaltarfechaUpdate=null;
	public Boolean mostrarfechaUpdate=true;
	public Boolean activarfechaUpdate=false;

	public Border resaltarfecha_archivoUpdate=null;
	public Boolean mostrarfecha_archivoUpdate=true;
	public Boolean activarfecha_archivoUpdate=false;

	public Border resaltarordenUpdate=null;
	public Boolean mostrarordenUpdate=true;
	public Boolean activarordenUpdate=true;

	public Border resaltarejecutadoUpdate=null;
	public Boolean mostrarejecutadoUpdate=true;
	public Boolean activarejecutadoUpdate=true;

	public Border resaltaresta_activoUpdate=null;
	public Boolean mostraresta_activoUpdate=true;
	public Boolean activaresta_activoUpdate=true;

	public Border resaltardescripcionUpdate=null;
	public Boolean mostrardescripcionUpdate=true;
	public Boolean activardescripcionUpdate=true;

	
	

	public Border setResaltaridUpdate(ParametroGeneralUsuario parametroGeneralUsuario/*UpdateBeanSwingJInternalFrame updateBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//updateBeanSwingJInternalFrame.jTtoolBarUpdate.setBorder(borderResaltar);
		
		this.resaltaridUpdate= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridUpdate() {
		return this.resaltaridUpdate;
	}

	public void setResaltaridUpdate(Border borderResaltar) {
		this.resaltaridUpdate= borderResaltar;
	}

	public Boolean getMostraridUpdate() {
		return this.mostraridUpdate;
	}

	public void setMostraridUpdate(Boolean mostraridUpdate) {
		this.mostraridUpdate= mostraridUpdate;
	}

	public Boolean getActivaridUpdate() {
		return this.activaridUpdate;
	}

	public void setActivaridUpdate(Boolean activaridUpdate) {
		this.activaridUpdate= activaridUpdate;
	}

	public Border setResaltarid_anioUpdate(ParametroGeneralUsuario parametroGeneralUsuario/*UpdateBeanSwingJInternalFrame updateBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//updateBeanSwingJInternalFrame.jTtoolBarUpdate.setBorder(borderResaltar);
		
		this.resaltarid_anioUpdate= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioUpdate() {
		return this.resaltarid_anioUpdate;
	}

	public void setResaltarid_anioUpdate(Border borderResaltar) {
		this.resaltarid_anioUpdate= borderResaltar;
	}

	public Boolean getMostrarid_anioUpdate() {
		return this.mostrarid_anioUpdate;
	}

	public void setMostrarid_anioUpdate(Boolean mostrarid_anioUpdate) {
		this.mostrarid_anioUpdate= mostrarid_anioUpdate;
	}

	public Boolean getActivarid_anioUpdate() {
		return this.activarid_anioUpdate;
	}

	public void setActivarid_anioUpdate(Boolean activarid_anioUpdate) {
		this.activarid_anioUpdate= activarid_anioUpdate;
	}

	public Boolean getCargarid_anioUpdate() {
		return this.cargarid_anioUpdate;
	}

	public void setCargarid_anioUpdate(Boolean cargarid_anioUpdate) {
		this.cargarid_anioUpdate= cargarid_anioUpdate;
	}

	public Border setResaltarid_mesUpdate(ParametroGeneralUsuario parametroGeneralUsuario/*UpdateBeanSwingJInternalFrame updateBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//updateBeanSwingJInternalFrame.jTtoolBarUpdate.setBorder(borderResaltar);
		
		this.resaltarid_mesUpdate= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesUpdate() {
		return this.resaltarid_mesUpdate;
	}

	public void setResaltarid_mesUpdate(Border borderResaltar) {
		this.resaltarid_mesUpdate= borderResaltar;
	}

	public Boolean getMostrarid_mesUpdate() {
		return this.mostrarid_mesUpdate;
	}

	public void setMostrarid_mesUpdate(Boolean mostrarid_mesUpdate) {
		this.mostrarid_mesUpdate= mostrarid_mesUpdate;
	}

	public Boolean getActivarid_mesUpdate() {
		return this.activarid_mesUpdate;
	}

	public void setActivarid_mesUpdate(Boolean activarid_mesUpdate) {
		this.activarid_mesUpdate= activarid_mesUpdate;
	}

	public Boolean getCargarid_mesUpdate() {
		return this.cargarid_mesUpdate;
	}

	public void setCargarid_mesUpdate(Boolean cargarid_mesUpdate) {
		this.cargarid_mesUpdate= cargarid_mesUpdate;
	}

	public Border setResaltarcodigoUpdate(ParametroGeneralUsuario parametroGeneralUsuario/*UpdateBeanSwingJInternalFrame updateBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//updateBeanSwingJInternalFrame.jTtoolBarUpdate.setBorder(borderResaltar);
		
		this.resaltarcodigoUpdate= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoUpdate() {
		return this.resaltarcodigoUpdate;
	}

	public void setResaltarcodigoUpdate(Border borderResaltar) {
		this.resaltarcodigoUpdate= borderResaltar;
	}

	public Boolean getMostrarcodigoUpdate() {
		return this.mostrarcodigoUpdate;
	}

	public void setMostrarcodigoUpdate(Boolean mostrarcodigoUpdate) {
		this.mostrarcodigoUpdate= mostrarcodigoUpdate;
	}

	public Boolean getActivarcodigoUpdate() {
		return this.activarcodigoUpdate;
	}

	public void setActivarcodigoUpdate(Boolean activarcodigoUpdate) {
		this.activarcodigoUpdate= activarcodigoUpdate;
	}

	public Border setResaltarcodigo_procesoUpdate(ParametroGeneralUsuario parametroGeneralUsuario/*UpdateBeanSwingJInternalFrame updateBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//updateBeanSwingJInternalFrame.jTtoolBarUpdate.setBorder(borderResaltar);
		
		this.resaltarcodigo_procesoUpdate= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_procesoUpdate() {
		return this.resaltarcodigo_procesoUpdate;
	}

	public void setResaltarcodigo_procesoUpdate(Border borderResaltar) {
		this.resaltarcodigo_procesoUpdate= borderResaltar;
	}

	public Boolean getMostrarcodigo_procesoUpdate() {
		return this.mostrarcodigo_procesoUpdate;
	}

	public void setMostrarcodigo_procesoUpdate(Boolean mostrarcodigo_procesoUpdate) {
		this.mostrarcodigo_procesoUpdate= mostrarcodigo_procesoUpdate;
	}

	public Boolean getActivarcodigo_procesoUpdate() {
		return this.activarcodigo_procesoUpdate;
	}

	public void setActivarcodigo_procesoUpdate(Boolean activarcodigo_procesoUpdate) {
		this.activarcodigo_procesoUpdate= activarcodigo_procesoUpdate;
	}

	public Border setResaltarquery_resumenUpdate(ParametroGeneralUsuario parametroGeneralUsuario/*UpdateBeanSwingJInternalFrame updateBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//updateBeanSwingJInternalFrame.jTtoolBarUpdate.setBorder(borderResaltar);
		
		this.resaltarquery_resumenUpdate= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarquery_resumenUpdate() {
		return this.resaltarquery_resumenUpdate;
	}

	public void setResaltarquery_resumenUpdate(Border borderResaltar) {
		this.resaltarquery_resumenUpdate= borderResaltar;
	}

	public Boolean getMostrarquery_resumenUpdate() {
		return this.mostrarquery_resumenUpdate;
	}

	public void setMostrarquery_resumenUpdate(Boolean mostrarquery_resumenUpdate) {
		this.mostrarquery_resumenUpdate= mostrarquery_resumenUpdate;
	}

	public Boolean getActivarquery_resumenUpdate() {
		return this.activarquery_resumenUpdate;
	}

	public void setActivarquery_resumenUpdate(Boolean activarquery_resumenUpdate) {
		this.activarquery_resumenUpdate= activarquery_resumenUpdate;
	}

	public Border setResaltarnumero_intentoUpdate(ParametroGeneralUsuario parametroGeneralUsuario/*UpdateBeanSwingJInternalFrame updateBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//updateBeanSwingJInternalFrame.jTtoolBarUpdate.setBorder(borderResaltar);
		
		this.resaltarnumero_intentoUpdate= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_intentoUpdate() {
		return this.resaltarnumero_intentoUpdate;
	}

	public void setResaltarnumero_intentoUpdate(Border borderResaltar) {
		this.resaltarnumero_intentoUpdate= borderResaltar;
	}

	public Boolean getMostrarnumero_intentoUpdate() {
		return this.mostrarnumero_intentoUpdate;
	}

	public void setMostrarnumero_intentoUpdate(Boolean mostrarnumero_intentoUpdate) {
		this.mostrarnumero_intentoUpdate= mostrarnumero_intentoUpdate;
	}

	public Boolean getActivarnumero_intentoUpdate() {
		return this.activarnumero_intentoUpdate;
	}

	public void setActivarnumero_intentoUpdate(Boolean activarnumero_intentoUpdate) {
		this.activarnumero_intentoUpdate= activarnumero_intentoUpdate;
	}

	public Border setResaltarfechaUpdate(ParametroGeneralUsuario parametroGeneralUsuario/*UpdateBeanSwingJInternalFrame updateBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//updateBeanSwingJInternalFrame.jTtoolBarUpdate.setBorder(borderResaltar);
		
		this.resaltarfechaUpdate= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaUpdate() {
		return this.resaltarfechaUpdate;
	}

	public void setResaltarfechaUpdate(Border borderResaltar) {
		this.resaltarfechaUpdate= borderResaltar;
	}

	public Boolean getMostrarfechaUpdate() {
		return this.mostrarfechaUpdate;
	}

	public void setMostrarfechaUpdate(Boolean mostrarfechaUpdate) {
		this.mostrarfechaUpdate= mostrarfechaUpdate;
	}

	public Boolean getActivarfechaUpdate() {
		return this.activarfechaUpdate;
	}

	public void setActivarfechaUpdate(Boolean activarfechaUpdate) {
		this.activarfechaUpdate= activarfechaUpdate;
	}

	public Border setResaltarfecha_archivoUpdate(ParametroGeneralUsuario parametroGeneralUsuario/*UpdateBeanSwingJInternalFrame updateBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//updateBeanSwingJInternalFrame.jTtoolBarUpdate.setBorder(borderResaltar);
		
		this.resaltarfecha_archivoUpdate= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_archivoUpdate() {
		return this.resaltarfecha_archivoUpdate;
	}

	public void setResaltarfecha_archivoUpdate(Border borderResaltar) {
		this.resaltarfecha_archivoUpdate= borderResaltar;
	}

	public Boolean getMostrarfecha_archivoUpdate() {
		return this.mostrarfecha_archivoUpdate;
	}

	public void setMostrarfecha_archivoUpdate(Boolean mostrarfecha_archivoUpdate) {
		this.mostrarfecha_archivoUpdate= mostrarfecha_archivoUpdate;
	}

	public Boolean getActivarfecha_archivoUpdate() {
		return this.activarfecha_archivoUpdate;
	}

	public void setActivarfecha_archivoUpdate(Boolean activarfecha_archivoUpdate) {
		this.activarfecha_archivoUpdate= activarfecha_archivoUpdate;
	}

	public Border setResaltarordenUpdate(ParametroGeneralUsuario parametroGeneralUsuario/*UpdateBeanSwingJInternalFrame updateBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//updateBeanSwingJInternalFrame.jTtoolBarUpdate.setBorder(borderResaltar);
		
		this.resaltarordenUpdate= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarordenUpdate() {
		return this.resaltarordenUpdate;
	}

	public void setResaltarordenUpdate(Border borderResaltar) {
		this.resaltarordenUpdate= borderResaltar;
	}

	public Boolean getMostrarordenUpdate() {
		return this.mostrarordenUpdate;
	}

	public void setMostrarordenUpdate(Boolean mostrarordenUpdate) {
		this.mostrarordenUpdate= mostrarordenUpdate;
	}

	public Boolean getActivarordenUpdate() {
		return this.activarordenUpdate;
	}

	public void setActivarordenUpdate(Boolean activarordenUpdate) {
		this.activarordenUpdate= activarordenUpdate;
	}

	public Border setResaltarejecutadoUpdate(ParametroGeneralUsuario parametroGeneralUsuario/*UpdateBeanSwingJInternalFrame updateBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//updateBeanSwingJInternalFrame.jTtoolBarUpdate.setBorder(borderResaltar);
		
		this.resaltarejecutadoUpdate= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarejecutadoUpdate() {
		return this.resaltarejecutadoUpdate;
	}

	public void setResaltarejecutadoUpdate(Border borderResaltar) {
		this.resaltarejecutadoUpdate= borderResaltar;
	}

	public Boolean getMostrarejecutadoUpdate() {
		return this.mostrarejecutadoUpdate;
	}

	public void setMostrarejecutadoUpdate(Boolean mostrarejecutadoUpdate) {
		this.mostrarejecutadoUpdate= mostrarejecutadoUpdate;
	}

	public Boolean getActivarejecutadoUpdate() {
		return this.activarejecutadoUpdate;
	}

	public void setActivarejecutadoUpdate(Boolean activarejecutadoUpdate) {
		this.activarejecutadoUpdate= activarejecutadoUpdate;
	}

	public Border setResaltaresta_activoUpdate(ParametroGeneralUsuario parametroGeneralUsuario/*UpdateBeanSwingJInternalFrame updateBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//updateBeanSwingJInternalFrame.jTtoolBarUpdate.setBorder(borderResaltar);
		
		this.resaltaresta_activoUpdate= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaresta_activoUpdate() {
		return this.resaltaresta_activoUpdate;
	}

	public void setResaltaresta_activoUpdate(Border borderResaltar) {
		this.resaltaresta_activoUpdate= borderResaltar;
	}

	public Boolean getMostraresta_activoUpdate() {
		return this.mostraresta_activoUpdate;
	}

	public void setMostraresta_activoUpdate(Boolean mostraresta_activoUpdate) {
		this.mostraresta_activoUpdate= mostraresta_activoUpdate;
	}

	public Boolean getActivaresta_activoUpdate() {
		return this.activaresta_activoUpdate;
	}

	public void setActivaresta_activoUpdate(Boolean activaresta_activoUpdate) {
		this.activaresta_activoUpdate= activaresta_activoUpdate;
	}

	public Border setResaltardescripcionUpdate(ParametroGeneralUsuario parametroGeneralUsuario/*UpdateBeanSwingJInternalFrame updateBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//updateBeanSwingJInternalFrame.jTtoolBarUpdate.setBorder(borderResaltar);
		
		this.resaltardescripcionUpdate= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionUpdate() {
		return this.resaltardescripcionUpdate;
	}

	public void setResaltardescripcionUpdate(Border borderResaltar) {
		this.resaltardescripcionUpdate= borderResaltar;
	}

	public Boolean getMostrardescripcionUpdate() {
		return this.mostrardescripcionUpdate;
	}

	public void setMostrardescripcionUpdate(Boolean mostrardescripcionUpdate) {
		this.mostrardescripcionUpdate= mostrardescripcionUpdate;
	}

	public Boolean getActivardescripcionUpdate() {
		return this.activardescripcionUpdate;
	}

	public void setActivardescripcionUpdate(Boolean activardescripcionUpdate) {
		this.activardescripcionUpdate= activardescripcionUpdate;
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
		
		
		this.setMostraridUpdate(esInicial);
		this.setMostrarid_anioUpdate(esInicial);
		this.setMostrarid_mesUpdate(esInicial);
		this.setMostrarcodigoUpdate(esInicial);
		this.setMostrarcodigo_procesoUpdate(esInicial);
		this.setMostrarquery_resumenUpdate(esInicial);
		this.setMostrarnumero_intentoUpdate(esInicial);
		this.setMostrarfechaUpdate(esInicial);
		this.setMostrarfecha_archivoUpdate(esInicial);
		this.setMostrarordenUpdate(esInicial);
		this.setMostrarejecutadoUpdate(esInicial);
		this.setMostraresta_activoUpdate(esInicial);
		this.setMostrardescripcionUpdate(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(UpdateConstantesFunciones.ID)) {
				this.setMostraridUpdate(esAsigna);
				continue;
			}

			if(campo.clase.equals(UpdateConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioUpdate(esAsigna);
				continue;
			}

			if(campo.clase.equals(UpdateConstantesFunciones.IDMES)) {
				this.setMostrarid_mesUpdate(esAsigna);
				continue;
			}

			if(campo.clase.equals(UpdateConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoUpdate(esAsigna);
				continue;
			}

			if(campo.clase.equals(UpdateConstantesFunciones.CODIGOPROCESO)) {
				this.setMostrarcodigo_procesoUpdate(esAsigna);
				continue;
			}

			if(campo.clase.equals(UpdateConstantesFunciones.QUERYRESUMEN)) {
				this.setMostrarquery_resumenUpdate(esAsigna);
				continue;
			}

			if(campo.clase.equals(UpdateConstantesFunciones.NUMEROINTENTO)) {
				this.setMostrarnumero_intentoUpdate(esAsigna);
				continue;
			}

			if(campo.clase.equals(UpdateConstantesFunciones.FECHA)) {
				this.setMostrarfechaUpdate(esAsigna);
				continue;
			}

			if(campo.clase.equals(UpdateConstantesFunciones.FECHAARCHIVO)) {
				this.setMostrarfecha_archivoUpdate(esAsigna);
				continue;
			}

			if(campo.clase.equals(UpdateConstantesFunciones.ORDEN)) {
				this.setMostrarordenUpdate(esAsigna);
				continue;
			}

			if(campo.clase.equals(UpdateConstantesFunciones.EJECUTADO)) {
				this.setMostrarejecutadoUpdate(esAsigna);
				continue;
			}

			if(campo.clase.equals(UpdateConstantesFunciones.ESTAACTIVO)) {
				this.setMostraresta_activoUpdate(esAsigna);
				continue;
			}

			if(campo.clase.equals(UpdateConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionUpdate(esAsigna);
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
		
		
		this.setActivaridUpdate(esInicial);
		this.setActivarid_anioUpdate(esInicial);
		this.setActivarid_mesUpdate(esInicial);
		this.setActivarcodigoUpdate(esInicial);
		this.setActivarcodigo_procesoUpdate(esInicial);
		this.setActivarquery_resumenUpdate(esInicial);
		this.setActivarnumero_intentoUpdate(esInicial);
		this.setActivarfechaUpdate(esInicial);
		this.setActivarfecha_archivoUpdate(esInicial);
		this.setActivarordenUpdate(esInicial);
		this.setActivarejecutadoUpdate(esInicial);
		this.setActivaresta_activoUpdate(esInicial);
		this.setActivardescripcionUpdate(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(UpdateConstantesFunciones.ID)) {
				this.setActivaridUpdate(esAsigna);
				continue;
			}

			if(campo.clase.equals(UpdateConstantesFunciones.IDANIO)) {
				this.setActivarid_anioUpdate(esAsigna);
				continue;
			}

			if(campo.clase.equals(UpdateConstantesFunciones.IDMES)) {
				this.setActivarid_mesUpdate(esAsigna);
				continue;
			}

			if(campo.clase.equals(UpdateConstantesFunciones.CODIGO)) {
				this.setActivarcodigoUpdate(esAsigna);
				continue;
			}

			if(campo.clase.equals(UpdateConstantesFunciones.CODIGOPROCESO)) {
				this.setActivarcodigo_procesoUpdate(esAsigna);
				continue;
			}

			if(campo.clase.equals(UpdateConstantesFunciones.QUERYRESUMEN)) {
				this.setActivarquery_resumenUpdate(esAsigna);
				continue;
			}

			if(campo.clase.equals(UpdateConstantesFunciones.NUMEROINTENTO)) {
				this.setActivarnumero_intentoUpdate(esAsigna);
				continue;
			}

			if(campo.clase.equals(UpdateConstantesFunciones.FECHA)) {
				this.setActivarfechaUpdate(esAsigna);
				continue;
			}

			if(campo.clase.equals(UpdateConstantesFunciones.FECHAARCHIVO)) {
				this.setActivarfecha_archivoUpdate(esAsigna);
				continue;
			}

			if(campo.clase.equals(UpdateConstantesFunciones.ORDEN)) {
				this.setActivarordenUpdate(esAsigna);
				continue;
			}

			if(campo.clase.equals(UpdateConstantesFunciones.EJECUTADO)) {
				this.setActivarejecutadoUpdate(esAsigna);
				continue;
			}

			if(campo.clase.equals(UpdateConstantesFunciones.ESTAACTIVO)) {
				this.setActivaresta_activoUpdate(esAsigna);
				continue;
			}

			if(campo.clase.equals(UpdateConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionUpdate(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,UpdateBeanSwingJInternalFrame updateBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridUpdate(esInicial);
		this.setResaltarid_anioUpdate(esInicial);
		this.setResaltarid_mesUpdate(esInicial);
		this.setResaltarcodigoUpdate(esInicial);
		this.setResaltarcodigo_procesoUpdate(esInicial);
		this.setResaltarquery_resumenUpdate(esInicial);
		this.setResaltarnumero_intentoUpdate(esInicial);
		this.setResaltarfechaUpdate(esInicial);
		this.setResaltarfecha_archivoUpdate(esInicial);
		this.setResaltarordenUpdate(esInicial);
		this.setResaltarejecutadoUpdate(esInicial);
		this.setResaltaresta_activoUpdate(esInicial);
		this.setResaltardescripcionUpdate(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(UpdateConstantesFunciones.ID)) {
				this.setResaltaridUpdate(esAsigna);
				continue;
			}

			if(campo.clase.equals(UpdateConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioUpdate(esAsigna);
				continue;
			}

			if(campo.clase.equals(UpdateConstantesFunciones.IDMES)) {
				this.setResaltarid_mesUpdate(esAsigna);
				continue;
			}

			if(campo.clase.equals(UpdateConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoUpdate(esAsigna);
				continue;
			}

			if(campo.clase.equals(UpdateConstantesFunciones.CODIGOPROCESO)) {
				this.setResaltarcodigo_procesoUpdate(esAsigna);
				continue;
			}

			if(campo.clase.equals(UpdateConstantesFunciones.QUERYRESUMEN)) {
				this.setResaltarquery_resumenUpdate(esAsigna);
				continue;
			}

			if(campo.clase.equals(UpdateConstantesFunciones.NUMEROINTENTO)) {
				this.setResaltarnumero_intentoUpdate(esAsigna);
				continue;
			}

			if(campo.clase.equals(UpdateConstantesFunciones.FECHA)) {
				this.setResaltarfechaUpdate(esAsigna);
				continue;
			}

			if(campo.clase.equals(UpdateConstantesFunciones.FECHAARCHIVO)) {
				this.setResaltarfecha_archivoUpdate(esAsigna);
				continue;
			}

			if(campo.clase.equals(UpdateConstantesFunciones.ORDEN)) {
				this.setResaltarordenUpdate(esAsigna);
				continue;
			}

			if(campo.clase.equals(UpdateConstantesFunciones.EJECUTADO)) {
				this.setResaltarejecutadoUpdate(esAsigna);
				continue;
			}

			if(campo.clase.equals(UpdateConstantesFunciones.ESTAACTIVO)) {
				this.setResaltaresta_activoUpdate(esAsigna);
				continue;
			}

			if(campo.clase.equals(UpdateConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionUpdate(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarUpdateDetalleUpdate=null;

	public Border getResaltarUpdateDetalleUpdate() {
		return this.resaltarUpdateDetalleUpdate;
	}

	public void setResaltarUpdateDetalleUpdate(Border borderResaltarUpdateDetalle) {
		if(borderResaltarUpdateDetalle!=null) {
			this.resaltarUpdateDetalleUpdate= borderResaltarUpdateDetalle;
		}
	}

	public Border setResaltarUpdateDetalleUpdate(ParametroGeneralUsuario parametroGeneralUsuario/*UpdateBeanSwingJInternalFrame updateBeanSwingJInternalFrame*/) {
		Border borderResaltarUpdateDetalle=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//updateBeanSwingJInternalFrame.jTtoolBarUpdate.setBorder(borderResaltarUpdateDetalle);
			
		this.resaltarUpdateDetalleUpdate= borderResaltarUpdateDetalle;

		 return borderResaltarUpdateDetalle;
	}



	public Boolean mostrarUpdateDetalleUpdate=true;

	public Boolean getMostrarUpdateDetalleUpdate() {
		return this.mostrarUpdateDetalleUpdate;
	}

	public void setMostrarUpdateDetalleUpdate(Boolean visibilidadResaltarUpdateDetalle) {
		this.mostrarUpdateDetalleUpdate= visibilidadResaltarUpdateDetalle;
	}



	public Boolean activarUpdateDetalleUpdate=true;

	public Boolean gethabilitarResaltarUpdateDetalleUpdate() {
		return this.activarUpdateDetalleUpdate;
	}

	public void setActivarUpdateDetalleUpdate(Boolean habilitarResaltarUpdateDetalle) {
		this.activarUpdateDetalleUpdate= habilitarResaltarUpdateDetalle;
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

		this.setMostrarUpdateDetalleUpdate(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(UpdateDetalle.class)) {
				this.setMostrarUpdateDetalleUpdate(esAsigna);
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

		this.setActivarUpdateDetalleUpdate(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(UpdateDetalle.class)) {
				this.setActivarUpdateDetalleUpdate(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,UpdateBeanSwingJInternalFrame updateBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarUpdateDetalleUpdate(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(UpdateDetalle.class)) {
				this.setResaltarUpdateDetalleUpdate(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdAnioUpdate=true;

	public Boolean getMostrarFK_IdAnioUpdate() {
		return this.mostrarFK_IdAnioUpdate;
	}

	public void setMostrarFK_IdAnioUpdate(Boolean visibilidadResaltar) {
		this.mostrarFK_IdAnioUpdate= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdMesUpdate=true;

	public Boolean getMostrarFK_IdMesUpdate() {
		return this.mostrarFK_IdMesUpdate;
	}

	public void setMostrarFK_IdMesUpdate(Boolean visibilidadResaltar) {
		this.mostrarFK_IdMesUpdate= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdAnioUpdate=true;

	public Boolean getActivarFK_IdAnioUpdate() {
		return this.activarFK_IdAnioUpdate;
	}

	public void setActivarFK_IdAnioUpdate(Boolean habilitarResaltar) {
		this.activarFK_IdAnioUpdate= habilitarResaltar;
	}

	public Boolean activarFK_IdMesUpdate=true;

	public Boolean getActivarFK_IdMesUpdate() {
		return this.activarFK_IdMesUpdate;
	}

	public void setActivarFK_IdMesUpdate(Boolean habilitarResaltar) {
		this.activarFK_IdMesUpdate= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdAnioUpdate=null;

	public Border getResaltarFK_IdAnioUpdate() {
		return this.resaltarFK_IdAnioUpdate;
	}

	public void setResaltarFK_IdAnioUpdate(Border borderResaltar) {
		this.resaltarFK_IdAnioUpdate= borderResaltar;
	}

	public void setResaltarFK_IdAnioUpdate(ParametroGeneralUsuario parametroGeneralUsuario/*UpdateBeanSwingJInternalFrame updateBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdAnioUpdate= borderResaltar;
	}

	public Border resaltarFK_IdMesUpdate=null;

	public Border getResaltarFK_IdMesUpdate() {
		return this.resaltarFK_IdMesUpdate;
	}

	public void setResaltarFK_IdMesUpdate(Border borderResaltar) {
		this.resaltarFK_IdMesUpdate= borderResaltar;
	}

	public void setResaltarFK_IdMesUpdate(ParametroGeneralUsuario parametroGeneralUsuario/*UpdateBeanSwingJInternalFrame updateBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdMesUpdate= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}