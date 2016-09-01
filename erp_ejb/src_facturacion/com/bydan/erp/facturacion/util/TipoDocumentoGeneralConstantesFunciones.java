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
package com.bydan.erp.facturacion.util;

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


import com.bydan.erp.facturacion.util.TipoDocumentoGeneralConstantesFunciones;
import com.bydan.erp.facturacion.util.TipoDocumentoGeneralParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.TipoDocumentoGeneralParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoDocumentoGeneralConstantesFunciones extends TipoDocumentoGeneralConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoDocumentoGeneral";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoDocumentoGeneral"+TipoDocumentoGeneralConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoDocumentoGeneralHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoDocumentoGeneralHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoDocumentoGeneralConstantesFunciones.SCHEMA+"_"+TipoDocumentoGeneralConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoDocumentoGeneralHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoDocumentoGeneralConstantesFunciones.SCHEMA+"_"+TipoDocumentoGeneralConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoDocumentoGeneralConstantesFunciones.SCHEMA+"_"+TipoDocumentoGeneralConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoDocumentoGeneralHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoDocumentoGeneralConstantesFunciones.SCHEMA+"_"+TipoDocumentoGeneralConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoDocumentoGeneralConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoDocumentoGeneralHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoDocumentoGeneralConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoDocumentoGeneralConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoDocumentoGeneralHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoDocumentoGeneralConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoDocumentoGeneralConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoDocumentoGeneralConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoDocumentoGeneralConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoDocumentoGeneralConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Documento Generals";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Documento General";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Documento General";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoDocumentoGeneral";
	public static final String OBJECTNAME="tipodocumentogeneral";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="tipo_documento_general";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipodocumentogeneral from "+TipoDocumentoGeneralConstantesFunciones.SPERSISTENCENAME+" tipodocumentogeneral";
	public static String QUERYSELECTNATIVE="select "+TipoDocumentoGeneralConstantesFunciones.SCHEMA+"."+TipoDocumentoGeneralConstantesFunciones.TABLENAME+".id,"+TipoDocumentoGeneralConstantesFunciones.SCHEMA+"."+TipoDocumentoGeneralConstantesFunciones.TABLENAME+".version_row,"+TipoDocumentoGeneralConstantesFunciones.SCHEMA+"."+TipoDocumentoGeneralConstantesFunciones.TABLENAME+".codigo,"+TipoDocumentoGeneralConstantesFunciones.SCHEMA+"."+TipoDocumentoGeneralConstantesFunciones.TABLENAME+".nombre from "+TipoDocumentoGeneralConstantesFunciones.SCHEMA+"."+TipoDocumentoGeneralConstantesFunciones.TABLENAME;//+" as "+TipoDocumentoGeneralConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoDocumentoGeneralConstantesFuncionesAdditional tipodocumentogeneralConstantesFuncionesAdditional=null;
	
	public TipoDocumentoGeneralConstantesFuncionesAdditional getTipoDocumentoGeneralConstantesFuncionesAdditional() {
		return this.tipodocumentogeneralConstantesFuncionesAdditional;
	}
	
	public void setTipoDocumentoGeneralConstantesFuncionesAdditional(TipoDocumentoGeneralConstantesFuncionesAdditional tipodocumentogeneralConstantesFuncionesAdditional) {
		try {
			this.tipodocumentogeneralConstantesFuncionesAdditional=tipodocumentogeneralConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getTipoDocumentoGeneralLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoDocumentoGeneralConstantesFunciones.CODIGO)) {sLabelColumna=TipoDocumentoGeneralConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoDocumentoGeneralConstantesFunciones.NOMBRE)) {sLabelColumna=TipoDocumentoGeneralConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoDocumentoGeneralDescripcion(TipoDocumentoGeneral tipodocumentogeneral) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipodocumentogeneral !=null/* && tipodocumentogeneral.getId()!=0*/) {
			sDescripcion=tipodocumentogeneral.getcodigo();//tipodocumentogeneraltipodocumentogeneral.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoDocumentoGeneralDescripcionDetallado(TipoDocumentoGeneral tipodocumentogeneral) {
		String sDescripcion="";
			
		sDescripcion+=TipoDocumentoGeneralConstantesFunciones.ID+"=";
		sDescripcion+=tipodocumentogeneral.getId().toString()+",";
		sDescripcion+=TipoDocumentoGeneralConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipodocumentogeneral.getVersionRow().toString()+",";
		sDescripcion+=TipoDocumentoGeneralConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipodocumentogeneral.getcodigo()+",";
		sDescripcion+=TipoDocumentoGeneralConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipodocumentogeneral.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoDocumentoGeneralDescripcion(TipoDocumentoGeneral tipodocumentogeneral,String sValor) throws Exception {			
		if(tipodocumentogeneral !=null) {
			tipodocumentogeneral.setcodigo(sValor);;//tipodocumentogeneraltipodocumentogeneral.getcodigo().trim();
		}		
	}
	
		
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorCodigo")) {
			sNombreIndice="Tipo=  Por Codigo";
		} else if(sNombreIndice.equals("BusquedaPorId")) {
			sNombreIndice="Tipo=  Por Id";
		} else if(sNombreIndice.equals("BusquedaPorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorCodigo(String codigo) {
		String sDetalleIndice=" Parametros->";
		if(codigo!=null) {sDetalleIndice+=" Codigo="+codigo;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorId(Long id) {
		String sDetalleIndice=" Parametros->";
		if(id!=null) {sDetalleIndice+=" Id="+id.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTipoDocumentoGeneral(TipoDocumentoGeneral tipodocumentogeneral,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipodocumentogeneral.setcodigo(tipodocumentogeneral.getcodigo().trim());
		tipodocumentogeneral.setnombre(tipodocumentogeneral.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoDocumentoGenerals(List<TipoDocumentoGeneral> tipodocumentogenerals,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoDocumentoGeneral tipodocumentogeneral: tipodocumentogenerals) {
			tipodocumentogeneral.setcodigo(tipodocumentogeneral.getcodigo().trim());
			tipodocumentogeneral.setnombre(tipodocumentogeneral.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoDocumentoGeneral(TipoDocumentoGeneral tipodocumentogeneral,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipodocumentogeneral.getConCambioAuxiliar()) {
			tipodocumentogeneral.setIsDeleted(tipodocumentogeneral.getIsDeletedAuxiliar());	
			tipodocumentogeneral.setIsNew(tipodocumentogeneral.getIsNewAuxiliar());	
			tipodocumentogeneral.setIsChanged(tipodocumentogeneral.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipodocumentogeneral.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipodocumentogeneral.setIsDeletedAuxiliar(false);	
			tipodocumentogeneral.setIsNewAuxiliar(false);	
			tipodocumentogeneral.setIsChangedAuxiliar(false);
			
			tipodocumentogeneral.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoDocumentoGenerals(List<TipoDocumentoGeneral> tipodocumentogenerals,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoDocumentoGeneral tipodocumentogeneral : tipodocumentogenerals) {
			if(conAsignarBase && tipodocumentogeneral.getConCambioAuxiliar()) {
				tipodocumentogeneral.setIsDeleted(tipodocumentogeneral.getIsDeletedAuxiliar());	
				tipodocumentogeneral.setIsNew(tipodocumentogeneral.getIsNewAuxiliar());	
				tipodocumentogeneral.setIsChanged(tipodocumentogeneral.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipodocumentogeneral.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipodocumentogeneral.setIsDeletedAuxiliar(false);	
				tipodocumentogeneral.setIsNewAuxiliar(false);	
				tipodocumentogeneral.setIsChangedAuxiliar(false);
				
				tipodocumentogeneral.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoDocumentoGeneral(TipoDocumentoGeneral tipodocumentogeneral,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoDocumentoGenerals(List<TipoDocumentoGeneral> tipodocumentogenerals,Boolean conEnteros) throws Exception  {
		
		for(TipoDocumentoGeneral tipodocumentogeneral: tipodocumentogenerals) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoDocumentoGeneral(List<TipoDocumentoGeneral> tipodocumentogenerals,TipoDocumentoGeneral tipodocumentogeneralAux) throws Exception  {
		TipoDocumentoGeneralConstantesFunciones.InicializarValoresTipoDocumentoGeneral(tipodocumentogeneralAux,true);
		
		for(TipoDocumentoGeneral tipodocumentogeneral: tipodocumentogenerals) {
			if(tipodocumentogeneral.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoDocumentoGeneral(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoDocumentoGeneralConstantesFunciones.getArrayColumnasGlobalesTipoDocumentoGeneral(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoDocumentoGeneral(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoDocumentoGeneral(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoDocumentoGeneral> tipodocumentogenerals,TipoDocumentoGeneral tipodocumentogeneral,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoDocumentoGeneral tipodocumentogeneralAux: tipodocumentogenerals) {
			if(tipodocumentogeneralAux!=null && tipodocumentogeneral!=null) {
				if((tipodocumentogeneralAux.getId()==null && tipodocumentogeneral.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipodocumentogeneralAux.getId()!=null && tipodocumentogeneral.getId()!=null){
					if(tipodocumentogeneralAux.getId().equals(tipodocumentogeneral.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoDocumentoGeneral(List<TipoDocumentoGeneral> tipodocumentogenerals) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoDocumentoGeneral tipodocumentogeneral: tipodocumentogenerals) {			
			if(tipodocumentogeneral.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoDocumentoGeneral() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoDocumentoGeneralConstantesFunciones.LABEL_ID, TipoDocumentoGeneralConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoDocumentoGeneralConstantesFunciones.LABEL_VERSIONROW, TipoDocumentoGeneralConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoDocumentoGeneralConstantesFunciones.LABEL_CODIGO, TipoDocumentoGeneralConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoDocumentoGeneralConstantesFunciones.LABEL_NOMBRE, TipoDocumentoGeneralConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoDocumentoGeneral() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoDocumentoGeneralConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoDocumentoGeneralConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoDocumentoGeneralConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoDocumentoGeneralConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoDocumentoGeneral() throws Exception  {
		return TipoDocumentoGeneralConstantesFunciones.getTiposSeleccionarTipoDocumentoGeneral(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoDocumentoGeneral(Boolean conFk) throws Exception  {
		return TipoDocumentoGeneralConstantesFunciones.getTiposSeleccionarTipoDocumentoGeneral(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoDocumentoGeneral(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoDocumentoGeneralConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoDocumentoGeneralConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoDocumentoGeneralConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoDocumentoGeneralConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoDocumentoGeneral(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoDocumentoGeneral(TipoDocumentoGeneral tipodocumentogeneralAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoDocumentoGeneral(List<TipoDocumentoGeneral> tipodocumentogeneralsTemp) throws Exception {
		for(TipoDocumentoGeneral tipodocumentogeneralAux:tipodocumentogeneralsTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoDocumentoGeneral(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoDocumentoGeneral(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoDocumentoGeneral(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoDocumentoGeneralConstantesFunciones.getClassesRelationshipsOfTipoDocumentoGeneral(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoDocumentoGeneral(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoDocumentoGeneral(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoDocumentoGeneralConstantesFunciones.getClassesRelationshipsFromStringsOfTipoDocumentoGeneral(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoDocumentoGeneral(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TipoDocumentoGeneral tipodocumentogeneral,List<TipoDocumentoGeneral> tipodocumentogenerals,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoDocumentoGeneral tipodocumentogeneralEncontrado=null;
			
			for(TipoDocumentoGeneral tipodocumentogeneralLocal:tipodocumentogenerals) {
				if(tipodocumentogeneralLocal.getId().equals(tipodocumentogeneral.getId())) {
					tipodocumentogeneralEncontrado=tipodocumentogeneralLocal;
					
					tipodocumentogeneralLocal.setIsChanged(tipodocumentogeneral.getIsChanged());
					tipodocumentogeneralLocal.setIsNew(tipodocumentogeneral.getIsNew());
					tipodocumentogeneralLocal.setIsDeleted(tipodocumentogeneral.getIsDeleted());
					
					tipodocumentogeneralLocal.setGeneralEntityOriginal(tipodocumentogeneral.getGeneralEntityOriginal());
					
					tipodocumentogeneralLocal.setId(tipodocumentogeneral.getId());	
					tipodocumentogeneralLocal.setVersionRow(tipodocumentogeneral.getVersionRow());	
					tipodocumentogeneralLocal.setcodigo(tipodocumentogeneral.getcodigo());	
					tipodocumentogeneralLocal.setnombre(tipodocumentogeneral.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipodocumentogeneral.getIsDeleted()) {
				if(!existe) {
					tipodocumentogenerals.add(tipodocumentogeneral);
				}
			} else {
				if(tipodocumentogeneralEncontrado!=null && permiteQuitar)  {
					tipodocumentogenerals.remove(tipodocumentogeneralEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoDocumentoGeneral tipodocumentogeneral,List<TipoDocumentoGeneral> tipodocumentogenerals) throws Exception {
		try	{			
			for(TipoDocumentoGeneral tipodocumentogeneralLocal:tipodocumentogenerals) {
				if(tipodocumentogeneralLocal.getId().equals(tipodocumentogeneral.getId())) {
					tipodocumentogeneralLocal.setIsSelected(tipodocumentogeneral.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoDocumentoGeneral(List<TipoDocumentoGeneral> tipodocumentogeneralsAux) throws Exception {
		//this.tipodocumentogeneralsAux=tipodocumentogeneralsAux;
		
		for(TipoDocumentoGeneral tipodocumentogeneralAux:tipodocumentogeneralsAux) {
			if(tipodocumentogeneralAux.getIsChanged()) {
				tipodocumentogeneralAux.setIsChanged(false);
			}		
			
			if(tipodocumentogeneralAux.getIsNew()) {
				tipodocumentogeneralAux.setIsNew(false);
			}	
			
			if(tipodocumentogeneralAux.getIsDeleted()) {
				tipodocumentogeneralAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoDocumentoGeneral(TipoDocumentoGeneral tipodocumentogeneralAux) throws Exception {
		//this.tipodocumentogeneralAux=tipodocumentogeneralAux;
		
			if(tipodocumentogeneralAux.getIsChanged()) {
				tipodocumentogeneralAux.setIsChanged(false);
			}		
			
			if(tipodocumentogeneralAux.getIsNew()) {
				tipodocumentogeneralAux.setIsNew(false);
			}	
			
			if(tipodocumentogeneralAux.getIsDeleted()) {
				tipodocumentogeneralAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoDocumentoGeneral tipodocumentogeneralAsignar,TipoDocumentoGeneral tipodocumentogeneral) throws Exception {
		tipodocumentogeneralAsignar.setId(tipodocumentogeneral.getId());	
		tipodocumentogeneralAsignar.setVersionRow(tipodocumentogeneral.getVersionRow());	
		tipodocumentogeneralAsignar.setcodigo(tipodocumentogeneral.getcodigo());	
		tipodocumentogeneralAsignar.setnombre(tipodocumentogeneral.getnombre());	
	}
	
	public static void inicializarTipoDocumentoGeneral(TipoDocumentoGeneral tipodocumentogeneral) throws Exception {
		try {
				tipodocumentogeneral.setId(0L);	
					
				tipodocumentogeneral.setcodigo("");	
				tipodocumentogeneral.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoDocumentoGeneral(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoDocumentoGeneralConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoDocumentoGeneralConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoDocumentoGeneral(String sTipo,Row row,Workbook workbook,TipoDocumentoGeneral tipodocumentogeneral,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipodocumentogeneral.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipodocumentogeneral.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoDocumentoGeneral=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoDocumentoGeneral() {
		return this.sFinalQueryTipoDocumentoGeneral;
	}
	
	public void setsFinalQueryTipoDocumentoGeneral(String sFinalQueryTipoDocumentoGeneral) {
		this.sFinalQueryTipoDocumentoGeneral= sFinalQueryTipoDocumentoGeneral;
	}
	
	public Border resaltarSeleccionarTipoDocumentoGeneral=null;
	
	public Border setResaltarSeleccionarTipoDocumentoGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDocumentoGeneralBeanSwingJInternalFrame tipodocumentogeneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipodocumentogeneralBeanSwingJInternalFrame.jTtoolBarTipoDocumentoGeneral.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoDocumentoGeneral= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoDocumentoGeneral() {
		return this.resaltarSeleccionarTipoDocumentoGeneral;
	}
	
	public void setResaltarSeleccionarTipoDocumentoGeneral(Border borderResaltarSeleccionarTipoDocumentoGeneral) {
		this.resaltarSeleccionarTipoDocumentoGeneral= borderResaltarSeleccionarTipoDocumentoGeneral;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoDocumentoGeneral=null;
	public Boolean mostraridTipoDocumentoGeneral=true;
	public Boolean activaridTipoDocumentoGeneral=true;

	public Border resaltarcodigoTipoDocumentoGeneral=null;
	public Boolean mostrarcodigoTipoDocumentoGeneral=true;
	public Boolean activarcodigoTipoDocumentoGeneral=true;

	public Border resaltarnombreTipoDocumentoGeneral=null;
	public Boolean mostrarnombreTipoDocumentoGeneral=true;
	public Boolean activarnombreTipoDocumentoGeneral=true;

	
	

	public Border setResaltaridTipoDocumentoGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDocumentoGeneralBeanSwingJInternalFrame tipodocumentogeneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipodocumentogeneralBeanSwingJInternalFrame.jTtoolBarTipoDocumentoGeneral.setBorder(borderResaltar);
		
		this.resaltaridTipoDocumentoGeneral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoDocumentoGeneral() {
		return this.resaltaridTipoDocumentoGeneral;
	}

	public void setResaltaridTipoDocumentoGeneral(Border borderResaltar) {
		this.resaltaridTipoDocumentoGeneral= borderResaltar;
	}

	public Boolean getMostraridTipoDocumentoGeneral() {
		return this.mostraridTipoDocumentoGeneral;
	}

	public void setMostraridTipoDocumentoGeneral(Boolean mostraridTipoDocumentoGeneral) {
		this.mostraridTipoDocumentoGeneral= mostraridTipoDocumentoGeneral;
	}

	public Boolean getActivaridTipoDocumentoGeneral() {
		return this.activaridTipoDocumentoGeneral;
	}

	public void setActivaridTipoDocumentoGeneral(Boolean activaridTipoDocumentoGeneral) {
		this.activaridTipoDocumentoGeneral= activaridTipoDocumentoGeneral;
	}

	public Border setResaltarcodigoTipoDocumentoGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDocumentoGeneralBeanSwingJInternalFrame tipodocumentogeneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipodocumentogeneralBeanSwingJInternalFrame.jTtoolBarTipoDocumentoGeneral.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoDocumentoGeneral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoDocumentoGeneral() {
		return this.resaltarcodigoTipoDocumentoGeneral;
	}

	public void setResaltarcodigoTipoDocumentoGeneral(Border borderResaltar) {
		this.resaltarcodigoTipoDocumentoGeneral= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoDocumentoGeneral() {
		return this.mostrarcodigoTipoDocumentoGeneral;
	}

	public void setMostrarcodigoTipoDocumentoGeneral(Boolean mostrarcodigoTipoDocumentoGeneral) {
		this.mostrarcodigoTipoDocumentoGeneral= mostrarcodigoTipoDocumentoGeneral;
	}

	public Boolean getActivarcodigoTipoDocumentoGeneral() {
		return this.activarcodigoTipoDocumentoGeneral;
	}

	public void setActivarcodigoTipoDocumentoGeneral(Boolean activarcodigoTipoDocumentoGeneral) {
		this.activarcodigoTipoDocumentoGeneral= activarcodigoTipoDocumentoGeneral;
	}

	public Border setResaltarnombreTipoDocumentoGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDocumentoGeneralBeanSwingJInternalFrame tipodocumentogeneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipodocumentogeneralBeanSwingJInternalFrame.jTtoolBarTipoDocumentoGeneral.setBorder(borderResaltar);
		
		this.resaltarnombreTipoDocumentoGeneral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoDocumentoGeneral() {
		return this.resaltarnombreTipoDocumentoGeneral;
	}

	public void setResaltarnombreTipoDocumentoGeneral(Border borderResaltar) {
		this.resaltarnombreTipoDocumentoGeneral= borderResaltar;
	}

	public Boolean getMostrarnombreTipoDocumentoGeneral() {
		return this.mostrarnombreTipoDocumentoGeneral;
	}

	public void setMostrarnombreTipoDocumentoGeneral(Boolean mostrarnombreTipoDocumentoGeneral) {
		this.mostrarnombreTipoDocumentoGeneral= mostrarnombreTipoDocumentoGeneral;
	}

	public Boolean getActivarnombreTipoDocumentoGeneral() {
		return this.activarnombreTipoDocumentoGeneral;
	}

	public void setActivarnombreTipoDocumentoGeneral(Boolean activarnombreTipoDocumentoGeneral) {
		this.activarnombreTipoDocumentoGeneral= activarnombreTipoDocumentoGeneral;
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
		
		
		this.setMostraridTipoDocumentoGeneral(esInicial);
		this.setMostrarcodigoTipoDocumentoGeneral(esInicial);
		this.setMostrarnombreTipoDocumentoGeneral(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoDocumentoGeneralConstantesFunciones.ID)) {
				this.setMostraridTipoDocumentoGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDocumentoGeneralConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoDocumentoGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDocumentoGeneralConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoDocumentoGeneral(esAsigna);
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
		
		
		this.setActivaridTipoDocumentoGeneral(esInicial);
		this.setActivarcodigoTipoDocumentoGeneral(esInicial);
		this.setActivarnombreTipoDocumentoGeneral(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoDocumentoGeneralConstantesFunciones.ID)) {
				this.setActivaridTipoDocumentoGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDocumentoGeneralConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoDocumentoGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDocumentoGeneralConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoDocumentoGeneral(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoDocumentoGeneralBeanSwingJInternalFrame tipodocumentogeneralBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoDocumentoGeneral(esInicial);
		this.setResaltarcodigoTipoDocumentoGeneral(esInicial);
		this.setResaltarnombreTipoDocumentoGeneral(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoDocumentoGeneralConstantesFunciones.ID)) {
				this.setResaltaridTipoDocumentoGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDocumentoGeneralConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoDocumentoGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDocumentoGeneralConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoDocumentoGeneral(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoDocumentoGeneralBeanSwingJInternalFrame tipodocumentogeneralBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPorCodigoTipoDocumentoGeneral=true;

	public Boolean getMostrarBusquedaPorCodigoTipoDocumentoGeneral() {
		return this.mostrarBusquedaPorCodigoTipoDocumentoGeneral;
	}

	public void setMostrarBusquedaPorCodigoTipoDocumentoGeneral(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoTipoDocumentoGeneral= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorIdTipoDocumentoGeneral=true;

	public Boolean getMostrarBusquedaPorIdTipoDocumentoGeneral() {
		return this.mostrarBusquedaPorIdTipoDocumentoGeneral;
	}

	public void setMostrarBusquedaPorIdTipoDocumentoGeneral(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorIdTipoDocumentoGeneral= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreTipoDocumentoGeneral=true;

	public Boolean getMostrarBusquedaPorNombreTipoDocumentoGeneral() {
		return this.mostrarBusquedaPorNombreTipoDocumentoGeneral;
	}

	public void setMostrarBusquedaPorNombreTipoDocumentoGeneral(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreTipoDocumentoGeneral= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorCodigoTipoDocumentoGeneral=true;

	public Boolean getActivarBusquedaPorCodigoTipoDocumentoGeneral() {
		return this.activarBusquedaPorCodigoTipoDocumentoGeneral;
	}

	public void setActivarBusquedaPorCodigoTipoDocumentoGeneral(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoTipoDocumentoGeneral= habilitarResaltar;
	}

	public Boolean activarBusquedaPorIdTipoDocumentoGeneral=true;

	public Boolean getActivarBusquedaPorIdTipoDocumentoGeneral() {
		return this.activarBusquedaPorIdTipoDocumentoGeneral;
	}

	public void setActivarBusquedaPorIdTipoDocumentoGeneral(Boolean habilitarResaltar) {
		this.activarBusquedaPorIdTipoDocumentoGeneral= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreTipoDocumentoGeneral=true;

	public Boolean getActivarBusquedaPorNombreTipoDocumentoGeneral() {
		return this.activarBusquedaPorNombreTipoDocumentoGeneral;
	}

	public void setActivarBusquedaPorNombreTipoDocumentoGeneral(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreTipoDocumentoGeneral= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorCodigoTipoDocumentoGeneral=null;

	public Border getResaltarBusquedaPorCodigoTipoDocumentoGeneral() {
		return this.resaltarBusquedaPorCodigoTipoDocumentoGeneral;
	}

	public void setResaltarBusquedaPorCodigoTipoDocumentoGeneral(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoTipoDocumentoGeneral= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoTipoDocumentoGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDocumentoGeneralBeanSwingJInternalFrame tipodocumentogeneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoTipoDocumentoGeneral= borderResaltar;
	}

	public Border resaltarBusquedaPorIdTipoDocumentoGeneral=null;

	public Border getResaltarBusquedaPorIdTipoDocumentoGeneral() {
		return this.resaltarBusquedaPorIdTipoDocumentoGeneral;
	}

	public void setResaltarBusquedaPorIdTipoDocumentoGeneral(Border borderResaltar) {
		this.resaltarBusquedaPorIdTipoDocumentoGeneral= borderResaltar;
	}

	public void setResaltarBusquedaPorIdTipoDocumentoGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDocumentoGeneralBeanSwingJInternalFrame tipodocumentogeneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorIdTipoDocumentoGeneral= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreTipoDocumentoGeneral=null;

	public Border getResaltarBusquedaPorNombreTipoDocumentoGeneral() {
		return this.resaltarBusquedaPorNombreTipoDocumentoGeneral;
	}

	public void setResaltarBusquedaPorNombreTipoDocumentoGeneral(Border borderResaltar) {
		this.resaltarBusquedaPorNombreTipoDocumentoGeneral= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreTipoDocumentoGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDocumentoGeneralBeanSwingJInternalFrame tipodocumentogeneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreTipoDocumentoGeneral= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}