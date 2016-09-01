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


import com.bydan.erp.produccion.util.TipoManoProduEmpresaConstantesFunciones;
import com.bydan.erp.produccion.util.TipoManoProduEmpresaParameterReturnGeneral;
//import com.bydan.erp.produccion.util.TipoManoProduEmpresaParameterGeneral;

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
final public class TipoManoProduEmpresaConstantesFunciones extends TipoManoProduEmpresaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoManoProduEmpresa";
	public static final String SPATHOPCION="Produccion";	
	public static final String SPATHMODULO="produccion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoManoProduEmpresa"+TipoManoProduEmpresaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoManoProduEmpresaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoManoProduEmpresaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoManoProduEmpresaConstantesFunciones.SCHEMA+"_"+TipoManoProduEmpresaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoManoProduEmpresaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoManoProduEmpresaConstantesFunciones.SCHEMA+"_"+TipoManoProduEmpresaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoManoProduEmpresaConstantesFunciones.SCHEMA+"_"+TipoManoProduEmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoManoProduEmpresaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoManoProduEmpresaConstantesFunciones.SCHEMA+"_"+TipoManoProduEmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoManoProduEmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoManoProduEmpresaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoManoProduEmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoManoProduEmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoManoProduEmpresaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoManoProduEmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoManoProduEmpresaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoManoProduEmpresaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoManoProduEmpresaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoManoProduEmpresaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Mano Obra Produccion Empresas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Mano Obra Produccion Empresa";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Mano Produ Empresa";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoManoProduEmpresa";
	public static final String OBJECTNAME="tipomanoproduempresa";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PRODUCCION;	
	public static final String TABLENAME="tipo_mano_produ_empresa";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipomanoproduempresa from "+TipoManoProduEmpresaConstantesFunciones.SPERSISTENCENAME+" tipomanoproduempresa";
	public static String QUERYSELECTNATIVE="select "+TipoManoProduEmpresaConstantesFunciones.SCHEMA+"."+TipoManoProduEmpresaConstantesFunciones.TABLENAME+".id,"+TipoManoProduEmpresaConstantesFunciones.SCHEMA+"."+TipoManoProduEmpresaConstantesFunciones.TABLENAME+".version_row,"+TipoManoProduEmpresaConstantesFunciones.SCHEMA+"."+TipoManoProduEmpresaConstantesFunciones.TABLENAME+".id_empresa,"+TipoManoProduEmpresaConstantesFunciones.SCHEMA+"."+TipoManoProduEmpresaConstantesFunciones.TABLENAME+".nombre,"+TipoManoProduEmpresaConstantesFunciones.SCHEMA+"."+TipoManoProduEmpresaConstantesFunciones.TABLENAME+".descripcion from "+TipoManoProduEmpresaConstantesFunciones.SCHEMA+"."+TipoManoProduEmpresaConstantesFunciones.TABLENAME;//+" as "+TipoManoProduEmpresaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoManoProduEmpresaConstantesFuncionesAdditional tipomanoproduempresaConstantesFuncionesAdditional=null;
	
	public TipoManoProduEmpresaConstantesFuncionesAdditional getTipoManoProduEmpresaConstantesFuncionesAdditional() {
		return this.tipomanoproduempresaConstantesFuncionesAdditional;
	}
	
	public void setTipoManoProduEmpresaConstantesFuncionesAdditional(TipoManoProduEmpresaConstantesFuncionesAdditional tipomanoproduempresaConstantesFuncionesAdditional) {
		try {
			this.tipomanoproduempresaConstantesFuncionesAdditional=tipomanoproduempresaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String NOMBRE= "nombre";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getTipoManoProduEmpresaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoManoProduEmpresaConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoManoProduEmpresaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoManoProduEmpresaConstantesFunciones.NOMBRE)) {sLabelColumna=TipoManoProduEmpresaConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(TipoManoProduEmpresaConstantesFunciones.DESCRIPCION)) {sLabelColumna=TipoManoProduEmpresaConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getTipoManoProduEmpresaDescripcion(TipoManoProduEmpresa tipomanoproduempresa) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipomanoproduempresa !=null/* && tipomanoproduempresa.getId()!=0*/) {
			sDescripcion=tipomanoproduempresa.getnombre();//tipomanoproduempresatipomanoproduempresa.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoManoProduEmpresaDescripcionDetallado(TipoManoProduEmpresa tipomanoproduempresa) {
		String sDescripcion="";
			
		sDescripcion+=TipoManoProduEmpresaConstantesFunciones.ID+"=";
		sDescripcion+=tipomanoproduempresa.getId().toString()+",";
		sDescripcion+=TipoManoProduEmpresaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipomanoproduempresa.getVersionRow().toString()+",";
		sDescripcion+=TipoManoProduEmpresaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tipomanoproduempresa.getid_empresa().toString()+",";
		sDescripcion+=TipoManoProduEmpresaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipomanoproduempresa.getnombre()+",";
		sDescripcion+=TipoManoProduEmpresaConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=tipomanoproduempresa.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoManoProduEmpresaDescripcion(TipoManoProduEmpresa tipomanoproduempresa,String sValor) throws Exception {			
		if(tipomanoproduempresa !=null) {
			tipomanoproduempresa.setnombre(sValor);;//tipomanoproduempresatipomanoproduempresa.getnombre().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoManoProduEmpresa(TipoManoProduEmpresa tipomanoproduempresa,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipomanoproduempresa.setnombre(tipomanoproduempresa.getnombre().trim());
		tipomanoproduempresa.setdescripcion(tipomanoproduempresa.getdescripcion().trim());
	}
	
	public static void quitarEspaciosTipoManoProduEmpresas(List<TipoManoProduEmpresa> tipomanoproduempresas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoManoProduEmpresa tipomanoproduempresa: tipomanoproduempresas) {
			tipomanoproduempresa.setnombre(tipomanoproduempresa.getnombre().trim());
			tipomanoproduempresa.setdescripcion(tipomanoproduempresa.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoManoProduEmpresa(TipoManoProduEmpresa tipomanoproduempresa,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipomanoproduempresa.getConCambioAuxiliar()) {
			tipomanoproduempresa.setIsDeleted(tipomanoproduempresa.getIsDeletedAuxiliar());	
			tipomanoproduempresa.setIsNew(tipomanoproduempresa.getIsNewAuxiliar());	
			tipomanoproduempresa.setIsChanged(tipomanoproduempresa.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipomanoproduempresa.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipomanoproduempresa.setIsDeletedAuxiliar(false);	
			tipomanoproduempresa.setIsNewAuxiliar(false);	
			tipomanoproduempresa.setIsChangedAuxiliar(false);
			
			tipomanoproduempresa.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoManoProduEmpresas(List<TipoManoProduEmpresa> tipomanoproduempresas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoManoProduEmpresa tipomanoproduempresa : tipomanoproduempresas) {
			if(conAsignarBase && tipomanoproduempresa.getConCambioAuxiliar()) {
				tipomanoproduempresa.setIsDeleted(tipomanoproduempresa.getIsDeletedAuxiliar());	
				tipomanoproduempresa.setIsNew(tipomanoproduempresa.getIsNewAuxiliar());	
				tipomanoproduempresa.setIsChanged(tipomanoproduempresa.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipomanoproduempresa.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipomanoproduempresa.setIsDeletedAuxiliar(false);	
				tipomanoproduempresa.setIsNewAuxiliar(false);	
				tipomanoproduempresa.setIsChangedAuxiliar(false);
				
				tipomanoproduempresa.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoManoProduEmpresa(TipoManoProduEmpresa tipomanoproduempresa,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoManoProduEmpresas(List<TipoManoProduEmpresa> tipomanoproduempresas,Boolean conEnteros) throws Exception  {
		
		for(TipoManoProduEmpresa tipomanoproduempresa: tipomanoproduempresas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoManoProduEmpresa(List<TipoManoProduEmpresa> tipomanoproduempresas,TipoManoProduEmpresa tipomanoproduempresaAux) throws Exception  {
		TipoManoProduEmpresaConstantesFunciones.InicializarValoresTipoManoProduEmpresa(tipomanoproduempresaAux,true);
		
		for(TipoManoProduEmpresa tipomanoproduempresa: tipomanoproduempresas) {
			if(tipomanoproduempresa.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoManoProduEmpresa(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoManoProduEmpresaConstantesFunciones.getArrayColumnasGlobalesTipoManoProduEmpresa(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoManoProduEmpresa(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoManoProduEmpresaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoManoProduEmpresaConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoManoProduEmpresa(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoManoProduEmpresa> tipomanoproduempresas,TipoManoProduEmpresa tipomanoproduempresa,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoManoProduEmpresa tipomanoproduempresaAux: tipomanoproduempresas) {
			if(tipomanoproduempresaAux!=null && tipomanoproduempresa!=null) {
				if((tipomanoproduempresaAux.getId()==null && tipomanoproduempresa.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipomanoproduempresaAux.getId()!=null && tipomanoproduempresa.getId()!=null){
					if(tipomanoproduempresaAux.getId().equals(tipomanoproduempresa.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoManoProduEmpresa(List<TipoManoProduEmpresa> tipomanoproduempresas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoManoProduEmpresa tipomanoproduempresa: tipomanoproduempresas) {			
			if(tipomanoproduempresa.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoManoProduEmpresa() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoManoProduEmpresaConstantesFunciones.LABEL_ID, TipoManoProduEmpresaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoManoProduEmpresaConstantesFunciones.LABEL_VERSIONROW, TipoManoProduEmpresaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoManoProduEmpresaConstantesFunciones.LABEL_IDEMPRESA, TipoManoProduEmpresaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoManoProduEmpresaConstantesFunciones.LABEL_NOMBRE, TipoManoProduEmpresaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoManoProduEmpresaConstantesFunciones.LABEL_DESCRIPCION, TipoManoProduEmpresaConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoManoProduEmpresa() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoManoProduEmpresaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoManoProduEmpresaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoManoProduEmpresaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoManoProduEmpresaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoManoProduEmpresaConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoManoProduEmpresa() throws Exception  {
		return TipoManoProduEmpresaConstantesFunciones.getTiposSeleccionarTipoManoProduEmpresa(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoManoProduEmpresa(Boolean conFk) throws Exception  {
		return TipoManoProduEmpresaConstantesFunciones.getTiposSeleccionarTipoManoProduEmpresa(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoManoProduEmpresa(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoManoProduEmpresaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoManoProduEmpresaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoManoProduEmpresaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoManoProduEmpresaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoManoProduEmpresaConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(TipoManoProduEmpresaConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoManoProduEmpresa(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoManoProduEmpresa(TipoManoProduEmpresa tipomanoproduempresaAux) throws Exception {
		
			tipomanoproduempresaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipomanoproduempresaAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoManoProduEmpresa(List<TipoManoProduEmpresa> tipomanoproduempresasTemp) throws Exception {
		for(TipoManoProduEmpresa tipomanoproduempresaAux:tipomanoproduempresasTemp) {
			
			tipomanoproduempresaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipomanoproduempresaAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoManoProduEmpresa(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoManoProduEmpresa(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoManoProduEmpresa(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoManoProduEmpresaConstantesFunciones.getClassesRelationshipsOfTipoManoProduEmpresa(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoManoProduEmpresa(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(ProductoProduMano.class));
				classes.add(new Classe(ProductoOrdenDetaProduMano.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(ProductoProduMano.class)) {
						classes.add(new Classe(ProductoProduMano.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ProductoOrdenDetaProduMano.class)) {
						classes.add(new Classe(ProductoOrdenDetaProduMano.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoManoProduEmpresa(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoManoProduEmpresaConstantesFunciones.getClassesRelationshipsFromStringsOfTipoManoProduEmpresa(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoManoProduEmpresa(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(ProductoProduMano.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoProduMano.class)); continue;
					}

					if(ProductoOrdenDetaProduMano.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoOrdenDetaProduMano.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(ProductoProduMano.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoProduMano.class)); continue;
					}

					if(ProductoOrdenDetaProduMano.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoOrdenDetaProduMano.class)); continue;
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
	public static void actualizarLista(TipoManoProduEmpresa tipomanoproduempresa,List<TipoManoProduEmpresa> tipomanoproduempresas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoManoProduEmpresa tipomanoproduempresaEncontrado=null;
			
			for(TipoManoProduEmpresa tipomanoproduempresaLocal:tipomanoproduempresas) {
				if(tipomanoproduempresaLocal.getId().equals(tipomanoproduempresa.getId())) {
					tipomanoproduempresaEncontrado=tipomanoproduempresaLocal;
					
					tipomanoproduempresaLocal.setIsChanged(tipomanoproduempresa.getIsChanged());
					tipomanoproduempresaLocal.setIsNew(tipomanoproduempresa.getIsNew());
					tipomanoproduempresaLocal.setIsDeleted(tipomanoproduempresa.getIsDeleted());
					
					tipomanoproduempresaLocal.setGeneralEntityOriginal(tipomanoproduempresa.getGeneralEntityOriginal());
					
					tipomanoproduempresaLocal.setId(tipomanoproduempresa.getId());	
					tipomanoproduempresaLocal.setVersionRow(tipomanoproduempresa.getVersionRow());	
					tipomanoproduempresaLocal.setid_empresa(tipomanoproduempresa.getid_empresa());	
					tipomanoproduempresaLocal.setnombre(tipomanoproduempresa.getnombre());	
					tipomanoproduempresaLocal.setdescripcion(tipomanoproduempresa.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipomanoproduempresa.getIsDeleted()) {
				if(!existe) {
					tipomanoproduempresas.add(tipomanoproduempresa);
				}
			} else {
				if(tipomanoproduempresaEncontrado!=null && permiteQuitar)  {
					tipomanoproduempresas.remove(tipomanoproduempresaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoManoProduEmpresa tipomanoproduempresa,List<TipoManoProduEmpresa> tipomanoproduempresas) throws Exception {
		try	{			
			for(TipoManoProduEmpresa tipomanoproduempresaLocal:tipomanoproduempresas) {
				if(tipomanoproduempresaLocal.getId().equals(tipomanoproduempresa.getId())) {
					tipomanoproduempresaLocal.setIsSelected(tipomanoproduempresa.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoManoProduEmpresa(List<TipoManoProduEmpresa> tipomanoproduempresasAux) throws Exception {
		//this.tipomanoproduempresasAux=tipomanoproduempresasAux;
		
		for(TipoManoProduEmpresa tipomanoproduempresaAux:tipomanoproduempresasAux) {
			if(tipomanoproduempresaAux.getIsChanged()) {
				tipomanoproduempresaAux.setIsChanged(false);
			}		
			
			if(tipomanoproduempresaAux.getIsNew()) {
				tipomanoproduempresaAux.setIsNew(false);
			}	
			
			if(tipomanoproduempresaAux.getIsDeleted()) {
				tipomanoproduempresaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoManoProduEmpresa(TipoManoProduEmpresa tipomanoproduempresaAux) throws Exception {
		//this.tipomanoproduempresaAux=tipomanoproduempresaAux;
		
			if(tipomanoproduempresaAux.getIsChanged()) {
				tipomanoproduempresaAux.setIsChanged(false);
			}		
			
			if(tipomanoproduempresaAux.getIsNew()) {
				tipomanoproduempresaAux.setIsNew(false);
			}	
			
			if(tipomanoproduempresaAux.getIsDeleted()) {
				tipomanoproduempresaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoManoProduEmpresa tipomanoproduempresaAsignar,TipoManoProduEmpresa tipomanoproduempresa) throws Exception {
		tipomanoproduempresaAsignar.setId(tipomanoproduempresa.getId());	
		tipomanoproduempresaAsignar.setVersionRow(tipomanoproduempresa.getVersionRow());	
		tipomanoproduempresaAsignar.setid_empresa(tipomanoproduempresa.getid_empresa());
		tipomanoproduempresaAsignar.setempresa_descripcion(tipomanoproduempresa.getempresa_descripcion());	
		tipomanoproduempresaAsignar.setnombre(tipomanoproduempresa.getnombre());	
		tipomanoproduempresaAsignar.setdescripcion(tipomanoproduempresa.getdescripcion());	
	}
	
	public static void inicializarTipoManoProduEmpresa(TipoManoProduEmpresa tipomanoproduempresa) throws Exception {
		try {
				tipomanoproduempresa.setId(0L);	
					
				tipomanoproduempresa.setid_empresa(-1L);	
				tipomanoproduempresa.setnombre("");	
				tipomanoproduempresa.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoManoProduEmpresa(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoManoProduEmpresaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoManoProduEmpresaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoManoProduEmpresaConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoManoProduEmpresa(String sTipo,Row row,Workbook workbook,TipoManoProduEmpresa tipomanoproduempresa,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipomanoproduempresa.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipomanoproduempresa.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipomanoproduempresa.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoManoProduEmpresa=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoManoProduEmpresa() {
		return this.sFinalQueryTipoManoProduEmpresa;
	}
	
	public void setsFinalQueryTipoManoProduEmpresa(String sFinalQueryTipoManoProduEmpresa) {
		this.sFinalQueryTipoManoProduEmpresa= sFinalQueryTipoManoProduEmpresa;
	}
	
	public Border resaltarSeleccionarTipoManoProduEmpresa=null;
	
	public Border setResaltarSeleccionarTipoManoProduEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoManoProduEmpresaBeanSwingJInternalFrame tipomanoproduempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipomanoproduempresaBeanSwingJInternalFrame.jTtoolBarTipoManoProduEmpresa.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoManoProduEmpresa= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoManoProduEmpresa() {
		return this.resaltarSeleccionarTipoManoProduEmpresa;
	}
	
	public void setResaltarSeleccionarTipoManoProduEmpresa(Border borderResaltarSeleccionarTipoManoProduEmpresa) {
		this.resaltarSeleccionarTipoManoProduEmpresa= borderResaltarSeleccionarTipoManoProduEmpresa;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoManoProduEmpresa=null;
	public Boolean mostraridTipoManoProduEmpresa=true;
	public Boolean activaridTipoManoProduEmpresa=true;

	public Border resaltarid_empresaTipoManoProduEmpresa=null;
	public Boolean mostrarid_empresaTipoManoProduEmpresa=true;
	public Boolean activarid_empresaTipoManoProduEmpresa=true;
	public Boolean cargarid_empresaTipoManoProduEmpresa=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoManoProduEmpresa=false;//ConEventDepend=true

	public Border resaltarnombreTipoManoProduEmpresa=null;
	public Boolean mostrarnombreTipoManoProduEmpresa=true;
	public Boolean activarnombreTipoManoProduEmpresa=true;

	public Border resaltardescripcionTipoManoProduEmpresa=null;
	public Boolean mostrardescripcionTipoManoProduEmpresa=true;
	public Boolean activardescripcionTipoManoProduEmpresa=true;

	
	

	public Border setResaltaridTipoManoProduEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoManoProduEmpresaBeanSwingJInternalFrame tipomanoproduempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipomanoproduempresaBeanSwingJInternalFrame.jTtoolBarTipoManoProduEmpresa.setBorder(borderResaltar);
		
		this.resaltaridTipoManoProduEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoManoProduEmpresa() {
		return this.resaltaridTipoManoProduEmpresa;
	}

	public void setResaltaridTipoManoProduEmpresa(Border borderResaltar) {
		this.resaltaridTipoManoProduEmpresa= borderResaltar;
	}

	public Boolean getMostraridTipoManoProduEmpresa() {
		return this.mostraridTipoManoProduEmpresa;
	}

	public void setMostraridTipoManoProduEmpresa(Boolean mostraridTipoManoProduEmpresa) {
		this.mostraridTipoManoProduEmpresa= mostraridTipoManoProduEmpresa;
	}

	public Boolean getActivaridTipoManoProduEmpresa() {
		return this.activaridTipoManoProduEmpresa;
	}

	public void setActivaridTipoManoProduEmpresa(Boolean activaridTipoManoProduEmpresa) {
		this.activaridTipoManoProduEmpresa= activaridTipoManoProduEmpresa;
	}

	public Border setResaltarid_empresaTipoManoProduEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoManoProduEmpresaBeanSwingJInternalFrame tipomanoproduempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipomanoproduempresaBeanSwingJInternalFrame.jTtoolBarTipoManoProduEmpresa.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoManoProduEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoManoProduEmpresa() {
		return this.resaltarid_empresaTipoManoProduEmpresa;
	}

	public void setResaltarid_empresaTipoManoProduEmpresa(Border borderResaltar) {
		this.resaltarid_empresaTipoManoProduEmpresa= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoManoProduEmpresa() {
		return this.mostrarid_empresaTipoManoProduEmpresa;
	}

	public void setMostrarid_empresaTipoManoProduEmpresa(Boolean mostrarid_empresaTipoManoProduEmpresa) {
		this.mostrarid_empresaTipoManoProduEmpresa= mostrarid_empresaTipoManoProduEmpresa;
	}

	public Boolean getActivarid_empresaTipoManoProduEmpresa() {
		return this.activarid_empresaTipoManoProduEmpresa;
	}

	public void setActivarid_empresaTipoManoProduEmpresa(Boolean activarid_empresaTipoManoProduEmpresa) {
		this.activarid_empresaTipoManoProduEmpresa= activarid_empresaTipoManoProduEmpresa;
	}

	public Boolean getCargarid_empresaTipoManoProduEmpresa() {
		return this.cargarid_empresaTipoManoProduEmpresa;
	}

	public void setCargarid_empresaTipoManoProduEmpresa(Boolean cargarid_empresaTipoManoProduEmpresa) {
		this.cargarid_empresaTipoManoProduEmpresa= cargarid_empresaTipoManoProduEmpresa;
	}

	public Border setResaltarnombreTipoManoProduEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoManoProduEmpresaBeanSwingJInternalFrame tipomanoproduempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipomanoproduempresaBeanSwingJInternalFrame.jTtoolBarTipoManoProduEmpresa.setBorder(borderResaltar);
		
		this.resaltarnombreTipoManoProduEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoManoProduEmpresa() {
		return this.resaltarnombreTipoManoProduEmpresa;
	}

	public void setResaltarnombreTipoManoProduEmpresa(Border borderResaltar) {
		this.resaltarnombreTipoManoProduEmpresa= borderResaltar;
	}

	public Boolean getMostrarnombreTipoManoProduEmpresa() {
		return this.mostrarnombreTipoManoProduEmpresa;
	}

	public void setMostrarnombreTipoManoProduEmpresa(Boolean mostrarnombreTipoManoProduEmpresa) {
		this.mostrarnombreTipoManoProduEmpresa= mostrarnombreTipoManoProduEmpresa;
	}

	public Boolean getActivarnombreTipoManoProduEmpresa() {
		return this.activarnombreTipoManoProduEmpresa;
	}

	public void setActivarnombreTipoManoProduEmpresa(Boolean activarnombreTipoManoProduEmpresa) {
		this.activarnombreTipoManoProduEmpresa= activarnombreTipoManoProduEmpresa;
	}

	public Border setResaltardescripcionTipoManoProduEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoManoProduEmpresaBeanSwingJInternalFrame tipomanoproduempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipomanoproduempresaBeanSwingJInternalFrame.jTtoolBarTipoManoProduEmpresa.setBorder(borderResaltar);
		
		this.resaltardescripcionTipoManoProduEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionTipoManoProduEmpresa() {
		return this.resaltardescripcionTipoManoProduEmpresa;
	}

	public void setResaltardescripcionTipoManoProduEmpresa(Border borderResaltar) {
		this.resaltardescripcionTipoManoProduEmpresa= borderResaltar;
	}

	public Boolean getMostrardescripcionTipoManoProduEmpresa() {
		return this.mostrardescripcionTipoManoProduEmpresa;
	}

	public void setMostrardescripcionTipoManoProduEmpresa(Boolean mostrardescripcionTipoManoProduEmpresa) {
		this.mostrardescripcionTipoManoProduEmpresa= mostrardescripcionTipoManoProduEmpresa;
	}

	public Boolean getActivardescripcionTipoManoProduEmpresa() {
		return this.activardescripcionTipoManoProduEmpresa;
	}

	public void setActivardescripcionTipoManoProduEmpresa(Boolean activardescripcionTipoManoProduEmpresa) {
		this.activardescripcionTipoManoProduEmpresa= activardescripcionTipoManoProduEmpresa;
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
		
		
		this.setMostraridTipoManoProduEmpresa(esInicial);
		this.setMostrarid_empresaTipoManoProduEmpresa(esInicial);
		this.setMostrarnombreTipoManoProduEmpresa(esInicial);
		this.setMostrardescripcionTipoManoProduEmpresa(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoManoProduEmpresaConstantesFunciones.ID)) {
				this.setMostraridTipoManoProduEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoManoProduEmpresaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoManoProduEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoManoProduEmpresaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoManoProduEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoManoProduEmpresaConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionTipoManoProduEmpresa(esAsigna);
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
		
		
		this.setActivaridTipoManoProduEmpresa(esInicial);
		this.setActivarid_empresaTipoManoProduEmpresa(esInicial);
		this.setActivarnombreTipoManoProduEmpresa(esInicial);
		this.setActivardescripcionTipoManoProduEmpresa(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoManoProduEmpresaConstantesFunciones.ID)) {
				this.setActivaridTipoManoProduEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoManoProduEmpresaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoManoProduEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoManoProduEmpresaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoManoProduEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoManoProduEmpresaConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionTipoManoProduEmpresa(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoManoProduEmpresaBeanSwingJInternalFrame tipomanoproduempresaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoManoProduEmpresa(esInicial);
		this.setResaltarid_empresaTipoManoProduEmpresa(esInicial);
		this.setResaltarnombreTipoManoProduEmpresa(esInicial);
		this.setResaltardescripcionTipoManoProduEmpresa(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoManoProduEmpresaConstantesFunciones.ID)) {
				this.setResaltaridTipoManoProduEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoManoProduEmpresaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoManoProduEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoManoProduEmpresaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoManoProduEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoManoProduEmpresaConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionTipoManoProduEmpresa(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoManoProduEmpresaBeanSwingJInternalFrame tipomanoproduempresaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpresaTipoManoProduEmpresa=true;

	public Boolean getMostrarFK_IdEmpresaTipoManoProduEmpresa() {
		return this.mostrarFK_IdEmpresaTipoManoProduEmpresa;
	}

	public void setMostrarFK_IdEmpresaTipoManoProduEmpresa(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoManoProduEmpresa= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaTipoManoProduEmpresa=true;

	public Boolean getActivarFK_IdEmpresaTipoManoProduEmpresa() {
		return this.activarFK_IdEmpresaTipoManoProduEmpresa;
	}

	public void setActivarFK_IdEmpresaTipoManoProduEmpresa(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoManoProduEmpresa= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaTipoManoProduEmpresa=null;

	public Border getResaltarFK_IdEmpresaTipoManoProduEmpresa() {
		return this.resaltarFK_IdEmpresaTipoManoProduEmpresa;
	}

	public void setResaltarFK_IdEmpresaTipoManoProduEmpresa(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoManoProduEmpresa= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoManoProduEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoManoProduEmpresaBeanSwingJInternalFrame tipomanoproduempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoManoProduEmpresa= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}