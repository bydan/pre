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


import com.bydan.erp.contabilidad.util.NivelCentroCostoConstantesFunciones;
import com.bydan.erp.contabilidad.util.NivelCentroCostoParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.NivelCentroCostoParameterGeneral;

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
final public class NivelCentroCostoConstantesFunciones extends NivelCentroCostoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="NivelCentroCosto";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="NivelCentroCosto"+NivelCentroCostoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="NivelCentroCostoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="NivelCentroCostoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=NivelCentroCostoConstantesFunciones.SCHEMA+"_"+NivelCentroCostoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/NivelCentroCostoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=NivelCentroCostoConstantesFunciones.SCHEMA+"_"+NivelCentroCostoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=NivelCentroCostoConstantesFunciones.SCHEMA+"_"+NivelCentroCostoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/NivelCentroCostoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=NivelCentroCostoConstantesFunciones.SCHEMA+"_"+NivelCentroCostoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+NivelCentroCostoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/NivelCentroCostoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+NivelCentroCostoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+NivelCentroCostoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/NivelCentroCostoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+NivelCentroCostoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=NivelCentroCostoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+NivelCentroCostoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=NivelCentroCostoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+NivelCentroCostoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Nivel Centro Costos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Nivel Centro Costo";
	public static final String SCLASSWEBTITULO_LOWER="Nivel Centro Costo";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="NivelCentroCosto";
	public static final String OBJECTNAME="nivelcentrocosto";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="nivel_centro_costo";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select nivelcentrocosto from "+NivelCentroCostoConstantesFunciones.SPERSISTENCENAME+" nivelcentrocosto";
	public static String QUERYSELECTNATIVE="select "+NivelCentroCostoConstantesFunciones.SCHEMA+"."+NivelCentroCostoConstantesFunciones.TABLENAME+".id,"+NivelCentroCostoConstantesFunciones.SCHEMA+"."+NivelCentroCostoConstantesFunciones.TABLENAME+".version_row,"+NivelCentroCostoConstantesFunciones.SCHEMA+"."+NivelCentroCostoConstantesFunciones.TABLENAME+".id_empresa,"+NivelCentroCostoConstantesFunciones.SCHEMA+"."+NivelCentroCostoConstantesFunciones.TABLENAME+".nivel,"+NivelCentroCostoConstantesFunciones.SCHEMA+"."+NivelCentroCostoConstantesFunciones.TABLENAME+".numero_digitos from "+NivelCentroCostoConstantesFunciones.SCHEMA+"."+NivelCentroCostoConstantesFunciones.TABLENAME;//+" as "+NivelCentroCostoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected NivelCentroCostoConstantesFuncionesAdditional nivelcentrocostoConstantesFuncionesAdditional=null;
	
	public NivelCentroCostoConstantesFuncionesAdditional getNivelCentroCostoConstantesFuncionesAdditional() {
		return this.nivelcentrocostoConstantesFuncionesAdditional;
	}
	
	public void setNivelCentroCostoConstantesFuncionesAdditional(NivelCentroCostoConstantesFuncionesAdditional nivelcentrocostoConstantesFuncionesAdditional) {
		try {
			this.nivelcentrocostoConstantesFuncionesAdditional=nivelcentrocostoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String NIVEL= "nivel";
    public static final String NUMERODIGITOS= "numero_digitos";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_NIVEL= "Nivel";
		public static final String LABEL_NIVEL_LOWER= "Nivel";
    	public static final String LABEL_NUMERODIGITOS= "Numero Digitos";
		public static final String LABEL_NUMERODIGITOS_LOWER= "Numero Digitos";
	
		
		
		
		
		
	
	public static String getNivelCentroCostoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(NivelCentroCostoConstantesFunciones.IDEMPRESA)) {sLabelColumna=NivelCentroCostoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(NivelCentroCostoConstantesFunciones.NIVEL)) {sLabelColumna=NivelCentroCostoConstantesFunciones.LABEL_NIVEL;}
		if(sNombreColumna.equals(NivelCentroCostoConstantesFunciones.NUMERODIGITOS)) {sLabelColumna=NivelCentroCostoConstantesFunciones.LABEL_NUMERODIGITOS;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getNivelCentroCostoDescripcion(NivelCentroCosto nivelcentrocosto) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(nivelcentrocosto !=null/* && nivelcentrocosto.getId()!=0*/) {
			if(nivelcentrocosto.getId()!=null) {
				sDescripcion=nivelcentrocosto.getId().toString();
			}//nivelcentrocostonivelcentrocosto.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getNivelCentroCostoDescripcionDetallado(NivelCentroCosto nivelcentrocosto) {
		String sDescripcion="";
			
		sDescripcion+=NivelCentroCostoConstantesFunciones.ID+"=";
		sDescripcion+=nivelcentrocosto.getId().toString()+",";
		sDescripcion+=NivelCentroCostoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=nivelcentrocosto.getVersionRow().toString()+",";
		sDescripcion+=NivelCentroCostoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=nivelcentrocosto.getid_empresa().toString()+",";
		sDescripcion+=NivelCentroCostoConstantesFunciones.NIVEL+"=";
		sDescripcion+=nivelcentrocosto.getnivel().toString()+",";
		sDescripcion+=NivelCentroCostoConstantesFunciones.NUMERODIGITOS+"=";
		sDescripcion+=nivelcentrocosto.getnumero_digitos().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setNivelCentroCostoDescripcion(NivelCentroCosto nivelcentrocosto,String sValor) throws Exception {			
		if(nivelcentrocosto !=null) {
			//nivelcentrocostonivelcentrocosto.getId().toString();
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
	
	
	
	
	
	
	public static void quitarEspaciosNivelCentroCosto(NivelCentroCosto nivelcentrocosto,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosNivelCentroCostos(List<NivelCentroCosto> nivelcentrocostos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(NivelCentroCosto nivelcentrocosto: nivelcentrocostos) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresNivelCentroCosto(NivelCentroCosto nivelcentrocosto,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && nivelcentrocosto.getConCambioAuxiliar()) {
			nivelcentrocosto.setIsDeleted(nivelcentrocosto.getIsDeletedAuxiliar());	
			nivelcentrocosto.setIsNew(nivelcentrocosto.getIsNewAuxiliar());	
			nivelcentrocosto.setIsChanged(nivelcentrocosto.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			nivelcentrocosto.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			nivelcentrocosto.setIsDeletedAuxiliar(false);	
			nivelcentrocosto.setIsNewAuxiliar(false);	
			nivelcentrocosto.setIsChangedAuxiliar(false);
			
			nivelcentrocosto.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresNivelCentroCostos(List<NivelCentroCosto> nivelcentrocostos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(NivelCentroCosto nivelcentrocosto : nivelcentrocostos) {
			if(conAsignarBase && nivelcentrocosto.getConCambioAuxiliar()) {
				nivelcentrocosto.setIsDeleted(nivelcentrocosto.getIsDeletedAuxiliar());	
				nivelcentrocosto.setIsNew(nivelcentrocosto.getIsNewAuxiliar());	
				nivelcentrocosto.setIsChanged(nivelcentrocosto.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				nivelcentrocosto.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				nivelcentrocosto.setIsDeletedAuxiliar(false);	
				nivelcentrocosto.setIsNewAuxiliar(false);	
				nivelcentrocosto.setIsChangedAuxiliar(false);
				
				nivelcentrocosto.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresNivelCentroCosto(NivelCentroCosto nivelcentrocosto,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
			nivelcentrocosto.setnivel(0);
			nivelcentrocosto.setnumero_digitos(0);
		}
	}		
	
	public static void InicializarValoresNivelCentroCostos(List<NivelCentroCosto> nivelcentrocostos,Boolean conEnteros) throws Exception  {
		
		for(NivelCentroCosto nivelcentrocosto: nivelcentrocostos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
				nivelcentrocosto.setnivel(0);
				nivelcentrocosto.setnumero_digitos(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaNivelCentroCosto(List<NivelCentroCosto> nivelcentrocostos,NivelCentroCosto nivelcentrocostoAux) throws Exception  {
		NivelCentroCostoConstantesFunciones.InicializarValoresNivelCentroCosto(nivelcentrocostoAux,true);
		
		for(NivelCentroCosto nivelcentrocosto: nivelcentrocostos) {
			if(nivelcentrocosto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			nivelcentrocostoAux.setnivel(nivelcentrocostoAux.getnivel()+nivelcentrocosto.getnivel());			
			nivelcentrocostoAux.setnumero_digitos(nivelcentrocostoAux.getnumero_digitos()+nivelcentrocosto.getnumero_digitos());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNivelCentroCosto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=NivelCentroCostoConstantesFunciones.getArrayColumnasGlobalesNivelCentroCosto(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesNivelCentroCosto(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(NivelCentroCostoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(NivelCentroCostoConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoNivelCentroCosto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<NivelCentroCosto> nivelcentrocostos,NivelCentroCosto nivelcentrocosto,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(NivelCentroCosto nivelcentrocostoAux: nivelcentrocostos) {
			if(nivelcentrocostoAux!=null && nivelcentrocosto!=null) {
				if((nivelcentrocostoAux.getId()==null && nivelcentrocosto.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(nivelcentrocostoAux.getId()!=null && nivelcentrocosto.getId()!=null){
					if(nivelcentrocostoAux.getId().equals(nivelcentrocosto.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaNivelCentroCosto(List<NivelCentroCosto> nivelcentrocostos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(NivelCentroCosto nivelcentrocosto: nivelcentrocostos) {			
			if(nivelcentrocosto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaNivelCentroCosto() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,NivelCentroCostoConstantesFunciones.LABEL_ID, NivelCentroCostoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NivelCentroCostoConstantesFunciones.LABEL_VERSIONROW, NivelCentroCostoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NivelCentroCostoConstantesFunciones.LABEL_IDEMPRESA, NivelCentroCostoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NivelCentroCostoConstantesFunciones.LABEL_NIVEL, NivelCentroCostoConstantesFunciones.NIVEL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NivelCentroCostoConstantesFunciones.LABEL_NUMERODIGITOS, NivelCentroCostoConstantesFunciones.NUMERODIGITOS,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasNivelCentroCosto() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=NivelCentroCostoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NivelCentroCostoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NivelCentroCostoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NivelCentroCostoConstantesFunciones.NIVEL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NivelCentroCostoConstantesFunciones.NUMERODIGITOS;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarNivelCentroCosto() throws Exception  {
		return NivelCentroCostoConstantesFunciones.getTiposSeleccionarNivelCentroCosto(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarNivelCentroCosto(Boolean conFk) throws Exception  {
		return NivelCentroCostoConstantesFunciones.getTiposSeleccionarNivelCentroCosto(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarNivelCentroCosto(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NivelCentroCostoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(NivelCentroCostoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NivelCentroCostoConstantesFunciones.LABEL_NIVEL);
			reporte.setsDescripcion(NivelCentroCostoConstantesFunciones.LABEL_NIVEL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NivelCentroCostoConstantesFunciones.LABEL_NUMERODIGITOS);
			reporte.setsDescripcion(NivelCentroCostoConstantesFunciones.LABEL_NUMERODIGITOS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesNivelCentroCosto(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesNivelCentroCosto(NivelCentroCosto nivelcentrocostoAux) throws Exception {
		
			nivelcentrocostoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(nivelcentrocostoAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesNivelCentroCosto(List<NivelCentroCosto> nivelcentrocostosTemp) throws Exception {
		for(NivelCentroCosto nivelcentrocostoAux:nivelcentrocostosTemp) {
			
			nivelcentrocostoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(nivelcentrocostoAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfNivelCentroCosto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfNivelCentroCosto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfNivelCentroCosto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return NivelCentroCostoConstantesFunciones.getClassesRelationshipsOfNivelCentroCosto(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfNivelCentroCosto(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfNivelCentroCosto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return NivelCentroCostoConstantesFunciones.getClassesRelationshipsFromStringsOfNivelCentroCosto(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfNivelCentroCosto(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(NivelCentroCosto nivelcentrocosto,List<NivelCentroCosto> nivelcentrocostos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			NivelCentroCosto nivelcentrocostoEncontrado=null;
			
			for(NivelCentroCosto nivelcentrocostoLocal:nivelcentrocostos) {
				if(nivelcentrocostoLocal.getId().equals(nivelcentrocosto.getId())) {
					nivelcentrocostoEncontrado=nivelcentrocostoLocal;
					
					nivelcentrocostoLocal.setIsChanged(nivelcentrocosto.getIsChanged());
					nivelcentrocostoLocal.setIsNew(nivelcentrocosto.getIsNew());
					nivelcentrocostoLocal.setIsDeleted(nivelcentrocosto.getIsDeleted());
					
					nivelcentrocostoLocal.setGeneralEntityOriginal(nivelcentrocosto.getGeneralEntityOriginal());
					
					nivelcentrocostoLocal.setId(nivelcentrocosto.getId());	
					nivelcentrocostoLocal.setVersionRow(nivelcentrocosto.getVersionRow());	
					nivelcentrocostoLocal.setid_empresa(nivelcentrocosto.getid_empresa());	
					nivelcentrocostoLocal.setnivel(nivelcentrocosto.getnivel());	
					nivelcentrocostoLocal.setnumero_digitos(nivelcentrocosto.getnumero_digitos());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!nivelcentrocosto.getIsDeleted()) {
				if(!existe) {
					nivelcentrocostos.add(nivelcentrocosto);
				}
			} else {
				if(nivelcentrocostoEncontrado!=null && permiteQuitar)  {
					nivelcentrocostos.remove(nivelcentrocostoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(NivelCentroCosto nivelcentrocosto,List<NivelCentroCosto> nivelcentrocostos) throws Exception {
		try	{			
			for(NivelCentroCosto nivelcentrocostoLocal:nivelcentrocostos) {
				if(nivelcentrocostoLocal.getId().equals(nivelcentrocosto.getId())) {
					nivelcentrocostoLocal.setIsSelected(nivelcentrocosto.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesNivelCentroCosto(List<NivelCentroCosto> nivelcentrocostosAux) throws Exception {
		//this.nivelcentrocostosAux=nivelcentrocostosAux;
		
		for(NivelCentroCosto nivelcentrocostoAux:nivelcentrocostosAux) {
			if(nivelcentrocostoAux.getIsChanged()) {
				nivelcentrocostoAux.setIsChanged(false);
			}		
			
			if(nivelcentrocostoAux.getIsNew()) {
				nivelcentrocostoAux.setIsNew(false);
			}	
			
			if(nivelcentrocostoAux.getIsDeleted()) {
				nivelcentrocostoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesNivelCentroCosto(NivelCentroCosto nivelcentrocostoAux) throws Exception {
		//this.nivelcentrocostoAux=nivelcentrocostoAux;
		
			if(nivelcentrocostoAux.getIsChanged()) {
				nivelcentrocostoAux.setIsChanged(false);
			}		
			
			if(nivelcentrocostoAux.getIsNew()) {
				nivelcentrocostoAux.setIsNew(false);
			}	
			
			if(nivelcentrocostoAux.getIsDeleted()) {
				nivelcentrocostoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(NivelCentroCosto nivelcentrocostoAsignar,NivelCentroCosto nivelcentrocosto) throws Exception {
		nivelcentrocostoAsignar.setId(nivelcentrocosto.getId());	
		nivelcentrocostoAsignar.setVersionRow(nivelcentrocosto.getVersionRow());	
		nivelcentrocostoAsignar.setid_empresa(nivelcentrocosto.getid_empresa());
		nivelcentrocostoAsignar.setempresa_descripcion(nivelcentrocosto.getempresa_descripcion());	
		nivelcentrocostoAsignar.setnivel(nivelcentrocosto.getnivel());	
		nivelcentrocostoAsignar.setnumero_digitos(nivelcentrocosto.getnumero_digitos());	
	}
	
	public static void inicializarNivelCentroCosto(NivelCentroCosto nivelcentrocosto) throws Exception {
		try {
				nivelcentrocosto.setId(0L);	
					
				nivelcentrocosto.setid_empresa(-1L);	
				nivelcentrocosto.setnivel(0);	
				nivelcentrocosto.setnumero_digitos(0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderNivelCentroCosto(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(NivelCentroCostoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NivelCentroCostoConstantesFunciones.LABEL_NIVEL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NivelCentroCostoConstantesFunciones.LABEL_NUMERODIGITOS);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataNivelCentroCosto(String sTipo,Row row,Workbook workbook,NivelCentroCosto nivelcentrocosto,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(nivelcentrocosto.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(nivelcentrocosto.getnivel());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(nivelcentrocosto.getnumero_digitos());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryNivelCentroCosto=Constantes.SFINALQUERY;
	
	public String getsFinalQueryNivelCentroCosto() {
		return this.sFinalQueryNivelCentroCosto;
	}
	
	public void setsFinalQueryNivelCentroCosto(String sFinalQueryNivelCentroCosto) {
		this.sFinalQueryNivelCentroCosto= sFinalQueryNivelCentroCosto;
	}
	
	public Border resaltarSeleccionarNivelCentroCosto=null;
	
	public Border setResaltarSeleccionarNivelCentroCosto(ParametroGeneralUsuario parametroGeneralUsuario/*NivelCentroCostoBeanSwingJInternalFrame nivelcentrocostoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//nivelcentrocostoBeanSwingJInternalFrame.jTtoolBarNivelCentroCosto.setBorder(borderResaltar);
		
		this.resaltarSeleccionarNivelCentroCosto= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarNivelCentroCosto() {
		return this.resaltarSeleccionarNivelCentroCosto;
	}
	
	public void setResaltarSeleccionarNivelCentroCosto(Border borderResaltarSeleccionarNivelCentroCosto) {
		this.resaltarSeleccionarNivelCentroCosto= borderResaltarSeleccionarNivelCentroCosto;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridNivelCentroCosto=null;
	public Boolean mostraridNivelCentroCosto=true;
	public Boolean activaridNivelCentroCosto=true;

	public Border resaltarid_empresaNivelCentroCosto=null;
	public Boolean mostrarid_empresaNivelCentroCosto=true;
	public Boolean activarid_empresaNivelCentroCosto=true;
	public Boolean cargarid_empresaNivelCentroCosto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaNivelCentroCosto=false;//ConEventDepend=true

	public Border resaltarnivelNivelCentroCosto=null;
	public Boolean mostrarnivelNivelCentroCosto=true;
	public Boolean activarnivelNivelCentroCosto=true;

	public Border resaltarnumero_digitosNivelCentroCosto=null;
	public Boolean mostrarnumero_digitosNivelCentroCosto=true;
	public Boolean activarnumero_digitosNivelCentroCosto=true;

	
	

	public Border setResaltaridNivelCentroCosto(ParametroGeneralUsuario parametroGeneralUsuario/*NivelCentroCostoBeanSwingJInternalFrame nivelcentrocostoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//nivelcentrocostoBeanSwingJInternalFrame.jTtoolBarNivelCentroCosto.setBorder(borderResaltar);
		
		this.resaltaridNivelCentroCosto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridNivelCentroCosto() {
		return this.resaltaridNivelCentroCosto;
	}

	public void setResaltaridNivelCentroCosto(Border borderResaltar) {
		this.resaltaridNivelCentroCosto= borderResaltar;
	}

	public Boolean getMostraridNivelCentroCosto() {
		return this.mostraridNivelCentroCosto;
	}

	public void setMostraridNivelCentroCosto(Boolean mostraridNivelCentroCosto) {
		this.mostraridNivelCentroCosto= mostraridNivelCentroCosto;
	}

	public Boolean getActivaridNivelCentroCosto() {
		return this.activaridNivelCentroCosto;
	}

	public void setActivaridNivelCentroCosto(Boolean activaridNivelCentroCosto) {
		this.activaridNivelCentroCosto= activaridNivelCentroCosto;
	}

	public Border setResaltarid_empresaNivelCentroCosto(ParametroGeneralUsuario parametroGeneralUsuario/*NivelCentroCostoBeanSwingJInternalFrame nivelcentrocostoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//nivelcentrocostoBeanSwingJInternalFrame.jTtoolBarNivelCentroCosto.setBorder(borderResaltar);
		
		this.resaltarid_empresaNivelCentroCosto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaNivelCentroCosto() {
		return this.resaltarid_empresaNivelCentroCosto;
	}

	public void setResaltarid_empresaNivelCentroCosto(Border borderResaltar) {
		this.resaltarid_empresaNivelCentroCosto= borderResaltar;
	}

	public Boolean getMostrarid_empresaNivelCentroCosto() {
		return this.mostrarid_empresaNivelCentroCosto;
	}

	public void setMostrarid_empresaNivelCentroCosto(Boolean mostrarid_empresaNivelCentroCosto) {
		this.mostrarid_empresaNivelCentroCosto= mostrarid_empresaNivelCentroCosto;
	}

	public Boolean getActivarid_empresaNivelCentroCosto() {
		return this.activarid_empresaNivelCentroCosto;
	}

	public void setActivarid_empresaNivelCentroCosto(Boolean activarid_empresaNivelCentroCosto) {
		this.activarid_empresaNivelCentroCosto= activarid_empresaNivelCentroCosto;
	}

	public Boolean getCargarid_empresaNivelCentroCosto() {
		return this.cargarid_empresaNivelCentroCosto;
	}

	public void setCargarid_empresaNivelCentroCosto(Boolean cargarid_empresaNivelCentroCosto) {
		this.cargarid_empresaNivelCentroCosto= cargarid_empresaNivelCentroCosto;
	}

	public Border setResaltarnivelNivelCentroCosto(ParametroGeneralUsuario parametroGeneralUsuario/*NivelCentroCostoBeanSwingJInternalFrame nivelcentrocostoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//nivelcentrocostoBeanSwingJInternalFrame.jTtoolBarNivelCentroCosto.setBorder(borderResaltar);
		
		this.resaltarnivelNivelCentroCosto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnivelNivelCentroCosto() {
		return this.resaltarnivelNivelCentroCosto;
	}

	public void setResaltarnivelNivelCentroCosto(Border borderResaltar) {
		this.resaltarnivelNivelCentroCosto= borderResaltar;
	}

	public Boolean getMostrarnivelNivelCentroCosto() {
		return this.mostrarnivelNivelCentroCosto;
	}

	public void setMostrarnivelNivelCentroCosto(Boolean mostrarnivelNivelCentroCosto) {
		this.mostrarnivelNivelCentroCosto= mostrarnivelNivelCentroCosto;
	}

	public Boolean getActivarnivelNivelCentroCosto() {
		return this.activarnivelNivelCentroCosto;
	}

	public void setActivarnivelNivelCentroCosto(Boolean activarnivelNivelCentroCosto) {
		this.activarnivelNivelCentroCosto= activarnivelNivelCentroCosto;
	}

	public Border setResaltarnumero_digitosNivelCentroCosto(ParametroGeneralUsuario parametroGeneralUsuario/*NivelCentroCostoBeanSwingJInternalFrame nivelcentrocostoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//nivelcentrocostoBeanSwingJInternalFrame.jTtoolBarNivelCentroCosto.setBorder(borderResaltar);
		
		this.resaltarnumero_digitosNivelCentroCosto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_digitosNivelCentroCosto() {
		return this.resaltarnumero_digitosNivelCentroCosto;
	}

	public void setResaltarnumero_digitosNivelCentroCosto(Border borderResaltar) {
		this.resaltarnumero_digitosNivelCentroCosto= borderResaltar;
	}

	public Boolean getMostrarnumero_digitosNivelCentroCosto() {
		return this.mostrarnumero_digitosNivelCentroCosto;
	}

	public void setMostrarnumero_digitosNivelCentroCosto(Boolean mostrarnumero_digitosNivelCentroCosto) {
		this.mostrarnumero_digitosNivelCentroCosto= mostrarnumero_digitosNivelCentroCosto;
	}

	public Boolean getActivarnumero_digitosNivelCentroCosto() {
		return this.activarnumero_digitosNivelCentroCosto;
	}

	public void setActivarnumero_digitosNivelCentroCosto(Boolean activarnumero_digitosNivelCentroCosto) {
		this.activarnumero_digitosNivelCentroCosto= activarnumero_digitosNivelCentroCosto;
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
		
		
		this.setMostraridNivelCentroCosto(esInicial);
		this.setMostrarid_empresaNivelCentroCosto(esInicial);
		this.setMostrarnivelNivelCentroCosto(esInicial);
		this.setMostrarnumero_digitosNivelCentroCosto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(NivelCentroCostoConstantesFunciones.ID)) {
				this.setMostraridNivelCentroCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(NivelCentroCostoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaNivelCentroCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(NivelCentroCostoConstantesFunciones.NIVEL)) {
				this.setMostrarnivelNivelCentroCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(NivelCentroCostoConstantesFunciones.NUMERODIGITOS)) {
				this.setMostrarnumero_digitosNivelCentroCosto(esAsigna);
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
		
		
		this.setActivaridNivelCentroCosto(esInicial);
		this.setActivarid_empresaNivelCentroCosto(esInicial);
		this.setActivarnivelNivelCentroCosto(esInicial);
		this.setActivarnumero_digitosNivelCentroCosto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(NivelCentroCostoConstantesFunciones.ID)) {
				this.setActivaridNivelCentroCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(NivelCentroCostoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaNivelCentroCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(NivelCentroCostoConstantesFunciones.NIVEL)) {
				this.setActivarnivelNivelCentroCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(NivelCentroCostoConstantesFunciones.NUMERODIGITOS)) {
				this.setActivarnumero_digitosNivelCentroCosto(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,NivelCentroCostoBeanSwingJInternalFrame nivelcentrocostoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridNivelCentroCosto(esInicial);
		this.setResaltarid_empresaNivelCentroCosto(esInicial);
		this.setResaltarnivelNivelCentroCosto(esInicial);
		this.setResaltarnumero_digitosNivelCentroCosto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(NivelCentroCostoConstantesFunciones.ID)) {
				this.setResaltaridNivelCentroCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(NivelCentroCostoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaNivelCentroCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(NivelCentroCostoConstantesFunciones.NIVEL)) {
				this.setResaltarnivelNivelCentroCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(NivelCentroCostoConstantesFunciones.NUMERODIGITOS)) {
				this.setResaltarnumero_digitosNivelCentroCosto(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,NivelCentroCostoBeanSwingJInternalFrame nivelcentrocostoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpresaNivelCentroCosto=true;

	public Boolean getMostrarFK_IdEmpresaNivelCentroCosto() {
		return this.mostrarFK_IdEmpresaNivelCentroCosto;
	}

	public void setMostrarFK_IdEmpresaNivelCentroCosto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaNivelCentroCosto= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaNivelCentroCosto=true;

	public Boolean getActivarFK_IdEmpresaNivelCentroCosto() {
		return this.activarFK_IdEmpresaNivelCentroCosto;
	}

	public void setActivarFK_IdEmpresaNivelCentroCosto(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaNivelCentroCosto= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaNivelCentroCosto=null;

	public Border getResaltarFK_IdEmpresaNivelCentroCosto() {
		return this.resaltarFK_IdEmpresaNivelCentroCosto;
	}

	public void setResaltarFK_IdEmpresaNivelCentroCosto(Border borderResaltar) {
		this.resaltarFK_IdEmpresaNivelCentroCosto= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaNivelCentroCosto(ParametroGeneralUsuario parametroGeneralUsuario/*NivelCentroCostoBeanSwingJInternalFrame nivelcentrocostoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaNivelCentroCosto= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}