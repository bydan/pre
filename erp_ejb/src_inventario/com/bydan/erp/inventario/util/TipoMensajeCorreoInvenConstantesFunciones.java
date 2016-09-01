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
package com.bydan.erp.inventario.util;

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


import com.bydan.erp.inventario.util.TipoMensajeCorreoInvenConstantesFunciones;
import com.bydan.erp.inventario.util.TipoMensajeCorreoInvenParameterReturnGeneral;
//import com.bydan.erp.inventario.util.TipoMensajeCorreoInvenParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoMensajeCorreoInvenConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoMensajeCorreoInven";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoMensajeCorreoInven"+TipoMensajeCorreoInvenConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoMensajeCorreoInvenHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoMensajeCorreoInvenHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoMensajeCorreoInvenConstantesFunciones.SCHEMA+"_"+TipoMensajeCorreoInvenConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoMensajeCorreoInvenHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoMensajeCorreoInvenConstantesFunciones.SCHEMA+"_"+TipoMensajeCorreoInvenConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoMensajeCorreoInvenConstantesFunciones.SCHEMA+"_"+TipoMensajeCorreoInvenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoMensajeCorreoInvenHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoMensajeCorreoInvenConstantesFunciones.SCHEMA+"_"+TipoMensajeCorreoInvenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoMensajeCorreoInvenConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoMensajeCorreoInvenHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoMensajeCorreoInvenConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoMensajeCorreoInvenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoMensajeCorreoInvenHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoMensajeCorreoInvenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoMensajeCorreoInvenConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoMensajeCorreoInvenConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoMensajeCorreoInvenConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoMensajeCorreoInvenConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Mensaje Correos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Mensaje Correo";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Mensaje Correo Inven";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoMensajeCorreoInven";
	public static final String OBJECTNAME="tipomensajecorreoinven";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="tipo_mensaje_correo_inven";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipomensajecorreoinven from "+TipoMensajeCorreoInvenConstantesFunciones.SPERSISTENCENAME+" tipomensajecorreoinven";
	public static String QUERYSELECTNATIVE="select "+TipoMensajeCorreoInvenConstantesFunciones.SCHEMA+"."+TipoMensajeCorreoInvenConstantesFunciones.TABLENAME+".id,"+TipoMensajeCorreoInvenConstantesFunciones.SCHEMA+"."+TipoMensajeCorreoInvenConstantesFunciones.TABLENAME+".version_row,"+TipoMensajeCorreoInvenConstantesFunciones.SCHEMA+"."+TipoMensajeCorreoInvenConstantesFunciones.TABLENAME+".id_modulo,"+TipoMensajeCorreoInvenConstantesFunciones.SCHEMA+"."+TipoMensajeCorreoInvenConstantesFunciones.TABLENAME+".codigo,"+TipoMensajeCorreoInvenConstantesFunciones.SCHEMA+"."+TipoMensajeCorreoInvenConstantesFunciones.TABLENAME+".nombre from "+TipoMensajeCorreoInvenConstantesFunciones.SCHEMA+"."+TipoMensajeCorreoInvenConstantesFunciones.TABLENAME;//+" as "+TipoMensajeCorreoInvenConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDMODULO= "id_modulo";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDMODULO= "Modulo";
		public static final String LABEL_IDMODULO_LOWER= "Modulo";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getTipoMensajeCorreoInvenLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoMensajeCorreoInvenConstantesFunciones.IDMODULO)) {sLabelColumna=TipoMensajeCorreoInvenConstantesFunciones.LABEL_IDMODULO;}
		if(sNombreColumna.equals(TipoMensajeCorreoInvenConstantesFunciones.CODIGO)) {sLabelColumna=TipoMensajeCorreoInvenConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoMensajeCorreoInvenConstantesFunciones.NOMBRE)) {sLabelColumna=TipoMensajeCorreoInvenConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getTipoMensajeCorreoInvenDescripcion(TipoMensajeCorreoInven tipomensajecorreoinven) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipomensajecorreoinven !=null/* && tipomensajecorreoinven.getId()!=0*/) {
			sDescripcion=tipomensajecorreoinven.getcodigo();//tipomensajecorreoinventipomensajecorreoinven.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoMensajeCorreoInvenDescripcionDetallado(TipoMensajeCorreoInven tipomensajecorreoinven) {
		String sDescripcion="";
			
		sDescripcion+=TipoMensajeCorreoInvenConstantesFunciones.ID+"=";
		sDescripcion+=tipomensajecorreoinven.getId().toString()+",";
		sDescripcion+=TipoMensajeCorreoInvenConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipomensajecorreoinven.getVersionRow().toString()+",";
		sDescripcion+=TipoMensajeCorreoInvenConstantesFunciones.IDMODULO+"=";
		sDescripcion+=tipomensajecorreoinven.getid_modulo().toString()+",";
		sDescripcion+=TipoMensajeCorreoInvenConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipomensajecorreoinven.getcodigo()+",";
		sDescripcion+=TipoMensajeCorreoInvenConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipomensajecorreoinven.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoMensajeCorreoInvenDescripcion(TipoMensajeCorreoInven tipomensajecorreoinven,String sValor) throws Exception {			
		if(tipomensajecorreoinven !=null) {
			tipomensajecorreoinven.setcodigo(sValor);;//tipomensajecorreoinventipomensajecorreoinven.getcodigo().trim();
		}		
	}
	
		

	public static String getModuloDescripcion(Modulo modulo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(modulo!=null/*&&modulo.getId()>0*/) {
			sDescripcion=ModuloConstantesFunciones.getModuloDescripcion(modulo);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdModulo")) {
			sNombreIndice="Tipo=  Por Modulo";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdModulo(Long id_modulo) {
		String sDetalleIndice=" Parametros->";
		if(id_modulo!=null) {sDetalleIndice+=" Codigo Unico De Modulo="+id_modulo.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTipoMensajeCorreoInven(TipoMensajeCorreoInven tipomensajecorreoinven,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipomensajecorreoinven.setcodigo(tipomensajecorreoinven.getcodigo().trim());
		tipomensajecorreoinven.setnombre(tipomensajecorreoinven.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoMensajeCorreoInvens(List<TipoMensajeCorreoInven> tipomensajecorreoinvens,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoMensajeCorreoInven tipomensajecorreoinven: tipomensajecorreoinvens) {
			tipomensajecorreoinven.setcodigo(tipomensajecorreoinven.getcodigo().trim());
			tipomensajecorreoinven.setnombre(tipomensajecorreoinven.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoMensajeCorreoInven(TipoMensajeCorreoInven tipomensajecorreoinven,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipomensajecorreoinven.getConCambioAuxiliar()) {
			tipomensajecorreoinven.setIsDeleted(tipomensajecorreoinven.getIsDeletedAuxiliar());	
			tipomensajecorreoinven.setIsNew(tipomensajecorreoinven.getIsNewAuxiliar());	
			tipomensajecorreoinven.setIsChanged(tipomensajecorreoinven.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipomensajecorreoinven.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipomensajecorreoinven.setIsDeletedAuxiliar(false);	
			tipomensajecorreoinven.setIsNewAuxiliar(false);	
			tipomensajecorreoinven.setIsChangedAuxiliar(false);
			
			tipomensajecorreoinven.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoMensajeCorreoInvens(List<TipoMensajeCorreoInven> tipomensajecorreoinvens,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoMensajeCorreoInven tipomensajecorreoinven : tipomensajecorreoinvens) {
			if(conAsignarBase && tipomensajecorreoinven.getConCambioAuxiliar()) {
				tipomensajecorreoinven.setIsDeleted(tipomensajecorreoinven.getIsDeletedAuxiliar());	
				tipomensajecorreoinven.setIsNew(tipomensajecorreoinven.getIsNewAuxiliar());	
				tipomensajecorreoinven.setIsChanged(tipomensajecorreoinven.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipomensajecorreoinven.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipomensajecorreoinven.setIsDeletedAuxiliar(false);	
				tipomensajecorreoinven.setIsNewAuxiliar(false);	
				tipomensajecorreoinven.setIsChangedAuxiliar(false);
				
				tipomensajecorreoinven.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoMensajeCorreoInven(TipoMensajeCorreoInven tipomensajecorreoinven,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoMensajeCorreoInvens(List<TipoMensajeCorreoInven> tipomensajecorreoinvens,Boolean conEnteros) throws Exception  {
		
		for(TipoMensajeCorreoInven tipomensajecorreoinven: tipomensajecorreoinvens) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoMensajeCorreoInven(List<TipoMensajeCorreoInven> tipomensajecorreoinvens,TipoMensajeCorreoInven tipomensajecorreoinvenAux) throws Exception  {
		TipoMensajeCorreoInvenConstantesFunciones.InicializarValoresTipoMensajeCorreoInven(tipomensajecorreoinvenAux,true);
		
		for(TipoMensajeCorreoInven tipomensajecorreoinven: tipomensajecorreoinvens) {
			if(tipomensajecorreoinven.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoMensajeCorreoInven(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoMensajeCorreoInvenConstantesFunciones.getArrayColumnasGlobalesTipoMensajeCorreoInven(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoMensajeCorreoInven(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoMensajeCorreoInvenConstantesFunciones.IDMODULO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoMensajeCorreoInvenConstantesFunciones.IDMODULO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoMensajeCorreoInven(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoMensajeCorreoInven> tipomensajecorreoinvens,TipoMensajeCorreoInven tipomensajecorreoinven,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoMensajeCorreoInven tipomensajecorreoinvenAux: tipomensajecorreoinvens) {
			if(tipomensajecorreoinvenAux!=null && tipomensajecorreoinven!=null) {
				if((tipomensajecorreoinvenAux.getId()==null && tipomensajecorreoinven.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipomensajecorreoinvenAux.getId()!=null && tipomensajecorreoinven.getId()!=null){
					if(tipomensajecorreoinvenAux.getId().equals(tipomensajecorreoinven.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoMensajeCorreoInven(List<TipoMensajeCorreoInven> tipomensajecorreoinvens) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoMensajeCorreoInven tipomensajecorreoinven: tipomensajecorreoinvens) {			
			if(tipomensajecorreoinven.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoMensajeCorreoInven() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoMensajeCorreoInvenConstantesFunciones.LABEL_ID, TipoMensajeCorreoInvenConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoMensajeCorreoInvenConstantesFunciones.LABEL_VERSIONROW, TipoMensajeCorreoInvenConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoMensajeCorreoInvenConstantesFunciones.LABEL_IDMODULO, TipoMensajeCorreoInvenConstantesFunciones.IDMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoMensajeCorreoInvenConstantesFunciones.LABEL_CODIGO, TipoMensajeCorreoInvenConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoMensajeCorreoInvenConstantesFunciones.LABEL_NOMBRE, TipoMensajeCorreoInvenConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoMensajeCorreoInven() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoMensajeCorreoInvenConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoMensajeCorreoInvenConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoMensajeCorreoInvenConstantesFunciones.IDMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoMensajeCorreoInvenConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoMensajeCorreoInvenConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoMensajeCorreoInven() throws Exception  {
		return TipoMensajeCorreoInvenConstantesFunciones.getTiposSeleccionarTipoMensajeCorreoInven(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoMensajeCorreoInven(Boolean conFk) throws Exception  {
		return TipoMensajeCorreoInvenConstantesFunciones.getTiposSeleccionarTipoMensajeCorreoInven(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoMensajeCorreoInven(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoMensajeCorreoInvenConstantesFunciones.LABEL_IDMODULO);
			reporte.setsDescripcion(TipoMensajeCorreoInvenConstantesFunciones.LABEL_IDMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoMensajeCorreoInvenConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoMensajeCorreoInvenConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoMensajeCorreoInvenConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoMensajeCorreoInvenConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoMensajeCorreoInven(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoMensajeCorreoInven(TipoMensajeCorreoInven tipomensajecorreoinvenAux) throws Exception {
		
			tipomensajecorreoinvenAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(tipomensajecorreoinvenAux.getModulo()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoMensajeCorreoInven(List<TipoMensajeCorreoInven> tipomensajecorreoinvensTemp) throws Exception {
		for(TipoMensajeCorreoInven tipomensajecorreoinvenAux:tipomensajecorreoinvensTemp) {
			
			tipomensajecorreoinvenAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(tipomensajecorreoinvenAux.getModulo()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoMensajeCorreoInven(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Modulo.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Modulo.class)) {
						classes.add(new Classe(Modulo.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoMensajeCorreoInven(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoMensajeCorreoInven(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoMensajeCorreoInvenConstantesFunciones.getClassesRelationshipsOfTipoMensajeCorreoInven(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoMensajeCorreoInven(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoMensajeCorreoInven(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoMensajeCorreoInvenConstantesFunciones.getClassesRelationshipsFromStringsOfTipoMensajeCorreoInven(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoMensajeCorreoInven(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TipoMensajeCorreoInven tipomensajecorreoinven,List<TipoMensajeCorreoInven> tipomensajecorreoinvens,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoMensajeCorreoInven tipomensajecorreoinvenEncontrado=null;
			
			for(TipoMensajeCorreoInven tipomensajecorreoinvenLocal:tipomensajecorreoinvens) {
				if(tipomensajecorreoinvenLocal.getId().equals(tipomensajecorreoinven.getId())) {
					tipomensajecorreoinvenEncontrado=tipomensajecorreoinvenLocal;
					
					tipomensajecorreoinvenLocal.setIsChanged(tipomensajecorreoinven.getIsChanged());
					tipomensajecorreoinvenLocal.setIsNew(tipomensajecorreoinven.getIsNew());
					tipomensajecorreoinvenLocal.setIsDeleted(tipomensajecorreoinven.getIsDeleted());
					
					tipomensajecorreoinvenLocal.setGeneralEntityOriginal(tipomensajecorreoinven.getGeneralEntityOriginal());
					
					tipomensajecorreoinvenLocal.setId(tipomensajecorreoinven.getId());	
					tipomensajecorreoinvenLocal.setVersionRow(tipomensajecorreoinven.getVersionRow());	
					tipomensajecorreoinvenLocal.setid_modulo(tipomensajecorreoinven.getid_modulo());	
					tipomensajecorreoinvenLocal.setcodigo(tipomensajecorreoinven.getcodigo());	
					tipomensajecorreoinvenLocal.setnombre(tipomensajecorreoinven.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipomensajecorreoinven.getIsDeleted()) {
				if(!existe) {
					tipomensajecorreoinvens.add(tipomensajecorreoinven);
				}
			} else {
				if(tipomensajecorreoinvenEncontrado!=null && permiteQuitar)  {
					tipomensajecorreoinvens.remove(tipomensajecorreoinvenEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoMensajeCorreoInven tipomensajecorreoinven,List<TipoMensajeCorreoInven> tipomensajecorreoinvens) throws Exception {
		try	{			
			for(TipoMensajeCorreoInven tipomensajecorreoinvenLocal:tipomensajecorreoinvens) {
				if(tipomensajecorreoinvenLocal.getId().equals(tipomensajecorreoinven.getId())) {
					tipomensajecorreoinvenLocal.setIsSelected(tipomensajecorreoinven.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoMensajeCorreoInven(List<TipoMensajeCorreoInven> tipomensajecorreoinvensAux) throws Exception {
		//this.tipomensajecorreoinvensAux=tipomensajecorreoinvensAux;
		
		for(TipoMensajeCorreoInven tipomensajecorreoinvenAux:tipomensajecorreoinvensAux) {
			if(tipomensajecorreoinvenAux.getIsChanged()) {
				tipomensajecorreoinvenAux.setIsChanged(false);
			}		
			
			if(tipomensajecorreoinvenAux.getIsNew()) {
				tipomensajecorreoinvenAux.setIsNew(false);
			}	
			
			if(tipomensajecorreoinvenAux.getIsDeleted()) {
				tipomensajecorreoinvenAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoMensajeCorreoInven(TipoMensajeCorreoInven tipomensajecorreoinvenAux) throws Exception {
		//this.tipomensajecorreoinvenAux=tipomensajecorreoinvenAux;
		
			if(tipomensajecorreoinvenAux.getIsChanged()) {
				tipomensajecorreoinvenAux.setIsChanged(false);
			}		
			
			if(tipomensajecorreoinvenAux.getIsNew()) {
				tipomensajecorreoinvenAux.setIsNew(false);
			}	
			
			if(tipomensajecorreoinvenAux.getIsDeleted()) {
				tipomensajecorreoinvenAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoMensajeCorreoInven tipomensajecorreoinvenAsignar,TipoMensajeCorreoInven tipomensajecorreoinven) throws Exception {
		tipomensajecorreoinvenAsignar.setId(tipomensajecorreoinven.getId());	
		tipomensajecorreoinvenAsignar.setVersionRow(tipomensajecorreoinven.getVersionRow());	
		tipomensajecorreoinvenAsignar.setid_modulo(tipomensajecorreoinven.getid_modulo());
		tipomensajecorreoinvenAsignar.setmodulo_descripcion(tipomensajecorreoinven.getmodulo_descripcion());	
		tipomensajecorreoinvenAsignar.setcodigo(tipomensajecorreoinven.getcodigo());	
		tipomensajecorreoinvenAsignar.setnombre(tipomensajecorreoinven.getnombre());	
	}
	
	public static void inicializarTipoMensajeCorreoInven(TipoMensajeCorreoInven tipomensajecorreoinven) throws Exception {
		try {
				tipomensajecorreoinven.setId(0L);	
					
				tipomensajecorreoinven.setid_modulo(-1L);	
				tipomensajecorreoinven.setcodigo("");	
				tipomensajecorreoinven.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoMensajeCorreoInven(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoMensajeCorreoInvenConstantesFunciones.LABEL_IDMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoMensajeCorreoInvenConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoMensajeCorreoInvenConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoMensajeCorreoInven(String sTipo,Row row,Workbook workbook,TipoMensajeCorreoInven tipomensajecorreoinven,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipomensajecorreoinven.getmodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipomensajecorreoinven.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipomensajecorreoinven.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoMensajeCorreoInven=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoMensajeCorreoInven() {
		return this.sFinalQueryTipoMensajeCorreoInven;
	}
	
	public void setsFinalQueryTipoMensajeCorreoInven(String sFinalQueryTipoMensajeCorreoInven) {
		this.sFinalQueryTipoMensajeCorreoInven= sFinalQueryTipoMensajeCorreoInven;
	}
	
	public Border resaltarSeleccionarTipoMensajeCorreoInven=null;
	
	public Border setResaltarSeleccionarTipoMensajeCorreoInven(ParametroGeneralUsuario parametroGeneralUsuario/*TipoMensajeCorreoInvenBeanSwingJInternalFrame tipomensajecorreoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipomensajecorreoinvenBeanSwingJInternalFrame.jTtoolBarTipoMensajeCorreoInven.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoMensajeCorreoInven= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoMensajeCorreoInven() {
		return this.resaltarSeleccionarTipoMensajeCorreoInven;
	}
	
	public void setResaltarSeleccionarTipoMensajeCorreoInven(Border borderResaltarSeleccionarTipoMensajeCorreoInven) {
		this.resaltarSeleccionarTipoMensajeCorreoInven= borderResaltarSeleccionarTipoMensajeCorreoInven;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoMensajeCorreoInven=null;
	public Boolean mostraridTipoMensajeCorreoInven=true;
	public Boolean activaridTipoMensajeCorreoInven=true;

	public Border resaltarid_moduloTipoMensajeCorreoInven=null;
	public Boolean mostrarid_moduloTipoMensajeCorreoInven=true;
	public Boolean activarid_moduloTipoMensajeCorreoInven=true;
	public Boolean cargarid_moduloTipoMensajeCorreoInven=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_moduloTipoMensajeCorreoInven=false;//ConEventDepend=true

	public Border resaltarcodigoTipoMensajeCorreoInven=null;
	public Boolean mostrarcodigoTipoMensajeCorreoInven=true;
	public Boolean activarcodigoTipoMensajeCorreoInven=true;

	public Border resaltarnombreTipoMensajeCorreoInven=null;
	public Boolean mostrarnombreTipoMensajeCorreoInven=true;
	public Boolean activarnombreTipoMensajeCorreoInven=true;

	
	

	public Border setResaltaridTipoMensajeCorreoInven(ParametroGeneralUsuario parametroGeneralUsuario/*TipoMensajeCorreoInvenBeanSwingJInternalFrame tipomensajecorreoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipomensajecorreoinvenBeanSwingJInternalFrame.jTtoolBarTipoMensajeCorreoInven.setBorder(borderResaltar);
		
		this.resaltaridTipoMensajeCorreoInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoMensajeCorreoInven() {
		return this.resaltaridTipoMensajeCorreoInven;
	}

	public void setResaltaridTipoMensajeCorreoInven(Border borderResaltar) {
		this.resaltaridTipoMensajeCorreoInven= borderResaltar;
	}

	public Boolean getMostraridTipoMensajeCorreoInven() {
		return this.mostraridTipoMensajeCorreoInven;
	}

	public void setMostraridTipoMensajeCorreoInven(Boolean mostraridTipoMensajeCorreoInven) {
		this.mostraridTipoMensajeCorreoInven= mostraridTipoMensajeCorreoInven;
	}

	public Boolean getActivaridTipoMensajeCorreoInven() {
		return this.activaridTipoMensajeCorreoInven;
	}

	public void setActivaridTipoMensajeCorreoInven(Boolean activaridTipoMensajeCorreoInven) {
		this.activaridTipoMensajeCorreoInven= activaridTipoMensajeCorreoInven;
	}

	public Border setResaltarid_moduloTipoMensajeCorreoInven(ParametroGeneralUsuario parametroGeneralUsuario/*TipoMensajeCorreoInvenBeanSwingJInternalFrame tipomensajecorreoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipomensajecorreoinvenBeanSwingJInternalFrame.jTtoolBarTipoMensajeCorreoInven.setBorder(borderResaltar);
		
		this.resaltarid_moduloTipoMensajeCorreoInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_moduloTipoMensajeCorreoInven() {
		return this.resaltarid_moduloTipoMensajeCorreoInven;
	}

	public void setResaltarid_moduloTipoMensajeCorreoInven(Border borderResaltar) {
		this.resaltarid_moduloTipoMensajeCorreoInven= borderResaltar;
	}

	public Boolean getMostrarid_moduloTipoMensajeCorreoInven() {
		return this.mostrarid_moduloTipoMensajeCorreoInven;
	}

	public void setMostrarid_moduloTipoMensajeCorreoInven(Boolean mostrarid_moduloTipoMensajeCorreoInven) {
		this.mostrarid_moduloTipoMensajeCorreoInven= mostrarid_moduloTipoMensajeCorreoInven;
	}

	public Boolean getActivarid_moduloTipoMensajeCorreoInven() {
		return this.activarid_moduloTipoMensajeCorreoInven;
	}

	public void setActivarid_moduloTipoMensajeCorreoInven(Boolean activarid_moduloTipoMensajeCorreoInven) {
		this.activarid_moduloTipoMensajeCorreoInven= activarid_moduloTipoMensajeCorreoInven;
	}

	public Boolean getCargarid_moduloTipoMensajeCorreoInven() {
		return this.cargarid_moduloTipoMensajeCorreoInven;
	}

	public void setCargarid_moduloTipoMensajeCorreoInven(Boolean cargarid_moduloTipoMensajeCorreoInven) {
		this.cargarid_moduloTipoMensajeCorreoInven= cargarid_moduloTipoMensajeCorreoInven;
	}

	public Border setResaltarcodigoTipoMensajeCorreoInven(ParametroGeneralUsuario parametroGeneralUsuario/*TipoMensajeCorreoInvenBeanSwingJInternalFrame tipomensajecorreoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipomensajecorreoinvenBeanSwingJInternalFrame.jTtoolBarTipoMensajeCorreoInven.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoMensajeCorreoInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoMensajeCorreoInven() {
		return this.resaltarcodigoTipoMensajeCorreoInven;
	}

	public void setResaltarcodigoTipoMensajeCorreoInven(Border borderResaltar) {
		this.resaltarcodigoTipoMensajeCorreoInven= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoMensajeCorreoInven() {
		return this.mostrarcodigoTipoMensajeCorreoInven;
	}

	public void setMostrarcodigoTipoMensajeCorreoInven(Boolean mostrarcodigoTipoMensajeCorreoInven) {
		this.mostrarcodigoTipoMensajeCorreoInven= mostrarcodigoTipoMensajeCorreoInven;
	}

	public Boolean getActivarcodigoTipoMensajeCorreoInven() {
		return this.activarcodigoTipoMensajeCorreoInven;
	}

	public void setActivarcodigoTipoMensajeCorreoInven(Boolean activarcodigoTipoMensajeCorreoInven) {
		this.activarcodigoTipoMensajeCorreoInven= activarcodigoTipoMensajeCorreoInven;
	}

	public Border setResaltarnombreTipoMensajeCorreoInven(ParametroGeneralUsuario parametroGeneralUsuario/*TipoMensajeCorreoInvenBeanSwingJInternalFrame tipomensajecorreoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipomensajecorreoinvenBeanSwingJInternalFrame.jTtoolBarTipoMensajeCorreoInven.setBorder(borderResaltar);
		
		this.resaltarnombreTipoMensajeCorreoInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoMensajeCorreoInven() {
		return this.resaltarnombreTipoMensajeCorreoInven;
	}

	public void setResaltarnombreTipoMensajeCorreoInven(Border borderResaltar) {
		this.resaltarnombreTipoMensajeCorreoInven= borderResaltar;
	}

	public Boolean getMostrarnombreTipoMensajeCorreoInven() {
		return this.mostrarnombreTipoMensajeCorreoInven;
	}

	public void setMostrarnombreTipoMensajeCorreoInven(Boolean mostrarnombreTipoMensajeCorreoInven) {
		this.mostrarnombreTipoMensajeCorreoInven= mostrarnombreTipoMensajeCorreoInven;
	}

	public Boolean getActivarnombreTipoMensajeCorreoInven() {
		return this.activarnombreTipoMensajeCorreoInven;
	}

	public void setActivarnombreTipoMensajeCorreoInven(Boolean activarnombreTipoMensajeCorreoInven) {
		this.activarnombreTipoMensajeCorreoInven= activarnombreTipoMensajeCorreoInven;
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
		
		
		this.setMostraridTipoMensajeCorreoInven(esInicial);
		this.setMostrarid_moduloTipoMensajeCorreoInven(esInicial);
		this.setMostrarcodigoTipoMensajeCorreoInven(esInicial);
		this.setMostrarnombreTipoMensajeCorreoInven(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoMensajeCorreoInvenConstantesFunciones.ID)) {
				this.setMostraridTipoMensajeCorreoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMensajeCorreoInvenConstantesFunciones.IDMODULO)) {
				this.setMostrarid_moduloTipoMensajeCorreoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMensajeCorreoInvenConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoMensajeCorreoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMensajeCorreoInvenConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoMensajeCorreoInven(esAsigna);
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
		
		
		this.setActivaridTipoMensajeCorreoInven(esInicial);
		this.setActivarid_moduloTipoMensajeCorreoInven(esInicial);
		this.setActivarcodigoTipoMensajeCorreoInven(esInicial);
		this.setActivarnombreTipoMensajeCorreoInven(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoMensajeCorreoInvenConstantesFunciones.ID)) {
				this.setActivaridTipoMensajeCorreoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMensajeCorreoInvenConstantesFunciones.IDMODULO)) {
				this.setActivarid_moduloTipoMensajeCorreoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMensajeCorreoInvenConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoMensajeCorreoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMensajeCorreoInvenConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoMensajeCorreoInven(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoMensajeCorreoInvenBeanSwingJInternalFrame tipomensajecorreoinvenBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoMensajeCorreoInven(esInicial);
		this.setResaltarid_moduloTipoMensajeCorreoInven(esInicial);
		this.setResaltarcodigoTipoMensajeCorreoInven(esInicial);
		this.setResaltarnombreTipoMensajeCorreoInven(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoMensajeCorreoInvenConstantesFunciones.ID)) {
				this.setResaltaridTipoMensajeCorreoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMensajeCorreoInvenConstantesFunciones.IDMODULO)) {
				this.setResaltarid_moduloTipoMensajeCorreoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMensajeCorreoInvenConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoMensajeCorreoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMensajeCorreoInvenConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoMensajeCorreoInven(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoMensajeCorreoInvenBeanSwingJInternalFrame tipomensajecorreoinvenBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdModuloTipoMensajeCorreoInven=true;

	public Boolean getMostrarFK_IdModuloTipoMensajeCorreoInven() {
		return this.mostrarFK_IdModuloTipoMensajeCorreoInven;
	}

	public void setMostrarFK_IdModuloTipoMensajeCorreoInven(Boolean visibilidadResaltar) {
		this.mostrarFK_IdModuloTipoMensajeCorreoInven= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdModuloTipoMensajeCorreoInven=true;

	public Boolean getActivarFK_IdModuloTipoMensajeCorreoInven() {
		return this.activarFK_IdModuloTipoMensajeCorreoInven;
	}

	public void setActivarFK_IdModuloTipoMensajeCorreoInven(Boolean habilitarResaltar) {
		this.activarFK_IdModuloTipoMensajeCorreoInven= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdModuloTipoMensajeCorreoInven=null;

	public Border getResaltarFK_IdModuloTipoMensajeCorreoInven() {
		return this.resaltarFK_IdModuloTipoMensajeCorreoInven;
	}

	public void setResaltarFK_IdModuloTipoMensajeCorreoInven(Border borderResaltar) {
		this.resaltarFK_IdModuloTipoMensajeCorreoInven= borderResaltar;
	}

	public void setResaltarFK_IdModuloTipoMensajeCorreoInven(ParametroGeneralUsuario parametroGeneralUsuario/*TipoMensajeCorreoInvenBeanSwingJInternalFrame tipomensajecorreoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdModuloTipoMensajeCorreoInven= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}