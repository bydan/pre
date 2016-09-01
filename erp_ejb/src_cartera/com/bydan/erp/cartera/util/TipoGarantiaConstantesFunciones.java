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
package com.bydan.erp.cartera.util;

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


import com.bydan.erp.cartera.util.TipoGarantiaConstantesFunciones;
import com.bydan.erp.cartera.util.TipoGarantiaParameterReturnGeneral;
//import com.bydan.erp.cartera.util.TipoGarantiaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoGarantiaConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoGarantia";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoGarantia"+TipoGarantiaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoGarantiaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoGarantiaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoGarantiaConstantesFunciones.SCHEMA+"_"+TipoGarantiaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoGarantiaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoGarantiaConstantesFunciones.SCHEMA+"_"+TipoGarantiaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoGarantiaConstantesFunciones.SCHEMA+"_"+TipoGarantiaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoGarantiaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoGarantiaConstantesFunciones.SCHEMA+"_"+TipoGarantiaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoGarantiaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoGarantiaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoGarantiaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoGarantiaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoGarantiaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoGarantiaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoGarantiaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoGarantiaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoGarantiaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoGarantiaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Garantias";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Garantia";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Garantia";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoGarantia";
	public static final String OBJECTNAME="tipogarantia";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="tipo_garantia";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipogarantia from "+TipoGarantiaConstantesFunciones.SPERSISTENCENAME+" tipogarantia";
	public static String QUERYSELECTNATIVE="select "+TipoGarantiaConstantesFunciones.SCHEMA+"."+TipoGarantiaConstantesFunciones.TABLENAME+".id,"+TipoGarantiaConstantesFunciones.SCHEMA+"."+TipoGarantiaConstantesFunciones.TABLENAME+".version_row,"+TipoGarantiaConstantesFunciones.SCHEMA+"."+TipoGarantiaConstantesFunciones.TABLENAME+".id_pais,"+TipoGarantiaConstantesFunciones.SCHEMA+"."+TipoGarantiaConstantesFunciones.TABLENAME+".codigo,"+TipoGarantiaConstantesFunciones.SCHEMA+"."+TipoGarantiaConstantesFunciones.TABLENAME+".nombre from "+TipoGarantiaConstantesFunciones.SCHEMA+"."+TipoGarantiaConstantesFunciones.TABLENAME;//+" as "+TipoGarantiaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDPAIS= "id_pais";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDPAIS= "Pais";
		public static final String LABEL_IDPAIS_LOWER= "Pais";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getTipoGarantiaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoGarantiaConstantesFunciones.IDPAIS)) {sLabelColumna=TipoGarantiaConstantesFunciones.LABEL_IDPAIS;}
		if(sNombreColumna.equals(TipoGarantiaConstantesFunciones.CODIGO)) {sLabelColumna=TipoGarantiaConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoGarantiaConstantesFunciones.NOMBRE)) {sLabelColumna=TipoGarantiaConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getTipoGarantiaDescripcion(TipoGarantia tipogarantia) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipogarantia !=null/* && tipogarantia.getId()!=0*/) {
			sDescripcion=tipogarantia.getcodigo();//tipogarantiatipogarantia.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoGarantiaDescripcionDetallado(TipoGarantia tipogarantia) {
		String sDescripcion="";
			
		sDescripcion+=TipoGarantiaConstantesFunciones.ID+"=";
		sDescripcion+=tipogarantia.getId().toString()+",";
		sDescripcion+=TipoGarantiaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipogarantia.getVersionRow().toString()+",";
		sDescripcion+=TipoGarantiaConstantesFunciones.IDPAIS+"=";
		sDescripcion+=tipogarantia.getid_pais().toString()+",";
		sDescripcion+=TipoGarantiaConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipogarantia.getcodigo()+",";
		sDescripcion+=TipoGarantiaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipogarantia.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoGarantiaDescripcion(TipoGarantia tipogarantia,String sValor) throws Exception {			
		if(tipogarantia !=null) {
			tipogarantia.setcodigo(sValor);;//tipogarantiatipogarantia.getcodigo().trim();
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
		} else if(sNombreIndice.equals("BusquedaPorCodigo")) {
			sNombreIndice="Tipo=  Por Codigo";
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

	public static String getDetalleIndiceBusquedaPorCodigo(String codigo) {
		String sDetalleIndice=" Parametros->";
		if(codigo!=null) {sDetalleIndice+=" Codigo="+codigo;} 

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
	
	
	
	
	
	
	public static void quitarEspaciosTipoGarantia(TipoGarantia tipogarantia,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipogarantia.setcodigo(tipogarantia.getcodigo().trim());
		tipogarantia.setnombre(tipogarantia.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoGarantias(List<TipoGarantia> tipogarantias,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoGarantia tipogarantia: tipogarantias) {
			tipogarantia.setcodigo(tipogarantia.getcodigo().trim());
			tipogarantia.setnombre(tipogarantia.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoGarantia(TipoGarantia tipogarantia,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipogarantia.getConCambioAuxiliar()) {
			tipogarantia.setIsDeleted(tipogarantia.getIsDeletedAuxiliar());	
			tipogarantia.setIsNew(tipogarantia.getIsNewAuxiliar());	
			tipogarantia.setIsChanged(tipogarantia.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipogarantia.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipogarantia.setIsDeletedAuxiliar(false);	
			tipogarantia.setIsNewAuxiliar(false);	
			tipogarantia.setIsChangedAuxiliar(false);
			
			tipogarantia.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoGarantias(List<TipoGarantia> tipogarantias,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoGarantia tipogarantia : tipogarantias) {
			if(conAsignarBase && tipogarantia.getConCambioAuxiliar()) {
				tipogarantia.setIsDeleted(tipogarantia.getIsDeletedAuxiliar());	
				tipogarantia.setIsNew(tipogarantia.getIsNewAuxiliar());	
				tipogarantia.setIsChanged(tipogarantia.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipogarantia.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipogarantia.setIsDeletedAuxiliar(false);	
				tipogarantia.setIsNewAuxiliar(false);	
				tipogarantia.setIsChangedAuxiliar(false);
				
				tipogarantia.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoGarantia(TipoGarantia tipogarantia,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoGarantias(List<TipoGarantia> tipogarantias,Boolean conEnteros) throws Exception  {
		
		for(TipoGarantia tipogarantia: tipogarantias) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoGarantia(List<TipoGarantia> tipogarantias,TipoGarantia tipogarantiaAux) throws Exception  {
		TipoGarantiaConstantesFunciones.InicializarValoresTipoGarantia(tipogarantiaAux,true);
		
		for(TipoGarantia tipogarantia: tipogarantias) {
			if(tipogarantia.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoGarantia(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoGarantiaConstantesFunciones.getArrayColumnasGlobalesTipoGarantia(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoGarantia(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoGarantia(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoGarantia> tipogarantias,TipoGarantia tipogarantia,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoGarantia tipogarantiaAux: tipogarantias) {
			if(tipogarantiaAux!=null && tipogarantia!=null) {
				if((tipogarantiaAux.getId()==null && tipogarantia.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipogarantiaAux.getId()!=null && tipogarantia.getId()!=null){
					if(tipogarantiaAux.getId().equals(tipogarantia.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoGarantia(List<TipoGarantia> tipogarantias) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoGarantia tipogarantia: tipogarantias) {			
			if(tipogarantia.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoGarantia() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoGarantiaConstantesFunciones.LABEL_ID, TipoGarantiaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoGarantiaConstantesFunciones.LABEL_VERSIONROW, TipoGarantiaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoGarantiaConstantesFunciones.LABEL_IDPAIS, TipoGarantiaConstantesFunciones.IDPAIS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoGarantiaConstantesFunciones.LABEL_CODIGO, TipoGarantiaConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoGarantiaConstantesFunciones.LABEL_NOMBRE, TipoGarantiaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoGarantia() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoGarantiaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoGarantiaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoGarantiaConstantesFunciones.IDPAIS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoGarantiaConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoGarantiaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoGarantia() throws Exception  {
		return TipoGarantiaConstantesFunciones.getTiposSeleccionarTipoGarantia(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoGarantia(Boolean conFk) throws Exception  {
		return TipoGarantiaConstantesFunciones.getTiposSeleccionarTipoGarantia(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoGarantia(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoGarantiaConstantesFunciones.LABEL_IDPAIS);
			reporte.setsDescripcion(TipoGarantiaConstantesFunciones.LABEL_IDPAIS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoGarantiaConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoGarantiaConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoGarantiaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoGarantiaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoGarantia(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoGarantia(TipoGarantia tipogarantiaAux) throws Exception {
		
			tipogarantiaAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(tipogarantiaAux.getPais()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoGarantia(List<TipoGarantia> tipogarantiasTemp) throws Exception {
		for(TipoGarantia tipogarantiaAux:tipogarantiasTemp) {
			
			tipogarantiaAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(tipogarantiaAux.getPais()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoGarantia(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoGarantia(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoGarantia(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoGarantiaConstantesFunciones.getClassesRelationshipsOfTipoGarantia(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoGarantia(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoGarantia(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoGarantiaConstantesFunciones.getClassesRelationshipsFromStringsOfTipoGarantia(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoGarantia(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TipoGarantia tipogarantia,List<TipoGarantia> tipogarantias,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoGarantia tipogarantiaEncontrado=null;
			
			for(TipoGarantia tipogarantiaLocal:tipogarantias) {
				if(tipogarantiaLocal.getId().equals(tipogarantia.getId())) {
					tipogarantiaEncontrado=tipogarantiaLocal;
					
					tipogarantiaLocal.setIsChanged(tipogarantia.getIsChanged());
					tipogarantiaLocal.setIsNew(tipogarantia.getIsNew());
					tipogarantiaLocal.setIsDeleted(tipogarantia.getIsDeleted());
					
					tipogarantiaLocal.setGeneralEntityOriginal(tipogarantia.getGeneralEntityOriginal());
					
					tipogarantiaLocal.setId(tipogarantia.getId());	
					tipogarantiaLocal.setVersionRow(tipogarantia.getVersionRow());	
					tipogarantiaLocal.setid_pais(tipogarantia.getid_pais());	
					tipogarantiaLocal.setcodigo(tipogarantia.getcodigo());	
					tipogarantiaLocal.setnombre(tipogarantia.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipogarantia.getIsDeleted()) {
				if(!existe) {
					tipogarantias.add(tipogarantia);
				}
			} else {
				if(tipogarantiaEncontrado!=null && permiteQuitar)  {
					tipogarantias.remove(tipogarantiaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoGarantia tipogarantia,List<TipoGarantia> tipogarantias) throws Exception {
		try	{			
			for(TipoGarantia tipogarantiaLocal:tipogarantias) {
				if(tipogarantiaLocal.getId().equals(tipogarantia.getId())) {
					tipogarantiaLocal.setIsSelected(tipogarantia.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoGarantia(List<TipoGarantia> tipogarantiasAux) throws Exception {
		//this.tipogarantiasAux=tipogarantiasAux;
		
		for(TipoGarantia tipogarantiaAux:tipogarantiasAux) {
			if(tipogarantiaAux.getIsChanged()) {
				tipogarantiaAux.setIsChanged(false);
			}		
			
			if(tipogarantiaAux.getIsNew()) {
				tipogarantiaAux.setIsNew(false);
			}	
			
			if(tipogarantiaAux.getIsDeleted()) {
				tipogarantiaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoGarantia(TipoGarantia tipogarantiaAux) throws Exception {
		//this.tipogarantiaAux=tipogarantiaAux;
		
			if(tipogarantiaAux.getIsChanged()) {
				tipogarantiaAux.setIsChanged(false);
			}		
			
			if(tipogarantiaAux.getIsNew()) {
				tipogarantiaAux.setIsNew(false);
			}	
			
			if(tipogarantiaAux.getIsDeleted()) {
				tipogarantiaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoGarantia tipogarantiaAsignar,TipoGarantia tipogarantia) throws Exception {
		tipogarantiaAsignar.setId(tipogarantia.getId());	
		tipogarantiaAsignar.setVersionRow(tipogarantia.getVersionRow());	
		tipogarantiaAsignar.setid_pais(tipogarantia.getid_pais());
		tipogarantiaAsignar.setpais_descripcion(tipogarantia.getpais_descripcion());	
		tipogarantiaAsignar.setcodigo(tipogarantia.getcodigo());	
		tipogarantiaAsignar.setnombre(tipogarantia.getnombre());	
	}
	
	public static void inicializarTipoGarantia(TipoGarantia tipogarantia) throws Exception {
		try {
				tipogarantia.setId(0L);	
					
				tipogarantia.setid_pais(-1L);	
				tipogarantia.setcodigo("");	
				tipogarantia.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoGarantia(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoGarantiaConstantesFunciones.LABEL_IDPAIS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoGarantiaConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoGarantiaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoGarantia(String sTipo,Row row,Workbook workbook,TipoGarantia tipogarantia,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipogarantia.getpais_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipogarantia.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipogarantia.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoGarantia=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoGarantia() {
		return this.sFinalQueryTipoGarantia;
	}
	
	public void setsFinalQueryTipoGarantia(String sFinalQueryTipoGarantia) {
		this.sFinalQueryTipoGarantia= sFinalQueryTipoGarantia;
	}
	
	public Border resaltarSeleccionarTipoGarantia=null;
	
	public Border setResaltarSeleccionarTipoGarantia(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGarantiaBeanSwingJInternalFrame tipogarantiaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipogarantiaBeanSwingJInternalFrame.jTtoolBarTipoGarantia.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoGarantia= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoGarantia() {
		return this.resaltarSeleccionarTipoGarantia;
	}
	
	public void setResaltarSeleccionarTipoGarantia(Border borderResaltarSeleccionarTipoGarantia) {
		this.resaltarSeleccionarTipoGarantia= borderResaltarSeleccionarTipoGarantia;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoGarantia=null;
	public Boolean mostraridTipoGarantia=true;
	public Boolean activaridTipoGarantia=true;

	public Border resaltarid_paisTipoGarantia=null;
	public Boolean mostrarid_paisTipoGarantia=true;
	public Boolean activarid_paisTipoGarantia=true;
	public Boolean cargarid_paisTipoGarantia=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_paisTipoGarantia=false;//ConEventDepend=true

	public Border resaltarcodigoTipoGarantia=null;
	public Boolean mostrarcodigoTipoGarantia=true;
	public Boolean activarcodigoTipoGarantia=true;

	public Border resaltarnombreTipoGarantia=null;
	public Boolean mostrarnombreTipoGarantia=true;
	public Boolean activarnombreTipoGarantia=true;

	
	

	public Border setResaltaridTipoGarantia(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGarantiaBeanSwingJInternalFrame tipogarantiaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipogarantiaBeanSwingJInternalFrame.jTtoolBarTipoGarantia.setBorder(borderResaltar);
		
		this.resaltaridTipoGarantia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoGarantia() {
		return this.resaltaridTipoGarantia;
	}

	public void setResaltaridTipoGarantia(Border borderResaltar) {
		this.resaltaridTipoGarantia= borderResaltar;
	}

	public Boolean getMostraridTipoGarantia() {
		return this.mostraridTipoGarantia;
	}

	public void setMostraridTipoGarantia(Boolean mostraridTipoGarantia) {
		this.mostraridTipoGarantia= mostraridTipoGarantia;
	}

	public Boolean getActivaridTipoGarantia() {
		return this.activaridTipoGarantia;
	}

	public void setActivaridTipoGarantia(Boolean activaridTipoGarantia) {
		this.activaridTipoGarantia= activaridTipoGarantia;
	}

	public Border setResaltarid_paisTipoGarantia(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGarantiaBeanSwingJInternalFrame tipogarantiaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipogarantiaBeanSwingJInternalFrame.jTtoolBarTipoGarantia.setBorder(borderResaltar);
		
		this.resaltarid_paisTipoGarantia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_paisTipoGarantia() {
		return this.resaltarid_paisTipoGarantia;
	}

	public void setResaltarid_paisTipoGarantia(Border borderResaltar) {
		this.resaltarid_paisTipoGarantia= borderResaltar;
	}

	public Boolean getMostrarid_paisTipoGarantia() {
		return this.mostrarid_paisTipoGarantia;
	}

	public void setMostrarid_paisTipoGarantia(Boolean mostrarid_paisTipoGarantia) {
		this.mostrarid_paisTipoGarantia= mostrarid_paisTipoGarantia;
	}

	public Boolean getActivarid_paisTipoGarantia() {
		return this.activarid_paisTipoGarantia;
	}

	public void setActivarid_paisTipoGarantia(Boolean activarid_paisTipoGarantia) {
		this.activarid_paisTipoGarantia= activarid_paisTipoGarantia;
	}

	public Boolean getCargarid_paisTipoGarantia() {
		return this.cargarid_paisTipoGarantia;
	}

	public void setCargarid_paisTipoGarantia(Boolean cargarid_paisTipoGarantia) {
		this.cargarid_paisTipoGarantia= cargarid_paisTipoGarantia;
	}

	public Border setResaltarcodigoTipoGarantia(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGarantiaBeanSwingJInternalFrame tipogarantiaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipogarantiaBeanSwingJInternalFrame.jTtoolBarTipoGarantia.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoGarantia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoGarantia() {
		return this.resaltarcodigoTipoGarantia;
	}

	public void setResaltarcodigoTipoGarantia(Border borderResaltar) {
		this.resaltarcodigoTipoGarantia= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoGarantia() {
		return this.mostrarcodigoTipoGarantia;
	}

	public void setMostrarcodigoTipoGarantia(Boolean mostrarcodigoTipoGarantia) {
		this.mostrarcodigoTipoGarantia= mostrarcodigoTipoGarantia;
	}

	public Boolean getActivarcodigoTipoGarantia() {
		return this.activarcodigoTipoGarantia;
	}

	public void setActivarcodigoTipoGarantia(Boolean activarcodigoTipoGarantia) {
		this.activarcodigoTipoGarantia= activarcodigoTipoGarantia;
	}

	public Border setResaltarnombreTipoGarantia(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGarantiaBeanSwingJInternalFrame tipogarantiaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipogarantiaBeanSwingJInternalFrame.jTtoolBarTipoGarantia.setBorder(borderResaltar);
		
		this.resaltarnombreTipoGarantia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoGarantia() {
		return this.resaltarnombreTipoGarantia;
	}

	public void setResaltarnombreTipoGarantia(Border borderResaltar) {
		this.resaltarnombreTipoGarantia= borderResaltar;
	}

	public Boolean getMostrarnombreTipoGarantia() {
		return this.mostrarnombreTipoGarantia;
	}

	public void setMostrarnombreTipoGarantia(Boolean mostrarnombreTipoGarantia) {
		this.mostrarnombreTipoGarantia= mostrarnombreTipoGarantia;
	}

	public Boolean getActivarnombreTipoGarantia() {
		return this.activarnombreTipoGarantia;
	}

	public void setActivarnombreTipoGarantia(Boolean activarnombreTipoGarantia) {
		this.activarnombreTipoGarantia= activarnombreTipoGarantia;
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
		
		
		this.setMostraridTipoGarantia(esInicial);
		this.setMostrarid_paisTipoGarantia(esInicial);
		this.setMostrarcodigoTipoGarantia(esInicial);
		this.setMostrarnombreTipoGarantia(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoGarantiaConstantesFunciones.ID)) {
				this.setMostraridTipoGarantia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGarantiaConstantesFunciones.IDPAIS)) {
				this.setMostrarid_paisTipoGarantia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGarantiaConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoGarantia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGarantiaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoGarantia(esAsigna);
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
		
		
		this.setActivaridTipoGarantia(esInicial);
		this.setActivarid_paisTipoGarantia(esInicial);
		this.setActivarcodigoTipoGarantia(esInicial);
		this.setActivarnombreTipoGarantia(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoGarantiaConstantesFunciones.ID)) {
				this.setActivaridTipoGarantia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGarantiaConstantesFunciones.IDPAIS)) {
				this.setActivarid_paisTipoGarantia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGarantiaConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoGarantia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGarantiaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoGarantia(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoGarantiaBeanSwingJInternalFrame tipogarantiaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoGarantia(esInicial);
		this.setResaltarid_paisTipoGarantia(esInicial);
		this.setResaltarcodigoTipoGarantia(esInicial);
		this.setResaltarnombreTipoGarantia(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoGarantiaConstantesFunciones.ID)) {
				this.setResaltaridTipoGarantia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGarantiaConstantesFunciones.IDPAIS)) {
				this.setResaltarid_paisTipoGarantia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGarantiaConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoGarantia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGarantiaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoGarantia(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoGarantiaBeanSwingJInternalFrame tipogarantiaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPorCodigoTipoGarantia=true;

	public Boolean getMostrarBusquedaPorCodigoTipoGarantia() {
		return this.mostrarBusquedaPorCodigoTipoGarantia;
	}

	public void setMostrarBusquedaPorCodigoTipoGarantia(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoTipoGarantia= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreTipoGarantia=true;

	public Boolean getMostrarBusquedaPorNombreTipoGarantia() {
		return this.mostrarBusquedaPorNombreTipoGarantia;
	}

	public void setMostrarBusquedaPorNombreTipoGarantia(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreTipoGarantia= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPaisTipoGarantia=true;

	public Boolean getMostrarFK_IdPaisTipoGarantia() {
		return this.mostrarFK_IdPaisTipoGarantia;
	}

	public void setMostrarFK_IdPaisTipoGarantia(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPaisTipoGarantia= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorCodigoTipoGarantia=true;

	public Boolean getActivarBusquedaPorCodigoTipoGarantia() {
		return this.activarBusquedaPorCodigoTipoGarantia;
	}

	public void setActivarBusquedaPorCodigoTipoGarantia(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoTipoGarantia= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreTipoGarantia=true;

	public Boolean getActivarBusquedaPorNombreTipoGarantia() {
		return this.activarBusquedaPorNombreTipoGarantia;
	}

	public void setActivarBusquedaPorNombreTipoGarantia(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreTipoGarantia= habilitarResaltar;
	}

	public Boolean activarFK_IdPaisTipoGarantia=true;

	public Boolean getActivarFK_IdPaisTipoGarantia() {
		return this.activarFK_IdPaisTipoGarantia;
	}

	public void setActivarFK_IdPaisTipoGarantia(Boolean habilitarResaltar) {
		this.activarFK_IdPaisTipoGarantia= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorCodigoTipoGarantia=null;

	public Border getResaltarBusquedaPorCodigoTipoGarantia() {
		return this.resaltarBusquedaPorCodigoTipoGarantia;
	}

	public void setResaltarBusquedaPorCodigoTipoGarantia(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoTipoGarantia= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoTipoGarantia(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGarantiaBeanSwingJInternalFrame tipogarantiaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoTipoGarantia= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreTipoGarantia=null;

	public Border getResaltarBusquedaPorNombreTipoGarantia() {
		return this.resaltarBusquedaPorNombreTipoGarantia;
	}

	public void setResaltarBusquedaPorNombreTipoGarantia(Border borderResaltar) {
		this.resaltarBusquedaPorNombreTipoGarantia= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreTipoGarantia(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGarantiaBeanSwingJInternalFrame tipogarantiaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreTipoGarantia= borderResaltar;
	}

	public Border resaltarFK_IdPaisTipoGarantia=null;

	public Border getResaltarFK_IdPaisTipoGarantia() {
		return this.resaltarFK_IdPaisTipoGarantia;
	}

	public void setResaltarFK_IdPaisTipoGarantia(Border borderResaltar) {
		this.resaltarFK_IdPaisTipoGarantia= borderResaltar;
	}

	public void setResaltarFK_IdPaisTipoGarantia(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGarantiaBeanSwingJInternalFrame tipogarantiaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPaisTipoGarantia= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}