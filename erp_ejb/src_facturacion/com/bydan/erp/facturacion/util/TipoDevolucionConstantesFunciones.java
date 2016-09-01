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


import com.bydan.erp.facturacion.util.TipoDevolucionConstantesFunciones;
import com.bydan.erp.facturacion.util.TipoDevolucionParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.TipoDevolucionParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoDevolucionConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoDevolucion";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoDevolucion"+TipoDevolucionConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoDevolucionHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoDevolucionHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoDevolucionConstantesFunciones.SCHEMA+"_"+TipoDevolucionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoDevolucionHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoDevolucionConstantesFunciones.SCHEMA+"_"+TipoDevolucionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoDevolucionConstantesFunciones.SCHEMA+"_"+TipoDevolucionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoDevolucionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoDevolucionConstantesFunciones.SCHEMA+"_"+TipoDevolucionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoDevolucionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoDevolucionHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoDevolucionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoDevolucionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoDevolucionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoDevolucionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoDevolucionConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoDevolucionConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoDevolucionConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoDevolucionConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Devolucions";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Devolucion";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Devolucion";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoDevolucion";
	public static final String OBJECTNAME="tipodevolucion";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="tipo_devolucion";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipodevolucion from "+TipoDevolucionConstantesFunciones.SPERSISTENCENAME+" tipodevolucion";
	public static String QUERYSELECTNATIVE="select "+TipoDevolucionConstantesFunciones.SCHEMA+"."+TipoDevolucionConstantesFunciones.TABLENAME+".id,"+TipoDevolucionConstantesFunciones.SCHEMA+"."+TipoDevolucionConstantesFunciones.TABLENAME+".version_row,"+TipoDevolucionConstantesFunciones.SCHEMA+"."+TipoDevolucionConstantesFunciones.TABLENAME+".id_pais,"+TipoDevolucionConstantesFunciones.SCHEMA+"."+TipoDevolucionConstantesFunciones.TABLENAME+".nombre from "+TipoDevolucionConstantesFunciones.SCHEMA+"."+TipoDevolucionConstantesFunciones.TABLENAME;//+" as "+TipoDevolucionConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDPAIS= "id_pais";
    public static final String NOMBRE= "nombre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDPAIS= "Pais";
		public static final String LABEL_IDPAIS_LOWER= "Pais";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getTipoDevolucionLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoDevolucionConstantesFunciones.IDPAIS)) {sLabelColumna=TipoDevolucionConstantesFunciones.LABEL_IDPAIS;}
		if(sNombreColumna.equals(TipoDevolucionConstantesFunciones.NOMBRE)) {sLabelColumna=TipoDevolucionConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoDevolucionDescripcion(TipoDevolucion tipodevolucion) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipodevolucion !=null/* && tipodevolucion.getId()!=0*/) {
			sDescripcion=tipodevolucion.getnombre();//tipodevoluciontipodevolucion.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoDevolucionDescripcionDetallado(TipoDevolucion tipodevolucion) {
		String sDescripcion="";
			
		sDescripcion+=TipoDevolucionConstantesFunciones.ID+"=";
		sDescripcion+=tipodevolucion.getId().toString()+",";
		sDescripcion+=TipoDevolucionConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipodevolucion.getVersionRow().toString()+",";
		sDescripcion+=TipoDevolucionConstantesFunciones.IDPAIS+"=";
		sDescripcion+=tipodevolucion.getid_pais().toString()+",";
		sDescripcion+=TipoDevolucionConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipodevolucion.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoDevolucionDescripcion(TipoDevolucion tipodevolucion,String sValor) throws Exception {			
		if(tipodevolucion !=null) {
			tipodevolucion.setnombre(sValor);//tipodevoluciontipodevolucion.getId().toString();
		}		
	}
	
		

	public static String getPaisDescripcion(Pais pais) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(pais!=null/*&&pais.getId()>0*/) {
			sDescripcion=PaisConstantesFunciones.getPaisDescripcion(pais);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		} else if(sNombreIndice.equals("FK_IdPais")) {
			sNombreIndice="Tipo=  Por Pais";
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

	public static String getDetalleIndiceFK_IdPais(Long id_pais) {
		String sDetalleIndice=" Parametros->";
		if(id_pais!=null) {sDetalleIndice+=" Codigo Unico De Pais="+id_pais.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndicePorNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTipoDevolucion(TipoDevolucion tipodevolucion,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipodevolucion.setnombre(tipodevolucion.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoDevolucions(List<TipoDevolucion> tipodevolucions,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoDevolucion tipodevolucion: tipodevolucions) {
			tipodevolucion.setnombre(tipodevolucion.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoDevolucion(TipoDevolucion tipodevolucion,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipodevolucion.getConCambioAuxiliar()) {
			tipodevolucion.setIsDeleted(tipodevolucion.getIsDeletedAuxiliar());	
			tipodevolucion.setIsNew(tipodevolucion.getIsNewAuxiliar());	
			tipodevolucion.setIsChanged(tipodevolucion.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipodevolucion.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipodevolucion.setIsDeletedAuxiliar(false);	
			tipodevolucion.setIsNewAuxiliar(false);	
			tipodevolucion.setIsChangedAuxiliar(false);
			
			tipodevolucion.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoDevolucions(List<TipoDevolucion> tipodevolucions,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoDevolucion tipodevolucion : tipodevolucions) {
			if(conAsignarBase && tipodevolucion.getConCambioAuxiliar()) {
				tipodevolucion.setIsDeleted(tipodevolucion.getIsDeletedAuxiliar());	
				tipodevolucion.setIsNew(tipodevolucion.getIsNewAuxiliar());	
				tipodevolucion.setIsChanged(tipodevolucion.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipodevolucion.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipodevolucion.setIsDeletedAuxiliar(false);	
				tipodevolucion.setIsNewAuxiliar(false);	
				tipodevolucion.setIsChangedAuxiliar(false);
				
				tipodevolucion.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoDevolucion(TipoDevolucion tipodevolucion,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoDevolucions(List<TipoDevolucion> tipodevolucions,Boolean conEnteros) throws Exception  {
		
		for(TipoDevolucion tipodevolucion: tipodevolucions) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoDevolucion(List<TipoDevolucion> tipodevolucions,TipoDevolucion tipodevolucionAux) throws Exception  {
		TipoDevolucionConstantesFunciones.InicializarValoresTipoDevolucion(tipodevolucionAux,true);
		
		for(TipoDevolucion tipodevolucion: tipodevolucions) {
			if(tipodevolucion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoDevolucion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoDevolucionConstantesFunciones.getArrayColumnasGlobalesTipoDevolucion(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoDevolucion(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoDevolucion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoDevolucion> tipodevolucions,TipoDevolucion tipodevolucion,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoDevolucion tipodevolucionAux: tipodevolucions) {
			if(tipodevolucionAux!=null && tipodevolucion!=null) {
				if((tipodevolucionAux.getId()==null && tipodevolucion.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipodevolucionAux.getId()!=null && tipodevolucion.getId()!=null){
					if(tipodevolucionAux.getId().equals(tipodevolucion.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoDevolucion(List<TipoDevolucion> tipodevolucions) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoDevolucion tipodevolucion: tipodevolucions) {			
			if(tipodevolucion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoDevolucion() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoDevolucionConstantesFunciones.LABEL_ID, TipoDevolucionConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoDevolucionConstantesFunciones.LABEL_VERSIONROW, TipoDevolucionConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoDevolucionConstantesFunciones.LABEL_IDPAIS, TipoDevolucionConstantesFunciones.IDPAIS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoDevolucionConstantesFunciones.LABEL_NOMBRE, TipoDevolucionConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoDevolucion() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoDevolucionConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoDevolucionConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoDevolucionConstantesFunciones.IDPAIS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoDevolucionConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoDevolucion() throws Exception  {
		return TipoDevolucionConstantesFunciones.getTiposSeleccionarTipoDevolucion(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoDevolucion(Boolean conFk) throws Exception  {
		return TipoDevolucionConstantesFunciones.getTiposSeleccionarTipoDevolucion(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoDevolucion(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoDevolucionConstantesFunciones.LABEL_IDPAIS);
			reporte.setsDescripcion(TipoDevolucionConstantesFunciones.LABEL_IDPAIS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoDevolucionConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoDevolucionConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoDevolucion(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoDevolucion(TipoDevolucion tipodevolucionAux) throws Exception {
		
			tipodevolucionAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(tipodevolucionAux.getPais()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoDevolucion(List<TipoDevolucion> tipodevolucionsTemp) throws Exception {
		for(TipoDevolucion tipodevolucionAux:tipodevolucionsTemp) {
			
			tipodevolucionAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(tipodevolucionAux.getPais()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoDevolucion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Pais.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Pais.class)) {
						classes.add(new Classe(Pais.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoDevolucion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoDevolucion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoDevolucionConstantesFunciones.getClassesRelationshipsOfTipoDevolucion(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoDevolucion(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoDevolucion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoDevolucionConstantesFunciones.getClassesRelationshipsFromStringsOfTipoDevolucion(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoDevolucion(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TipoDevolucion tipodevolucion,List<TipoDevolucion> tipodevolucions,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoDevolucion tipodevolucionEncontrado=null;
			
			for(TipoDevolucion tipodevolucionLocal:tipodevolucions) {
				if(tipodevolucionLocal.getId().equals(tipodevolucion.getId())) {
					tipodevolucionEncontrado=tipodevolucionLocal;
					
					tipodevolucionLocal.setIsChanged(tipodevolucion.getIsChanged());
					tipodevolucionLocal.setIsNew(tipodevolucion.getIsNew());
					tipodevolucionLocal.setIsDeleted(tipodevolucion.getIsDeleted());
					
					tipodevolucionLocal.setGeneralEntityOriginal(tipodevolucion.getGeneralEntityOriginal());
					
					tipodevolucionLocal.setId(tipodevolucion.getId());	
					tipodevolucionLocal.setVersionRow(tipodevolucion.getVersionRow());	
					tipodevolucionLocal.setid_pais(tipodevolucion.getid_pais());	
					tipodevolucionLocal.setnombre(tipodevolucion.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipodevolucion.getIsDeleted()) {
				if(!existe) {
					tipodevolucions.add(tipodevolucion);
				}
			} else {
				if(tipodevolucionEncontrado!=null && permiteQuitar)  {
					tipodevolucions.remove(tipodevolucionEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoDevolucion tipodevolucion,List<TipoDevolucion> tipodevolucions) throws Exception {
		try	{			
			for(TipoDevolucion tipodevolucionLocal:tipodevolucions) {
				if(tipodevolucionLocal.getId().equals(tipodevolucion.getId())) {
					tipodevolucionLocal.setIsSelected(tipodevolucion.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoDevolucion(List<TipoDevolucion> tipodevolucionsAux) throws Exception {
		//this.tipodevolucionsAux=tipodevolucionsAux;
		
		for(TipoDevolucion tipodevolucionAux:tipodevolucionsAux) {
			if(tipodevolucionAux.getIsChanged()) {
				tipodevolucionAux.setIsChanged(false);
			}		
			
			if(tipodevolucionAux.getIsNew()) {
				tipodevolucionAux.setIsNew(false);
			}	
			
			if(tipodevolucionAux.getIsDeleted()) {
				tipodevolucionAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoDevolucion(TipoDevolucion tipodevolucionAux) throws Exception {
		//this.tipodevolucionAux=tipodevolucionAux;
		
			if(tipodevolucionAux.getIsChanged()) {
				tipodevolucionAux.setIsChanged(false);
			}		
			
			if(tipodevolucionAux.getIsNew()) {
				tipodevolucionAux.setIsNew(false);
			}	
			
			if(tipodevolucionAux.getIsDeleted()) {
				tipodevolucionAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoDevolucion tipodevolucionAsignar,TipoDevolucion tipodevolucion) throws Exception {
		tipodevolucionAsignar.setId(tipodevolucion.getId());	
		tipodevolucionAsignar.setVersionRow(tipodevolucion.getVersionRow());	
		tipodevolucionAsignar.setid_pais(tipodevolucion.getid_pais());
		tipodevolucionAsignar.setpais_descripcion(tipodevolucion.getpais_descripcion());	
		tipodevolucionAsignar.setnombre(tipodevolucion.getnombre());	
	}
	
	public static void inicializarTipoDevolucion(TipoDevolucion tipodevolucion) throws Exception {
		try {
				tipodevolucion.setId(0L);	
					
				tipodevolucion.setid_pais(-1L);	
				tipodevolucion.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoDevolucion(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoDevolucionConstantesFunciones.LABEL_IDPAIS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoDevolucionConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoDevolucion(String sTipo,Row row,Workbook workbook,TipoDevolucion tipodevolucion,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipodevolucion.getpais_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipodevolucion.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoDevolucion=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoDevolucion() {
		return this.sFinalQueryTipoDevolucion;
	}
	
	public void setsFinalQueryTipoDevolucion(String sFinalQueryTipoDevolucion) {
		this.sFinalQueryTipoDevolucion= sFinalQueryTipoDevolucion;
	}
	
	public Border resaltarSeleccionarTipoDevolucion=null;
	
	public Border setResaltarSeleccionarTipoDevolucion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDevolucionBeanSwingJInternalFrame tipodevolucionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipodevolucionBeanSwingJInternalFrame.jTtoolBarTipoDevolucion.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoDevolucion= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoDevolucion() {
		return this.resaltarSeleccionarTipoDevolucion;
	}
	
	public void setResaltarSeleccionarTipoDevolucion(Border borderResaltarSeleccionarTipoDevolucion) {
		this.resaltarSeleccionarTipoDevolucion= borderResaltarSeleccionarTipoDevolucion;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoDevolucion=null;
	public Boolean mostraridTipoDevolucion=true;
	public Boolean activaridTipoDevolucion=true;

	public Border resaltarid_paisTipoDevolucion=null;
	public Boolean mostrarid_paisTipoDevolucion=true;
	public Boolean activarid_paisTipoDevolucion=true;
	public Boolean cargarid_paisTipoDevolucion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_paisTipoDevolucion=false;//ConEventDepend=true

	public Border resaltarnombreTipoDevolucion=null;
	public Boolean mostrarnombreTipoDevolucion=true;
	public Boolean activarnombreTipoDevolucion=true;

	
	

	public Border setResaltaridTipoDevolucion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDevolucionBeanSwingJInternalFrame tipodevolucionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipodevolucionBeanSwingJInternalFrame.jTtoolBarTipoDevolucion.setBorder(borderResaltar);
		
		this.resaltaridTipoDevolucion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoDevolucion() {
		return this.resaltaridTipoDevolucion;
	}

	public void setResaltaridTipoDevolucion(Border borderResaltar) {
		this.resaltaridTipoDevolucion= borderResaltar;
	}

	public Boolean getMostraridTipoDevolucion() {
		return this.mostraridTipoDevolucion;
	}

	public void setMostraridTipoDevolucion(Boolean mostraridTipoDevolucion) {
		this.mostraridTipoDevolucion= mostraridTipoDevolucion;
	}

	public Boolean getActivaridTipoDevolucion() {
		return this.activaridTipoDevolucion;
	}

	public void setActivaridTipoDevolucion(Boolean activaridTipoDevolucion) {
		this.activaridTipoDevolucion= activaridTipoDevolucion;
	}

	public Border setResaltarid_paisTipoDevolucion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDevolucionBeanSwingJInternalFrame tipodevolucionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipodevolucionBeanSwingJInternalFrame.jTtoolBarTipoDevolucion.setBorder(borderResaltar);
		
		this.resaltarid_paisTipoDevolucion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_paisTipoDevolucion() {
		return this.resaltarid_paisTipoDevolucion;
	}

	public void setResaltarid_paisTipoDevolucion(Border borderResaltar) {
		this.resaltarid_paisTipoDevolucion= borderResaltar;
	}

	public Boolean getMostrarid_paisTipoDevolucion() {
		return this.mostrarid_paisTipoDevolucion;
	}

	public void setMostrarid_paisTipoDevolucion(Boolean mostrarid_paisTipoDevolucion) {
		this.mostrarid_paisTipoDevolucion= mostrarid_paisTipoDevolucion;
	}

	public Boolean getActivarid_paisTipoDevolucion() {
		return this.activarid_paisTipoDevolucion;
	}

	public void setActivarid_paisTipoDevolucion(Boolean activarid_paisTipoDevolucion) {
		this.activarid_paisTipoDevolucion= activarid_paisTipoDevolucion;
	}

	public Boolean getCargarid_paisTipoDevolucion() {
		return this.cargarid_paisTipoDevolucion;
	}

	public void setCargarid_paisTipoDevolucion(Boolean cargarid_paisTipoDevolucion) {
		this.cargarid_paisTipoDevolucion= cargarid_paisTipoDevolucion;
	}

	public Border setResaltarnombreTipoDevolucion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDevolucionBeanSwingJInternalFrame tipodevolucionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipodevolucionBeanSwingJInternalFrame.jTtoolBarTipoDevolucion.setBorder(borderResaltar);
		
		this.resaltarnombreTipoDevolucion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoDevolucion() {
		return this.resaltarnombreTipoDevolucion;
	}

	public void setResaltarnombreTipoDevolucion(Border borderResaltar) {
		this.resaltarnombreTipoDevolucion= borderResaltar;
	}

	public Boolean getMostrarnombreTipoDevolucion() {
		return this.mostrarnombreTipoDevolucion;
	}

	public void setMostrarnombreTipoDevolucion(Boolean mostrarnombreTipoDevolucion) {
		this.mostrarnombreTipoDevolucion= mostrarnombreTipoDevolucion;
	}

	public Boolean getActivarnombreTipoDevolucion() {
		return this.activarnombreTipoDevolucion;
	}

	public void setActivarnombreTipoDevolucion(Boolean activarnombreTipoDevolucion) {
		this.activarnombreTipoDevolucion= activarnombreTipoDevolucion;
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
		
		
		this.setMostraridTipoDevolucion(esInicial);
		this.setMostrarid_paisTipoDevolucion(esInicial);
		this.setMostrarnombreTipoDevolucion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoDevolucionConstantesFunciones.ID)) {
				this.setMostraridTipoDevolucion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDevolucionConstantesFunciones.IDPAIS)) {
				this.setMostrarid_paisTipoDevolucion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDevolucionConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoDevolucion(esAsigna);
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
		
		
		this.setActivaridTipoDevolucion(esInicial);
		this.setActivarid_paisTipoDevolucion(esInicial);
		this.setActivarnombreTipoDevolucion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoDevolucionConstantesFunciones.ID)) {
				this.setActivaridTipoDevolucion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDevolucionConstantesFunciones.IDPAIS)) {
				this.setActivarid_paisTipoDevolucion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDevolucionConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoDevolucion(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoDevolucionBeanSwingJInternalFrame tipodevolucionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoDevolucion(esInicial);
		this.setResaltarid_paisTipoDevolucion(esInicial);
		this.setResaltarnombreTipoDevolucion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoDevolucionConstantesFunciones.ID)) {
				this.setResaltaridTipoDevolucion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDevolucionConstantesFunciones.IDPAIS)) {
				this.setResaltarid_paisTipoDevolucion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDevolucionConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoDevolucion(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoDevolucionBeanSwingJInternalFrame tipodevolucionBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPorNombreTipoDevolucion=true;

	public Boolean getMostrarBusquedaPorNombreTipoDevolucion() {
		return this.mostrarBusquedaPorNombreTipoDevolucion;
	}

	public void setMostrarBusquedaPorNombreTipoDevolucion(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreTipoDevolucion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPaisTipoDevolucion=true;

	public Boolean getMostrarFK_IdPaisTipoDevolucion() {
		return this.mostrarFK_IdPaisTipoDevolucion;
	}

	public void setMostrarFK_IdPaisTipoDevolucion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPaisTipoDevolucion= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorNombreTipoDevolucion=true;

	public Boolean getActivarBusquedaPorNombreTipoDevolucion() {
		return this.activarBusquedaPorNombreTipoDevolucion;
	}

	public void setActivarBusquedaPorNombreTipoDevolucion(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreTipoDevolucion= habilitarResaltar;
	}

	public Boolean activarFK_IdPaisTipoDevolucion=true;

	public Boolean getActivarFK_IdPaisTipoDevolucion() {
		return this.activarFK_IdPaisTipoDevolucion;
	}

	public void setActivarFK_IdPaisTipoDevolucion(Boolean habilitarResaltar) {
		this.activarFK_IdPaisTipoDevolucion= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorNombreTipoDevolucion=null;

	public Border getResaltarBusquedaPorNombreTipoDevolucion() {
		return this.resaltarBusquedaPorNombreTipoDevolucion;
	}

	public void setResaltarBusquedaPorNombreTipoDevolucion(Border borderResaltar) {
		this.resaltarBusquedaPorNombreTipoDevolucion= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreTipoDevolucion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDevolucionBeanSwingJInternalFrame tipodevolucionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreTipoDevolucion= borderResaltar;
	}

	public Border resaltarFK_IdPaisTipoDevolucion=null;

	public Border getResaltarFK_IdPaisTipoDevolucion() {
		return this.resaltarFK_IdPaisTipoDevolucion;
	}

	public void setResaltarFK_IdPaisTipoDevolucion(Border borderResaltar) {
		this.resaltarFK_IdPaisTipoDevolucion= borderResaltar;
	}

	public void setResaltarFK_IdPaisTipoDevolucion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDevolucionBeanSwingJInternalFrame tipodevolucionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPaisTipoDevolucion= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}