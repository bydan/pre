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


import com.bydan.erp.cartera.util.TipoNacionalidadConstantesFunciones;
import com.bydan.erp.cartera.util.TipoNacionalidadParameterReturnGeneral;
//import com.bydan.erp.cartera.util.TipoNacionalidadParameterGeneral;

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
final public class TipoNacionalidadConstantesFunciones extends TipoNacionalidadConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoNacionalidad";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoNacionalidad"+TipoNacionalidadConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoNacionalidadHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoNacionalidadHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoNacionalidadConstantesFunciones.SCHEMA+"_"+TipoNacionalidadConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoNacionalidadHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoNacionalidadConstantesFunciones.SCHEMA+"_"+TipoNacionalidadConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoNacionalidadConstantesFunciones.SCHEMA+"_"+TipoNacionalidadConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoNacionalidadHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoNacionalidadConstantesFunciones.SCHEMA+"_"+TipoNacionalidadConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoNacionalidadConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoNacionalidadHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoNacionalidadConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoNacionalidadConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoNacionalidadHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoNacionalidadConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoNacionalidadConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoNacionalidadConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoNacionalidadConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoNacionalidadConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Nacionalidades";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Tipo Nacionalidad";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Nacionalidad";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoNacionalidad";
	public static final String OBJECTNAME="tiponacionalidad";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="tipo_nacionalidad";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tiponacionalidad from "+TipoNacionalidadConstantesFunciones.SPERSISTENCENAME+" tiponacionalidad";
	public static String QUERYSELECTNATIVE="select "+TipoNacionalidadConstantesFunciones.SCHEMA+"."+TipoNacionalidadConstantesFunciones.TABLENAME+".id,"+TipoNacionalidadConstantesFunciones.SCHEMA+"."+TipoNacionalidadConstantesFunciones.TABLENAME+".version_row,"+TipoNacionalidadConstantesFunciones.SCHEMA+"."+TipoNacionalidadConstantesFunciones.TABLENAME+".id_empresa,"+TipoNacionalidadConstantesFunciones.SCHEMA+"."+TipoNacionalidadConstantesFunciones.TABLENAME+".codigo,"+TipoNacionalidadConstantesFunciones.SCHEMA+"."+TipoNacionalidadConstantesFunciones.TABLENAME+".nombre from "+TipoNacionalidadConstantesFunciones.SCHEMA+"."+TipoNacionalidadConstantesFunciones.TABLENAME;//+" as "+TipoNacionalidadConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoNacionalidadConstantesFuncionesAdditional tiponacionalidadConstantesFuncionesAdditional=null;
	
	public TipoNacionalidadConstantesFuncionesAdditional getTipoNacionalidadConstantesFuncionesAdditional() {
		return this.tiponacionalidadConstantesFuncionesAdditional;
	}
	
	public void setTipoNacionalidadConstantesFuncionesAdditional(TipoNacionalidadConstantesFuncionesAdditional tiponacionalidadConstantesFuncionesAdditional) {
		try {
			this.tiponacionalidadConstantesFuncionesAdditional=tiponacionalidadConstantesFuncionesAdditional;
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
	
	public static String getTipoNacionalidadLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoNacionalidadConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoNacionalidadConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoNacionalidadConstantesFunciones.CODIGO)) {sLabelColumna=TipoNacionalidadConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoNacionalidadConstantesFunciones.NOMBRE)) {sLabelColumna=TipoNacionalidadConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getTipoNacionalidadDescripcion(TipoNacionalidad tiponacionalidad) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tiponacionalidad !=null/* && tiponacionalidad.getId()!=0*/) {
			sDescripcion=tiponacionalidad.getcodigo();//tiponacionalidadtiponacionalidad.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoNacionalidadDescripcionDetallado(TipoNacionalidad tiponacionalidad) {
		String sDescripcion="";
			
		sDescripcion+=TipoNacionalidadConstantesFunciones.ID+"=";
		sDescripcion+=tiponacionalidad.getId().toString()+",";
		sDescripcion+=TipoNacionalidadConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tiponacionalidad.getVersionRow().toString()+",";
		sDescripcion+=TipoNacionalidadConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tiponacionalidad.getid_empresa().toString()+",";
		sDescripcion+=TipoNacionalidadConstantesFunciones.CODIGO+"=";
		sDescripcion+=tiponacionalidad.getcodigo()+",";
		sDescripcion+=TipoNacionalidadConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tiponacionalidad.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoNacionalidadDescripcion(TipoNacionalidad tiponacionalidad,String sValor) throws Exception {			
		if(tiponacionalidad !=null) {
			tiponacionalidad.setcodigo(sValor);;//tiponacionalidadtiponacionalidad.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoNacionalidad(TipoNacionalidad tiponacionalidad,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tiponacionalidad.setcodigo(tiponacionalidad.getcodigo().trim());
		tiponacionalidad.setnombre(tiponacionalidad.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoNacionalidads(List<TipoNacionalidad> tiponacionalidads,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoNacionalidad tiponacionalidad: tiponacionalidads) {
			tiponacionalidad.setcodigo(tiponacionalidad.getcodigo().trim());
			tiponacionalidad.setnombre(tiponacionalidad.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoNacionalidad(TipoNacionalidad tiponacionalidad,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tiponacionalidad.getConCambioAuxiliar()) {
			tiponacionalidad.setIsDeleted(tiponacionalidad.getIsDeletedAuxiliar());	
			tiponacionalidad.setIsNew(tiponacionalidad.getIsNewAuxiliar());	
			tiponacionalidad.setIsChanged(tiponacionalidad.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tiponacionalidad.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tiponacionalidad.setIsDeletedAuxiliar(false);	
			tiponacionalidad.setIsNewAuxiliar(false);	
			tiponacionalidad.setIsChangedAuxiliar(false);
			
			tiponacionalidad.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoNacionalidads(List<TipoNacionalidad> tiponacionalidads,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoNacionalidad tiponacionalidad : tiponacionalidads) {
			if(conAsignarBase && tiponacionalidad.getConCambioAuxiliar()) {
				tiponacionalidad.setIsDeleted(tiponacionalidad.getIsDeletedAuxiliar());	
				tiponacionalidad.setIsNew(tiponacionalidad.getIsNewAuxiliar());	
				tiponacionalidad.setIsChanged(tiponacionalidad.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tiponacionalidad.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tiponacionalidad.setIsDeletedAuxiliar(false);	
				tiponacionalidad.setIsNewAuxiliar(false);	
				tiponacionalidad.setIsChangedAuxiliar(false);
				
				tiponacionalidad.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoNacionalidad(TipoNacionalidad tiponacionalidad,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoNacionalidads(List<TipoNacionalidad> tiponacionalidads,Boolean conEnteros) throws Exception  {
		
		for(TipoNacionalidad tiponacionalidad: tiponacionalidads) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoNacionalidad(List<TipoNacionalidad> tiponacionalidads,TipoNacionalidad tiponacionalidadAux) throws Exception  {
		TipoNacionalidadConstantesFunciones.InicializarValoresTipoNacionalidad(tiponacionalidadAux,true);
		
		for(TipoNacionalidad tiponacionalidad: tiponacionalidads) {
			if(tiponacionalidad.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoNacionalidad(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoNacionalidadConstantesFunciones.getArrayColumnasGlobalesTipoNacionalidad(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoNacionalidad(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoNacionalidadConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoNacionalidadConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoNacionalidad(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoNacionalidad> tiponacionalidads,TipoNacionalidad tiponacionalidad,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoNacionalidad tiponacionalidadAux: tiponacionalidads) {
			if(tiponacionalidadAux!=null && tiponacionalidad!=null) {
				if((tiponacionalidadAux.getId()==null && tiponacionalidad.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tiponacionalidadAux.getId()!=null && tiponacionalidad.getId()!=null){
					if(tiponacionalidadAux.getId().equals(tiponacionalidad.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoNacionalidad(List<TipoNacionalidad> tiponacionalidads) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoNacionalidad tiponacionalidad: tiponacionalidads) {			
			if(tiponacionalidad.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoNacionalidad() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoNacionalidadConstantesFunciones.LABEL_ID, TipoNacionalidadConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoNacionalidadConstantesFunciones.LABEL_VERSIONROW, TipoNacionalidadConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoNacionalidadConstantesFunciones.LABEL_IDEMPRESA, TipoNacionalidadConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoNacionalidadConstantesFunciones.LABEL_CODIGO, TipoNacionalidadConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoNacionalidadConstantesFunciones.LABEL_NOMBRE, TipoNacionalidadConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoNacionalidad() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoNacionalidadConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoNacionalidadConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoNacionalidadConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoNacionalidadConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoNacionalidadConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoNacionalidad() throws Exception  {
		return TipoNacionalidadConstantesFunciones.getTiposSeleccionarTipoNacionalidad(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoNacionalidad(Boolean conFk) throws Exception  {
		return TipoNacionalidadConstantesFunciones.getTiposSeleccionarTipoNacionalidad(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoNacionalidad(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoNacionalidadConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoNacionalidadConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoNacionalidadConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoNacionalidadConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoNacionalidadConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoNacionalidadConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoNacionalidad(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoNacionalidad(TipoNacionalidad tiponacionalidadAux) throws Exception {
		
			tiponacionalidadAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tiponacionalidadAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoNacionalidad(List<TipoNacionalidad> tiponacionalidadsTemp) throws Exception {
		for(TipoNacionalidad tiponacionalidadAux:tiponacionalidadsTemp) {
			
			tiponacionalidadAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tiponacionalidadAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoNacionalidad(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoNacionalidad(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoNacionalidad(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoNacionalidadConstantesFunciones.getClassesRelationshipsOfTipoNacionalidad(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoNacionalidad(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoNacionalidad(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoNacionalidadConstantesFunciones.getClassesRelationshipsFromStringsOfTipoNacionalidad(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoNacionalidad(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TipoNacionalidad tiponacionalidad,List<TipoNacionalidad> tiponacionalidads,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoNacionalidad tiponacionalidadEncontrado=null;
			
			for(TipoNacionalidad tiponacionalidadLocal:tiponacionalidads) {
				if(tiponacionalidadLocal.getId().equals(tiponacionalidad.getId())) {
					tiponacionalidadEncontrado=tiponacionalidadLocal;
					
					tiponacionalidadLocal.setIsChanged(tiponacionalidad.getIsChanged());
					tiponacionalidadLocal.setIsNew(tiponacionalidad.getIsNew());
					tiponacionalidadLocal.setIsDeleted(tiponacionalidad.getIsDeleted());
					
					tiponacionalidadLocal.setGeneralEntityOriginal(tiponacionalidad.getGeneralEntityOriginal());
					
					tiponacionalidadLocal.setId(tiponacionalidad.getId());	
					tiponacionalidadLocal.setVersionRow(tiponacionalidad.getVersionRow());	
					tiponacionalidadLocal.setid_empresa(tiponacionalidad.getid_empresa());	
					tiponacionalidadLocal.setcodigo(tiponacionalidad.getcodigo());	
					tiponacionalidadLocal.setnombre(tiponacionalidad.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tiponacionalidad.getIsDeleted()) {
				if(!existe) {
					tiponacionalidads.add(tiponacionalidad);
				}
			} else {
				if(tiponacionalidadEncontrado!=null && permiteQuitar)  {
					tiponacionalidads.remove(tiponacionalidadEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoNacionalidad tiponacionalidad,List<TipoNacionalidad> tiponacionalidads) throws Exception {
		try	{			
			for(TipoNacionalidad tiponacionalidadLocal:tiponacionalidads) {
				if(tiponacionalidadLocal.getId().equals(tiponacionalidad.getId())) {
					tiponacionalidadLocal.setIsSelected(tiponacionalidad.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoNacionalidad(List<TipoNacionalidad> tiponacionalidadsAux) throws Exception {
		//this.tiponacionalidadsAux=tiponacionalidadsAux;
		
		for(TipoNacionalidad tiponacionalidadAux:tiponacionalidadsAux) {
			if(tiponacionalidadAux.getIsChanged()) {
				tiponacionalidadAux.setIsChanged(false);
			}		
			
			if(tiponacionalidadAux.getIsNew()) {
				tiponacionalidadAux.setIsNew(false);
			}	
			
			if(tiponacionalidadAux.getIsDeleted()) {
				tiponacionalidadAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoNacionalidad(TipoNacionalidad tiponacionalidadAux) throws Exception {
		//this.tiponacionalidadAux=tiponacionalidadAux;
		
			if(tiponacionalidadAux.getIsChanged()) {
				tiponacionalidadAux.setIsChanged(false);
			}		
			
			if(tiponacionalidadAux.getIsNew()) {
				tiponacionalidadAux.setIsNew(false);
			}	
			
			if(tiponacionalidadAux.getIsDeleted()) {
				tiponacionalidadAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoNacionalidad tiponacionalidadAsignar,TipoNacionalidad tiponacionalidad) throws Exception {
		tiponacionalidadAsignar.setId(tiponacionalidad.getId());	
		tiponacionalidadAsignar.setVersionRow(tiponacionalidad.getVersionRow());	
		tiponacionalidadAsignar.setid_empresa(tiponacionalidad.getid_empresa());
		tiponacionalidadAsignar.setempresa_descripcion(tiponacionalidad.getempresa_descripcion());	
		tiponacionalidadAsignar.setcodigo(tiponacionalidad.getcodigo());	
		tiponacionalidadAsignar.setnombre(tiponacionalidad.getnombre());	
	}
	
	public static void inicializarTipoNacionalidad(TipoNacionalidad tiponacionalidad) throws Exception {
		try {
				tiponacionalidad.setId(0L);	
					
				tiponacionalidad.setid_empresa(-1L);	
				tiponacionalidad.setcodigo("");	
				tiponacionalidad.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoNacionalidad(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoNacionalidadConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoNacionalidadConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoNacionalidadConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoNacionalidad(String sTipo,Row row,Workbook workbook,TipoNacionalidad tiponacionalidad,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tiponacionalidad.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tiponacionalidad.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tiponacionalidad.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoNacionalidad=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoNacionalidad() {
		return this.sFinalQueryTipoNacionalidad;
	}
	
	public void setsFinalQueryTipoNacionalidad(String sFinalQueryTipoNacionalidad) {
		this.sFinalQueryTipoNacionalidad= sFinalQueryTipoNacionalidad;
	}
	
	public Border resaltarSeleccionarTipoNacionalidad=null;
	
	public Border setResaltarSeleccionarTipoNacionalidad(ParametroGeneralUsuario parametroGeneralUsuario/*TipoNacionalidadBeanSwingJInternalFrame tiponacionalidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tiponacionalidadBeanSwingJInternalFrame.jTtoolBarTipoNacionalidad.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoNacionalidad= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoNacionalidad() {
		return this.resaltarSeleccionarTipoNacionalidad;
	}
	
	public void setResaltarSeleccionarTipoNacionalidad(Border borderResaltarSeleccionarTipoNacionalidad) {
		this.resaltarSeleccionarTipoNacionalidad= borderResaltarSeleccionarTipoNacionalidad;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoNacionalidad=null;
	public Boolean mostraridTipoNacionalidad=true;
	public Boolean activaridTipoNacionalidad=true;

	public Border resaltarid_empresaTipoNacionalidad=null;
	public Boolean mostrarid_empresaTipoNacionalidad=true;
	public Boolean activarid_empresaTipoNacionalidad=true;
	public Boolean cargarid_empresaTipoNacionalidad=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoNacionalidad=false;//ConEventDepend=true

	public Border resaltarcodigoTipoNacionalidad=null;
	public Boolean mostrarcodigoTipoNacionalidad=true;
	public Boolean activarcodigoTipoNacionalidad=true;

	public Border resaltarnombreTipoNacionalidad=null;
	public Boolean mostrarnombreTipoNacionalidad=true;
	public Boolean activarnombreTipoNacionalidad=true;

	
	

	public Border setResaltaridTipoNacionalidad(ParametroGeneralUsuario parametroGeneralUsuario/*TipoNacionalidadBeanSwingJInternalFrame tiponacionalidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiponacionalidadBeanSwingJInternalFrame.jTtoolBarTipoNacionalidad.setBorder(borderResaltar);
		
		this.resaltaridTipoNacionalidad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoNacionalidad() {
		return this.resaltaridTipoNacionalidad;
	}

	public void setResaltaridTipoNacionalidad(Border borderResaltar) {
		this.resaltaridTipoNacionalidad= borderResaltar;
	}

	public Boolean getMostraridTipoNacionalidad() {
		return this.mostraridTipoNacionalidad;
	}

	public void setMostraridTipoNacionalidad(Boolean mostraridTipoNacionalidad) {
		this.mostraridTipoNacionalidad= mostraridTipoNacionalidad;
	}

	public Boolean getActivaridTipoNacionalidad() {
		return this.activaridTipoNacionalidad;
	}

	public void setActivaridTipoNacionalidad(Boolean activaridTipoNacionalidad) {
		this.activaridTipoNacionalidad= activaridTipoNacionalidad;
	}

	public Border setResaltarid_empresaTipoNacionalidad(ParametroGeneralUsuario parametroGeneralUsuario/*TipoNacionalidadBeanSwingJInternalFrame tiponacionalidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiponacionalidadBeanSwingJInternalFrame.jTtoolBarTipoNacionalidad.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoNacionalidad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoNacionalidad() {
		return this.resaltarid_empresaTipoNacionalidad;
	}

	public void setResaltarid_empresaTipoNacionalidad(Border borderResaltar) {
		this.resaltarid_empresaTipoNacionalidad= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoNacionalidad() {
		return this.mostrarid_empresaTipoNacionalidad;
	}

	public void setMostrarid_empresaTipoNacionalidad(Boolean mostrarid_empresaTipoNacionalidad) {
		this.mostrarid_empresaTipoNacionalidad= mostrarid_empresaTipoNacionalidad;
	}

	public Boolean getActivarid_empresaTipoNacionalidad() {
		return this.activarid_empresaTipoNacionalidad;
	}

	public void setActivarid_empresaTipoNacionalidad(Boolean activarid_empresaTipoNacionalidad) {
		this.activarid_empresaTipoNacionalidad= activarid_empresaTipoNacionalidad;
	}

	public Boolean getCargarid_empresaTipoNacionalidad() {
		return this.cargarid_empresaTipoNacionalidad;
	}

	public void setCargarid_empresaTipoNacionalidad(Boolean cargarid_empresaTipoNacionalidad) {
		this.cargarid_empresaTipoNacionalidad= cargarid_empresaTipoNacionalidad;
	}

	public Border setResaltarcodigoTipoNacionalidad(ParametroGeneralUsuario parametroGeneralUsuario/*TipoNacionalidadBeanSwingJInternalFrame tiponacionalidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiponacionalidadBeanSwingJInternalFrame.jTtoolBarTipoNacionalidad.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoNacionalidad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoNacionalidad() {
		return this.resaltarcodigoTipoNacionalidad;
	}

	public void setResaltarcodigoTipoNacionalidad(Border borderResaltar) {
		this.resaltarcodigoTipoNacionalidad= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoNacionalidad() {
		return this.mostrarcodigoTipoNacionalidad;
	}

	public void setMostrarcodigoTipoNacionalidad(Boolean mostrarcodigoTipoNacionalidad) {
		this.mostrarcodigoTipoNacionalidad= mostrarcodigoTipoNacionalidad;
	}

	public Boolean getActivarcodigoTipoNacionalidad() {
		return this.activarcodigoTipoNacionalidad;
	}

	public void setActivarcodigoTipoNacionalidad(Boolean activarcodigoTipoNacionalidad) {
		this.activarcodigoTipoNacionalidad= activarcodigoTipoNacionalidad;
	}

	public Border setResaltarnombreTipoNacionalidad(ParametroGeneralUsuario parametroGeneralUsuario/*TipoNacionalidadBeanSwingJInternalFrame tiponacionalidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiponacionalidadBeanSwingJInternalFrame.jTtoolBarTipoNacionalidad.setBorder(borderResaltar);
		
		this.resaltarnombreTipoNacionalidad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoNacionalidad() {
		return this.resaltarnombreTipoNacionalidad;
	}

	public void setResaltarnombreTipoNacionalidad(Border borderResaltar) {
		this.resaltarnombreTipoNacionalidad= borderResaltar;
	}

	public Boolean getMostrarnombreTipoNacionalidad() {
		return this.mostrarnombreTipoNacionalidad;
	}

	public void setMostrarnombreTipoNacionalidad(Boolean mostrarnombreTipoNacionalidad) {
		this.mostrarnombreTipoNacionalidad= mostrarnombreTipoNacionalidad;
	}

	public Boolean getActivarnombreTipoNacionalidad() {
		return this.activarnombreTipoNacionalidad;
	}

	public void setActivarnombreTipoNacionalidad(Boolean activarnombreTipoNacionalidad) {
		this.activarnombreTipoNacionalidad= activarnombreTipoNacionalidad;
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
		
		
		this.setMostraridTipoNacionalidad(esInicial);
		this.setMostrarid_empresaTipoNacionalidad(esInicial);
		this.setMostrarcodigoTipoNacionalidad(esInicial);
		this.setMostrarnombreTipoNacionalidad(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoNacionalidadConstantesFunciones.ID)) {
				this.setMostraridTipoNacionalidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoNacionalidadConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoNacionalidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoNacionalidadConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoNacionalidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoNacionalidadConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoNacionalidad(esAsigna);
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
		
		
		this.setActivaridTipoNacionalidad(esInicial);
		this.setActivarid_empresaTipoNacionalidad(esInicial);
		this.setActivarcodigoTipoNacionalidad(esInicial);
		this.setActivarnombreTipoNacionalidad(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoNacionalidadConstantesFunciones.ID)) {
				this.setActivaridTipoNacionalidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoNacionalidadConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoNacionalidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoNacionalidadConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoNacionalidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoNacionalidadConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoNacionalidad(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoNacionalidadBeanSwingJInternalFrame tiponacionalidadBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoNacionalidad(esInicial);
		this.setResaltarid_empresaTipoNacionalidad(esInicial);
		this.setResaltarcodigoTipoNacionalidad(esInicial);
		this.setResaltarnombreTipoNacionalidad(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoNacionalidadConstantesFunciones.ID)) {
				this.setResaltaridTipoNacionalidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoNacionalidadConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoNacionalidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoNacionalidadConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoNacionalidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoNacionalidadConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoNacionalidad(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoNacionalidadBeanSwingJInternalFrame tiponacionalidadBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpresaTipoNacionalidad=true;

	public Boolean getMostrarFK_IdEmpresaTipoNacionalidad() {
		return this.mostrarFK_IdEmpresaTipoNacionalidad;
	}

	public void setMostrarFK_IdEmpresaTipoNacionalidad(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoNacionalidad= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaTipoNacionalidad=true;

	public Boolean getActivarFK_IdEmpresaTipoNacionalidad() {
		return this.activarFK_IdEmpresaTipoNacionalidad;
	}

	public void setActivarFK_IdEmpresaTipoNacionalidad(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoNacionalidad= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaTipoNacionalidad=null;

	public Border getResaltarFK_IdEmpresaTipoNacionalidad() {
		return this.resaltarFK_IdEmpresaTipoNacionalidad;
	}

	public void setResaltarFK_IdEmpresaTipoNacionalidad(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoNacionalidad= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoNacionalidad(ParametroGeneralUsuario parametroGeneralUsuario/*TipoNacionalidadBeanSwingJInternalFrame tiponacionalidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoNacionalidad= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}