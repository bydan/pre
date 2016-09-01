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


import com.bydan.erp.seguridad.util.AccionConstantesFunciones;
import com.bydan.erp.seguridad.util.AccionParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.AccionParameterGeneral;

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
final public class AccionConstantesFunciones extends AccionConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Accion";
	public static final String SPATHOPCION="Seguridad";	
	public static final String SPATHMODULO="seguridad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Accion"+AccionConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="AccionHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="AccionHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=AccionConstantesFunciones.SCHEMA+"_"+AccionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/AccionHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=AccionConstantesFunciones.SCHEMA+"_"+AccionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=AccionConstantesFunciones.SCHEMA+"_"+AccionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/AccionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=AccionConstantesFunciones.SCHEMA+"_"+AccionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AccionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/AccionHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AccionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AccionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/AccionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AccionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=AccionConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+AccionConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=AccionConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+AccionConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Acciones";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Accion";
	public static final String SCLASSWEBTITULO_LOWER="Accion";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Accion";
	public static final String OBJECTNAME="accion";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SEGURIDAD;	
	public static final String TABLENAME="accion";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select accion from "+AccionConstantesFunciones.SPERSISTENCENAME+" accion";
	public static String QUERYSELECTNATIVE="select "+AccionConstantesFunciones.SCHEMA+"."+AccionConstantesFunciones.TABLENAME+".id,"+AccionConstantesFunciones.SCHEMA+"."+AccionConstantesFunciones.TABLENAME+".version_row,"+AccionConstantesFunciones.SCHEMA+"."+AccionConstantesFunciones.TABLENAME+".id_opcion,"+AccionConstantesFunciones.SCHEMA+"."+AccionConstantesFunciones.TABLENAME+".codigo,"+AccionConstantesFunciones.SCHEMA+"."+AccionConstantesFunciones.TABLENAME+".nombre,"+AccionConstantesFunciones.SCHEMA+"."+AccionConstantesFunciones.TABLENAME+".solo_form,"+AccionConstantesFunciones.SCHEMA+"."+AccionConstantesFunciones.TABLENAME+".descripcion,"+AccionConstantesFunciones.SCHEMA+"."+AccionConstantesFunciones.TABLENAME+".orden,"+AccionConstantesFunciones.SCHEMA+"."+AccionConstantesFunciones.TABLENAME+".estado from "+AccionConstantesFunciones.SCHEMA+"."+AccionConstantesFunciones.TABLENAME;//+" as "+AccionConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=true;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected AccionConstantesFuncionesAdditional accionConstantesFuncionesAdditional=null;
	
	public AccionConstantesFuncionesAdditional getAccionConstantesFuncionesAdditional() {
		return this.accionConstantesFuncionesAdditional;
	}
	
	public void setAccionConstantesFuncionesAdditional(AccionConstantesFuncionesAdditional accionConstantesFuncionesAdditional) {
		try {
			this.accionConstantesFuncionesAdditional=accionConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDOPCION= "id_opcion";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String SOLOFORM= "solo_form";
    public static final String DESCRIPCION= "descripcion";
    public static final String ORDEN= "orden";
    public static final String ESTADO= "estado";
	//TITULO CAMPO
    	public static final String LABEL_ID= "A";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "A";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDOPCION= "Opcion";
		public static final String LABEL_IDOPCION_LOWER= "Opcion";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_SOLOFORM= "Solo Form";
		public static final String LABEL_SOLOFORM_LOWER= "Solo Form";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
    	public static final String LABEL_ORDEN= "Orden";
		public static final String LABEL_ORDEN_LOWER= "Orden";
    	public static final String LABEL_ESTADO= "Estado";
		public static final String LABEL_ESTADO_LOWER= "Estado";
	
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	
	public static String getAccionLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(AccionConstantesFunciones.IDOPCION)) {sLabelColumna=AccionConstantesFunciones.LABEL_IDOPCION;}
		if(sNombreColumna.equals(AccionConstantesFunciones.CODIGO)) {sLabelColumna=AccionConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(AccionConstantesFunciones.NOMBRE)) {sLabelColumna=AccionConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(AccionConstantesFunciones.SOLOFORM)) {sLabelColumna=AccionConstantesFunciones.LABEL_SOLOFORM;}
		if(sNombreColumna.equals(AccionConstantesFunciones.DESCRIPCION)) {sLabelColumna=AccionConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(AccionConstantesFunciones.ORDEN)) {sLabelColumna=AccionConstantesFunciones.LABEL_ORDEN;}
		if(sNombreColumna.equals(AccionConstantesFunciones.ESTADO)) {sLabelColumna=AccionConstantesFunciones.LABEL_ESTADO;}
		
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
	
	
	
			
			
			
			
			
		
	public static String getsolo_formDescripcion(Accion accion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!accion.getsolo_form()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getsolo_formHtmlDescripcion(Accion accion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(accion.getId(),accion.getsolo_form());

		return sDescripcion;
	}	
			
			
		
	public static String getestadoDescripcion(Accion accion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!accion.getestado()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getestadoHtmlDescripcion(Accion accion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(accion.getId(),accion.getestado());

		return sDescripcion;
	}	
	
	public static String getAccionDescripcion(Accion accion) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(accion !=null/* && accion.getId()!=0*/) {
			sDescripcion=accion.getcodigo();//accionaccion.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getAccionDescripcionDetallado(Accion accion) {
		String sDescripcion="";
			
		sDescripcion+=AccionConstantesFunciones.ID+"=";
		sDescripcion+=accion.getId().toString()+",";
		sDescripcion+=AccionConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=accion.getVersionRow().toString()+",";
		sDescripcion+=AccionConstantesFunciones.IDOPCION+"=";
		sDescripcion+=accion.getid_opcion().toString()+",";
		sDescripcion+=AccionConstantesFunciones.CODIGO+"=";
		sDescripcion+=accion.getcodigo()+",";
		sDescripcion+=AccionConstantesFunciones.NOMBRE+"=";
		sDescripcion+=accion.getnombre()+",";
		sDescripcion+=AccionConstantesFunciones.SOLOFORM+"=";
		sDescripcion+=accion.getsolo_form().toString()+",";
		sDescripcion+=AccionConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=accion.getdescripcion()+",";
		sDescripcion+=AccionConstantesFunciones.ORDEN+"=";
		sDescripcion+=accion.getorden().toString()+",";
		sDescripcion+=AccionConstantesFunciones.ESTADO+"=";
		sDescripcion+=accion.getestado().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setAccionDescripcion(Accion accion,String sValor) throws Exception {			
		if(accion !=null) {
			accion.setcodigo(sValor);;//accionaccion.getcodigo().trim();
		}		
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
		} else if(sNombreIndice.equals("FK_IdOpcion")) {
			sNombreIndice="Tipo=  Por Opcion";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdOpcion(Long id_opcion) {
		String sDetalleIndice=" Parametros->";
		if(id_opcion!=null) {sDetalleIndice+=" Codigo Unico De Opcion="+id_opcion.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosAccion(Accion accion,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		accion.setcodigo(accion.getcodigo().trim());
		accion.setnombre(accion.getnombre().trim());
		accion.setdescripcion(accion.getdescripcion().trim());
	}
	
	public static void quitarEspaciosAccions(List<Accion> accions,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Accion accion: accions) {
			accion.setcodigo(accion.getcodigo().trim());
			accion.setnombre(accion.getnombre().trim());
			accion.setdescripcion(accion.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresAccion(Accion accion,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && accion.getConCambioAuxiliar()) {
			accion.setIsDeleted(accion.getIsDeletedAuxiliar());	
			accion.setIsNew(accion.getIsNewAuxiliar());	
			accion.setIsChanged(accion.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			accion.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			accion.setIsDeletedAuxiliar(false);	
			accion.setIsNewAuxiliar(false);	
			accion.setIsChangedAuxiliar(false);
			
			accion.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresAccions(List<Accion> accions,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Accion accion : accions) {
			if(conAsignarBase && accion.getConCambioAuxiliar()) {
				accion.setIsDeleted(accion.getIsDeletedAuxiliar());	
				accion.setIsNew(accion.getIsNewAuxiliar());	
				accion.setIsChanged(accion.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				accion.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				accion.setIsDeletedAuxiliar(false);	
				accion.setIsNewAuxiliar(false);	
				accion.setIsChangedAuxiliar(false);
				
				accion.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresAccion(Accion accion,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
			accion.setorden(0);
		}
	}		
	
	public static void InicializarValoresAccions(List<Accion> accions,Boolean conEnteros) throws Exception  {
		
		for(Accion accion: accions) {
		
			if(conEnteros) {
				Short ish_value=0;
				
				accion.setorden(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaAccion(List<Accion> accions,Accion accionAux) throws Exception  {
		AccionConstantesFunciones.InicializarValoresAccion(accionAux,true);
		
		for(Accion accion: accions) {
			if(accion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			accionAux.setorden(accionAux.getorden()+accion.getorden());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesAccion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=AccionConstantesFunciones.getArrayColumnasGlobalesAccion(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesAccion(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoAccion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Accion> accions,Accion accion,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Accion accionAux: accions) {
			if(accionAux!=null && accion!=null) {
				if((accionAux.getId()==null && accion.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(accionAux.getId()!=null && accion.getId()!=null){
					if(accionAux.getId().equals(accion.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaAccion(List<Accion> accions) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Accion accion: accions) {			
			if(accion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaAccion() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,AccionConstantesFunciones.LABEL_ID, AccionConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AccionConstantesFunciones.LABEL_VERSIONROW, AccionConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AccionConstantesFunciones.LABEL_IDOPCION, AccionConstantesFunciones.IDOPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AccionConstantesFunciones.LABEL_CODIGO, AccionConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AccionConstantesFunciones.LABEL_NOMBRE, AccionConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AccionConstantesFunciones.LABEL_SOLOFORM, AccionConstantesFunciones.SOLOFORM,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AccionConstantesFunciones.LABEL_DESCRIPCION, AccionConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AccionConstantesFunciones.LABEL_ORDEN, AccionConstantesFunciones.ORDEN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AccionConstantesFunciones.LABEL_ESTADO, AccionConstantesFunciones.ESTADO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasAccion() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=AccionConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AccionConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AccionConstantesFunciones.IDOPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AccionConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AccionConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AccionConstantesFunciones.SOLOFORM;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AccionConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AccionConstantesFunciones.ORDEN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AccionConstantesFunciones.ESTADO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarAccion() throws Exception  {
		return AccionConstantesFunciones.getTiposSeleccionarAccion(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarAccion(Boolean conFk) throws Exception  {
		return AccionConstantesFunciones.getTiposSeleccionarAccion(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarAccion(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AccionConstantesFunciones.LABEL_IDOPCION);
			reporte.setsDescripcion(AccionConstantesFunciones.LABEL_IDOPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AccionConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(AccionConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AccionConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(AccionConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AccionConstantesFunciones.LABEL_SOLOFORM);
			reporte.setsDescripcion(AccionConstantesFunciones.LABEL_SOLOFORM);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AccionConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(AccionConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AccionConstantesFunciones.LABEL_ORDEN);
			reporte.setsDescripcion(AccionConstantesFunciones.LABEL_ORDEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AccionConstantesFunciones.LABEL_ESTADO);
			reporte.setsDescripcion(AccionConstantesFunciones.LABEL_ESTADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesAccion(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesAccion(Accion accionAux) throws Exception {
		
			accionAux.setopcion_descripcion(OpcionConstantesFunciones.getOpcionDescripcion(accionAux.getOpcion()));		
	}
	
	public static void refrescarForeignKeysDescripcionesAccion(List<Accion> accionsTemp) throws Exception {
		for(Accion accionAux:accionsTemp) {
			
			accionAux.setopcion_descripcion(OpcionConstantesFunciones.getOpcionDescripcion(accionAux.getOpcion()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfAccion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Opcion.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfAccion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Opcion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Opcion.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

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
	
	public static ArrayList<Classe> getClassesRelationshipsOfAccion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return AccionConstantesFunciones.getClassesRelationshipsOfAccion(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfAccion(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				if(conMuchosAMuchos) {classes.add(new Classe(Perfil.class));}
				classes.add(new Classe(PerfilAccion.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				if(conMuchosAMuchos) {
				for(Classe clas:classesP) {
					if(clas.clas.equals(Perfil.class)) {
						classes.add(new Classe(Perfil.class)); break;
					}
				}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(PerfilAccion.class)) {
						classes.add(new Classe(PerfilAccion.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfAccion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return AccionConstantesFunciones.getClassesRelationshipsFromStringsOfAccion(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfAccion(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(conMuchosAMuchos && Perfil.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Perfil.class)); continue;
					}

					if(PerfilAccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PerfilAccion.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(conMuchosAMuchos && Perfil.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Perfil.class)); continue;
					}

					if(PerfilAccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PerfilAccion.class)); continue;
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
	public static void actualizarLista(Accion accion,List<Accion> accions,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Accion accionEncontrado=null;
			
			for(Accion accionLocal:accions) {
				if(accionLocal.getId().equals(accion.getId())) {
					accionEncontrado=accionLocal;
					
					accionLocal.setIsChanged(accion.getIsChanged());
					accionLocal.setIsNew(accion.getIsNew());
					accionLocal.setIsDeleted(accion.getIsDeleted());
					
					accionLocal.setGeneralEntityOriginal(accion.getGeneralEntityOriginal());
					
					accionLocal.setId(accion.getId());	
					accionLocal.setVersionRow(accion.getVersionRow());	
					accionLocal.setid_opcion(accion.getid_opcion());	
					accionLocal.setcodigo(accion.getcodigo());	
					accionLocal.setnombre(accion.getnombre());	
					accionLocal.setsolo_form(accion.getsolo_form());	
					accionLocal.setdescripcion(accion.getdescripcion());	
					accionLocal.setorden(accion.getorden());	
					accionLocal.setestado(accion.getestado());	
					
					
					accionLocal.setPerfilAccions(accion.getPerfilAccions());
					
					existe=true;
					break;
				}
			}
			
			if(!accion.getIsDeleted()) {
				if(!existe) {
					accions.add(accion);
				}
			} else {
				if(accionEncontrado!=null && permiteQuitar)  {
					accions.remove(accionEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Accion accion,List<Accion> accions) throws Exception {
		try	{			
			for(Accion accionLocal:accions) {
				if(accionLocal.getId().equals(accion.getId())) {
					accionLocal.setIsSelected(accion.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesAccion(List<Accion> accionsAux) throws Exception {
		//this.accionsAux=accionsAux;
		
		for(Accion accionAux:accionsAux) {
			if(accionAux.getIsChanged()) {
				accionAux.setIsChanged(false);
			}		
			
			if(accionAux.getIsNew()) {
				accionAux.setIsNew(false);
			}	
			
			if(accionAux.getIsDeleted()) {
				accionAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesAccion(Accion accionAux) throws Exception {
		//this.accionAux=accionAux;
		
			if(accionAux.getIsChanged()) {
				accionAux.setIsChanged(false);
			}		
			
			if(accionAux.getIsNew()) {
				accionAux.setIsNew(false);
			}	
			
			if(accionAux.getIsDeleted()) {
				accionAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Accion accionAsignar,Accion accion) throws Exception {
		accionAsignar.setId(accion.getId());	
		accionAsignar.setVersionRow(accion.getVersionRow());	
		accionAsignar.setid_opcion(accion.getid_opcion());
		accionAsignar.setopcion_descripcion(accion.getopcion_descripcion());	
		accionAsignar.setcodigo(accion.getcodigo());	
		accionAsignar.setnombre(accion.getnombre());	
		accionAsignar.setsolo_form(accion.getsolo_form());	
		accionAsignar.setdescripcion(accion.getdescripcion());	
		accionAsignar.setorden(accion.getorden());	
		accionAsignar.setestado(accion.getestado());	
	}
	
	public static void inicializarAccion(Accion accion) throws Exception {
		try {
				accion.setId(0L);	
					
				accion.setid_opcion(-1L);	
				accion.setcodigo("");	
				accion.setnombre("");	
				accion.setsolo_form(false);	
				accion.setdescripcion("");	
				accion.setorden(0);	
				accion.setestado(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderAccion(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(AccionConstantesFunciones.LABEL_IDOPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AccionConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AccionConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AccionConstantesFunciones.LABEL_SOLOFORM);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AccionConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AccionConstantesFunciones.LABEL_ORDEN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AccionConstantesFunciones.LABEL_ESTADO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataAccion(String sTipo,Row row,Workbook workbook,Accion accion,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(accion.getopcion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(accion.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(accion.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(accion.getsolo_form()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(accion.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(accion.getorden());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(accion.getestado()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryAccion=Constantes.SFINALQUERY;
	
	public String getsFinalQueryAccion() {
		return this.sFinalQueryAccion;
	}
	
	public void setsFinalQueryAccion(String sFinalQueryAccion) {
		this.sFinalQueryAccion= sFinalQueryAccion;
	}
	
	public Border resaltarSeleccionarAccion=null;
	
	public Border setResaltarSeleccionarAccion(ParametroGeneralUsuario parametroGeneralUsuario/*AccionBeanSwingJInternalFrame accionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//accionBeanSwingJInternalFrame.jTtoolBarAccion.setBorder(borderResaltar);
		
		this.resaltarSeleccionarAccion= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarAccion() {
		return this.resaltarSeleccionarAccion;
	}
	
	public void setResaltarSeleccionarAccion(Border borderResaltarSeleccionarAccion) {
		this.resaltarSeleccionarAccion= borderResaltarSeleccionarAccion;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridAccion=null;
	public Boolean mostraridAccion=true;
	public Boolean activaridAccion=true;

	public Border resaltarid_opcionAccion=null;
	public Boolean mostrarid_opcionAccion=true;
	public Boolean activarid_opcionAccion=true;
	public Boolean cargarid_opcionAccion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_opcionAccion=false;//ConEventDepend=true

	public Border resaltarcodigoAccion=null;
	public Boolean mostrarcodigoAccion=true;
	public Boolean activarcodigoAccion=true;

	public Border resaltarnombreAccion=null;
	public Boolean mostrarnombreAccion=true;
	public Boolean activarnombreAccion=true;

	public Border resaltarsolo_formAccion=null;
	public Boolean mostrarsolo_formAccion=true;
	public Boolean activarsolo_formAccion=true;

	public Border resaltardescripcionAccion=null;
	public Boolean mostrardescripcionAccion=true;
	public Boolean activardescripcionAccion=true;

	public Border resaltarordenAccion=null;
	public Boolean mostrarordenAccion=true;
	public Boolean activarordenAccion=true;

	public Border resaltarestadoAccion=null;
	public Boolean mostrarestadoAccion=true;
	public Boolean activarestadoAccion=true;

	
	

	public Border setResaltaridAccion(ParametroGeneralUsuario parametroGeneralUsuario/*AccionBeanSwingJInternalFrame accionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//accionBeanSwingJInternalFrame.jTtoolBarAccion.setBorder(borderResaltar);
		
		this.resaltaridAccion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridAccion() {
		return this.resaltaridAccion;
	}

	public void setResaltaridAccion(Border borderResaltar) {
		this.resaltaridAccion= borderResaltar;
	}

	public Boolean getMostraridAccion() {
		return this.mostraridAccion;
	}

	public void setMostraridAccion(Boolean mostraridAccion) {
		this.mostraridAccion= mostraridAccion;
	}

	public Boolean getActivaridAccion() {
		return this.activaridAccion;
	}

	public void setActivaridAccion(Boolean activaridAccion) {
		this.activaridAccion= activaridAccion;
	}

	public Border setResaltarid_opcionAccion(ParametroGeneralUsuario parametroGeneralUsuario/*AccionBeanSwingJInternalFrame accionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//accionBeanSwingJInternalFrame.jTtoolBarAccion.setBorder(borderResaltar);
		
		this.resaltarid_opcionAccion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_opcionAccion() {
		return this.resaltarid_opcionAccion;
	}

	public void setResaltarid_opcionAccion(Border borderResaltar) {
		this.resaltarid_opcionAccion= borderResaltar;
	}

	public Boolean getMostrarid_opcionAccion() {
		return this.mostrarid_opcionAccion;
	}

	public void setMostrarid_opcionAccion(Boolean mostrarid_opcionAccion) {
		this.mostrarid_opcionAccion= mostrarid_opcionAccion;
	}

	public Boolean getActivarid_opcionAccion() {
		return this.activarid_opcionAccion;
	}

	public void setActivarid_opcionAccion(Boolean activarid_opcionAccion) {
		this.activarid_opcionAccion= activarid_opcionAccion;
	}

	public Boolean getCargarid_opcionAccion() {
		return this.cargarid_opcionAccion;
	}

	public void setCargarid_opcionAccion(Boolean cargarid_opcionAccion) {
		this.cargarid_opcionAccion= cargarid_opcionAccion;
	}

	public Border setResaltarcodigoAccion(ParametroGeneralUsuario parametroGeneralUsuario/*AccionBeanSwingJInternalFrame accionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//accionBeanSwingJInternalFrame.jTtoolBarAccion.setBorder(borderResaltar);
		
		this.resaltarcodigoAccion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoAccion() {
		return this.resaltarcodigoAccion;
	}

	public void setResaltarcodigoAccion(Border borderResaltar) {
		this.resaltarcodigoAccion= borderResaltar;
	}

	public Boolean getMostrarcodigoAccion() {
		return this.mostrarcodigoAccion;
	}

	public void setMostrarcodigoAccion(Boolean mostrarcodigoAccion) {
		this.mostrarcodigoAccion= mostrarcodigoAccion;
	}

	public Boolean getActivarcodigoAccion() {
		return this.activarcodigoAccion;
	}

	public void setActivarcodigoAccion(Boolean activarcodigoAccion) {
		this.activarcodigoAccion= activarcodigoAccion;
	}

	public Border setResaltarnombreAccion(ParametroGeneralUsuario parametroGeneralUsuario/*AccionBeanSwingJInternalFrame accionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//accionBeanSwingJInternalFrame.jTtoolBarAccion.setBorder(borderResaltar);
		
		this.resaltarnombreAccion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreAccion() {
		return this.resaltarnombreAccion;
	}

	public void setResaltarnombreAccion(Border borderResaltar) {
		this.resaltarnombreAccion= borderResaltar;
	}

	public Boolean getMostrarnombreAccion() {
		return this.mostrarnombreAccion;
	}

	public void setMostrarnombreAccion(Boolean mostrarnombreAccion) {
		this.mostrarnombreAccion= mostrarnombreAccion;
	}

	public Boolean getActivarnombreAccion() {
		return this.activarnombreAccion;
	}

	public void setActivarnombreAccion(Boolean activarnombreAccion) {
		this.activarnombreAccion= activarnombreAccion;
	}

	public Border setResaltarsolo_formAccion(ParametroGeneralUsuario parametroGeneralUsuario/*AccionBeanSwingJInternalFrame accionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//accionBeanSwingJInternalFrame.jTtoolBarAccion.setBorder(borderResaltar);
		
		this.resaltarsolo_formAccion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsolo_formAccion() {
		return this.resaltarsolo_formAccion;
	}

	public void setResaltarsolo_formAccion(Border borderResaltar) {
		this.resaltarsolo_formAccion= borderResaltar;
	}

	public Boolean getMostrarsolo_formAccion() {
		return this.mostrarsolo_formAccion;
	}

	public void setMostrarsolo_formAccion(Boolean mostrarsolo_formAccion) {
		this.mostrarsolo_formAccion= mostrarsolo_formAccion;
	}

	public Boolean getActivarsolo_formAccion() {
		return this.activarsolo_formAccion;
	}

	public void setActivarsolo_formAccion(Boolean activarsolo_formAccion) {
		this.activarsolo_formAccion= activarsolo_formAccion;
	}

	public Border setResaltardescripcionAccion(ParametroGeneralUsuario parametroGeneralUsuario/*AccionBeanSwingJInternalFrame accionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//accionBeanSwingJInternalFrame.jTtoolBarAccion.setBorder(borderResaltar);
		
		this.resaltardescripcionAccion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionAccion() {
		return this.resaltardescripcionAccion;
	}

	public void setResaltardescripcionAccion(Border borderResaltar) {
		this.resaltardescripcionAccion= borderResaltar;
	}

	public Boolean getMostrardescripcionAccion() {
		return this.mostrardescripcionAccion;
	}

	public void setMostrardescripcionAccion(Boolean mostrardescripcionAccion) {
		this.mostrardescripcionAccion= mostrardescripcionAccion;
	}

	public Boolean getActivardescripcionAccion() {
		return this.activardescripcionAccion;
	}

	public void setActivardescripcionAccion(Boolean activardescripcionAccion) {
		this.activardescripcionAccion= activardescripcionAccion;
	}

	public Border setResaltarordenAccion(ParametroGeneralUsuario parametroGeneralUsuario/*AccionBeanSwingJInternalFrame accionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//accionBeanSwingJInternalFrame.jTtoolBarAccion.setBorder(borderResaltar);
		
		this.resaltarordenAccion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarordenAccion() {
		return this.resaltarordenAccion;
	}

	public void setResaltarordenAccion(Border borderResaltar) {
		this.resaltarordenAccion= borderResaltar;
	}

	public Boolean getMostrarordenAccion() {
		return this.mostrarordenAccion;
	}

	public void setMostrarordenAccion(Boolean mostrarordenAccion) {
		this.mostrarordenAccion= mostrarordenAccion;
	}

	public Boolean getActivarordenAccion() {
		return this.activarordenAccion;
	}

	public void setActivarordenAccion(Boolean activarordenAccion) {
		this.activarordenAccion= activarordenAccion;
	}

	public Border setResaltarestadoAccion(ParametroGeneralUsuario parametroGeneralUsuario/*AccionBeanSwingJInternalFrame accionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//accionBeanSwingJInternalFrame.jTtoolBarAccion.setBorder(borderResaltar);
		
		this.resaltarestadoAccion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarestadoAccion() {
		return this.resaltarestadoAccion;
	}

	public void setResaltarestadoAccion(Border borderResaltar) {
		this.resaltarestadoAccion= borderResaltar;
	}

	public Boolean getMostrarestadoAccion() {
		return this.mostrarestadoAccion;
	}

	public void setMostrarestadoAccion(Boolean mostrarestadoAccion) {
		this.mostrarestadoAccion= mostrarestadoAccion;
	}

	public Boolean getActivarestadoAccion() {
		return this.activarestadoAccion;
	}

	public void setActivarestadoAccion(Boolean activarestadoAccion) {
		this.activarestadoAccion= activarestadoAccion;
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
		
		
		this.setMostraridAccion(esInicial);
		this.setMostrarid_opcionAccion(esInicial);
		this.setMostrarcodigoAccion(esInicial);
		this.setMostrarnombreAccion(esInicial);
		this.setMostrarsolo_formAccion(esInicial);
		this.setMostrardescripcionAccion(esInicial);
		this.setMostrarordenAccion(esInicial);
		this.setMostrarestadoAccion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(AccionConstantesFunciones.ID)) {
				this.setMostraridAccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(AccionConstantesFunciones.IDOPCION)) {
				this.setMostrarid_opcionAccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(AccionConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoAccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(AccionConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreAccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(AccionConstantesFunciones.SOLOFORM)) {
				this.setMostrarsolo_formAccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(AccionConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionAccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(AccionConstantesFunciones.ORDEN)) {
				this.setMostrarordenAccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(AccionConstantesFunciones.ESTADO)) {
				this.setMostrarestadoAccion(esAsigna);
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
		
		
		this.setActivaridAccion(esInicial);
		this.setActivarid_opcionAccion(esInicial);
		this.setActivarcodigoAccion(esInicial);
		this.setActivarnombreAccion(esInicial);
		this.setActivarsolo_formAccion(esInicial);
		this.setActivardescripcionAccion(esInicial);
		this.setActivarordenAccion(esInicial);
		this.setActivarestadoAccion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(AccionConstantesFunciones.ID)) {
				this.setActivaridAccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(AccionConstantesFunciones.IDOPCION)) {
				this.setActivarid_opcionAccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(AccionConstantesFunciones.CODIGO)) {
				this.setActivarcodigoAccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(AccionConstantesFunciones.NOMBRE)) {
				this.setActivarnombreAccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(AccionConstantesFunciones.SOLOFORM)) {
				this.setActivarsolo_formAccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(AccionConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionAccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(AccionConstantesFunciones.ORDEN)) {
				this.setActivarordenAccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(AccionConstantesFunciones.ESTADO)) {
				this.setActivarestadoAccion(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,AccionBeanSwingJInternalFrame accionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridAccion(esInicial);
		this.setResaltarid_opcionAccion(esInicial);
		this.setResaltarcodigoAccion(esInicial);
		this.setResaltarnombreAccion(esInicial);
		this.setResaltarsolo_formAccion(esInicial);
		this.setResaltardescripcionAccion(esInicial);
		this.setResaltarordenAccion(esInicial);
		this.setResaltarestadoAccion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(AccionConstantesFunciones.ID)) {
				this.setResaltaridAccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(AccionConstantesFunciones.IDOPCION)) {
				this.setResaltarid_opcionAccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(AccionConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoAccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(AccionConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreAccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(AccionConstantesFunciones.SOLOFORM)) {
				this.setResaltarsolo_formAccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(AccionConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionAccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(AccionConstantesFunciones.ORDEN)) {
				this.setResaltarordenAccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(AccionConstantesFunciones.ESTADO)) {
				this.setResaltarestadoAccion(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarPerfilAccionAccion=null;

	public Border getResaltarPerfilAccionAccion() {
		return this.resaltarPerfilAccionAccion;
	}

	public void setResaltarPerfilAccionAccion(Border borderResaltarPerfilAccion) {
		if(borderResaltarPerfilAccion!=null) {
			this.resaltarPerfilAccionAccion= borderResaltarPerfilAccion;
		}
	}

	public Border setResaltarPerfilAccionAccion(ParametroGeneralUsuario parametroGeneralUsuario/*AccionBeanSwingJInternalFrame accionBeanSwingJInternalFrame*/) {
		Border borderResaltarPerfilAccion=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//accionBeanSwingJInternalFrame.jTtoolBarAccion.setBorder(borderResaltarPerfilAccion);
			
		this.resaltarPerfilAccionAccion= borderResaltarPerfilAccion;

		 return borderResaltarPerfilAccion;
	}



	public Boolean mostrarPerfilAccionAccion=true;

	public Boolean getMostrarPerfilAccionAccion() {
		return this.mostrarPerfilAccionAccion;
	}

	public void setMostrarPerfilAccionAccion(Boolean visibilidadResaltarPerfilAccion) {
		this.mostrarPerfilAccionAccion= visibilidadResaltarPerfilAccion;
	}



	public Boolean activarPerfilAccionAccion=true;

	public Boolean gethabilitarResaltarPerfilAccionAccion() {
		return this.activarPerfilAccionAccion;
	}

	public void setActivarPerfilAccionAccion(Boolean habilitarResaltarPerfilAccion) {
		this.activarPerfilAccionAccion= habilitarResaltarPerfilAccion;
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

		this.setMostrarPerfilAccionAccion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(PerfilAccion.class)) {
				this.setMostrarPerfilAccionAccion(esAsigna);
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

		this.setActivarPerfilAccionAccion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(PerfilAccion.class)) {
				this.setActivarPerfilAccionAccion(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,AccionBeanSwingJInternalFrame accionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarPerfilAccionAccion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(PerfilAccion.class)) {
				this.setResaltarPerfilAccionAccion(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdOpcionAccion=true;

	public Boolean getMostrarFK_IdOpcionAccion() {
		return this.mostrarFK_IdOpcionAccion;
	}

	public void setMostrarFK_IdOpcionAccion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdOpcionAccion= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdOpcionAccion=true;

	public Boolean getActivarFK_IdOpcionAccion() {
		return this.activarFK_IdOpcionAccion;
	}

	public void setActivarFK_IdOpcionAccion(Boolean habilitarResaltar) {
		this.activarFK_IdOpcionAccion= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdOpcionAccion=null;

	public Border getResaltarFK_IdOpcionAccion() {
		return this.resaltarFK_IdOpcionAccion;
	}

	public void setResaltarFK_IdOpcionAccion(Border borderResaltar) {
		this.resaltarFK_IdOpcionAccion= borderResaltar;
	}

	public void setResaltarFK_IdOpcionAccion(ParametroGeneralUsuario parametroGeneralUsuario/*AccionBeanSwingJInternalFrame accionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdOpcionAccion= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}