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


import com.bydan.erp.cartera.util.TipoUbicacionNegocioConstantesFunciones;
import com.bydan.erp.cartera.util.TipoUbicacionNegocioParameterReturnGeneral;
//import com.bydan.erp.cartera.util.TipoUbicacionNegocioParameterGeneral;

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
final public class TipoUbicacionNegocioConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoUbicacionNegocio";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoUbicacionNegocio"+TipoUbicacionNegocioConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoUbicacionNegocioHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoUbicacionNegocioHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoUbicacionNegocioConstantesFunciones.SCHEMA+"_"+TipoUbicacionNegocioConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoUbicacionNegocioHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoUbicacionNegocioConstantesFunciones.SCHEMA+"_"+TipoUbicacionNegocioConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoUbicacionNegocioConstantesFunciones.SCHEMA+"_"+TipoUbicacionNegocioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoUbicacionNegocioHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoUbicacionNegocioConstantesFunciones.SCHEMA+"_"+TipoUbicacionNegocioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoUbicacionNegocioConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoUbicacionNegocioHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoUbicacionNegocioConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoUbicacionNegocioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoUbicacionNegocioHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoUbicacionNegocioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoUbicacionNegocioConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoUbicacionNegocioConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoUbicacionNegocioConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoUbicacionNegocioConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Ubicacion Negocios";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Ubicacion Negocio";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Ubicacion Negocio";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoUbicacionNegocio";
	public static final String OBJECTNAME="tipoubicacionnegocio";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="tipo_ubicacion_negocio";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipoubicacionnegocio from "+TipoUbicacionNegocioConstantesFunciones.SPERSISTENCENAME+" tipoubicacionnegocio";
	public static String QUERYSELECTNATIVE="select "+TipoUbicacionNegocioConstantesFunciones.SCHEMA+"."+TipoUbicacionNegocioConstantesFunciones.TABLENAME+".id,"+TipoUbicacionNegocioConstantesFunciones.SCHEMA+"."+TipoUbicacionNegocioConstantesFunciones.TABLENAME+".version_row,"+TipoUbicacionNegocioConstantesFunciones.SCHEMA+"."+TipoUbicacionNegocioConstantesFunciones.TABLENAME+".id_empresa,"+TipoUbicacionNegocioConstantesFunciones.SCHEMA+"."+TipoUbicacionNegocioConstantesFunciones.TABLENAME+".codigo,"+TipoUbicacionNegocioConstantesFunciones.SCHEMA+"."+TipoUbicacionNegocioConstantesFunciones.TABLENAME+".nombre from "+TipoUbicacionNegocioConstantesFunciones.SCHEMA+"."+TipoUbicacionNegocioConstantesFunciones.TABLENAME;//+" as "+TipoUbicacionNegocioConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getTipoUbicacionNegocioLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoUbicacionNegocioConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoUbicacionNegocioConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoUbicacionNegocioConstantesFunciones.CODIGO)) {sLabelColumna=TipoUbicacionNegocioConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoUbicacionNegocioConstantesFunciones.NOMBRE)) {sLabelColumna=TipoUbicacionNegocioConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getTipoUbicacionNegocioDescripcion(TipoUbicacionNegocio tipoubicacionnegocio) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipoubicacionnegocio !=null/* && tipoubicacionnegocio.getId()!=0*/) {
			sDescripcion=tipoubicacionnegocio.getcodigo();//tipoubicacionnegociotipoubicacionnegocio.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoUbicacionNegocioDescripcionDetallado(TipoUbicacionNegocio tipoubicacionnegocio) {
		String sDescripcion="";
			
		sDescripcion+=TipoUbicacionNegocioConstantesFunciones.ID+"=";
		sDescripcion+=tipoubicacionnegocio.getId().toString()+",";
		sDescripcion+=TipoUbicacionNegocioConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipoubicacionnegocio.getVersionRow().toString()+",";
		sDescripcion+=TipoUbicacionNegocioConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tipoubicacionnegocio.getid_empresa().toString()+",";
		sDescripcion+=TipoUbicacionNegocioConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipoubicacionnegocio.getcodigo()+",";
		sDescripcion+=TipoUbicacionNegocioConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipoubicacionnegocio.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoUbicacionNegocioDescripcion(TipoUbicacionNegocio tipoubicacionnegocio,String sValor) throws Exception {			
		if(tipoubicacionnegocio !=null) {
			tipoubicacionnegocio.setcodigo(sValor);;//tipoubicacionnegociotipoubicacionnegocio.getcodigo().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTipoUbicacionNegocio(TipoUbicacionNegocio tipoubicacionnegocio,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipoubicacionnegocio.setcodigo(tipoubicacionnegocio.getcodigo().trim());
		tipoubicacionnegocio.setnombre(tipoubicacionnegocio.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoUbicacionNegocios(List<TipoUbicacionNegocio> tipoubicacionnegocios,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoUbicacionNegocio tipoubicacionnegocio: tipoubicacionnegocios) {
			tipoubicacionnegocio.setcodigo(tipoubicacionnegocio.getcodigo().trim());
			tipoubicacionnegocio.setnombre(tipoubicacionnegocio.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoUbicacionNegocio(TipoUbicacionNegocio tipoubicacionnegocio,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipoubicacionnegocio.getConCambioAuxiliar()) {
			tipoubicacionnegocio.setIsDeleted(tipoubicacionnegocio.getIsDeletedAuxiliar());	
			tipoubicacionnegocio.setIsNew(tipoubicacionnegocio.getIsNewAuxiliar());	
			tipoubicacionnegocio.setIsChanged(tipoubicacionnegocio.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipoubicacionnegocio.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipoubicacionnegocio.setIsDeletedAuxiliar(false);	
			tipoubicacionnegocio.setIsNewAuxiliar(false);	
			tipoubicacionnegocio.setIsChangedAuxiliar(false);
			
			tipoubicacionnegocio.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoUbicacionNegocios(List<TipoUbicacionNegocio> tipoubicacionnegocios,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoUbicacionNegocio tipoubicacionnegocio : tipoubicacionnegocios) {
			if(conAsignarBase && tipoubicacionnegocio.getConCambioAuxiliar()) {
				tipoubicacionnegocio.setIsDeleted(tipoubicacionnegocio.getIsDeletedAuxiliar());	
				tipoubicacionnegocio.setIsNew(tipoubicacionnegocio.getIsNewAuxiliar());	
				tipoubicacionnegocio.setIsChanged(tipoubicacionnegocio.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipoubicacionnegocio.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipoubicacionnegocio.setIsDeletedAuxiliar(false);	
				tipoubicacionnegocio.setIsNewAuxiliar(false);	
				tipoubicacionnegocio.setIsChangedAuxiliar(false);
				
				tipoubicacionnegocio.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoUbicacionNegocio(TipoUbicacionNegocio tipoubicacionnegocio,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoUbicacionNegocios(List<TipoUbicacionNegocio> tipoubicacionnegocios,Boolean conEnteros) throws Exception  {
		
		for(TipoUbicacionNegocio tipoubicacionnegocio: tipoubicacionnegocios) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoUbicacionNegocio(List<TipoUbicacionNegocio> tipoubicacionnegocios,TipoUbicacionNegocio tipoubicacionnegocioAux) throws Exception  {
		TipoUbicacionNegocioConstantesFunciones.InicializarValoresTipoUbicacionNegocio(tipoubicacionnegocioAux,true);
		
		for(TipoUbicacionNegocio tipoubicacionnegocio: tipoubicacionnegocios) {
			if(tipoubicacionnegocio.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoUbicacionNegocio(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoUbicacionNegocioConstantesFunciones.getArrayColumnasGlobalesTipoUbicacionNegocio(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoUbicacionNegocio(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoUbicacionNegocioConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoUbicacionNegocioConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoUbicacionNegocio(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoUbicacionNegocio> tipoubicacionnegocios,TipoUbicacionNegocio tipoubicacionnegocio,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoUbicacionNegocio tipoubicacionnegocioAux: tipoubicacionnegocios) {
			if(tipoubicacionnegocioAux!=null && tipoubicacionnegocio!=null) {
				if((tipoubicacionnegocioAux.getId()==null && tipoubicacionnegocio.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipoubicacionnegocioAux.getId()!=null && tipoubicacionnegocio.getId()!=null){
					if(tipoubicacionnegocioAux.getId().equals(tipoubicacionnegocio.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoUbicacionNegocio(List<TipoUbicacionNegocio> tipoubicacionnegocios) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoUbicacionNegocio tipoubicacionnegocio: tipoubicacionnegocios) {			
			if(tipoubicacionnegocio.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoUbicacionNegocio() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoUbicacionNegocioConstantesFunciones.LABEL_ID, TipoUbicacionNegocioConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoUbicacionNegocioConstantesFunciones.LABEL_VERSIONROW, TipoUbicacionNegocioConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoUbicacionNegocioConstantesFunciones.LABEL_IDEMPRESA, TipoUbicacionNegocioConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoUbicacionNegocioConstantesFunciones.LABEL_CODIGO, TipoUbicacionNegocioConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoUbicacionNegocioConstantesFunciones.LABEL_NOMBRE, TipoUbicacionNegocioConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoUbicacionNegocio() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoUbicacionNegocioConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoUbicacionNegocioConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoUbicacionNegocioConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoUbicacionNegocioConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoUbicacionNegocioConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoUbicacionNegocio() throws Exception  {
		return TipoUbicacionNegocioConstantesFunciones.getTiposSeleccionarTipoUbicacionNegocio(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoUbicacionNegocio(Boolean conFk) throws Exception  {
		return TipoUbicacionNegocioConstantesFunciones.getTiposSeleccionarTipoUbicacionNegocio(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoUbicacionNegocio(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoUbicacionNegocioConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoUbicacionNegocioConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoUbicacionNegocioConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoUbicacionNegocioConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoUbicacionNegocioConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoUbicacionNegocioConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoUbicacionNegocio(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoUbicacionNegocio(TipoUbicacionNegocio tipoubicacionnegocioAux) throws Exception {
		
			tipoubicacionnegocioAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipoubicacionnegocioAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoUbicacionNegocio(List<TipoUbicacionNegocio> tipoubicacionnegociosTemp) throws Exception {
		for(TipoUbicacionNegocio tipoubicacionnegocioAux:tipoubicacionnegociosTemp) {
			
			tipoubicacionnegocioAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipoubicacionnegocioAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoUbicacionNegocio(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoUbicacionNegocio(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoUbicacionNegocio(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoUbicacionNegocioConstantesFunciones.getClassesRelationshipsOfTipoUbicacionNegocio(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoUbicacionNegocio(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoUbicacionNegocio(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoUbicacionNegocioConstantesFunciones.getClassesRelationshipsFromStringsOfTipoUbicacionNegocio(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoUbicacionNegocio(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TipoUbicacionNegocio tipoubicacionnegocio,List<TipoUbicacionNegocio> tipoubicacionnegocios,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoUbicacionNegocio tipoubicacionnegocioEncontrado=null;
			
			for(TipoUbicacionNegocio tipoubicacionnegocioLocal:tipoubicacionnegocios) {
				if(tipoubicacionnegocioLocal.getId().equals(tipoubicacionnegocio.getId())) {
					tipoubicacionnegocioEncontrado=tipoubicacionnegocioLocal;
					
					tipoubicacionnegocioLocal.setIsChanged(tipoubicacionnegocio.getIsChanged());
					tipoubicacionnegocioLocal.setIsNew(tipoubicacionnegocio.getIsNew());
					tipoubicacionnegocioLocal.setIsDeleted(tipoubicacionnegocio.getIsDeleted());
					
					tipoubicacionnegocioLocal.setGeneralEntityOriginal(tipoubicacionnegocio.getGeneralEntityOriginal());
					
					tipoubicacionnegocioLocal.setId(tipoubicacionnegocio.getId());	
					tipoubicacionnegocioLocal.setVersionRow(tipoubicacionnegocio.getVersionRow());	
					tipoubicacionnegocioLocal.setid_empresa(tipoubicacionnegocio.getid_empresa());	
					tipoubicacionnegocioLocal.setcodigo(tipoubicacionnegocio.getcodigo());	
					tipoubicacionnegocioLocal.setnombre(tipoubicacionnegocio.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipoubicacionnegocio.getIsDeleted()) {
				if(!existe) {
					tipoubicacionnegocios.add(tipoubicacionnegocio);
				}
			} else {
				if(tipoubicacionnegocioEncontrado!=null && permiteQuitar)  {
					tipoubicacionnegocios.remove(tipoubicacionnegocioEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoUbicacionNegocio tipoubicacionnegocio,List<TipoUbicacionNegocio> tipoubicacionnegocios) throws Exception {
		try	{			
			for(TipoUbicacionNegocio tipoubicacionnegocioLocal:tipoubicacionnegocios) {
				if(tipoubicacionnegocioLocal.getId().equals(tipoubicacionnegocio.getId())) {
					tipoubicacionnegocioLocal.setIsSelected(tipoubicacionnegocio.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoUbicacionNegocio(List<TipoUbicacionNegocio> tipoubicacionnegociosAux) throws Exception {
		//this.tipoubicacionnegociosAux=tipoubicacionnegociosAux;
		
		for(TipoUbicacionNegocio tipoubicacionnegocioAux:tipoubicacionnegociosAux) {
			if(tipoubicacionnegocioAux.getIsChanged()) {
				tipoubicacionnegocioAux.setIsChanged(false);
			}		
			
			if(tipoubicacionnegocioAux.getIsNew()) {
				tipoubicacionnegocioAux.setIsNew(false);
			}	
			
			if(tipoubicacionnegocioAux.getIsDeleted()) {
				tipoubicacionnegocioAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoUbicacionNegocio(TipoUbicacionNegocio tipoubicacionnegocioAux) throws Exception {
		//this.tipoubicacionnegocioAux=tipoubicacionnegocioAux;
		
			if(tipoubicacionnegocioAux.getIsChanged()) {
				tipoubicacionnegocioAux.setIsChanged(false);
			}		
			
			if(tipoubicacionnegocioAux.getIsNew()) {
				tipoubicacionnegocioAux.setIsNew(false);
			}	
			
			if(tipoubicacionnegocioAux.getIsDeleted()) {
				tipoubicacionnegocioAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoUbicacionNegocio tipoubicacionnegocioAsignar,TipoUbicacionNegocio tipoubicacionnegocio) throws Exception {
		tipoubicacionnegocioAsignar.setId(tipoubicacionnegocio.getId());	
		tipoubicacionnegocioAsignar.setVersionRow(tipoubicacionnegocio.getVersionRow());	
		tipoubicacionnegocioAsignar.setid_empresa(tipoubicacionnegocio.getid_empresa());
		tipoubicacionnegocioAsignar.setempresa_descripcion(tipoubicacionnegocio.getempresa_descripcion());	
		tipoubicacionnegocioAsignar.setcodigo(tipoubicacionnegocio.getcodigo());	
		tipoubicacionnegocioAsignar.setnombre(tipoubicacionnegocio.getnombre());	
	}
	
	public static void inicializarTipoUbicacionNegocio(TipoUbicacionNegocio tipoubicacionnegocio) throws Exception {
		try {
				tipoubicacionnegocio.setId(0L);	
					
				tipoubicacionnegocio.setid_empresa(-1L);	
				tipoubicacionnegocio.setcodigo("");	
				tipoubicacionnegocio.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoUbicacionNegocio(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoUbicacionNegocioConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoUbicacionNegocioConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoUbicacionNegocioConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoUbicacionNegocio(String sTipo,Row row,Workbook workbook,TipoUbicacionNegocio tipoubicacionnegocio,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoubicacionnegocio.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoubicacionnegocio.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoubicacionnegocio.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoUbicacionNegocio=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoUbicacionNegocio() {
		return this.sFinalQueryTipoUbicacionNegocio;
	}
	
	public void setsFinalQueryTipoUbicacionNegocio(String sFinalQueryTipoUbicacionNegocio) {
		this.sFinalQueryTipoUbicacionNegocio= sFinalQueryTipoUbicacionNegocio;
	}
	
	public Border resaltarSeleccionarTipoUbicacionNegocio=null;
	
	public Border setResaltarSeleccionarTipoUbicacionNegocio(ParametroGeneralUsuario parametroGeneralUsuario/*TipoUbicacionNegocioBeanSwingJInternalFrame tipoubicacionnegocioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipoubicacionnegocioBeanSwingJInternalFrame.jTtoolBarTipoUbicacionNegocio.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoUbicacionNegocio= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoUbicacionNegocio() {
		return this.resaltarSeleccionarTipoUbicacionNegocio;
	}
	
	public void setResaltarSeleccionarTipoUbicacionNegocio(Border borderResaltarSeleccionarTipoUbicacionNegocio) {
		this.resaltarSeleccionarTipoUbicacionNegocio= borderResaltarSeleccionarTipoUbicacionNegocio;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoUbicacionNegocio=null;
	public Boolean mostraridTipoUbicacionNegocio=true;
	public Boolean activaridTipoUbicacionNegocio=true;

	public Border resaltarid_empresaTipoUbicacionNegocio=null;
	public Boolean mostrarid_empresaTipoUbicacionNegocio=true;
	public Boolean activarid_empresaTipoUbicacionNegocio=true;
	public Boolean cargarid_empresaTipoUbicacionNegocio=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoUbicacionNegocio=false;//ConEventDepend=true

	public Border resaltarcodigoTipoUbicacionNegocio=null;
	public Boolean mostrarcodigoTipoUbicacionNegocio=true;
	public Boolean activarcodigoTipoUbicacionNegocio=true;

	public Border resaltarnombreTipoUbicacionNegocio=null;
	public Boolean mostrarnombreTipoUbicacionNegocio=true;
	public Boolean activarnombreTipoUbicacionNegocio=true;

	
	

	public Border setResaltaridTipoUbicacionNegocio(ParametroGeneralUsuario parametroGeneralUsuario/*TipoUbicacionNegocioBeanSwingJInternalFrame tipoubicacionnegocioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoubicacionnegocioBeanSwingJInternalFrame.jTtoolBarTipoUbicacionNegocio.setBorder(borderResaltar);
		
		this.resaltaridTipoUbicacionNegocio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoUbicacionNegocio() {
		return this.resaltaridTipoUbicacionNegocio;
	}

	public void setResaltaridTipoUbicacionNegocio(Border borderResaltar) {
		this.resaltaridTipoUbicacionNegocio= borderResaltar;
	}

	public Boolean getMostraridTipoUbicacionNegocio() {
		return this.mostraridTipoUbicacionNegocio;
	}

	public void setMostraridTipoUbicacionNegocio(Boolean mostraridTipoUbicacionNegocio) {
		this.mostraridTipoUbicacionNegocio= mostraridTipoUbicacionNegocio;
	}

	public Boolean getActivaridTipoUbicacionNegocio() {
		return this.activaridTipoUbicacionNegocio;
	}

	public void setActivaridTipoUbicacionNegocio(Boolean activaridTipoUbicacionNegocio) {
		this.activaridTipoUbicacionNegocio= activaridTipoUbicacionNegocio;
	}

	public Border setResaltarid_empresaTipoUbicacionNegocio(ParametroGeneralUsuario parametroGeneralUsuario/*TipoUbicacionNegocioBeanSwingJInternalFrame tipoubicacionnegocioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoubicacionnegocioBeanSwingJInternalFrame.jTtoolBarTipoUbicacionNegocio.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoUbicacionNegocio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoUbicacionNegocio() {
		return this.resaltarid_empresaTipoUbicacionNegocio;
	}

	public void setResaltarid_empresaTipoUbicacionNegocio(Border borderResaltar) {
		this.resaltarid_empresaTipoUbicacionNegocio= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoUbicacionNegocio() {
		return this.mostrarid_empresaTipoUbicacionNegocio;
	}

	public void setMostrarid_empresaTipoUbicacionNegocio(Boolean mostrarid_empresaTipoUbicacionNegocio) {
		this.mostrarid_empresaTipoUbicacionNegocio= mostrarid_empresaTipoUbicacionNegocio;
	}

	public Boolean getActivarid_empresaTipoUbicacionNegocio() {
		return this.activarid_empresaTipoUbicacionNegocio;
	}

	public void setActivarid_empresaTipoUbicacionNegocio(Boolean activarid_empresaTipoUbicacionNegocio) {
		this.activarid_empresaTipoUbicacionNegocio= activarid_empresaTipoUbicacionNegocio;
	}

	public Boolean getCargarid_empresaTipoUbicacionNegocio() {
		return this.cargarid_empresaTipoUbicacionNegocio;
	}

	public void setCargarid_empresaTipoUbicacionNegocio(Boolean cargarid_empresaTipoUbicacionNegocio) {
		this.cargarid_empresaTipoUbicacionNegocio= cargarid_empresaTipoUbicacionNegocio;
	}

	public Border setResaltarcodigoTipoUbicacionNegocio(ParametroGeneralUsuario parametroGeneralUsuario/*TipoUbicacionNegocioBeanSwingJInternalFrame tipoubicacionnegocioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoubicacionnegocioBeanSwingJInternalFrame.jTtoolBarTipoUbicacionNegocio.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoUbicacionNegocio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoUbicacionNegocio() {
		return this.resaltarcodigoTipoUbicacionNegocio;
	}

	public void setResaltarcodigoTipoUbicacionNegocio(Border borderResaltar) {
		this.resaltarcodigoTipoUbicacionNegocio= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoUbicacionNegocio() {
		return this.mostrarcodigoTipoUbicacionNegocio;
	}

	public void setMostrarcodigoTipoUbicacionNegocio(Boolean mostrarcodigoTipoUbicacionNegocio) {
		this.mostrarcodigoTipoUbicacionNegocio= mostrarcodigoTipoUbicacionNegocio;
	}

	public Boolean getActivarcodigoTipoUbicacionNegocio() {
		return this.activarcodigoTipoUbicacionNegocio;
	}

	public void setActivarcodigoTipoUbicacionNegocio(Boolean activarcodigoTipoUbicacionNegocio) {
		this.activarcodigoTipoUbicacionNegocio= activarcodigoTipoUbicacionNegocio;
	}

	public Border setResaltarnombreTipoUbicacionNegocio(ParametroGeneralUsuario parametroGeneralUsuario/*TipoUbicacionNegocioBeanSwingJInternalFrame tipoubicacionnegocioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoubicacionnegocioBeanSwingJInternalFrame.jTtoolBarTipoUbicacionNegocio.setBorder(borderResaltar);
		
		this.resaltarnombreTipoUbicacionNegocio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoUbicacionNegocio() {
		return this.resaltarnombreTipoUbicacionNegocio;
	}

	public void setResaltarnombreTipoUbicacionNegocio(Border borderResaltar) {
		this.resaltarnombreTipoUbicacionNegocio= borderResaltar;
	}

	public Boolean getMostrarnombreTipoUbicacionNegocio() {
		return this.mostrarnombreTipoUbicacionNegocio;
	}

	public void setMostrarnombreTipoUbicacionNegocio(Boolean mostrarnombreTipoUbicacionNegocio) {
		this.mostrarnombreTipoUbicacionNegocio= mostrarnombreTipoUbicacionNegocio;
	}

	public Boolean getActivarnombreTipoUbicacionNegocio() {
		return this.activarnombreTipoUbicacionNegocio;
	}

	public void setActivarnombreTipoUbicacionNegocio(Boolean activarnombreTipoUbicacionNegocio) {
		this.activarnombreTipoUbicacionNegocio= activarnombreTipoUbicacionNegocio;
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
		
		
		this.setMostraridTipoUbicacionNegocio(esInicial);
		this.setMostrarid_empresaTipoUbicacionNegocio(esInicial);
		this.setMostrarcodigoTipoUbicacionNegocio(esInicial);
		this.setMostrarnombreTipoUbicacionNegocio(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoUbicacionNegocioConstantesFunciones.ID)) {
				this.setMostraridTipoUbicacionNegocio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoUbicacionNegocioConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoUbicacionNegocio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoUbicacionNegocioConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoUbicacionNegocio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoUbicacionNegocioConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoUbicacionNegocio(esAsigna);
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
		
		
		this.setActivaridTipoUbicacionNegocio(esInicial);
		this.setActivarid_empresaTipoUbicacionNegocio(esInicial);
		this.setActivarcodigoTipoUbicacionNegocio(esInicial);
		this.setActivarnombreTipoUbicacionNegocio(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoUbicacionNegocioConstantesFunciones.ID)) {
				this.setActivaridTipoUbicacionNegocio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoUbicacionNegocioConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoUbicacionNegocio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoUbicacionNegocioConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoUbicacionNegocio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoUbicacionNegocioConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoUbicacionNegocio(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoUbicacionNegocioBeanSwingJInternalFrame tipoubicacionnegocioBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoUbicacionNegocio(esInicial);
		this.setResaltarid_empresaTipoUbicacionNegocio(esInicial);
		this.setResaltarcodigoTipoUbicacionNegocio(esInicial);
		this.setResaltarnombreTipoUbicacionNegocio(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoUbicacionNegocioConstantesFunciones.ID)) {
				this.setResaltaridTipoUbicacionNegocio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoUbicacionNegocioConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoUbicacionNegocio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoUbicacionNegocioConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoUbicacionNegocio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoUbicacionNegocioConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoUbicacionNegocio(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoUbicacionNegocioBeanSwingJInternalFrame tipoubicacionnegocioBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpresaTipoUbicacionNegocio=true;

	public Boolean getMostrarFK_IdEmpresaTipoUbicacionNegocio() {
		return this.mostrarFK_IdEmpresaTipoUbicacionNegocio;
	}

	public void setMostrarFK_IdEmpresaTipoUbicacionNegocio(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoUbicacionNegocio= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaTipoUbicacionNegocio=true;

	public Boolean getActivarFK_IdEmpresaTipoUbicacionNegocio() {
		return this.activarFK_IdEmpresaTipoUbicacionNegocio;
	}

	public void setActivarFK_IdEmpresaTipoUbicacionNegocio(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoUbicacionNegocio= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaTipoUbicacionNegocio=null;

	public Border getResaltarFK_IdEmpresaTipoUbicacionNegocio() {
		return this.resaltarFK_IdEmpresaTipoUbicacionNegocio;
	}

	public void setResaltarFK_IdEmpresaTipoUbicacionNegocio(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoUbicacionNegocio= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoUbicacionNegocio(ParametroGeneralUsuario parametroGeneralUsuario/*TipoUbicacionNegocioBeanSwingJInternalFrame tipoubicacionnegocioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoUbicacionNegocio= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}