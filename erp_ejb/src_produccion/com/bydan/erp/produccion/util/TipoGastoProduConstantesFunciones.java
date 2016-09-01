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
package com.bydan.erp.produccion.util;

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


import com.bydan.erp.produccion.util.TipoGastoProduConstantesFunciones;
import com.bydan.erp.produccion.util.TipoGastoProduParameterReturnGeneral;
//import com.bydan.erp.produccion.util.TipoGastoProduParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.produccion.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.produccion.business.dataaccess.*;
//import com.bydan.erp.produccion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoGastoProduConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoGastoProdu";
	public static final String SPATHOPCION="Produccion";	
	public static final String SPATHMODULO="produccion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoGastoProdu"+TipoGastoProduConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoGastoProduHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoGastoProduHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoGastoProduConstantesFunciones.SCHEMA+"_"+TipoGastoProduConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoGastoProduHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoGastoProduConstantesFunciones.SCHEMA+"_"+TipoGastoProduConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoGastoProduConstantesFunciones.SCHEMA+"_"+TipoGastoProduConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoGastoProduHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoGastoProduConstantesFunciones.SCHEMA+"_"+TipoGastoProduConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoGastoProduConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoGastoProduHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoGastoProduConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoGastoProduConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoGastoProduHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoGastoProduConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoGastoProduConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoGastoProduConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoGastoProduConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoGastoProduConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Gasto Produccions";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Gasto Produccion";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Gasto Produ";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoGastoProdu";
	public static final String OBJECTNAME="tipogastoprodu";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PRODUCCION;	
	public static final String TABLENAME="tipo_gasto_produ";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipogastoprodu from "+TipoGastoProduConstantesFunciones.SPERSISTENCENAME+" tipogastoprodu";
	public static String QUERYSELECTNATIVE="select "+TipoGastoProduConstantesFunciones.SCHEMA+"."+TipoGastoProduConstantesFunciones.TABLENAME+".id,"+TipoGastoProduConstantesFunciones.SCHEMA+"."+TipoGastoProduConstantesFunciones.TABLENAME+".version_row,"+TipoGastoProduConstantesFunciones.SCHEMA+"."+TipoGastoProduConstantesFunciones.TABLENAME+".id_pais,"+TipoGastoProduConstantesFunciones.SCHEMA+"."+TipoGastoProduConstantesFunciones.TABLENAME+".nombre,"+TipoGastoProduConstantesFunciones.SCHEMA+"."+TipoGastoProduConstantesFunciones.TABLENAME+".descripcion from "+TipoGastoProduConstantesFunciones.SCHEMA+"."+TipoGastoProduConstantesFunciones.TABLENAME;//+" as "+TipoGastoProduConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDPAIS= "id_pais";
    public static final String NOMBRE= "nombre";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDPAIS= "Pais";
		public static final String LABEL_IDPAIS_LOWER= "Pais";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getTipoGastoProduLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoGastoProduConstantesFunciones.IDPAIS)) {sLabelColumna=TipoGastoProduConstantesFunciones.LABEL_IDPAIS;}
		if(sNombreColumna.equals(TipoGastoProduConstantesFunciones.NOMBRE)) {sLabelColumna=TipoGastoProduConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(TipoGastoProduConstantesFunciones.DESCRIPCION)) {sLabelColumna=TipoGastoProduConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getTipoGastoProduDescripcion(TipoGastoProdu tipogastoprodu) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipogastoprodu !=null/* && tipogastoprodu.getId()!=0*/) {
			sDescripcion=tipogastoprodu.getnombre();//tipogastoprodutipogastoprodu.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoGastoProduDescripcionDetallado(TipoGastoProdu tipogastoprodu) {
		String sDescripcion="";
			
		sDescripcion+=TipoGastoProduConstantesFunciones.ID+"=";
		sDescripcion+=tipogastoprodu.getId().toString()+",";
		sDescripcion+=TipoGastoProduConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipogastoprodu.getVersionRow().toString()+",";
		sDescripcion+=TipoGastoProduConstantesFunciones.IDPAIS+"=";
		sDescripcion+=tipogastoprodu.getid_pais().toString()+",";
		sDescripcion+=TipoGastoProduConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipogastoprodu.getnombre()+",";
		sDescripcion+=TipoGastoProduConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=tipogastoprodu.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoGastoProduDescripcion(TipoGastoProdu tipogastoprodu,String sValor) throws Exception {			
		if(tipogastoprodu !=null) {
			tipogastoprodu.setnombre(sValor);;//tipogastoprodutipogastoprodu.getnombre().trim();
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
		} else if(sNombreIndice.equals("FK_IdPais")) {
			sNombreIndice="Tipo=  Por Pais";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdPais(Long id_pais) {
		String sDetalleIndice=" Parametros->";
		if(id_pais!=null) {sDetalleIndice+=" Codigo Unico De Pais="+id_pais.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTipoGastoProdu(TipoGastoProdu tipogastoprodu,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipogastoprodu.setnombre(tipogastoprodu.getnombre().trim());
		tipogastoprodu.setdescripcion(tipogastoprodu.getdescripcion().trim());
	}
	
	public static void quitarEspaciosTipoGastoProdus(List<TipoGastoProdu> tipogastoprodus,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoGastoProdu tipogastoprodu: tipogastoprodus) {
			tipogastoprodu.setnombre(tipogastoprodu.getnombre().trim());
			tipogastoprodu.setdescripcion(tipogastoprodu.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoGastoProdu(TipoGastoProdu tipogastoprodu,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipogastoprodu.getConCambioAuxiliar()) {
			tipogastoprodu.setIsDeleted(tipogastoprodu.getIsDeletedAuxiliar());	
			tipogastoprodu.setIsNew(tipogastoprodu.getIsNewAuxiliar());	
			tipogastoprodu.setIsChanged(tipogastoprodu.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipogastoprodu.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipogastoprodu.setIsDeletedAuxiliar(false);	
			tipogastoprodu.setIsNewAuxiliar(false);	
			tipogastoprodu.setIsChangedAuxiliar(false);
			
			tipogastoprodu.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoGastoProdus(List<TipoGastoProdu> tipogastoprodus,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoGastoProdu tipogastoprodu : tipogastoprodus) {
			if(conAsignarBase && tipogastoprodu.getConCambioAuxiliar()) {
				tipogastoprodu.setIsDeleted(tipogastoprodu.getIsDeletedAuxiliar());	
				tipogastoprodu.setIsNew(tipogastoprodu.getIsNewAuxiliar());	
				tipogastoprodu.setIsChanged(tipogastoprodu.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipogastoprodu.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipogastoprodu.setIsDeletedAuxiliar(false);	
				tipogastoprodu.setIsNewAuxiliar(false);	
				tipogastoprodu.setIsChangedAuxiliar(false);
				
				tipogastoprodu.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoGastoProdu(TipoGastoProdu tipogastoprodu,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoGastoProdus(List<TipoGastoProdu> tipogastoprodus,Boolean conEnteros) throws Exception  {
		
		for(TipoGastoProdu tipogastoprodu: tipogastoprodus) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoGastoProdu(List<TipoGastoProdu> tipogastoprodus,TipoGastoProdu tipogastoproduAux) throws Exception  {
		TipoGastoProduConstantesFunciones.InicializarValoresTipoGastoProdu(tipogastoproduAux,true);
		
		for(TipoGastoProdu tipogastoprodu: tipogastoprodus) {
			if(tipogastoprodu.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoGastoProdu(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoGastoProduConstantesFunciones.getArrayColumnasGlobalesTipoGastoProdu(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoGastoProdu(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoGastoProdu(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoGastoProdu> tipogastoprodus,TipoGastoProdu tipogastoprodu,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoGastoProdu tipogastoproduAux: tipogastoprodus) {
			if(tipogastoproduAux!=null && tipogastoprodu!=null) {
				if((tipogastoproduAux.getId()==null && tipogastoprodu.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipogastoproduAux.getId()!=null && tipogastoprodu.getId()!=null){
					if(tipogastoproduAux.getId().equals(tipogastoprodu.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoGastoProdu(List<TipoGastoProdu> tipogastoprodus) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoGastoProdu tipogastoprodu: tipogastoprodus) {			
			if(tipogastoprodu.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoGastoProdu() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoGastoProduConstantesFunciones.LABEL_ID, TipoGastoProduConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoGastoProduConstantesFunciones.LABEL_VERSIONROW, TipoGastoProduConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoGastoProduConstantesFunciones.LABEL_IDPAIS, TipoGastoProduConstantesFunciones.IDPAIS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoGastoProduConstantesFunciones.LABEL_NOMBRE, TipoGastoProduConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoGastoProduConstantesFunciones.LABEL_DESCRIPCION, TipoGastoProduConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoGastoProdu() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoGastoProduConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoGastoProduConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoGastoProduConstantesFunciones.IDPAIS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoGastoProduConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoGastoProduConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoGastoProdu() throws Exception  {
		return TipoGastoProduConstantesFunciones.getTiposSeleccionarTipoGastoProdu(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoGastoProdu(Boolean conFk) throws Exception  {
		return TipoGastoProduConstantesFunciones.getTiposSeleccionarTipoGastoProdu(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoGastoProdu(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoGastoProduConstantesFunciones.LABEL_IDPAIS);
			reporte.setsDescripcion(TipoGastoProduConstantesFunciones.LABEL_IDPAIS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoGastoProduConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoGastoProduConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoGastoProduConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(TipoGastoProduConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoGastoProdu(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoGastoProdu(TipoGastoProdu tipogastoproduAux) throws Exception {
		
			tipogastoproduAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(tipogastoproduAux.getPais()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoGastoProdu(List<TipoGastoProdu> tipogastoprodusTemp) throws Exception {
		for(TipoGastoProdu tipogastoproduAux:tipogastoprodusTemp) {
			
			tipogastoproduAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(tipogastoproduAux.getPais()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoGastoProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoGastoProdu(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoGastoProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoGastoProduConstantesFunciones.getClassesRelationshipsOfTipoGastoProdu(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoGastoProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoGastoProdu(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoGastoProduConstantesFunciones.getClassesRelationshipsFromStringsOfTipoGastoProdu(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoGastoProdu(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TipoGastoProdu tipogastoprodu,List<TipoGastoProdu> tipogastoprodus,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoGastoProdu tipogastoproduEncontrado=null;
			
			for(TipoGastoProdu tipogastoproduLocal:tipogastoprodus) {
				if(tipogastoproduLocal.getId().equals(tipogastoprodu.getId())) {
					tipogastoproduEncontrado=tipogastoproduLocal;
					
					tipogastoproduLocal.setIsChanged(tipogastoprodu.getIsChanged());
					tipogastoproduLocal.setIsNew(tipogastoprodu.getIsNew());
					tipogastoproduLocal.setIsDeleted(tipogastoprodu.getIsDeleted());
					
					tipogastoproduLocal.setGeneralEntityOriginal(tipogastoprodu.getGeneralEntityOriginal());
					
					tipogastoproduLocal.setId(tipogastoprodu.getId());	
					tipogastoproduLocal.setVersionRow(tipogastoprodu.getVersionRow());	
					tipogastoproduLocal.setid_pais(tipogastoprodu.getid_pais());	
					tipogastoproduLocal.setnombre(tipogastoprodu.getnombre());	
					tipogastoproduLocal.setdescripcion(tipogastoprodu.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipogastoprodu.getIsDeleted()) {
				if(!existe) {
					tipogastoprodus.add(tipogastoprodu);
				}
			} else {
				if(tipogastoproduEncontrado!=null && permiteQuitar)  {
					tipogastoprodus.remove(tipogastoproduEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoGastoProdu tipogastoprodu,List<TipoGastoProdu> tipogastoprodus) throws Exception {
		try	{			
			for(TipoGastoProdu tipogastoproduLocal:tipogastoprodus) {
				if(tipogastoproduLocal.getId().equals(tipogastoprodu.getId())) {
					tipogastoproduLocal.setIsSelected(tipogastoprodu.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoGastoProdu(List<TipoGastoProdu> tipogastoprodusAux) throws Exception {
		//this.tipogastoprodusAux=tipogastoprodusAux;
		
		for(TipoGastoProdu tipogastoproduAux:tipogastoprodusAux) {
			if(tipogastoproduAux.getIsChanged()) {
				tipogastoproduAux.setIsChanged(false);
			}		
			
			if(tipogastoproduAux.getIsNew()) {
				tipogastoproduAux.setIsNew(false);
			}	
			
			if(tipogastoproduAux.getIsDeleted()) {
				tipogastoproduAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoGastoProdu(TipoGastoProdu tipogastoproduAux) throws Exception {
		//this.tipogastoproduAux=tipogastoproduAux;
		
			if(tipogastoproduAux.getIsChanged()) {
				tipogastoproduAux.setIsChanged(false);
			}		
			
			if(tipogastoproduAux.getIsNew()) {
				tipogastoproduAux.setIsNew(false);
			}	
			
			if(tipogastoproduAux.getIsDeleted()) {
				tipogastoproduAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoGastoProdu tipogastoproduAsignar,TipoGastoProdu tipogastoprodu) throws Exception {
		tipogastoproduAsignar.setId(tipogastoprodu.getId());	
		tipogastoproduAsignar.setVersionRow(tipogastoprodu.getVersionRow());	
		tipogastoproduAsignar.setid_pais(tipogastoprodu.getid_pais());
		tipogastoproduAsignar.setpais_descripcion(tipogastoprodu.getpais_descripcion());	
		tipogastoproduAsignar.setnombre(tipogastoprodu.getnombre());	
		tipogastoproduAsignar.setdescripcion(tipogastoprodu.getdescripcion());	
	}
	
	public static void inicializarTipoGastoProdu(TipoGastoProdu tipogastoprodu) throws Exception {
		try {
				tipogastoprodu.setId(0L);	
					
				tipogastoprodu.setid_pais(-1L);	
				tipogastoprodu.setnombre("");	
				tipogastoprodu.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoGastoProdu(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoGastoProduConstantesFunciones.LABEL_IDPAIS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoGastoProduConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoGastoProduConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoGastoProdu(String sTipo,Row row,Workbook workbook,TipoGastoProdu tipogastoprodu,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipogastoprodu.getpais_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipogastoprodu.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipogastoprodu.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoGastoProdu=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoGastoProdu() {
		return this.sFinalQueryTipoGastoProdu;
	}
	
	public void setsFinalQueryTipoGastoProdu(String sFinalQueryTipoGastoProdu) {
		this.sFinalQueryTipoGastoProdu= sFinalQueryTipoGastoProdu;
	}
	
	public Border resaltarSeleccionarTipoGastoProdu=null;
	
	public Border setResaltarSeleccionarTipoGastoProdu(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGastoProduBeanSwingJInternalFrame tipogastoproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipogastoproduBeanSwingJInternalFrame.jTtoolBarTipoGastoProdu.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoGastoProdu= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoGastoProdu() {
		return this.resaltarSeleccionarTipoGastoProdu;
	}
	
	public void setResaltarSeleccionarTipoGastoProdu(Border borderResaltarSeleccionarTipoGastoProdu) {
		this.resaltarSeleccionarTipoGastoProdu= borderResaltarSeleccionarTipoGastoProdu;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoGastoProdu=null;
	public Boolean mostraridTipoGastoProdu=true;
	public Boolean activaridTipoGastoProdu=true;

	public Border resaltarid_paisTipoGastoProdu=null;
	public Boolean mostrarid_paisTipoGastoProdu=true;
	public Boolean activarid_paisTipoGastoProdu=true;
	public Boolean cargarid_paisTipoGastoProdu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_paisTipoGastoProdu=false;//ConEventDepend=true

	public Border resaltarnombreTipoGastoProdu=null;
	public Boolean mostrarnombreTipoGastoProdu=true;
	public Boolean activarnombreTipoGastoProdu=true;

	public Border resaltardescripcionTipoGastoProdu=null;
	public Boolean mostrardescripcionTipoGastoProdu=true;
	public Boolean activardescripcionTipoGastoProdu=true;

	
	

	public Border setResaltaridTipoGastoProdu(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGastoProduBeanSwingJInternalFrame tipogastoproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipogastoproduBeanSwingJInternalFrame.jTtoolBarTipoGastoProdu.setBorder(borderResaltar);
		
		this.resaltaridTipoGastoProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoGastoProdu() {
		return this.resaltaridTipoGastoProdu;
	}

	public void setResaltaridTipoGastoProdu(Border borderResaltar) {
		this.resaltaridTipoGastoProdu= borderResaltar;
	}

	public Boolean getMostraridTipoGastoProdu() {
		return this.mostraridTipoGastoProdu;
	}

	public void setMostraridTipoGastoProdu(Boolean mostraridTipoGastoProdu) {
		this.mostraridTipoGastoProdu= mostraridTipoGastoProdu;
	}

	public Boolean getActivaridTipoGastoProdu() {
		return this.activaridTipoGastoProdu;
	}

	public void setActivaridTipoGastoProdu(Boolean activaridTipoGastoProdu) {
		this.activaridTipoGastoProdu= activaridTipoGastoProdu;
	}

	public Border setResaltarid_paisTipoGastoProdu(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGastoProduBeanSwingJInternalFrame tipogastoproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipogastoproduBeanSwingJInternalFrame.jTtoolBarTipoGastoProdu.setBorder(borderResaltar);
		
		this.resaltarid_paisTipoGastoProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_paisTipoGastoProdu() {
		return this.resaltarid_paisTipoGastoProdu;
	}

	public void setResaltarid_paisTipoGastoProdu(Border borderResaltar) {
		this.resaltarid_paisTipoGastoProdu= borderResaltar;
	}

	public Boolean getMostrarid_paisTipoGastoProdu() {
		return this.mostrarid_paisTipoGastoProdu;
	}

	public void setMostrarid_paisTipoGastoProdu(Boolean mostrarid_paisTipoGastoProdu) {
		this.mostrarid_paisTipoGastoProdu= mostrarid_paisTipoGastoProdu;
	}

	public Boolean getActivarid_paisTipoGastoProdu() {
		return this.activarid_paisTipoGastoProdu;
	}

	public void setActivarid_paisTipoGastoProdu(Boolean activarid_paisTipoGastoProdu) {
		this.activarid_paisTipoGastoProdu= activarid_paisTipoGastoProdu;
	}

	public Boolean getCargarid_paisTipoGastoProdu() {
		return this.cargarid_paisTipoGastoProdu;
	}

	public void setCargarid_paisTipoGastoProdu(Boolean cargarid_paisTipoGastoProdu) {
		this.cargarid_paisTipoGastoProdu= cargarid_paisTipoGastoProdu;
	}

	public Border setResaltarnombreTipoGastoProdu(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGastoProduBeanSwingJInternalFrame tipogastoproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipogastoproduBeanSwingJInternalFrame.jTtoolBarTipoGastoProdu.setBorder(borderResaltar);
		
		this.resaltarnombreTipoGastoProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoGastoProdu() {
		return this.resaltarnombreTipoGastoProdu;
	}

	public void setResaltarnombreTipoGastoProdu(Border borderResaltar) {
		this.resaltarnombreTipoGastoProdu= borderResaltar;
	}

	public Boolean getMostrarnombreTipoGastoProdu() {
		return this.mostrarnombreTipoGastoProdu;
	}

	public void setMostrarnombreTipoGastoProdu(Boolean mostrarnombreTipoGastoProdu) {
		this.mostrarnombreTipoGastoProdu= mostrarnombreTipoGastoProdu;
	}

	public Boolean getActivarnombreTipoGastoProdu() {
		return this.activarnombreTipoGastoProdu;
	}

	public void setActivarnombreTipoGastoProdu(Boolean activarnombreTipoGastoProdu) {
		this.activarnombreTipoGastoProdu= activarnombreTipoGastoProdu;
	}

	public Border setResaltardescripcionTipoGastoProdu(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGastoProduBeanSwingJInternalFrame tipogastoproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipogastoproduBeanSwingJInternalFrame.jTtoolBarTipoGastoProdu.setBorder(borderResaltar);
		
		this.resaltardescripcionTipoGastoProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionTipoGastoProdu() {
		return this.resaltardescripcionTipoGastoProdu;
	}

	public void setResaltardescripcionTipoGastoProdu(Border borderResaltar) {
		this.resaltardescripcionTipoGastoProdu= borderResaltar;
	}

	public Boolean getMostrardescripcionTipoGastoProdu() {
		return this.mostrardescripcionTipoGastoProdu;
	}

	public void setMostrardescripcionTipoGastoProdu(Boolean mostrardescripcionTipoGastoProdu) {
		this.mostrardescripcionTipoGastoProdu= mostrardescripcionTipoGastoProdu;
	}

	public Boolean getActivardescripcionTipoGastoProdu() {
		return this.activardescripcionTipoGastoProdu;
	}

	public void setActivardescripcionTipoGastoProdu(Boolean activardescripcionTipoGastoProdu) {
		this.activardescripcionTipoGastoProdu= activardescripcionTipoGastoProdu;
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
		
		
		this.setMostraridTipoGastoProdu(esInicial);
		this.setMostrarid_paisTipoGastoProdu(esInicial);
		this.setMostrarnombreTipoGastoProdu(esInicial);
		this.setMostrardescripcionTipoGastoProdu(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoGastoProduConstantesFunciones.ID)) {
				this.setMostraridTipoGastoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGastoProduConstantesFunciones.IDPAIS)) {
				this.setMostrarid_paisTipoGastoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGastoProduConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoGastoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGastoProduConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionTipoGastoProdu(esAsigna);
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
		
		
		this.setActivaridTipoGastoProdu(esInicial);
		this.setActivarid_paisTipoGastoProdu(esInicial);
		this.setActivarnombreTipoGastoProdu(esInicial);
		this.setActivardescripcionTipoGastoProdu(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoGastoProduConstantesFunciones.ID)) {
				this.setActivaridTipoGastoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGastoProduConstantesFunciones.IDPAIS)) {
				this.setActivarid_paisTipoGastoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGastoProduConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoGastoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGastoProduConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionTipoGastoProdu(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoGastoProduBeanSwingJInternalFrame tipogastoproduBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoGastoProdu(esInicial);
		this.setResaltarid_paisTipoGastoProdu(esInicial);
		this.setResaltarnombreTipoGastoProdu(esInicial);
		this.setResaltardescripcionTipoGastoProdu(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoGastoProduConstantesFunciones.ID)) {
				this.setResaltaridTipoGastoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGastoProduConstantesFunciones.IDPAIS)) {
				this.setResaltarid_paisTipoGastoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGastoProduConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoGastoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGastoProduConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionTipoGastoProdu(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoGastoProduBeanSwingJInternalFrame tipogastoproduBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdPaisTipoGastoProdu=true;

	public Boolean getMostrarFK_IdPaisTipoGastoProdu() {
		return this.mostrarFK_IdPaisTipoGastoProdu;
	}

	public void setMostrarFK_IdPaisTipoGastoProdu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPaisTipoGastoProdu= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdPaisTipoGastoProdu=true;

	public Boolean getActivarFK_IdPaisTipoGastoProdu() {
		return this.activarFK_IdPaisTipoGastoProdu;
	}

	public void setActivarFK_IdPaisTipoGastoProdu(Boolean habilitarResaltar) {
		this.activarFK_IdPaisTipoGastoProdu= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdPaisTipoGastoProdu=null;

	public Border getResaltarFK_IdPaisTipoGastoProdu() {
		return this.resaltarFK_IdPaisTipoGastoProdu;
	}

	public void setResaltarFK_IdPaisTipoGastoProdu(Border borderResaltar) {
		this.resaltarFK_IdPaisTipoGastoProdu= borderResaltar;
	}

	public void setResaltarFK_IdPaisTipoGastoProdu(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGastoProduBeanSwingJInternalFrame tipogastoproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPaisTipoGastoProdu= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}