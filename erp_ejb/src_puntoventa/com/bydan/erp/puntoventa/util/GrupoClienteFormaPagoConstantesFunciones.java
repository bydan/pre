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
package com.bydan.erp.puntoventa.util;

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


import com.bydan.erp.puntoventa.util.GrupoClienteFormaPagoConstantesFunciones;
import com.bydan.erp.puntoventa.util.GrupoClienteFormaPagoParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.GrupoClienteFormaPagoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.puntoventa.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.facturacion.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.puntoventa.business.dataaccess.*;
//import com.bydan.erp.puntoventa.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class GrupoClienteFormaPagoConstantesFunciones extends GrupoClienteFormaPagoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="GrupoClienteFormaPago";
	public static final String SPATHOPCION="PuntoVenta";	
	public static final String SPATHMODULO="puntoventa/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="GrupoClienteFormaPago"+GrupoClienteFormaPagoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="GrupoClienteFormaPagoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="GrupoClienteFormaPagoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=GrupoClienteFormaPagoConstantesFunciones.SCHEMA+"_"+GrupoClienteFormaPagoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/GrupoClienteFormaPagoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=GrupoClienteFormaPagoConstantesFunciones.SCHEMA+"_"+GrupoClienteFormaPagoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=GrupoClienteFormaPagoConstantesFunciones.SCHEMA+"_"+GrupoClienteFormaPagoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/GrupoClienteFormaPagoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=GrupoClienteFormaPagoConstantesFunciones.SCHEMA+"_"+GrupoClienteFormaPagoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+GrupoClienteFormaPagoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/GrupoClienteFormaPagoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+GrupoClienteFormaPagoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+GrupoClienteFormaPagoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/GrupoClienteFormaPagoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+GrupoClienteFormaPagoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=GrupoClienteFormaPagoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+GrupoClienteFormaPagoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=GrupoClienteFormaPagoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+GrupoClienteFormaPagoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Grupo Cliente Forma Pagos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Grupo Cliente Forma Pago";
	public static final String SCLASSWEBTITULO_LOWER="Grupo Cliente Forma Pago";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="GrupoClienteFormaPago";
	public static final String OBJECTNAME="grupoclienteformapago";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PUNTOVENTA;	
	public static final String TABLENAME="grupo_cliente_forma_pago";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select grupoclienteformapago from "+GrupoClienteFormaPagoConstantesFunciones.SPERSISTENCENAME+" grupoclienteformapago";
	public static String QUERYSELECTNATIVE="select "+GrupoClienteFormaPagoConstantesFunciones.SCHEMA+"."+GrupoClienteFormaPagoConstantesFunciones.TABLENAME+".id,"+GrupoClienteFormaPagoConstantesFunciones.SCHEMA+"."+GrupoClienteFormaPagoConstantesFunciones.TABLENAME+".version_row,"+GrupoClienteFormaPagoConstantesFunciones.SCHEMA+"."+GrupoClienteFormaPagoConstantesFunciones.TABLENAME+".id_empresa,"+GrupoClienteFormaPagoConstantesFunciones.SCHEMA+"."+GrupoClienteFormaPagoConstantesFunciones.TABLENAME+".id_grupo_cliente,"+GrupoClienteFormaPagoConstantesFunciones.SCHEMA+"."+GrupoClienteFormaPagoConstantesFunciones.TABLENAME+".id_tipo_forma_pago from "+GrupoClienteFormaPagoConstantesFunciones.SCHEMA+"."+GrupoClienteFormaPagoConstantesFunciones.TABLENAME;//+" as "+GrupoClienteFormaPagoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected GrupoClienteFormaPagoConstantesFuncionesAdditional grupoclienteformapagoConstantesFuncionesAdditional=null;
	
	public GrupoClienteFormaPagoConstantesFuncionesAdditional getGrupoClienteFormaPagoConstantesFuncionesAdditional() {
		return this.grupoclienteformapagoConstantesFuncionesAdditional;
	}
	
	public void setGrupoClienteFormaPagoConstantesFuncionesAdditional(GrupoClienteFormaPagoConstantesFuncionesAdditional grupoclienteformapagoConstantesFuncionesAdditional) {
		try {
			this.grupoclienteformapagoConstantesFuncionesAdditional=grupoclienteformapagoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDGRUPOCLIENTE= "id_grupo_cliente";
    public static final String IDTIPOFORMAPAGO= "id_tipo_forma_pago";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDGRUPOCLIENTE= "Grupo Cliente";
		public static final String LABEL_IDGRUPOCLIENTE_LOWER= "Grupo Cliente";
    	public static final String LABEL_IDTIPOFORMAPAGO= "T. Forma Pago";
		public static final String LABEL_IDTIPOFORMAPAGO_LOWER= "Tipo Forma Pago";
	
		
		
		
		
		
	
	public static String getGrupoClienteFormaPagoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(GrupoClienteFormaPagoConstantesFunciones.IDEMPRESA)) {sLabelColumna=GrupoClienteFormaPagoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(GrupoClienteFormaPagoConstantesFunciones.IDGRUPOCLIENTE)) {sLabelColumna=GrupoClienteFormaPagoConstantesFunciones.LABEL_IDGRUPOCLIENTE;}
		if(sNombreColumna.equals(GrupoClienteFormaPagoConstantesFunciones.IDTIPOFORMAPAGO)) {sLabelColumna=GrupoClienteFormaPagoConstantesFunciones.LABEL_IDTIPOFORMAPAGO;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getGrupoClienteFormaPagoDescripcion(GrupoClienteFormaPago grupoclienteformapago) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(grupoclienteformapago !=null/* && grupoclienteformapago.getId()!=0*/) {
			if(grupoclienteformapago.getId()!=null) {
				sDescripcion=grupoclienteformapago.getId().toString();
			}//grupoclienteformapagogrupoclienteformapago.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getGrupoClienteFormaPagoDescripcionDetallado(GrupoClienteFormaPago grupoclienteformapago) {
		String sDescripcion="";
			
		sDescripcion+=GrupoClienteFormaPagoConstantesFunciones.ID+"=";
		sDescripcion+=grupoclienteformapago.getId().toString()+",";
		sDescripcion+=GrupoClienteFormaPagoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=grupoclienteformapago.getVersionRow().toString()+",";
		sDescripcion+=GrupoClienteFormaPagoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=grupoclienteformapago.getid_empresa().toString()+",";
		sDescripcion+=GrupoClienteFormaPagoConstantesFunciones.IDGRUPOCLIENTE+"=";
		sDescripcion+=grupoclienteformapago.getid_grupo_cliente().toString()+",";
		sDescripcion+=GrupoClienteFormaPagoConstantesFunciones.IDTIPOFORMAPAGO+"=";
		sDescripcion+=grupoclienteformapago.getid_tipo_forma_pago().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setGrupoClienteFormaPagoDescripcion(GrupoClienteFormaPago grupoclienteformapago,String sValor) throws Exception {			
		if(grupoclienteformapago !=null) {
			//grupoclienteformapagogrupoclienteformapago.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getGrupoClienteDescripcion(GrupoCliente grupocliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(grupocliente!=null/*&&grupocliente.getId()>0*/) {
			sDescripcion=GrupoClienteConstantesFunciones.getGrupoClienteDescripcion(grupocliente);
		}

		return sDescripcion;
	}

	public static String getTipoFormaPagoDescripcion(TipoFormaPago tipoformapago) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoformapago!=null/*&&tipoformapago.getId()>0*/) {
			sDescripcion=TipoFormaPagoConstantesFunciones.getTipoFormaPagoDescripcion(tipoformapago);
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
		} else if(sNombreIndice.equals("FK_IdGrupoCliente")) {
			sNombreIndice="Tipo=  Por Grupo Cliente";
		} else if(sNombreIndice.equals("FK_IdTipoFormaPago")) {
			sNombreIndice="Tipo=  Por T. Forma Pago";
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

	public static String getDetalleIndiceFK_IdGrupoCliente(Long id_grupo_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_grupo_cliente!=null) {sDetalleIndice+=" Codigo Unico De Grupo Cliente="+id_grupo_cliente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoFormaPago(Long id_tipo_forma_pago) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_forma_pago!=null) {sDetalleIndice+=" Codigo Unico De T. Forma Pago="+id_tipo_forma_pago.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosGrupoClienteFormaPago(GrupoClienteFormaPago grupoclienteformapago,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosGrupoClienteFormaPagos(List<GrupoClienteFormaPago> grupoclienteformapagos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(GrupoClienteFormaPago grupoclienteformapago: grupoclienteformapagos) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresGrupoClienteFormaPago(GrupoClienteFormaPago grupoclienteformapago,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && grupoclienteformapago.getConCambioAuxiliar()) {
			grupoclienteformapago.setIsDeleted(grupoclienteformapago.getIsDeletedAuxiliar());	
			grupoclienteformapago.setIsNew(grupoclienteformapago.getIsNewAuxiliar());	
			grupoclienteformapago.setIsChanged(grupoclienteformapago.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			grupoclienteformapago.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			grupoclienteformapago.setIsDeletedAuxiliar(false);	
			grupoclienteformapago.setIsNewAuxiliar(false);	
			grupoclienteformapago.setIsChangedAuxiliar(false);
			
			grupoclienteformapago.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresGrupoClienteFormaPagos(List<GrupoClienteFormaPago> grupoclienteformapagos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(GrupoClienteFormaPago grupoclienteformapago : grupoclienteformapagos) {
			if(conAsignarBase && grupoclienteformapago.getConCambioAuxiliar()) {
				grupoclienteformapago.setIsDeleted(grupoclienteformapago.getIsDeletedAuxiliar());	
				grupoclienteformapago.setIsNew(grupoclienteformapago.getIsNewAuxiliar());	
				grupoclienteformapago.setIsChanged(grupoclienteformapago.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				grupoclienteformapago.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				grupoclienteformapago.setIsDeletedAuxiliar(false);	
				grupoclienteformapago.setIsNewAuxiliar(false);	
				grupoclienteformapago.setIsChangedAuxiliar(false);
				
				grupoclienteformapago.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresGrupoClienteFormaPago(GrupoClienteFormaPago grupoclienteformapago,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresGrupoClienteFormaPagos(List<GrupoClienteFormaPago> grupoclienteformapagos,Boolean conEnteros) throws Exception  {
		
		for(GrupoClienteFormaPago grupoclienteformapago: grupoclienteformapagos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaGrupoClienteFormaPago(List<GrupoClienteFormaPago> grupoclienteformapagos,GrupoClienteFormaPago grupoclienteformapagoAux) throws Exception  {
		GrupoClienteFormaPagoConstantesFunciones.InicializarValoresGrupoClienteFormaPago(grupoclienteformapagoAux,true);
		
		for(GrupoClienteFormaPago grupoclienteformapago: grupoclienteformapagos) {
			if(grupoclienteformapago.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesGrupoClienteFormaPago(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=GrupoClienteFormaPagoConstantesFunciones.getArrayColumnasGlobalesGrupoClienteFormaPago(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesGrupoClienteFormaPago(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(GrupoClienteFormaPagoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(GrupoClienteFormaPagoConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoGrupoClienteFormaPago(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<GrupoClienteFormaPago> grupoclienteformapagos,GrupoClienteFormaPago grupoclienteformapago,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(GrupoClienteFormaPago grupoclienteformapagoAux: grupoclienteformapagos) {
			if(grupoclienteformapagoAux!=null && grupoclienteformapago!=null) {
				if((grupoclienteformapagoAux.getId()==null && grupoclienteformapago.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(grupoclienteformapagoAux.getId()!=null && grupoclienteformapago.getId()!=null){
					if(grupoclienteformapagoAux.getId().equals(grupoclienteformapago.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaGrupoClienteFormaPago(List<GrupoClienteFormaPago> grupoclienteformapagos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(GrupoClienteFormaPago grupoclienteformapago: grupoclienteformapagos) {			
			if(grupoclienteformapago.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaGrupoClienteFormaPago() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,GrupoClienteFormaPagoConstantesFunciones.LABEL_ID, GrupoClienteFormaPagoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GrupoClienteFormaPagoConstantesFunciones.LABEL_VERSIONROW, GrupoClienteFormaPagoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GrupoClienteFormaPagoConstantesFunciones.LABEL_IDEMPRESA, GrupoClienteFormaPagoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GrupoClienteFormaPagoConstantesFunciones.LABEL_IDGRUPOCLIENTE, GrupoClienteFormaPagoConstantesFunciones.IDGRUPOCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GrupoClienteFormaPagoConstantesFunciones.LABEL_IDTIPOFORMAPAGO, GrupoClienteFormaPagoConstantesFunciones.IDTIPOFORMAPAGO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasGrupoClienteFormaPago() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=GrupoClienteFormaPagoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GrupoClienteFormaPagoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GrupoClienteFormaPagoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GrupoClienteFormaPagoConstantesFunciones.IDGRUPOCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GrupoClienteFormaPagoConstantesFunciones.IDTIPOFORMAPAGO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarGrupoClienteFormaPago() throws Exception  {
		return GrupoClienteFormaPagoConstantesFunciones.getTiposSeleccionarGrupoClienteFormaPago(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarGrupoClienteFormaPago(Boolean conFk) throws Exception  {
		return GrupoClienteFormaPagoConstantesFunciones.getTiposSeleccionarGrupoClienteFormaPago(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarGrupoClienteFormaPago(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(GrupoClienteFormaPagoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(GrupoClienteFormaPagoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(GrupoClienteFormaPagoConstantesFunciones.LABEL_IDGRUPOCLIENTE);
			reporte.setsDescripcion(GrupoClienteFormaPagoConstantesFunciones.LABEL_IDGRUPOCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(GrupoClienteFormaPagoConstantesFunciones.LABEL_IDTIPOFORMAPAGO);
			reporte.setsDescripcion(GrupoClienteFormaPagoConstantesFunciones.LABEL_IDTIPOFORMAPAGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesGrupoClienteFormaPago(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesGrupoClienteFormaPago(GrupoClienteFormaPago grupoclienteformapagoAux) throws Exception {
		
			grupoclienteformapagoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(grupoclienteformapagoAux.getEmpresa()));
			grupoclienteformapagoAux.setgrupocliente_descripcion(GrupoClienteConstantesFunciones.getGrupoClienteDescripcion(grupoclienteformapagoAux.getGrupoCliente()));
			grupoclienteformapagoAux.settipoformapago_descripcion(TipoFormaPagoConstantesFunciones.getTipoFormaPagoDescripcion(grupoclienteformapagoAux.getTipoFormaPago()));		
	}
	
	public static void refrescarForeignKeysDescripcionesGrupoClienteFormaPago(List<GrupoClienteFormaPago> grupoclienteformapagosTemp) throws Exception {
		for(GrupoClienteFormaPago grupoclienteformapagoAux:grupoclienteformapagosTemp) {
			
			grupoclienteformapagoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(grupoclienteformapagoAux.getEmpresa()));
			grupoclienteformapagoAux.setgrupocliente_descripcion(GrupoClienteConstantesFunciones.getGrupoClienteDescripcion(grupoclienteformapagoAux.getGrupoCliente()));
			grupoclienteformapagoAux.settipoformapago_descripcion(TipoFormaPagoConstantesFunciones.getTipoFormaPagoDescripcion(grupoclienteformapagoAux.getTipoFormaPago()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfGrupoClienteFormaPago(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(GrupoCliente.class));
				classes.add(new Classe(TipoFormaPago.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(GrupoCliente.class)) {
						classes.add(new Classe(GrupoCliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoFormaPago.class)) {
						classes.add(new Classe(TipoFormaPago.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfGrupoClienteFormaPago(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(GrupoCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(GrupoCliente.class)); continue;
					}

					if(TipoFormaPago.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoFormaPago.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(GrupoCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(GrupoCliente.class)); continue;
					}

					if(TipoFormaPago.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoFormaPago.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfGrupoClienteFormaPago(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return GrupoClienteFormaPagoConstantesFunciones.getClassesRelationshipsOfGrupoClienteFormaPago(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfGrupoClienteFormaPago(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfGrupoClienteFormaPago(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return GrupoClienteFormaPagoConstantesFunciones.getClassesRelationshipsFromStringsOfGrupoClienteFormaPago(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfGrupoClienteFormaPago(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(GrupoClienteFormaPago grupoclienteformapago,List<GrupoClienteFormaPago> grupoclienteformapagos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			GrupoClienteFormaPago grupoclienteformapagoEncontrado=null;
			
			for(GrupoClienteFormaPago grupoclienteformapagoLocal:grupoclienteformapagos) {
				if(grupoclienteformapagoLocal.getId().equals(grupoclienteformapago.getId())) {
					grupoclienteformapagoEncontrado=grupoclienteformapagoLocal;
					
					grupoclienteformapagoLocal.setIsChanged(grupoclienteformapago.getIsChanged());
					grupoclienteformapagoLocal.setIsNew(grupoclienteformapago.getIsNew());
					grupoclienteformapagoLocal.setIsDeleted(grupoclienteformapago.getIsDeleted());
					
					grupoclienteformapagoLocal.setGeneralEntityOriginal(grupoclienteformapago.getGeneralEntityOriginal());
					
					grupoclienteformapagoLocal.setId(grupoclienteformapago.getId());	
					grupoclienteformapagoLocal.setVersionRow(grupoclienteformapago.getVersionRow());	
					grupoclienteformapagoLocal.setid_empresa(grupoclienteformapago.getid_empresa());	
					grupoclienteformapagoLocal.setid_grupo_cliente(grupoclienteformapago.getid_grupo_cliente());	
					grupoclienteformapagoLocal.setid_tipo_forma_pago(grupoclienteformapago.getid_tipo_forma_pago());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!grupoclienteformapago.getIsDeleted()) {
				if(!existe) {
					grupoclienteformapagos.add(grupoclienteformapago);
				}
			} else {
				if(grupoclienteformapagoEncontrado!=null && permiteQuitar)  {
					grupoclienteformapagos.remove(grupoclienteformapagoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(GrupoClienteFormaPago grupoclienteformapago,List<GrupoClienteFormaPago> grupoclienteformapagos) throws Exception {
		try	{			
			for(GrupoClienteFormaPago grupoclienteformapagoLocal:grupoclienteformapagos) {
				if(grupoclienteformapagoLocal.getId().equals(grupoclienteformapago.getId())) {
					grupoclienteformapagoLocal.setIsSelected(grupoclienteformapago.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesGrupoClienteFormaPago(List<GrupoClienteFormaPago> grupoclienteformapagosAux) throws Exception {
		//this.grupoclienteformapagosAux=grupoclienteformapagosAux;
		
		for(GrupoClienteFormaPago grupoclienteformapagoAux:grupoclienteformapagosAux) {
			if(grupoclienteformapagoAux.getIsChanged()) {
				grupoclienteformapagoAux.setIsChanged(false);
			}		
			
			if(grupoclienteformapagoAux.getIsNew()) {
				grupoclienteformapagoAux.setIsNew(false);
			}	
			
			if(grupoclienteformapagoAux.getIsDeleted()) {
				grupoclienteformapagoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesGrupoClienteFormaPago(GrupoClienteFormaPago grupoclienteformapagoAux) throws Exception {
		//this.grupoclienteformapagoAux=grupoclienteformapagoAux;
		
			if(grupoclienteformapagoAux.getIsChanged()) {
				grupoclienteformapagoAux.setIsChanged(false);
			}		
			
			if(grupoclienteformapagoAux.getIsNew()) {
				grupoclienteformapagoAux.setIsNew(false);
			}	
			
			if(grupoclienteformapagoAux.getIsDeleted()) {
				grupoclienteformapagoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(GrupoClienteFormaPago grupoclienteformapagoAsignar,GrupoClienteFormaPago grupoclienteformapago) throws Exception {
		grupoclienteformapagoAsignar.setId(grupoclienteformapago.getId());	
		grupoclienteformapagoAsignar.setVersionRow(grupoclienteformapago.getVersionRow());	
		grupoclienteformapagoAsignar.setid_empresa(grupoclienteformapago.getid_empresa());
		grupoclienteformapagoAsignar.setempresa_descripcion(grupoclienteformapago.getempresa_descripcion());	
		grupoclienteformapagoAsignar.setid_grupo_cliente(grupoclienteformapago.getid_grupo_cliente());
		grupoclienteformapagoAsignar.setgrupocliente_descripcion(grupoclienteformapago.getgrupocliente_descripcion());	
		grupoclienteformapagoAsignar.setid_tipo_forma_pago(grupoclienteformapago.getid_tipo_forma_pago());
		grupoclienteformapagoAsignar.settipoformapago_descripcion(grupoclienteformapago.gettipoformapago_descripcion());	
	}
	
	public static void inicializarGrupoClienteFormaPago(GrupoClienteFormaPago grupoclienteformapago) throws Exception {
		try {
				grupoclienteformapago.setId(0L);	
					
				grupoclienteformapago.setid_empresa(-1L);	
				grupoclienteformapago.setid_grupo_cliente(-1L);	
				grupoclienteformapago.setid_tipo_forma_pago(-1L);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderGrupoClienteFormaPago(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(GrupoClienteFormaPagoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GrupoClienteFormaPagoConstantesFunciones.LABEL_IDGRUPOCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GrupoClienteFormaPagoConstantesFunciones.LABEL_IDTIPOFORMAPAGO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataGrupoClienteFormaPago(String sTipo,Row row,Workbook workbook,GrupoClienteFormaPago grupoclienteformapago,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(grupoclienteformapago.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(grupoclienteformapago.getgrupocliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(grupoclienteformapago.gettipoformapago_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryGrupoClienteFormaPago=Constantes.SFINALQUERY;
	
	public String getsFinalQueryGrupoClienteFormaPago() {
		return this.sFinalQueryGrupoClienteFormaPago;
	}
	
	public void setsFinalQueryGrupoClienteFormaPago(String sFinalQueryGrupoClienteFormaPago) {
		this.sFinalQueryGrupoClienteFormaPago= sFinalQueryGrupoClienteFormaPago;
	}
	
	public Border resaltarSeleccionarGrupoClienteFormaPago=null;
	
	public Border setResaltarSeleccionarGrupoClienteFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoClienteFormaPagoBeanSwingJInternalFrame grupoclienteformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//grupoclienteformapagoBeanSwingJInternalFrame.jTtoolBarGrupoClienteFormaPago.setBorder(borderResaltar);
		
		this.resaltarSeleccionarGrupoClienteFormaPago= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarGrupoClienteFormaPago() {
		return this.resaltarSeleccionarGrupoClienteFormaPago;
	}
	
	public void setResaltarSeleccionarGrupoClienteFormaPago(Border borderResaltarSeleccionarGrupoClienteFormaPago) {
		this.resaltarSeleccionarGrupoClienteFormaPago= borderResaltarSeleccionarGrupoClienteFormaPago;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridGrupoClienteFormaPago=null;
	public Boolean mostraridGrupoClienteFormaPago=true;
	public Boolean activaridGrupoClienteFormaPago=true;

	public Border resaltarid_empresaGrupoClienteFormaPago=null;
	public Boolean mostrarid_empresaGrupoClienteFormaPago=true;
	public Boolean activarid_empresaGrupoClienteFormaPago=true;
	public Boolean cargarid_empresaGrupoClienteFormaPago=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaGrupoClienteFormaPago=false;//ConEventDepend=true

	public Border resaltarid_grupo_clienteGrupoClienteFormaPago=null;
	public Boolean mostrarid_grupo_clienteGrupoClienteFormaPago=true;
	public Boolean activarid_grupo_clienteGrupoClienteFormaPago=true;
	public Boolean cargarid_grupo_clienteGrupoClienteFormaPago=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_grupo_clienteGrupoClienteFormaPago=false;//ConEventDepend=true

	public Border resaltarid_tipo_forma_pagoGrupoClienteFormaPago=null;
	public Boolean mostrarid_tipo_forma_pagoGrupoClienteFormaPago=true;
	public Boolean activarid_tipo_forma_pagoGrupoClienteFormaPago=true;
	public Boolean cargarid_tipo_forma_pagoGrupoClienteFormaPago=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_forma_pagoGrupoClienteFormaPago=false;//ConEventDepend=true

	
	

	public Border setResaltaridGrupoClienteFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoClienteFormaPagoBeanSwingJInternalFrame grupoclienteformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//grupoclienteformapagoBeanSwingJInternalFrame.jTtoolBarGrupoClienteFormaPago.setBorder(borderResaltar);
		
		this.resaltaridGrupoClienteFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridGrupoClienteFormaPago() {
		return this.resaltaridGrupoClienteFormaPago;
	}

	public void setResaltaridGrupoClienteFormaPago(Border borderResaltar) {
		this.resaltaridGrupoClienteFormaPago= borderResaltar;
	}

	public Boolean getMostraridGrupoClienteFormaPago() {
		return this.mostraridGrupoClienteFormaPago;
	}

	public void setMostraridGrupoClienteFormaPago(Boolean mostraridGrupoClienteFormaPago) {
		this.mostraridGrupoClienteFormaPago= mostraridGrupoClienteFormaPago;
	}

	public Boolean getActivaridGrupoClienteFormaPago() {
		return this.activaridGrupoClienteFormaPago;
	}

	public void setActivaridGrupoClienteFormaPago(Boolean activaridGrupoClienteFormaPago) {
		this.activaridGrupoClienteFormaPago= activaridGrupoClienteFormaPago;
	}

	public Border setResaltarid_empresaGrupoClienteFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoClienteFormaPagoBeanSwingJInternalFrame grupoclienteformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//grupoclienteformapagoBeanSwingJInternalFrame.jTtoolBarGrupoClienteFormaPago.setBorder(borderResaltar);
		
		this.resaltarid_empresaGrupoClienteFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaGrupoClienteFormaPago() {
		return this.resaltarid_empresaGrupoClienteFormaPago;
	}

	public void setResaltarid_empresaGrupoClienteFormaPago(Border borderResaltar) {
		this.resaltarid_empresaGrupoClienteFormaPago= borderResaltar;
	}

	public Boolean getMostrarid_empresaGrupoClienteFormaPago() {
		return this.mostrarid_empresaGrupoClienteFormaPago;
	}

	public void setMostrarid_empresaGrupoClienteFormaPago(Boolean mostrarid_empresaGrupoClienteFormaPago) {
		this.mostrarid_empresaGrupoClienteFormaPago= mostrarid_empresaGrupoClienteFormaPago;
	}

	public Boolean getActivarid_empresaGrupoClienteFormaPago() {
		return this.activarid_empresaGrupoClienteFormaPago;
	}

	public void setActivarid_empresaGrupoClienteFormaPago(Boolean activarid_empresaGrupoClienteFormaPago) {
		this.activarid_empresaGrupoClienteFormaPago= activarid_empresaGrupoClienteFormaPago;
	}

	public Boolean getCargarid_empresaGrupoClienteFormaPago() {
		return this.cargarid_empresaGrupoClienteFormaPago;
	}

	public void setCargarid_empresaGrupoClienteFormaPago(Boolean cargarid_empresaGrupoClienteFormaPago) {
		this.cargarid_empresaGrupoClienteFormaPago= cargarid_empresaGrupoClienteFormaPago;
	}

	public Border setResaltarid_grupo_clienteGrupoClienteFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoClienteFormaPagoBeanSwingJInternalFrame grupoclienteformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//grupoclienteformapagoBeanSwingJInternalFrame.jTtoolBarGrupoClienteFormaPago.setBorder(borderResaltar);
		
		this.resaltarid_grupo_clienteGrupoClienteFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_grupo_clienteGrupoClienteFormaPago() {
		return this.resaltarid_grupo_clienteGrupoClienteFormaPago;
	}

	public void setResaltarid_grupo_clienteGrupoClienteFormaPago(Border borderResaltar) {
		this.resaltarid_grupo_clienteGrupoClienteFormaPago= borderResaltar;
	}

	public Boolean getMostrarid_grupo_clienteGrupoClienteFormaPago() {
		return this.mostrarid_grupo_clienteGrupoClienteFormaPago;
	}

	public void setMostrarid_grupo_clienteGrupoClienteFormaPago(Boolean mostrarid_grupo_clienteGrupoClienteFormaPago) {
		this.mostrarid_grupo_clienteGrupoClienteFormaPago= mostrarid_grupo_clienteGrupoClienteFormaPago;
	}

	public Boolean getActivarid_grupo_clienteGrupoClienteFormaPago() {
		return this.activarid_grupo_clienteGrupoClienteFormaPago;
	}

	public void setActivarid_grupo_clienteGrupoClienteFormaPago(Boolean activarid_grupo_clienteGrupoClienteFormaPago) {
		this.activarid_grupo_clienteGrupoClienteFormaPago= activarid_grupo_clienteGrupoClienteFormaPago;
	}

	public Boolean getCargarid_grupo_clienteGrupoClienteFormaPago() {
		return this.cargarid_grupo_clienteGrupoClienteFormaPago;
	}

	public void setCargarid_grupo_clienteGrupoClienteFormaPago(Boolean cargarid_grupo_clienteGrupoClienteFormaPago) {
		this.cargarid_grupo_clienteGrupoClienteFormaPago= cargarid_grupo_clienteGrupoClienteFormaPago;
	}

	public Border setResaltarid_tipo_forma_pagoGrupoClienteFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoClienteFormaPagoBeanSwingJInternalFrame grupoclienteformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//grupoclienteformapagoBeanSwingJInternalFrame.jTtoolBarGrupoClienteFormaPago.setBorder(borderResaltar);
		
		this.resaltarid_tipo_forma_pagoGrupoClienteFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_forma_pagoGrupoClienteFormaPago() {
		return this.resaltarid_tipo_forma_pagoGrupoClienteFormaPago;
	}

	public void setResaltarid_tipo_forma_pagoGrupoClienteFormaPago(Border borderResaltar) {
		this.resaltarid_tipo_forma_pagoGrupoClienteFormaPago= borderResaltar;
	}

	public Boolean getMostrarid_tipo_forma_pagoGrupoClienteFormaPago() {
		return this.mostrarid_tipo_forma_pagoGrupoClienteFormaPago;
	}

	public void setMostrarid_tipo_forma_pagoGrupoClienteFormaPago(Boolean mostrarid_tipo_forma_pagoGrupoClienteFormaPago) {
		this.mostrarid_tipo_forma_pagoGrupoClienteFormaPago= mostrarid_tipo_forma_pagoGrupoClienteFormaPago;
	}

	public Boolean getActivarid_tipo_forma_pagoGrupoClienteFormaPago() {
		return this.activarid_tipo_forma_pagoGrupoClienteFormaPago;
	}

	public void setActivarid_tipo_forma_pagoGrupoClienteFormaPago(Boolean activarid_tipo_forma_pagoGrupoClienteFormaPago) {
		this.activarid_tipo_forma_pagoGrupoClienteFormaPago= activarid_tipo_forma_pagoGrupoClienteFormaPago;
	}

	public Boolean getCargarid_tipo_forma_pagoGrupoClienteFormaPago() {
		return this.cargarid_tipo_forma_pagoGrupoClienteFormaPago;
	}

	public void setCargarid_tipo_forma_pagoGrupoClienteFormaPago(Boolean cargarid_tipo_forma_pagoGrupoClienteFormaPago) {
		this.cargarid_tipo_forma_pagoGrupoClienteFormaPago= cargarid_tipo_forma_pagoGrupoClienteFormaPago;
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
		
		
		this.setMostraridGrupoClienteFormaPago(esInicial);
		this.setMostrarid_empresaGrupoClienteFormaPago(esInicial);
		this.setMostrarid_grupo_clienteGrupoClienteFormaPago(esInicial);
		this.setMostrarid_tipo_forma_pagoGrupoClienteFormaPago(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(GrupoClienteFormaPagoConstantesFunciones.ID)) {
				this.setMostraridGrupoClienteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoClienteFormaPagoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaGrupoClienteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoClienteFormaPagoConstantesFunciones.IDGRUPOCLIENTE)) {
				this.setMostrarid_grupo_clienteGrupoClienteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoClienteFormaPagoConstantesFunciones.IDTIPOFORMAPAGO)) {
				this.setMostrarid_tipo_forma_pagoGrupoClienteFormaPago(esAsigna);
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
		
		
		this.setActivaridGrupoClienteFormaPago(esInicial);
		this.setActivarid_empresaGrupoClienteFormaPago(esInicial);
		this.setActivarid_grupo_clienteGrupoClienteFormaPago(esInicial);
		this.setActivarid_tipo_forma_pagoGrupoClienteFormaPago(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(GrupoClienteFormaPagoConstantesFunciones.ID)) {
				this.setActivaridGrupoClienteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoClienteFormaPagoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaGrupoClienteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoClienteFormaPagoConstantesFunciones.IDGRUPOCLIENTE)) {
				this.setActivarid_grupo_clienteGrupoClienteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoClienteFormaPagoConstantesFunciones.IDTIPOFORMAPAGO)) {
				this.setActivarid_tipo_forma_pagoGrupoClienteFormaPago(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,GrupoClienteFormaPagoBeanSwingJInternalFrame grupoclienteformapagoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridGrupoClienteFormaPago(esInicial);
		this.setResaltarid_empresaGrupoClienteFormaPago(esInicial);
		this.setResaltarid_grupo_clienteGrupoClienteFormaPago(esInicial);
		this.setResaltarid_tipo_forma_pagoGrupoClienteFormaPago(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(GrupoClienteFormaPagoConstantesFunciones.ID)) {
				this.setResaltaridGrupoClienteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoClienteFormaPagoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaGrupoClienteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoClienteFormaPagoConstantesFunciones.IDGRUPOCLIENTE)) {
				this.setResaltarid_grupo_clienteGrupoClienteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoClienteFormaPagoConstantesFunciones.IDTIPOFORMAPAGO)) {
				this.setResaltarid_tipo_forma_pagoGrupoClienteFormaPago(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,GrupoClienteFormaPagoBeanSwingJInternalFrame grupoclienteformapagoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpresaGrupoClienteFormaPago=true;

	public Boolean getMostrarFK_IdEmpresaGrupoClienteFormaPago() {
		return this.mostrarFK_IdEmpresaGrupoClienteFormaPago;
	}

	public void setMostrarFK_IdEmpresaGrupoClienteFormaPago(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaGrupoClienteFormaPago= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdGrupoClienteGrupoClienteFormaPago=true;

	public Boolean getMostrarFK_IdGrupoClienteGrupoClienteFormaPago() {
		return this.mostrarFK_IdGrupoClienteGrupoClienteFormaPago;
	}

	public void setMostrarFK_IdGrupoClienteGrupoClienteFormaPago(Boolean visibilidadResaltar) {
		this.mostrarFK_IdGrupoClienteGrupoClienteFormaPago= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoFormaPagoGrupoClienteFormaPago=true;

	public Boolean getMostrarFK_IdTipoFormaPagoGrupoClienteFormaPago() {
		return this.mostrarFK_IdTipoFormaPagoGrupoClienteFormaPago;
	}

	public void setMostrarFK_IdTipoFormaPagoGrupoClienteFormaPago(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoFormaPagoGrupoClienteFormaPago= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaGrupoClienteFormaPago=true;

	public Boolean getActivarFK_IdEmpresaGrupoClienteFormaPago() {
		return this.activarFK_IdEmpresaGrupoClienteFormaPago;
	}

	public void setActivarFK_IdEmpresaGrupoClienteFormaPago(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaGrupoClienteFormaPago= habilitarResaltar;
	}

	public Boolean activarFK_IdGrupoClienteGrupoClienteFormaPago=true;

	public Boolean getActivarFK_IdGrupoClienteGrupoClienteFormaPago() {
		return this.activarFK_IdGrupoClienteGrupoClienteFormaPago;
	}

	public void setActivarFK_IdGrupoClienteGrupoClienteFormaPago(Boolean habilitarResaltar) {
		this.activarFK_IdGrupoClienteGrupoClienteFormaPago= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoFormaPagoGrupoClienteFormaPago=true;

	public Boolean getActivarFK_IdTipoFormaPagoGrupoClienteFormaPago() {
		return this.activarFK_IdTipoFormaPagoGrupoClienteFormaPago;
	}

	public void setActivarFK_IdTipoFormaPagoGrupoClienteFormaPago(Boolean habilitarResaltar) {
		this.activarFK_IdTipoFormaPagoGrupoClienteFormaPago= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaGrupoClienteFormaPago=null;

	public Border getResaltarFK_IdEmpresaGrupoClienteFormaPago() {
		return this.resaltarFK_IdEmpresaGrupoClienteFormaPago;
	}

	public void setResaltarFK_IdEmpresaGrupoClienteFormaPago(Border borderResaltar) {
		this.resaltarFK_IdEmpresaGrupoClienteFormaPago= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaGrupoClienteFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoClienteFormaPagoBeanSwingJInternalFrame grupoclienteformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaGrupoClienteFormaPago= borderResaltar;
	}

	public Border resaltarFK_IdGrupoClienteGrupoClienteFormaPago=null;

	public Border getResaltarFK_IdGrupoClienteGrupoClienteFormaPago() {
		return this.resaltarFK_IdGrupoClienteGrupoClienteFormaPago;
	}

	public void setResaltarFK_IdGrupoClienteGrupoClienteFormaPago(Border borderResaltar) {
		this.resaltarFK_IdGrupoClienteGrupoClienteFormaPago= borderResaltar;
	}

	public void setResaltarFK_IdGrupoClienteGrupoClienteFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoClienteFormaPagoBeanSwingJInternalFrame grupoclienteformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdGrupoClienteGrupoClienteFormaPago= borderResaltar;
	}

	public Border resaltarFK_IdTipoFormaPagoGrupoClienteFormaPago=null;

	public Border getResaltarFK_IdTipoFormaPagoGrupoClienteFormaPago() {
		return this.resaltarFK_IdTipoFormaPagoGrupoClienteFormaPago;
	}

	public void setResaltarFK_IdTipoFormaPagoGrupoClienteFormaPago(Border borderResaltar) {
		this.resaltarFK_IdTipoFormaPagoGrupoClienteFormaPago= borderResaltar;
	}

	public void setResaltarFK_IdTipoFormaPagoGrupoClienteFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoClienteFormaPagoBeanSwingJInternalFrame grupoclienteformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoFormaPagoGrupoClienteFormaPago= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}