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


import com.bydan.erp.cartera.util.MontoConstantesFunciones;
import com.bydan.erp.cartera.util.MontoParameterReturnGeneral;
//import com.bydan.erp.cartera.util.MontoParameterGeneral;

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
final public class MontoConstantesFunciones extends MontoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Monto";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Monto"+MontoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="MontoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="MontoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=MontoConstantesFunciones.SCHEMA+"_"+MontoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/MontoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=MontoConstantesFunciones.SCHEMA+"_"+MontoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=MontoConstantesFunciones.SCHEMA+"_"+MontoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/MontoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=MontoConstantesFunciones.SCHEMA+"_"+MontoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+MontoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/MontoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+MontoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+MontoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/MontoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+MontoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=MontoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+MontoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=MontoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+MontoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Monto De Facturacions";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Monto De Facturacion";
	public static final String SCLASSWEBTITULO_LOWER="Monto";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Monto";
	public static final String OBJECTNAME="monto";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="monto";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select monto from "+MontoConstantesFunciones.SPERSISTENCENAME+" monto";
	public static String QUERYSELECTNATIVE="select "+MontoConstantesFunciones.SCHEMA+"."+MontoConstantesFunciones.TABLENAME+".id,"+MontoConstantesFunciones.SCHEMA+"."+MontoConstantesFunciones.TABLENAME+".version_row,"+MontoConstantesFunciones.SCHEMA+"."+MontoConstantesFunciones.TABLENAME+".id_empresa,"+MontoConstantesFunciones.SCHEMA+"."+MontoConstantesFunciones.TABLENAME+".id_sucursal,"+MontoConstantesFunciones.SCHEMA+"."+MontoConstantesFunciones.TABLENAME+".id_cliente,"+MontoConstantesFunciones.SCHEMA+"."+MontoConstantesFunciones.TABLENAME+".valor_inicio,"+MontoConstantesFunciones.SCHEMA+"."+MontoConstantesFunciones.TABLENAME+".valor_fin,"+MontoConstantesFunciones.SCHEMA+"."+MontoConstantesFunciones.TABLENAME+".numero_dias,"+MontoConstantesFunciones.SCHEMA+"."+MontoConstantesFunciones.TABLENAME+".numero_cuota,"+MontoConstantesFunciones.SCHEMA+"."+MontoConstantesFunciones.TABLENAME+".es_general from "+MontoConstantesFunciones.SCHEMA+"."+MontoConstantesFunciones.TABLENAME;//+" as "+MontoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected MontoConstantesFuncionesAdditional montoConstantesFuncionesAdditional=null;
	
	public MontoConstantesFuncionesAdditional getMontoConstantesFuncionesAdditional() {
		return this.montoConstantesFuncionesAdditional;
	}
	
	public void setMontoConstantesFuncionesAdditional(MontoConstantesFuncionesAdditional montoConstantesFuncionesAdditional) {
		try {
			this.montoConstantesFuncionesAdditional=montoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDCLIENTE= "id_cliente";
    public static final String VALORINICIO= "valor_inicio";
    public static final String VALORFIN= "valor_fin";
    public static final String NUMERODIAS= "numero_dias";
    public static final String NUMEROCUOTA= "numero_cuota";
    public static final String ESGENERAL= "es_general";
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
    	public static final String LABEL_VALORINICIO= "Valor Inicio";
		public static final String LABEL_VALORINICIO_LOWER= "Valor Inicio";
    	public static final String LABEL_VALORFIN= "Valor Fin";
		public static final String LABEL_VALORFIN_LOWER= "Valor Fin";
    	public static final String LABEL_NUMERODIAS= "Numero Dias";
		public static final String LABEL_NUMERODIAS_LOWER= "Numero Dias";
    	public static final String LABEL_NUMEROCUOTA= "Numero Cuota";
		public static final String LABEL_NUMEROCUOTA_LOWER= "Numero Cuota";
    	public static final String LABEL_ESGENERAL= "Es General";
		public static final String LABEL_ESGENERAL_LOWER= "Es General";
	
		
		
		
		
		
		
		
		
		
		
	
	public static String getMontoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(MontoConstantesFunciones.IDEMPRESA)) {sLabelColumna=MontoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(MontoConstantesFunciones.IDSUCURSAL)) {sLabelColumna=MontoConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(MontoConstantesFunciones.IDCLIENTE)) {sLabelColumna=MontoConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(MontoConstantesFunciones.VALORINICIO)) {sLabelColumna=MontoConstantesFunciones.LABEL_VALORINICIO;}
		if(sNombreColumna.equals(MontoConstantesFunciones.VALORFIN)) {sLabelColumna=MontoConstantesFunciones.LABEL_VALORFIN;}
		if(sNombreColumna.equals(MontoConstantesFunciones.NUMERODIAS)) {sLabelColumna=MontoConstantesFunciones.LABEL_NUMERODIAS;}
		if(sNombreColumna.equals(MontoConstantesFunciones.NUMEROCUOTA)) {sLabelColumna=MontoConstantesFunciones.LABEL_NUMEROCUOTA;}
		if(sNombreColumna.equals(MontoConstantesFunciones.ESGENERAL)) {sLabelColumna=MontoConstantesFunciones.LABEL_ESGENERAL;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
		
	public static String getes_generalDescripcion(Monto monto) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!monto.getes_general()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_generalHtmlDescripcion(Monto monto) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(monto.getId(),monto.getes_general());

		return sDescripcion;
	}	
	
	public static String getMontoDescripcion(Monto monto) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(monto !=null/* && monto.getId()!=0*/) {
			if(monto.getId()!=null) {
				sDescripcion=monto.getId().toString();
			}//montomonto.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getMontoDescripcionDetallado(Monto monto) {
		String sDescripcion="";
			
		sDescripcion+=MontoConstantesFunciones.ID+"=";
		sDescripcion+=monto.getId().toString()+",";
		sDescripcion+=MontoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=monto.getVersionRow().toString()+",";
		sDescripcion+=MontoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=monto.getid_empresa().toString()+",";
		sDescripcion+=MontoConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=monto.getid_sucursal().toString()+",";
		sDescripcion+=MontoConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=monto.getid_cliente().toString()+",";
		sDescripcion+=MontoConstantesFunciones.VALORINICIO+"=";
		sDescripcion+=monto.getvalor_inicio().toString()+",";
		sDescripcion+=MontoConstantesFunciones.VALORFIN+"=";
		sDescripcion+=monto.getvalor_fin().toString()+",";
		sDescripcion+=MontoConstantesFunciones.NUMERODIAS+"=";
		sDescripcion+=monto.getnumero_dias().toString()+",";
		sDescripcion+=MontoConstantesFunciones.NUMEROCUOTA+"=";
		sDescripcion+=monto.getnumero_cuota().toString()+",";
		sDescripcion+=MontoConstantesFunciones.ESGENERAL+"=";
		sDescripcion+=monto.getes_general().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setMontoDescripcion(Monto monto,String sValor) throws Exception {			
		if(monto !=null) {
			//montomonto.getId().toString();
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
		} else if(sNombreIndice.equals("BusquedaPorEsGeneral")) {
			sNombreIndice="Tipo=  Por Es General";
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

	public static String getDetalleIndiceBusquedaPorEsGeneral(Boolean es_general) {
		String sDetalleIndice=" Parametros->";
		if(es_general!=null) {sDetalleIndice+=" Es General="+es_general.toString();} 

		return sDetalleIndice;
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
	
	
	
	
	
	
	public static void quitarEspaciosMonto(Monto monto,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosMontos(List<Monto> montos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Monto monto: montos) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresMonto(Monto monto,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && monto.getConCambioAuxiliar()) {
			monto.setIsDeleted(monto.getIsDeletedAuxiliar());	
			monto.setIsNew(monto.getIsNewAuxiliar());	
			monto.setIsChanged(monto.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			monto.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			monto.setIsDeletedAuxiliar(false);	
			monto.setIsNewAuxiliar(false);	
			monto.setIsChangedAuxiliar(false);
			
			monto.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresMontos(List<Monto> montos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Monto monto : montos) {
			if(conAsignarBase && monto.getConCambioAuxiliar()) {
				monto.setIsDeleted(monto.getIsDeletedAuxiliar());	
				monto.setIsNew(monto.getIsNewAuxiliar());	
				monto.setIsChanged(monto.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				monto.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				monto.setIsDeletedAuxiliar(false);	
				monto.setIsNewAuxiliar(false);	
				monto.setIsChangedAuxiliar(false);
				
				monto.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresMonto(Monto monto,Boolean conEnteros) throws Exception  {
		monto.setvalor_inicio(0.0);
		monto.setvalor_fin(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			monto.setnumero_dias(0);
			monto.setnumero_cuota(0);
		}
	}		
	
	public static void InicializarValoresMontos(List<Monto> montos,Boolean conEnteros) throws Exception  {
		
		for(Monto monto: montos) {
			monto.setvalor_inicio(0.0);
			monto.setvalor_fin(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				monto.setnumero_dias(0);
				monto.setnumero_cuota(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaMonto(List<Monto> montos,Monto montoAux) throws Exception  {
		MontoConstantesFunciones.InicializarValoresMonto(montoAux,true);
		
		for(Monto monto: montos) {
			if(monto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			montoAux.setvalor_inicio(montoAux.getvalor_inicio()+monto.getvalor_inicio());			
			montoAux.setvalor_fin(montoAux.getvalor_fin()+monto.getvalor_fin());			
			montoAux.setnumero_dias(montoAux.getnumero_dias()+monto.getnumero_dias());			
			montoAux.setnumero_cuota(montoAux.getnumero_cuota()+monto.getnumero_cuota());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesMonto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=MontoConstantesFunciones.getArrayColumnasGlobalesMonto(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesMonto(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(MontoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(MontoConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(MontoConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(MontoConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoMonto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Monto> montos,Monto monto,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Monto montoAux: montos) {
			if(montoAux!=null && monto!=null) {
				if((montoAux.getId()==null && monto.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(montoAux.getId()!=null && monto.getId()!=null){
					if(montoAux.getId().equals(monto.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaMonto(List<Monto> montos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valor_inicioTotal=0.0;
		Double valor_finTotal=0.0;
	
		for(Monto monto: montos) {			
			if(monto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valor_inicioTotal+=monto.getvalor_inicio();
			valor_finTotal+=monto.getvalor_fin();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(MontoConstantesFunciones.VALORINICIO);
		datoGeneral.setsDescripcion(MontoConstantesFunciones.LABEL_VALORINICIO);
		datoGeneral.setdValorDouble(valor_inicioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(MontoConstantesFunciones.VALORFIN);
		datoGeneral.setsDescripcion(MontoConstantesFunciones.LABEL_VALORFIN);
		datoGeneral.setdValorDouble(valor_finTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaMonto() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,MontoConstantesFunciones.LABEL_ID, MontoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MontoConstantesFunciones.LABEL_VERSIONROW, MontoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MontoConstantesFunciones.LABEL_IDEMPRESA, MontoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MontoConstantesFunciones.LABEL_IDSUCURSAL, MontoConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MontoConstantesFunciones.LABEL_IDCLIENTE, MontoConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MontoConstantesFunciones.LABEL_VALORINICIO, MontoConstantesFunciones.VALORINICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MontoConstantesFunciones.LABEL_VALORFIN, MontoConstantesFunciones.VALORFIN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MontoConstantesFunciones.LABEL_NUMERODIAS, MontoConstantesFunciones.NUMERODIAS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MontoConstantesFunciones.LABEL_NUMEROCUOTA, MontoConstantesFunciones.NUMEROCUOTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MontoConstantesFunciones.LABEL_ESGENERAL, MontoConstantesFunciones.ESGENERAL,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasMonto() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=MontoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MontoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MontoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MontoConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MontoConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MontoConstantesFunciones.VALORINICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MontoConstantesFunciones.VALORFIN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MontoConstantesFunciones.NUMERODIAS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MontoConstantesFunciones.NUMEROCUOTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MontoConstantesFunciones.ESGENERAL;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarMonto() throws Exception  {
		return MontoConstantesFunciones.getTiposSeleccionarMonto(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarMonto(Boolean conFk) throws Exception  {
		return MontoConstantesFunciones.getTiposSeleccionarMonto(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarMonto(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(MontoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(MontoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(MontoConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(MontoConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(MontoConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(MontoConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MontoConstantesFunciones.LABEL_VALORINICIO);
			reporte.setsDescripcion(MontoConstantesFunciones.LABEL_VALORINICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MontoConstantesFunciones.LABEL_VALORFIN);
			reporte.setsDescripcion(MontoConstantesFunciones.LABEL_VALORFIN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MontoConstantesFunciones.LABEL_NUMERODIAS);
			reporte.setsDescripcion(MontoConstantesFunciones.LABEL_NUMERODIAS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MontoConstantesFunciones.LABEL_NUMEROCUOTA);
			reporte.setsDescripcion(MontoConstantesFunciones.LABEL_NUMEROCUOTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MontoConstantesFunciones.LABEL_ESGENERAL);
			reporte.setsDescripcion(MontoConstantesFunciones.LABEL_ESGENERAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesMonto(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesMonto(Monto montoAux) throws Exception {
		
			montoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(montoAux.getEmpresa()));
			montoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(montoAux.getSucursal()));
			montoAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(montoAux.getCliente()));		
	}
	
	public static void refrescarForeignKeysDescripcionesMonto(List<Monto> montosTemp) throws Exception {
		for(Monto montoAux:montosTemp) {
			
			montoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(montoAux.getEmpresa()));
			montoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(montoAux.getSucursal()));
			montoAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(montoAux.getCliente()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfMonto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfMonto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfMonto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return MontoConstantesFunciones.getClassesRelationshipsOfMonto(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfMonto(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfMonto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return MontoConstantesFunciones.getClassesRelationshipsFromStringsOfMonto(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfMonto(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(Monto monto,List<Monto> montos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Monto montoEncontrado=null;
			
			for(Monto montoLocal:montos) {
				if(montoLocal.getId().equals(monto.getId())) {
					montoEncontrado=montoLocal;
					
					montoLocal.setIsChanged(monto.getIsChanged());
					montoLocal.setIsNew(monto.getIsNew());
					montoLocal.setIsDeleted(monto.getIsDeleted());
					
					montoLocal.setGeneralEntityOriginal(monto.getGeneralEntityOriginal());
					
					montoLocal.setId(monto.getId());	
					montoLocal.setVersionRow(monto.getVersionRow());	
					montoLocal.setid_empresa(monto.getid_empresa());	
					montoLocal.setid_sucursal(monto.getid_sucursal());	
					montoLocal.setid_cliente(monto.getid_cliente());	
					montoLocal.setvalor_inicio(monto.getvalor_inicio());	
					montoLocal.setvalor_fin(monto.getvalor_fin());	
					montoLocal.setnumero_dias(monto.getnumero_dias());	
					montoLocal.setnumero_cuota(monto.getnumero_cuota());	
					montoLocal.setes_general(monto.getes_general());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!monto.getIsDeleted()) {
				if(!existe) {
					montos.add(monto);
				}
			} else {
				if(montoEncontrado!=null && permiteQuitar)  {
					montos.remove(montoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Monto monto,List<Monto> montos) throws Exception {
		try	{			
			for(Monto montoLocal:montos) {
				if(montoLocal.getId().equals(monto.getId())) {
					montoLocal.setIsSelected(monto.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesMonto(List<Monto> montosAux) throws Exception {
		//this.montosAux=montosAux;
		
		for(Monto montoAux:montosAux) {
			if(montoAux.getIsChanged()) {
				montoAux.setIsChanged(false);
			}		
			
			if(montoAux.getIsNew()) {
				montoAux.setIsNew(false);
			}	
			
			if(montoAux.getIsDeleted()) {
				montoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesMonto(Monto montoAux) throws Exception {
		//this.montoAux=montoAux;
		
			if(montoAux.getIsChanged()) {
				montoAux.setIsChanged(false);
			}		
			
			if(montoAux.getIsNew()) {
				montoAux.setIsNew(false);
			}	
			
			if(montoAux.getIsDeleted()) {
				montoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Monto montoAsignar,Monto monto) throws Exception {
		montoAsignar.setId(monto.getId());	
		montoAsignar.setVersionRow(monto.getVersionRow());	
		montoAsignar.setid_empresa(monto.getid_empresa());
		montoAsignar.setempresa_descripcion(monto.getempresa_descripcion());	
		montoAsignar.setid_sucursal(monto.getid_sucursal());
		montoAsignar.setsucursal_descripcion(monto.getsucursal_descripcion());	
		montoAsignar.setid_cliente(monto.getid_cliente());
		montoAsignar.setcliente_descripcion(monto.getcliente_descripcion());	
		montoAsignar.setvalor_inicio(monto.getvalor_inicio());	
		montoAsignar.setvalor_fin(monto.getvalor_fin());	
		montoAsignar.setnumero_dias(monto.getnumero_dias());	
		montoAsignar.setnumero_cuota(monto.getnumero_cuota());	
		montoAsignar.setes_general(monto.getes_general());	
	}
	
	public static void inicializarMonto(Monto monto) throws Exception {
		try {
				monto.setId(0L);	
					
				monto.setid_empresa(-1L);	
				monto.setid_sucursal(-1L);	
				monto.setid_cliente(-1L);	
				monto.setvalor_inicio(0.0);	
				monto.setvalor_fin(0.0);	
				monto.setnumero_dias(0);	
				monto.setnumero_cuota(0);	
				monto.setes_general(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderMonto(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(MontoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MontoConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MontoConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MontoConstantesFunciones.LABEL_VALORINICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MontoConstantesFunciones.LABEL_VALORFIN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MontoConstantesFunciones.LABEL_NUMERODIAS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MontoConstantesFunciones.LABEL_NUMEROCUOTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MontoConstantesFunciones.LABEL_ESGENERAL);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataMonto(String sTipo,Row row,Workbook workbook,Monto monto,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(monto.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(monto.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(monto.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(monto.getvalor_inicio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(monto.getvalor_fin());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(monto.getnumero_dias());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(monto.getnumero_cuota());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(monto.getes_general()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryMonto=Constantes.SFINALQUERY;
	
	public String getsFinalQueryMonto() {
		return this.sFinalQueryMonto;
	}
	
	public void setsFinalQueryMonto(String sFinalQueryMonto) {
		this.sFinalQueryMonto= sFinalQueryMonto;
	}
	
	public Border resaltarSeleccionarMonto=null;
	
	public Border setResaltarSeleccionarMonto(ParametroGeneralUsuario parametroGeneralUsuario/*MontoBeanSwingJInternalFrame montoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//montoBeanSwingJInternalFrame.jTtoolBarMonto.setBorder(borderResaltar);
		
		this.resaltarSeleccionarMonto= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarMonto() {
		return this.resaltarSeleccionarMonto;
	}
	
	public void setResaltarSeleccionarMonto(Border borderResaltarSeleccionarMonto) {
		this.resaltarSeleccionarMonto= borderResaltarSeleccionarMonto;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridMonto=null;
	public Boolean mostraridMonto=true;
	public Boolean activaridMonto=true;

	public Border resaltarid_empresaMonto=null;
	public Boolean mostrarid_empresaMonto=true;
	public Boolean activarid_empresaMonto=true;
	public Boolean cargarid_empresaMonto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaMonto=false;//ConEventDepend=true

	public Border resaltarid_sucursalMonto=null;
	public Boolean mostrarid_sucursalMonto=true;
	public Boolean activarid_sucursalMonto=true;
	public Boolean cargarid_sucursalMonto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalMonto=false;//ConEventDepend=true

	public Border resaltarid_clienteMonto=null;
	public Boolean mostrarid_clienteMonto=true;
	public Boolean activarid_clienteMonto=true;
	public Boolean cargarid_clienteMonto=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteMonto=false;//ConEventDepend=true

	public Border resaltarvalor_inicioMonto=null;
	public Boolean mostrarvalor_inicioMonto=true;
	public Boolean activarvalor_inicioMonto=true;

	public Border resaltarvalor_finMonto=null;
	public Boolean mostrarvalor_finMonto=true;
	public Boolean activarvalor_finMonto=true;

	public Border resaltarnumero_diasMonto=null;
	public Boolean mostrarnumero_diasMonto=true;
	public Boolean activarnumero_diasMonto=true;

	public Border resaltarnumero_cuotaMonto=null;
	public Boolean mostrarnumero_cuotaMonto=true;
	public Boolean activarnumero_cuotaMonto=true;

	public Border resaltares_generalMonto=null;
	public Boolean mostrares_generalMonto=true;
	public Boolean activares_generalMonto=true;

	
	

	public Border setResaltaridMonto(ParametroGeneralUsuario parametroGeneralUsuario/*MontoBeanSwingJInternalFrame montoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//montoBeanSwingJInternalFrame.jTtoolBarMonto.setBorder(borderResaltar);
		
		this.resaltaridMonto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridMonto() {
		return this.resaltaridMonto;
	}

	public void setResaltaridMonto(Border borderResaltar) {
		this.resaltaridMonto= borderResaltar;
	}

	public Boolean getMostraridMonto() {
		return this.mostraridMonto;
	}

	public void setMostraridMonto(Boolean mostraridMonto) {
		this.mostraridMonto= mostraridMonto;
	}

	public Boolean getActivaridMonto() {
		return this.activaridMonto;
	}

	public void setActivaridMonto(Boolean activaridMonto) {
		this.activaridMonto= activaridMonto;
	}

	public Border setResaltarid_empresaMonto(ParametroGeneralUsuario parametroGeneralUsuario/*MontoBeanSwingJInternalFrame montoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//montoBeanSwingJInternalFrame.jTtoolBarMonto.setBorder(borderResaltar);
		
		this.resaltarid_empresaMonto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaMonto() {
		return this.resaltarid_empresaMonto;
	}

	public void setResaltarid_empresaMonto(Border borderResaltar) {
		this.resaltarid_empresaMonto= borderResaltar;
	}

	public Boolean getMostrarid_empresaMonto() {
		return this.mostrarid_empresaMonto;
	}

	public void setMostrarid_empresaMonto(Boolean mostrarid_empresaMonto) {
		this.mostrarid_empresaMonto= mostrarid_empresaMonto;
	}

	public Boolean getActivarid_empresaMonto() {
		return this.activarid_empresaMonto;
	}

	public void setActivarid_empresaMonto(Boolean activarid_empresaMonto) {
		this.activarid_empresaMonto= activarid_empresaMonto;
	}

	public Boolean getCargarid_empresaMonto() {
		return this.cargarid_empresaMonto;
	}

	public void setCargarid_empresaMonto(Boolean cargarid_empresaMonto) {
		this.cargarid_empresaMonto= cargarid_empresaMonto;
	}

	public Border setResaltarid_sucursalMonto(ParametroGeneralUsuario parametroGeneralUsuario/*MontoBeanSwingJInternalFrame montoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//montoBeanSwingJInternalFrame.jTtoolBarMonto.setBorder(borderResaltar);
		
		this.resaltarid_sucursalMonto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalMonto() {
		return this.resaltarid_sucursalMonto;
	}

	public void setResaltarid_sucursalMonto(Border borderResaltar) {
		this.resaltarid_sucursalMonto= borderResaltar;
	}

	public Boolean getMostrarid_sucursalMonto() {
		return this.mostrarid_sucursalMonto;
	}

	public void setMostrarid_sucursalMonto(Boolean mostrarid_sucursalMonto) {
		this.mostrarid_sucursalMonto= mostrarid_sucursalMonto;
	}

	public Boolean getActivarid_sucursalMonto() {
		return this.activarid_sucursalMonto;
	}

	public void setActivarid_sucursalMonto(Boolean activarid_sucursalMonto) {
		this.activarid_sucursalMonto= activarid_sucursalMonto;
	}

	public Boolean getCargarid_sucursalMonto() {
		return this.cargarid_sucursalMonto;
	}

	public void setCargarid_sucursalMonto(Boolean cargarid_sucursalMonto) {
		this.cargarid_sucursalMonto= cargarid_sucursalMonto;
	}

	public Border setResaltarid_clienteMonto(ParametroGeneralUsuario parametroGeneralUsuario/*MontoBeanSwingJInternalFrame montoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//montoBeanSwingJInternalFrame.jTtoolBarMonto.setBorder(borderResaltar);
		
		this.resaltarid_clienteMonto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteMonto() {
		return this.resaltarid_clienteMonto;
	}

	public void setResaltarid_clienteMonto(Border borderResaltar) {
		this.resaltarid_clienteMonto= borderResaltar;
	}

	public Boolean getMostrarid_clienteMonto() {
		return this.mostrarid_clienteMonto;
	}

	public void setMostrarid_clienteMonto(Boolean mostrarid_clienteMonto) {
		this.mostrarid_clienteMonto= mostrarid_clienteMonto;
	}

	public Boolean getActivarid_clienteMonto() {
		return this.activarid_clienteMonto;
	}

	public void setActivarid_clienteMonto(Boolean activarid_clienteMonto) {
		this.activarid_clienteMonto= activarid_clienteMonto;
	}

	public Boolean getCargarid_clienteMonto() {
		return this.cargarid_clienteMonto;
	}

	public void setCargarid_clienteMonto(Boolean cargarid_clienteMonto) {
		this.cargarid_clienteMonto= cargarid_clienteMonto;
	}

	public Border setResaltarvalor_inicioMonto(ParametroGeneralUsuario parametroGeneralUsuario/*MontoBeanSwingJInternalFrame montoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//montoBeanSwingJInternalFrame.jTtoolBarMonto.setBorder(borderResaltar);
		
		this.resaltarvalor_inicioMonto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_inicioMonto() {
		return this.resaltarvalor_inicioMonto;
	}

	public void setResaltarvalor_inicioMonto(Border borderResaltar) {
		this.resaltarvalor_inicioMonto= borderResaltar;
	}

	public Boolean getMostrarvalor_inicioMonto() {
		return this.mostrarvalor_inicioMonto;
	}

	public void setMostrarvalor_inicioMonto(Boolean mostrarvalor_inicioMonto) {
		this.mostrarvalor_inicioMonto= mostrarvalor_inicioMonto;
	}

	public Boolean getActivarvalor_inicioMonto() {
		return this.activarvalor_inicioMonto;
	}

	public void setActivarvalor_inicioMonto(Boolean activarvalor_inicioMonto) {
		this.activarvalor_inicioMonto= activarvalor_inicioMonto;
	}

	public Border setResaltarvalor_finMonto(ParametroGeneralUsuario parametroGeneralUsuario/*MontoBeanSwingJInternalFrame montoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//montoBeanSwingJInternalFrame.jTtoolBarMonto.setBorder(borderResaltar);
		
		this.resaltarvalor_finMonto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_finMonto() {
		return this.resaltarvalor_finMonto;
	}

	public void setResaltarvalor_finMonto(Border borderResaltar) {
		this.resaltarvalor_finMonto= borderResaltar;
	}

	public Boolean getMostrarvalor_finMonto() {
		return this.mostrarvalor_finMonto;
	}

	public void setMostrarvalor_finMonto(Boolean mostrarvalor_finMonto) {
		this.mostrarvalor_finMonto= mostrarvalor_finMonto;
	}

	public Boolean getActivarvalor_finMonto() {
		return this.activarvalor_finMonto;
	}

	public void setActivarvalor_finMonto(Boolean activarvalor_finMonto) {
		this.activarvalor_finMonto= activarvalor_finMonto;
	}

	public Border setResaltarnumero_diasMonto(ParametroGeneralUsuario parametroGeneralUsuario/*MontoBeanSwingJInternalFrame montoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//montoBeanSwingJInternalFrame.jTtoolBarMonto.setBorder(borderResaltar);
		
		this.resaltarnumero_diasMonto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_diasMonto() {
		return this.resaltarnumero_diasMonto;
	}

	public void setResaltarnumero_diasMonto(Border borderResaltar) {
		this.resaltarnumero_diasMonto= borderResaltar;
	}

	public Boolean getMostrarnumero_diasMonto() {
		return this.mostrarnumero_diasMonto;
	}

	public void setMostrarnumero_diasMonto(Boolean mostrarnumero_diasMonto) {
		this.mostrarnumero_diasMonto= mostrarnumero_diasMonto;
	}

	public Boolean getActivarnumero_diasMonto() {
		return this.activarnumero_diasMonto;
	}

	public void setActivarnumero_diasMonto(Boolean activarnumero_diasMonto) {
		this.activarnumero_diasMonto= activarnumero_diasMonto;
	}

	public Border setResaltarnumero_cuotaMonto(ParametroGeneralUsuario parametroGeneralUsuario/*MontoBeanSwingJInternalFrame montoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//montoBeanSwingJInternalFrame.jTtoolBarMonto.setBorder(borderResaltar);
		
		this.resaltarnumero_cuotaMonto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_cuotaMonto() {
		return this.resaltarnumero_cuotaMonto;
	}

	public void setResaltarnumero_cuotaMonto(Border borderResaltar) {
		this.resaltarnumero_cuotaMonto= borderResaltar;
	}

	public Boolean getMostrarnumero_cuotaMonto() {
		return this.mostrarnumero_cuotaMonto;
	}

	public void setMostrarnumero_cuotaMonto(Boolean mostrarnumero_cuotaMonto) {
		this.mostrarnumero_cuotaMonto= mostrarnumero_cuotaMonto;
	}

	public Boolean getActivarnumero_cuotaMonto() {
		return this.activarnumero_cuotaMonto;
	}

	public void setActivarnumero_cuotaMonto(Boolean activarnumero_cuotaMonto) {
		this.activarnumero_cuotaMonto= activarnumero_cuotaMonto;
	}

	public Border setResaltares_generalMonto(ParametroGeneralUsuario parametroGeneralUsuario/*MontoBeanSwingJInternalFrame montoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//montoBeanSwingJInternalFrame.jTtoolBarMonto.setBorder(borderResaltar);
		
		this.resaltares_generalMonto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_generalMonto() {
		return this.resaltares_generalMonto;
	}

	public void setResaltares_generalMonto(Border borderResaltar) {
		this.resaltares_generalMonto= borderResaltar;
	}

	public Boolean getMostrares_generalMonto() {
		return this.mostrares_generalMonto;
	}

	public void setMostrares_generalMonto(Boolean mostrares_generalMonto) {
		this.mostrares_generalMonto= mostrares_generalMonto;
	}

	public Boolean getActivares_generalMonto() {
		return this.activares_generalMonto;
	}

	public void setActivares_generalMonto(Boolean activares_generalMonto) {
		this.activares_generalMonto= activares_generalMonto;
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
		
		
		this.setMostraridMonto(esInicial);
		this.setMostrarid_empresaMonto(esInicial);
		this.setMostrarid_sucursalMonto(esInicial);
		this.setMostrarid_clienteMonto(esInicial);
		this.setMostrarvalor_inicioMonto(esInicial);
		this.setMostrarvalor_finMonto(esInicial);
		this.setMostrarnumero_diasMonto(esInicial);
		this.setMostrarnumero_cuotaMonto(esInicial);
		this.setMostrares_generalMonto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(MontoConstantesFunciones.ID)) {
				this.setMostraridMonto(esAsigna);
				continue;
			}

			if(campo.clase.equals(MontoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaMonto(esAsigna);
				continue;
			}

			if(campo.clase.equals(MontoConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalMonto(esAsigna);
				continue;
			}

			if(campo.clase.equals(MontoConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteMonto(esAsigna);
				continue;
			}

			if(campo.clase.equals(MontoConstantesFunciones.VALORINICIO)) {
				this.setMostrarvalor_inicioMonto(esAsigna);
				continue;
			}

			if(campo.clase.equals(MontoConstantesFunciones.VALORFIN)) {
				this.setMostrarvalor_finMonto(esAsigna);
				continue;
			}

			if(campo.clase.equals(MontoConstantesFunciones.NUMERODIAS)) {
				this.setMostrarnumero_diasMonto(esAsigna);
				continue;
			}

			if(campo.clase.equals(MontoConstantesFunciones.NUMEROCUOTA)) {
				this.setMostrarnumero_cuotaMonto(esAsigna);
				continue;
			}

			if(campo.clase.equals(MontoConstantesFunciones.ESGENERAL)) {
				this.setMostrares_generalMonto(esAsigna);
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
		
		
		this.setActivaridMonto(esInicial);
		this.setActivarid_empresaMonto(esInicial);
		this.setActivarid_sucursalMonto(esInicial);
		this.setActivarid_clienteMonto(esInicial);
		this.setActivarvalor_inicioMonto(esInicial);
		this.setActivarvalor_finMonto(esInicial);
		this.setActivarnumero_diasMonto(esInicial);
		this.setActivarnumero_cuotaMonto(esInicial);
		this.setActivares_generalMonto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(MontoConstantesFunciones.ID)) {
				this.setActivaridMonto(esAsigna);
				continue;
			}

			if(campo.clase.equals(MontoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaMonto(esAsigna);
				continue;
			}

			if(campo.clase.equals(MontoConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalMonto(esAsigna);
				continue;
			}

			if(campo.clase.equals(MontoConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteMonto(esAsigna);
				continue;
			}

			if(campo.clase.equals(MontoConstantesFunciones.VALORINICIO)) {
				this.setActivarvalor_inicioMonto(esAsigna);
				continue;
			}

			if(campo.clase.equals(MontoConstantesFunciones.VALORFIN)) {
				this.setActivarvalor_finMonto(esAsigna);
				continue;
			}

			if(campo.clase.equals(MontoConstantesFunciones.NUMERODIAS)) {
				this.setActivarnumero_diasMonto(esAsigna);
				continue;
			}

			if(campo.clase.equals(MontoConstantesFunciones.NUMEROCUOTA)) {
				this.setActivarnumero_cuotaMonto(esAsigna);
				continue;
			}

			if(campo.clase.equals(MontoConstantesFunciones.ESGENERAL)) {
				this.setActivares_generalMonto(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,MontoBeanSwingJInternalFrame montoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridMonto(esInicial);
		this.setResaltarid_empresaMonto(esInicial);
		this.setResaltarid_sucursalMonto(esInicial);
		this.setResaltarid_clienteMonto(esInicial);
		this.setResaltarvalor_inicioMonto(esInicial);
		this.setResaltarvalor_finMonto(esInicial);
		this.setResaltarnumero_diasMonto(esInicial);
		this.setResaltarnumero_cuotaMonto(esInicial);
		this.setResaltares_generalMonto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(MontoConstantesFunciones.ID)) {
				this.setResaltaridMonto(esAsigna);
				continue;
			}

			if(campo.clase.equals(MontoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaMonto(esAsigna);
				continue;
			}

			if(campo.clase.equals(MontoConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalMonto(esAsigna);
				continue;
			}

			if(campo.clase.equals(MontoConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteMonto(esAsigna);
				continue;
			}

			if(campo.clase.equals(MontoConstantesFunciones.VALORINICIO)) {
				this.setResaltarvalor_inicioMonto(esAsigna);
				continue;
			}

			if(campo.clase.equals(MontoConstantesFunciones.VALORFIN)) {
				this.setResaltarvalor_finMonto(esAsigna);
				continue;
			}

			if(campo.clase.equals(MontoConstantesFunciones.NUMERODIAS)) {
				this.setResaltarnumero_diasMonto(esAsigna);
				continue;
			}

			if(campo.clase.equals(MontoConstantesFunciones.NUMEROCUOTA)) {
				this.setResaltarnumero_cuotaMonto(esAsigna);
				continue;
			}

			if(campo.clase.equals(MontoConstantesFunciones.ESGENERAL)) {
				this.setResaltares_generalMonto(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,MontoBeanSwingJInternalFrame montoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPorEsGeneralMonto=true;

	public Boolean getMostrarBusquedaPorEsGeneralMonto() {
		return this.mostrarBusquedaPorEsGeneralMonto;
	}

	public void setMostrarBusquedaPorEsGeneralMonto(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorEsGeneralMonto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdClienteMonto=true;

	public Boolean getMostrarFK_IdClienteMonto() {
		return this.mostrarFK_IdClienteMonto;
	}

	public void setMostrarFK_IdClienteMonto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteMonto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaMonto=true;

	public Boolean getMostrarFK_IdEmpresaMonto() {
		return this.mostrarFK_IdEmpresaMonto;
	}

	public void setMostrarFK_IdEmpresaMonto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaMonto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalMonto=true;

	public Boolean getMostrarFK_IdSucursalMonto() {
		return this.mostrarFK_IdSucursalMonto;
	}

	public void setMostrarFK_IdSucursalMonto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalMonto= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorEsGeneralMonto=true;

	public Boolean getActivarBusquedaPorEsGeneralMonto() {
		return this.activarBusquedaPorEsGeneralMonto;
	}

	public void setActivarBusquedaPorEsGeneralMonto(Boolean habilitarResaltar) {
		this.activarBusquedaPorEsGeneralMonto= habilitarResaltar;
	}

	public Boolean activarFK_IdClienteMonto=true;

	public Boolean getActivarFK_IdClienteMonto() {
		return this.activarFK_IdClienteMonto;
	}

	public void setActivarFK_IdClienteMonto(Boolean habilitarResaltar) {
		this.activarFK_IdClienteMonto= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaMonto=true;

	public Boolean getActivarFK_IdEmpresaMonto() {
		return this.activarFK_IdEmpresaMonto;
	}

	public void setActivarFK_IdEmpresaMonto(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaMonto= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalMonto=true;

	public Boolean getActivarFK_IdSucursalMonto() {
		return this.activarFK_IdSucursalMonto;
	}

	public void setActivarFK_IdSucursalMonto(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalMonto= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorEsGeneralMonto=null;

	public Border getResaltarBusquedaPorEsGeneralMonto() {
		return this.resaltarBusquedaPorEsGeneralMonto;
	}

	public void setResaltarBusquedaPorEsGeneralMonto(Border borderResaltar) {
		this.resaltarBusquedaPorEsGeneralMonto= borderResaltar;
	}

	public void setResaltarBusquedaPorEsGeneralMonto(ParametroGeneralUsuario parametroGeneralUsuario/*MontoBeanSwingJInternalFrame montoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorEsGeneralMonto= borderResaltar;
	}

	public Border resaltarFK_IdClienteMonto=null;

	public Border getResaltarFK_IdClienteMonto() {
		return this.resaltarFK_IdClienteMonto;
	}

	public void setResaltarFK_IdClienteMonto(Border borderResaltar) {
		this.resaltarFK_IdClienteMonto= borderResaltar;
	}

	public void setResaltarFK_IdClienteMonto(ParametroGeneralUsuario parametroGeneralUsuario/*MontoBeanSwingJInternalFrame montoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteMonto= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaMonto=null;

	public Border getResaltarFK_IdEmpresaMonto() {
		return this.resaltarFK_IdEmpresaMonto;
	}

	public void setResaltarFK_IdEmpresaMonto(Border borderResaltar) {
		this.resaltarFK_IdEmpresaMonto= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaMonto(ParametroGeneralUsuario parametroGeneralUsuario/*MontoBeanSwingJInternalFrame montoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaMonto= borderResaltar;
	}

	public Border resaltarFK_IdSucursalMonto=null;

	public Border getResaltarFK_IdSucursalMonto() {
		return this.resaltarFK_IdSucursalMonto;
	}

	public void setResaltarFK_IdSucursalMonto(Border borderResaltar) {
		this.resaltarFK_IdSucursalMonto= borderResaltar;
	}

	public void setResaltarFK_IdSucursalMonto(ParametroGeneralUsuario parametroGeneralUsuario/*MontoBeanSwingJInternalFrame montoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalMonto= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}