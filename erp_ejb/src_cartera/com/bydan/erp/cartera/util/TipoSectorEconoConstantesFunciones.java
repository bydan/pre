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


import com.bydan.erp.cartera.util.TipoSectorEconoConstantesFunciones;
import com.bydan.erp.cartera.util.TipoSectorEconoParameterReturnGeneral;
//import com.bydan.erp.cartera.util.TipoSectorEconoParameterGeneral;

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
final public class TipoSectorEconoConstantesFunciones extends TipoSectorEconoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoSectorEcono";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoSectorEcono"+TipoSectorEconoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoSectorEconoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoSectorEconoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoSectorEconoConstantesFunciones.SCHEMA+"_"+TipoSectorEconoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoSectorEconoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoSectorEconoConstantesFunciones.SCHEMA+"_"+TipoSectorEconoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoSectorEconoConstantesFunciones.SCHEMA+"_"+TipoSectorEconoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoSectorEconoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoSectorEconoConstantesFunciones.SCHEMA+"_"+TipoSectorEconoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoSectorEconoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoSectorEconoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoSectorEconoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoSectorEconoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoSectorEconoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoSectorEconoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoSectorEconoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoSectorEconoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoSectorEconoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoSectorEconoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Sector Econos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Sector Econo";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Sector Econo";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoSectorEcono";
	public static final String OBJECTNAME="tiposectorecono";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="tipo_sector_econo";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tiposectorecono from "+TipoSectorEconoConstantesFunciones.SPERSISTENCENAME+" tiposectorecono";
	public static String QUERYSELECTNATIVE="select "+TipoSectorEconoConstantesFunciones.SCHEMA+"."+TipoSectorEconoConstantesFunciones.TABLENAME+".id,"+TipoSectorEconoConstantesFunciones.SCHEMA+"."+TipoSectorEconoConstantesFunciones.TABLENAME+".version_row,"+TipoSectorEconoConstantesFunciones.SCHEMA+"."+TipoSectorEconoConstantesFunciones.TABLENAME+".id_empresa,"+TipoSectorEconoConstantesFunciones.SCHEMA+"."+TipoSectorEconoConstantesFunciones.TABLENAME+".codigo,"+TipoSectorEconoConstantesFunciones.SCHEMA+"."+TipoSectorEconoConstantesFunciones.TABLENAME+".nombre from "+TipoSectorEconoConstantesFunciones.SCHEMA+"."+TipoSectorEconoConstantesFunciones.TABLENAME;//+" as "+TipoSectorEconoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoSectorEconoConstantesFuncionesAdditional tiposectoreconoConstantesFuncionesAdditional=null;
	
	public TipoSectorEconoConstantesFuncionesAdditional getTipoSectorEconoConstantesFuncionesAdditional() {
		return this.tiposectoreconoConstantesFuncionesAdditional;
	}
	
	public void setTipoSectorEconoConstantesFuncionesAdditional(TipoSectorEconoConstantesFuncionesAdditional tiposectoreconoConstantesFuncionesAdditional) {
		try {
			this.tiposectoreconoConstantesFuncionesAdditional=tiposectoreconoConstantesFuncionesAdditional;
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
	
	public static String getTipoSectorEconoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoSectorEconoConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoSectorEconoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoSectorEconoConstantesFunciones.CODIGO)) {sLabelColumna=TipoSectorEconoConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoSectorEconoConstantesFunciones.NOMBRE)) {sLabelColumna=TipoSectorEconoConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getTipoSectorEconoDescripcion(TipoSectorEcono tiposectorecono) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tiposectorecono !=null/* && tiposectorecono.getId()!=0*/) {
			sDescripcion=tiposectorecono.getcodigo();//tiposectoreconotiposectorecono.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoSectorEconoDescripcionDetallado(TipoSectorEcono tiposectorecono) {
		String sDescripcion="";
			
		sDescripcion+=TipoSectorEconoConstantesFunciones.ID+"=";
		sDescripcion+=tiposectorecono.getId().toString()+",";
		sDescripcion+=TipoSectorEconoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tiposectorecono.getVersionRow().toString()+",";
		sDescripcion+=TipoSectorEconoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tiposectorecono.getid_empresa().toString()+",";
		sDescripcion+=TipoSectorEconoConstantesFunciones.CODIGO+"=";
		sDescripcion+=tiposectorecono.getcodigo()+",";
		sDescripcion+=TipoSectorEconoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tiposectorecono.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoSectorEconoDescripcion(TipoSectorEcono tiposectorecono,String sValor) throws Exception {			
		if(tiposectorecono !=null) {
			tiposectorecono.setcodigo(sValor);;//tiposectoreconotiposectorecono.getcodigo().trim();
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
		} else if(sNombreIndice.equals("BusquedaPorCodigo")) {
			sNombreIndice="Tipo=  Por Codigo";
		} else if(sNombreIndice.equals("BusquedaPorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
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

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTipoSectorEcono(TipoSectorEcono tiposectorecono,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tiposectorecono.setcodigo(tiposectorecono.getcodigo().trim());
		tiposectorecono.setnombre(tiposectorecono.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoSectorEconos(List<TipoSectorEcono> tiposectoreconos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoSectorEcono tiposectorecono: tiposectoreconos) {
			tiposectorecono.setcodigo(tiposectorecono.getcodigo().trim());
			tiposectorecono.setnombre(tiposectorecono.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoSectorEcono(TipoSectorEcono tiposectorecono,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tiposectorecono.getConCambioAuxiliar()) {
			tiposectorecono.setIsDeleted(tiposectorecono.getIsDeletedAuxiliar());	
			tiposectorecono.setIsNew(tiposectorecono.getIsNewAuxiliar());	
			tiposectorecono.setIsChanged(tiposectorecono.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tiposectorecono.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tiposectorecono.setIsDeletedAuxiliar(false);	
			tiposectorecono.setIsNewAuxiliar(false);	
			tiposectorecono.setIsChangedAuxiliar(false);
			
			tiposectorecono.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoSectorEconos(List<TipoSectorEcono> tiposectoreconos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoSectorEcono tiposectorecono : tiposectoreconos) {
			if(conAsignarBase && tiposectorecono.getConCambioAuxiliar()) {
				tiposectorecono.setIsDeleted(tiposectorecono.getIsDeletedAuxiliar());	
				tiposectorecono.setIsNew(tiposectorecono.getIsNewAuxiliar());	
				tiposectorecono.setIsChanged(tiposectorecono.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tiposectorecono.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tiposectorecono.setIsDeletedAuxiliar(false);	
				tiposectorecono.setIsNewAuxiliar(false);	
				tiposectorecono.setIsChangedAuxiliar(false);
				
				tiposectorecono.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoSectorEcono(TipoSectorEcono tiposectorecono,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoSectorEconos(List<TipoSectorEcono> tiposectoreconos,Boolean conEnteros) throws Exception  {
		
		for(TipoSectorEcono tiposectorecono: tiposectoreconos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoSectorEcono(List<TipoSectorEcono> tiposectoreconos,TipoSectorEcono tiposectoreconoAux) throws Exception  {
		TipoSectorEconoConstantesFunciones.InicializarValoresTipoSectorEcono(tiposectoreconoAux,true);
		
		for(TipoSectorEcono tiposectorecono: tiposectoreconos) {
			if(tiposectorecono.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoSectorEcono(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoSectorEconoConstantesFunciones.getArrayColumnasGlobalesTipoSectorEcono(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoSectorEcono(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoSectorEconoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoSectorEconoConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoSectorEcono(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoSectorEcono> tiposectoreconos,TipoSectorEcono tiposectorecono,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoSectorEcono tiposectoreconoAux: tiposectoreconos) {
			if(tiposectoreconoAux!=null && tiposectorecono!=null) {
				if((tiposectoreconoAux.getId()==null && tiposectorecono.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tiposectoreconoAux.getId()!=null && tiposectorecono.getId()!=null){
					if(tiposectoreconoAux.getId().equals(tiposectorecono.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoSectorEcono(List<TipoSectorEcono> tiposectoreconos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoSectorEcono tiposectorecono: tiposectoreconos) {			
			if(tiposectorecono.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoSectorEcono() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoSectorEconoConstantesFunciones.LABEL_ID, TipoSectorEconoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoSectorEconoConstantesFunciones.LABEL_VERSIONROW, TipoSectorEconoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoSectorEconoConstantesFunciones.LABEL_IDEMPRESA, TipoSectorEconoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoSectorEconoConstantesFunciones.LABEL_CODIGO, TipoSectorEconoConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoSectorEconoConstantesFunciones.LABEL_NOMBRE, TipoSectorEconoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoSectorEcono() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoSectorEconoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoSectorEconoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoSectorEconoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoSectorEconoConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoSectorEconoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoSectorEcono() throws Exception  {
		return TipoSectorEconoConstantesFunciones.getTiposSeleccionarTipoSectorEcono(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoSectorEcono(Boolean conFk) throws Exception  {
		return TipoSectorEconoConstantesFunciones.getTiposSeleccionarTipoSectorEcono(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoSectorEcono(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoSectorEconoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoSectorEconoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoSectorEconoConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoSectorEconoConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoSectorEconoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoSectorEconoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoSectorEcono(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoSectorEcono(TipoSectorEcono tiposectoreconoAux) throws Exception {
		
			tiposectoreconoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tiposectoreconoAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoSectorEcono(List<TipoSectorEcono> tiposectoreconosTemp) throws Exception {
		for(TipoSectorEcono tiposectoreconoAux:tiposectoreconosTemp) {
			
			tiposectoreconoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tiposectoreconoAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoSectorEcono(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoSectorEcono(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoSectorEcono(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoSectorEconoConstantesFunciones.getClassesRelationshipsOfTipoSectorEcono(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoSectorEcono(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(ReferenciaComercial.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(ReferenciaComercial.class)) {
						classes.add(new Classe(ReferenciaComercial.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoSectorEcono(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoSectorEconoConstantesFunciones.getClassesRelationshipsFromStringsOfTipoSectorEcono(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoSectorEcono(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(ReferenciaComercial.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ReferenciaComercial.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(ReferenciaComercial.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ReferenciaComercial.class)); continue;
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
	public static void actualizarLista(TipoSectorEcono tiposectorecono,List<TipoSectorEcono> tiposectoreconos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoSectorEcono tiposectoreconoEncontrado=null;
			
			for(TipoSectorEcono tiposectoreconoLocal:tiposectoreconos) {
				if(tiposectoreconoLocal.getId().equals(tiposectorecono.getId())) {
					tiposectoreconoEncontrado=tiposectoreconoLocal;
					
					tiposectoreconoLocal.setIsChanged(tiposectorecono.getIsChanged());
					tiposectoreconoLocal.setIsNew(tiposectorecono.getIsNew());
					tiposectoreconoLocal.setIsDeleted(tiposectorecono.getIsDeleted());
					
					tiposectoreconoLocal.setGeneralEntityOriginal(tiposectorecono.getGeneralEntityOriginal());
					
					tiposectoreconoLocal.setId(tiposectorecono.getId());	
					tiposectoreconoLocal.setVersionRow(tiposectorecono.getVersionRow());	
					tiposectoreconoLocal.setid_empresa(tiposectorecono.getid_empresa());	
					tiposectoreconoLocal.setcodigo(tiposectorecono.getcodigo());	
					tiposectoreconoLocal.setnombre(tiposectorecono.getnombre());	
					
					
					tiposectoreconoLocal.setReferenciaComercials(tiposectorecono.getReferenciaComercials());
					
					existe=true;
					break;
				}
			}
			
			if(!tiposectorecono.getIsDeleted()) {
				if(!existe) {
					tiposectoreconos.add(tiposectorecono);
				}
			} else {
				if(tiposectoreconoEncontrado!=null && permiteQuitar)  {
					tiposectoreconos.remove(tiposectoreconoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoSectorEcono tiposectorecono,List<TipoSectorEcono> tiposectoreconos) throws Exception {
		try	{			
			for(TipoSectorEcono tiposectoreconoLocal:tiposectoreconos) {
				if(tiposectoreconoLocal.getId().equals(tiposectorecono.getId())) {
					tiposectoreconoLocal.setIsSelected(tiposectorecono.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoSectorEcono(List<TipoSectorEcono> tiposectoreconosAux) throws Exception {
		//this.tiposectoreconosAux=tiposectoreconosAux;
		
		for(TipoSectorEcono tiposectoreconoAux:tiposectoreconosAux) {
			if(tiposectoreconoAux.getIsChanged()) {
				tiposectoreconoAux.setIsChanged(false);
			}		
			
			if(tiposectoreconoAux.getIsNew()) {
				tiposectoreconoAux.setIsNew(false);
			}	
			
			if(tiposectoreconoAux.getIsDeleted()) {
				tiposectoreconoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoSectorEcono(TipoSectorEcono tiposectoreconoAux) throws Exception {
		//this.tiposectoreconoAux=tiposectoreconoAux;
		
			if(tiposectoreconoAux.getIsChanged()) {
				tiposectoreconoAux.setIsChanged(false);
			}		
			
			if(tiposectoreconoAux.getIsNew()) {
				tiposectoreconoAux.setIsNew(false);
			}	
			
			if(tiposectoreconoAux.getIsDeleted()) {
				tiposectoreconoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoSectorEcono tiposectoreconoAsignar,TipoSectorEcono tiposectorecono) throws Exception {
		tiposectoreconoAsignar.setId(tiposectorecono.getId());	
		tiposectoreconoAsignar.setVersionRow(tiposectorecono.getVersionRow());	
		tiposectoreconoAsignar.setid_empresa(tiposectorecono.getid_empresa());
		tiposectoreconoAsignar.setempresa_descripcion(tiposectorecono.getempresa_descripcion());	
		tiposectoreconoAsignar.setcodigo(tiposectorecono.getcodigo());	
		tiposectoreconoAsignar.setnombre(tiposectorecono.getnombre());	
	}
	
	public static void inicializarTipoSectorEcono(TipoSectorEcono tiposectorecono) throws Exception {
		try {
				tiposectorecono.setId(0L);	
					
				tiposectorecono.setid_empresa(-1L);	
				tiposectorecono.setcodigo("");	
				tiposectorecono.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoSectorEcono(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoSectorEconoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoSectorEconoConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoSectorEconoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoSectorEcono(String sTipo,Row row,Workbook workbook,TipoSectorEcono tiposectorecono,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tiposectorecono.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tiposectorecono.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tiposectorecono.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoSectorEcono=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoSectorEcono() {
		return this.sFinalQueryTipoSectorEcono;
	}
	
	public void setsFinalQueryTipoSectorEcono(String sFinalQueryTipoSectorEcono) {
		this.sFinalQueryTipoSectorEcono= sFinalQueryTipoSectorEcono;
	}
	
	public Border resaltarSeleccionarTipoSectorEcono=null;
	
	public Border setResaltarSeleccionarTipoSectorEcono(ParametroGeneralUsuario parametroGeneralUsuario/*TipoSectorEconoBeanSwingJInternalFrame tiposectoreconoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tiposectoreconoBeanSwingJInternalFrame.jTtoolBarTipoSectorEcono.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoSectorEcono= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoSectorEcono() {
		return this.resaltarSeleccionarTipoSectorEcono;
	}
	
	public void setResaltarSeleccionarTipoSectorEcono(Border borderResaltarSeleccionarTipoSectorEcono) {
		this.resaltarSeleccionarTipoSectorEcono= borderResaltarSeleccionarTipoSectorEcono;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoSectorEcono=null;
	public Boolean mostraridTipoSectorEcono=true;
	public Boolean activaridTipoSectorEcono=true;

	public Border resaltarid_empresaTipoSectorEcono=null;
	public Boolean mostrarid_empresaTipoSectorEcono=true;
	public Boolean activarid_empresaTipoSectorEcono=true;
	public Boolean cargarid_empresaTipoSectorEcono=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoSectorEcono=false;//ConEventDepend=true

	public Border resaltarcodigoTipoSectorEcono=null;
	public Boolean mostrarcodigoTipoSectorEcono=true;
	public Boolean activarcodigoTipoSectorEcono=true;

	public Border resaltarnombreTipoSectorEcono=null;
	public Boolean mostrarnombreTipoSectorEcono=true;
	public Boolean activarnombreTipoSectorEcono=true;

	
	

	public Border setResaltaridTipoSectorEcono(ParametroGeneralUsuario parametroGeneralUsuario/*TipoSectorEconoBeanSwingJInternalFrame tiposectoreconoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiposectoreconoBeanSwingJInternalFrame.jTtoolBarTipoSectorEcono.setBorder(borderResaltar);
		
		this.resaltaridTipoSectorEcono= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoSectorEcono() {
		return this.resaltaridTipoSectorEcono;
	}

	public void setResaltaridTipoSectorEcono(Border borderResaltar) {
		this.resaltaridTipoSectorEcono= borderResaltar;
	}

	public Boolean getMostraridTipoSectorEcono() {
		return this.mostraridTipoSectorEcono;
	}

	public void setMostraridTipoSectorEcono(Boolean mostraridTipoSectorEcono) {
		this.mostraridTipoSectorEcono= mostraridTipoSectorEcono;
	}

	public Boolean getActivaridTipoSectorEcono() {
		return this.activaridTipoSectorEcono;
	}

	public void setActivaridTipoSectorEcono(Boolean activaridTipoSectorEcono) {
		this.activaridTipoSectorEcono= activaridTipoSectorEcono;
	}

	public Border setResaltarid_empresaTipoSectorEcono(ParametroGeneralUsuario parametroGeneralUsuario/*TipoSectorEconoBeanSwingJInternalFrame tiposectoreconoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiposectoreconoBeanSwingJInternalFrame.jTtoolBarTipoSectorEcono.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoSectorEcono= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoSectorEcono() {
		return this.resaltarid_empresaTipoSectorEcono;
	}

	public void setResaltarid_empresaTipoSectorEcono(Border borderResaltar) {
		this.resaltarid_empresaTipoSectorEcono= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoSectorEcono() {
		return this.mostrarid_empresaTipoSectorEcono;
	}

	public void setMostrarid_empresaTipoSectorEcono(Boolean mostrarid_empresaTipoSectorEcono) {
		this.mostrarid_empresaTipoSectorEcono= mostrarid_empresaTipoSectorEcono;
	}

	public Boolean getActivarid_empresaTipoSectorEcono() {
		return this.activarid_empresaTipoSectorEcono;
	}

	public void setActivarid_empresaTipoSectorEcono(Boolean activarid_empresaTipoSectorEcono) {
		this.activarid_empresaTipoSectorEcono= activarid_empresaTipoSectorEcono;
	}

	public Boolean getCargarid_empresaTipoSectorEcono() {
		return this.cargarid_empresaTipoSectorEcono;
	}

	public void setCargarid_empresaTipoSectorEcono(Boolean cargarid_empresaTipoSectorEcono) {
		this.cargarid_empresaTipoSectorEcono= cargarid_empresaTipoSectorEcono;
	}

	public Border setResaltarcodigoTipoSectorEcono(ParametroGeneralUsuario parametroGeneralUsuario/*TipoSectorEconoBeanSwingJInternalFrame tiposectoreconoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiposectoreconoBeanSwingJInternalFrame.jTtoolBarTipoSectorEcono.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoSectorEcono= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoSectorEcono() {
		return this.resaltarcodigoTipoSectorEcono;
	}

	public void setResaltarcodigoTipoSectorEcono(Border borderResaltar) {
		this.resaltarcodigoTipoSectorEcono= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoSectorEcono() {
		return this.mostrarcodigoTipoSectorEcono;
	}

	public void setMostrarcodigoTipoSectorEcono(Boolean mostrarcodigoTipoSectorEcono) {
		this.mostrarcodigoTipoSectorEcono= mostrarcodigoTipoSectorEcono;
	}

	public Boolean getActivarcodigoTipoSectorEcono() {
		return this.activarcodigoTipoSectorEcono;
	}

	public void setActivarcodigoTipoSectorEcono(Boolean activarcodigoTipoSectorEcono) {
		this.activarcodigoTipoSectorEcono= activarcodigoTipoSectorEcono;
	}

	public Border setResaltarnombreTipoSectorEcono(ParametroGeneralUsuario parametroGeneralUsuario/*TipoSectorEconoBeanSwingJInternalFrame tiposectoreconoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiposectoreconoBeanSwingJInternalFrame.jTtoolBarTipoSectorEcono.setBorder(borderResaltar);
		
		this.resaltarnombreTipoSectorEcono= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoSectorEcono() {
		return this.resaltarnombreTipoSectorEcono;
	}

	public void setResaltarnombreTipoSectorEcono(Border borderResaltar) {
		this.resaltarnombreTipoSectorEcono= borderResaltar;
	}

	public Boolean getMostrarnombreTipoSectorEcono() {
		return this.mostrarnombreTipoSectorEcono;
	}

	public void setMostrarnombreTipoSectorEcono(Boolean mostrarnombreTipoSectorEcono) {
		this.mostrarnombreTipoSectorEcono= mostrarnombreTipoSectorEcono;
	}

	public Boolean getActivarnombreTipoSectorEcono() {
		return this.activarnombreTipoSectorEcono;
	}

	public void setActivarnombreTipoSectorEcono(Boolean activarnombreTipoSectorEcono) {
		this.activarnombreTipoSectorEcono= activarnombreTipoSectorEcono;
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
		
		
		this.setMostraridTipoSectorEcono(esInicial);
		this.setMostrarid_empresaTipoSectorEcono(esInicial);
		this.setMostrarcodigoTipoSectorEcono(esInicial);
		this.setMostrarnombreTipoSectorEcono(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoSectorEconoConstantesFunciones.ID)) {
				this.setMostraridTipoSectorEcono(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoSectorEconoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoSectorEcono(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoSectorEconoConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoSectorEcono(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoSectorEconoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoSectorEcono(esAsigna);
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
		
		
		this.setActivaridTipoSectorEcono(esInicial);
		this.setActivarid_empresaTipoSectorEcono(esInicial);
		this.setActivarcodigoTipoSectorEcono(esInicial);
		this.setActivarnombreTipoSectorEcono(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoSectorEconoConstantesFunciones.ID)) {
				this.setActivaridTipoSectorEcono(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoSectorEconoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoSectorEcono(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoSectorEconoConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoSectorEcono(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoSectorEconoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoSectorEcono(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoSectorEconoBeanSwingJInternalFrame tiposectoreconoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoSectorEcono(esInicial);
		this.setResaltarid_empresaTipoSectorEcono(esInicial);
		this.setResaltarcodigoTipoSectorEcono(esInicial);
		this.setResaltarnombreTipoSectorEcono(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoSectorEconoConstantesFunciones.ID)) {
				this.setResaltaridTipoSectorEcono(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoSectorEconoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoSectorEcono(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoSectorEconoConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoSectorEcono(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoSectorEconoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoSectorEcono(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarReferenciaComercialTipoSectorEcono=null;

	public Border getResaltarReferenciaComercialTipoSectorEcono() {
		return this.resaltarReferenciaComercialTipoSectorEcono;
	}

	public void setResaltarReferenciaComercialTipoSectorEcono(Border borderResaltarReferenciaComercial) {
		if(borderResaltarReferenciaComercial!=null) {
			this.resaltarReferenciaComercialTipoSectorEcono= borderResaltarReferenciaComercial;
		}
	}

	public Border setResaltarReferenciaComercialTipoSectorEcono(ParametroGeneralUsuario parametroGeneralUsuario/*TipoSectorEconoBeanSwingJInternalFrame tiposectoreconoBeanSwingJInternalFrame*/) {
		Border borderResaltarReferenciaComercial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tiposectoreconoBeanSwingJInternalFrame.jTtoolBarTipoSectorEcono.setBorder(borderResaltarReferenciaComercial);
			
		this.resaltarReferenciaComercialTipoSectorEcono= borderResaltarReferenciaComercial;

		 return borderResaltarReferenciaComercial;
	}



	public Boolean mostrarReferenciaComercialTipoSectorEcono=true;

	public Boolean getMostrarReferenciaComercialTipoSectorEcono() {
		return this.mostrarReferenciaComercialTipoSectorEcono;
	}

	public void setMostrarReferenciaComercialTipoSectorEcono(Boolean visibilidadResaltarReferenciaComercial) {
		this.mostrarReferenciaComercialTipoSectorEcono= visibilidadResaltarReferenciaComercial;
	}



	public Boolean activarReferenciaComercialTipoSectorEcono=true;

	public Boolean gethabilitarResaltarReferenciaComercialTipoSectorEcono() {
		return this.activarReferenciaComercialTipoSectorEcono;
	}

	public void setActivarReferenciaComercialTipoSectorEcono(Boolean habilitarResaltarReferenciaComercial) {
		this.activarReferenciaComercialTipoSectorEcono= habilitarResaltarReferenciaComercial;
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

		this.setMostrarReferenciaComercialTipoSectorEcono(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ReferenciaComercial.class)) {
				this.setMostrarReferenciaComercialTipoSectorEcono(esAsigna);
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

		this.setActivarReferenciaComercialTipoSectorEcono(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ReferenciaComercial.class)) {
				this.setActivarReferenciaComercialTipoSectorEcono(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoSectorEconoBeanSwingJInternalFrame tiposectoreconoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarReferenciaComercialTipoSectorEcono(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ReferenciaComercial.class)) {
				this.setResaltarReferenciaComercialTipoSectorEcono(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorCodigoTipoSectorEcono=true;

	public Boolean getMostrarBusquedaPorCodigoTipoSectorEcono() {
		return this.mostrarBusquedaPorCodigoTipoSectorEcono;
	}

	public void setMostrarBusquedaPorCodigoTipoSectorEcono(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoTipoSectorEcono= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreTipoSectorEcono=true;

	public Boolean getMostrarBusquedaPorNombreTipoSectorEcono() {
		return this.mostrarBusquedaPorNombreTipoSectorEcono;
	}

	public void setMostrarBusquedaPorNombreTipoSectorEcono(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreTipoSectorEcono= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaTipoSectorEcono=true;

	public Boolean getMostrarFK_IdEmpresaTipoSectorEcono() {
		return this.mostrarFK_IdEmpresaTipoSectorEcono;
	}

	public void setMostrarFK_IdEmpresaTipoSectorEcono(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoSectorEcono= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorCodigoTipoSectorEcono=true;

	public Boolean getActivarBusquedaPorCodigoTipoSectorEcono() {
		return this.activarBusquedaPorCodigoTipoSectorEcono;
	}

	public void setActivarBusquedaPorCodigoTipoSectorEcono(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoTipoSectorEcono= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreTipoSectorEcono=true;

	public Boolean getActivarBusquedaPorNombreTipoSectorEcono() {
		return this.activarBusquedaPorNombreTipoSectorEcono;
	}

	public void setActivarBusquedaPorNombreTipoSectorEcono(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreTipoSectorEcono= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaTipoSectorEcono=true;

	public Boolean getActivarFK_IdEmpresaTipoSectorEcono() {
		return this.activarFK_IdEmpresaTipoSectorEcono;
	}

	public void setActivarFK_IdEmpresaTipoSectorEcono(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoSectorEcono= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorCodigoTipoSectorEcono=null;

	public Border getResaltarBusquedaPorCodigoTipoSectorEcono() {
		return this.resaltarBusquedaPorCodigoTipoSectorEcono;
	}

	public void setResaltarBusquedaPorCodigoTipoSectorEcono(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoTipoSectorEcono= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoTipoSectorEcono(ParametroGeneralUsuario parametroGeneralUsuario/*TipoSectorEconoBeanSwingJInternalFrame tiposectoreconoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoTipoSectorEcono= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreTipoSectorEcono=null;

	public Border getResaltarBusquedaPorNombreTipoSectorEcono() {
		return this.resaltarBusquedaPorNombreTipoSectorEcono;
	}

	public void setResaltarBusquedaPorNombreTipoSectorEcono(Border borderResaltar) {
		this.resaltarBusquedaPorNombreTipoSectorEcono= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreTipoSectorEcono(ParametroGeneralUsuario parametroGeneralUsuario/*TipoSectorEconoBeanSwingJInternalFrame tiposectoreconoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreTipoSectorEcono= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaTipoSectorEcono=null;

	public Border getResaltarFK_IdEmpresaTipoSectorEcono() {
		return this.resaltarFK_IdEmpresaTipoSectorEcono;
	}

	public void setResaltarFK_IdEmpresaTipoSectorEcono(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoSectorEcono= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoSectorEcono(ParametroGeneralUsuario parametroGeneralUsuario/*TipoSectorEconoBeanSwingJInternalFrame tiposectoreconoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoSectorEcono= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}