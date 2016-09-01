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


import com.bydan.erp.seguridad.util.CampoConstantesFunciones;
import com.bydan.erp.seguridad.util.CampoParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.CampoParameterGeneral;

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
final public class CampoConstantesFunciones extends CampoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Campo";
	public static final String SPATHOPCION="Seguridad";	
	public static final String SPATHMODULO="seguridad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Campo"+CampoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="CampoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="CampoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=CampoConstantesFunciones.SCHEMA+"_"+CampoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/CampoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=CampoConstantesFunciones.SCHEMA+"_"+CampoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=CampoConstantesFunciones.SCHEMA+"_"+CampoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/CampoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=CampoConstantesFunciones.SCHEMA+"_"+CampoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CampoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CampoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CampoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CampoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CampoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CampoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=CampoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+CampoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=CampoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+CampoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Campos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Campo";
	public static final String SCLASSWEBTITULO_LOWER="Campo";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Campo";
	public static final String OBJECTNAME="campo";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SEGURIDAD;	
	public static final String TABLENAME="campo";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select campo from "+CampoConstantesFunciones.SPERSISTENCENAME+" campo";
	public static String QUERYSELECTNATIVE="select "+CampoConstantesFunciones.SCHEMA+"."+CampoConstantesFunciones.TABLENAME+".id,"+CampoConstantesFunciones.SCHEMA+"."+CampoConstantesFunciones.TABLENAME+".version_row,"+CampoConstantesFunciones.SCHEMA+"."+CampoConstantesFunciones.TABLENAME+".id_opcion,"+CampoConstantesFunciones.SCHEMA+"."+CampoConstantesFunciones.TABLENAME+".codigo,"+CampoConstantesFunciones.SCHEMA+"."+CampoConstantesFunciones.TABLENAME+".nombre,"+CampoConstantesFunciones.SCHEMA+"."+CampoConstantesFunciones.TABLENAME+".descripcion,"+CampoConstantesFunciones.SCHEMA+"."+CampoConstantesFunciones.TABLENAME+".estado from "+CampoConstantesFunciones.SCHEMA+"."+CampoConstantesFunciones.TABLENAME;//+" as "+CampoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=true;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected CampoConstantesFuncionesAdditional campoConstantesFuncionesAdditional=null;
	
	public CampoConstantesFuncionesAdditional getCampoConstantesFuncionesAdditional() {
		return this.campoConstantesFuncionesAdditional;
	}
	
	public void setCampoConstantesFuncionesAdditional(CampoConstantesFuncionesAdditional campoConstantesFuncionesAdditional) {
		try {
			this.campoConstantesFuncionesAdditional=campoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDOPCION= "id_opcion";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String DESCRIPCION= "descripcion";
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
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
    	public static final String LABEL_ESTADO= "Estado";
		public static final String LABEL_ESTADO_LOWER= "Estado";
	
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getCampoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(CampoConstantesFunciones.IDOPCION)) {sLabelColumna=CampoConstantesFunciones.LABEL_IDOPCION;}
		if(sNombreColumna.equals(CampoConstantesFunciones.CODIGO)) {sLabelColumna=CampoConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(CampoConstantesFunciones.NOMBRE)) {sLabelColumna=CampoConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(CampoConstantesFunciones.DESCRIPCION)) {sLabelColumna=CampoConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(CampoConstantesFunciones.ESTADO)) {sLabelColumna=CampoConstantesFunciones.LABEL_ESTADO;}
		
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
	
	
	
			
			
			
			
			
			
		
	public static String getestadoDescripcion(Campo campo) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!campo.getestado()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getestadoHtmlDescripcion(Campo campo) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(campo.getId(),campo.getestado());

		return sDescripcion;
	}	
	
	public static String getCampoDescripcion(Campo campo) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(campo !=null/* && campo.getId()!=0*/) {
			sDescripcion=campo.getcodigo();//campocampo.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getCampoDescripcionDetallado(Campo campo) {
		String sDescripcion="";
			
		sDescripcion+=CampoConstantesFunciones.ID+"=";
		sDescripcion+=campo.getId().toString()+",";
		sDescripcion+=CampoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=campo.getVersionRow().toString()+",";
		sDescripcion+=CampoConstantesFunciones.IDOPCION+"=";
		sDescripcion+=campo.getid_opcion().toString()+",";
		sDescripcion+=CampoConstantesFunciones.CODIGO+"=";
		sDescripcion+=campo.getcodigo()+",";
		sDescripcion+=CampoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=campo.getnombre()+",";
		sDescripcion+=CampoConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=campo.getdescripcion()+",";
		sDescripcion+=CampoConstantesFunciones.ESTADO+"=";
		sDescripcion+=campo.getestado().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setCampoDescripcion(Campo campo,String sValor) throws Exception {			
		if(campo !=null) {
			campo.setcodigo(sValor);;//campocampo.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosCampo(Campo campo,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		campo.setcodigo(campo.getcodigo().trim());
		campo.setnombre(campo.getnombre().trim());
		campo.setdescripcion(campo.getdescripcion().trim());
	}
	
	public static void quitarEspaciosCampos(List<Campo> campos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Campo campo: campos) {
			campo.setcodigo(campo.getcodigo().trim());
			campo.setnombre(campo.getnombre().trim());
			campo.setdescripcion(campo.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCampo(Campo campo,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && campo.getConCambioAuxiliar()) {
			campo.setIsDeleted(campo.getIsDeletedAuxiliar());	
			campo.setIsNew(campo.getIsNewAuxiliar());	
			campo.setIsChanged(campo.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			campo.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			campo.setIsDeletedAuxiliar(false);	
			campo.setIsNewAuxiliar(false);	
			campo.setIsChangedAuxiliar(false);
			
			campo.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCampos(List<Campo> campos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Campo campo : campos) {
			if(conAsignarBase && campo.getConCambioAuxiliar()) {
				campo.setIsDeleted(campo.getIsDeletedAuxiliar());	
				campo.setIsNew(campo.getIsNewAuxiliar());	
				campo.setIsChanged(campo.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				campo.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				campo.setIsDeletedAuxiliar(false);	
				campo.setIsNewAuxiliar(false);	
				campo.setIsChangedAuxiliar(false);
				
				campo.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresCampo(Campo campo,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresCampos(List<Campo> campos,Boolean conEnteros) throws Exception  {
		
		for(Campo campo: campos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaCampo(List<Campo> campos,Campo campoAux) throws Exception  {
		CampoConstantesFunciones.InicializarValoresCampo(campoAux,true);
		
		for(Campo campo: campos) {
			if(campo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCampo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=CampoConstantesFunciones.getArrayColumnasGlobalesCampo(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesCampo(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoCampo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Campo> campos,Campo campo,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Campo campoAux: campos) {
			if(campoAux!=null && campo!=null) {
				if((campoAux.getId()==null && campo.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(campoAux.getId()!=null && campo.getId()!=null){
					if(campoAux.getId().equals(campo.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCampo(List<Campo> campos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Campo campo: campos) {			
			if(campo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaCampo() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,CampoConstantesFunciones.LABEL_ID, CampoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CampoConstantesFunciones.LABEL_VERSIONROW, CampoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CampoConstantesFunciones.LABEL_IDOPCION, CampoConstantesFunciones.IDOPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CampoConstantesFunciones.LABEL_CODIGO, CampoConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CampoConstantesFunciones.LABEL_NOMBRE, CampoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CampoConstantesFunciones.LABEL_DESCRIPCION, CampoConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CampoConstantesFunciones.LABEL_ESTADO, CampoConstantesFunciones.ESTADO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasCampo() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=CampoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CampoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CampoConstantesFunciones.IDOPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CampoConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CampoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CampoConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CampoConstantesFunciones.ESTADO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCampo() throws Exception  {
		return CampoConstantesFunciones.getTiposSeleccionarCampo(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCampo(Boolean conFk) throws Exception  {
		return CampoConstantesFunciones.getTiposSeleccionarCampo(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCampo(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CampoConstantesFunciones.LABEL_IDOPCION);
			reporte.setsDescripcion(CampoConstantesFunciones.LABEL_IDOPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CampoConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(CampoConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CampoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(CampoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CampoConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(CampoConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CampoConstantesFunciones.LABEL_ESTADO);
			reporte.setsDescripcion(CampoConstantesFunciones.LABEL_ESTADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesCampo(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesCampo(Campo campoAux) throws Exception {
		
			campoAux.setopcion_descripcion(OpcionConstantesFunciones.getOpcionDescripcion(campoAux.getOpcion()));		
	}
	
	public static void refrescarForeignKeysDescripcionesCampo(List<Campo> camposTemp) throws Exception {
		for(Campo campoAux:camposTemp) {
			
			campoAux.setopcion_descripcion(OpcionConstantesFunciones.getOpcionDescripcion(campoAux.getOpcion()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfCampo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfCampo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfCampo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return CampoConstantesFunciones.getClassesRelationshipsOfCampo(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCampo(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(PerfilCampo.class));
				if(conMuchosAMuchos) {classes.add(new Classe(Perfil.class));}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(PerfilCampo.class)) {
						classes.add(new Classe(PerfilCampo.class)); break;
					}
				}

				if(conMuchosAMuchos) {
				for(Classe clas:classesP) {
					if(clas.clas.equals(Perfil.class)) {
						classes.add(new Classe(Perfil.class)); break;
					}
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCampo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return CampoConstantesFunciones.getClassesRelationshipsFromStringsOfCampo(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCampo(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(PerfilCampo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PerfilCampo.class)); continue;
					}

					if(conMuchosAMuchos && Perfil.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Perfil.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(PerfilCampo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PerfilCampo.class)); continue;
					}

					if(conMuchosAMuchos && Perfil.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Perfil.class)); continue;
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
	public static void actualizarLista(Campo campo,List<Campo> campos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Campo campoEncontrado=null;
			
			for(Campo campoLocal:campos) {
				if(campoLocal.getId().equals(campo.getId())) {
					campoEncontrado=campoLocal;
					
					campoLocal.setIsChanged(campo.getIsChanged());
					campoLocal.setIsNew(campo.getIsNew());
					campoLocal.setIsDeleted(campo.getIsDeleted());
					
					campoLocal.setGeneralEntityOriginal(campo.getGeneralEntityOriginal());
					
					campoLocal.setId(campo.getId());	
					campoLocal.setVersionRow(campo.getVersionRow());	
					campoLocal.setid_opcion(campo.getid_opcion());	
					campoLocal.setcodigo(campo.getcodigo());	
					campoLocal.setnombre(campo.getnombre());	
					campoLocal.setdescripcion(campo.getdescripcion());	
					campoLocal.setestado(campo.getestado());	
					
					
					campoLocal.setPerfilCampos(campo.getPerfilCampos());
					
					existe=true;
					break;
				}
			}
			
			if(!campo.getIsDeleted()) {
				if(!existe) {
					campos.add(campo);
				}
			} else {
				if(campoEncontrado!=null && permiteQuitar)  {
					campos.remove(campoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Campo campo,List<Campo> campos) throws Exception {
		try	{			
			for(Campo campoLocal:campos) {
				if(campoLocal.getId().equals(campo.getId())) {
					campoLocal.setIsSelected(campo.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesCampo(List<Campo> camposAux) throws Exception {
		//this.camposAux=camposAux;
		
		for(Campo campoAux:camposAux) {
			if(campoAux.getIsChanged()) {
				campoAux.setIsChanged(false);
			}		
			
			if(campoAux.getIsNew()) {
				campoAux.setIsNew(false);
			}	
			
			if(campoAux.getIsDeleted()) {
				campoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesCampo(Campo campoAux) throws Exception {
		//this.campoAux=campoAux;
		
			if(campoAux.getIsChanged()) {
				campoAux.setIsChanged(false);
			}		
			
			if(campoAux.getIsNew()) {
				campoAux.setIsNew(false);
			}	
			
			if(campoAux.getIsDeleted()) {
				campoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Campo campoAsignar,Campo campo) throws Exception {
		campoAsignar.setId(campo.getId());	
		campoAsignar.setVersionRow(campo.getVersionRow());	
		campoAsignar.setid_opcion(campo.getid_opcion());
		campoAsignar.setopcion_descripcion(campo.getopcion_descripcion());	
		campoAsignar.setcodigo(campo.getcodigo());	
		campoAsignar.setnombre(campo.getnombre());	
		campoAsignar.setdescripcion(campo.getdescripcion());	
		campoAsignar.setestado(campo.getestado());	
	}
	
	public static void inicializarCampo(Campo campo) throws Exception {
		try {
				campo.setId(0L);	
					
				campo.setid_opcion(-1L);	
				campo.setcodigo("");	
				campo.setnombre("");	
				campo.setdescripcion("");	
				campo.setestado(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderCampo(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(CampoConstantesFunciones.LABEL_IDOPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CampoConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CampoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CampoConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CampoConstantesFunciones.LABEL_ESTADO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataCampo(String sTipo,Row row,Workbook workbook,Campo campo,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(campo.getopcion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(campo.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(campo.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(campo.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(campo.getestado()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryCampo=Constantes.SFINALQUERY;
	
	public String getsFinalQueryCampo() {
		return this.sFinalQueryCampo;
	}
	
	public void setsFinalQueryCampo(String sFinalQueryCampo) {
		this.sFinalQueryCampo= sFinalQueryCampo;
	}
	
	public Border resaltarSeleccionarCampo=null;
	
	public Border setResaltarSeleccionarCampo(ParametroGeneralUsuario parametroGeneralUsuario/*CampoBeanSwingJInternalFrame campoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//campoBeanSwingJInternalFrame.jTtoolBarCampo.setBorder(borderResaltar);
		
		this.resaltarSeleccionarCampo= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarCampo() {
		return this.resaltarSeleccionarCampo;
	}
	
	public void setResaltarSeleccionarCampo(Border borderResaltarSeleccionarCampo) {
		this.resaltarSeleccionarCampo= borderResaltarSeleccionarCampo;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridCampo=null;
	public Boolean mostraridCampo=true;
	public Boolean activaridCampo=true;

	public Border resaltarid_opcionCampo=null;
	public Boolean mostrarid_opcionCampo=true;
	public Boolean activarid_opcionCampo=true;
	public Boolean cargarid_opcionCampo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_opcionCampo=false;//ConEventDepend=true

	public Border resaltarcodigoCampo=null;
	public Boolean mostrarcodigoCampo=true;
	public Boolean activarcodigoCampo=true;

	public Border resaltarnombreCampo=null;
	public Boolean mostrarnombreCampo=true;
	public Boolean activarnombreCampo=true;

	public Border resaltardescripcionCampo=null;
	public Boolean mostrardescripcionCampo=true;
	public Boolean activardescripcionCampo=true;

	public Border resaltarestadoCampo=null;
	public Boolean mostrarestadoCampo=true;
	public Boolean activarestadoCampo=true;

	
	

	public Border setResaltaridCampo(ParametroGeneralUsuario parametroGeneralUsuario/*CampoBeanSwingJInternalFrame campoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//campoBeanSwingJInternalFrame.jTtoolBarCampo.setBorder(borderResaltar);
		
		this.resaltaridCampo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridCampo() {
		return this.resaltaridCampo;
	}

	public void setResaltaridCampo(Border borderResaltar) {
		this.resaltaridCampo= borderResaltar;
	}

	public Boolean getMostraridCampo() {
		return this.mostraridCampo;
	}

	public void setMostraridCampo(Boolean mostraridCampo) {
		this.mostraridCampo= mostraridCampo;
	}

	public Boolean getActivaridCampo() {
		return this.activaridCampo;
	}

	public void setActivaridCampo(Boolean activaridCampo) {
		this.activaridCampo= activaridCampo;
	}

	public Border setResaltarid_opcionCampo(ParametroGeneralUsuario parametroGeneralUsuario/*CampoBeanSwingJInternalFrame campoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//campoBeanSwingJInternalFrame.jTtoolBarCampo.setBorder(borderResaltar);
		
		this.resaltarid_opcionCampo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_opcionCampo() {
		return this.resaltarid_opcionCampo;
	}

	public void setResaltarid_opcionCampo(Border borderResaltar) {
		this.resaltarid_opcionCampo= borderResaltar;
	}

	public Boolean getMostrarid_opcionCampo() {
		return this.mostrarid_opcionCampo;
	}

	public void setMostrarid_opcionCampo(Boolean mostrarid_opcionCampo) {
		this.mostrarid_opcionCampo= mostrarid_opcionCampo;
	}

	public Boolean getActivarid_opcionCampo() {
		return this.activarid_opcionCampo;
	}

	public void setActivarid_opcionCampo(Boolean activarid_opcionCampo) {
		this.activarid_opcionCampo= activarid_opcionCampo;
	}

	public Boolean getCargarid_opcionCampo() {
		return this.cargarid_opcionCampo;
	}

	public void setCargarid_opcionCampo(Boolean cargarid_opcionCampo) {
		this.cargarid_opcionCampo= cargarid_opcionCampo;
	}

	public Border setResaltarcodigoCampo(ParametroGeneralUsuario parametroGeneralUsuario/*CampoBeanSwingJInternalFrame campoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//campoBeanSwingJInternalFrame.jTtoolBarCampo.setBorder(borderResaltar);
		
		this.resaltarcodigoCampo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoCampo() {
		return this.resaltarcodigoCampo;
	}

	public void setResaltarcodigoCampo(Border borderResaltar) {
		this.resaltarcodigoCampo= borderResaltar;
	}

	public Boolean getMostrarcodigoCampo() {
		return this.mostrarcodigoCampo;
	}

	public void setMostrarcodigoCampo(Boolean mostrarcodigoCampo) {
		this.mostrarcodigoCampo= mostrarcodigoCampo;
	}

	public Boolean getActivarcodigoCampo() {
		return this.activarcodigoCampo;
	}

	public void setActivarcodigoCampo(Boolean activarcodigoCampo) {
		this.activarcodigoCampo= activarcodigoCampo;
	}

	public Border setResaltarnombreCampo(ParametroGeneralUsuario parametroGeneralUsuario/*CampoBeanSwingJInternalFrame campoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//campoBeanSwingJInternalFrame.jTtoolBarCampo.setBorder(borderResaltar);
		
		this.resaltarnombreCampo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreCampo() {
		return this.resaltarnombreCampo;
	}

	public void setResaltarnombreCampo(Border borderResaltar) {
		this.resaltarnombreCampo= borderResaltar;
	}

	public Boolean getMostrarnombreCampo() {
		return this.mostrarnombreCampo;
	}

	public void setMostrarnombreCampo(Boolean mostrarnombreCampo) {
		this.mostrarnombreCampo= mostrarnombreCampo;
	}

	public Boolean getActivarnombreCampo() {
		return this.activarnombreCampo;
	}

	public void setActivarnombreCampo(Boolean activarnombreCampo) {
		this.activarnombreCampo= activarnombreCampo;
	}

	public Border setResaltardescripcionCampo(ParametroGeneralUsuario parametroGeneralUsuario/*CampoBeanSwingJInternalFrame campoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//campoBeanSwingJInternalFrame.jTtoolBarCampo.setBorder(borderResaltar);
		
		this.resaltardescripcionCampo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionCampo() {
		return this.resaltardescripcionCampo;
	}

	public void setResaltardescripcionCampo(Border borderResaltar) {
		this.resaltardescripcionCampo= borderResaltar;
	}

	public Boolean getMostrardescripcionCampo() {
		return this.mostrardescripcionCampo;
	}

	public void setMostrardescripcionCampo(Boolean mostrardescripcionCampo) {
		this.mostrardescripcionCampo= mostrardescripcionCampo;
	}

	public Boolean getActivardescripcionCampo() {
		return this.activardescripcionCampo;
	}

	public void setActivardescripcionCampo(Boolean activardescripcionCampo) {
		this.activardescripcionCampo= activardescripcionCampo;
	}

	public Border setResaltarestadoCampo(ParametroGeneralUsuario parametroGeneralUsuario/*CampoBeanSwingJInternalFrame campoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//campoBeanSwingJInternalFrame.jTtoolBarCampo.setBorder(borderResaltar);
		
		this.resaltarestadoCampo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarestadoCampo() {
		return this.resaltarestadoCampo;
	}

	public void setResaltarestadoCampo(Border borderResaltar) {
		this.resaltarestadoCampo= borderResaltar;
	}

	public Boolean getMostrarestadoCampo() {
		return this.mostrarestadoCampo;
	}

	public void setMostrarestadoCampo(Boolean mostrarestadoCampo) {
		this.mostrarestadoCampo= mostrarestadoCampo;
	}

	public Boolean getActivarestadoCampo() {
		return this.activarestadoCampo;
	}

	public void setActivarestadoCampo(Boolean activarestadoCampo) {
		this.activarestadoCampo= activarestadoCampo;
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
		
		
		this.setMostraridCampo(esInicial);
		this.setMostrarid_opcionCampo(esInicial);
		this.setMostrarcodigoCampo(esInicial);
		this.setMostrarnombreCampo(esInicial);
		this.setMostrardescripcionCampo(esInicial);
		this.setMostrarestadoCampo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CampoConstantesFunciones.ID)) {
				this.setMostraridCampo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CampoConstantesFunciones.IDOPCION)) {
				this.setMostrarid_opcionCampo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CampoConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoCampo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CampoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreCampo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CampoConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionCampo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CampoConstantesFunciones.ESTADO)) {
				this.setMostrarestadoCampo(esAsigna);
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
		
		
		this.setActivaridCampo(esInicial);
		this.setActivarid_opcionCampo(esInicial);
		this.setActivarcodigoCampo(esInicial);
		this.setActivarnombreCampo(esInicial);
		this.setActivardescripcionCampo(esInicial);
		this.setActivarestadoCampo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CampoConstantesFunciones.ID)) {
				this.setActivaridCampo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CampoConstantesFunciones.IDOPCION)) {
				this.setActivarid_opcionCampo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CampoConstantesFunciones.CODIGO)) {
				this.setActivarcodigoCampo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CampoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreCampo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CampoConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionCampo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CampoConstantesFunciones.ESTADO)) {
				this.setActivarestadoCampo(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,CampoBeanSwingJInternalFrame campoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridCampo(esInicial);
		this.setResaltarid_opcionCampo(esInicial);
		this.setResaltarcodigoCampo(esInicial);
		this.setResaltarnombreCampo(esInicial);
		this.setResaltardescripcionCampo(esInicial);
		this.setResaltarestadoCampo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CampoConstantesFunciones.ID)) {
				this.setResaltaridCampo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CampoConstantesFunciones.IDOPCION)) {
				this.setResaltarid_opcionCampo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CampoConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoCampo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CampoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreCampo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CampoConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionCampo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CampoConstantesFunciones.ESTADO)) {
				this.setResaltarestadoCampo(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarPerfilCampoCampo=null;

	public Border getResaltarPerfilCampoCampo() {
		return this.resaltarPerfilCampoCampo;
	}

	public void setResaltarPerfilCampoCampo(Border borderResaltarPerfilCampo) {
		if(borderResaltarPerfilCampo!=null) {
			this.resaltarPerfilCampoCampo= borderResaltarPerfilCampo;
		}
	}

	public Border setResaltarPerfilCampoCampo(ParametroGeneralUsuario parametroGeneralUsuario/*CampoBeanSwingJInternalFrame campoBeanSwingJInternalFrame*/) {
		Border borderResaltarPerfilCampo=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//campoBeanSwingJInternalFrame.jTtoolBarCampo.setBorder(borderResaltarPerfilCampo);
			
		this.resaltarPerfilCampoCampo= borderResaltarPerfilCampo;

		 return borderResaltarPerfilCampo;
	}



	public Boolean mostrarPerfilCampoCampo=true;

	public Boolean getMostrarPerfilCampoCampo() {
		return this.mostrarPerfilCampoCampo;
	}

	public void setMostrarPerfilCampoCampo(Boolean visibilidadResaltarPerfilCampo) {
		this.mostrarPerfilCampoCampo= visibilidadResaltarPerfilCampo;
	}



	public Boolean activarPerfilCampoCampo=true;

	public Boolean gethabilitarResaltarPerfilCampoCampo() {
		return this.activarPerfilCampoCampo;
	}

	public void setActivarPerfilCampoCampo(Boolean habilitarResaltarPerfilCampo) {
		this.activarPerfilCampoCampo= habilitarResaltarPerfilCampo;
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

		this.setMostrarPerfilCampoCampo(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(PerfilCampo.class)) {
				this.setMostrarPerfilCampoCampo(esAsigna);
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

		this.setActivarPerfilCampoCampo(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(PerfilCampo.class)) {
				this.setActivarPerfilCampoCampo(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,CampoBeanSwingJInternalFrame campoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarPerfilCampoCampo(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(PerfilCampo.class)) {
				this.setResaltarPerfilCampoCampo(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdOpcionCampo=true;

	public Boolean getMostrarFK_IdOpcionCampo() {
		return this.mostrarFK_IdOpcionCampo;
	}

	public void setMostrarFK_IdOpcionCampo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdOpcionCampo= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdOpcionCampo=true;

	public Boolean getActivarFK_IdOpcionCampo() {
		return this.activarFK_IdOpcionCampo;
	}

	public void setActivarFK_IdOpcionCampo(Boolean habilitarResaltar) {
		this.activarFK_IdOpcionCampo= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdOpcionCampo=null;

	public Border getResaltarFK_IdOpcionCampo() {
		return this.resaltarFK_IdOpcionCampo;
	}

	public void setResaltarFK_IdOpcionCampo(Border borderResaltar) {
		this.resaltarFK_IdOpcionCampo= borderResaltar;
	}

	public void setResaltarFK_IdOpcionCampo(ParametroGeneralUsuario parametroGeneralUsuario/*CampoBeanSwingJInternalFrame campoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdOpcionCampo= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}