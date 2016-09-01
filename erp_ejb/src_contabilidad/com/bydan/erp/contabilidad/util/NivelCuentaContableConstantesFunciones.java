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


import com.bydan.erp.contabilidad.util.NivelCuentaContableConstantesFunciones;
import com.bydan.erp.contabilidad.util.NivelCuentaContableParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.NivelCuentaContableParameterGeneral;

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
final public class NivelCuentaContableConstantesFunciones extends NivelCuentaContableConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="NivelCuentaContable";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="NivelCuentaContable"+NivelCuentaContableConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="NivelCuentaContableHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="NivelCuentaContableHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=NivelCuentaContableConstantesFunciones.SCHEMA+"_"+NivelCuentaContableConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/NivelCuentaContableHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=NivelCuentaContableConstantesFunciones.SCHEMA+"_"+NivelCuentaContableConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=NivelCuentaContableConstantesFunciones.SCHEMA+"_"+NivelCuentaContableConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/NivelCuentaContableHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=NivelCuentaContableConstantesFunciones.SCHEMA+"_"+NivelCuentaContableConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+NivelCuentaContableConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/NivelCuentaContableHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+NivelCuentaContableConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+NivelCuentaContableConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/NivelCuentaContableHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+NivelCuentaContableConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=NivelCuentaContableConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+NivelCuentaContableConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=NivelCuentaContableConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+NivelCuentaContableConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Nivel Cuenta Contables";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Nivel Cuenta Contable";
	public static final String SCLASSWEBTITULO_LOWER="Nivel Cuenta Contable";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="NivelCuentaContable";
	public static final String OBJECTNAME="nivelcuentacontable";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="nivel_cuenta_contable";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select nivelcuentacontable from "+NivelCuentaContableConstantesFunciones.SPERSISTENCENAME+" nivelcuentacontable";
	public static String QUERYSELECTNATIVE="select "+NivelCuentaContableConstantesFunciones.SCHEMA+"."+NivelCuentaContableConstantesFunciones.TABLENAME+".id,"+NivelCuentaContableConstantesFunciones.SCHEMA+"."+NivelCuentaContableConstantesFunciones.TABLENAME+".version_row,"+NivelCuentaContableConstantesFunciones.SCHEMA+"."+NivelCuentaContableConstantesFunciones.TABLENAME+".id_empresa,"+NivelCuentaContableConstantesFunciones.SCHEMA+"."+NivelCuentaContableConstantesFunciones.TABLENAME+".nivel,"+NivelCuentaContableConstantesFunciones.SCHEMA+"."+NivelCuentaContableConstantesFunciones.TABLENAME+".numero_digitos from "+NivelCuentaContableConstantesFunciones.SCHEMA+"."+NivelCuentaContableConstantesFunciones.TABLENAME;//+" as "+NivelCuentaContableConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected NivelCuentaContableConstantesFuncionesAdditional nivelcuentacontableConstantesFuncionesAdditional=null;
	
	public NivelCuentaContableConstantesFuncionesAdditional getNivelCuentaContableConstantesFuncionesAdditional() {
		return this.nivelcuentacontableConstantesFuncionesAdditional;
	}
	
	public void setNivelCuentaContableConstantesFuncionesAdditional(NivelCuentaContableConstantesFuncionesAdditional nivelcuentacontableConstantesFuncionesAdditional) {
		try {
			this.nivelcuentacontableConstantesFuncionesAdditional=nivelcuentacontableConstantesFuncionesAdditional;
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
	
		
		
		
		
		
	
	public static String getNivelCuentaContableLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(NivelCuentaContableConstantesFunciones.IDEMPRESA)) {sLabelColumna=NivelCuentaContableConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(NivelCuentaContableConstantesFunciones.NIVEL)) {sLabelColumna=NivelCuentaContableConstantesFunciones.LABEL_NIVEL;}
		if(sNombreColumna.equals(NivelCuentaContableConstantesFunciones.NUMERODIGITOS)) {sLabelColumna=NivelCuentaContableConstantesFunciones.LABEL_NUMERODIGITOS;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getNivelCuentaContableDescripcion(NivelCuentaContable nivelcuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(nivelcuentacontable !=null/* && nivelcuentacontable.getId()!=0*/) {
			if(nivelcuentacontable.getId()!=null) {
				sDescripcion=nivelcuentacontable.getId().toString();
			}//nivelcuentacontablenivelcuentacontable.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getNivelCuentaContableDescripcionDetallado(NivelCuentaContable nivelcuentacontable) {
		String sDescripcion="";
			
		sDescripcion+=NivelCuentaContableConstantesFunciones.ID+"=";
		sDescripcion+=nivelcuentacontable.getId().toString()+",";
		sDescripcion+=NivelCuentaContableConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=nivelcuentacontable.getVersionRow().toString()+",";
		sDescripcion+=NivelCuentaContableConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=nivelcuentacontable.getid_empresa().toString()+",";
		sDescripcion+=NivelCuentaContableConstantesFunciones.NIVEL+"=";
		sDescripcion+=nivelcuentacontable.getnivel().toString()+",";
		sDescripcion+=NivelCuentaContableConstantesFunciones.NUMERODIGITOS+"=";
		sDescripcion+=nivelcuentacontable.getnumero_digitos().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setNivelCuentaContableDescripcion(NivelCuentaContable nivelcuentacontable,String sValor) throws Exception {			
		if(nivelcuentacontable !=null) {
			//nivelcuentacontablenivelcuentacontable.getId().toString();
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
	
	
	
	
	
	
	public static void quitarEspaciosNivelCuentaContable(NivelCuentaContable nivelcuentacontable,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosNivelCuentaContables(List<NivelCuentaContable> nivelcuentacontables,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(NivelCuentaContable nivelcuentacontable: nivelcuentacontables) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresNivelCuentaContable(NivelCuentaContable nivelcuentacontable,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && nivelcuentacontable.getConCambioAuxiliar()) {
			nivelcuentacontable.setIsDeleted(nivelcuentacontable.getIsDeletedAuxiliar());	
			nivelcuentacontable.setIsNew(nivelcuentacontable.getIsNewAuxiliar());	
			nivelcuentacontable.setIsChanged(nivelcuentacontable.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			nivelcuentacontable.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			nivelcuentacontable.setIsDeletedAuxiliar(false);	
			nivelcuentacontable.setIsNewAuxiliar(false);	
			nivelcuentacontable.setIsChangedAuxiliar(false);
			
			nivelcuentacontable.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresNivelCuentaContables(List<NivelCuentaContable> nivelcuentacontables,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(NivelCuentaContable nivelcuentacontable : nivelcuentacontables) {
			if(conAsignarBase && nivelcuentacontable.getConCambioAuxiliar()) {
				nivelcuentacontable.setIsDeleted(nivelcuentacontable.getIsDeletedAuxiliar());	
				nivelcuentacontable.setIsNew(nivelcuentacontable.getIsNewAuxiliar());	
				nivelcuentacontable.setIsChanged(nivelcuentacontable.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				nivelcuentacontable.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				nivelcuentacontable.setIsDeletedAuxiliar(false);	
				nivelcuentacontable.setIsNewAuxiliar(false);	
				nivelcuentacontable.setIsChangedAuxiliar(false);
				
				nivelcuentacontable.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresNivelCuentaContable(NivelCuentaContable nivelcuentacontable,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
			nivelcuentacontable.setnivel(0);
			nivelcuentacontable.setnumero_digitos(0);
		}
	}		
	
	public static void InicializarValoresNivelCuentaContables(List<NivelCuentaContable> nivelcuentacontables,Boolean conEnteros) throws Exception  {
		
		for(NivelCuentaContable nivelcuentacontable: nivelcuentacontables) {
		
			if(conEnteros) {
				Short ish_value=0;
				
				nivelcuentacontable.setnivel(0);
				nivelcuentacontable.setnumero_digitos(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaNivelCuentaContable(List<NivelCuentaContable> nivelcuentacontables,NivelCuentaContable nivelcuentacontableAux) throws Exception  {
		NivelCuentaContableConstantesFunciones.InicializarValoresNivelCuentaContable(nivelcuentacontableAux,true);
		
		for(NivelCuentaContable nivelcuentacontable: nivelcuentacontables) {
			if(nivelcuentacontable.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			nivelcuentacontableAux.setnivel(nivelcuentacontableAux.getnivel()+nivelcuentacontable.getnivel());			
			nivelcuentacontableAux.setnumero_digitos(nivelcuentacontableAux.getnumero_digitos()+nivelcuentacontable.getnumero_digitos());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNivelCuentaContable(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=NivelCuentaContableConstantesFunciones.getArrayColumnasGlobalesNivelCuentaContable(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesNivelCuentaContable(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(NivelCuentaContableConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(NivelCuentaContableConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoNivelCuentaContable(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<NivelCuentaContable> nivelcuentacontables,NivelCuentaContable nivelcuentacontable,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(NivelCuentaContable nivelcuentacontableAux: nivelcuentacontables) {
			if(nivelcuentacontableAux!=null && nivelcuentacontable!=null) {
				if((nivelcuentacontableAux.getId()==null && nivelcuentacontable.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(nivelcuentacontableAux.getId()!=null && nivelcuentacontable.getId()!=null){
					if(nivelcuentacontableAux.getId().equals(nivelcuentacontable.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaNivelCuentaContable(List<NivelCuentaContable> nivelcuentacontables) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(NivelCuentaContable nivelcuentacontable: nivelcuentacontables) {			
			if(nivelcuentacontable.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaNivelCuentaContable() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,NivelCuentaContableConstantesFunciones.LABEL_ID, NivelCuentaContableConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NivelCuentaContableConstantesFunciones.LABEL_VERSIONROW, NivelCuentaContableConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NivelCuentaContableConstantesFunciones.LABEL_IDEMPRESA, NivelCuentaContableConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NivelCuentaContableConstantesFunciones.LABEL_NIVEL, NivelCuentaContableConstantesFunciones.NIVEL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NivelCuentaContableConstantesFunciones.LABEL_NUMERODIGITOS, NivelCuentaContableConstantesFunciones.NUMERODIGITOS,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasNivelCuentaContable() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=NivelCuentaContableConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NivelCuentaContableConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NivelCuentaContableConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NivelCuentaContableConstantesFunciones.NIVEL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NivelCuentaContableConstantesFunciones.NUMERODIGITOS;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarNivelCuentaContable() throws Exception  {
		return NivelCuentaContableConstantesFunciones.getTiposSeleccionarNivelCuentaContable(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarNivelCuentaContable(Boolean conFk) throws Exception  {
		return NivelCuentaContableConstantesFunciones.getTiposSeleccionarNivelCuentaContable(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarNivelCuentaContable(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NivelCuentaContableConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(NivelCuentaContableConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NivelCuentaContableConstantesFunciones.LABEL_NIVEL);
			reporte.setsDescripcion(NivelCuentaContableConstantesFunciones.LABEL_NIVEL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NivelCuentaContableConstantesFunciones.LABEL_NUMERODIGITOS);
			reporte.setsDescripcion(NivelCuentaContableConstantesFunciones.LABEL_NUMERODIGITOS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesNivelCuentaContable(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesNivelCuentaContable(NivelCuentaContable nivelcuentacontableAux) throws Exception {
		
			nivelcuentacontableAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(nivelcuentacontableAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesNivelCuentaContable(List<NivelCuentaContable> nivelcuentacontablesTemp) throws Exception {
		for(NivelCuentaContable nivelcuentacontableAux:nivelcuentacontablesTemp) {
			
			nivelcuentacontableAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(nivelcuentacontableAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfNivelCuentaContable(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfNivelCuentaContable(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfNivelCuentaContable(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return NivelCuentaContableConstantesFunciones.getClassesRelationshipsOfNivelCuentaContable(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfNivelCuentaContable(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfNivelCuentaContable(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return NivelCuentaContableConstantesFunciones.getClassesRelationshipsFromStringsOfNivelCuentaContable(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfNivelCuentaContable(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(NivelCuentaContable nivelcuentacontable,List<NivelCuentaContable> nivelcuentacontables,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			NivelCuentaContable nivelcuentacontableEncontrado=null;
			
			for(NivelCuentaContable nivelcuentacontableLocal:nivelcuentacontables) {
				if(nivelcuentacontableLocal.getId().equals(nivelcuentacontable.getId())) {
					nivelcuentacontableEncontrado=nivelcuentacontableLocal;
					
					nivelcuentacontableLocal.setIsChanged(nivelcuentacontable.getIsChanged());
					nivelcuentacontableLocal.setIsNew(nivelcuentacontable.getIsNew());
					nivelcuentacontableLocal.setIsDeleted(nivelcuentacontable.getIsDeleted());
					
					nivelcuentacontableLocal.setGeneralEntityOriginal(nivelcuentacontable.getGeneralEntityOriginal());
					
					nivelcuentacontableLocal.setId(nivelcuentacontable.getId());	
					nivelcuentacontableLocal.setVersionRow(nivelcuentacontable.getVersionRow());	
					nivelcuentacontableLocal.setid_empresa(nivelcuentacontable.getid_empresa());	
					nivelcuentacontableLocal.setnivel(nivelcuentacontable.getnivel());	
					nivelcuentacontableLocal.setnumero_digitos(nivelcuentacontable.getnumero_digitos());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!nivelcuentacontable.getIsDeleted()) {
				if(!existe) {
					nivelcuentacontables.add(nivelcuentacontable);
				}
			} else {
				if(nivelcuentacontableEncontrado!=null && permiteQuitar)  {
					nivelcuentacontables.remove(nivelcuentacontableEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(NivelCuentaContable nivelcuentacontable,List<NivelCuentaContable> nivelcuentacontables) throws Exception {
		try	{			
			for(NivelCuentaContable nivelcuentacontableLocal:nivelcuentacontables) {
				if(nivelcuentacontableLocal.getId().equals(nivelcuentacontable.getId())) {
					nivelcuentacontableLocal.setIsSelected(nivelcuentacontable.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesNivelCuentaContable(List<NivelCuentaContable> nivelcuentacontablesAux) throws Exception {
		//this.nivelcuentacontablesAux=nivelcuentacontablesAux;
		
		for(NivelCuentaContable nivelcuentacontableAux:nivelcuentacontablesAux) {
			if(nivelcuentacontableAux.getIsChanged()) {
				nivelcuentacontableAux.setIsChanged(false);
			}		
			
			if(nivelcuentacontableAux.getIsNew()) {
				nivelcuentacontableAux.setIsNew(false);
			}	
			
			if(nivelcuentacontableAux.getIsDeleted()) {
				nivelcuentacontableAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesNivelCuentaContable(NivelCuentaContable nivelcuentacontableAux) throws Exception {
		//this.nivelcuentacontableAux=nivelcuentacontableAux;
		
			if(nivelcuentacontableAux.getIsChanged()) {
				nivelcuentacontableAux.setIsChanged(false);
			}		
			
			if(nivelcuentacontableAux.getIsNew()) {
				nivelcuentacontableAux.setIsNew(false);
			}	
			
			if(nivelcuentacontableAux.getIsDeleted()) {
				nivelcuentacontableAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(NivelCuentaContable nivelcuentacontableAsignar,NivelCuentaContable nivelcuentacontable) throws Exception {
		nivelcuentacontableAsignar.setId(nivelcuentacontable.getId());	
		nivelcuentacontableAsignar.setVersionRow(nivelcuentacontable.getVersionRow());	
		nivelcuentacontableAsignar.setid_empresa(nivelcuentacontable.getid_empresa());
		nivelcuentacontableAsignar.setempresa_descripcion(nivelcuentacontable.getempresa_descripcion());	
		nivelcuentacontableAsignar.setnivel(nivelcuentacontable.getnivel());	
		nivelcuentacontableAsignar.setnumero_digitos(nivelcuentacontable.getnumero_digitos());	
	}
	
	public static void inicializarNivelCuentaContable(NivelCuentaContable nivelcuentacontable) throws Exception {
		try {
				nivelcuentacontable.setId(0L);	
					
				nivelcuentacontable.setid_empresa(-1L);	
				nivelcuentacontable.setnivel(0);	
				nivelcuentacontable.setnumero_digitos(0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderNivelCuentaContable(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(NivelCuentaContableConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NivelCuentaContableConstantesFunciones.LABEL_NIVEL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NivelCuentaContableConstantesFunciones.LABEL_NUMERODIGITOS);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataNivelCuentaContable(String sTipo,Row row,Workbook workbook,NivelCuentaContable nivelcuentacontable,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(nivelcuentacontable.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(nivelcuentacontable.getnivel());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(nivelcuentacontable.getnumero_digitos());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryNivelCuentaContable=Constantes.SFINALQUERY;
	
	public String getsFinalQueryNivelCuentaContable() {
		return this.sFinalQueryNivelCuentaContable;
	}
	
	public void setsFinalQueryNivelCuentaContable(String sFinalQueryNivelCuentaContable) {
		this.sFinalQueryNivelCuentaContable= sFinalQueryNivelCuentaContable;
	}
	
	public Border resaltarSeleccionarNivelCuentaContable=null;
	
	public Border setResaltarSeleccionarNivelCuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*NivelCuentaContableBeanSwingJInternalFrame nivelcuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//nivelcuentacontableBeanSwingJInternalFrame.jTtoolBarNivelCuentaContable.setBorder(borderResaltar);
		
		this.resaltarSeleccionarNivelCuentaContable= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarNivelCuentaContable() {
		return this.resaltarSeleccionarNivelCuentaContable;
	}
	
	public void setResaltarSeleccionarNivelCuentaContable(Border borderResaltarSeleccionarNivelCuentaContable) {
		this.resaltarSeleccionarNivelCuentaContable= borderResaltarSeleccionarNivelCuentaContable;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridNivelCuentaContable=null;
	public Boolean mostraridNivelCuentaContable=true;
	public Boolean activaridNivelCuentaContable=true;

	public Border resaltarid_empresaNivelCuentaContable=null;
	public Boolean mostrarid_empresaNivelCuentaContable=true;
	public Boolean activarid_empresaNivelCuentaContable=true;
	public Boolean cargarid_empresaNivelCuentaContable=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaNivelCuentaContable=false;//ConEventDepend=true

	public Border resaltarnivelNivelCuentaContable=null;
	public Boolean mostrarnivelNivelCuentaContable=true;
	public Boolean activarnivelNivelCuentaContable=true;

	public Border resaltarnumero_digitosNivelCuentaContable=null;
	public Boolean mostrarnumero_digitosNivelCuentaContable=true;
	public Boolean activarnumero_digitosNivelCuentaContable=true;

	
	

	public Border setResaltaridNivelCuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*NivelCuentaContableBeanSwingJInternalFrame nivelcuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//nivelcuentacontableBeanSwingJInternalFrame.jTtoolBarNivelCuentaContable.setBorder(borderResaltar);
		
		this.resaltaridNivelCuentaContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridNivelCuentaContable() {
		return this.resaltaridNivelCuentaContable;
	}

	public void setResaltaridNivelCuentaContable(Border borderResaltar) {
		this.resaltaridNivelCuentaContable= borderResaltar;
	}

	public Boolean getMostraridNivelCuentaContable() {
		return this.mostraridNivelCuentaContable;
	}

	public void setMostraridNivelCuentaContable(Boolean mostraridNivelCuentaContable) {
		this.mostraridNivelCuentaContable= mostraridNivelCuentaContable;
	}

	public Boolean getActivaridNivelCuentaContable() {
		return this.activaridNivelCuentaContable;
	}

	public void setActivaridNivelCuentaContable(Boolean activaridNivelCuentaContable) {
		this.activaridNivelCuentaContable= activaridNivelCuentaContable;
	}

	public Border setResaltarid_empresaNivelCuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*NivelCuentaContableBeanSwingJInternalFrame nivelcuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//nivelcuentacontableBeanSwingJInternalFrame.jTtoolBarNivelCuentaContable.setBorder(borderResaltar);
		
		this.resaltarid_empresaNivelCuentaContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaNivelCuentaContable() {
		return this.resaltarid_empresaNivelCuentaContable;
	}

	public void setResaltarid_empresaNivelCuentaContable(Border borderResaltar) {
		this.resaltarid_empresaNivelCuentaContable= borderResaltar;
	}

	public Boolean getMostrarid_empresaNivelCuentaContable() {
		return this.mostrarid_empresaNivelCuentaContable;
	}

	public void setMostrarid_empresaNivelCuentaContable(Boolean mostrarid_empresaNivelCuentaContable) {
		this.mostrarid_empresaNivelCuentaContable= mostrarid_empresaNivelCuentaContable;
	}

	public Boolean getActivarid_empresaNivelCuentaContable() {
		return this.activarid_empresaNivelCuentaContable;
	}

	public void setActivarid_empresaNivelCuentaContable(Boolean activarid_empresaNivelCuentaContable) {
		this.activarid_empresaNivelCuentaContable= activarid_empresaNivelCuentaContable;
	}

	public Boolean getCargarid_empresaNivelCuentaContable() {
		return this.cargarid_empresaNivelCuentaContable;
	}

	public void setCargarid_empresaNivelCuentaContable(Boolean cargarid_empresaNivelCuentaContable) {
		this.cargarid_empresaNivelCuentaContable= cargarid_empresaNivelCuentaContable;
	}

	public Border setResaltarnivelNivelCuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*NivelCuentaContableBeanSwingJInternalFrame nivelcuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//nivelcuentacontableBeanSwingJInternalFrame.jTtoolBarNivelCuentaContable.setBorder(borderResaltar);
		
		this.resaltarnivelNivelCuentaContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnivelNivelCuentaContable() {
		return this.resaltarnivelNivelCuentaContable;
	}

	public void setResaltarnivelNivelCuentaContable(Border borderResaltar) {
		this.resaltarnivelNivelCuentaContable= borderResaltar;
	}

	public Boolean getMostrarnivelNivelCuentaContable() {
		return this.mostrarnivelNivelCuentaContable;
	}

	public void setMostrarnivelNivelCuentaContable(Boolean mostrarnivelNivelCuentaContable) {
		this.mostrarnivelNivelCuentaContable= mostrarnivelNivelCuentaContable;
	}

	public Boolean getActivarnivelNivelCuentaContable() {
		return this.activarnivelNivelCuentaContable;
	}

	public void setActivarnivelNivelCuentaContable(Boolean activarnivelNivelCuentaContable) {
		this.activarnivelNivelCuentaContable= activarnivelNivelCuentaContable;
	}

	public Border setResaltarnumero_digitosNivelCuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*NivelCuentaContableBeanSwingJInternalFrame nivelcuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//nivelcuentacontableBeanSwingJInternalFrame.jTtoolBarNivelCuentaContable.setBorder(borderResaltar);
		
		this.resaltarnumero_digitosNivelCuentaContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_digitosNivelCuentaContable() {
		return this.resaltarnumero_digitosNivelCuentaContable;
	}

	public void setResaltarnumero_digitosNivelCuentaContable(Border borderResaltar) {
		this.resaltarnumero_digitosNivelCuentaContable= borderResaltar;
	}

	public Boolean getMostrarnumero_digitosNivelCuentaContable() {
		return this.mostrarnumero_digitosNivelCuentaContable;
	}

	public void setMostrarnumero_digitosNivelCuentaContable(Boolean mostrarnumero_digitosNivelCuentaContable) {
		this.mostrarnumero_digitosNivelCuentaContable= mostrarnumero_digitosNivelCuentaContable;
	}

	public Boolean getActivarnumero_digitosNivelCuentaContable() {
		return this.activarnumero_digitosNivelCuentaContable;
	}

	public void setActivarnumero_digitosNivelCuentaContable(Boolean activarnumero_digitosNivelCuentaContable) {
		this.activarnumero_digitosNivelCuentaContable= activarnumero_digitosNivelCuentaContable;
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
		
		
		this.setMostraridNivelCuentaContable(esInicial);
		this.setMostrarid_empresaNivelCuentaContable(esInicial);
		this.setMostrarnivelNivelCuentaContable(esInicial);
		this.setMostrarnumero_digitosNivelCuentaContable(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(NivelCuentaContableConstantesFunciones.ID)) {
				this.setMostraridNivelCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(NivelCuentaContableConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaNivelCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(NivelCuentaContableConstantesFunciones.NIVEL)) {
				this.setMostrarnivelNivelCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(NivelCuentaContableConstantesFunciones.NUMERODIGITOS)) {
				this.setMostrarnumero_digitosNivelCuentaContable(esAsigna);
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
		
		
		this.setActivaridNivelCuentaContable(esInicial);
		this.setActivarid_empresaNivelCuentaContable(esInicial);
		this.setActivarnivelNivelCuentaContable(esInicial);
		this.setActivarnumero_digitosNivelCuentaContable(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(NivelCuentaContableConstantesFunciones.ID)) {
				this.setActivaridNivelCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(NivelCuentaContableConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaNivelCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(NivelCuentaContableConstantesFunciones.NIVEL)) {
				this.setActivarnivelNivelCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(NivelCuentaContableConstantesFunciones.NUMERODIGITOS)) {
				this.setActivarnumero_digitosNivelCuentaContable(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,NivelCuentaContableBeanSwingJInternalFrame nivelcuentacontableBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridNivelCuentaContable(esInicial);
		this.setResaltarid_empresaNivelCuentaContable(esInicial);
		this.setResaltarnivelNivelCuentaContable(esInicial);
		this.setResaltarnumero_digitosNivelCuentaContable(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(NivelCuentaContableConstantesFunciones.ID)) {
				this.setResaltaridNivelCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(NivelCuentaContableConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaNivelCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(NivelCuentaContableConstantesFunciones.NIVEL)) {
				this.setResaltarnivelNivelCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(NivelCuentaContableConstantesFunciones.NUMERODIGITOS)) {
				this.setResaltarnumero_digitosNivelCuentaContable(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,NivelCuentaContableBeanSwingJInternalFrame nivelcuentacontableBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpresaNivelCuentaContable=true;

	public Boolean getMostrarFK_IdEmpresaNivelCuentaContable() {
		return this.mostrarFK_IdEmpresaNivelCuentaContable;
	}

	public void setMostrarFK_IdEmpresaNivelCuentaContable(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaNivelCuentaContable= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaNivelCuentaContable=true;

	public Boolean getActivarFK_IdEmpresaNivelCuentaContable() {
		return this.activarFK_IdEmpresaNivelCuentaContable;
	}

	public void setActivarFK_IdEmpresaNivelCuentaContable(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaNivelCuentaContable= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaNivelCuentaContable=null;

	public Border getResaltarFK_IdEmpresaNivelCuentaContable() {
		return this.resaltarFK_IdEmpresaNivelCuentaContable;
	}

	public void setResaltarFK_IdEmpresaNivelCuentaContable(Border borderResaltar) {
		this.resaltarFK_IdEmpresaNivelCuentaContable= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaNivelCuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*NivelCuentaContableBeanSwingJInternalFrame nivelcuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaNivelCuentaContable= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}