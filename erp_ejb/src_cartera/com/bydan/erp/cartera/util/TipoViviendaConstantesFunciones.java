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


import com.bydan.erp.cartera.util.TipoViviendaConstantesFunciones;
import com.bydan.erp.cartera.util.TipoViviendaParameterReturnGeneral;
//import com.bydan.erp.cartera.util.TipoViviendaParameterGeneral;

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
final public class TipoViviendaConstantesFunciones extends TipoViviendaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoVivienda";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoVivienda"+TipoViviendaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoViviendaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoViviendaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoViviendaConstantesFunciones.SCHEMA+"_"+TipoViviendaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoViviendaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoViviendaConstantesFunciones.SCHEMA+"_"+TipoViviendaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoViviendaConstantesFunciones.SCHEMA+"_"+TipoViviendaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoViviendaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoViviendaConstantesFunciones.SCHEMA+"_"+TipoViviendaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoViviendaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoViviendaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoViviendaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoViviendaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoViviendaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoViviendaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoViviendaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoViviendaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoViviendaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoViviendaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Viviendas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Vivienda";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Vivienda";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoVivienda";
	public static final String OBJECTNAME="tipovivienda";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="tipo_vivienda";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipovivienda from "+TipoViviendaConstantesFunciones.SPERSISTENCENAME+" tipovivienda";
	public static String QUERYSELECTNATIVE="select "+TipoViviendaConstantesFunciones.SCHEMA+"."+TipoViviendaConstantesFunciones.TABLENAME+".id,"+TipoViviendaConstantesFunciones.SCHEMA+"."+TipoViviendaConstantesFunciones.TABLENAME+".version_row,"+TipoViviendaConstantesFunciones.SCHEMA+"."+TipoViviendaConstantesFunciones.TABLENAME+".id_empresa,"+TipoViviendaConstantesFunciones.SCHEMA+"."+TipoViviendaConstantesFunciones.TABLENAME+".codigo,"+TipoViviendaConstantesFunciones.SCHEMA+"."+TipoViviendaConstantesFunciones.TABLENAME+".nombre from "+TipoViviendaConstantesFunciones.SCHEMA+"."+TipoViviendaConstantesFunciones.TABLENAME;//+" as "+TipoViviendaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoViviendaConstantesFuncionesAdditional tipoviviendaConstantesFuncionesAdditional=null;
	
	public TipoViviendaConstantesFuncionesAdditional getTipoViviendaConstantesFuncionesAdditional() {
		return this.tipoviviendaConstantesFuncionesAdditional;
	}
	
	public void setTipoViviendaConstantesFuncionesAdditional(TipoViviendaConstantesFuncionesAdditional tipoviviendaConstantesFuncionesAdditional) {
		try {
			this.tipoviviendaConstantesFuncionesAdditional=tipoviviendaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
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
	
	public static String getTipoViviendaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoViviendaConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoViviendaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoViviendaConstantesFunciones.CODIGO)) {sLabelColumna=TipoViviendaConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoViviendaConstantesFunciones.NOMBRE)) {sLabelColumna=TipoViviendaConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getTipoViviendaDescripcion(TipoVivienda tipovivienda) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipovivienda !=null/* && tipovivienda.getId()!=0*/) {
			sDescripcion=tipovivienda.getcodigo();//tipoviviendatipovivienda.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoViviendaDescripcionDetallado(TipoVivienda tipovivienda) {
		String sDescripcion="";
			
		sDescripcion+=TipoViviendaConstantesFunciones.ID+"=";
		sDescripcion+=tipovivienda.getId().toString()+",";
		sDescripcion+=TipoViviendaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipovivienda.getVersionRow().toString()+",";
		sDescripcion+=TipoViviendaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tipovivienda.getid_empresa().toString()+",";
		sDescripcion+=TipoViviendaConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipovivienda.getcodigo()+",";
		sDescripcion+=TipoViviendaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipovivienda.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoViviendaDescripcion(TipoVivienda tipovivienda,String sValor) throws Exception {			
		if(tipovivienda !=null) {
			tipovivienda.setcodigo(sValor);;//tipoviviendatipovivienda.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoVivienda(TipoVivienda tipovivienda,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipovivienda.setcodigo(tipovivienda.getcodigo().trim());
		tipovivienda.setnombre(tipovivienda.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoViviendas(List<TipoVivienda> tipoviviendas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoVivienda tipovivienda: tipoviviendas) {
			tipovivienda.setcodigo(tipovivienda.getcodigo().trim());
			tipovivienda.setnombre(tipovivienda.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoVivienda(TipoVivienda tipovivienda,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipovivienda.getConCambioAuxiliar()) {
			tipovivienda.setIsDeleted(tipovivienda.getIsDeletedAuxiliar());	
			tipovivienda.setIsNew(tipovivienda.getIsNewAuxiliar());	
			tipovivienda.setIsChanged(tipovivienda.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipovivienda.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipovivienda.setIsDeletedAuxiliar(false);	
			tipovivienda.setIsNewAuxiliar(false);	
			tipovivienda.setIsChangedAuxiliar(false);
			
			tipovivienda.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoViviendas(List<TipoVivienda> tipoviviendas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoVivienda tipovivienda : tipoviviendas) {
			if(conAsignarBase && tipovivienda.getConCambioAuxiliar()) {
				tipovivienda.setIsDeleted(tipovivienda.getIsDeletedAuxiliar());	
				tipovivienda.setIsNew(tipovivienda.getIsNewAuxiliar());	
				tipovivienda.setIsChanged(tipovivienda.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipovivienda.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipovivienda.setIsDeletedAuxiliar(false);	
				tipovivienda.setIsNewAuxiliar(false);	
				tipovivienda.setIsChangedAuxiliar(false);
				
				tipovivienda.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoVivienda(TipoVivienda tipovivienda,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoViviendas(List<TipoVivienda> tipoviviendas,Boolean conEnteros) throws Exception  {
		
		for(TipoVivienda tipovivienda: tipoviviendas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoVivienda(List<TipoVivienda> tipoviviendas,TipoVivienda tipoviviendaAux) throws Exception  {
		TipoViviendaConstantesFunciones.InicializarValoresTipoVivienda(tipoviviendaAux,true);
		
		for(TipoVivienda tipovivienda: tipoviviendas) {
			if(tipovivienda.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoVivienda(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoViviendaConstantesFunciones.getArrayColumnasGlobalesTipoVivienda(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoVivienda(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoViviendaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoViviendaConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoVivienda(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoVivienda> tipoviviendas,TipoVivienda tipovivienda,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoVivienda tipoviviendaAux: tipoviviendas) {
			if(tipoviviendaAux!=null && tipovivienda!=null) {
				if((tipoviviendaAux.getId()==null && tipovivienda.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipoviviendaAux.getId()!=null && tipovivienda.getId()!=null){
					if(tipoviviendaAux.getId().equals(tipovivienda.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoVivienda(List<TipoVivienda> tipoviviendas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoVivienda tipovivienda: tipoviviendas) {			
			if(tipovivienda.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoVivienda() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoViviendaConstantesFunciones.LABEL_ID, TipoViviendaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoViviendaConstantesFunciones.LABEL_VERSIONROW, TipoViviendaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoViviendaConstantesFunciones.LABEL_IDEMPRESA, TipoViviendaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoViviendaConstantesFunciones.LABEL_CODIGO, TipoViviendaConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoViviendaConstantesFunciones.LABEL_NOMBRE, TipoViviendaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoVivienda() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoViviendaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoViviendaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoViviendaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoViviendaConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoViviendaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoVivienda() throws Exception  {
		return TipoViviendaConstantesFunciones.getTiposSeleccionarTipoVivienda(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoVivienda(Boolean conFk) throws Exception  {
		return TipoViviendaConstantesFunciones.getTiposSeleccionarTipoVivienda(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoVivienda(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoViviendaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoViviendaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoViviendaConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoViviendaConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoViviendaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoViviendaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoVivienda(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoVivienda(TipoVivienda tipoviviendaAux) throws Exception {
		
			tipoviviendaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipoviviendaAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoVivienda(List<TipoVivienda> tipoviviendasTemp) throws Exception {
		for(TipoVivienda tipoviviendaAux:tipoviviendasTemp) {
			
			tipoviviendaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipoviviendaAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoVivienda(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoVivienda(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoVivienda(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoViviendaConstantesFunciones.getClassesRelationshipsOfTipoVivienda(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoVivienda(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Direccion.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Direccion.class)) {
						classes.add(new Classe(Direccion.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoVivienda(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoViviendaConstantesFunciones.getClassesRelationshipsFromStringsOfTipoVivienda(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoVivienda(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Direccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Direccion.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Direccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Direccion.class)); continue;
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
	public static void actualizarLista(TipoVivienda tipovivienda,List<TipoVivienda> tipoviviendas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoVivienda tipoviviendaEncontrado=null;
			
			for(TipoVivienda tipoviviendaLocal:tipoviviendas) {
				if(tipoviviendaLocal.getId().equals(tipovivienda.getId())) {
					tipoviviendaEncontrado=tipoviviendaLocal;
					
					tipoviviendaLocal.setIsChanged(tipovivienda.getIsChanged());
					tipoviviendaLocal.setIsNew(tipovivienda.getIsNew());
					tipoviviendaLocal.setIsDeleted(tipovivienda.getIsDeleted());
					
					tipoviviendaLocal.setGeneralEntityOriginal(tipovivienda.getGeneralEntityOriginal());
					
					tipoviviendaLocal.setId(tipovivienda.getId());	
					tipoviviendaLocal.setVersionRow(tipovivienda.getVersionRow());	
					tipoviviendaLocal.setid_empresa(tipovivienda.getid_empresa());	
					tipoviviendaLocal.setcodigo(tipovivienda.getcodigo());	
					tipoviviendaLocal.setnombre(tipovivienda.getnombre());	
					
					
					tipoviviendaLocal.setDireccions(tipovivienda.getDireccions());
					
					existe=true;
					break;
				}
			}
			
			if(!tipovivienda.getIsDeleted()) {
				if(!existe) {
					tipoviviendas.add(tipovivienda);
				}
			} else {
				if(tipoviviendaEncontrado!=null && permiteQuitar)  {
					tipoviviendas.remove(tipoviviendaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoVivienda tipovivienda,List<TipoVivienda> tipoviviendas) throws Exception {
		try	{			
			for(TipoVivienda tipoviviendaLocal:tipoviviendas) {
				if(tipoviviendaLocal.getId().equals(tipovivienda.getId())) {
					tipoviviendaLocal.setIsSelected(tipovivienda.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoVivienda(List<TipoVivienda> tipoviviendasAux) throws Exception {
		//this.tipoviviendasAux=tipoviviendasAux;
		
		for(TipoVivienda tipoviviendaAux:tipoviviendasAux) {
			if(tipoviviendaAux.getIsChanged()) {
				tipoviviendaAux.setIsChanged(false);
			}		
			
			if(tipoviviendaAux.getIsNew()) {
				tipoviviendaAux.setIsNew(false);
			}	
			
			if(tipoviviendaAux.getIsDeleted()) {
				tipoviviendaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoVivienda(TipoVivienda tipoviviendaAux) throws Exception {
		//this.tipoviviendaAux=tipoviviendaAux;
		
			if(tipoviviendaAux.getIsChanged()) {
				tipoviviendaAux.setIsChanged(false);
			}		
			
			if(tipoviviendaAux.getIsNew()) {
				tipoviviendaAux.setIsNew(false);
			}	
			
			if(tipoviviendaAux.getIsDeleted()) {
				tipoviviendaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoVivienda tipoviviendaAsignar,TipoVivienda tipovivienda) throws Exception {
		tipoviviendaAsignar.setId(tipovivienda.getId());	
		tipoviviendaAsignar.setVersionRow(tipovivienda.getVersionRow());	
		tipoviviendaAsignar.setid_empresa(tipovivienda.getid_empresa());
		tipoviviendaAsignar.setempresa_descripcion(tipovivienda.getempresa_descripcion());	
		tipoviviendaAsignar.setcodigo(tipovivienda.getcodigo());	
		tipoviviendaAsignar.setnombre(tipovivienda.getnombre());	
	}
	
	public static void inicializarTipoVivienda(TipoVivienda tipovivienda) throws Exception {
		try {
				tipovivienda.setId(0L);	
					
				tipovivienda.setid_empresa(-1L);	
				tipovivienda.setcodigo("");	
				tipovivienda.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoVivienda(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoViviendaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoViviendaConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoViviendaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoVivienda(String sTipo,Row row,Workbook workbook,TipoVivienda tipovivienda,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipovivienda.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipovivienda.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipovivienda.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoVivienda=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoVivienda() {
		return this.sFinalQueryTipoVivienda;
	}
	
	public void setsFinalQueryTipoVivienda(String sFinalQueryTipoVivienda) {
		this.sFinalQueryTipoVivienda= sFinalQueryTipoVivienda;
	}
	
	public Border resaltarSeleccionarTipoVivienda=null;
	
	public Border setResaltarSeleccionarTipoVivienda(ParametroGeneralUsuario parametroGeneralUsuario/*TipoViviendaBeanSwingJInternalFrame tipoviviendaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipoviviendaBeanSwingJInternalFrame.jTtoolBarTipoVivienda.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoVivienda= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoVivienda() {
		return this.resaltarSeleccionarTipoVivienda;
	}
	
	public void setResaltarSeleccionarTipoVivienda(Border borderResaltarSeleccionarTipoVivienda) {
		this.resaltarSeleccionarTipoVivienda= borderResaltarSeleccionarTipoVivienda;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoVivienda=null;
	public Boolean mostraridTipoVivienda=true;
	public Boolean activaridTipoVivienda=true;

	public Border resaltarid_empresaTipoVivienda=null;
	public Boolean mostrarid_empresaTipoVivienda=true;
	public Boolean activarid_empresaTipoVivienda=true;
	public Boolean cargarid_empresaTipoVivienda=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoVivienda=false;//ConEventDepend=true

	public Border resaltarcodigoTipoVivienda=null;
	public Boolean mostrarcodigoTipoVivienda=true;
	public Boolean activarcodigoTipoVivienda=true;

	public Border resaltarnombreTipoVivienda=null;
	public Boolean mostrarnombreTipoVivienda=true;
	public Boolean activarnombreTipoVivienda=true;

	
	

	public Border setResaltaridTipoVivienda(ParametroGeneralUsuario parametroGeneralUsuario/*TipoViviendaBeanSwingJInternalFrame tipoviviendaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoviviendaBeanSwingJInternalFrame.jTtoolBarTipoVivienda.setBorder(borderResaltar);
		
		this.resaltaridTipoVivienda= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoVivienda() {
		return this.resaltaridTipoVivienda;
	}

	public void setResaltaridTipoVivienda(Border borderResaltar) {
		this.resaltaridTipoVivienda= borderResaltar;
	}

	public Boolean getMostraridTipoVivienda() {
		return this.mostraridTipoVivienda;
	}

	public void setMostraridTipoVivienda(Boolean mostraridTipoVivienda) {
		this.mostraridTipoVivienda= mostraridTipoVivienda;
	}

	public Boolean getActivaridTipoVivienda() {
		return this.activaridTipoVivienda;
	}

	public void setActivaridTipoVivienda(Boolean activaridTipoVivienda) {
		this.activaridTipoVivienda= activaridTipoVivienda;
	}

	public Border setResaltarid_empresaTipoVivienda(ParametroGeneralUsuario parametroGeneralUsuario/*TipoViviendaBeanSwingJInternalFrame tipoviviendaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoviviendaBeanSwingJInternalFrame.jTtoolBarTipoVivienda.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoVivienda= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoVivienda() {
		return this.resaltarid_empresaTipoVivienda;
	}

	public void setResaltarid_empresaTipoVivienda(Border borderResaltar) {
		this.resaltarid_empresaTipoVivienda= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoVivienda() {
		return this.mostrarid_empresaTipoVivienda;
	}

	public void setMostrarid_empresaTipoVivienda(Boolean mostrarid_empresaTipoVivienda) {
		this.mostrarid_empresaTipoVivienda= mostrarid_empresaTipoVivienda;
	}

	public Boolean getActivarid_empresaTipoVivienda() {
		return this.activarid_empresaTipoVivienda;
	}

	public void setActivarid_empresaTipoVivienda(Boolean activarid_empresaTipoVivienda) {
		this.activarid_empresaTipoVivienda= activarid_empresaTipoVivienda;
	}

	public Boolean getCargarid_empresaTipoVivienda() {
		return this.cargarid_empresaTipoVivienda;
	}

	public void setCargarid_empresaTipoVivienda(Boolean cargarid_empresaTipoVivienda) {
		this.cargarid_empresaTipoVivienda= cargarid_empresaTipoVivienda;
	}

	public Border setResaltarcodigoTipoVivienda(ParametroGeneralUsuario parametroGeneralUsuario/*TipoViviendaBeanSwingJInternalFrame tipoviviendaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoviviendaBeanSwingJInternalFrame.jTtoolBarTipoVivienda.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoVivienda= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoVivienda() {
		return this.resaltarcodigoTipoVivienda;
	}

	public void setResaltarcodigoTipoVivienda(Border borderResaltar) {
		this.resaltarcodigoTipoVivienda= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoVivienda() {
		return this.mostrarcodigoTipoVivienda;
	}

	public void setMostrarcodigoTipoVivienda(Boolean mostrarcodigoTipoVivienda) {
		this.mostrarcodigoTipoVivienda= mostrarcodigoTipoVivienda;
	}

	public Boolean getActivarcodigoTipoVivienda() {
		return this.activarcodigoTipoVivienda;
	}

	public void setActivarcodigoTipoVivienda(Boolean activarcodigoTipoVivienda) {
		this.activarcodigoTipoVivienda= activarcodigoTipoVivienda;
	}

	public Border setResaltarnombreTipoVivienda(ParametroGeneralUsuario parametroGeneralUsuario/*TipoViviendaBeanSwingJInternalFrame tipoviviendaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoviviendaBeanSwingJInternalFrame.jTtoolBarTipoVivienda.setBorder(borderResaltar);
		
		this.resaltarnombreTipoVivienda= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoVivienda() {
		return this.resaltarnombreTipoVivienda;
	}

	public void setResaltarnombreTipoVivienda(Border borderResaltar) {
		this.resaltarnombreTipoVivienda= borderResaltar;
	}

	public Boolean getMostrarnombreTipoVivienda() {
		return this.mostrarnombreTipoVivienda;
	}

	public void setMostrarnombreTipoVivienda(Boolean mostrarnombreTipoVivienda) {
		this.mostrarnombreTipoVivienda= mostrarnombreTipoVivienda;
	}

	public Boolean getActivarnombreTipoVivienda() {
		return this.activarnombreTipoVivienda;
	}

	public void setActivarnombreTipoVivienda(Boolean activarnombreTipoVivienda) {
		this.activarnombreTipoVivienda= activarnombreTipoVivienda;
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
		
		
		this.setMostraridTipoVivienda(esInicial);
		this.setMostrarid_empresaTipoVivienda(esInicial);
		this.setMostrarcodigoTipoVivienda(esInicial);
		this.setMostrarnombreTipoVivienda(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoViviendaConstantesFunciones.ID)) {
				this.setMostraridTipoVivienda(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoViviendaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoVivienda(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoViviendaConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoVivienda(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoViviendaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoVivienda(esAsigna);
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
		
		
		this.setActivaridTipoVivienda(esInicial);
		this.setActivarid_empresaTipoVivienda(esInicial);
		this.setActivarcodigoTipoVivienda(esInicial);
		this.setActivarnombreTipoVivienda(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoViviendaConstantesFunciones.ID)) {
				this.setActivaridTipoVivienda(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoViviendaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoVivienda(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoViviendaConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoVivienda(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoViviendaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoVivienda(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoViviendaBeanSwingJInternalFrame tipoviviendaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoVivienda(esInicial);
		this.setResaltarid_empresaTipoVivienda(esInicial);
		this.setResaltarcodigoTipoVivienda(esInicial);
		this.setResaltarnombreTipoVivienda(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoViviendaConstantesFunciones.ID)) {
				this.setResaltaridTipoVivienda(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoViviendaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoVivienda(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoViviendaConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoVivienda(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoViviendaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoVivienda(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarDireccionTipoVivienda=null;

	public Border getResaltarDireccionTipoVivienda() {
		return this.resaltarDireccionTipoVivienda;
	}

	public void setResaltarDireccionTipoVivienda(Border borderResaltarDireccion) {
		if(borderResaltarDireccion!=null) {
			this.resaltarDireccionTipoVivienda= borderResaltarDireccion;
		}
	}

	public Border setResaltarDireccionTipoVivienda(ParametroGeneralUsuario parametroGeneralUsuario/*TipoViviendaBeanSwingJInternalFrame tipoviviendaBeanSwingJInternalFrame*/) {
		Border borderResaltarDireccion=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoviviendaBeanSwingJInternalFrame.jTtoolBarTipoVivienda.setBorder(borderResaltarDireccion);
			
		this.resaltarDireccionTipoVivienda= borderResaltarDireccion;

		 return borderResaltarDireccion;
	}



	public Boolean mostrarDireccionTipoVivienda=true;

	public Boolean getMostrarDireccionTipoVivienda() {
		return this.mostrarDireccionTipoVivienda;
	}

	public void setMostrarDireccionTipoVivienda(Boolean visibilidadResaltarDireccion) {
		this.mostrarDireccionTipoVivienda= visibilidadResaltarDireccion;
	}



	public Boolean activarDireccionTipoVivienda=true;

	public Boolean gethabilitarResaltarDireccionTipoVivienda() {
		return this.activarDireccionTipoVivienda;
	}

	public void setActivarDireccionTipoVivienda(Boolean habilitarResaltarDireccion) {
		this.activarDireccionTipoVivienda= habilitarResaltarDireccion;
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

		this.setMostrarDireccionTipoVivienda(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Direccion.class)) {
				this.setMostrarDireccionTipoVivienda(esAsigna);
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

		this.setActivarDireccionTipoVivienda(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Direccion.class)) {
				this.setActivarDireccionTipoVivienda(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoViviendaBeanSwingJInternalFrame tipoviviendaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarDireccionTipoVivienda(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Direccion.class)) {
				this.setResaltarDireccionTipoVivienda(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdEmpresaTipoVivienda=true;

	public Boolean getMostrarFK_IdEmpresaTipoVivienda() {
		return this.mostrarFK_IdEmpresaTipoVivienda;
	}

	public void setMostrarFK_IdEmpresaTipoVivienda(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoVivienda= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaTipoVivienda=true;

	public Boolean getActivarFK_IdEmpresaTipoVivienda() {
		return this.activarFK_IdEmpresaTipoVivienda;
	}

	public void setActivarFK_IdEmpresaTipoVivienda(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoVivienda= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaTipoVivienda=null;

	public Border getResaltarFK_IdEmpresaTipoVivienda() {
		return this.resaltarFK_IdEmpresaTipoVivienda;
	}

	public void setResaltarFK_IdEmpresaTipoVivienda(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoVivienda= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoVivienda(ParametroGeneralUsuario parametroGeneralUsuario/*TipoViviendaBeanSwingJInternalFrame tipoviviendaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoVivienda= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}