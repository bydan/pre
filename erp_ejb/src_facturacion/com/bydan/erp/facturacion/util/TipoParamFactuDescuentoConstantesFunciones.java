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


import com.bydan.erp.facturacion.util.TipoParamFactuDescuentoConstantesFunciones;
import com.bydan.erp.facturacion.util.TipoParamFactuDescuentoParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.TipoParamFactuDescuentoParameterGeneral;

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
final public class TipoParamFactuDescuentoConstantesFunciones extends TipoParamFactuDescuentoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoParamFactuDescuento";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoParamFactuDescuento"+TipoParamFactuDescuentoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoParamFactuDescuentoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoParamFactuDescuentoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoParamFactuDescuentoConstantesFunciones.SCHEMA+"_"+TipoParamFactuDescuentoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoParamFactuDescuentoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoParamFactuDescuentoConstantesFunciones.SCHEMA+"_"+TipoParamFactuDescuentoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoParamFactuDescuentoConstantesFunciones.SCHEMA+"_"+TipoParamFactuDescuentoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoParamFactuDescuentoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoParamFactuDescuentoConstantesFunciones.SCHEMA+"_"+TipoParamFactuDescuentoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoParamFactuDescuentoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoParamFactuDescuentoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoParamFactuDescuentoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoParamFactuDescuentoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoParamFactuDescuentoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoParamFactuDescuentoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoParamFactuDescuentoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoParamFactuDescuentoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoParamFactuDescuentoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoParamFactuDescuentoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Descuentos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Descuento";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Param Factu Descuento";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoParamFactuDescuento";
	public static final String OBJECTNAME="tipoparamfactudescuento";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="tipo_param_factu_descuento";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipoparamfactudescuento from "+TipoParamFactuDescuentoConstantesFunciones.SPERSISTENCENAME+" tipoparamfactudescuento";
	public static String QUERYSELECTNATIVE="select "+TipoParamFactuDescuentoConstantesFunciones.SCHEMA+"."+TipoParamFactuDescuentoConstantesFunciones.TABLENAME+".id,"+TipoParamFactuDescuentoConstantesFunciones.SCHEMA+"."+TipoParamFactuDescuentoConstantesFunciones.TABLENAME+".version_row,"+TipoParamFactuDescuentoConstantesFunciones.SCHEMA+"."+TipoParamFactuDescuentoConstantesFunciones.TABLENAME+".nombre from "+TipoParamFactuDescuentoConstantesFunciones.SCHEMA+"."+TipoParamFactuDescuentoConstantesFunciones.TABLENAME;//+" as "+TipoParamFactuDescuentoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoParamFactuDescuentoConstantesFuncionesAdditional tipoparamfactudescuentoConstantesFuncionesAdditional=null;
	
	public TipoParamFactuDescuentoConstantesFuncionesAdditional getTipoParamFactuDescuentoConstantesFuncionesAdditional() {
		return this.tipoparamfactudescuentoConstantesFuncionesAdditional;
	}
	
	public void setTipoParamFactuDescuentoConstantesFuncionesAdditional(TipoParamFactuDescuentoConstantesFuncionesAdditional tipoparamfactudescuentoConstantesFuncionesAdditional) {
		try {
			this.tipoparamfactudescuentoConstantesFuncionesAdditional=tipoparamfactudescuentoConstantesFuncionesAdditional;
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
	
	public static String getTipoParamFactuDescuentoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoParamFactuDescuentoConstantesFunciones.NOMBRE)) {sLabelColumna=TipoParamFactuDescuentoConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
	
	public static String getTipoParamFactuDescuentoDescripcion(TipoParamFactuDescuento tipoparamfactudescuento) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipoparamfactudescuento !=null/* && tipoparamfactudescuento.getId()!=0*/) {
			sDescripcion=tipoparamfactudescuento.getnombre();//tipoparamfactudescuentotipoparamfactudescuento.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoParamFactuDescuentoDescripcionDetallado(TipoParamFactuDescuento tipoparamfactudescuento) {
		String sDescripcion="";
			
		sDescripcion+=TipoParamFactuDescuentoConstantesFunciones.ID+"=";
		sDescripcion+=tipoparamfactudescuento.getId().toString()+",";
		sDescripcion+=TipoParamFactuDescuentoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipoparamfactudescuento.getVersionRow().toString()+",";
		sDescripcion+=TipoParamFactuDescuentoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipoparamfactudescuento.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoParamFactuDescuentoDescripcion(TipoParamFactuDescuento tipoparamfactudescuento,String sValor) throws Exception {			
		if(tipoparamfactudescuento !=null) {
			tipoparamfactudescuento.setnombre(sValor);//tipoparamfactudescuentotipoparamfactudescuento.getId().toString();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoParamFactuDescuento(TipoParamFactuDescuento tipoparamfactudescuento,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipoparamfactudescuento.setnombre(tipoparamfactudescuento.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoParamFactuDescuentos(List<TipoParamFactuDescuento> tipoparamfactudescuentos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoParamFactuDescuento tipoparamfactudescuento: tipoparamfactudescuentos) {
			tipoparamfactudescuento.setnombre(tipoparamfactudescuento.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoParamFactuDescuento(TipoParamFactuDescuento tipoparamfactudescuento,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipoparamfactudescuento.getConCambioAuxiliar()) {
			tipoparamfactudescuento.setIsDeleted(tipoparamfactudescuento.getIsDeletedAuxiliar());	
			tipoparamfactudescuento.setIsNew(tipoparamfactudescuento.getIsNewAuxiliar());	
			tipoparamfactudescuento.setIsChanged(tipoparamfactudescuento.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipoparamfactudescuento.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipoparamfactudescuento.setIsDeletedAuxiliar(false);	
			tipoparamfactudescuento.setIsNewAuxiliar(false);	
			tipoparamfactudescuento.setIsChangedAuxiliar(false);
			
			tipoparamfactudescuento.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoParamFactuDescuentos(List<TipoParamFactuDescuento> tipoparamfactudescuentos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoParamFactuDescuento tipoparamfactudescuento : tipoparamfactudescuentos) {
			if(conAsignarBase && tipoparamfactudescuento.getConCambioAuxiliar()) {
				tipoparamfactudescuento.setIsDeleted(tipoparamfactudescuento.getIsDeletedAuxiliar());	
				tipoparamfactudescuento.setIsNew(tipoparamfactudescuento.getIsNewAuxiliar());	
				tipoparamfactudescuento.setIsChanged(tipoparamfactudescuento.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipoparamfactudescuento.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipoparamfactudescuento.setIsDeletedAuxiliar(false);	
				tipoparamfactudescuento.setIsNewAuxiliar(false);	
				tipoparamfactudescuento.setIsChangedAuxiliar(false);
				
				tipoparamfactudescuento.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoParamFactuDescuento(TipoParamFactuDescuento tipoparamfactudescuento,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoParamFactuDescuentos(List<TipoParamFactuDescuento> tipoparamfactudescuentos,Boolean conEnteros) throws Exception  {
		
		for(TipoParamFactuDescuento tipoparamfactudescuento: tipoparamfactudescuentos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoParamFactuDescuento(List<TipoParamFactuDescuento> tipoparamfactudescuentos,TipoParamFactuDescuento tipoparamfactudescuentoAux) throws Exception  {
		TipoParamFactuDescuentoConstantesFunciones.InicializarValoresTipoParamFactuDescuento(tipoparamfactudescuentoAux,true);
		
		for(TipoParamFactuDescuento tipoparamfactudescuento: tipoparamfactudescuentos) {
			if(tipoparamfactudescuento.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoParamFactuDescuento(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoParamFactuDescuentoConstantesFunciones.getArrayColumnasGlobalesTipoParamFactuDescuento(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoParamFactuDescuento(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoParamFactuDescuento(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoParamFactuDescuento> tipoparamfactudescuentos,TipoParamFactuDescuento tipoparamfactudescuento,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoParamFactuDescuento tipoparamfactudescuentoAux: tipoparamfactudescuentos) {
			if(tipoparamfactudescuentoAux!=null && tipoparamfactudescuento!=null) {
				if((tipoparamfactudescuentoAux.getId()==null && tipoparamfactudescuento.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipoparamfactudescuentoAux.getId()!=null && tipoparamfactudescuento.getId()!=null){
					if(tipoparamfactudescuentoAux.getId().equals(tipoparamfactudescuento.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoParamFactuDescuento(List<TipoParamFactuDescuento> tipoparamfactudescuentos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoParamFactuDescuento tipoparamfactudescuento: tipoparamfactudescuentos) {			
			if(tipoparamfactudescuento.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoParamFactuDescuento() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoParamFactuDescuentoConstantesFunciones.LABEL_ID, TipoParamFactuDescuentoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoParamFactuDescuentoConstantesFunciones.LABEL_VERSIONROW, TipoParamFactuDescuentoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoParamFactuDescuentoConstantesFunciones.LABEL_NOMBRE, TipoParamFactuDescuentoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoParamFactuDescuento() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoParamFactuDescuentoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoParamFactuDescuentoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoParamFactuDescuentoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoParamFactuDescuento() throws Exception  {
		return TipoParamFactuDescuentoConstantesFunciones.getTiposSeleccionarTipoParamFactuDescuento(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoParamFactuDescuento(Boolean conFk) throws Exception  {
		return TipoParamFactuDescuentoConstantesFunciones.getTiposSeleccionarTipoParamFactuDescuento(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoParamFactuDescuento(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoParamFactuDescuentoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoParamFactuDescuentoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoParamFactuDescuento(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoParamFactuDescuento(TipoParamFactuDescuento tipoparamfactudescuentoAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoParamFactuDescuento(List<TipoParamFactuDescuento> tipoparamfactudescuentosTemp) throws Exception {
		for(TipoParamFactuDescuento tipoparamfactudescuentoAux:tipoparamfactudescuentosTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoParamFactuDescuento(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoParamFactuDescuento(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoParamFactuDescuento(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoParamFactuDescuentoConstantesFunciones.getClassesRelationshipsOfTipoParamFactuDescuento(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoParamFactuDescuento(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(ParametroFactuPrincipal.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(ParametroFactuPrincipal.class)) {
						classes.add(new Classe(ParametroFactuPrincipal.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoParamFactuDescuento(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoParamFactuDescuentoConstantesFunciones.getClassesRelationshipsFromStringsOfTipoParamFactuDescuento(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoParamFactuDescuento(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(ParametroFactuPrincipal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroFactuPrincipal.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(ParametroFactuPrincipal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroFactuPrincipal.class)); continue;
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
	public static void actualizarLista(TipoParamFactuDescuento tipoparamfactudescuento,List<TipoParamFactuDescuento> tipoparamfactudescuentos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoParamFactuDescuento tipoparamfactudescuentoEncontrado=null;
			
			for(TipoParamFactuDescuento tipoparamfactudescuentoLocal:tipoparamfactudescuentos) {
				if(tipoparamfactudescuentoLocal.getId().equals(tipoparamfactudescuento.getId())) {
					tipoparamfactudescuentoEncontrado=tipoparamfactudescuentoLocal;
					
					tipoparamfactudescuentoLocal.setIsChanged(tipoparamfactudescuento.getIsChanged());
					tipoparamfactudescuentoLocal.setIsNew(tipoparamfactudescuento.getIsNew());
					tipoparamfactudescuentoLocal.setIsDeleted(tipoparamfactudescuento.getIsDeleted());
					
					tipoparamfactudescuentoLocal.setGeneralEntityOriginal(tipoparamfactudescuento.getGeneralEntityOriginal());
					
					tipoparamfactudescuentoLocal.setId(tipoparamfactudescuento.getId());	
					tipoparamfactudescuentoLocal.setVersionRow(tipoparamfactudescuento.getVersionRow());	
					tipoparamfactudescuentoLocal.setnombre(tipoparamfactudescuento.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipoparamfactudescuento.getIsDeleted()) {
				if(!existe) {
					tipoparamfactudescuentos.add(tipoparamfactudescuento);
				}
			} else {
				if(tipoparamfactudescuentoEncontrado!=null && permiteQuitar)  {
					tipoparamfactudescuentos.remove(tipoparamfactudescuentoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoParamFactuDescuento tipoparamfactudescuento,List<TipoParamFactuDescuento> tipoparamfactudescuentos) throws Exception {
		try	{			
			for(TipoParamFactuDescuento tipoparamfactudescuentoLocal:tipoparamfactudescuentos) {
				if(tipoparamfactudescuentoLocal.getId().equals(tipoparamfactudescuento.getId())) {
					tipoparamfactudescuentoLocal.setIsSelected(tipoparamfactudescuento.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoParamFactuDescuento(List<TipoParamFactuDescuento> tipoparamfactudescuentosAux) throws Exception {
		//this.tipoparamfactudescuentosAux=tipoparamfactudescuentosAux;
		
		for(TipoParamFactuDescuento tipoparamfactudescuentoAux:tipoparamfactudescuentosAux) {
			if(tipoparamfactudescuentoAux.getIsChanged()) {
				tipoparamfactudescuentoAux.setIsChanged(false);
			}		
			
			if(tipoparamfactudescuentoAux.getIsNew()) {
				tipoparamfactudescuentoAux.setIsNew(false);
			}	
			
			if(tipoparamfactudescuentoAux.getIsDeleted()) {
				tipoparamfactudescuentoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoParamFactuDescuento(TipoParamFactuDescuento tipoparamfactudescuentoAux) throws Exception {
		//this.tipoparamfactudescuentoAux=tipoparamfactudescuentoAux;
		
			if(tipoparamfactudescuentoAux.getIsChanged()) {
				tipoparamfactudescuentoAux.setIsChanged(false);
			}		
			
			if(tipoparamfactudescuentoAux.getIsNew()) {
				tipoparamfactudescuentoAux.setIsNew(false);
			}	
			
			if(tipoparamfactudescuentoAux.getIsDeleted()) {
				tipoparamfactudescuentoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoParamFactuDescuento tipoparamfactudescuentoAsignar,TipoParamFactuDescuento tipoparamfactudescuento) throws Exception {
		tipoparamfactudescuentoAsignar.setId(tipoparamfactudescuento.getId());	
		tipoparamfactudescuentoAsignar.setVersionRow(tipoparamfactudescuento.getVersionRow());	
		tipoparamfactudescuentoAsignar.setnombre(tipoparamfactudescuento.getnombre());	
	}
	
	public static void inicializarTipoParamFactuDescuento(TipoParamFactuDescuento tipoparamfactudescuento) throws Exception {
		try {
				tipoparamfactudescuento.setId(0L);	
					
				tipoparamfactudescuento.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoParamFactuDescuento(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoParamFactuDescuentoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoParamFactuDescuento(String sTipo,Row row,Workbook workbook,TipoParamFactuDescuento tipoparamfactudescuento,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoparamfactudescuento.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoParamFactuDescuento=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoParamFactuDescuento() {
		return this.sFinalQueryTipoParamFactuDescuento;
	}
	
	public void setsFinalQueryTipoParamFactuDescuento(String sFinalQueryTipoParamFactuDescuento) {
		this.sFinalQueryTipoParamFactuDescuento= sFinalQueryTipoParamFactuDescuento;
	}
	
	public Border resaltarSeleccionarTipoParamFactuDescuento=null;
	
	public Border setResaltarSeleccionarTipoParamFactuDescuento(ParametroGeneralUsuario parametroGeneralUsuario/*TipoParamFactuDescuentoBeanSwingJInternalFrame tipoparamfactudescuentoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipoparamfactudescuentoBeanSwingJInternalFrame.jTtoolBarTipoParamFactuDescuento.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoParamFactuDescuento= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoParamFactuDescuento() {
		return this.resaltarSeleccionarTipoParamFactuDescuento;
	}
	
	public void setResaltarSeleccionarTipoParamFactuDescuento(Border borderResaltarSeleccionarTipoParamFactuDescuento) {
		this.resaltarSeleccionarTipoParamFactuDescuento= borderResaltarSeleccionarTipoParamFactuDescuento;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoParamFactuDescuento=null;
	public Boolean mostraridTipoParamFactuDescuento=true;
	public Boolean activaridTipoParamFactuDescuento=true;

	public Border resaltarnombreTipoParamFactuDescuento=null;
	public Boolean mostrarnombreTipoParamFactuDescuento=true;
	public Boolean activarnombreTipoParamFactuDescuento=true;

	
	

	public Border setResaltaridTipoParamFactuDescuento(ParametroGeneralUsuario parametroGeneralUsuario/*TipoParamFactuDescuentoBeanSwingJInternalFrame tipoparamfactudescuentoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoparamfactudescuentoBeanSwingJInternalFrame.jTtoolBarTipoParamFactuDescuento.setBorder(borderResaltar);
		
		this.resaltaridTipoParamFactuDescuento= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoParamFactuDescuento() {
		return this.resaltaridTipoParamFactuDescuento;
	}

	public void setResaltaridTipoParamFactuDescuento(Border borderResaltar) {
		this.resaltaridTipoParamFactuDescuento= borderResaltar;
	}

	public Boolean getMostraridTipoParamFactuDescuento() {
		return this.mostraridTipoParamFactuDescuento;
	}

	public void setMostraridTipoParamFactuDescuento(Boolean mostraridTipoParamFactuDescuento) {
		this.mostraridTipoParamFactuDescuento= mostraridTipoParamFactuDescuento;
	}

	public Boolean getActivaridTipoParamFactuDescuento() {
		return this.activaridTipoParamFactuDescuento;
	}

	public void setActivaridTipoParamFactuDescuento(Boolean activaridTipoParamFactuDescuento) {
		this.activaridTipoParamFactuDescuento= activaridTipoParamFactuDescuento;
	}

	public Border setResaltarnombreTipoParamFactuDescuento(ParametroGeneralUsuario parametroGeneralUsuario/*TipoParamFactuDescuentoBeanSwingJInternalFrame tipoparamfactudescuentoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoparamfactudescuentoBeanSwingJInternalFrame.jTtoolBarTipoParamFactuDescuento.setBorder(borderResaltar);
		
		this.resaltarnombreTipoParamFactuDescuento= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoParamFactuDescuento() {
		return this.resaltarnombreTipoParamFactuDescuento;
	}

	public void setResaltarnombreTipoParamFactuDescuento(Border borderResaltar) {
		this.resaltarnombreTipoParamFactuDescuento= borderResaltar;
	}

	public Boolean getMostrarnombreTipoParamFactuDescuento() {
		return this.mostrarnombreTipoParamFactuDescuento;
	}

	public void setMostrarnombreTipoParamFactuDescuento(Boolean mostrarnombreTipoParamFactuDescuento) {
		this.mostrarnombreTipoParamFactuDescuento= mostrarnombreTipoParamFactuDescuento;
	}

	public Boolean getActivarnombreTipoParamFactuDescuento() {
		return this.activarnombreTipoParamFactuDescuento;
	}

	public void setActivarnombreTipoParamFactuDescuento(Boolean activarnombreTipoParamFactuDescuento) {
		this.activarnombreTipoParamFactuDescuento= activarnombreTipoParamFactuDescuento;
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
		
		
		this.setMostraridTipoParamFactuDescuento(esInicial);
		this.setMostrarnombreTipoParamFactuDescuento(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoParamFactuDescuentoConstantesFunciones.ID)) {
				this.setMostraridTipoParamFactuDescuento(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoParamFactuDescuentoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoParamFactuDescuento(esAsigna);
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
		
		
		this.setActivaridTipoParamFactuDescuento(esInicial);
		this.setActivarnombreTipoParamFactuDescuento(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoParamFactuDescuentoConstantesFunciones.ID)) {
				this.setActivaridTipoParamFactuDescuento(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoParamFactuDescuentoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoParamFactuDescuento(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoParamFactuDescuentoBeanSwingJInternalFrame tipoparamfactudescuentoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoParamFactuDescuento(esInicial);
		this.setResaltarnombreTipoParamFactuDescuento(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoParamFactuDescuentoConstantesFunciones.ID)) {
				this.setResaltaridTipoParamFactuDescuento(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoParamFactuDescuentoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoParamFactuDescuento(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoParamFactuDescuentoBeanSwingJInternalFrame tipoparamfactudescuentoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPorNombreTipoParamFactuDescuento=true;

	public Boolean getMostrarBusquedaPorNombreTipoParamFactuDescuento() {
		return this.mostrarBusquedaPorNombreTipoParamFactuDescuento;
	}

	public void setMostrarBusquedaPorNombreTipoParamFactuDescuento(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreTipoParamFactuDescuento= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorNombreTipoParamFactuDescuento=true;

	public Boolean getActivarBusquedaPorNombreTipoParamFactuDescuento() {
		return this.activarBusquedaPorNombreTipoParamFactuDescuento;
	}

	public void setActivarBusquedaPorNombreTipoParamFactuDescuento(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreTipoParamFactuDescuento= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorNombreTipoParamFactuDescuento=null;

	public Border getResaltarBusquedaPorNombreTipoParamFactuDescuento() {
		return this.resaltarBusquedaPorNombreTipoParamFactuDescuento;
	}

	public void setResaltarBusquedaPorNombreTipoParamFactuDescuento(Border borderResaltar) {
		this.resaltarBusquedaPorNombreTipoParamFactuDescuento= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreTipoParamFactuDescuento(ParametroGeneralUsuario parametroGeneralUsuario/*TipoParamFactuDescuentoBeanSwingJInternalFrame tipoparamfactudescuentoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreTipoParamFactuDescuento= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}