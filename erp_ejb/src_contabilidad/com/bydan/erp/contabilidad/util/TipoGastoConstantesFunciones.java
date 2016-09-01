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
package com.bydan.erp.contabilidad.util;

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


import com.bydan.erp.contabilidad.util.TipoGastoConstantesFunciones;
import com.bydan.erp.contabilidad.util.TipoGastoParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.TipoGastoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoGastoConstantesFunciones extends TipoGastoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoGasto";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoGasto"+TipoGastoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoGastoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoGastoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoGastoConstantesFunciones.SCHEMA+"_"+TipoGastoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoGastoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoGastoConstantesFunciones.SCHEMA+"_"+TipoGastoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoGastoConstantesFunciones.SCHEMA+"_"+TipoGastoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoGastoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoGastoConstantesFunciones.SCHEMA+"_"+TipoGastoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoGastoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoGastoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoGastoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoGastoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoGastoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoGastoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoGastoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoGastoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoGastoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoGastoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Gasto s";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Gasto ";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Gasto";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoGasto";
	public static final String OBJECTNAME="tipogasto";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="tipo_gasto";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipogasto from "+TipoGastoConstantesFunciones.SPERSISTENCENAME+" tipogasto";
	public static String QUERYSELECTNATIVE="select "+TipoGastoConstantesFunciones.SCHEMA+"."+TipoGastoConstantesFunciones.TABLENAME+".id,"+TipoGastoConstantesFunciones.SCHEMA+"."+TipoGastoConstantesFunciones.TABLENAME+".version_row,"+TipoGastoConstantesFunciones.SCHEMA+"."+TipoGastoConstantesFunciones.TABLENAME+".id_pais,"+TipoGastoConstantesFunciones.SCHEMA+"."+TipoGastoConstantesFunciones.TABLENAME+".nombre from "+TipoGastoConstantesFunciones.SCHEMA+"."+TipoGastoConstantesFunciones.TABLENAME;//+" as "+TipoGastoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoGastoConstantesFuncionesAdditional tipogastoConstantesFuncionesAdditional=null;
	
	public TipoGastoConstantesFuncionesAdditional getTipoGastoConstantesFuncionesAdditional() {
		return this.tipogastoConstantesFuncionesAdditional;
	}
	
	public void setTipoGastoConstantesFuncionesAdditional(TipoGastoConstantesFuncionesAdditional tipogastoConstantesFuncionesAdditional) {
		try {
			this.tipogastoConstantesFuncionesAdditional=tipogastoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
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
	
	public static String getTipoGastoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoGastoConstantesFunciones.IDPAIS)) {sLabelColumna=TipoGastoConstantesFunciones.LABEL_IDPAIS;}
		if(sNombreColumna.equals(TipoGastoConstantesFunciones.NOMBRE)) {sLabelColumna=TipoGastoConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoGastoDescripcion(TipoGasto tipogasto) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipogasto !=null/* && tipogasto.getId()!=0*/) {
			sDescripcion=tipogasto.getnombre();//tipogastotipogasto.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoGastoDescripcionDetallado(TipoGasto tipogasto) {
		String sDescripcion="";
			
		sDescripcion+=TipoGastoConstantesFunciones.ID+"=";
		sDescripcion+=tipogasto.getId().toString()+",";
		sDescripcion+=TipoGastoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipogasto.getVersionRow().toString()+",";
		sDescripcion+=TipoGastoConstantesFunciones.IDPAIS+"=";
		sDescripcion+=tipogasto.getid_pais().toString()+",";
		sDescripcion+=TipoGastoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipogasto.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoGastoDescripcion(TipoGasto tipogasto,String sValor) throws Exception {			
		if(tipogasto !=null) {
			tipogasto.setnombre(sValor);;//tipogastotipogasto.getnombre().trim();
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
		} else if(sNombreIndice.equals("BusquedaPorId")) {
			sNombreIndice="Tipo=  Por Id";
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoGasto(TipoGasto tipogasto,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipogasto.setnombre(tipogasto.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoGastos(List<TipoGasto> tipogastos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoGasto tipogasto: tipogastos) {
			tipogasto.setnombre(tipogasto.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoGasto(TipoGasto tipogasto,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipogasto.getConCambioAuxiliar()) {
			tipogasto.setIsDeleted(tipogasto.getIsDeletedAuxiliar());	
			tipogasto.setIsNew(tipogasto.getIsNewAuxiliar());	
			tipogasto.setIsChanged(tipogasto.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipogasto.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipogasto.setIsDeletedAuxiliar(false);	
			tipogasto.setIsNewAuxiliar(false);	
			tipogasto.setIsChangedAuxiliar(false);
			
			tipogasto.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoGastos(List<TipoGasto> tipogastos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoGasto tipogasto : tipogastos) {
			if(conAsignarBase && tipogasto.getConCambioAuxiliar()) {
				tipogasto.setIsDeleted(tipogasto.getIsDeletedAuxiliar());	
				tipogasto.setIsNew(tipogasto.getIsNewAuxiliar());	
				tipogasto.setIsChanged(tipogasto.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipogasto.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipogasto.setIsDeletedAuxiliar(false);	
				tipogasto.setIsNewAuxiliar(false);	
				tipogasto.setIsChangedAuxiliar(false);
				
				tipogasto.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoGasto(TipoGasto tipogasto,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoGastos(List<TipoGasto> tipogastos,Boolean conEnteros) throws Exception  {
		
		for(TipoGasto tipogasto: tipogastos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoGasto(List<TipoGasto> tipogastos,TipoGasto tipogastoAux) throws Exception  {
		TipoGastoConstantesFunciones.InicializarValoresTipoGasto(tipogastoAux,true);
		
		for(TipoGasto tipogasto: tipogastos) {
			if(tipogasto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoGasto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoGastoConstantesFunciones.getArrayColumnasGlobalesTipoGasto(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoGasto(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoGasto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoGasto> tipogastos,TipoGasto tipogasto,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoGasto tipogastoAux: tipogastos) {
			if(tipogastoAux!=null && tipogasto!=null) {
				if((tipogastoAux.getId()==null && tipogasto.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipogastoAux.getId()!=null && tipogasto.getId()!=null){
					if(tipogastoAux.getId().equals(tipogasto.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoGasto(List<TipoGasto> tipogastos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoGasto tipogasto: tipogastos) {			
			if(tipogasto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoGasto() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoGastoConstantesFunciones.LABEL_ID, TipoGastoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoGastoConstantesFunciones.LABEL_VERSIONROW, TipoGastoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoGastoConstantesFunciones.LABEL_IDPAIS, TipoGastoConstantesFunciones.IDPAIS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoGastoConstantesFunciones.LABEL_NOMBRE, TipoGastoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoGasto() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoGastoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoGastoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoGastoConstantesFunciones.IDPAIS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoGastoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoGasto() throws Exception  {
		return TipoGastoConstantesFunciones.getTiposSeleccionarTipoGasto(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoGasto(Boolean conFk) throws Exception  {
		return TipoGastoConstantesFunciones.getTiposSeleccionarTipoGasto(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoGasto(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoGastoConstantesFunciones.LABEL_IDPAIS);
			reporte.setsDescripcion(TipoGastoConstantesFunciones.LABEL_IDPAIS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoGastoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoGastoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoGasto(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoGasto(TipoGasto tipogastoAux) throws Exception {
		
			tipogastoAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(tipogastoAux.getPais()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoGasto(List<TipoGasto> tipogastosTemp) throws Exception {
		for(TipoGasto tipogastoAux:tipogastosTemp) {
			
			tipogastoAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(tipogastoAux.getPais()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoGasto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoGasto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoGasto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoGastoConstantesFunciones.getClassesRelationshipsOfTipoGasto(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoGasto(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoGasto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoGastoConstantesFunciones.getClassesRelationshipsFromStringsOfTipoGasto(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoGasto(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TipoGasto tipogasto,List<TipoGasto> tipogastos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoGasto tipogastoEncontrado=null;
			
			for(TipoGasto tipogastoLocal:tipogastos) {
				if(tipogastoLocal.getId().equals(tipogasto.getId())) {
					tipogastoEncontrado=tipogastoLocal;
					
					tipogastoLocal.setIsChanged(tipogasto.getIsChanged());
					tipogastoLocal.setIsNew(tipogasto.getIsNew());
					tipogastoLocal.setIsDeleted(tipogasto.getIsDeleted());
					
					tipogastoLocal.setGeneralEntityOriginal(tipogasto.getGeneralEntityOriginal());
					
					tipogastoLocal.setId(tipogasto.getId());	
					tipogastoLocal.setVersionRow(tipogasto.getVersionRow());	
					tipogastoLocal.setid_pais(tipogasto.getid_pais());	
					tipogastoLocal.setnombre(tipogasto.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipogasto.getIsDeleted()) {
				if(!existe) {
					tipogastos.add(tipogasto);
				}
			} else {
				if(tipogastoEncontrado!=null && permiteQuitar)  {
					tipogastos.remove(tipogastoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoGasto tipogasto,List<TipoGasto> tipogastos) throws Exception {
		try	{			
			for(TipoGasto tipogastoLocal:tipogastos) {
				if(tipogastoLocal.getId().equals(tipogasto.getId())) {
					tipogastoLocal.setIsSelected(tipogasto.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoGasto(List<TipoGasto> tipogastosAux) throws Exception {
		//this.tipogastosAux=tipogastosAux;
		
		for(TipoGasto tipogastoAux:tipogastosAux) {
			if(tipogastoAux.getIsChanged()) {
				tipogastoAux.setIsChanged(false);
			}		
			
			if(tipogastoAux.getIsNew()) {
				tipogastoAux.setIsNew(false);
			}	
			
			if(tipogastoAux.getIsDeleted()) {
				tipogastoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoGasto(TipoGasto tipogastoAux) throws Exception {
		//this.tipogastoAux=tipogastoAux;
		
			if(tipogastoAux.getIsChanged()) {
				tipogastoAux.setIsChanged(false);
			}		
			
			if(tipogastoAux.getIsNew()) {
				tipogastoAux.setIsNew(false);
			}	
			
			if(tipogastoAux.getIsDeleted()) {
				tipogastoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoGasto tipogastoAsignar,TipoGasto tipogasto) throws Exception {
		tipogastoAsignar.setId(tipogasto.getId());	
		tipogastoAsignar.setVersionRow(tipogasto.getVersionRow());	
		tipogastoAsignar.setid_pais(tipogasto.getid_pais());
		tipogastoAsignar.setpais_descripcion(tipogasto.getpais_descripcion());	
		tipogastoAsignar.setnombre(tipogasto.getnombre());	
	}
	
	public static void inicializarTipoGasto(TipoGasto tipogasto) throws Exception {
		try {
				tipogasto.setId(0L);	
					
				tipogasto.setid_pais(-1L);	
				tipogasto.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoGasto(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoGastoConstantesFunciones.LABEL_IDPAIS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoGastoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoGasto(String sTipo,Row row,Workbook workbook,TipoGasto tipogasto,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipogasto.getpais_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipogasto.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoGasto=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoGasto() {
		return this.sFinalQueryTipoGasto;
	}
	
	public void setsFinalQueryTipoGasto(String sFinalQueryTipoGasto) {
		this.sFinalQueryTipoGasto= sFinalQueryTipoGasto;
	}
	
	public Border resaltarSeleccionarTipoGasto=null;
	
	public Border setResaltarSeleccionarTipoGasto(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGastoBeanSwingJInternalFrame tipogastoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipogastoBeanSwingJInternalFrame.jTtoolBarTipoGasto.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoGasto= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoGasto() {
		return this.resaltarSeleccionarTipoGasto;
	}
	
	public void setResaltarSeleccionarTipoGasto(Border borderResaltarSeleccionarTipoGasto) {
		this.resaltarSeleccionarTipoGasto= borderResaltarSeleccionarTipoGasto;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoGasto=null;
	public Boolean mostraridTipoGasto=true;
	public Boolean activaridTipoGasto=true;

	public Border resaltarid_paisTipoGasto=null;
	public Boolean mostrarid_paisTipoGasto=true;
	public Boolean activarid_paisTipoGasto=true;
	public Boolean cargarid_paisTipoGasto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_paisTipoGasto=false;//ConEventDepend=true

	public Border resaltarnombreTipoGasto=null;
	public Boolean mostrarnombreTipoGasto=true;
	public Boolean activarnombreTipoGasto=true;

	
	

	public Border setResaltaridTipoGasto(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGastoBeanSwingJInternalFrame tipogastoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipogastoBeanSwingJInternalFrame.jTtoolBarTipoGasto.setBorder(borderResaltar);
		
		this.resaltaridTipoGasto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoGasto() {
		return this.resaltaridTipoGasto;
	}

	public void setResaltaridTipoGasto(Border borderResaltar) {
		this.resaltaridTipoGasto= borderResaltar;
	}

	public Boolean getMostraridTipoGasto() {
		return this.mostraridTipoGasto;
	}

	public void setMostraridTipoGasto(Boolean mostraridTipoGasto) {
		this.mostraridTipoGasto= mostraridTipoGasto;
	}

	public Boolean getActivaridTipoGasto() {
		return this.activaridTipoGasto;
	}

	public void setActivaridTipoGasto(Boolean activaridTipoGasto) {
		this.activaridTipoGasto= activaridTipoGasto;
	}

	public Border setResaltarid_paisTipoGasto(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGastoBeanSwingJInternalFrame tipogastoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipogastoBeanSwingJInternalFrame.jTtoolBarTipoGasto.setBorder(borderResaltar);
		
		this.resaltarid_paisTipoGasto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_paisTipoGasto() {
		return this.resaltarid_paisTipoGasto;
	}

	public void setResaltarid_paisTipoGasto(Border borderResaltar) {
		this.resaltarid_paisTipoGasto= borderResaltar;
	}

	public Boolean getMostrarid_paisTipoGasto() {
		return this.mostrarid_paisTipoGasto;
	}

	public void setMostrarid_paisTipoGasto(Boolean mostrarid_paisTipoGasto) {
		this.mostrarid_paisTipoGasto= mostrarid_paisTipoGasto;
	}

	public Boolean getActivarid_paisTipoGasto() {
		return this.activarid_paisTipoGasto;
	}

	public void setActivarid_paisTipoGasto(Boolean activarid_paisTipoGasto) {
		this.activarid_paisTipoGasto= activarid_paisTipoGasto;
	}

	public Boolean getCargarid_paisTipoGasto() {
		return this.cargarid_paisTipoGasto;
	}

	public void setCargarid_paisTipoGasto(Boolean cargarid_paisTipoGasto) {
		this.cargarid_paisTipoGasto= cargarid_paisTipoGasto;
	}

	public Border setResaltarnombreTipoGasto(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGastoBeanSwingJInternalFrame tipogastoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipogastoBeanSwingJInternalFrame.jTtoolBarTipoGasto.setBorder(borderResaltar);
		
		this.resaltarnombreTipoGasto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoGasto() {
		return this.resaltarnombreTipoGasto;
	}

	public void setResaltarnombreTipoGasto(Border borderResaltar) {
		this.resaltarnombreTipoGasto= borderResaltar;
	}

	public Boolean getMostrarnombreTipoGasto() {
		return this.mostrarnombreTipoGasto;
	}

	public void setMostrarnombreTipoGasto(Boolean mostrarnombreTipoGasto) {
		this.mostrarnombreTipoGasto= mostrarnombreTipoGasto;
	}

	public Boolean getActivarnombreTipoGasto() {
		return this.activarnombreTipoGasto;
	}

	public void setActivarnombreTipoGasto(Boolean activarnombreTipoGasto) {
		this.activarnombreTipoGasto= activarnombreTipoGasto;
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
		
		
		this.setMostraridTipoGasto(esInicial);
		this.setMostrarid_paisTipoGasto(esInicial);
		this.setMostrarnombreTipoGasto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoGastoConstantesFunciones.ID)) {
				this.setMostraridTipoGasto(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGastoConstantesFunciones.IDPAIS)) {
				this.setMostrarid_paisTipoGasto(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGastoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoGasto(esAsigna);
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
		
		
		this.setActivaridTipoGasto(esInicial);
		this.setActivarid_paisTipoGasto(esInicial);
		this.setActivarnombreTipoGasto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoGastoConstantesFunciones.ID)) {
				this.setActivaridTipoGasto(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGastoConstantesFunciones.IDPAIS)) {
				this.setActivarid_paisTipoGasto(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGastoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoGasto(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoGastoBeanSwingJInternalFrame tipogastoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoGasto(esInicial);
		this.setResaltarid_paisTipoGasto(esInicial);
		this.setResaltarnombreTipoGasto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoGastoConstantesFunciones.ID)) {
				this.setResaltaridTipoGasto(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGastoConstantesFunciones.IDPAIS)) {
				this.setResaltarid_paisTipoGasto(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGastoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoGasto(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoGastoBeanSwingJInternalFrame tipogastoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPorIdTipoGasto=true;

	public Boolean getMostrarBusquedaPorIdTipoGasto() {
		return this.mostrarBusquedaPorIdTipoGasto;
	}

	public void setMostrarBusquedaPorIdTipoGasto(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorIdTipoGasto= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreTipoGasto=true;

	public Boolean getMostrarBusquedaPorNombreTipoGasto() {
		return this.mostrarBusquedaPorNombreTipoGasto;
	}

	public void setMostrarBusquedaPorNombreTipoGasto(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreTipoGasto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPaisTipoGasto=true;

	public Boolean getMostrarFK_IdPaisTipoGasto() {
		return this.mostrarFK_IdPaisTipoGasto;
	}

	public void setMostrarFK_IdPaisTipoGasto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPaisTipoGasto= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorIdTipoGasto=true;

	public Boolean getActivarBusquedaPorIdTipoGasto() {
		return this.activarBusquedaPorIdTipoGasto;
	}

	public void setActivarBusquedaPorIdTipoGasto(Boolean habilitarResaltar) {
		this.activarBusquedaPorIdTipoGasto= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreTipoGasto=true;

	public Boolean getActivarBusquedaPorNombreTipoGasto() {
		return this.activarBusquedaPorNombreTipoGasto;
	}

	public void setActivarBusquedaPorNombreTipoGasto(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreTipoGasto= habilitarResaltar;
	}

	public Boolean activarFK_IdPaisTipoGasto=true;

	public Boolean getActivarFK_IdPaisTipoGasto() {
		return this.activarFK_IdPaisTipoGasto;
	}

	public void setActivarFK_IdPaisTipoGasto(Boolean habilitarResaltar) {
		this.activarFK_IdPaisTipoGasto= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorIdTipoGasto=null;

	public Border getResaltarBusquedaPorIdTipoGasto() {
		return this.resaltarBusquedaPorIdTipoGasto;
	}

	public void setResaltarBusquedaPorIdTipoGasto(Border borderResaltar) {
		this.resaltarBusquedaPorIdTipoGasto= borderResaltar;
	}

	public void setResaltarBusquedaPorIdTipoGasto(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGastoBeanSwingJInternalFrame tipogastoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorIdTipoGasto= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreTipoGasto=null;

	public Border getResaltarBusquedaPorNombreTipoGasto() {
		return this.resaltarBusquedaPorNombreTipoGasto;
	}

	public void setResaltarBusquedaPorNombreTipoGasto(Border borderResaltar) {
		this.resaltarBusquedaPorNombreTipoGasto= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreTipoGasto(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGastoBeanSwingJInternalFrame tipogastoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreTipoGasto= borderResaltar;
	}

	public Border resaltarFK_IdPaisTipoGasto=null;

	public Border getResaltarFK_IdPaisTipoGasto() {
		return this.resaltarFK_IdPaisTipoGasto;
	}

	public void setResaltarFK_IdPaisTipoGasto(Border borderResaltar) {
		this.resaltarFK_IdPaisTipoGasto= borderResaltar;
	}

	public void setResaltarFK_IdPaisTipoGasto(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGastoBeanSwingJInternalFrame tipogastoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPaisTipoGasto= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}