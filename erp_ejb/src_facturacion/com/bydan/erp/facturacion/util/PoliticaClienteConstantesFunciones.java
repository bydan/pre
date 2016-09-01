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


import com.bydan.erp.facturacion.util.PoliticaClienteConstantesFunciones;
import com.bydan.erp.facturacion.util.PoliticaClienteParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.PoliticaClienteParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class PoliticaClienteConstantesFunciones extends PoliticaClienteConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="PoliticaCliente";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="PoliticaCliente"+PoliticaClienteConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="PoliticaClienteHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="PoliticaClienteHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=PoliticaClienteConstantesFunciones.SCHEMA+"_"+PoliticaClienteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/PoliticaClienteHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=PoliticaClienteConstantesFunciones.SCHEMA+"_"+PoliticaClienteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=PoliticaClienteConstantesFunciones.SCHEMA+"_"+PoliticaClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/PoliticaClienteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=PoliticaClienteConstantesFunciones.SCHEMA+"_"+PoliticaClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PoliticaClienteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PoliticaClienteHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PoliticaClienteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PoliticaClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PoliticaClienteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PoliticaClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=PoliticaClienteConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+PoliticaClienteConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=PoliticaClienteConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+PoliticaClienteConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Politica Clientes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Politica Cliente";
	public static final String SCLASSWEBTITULO_LOWER="Politica Cliente";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="PoliticaCliente";
	public static final String OBJECTNAME="politicacliente";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="politica_cliente";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select politicacliente from "+PoliticaClienteConstantesFunciones.SPERSISTENCENAME+" politicacliente";
	public static String QUERYSELECTNATIVE="select "+PoliticaClienteConstantesFunciones.SCHEMA+"."+PoliticaClienteConstantesFunciones.TABLENAME+".id,"+PoliticaClienteConstantesFunciones.SCHEMA+"."+PoliticaClienteConstantesFunciones.TABLENAME+".version_row,"+PoliticaClienteConstantesFunciones.SCHEMA+"."+PoliticaClienteConstantesFunciones.TABLENAME+".id_empresa,"+PoliticaClienteConstantesFunciones.SCHEMA+"."+PoliticaClienteConstantesFunciones.TABLENAME+".id_sucursal,"+PoliticaClienteConstantesFunciones.SCHEMA+"."+PoliticaClienteConstantesFunciones.TABLENAME+".id_cliente from "+PoliticaClienteConstantesFunciones.SCHEMA+"."+PoliticaClienteConstantesFunciones.TABLENAME;//+" as "+PoliticaClienteConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected PoliticaClienteConstantesFuncionesAdditional politicaclienteConstantesFuncionesAdditional=null;
	
	public PoliticaClienteConstantesFuncionesAdditional getPoliticaClienteConstantesFuncionesAdditional() {
		return this.politicaclienteConstantesFuncionesAdditional;
	}
	
	public void setPoliticaClienteConstantesFuncionesAdditional(PoliticaClienteConstantesFuncionesAdditional politicaclienteConstantesFuncionesAdditional) {
		try {
			this.politicaclienteConstantesFuncionesAdditional=politicaclienteConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDCLIENTE= "id_cliente";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
	
		
		
		
		
		
	
	public static String getPoliticaClienteLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(PoliticaClienteConstantesFunciones.IDEMPRESA)) {sLabelColumna=PoliticaClienteConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(PoliticaClienteConstantesFunciones.IDSUCURSAL)) {sLabelColumna=PoliticaClienteConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(PoliticaClienteConstantesFunciones.IDCLIENTE)) {sLabelColumna=PoliticaClienteConstantesFunciones.LABEL_IDCLIENTE;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getPoliticaClienteDescripcion(PoliticaCliente politicacliente) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(politicacliente !=null/* && politicacliente.getId()!=0*/) {
			if(politicacliente.getId()!=null) {
				sDescripcion=politicacliente.getId().toString();
			}//politicaclientepoliticacliente.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getPoliticaClienteDescripcionDetallado(PoliticaCliente politicacliente) {
		String sDescripcion="";
			
		sDescripcion+=PoliticaClienteConstantesFunciones.ID+"=";
		sDescripcion+=politicacliente.getId().toString()+",";
		sDescripcion+=PoliticaClienteConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=politicacliente.getVersionRow().toString()+",";
		sDescripcion+=PoliticaClienteConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=politicacliente.getid_empresa().toString()+",";
		sDescripcion+=PoliticaClienteConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=politicacliente.getid_sucursal().toString()+",";
		sDescripcion+=PoliticaClienteConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=politicacliente.getid_cliente().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setPoliticaClienteDescripcion(PoliticaCliente politicacliente,String sValor) throws Exception {			
		if(politicacliente !=null) {
			//politicaclientepoliticacliente.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getSucursalDescripcion(Sucursal sucursal) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(sucursal!=null/*&&sucursal.getId()>0*/) {
			sDescripcion=SucursalConstantesFunciones.getSucursalDescripcion(sucursal);
		}

		return sDescripcion;
	}

	public static String getClienteDescripcion(Cliente cliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cliente!=null/*&&cliente.getId()>0*/) {
			sDescripcion=ClienteConstantesFunciones.getClienteDescripcion(cliente);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Cliente";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdCliente(Long id_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_cliente!=null) {sDetalleIndice+=" Codigo Unico De Cliente="+id_cliente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosPoliticaCliente(PoliticaCliente politicacliente,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosPoliticaClientes(List<PoliticaCliente> politicaclientes,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(PoliticaCliente politicacliente: politicaclientes) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPoliticaCliente(PoliticaCliente politicacliente,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && politicacliente.getConCambioAuxiliar()) {
			politicacliente.setIsDeleted(politicacliente.getIsDeletedAuxiliar());	
			politicacliente.setIsNew(politicacliente.getIsNewAuxiliar());	
			politicacliente.setIsChanged(politicacliente.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			politicacliente.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			politicacliente.setIsDeletedAuxiliar(false);	
			politicacliente.setIsNewAuxiliar(false);	
			politicacliente.setIsChangedAuxiliar(false);
			
			politicacliente.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPoliticaClientes(List<PoliticaCliente> politicaclientes,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(PoliticaCliente politicacliente : politicaclientes) {
			if(conAsignarBase && politicacliente.getConCambioAuxiliar()) {
				politicacliente.setIsDeleted(politicacliente.getIsDeletedAuxiliar());	
				politicacliente.setIsNew(politicacliente.getIsNewAuxiliar());	
				politicacliente.setIsChanged(politicacliente.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				politicacliente.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				politicacliente.setIsDeletedAuxiliar(false);	
				politicacliente.setIsNewAuxiliar(false);	
				politicacliente.setIsChangedAuxiliar(false);
				
				politicacliente.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresPoliticaCliente(PoliticaCliente politicacliente,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresPoliticaClientes(List<PoliticaCliente> politicaclientes,Boolean conEnteros) throws Exception  {
		
		for(PoliticaCliente politicacliente: politicaclientes) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaPoliticaCliente(List<PoliticaCliente> politicaclientes,PoliticaCliente politicaclienteAux) throws Exception  {
		PoliticaClienteConstantesFunciones.InicializarValoresPoliticaCliente(politicaclienteAux,true);
		
		for(PoliticaCliente politicacliente: politicaclientes) {
			if(politicacliente.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesPoliticaCliente(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=PoliticaClienteConstantesFunciones.getArrayColumnasGlobalesPoliticaCliente(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesPoliticaCliente(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PoliticaClienteConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PoliticaClienteConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PoliticaClienteConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PoliticaClienteConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoPoliticaCliente(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<PoliticaCliente> politicaclientes,PoliticaCliente politicacliente,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(PoliticaCliente politicaclienteAux: politicaclientes) {
			if(politicaclienteAux!=null && politicacliente!=null) {
				if((politicaclienteAux.getId()==null && politicacliente.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(politicaclienteAux.getId()!=null && politicacliente.getId()!=null){
					if(politicaclienteAux.getId().equals(politicacliente.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaPoliticaCliente(List<PoliticaCliente> politicaclientes) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(PoliticaCliente politicacliente: politicaclientes) {			
			if(politicacliente.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaPoliticaCliente() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,PoliticaClienteConstantesFunciones.LABEL_ID, PoliticaClienteConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PoliticaClienteConstantesFunciones.LABEL_VERSIONROW, PoliticaClienteConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PoliticaClienteConstantesFunciones.LABEL_IDEMPRESA, PoliticaClienteConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PoliticaClienteConstantesFunciones.LABEL_IDSUCURSAL, PoliticaClienteConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PoliticaClienteConstantesFunciones.LABEL_IDCLIENTE, PoliticaClienteConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasPoliticaCliente() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=PoliticaClienteConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PoliticaClienteConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PoliticaClienteConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PoliticaClienteConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PoliticaClienteConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPoliticaCliente() throws Exception  {
		return PoliticaClienteConstantesFunciones.getTiposSeleccionarPoliticaCliente(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPoliticaCliente(Boolean conFk) throws Exception  {
		return PoliticaClienteConstantesFunciones.getTiposSeleccionarPoliticaCliente(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPoliticaCliente(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PoliticaClienteConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(PoliticaClienteConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PoliticaClienteConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(PoliticaClienteConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PoliticaClienteConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(PoliticaClienteConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesPoliticaCliente(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesPoliticaCliente(PoliticaCliente politicaclienteAux) throws Exception {
		
			politicaclienteAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(politicaclienteAux.getEmpresa()));
			politicaclienteAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(politicaclienteAux.getSucursal()));
			politicaclienteAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(politicaclienteAux.getCliente()));		
	}
	
	public static void refrescarForeignKeysDescripcionesPoliticaCliente(List<PoliticaCliente> politicaclientesTemp) throws Exception {
		for(PoliticaCliente politicaclienteAux:politicaclientesTemp) {
			
			politicaclienteAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(politicaclienteAux.getEmpresa()));
			politicaclienteAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(politicaclienteAux.getSucursal()));
			politicaclienteAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(politicaclienteAux.getCliente()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfPoliticaCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Cliente.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Sucursal.class)) {
						classes.add(new Classe(Sucursal.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfPoliticaCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfPoliticaCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return PoliticaClienteConstantesFunciones.getClassesRelationshipsOfPoliticaCliente(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPoliticaCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPoliticaCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return PoliticaClienteConstantesFunciones.getClassesRelationshipsFromStringsOfPoliticaCliente(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPoliticaCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(PoliticaCliente politicacliente,List<PoliticaCliente> politicaclientes,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			PoliticaCliente politicaclienteEncontrado=null;
			
			for(PoliticaCliente politicaclienteLocal:politicaclientes) {
				if(politicaclienteLocal.getId().equals(politicacliente.getId())) {
					politicaclienteEncontrado=politicaclienteLocal;
					
					politicaclienteLocal.setIsChanged(politicacliente.getIsChanged());
					politicaclienteLocal.setIsNew(politicacliente.getIsNew());
					politicaclienteLocal.setIsDeleted(politicacliente.getIsDeleted());
					
					politicaclienteLocal.setGeneralEntityOriginal(politicacliente.getGeneralEntityOriginal());
					
					politicaclienteLocal.setId(politicacliente.getId());	
					politicaclienteLocal.setVersionRow(politicacliente.getVersionRow());	
					politicaclienteLocal.setid_empresa(politicacliente.getid_empresa());	
					politicaclienteLocal.setid_sucursal(politicacliente.getid_sucursal());	
					politicaclienteLocal.setid_cliente(politicacliente.getid_cliente());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!politicacliente.getIsDeleted()) {
				if(!existe) {
					politicaclientes.add(politicacliente);
				}
			} else {
				if(politicaclienteEncontrado!=null && permiteQuitar)  {
					politicaclientes.remove(politicaclienteEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(PoliticaCliente politicacliente,List<PoliticaCliente> politicaclientes) throws Exception {
		try	{			
			for(PoliticaCliente politicaclienteLocal:politicaclientes) {
				if(politicaclienteLocal.getId().equals(politicacliente.getId())) {
					politicaclienteLocal.setIsSelected(politicacliente.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesPoliticaCliente(List<PoliticaCliente> politicaclientesAux) throws Exception {
		//this.politicaclientesAux=politicaclientesAux;
		
		for(PoliticaCliente politicaclienteAux:politicaclientesAux) {
			if(politicaclienteAux.getIsChanged()) {
				politicaclienteAux.setIsChanged(false);
			}		
			
			if(politicaclienteAux.getIsNew()) {
				politicaclienteAux.setIsNew(false);
			}	
			
			if(politicaclienteAux.getIsDeleted()) {
				politicaclienteAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesPoliticaCliente(PoliticaCliente politicaclienteAux) throws Exception {
		//this.politicaclienteAux=politicaclienteAux;
		
			if(politicaclienteAux.getIsChanged()) {
				politicaclienteAux.setIsChanged(false);
			}		
			
			if(politicaclienteAux.getIsNew()) {
				politicaclienteAux.setIsNew(false);
			}	
			
			if(politicaclienteAux.getIsDeleted()) {
				politicaclienteAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(PoliticaCliente politicaclienteAsignar,PoliticaCliente politicacliente) throws Exception {
		politicaclienteAsignar.setId(politicacliente.getId());	
		politicaclienteAsignar.setVersionRow(politicacliente.getVersionRow());	
		politicaclienteAsignar.setid_empresa(politicacliente.getid_empresa());
		politicaclienteAsignar.setempresa_descripcion(politicacliente.getempresa_descripcion());	
		politicaclienteAsignar.setid_sucursal(politicacliente.getid_sucursal());
		politicaclienteAsignar.setsucursal_descripcion(politicacliente.getsucursal_descripcion());	
		politicaclienteAsignar.setid_cliente(politicacliente.getid_cliente());
		politicaclienteAsignar.setcliente_descripcion(politicacliente.getcliente_descripcion());	
	}
	
	public static void inicializarPoliticaCliente(PoliticaCliente politicacliente) throws Exception {
		try {
				politicacliente.setId(0L);	
					
				politicacliente.setid_empresa(-1L);	
				politicacliente.setid_sucursal(-1L);	
				politicacliente.setid_cliente(-1L);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderPoliticaCliente(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(PoliticaClienteConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PoliticaClienteConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PoliticaClienteConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataPoliticaCliente(String sTipo,Row row,Workbook workbook,PoliticaCliente politicacliente,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(politicacliente.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(politicacliente.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(politicacliente.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryPoliticaCliente=Constantes.SFINALQUERY;
	
	public String getsFinalQueryPoliticaCliente() {
		return this.sFinalQueryPoliticaCliente;
	}
	
	public void setsFinalQueryPoliticaCliente(String sFinalQueryPoliticaCliente) {
		this.sFinalQueryPoliticaCliente= sFinalQueryPoliticaCliente;
	}
	
	public Border resaltarSeleccionarPoliticaCliente=null;
	
	public Border setResaltarSeleccionarPoliticaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*PoliticaClienteBeanSwingJInternalFrame politicaclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//politicaclienteBeanSwingJInternalFrame.jTtoolBarPoliticaCliente.setBorder(borderResaltar);
		
		this.resaltarSeleccionarPoliticaCliente= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarPoliticaCliente() {
		return this.resaltarSeleccionarPoliticaCliente;
	}
	
	public void setResaltarSeleccionarPoliticaCliente(Border borderResaltarSeleccionarPoliticaCliente) {
		this.resaltarSeleccionarPoliticaCliente= borderResaltarSeleccionarPoliticaCliente;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridPoliticaCliente=null;
	public Boolean mostraridPoliticaCliente=true;
	public Boolean activaridPoliticaCliente=true;

	public Border resaltarid_empresaPoliticaCliente=null;
	public Boolean mostrarid_empresaPoliticaCliente=true;
	public Boolean activarid_empresaPoliticaCliente=true;
	public Boolean cargarid_empresaPoliticaCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaPoliticaCliente=false;//ConEventDepend=true

	public Border resaltarid_sucursalPoliticaCliente=null;
	public Boolean mostrarid_sucursalPoliticaCliente=true;
	public Boolean activarid_sucursalPoliticaCliente=true;
	public Boolean cargarid_sucursalPoliticaCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalPoliticaCliente=false;//ConEventDepend=true

	public Border resaltarid_clientePoliticaCliente=null;
	public Boolean mostrarid_clientePoliticaCliente=true;
	public Boolean activarid_clientePoliticaCliente=true;
	public Boolean cargarid_clientePoliticaCliente=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clientePoliticaCliente=false;//ConEventDepend=true

	
	

	public Border setResaltaridPoliticaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*PoliticaClienteBeanSwingJInternalFrame politicaclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//politicaclienteBeanSwingJInternalFrame.jTtoolBarPoliticaCliente.setBorder(borderResaltar);
		
		this.resaltaridPoliticaCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridPoliticaCliente() {
		return this.resaltaridPoliticaCliente;
	}

	public void setResaltaridPoliticaCliente(Border borderResaltar) {
		this.resaltaridPoliticaCliente= borderResaltar;
	}

	public Boolean getMostraridPoliticaCliente() {
		return this.mostraridPoliticaCliente;
	}

	public void setMostraridPoliticaCliente(Boolean mostraridPoliticaCliente) {
		this.mostraridPoliticaCliente= mostraridPoliticaCliente;
	}

	public Boolean getActivaridPoliticaCliente() {
		return this.activaridPoliticaCliente;
	}

	public void setActivaridPoliticaCliente(Boolean activaridPoliticaCliente) {
		this.activaridPoliticaCliente= activaridPoliticaCliente;
	}

	public Border setResaltarid_empresaPoliticaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*PoliticaClienteBeanSwingJInternalFrame politicaclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//politicaclienteBeanSwingJInternalFrame.jTtoolBarPoliticaCliente.setBorder(borderResaltar);
		
		this.resaltarid_empresaPoliticaCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaPoliticaCliente() {
		return this.resaltarid_empresaPoliticaCliente;
	}

	public void setResaltarid_empresaPoliticaCliente(Border borderResaltar) {
		this.resaltarid_empresaPoliticaCliente= borderResaltar;
	}

	public Boolean getMostrarid_empresaPoliticaCliente() {
		return this.mostrarid_empresaPoliticaCliente;
	}

	public void setMostrarid_empresaPoliticaCliente(Boolean mostrarid_empresaPoliticaCliente) {
		this.mostrarid_empresaPoliticaCliente= mostrarid_empresaPoliticaCliente;
	}

	public Boolean getActivarid_empresaPoliticaCliente() {
		return this.activarid_empresaPoliticaCliente;
	}

	public void setActivarid_empresaPoliticaCliente(Boolean activarid_empresaPoliticaCliente) {
		this.activarid_empresaPoliticaCliente= activarid_empresaPoliticaCliente;
	}

	public Boolean getCargarid_empresaPoliticaCliente() {
		return this.cargarid_empresaPoliticaCliente;
	}

	public void setCargarid_empresaPoliticaCliente(Boolean cargarid_empresaPoliticaCliente) {
		this.cargarid_empresaPoliticaCliente= cargarid_empresaPoliticaCliente;
	}

	public Border setResaltarid_sucursalPoliticaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*PoliticaClienteBeanSwingJInternalFrame politicaclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//politicaclienteBeanSwingJInternalFrame.jTtoolBarPoliticaCliente.setBorder(borderResaltar);
		
		this.resaltarid_sucursalPoliticaCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalPoliticaCliente() {
		return this.resaltarid_sucursalPoliticaCliente;
	}

	public void setResaltarid_sucursalPoliticaCliente(Border borderResaltar) {
		this.resaltarid_sucursalPoliticaCliente= borderResaltar;
	}

	public Boolean getMostrarid_sucursalPoliticaCliente() {
		return this.mostrarid_sucursalPoliticaCliente;
	}

	public void setMostrarid_sucursalPoliticaCliente(Boolean mostrarid_sucursalPoliticaCliente) {
		this.mostrarid_sucursalPoliticaCliente= mostrarid_sucursalPoliticaCliente;
	}

	public Boolean getActivarid_sucursalPoliticaCliente() {
		return this.activarid_sucursalPoliticaCliente;
	}

	public void setActivarid_sucursalPoliticaCliente(Boolean activarid_sucursalPoliticaCliente) {
		this.activarid_sucursalPoliticaCliente= activarid_sucursalPoliticaCliente;
	}

	public Boolean getCargarid_sucursalPoliticaCliente() {
		return this.cargarid_sucursalPoliticaCliente;
	}

	public void setCargarid_sucursalPoliticaCliente(Boolean cargarid_sucursalPoliticaCliente) {
		this.cargarid_sucursalPoliticaCliente= cargarid_sucursalPoliticaCliente;
	}

	public Border setResaltarid_clientePoliticaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*PoliticaClienteBeanSwingJInternalFrame politicaclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//politicaclienteBeanSwingJInternalFrame.jTtoolBarPoliticaCliente.setBorder(borderResaltar);
		
		this.resaltarid_clientePoliticaCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clientePoliticaCliente() {
		return this.resaltarid_clientePoliticaCliente;
	}

	public void setResaltarid_clientePoliticaCliente(Border borderResaltar) {
		this.resaltarid_clientePoliticaCliente= borderResaltar;
	}

	public Boolean getMostrarid_clientePoliticaCliente() {
		return this.mostrarid_clientePoliticaCliente;
	}

	public void setMostrarid_clientePoliticaCliente(Boolean mostrarid_clientePoliticaCliente) {
		this.mostrarid_clientePoliticaCliente= mostrarid_clientePoliticaCliente;
	}

	public Boolean getActivarid_clientePoliticaCliente() {
		return this.activarid_clientePoliticaCliente;
	}

	public void setActivarid_clientePoliticaCliente(Boolean activarid_clientePoliticaCliente) {
		this.activarid_clientePoliticaCliente= activarid_clientePoliticaCliente;
	}

	public Boolean getCargarid_clientePoliticaCliente() {
		return this.cargarid_clientePoliticaCliente;
	}

	public void setCargarid_clientePoliticaCliente(Boolean cargarid_clientePoliticaCliente) {
		this.cargarid_clientePoliticaCliente= cargarid_clientePoliticaCliente;
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
		
		
		this.setMostraridPoliticaCliente(esInicial);
		this.setMostrarid_empresaPoliticaCliente(esInicial);
		this.setMostrarid_sucursalPoliticaCliente(esInicial);
		this.setMostrarid_clientePoliticaCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PoliticaClienteConstantesFunciones.ID)) {
				this.setMostraridPoliticaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticaClienteConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaPoliticaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticaClienteConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalPoliticaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticaClienteConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clientePoliticaCliente(esAsigna);
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
		
		
		this.setActivaridPoliticaCliente(esInicial);
		this.setActivarid_empresaPoliticaCliente(esInicial);
		this.setActivarid_sucursalPoliticaCliente(esInicial);
		this.setActivarid_clientePoliticaCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PoliticaClienteConstantesFunciones.ID)) {
				this.setActivaridPoliticaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticaClienteConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaPoliticaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticaClienteConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalPoliticaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticaClienteConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clientePoliticaCliente(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,PoliticaClienteBeanSwingJInternalFrame politicaclienteBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridPoliticaCliente(esInicial);
		this.setResaltarid_empresaPoliticaCliente(esInicial);
		this.setResaltarid_sucursalPoliticaCliente(esInicial);
		this.setResaltarid_clientePoliticaCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PoliticaClienteConstantesFunciones.ID)) {
				this.setResaltaridPoliticaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticaClienteConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaPoliticaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticaClienteConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalPoliticaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticaClienteConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clientePoliticaCliente(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,PoliticaClienteBeanSwingJInternalFrame politicaclienteBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdClientePoliticaCliente=true;

	public Boolean getMostrarFK_IdClientePoliticaCliente() {
		return this.mostrarFK_IdClientePoliticaCliente;
	}

	public void setMostrarFK_IdClientePoliticaCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClientePoliticaCliente= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaPoliticaCliente=true;

	public Boolean getMostrarFK_IdEmpresaPoliticaCliente() {
		return this.mostrarFK_IdEmpresaPoliticaCliente;
	}

	public void setMostrarFK_IdEmpresaPoliticaCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaPoliticaCliente= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalPoliticaCliente=true;

	public Boolean getMostrarFK_IdSucursalPoliticaCliente() {
		return this.mostrarFK_IdSucursalPoliticaCliente;
	}

	public void setMostrarFK_IdSucursalPoliticaCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalPoliticaCliente= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdClientePoliticaCliente=true;

	public Boolean getActivarFK_IdClientePoliticaCliente() {
		return this.activarFK_IdClientePoliticaCliente;
	}

	public void setActivarFK_IdClientePoliticaCliente(Boolean habilitarResaltar) {
		this.activarFK_IdClientePoliticaCliente= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaPoliticaCliente=true;

	public Boolean getActivarFK_IdEmpresaPoliticaCliente() {
		return this.activarFK_IdEmpresaPoliticaCliente;
	}

	public void setActivarFK_IdEmpresaPoliticaCliente(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaPoliticaCliente= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalPoliticaCliente=true;

	public Boolean getActivarFK_IdSucursalPoliticaCliente() {
		return this.activarFK_IdSucursalPoliticaCliente;
	}

	public void setActivarFK_IdSucursalPoliticaCliente(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalPoliticaCliente= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdClientePoliticaCliente=null;

	public Border getResaltarFK_IdClientePoliticaCliente() {
		return this.resaltarFK_IdClientePoliticaCliente;
	}

	public void setResaltarFK_IdClientePoliticaCliente(Border borderResaltar) {
		this.resaltarFK_IdClientePoliticaCliente= borderResaltar;
	}

	public void setResaltarFK_IdClientePoliticaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*PoliticaClienteBeanSwingJInternalFrame politicaclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClientePoliticaCliente= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaPoliticaCliente=null;

	public Border getResaltarFK_IdEmpresaPoliticaCliente() {
		return this.resaltarFK_IdEmpresaPoliticaCliente;
	}

	public void setResaltarFK_IdEmpresaPoliticaCliente(Border borderResaltar) {
		this.resaltarFK_IdEmpresaPoliticaCliente= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaPoliticaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*PoliticaClienteBeanSwingJInternalFrame politicaclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaPoliticaCliente= borderResaltar;
	}

	public Border resaltarFK_IdSucursalPoliticaCliente=null;

	public Border getResaltarFK_IdSucursalPoliticaCliente() {
		return this.resaltarFK_IdSucursalPoliticaCliente;
	}

	public void setResaltarFK_IdSucursalPoliticaCliente(Border borderResaltar) {
		this.resaltarFK_IdSucursalPoliticaCliente= borderResaltar;
	}

	public void setResaltarFK_IdSucursalPoliticaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*PoliticaClienteBeanSwingJInternalFrame politicaclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalPoliticaCliente= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}