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


import com.bydan.erp.facturacion.util.TipoProformaConstantesFunciones;
import com.bydan.erp.facturacion.util.TipoProformaParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.TipoProformaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.comisiones.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoProformaConstantesFunciones extends TipoProformaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoProforma";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoProforma"+TipoProformaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoProformaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoProformaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoProformaConstantesFunciones.SCHEMA+"_"+TipoProformaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoProformaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoProformaConstantesFunciones.SCHEMA+"_"+TipoProformaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoProformaConstantesFunciones.SCHEMA+"_"+TipoProformaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoProformaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoProformaConstantesFunciones.SCHEMA+"_"+TipoProformaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoProformaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoProformaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoProformaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoProformaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoProformaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoProformaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoProformaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoProformaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoProformaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoProformaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Proformas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Proforma";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Proforma";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoProforma";
	public static final String OBJECTNAME="tipoproforma";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="tipo_proforma";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipoproforma from "+TipoProformaConstantesFunciones.SPERSISTENCENAME+" tipoproforma";
	public static String QUERYSELECTNATIVE="select "+TipoProformaConstantesFunciones.SCHEMA+"."+TipoProformaConstantesFunciones.TABLENAME+".id,"+TipoProformaConstantesFunciones.SCHEMA+"."+TipoProformaConstantesFunciones.TABLENAME+".version_row,"+TipoProformaConstantesFunciones.SCHEMA+"."+TipoProformaConstantesFunciones.TABLENAME+".id_empresa,"+TipoProformaConstantesFunciones.SCHEMA+"."+TipoProformaConstantesFunciones.TABLENAME+".codigo,"+TipoProformaConstantesFunciones.SCHEMA+"."+TipoProformaConstantesFunciones.TABLENAME+".nombre from "+TipoProformaConstantesFunciones.SCHEMA+"."+TipoProformaConstantesFunciones.TABLENAME;//+" as "+TipoProformaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoProformaConstantesFuncionesAdditional tipoproformaConstantesFuncionesAdditional=null;
	
	public TipoProformaConstantesFuncionesAdditional getTipoProformaConstantesFuncionesAdditional() {
		return this.tipoproformaConstantesFuncionesAdditional;
	}
	
	public void setTipoProformaConstantesFuncionesAdditional(TipoProformaConstantesFuncionesAdditional tipoproformaConstantesFuncionesAdditional) {
		try {
			this.tipoproformaConstantesFuncionesAdditional=tipoproformaConstantesFuncionesAdditional;
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
	
	public static String getTipoProformaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoProformaConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoProformaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoProformaConstantesFunciones.CODIGO)) {sLabelColumna=TipoProformaConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoProformaConstantesFunciones.NOMBRE)) {sLabelColumna=TipoProformaConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getTipoProformaDescripcion(TipoProforma tipoproforma) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipoproforma !=null/* && tipoproforma.getId()!=0*/) {
			sDescripcion=tipoproforma.getcodigo();//tipoproformatipoproforma.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoProformaDescripcionDetallado(TipoProforma tipoproforma) {
		String sDescripcion="";
			
		sDescripcion+=TipoProformaConstantesFunciones.ID+"=";
		sDescripcion+=tipoproforma.getId().toString()+",";
		sDescripcion+=TipoProformaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipoproforma.getVersionRow().toString()+",";
		sDescripcion+=TipoProformaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tipoproforma.getid_empresa().toString()+",";
		sDescripcion+=TipoProformaConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipoproforma.getcodigo()+",";
		sDescripcion+=TipoProformaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipoproforma.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoProformaDescripcion(TipoProforma tipoproforma,String sValor) throws Exception {			
		if(tipoproforma !=null) {
			tipoproforma.setcodigo(sValor);;//tipoproformatipoproforma.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoProforma(TipoProforma tipoproforma,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipoproforma.setcodigo(tipoproforma.getcodigo().trim());
		tipoproforma.setnombre(tipoproforma.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoProformas(List<TipoProforma> tipoproformas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoProforma tipoproforma: tipoproformas) {
			tipoproforma.setcodigo(tipoproforma.getcodigo().trim());
			tipoproforma.setnombre(tipoproforma.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoProforma(TipoProforma tipoproforma,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipoproforma.getConCambioAuxiliar()) {
			tipoproforma.setIsDeleted(tipoproforma.getIsDeletedAuxiliar());	
			tipoproforma.setIsNew(tipoproforma.getIsNewAuxiliar());	
			tipoproforma.setIsChanged(tipoproforma.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipoproforma.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipoproforma.setIsDeletedAuxiliar(false);	
			tipoproforma.setIsNewAuxiliar(false);	
			tipoproforma.setIsChangedAuxiliar(false);
			
			tipoproforma.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoProformas(List<TipoProforma> tipoproformas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoProforma tipoproforma : tipoproformas) {
			if(conAsignarBase && tipoproforma.getConCambioAuxiliar()) {
				tipoproforma.setIsDeleted(tipoproforma.getIsDeletedAuxiliar());	
				tipoproforma.setIsNew(tipoproforma.getIsNewAuxiliar());	
				tipoproforma.setIsChanged(tipoproforma.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipoproforma.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipoproforma.setIsDeletedAuxiliar(false);	
				tipoproforma.setIsNewAuxiliar(false);	
				tipoproforma.setIsChangedAuxiliar(false);
				
				tipoproforma.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoProforma(TipoProforma tipoproforma,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoProformas(List<TipoProforma> tipoproformas,Boolean conEnteros) throws Exception  {
		
		for(TipoProforma tipoproforma: tipoproformas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoProforma(List<TipoProforma> tipoproformas,TipoProforma tipoproformaAux) throws Exception  {
		TipoProformaConstantesFunciones.InicializarValoresTipoProforma(tipoproformaAux,true);
		
		for(TipoProforma tipoproforma: tipoproformas) {
			if(tipoproforma.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoProforma(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoProformaConstantesFunciones.getArrayColumnasGlobalesTipoProforma(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoProforma(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoProformaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoProformaConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoProforma(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoProforma> tipoproformas,TipoProforma tipoproforma,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoProforma tipoproformaAux: tipoproformas) {
			if(tipoproformaAux!=null && tipoproforma!=null) {
				if((tipoproformaAux.getId()==null && tipoproforma.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipoproformaAux.getId()!=null && tipoproforma.getId()!=null){
					if(tipoproformaAux.getId().equals(tipoproforma.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoProforma(List<TipoProforma> tipoproformas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoProforma tipoproforma: tipoproformas) {			
			if(tipoproforma.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoProforma() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoProformaConstantesFunciones.LABEL_ID, TipoProformaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoProformaConstantesFunciones.LABEL_VERSIONROW, TipoProformaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoProformaConstantesFunciones.LABEL_IDEMPRESA, TipoProformaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoProformaConstantesFunciones.LABEL_CODIGO, TipoProformaConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoProformaConstantesFunciones.LABEL_NOMBRE, TipoProformaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoProforma() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoProformaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoProformaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoProformaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoProformaConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoProformaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoProforma() throws Exception  {
		return TipoProformaConstantesFunciones.getTiposSeleccionarTipoProforma(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoProforma(Boolean conFk) throws Exception  {
		return TipoProformaConstantesFunciones.getTiposSeleccionarTipoProforma(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoProforma(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoProformaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoProformaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoProformaConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoProformaConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoProformaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoProformaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoProforma(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoProforma(TipoProforma tipoproformaAux) throws Exception {
		
			tipoproformaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipoproformaAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoProforma(List<TipoProforma> tipoproformasTemp) throws Exception {
		for(TipoProforma tipoproformaAux:tipoproformasTemp) {
			
			tipoproformaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipoproformaAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoProforma(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoProforma(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoProforma(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoProformaConstantesFunciones.getClassesRelationshipsOfTipoProforma(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoProforma(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Proforma.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Proforma.class)) {
						classes.add(new Classe(Proforma.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoProforma(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoProformaConstantesFunciones.getClassesRelationshipsFromStringsOfTipoProforma(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoProforma(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Proforma.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Proforma.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Proforma.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Proforma.class)); continue;
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
	public static void actualizarLista(TipoProforma tipoproforma,List<TipoProforma> tipoproformas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoProforma tipoproformaEncontrado=null;
			
			for(TipoProforma tipoproformaLocal:tipoproformas) {
				if(tipoproformaLocal.getId().equals(tipoproforma.getId())) {
					tipoproformaEncontrado=tipoproformaLocal;
					
					tipoproformaLocal.setIsChanged(tipoproforma.getIsChanged());
					tipoproformaLocal.setIsNew(tipoproforma.getIsNew());
					tipoproformaLocal.setIsDeleted(tipoproforma.getIsDeleted());
					
					tipoproformaLocal.setGeneralEntityOriginal(tipoproforma.getGeneralEntityOriginal());
					
					tipoproformaLocal.setId(tipoproforma.getId());	
					tipoproformaLocal.setVersionRow(tipoproforma.getVersionRow());	
					tipoproformaLocal.setid_empresa(tipoproforma.getid_empresa());	
					tipoproformaLocal.setcodigo(tipoproforma.getcodigo());	
					tipoproformaLocal.setnombre(tipoproforma.getnombre());	
					
					
					tipoproformaLocal.setProformas(tipoproforma.getProformas());
					
					existe=true;
					break;
				}
			}
			
			if(!tipoproforma.getIsDeleted()) {
				if(!existe) {
					tipoproformas.add(tipoproforma);
				}
			} else {
				if(tipoproformaEncontrado!=null && permiteQuitar)  {
					tipoproformas.remove(tipoproformaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoProforma tipoproforma,List<TipoProforma> tipoproformas) throws Exception {
		try	{			
			for(TipoProforma tipoproformaLocal:tipoproformas) {
				if(tipoproformaLocal.getId().equals(tipoproforma.getId())) {
					tipoproformaLocal.setIsSelected(tipoproforma.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoProforma(List<TipoProforma> tipoproformasAux) throws Exception {
		//this.tipoproformasAux=tipoproformasAux;
		
		for(TipoProforma tipoproformaAux:tipoproformasAux) {
			if(tipoproformaAux.getIsChanged()) {
				tipoproformaAux.setIsChanged(false);
			}		
			
			if(tipoproformaAux.getIsNew()) {
				tipoproformaAux.setIsNew(false);
			}	
			
			if(tipoproformaAux.getIsDeleted()) {
				tipoproformaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoProforma(TipoProforma tipoproformaAux) throws Exception {
		//this.tipoproformaAux=tipoproformaAux;
		
			if(tipoproformaAux.getIsChanged()) {
				tipoproformaAux.setIsChanged(false);
			}		
			
			if(tipoproformaAux.getIsNew()) {
				tipoproformaAux.setIsNew(false);
			}	
			
			if(tipoproformaAux.getIsDeleted()) {
				tipoproformaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoProforma tipoproformaAsignar,TipoProforma tipoproforma) throws Exception {
		tipoproformaAsignar.setId(tipoproforma.getId());	
		tipoproformaAsignar.setVersionRow(tipoproforma.getVersionRow());	
		tipoproformaAsignar.setid_empresa(tipoproforma.getid_empresa());
		tipoproformaAsignar.setempresa_descripcion(tipoproforma.getempresa_descripcion());	
		tipoproformaAsignar.setcodigo(tipoproforma.getcodigo());	
		tipoproformaAsignar.setnombre(tipoproforma.getnombre());	
	}
	
	public static void inicializarTipoProforma(TipoProforma tipoproforma) throws Exception {
		try {
				tipoproforma.setId(0L);	
					
				tipoproforma.setid_empresa(-1L);	
				tipoproforma.setcodigo("");	
				tipoproforma.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoProforma(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoProformaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoProformaConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoProformaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoProforma(String sTipo,Row row,Workbook workbook,TipoProforma tipoproforma,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoproforma.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoproforma.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoproforma.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoProforma=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoProforma() {
		return this.sFinalQueryTipoProforma;
	}
	
	public void setsFinalQueryTipoProforma(String sFinalQueryTipoProforma) {
		this.sFinalQueryTipoProforma= sFinalQueryTipoProforma;
	}
	
	public Border resaltarSeleccionarTipoProforma=null;
	
	public Border setResaltarSeleccionarTipoProforma(ParametroGeneralUsuario parametroGeneralUsuario/*TipoProformaBeanSwingJInternalFrame tipoproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipoproformaBeanSwingJInternalFrame.jTtoolBarTipoProforma.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoProforma= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoProforma() {
		return this.resaltarSeleccionarTipoProforma;
	}
	
	public void setResaltarSeleccionarTipoProforma(Border borderResaltarSeleccionarTipoProforma) {
		this.resaltarSeleccionarTipoProforma= borderResaltarSeleccionarTipoProforma;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoProforma=null;
	public Boolean mostraridTipoProforma=true;
	public Boolean activaridTipoProforma=true;

	public Border resaltarid_empresaTipoProforma=null;
	public Boolean mostrarid_empresaTipoProforma=true;
	public Boolean activarid_empresaTipoProforma=true;
	public Boolean cargarid_empresaTipoProforma=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoProforma=false;//ConEventDepend=true

	public Border resaltarcodigoTipoProforma=null;
	public Boolean mostrarcodigoTipoProforma=true;
	public Boolean activarcodigoTipoProforma=true;

	public Border resaltarnombreTipoProforma=null;
	public Boolean mostrarnombreTipoProforma=true;
	public Boolean activarnombreTipoProforma=true;

	
	

	public Border setResaltaridTipoProforma(ParametroGeneralUsuario parametroGeneralUsuario/*TipoProformaBeanSwingJInternalFrame tipoproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoproformaBeanSwingJInternalFrame.jTtoolBarTipoProforma.setBorder(borderResaltar);
		
		this.resaltaridTipoProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoProforma() {
		return this.resaltaridTipoProforma;
	}

	public void setResaltaridTipoProforma(Border borderResaltar) {
		this.resaltaridTipoProforma= borderResaltar;
	}

	public Boolean getMostraridTipoProforma() {
		return this.mostraridTipoProforma;
	}

	public void setMostraridTipoProforma(Boolean mostraridTipoProforma) {
		this.mostraridTipoProforma= mostraridTipoProforma;
	}

	public Boolean getActivaridTipoProforma() {
		return this.activaridTipoProforma;
	}

	public void setActivaridTipoProforma(Boolean activaridTipoProforma) {
		this.activaridTipoProforma= activaridTipoProforma;
	}

	public Border setResaltarid_empresaTipoProforma(ParametroGeneralUsuario parametroGeneralUsuario/*TipoProformaBeanSwingJInternalFrame tipoproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoproformaBeanSwingJInternalFrame.jTtoolBarTipoProforma.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoProforma() {
		return this.resaltarid_empresaTipoProforma;
	}

	public void setResaltarid_empresaTipoProforma(Border borderResaltar) {
		this.resaltarid_empresaTipoProforma= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoProforma() {
		return this.mostrarid_empresaTipoProforma;
	}

	public void setMostrarid_empresaTipoProforma(Boolean mostrarid_empresaTipoProforma) {
		this.mostrarid_empresaTipoProforma= mostrarid_empresaTipoProforma;
	}

	public Boolean getActivarid_empresaTipoProforma() {
		return this.activarid_empresaTipoProforma;
	}

	public void setActivarid_empresaTipoProforma(Boolean activarid_empresaTipoProforma) {
		this.activarid_empresaTipoProforma= activarid_empresaTipoProforma;
	}

	public Boolean getCargarid_empresaTipoProforma() {
		return this.cargarid_empresaTipoProforma;
	}

	public void setCargarid_empresaTipoProforma(Boolean cargarid_empresaTipoProforma) {
		this.cargarid_empresaTipoProforma= cargarid_empresaTipoProforma;
	}

	public Border setResaltarcodigoTipoProforma(ParametroGeneralUsuario parametroGeneralUsuario/*TipoProformaBeanSwingJInternalFrame tipoproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoproformaBeanSwingJInternalFrame.jTtoolBarTipoProforma.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoProforma() {
		return this.resaltarcodigoTipoProforma;
	}

	public void setResaltarcodigoTipoProforma(Border borderResaltar) {
		this.resaltarcodigoTipoProforma= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoProforma() {
		return this.mostrarcodigoTipoProforma;
	}

	public void setMostrarcodigoTipoProforma(Boolean mostrarcodigoTipoProforma) {
		this.mostrarcodigoTipoProforma= mostrarcodigoTipoProforma;
	}

	public Boolean getActivarcodigoTipoProforma() {
		return this.activarcodigoTipoProforma;
	}

	public void setActivarcodigoTipoProforma(Boolean activarcodigoTipoProforma) {
		this.activarcodigoTipoProforma= activarcodigoTipoProforma;
	}

	public Border setResaltarnombreTipoProforma(ParametroGeneralUsuario parametroGeneralUsuario/*TipoProformaBeanSwingJInternalFrame tipoproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoproformaBeanSwingJInternalFrame.jTtoolBarTipoProforma.setBorder(borderResaltar);
		
		this.resaltarnombreTipoProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoProforma() {
		return this.resaltarnombreTipoProforma;
	}

	public void setResaltarnombreTipoProforma(Border borderResaltar) {
		this.resaltarnombreTipoProforma= borderResaltar;
	}

	public Boolean getMostrarnombreTipoProforma() {
		return this.mostrarnombreTipoProforma;
	}

	public void setMostrarnombreTipoProforma(Boolean mostrarnombreTipoProforma) {
		this.mostrarnombreTipoProforma= mostrarnombreTipoProforma;
	}

	public Boolean getActivarnombreTipoProforma() {
		return this.activarnombreTipoProforma;
	}

	public void setActivarnombreTipoProforma(Boolean activarnombreTipoProforma) {
		this.activarnombreTipoProforma= activarnombreTipoProforma;
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
		
		
		this.setMostraridTipoProforma(esInicial);
		this.setMostrarid_empresaTipoProforma(esInicial);
		this.setMostrarcodigoTipoProforma(esInicial);
		this.setMostrarnombreTipoProforma(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoProformaConstantesFunciones.ID)) {
				this.setMostraridTipoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoProformaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoProformaConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoProformaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoProforma(esAsigna);
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
		
		
		this.setActivaridTipoProforma(esInicial);
		this.setActivarid_empresaTipoProforma(esInicial);
		this.setActivarcodigoTipoProforma(esInicial);
		this.setActivarnombreTipoProforma(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoProformaConstantesFunciones.ID)) {
				this.setActivaridTipoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoProformaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoProformaConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoProformaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoProforma(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoProformaBeanSwingJInternalFrame tipoproformaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoProforma(esInicial);
		this.setResaltarid_empresaTipoProforma(esInicial);
		this.setResaltarcodigoTipoProforma(esInicial);
		this.setResaltarnombreTipoProforma(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoProformaConstantesFunciones.ID)) {
				this.setResaltaridTipoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoProformaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoProformaConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoProformaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoProforma(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarProformaTipoProforma=null;

	public Border getResaltarProformaTipoProforma() {
		return this.resaltarProformaTipoProforma;
	}

	public void setResaltarProformaTipoProforma(Border borderResaltarProforma) {
		if(borderResaltarProforma!=null) {
			this.resaltarProformaTipoProforma= borderResaltarProforma;
		}
	}

	public Border setResaltarProformaTipoProforma(ParametroGeneralUsuario parametroGeneralUsuario/*TipoProformaBeanSwingJInternalFrame tipoproformaBeanSwingJInternalFrame*/) {
		Border borderResaltarProforma=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoproformaBeanSwingJInternalFrame.jTtoolBarTipoProforma.setBorder(borderResaltarProforma);
			
		this.resaltarProformaTipoProforma= borderResaltarProforma;

		 return borderResaltarProforma;
	}



	public Boolean mostrarProformaTipoProforma=true;

	public Boolean getMostrarProformaTipoProforma() {
		return this.mostrarProformaTipoProforma;
	}

	public void setMostrarProformaTipoProforma(Boolean visibilidadResaltarProforma) {
		this.mostrarProformaTipoProforma= visibilidadResaltarProforma;
	}



	public Boolean activarProformaTipoProforma=true;

	public Boolean gethabilitarResaltarProformaTipoProforma() {
		return this.activarProformaTipoProforma;
	}

	public void setActivarProformaTipoProforma(Boolean habilitarResaltarProforma) {
		this.activarProformaTipoProforma= habilitarResaltarProforma;
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

		this.setMostrarProformaTipoProforma(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Proforma.class)) {
				this.setMostrarProformaTipoProforma(esAsigna);
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

		this.setActivarProformaTipoProforma(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Proforma.class)) {
				this.setActivarProformaTipoProforma(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoProformaBeanSwingJInternalFrame tipoproformaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarProformaTipoProforma(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Proforma.class)) {
				this.setResaltarProformaTipoProforma(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdEmpresaTipoProforma=true;

	public Boolean getMostrarFK_IdEmpresaTipoProforma() {
		return this.mostrarFK_IdEmpresaTipoProforma;
	}

	public void setMostrarFK_IdEmpresaTipoProforma(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoProforma= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaTipoProforma=true;

	public Boolean getActivarFK_IdEmpresaTipoProforma() {
		return this.activarFK_IdEmpresaTipoProforma;
	}

	public void setActivarFK_IdEmpresaTipoProforma(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoProforma= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaTipoProforma=null;

	public Border getResaltarFK_IdEmpresaTipoProforma() {
		return this.resaltarFK_IdEmpresaTipoProforma;
	}

	public void setResaltarFK_IdEmpresaTipoProforma(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoProforma= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoProforma(ParametroGeneralUsuario parametroGeneralUsuario/*TipoProformaBeanSwingJInternalFrame tipoproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoProforma= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}