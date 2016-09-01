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


import com.bydan.erp.facturacion.util.TipoParamFactuPlazoConstantesFunciones;
import com.bydan.erp.facturacion.util.TipoParamFactuPlazoParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.TipoParamFactuPlazoParameterGeneral;

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
final public class TipoParamFactuPlazoConstantesFunciones extends TipoParamFactuPlazoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoParamFactuPlazo";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoParamFactuPlazo"+TipoParamFactuPlazoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoParamFactuPlazoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoParamFactuPlazoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoParamFactuPlazoConstantesFunciones.SCHEMA+"_"+TipoParamFactuPlazoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoParamFactuPlazoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoParamFactuPlazoConstantesFunciones.SCHEMA+"_"+TipoParamFactuPlazoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoParamFactuPlazoConstantesFunciones.SCHEMA+"_"+TipoParamFactuPlazoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoParamFactuPlazoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoParamFactuPlazoConstantesFunciones.SCHEMA+"_"+TipoParamFactuPlazoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoParamFactuPlazoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoParamFactuPlazoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoParamFactuPlazoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoParamFactuPlazoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoParamFactuPlazoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoParamFactuPlazoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoParamFactuPlazoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoParamFactuPlazoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoParamFactuPlazoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoParamFactuPlazoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Plazos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Plazo";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Param Factu Plazo";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoParamFactuPlazo";
	public static final String OBJECTNAME="tipoparamfactuplazo";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="tipo_param_factu_plazo";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipoparamfactuplazo from "+TipoParamFactuPlazoConstantesFunciones.SPERSISTENCENAME+" tipoparamfactuplazo";
	public static String QUERYSELECTNATIVE="select "+TipoParamFactuPlazoConstantesFunciones.SCHEMA+"."+TipoParamFactuPlazoConstantesFunciones.TABLENAME+".id,"+TipoParamFactuPlazoConstantesFunciones.SCHEMA+"."+TipoParamFactuPlazoConstantesFunciones.TABLENAME+".version_row,"+TipoParamFactuPlazoConstantesFunciones.SCHEMA+"."+TipoParamFactuPlazoConstantesFunciones.TABLENAME+".nombre from "+TipoParamFactuPlazoConstantesFunciones.SCHEMA+"."+TipoParamFactuPlazoConstantesFunciones.TABLENAME;//+" as "+TipoParamFactuPlazoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoParamFactuPlazoConstantesFuncionesAdditional tipoparamfactuplazoConstantesFuncionesAdditional=null;
	
	public TipoParamFactuPlazoConstantesFuncionesAdditional getTipoParamFactuPlazoConstantesFuncionesAdditional() {
		return this.tipoparamfactuplazoConstantesFuncionesAdditional;
	}
	
	public void setTipoParamFactuPlazoConstantesFuncionesAdditional(TipoParamFactuPlazoConstantesFuncionesAdditional tipoparamfactuplazoConstantesFuncionesAdditional) {
		try {
			this.tipoparamfactuplazoConstantesFuncionesAdditional=tipoparamfactuplazoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String NOMBRE= "nombre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getTipoParamFactuPlazoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoParamFactuPlazoConstantesFunciones.NOMBRE)) {sLabelColumna=TipoParamFactuPlazoConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
	
	public static String getTipoParamFactuPlazoDescripcion(TipoParamFactuPlazo tipoparamfactuplazo) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipoparamfactuplazo !=null/* && tipoparamfactuplazo.getId()!=0*/) {
			sDescripcion=tipoparamfactuplazo.getnombre();//tipoparamfactuplazotipoparamfactuplazo.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoParamFactuPlazoDescripcionDetallado(TipoParamFactuPlazo tipoparamfactuplazo) {
		String sDescripcion="";
			
		sDescripcion+=TipoParamFactuPlazoConstantesFunciones.ID+"=";
		sDescripcion+=tipoparamfactuplazo.getId().toString()+",";
		sDescripcion+=TipoParamFactuPlazoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipoparamfactuplazo.getVersionRow().toString()+",";
		sDescripcion+=TipoParamFactuPlazoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipoparamfactuplazo.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoParamFactuPlazoDescripcion(TipoParamFactuPlazo tipoparamfactuplazo,String sValor) throws Exception {			
		if(tipoparamfactuplazo !=null) {
			tipoparamfactuplazo.setnombre(sValor);//tipoparamfactuplazotipoparamfactuplazo.getId().toString();
		}		
	}
	
		
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		} else if(sNombreIndice.equals("PorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndicePorNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTipoParamFactuPlazo(TipoParamFactuPlazo tipoparamfactuplazo,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipoparamfactuplazo.setnombre(tipoparamfactuplazo.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoParamFactuPlazos(List<TipoParamFactuPlazo> tipoparamfactuplazos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoParamFactuPlazo tipoparamfactuplazo: tipoparamfactuplazos) {
			tipoparamfactuplazo.setnombre(tipoparamfactuplazo.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoParamFactuPlazo(TipoParamFactuPlazo tipoparamfactuplazo,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipoparamfactuplazo.getConCambioAuxiliar()) {
			tipoparamfactuplazo.setIsDeleted(tipoparamfactuplazo.getIsDeletedAuxiliar());	
			tipoparamfactuplazo.setIsNew(tipoparamfactuplazo.getIsNewAuxiliar());	
			tipoparamfactuplazo.setIsChanged(tipoparamfactuplazo.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipoparamfactuplazo.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipoparamfactuplazo.setIsDeletedAuxiliar(false);	
			tipoparamfactuplazo.setIsNewAuxiliar(false);	
			tipoparamfactuplazo.setIsChangedAuxiliar(false);
			
			tipoparamfactuplazo.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoParamFactuPlazos(List<TipoParamFactuPlazo> tipoparamfactuplazos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoParamFactuPlazo tipoparamfactuplazo : tipoparamfactuplazos) {
			if(conAsignarBase && tipoparamfactuplazo.getConCambioAuxiliar()) {
				tipoparamfactuplazo.setIsDeleted(tipoparamfactuplazo.getIsDeletedAuxiliar());	
				tipoparamfactuplazo.setIsNew(tipoparamfactuplazo.getIsNewAuxiliar());	
				tipoparamfactuplazo.setIsChanged(tipoparamfactuplazo.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipoparamfactuplazo.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipoparamfactuplazo.setIsDeletedAuxiliar(false);	
				tipoparamfactuplazo.setIsNewAuxiliar(false);	
				tipoparamfactuplazo.setIsChangedAuxiliar(false);
				
				tipoparamfactuplazo.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoParamFactuPlazo(TipoParamFactuPlazo tipoparamfactuplazo,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoParamFactuPlazos(List<TipoParamFactuPlazo> tipoparamfactuplazos,Boolean conEnteros) throws Exception  {
		
		for(TipoParamFactuPlazo tipoparamfactuplazo: tipoparamfactuplazos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoParamFactuPlazo(List<TipoParamFactuPlazo> tipoparamfactuplazos,TipoParamFactuPlazo tipoparamfactuplazoAux) throws Exception  {
		TipoParamFactuPlazoConstantesFunciones.InicializarValoresTipoParamFactuPlazo(tipoparamfactuplazoAux,true);
		
		for(TipoParamFactuPlazo tipoparamfactuplazo: tipoparamfactuplazos) {
			if(tipoparamfactuplazo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoParamFactuPlazo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoParamFactuPlazoConstantesFunciones.getArrayColumnasGlobalesTipoParamFactuPlazo(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoParamFactuPlazo(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoParamFactuPlazo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoParamFactuPlazo> tipoparamfactuplazos,TipoParamFactuPlazo tipoparamfactuplazo,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoParamFactuPlazo tipoparamfactuplazoAux: tipoparamfactuplazos) {
			if(tipoparamfactuplazoAux!=null && tipoparamfactuplazo!=null) {
				if((tipoparamfactuplazoAux.getId()==null && tipoparamfactuplazo.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipoparamfactuplazoAux.getId()!=null && tipoparamfactuplazo.getId()!=null){
					if(tipoparamfactuplazoAux.getId().equals(tipoparamfactuplazo.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoParamFactuPlazo(List<TipoParamFactuPlazo> tipoparamfactuplazos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoParamFactuPlazo tipoparamfactuplazo: tipoparamfactuplazos) {			
			if(tipoparamfactuplazo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoParamFactuPlazo() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoParamFactuPlazoConstantesFunciones.LABEL_ID, TipoParamFactuPlazoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoParamFactuPlazoConstantesFunciones.LABEL_VERSIONROW, TipoParamFactuPlazoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoParamFactuPlazoConstantesFunciones.LABEL_NOMBRE, TipoParamFactuPlazoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoParamFactuPlazo() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoParamFactuPlazoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoParamFactuPlazoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoParamFactuPlazoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoParamFactuPlazo() throws Exception  {
		return TipoParamFactuPlazoConstantesFunciones.getTiposSeleccionarTipoParamFactuPlazo(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoParamFactuPlazo(Boolean conFk) throws Exception  {
		return TipoParamFactuPlazoConstantesFunciones.getTiposSeleccionarTipoParamFactuPlazo(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoParamFactuPlazo(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoParamFactuPlazoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoParamFactuPlazoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoParamFactuPlazo(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoParamFactuPlazo(TipoParamFactuPlazo tipoparamfactuplazoAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoParamFactuPlazo(List<TipoParamFactuPlazo> tipoparamfactuplazosTemp) throws Exception {
		for(TipoParamFactuPlazo tipoparamfactuplazoAux:tipoparamfactuplazosTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoParamFactuPlazo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoParamFactuPlazo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoParamFactuPlazo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoParamFactuPlazoConstantesFunciones.getClassesRelationshipsOfTipoParamFactuPlazo(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoParamFactuPlazo(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(ParametroFactuSecuencial.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(ParametroFactuSecuencial.class)) {
						classes.add(new Classe(ParametroFactuSecuencial.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoParamFactuPlazo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoParamFactuPlazoConstantesFunciones.getClassesRelationshipsFromStringsOfTipoParamFactuPlazo(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoParamFactuPlazo(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(ParametroFactuSecuencial.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroFactuSecuencial.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(ParametroFactuSecuencial.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroFactuSecuencial.class)); continue;
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
	public static void actualizarLista(TipoParamFactuPlazo tipoparamfactuplazo,List<TipoParamFactuPlazo> tipoparamfactuplazos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoParamFactuPlazo tipoparamfactuplazoEncontrado=null;
			
			for(TipoParamFactuPlazo tipoparamfactuplazoLocal:tipoparamfactuplazos) {
				if(tipoparamfactuplazoLocal.getId().equals(tipoparamfactuplazo.getId())) {
					tipoparamfactuplazoEncontrado=tipoparamfactuplazoLocal;
					
					tipoparamfactuplazoLocal.setIsChanged(tipoparamfactuplazo.getIsChanged());
					tipoparamfactuplazoLocal.setIsNew(tipoparamfactuplazo.getIsNew());
					tipoparamfactuplazoLocal.setIsDeleted(tipoparamfactuplazo.getIsDeleted());
					
					tipoparamfactuplazoLocal.setGeneralEntityOriginal(tipoparamfactuplazo.getGeneralEntityOriginal());
					
					tipoparamfactuplazoLocal.setId(tipoparamfactuplazo.getId());	
					tipoparamfactuplazoLocal.setVersionRow(tipoparamfactuplazo.getVersionRow());	
					tipoparamfactuplazoLocal.setnombre(tipoparamfactuplazo.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipoparamfactuplazo.getIsDeleted()) {
				if(!existe) {
					tipoparamfactuplazos.add(tipoparamfactuplazo);
				}
			} else {
				if(tipoparamfactuplazoEncontrado!=null && permiteQuitar)  {
					tipoparamfactuplazos.remove(tipoparamfactuplazoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoParamFactuPlazo tipoparamfactuplazo,List<TipoParamFactuPlazo> tipoparamfactuplazos) throws Exception {
		try	{			
			for(TipoParamFactuPlazo tipoparamfactuplazoLocal:tipoparamfactuplazos) {
				if(tipoparamfactuplazoLocal.getId().equals(tipoparamfactuplazo.getId())) {
					tipoparamfactuplazoLocal.setIsSelected(tipoparamfactuplazo.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoParamFactuPlazo(List<TipoParamFactuPlazo> tipoparamfactuplazosAux) throws Exception {
		//this.tipoparamfactuplazosAux=tipoparamfactuplazosAux;
		
		for(TipoParamFactuPlazo tipoparamfactuplazoAux:tipoparamfactuplazosAux) {
			if(tipoparamfactuplazoAux.getIsChanged()) {
				tipoparamfactuplazoAux.setIsChanged(false);
			}		
			
			if(tipoparamfactuplazoAux.getIsNew()) {
				tipoparamfactuplazoAux.setIsNew(false);
			}	
			
			if(tipoparamfactuplazoAux.getIsDeleted()) {
				tipoparamfactuplazoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoParamFactuPlazo(TipoParamFactuPlazo tipoparamfactuplazoAux) throws Exception {
		//this.tipoparamfactuplazoAux=tipoparamfactuplazoAux;
		
			if(tipoparamfactuplazoAux.getIsChanged()) {
				tipoparamfactuplazoAux.setIsChanged(false);
			}		
			
			if(tipoparamfactuplazoAux.getIsNew()) {
				tipoparamfactuplazoAux.setIsNew(false);
			}	
			
			if(tipoparamfactuplazoAux.getIsDeleted()) {
				tipoparamfactuplazoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoParamFactuPlazo tipoparamfactuplazoAsignar,TipoParamFactuPlazo tipoparamfactuplazo) throws Exception {
		tipoparamfactuplazoAsignar.setId(tipoparamfactuplazo.getId());	
		tipoparamfactuplazoAsignar.setVersionRow(tipoparamfactuplazo.getVersionRow());	
		tipoparamfactuplazoAsignar.setnombre(tipoparamfactuplazo.getnombre());	
	}
	
	public static void inicializarTipoParamFactuPlazo(TipoParamFactuPlazo tipoparamfactuplazo) throws Exception {
		try {
				tipoparamfactuplazo.setId(0L);	
					
				tipoparamfactuplazo.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoParamFactuPlazo(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoParamFactuPlazoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoParamFactuPlazo(String sTipo,Row row,Workbook workbook,TipoParamFactuPlazo tipoparamfactuplazo,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoparamfactuplazo.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoParamFactuPlazo=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoParamFactuPlazo() {
		return this.sFinalQueryTipoParamFactuPlazo;
	}
	
	public void setsFinalQueryTipoParamFactuPlazo(String sFinalQueryTipoParamFactuPlazo) {
		this.sFinalQueryTipoParamFactuPlazo= sFinalQueryTipoParamFactuPlazo;
	}
	
	public Border resaltarSeleccionarTipoParamFactuPlazo=null;
	
	public Border setResaltarSeleccionarTipoParamFactuPlazo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoParamFactuPlazoBeanSwingJInternalFrame tipoparamfactuplazoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipoparamfactuplazoBeanSwingJInternalFrame.jTtoolBarTipoParamFactuPlazo.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoParamFactuPlazo= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoParamFactuPlazo() {
		return this.resaltarSeleccionarTipoParamFactuPlazo;
	}
	
	public void setResaltarSeleccionarTipoParamFactuPlazo(Border borderResaltarSeleccionarTipoParamFactuPlazo) {
		this.resaltarSeleccionarTipoParamFactuPlazo= borderResaltarSeleccionarTipoParamFactuPlazo;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoParamFactuPlazo=null;
	public Boolean mostraridTipoParamFactuPlazo=true;
	public Boolean activaridTipoParamFactuPlazo=true;

	public Border resaltarnombreTipoParamFactuPlazo=null;
	public Boolean mostrarnombreTipoParamFactuPlazo=true;
	public Boolean activarnombreTipoParamFactuPlazo=true;

	
	

	public Border setResaltaridTipoParamFactuPlazo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoParamFactuPlazoBeanSwingJInternalFrame tipoparamfactuplazoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoparamfactuplazoBeanSwingJInternalFrame.jTtoolBarTipoParamFactuPlazo.setBorder(borderResaltar);
		
		this.resaltaridTipoParamFactuPlazo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoParamFactuPlazo() {
		return this.resaltaridTipoParamFactuPlazo;
	}

	public void setResaltaridTipoParamFactuPlazo(Border borderResaltar) {
		this.resaltaridTipoParamFactuPlazo= borderResaltar;
	}

	public Boolean getMostraridTipoParamFactuPlazo() {
		return this.mostraridTipoParamFactuPlazo;
	}

	public void setMostraridTipoParamFactuPlazo(Boolean mostraridTipoParamFactuPlazo) {
		this.mostraridTipoParamFactuPlazo= mostraridTipoParamFactuPlazo;
	}

	public Boolean getActivaridTipoParamFactuPlazo() {
		return this.activaridTipoParamFactuPlazo;
	}

	public void setActivaridTipoParamFactuPlazo(Boolean activaridTipoParamFactuPlazo) {
		this.activaridTipoParamFactuPlazo= activaridTipoParamFactuPlazo;
	}

	public Border setResaltarnombreTipoParamFactuPlazo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoParamFactuPlazoBeanSwingJInternalFrame tipoparamfactuplazoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoparamfactuplazoBeanSwingJInternalFrame.jTtoolBarTipoParamFactuPlazo.setBorder(borderResaltar);
		
		this.resaltarnombreTipoParamFactuPlazo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoParamFactuPlazo() {
		return this.resaltarnombreTipoParamFactuPlazo;
	}

	public void setResaltarnombreTipoParamFactuPlazo(Border borderResaltar) {
		this.resaltarnombreTipoParamFactuPlazo= borderResaltar;
	}

	public Boolean getMostrarnombreTipoParamFactuPlazo() {
		return this.mostrarnombreTipoParamFactuPlazo;
	}

	public void setMostrarnombreTipoParamFactuPlazo(Boolean mostrarnombreTipoParamFactuPlazo) {
		this.mostrarnombreTipoParamFactuPlazo= mostrarnombreTipoParamFactuPlazo;
	}

	public Boolean getActivarnombreTipoParamFactuPlazo() {
		return this.activarnombreTipoParamFactuPlazo;
	}

	public void setActivarnombreTipoParamFactuPlazo(Boolean activarnombreTipoParamFactuPlazo) {
		this.activarnombreTipoParamFactuPlazo= activarnombreTipoParamFactuPlazo;
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
		
		
		this.setMostraridTipoParamFactuPlazo(esInicial);
		this.setMostrarnombreTipoParamFactuPlazo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoParamFactuPlazoConstantesFunciones.ID)) {
				this.setMostraridTipoParamFactuPlazo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoParamFactuPlazoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoParamFactuPlazo(esAsigna);
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
		
		
		this.setActivaridTipoParamFactuPlazo(esInicial);
		this.setActivarnombreTipoParamFactuPlazo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoParamFactuPlazoConstantesFunciones.ID)) {
				this.setActivaridTipoParamFactuPlazo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoParamFactuPlazoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoParamFactuPlazo(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoParamFactuPlazoBeanSwingJInternalFrame tipoparamfactuplazoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoParamFactuPlazo(esInicial);
		this.setResaltarnombreTipoParamFactuPlazo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoParamFactuPlazoConstantesFunciones.ID)) {
				this.setResaltaridTipoParamFactuPlazo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoParamFactuPlazoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoParamFactuPlazo(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoParamFactuPlazoBeanSwingJInternalFrame tipoparamfactuplazoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPorNombreTipoParamFactuPlazo=true;

	public Boolean getMostrarBusquedaPorNombreTipoParamFactuPlazo() {
		return this.mostrarBusquedaPorNombreTipoParamFactuPlazo;
	}

	public void setMostrarBusquedaPorNombreTipoParamFactuPlazo(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreTipoParamFactuPlazo= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorNombreTipoParamFactuPlazo=true;

	public Boolean getActivarBusquedaPorNombreTipoParamFactuPlazo() {
		return this.activarBusquedaPorNombreTipoParamFactuPlazo;
	}

	public void setActivarBusquedaPorNombreTipoParamFactuPlazo(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreTipoParamFactuPlazo= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorNombreTipoParamFactuPlazo=null;

	public Border getResaltarBusquedaPorNombreTipoParamFactuPlazo() {
		return this.resaltarBusquedaPorNombreTipoParamFactuPlazo;
	}

	public void setResaltarBusquedaPorNombreTipoParamFactuPlazo(Border borderResaltar) {
		this.resaltarBusquedaPorNombreTipoParamFactuPlazo= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreTipoParamFactuPlazo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoParamFactuPlazoBeanSwingJInternalFrame tipoparamfactuplazoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreTipoParamFactuPlazo= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}